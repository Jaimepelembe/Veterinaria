/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.VO;

import Controller.AnimalController;
import Model.DAO.AnimalDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ExceptionDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;

/**
 *
 * @author multi
 */
public class Animal {
private int idAnimal,idCliente,idVeterinaria;
private String nome,especie,raca,cor_pelo;
private String sexo;
private float peso;
private Date dt_nascimento;

public Animal() {
    }

public Animal(int idAnimal, int idCliente, int idVeterinaria, String nome, String especie, String raca, String cor_pelo, float peso,Date date, String sexo) {
        this.idAnimal = idAnimal;
        this.idCliente = idCliente;
        this.idVeterinaria = idVeterinaria;
        this.peso = peso;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.cor_pelo = cor_pelo;
        this.dt_nascimento = date;
        this.sexo = sexo;
    }

//construtor para cadastrar animal BD
    public Animal( String nome, String especie, String sexo,String raca, String cor_pelo, float peso, Date dt_nascimento,int idCliente, int idVeterinaria) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.cor_pelo = cor_pelo;
        this.sexo = sexo;
        this.peso = peso;
        this.dt_nascimento = dt_nascimento;
        this.idCliente = idCliente;
        this.idVeterinaria = idVeterinaria;
    }


//Metodo que recebe o animal da controller e passa para DAO
public void cadastrarAnimal(Animal animal) throws SQLException, ClassNotFoundException, ExceptionDAO{
new AnimalDAO().cadastrarAnimal(animal);
}

 public void actualizarAnimal(Animal animal) throws SQLException, ClassNotFoundException, ExceptionDAO{
new AnimalDAO().actualizarAnimal(animal);
} 
 
public void apagarAnimal(Animal animal)  throws SQLException, ClassNotFoundException, ExceptionDAO{
new AnimalDAO().apagarAnimal(animal);
} 

public Vector<Cliente> selecionarCliente() throws SQLException, ClassNotFoundException, ExceptionDAO{
return  new AnimalController().selecionarCliente();
}

public Vector<Animal> pesquisarAnimalEspecie(String especie) throws ClassNotFoundException, ExceptionDAO {
return new AnimalDAO().pesquisarAnimalEspecie(especie);
        }

public Vector<Animal> pesquisarAnimalRaca(String raca) throws ClassNotFoundException, ExceptionDAO {
return new AnimalDAO().pesquisarAnimalRaca(raca);
        }

public Vector<Animal> pesquisarAnimalNome(String nome) throws ClassNotFoundException, ExceptionDAO {
return new AnimalDAO().pesquisarAnimalNome(nome);
        }

public Vector<Animal> pesquisarAnimalRelatorio() throws ClassNotFoundException, ExceptionDAO {
return new AnimalDAO().pesquisarAnimalRelatorio();
        }
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor_pelo() {
        return cor_pelo;
    }

    public void setCor_pelo(String cor_pelo) {
        this.cor_pelo = cor_pelo;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

  

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

  

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Animal{" + "idAnimal=" + idAnimal + ", idCliente=" + idCliente + ", idVeterinaria=" + idVeterinaria + ", nome=" + nome + ", especie=" + especie + ", raca=" + raca + ", cor_pelo=" + cor_pelo + ", sexo=" + sexo + ", peso=" + peso + ", dt_nascimento=" + dt_nascimento + '}';
    }



}
