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
            System.out.println("Tarefa com ID " + idParaRemover + " não encontrada.");
        }
    }

    public void marcarConcluida(Scanner sc) {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("Não há tarefa para ser marcada como concluída!");
            return;
        }

        System.out.print("Digite o ID da tarefa concluída:");
        int idTarefaConcluida = sc.nextInt();

        Tarefa tarefaConcluida = null;

        for (Tarefa tarefa : listaDeTarefas) {
            if (tarefa.getId() == idTarefaConcluida) {
                tarefaConcluida = tarefa;
                break;
            }
        }

        if (tarefaConcluida != null) {
            tarefaConcluida.setConcluida(true);
            System.out.println("Tarefa marcada como concluída: ");
            System.out.println(tarefaConcluida);
        } else {
            System.out.println("Tarefa com ID " + idTarefaConcluida + " não encontrada.");
        }
    }

    public void editarTarefa(Scanner sc) {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("Não há tarefa para editar!");
            return;
        }

        System.out.print("Digite o ID da tarefa que você deseja editar: ");
        int idTarefaEditar = sc.nextInt();

        Tarefa tarefaEditar = null;

        for (Tarefa tarefa : listaDeTarefas) {
            if (tarefa.getId() == idTarefaEditar) {
                tarefaEditar = tarefa;
                break;
            }
        }

        if (tarefaEditar != null) {
            System.out.println("O que deseja editar?");
            System.out.println("1 - Descrição");
            System.out.println("2 - Prioridade");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.println("Digite a nova descrição: ");
                String novaDescricao = sc.nextLine();
                tarefaEditar.setDescricao(novaDescricao);
            } else if (opcao == 2) {
                System.out.println("Digite a nova prioridade (BAIXA, MEDIA, ALTA): ");
                String novaPrioridade = sc.nextLine().toUpperCase();

                try {
                    Tarefa.Prioridade prioridade = Tarefa.Prioridade.valueOf(novaPrioridade);
                    tarefaEditar.setPrioridade(prioridade);
                    System.out.println("Prioridade atualizada com sucesso.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Valor inválido. Prioridades válidas: BAIXA, MÉDIA, ALTA.");

                }
            } else {
                System.out.println("Opção inválida.");
            }

            System.out.println("Tarefa atualizada: ");
            System.out.println(tarefaEditar);

        } else {
            System.out.println("Tarefa com ID " + idTarefaEditar + " não encontrada.");
        }
    }
}