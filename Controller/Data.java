/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Date;
import java.time.Instant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author multi
 */
public class Data implements  Datas{
    public Data() {
       
    }
 public Date dataActual(){
     LocalDate date= LocalDate.now();
     Date data= Date.valueOf(date);//Retorna a data no padrao Mysql
 return data;}
 
    public static void main(String[] args) {
      
    }

    @Override
    public Date StringtoSqlDate(String data) {
    data=data.substring(6, 10)+"-"+data.substring(3, 5)+"-"+data.substring(0,2); //Converter para padrao da BD YYYY-MM-dd
     Date  datasql=(Date.valueOf(data)) ;
    return datasql;}

    @Override
    public String SqlDatetoString(Date data) {
        LocalDate date= data.toLocalDate();
     DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd-MM-yyyy");//Converter para padrao do usuario  dd-MM-YYYY
     
     String datastr=""+dtf.format(date); 
    
   return datastr;}

    @Override
    public int calcularIdade(Date dataNasci) {
        LocalDate dataActual=LocalDate.now();
        int idade= dataActual.getYear()- dataNasci.toLocalDate().getYear();
        
    return idade;}
    

}
