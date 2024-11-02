public class App {
    public static void main(String[] args) throws Exception {
        // Piramide.direita();
        // Piramide.direitaInversa();
        // Piramide.esquerda();
        // Piramide.esquerdaInversa();

        // Letra.a();
        // Letra.ab();
        // Letra.nome();

        Calculadora.calculadora("(3 + 3) / (2 + 1)");
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

class Calculadora {
    public static void calculadora(String expressao) {
        // Removendo os espaços em branco e os parenteses
        expressao = expressao.replaceAll(" ", "").replaceAll("[()]", "");

        // Obtendo os números e operadores com split
        String[] numeros = expressao.split("[+*/-]");
        /*
         * Primeiro remove os números, depois da split nos espaços vazios. Isso evita
         * com que existam índices vázios no array
         */
        String[] operadores = expressao.replaceAll("[0-9]", "").split("");

        for (String s : numeros)
            System.out.println(s);

        for (String s : operadores)
            System.out.println(s);
    }
}