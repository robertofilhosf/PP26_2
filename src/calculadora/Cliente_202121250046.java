package calculadora;

public class Cliente_202121250046 {
    public static void main(String[] args) {
        Calculadora_202121250046 calculadora = new Calculadora_202121250046();

        System.out.println("=== Teste das Operações Matemáticas ===");

        double num1 = 15.0;
        double num2 = 3.0;

        System.out.println("Valores de entrada: " + num1 + " e " + num2);
        System.out.println("Soma: " + calculadora.somar(num1, num2));
        System.out.println("Subtração: " + calculadora.subtrair(num1, num2));
        System.out.println("Multiplicação: " + calculadora.multiplicar(num1, num2));
        System.out.println("Divisão: " + calculadora.dividir(num1, num2));

        System.out.println("\nTeste de divisão por zero:");
        System.out.println("Divisão (10 / 0): " + calculadora.dividir(10.0, 0.0));
    }
}
