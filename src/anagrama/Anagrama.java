/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagrama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author edher
 */
public class Anagrama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Scanner read = new Scanner(System.in);
        String palabra = new String();
        String[] words;
        words[0]="hola";
        String z = "";
        while(z!="\n")
        {
            Arrays.
        }
        words = read.next();
        System.out.println(alfabeticamente(palabra));*/
       
       ArrayList<String> palabra = new ArrayList<String>(); //Creamos una lista de arreglos de tipo string
       Scanner read = new Scanner(System.in); //Creamos un objeto de tipo Scanner para leer las palabras que ingrese el usuario
       String z;    //En esta variable auxiliar se guardará temporalmente la palabra que desea agregar a la lista el usuario en tiempo de ejecución del programa
       //z=read.nextLine();
       
       do      //Ciclo do-while para permitir que el usuario ingrese palabras y el ciclo se rompa cuando el usuario ingrese la letra "r"
       {
           z=read.next().toUpperCase();   //Almacena en variable z la palabra que el usuario escribe en consola
         if(!z.equals("R"))     //Compara si z es igual a r de lo contrario añade la palabra a la lista
           palabra.add(z);
           
       }while(!(z.equals("R"))); //Si z es igual a r se rompe el ciclo do-while
        //System.out.println(palabra.get(1));
        groupAnagrams(palabra);
      
        
    }
    
    public static void groupAnagrams(List<String> words)
    {
        if(words.isEmpty())
            System.out.println("La lista está vacía");
        else
        {
        String[] auxiliar = new String[words.size()];
        for(int y=0; y<words.size(); y++) //Ciclo for para ordenar alfabeticamente mediante la funcion alfabeticamenete(String) cada palabra de nuestro ArrayList 
        {
            //System.out.println(alfabeticamente(words.get(y))); //Se imprime cada palabra ordenada alfabeticamente
            auxiliar[y] = alfabeticamente(words.get(y));
            
        }
        //System.out.println(auxiliar.length);
        resultados(auxiliar,words);
        }

    }
    
    public static String alfabeticamente(String word)
    {
        String[] hola = word.split(""); //Construye un arreglo de String, mediante el String pasado como parametro
        Arrays.sort(hola); //Ordena el arreglo de String alfabeticamente
        word = ""; //Nuestro parametro se iguala a una cadena vacía.
        for(int x=0;x<hola.length;x++){   //Ciclo for para formar una variable String con ayuda del método concat(String[])
         word = word.concat(hola[x]); 
        }
        return word; //Retornar la cadena ordenada alfabeticamente
    }
    
    public static void resultados(String[] container, List<String> palabras)
    {
        int contador = 0; //Verifica si es la primera coincidencia
        Map<String,Integer> myMap = new HashMap<String,Integer>(); 
        //System.out.println(container[0]+" ");
        for(int k=0; k<container.length; k++)
        {
            for(int l=k+1; l<container.length; l++)
            {
                if(container[k].equals(container[l]) && myMap.get(container[l])==null)
                {
                    contador++;
                    if(contador==1)
                    {
                        /*System.out.print(palabras.get(mapa.get(container[k]))+" ");
                        System.out.print(palabras.get(mapa.get(container[l]))+" ");*/
                        System.out.print(palabras.get(k)+" - ");
                        System.out.print(palabras.get(l)+" - ");
                        
                    }
                    else
                        //System.out.print(palabras.get(mapa.get(container[l]))+" ");
                        System.out.print(palabras.get(l)+" - ");
                    
                }
            }
            if(contador!=0){
                System.out.print("\n");
            }  
            
            
            
            
            
            
            contador = 0;
            myMap.put(container[k], k);
        }
         
    }
    
}
