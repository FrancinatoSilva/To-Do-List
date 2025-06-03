package view;

import controller.GerenciadorDeTarefas;

import java.util.Scanner;

public class ConsoleView {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GerenciadorDeTarefas gerenciadorDeTarefas = new GerenciadorDeTarefas();

        int opcaoDesejada;
        do {
            gerenciadorDeTarefas.exibirMenu();
            System.out.print("Opção desejada:");
            opcaoDesejada = sc.nextInt();

            switch (opcaoDesejada) {
                case 1:

            }

            if (opcaoDesejada < 1 || opcaoDesejada >= 6) {
                System.out.println("OPÇÃO INVÁLIDA!");
            }
        } while (opcaoDesejada < 1 || opcaoDesejada >= 6);

        sc.close();
    }
}
