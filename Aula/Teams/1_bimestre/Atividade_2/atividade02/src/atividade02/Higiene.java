package atividade02;

public class Higiene extends Produto {
    private String uso;

    public Higiene(String descricao, float preco, String uso) {
        super(descricao, preco);
        this.uso = uso;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  Higiene [Uso: " + uso + "]";
    }
}