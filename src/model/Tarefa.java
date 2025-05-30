package model;

public class Tarefa {

    private int id;
    private String descricao;
    private Prioridade prioridade;
    private boolean concluida;

    public Tarefa() {
    }

    public Tarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Tarefa(int id, String descricao, Prioridade prioridade, boolean concluida) {
        this.id = id;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return this.prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public boolean getConcluida() {
        return this.concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public enum Prioridade {
        BAIXA, MEDIA, ALTA;
    }

    public void exibirTarefa() {
        if (concluida) {
            System.out.println("[X] " + getDescricao() + " (" + getPrioridade() + ")" + " |" + getId() + "|");
        } else {
            System.out.println("[ ] " + getDescricao() + " (" + getPrioridade() + ")" + " |" + getId() + "|");
        }
    }
}