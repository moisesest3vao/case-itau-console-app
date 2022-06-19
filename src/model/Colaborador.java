package model;

public class Colaborador {
    private String login;
    private String nome;

    public Colaborador(String nome, String login) {
        this.login = login;
        this.nome = nome;
    }

    public String getId() {
        return login;
    }

    public void setId(String id) {
        this.login = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "===============================\nNome: "+nome+"\nLogin: "+login+"\n===============================";
    }
}
