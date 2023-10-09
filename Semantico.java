package gals;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    Stack<Integer> stack = new Stack<>();
    Map<String, Integer> vars = new HashMap<String, Integer>();

    String varAtual;
    public void executeAction(int action, Token token)	throws SemanticError
    {
        Integer a, b;

        switch (action){
            case 1:
                System.out.println("CASE 1");
                System.out.println(token.getLexeme());
                stack.push(Integer.parseInt(token.getLexeme(), 2));
                break;
            case 2:
                System.out.println("CASE 2");
                b = stack.pop();
                a = stack.pop();

                int teste = a.intValue() + b.intValue();
                stack.push((a.intValue() + b.intValue()));
                System.out.println(varAtual);
                System.out.println(teste);
                break;
            case 3:
                System.out.println("CASE 3");
                System.out.println(token.getLexeme());
                b = stack.pop();
                a = stack.pop();

                int teste2 = a.intValue() * b.intValue();
                stack.push((a.intValue() * b.intValue()));
                System.out.println(teste2);
                System.out.println(varAtual);
                break;
            case 4:
                System.out.println("CASE 4");
                System.out.println(token.getLexeme());
                System.out.println(vars.get(token.getLexeme()));
                stack.push(vars.get(token.getLexeme()));
                break;

            case 5:
                System.out.println("CASE 5");
                b = stack.pop();
                a = stack.pop();

                stack.push((a.intValue() - b.intValue()));
                break;

            case 6:
                System.out.println("CASE 6");
                b = stack.pop();
                a = stack.pop();

                stack.push((a.intValue() / b.intValue()));
                break;

            case 7:
                System.out.println("CASE 7");
                b = stack.pop();
                a = stack.pop();
                Double A = Math.pow(a, b);
                stack.push((A.intValue()));
                break;

            case 8:
                System.out.println("CASE 8");
                System.out.println("Resultado " + Integer.toBinaryString(vars.get(varAtual)) + "\n");
                break;

            case 9:
                System.out.println("CASE 9");
                System.out.println(token.getLexeme());
                vars.put(varAtual, stack.pop());
                break;

            case 10:
                System.out.println("CASE 10");
                varAtual = token.getLexeme();
                System.out.println(varAtual);
                break;

        }
    }	
}
