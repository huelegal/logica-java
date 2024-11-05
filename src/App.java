import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        // Piramide.direita();
        // Piramide.direitaInversa();
        // Piramide.esquerda();
        // Piramide.esquerdaInversa();

        // Letra.a();
        // Letra.ab();
        // Letra.nome();

        Calculadora.calculadora("4 * (3 + 3) + 10 + (10 * 8 + (2 - 1))");
    }
}

/*
 * Classe pirâmide
 */
class Piramide {
    public static void direita() {
        // String s = "";

        // for (int i = 0; i < 6; i++) {
        // System.out.println(s + i);
        // s += (char) 32;
        // }

        // for (int i = 0; i < 6; i++) {
        // System.out.println(" ".repeat(i) + i);
        // }

        for (int i = 0; i < 6; i++) {
            StringBuilder sb = new StringBuilder("      ");
            sb.setCharAt(i, (char) (48 + i));
            System.out.println(sb);
        }
    }

    public static void esquerda() {
        // String s = " ".repeat(6);

        // for (int i = 5; i >= 0; i--) {
        // System.out.println(s + i);
        // s = s.replaceAll(" $", "");
        // }

        // for (int i = 5; i >= 0; i--) {
        // System.out.println(" ".repeat(i) + i);
        // }

        for (int i = 5; i >= 0; i--) {
            StringBuilder sb = new StringBuilder("      ");
            sb.setCharAt(i, (char) (48 + i));
            System.out.println(sb);
        }
    }

    public static void direitaInversa() {
        for (int i = 0; i < 6; i++) {
            System.out.println(" ".repeat(i) + (5 - i));
        }

        String s = "";

        for (int i = 5; i >= 0; i--) {
            System.out.println(s + i);
            s += (char) 32;
        }

        for (int i = 0; i < 6; i++) {
            StringBuilder sb = new StringBuilder("      ");
            sb.setCharAt(i, (char) (53 - i));
            System.out.println(sb);
        }
    }

    public static void esquerdaInversa() {
        String s = " ".repeat(6);

        for (int i = 5; i >= 0; i--) {
            System.out.println(s + (5 - i));
            s = s.replaceAll(" $", "");
        }

        for (int i = 5; i >= 0; i--) {
            System.out.println(" ".repeat(i) + (5 - i));
        }

        String s2 = "      ";

        for (int i = 0; i < 6; i++) {
            s2 = s2.replaceAll("^ ", "");
            System.out.println(s2 + i);
        }
    }
}

/*
 * Classe Letra
 */
class Letra {
    /**
     * Letra A:
     */
    public static void a() {
        System.out.println("x".repeat(3));
        System.out.println("x".repeat(2).replace("", " ").trim());
        System.out.println("x".repeat(3));
        System.out.println("x".repeat(2).replace("", " ").trim());
        System.out.println("x".repeat(2).replace("", " ").trim());
    }

    /**
     * Letra A e B:
     */
    public static void ab() {
        System.out.println("x".repeat(3) + " " + "x".repeat(3));
        System.out.println("x".repeat(2).replace("", " ").trim() + " " + "x" + " ".repeat(2) + "x");
        System.out.println("x".repeat(3) + " " + "x".repeat(3));
        System.out.println("x".repeat(2).replace("", " ").trim() + " " + "x" + " ".repeat(2) + "x");
        System.out.println("x".repeat(2).replace("", " ").trim() + " " + "x".repeat(3));
    }

    /**
     * Imprimindo meu nome:
     */
    public static void nome() {
        String l1 = (
        /* V */ "x".repeat(2).replace("", " ").trim() + " " +
        /* I */ " " + "x".repeat(2) + " ".repeat(2) +
        /* T */ "x".repeat(3) + " " +
        /* O */ "x".repeat(3) + " " +
        /* R */ "x".repeat(3) + " ");

        String l2 = (
        /* V */ "x".repeat(2).replace("", " ").trim() + " " +
        /* I */ " " + "x".repeat(2) + " ".repeat(2) +
        /* T */ " " + "x" + " ".repeat(2) +
        /* O */ "x".repeat(2).replace("", " ").trim() + " " +
        /* R */ "x".repeat(2).replace("", " ").trim());

        String l3 = (
        /* V */ "x".repeat(2).replace("", " ").trim() + " " +
        /* I */ " " + "x".repeat(2) + " ".repeat(2) +
        /* T */ " " + "x" + " ".repeat(2) +
        /* O */ "x".repeat(2).replace("", " ").trim() + " " +
        /* R */ "x".repeat(3));

        String l4 = (
        /* V */ "x".repeat(2).replace("", " ").trim() + " " +
        /* I */ " " + "x".repeat(2) + " ".repeat(2) +
        /* T */ " " + "x" + " ".repeat(2) +
        /* O */ "x".repeat(2).replace("", " ").trim() + " " +
        /* R */ "x");

        String l5 = (
        /* V */ "x".repeat(2).replace("", " ").trim() + " " +
        /* I */ " " + "x".repeat(2) + " ".repeat(2) +
        /* T */ " " + "x" + " ".repeat(2) +
        /* O */ "x".repeat(2).replace("", " ").trim() + " " +
        /* R */ "x".repeat(2));

        String l6 = (
        /* V */ " " + "x" + " ".repeat(2) +
        /* I */ " " + "x".repeat(2) + " ".repeat(2) +
        /* T */ " " + "x" + " ".repeat(2) +
        /* O */ "x".repeat(3) + " " +
        /* R */ "x".repeat(2).replace("", " ").trim());

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);
        System.out.println(l4);
        System.out.println(l5);
        System.out.println(l6);
    }
}

/**
 * Calculadora
 */
class Calculadora {
    public static void calculadora(String expressao) {
        // Removendo espaços da expressão
        expressao = expressao.trim().replaceAll(" ", "");

        StringBuilder sb = new StringBuilder(expressao);
        String numeros[] = sb.toString().split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))|(?=[+*/-])|(?<=[+*/-])");

        // Verificando se contém parenteses e resolvendo
        String conta = "";
        int op = 0;

        if (sb.toString().contains("(")) {
            // Pegando o index dos parenteses pra resolver a conta
            int indexInicio = expressao.lastIndexOf("(");
            int indexFinal = expressao.indexOf(")", indexInicio) + 1;

            conta = expressao.substring(indexInicio, indexFinal);
            String elementos[] = conta.toString().split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))|(?=[+*/-])|(?<=[+*/-])");

            if (elementos.length > 5) {
                if (conta.contains("*") && op == 0)
                    op = Arrays.asList(numeros).indexOf("*");

                if (conta.contains(("/")) && op == 0)
                    op = Arrays.asList(numeros).indexOf("/");

                if (conta.contains(("+")) && op == 0)
                    op = Arrays.asList(numeros).indexOf("+");

                if (conta.contains(("-")) && op == 0)
                    op = Arrays.asList(numeros).indexOf("-");

                indexInicio = conta.contains("(") ? op : op - 1;
                indexFinal = op + numeros[op - 1].length() - 1 + numeros[op + 1].length() + 1;
                conta = conta.substring(indexInicio, indexFinal);
            }

            sb.replace(indexInicio, indexFinal, calcular(conta));

            // System.out.println(sb);

            numeros = sb.toString().split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))|(?=[+*/-])|(?<=[+*/-])");

            if (numeros.length > 1) {
                calculadora(sb.toString());
            } else {
                System.out.println(sb.toString());
            }

            return;
        }

        if (!sb.toString().contains("(")) {
            if (sb.toString().contains("*") && op == 0)
                op = Arrays.asList(numeros).indexOf("*");

            if (sb.toString().contains(("/")) && op == 0)
                op = Arrays.asList(numeros).indexOf("/");

            if (sb.toString().contains(("+")) && op == 0)
                op = Arrays.asList(numeros).indexOf("+");

            if (sb.toString().contains(("-")) && op == 0)
                op = Arrays.asList(numeros).indexOf("-");

            int indexInicio = op - 1;
            int indexFinal = op + numeros[op - 1].length() - 1 + numeros[op + 1].length() + 1;
            conta = expressao.substring(indexInicio, indexFinal);

            sb.replace(indexInicio, indexFinal, calcular(conta));
            // System.out.println(sb);

            numeros = sb.toString().split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))|(?=[+*/-])|(?<=[+*/-])");

            if (numeros.length > 1)
                calculadora(sb.toString());
            else {
                System.out.println(sb.toString());
                return;
            }
        }
    }

    public static String calcular(String calculo) {
        // Separando a string em um array de números
        String numeros[] = calculo.split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))|(?=[+*/-])|(?<=[+*/-])");
        int resultado = 0;

        if (calculo.contains("*")) {
            // Definindo a posição do operador e números
            int op = Arrays.asList(numeros).indexOf("*");
            int num1 = Integer.parseInt(numeros[op - 1]);
            int num2 = Integer.parseInt(numeros[op + 1]);

            // Calculando o resultado
            return Integer.toString(resultado = num1 * num2);
        }

        if (calculo.contains("/")) {
            // Definindo a posição do operador e números
            int op = Arrays.asList(numeros).indexOf("/");
            int num1 = Integer.parseInt(numeros[op - 1]);
            int num2 = Integer.parseInt(numeros[op + 1]);

            // Calculando o resultado
            return Integer.toString(resultado = num1 / num2);
        }

        if (calculo.contains("+")) {
            // Definindo a posição do operador e números
            int op = Arrays.asList(numeros).indexOf("+");
            int num1 = Integer.parseInt(numeros[op - 1]);
            int num2 = Integer.parseInt(numeros[op + 1]);

            // Calculando o resultado
            return Integer.toString(resultado = num1 + num2);
        }

        if (calculo.contains("-")) {
            // Definindo a posição do operador e números
            int op = Arrays.asList(numeros).indexOf("-");
            int num1 = Integer.parseInt(numeros[op - 1]);
            int num2 = Integer.parseInt(numeros[op + 1]);

            // Calculando o resultado
            return Integer.toString(resultado = num1 - num2);
        }

        return Integer.toString(resultado);
    }
}