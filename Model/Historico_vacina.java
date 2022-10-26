package Model;

/**
 *
 * @author multi
 */
public class Historico_vacina {
private int idAnimal,idVacina;
private float preco;
private String data, observacao;//A data refere-se a data de realizacao ,deve ser gerada automaticamente

    public Historico_vacina() {
    }

    public Historico_vacina(int idAnimal, int idVacina, float preco, String data, String observacao) {
        this.idAnimal = idAnimal;
        this.idVacina = idVacina;
        this.preco = preco;
        this.data = data;
        this.observacao = observacao;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }


    
}
