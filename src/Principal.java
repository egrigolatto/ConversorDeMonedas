import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // objeto ConversorMoneda para realizar las conversiones
        ConversorMoneda conversor = new ConversorMoneda();

        // Menú de opciones
        System.out.println();
        System.out.println("<$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$>");
        System.out.println();
        System.out.println("Bienvenido al Conversor de Monedas");
        System.out.println("1) Dólar ---> Peso argentino");
        System.out.println("2) Peso argentino ---> Dólar");
        System.out.println("3) Dólar ---> Real brasileño");
        System.out.println("4) Real brasileño ---> Dólar");
        System.out.println("5) Dólar ---> Peso colombiano");
        System.out.println("6) Peso colombiano ---> Dólar");
        System.out.println("7) Salir");
        System.out.println();
        System.out.println("<$*$*$*$*$*$*$*$*$*$*$*$*$*$*$*$>");
        System.out.println();

        // usamos un bucle while para iterar
        while (true) {
            // pedimos al usuario que elija una opción del menú
            System.out.print("--> Elija una opción (1-7): ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    convertirMoneda(conversor, "USD", "ARS");
                    break;
                case "2":
                    convertirMoneda(conversor, "ARS", "USD");
                    break;
                case "3":
                    convertirMoneda(conversor, "USD", "BRL");
                    break;
                case "4":
                    convertirMoneda(conversor, "BRL", "USD");
                    break;
                case "5":
                    convertirMoneda(conversor, "USD", "COP");
                    break;
                case "6":
                    convertirMoneda(conversor, "COP", "USD");
                    break;
                case "7":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Elija una opción válida.");
            }
        }
    }

    // Método creado para convertir moneda
    private static void convertirMoneda(ConversorMoneda conversor, String monedaOrigen, String monedaDestino) {
        Scanner scanner = new Scanner(System.in);
        // pedimos al usuario que ingrese un monto
        System.out.print("--> Ingrese el monto a convertir: ");
        double montoInput = scanner.nextDouble();
        // conversión con el objeto ConversorMoneda
        double montoConvertido = conversor.convertirMoneda(montoInput, monedaOrigen, monedaDestino);
        // Mostramos el resultado
        System.out.println(montoInput + " " + monedaOrigen + " = " + montoConvertido + " " + monedaDestino);
    }
}

