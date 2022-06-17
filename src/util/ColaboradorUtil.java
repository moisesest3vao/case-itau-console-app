package util;

import model.Colaborador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ColaboradorUtil {
    private static List<String> historicoLogins = new ArrayList<>();
    private static String expressaoRegular = "(\\w)(\\s+)(DO|DA|DE|DOS|DAS)(\\s+)(\\w)";

    public Colaborador criarLogin(String nome){
        String nomeSemElementos = this.removeElementosDeLigacao(nome);
        String[] nomes = nomeSemElementos.split(" ");
        String identificador = this.criaIdentificador(nomes);

        return new Colaborador(nome, identificador);
    }

    public String criaIdentificador(String[] nomes){

        String login = this.montaLogin(nomes);


        historicoLogins.add(login);
        return login;
    }

    private String montaLogin(String[] nomes){
        String parte1 = null;
        String parte2 = null;
        int nomesCount = nomes.length;
        boolean validaLogin = true;
        int contador = 0;

        while(validaLogin){
            if(contador > 3000){
                throw new RuntimeException("Não é possível gerar um usuário dinamicamente com este nome");
            }

            Random random = new Random();
            int aux = random.nextInt(((nomesCount - 1)) + 1);
            int aux2 = random.nextInt(((nomesCount - 1)) + 1);

            if(nomes[aux].length() >=4){
                parte1 = nomes[aux].substring(0,4);
                if(nomes[aux2].length() >= 3){
                    parte2 = nomes[aux2].substring(0,3);
                }
            }
            String login = parte1+parte2;
            validaLogin = this.verificaRepeticaoOuIgualdade(login);

            contador++;
        }

        return parte1+parte2;
    }

    private String removeElementosDeLigacao(String nome) {
        return nome.toUpperCase().replaceAll(expressaoRegular, "$1 $5");
    }

    private boolean verificaRepeticaoOuIgualdade(String identificador) {
        return historicoLogins.stream().anyMatch( login -> {
            return Objects.equals(login, identificador) || identificador.substring(0, 3).equals(identificador.substring(4, 7));
        });
    }
}
