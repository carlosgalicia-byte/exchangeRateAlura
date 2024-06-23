import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaExchangeRate consulta = new ConsultaExchangeRate();
        try {
            while (true) {
                System.out.println("************************************************************");
                System.out.println("ExchangeRate by Carlos Galicia");
                System.out.println("------------------------ BIENVENIDO ------------------------");
                System.out.println("Selecciona la opcion deseada:");
                System.out.println("1) Dolar => Peso Argentino");
                System.out.println("2) Peso argentino => Dolar");
                System.out.println("3) Dolar => Real brasilenio");
                System.out.println("4) Real brasilenio => Dolar ");
                System.out.println("5) Dolar => Peso colombiano");
                System.out.println("6) Peso colombiano => Dolar");
                System.out.println("7) Dolar => Peso mexicano");
                System.out.println("8) Peso mexicano => Dolar");
                System.out.println("9) Salir");
                System.out.println("************************************************************");

                var select = lectura.nextInt();
                if (select == 9) {
                    System.out.println("Gracias por usar ExchangeRate by Carlos Galicia. Adios!");
                    break;
                }
                String baseCode = "";
                String monedaAConvertir = "";

                switch (select) {
                    case 1 -> {
                        baseCode = "USD";
                        monedaAConvertir = "ARS";
                    }
                    case 2 -> {
                        baseCode = "ARS";
                        monedaAConvertir = "USD";
                    }
                    case 3 -> {
                        baseCode = "USD";
                        monedaAConvertir = "BRL";
                    }
                    case 4 -> {
                        baseCode = "BRL";
                        monedaAConvertir = "USD";
                    }
                    case 5 -> {
                        baseCode = "USD";
                        monedaAConvertir = "COP";
                    }
                    case 6 -> {
                        baseCode = "COP";
                        monedaAConvertir = "USD";
                    }
                    case 7 -> {
                        baseCode = "USD";
                        monedaAConvertir = "MXN";
                    }
                    case 8 -> {
                        baseCode = "MXN";
                        monedaAConvertir = "USD";
                    }
                    default -> {
                        System.out.println("Opcion invalida!");
                        continue; //Para pasar a la siguiente iteracion del ciclo While
                    }
                }
                System.out.println("************************************************************");
                System.out.println("Ingresa la cantidad a convertir:");
                System.out.println("************************************************************");

                double cantidad = lectura.nextDouble();
                double moneda = consulta.consultaMoneda(baseCode, monedaAConvertir, cantidad);
                System.out.println("Resultado: " + cantidad + " " + baseCode + " son igual a " + moneda + " " + monedaAConvertir);
            }
        }catch (NumberFormatException e){
            System.out.println("Error en la conversion!");
        }catch (Exception e) {
            System.out.println("Error en la conversion!");
        }finally {
            lectura.close();
        }

    }
}
