/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author multi
 */
public class Validacao {
public boolean validarString(String msg){
if( msg!="" && msg.length()>0 ){
return true;
}
return false;
}

public boolean validarSexo(char msg){
    if(msg=='F'|| msg=='M'){
        return true;
    }
    return false;
}
public boolean  validarPeso(float peso){
if(peso>0 && peso<=120){
return true;
}
return false;
}
public boolean validaID(int id){
if(id>0){return true;}
return false;}

 public Date StringToDate (String data){
    
    String[] partesData=data.split("/");
    int ano=Integer.parseInt(partesData[2]);
    int mes= Integer.parseInt(partesData[1]);
    int dia= Integer.parseInt(partesData[0]);
    
     Date date= new Date(ano, mes, dia);
    return date;
  }
 
 public String DateToString(Date data){
    //LocalDate dat=data;
    Date dat= data;
    SimpleDateFormat formato= new SimpleDateFormat("dd-MM-yyyy");//Ano, mes, dia
    
    //Converter String para date
     String date=formato.format(dat);//Converte Local date para String
 return date;
 }
 
 public float StringToFloat(String valor){
     float numero=0;
 try{
 numero=Float.parseFloat(valor);
 }catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "Erro de conversao"+ex);}
 
 return numero;}
 
 public int StringToIntger(String valor){
     int numero=0;
 try{
 numero=Integer.parseInt(valor);
 }catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "Erro de conversao"+ex);}
 
 return numero;}
 
  public byte StringToByte(String valor){
     byte numero=0;
 try{
 numero=Byte.parseByte(valor);
 }catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "Erro de conversao"+ex);}
 
 return numero;}
 
//public boolean validarDataActual (Date data){
//   // LocalDateTime dat=LocalDateTime.parse("20/20/2000");
//    Date date=new java.sql.Date(2022, 10, 10);
//    System.out.println(date);
//    if(data.after(data)){
//        return true;
// 
//    }
//return false;
//}
   


}