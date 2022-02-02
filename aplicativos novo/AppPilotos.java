package aplicativos;

import java.io.IOException;
import java.util.Scanner;

import aplicativos.classes.Pessoa;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        Pessoa[] arrayTemp = new Pessoa[MAX_ELEMENTOS];
        int MAX_ELEMENTOS_NOVO = MAX_ELEMENTOS;

        do {

            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            // (qtdCadastrados == MAX_ELEMENTOS
            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (MAX_ELEMENTOS == MAX_ELEMENTOS_NOVO) {
                    if (qtdCadastrados == MAX_ELEMENTOS) {
                        System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                        voltarMenu(in);
                        continue;
                    }
                } else {
                    if (qtdCadastrados == MAX_ELEMENTOS_NOVO) {
                        System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                        voltarMenu(in);
                        continue;
                    }
                }
                // Cadastre seu piloto aqui

                System.out.println("Digite o nome");
                String nome = in.nextLine();

                System.out.println("Digite o CPF");
                String cpf = in.nextLine();

                Pessoa pessoas = new Pessoa(nome, cpf);
                pilotos[qtdCadastrados] = pessoas;

                qtdCadastrados++;

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);

            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui

                System.out.println("Lista de pilotos cadastrados:");
                for (int i = 0; i < qtdCadastrados; i++) {
                    System.out.printf("Nome: %s CPF: %s\n", pilotos[i].getNome(), pilotos[i].getCpf());
                }

                voltarMenu(in);
            } else if (opcao == 3) {
                System.out.println("Informe o CPF do cadastrado: ");
                String cpfDigitado = in.nextLine();
                for (int i = 0; i < qtdCadastrados; i++) {
                    if (cpfDigitado.equals(pilotos[i].getCpf())) {
                        System.out.println("O piloto referente ao CPF digitado é " + pilotos[i].getNome());
                        i = qtdCadastrados + 1;
                    } else {
                        System.out.println("Cpf não encontrado");
                    }

                    voltarMenu(in);
                }
            } else if (opcao == 4) {
                System.out.println("Digite o novo tamanho do armazenamento");
                int valorDigitado = in.nextInt();

                if (valorDigitado > MAX_ELEMENTOS_NOVO) {
                    MAX_ELEMENTOS_NOVO = valorDigitado;

                    arrayTemp = new Pessoa[MAX_ELEMENTOS_NOVO];
                    for (int i = 0; i < pilotos.length; i++) {
                        arrayTemp[i] = pilotos[i];
                    }

                    pilotos = new Pessoa[MAX_ELEMENTOS_NOVO];
                    for (int i = 0; i < arrayTemp.length; i++) {
                        pilotos[i] = arrayTemp[i];

                        System.out.println("O tamanho atual do array foi atualizado com sucesso");

                    }
                    voltarMenu(in);
                } else {
                    System.out.println("O tamanho informado é menor que o tamanho atual");
                }

            } else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}