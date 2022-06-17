package util;

import java.util.List;

public class ColaboradorUtil {
    private static List<String> historicoLogins;
    private static int tamanhoLogin = 7;
    private static String expressaoRegular = "(\\w)(\\s+)(DO|DA|DE|DOS|DAS)(\\s+)(\\w)";

    public void criarLogin(String nome){

        String nomeSemElementos = this.removeElementosDeLigacao(nome.toUpperCase());
        System.out.println(nomeSemElementos);
    }

    private String removeElementosDeLigacao(String nomeUpperCase) {
        String nomeSemElementos = nomeUpperCase.replaceAll(expressaoRegular, "$1 $5");
        System.out.println(nomeSemElementos);
        return nomeSemElementos;
    }
}
