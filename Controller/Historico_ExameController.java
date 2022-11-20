/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ExceptionDAO;
import Model.VO.Exame;
import Model.VO.Historico_Exame;
import java.sql.SQLException;

/**
 *
 * @author multi
 */
public class Historico_ExameController {
 
public boolean cadastrarExame(int idAnimal,int idExame,String data,String resultado,String observacao) throws SQLException, ClassNotFoundException, ExceptionDAO {
    
    Validacao vv = new Validacao();
        if (vv.validaID(idExame)&& vv.validaID(idAnimal) && vv.validarString(data) && vv.validarString(resultado)) {
           Historico_Exame historico= new Historico_Exame();
            historico.setIdAnimal(idAnimal);
            historico.setIdExame(idExame);
            historico.setData(data);
            historico.setResultado(resultado);
            historico.setObservacao(observacao);
            historico.CadastrarHistorico(historico);
            return true;
        }
        return false;
    }
    
    
    
}
