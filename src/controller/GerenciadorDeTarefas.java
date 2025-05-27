package controller;

import model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {
    private List<Tarefa> listaDeTarefas; //Atributo da classe

    public GerenciadorDeTarefas() {
        this.listaDeTarefas = new ArrayList<>(); //Construtor que instância a lista como ArrayList
    }

    public void adicionarTarefa(String descricao) {
        int id = listaDeTarefas.size() + 1;
        Tarefa nova = new Tarefa(id, descricao);
        listaDeTarefas.add(nova);
        System.out.println("Tarefa adicionada com sucesso!");
    }

}