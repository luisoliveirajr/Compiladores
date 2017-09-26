/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Stack;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author luis.oliveira
 */
public class Operations {
    private final Stack<Character> pilha = new Stack<>();
    
    //Metódo converte expressão de infixa para posfixa.
    public String Posfixa(String s){
        int i;
        String pos = new String();
        //Alertta de Erros.
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Compilador");
        alerta.setHeaderText(null);
            s = ExConc(s);
            //Primeiro Algoritmo.
            for(i=0; i< s.length(); i++){
                //Verifica se o caracter é operando    
                if(s.charAt(i)!= '(' && s.charAt(i)!= ')' && s.charAt(i)!= '.' && s.charAt(i)!= '+' && s.charAt(i)!= '*' ){

                    pos += s.charAt(i);
                }
                //Caso o caracter seja operador.
                else{ 
                    //Se for abre parenteses.
                    if(s.charAt(i)== '('){
                         pilha.push('(');
                    }
                    //Se for fecha parentese
                    else if(s.charAt(i)== ')'){
                            //Desempilha até enquanto a pilha não estiver vazia ou encontrar o abre parentese.  
                            while(!pilha.isEmpty() && pilha.lastElement() != '(' ){
                              pos+= pilha.lastElement();
                              pilha.pop();
                            }
                            //Remove o último elemento da pilha. 
                            if(!pilha.empty()){
                                pilha.pop();
                            }   
                            else{
                                alerta.setContentText("Falta abrir parêntese '('.");
                                alerta.showAndWait();  
                            }
                    }
                     // 
                    else{
                          if(!pilha.empty()){                         
                             if(PreOp(s.charAt(i))> PreOp(pilha.lastElement())){
                                pilha.push(s.charAt(i));                           
                             }
                             else{
                                  while(!pilha.isEmpty() && PreOp(s.charAt(i)) <= PreOp(pilha.lastElement())){
                                        pos+= pilha.lastElement(); 
                                        pilha.pop();
                                  }
                                  pilha.push(s.charAt(i));                             
                             }
                          }
                          else{
                              pilha.push(s.charAt(i));  
                          }
                    }
                }
            }//fim for
            //Desempilha todos operacdores que estão na pilha.
            while(!pilha.isEmpty() && pilha.lastElement() != '(' ){
                   pos+= pilha.lastElement();
                   pilha.pop();
            }
            if(!pilha.empty()){
                alerta.setContentText("Falta fechar parêntese ')'.");
                alerta.showAndWait(); 
            }
        pos = ValidaExpressao(pos); // validando a expressao.
        return pos;
    }
    
    public String ValidaExpressao(String s){
        int i;
        //Alertta de Erros.
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Compilador");
        alerta.setHeaderText(null);
        
            for(i=0; i< s.length(); i++){
                //Se simbolo for operando
                if(s.charAt(i)!= '.' && s.charAt(i)!= '+' && s.charAt(i)!= '*'){
                pilha.push(s.charAt(i));
                }
                //Se simbolo for operador
                else{
                    //Se operador Binario
                    if(s.charAt(i)!= '*'){
                        if(!pilha.empty()){
                            pilha.pop();
                            if(!pilha.empty()){
                                pilha.pop();
                                pilha.push('x');
                            }//fim op1
                            else{
                                alerta.setContentText(" O operador '"+s.charAt(i)+"' é binário e só foi encontrado um operando.");
                                alerta.showAndWait();
                                return null;
                            }
                        }//fim op2
                        else{
                            alerta.setContentText(" O operador '"+s.charAt(i)+"' é binário e só foi encontrado um operando.");
                            alerta.showAndWait();
                            return null;
                        }
                    }//fim bin
                //Se o simbolo e Unario
                else{
                     if(!pilha.empty()){
                         pilha.pop();
                         pilha.push('s');
                     }
                     else{
                          alerta.setContentText(" O operador '"+s.charAt(i)+"' é unario e não foi encontrado operando.");
                          alerta.showAndWait();
                          return null;
                     }
                }
            } //fim operadores
        }//fim for
        if(pilha.empty()){
             alerta.setContentText(" Expressão Regular inválida.");
             alerta.showAndWait();
             return null;
        }
        else{
            return s;   
        }
    }
    
    //Metódo que torna explicito as concatenações da expressão
    private String ExConc(String a){
        String b = new String();
        int i;
             for(i=0; i< a.length(); i++){
                //Verifica se o caracter não é reservado 
                if(a.charAt(i) == ' '){
                   b += a.charAt(i);
                   b += '.';
                }
                else if(i > 0 && a.charAt(i) == '(' && a.charAt(i-1) == ')'){
                    b+='.';
                    b += a.charAt(i);
                    
                }
                else if(i > 0 && a.charAt(i-1) == '*'){
                    b+='.';
                    b += a.charAt(i);
                }
                else if(i > 0 && a.charAt(i-1) != '+' && a.charAt(i-1) != '.' && a.charAt(i-1) != ' ' && a.charAt(i-1) != '*' && a.charAt(i-1) != '(' && a.charAt(i-1) != ')' && a.charAt(i) != '+' && a.charAt(i) != '.' && a.charAt(i) != '*' && a.charAt(i) != ')' && a.charAt(i) != '('){
                    b+='.';
                    b += a.charAt(i);
                } 
                else{
                    b += a.charAt(i);
                }
            }
        return b;
    }
    
    //Metódo que define a precendecia de operadores;
    private int PreOp(char op){
        switch (op) {
            case '*':
                return 3; //Maior precendecia
            case '.':
                return 2;
            case '+':
                return 1;
            default:
                return 0; // Menor precendencia
        }
    }
    
    private Automato base(String s){
        Automato a = new Automato();
        ArrayList <Integer> EstadosFinais = new ArrayList<>();
        Transicao T = new Transicao();
        
        a.setAlfabeto(s);
        a.setConjunto_de_Simbolos(s);
        a.setEstadoInicial(0);
        EstadosFinais.add(1);
        a.setEstadosFinais(EstadosFinais);
        T.transicao.add(1);
        a.setMatrizdeTransicao(T);
        
        return a; 
    }
}
