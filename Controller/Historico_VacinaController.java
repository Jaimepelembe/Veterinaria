/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ExameDAO;
import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
import Model.VO.Historico_Exame;
import Model.VO.Historico_vacina;
import Model.VO.Vacina;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author multi
 */
public class Historico_VacinaController {
public Vector<Vacina> receberVacinas(String especie) throws ClassNotFoundException, SQLException, ExceptionDAO{
  Vector<Vacina> vacinas=new Historico_vacina().receberVacinas(especie);
    
  float preco=0;
  for(int i=0; i<vacinas.size();i++){
  preco=vacinas.elementAt(i).getPreco()+(vacinas.elementAt(i).getPreco())*((float)0.2);//O preco da vacina e igual ao preco de compra mais 20% desse preco
  vacinas.elementAt(i).setPreco(preco);
  }
    
return vacinas;
}

 
public boolean cadastrarVacinacao(int idAnimal,int idVacina,float preco,String data,String observacao) throws SQLException, ClassNotFoundException, ExceptionDAO {
    
    Validacao vv = new Validacao();
        if (vv.validaID(idVacina)&& vv.validaID(idAnimal) && vv.validarString(data) && preco>0 &&vv.validarString(observacao)) {
           Historico_vacina historico=new Historico_vacina();
            historico.setIdAnimal(idAnimal);
            historico.setIdVacina(idVacina);
            historico.setData(data);
            historico.setObservacao(observacao);
            historico.setPreco(preco);
            historico.CadastrarHistorico(historico);
            return true;
        }
        return false;
    }


  
}
