package br.edu.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        List<String> celulares = new ArrayList<>();
        List<String> emails = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        boolean continuar = true;

        System.out.println("==============================");
        System.out.println("       AGENDA DE CONTATOS");
        System.out.println("           V.0.2.0");
        System.out.println("==============================");
        System.out.println("Bem-vindo!");

        while (continuar) {

            System.out.println();
            System.out.println("========== MENU ==========");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Listar contatos");
            System.out.println("3 - Procurar contato");
            System.out.println("4 - Excluir contato");
            System.out.println("5 - Sair");
            System.out.println("===========================");

            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {

                    System.out.println("\n--- ADICIONAR CONTATO ---");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Celular: ");
                    String celular = sc.nextLine();

                    System.out.print("E-mail: ");
                    String email = sc.nextLine();

                    nomes.add(nome);
                    celulares.add(celular);
                    emails.add(email);

                    System.out.println("\nContato salvo com sucesso!");
                }

                case 2 -> {

                    System.out.println("\n--- LISTA DE CONTATOS ---");

                    if (nomes.isEmpty()) {

                        System.out.println("Nenhum contato cadastrado.");

                    } else {

                        for (int i = 0; i < nomes.size(); i++) {

                            System.out.println("\nContato " + (i + 1));
                            System.out.println("--------------------------");
                            System.out.println("Nome: " + nomes.get(i));
                            System.out.println("Celular: " + celulares.get(i));
                            System.out.println("E-mail: " + emails.get(i));
                        }
                    }
                }
                case 3 -> {

                    System.out.println("\n--- PROCURAR CONTATO ---");

                    System.out.print("Digite o nome: ");
                    String nomeBusca = sc.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < nomes.size(); i++) {

                        if (nomes.get(i).equalsIgnoreCase(nomeBusca)) {

                            System.out.println("\nContato encontrado!");
                            System.out.println("--------------------------");
                            System.out.println("Nome: " + nomes.get(i));
                            System.out.println("Celular: " + celulares.get(i));
                            System.out.println("E-mail: " + emails.get(i));

                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Contato não encontrado.");
                    }
                }
                case 4 -> {

                    System.out.println("\n--- EXCLUIR CONTATO ---");

                    if (nomes.isEmpty()) {

                        System.out.println("Nenhum contato cadastrado.");

                    } else {

                        System.out.print("Digite o nome do contato: ");
                        String nomeExcluir = sc.nextLine();

                        int indiceExcluir = -1;

                        for (int i = 0; i < nomes.size(); i++) {

                            if (nomes.get(i).equalsIgnoreCase(nomeExcluir)) {
                                indiceExcluir = i;
                                break;
                            }
                        }

                        if (indiceExcluir == -1) {

                            System.out.println("Contato não encontrado.");

                        } else {

                            nomes.remove(indiceExcluir);
                            celulares.remove(indiceExcluir);
                            emails.remove(indiceExcluir);

                            System.out.println("Contato excluído com sucesso!");
                        }
                    }
                }

                case 5 -> {

                    System.out.println("\nEncerrando a agenda...");
                    System.out.println("Obrigado por utilizar!");

                    continuar = false;
                }
                default -> {

                    System.out.println("\nOpção inválida!");
                    System.out.println("Escolha uma opção entre 1 e 5.");
                }
            }
        }

        sc.close();
    }
}

