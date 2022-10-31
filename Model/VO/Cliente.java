package Model.VO;

import Model.DAO.AnimalDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ExceptionDAO;
import java.sql.SQLException;

public class Cliente {
private int idCliente,idVeterinaria;
private String nome,telefone, morada;

    public Cliente() {
    }

    public Cliente(int idCliente, int idVeterinaria, String nome, String telefone, String morada) {
        this.idCliente = idCliente;
        this.idVeterinaria = idVeterinaria;
        this.nome = nome;
        this.telefone = telefone;
        this.morada = morada;
    }

    public Cliente(String nome, String telefone, String morada) {
        this.nome = nome;
        this.telefone = telefone;
        this.morada = morada;
    }
    
 public void cadastrarCliente(Cliente cliente) throws SQLException, ClassNotFoundException, ExceptionDAO{
new ClienteDAO().cadastrarCliente(cliente);
} 

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVeterinaria() {
        return idVeterinaria;
    }

    public void setIdVeterinaria(int idVeterinaria) {
        this.idVeterinaria = idVeterinaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", idVeterinaria=" + idVeterinaria + ", nome=" + nome + ", telefone=" + telefone + ", morada=" + morada + '}';
    }


}