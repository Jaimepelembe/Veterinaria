package Model.VO;

import Model.DAO.ExceptionDAO;
import Model.DAO.Historico_ExameDAO;
import Model.DAO.VacinaDAO;
import java.sql.Date;
import java.sql.SQLException;

public class Vacina {
    private int idVacina,idVeterinaria;
    private String marca, nome;
    private Date data;//data de validade
    private float quantidade, preco;// Quantidade ml , preco de aquisicao

    public Vacina() {
    }

    public Vacina(int idVacina, int idVeterinaria, String marca, String nome,Date data, float quantidade, float preco) {
        this.idVacina = idVacina;
        this.idVeterinaria = idVeterinaria;
        this.marca = marca;
        this.nome = nome;
        this.data = data;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    
    
    public void cadastrarHistorico(Vacina vacina) throws SQLException, ClassNotFoundException, ExceptionDAO{
    new VacinaDAO().cadastrarVacina(vacina);
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
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

    @Override
    public String toString() {
        return "Vacina{" + "idVacina=" + idVacina + ", idVeterinaria=" + idVeterinaria + ", marca=" + marca + ", nome=" + nome + ", data=" + data + ", quantidade=" + quantidade + ", preco=" + preco + '}';
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
}
