package ReversePolishNotation;

import MathManager.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Procesar implements ReversePolishNotation {

    public  Integer procesarOp(Operacion operacion){
        int resultado=0;

        Queue<Expressio> listaDeExpresiones = new LinkedList<Expressio>(operacion.getLlistaExpressions());
        Stack<Integer> pilaExpresiones = new Stack<Integer>();
        for(Expressio expre: listaDeExpresiones){

            if (!expre.isSymbol()) {
                //si entra es que no es una operacion y en teoria es un int
                Numero n = (Numero)expre;
                pilaExpresiones.push(n.getNumero());
            }
            else{
                Simbolo simbolo = (Simbolo)expre;
                String simboloString = simbolo.getSimbolo();
                if (simboloString.equals("+")){
                    int x1 = pilaExpresiones.pop();
                    int x2 = pilaExpresiones.pop();
                    int operacio = (x2+x1);
                    pilaExpresiones.push(operacio);

                }if(simboloString.equals("-")) {
                    int x1 = pilaExpresiones.pop();
                    int x2 = pilaExpresiones.pop();
                    int operacio = (x2-x1);
                    pilaExpresiones.push(operacio);

                }if(simboloString.equals("*")) {
                    int x1 = pilaExpresiones.pop();
                    int x2 = pilaExpresiones.pop();
                    int operacio = (x2*x1);
                    pilaExpresiones.push(operacio);

                }if(simboloString.equals("/")) {
                    int x1 = pilaExpresiones.pop();
                    int x2 = pilaExpresiones.pop();
                    int operacio = (x2/x1);
                    pilaExpresiones.push(operacio);
                } else{
                    return null;
                }

            }
        }
        resultado = pilaExpresiones.pop();
        operacion.setResultado(resultado);
        return resultado;
    }
}
