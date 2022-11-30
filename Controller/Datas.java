/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

import java.sql.Date;

/**
 *
 * @author multi
 */
public interface Datas {
public abstract Date dataActual();  
public abstract Date StringtoSqlDate(String data);
public abstract String SqlDatetoString(Date data);
public abstract int calcularIdade(Date dataNasci);
//public abstract Date javaDatetoSqlDate(Date data);
//
}

