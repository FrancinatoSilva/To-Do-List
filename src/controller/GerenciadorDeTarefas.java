package controller;

import model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GerenciadorDeTarefas {
    private List<Tarefa> listaDeTarefas; //Atributo da classe

    public GerenciadorDeTarefas() {
        this.listaDeTarefas = new ArrayList<>(); //Construtor que instância a lista como ArrayList
    }

    public void adicionarTarefa(String descricao) {
        Random random = new Random();
        int id;

        while (true) {
            id = random.nextInt(100);
            boolean idExiste = false;

            for (Tarefa tarefa : listaDeTarefas) {
                if (tarefa.getId() == id) {
                    idExiste = true;
                    break;
                }
            }

            if (!idExiste) break;
        }

        Tarefa nova = new Tarefa(id, descricao);
        listaDeTarefas.add(nova);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    public void listarTarefas() {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("Não há tarefa armazenada!");
            return;
        }
        for (Tarefa tarefa : listaDeTarefas) {
            tarefa.exibirTarefa();
        }
    }

    public void removerTarefa(Scanner sc) {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("Não há tarefas para remover!");
            return;
        }

        System.out.println("Digite o ID da tarefa a ser removida: ");
        int idParaRemover = sc.nextInt();

        Tarefa tarefaParaRemover = null;

        for (Tarefa tarefa : listaDeTarefas) {
            if (tarefa.getId() == idParaRemover) {
                tarefaParaRemover = tarefa;
                break;
            }
        }

        if (tarefaParaRemover != null) {
            listaDeTarefas.remove(tarefaParaRemover);
            System.out.println("Tarefa removida com sucesso!");
        } else {
            System.out.println("Tarefa com ID " + idParaRemover + "não encontrada.");
        }
    }
}