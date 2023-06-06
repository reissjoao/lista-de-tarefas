public class Tarefa {
    private String descricao;
    private boolean concluido;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluido = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean estaConcluido() {
        return concluido;
    }

    public void marcarComoConcluido() {
        concluido = true;
    }

    public void marcarComoNaoConcluido() {
        concluido = false;
    }
}
