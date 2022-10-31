/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

/**
 *
 * @author multi
 */
import java.lang.invoke.MethodHandles;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionBD {

    private String Host, BD, user, password, porta;

    //Classe que faz conexao entre O banco de dados e a DAO
    public ConnectionBD() {
        this.Host = "localhost";
        this.porta = "3306";
        this.BD = "veterinaria";
        this.user = "root";
        this.password = "";

    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Carregar Driver Sql
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            ConnectionBD conexao = new ConnectionBD();
            con = DriverManager.getConnection("jdbc:mysql://" + conexao.Host + ":" + conexao.porta + "/" + conexao.BD + "?user="+conexao.user+"&password="+conexao.password+"&noAccessToProcedureBodies=true");
        } catch (SQLException ex) {ex.printStackTrace();
        }
        return con;}

    public void fecharConexao(PreparedStatement pstate, Connection con) throws ExceptionDAO {
        try {
            if (pstate != null) {
                pstate.close();
            }
        } catch (SQLException ex) {
            throw new ExceptionDAO("Erro ao fechar preparedStatement: " + ex);
        }

        try {
            if (con != null) {
                con.close();

            }
        } catch (SQLException ex) {
            throw new ExceptionDAO("Erro ao fechar a connection ");
        }
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String Host) {
        this.Host = Host;
    }

    public String getBD() {
        return BD;
    }

    public void setBD(String BD) {
        this.BD = BD;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }
}
