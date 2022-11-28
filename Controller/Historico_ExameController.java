/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ExceptionDAO;
import Model.DAO.Historico_ExameDAO;
import Model.VO.Exame;
import Model.VO.Historico_Exame;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author multi
 */
public class Historico_ExameController {
 
public boolean cadastrarExame(int idAnimal,int idExame,int idHistorico,Date data,String resultado,String observacao) throws SQLException, ClassNotFoundException, ExceptionDAO {
    
    Validacao vv = new Validacao();
        if (vv.validaID(idExame)&& vv.validaID(idAnimal) && vv.validaID(idHistorico) && data!=null && vv.validarString(resultado)) {
           Historico_Exame historico= new Historico_Exame();
            historico.setIdAnimal(idAnimal);
            historico.setIdExame(idExame);
            historico.setIdHistorico(idHistorico);
            historico.setData(data);
            historico.setResultado(resultado);
            historico.setObservacao(observacao);
            historico.CadastrarHistorico(historico);
            return true;
        }
        return false;
    }
public int selecionaridHistorico() throws SQLException, ClassNotFoundException, ExceptionDAO{
   int id=new Historico_Exame().selecionaridHistorico();
    if(id>0){
       id++;}
    else{id=1;};
    
    return id;
}    
    
    
}
