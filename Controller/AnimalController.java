package Controller;

import DAO.ExceptionDAO;
import Model.Animal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author multi
 */
public class AnimalController {

    public AnimalController() {
    }
 //Metodo que recebe dados da view e passa para o model   
 public boolean cadastrarAnimal(String nome, String especie,char sexo, String raca, String pelo,float peso, String dt_nascimentO,int idCli,int idVet) throws SQLException, ClassNotFoundException, ExceptionDAO {
Validacao vv= new Validacao();
if(vv.validarString(nome)){//&vv.validarSexo(sexo) && vv.validarString(especie)&&vv.validarString(raca)&& vv.validarString(pelo) &&vv.validarPeso(peso)&& vv.validaeID(idVet)&& vv.validaeID(idCli
 Animal animal = new Animal(nome, especie, sexo, raca, pelo, peso, dt_nascimentO, idCli, idVet);
 animal.cadastrarAnimal(animal);
 return true;
 }
 return false;
 }  
    
}
