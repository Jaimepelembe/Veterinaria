package Model.VO;

import Model.DAO.ExceptionDAO;
import Model.DAO.Historico_VacinaDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author multi
 */
public class Historico_vacina {
private int idAnimal,idVacina;
private float preco;
private String observacao;//A data refere-se a data de realizacao ,deve ser gerada automaticamente
private Date data;
    public Historico_vacina() {
    }

    public Historico_vacina(int idAnimal, int idVacina, float preco, Date data, String observacao) {
        this.idAnimal = idAnimal;
        this.idVacina = idVacina;
        this.preco = preco;
        this.data = data;
        this.observacao = observacao;
    }

    public void CadastrarHistorico(Historico_vacina historico) throws SQLException, ClassNotFoundException, ExceptionDAO{
   //new Historico_VacinaDAO().
    }
    public Vector<Vacina> receberVacinas(String especie) throws ClassNotFoundException, SQLException, ExceptionDAO{
    
    return new Historico_VacinaDAO().selecionarVacinas(especie);}
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(int idVacina) {
        this.idVacina = idVacina;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

   

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }


    
}
