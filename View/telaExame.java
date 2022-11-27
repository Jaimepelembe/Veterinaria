package View;

import Controller.AnimalController;
import Controller.Data;
import Controller.ExameController;
import Controller.Historico_ExameController;
import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
import Model.VO.Exame;
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
import java.sql.Date;
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

public class telaExame implements ActionListener {

    private JLabel lab, codAnimal, preco;
    private JButton bSalvar, bLimpar, bCancelar;
    private JComboBox cbAnimais, CbExames, CbResultados;
    private JTextField fObservacao;
    private JFrame frame;
    private JRadioButton rbcao,rbgato;
    private ButtonGroup botoes;
    private JPanel painel, pPrincipal, pBotoes;
    private GridBagConstraints gbc = new GridBagConstraints();
    private int idAnimal=-1, idExame=-1,idHistorico=-1;
    private float precoExame;
    private Vector<Animal> vectorAnimais;
    private Vector<Exame> vectorExames;
    private String[] resultados = {"Positivo", "Negativo"};

    public telaExame() throws SQLException, ClassNotFoundException, ExceptionDAO {
        
        inicializar();
       // criarJanela();
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
        CbExames = new JComboBox();
        CbExames.addActionListener(this);
        CbExames.setSelectedIndex(-1);
        
        cbAnimais = new JComboBox();
        cbAnimais.addActionListener(this);
        cbAnimais.setSelectedIndex(-1);
        CbResultados = new JComboBox(resultados);
        CbResultados.setSelectedIndex(-1);
        
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
        gbc.ipadx = 20;
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
        lab = new JLabel("Exame");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 20;
        gbc.ipady = 8;
        painel.add(lab, gbc);
        //Combobox
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        painel.add(CbExames, gbc);
        //Label preco telaExame
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 4;
        painel.add(preco, gbc);

        //Informacoes do resultado
        lab = new JLabel("Resultado");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipadx = 20;
        painel.add(lab, gbc);
        //Combobox
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        painel.add(CbResultados, gbc);

        //Informacoes da observacao
        lab = new JLabel("Observacao");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 7;
        painel.add(lab, gbc);
        //Combobox
        gbc.insets = new Insets(35, 5, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 20;
        gbc.ipady = 10;
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
//         public void colocarIconMenu() {
//       Menu_Principal a = new Menu_Principal("");
//        a.mudarCor();
//        a.iconPrincipal();
//        
//    }

    private void recebertodosAnimais() throws SQLException, ClassNotFoundException, ExceptionDAO {
        vectorAnimais = new ExameController().selecionarAnimais();
        for (int i = 0; i < vectorAnimais.size(); i++) {
            this.cbAnimais.addItem(vectorAnimais.elementAt(i).getNome());
        }
        this.cbAnimais.setSelectedIndex(-1);
    }
    private void receberAnimaisEspecie(String especie) throws SQLException, ClassNotFoundException, ExceptionDAO {
        vectorAnimais = new ExameController().selecionarAnimaisEspecie(especie);
        cbAnimais.removeAllItems();//Remover todos os itens do combobox
        for (int i = 0; i < vectorAnimais.size(); i++) {
            this.cbAnimais.addItem(vectorAnimais.elementAt(i).getNome());
        }
        //cbAnimais.setSelectedIndex(-1);
    }
    private void selecionarIdAnimal(int indice){
    idAnimal=vectorAnimais.elementAt(indice).getIdAnimal();
    codAnimal.setText(" ID: "+idAnimal);
    }
    private void receberExames() throws SQLException, ClassNotFoundException, ExceptionDAO{
       vectorExames = new ExameController().selecionarExames();
        CbExames.removeAllItems();//Remover todos os itens do combobox
        for (int i = 0; i < vectorExames.size(); i++) {
            this.CbExames.addItem(vectorExames.elementAt(i).getNome());
        }
     }
    private void SelecionarPrecoExame(int indice){
     precoExame=vectorExames.elementAt(indice).getPreco();
     preco.setText(" Preco: "+ precoExame);
     }
    private void selecionarIdExame(int indice){
    idExame=vectorExames.elementAt(indice).getIdExame();
    }
    private void selecionarIdHistorico() throws SQLException, ClassNotFoundException, ExceptionDAO{
   idHistorico=new Historico_ExameController().selecionaridHistorico();
    }
    
   public void cadastrarHistoricoExame() throws SQLException, ClassNotFoundException, ExceptionDAO{
       boolean sucesso;
    selecionarIdHistorico();//Metodo que vai selecionar o idHistorico que esta na BD
    Historico_ExameController historico= new Historico_ExameController();
       Data data= new Data();
       Date date=data.dataActual();
       String resultado=CbResultados.getSelectedItem().toString();
       String observacao= fObservacao.getText();
    
      sucesso=historico.cadastrarExame(idAnimal, idExame,idHistorico, date, resultado, observacao);
    if(sucesso){
    JOptionPane.showMessageDialog(null, "O Historico do exame foi cadastrado com sucesso");
    }
    else{JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o historico");}
    
}
    private void Limpar() {
 cbAnimais.removeAllItems();
cbAnimais.setSelectedIndex(-1);
CbExames.removeAllItems();
CbExames.setSelectedIndex(-1);
CbResultados.setSelectedIndex(-1);
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
        frame = new JFrame("Exame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(530, 550);
        frame.add(pPrincipal());
        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ExceptionDAO {
        new telaExame();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bLimpar) {
            Limpar();
        }
        //Evento para selecionar os animais de acordo com a especie
        //Especie canina
        if(e.getSource()==rbcao){
        String especie="Canina";
            try {
                receberAnimaisEspecie(especie);
                receberExames();
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
        String especie="Felina";
            try {
                receberAnimaisEspecie(especie);
                receberExames();
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
       
       if(e.getSource()==CbExames&& CbExames.isShowing()){
        int indice=CbExames.getSelectedIndex();
        if(indice>=0){
            SelecionarPrecoExame(indice);
            selecionarIdExame(indice);
        }   
       } 
       if(e.getSource()==bSalvar){
            try {
                cadastrarHistoricoExame();
                Limpar();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Salvar o historico"+ e);
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog(null, "Classe nao encontrada ao Salvar o historico"+ e);
            } catch (ExceptionDAO ex) {
                JOptionPane.showMessageDialog(null, "Houve um Erro ao salavar o historico"+ e);
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
