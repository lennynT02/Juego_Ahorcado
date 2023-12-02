import java.util.Scanner;
import java.util.Random;

public class Ahorcado {

    static char opcion;
    static String[] palabras = {"oceano", "bosque", "tecnologia", "programar", "dinero", "sabiduria", "aprender", "oscuridad", "comida", "viajar"};
    static String palabra, fallas;
    static int aleatorio;
    static int vida;
    static boolean correcta, completa;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            vida = 7;
            palabra = "";
            fallas = "";
            System.out.println("OPCIONES DEL JUEGO");
            System.out.println("1. Jugar");
            System.out.println("2. Salir");
            opcion = scanner.next().charAt(0);

            switch (opcion) {
                case '1':
                    jugarPartida();
                    break;
                case '2':
                    System.out.println("Saliendo del juego.....");
                    return;
            }
        } while (opcion != '2');
    }

    public static void jugarPartida() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        aleatorio = random.nextInt(10);

        for (int i = 0; i < palabras[aleatorio].length(); i++) {
            palabra += "-";
        }

        while (vida > 0) {
            System.out.println("------A H O R C A D O------");
            dibujar();
            System.out.println("Letras con las que has fallado: " + fallas);
            System.out.println("Hasta el momento tu palabra es: " + palabra);
            System.out.print("Dime una letra: ");
            opcion = scanner.next().charAt(0);
            System.out.println("Jugando");

            correcta = false;
            for (int i = 0; i < palabras[aleatorio].length(); i++) {
                if (palabras[aleatorio].charAt(i) == opcion) {
                    palabra = palabra.substring(0, i) + opcion + palabra.substring(i + 1);
                    correcta = true;
                }
            }

            if (!correcta) {
                vida--;
                fallas += opcion + " ";
            }

            completa = !palabra.contains("-");
            if (completa) {
                System.out.println("A H O R C A D O");
                dibujar();
                System.out.println("Palabra completa: " + palabras[aleatorio]);
                System.out.println("GANASTE");
                System.out.print("Si deseas seguir jugando ingresa cualquier caracter: ");
                opcion = scanner.next().charAt(0);
            }
        }

        System.out.println("A H O R C A D O");
        dibujar();
        System.out.println("Palabra completa: " + palabras[aleatorio]);
        System.out.println("PERDISTE");
        System.out.print("Si deseas seguir jugando ingresa cualquier caracter: ");
        opcion = scanner.next().charAt(0);
    }

    public static void dibujar() {
        switch (vida) {
            case 7:
                System.out.println(" ------------  ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println("----           ");
                break;
            case 6:
                System.out.println(" ------------  ");
                System.out.println(" |          |  ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println("----           ");
                break;
            case 5:
                System.out.println("Llevas 1 falla ");
                System.out.println("Dibujare tu cabeza ");
                System.out.println(" ------------  ");
                System.out.println(" |          |  ");
                System.out.println(" |          O  ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println("----           ");
                break;
            case 4:
                System.out.println("Llevas 2 falla ");
                System.out.println("Dibujare tu tronco ");
                System.out.println(" ------------  ");
                System.out.println(" |          |  ");
                System.out.println(" |          O  ");
                System.out.println(" |          |  ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println("----           ");
                break;
            case 3:
                System.out.println("Llevas 3 falla ");
                System.out.println("Dibujare tu brazo ");
                System.out.println(" ------------  ");
                System.out.println(" |          |  ");
                System.out.println(" |          O  ");
                System.out.println(" |         /|\\ ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println("----           ");
                break;
            case 2:
                System.out.println("Llevas 4 falla ");
                System.out.println("Dibujare tu otro brazo ");
                System.out.println(" ------------  ");
                System.out.println(" |          |  ");
                System.out.println(" |          O  ");
                System.out.println(" |         /|\\ ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println("----           ");
                break;
            case 1:
                System.out.println("Llevas 5 falla ");
                System.out.println("Dibujare tu pierna ");
                System.out.println(" ------------  ");
                System.out.println(" |          |  ");
                System.out.println(" |          O  ");
                System.out.println(" |         /|\\ ");
                System.out.println(" |         /   ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println("----           ");
                break;
            case 0:
                System.out.println("Llevas 6 falla ");
                System.out.println("Dibujare otra pierna ");
                System.out.println(" ------------  ");
                System.out.println(" |          |  ");
                System.out.println(" |          O  ");
                System.out.println(" |         /|\\ ");
                System.out.println(" |         / \\ ");
                System.out.println(" |             ");
                System.out.println(" |             ");
                System.out.println("----           ");
                break;
        }
    }
}
