package view;

import controller.GerenciadorDeTarefas;
import model.Tarefa;

import java.util.Scanner;

public class ConsoleView {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GerenciadorDeTarefas gerenciadorDeTarefas = new GerenciadorDeTarefas();
        Tarefa tarefa = new Tarefa();

        int opcaoDesejada;
        do {
            gerenciadorDeTarefas.exibirMenu();
            System.out.print("Opção desejada:");
            opcaoDesejada = sc.nextInt();

            Tarefa.Prioridade prioridade = null;

            switch (opcaoDesejada) {
                case 1:
                    sc.nextLine();
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = sc.nextLine();
                    System.out.print("Digite a prioridade (BAIXA, MEDIA, ALTA): ");
                    String input = sc.nextLine().toUpperCase();

                    try {
                        prioridade = Tarefa.Prioridade.valueOf(input);
                        System.out.println("Você escolheu: " + prioridade);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Prioridade inválida. Tente novamente.");
                    }

                    gerenciadorDeTarefas.adicionarTarefa(descricao, prioridade);
                    break;
                case 2:
                    gerenciadorDeTarefas.listarTarefas();
                    break;
                case 3:
                    gerenciadorDeTarefas.removerTarefa(sc);
                    break;
                case 4:
                    gerenciadorDeTarefas.marcarConcluida(sc);
                    break;
                case 5:
                    gerenciadorDeTarefas.editarTarefa(sc);
                    break;
                case 6:
                    System.out.println("Encerrando execução...");
                    return;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");

            }
            System.out.println("------------------------------------------------");
        } while (opcaoDesejada != 6);

        sc.close();
    }
}