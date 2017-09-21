/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Stack;

/**
 *
 * @author luis.oliveira
 */
public class Operations {
    private Stack<Character> pilha = new Stack<>();
    
    //Metódo converte expressão de infixa para posfixa.
    public String Posfixa(String s){
        s = ExConc(s);
        
        
        return s;
    }
    
    //Metódo que torna explicito as concatenações da expressão
    private String ExConc(String a){
        String b = new String();
        int i;
            for(i=0; i< a.length(); i++){
            //Verifica se o caracter não é reservado 
                if(i > 0 && a.charAt(i)!= ')' && a.charAt(i)!= '.' && a.charAt(i)!= '+' && a.charAt(i)!= '*'){
                    //Verificar se o caracter onde será explicitado a contactenação não é reservado 
                    if(a.charAt(i-1)!= '(' && a.charAt(i-1)!= ')' && a.charAt(i-1)!= '+' && a.charAt(i-1)!= '.'){
                        
                        b += '.'; 
                    }  
                }
                b += a.charAt(i);
            }
        return b;
    }
    
    //Metódo que definer a precendecia de operadores;
    private int preOp(char op){
        if(op == '*') return 3; //Maior precendecia
            else if(op == '.') return 2;   
                else if(op == '+') return 1;
                    else return 0; // Menor precendencia
    }
}
