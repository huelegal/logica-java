/**
 * Calculadora
 */
class Calculadora {
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
class Teste {
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
