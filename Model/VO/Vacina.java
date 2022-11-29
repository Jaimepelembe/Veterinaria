package Model.VO;

import Model.DAO.ExceptionDAO;
import Model.DAO.Historico_ExameDAO;
import Model.DAO.VacinaDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

public class Vacina {
    private int idVacina,idVeterinaria;
    private String marca, nome,especie;
    private Date data;//data de validade
    private float quantidade, preco;// Quantidade ml , preco de aquisicao

    public Vacina() {
    }

    public Vacina(int idVacina, int idVeterinaria, String marca, String nome, String especie, Date data, float quantidade, float preco) {
        this.idVacina = idVacina;
        this.idVeterinaria = idVeterinaria;
        this.marca = marca;
        this.nome = nome;
        this.especie = especie;
        this.data = data;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Vacina(String marca, String nome, String especie, Date data, float preco,float quantidade) {
        this.marca = marca;
        this.nome = nome;
        this.especie = especie;
        this.data = data;
        this.preco = preco;
        this.quantidade=quantidade;
    }
    
    
    
    public void cadastrarVacina(Vacina vacina) throws SQLException, ClassNotFoundException, ExceptionDAO{
    new VacinaDAO().cadastrarVacina(vacina);
    }
  public Vector<Vacina> pesquisarVacinaMarca(String marca) throws ClassNotFoundException, ExceptionDAO {
  return new  VacinaDAO().pesquisarVacinaMarca(marca);
    }
  
  public Vector<Vacina> pesquisarVacinaNome(String nome) throws ClassNotFoundException, ExceptionDAO {
  return new  VacinaDAO().pesquisarVacinaNome(nome);
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
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
