package Model.VO;

public class Vacina {
    private int idVacina,idVeterinaria;
    private String marca, nome, data;//data de validade
    private float quantidade, preco;// Quantidade ml , preco de aquisicao

    public Vacina() {
    }

    public Vacina(int idVacina, int idVeterinaria, String marca, String nome, String data, float quantidade, float preco) {
        this.idVacina = idVacina;
        this.idVeterinaria = idVeterinaria;
        this.marca = marca;
        this.nome = nome;
        this.data = data;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }

    public int getIdVeterinaria() {
        return idVeterinaria;
    }

    public void setIdVeterinaria(int idVeterinaria) {
        this.idVeterinaria = idVeterinaria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
}
