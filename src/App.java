public class App {
    public static void main(String[] args) throws Exception {
        // Piramide.direita();
        // Piramide.direitaInversa();
        // Piramide.esquerda();
        // Piramide.esquerdaInversa();

        // Letra.a();
        // Letra.ab();
        // Letra.nome();

        Calculadora.calculadora("(4 + 7) / (10 * 10)");
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
        String s = "";

        for (int i = 5; i >= 0; i--) {
            System.out.println(s + i);
            s += (char) 32;
        }
    }

    public static void esquerdaInversa() {
        String s = "      ";

        for (int i = 0; i < 6; i++) {
            s = s.replaceAll("^ ", "");
            System.out.println(s + i);
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

/*
 * Classe calculadora
 */
class Calculadora {
    public static void calculadora(String ex) {
        String[] partes = ex.trim().replaceAll(" ", "")
                .split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))|(?=[+*/-])|(?<=[+*/-])");

        // Exibir as partes resultantes
        for (String parte : partes) {
            if (!parte.isEmpty()) { // Verifica se a parte não está vazia
                System.out.println(parte);
            }
        }

        int indexOp = 0;
        int indexInicio = 0;
        int indexFim = 0;

        StringBuilder sb = new StringBuilder(ex.trim().replaceAll(" ", ""));

        for (int index = 0; index < ex.length(); index++) {
            if ((partes[index].equals("*") && !partes[index + 1].equals("(")) ||
                    (partes[index].equals("/") && !partes[index + 1].equals("("))) {

                /**
                 * Pegar o inicio
                 */
                for (int parenteses = 0; parenteses < partes.length; parenteses++) {
                    if (partes[parenteses].equals("("))
                        indexInicio = parenteses;

                    if (partes[parenteses].equals(")"))
                        indexFim = parenteses;
                }

                indexOp = index;

                int num1 = Integer.parseInt(partes[index - 1]);
                int num2 = Integer.parseInt(partes[index + 1]);
                int resultado = partes[index].equals("*") ? num1 * num2 : num1 / num2;

                System.out.println(sb.replace(indexInicio, indexFim, Integer.toString(resultado)));
                System.out.println(resultado);

                // if (partes[index - 1].length() > 1 && partes[index + 1].length() > 1)
                // sb.replace(index - 2, index + 2, Double.toString(resultado));

                // System.out.println(resultado);
                // System.out.println(sb);

                break;
            }
        }
    }
}