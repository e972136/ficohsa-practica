package com.patito.xmen.entity;

import org.springframework.stereotype.Component;

/**
 * Clase para validacion de los mutantes
 * @since  2022/06/22
 * @author GasparCalix
 * */
@Component
public class Sentinel {
    static final int cantidad = 4;

    private boolean derecha(int fila, int columna, String v, String data[]){
        int cont=0;
        int end=columna+cantidad;
        if(end>data[0].length())
        {
            return false;
        }

        for(int c=columna;c<end && c < data[fila].length();c++)
        {
            if(data[fila].charAt(c)==v.charAt(0)){
                cont++;
                if(cont==cantidad){
                    return true;
                }
            }else{
                cont=0;
            }
        }
        return false;
    }

    private boolean abajo(int fila, int columna, String v, String data[]){
        int cont=0;
        int end = fila+cantidad;
        if(end>data.length){
            return false;
        }
        for(int f=fila;f<end && f<data.length; f++){
            if(data[f].charAt(columna) == v.charAt(0)){
                cont++;
                if(cont==cantidad){
                    return true;
                }
            }else{
                cont = 0;
            }
        }
        return false;
    }

    private boolean diagonalDerecha(int fila, int columna, String v, String data[]){
        int cont = 0;
        int endF = fila+cantidad;
        if(endF>data.length){
            return false;
        }
        int endC = columna+cantidad;
        if(endC>data[0].length())
        {
            return false;
        }
        for(int f=fila;f<endF;f++)
        {
            if(data[f].charAt(columna) == v.charAt(0)){
                cont++;
                if(cont==cantidad){
                    return true;
                }
            }else{
                cont = 0;
            }
            columna++;
        }
        return false;
    }

     private boolean diagonalIxquierda(int fila, int columna, String v, String data[]){
        int cont = 0;
        int endF = fila+cantidad;
        if(endF>data.length){
            return false;
        }
        int endC = columna-cantidad+1;
        if(endC<0)
        {
            return false;
        }
        for(int f=fila;f<endF;f++)
        {
            char p1 = data[f].charAt(columna);
            char p2 = v.charAt(0);
            if(data[f].charAt(columna) == v.charAt(0)){
                cont++;
                if(cont==cantidad){
                    return true;
                }
            }else{
                cont = 0;
            }
            columna--;
        }
        return false;
    }

    /**
     * Metodo expuesto para validar
     * @param data codigo ADN
     */
     public boolean isMutant(String []data){
        String validadores[]={"A","T","C","G"};
        int nSecuencias = 0;

        for(int f=0;f<data.length;f++)
        {
            for(int c=0;c<data[f].length();c++){

                for(String validador:validadores){
                    boolean b = derecha(f,c,validador,data);
                    if(b){
                        System.out.println(validador+" f"+f+" c"+c+" derecha");
                        nSecuencias++;
                    }
                    b = abajo(f,c,validador,data);
                    if(b){
                        System.out.println(validador+" f"+f+" c"+c+" abajo");
                        nSecuencias++;
                    }
                    b= diagonalDerecha(f,c,validador,data);
                    if(b){
                        System.out.println(validador+" f"+f+" c"+c+" diagonalDerecha");
                        nSecuencias++;
                    }
                    b= diagonalIxquierda(f,c,validador,data);
                    if(b){
                        System.out.println(validador+" f"+f+" c"+c+" diagonalIxquierda");
                        nSecuencias++;
                    }
                    if(nSecuencias>1){
                        return true;
                    }

                }
            }
        }
        return false;
    }

}
