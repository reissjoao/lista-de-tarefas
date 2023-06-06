import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ListaDeAfazeres listaDeAfazeres = new ListaDeAfazeres();

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            imprimirMenu();
            int escolha = getEscolhaDoUsuario();

            switch (escolha) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    marcarTarefasComoConcluidas();
                    break;
                case 3:
                    marcarTarefasComoNaoConcluidas();
                    break;
                case 4:
                    removerTarefa();
                    break;
                case 5:
                    imprimirTarefas();
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Encerrando o programa...");
    }

    private static void imprimirMenu() {
        System.out.println("\n===== Lista de Tarefas =====");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Marcar tarefa como concluída");
        System.out.println("3. Marcar tarefa como pendente");
        System.out.println("4. Remover tarefa");
        System.out.println("5. Exibir tarefas");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int getEscolhaDoUsuario() {
        return scanner.nextInt();
    }

    private static void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        scanner.nextLine(); // Consumir a nova linha pendente após a leitura do número
        String descricao = scanner.nextLine();

        Tarefa tarefa = new Tarefa(descricao);
        listaDeAfazeres.adicionarTarefa(tarefa);
        System.out.println("\nTarefa adicionada com sucesso!");
    }

    private static void marcarTarefasComoConcluidas() {
        System.out.print("Digite o número da tarefa a ser marcada como concluída: ");
        int numeroDaTarefa = scanner.nextInt();

        List<Tarefa> tarefas = listaDeAfazeres.getTarefas();
        if (numeroDaTarefa >= 1 && numeroDaTarefa <= tarefas.size()) {
            Tarefa tarefa = tarefas.get(numeroDaTarefa - 1);
            tarefa.marcarComoConcluido();
            System.out.println("\nTarefa marcada como concluída!");
        } else {
            System.out.println("\nNúmero de tarefa inválido!");
        }
    }

    private static void marcarTarefasComoNaoConcluidas() {
        System.out.print("Digite o número da tarefa a ser marcada como pendente: ");
        int numeroDaTarefa = scanner.nextInt();

        List<Tarefa> tarefas = listaDeAfazeres.getTarefas();
        if (numeroDaTarefa >= 1 && numeroDaTarefa <= tarefas.size()) {
            Tarefa tarefa = tarefas.get(numeroDaTarefa - 1);
            tarefa.marcarComoConcluido();
            System.out.println("\nTarefa marcada como pendente!");
        } else {
            System.out.println("\nNúmero de tarefa inválido!");
        }
    }

    private static void removerTarefa() {
        System.out.print("Digite o número da tarefa a ser removida: ");
        int numeroDaTarefa = scanner.nextInt();

        List<Tarefa> tarefas = listaDeAfazeres.getTarefas();
        if (numeroDaTarefa >= 1 && numeroDaTarefa <= tarefas.size()) {
            Tarefa tarefa = tarefas.get(numeroDaTarefa - 1);
            listaDeAfazeres.removerTarefa(tarefa);
            System.out.println("\nTarefa removida com sucesso!");
        } else {
            System.out.println("\nNúmero de tarefa inválido!");
        }
    }

    private static void imprimirTarefas() {
        List<Tarefa> tarefas = listaDeAfazeres.getTarefas();

        if (tarefas.isEmpty()) {
            System.out.println("\nNão há tarefas na lista.");
        } else {
            System.out.println("\n===== Tarefas =====");
            for (int i = 0; i < tarefas.size(); i++) {
                Tarefa tarefa = tarefas.get(i);
                String status = tarefa.estaConcluido() ? "[Concluída]" : "[Pendente]";
                System.out.println((i + 1) + ". " + status + " " + tarefa.getDescricao());
            }
            System.out.println("===================");
        }
    }
}