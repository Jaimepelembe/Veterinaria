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
import java.sql.Date;
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


  public boolean VerificarValidade(Date validade){
      LocalDate date= LocalDate.now();
      Date dataActual=Date.valueOf(date);
     
      if(validade.compareTo(dataActual)>0 ){//A data de validade e maior que a actual
      return true;
      }
      return false;
  }
 
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