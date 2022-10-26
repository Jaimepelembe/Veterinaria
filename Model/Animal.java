/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author multi
 */
public class Animal {
private int idAnimal,idCliente,idVeterinaria;
private String nome,especie,raca,cor_pelo,dt_nascimento;
private char sexo;
private float peso;

public Animal() {
    }

public Animal(int idAnimal, int idCliente, int idVeterinaria, float peso, String nome, String especie, String raca, String cor_pelo, String dt_nascimento, char sexo) {
        this.idAnimal = idAnimal;
        this.idCliente = idCliente;
        this.idVeterinaria = idVeterinaria;
        this.peso = peso;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.cor_pelo = cor_pelo;
        this.dt_nascimento = dt_nascimento;
        this.sexo = sexo;
    }

}
