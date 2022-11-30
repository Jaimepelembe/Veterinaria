/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ExameDAO;
import Model.DAO.ExceptionDAO;
import Model.DAO.Historico_CirurgiaDAO;
import Model.VO.Animal;
import Model.VO.Cirurgia;
import Model.VO.Exame;
import Model.VO.Historico_Cirurgia;
import Model.VO.Historico_Exame;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author multi
 */
public class Historico_CirurgiaController {
    
  
    
  
public boolean cadastrarHistorico(int idAnimal,int idCirurgia,Date data,String observacao,float preco) throws SQLException, ClassNotFoundException, ExceptionDAO {
    
       Validacao vv = new Validacao();
        if (vv.validaID(idAnimal)&& vv.validaID(idCirurgia)  && data!=null) {
           Historico_Cirurgia historico= new Historico_Cirurgia();
            historico.setIdAnimal(idAnimal);
            historico.setIdCirurgia(idCirurgia);
            historico.setData(data);
            historico.setObservacao(observacao);
            historico.setPreco(preco);
            historico.cadastrarHistorico(historico);
            return true;
        }
        return false;
    }   
    
 
 public Vector<Animal>selecionarAnimais(String especie) throws SQLException, ClassNotFoundException, ExceptionDAO{
 
 return new Historico_Cirurgia().selecionarAnimais(especie);
 }
 
 public Vector<Cirurgia> selecionarCirurgias() throws SQLException, ClassNotFoundException, ExceptionDAO{
 
 return new Historico_Cirurgia().selecionarCirurgias();}
 
 //Metodo para calcular o preco da Cirurgia
 public float calcularPreco(Animal animal){
     
 int idade=new Data().calcularIdade(animal.getDt_nascimento());
 float peso=animal.getPeso();
 
 //Veriricar a porcentagem que o animal vai pagar
 //o preco base e 1600mts
if(idade<=1 && peso<=20){

 return 1600+ 1600*15/100;   //15%
}
else 
{
 if(idade<=3 && peso <=30){
 return 1600+ 1600*25/100;   //25%

   }
   else {
        return 1600+ 1600*35/100;//35%
   }


}
  
   

}
   
    
}
