package com.daniela.CuentaB;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cuenta cuenta = null;
        boolean salir = false;

        System.out.println("===================================");
        System.out.println(" ¡Bienvenido al Sistema Bancario! ");
        System.out.println("===================================\n");

        // Selección del tipo de cuenta (solo una vez)
        while (cuenta == null) {
            System.out.println("Seleccione el tipo de cuenta :");
            System.out.println("1. Cuenta de Ahorros");
            System.out.println("2. Cuenta Corriente");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            System.out.print("Ingrese el saldo actual: ");
            float saldo = scanner.nextFloat();
            System.out.print("Ingrese la tasa de interés anual : ");
            float tasa = scanner.nextFloat();

            if (opcion == 1) {
                cuenta = new CuentaAhorro(saldo, tasa);
                System.out.println("\n Cuenta de Ahorros.\n");
            } else if (opcion == 2) {
                cuenta = new CuentaCorriente(saldo, tasa);
                System.out.println("\n Cuenta Corriente.\n");
            } else {
                System.out.println("\n Intente de nuevo.\n");
            }
        }

        // Menú principal
        do {
            System.out.println("\n========== MENÚ PRINCIPAL ==========");
            System.out.println("1. Depositar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Mostrar información de la cuenta");
            System.out.println("4. Generar extracto mensual");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcionMenu = scanner.nextInt();

            switch (opcionMenu) {
                case 1:
                    System.out.print("Ingrese el monto que desea depositar: ");
                    float deposito = scanner.nextFloat();
                    cuenta.depositar(deposito);
                    System.out.println(" Depósito realizado con éxito!");
                    break;

                case 2:
                    System.out.print("Ingrese el monto que desea retirar: ");
                    float retiro = scanner.nextFloat();
                    cuenta.retirar(retiro);
                    System.out.println(" Operación de retiro finalizada.");
                    break;

                case 3:
                    System.out.println("\n Información de la cuenta:");
                    if (cuenta instanceof CuentaAhorro) {
                        ((CuentaAhorro) cuenta).imprimir();
                    } else if (cuenta instanceof CuentaCorriente) {
                        ((CuentaCorriente) cuenta).imprimir();
                    } else {
                        System.out.println("Saldo: $" + cuenta.saldo);
                        System.out.println("Comisión Mensual: $" + cuenta.comisionMensual);
                        System.out.println("Número de movimientos: " + (cuenta.numeroDepositos + cuenta.numeroRetiro));
                    }
                    break;

                case 4:
                    cuenta.extractoMensual();
                    System.out.println(" Extracto mensual generado exitosamente.");
                    break;

                case 5:
                    System.out.println("\n Gracias por usar el sistema bancario. ¡Hasta pronto!");
                    salir = true;
                    break;

                default:
                    System.out.println(" Intenta nuevamente.");
            }

        } while (!salir);

        scanner.close();
    }
}
