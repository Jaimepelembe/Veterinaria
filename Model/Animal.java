/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.AnimalDAO;
import DAO.ExceptionDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author multi
 */
public class Animal {
private int idAnimal,idCliente,idVeterinaria;
private String nome,especie,raca,cor_pelo;
private char sexo;
private float peso;
private String dt_nascimento;

public Animal() {
    }

public Animal(int idAnimal, int idCliente, int idVeterinaria, String nome, String especie, String raca, String cor_pelo, float peso,String date, char sexo) {
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
    public Animal( String nome, String especie, char sexo,String raca, String cor_pelo, float peso, String dt_nascimento,int idCliente, int idVeterinaria) {
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

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    
   
  
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }



}
