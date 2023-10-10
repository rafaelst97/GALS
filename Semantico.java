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
                stack.push(Integer.parseInt(token.getLexeme(), 2));
                break;
            case 2:
                b = stack.pop();
                a = stack.pop();

                stack.push((a.intValue() + b.intValue()));
                break;
            case 3:
                b = stack.pop();
                a = stack.pop();

                stack.push((a.intValue() * b.intValue()));
                break;
            case 4:
                stack.push(vars.get(token.getLexeme()));
                break;

            case 5:
                b = stack.pop();
                a = stack.pop();

                stack.push((a.intValue() - b.intValue()));
                break;

            case 6:
                b = stack.pop();
                a = stack.pop();

                stack.push((a.intValue() / b.intValue()));
                break;

            case 7:
                b = stack.pop();
                a = stack.pop();
                Double A = Math.pow(a, b);
                stack.push((A.intValue()));
                break;

            case 8:
                System.out.println("Resultado " + Integer.toBinaryString(vars.get(varAtual)) + "\n");
                break;

            case 9:
                vars.put(varAtual, stack.pop());
                break;

            case 10:
                varAtual = token.getLexeme();
                break;

        }
    }	
}
