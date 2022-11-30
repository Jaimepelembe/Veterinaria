package View;

import Controller.Datas;
import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
import Model.VO.Exame;
import java.awt.BorderLayout;
import Controller.Data;
import Controller.ExameController;
import Controller.Historico_CirurgiaController;
import Controller.Historico_ExameController;
import Model.VO.Cirurgia;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.plaf.multi.MultiTableHeaderUI;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;

public class telaCirurgia implements ActionListener {

    private JLabel lab, preco, data, codAnimal;
    private JButton bSalvar, bLimpar, bCancelar;
    // private JFormattedTextField fPreco, fData;
    private JComboBox cbAnimais, CbCirurgia;
    private JFrame frame;
    private JPanel painel, pPrincipal, pBotoes;
    private GridBagConstraints gbc = new GridBagConstraints();
    private JTextField fObservacao;
    private JRadioButton rbcao, rbgato;
    private ButtonGroup botoes;
    private int idCirurgia = -1, idAnimal = -1;
    private float precoCirurgia;
    // private Vector<Animal> vectorAnimais;
    private Vector<Cirurgia> vectorCirurgias;
    private Vector<Animal> vectorAnimais;
    private String[] resultados = { "Positivo", "Negativo" };

    public telaCirurgia() throws SQLException, ClassNotFoundException, ExceptionDAO {
        inicializar();
        //criarJanela();
    }

    public void inicializar() {
        // Cores dos botoes
        Color corSalvar = new Color(0.05f, 0.72f, 0.08f, 1.0f);
        Color corLimpar = new Color(0.05f, 0.31f, 0.72f, 1.0f);

        // Radio Button da Especie do animal e vacina
        // Radio Button Cao
        botoes = new ButtonGroup();
        rbcao = new JRadioButton("Canina");
        rbcao.setBackground(Color.WHITE);
        rbcao.addActionListener(this);
        botoes.add(rbcao);

        // Radio Button Gato
        rbgato = new JRadioButton("Felina");
        rbgato.setBackground(Color.WHITE);
        rbgato.addActionListener(this);
        botoes.add(rbgato);

        // ComBoboxes
        CbCirurgia = new JComboBox();
        CbCirurgia.addActionListener(this);
        cbAnimais = new JComboBox();
        cbAnimais.addActionListener(this);
        cbAnimais.setSelectedIndex(-1);

        //Labes
        codAnimal = new JLabel();
        preco = new JLabel();
        codAnimal = new JLabel();
        
        // TextField observacao
        fObservacao = new JTextField();
        fObservacao.setColumns(10);
       
       
   

        // Botoes
        // Salvar
        bSalvar = new JButton("Salvar");
        bSalvar.setForeground(Color.white);
        bSalvar.setBackground(corSalvar);

        bSalvar.setBorderPainted(false);
        bSalvar.setFocusPainted(false);
        bSalvar.addActionListener(this);

        // Eliminar
        bLimpar = new JButton("Limpar");
        bLimpar.setForeground(Color.white);
        bLimpar.setBackground(corLimpar);
        bLimpar.setBorderPainted(false);
        bLimpar.addActionListener(this);
        bLimpar.setFocusPainted(false);
        bLimpar.addActionListener(this);

        // Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar.setForeground(Color.white);
        bCancelar.setBackground(Color.red);
        bCancelar.setBorderPainted(false);
        bCancelar.addActionListener(this);
        bCancelar.setFocusPainted(false);
        bCancelar.addActionListener(this);

        
    }
 //Metodos para adicao dos componentes nos paines
    public Container painelComponentes() throws SQLException, ClassNotFoundException, ExceptionDAO {
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Informacoes da especie do animal e vacina
        // Especie
        lab = new JLabel("Especie");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        painel.add(lab, gbc);

        // Radio Button da Especie
        // Canina
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(rbcao, gbc);

        // Radio Button da Especie Felina
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(rbgato, gbc);

        // Informacoes do animal
        lab = new JLabel("Animal");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(lab, gbc);
        // Combobox Animal
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(cbAnimais, gbc);
        // Label id
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(codAnimal, gbc);
        // Label do idAnimal
        
         gbc.insets = new Insets(35, 5, -27, 0);
         gbc.gridx = 1;
         gbc.gridy = 2;
         gbc.ipadx = 60;
         gbc.ipady = 8;
         painel.add(codAnimal, gbc);
      

        // Informacoes
        lab = new JLabel("Cirurgia");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 10;
        gbc.ipady = 10;
        painel.add(lab, gbc);

        // Combobox
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        painel.add(CbCirurgia, gbc);
        // Label preco
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 4;
        painel.add(preco, gbc);

        // Informacoes da observacao
        lab = new JLabel("Observacao");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.ipady=5;
        painel.add(lab, gbc);
        // field
        gbc.insets = new Insets(35, 5, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        
        gbc.ipady = 10;
        painel.add(fObservacao, gbc);
        gbc.gridwidth = 1;
        return painel;
    }

    public Container painelBotoes() {
        JPanel pBotoes = new JPanel();
        pBotoes.setBackground(Color.white);
        pBotoes.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(35, 5, 0, 0);
        gbc.ipady = 2;
        gbc.ipadx = 2;
        // add buttons to the panel
        gbc.gridy = 0;
        gbc.gridx = 1;
        pBotoes.add(bSalvar, gbc);
        gbc.gridx = 2;
        pBotoes.add(bLimpar, gbc);
        gbc.gridx = 4;
        pBotoes.add(bCancelar, gbc);
        return pBotoes;
    }

    public Container pPrincipal() throws SQLException, ClassNotFoundException, ExceptionDAO {
        JPanel pPrincipal = new JPanel(new BorderLayout());
        pPrincipal.add(painelComponentes(), BorderLayout.NORTH);
        pPrincipal.add(painelBotoes(), BorderLayout.CENTER);
        pPrincipal.setBackground(Color.white);

        return pPrincipal;
    }

    // Metodo para receber todos animais da BD pela especie
    private void receberAnimaisEspecie(String especie) throws SQLException, ClassNotFoundException, ExceptionDAO {
        vectorAnimais = new Historico_CirurgiaController().selecionarAnimais(especie);
        cbAnimais.removeAllItems();// Remover todos os itens do combobox
        for (int i = 0; i < vectorAnimais.size(); i++) {
            this.cbAnimais.addItem(vectorAnimais.elementAt(i).getNome());
        }
        
    }

    // Metodo para receber todas cirurgias realizadas na Veterinaria
    private void receberCirurgias() throws SQLException, ClassNotFoundException, ExceptionDAO {
        vectorCirurgias = new Historico_CirurgiaController().selecionarCirurgias();
        CbCirurgia.removeAllItems();// Remover todos os itens do combobox
        for (int i = 0; i < vectorCirurgias.size(); i++) {
            this.CbCirurgia.addItem(vectorCirurgias.elementAt(i).getNome());
        }
    }

    // Metodo para selecionar o id da cirurgia a ser realizada
    private void selecionarIdCirurgia(int indice) {
        idCirurgia = vectorCirurgias.elementAt(indice).getIdCirurgia();
    }

    private void Limpar() {
        CbCirurgia.setSelectedIndex(-1);
        cbAnimais.setSelectedIndex(-1);
        fObservacao.setText("");
        preco.setText("");
        codAnimal.setText("");

    }
   
//Metodo para voltar ao icon principal da tela  
   public void colocarIconMenu() {
        Menu_Principal a = new Menu_Principal("");
        a.iconPrincipal();
        a.mudarCor();
    }

     public void cadastrarHistoricoCirurgia() throws SQLException, ClassNotFoundException, ExceptionDAO{
     boolean sucesso;
   
     Historico_CirurgiaController historico= new Historico_CirurgiaController();
     Data data= new Data();//Instancia da classe data para gerar a data actual do sistema
     Date date=data.dataActual();
     String observacao= fObservacao.getText();
    
     sucesso=historico.cadastrarHistorico(idAnimal, idCirurgia, date, observacao, precoCirurgia);
     if(sucesso){
     JOptionPane.showMessageDialog(null, "O Historico da cirurgia foi cadastrado com sucesso");
     }
     else{JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o historico");
     }
    
     }
     //Metodo para selecionar o id do animal escolhido
    private void selecionarIdAnimal(int indice){
    idAnimal=vectorAnimais.elementAt(indice).getIdAnimal();
    codAnimal.setText(" ID: "+idAnimal);
    
   
    }
     //Metodo para calcular o preco da cirurgia do animal escolhido
    public void calcularprecoCirurgia(int indice){
     //Calcular o preco que o animal deve pagar
    
    this.precoCirurgia=new Historico_CirurgiaController().calcularPreco(vectorAnimais.elementAt(indice));
    this.preco.setText("Preco: "+precoCirurgia);
    }
    
    
     

    public void criarJanela() throws SQLException, ClassNotFoundException, ExceptionDAO {
        frame = new JFrame("Cirurgia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(530, 550);
        frame.add(pPrincipal());
        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ExceptionDAO {
        new telaCirurgia();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bSalvar){
            try {
                cadastrarHistoricoCirurgia();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "O Houve um erro ao cadastrar o historico cirurgia"+ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "O Houve um erro ao cadastrar o historico cirurgia"+ex);
            } catch (ExceptionDAO ex) {
                JOptionPane.showMessageDialog(null, "O Houve um erro ao cadastrar o historico cirurgia"+ex);
            }
        
        }
        
        if (e.getSource() == bLimpar) {
            Limpar();
        }
        
        if(e.getSource()==bCancelar){
        colocarIconMenu();
        }
        
        //Eventos do radio Button Cao
        if (e.getSource() == rbcao) {
            String especie = "Canina";
            try {
                // Receber animais da BD
                receberAnimaisEspecie(especie);

                this.CbCirurgia.removeAllItems();// Remover e inserir a cirurgia
                receberCirurgias();
               

            }  catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "O Houve um erro ao receber os animais"+ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "O Houve um erro ao receber os animais"+ex);
            } catch (ExceptionDAO ex) {
                JOptionPane.showMessageDialog(null, "O Houve um erro ao receber os animais"+ex);
            }
        }
        
        //Eventos do radio Button Gato
        if (e.getSource() == rbgato) {
            String especie = "Felina";
            try {
                receberAnimaisEspecie(especie);// Receber animais da BD
                
                // Remover e inserir a cirurgia
                this.CbCirurgia.removeAllItems();
                receberCirurgias();
                
            }  catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "O Houve um erro ao receber os animais"+ex);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "O Houve um erro ao receber os animais"+ex);
            } catch (ExceptionDAO ex) {
                JOptionPane.showMessageDialog(null, "O Houve um erro ao receber os animais"+ex);
            }
        }
        
        //Eventos de selecao do Id do animal 
        if(e.getSource()==cbAnimais ){
            int indice=cbAnimais.getSelectedIndex();
            if(indice>-1){
            selecionarIdAnimal(indice);
            calcularprecoCirurgia(indice);
            }
        }
        
        //Eventos de selecao do Id do Cirurgia
        if(e.getSource()==CbCirurgia && CbCirurgia.isShowing()){
            int id=CbCirurgia.getSelectedIndex();
            if(id>-1){
                selecionarIdCirurgia(id);
            }
        
        }

    }

}
