package com.patito.xmen.entity;

import org.springframework.stereotype.Component;

/**
 * Clase para validacion de los mutantes
 * @since  2022/06/22
 * @author GasparCalix
 * */
@Component
public class Sentinel {
    static final int CANTIDAD = 4;
    static final String VALIDADORES[]={"A","T","C","G"};

    private boolean derecha(int fila, int columna, String v, String data[]){
        int cont=0;
        int end=columna+ CANTIDAD;
        if(end>data[0].length())
        {
            //no hay espacio para buscar
            return false;
        }

        for(int c=columna;c<end && c < data[fila].length();c++)
        {
            if(data[fila].charAt(c)==v.charAt(0)){
                cont++;
                if(cont== CANTIDAD){
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
        int end = fila+ CANTIDAD;
        if(end>data.length){
            //no hay espacio para buscar
            return false;
        }
        for(int f=fila;f<end && f<data.length; f++){
            if(data[f].charAt(columna) == v.charAt(0)){
                cont++;
                if(cont== CANTIDAD){
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
        int endF = fila+ CANTIDAD;
        if(endF>data.length){
            //no hay espacio para buscar
            return false;
        }
        int endC = columna+ CANTIDAD;
        if(endC>data[0].length())
        {
            //no hay espacio para buscar
            return false;
        }
        for(int f=fila;f<endF;f++)
        {
            if(data[f].charAt(columna) == v.charAt(0)){
                cont++;
                if(cont== CANTIDAD){
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
        int endF = fila+ CANTIDAD;
        if(endF>data.length){
            //no hay espacio para buscar
            return false;
        }
        int endC = columna- CANTIDAD +1;
        if(endC<0)
        {
            //no hay espacio para buscar
            return false;
        }
        for(int f=fila;f<endF;f++)
        {
            if(data[f].charAt(columna) == v.charAt(0)){
                cont++;
                if(cont== CANTIDAD){
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
        int nSecuencias = 0;
        for(int f=0;f<data.length;f++)
        {
            for(int c=0;c<data[f].length();c++){

                for(String validador: VALIDADORES){

                    if(derecha(f,c,validador,data)){
//                        System.out.println(validador+" f"+f+" c"+c+" derecha");
                        nSecuencias++;
                        if(nSecuencias>1){
                            return true;
                        }
                    }
                    if(abajo(f,c,validador,data)){
//                        System.out.println(validador+" f"+f+" c"+c+" abajo");
                        nSecuencias++;
                        if(nSecuencias>1){
                            return true;
                        }
                    }
                    if(diagonalDerecha(f,c,validador,data)){
//                        System.out.println(validador+" f"+f+" c"+c+" diagonalDerecha");
                        nSecuencias++;
                        if(nSecuencias>1){
                            return true;
                        }
                    }
                    if(diagonalIxquierda(f,c,validador,data)){
//                        System.out.println(validador+" f"+f+" c"+c+" diagonalIxquierda");
                        nSecuencias++;
                        if(nSecuencias>1){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
