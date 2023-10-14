import gals.*;

import java.io.StringReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LexicalError, SemanticError, SyntaticError {

        Scanner input = new Scanner(System.in);
        String comando;

        do {

            System.out.print("Digite um comando: ");
            comando = input.nextLine();

            try {
                Lexico lexico = new Lexico(new StringReader(comando));
                //Lexico lexico = new Lexico(new StringReader("A = 10; B = 11; B = 111 + A * B; imprimir ( B );"));
                Sintatico sintatico = new Sintatico();
                Semantico semantico = new Semantico();

                sintatico.parse(lexico, semantico);
            } catch (LexicalError | SyntaticError | SemanticError e) {
                System.out.println("comando nao encontrado");
            }
        } while (true);
    }
}