package Controller;

import Model.DAO.AnimalDAO;
import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
import Model.VO.Cliente;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;

/**
 *
 * @author multi
 */
public class AnimalController {

    public AnimalController() {
    }
    //Metodo que recebe dados da view e passa para o model   

    public boolean cadastrarAnimal(String nome, String especie, String sexo, String raca, String pelo, float peso, String dt_nascimentO, int idCli, int idVet) throws SQLException, ClassNotFoundException, ExceptionDAO {
        Validacao vv = new Validacao();
        if (vv.validarString(nome) && vv.validarString(sexo) && vv.validarString(especie) && vv.validarString(raca) && vv.validarString(pelo) && vv.validarPeso(peso) && vv.validaeID(idVet) && vv.validaeID(idCli)) {
            Animal animal = new Animal(nome, especie, sexo, raca, pelo, peso, dt_nascimentO, idCli, idVet);
            animal.cadastrarAnimal(animal);
            return true;
        }
        return false;
    }

    public Vector<Cliente> selecionarCliente() throws SQLException, ClassNotFoundException, ExceptionDAO {

        return new AnimalDAO().selecionarCliente();
    }

    public Vector<Animal> pesquisarAnimalEspecie(String especie) throws ClassNotFoundException, ExceptionDAO {
        return new Animal().pesquisarAnimalEspecie(especie);
    }

    public Vector<Animal> pesquisarAnimalRaca(String Raca) throws ClassNotFoundException, ExceptionDAO {
        return new Animal().pesquisarAnimalRaca(Raca);
    }
    
    public Vector<Animal> pesquisarAnimalNome(String nome) throws ClassNotFoundException, ExceptionDAO {
        return new Animal().pesquisarAnimalNome(nome);
    }
}
