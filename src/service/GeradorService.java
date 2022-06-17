package service;

import model.Colaborador;
import util.ColaboradorUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GeradorService {

    public void comecar(){
        List<String> nomes = this.getColaboradores();
        List<Colaborador> colaboradores = this.gerarLogins(nomes);

        colaboradores.forEach(System.out::println);
    }

    private List<Colaborador> gerarLogins(List<String> nomes) {
        ColaboradorUtil colaboradorUtil = new ColaboradorUtil();
        return nomes.stream().map(colaboradorUtil::criarLogin).toList();
    }

    private List<String> getColaboradores() {
        List<String> nomes = new ArrayList<>();
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
