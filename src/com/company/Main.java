package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static void inicializarHashMap (HashMap<Integer, ArrayList<String>> hashMap, int longitudArrayOriginal){

        for (int i = 0; i < longitudArrayOriginal; i++){
            ArrayList <String> arrayList = new ArrayList<>();
            hashMap.put(i, arrayList);
        }
    }

    private static boolean indiceCoincideConKeyHashMap(char digitoArray, char indiceHash){
        return digitoArray == indiceHash;
    }

    private static void aniadirListaRenovadaAHash(HashMap<Integer, ArrayList<String>> hashMap, String digito, int indiceHashMap){
        ArrayList<String>arrayList = new ArrayList<>();
        arrayList = hashMap.get(indiceHashMap);
        arrayList.add(digito);
        hashMap.put(indiceHashMap, arrayList);
    }

    private static void aniadirListasAHash(HashMap<Integer, ArrayList<String>> hashMap, int longitudArrayOriginal, int longaaux, int indicadorDigito, String[] array){
        for (int indiceHashMap = 0; indiceHashMap < 10; indiceHashMap++) {
            for (int indiceDigito = 0; indiceDigito < longitudArrayOriginal; indiceDigito++){
                if (indiceCoincideConKeyHashMap(array[indiceDigito].charAt(longaaux-1-indicadorDigito), Character.forDigit(indiceHashMap, 10))){
                    aniadirListaRenovadaAHash(hashMap, array[indiceDigito], indiceHashMap);
                }
            }
        }
    }

    private static void agregarValoresDeHashMapAArray(HashMap<Integer, ArrayList<String>> hashMap, int longitudArrayOriginal, int ultimoIndiceVector, String[]array){
        for (int indiceHashMap = 0; indiceHashMap < longitudArrayOriginal; indiceHashMap++){
            ArrayList<String>arrayList = new ArrayList<>();
            arrayList = hashMap.get(indiceHashMap);

            if (hashMap.get(indiceHashMap).size() != 0){
                for (String s : arrayList) {
                    array[ultimoIndiceVector] = s;
                    ultimoIndiceVector++;
                }
            }
            ArrayList<String>arrayList2 = new ArrayList<>();

            hashMap.put(indiceHashMap, arrayList2);

        }
    }

    private static void obtenerArrayOrdenado (int longitudMayorPalabra, int longitudArrayOriginal, String[] array, HashMap<Integer, ArrayList<String>> hashMap, int longaaux){
        for (int indicadorDigito = 0; indicadorDigito < longitudMayorPalabra; indicadorDigito++) {

            aniadirListasAHash(hashMap, longitudArrayOriginal, longaaux, indicadorDigito, array);
            int ultimoIndiceVector = 0;

            agregarValoresDeHashMapAArray(hashMap, longitudArrayOriginal, ultimoIndiceVector, array);
        }
    }

    public static void radixSort(int []arr)
    {
        // PROGRAMAR AQUI
        String[] arrayAux = new String[arr.length];

        int longitudArrayOriginal = arr.length;

        int [] arrayADevolver;

        arrayAux = StringUtil.toStringArray(arr);

        int longitudMayorPalabra = StringUtil.maxLength(arrayAux);

        StringUtil.lNormalize(arrayAux, '0');

        int longaaux = StringUtil.maxLength(arrayAux);

        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();

        inicializarHashMap(hashMap, longitudArrayOriginal);

        obtenerArrayOrdenado(longitudMayorPalabra, longitudArrayOriginal, arrayAux, hashMap, longaaux);

        arrayADevolver = StringUtil.toIntArray(arrayAux);

        arr = arrayADevolver;

        mostrarVectorOrdenado(arr);

    }

    private static void mostrarVectorOrdenado(int [] arr){
        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
    }

    public static void main(String[] args)
    {
        int[] arr ={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

    }
}
