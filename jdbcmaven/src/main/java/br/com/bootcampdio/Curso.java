package br.com.bootcampdio;

public class Curso {

    private int id;
    private String nome;
    private int duracao;

    public Curso(int id, String nome, int duracao) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
    }

    public Curso(String nome, int duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getduracao() {
        return duracao;
    }

    public void setduracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Curso{");
        sb.append("id: ").append(id);
        sb.append(", nome: '").append(nome).append('\'');
        // sb.append(", duração: ").append(duracao);
        sb.append('}');
        return sb.toString();
    }

}
