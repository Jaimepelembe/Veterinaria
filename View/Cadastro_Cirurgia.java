package View;

import Controller.Datas;
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
import javax.swing.plaf.multi.MultiTableHeaderUI;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;


public class Cadastro_Cirurgia implements ActionListener, Datas {

    private JLabel lab,preco,data,codAnimal, idAnimal;
    private JButton bSalvar, bLimpar, bCancelar;
    //private JFormattedTextField fPreco, fData;
    private JComboBox cbNome,cbAnimais, CbCirurgia;
    private String[] nomes = {"Castração", "Remoção de corpos estranhos", "Remoção de pedras na bexiga", "Correção de fraturas"};
    private JFrame frame;
    private JPanel painel, pPrincipal, pBotoes;
    private GridBagConstraints gbc = new GridBagConstraints();
    private JTextField fObservacao;
    private JRadioButton rbcao,rbgato;
    private ButtonGroup botoes;
   // private int idAnimal=-1;
    private float precoExame;
    private Vector<Animal> vectorAnimais;
    private Vector<Exame> vectorExames;
    private String[] resultados = {"Positivo", "Negativo"};

    public Cadastro_Cirurgia() throws SQLException, ClassNotFoundException, ExceptionDAO{
       criarJanela();
    }

    public void inicializar() {
        //Informacoes do nome
        cbNome = new JComboBox(nomes);
        cbNome.setSelectedIndex(-1);

        //Label do preco da consulta
        preco = new JLabel("000");//Preco da consulta

        //Label da data da cirurgia
        data= new JLabel();
        data.setText(dataActual());
        
        
        
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
        CbCirurgia = new JComboBox();
        CbCirurgia.addActionListener(this);
        cbAnimais = new JComboBox();
        cbAnimais.addActionListener(this);
        cbAnimais.setSelectedIndex(-1);
        
        //Labes
        codAnimal = new JLabel();
        //TextField observacao
        fObservacao = new JTextField();
        fObservacao.setColumns(10);
        preco= new JLabel("PREÇO");
        idAnimal= new JLabel("ID ANIMAL: ");
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
        gbc.ipadx = 60;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(rbcao, gbc);
        
        //Radio Button da Especie Felina
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(rbgato, gbc);
        
        
        
        //Informacoes do animal
        lab = new JLabel("Animal");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(lab, gbc);
        //Combobox Animal
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        gbc.gridwidth = 1;
        painel.add(cbAnimais, gbc);
        //Label id 
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(idAnimal, gbc);
        //Label do idAnimal
       /* gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        painel.add(codAnimal, gbc);*/

        //Informacoes
        lab = new JLabel("Cirurgia");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 60;
        gbc.ipady = 8;
        painel.add(lab, gbc);
          
        //Combobox
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        painel.add(CbCirurgia, gbc);
        //Label preco 
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 1;
        gbc.gridy = 4;
        painel.add(preco, gbc);

        //Informacoes da observacao
        lab = new JLabel("Observacao");
        gbc.insets = new Insets(35, 5, -27, 0);
        gbc.gridx = 0;
        gbc.gridy = 7;
        painel.add(lab, gbc);
        //field
        gbc.insets = new Insets(35, 5, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.ipadx = 8;
        gbc.ipady = 27;
        painel.add(fObservacao, gbc);
        gbc.gridwidth = 1;
        return painel;
    }

    public Container adicionarBotoes() {
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
        pPrincipal.add(componentes(), BorderLayout.NORTH);
        pPrincipal.add(adicionarBotoes(), BorderLayout.CENTER);
        pPrincipal.setBackground(Color.white);

        return pPrincipal;
    }
  public void criarJanela() throws SQLException, ClassNotFoundException, ExceptionDAO {
        frame = new JFrame("Cirurgia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(530, 550);
        frame.add(pPrincipal());
        frame.setVisible(true);
    }

    public static void main(String[] args)throws SQLException, ClassNotFoundException, ExceptionDAO  {
        new Cadastro_Cirurgia();

    }

    public void Limpar() {
        cbNome.setSelectedIndex(-1);
        preco.setText("");
        data.setText("");
        cbNome.requestFocus();
    }

  public String dataActual() {
    String data="";
    LocalDateTime date= LocalDateTime.now();
    DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    data=""+dtf.format(date);
     return data;}  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bLimpar) {
            Limpar();
        }
    }

    

}
