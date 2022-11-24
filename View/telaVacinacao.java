package View;

import Controller.AnimalController;
import Controller.Data;
import Controller.ExameController;
import Controller.Historico_ExameController;
import Controller.Historico_VacinaController;
import Model.BO.Historico_VacinaBO;
import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
import Model.VO.Exame;
import Model.VO.Vacina;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.text.MaskFormatter;

public class telaVacinacao implements ActionListener {

    private JLabel lab, codAnimal, preco;
    private JButton bSalvar, bLimpar, bCancelar;
    private JComboBox cbAnimais, CbVacinas;
    private JTextField fObservacao;
    private JFrame frame;
    private JRadioButton rbcao,rbgato;
    private ButtonGroup botoes;
    private JPanel painel, pPrincipal, pBotoes;
    private GridBagConstraints gbc = new GridBagConstraints();
    private int idAnimal=-1, idVacina=-1;
    private float precoVacina;
    private String especie="";
    private Vector<Animal> vectorAnimais;
    private Vector<Vacina> vectorVacinas;


    public telaVacinacao() throws SQLException, ClassNotFoundException, ExceptionDAO {
        //criarJanela();
    }

    public void inicializar() throws SQLException, ClassNotFoundException, ExceptionDAO {
        //Radio Button da Especie do animal e vacina
          //Radio Button Cao
        botoes=new ButtonGroup();
          
        rbcao = new JRadioButton("Canina");
        rbcao.setBackground(Color.WHITE);
        rbcao.addActionListener(this);
        botoes.add(rbcao);
        
        
        //Radio Button Gato
        rbgato = new JRadioButton("Felina");
        rbgato.setBackground(Color.WHITE);
        rbgato.addActionListener(this);
        botoes.add(rbgato);
        
        //ComBoboxes
        CbVacinas = new JComboBox();
        CbVacinas.addActionListener(this);
        //CbVacinas.setSelectedIndex(-1);
        
        cbAnimais = new JComboBox();
        cbAnimais.addActionListener(this);
        //cbAnimais.setSelectedIndex(-1);
      
        
        //Labes
        codAnimal = new JLabel();
        preco = new JLabel();
        //TextField observacao
        fObservacao = new JTextField();
        fObservacao.setColumns(10);

        //recebertodosAnimais();

        //Botoes 
        //Salvar
        bSalvar = new JButton("Salvar");
        bSalvar.setForeground(Color.white);
        bSalvar.setBackground(Color.green);
        bSalvar.setBorderPainted(false);
        bSalvar.setFocusPainted(false);
        bSalvar.addActionListener(this);

        //Eliminar
        bLimpar = new JButton("Limpar");
        bLimpar.setForeground(Color.white);
        bLimpar.setBackground(Color.blue);
        bLimpar.setBorderPainted(false);
        bLimpar.addActionListener(this);
        bLimpar.setFocusPainted(false);
        bLimpar.addActionListener(this);

        //Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar.setForeground(Color.white);
        bCancelar.setBackground(Color.red);
        bCancelar.setBorderPainted(false);
        bCancelar.addActionListener(this);
        bCancelar.setFocusPainted(false);
        bCancelar.addActionListener(this);

    }

    public Container componentes() throws SQLException, ClassNotFoundException, ExceptionDAO {
        inicializar();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Informacoes da especie do animal e vacina
         //Especie
        lab = new JLabel("Especie");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        painel.add(lab, gbc);
        
        //Radio Button da Especie
        //Canina
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipadx = 20;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(rbcao, gbc);
        
        //Radio Button da Especie Felina
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.ipadx = 20;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(rbgato, gbc);
        
        
        
        //Informacoes do animal
        lab = new JLabel("Animal");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 20;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(lab, gbc);
        //Combobox Animal
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 40;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(cbAnimais, gbc);
        //Label do idAnimal
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 20;
        gbc.ipady = 8;
        painel.add(codAnimal, gbc);

        //Informacoes do exame
        lab = new JLabel("Vacina");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 40;
        gbc.ipady = 8;
        painel.add(lab, gbc);
        //Combobox
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        painel.add(CbVacinas, gbc);
        //Label preco telaExame
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 4;
        painel.add(preco, gbc);

        //Informacoes do resultado
        lab = new JLabel("Observacao");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipadx = 20;
        painel.add(lab, gbc);
        //Combobox
        gbc.insets = new Insets(35, 5,0, 0);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.ipadx=40;
        gbc.ipady=8;
        gbc.gridwidth = 1;
        painel.add(fObservacao, gbc);
        return painel;
    }

    public Container adicionarBotoes() {
        JPanel pBotoes = new JPanel();
        pBotoes.setBackground(Color.white);
        pBotoes.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.ipady = 2;
        gbc.ipadx = 2;
        // add buttons to the panel
        gbc.insets = new Insets(0, 0, 0, 45);
        gbc.gridy = 0;
        gbc.gridx = 1;
     
        pBotoes.add(bSalvar, gbc);
        gbc.gridx = 2;
        pBotoes.add(bLimpar, gbc);
         gbc.insets = new Insets(0, 0, 0, 45);
        gbc.gridx = 4;
        pBotoes.add(bCancelar, gbc);
        return pBotoes;
    }

    public Container pPrincipal() throws SQLException, ClassNotFoundException, ExceptionDAO {
        pPrincipal = new JPanel(new BorderLayout());
        pPrincipal.add(componentes(), BorderLayout.NORTH);
        pPrincipal.add(adicionarBotoes(), BorderLayout.CENTER);
        pPrincipal.setBackground(Color.white);

        return pPrincipal;
    }

    private void recebertodosAnimais() throws SQLException, ClassNotFoundException, ExceptionDAO {
        vectorAnimais = new ExameController().selecionarAnimais();
        for (int i = 0; i < vectorAnimais.size(); i++) {
            this.cbAnimais.addItem(vectorAnimais.elementAt(i).getNome());
        }
        
    }
    private void receberAnimaisEspecie(String especie) throws SQLException, ClassNotFoundException, ExceptionDAO {
        vectorAnimais = new ExameController().selecionarAnimaisEspecie(especie);
        cbAnimais.removeAllItems();//Remover todos os itens do combobox
        for (int i = 0; i < vectorAnimais.size(); i++) {
            this.cbAnimais.addItem(vectorAnimais.elementAt(i).getNome());
        }
       
    }
     private void selecionarIdAnimal(int indice){
    idAnimal=vectorAnimais.elementAt(indice).getIdAnimal();
    codAnimal.setText(" ID: "+idAnimal);
    }
   
     private void receberVacinas() throws SQLException, ClassNotFoundException, ExceptionDAO{
         if(especie.length()>0){
       vectorVacinas = new Historico_VacinaController().receberVacinas(especie);
        CbVacinas.removeAllItems();//Remover todos os itens do combobox
        for (int i = 0; i < vectorVacinas.size(); i++) {
            this.CbVacinas.addItem(vectorVacinas.elementAt(i).getNome());
        }}
     }
     private void SelecionarPrecoVacina(int indice){
     precoVacina=vectorVacinas.elementAt(indice).getPreco();
     preco.setText(" Preco: "+ precoVacina);
     }
    private void selecionarIdVacina(int indice){
    idVacina=vectorVacinas.elementAt(indice).getIdVacina();
    }
    
   public void cadastrarHistoricoVacinacao() throws SQLException, ClassNotFoundException, ExceptionDAO{
       boolean sucesso;
  Historico_VacinaController historico= new Historico_VacinaController();
       Data data= new Data();
       String date=data.dataActual();
       String observacao= fObservacao.getText();
    
      sucesso=historico.cadastrarVacinacao(idAnimal, idVacina, precoVacina, date, observacao);
    if(sucesso){
    JOptionPane.showMessageDialog(null, "O Historico foi cadastrado com sucesso");
    }
    else{JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o historico");}
    
}
    private void Limpar() {
cbAnimais.setSelectedIndex(-1);
CbVacinas.setSelectedIndex(-1);
fObservacao.setText("");
botoes.clearSelection();
preco.setText("");
codAnimal.setText("");
    }
    
    public void colocarIconMenu() {
        Menu_Principal a = new Menu_Principal("");
        a.iconPrincipal();
        a.mudarCor();
    }

    public void criarJanela() throws SQLException, ClassNotFoundException, ExceptionDAO {
        frame = new JFrame("Vacinacao");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(530, 550);
        frame.add(pPrincipal());
        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ExceptionDAO {
        new telaVacinacao();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bLimpar) {
            Limpar();
        }
        //Evento para selecionar os animais de acordo com a especie
        //Especie canina
        if(e.getSource()==rbcao){
          preco.setText("");
         especie="Canina";
            try {
                receberAnimaisEspecie(especie);
                receberVacinas();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao receber os animais"+ e);
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog(null, "Classe nao encontrada ao receber os animais"+ e);
            } catch (ExceptionDAO ex) {
                JOptionPane.showMessageDialog(null, "Erro ao receber os animais"+ e);
            }
        
        }
        
         //Especie Felina
        if(e.getSource()==rbgato){
            preco.setText("");
        especie="Felina";
            try {
                receberAnimaisEspecie(especie);
                receberVacinas();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao receber os animais"+ e);
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog(null, "Classe nao encontrada ao receber os animais"+ e);
            } catch (ExceptionDAO ex) {
                JOptionPane.showMessageDialog(null, "Erro ao receber os animais"+ e);
            }
        }
        
        //Evento para selecionar o idAnimal 
       if(e.getSource()==cbAnimais && cbAnimais.isShowing()){ 
       int indice=cbAnimais.getSelectedIndex();
        if(indice>=0){
        selecionarIdAnimal(indice);}
           
       } 
       
       if(e.getSource()==CbVacinas&& CbVacinas.isShowing()){
        int indice=CbVacinas.getSelectedIndex();
        if(indice>=0){
            SelecionarPrecoVacina(indice);
            selecionarIdVacina(indice);
        }   
       } 
       if(e.getSource()==bSalvar){
            try {
                cadastrarHistoricoVacinacao();
                Limpar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Salvar o historico"+ e);
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog(null, "Classe nao encontrada ao Salvar o historico"+ e);
            } catch (ExceptionDAO ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salavar o historico"+ e);
            }
       }
       
       if(e.getSource()==bLimpar){
           Limpar();
       }
       
  if(e.getSource()==bCancelar){
       colocarIconMenu();
       }
    }
}
