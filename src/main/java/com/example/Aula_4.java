package com.example;

public class Aula_4 {

    public static void main(String[] args) {
        
       // Contrução de vetores automatizados:

       int vetor[] = new int[5];

       //O comando for ja criou a variavel de controle começando do 0, vetor.length significa tamanho do vetor, 
       // no caso o tamanho do vetor é 5, mas o indice vai até 4 começando do 0, por isso é usado < e não <=.

       for (int i = 0; i < vetor.length; i++) {
            vetor[i] = 100 * (i + 1);
            System.out.println(i);
       }

       int matriz[][] = new int[4][5];

       for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = i * matriz[i].length + j;
            }
            System.out.println();
       }
       for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
            System.out.println(matriz[i][j]);
        }
        System.out.println();
   }

    }
    
}
