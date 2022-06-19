import model.Colaborador;
import service.GeradorService;

import java.util.List;


public class Gerador {
    public static void main(String[] args) {
        GeradorService geradorService = new GeradorService();
        List<Colaborador> colaboradores = geradorService.cadastrarColaboradores();
        colaboradores.forEach(System.out::println);
    }
}
