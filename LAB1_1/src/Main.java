import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double num1, num2;
        ComplexNumber complexNum1, complexNum2, result;

        System.out.println("Choose operation: \n1. Addition \n2. Subtraction \n3. Multiplication");
        choice = scanner.nextInt();

        System.out.println("Enter first complex number(space): ");
        num1 = scanner.nextDouble();
        num2 = scanner.nextDouble();
        complexNum1 = new ComplexNumber(num1, num2);

        System.out.println("Enter second complex number(space): ");
        num1 = scanner.nextDouble();
        num2 = scanner.nextDouble();
        complexNum2 = new ComplexNumber(num1, num2);

        switch (choice) {
            case 1:
                result = complexNum1.add(complexNum2);
                System.out.println("Result: " + result.toString());
                break;
            case 2:
                result = complexNum1.subtract(complexNum2);
                System.out.println("Result: " + result.toString());
                break;
            case 3:
                result = complexNum1.multiply(complexNum2);
                System.out.println("Result: " + result.toString());
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
class ComplexNumber {
    double real;
    double imag;

    ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    ComplexNumber add(ComplexNumber cnumber) {
        return new ComplexNumber(this.real + cnumber.real, this.imag + cnumber.imag);
    }

    ComplexNumber subtract(ComplexNumber cnumber) {
        return new ComplexNumber(this.real - cnumber.real, this.imag - cnumber.imag);
    }

    ComplexNumber multiply(ComplexNumber cnumber) {
        double real = this.real * cnumber.real - this.imag * cnumber.imag;
        double imag = this.real * cnumber.imag + this.imag * cnumber.real;
        return new ComplexNumber(real, imag);
    }

    @Override
    public String toString() {
        return this.real + " + " + this.imag + "i";
    }
}