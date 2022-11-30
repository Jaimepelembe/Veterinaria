/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Conversor;
import Controller.VacinaController;
import Controller.Validacao;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;


/**
 *
 * @author multi
 */
public class Cadastro_Vacina implements ActionListener,DateChooserListener{
 private ButtonGroup botoes;
 private JRadioButton rbDog,rbCat;
 private JTextField tfdtValidade,tfPreco;
 private JLabel lab;
 private JComboBox cbMArca,cbNome,cbQuantidade;
 private JSpinner spUnidades;
 private JButton bSalvar,bLimpar,bCancelar;
 private DateChooser datechoose;
 private String especie;
 private Date data;
 private JPanel pComponentes,pBotoes,pPrincipal;
 private JFrame frame;
 
  private String[] listaMarca = { "Zoetis", "Boehringer ingelheim", "VANGUARD ", "SERUM INSTITUTE OF INDIA PVT" };
  private String[] VacinasCaes={"Polivalente (V10) ","Antirrábica","Gripe","Giárdia","Esgana","Parvovirose "};
  private String[] VacinasGatos={"Panleucopénia","Antirrábica ","RinoTranquete","Leucemia","Peritonite infeciosa ","Clamídia"};
  private String[] quantidade={"0.5","0.7", "1 "};
  private GridBagConstraints gbc = new GridBagConstraints();
  private Validacao vv= new Validacao();
  private Conversor cc= new Conversor();
 
 public Cadastro_Vacina() {
      inicializarComponentes();
      //criarJanela();}
 }
        

//public class Cadastro_Vacina implements  ActionListener {
//    private JLabel nome, marca, quant,preco, dtVal,especie ;
//    Color corSalvar = new Color(0.05f, 0.72f, 0.08f, 1.0f);
//    Color corLimpar = new Color(0.05f, 0.31f, 0.72f, 1.0f);
//    private JButton bSalvar, bCancelar, bLimpar;
//    private JTextField fNome, fPreco;
//    private JTextField  fDtVal;
//    private JFrame frame;
//    private JComboBox cMarca,cNome;
//    private JRadioButton rbgato,rbcao;
//    private ButtonGroup botoes;
//    private JSpinner spQuant;
//     private String[] listaMarca = { "Zoetis", "Boehringer ingelheim", "VANGUARD ", "SERUM INSTITUTE OF INDIA PVT" };
//     private String[] VacinasCaes={"Polivalente (V10) ","Antirrábica","Gripe","Giárdia","Esgana","Parvovirose "};
//     private String[] VacinasGatos={"Panleucopénia","Antirrábica ","RinoTranquete","Leucemia","Peritonite infeciosa ","Clamídia"};
//    GridBagConstraints gbc = new GridBagConstraints();
//
//    public Cadastro_Vacina() {
//    inicializarComponentes();
//    criarJanela();
//
//    }
 
private void inicializarComponentes(){
    //Paineis
    pComponentes=new JPanel(new GridBagLayout());
    pComponentes.setBackground(Color.white);
    pBotoes=new JPanel(new GridBagLayout());
    pBotoes.setBackground(Color.white);
    pPrincipal=new JPanel(new BorderLayout());
    pPrincipal.setBackground(Color.white);
    
    //Radio buttons
    botoes = new ButtonGroup();
    //Gato
    rbCat= new JRadioButton("Felina");
    rbCat.setBackground(Color.white);
    rbCat.addActionListener(this);
    //Cao
    rbDog= new JRadioButton("Canina");
    rbDog.setBackground(Color.white);
    rbDog.addActionListener(this);
    
    botoes.add(rbDog);
    botoes.add(rbCat);
   
    //Data de validade
    tfdtValidade=new JTextField(10);
    datechoose =new DateChooser();
    datechoose.setTextField(tfdtValidade);
    datechoose.addActionDateChooserListener(this);
    //Preco
    tfPreco= new JTextField(10);
   
    
    //ComBoboxes
    //Marca
    cbMArca=new JComboBox(listaMarca);
    //Quantidade
    cbQuantidade=new JComboBox(quantidade);
    //Nome
    cbNome= new JComboBox();
    
    //Spinner
    spUnidades= new JSpinner();
    spUnidades.setBackground(Color.white);
    spUnidades.setValue(1);//Indica quantas vacinas quero adicionar

        //Botoes
        //Botao salvar
        bSalvar = new JButton("Salvar");
        bSalvar.setForeground(Color.white);
        bSalvar.setBackground(Color.green);
        bSalvar.addActionListener(this);
        bSalvar.setFocusPainted(false);
        
        


        //Botao limpar
        bLimpar = new JButton("Limpar");
        bLimpar.setForeground(Color.white);
        bLimpar.setBackground(Color.blue);
        bLimpar.addActionListener(this);
        bLimpar.setFocusPainted(false);

        //Botao cancelar

}
    //Informacoes do nome
//    //Label
//    nome = new JLabel("Nome ");
//    nome.setForeground(Color.gray);
//    
//   //Combobox Nome
//    cNome = new JComboBox();
//      cNome.setSelectedIndex(-1);
//      
//       for(int i=0;i<VacinasCaes.length;i++){
//        cNome.addItem(VacinasCaes[i]);
//        
//        }
      
    
    //informacoes da marca
//    //Label
//    marca = new JLabel("Marca");
//      cMarca = new JComboBox(listaMarca);
//      cMarca.setSelectedIndex(-1);
//     //BOX
//     marca.setForeground(Color.gray);
//     
//     //Informacoes QUANTIDADE
//     //Label
//     quant = new JLabel("Quantidade");
//     quant.setForeground(Color.gray);
//     
//     //SPINNER QUANTIDADE
//     spQuant = new JSpinner();
//     
//      //Informacoes do preco
//    //Label
//    preco = new JLabel("Preco (MZN) ");
//    preco.setForeground(Color.gray);
//    
//   //TextField
//    fPreco = new JTextField(5);
//    fPreco.setColumns(20);
//     
//   //INFORMACOES SOBRE DATA 
//     //Label
//    dtVal = new JLabel("Data de Validade ");
//    dtVal.setForeground(Color.gray);
//    
//   //TextField
//    fDtVal = new JTextField();
//    fDtVal.setColumns(20);
//        
//        
//     //Botoes 
//     //Salvar
//       bSalvar = new JButton("Salvar");
//       bSalvar.setForeground(Color.white);
//       bSalvar.setBackground(corSalvar);
//       bSalvar.setBorderPainted(false);
//       bSalvar.addActionListener(this);
//       bSalvar.setFocusPainted(false);
//       
//      //limpar
//       bLimpar = new JButton("Limpar");
//       bLimpar.setForeground(Color.white);
//       bLimpar.setBackground(corLimpar);
//       bLimpar.setBorderPainted(false);
//       bLimpar.addActionListener(this);
//       bLimpar.setFocusPainted(false);
//       
//       //Cancelar
//        bCancelar = new JButton("Cancelar");
//        bCancelar.setForeground(Color.white);
//        bCancelar.setBackground(Color.red);
//        bCancelar.addActionListener(this);
//        bCancelar.setFocusPainted(false);
//    
//    }
 
    //Adicionar os componentes ao painel
private Container painelComponentes() {
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Especie
        // Label especie
        lab= new JLabel("Especie");
        lab.setBackground(Color.gray);
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        gbc.gridy = 0;
        gbc.gridx = 0;
        painel.add(lab, gbc);

        // Informacoes RadioButtons
        gbc.insets = new Insets(35, 15, 0, 0);//Insets e Field,RadioButton, Combobox
        gbc.gridx = 0;
        gbc.gridy=1;
        gbc.gridwidth = 1;
        painel.add(rbDog, gbc);

        gbc.insets = new Insets(35, 15,0, 0);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(rbCat, gbc);

        // Informacoes Marca
        // Label nome
        lab= new JLabel("Marca");
        lab.setBackground(Color.gray);
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(lab, gbc);
        // Combobox Marca
        gbc.insets = new Insets(25, 5, 0, 40);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipady = 6;
        gbc.gridwidth = 1;
        painel.add(cbMArca, gbc);

        //Informacoes Preco
        lab= new JLabel("Preco (MZN)");
        lab.setBackground(Color.gray);
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 2;
        painel.add(lab, gbc);
        // TextField Preco
        gbc.insets = new Insets(25, 5, 0, 40);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.ipady = 10;
        gbc.ipadx = 15;
        gbc.gridwidth = 1;
        painel.add(tfPreco, gbc);
        
        
        // Informacoes Nome
        // Label nome
        lab= new JLabel("Nome");
        lab.setBackground(Color.gray);
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 4;
        painel.add(lab, gbc);
        // Combobox Nome
        gbc.insets = new Insets(25, 5, 0, 40);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.ipady = 6;
        gbc.gridwidth = 1;
        painel.add(cbNome, gbc);
        
        // Informacoes Data validade
        // Label nome
        lab= new JLabel("Data de validade");
        lab.setBackground(Color.gray);
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 4;
        painel.add(lab, gbc);
        //TexteField data de Validade com DateChoose
        gbc.insets = new Insets(25, 5, 0, 40);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.ipady = 6;
        gbc.gridwidth = 1;
        painel.add(tfdtValidade, gbc);
        
        // Informacoes Quantidade da vacina
        // Label Quantidade
        lab= new JLabel("Quantidade(ml)");
        lab.setBackground(Color.gray);
        gbc.insets = new Insets(25, 15, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 6;
        painel.add(lab, gbc);
        //Combobox da quantidade
        gbc.insets = new Insets(25, 5, 20, 40);
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.ipady = 6;
        gbc.gridwidth = 1;
        painel.add(cbQuantidade, gbc);
        
        // Informacoes Unidade
        // Label Unidades
        lab= new JLabel("Unidades");
        lab.setBackground(Color.gray);
        gbc.insets = new Insets(25, 15, 0, 0);
        gbc.gridx = 1;
        gbc.gridy = 6;
        painel.add(lab, gbc);
        //Spinner Unidades
        gbc.insets = new Insets(25, 5, 20, 40);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.ipady = 6;
        gbc.gridwidth = 1;
        painel.add(spUnidades, gbc);

        return painel;

    }

 
 //Metodo para devolver o painel com botoes de Cadastro
private Container botoesCadastro() {
        // Botoes de salvar,Cancelar e limpar
        //Botao salvar
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(35, 5, 10, 40);
        gbc.ipadx = 10;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pBotoes.add(bSalvar,gbc);

        //Botao limpar
        gbc.gridx = 1;
        pBotoes.add(bLimpar,gbc);

        //Botao cancelar
        gbc.gridx = 2;
        pBotoes.add(bCancelar,gbc);

        return pBotoes;
    }
 
 //Metodo para devolver o painel de cadastro com todos componentes e botoes inseridos
public Container  painelCadastro(){
pPrincipal.add(painelComponentes(),BorderLayout.CENTER);
pPrincipal.add(botoesCadastro(),BorderLayout.PAGE_END);
     
 return pPrincipal;
 }
 
 //Metodo para selecionar o nome das vacinas de determinada especie
private void selecionarNomeVacina() {
        if (rbDog.isSelected()) {
            this.cbNome.removeAllItems();
            for (int i = 0; i < VacinasCaes.length; i++) {
                this.cbNome.addItem(VacinasCaes[i]);

            }

        }
        if (rbCat.isSelected()) {
            this.cbNome.removeAllItems();
            for (int i = 0; i < VacinasGatos.length; i++) {
                this.cbNome.addItem(VacinasGatos[i]);
            }

        }

    }

//Metodo para colocar o icon principal no menu
private void colocarIconMenu() {
        Menu_Principal a = new Menu_Principal("");
        a.iconPrincipal();
        a.mudarCor();
    }

//Salvar Dados

    
     public void CadastrarVacina() {
         //Especie
         String espec=especie;
        //Marca
        String marca = cbMArca.getSelectedItem().toString();
        
        //nome da vacina
        String nome = cbNome.getSelectedItem().toString();
        
        //data
        Date dat = data;
        //data
        Float preco =cc.StringToFloat(tfPreco.getText().toString());
        //data
        Float quantidade = cc.StringToFloat(cbQuantidade.getSelectedItem().toString());
        int unidade=(int)spUnidades.getValue();
        boolean sucesso;
        try {
            VacinaController vacina= new VacinaController();
            sucesso = vacina.cadastrarVacina(espec, marca, nome, preco, quantidade, dat, unidade);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "A vacina foi cadastrado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar a vacina");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao coletar dados da vacina" + ex);
        }

    }

    //limpar
 private void Limpar() {
        this.tfPreco.setText("");
        this.tfdtValidade.setText("");
        this.cbMArca.setSelectedIndex(-1);
        this.cbNome.setSelectedIndex(-1);
        this.cbQuantidade.setSelectedIndex(-1);
        this.spUnidades.setValue(1);
        this.botoes.clearSelection();
    }

 
 
private void criarJanela() {
        frame = new JFrame("Vacina");
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(700, 500);
       frame.add(painelCadastro());
      lab=new JLabel("Especie");
    
        frame.pack();
           frame.setVisible(true);
        

    }  
    
public static void main(String[] args) {
        new Cadastro_Vacina();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    //Evento para salvar dados
    if(e.getSource()==bSalvar){
    CadastrarVacina();
    }
    //Evento para Limpar os campos
    if(e.getSource()==bLimpar){
        Limpar();
    }
    //Evento para cancelar o cadastro e voltar ao menu principal
    if(e.getSource()==bCancelar){
    colocarIconMenu();
    }
        
    if(e.getSource()==rbDog){
        especie="Canina";
    selecionarNomeVacina();
   }    
    if(e.getSource()==rbCat){
        especie="Felina";
    selecionarNomeVacina();
     
    }
    
    }




    @Override
    public void dateBetweenChanged(DateBetween db, DateChooserAction action) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void dateChanged(java.util.Date date, DateChooserAction action) {
      SimpleDateFormat dtf= new  SimpleDateFormat("yyyy-MM-dd");
      String data=dtf.format(date);
      java.sql.Date dat=java.sql.Date.valueOf(data);  
      this.data=dat; }
  
    
}
