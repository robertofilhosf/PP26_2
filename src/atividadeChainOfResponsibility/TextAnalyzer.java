package atividadeChainOfResponsibility;

import java.util.Scanner;

// Classe abstrata base do Padrão Chain of Responsibility
abstract class CharHandler {
    private CharHandler next;

    public void setNext(CharHandler next) {
        this.next = next;
    }

    public void handle(char c) {
        if (canHandle(c)) {
            process(c);
        } else if (next != null) {
            next.handle(c); // Passa a requisição para o próximo elo
        }
    }

    protected abstract boolean canHandle(char c);
    protected abstract void process(char c);
    protected abstract void printStats();

    public void printAllStats() {
        printStats();
        if (next != null) {
            next.printAllStats();
        }
    }
}

// Elo 1: Tratador de Espaços
class SpaceHandler extends CharHandler {
    private int count = 0;
    @Override protected boolean canHandle(char c) { return c == ' '; }
    @Override protected void process(char c) { count++; }
    @Override protected void printStats() { System.out.println("a) Número de espaços: " + count); }
}

// Elo 2: Tratador de Letras 'A' (Case-insensitive)
class LetterAHandler extends CharHandler {
    private int count = 0;
    @Override protected boolean canHandle(char c) { return c == 'a' || c == 'A'; }
    @Override protected void process(char c) { count++; }
    @Override protected void printStats() { System.out.println("b) Número de letras 'a': " + count); }
}

// Elo 3: Tratador de Pontos
class DotHandler extends CharHandler {
    private int count = 0;
    @Override protected boolean canHandle(char c) { return c == '.'; }
    @Override protected void process(char c) { count++; }
    @Override protected void printStats() { System.out.println("c) Número de pontos (.): " + count); }
}

// Cliente / Main
public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.println("Cole o texto abaixo. Para finalizar e processar, dê um Enter em uma linha vazia:");

        // Lê múltiplas linhas (ideal para textos com parágrafos)
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break; // Sai do loop se a linha estiver vazia
            }
            sb.append(line).append(" ");
        }

        String textToProcess = sb.toString();

        // 1. Instanciando os elos
        CharHandler spaceHandler = new SpaceHandler();
        CharHandler letterAHandler = new LetterAHandler();
        CharHandler dotHandler = new DotHandler();

        // 2. Encadeando a corrente
        spaceHandler.setNext(letterAHandler);
        letterAHandler.setNext(dotHandler);

        // 3. Processando o texto caractere por caractere
        for (char c : textToProcess.toCharArray()) {
            spaceHandler.handle(c); // O fluxo entra sempre pelo primeiro elo
        }

        System.out.println("\n=== Estatísticas do Texto ===");
        spaceHandler.printAllStats();

        scanner.close();
    }
}