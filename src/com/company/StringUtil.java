package com.company;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n)
    {
        String cadenaADevolver = "";
        for (int i = 1; i <= n; i++){
            cadenaADevolver += c;
        }
        return cadenaADevolver;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    public static String lpad(String s, int n, char c)
    {
        String cadenaADevolver = s;
        String cadenaAux;
        cadenaAux = replicate(c, n);
        cadenaADevolver = cadenaAux + cadenaADevolver;

        return cadenaADevolver;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] arrayADevolver = new String[arr.length];

        for (int i = 0; i < arr.length; i++){
            arrayADevolver[i] = String.valueOf(arr[i]);
        }
        return arrayADevolver;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String arr[])
    {
        int[] arrayADevolver = new int[arr.length];

        for (int i = 0; i < arr.length; i++){
            arrayADevolver[i] = Integer.parseInt(arr[i]);
        }
        return arrayADevolver;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int max = 0;
        for (int i = 0; i < arr.length; i++){
            if (max <= arr[i].length()){
                max = arr[i].length();
            }
        }
        return max;
    }

    public static String generarNuevoArray(String palabra, char c, int mayorCantidadCaracteres){
        return lpad(palabra, mayorCantidadCaracteres, c);
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c)
    {
        String arrayADevolver[] = arr;
        int mayorCantidadCaracteres = maxLength(arr);
        for (int i = 0; i < arr.length; i++){
            arrayADevolver[i] = generarNuevoArray(arr[i], c, mayorCantidadCaracteres - arr[i].length());
        }
    }
}