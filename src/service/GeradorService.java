package service;

import util.ColaboradorUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class GeradorService {

    public void comecar(){
        Set<String> colaboradores = this.getColaboradores();
        this.gerarLogins(colaboradores);

    }

    private void gerarLogins(Set<String> colaboradores) {
        ColaboradorUtil colaboradorUtil = new ColaboradorUtil();

        colaboradores.forEach(colaborador -> {
            colaboradorUtil.criarLogin(colaborador);
        });
    }

    private Set<String> getColaboradores() {
        Set<String> nomes = new HashSet<String>();
        String path = "src/repository/Massa de Dados.txt";

        File massaDeDados = new File(path);

        if(massaDeDados.exists()){
            try {
                FileReader fileReader = new FileReader(massaDeDados);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while(true){
                    String nome = bufferedReader.readLine();
                    if(nome == null){
                        return nomes;
                    }
                    nomes.add(nome);
                }
            }catch (Exception e){
                System.out.println("Houve um problema durante a leitura do arquivo");
            }
        }
        return null;
    }
}
