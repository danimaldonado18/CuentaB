package com.daniela.CuentaB;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        // Scanner para leer datos ingresados por el usuario
        Scanner scanner = new Scanner(System.in);

        // DecimalFormat para mostrar los montos con 2 decimales
        DecimalFormat df = new DecimalFormat("#0.00");

        // Declaración de la cuenta (polimorfismo: puede ser Ahorros o Corriente)
        Cuenta cuenta = null;

        // Variable para controlar la salida del menú
        boolean salir = false;

        // Mensaje de bienvenida al usuario
        System.out.println("===================================");
        System.out.println("       ¡Bienvenido al Banco!       ");
        System.out.println("===================================\n");

        // Bucle para seleccionar el tipo de cuenta (solo se permite una)
        while (cuenta == null) {
            System.out.println("Seleccione el tipo de cuenta que desea crear:");
            System.out.println("1. Cuenta de Ahorros");
            System.out.println("2. Cuenta Corriente");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            // Solicitar saldo inicial y tasa de interés al usuario
            System.out.print("Ingrese el saldo inicial: ");
            float saldo = scanner.nextFloat();
            System.out.print("Ingrese la tasa de interés anual (%): ");
            float tasa = scanner.nextFloat();

            // Crear la cuenta según la opción seleccionada
            if (opcion == 1) {
                cuenta = new CuentaAhorro(saldo, tasa);
                System.out.println("\n Cuenta de Ahorros creada con éxito!\n");
            } else if (opcion == 2) {
                cuenta = new CuentaCorriente(saldo, tasa);
                System.out.println("\n Cuenta Corriente creada con éxito!\n");
            } else {
                System.out.println("\n Opción no válida. Intente de nuevo.\n");
            }
        }

        // Menú principal: se repite hasta que el usuario elija salir
        do {
            System.out.println("\n========== MENÚ PRINCIPAL ==========");
            System.out.println("1. Depositar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Mostrar información de la cuenta");
            System.out.println("4. Generar extracto mensual");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcionMenu = scanner.nextInt();

            // Procesar la opción del usuario
            switch (opcionMenu) {
                case 1 -> {
                    // Depositar dinero en la cuenta
                    System.out.print("Ingrese el monto a depositar: ");
                    float deposito = scanner.nextFloat();
                    cuenta.depositar(deposito);
                    System.out.println("💰 ¡Depósito realizado con éxito! Nuevo saldo: $" + df.format(cuenta.saldo));
                }
                case 2 -> {
                    // Retirar dinero de la cuenta
                    System.out.print("Ingrese el monto a retirar: ");
                    float retiro = scanner.nextFloat();
                    cuenta.retirar(retiro);
                    System.out.println(" Operación de retiro finalizada. Saldo actual: $" + df.format(cuenta.saldo));
                }
                case 3 -> {
                    // Mostrar información de la cuenta
                    System.out.println("\n📄 Información de la cuenta:");
                    if (cuenta instanceof CuentaAhorro) {
                        ((CuentaAhorro) cuenta).imprimir();
                    } else if (cuenta instanceof CuentaCorriente) {
                        ((CuentaCorriente) cuenta).imprimir();
                    } else {
                        System.out.println("Saldo: $" + df.format(cuenta.saldo));
                        System.out.println("Comisión Mensual: $" + df.format(cuenta.comisionMensual));
                        System.out.println("Número de movimientos: " + (cuenta.numeroDepositos + cuenta.numeroRetiro));
                    }
                }
                case 4 -> {
                    // Generar extracto mensual
                    cuenta.extractoMensual();
                    System.out.println(" Extracto mensual generado correctamente. Saldo actualizado: $" + df.format(cuenta.saldo));
                }
                case 5 -> {
                    // Salir del programa
                    System.out.println("\n Gracias por usar nuestro sistema bancario. ¡Hasta pronto!");
                    salir = true;
                }
                default -> System.out.println(" Opción no válida, intenta nuevamente.");
            }

        } while (!salir); // El menú se repite mientras salir sea false

        // Cerrar el scanner para liberar recursos
        scanner.close();
    }
}

