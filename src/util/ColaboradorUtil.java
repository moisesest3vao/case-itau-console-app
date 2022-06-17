package util;

import model.Colaborador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ColaboradorUtil {
    private static List<String> historicoLogins = new ArrayList<>();
    private static int tamanhoLogin = 7;
    private static String expressaoRegular = "(\\w)(\\s+)(DO|DA|DE|DOS|DAS)(\\s+)(\\w)";

    public Colaborador criarLogin(String nome){

        String nomeSemElementos = this.removeElementosDeLigacao(nome.toUpperCase());

        String[] nomes = nomeSemElementos.split(" ");

        String identificador = this.criaIdentificador(nomes);

        return new Colaborador(nome, identificador);
    }

    public String criaIdentificador(String[] nomes){
        String parte1 = null;
        String parte2 = null;

        if(nomes[0].length() >=4){
            parte1 = nomes[0].substring(0,4);
            if(nomes[1].length() >= 3){
                parte2 = nomes[1].substring(0,3);
            }
        }

        if(this.verificaRepeticao(parte1+parte2)){
            if(nomes[1].length() >=4){
                parte1 = nomes[1].substring(0,4);
                if(nomes[0].length() >= 3){
                    parte2 = nomes[0].substring(0,3);
                }
            }
            historicoLogins.add(parte1+parte2);
            return parte1+parte2;
        }else {
            historicoLogins.add(parte1+parte2);
            return parte1+parte2;
        }
    }

    private boolean verificaRepeticao(String identificador) {
        return historicoLogins.stream().anyMatch( login -> {
            return Objects.equals(login, identificador);
        });
    }

    private String removeElementosDeLigacao(String nomeUpperCase) {
        String nomeSemElementos = nomeUpperCase.replaceAll(expressaoRegular, "$1 $5");
        return nomeSemElementos;
    }
}
