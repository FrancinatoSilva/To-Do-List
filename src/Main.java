import controller.GerenciadorDeTarefas;
import model.Tarefa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GerenciadorDeTarefas gerenciadorDeTarefas = new GerenciadorDeTarefas();
        Tarefa tarefa = new Tarefa();

        int opcaoDesejada = 0;
        do {
            gerenciadorDeTarefas.exibirMenu();

            while (true) {
                try {
                    System.out.print("Opção desejada:");
                    if (sc.hasNextInt()) {
                        opcaoDesejada = sc.nextInt();
                        break;
                    } else {
                        System.out.println("INSIRA UM NÚMERO INTEIRO");
                        sc.next(); // Limpa o scanner removendo o caractere inválido
                    }
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro. Insira um número inteiro.");
                    sc.next();
                }
            }

                Tarefa.Prioridade prioridade = null;

                switch (opcaoDesejada) {
                    case 1:
                        sc.nextLine();
                        System.out.print("Digite a descrição da tarefa: ");
                        String descricao = sc.nextLine();

                        while (prioridade == null) {
                            System.out.print("Digite a prioridade (BAIXA, MEDIA, ALTA): ");
                            String input = sc.nextLine().toUpperCase();

                            try {
                                prioridade = Tarefa.Prioridade.valueOf(input);
                                System.out.println("Você escolheu: " + prioridade);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Prioridade inválida. Digite BAIXA, MEDIA ou ALTA.");
                            }
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
        }while (opcaoDesejada != 6) ;

        sc.close();
    }
}