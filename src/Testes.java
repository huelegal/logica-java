/**
 * Calculadora
 */
class Calculadora0 {
    public static void calculadora(String expressao) {

    }

    public static void parenteses(String expressao) {

        // (4 + 7) / (2 + 5)

        String[] contas = expressao.replaceAll(" ", "").replaceFirst("^[(]", "").split("[()]");

        double[] numeroDouble = new double[contas.length * 2];
        String[] operadoresDouble = new String[contas.length * 2];

        int indexNumero = 0, indexOperador = 0;

        for (String conta : contas) {
            /*
             * Separa a conta atual entre operadores e números para poder realizar o cálculo
             */
            String[] numeros = conta.split("[+*/-]");
            String[] operadores = conta.replaceAll("[0-9]", "").split("");

            // Se for um número, insere no array de números como double
            for (String numero : numeros)
                if (numero.matches("[0-9]"))
                    numeroDouble[indexNumero++] = Double.parseDouble(numero);

            // Se for um operador, insere no array de operadores
            for (String operador : operadores)
                if (operador.matches("[+*/-]"))
                    operadoresDouble[indexOperador++] = operador;
        }

        // Calculando resultado
        double resultado = numeroDouble[0];

        for (int index = 0; index < indexOperador; index++) {
            String operador = operadoresDouble[index];
            double proximoNumero = numeroDouble[index + 1];

            if (operador.equals("*"))
                resultado *= proximoNumero;

            if (operador.equals("/"))
                resultado /= proximoNumero;

            if (operador.equals("-"))
                resultado -= proximoNumero;

            if (operador.equals("+"))
                resultado += proximoNumero;

            numeroDouble[index] = resultado;
        }

        for (Double numero : numeroDouble)
            System.out.println(numero);
    }
}

/**
 * Calculadora backup
 */
class Calculadora1 {
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

/*
 * Classe calculadora
 */
class Calculadora2 {
    public static void calculadora(String ex) {
        ex = ex.trim().replaceAll(" ", "");

        String[] partes = ex.trim().replaceAll(" ", "")
                .split("(?<=\\()|(?=\\()|(?<=\\))|(?=\\))|(?=[+*/-])|(?<=[+*/-])");

        // Exibir as partes resultantes
        for (String parte : partes) {
            if (!parte.isEmpty()) { // Verifica se a parte não está vazia
                System.out.println(parte);
            }
        }

        int indexOp = 0;
        int resultado = 0;
        int index = 0;

        StringBuilder sb = new StringBuilder(ex.trim().replaceAll(" ", ""));

        while (ex.contains("(")) {
            if ((partes[index].equals("*") && !partes[index + 1].equals("(")) ||
                    (partes[index].equals("/") && !partes[index + 1].equals("("))) {

                // Procurar parênteses mais próximos ao redor da operação
                int indexInicio = sb.lastIndexOf("(", sb.indexOf(partes[index - 1]));
                int indexFim = sb.indexOf(")", sb.indexOf(partes[index + 1])) + 1;

                indexOp = index;

                int num1 = Integer.parseInt(partes[index - 1]);
                int num2 = Integer.parseInt(partes[index + 1]);
                resultado = partes[index].equals("*") ? num1 * num2 : num1 / num2;

                System.out.println(sb.replace(indexInicio, indexFim, Integer.toString(resultado)));

                index++;

                if (sb.toString().contains(".*[+\\-*/].*")) {
                    index = 0;
                    calculadora(sb.toString());
                } else {
                    System.out.println(resultado);
                }
            } else if ((partes[index].equals("+") && !partes[index + 1].equals("(")) ||
                    partes[index].equals("-") && !partes[index + 1].equals("(")) {

                // Procurar parênteses mais próximos ao redor da operação
                int indexInicio = sb.lastIndexOf("(", sb.indexOf(partes[index - 1]));
                int indexFim = sb.indexOf(")", sb.indexOf(partes[index + 1])) + 1;

                indexOp = index;

                int num1 = Integer.parseInt(partes[index - 1]);
                int num2 = Integer.parseInt(partes[index + 1]);
                resultado = partes[index].equals("+") ? num1 + num2 : num1 - num2;

                System.out.println(sb.replace(indexInicio, indexFim, Integer.toString(resultado)));

                index++;

                if (sb.toString().contains(".*[+\\-*/].*")) {
                    index = 0;
                    calculadora(sb.toString());
                } else {
                    System.out.println(resultado);
                }
            }

            index++;
        }
    }
}