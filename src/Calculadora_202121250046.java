//import libAdapter.Calculadora;


public class Calculadora_202121250046 extends Calculadora_202321250008 {

    // O cliente chama somar(double, double), então criamos a assinatura e repassamos
    public double somar(double a, double b) {
        // A Calculadora de 2023 espera varargs (double... numeros)[cite: 2]
        return super.somar(a, b);
    }

    public double subtrair(double a, double b) {
        // A assinatura de 2023 já é exatamente (double a, double b)[cite: 2]
        return super.subtrair(a, b);
    }

    public double multiplicar(double a, double b) {
        // A Calculadora de 2023 espera varargs (double... fatores)[cite: 2]
        return super.multiplicar(a, b);
    }

    public double dividir(double a, double b) {
        // A assinatura de 2023 já é exatamente (double dividendo, double divisor)[cite: 2]
        return super.dividir(a, b);
    }
}