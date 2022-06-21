/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package menuarray;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Pablo Oller
 */
public class Menuarray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int TAM = 100;//Esta constante es para el tamaño del array, tiene un valor fijo
        int mayor = 0, menor = 100, suma, opcion = 0, pos, n;
        double media;
        //Creamos las variables que vamos a utilizar más adelante
        boolean desconocido = true;
        //Este booleano va a hacer que aparezcan las opciones por pantalla una vez
        int[] array = new int[TAM];
        //Declaramos el array, con tamaño TAM (100)
        Random al = new Random();
        //Creamos la clase random
        Scanner lector = new Scanner(System.in);
        //Creamos la clase lectura
        for (int i = 0; i < array.length; i++) {
            array[i] = al.nextInt();//formamos el array con numeros aleatorios
            System.out.println(array[i]);//preguntar si enseñar el array
        }

        do {
            suma = 0;//Inicializamos la suma en 0 por cada vez que se inicie en bucle y no sumar ya la anterior suma
            for (int i = 0; i < array.length; i++) {//Declaramos un segundo for para realizar las operaciones o sustitución del número

                if (array[i] > mayor) {
                    mayor = array[i];//Esta función encuentra el mayor o lo sustituye por uno más grande
                }
                if (array[i] < menor) {
                    menor = array[i];//Esta función encuentra el menor o lo sustituye por uno más pequeño
                }
                suma += array[i];//Aquí se suman todos los números
            }
            media = (double) suma / 100;//Aquí e hace la media

            if (desconocido) {//Esta función va a leeer el enunciado cuando desconocido sea verdadero
                System.out.println("Elige una opción:");//Esto va a ser el enunciado
                System.out.println("1. Mayor");
                System.out.println("2. Menor");
                System.out.println("3. Suma de todos los elementos");
                System.out.println("4. Media de todos los elementos");
                System.out.println("5. Sustituir un número");
                System.out.println("6.Salir");
            }
            desconocido = false;//Lo dejamos en falso para que no se vuelva a repetir el enunciado
            System.out.println("Opción?");
            opcion = lector.nextInt();//Metemos la opción con un valor entero
            switch (opcion) {//Creamos un switch para los distintos casos que pueden pasar
                case 1://Sale el número mayor calculado antes
                    System.out.println("El mayor es " + mayor);
                    break;
                case 2://Sale el número menor calculado antes
                    System.out.println("El menor es " + menor);
                    break;
                case 3://Sale la suma calculada antes
                    System.out.println("La suma es " + suma);
                    break;
                case 4://Sale la media calculada antes
                    System.out.println("La media es " + media);
                    break;
                case 5://Sustitución de un número
                    do {
                        System.out.println("Introduce la posición del número entre 0 y 99");
                        pos = lector.nextInt();
                    } while (pos < 0 || pos > 99);//Hasta que no meta el usuario una posición entre el 0 y el 99 no continúa el programa
                    System.out.println("Introduce el numero de repuesto");
                    while (!lector.hasNextInt()) {//para que solo pida números enteros utilizamos el bucle hasNextInt
                        lector.next();
                        System.out.println("Solo se permiten enteros, intentalo otra vez");
                    }
                    n = lector.nextInt();//Indtroducimos el número que queramos (preguntar al profesor si lo dejamos como entero)
                    array[pos] = n;//Cambiamos el valor en la posición seleccionada del array
                    System.out.println("Ahora en la posición " + pos + " está el valor " + n);
                    break;
                case 6:
                    System.out.println("Saliendo...");//Sale del programa
                    break;
                default:
                    System.out.println("Opción desconocida, introduzca otra de nuevo");//Cuando el usuario no meta un número entre el 1 y el 6 el programa dará error
                    break;
            }
        } while (opcion != 6);//Cuando pulse 6 el usuario el bucle acabará

    }

}
