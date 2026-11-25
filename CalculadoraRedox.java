/*
*            o  o
*          o  o
 *        ______
 *       |______|
 *        |    |
 *        |    |   CALCULADORA OXIDO-REDUCCION (REDOX)
 *       /      \  Proyecto Ordinario - Quimica e Introducción a los Sistemas
 *      /  ~  ~  \ Autor: Ernesto Dario Lopez Alejandre
 *     /__________\
 */
import java.util.Scanner;

public class CalculadoraRedox {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== CALCULADORA REDOX ===");
            System.out.println("1. Analizar oxidacion o reduccion");
            System.out.println("2. Igualar electrones (MCM)");
            System.out.println("3. Calcular numero de oxidacion");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    analizarCambioElemento(sc);
                    break;
                case 2:
                    balancearSemirreacciones(sc);
                    break;
                case 3:
                    calcularEstadoOxidacion(sc);
                    break;
                case 4:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            System.out.println();
        } while (opcion != 4);

        sc.close();
    }
    // Como un elevador: si sube (+), se oxida; si baja (-), se reduce
    public static void analizarCambioElemento(Scanner sc) {
        System.out.print("Elemento (ej. Mn, Fe): ");
        String elemento = sc.nextLine();

        System.out.print("Estado inicial (reactivos): ");
        int oxInicial = sc.nextInt();

        System.out.print("Estado final (productos): ");
        int oxFinal = sc.nextInt();

        System.out.print("Cantidad de atomos: ");
        int atomos = sc.nextInt();
        sc.nextLine();

        int cambio = oxFinal - oxInicial;
        int electrones = Math.abs(cambio) * atomos;

        System.out.println("\n--- RESULTADO ---");
        System.out.println("Elemento: " + elemento + " (" + oxInicial + " -> " + oxFinal + ")");

        if (cambio > 0) {
            System.out.println("Proceso: OXIDACION (agente reductor)");
            System.out.println("Pierde " + electrones + " electrones");
        } else if (cambio < 0) {
            System.out.println("Proceso: REDUCCION (agente oxidante)");
            System.out.println("Gana " + electrones + " electrones");
        } else {
            System.out.println("Proceso: Sin cambio redox");
        }
    }

