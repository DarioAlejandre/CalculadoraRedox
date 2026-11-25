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
    // Igual que buscar un numero comun donde coincidan dos paquetes distintos
    public static void balancearSemirreacciones(Scanner sc) {
        System.out.print("Especie que se oxida: ");
        String semiOx = sc.nextLine();
        System.out.print("Electrones perdidos: ");
        int eOx = sc.nextInt();
        sc.nextLine();

        System.out.print("Especie que se reduce: ");
        String semiRed = sc.nextLine();
        System.out.print("Electrones ganados: ");
        int eRed = sc.nextInt();
        sc.nextLine();

        if (eOx <= 0 || eRed <= 0) {
            System.out.println("Los electrones deben ser mayores a 0.");
            return;
        }

        int mcm = calcularMCM(eOx, eRed);
        System.out.println("\n--- BALANCE ---");
        System.out.println("Total de electrones a igualar (MCM): " + mcm);
        System.out.println("Multiplicar (" + semiOx + ") por: " + (mcm / eOx));
        System.out.println("Multiplicar (" + semiRed + ") por: " + (mcm / eRed));
    }
    // Igual que buscar un numero comun donde coincidan dos paquetes distintos
    public static void balancearSemirreacciones(Scanner sc) {
        System.out.print("Especie que se oxida: ");
        String semiOx = sc.nextLine();
        System.out.print("Electrones perdidos: ");
        int eOx = sc.nextInt();
        sc.nextLine();

        System.out.print("Especie que se reduce: ");
        String semiRed = sc.nextLine();
        System.out.print("Electrones ganados: ");
        int eRed = sc.nextInt();
        sc.nextLine();

        if (eOx <= 0 || eRed <= 0) {
            System.out.println("Los electrones deben ser mayores a 0.");
            return;
        }

        int mcm = calcularMCM(eOx, eRed);
        System.out.println("\n--- BALANCE ---");
        System.out.println("Total de electrones a igualar (MCM): " + mcm);
        System.out.println("Multiplicar (" + semiOx + ") por: " + (mcm / eOx));
        System.out.println("Multiplicar (" + semiRed + ") por: " + (mcm / eRed));
    }



    // Despeje sencillo: a la carga total le quitas lo conocido y divides entre los atomos de X
    public static void calcularEstadoOxidacion(Scanner sc) {
        System.out.print("Formula o ion: ");
        String formula = sc.nextLine();

        System.out.print("Carga total (ej. 0, -1, -2): ");
        int cargaTotal = sc.nextInt();

        System.out.print("Atomos de H (+1): ");
        int numH = sc.nextInt();

        System.out.print("Atomos de O (-2): ");
        int numO = sc.nextInt();

        System.out.print("Atomos del elemento desconocido: ");
        int numElemento = sc.nextInt();
        sc.nextLine();

        if (numElemento <= 0) {
            System.out.println("Debe haber al menos 1 atomo del elemento.");
            return;
        }

        int conocidos = numH - (2 * numO);
        double estadoOx = (double) (cargaTotal - conocidos) / numElemento;

        System.out.println("\n--- ESTADO DE OXIDACION ---");
        System.out.println("Compuesto: " + formula);
        System.out.println("Valor de X: " + (estadoOx > 0 ? "+" : "") + estadoOx);
    }

    public static int calcularMCM(int a, int b) {
        return Math.abs(a * b) / calcularMCD(a, b);
    }

    private static int calcularMCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int resto = a % b;
            a = b;
            b = resto;
        }
        return a;
    }
}