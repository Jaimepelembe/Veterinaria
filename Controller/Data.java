/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author multi
 */
public class Data {
 private String data;

    public Data() {
        dataActual();
    }
 public String dataActual(){
     LocalDateTime date= LocalDateTime.now();
     DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
     
     String data=""+dtf.format(date);
        System.out.println(data);
 return this.data;}
 
    public static void main(String[] args) {
        new Data();
        
    }
}