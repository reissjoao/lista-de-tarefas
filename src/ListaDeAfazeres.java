import java.util.ArrayList;
import java.util.List;

public class ListaDeAfazeres {
    private List<Tarefa> tarefas;

    public ListaDeAfazeres() {
        tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}
