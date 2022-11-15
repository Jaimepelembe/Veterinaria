package View;

import Controller.AnimalController;
import Controller.Validacao;
import Model.DAO.ExceptionDAO;
import Model.VO.Cliente;
import java.awt.BorderLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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
import java.awt.Label;
import static java.awt.SystemColor.info;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;
//import sun.jvm.hotspot.oops.java_lang_Class;

public class Cadastro_Animal implements ActionListener {

    private JLabel nome, especie, raca, cor, dtNascimento, peso, kg,codigoCliente, escolha, sexo, info;
    private JButton salvar, cancelar, limpar, bEliminar, bHistorico;
    private JTextField fNome;
    private Vector<Cliente> clientes;
    private static JFormattedTextField fPeso, fDtNascimento;
    private JFrame frame;
    private  JComboBox cRaca, cCor,cClientes;
    private Container pbActual;
    private JPanel pPrincipal, pbCadastro, pbConsulta, pComponentes;
    private ButtonGroup botoes,bSexo;
    private JRadioButton rbcao, rbgato,rbfeminino,rbmascolino;
    private int idCliente=-1,indice, idVeterinaria,idAnimal;
    private String[] racas_caes = {"Chow chow", "Chiuaua","Doberman", "Husky siberiano","Pastor Alemao", "Pitbull", "Pastor Belga", "outro"};
    private String[] racas_gatos = { "Bengal","British Shorthair", "Maine Coon", "Munchkin", "Persa", "Ragdoll","Sphynx", "outro"};
    private String[] cores = {"Branco", "Cizento", "Azul", "Amarelo"};
    private  Validacao vv= new Validacao();
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Animal() throws SQLException, ClassNotFoundException, ExceptionDAO {
        inicializarComponentes();
        criarJanela();
    }

    private void inicializarComponentes() throws SQLException, ClassNotFoundException, ExceptionDAO {
        //Paines
        //Principal
        pPrincipal = new JPanel(new BorderLayout());
        //Botoes de cadastro
        pbCadastro = new JPanel(new GridBagLayout());
        pbCadastro.setBackground(Color.white);
        //Botoes de Consulta
        pbConsulta = new JPanel(new GridBagLayout());
        pbConsulta.setBackground(Color.white);
        

        //Painel Actual
        pbActual = new JPanel(new GridBagLayout());
        pbActual.setBackground(Color.white);
        
        // label Selecionar o cliente
        escolha = new JLabel("Selecione o cliente");
        escolha.setForeground(Color.gray);
        

        //label codigo cliente
        //Combobox de clientes
        cClientes= new JComboBox();
        cClientes.addActionListener(this);
        //LABEL ID CLIENT
        info = new JLabel();
        //Nome
        nome = new JLabel("Nome ");
        nome.setForeground(Color.gray);
        fNome = new JTextField(5);
        fNome.setColumns(10);

        //Especie
        especie = new JLabel("Especie ");
        especie.setForeground(Color.gray);
        botoes = new ButtonGroup();
        //Radio Button Cao
        rbcao = new JRadioButton("Canina");
        rbcao.setBackground(Color.WHITE);
        rbcao.addActionListener(this);
        
        //Radio Button Gato
        rbgato = new JRadioButton("Felina");
        rbgato.setBackground(Color.WHITE);
        rbgato.addActionListener(this);
        //Button Group
        botoes.add(rbcao);
        botoes.add(rbgato);

       //Sexo do animal
       
        sexo = new JLabel("Sexo");
        sexo.setForeground(Color.gray);
       //Masculino
       rbmascolino= new JRadioButton("M");
       rbmascolino.setBackground(Color.white);
       //Feminino
       rbfeminino= new JRadioButton("F");
       rbfeminino.setBackground(Color.WHITE);
       bSexo= new ButtonGroup();
       bSexo.add(rbmascolino);
       bSexo.add(rbfeminino);
       
        
        //Cor do pelo
        cor = new JLabel("Cor do pelo ");
        cor.setForeground(Color.gray);
        cCor = new JComboBox(cores);
        cCor.setSelectedIndex(-1);

        //Raca do animal
        //Ela depende da especie
        raca = new JLabel("Raça ");
        raca.setForeground(Color.gray);
        cRaca = new JComboBox();//Deve ter raca de caes ou gatos dependendo da especie selecionada
            
        //Data de nascimento
        dtNascimento = new JLabel("Data de nascimento ");
        dtNascimento.setForeground(Color.gray);
        fDtNascimento = new JFormattedTextField();
        fDtNascimento.setColumns(10);
        formatarCampo(fDtNascimento);

        //Peso
        peso = new JLabel("Peso ");
        peso.setForeground(Color.gray);
        fPeso = new JFormattedTextField();
        fPeso.setColumns(10);
        formatarCampo(fPeso);
        //Receber os clientes da BD
        receberClientes();
        cClientes.setSelectedIndex(-1);

        //Botoes Salvar,Limpar e cancelar
        //Botao salvar
        salvar = new JButton("Salvar");
        salvar.setForeground(Color.white);
        salvar.setBackground(Color.green);
        salvar.addActionListener(this);
        salvar.setFocusPainted(false);

        //Botao limpar
        limpar = new JButton("Limpar");
        limpar.setForeground(Color.white);
        limpar.setBackground(Color.blue);
        limpar.addActionListener(this);
        limpar.setFocusPainted(false);

        //Botao cancelar
        cancelar = new JButton("Cancelar");
        cancelar.setForeground(Color.white);
        cancelar.setBackground(Color.red);
        cancelar.addActionListener(this);
        cancelar.setFocusPainted(false);

        //Botoes para formar a tela de consulta
        //Botao Ver historico
        bHistorico = new JButton("Historico");
        bHistorico.setForeground(Color.white);
        bHistorico.setBackground(Color.pink);
        bHistorico.setFocusPainted(false);

        //Botao Eliminar
        bEliminar = new JButton("Eliminar");
        bEliminar.setForeground(Color.white);
        bEliminar.setBackground(Color.orange);
        bEliminar.setFocusPainted(false);
    }

    private void formatarCampo(JTextField campoTexto) {
        try {
            MaskFormatter mascara = new MaskFormatter();
            if (campoTexto == fDtNascimento) {
                mascara.setMask("##-##-####");//Ano,Mes e Dia
                mascara.install(fDtNascimento);
            }
            if (campoTexto == fPeso) {
                mascara.setMask("###");
                mascara.install(fPeso);
            }

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar Campo de texto");
        }

    }

    private Container adicionarcomponentes() {
        pComponentes = new JPanel();
        pComponentes.setBackground(Color.white);
        pComponentes.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        
        //Informacpoes do cliente
        gbc.insets = new Insets(35, 15, -27, 0);//Insets de Label
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridx = 2;
        gbc.gridy = 0;
        pComponentes.add(escolha, gbc);
        
        //Combobox clientes
        gbc.insets = new Insets(35, 5, -27, 0);//Insets e Field,RadioButton, Combobox
        gbc.ipadx = 80;
        gbc.ipady = 10;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        pComponentes.add(cClientes, gbc);

         //codigo do cliente

        gbc.insets = new Insets(35, 5, -27, 10);//Insets e Field,RadioButton, Combobox
        gbc.ipadx = 80;
        gbc.ipady = 10;
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        pComponentes.add(info, gbc);
        
        //Label Nome do animal
        gbc.insets = new Insets(35, 15, -27, 0);//Insets de Label
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridx = 2;
        gbc.gridy = 2;
        pComponentes.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(35, 5, -27, 0);//Insets e Field,RadioButton, Combobox
        gbc.ipadx = 80;
        gbc.ipady = 10;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        pComponentes.add(fNome, gbc);

        // SEGUNDA FILA --Especie
        // Label especie
        gbc.insets = new Insets(35, 15, -27, 0);//Insets de Label
        gbc.gridy = 4;
        gbc.gridx = 2;
        pComponentes.add(especie, gbc);

        // Radios
        gbc.insets = new Insets(35, -10, -27, 0);//Insets e Field,RadioButton, Combobox
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        pComponentes.add(rbcao, gbc);

        gbc.insets = new Insets(35, -4, -27, 0);
        gbc.gridx = 4;
        gbc.gridwidth = 1;
        pComponentes.add(rbgato, gbc);
        
         //Sexo do animal
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridx = 2;
        gbc.gridy = 5;
        pComponentes.add(sexo, gbc);
        
        //Radio Masculino
      gbc.insets = new Insets(35, -10, -27, 30);
        gbc.gridx = 3;
        gbc.gridwidth=1;
        pComponentes.add(rbmascolino,gbc);
        
        //Radio Feminino
        gbc.insets = new Insets(35, -10, -27, 0);
        gbc.gridx = 4;
        gbc.gridwidth=1;
        pComponentes.add(rbfeminino,gbc);
        

        // terceira --Raca
        // label raca
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridx = 2;
        gbc.gridy = 6;
        pComponentes.add(raca, gbc);
        

        // box racas
        gbc.insets = new Insets(5, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        gbc.ipadx = 80;
        gbc.ipady = 10;
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        pComponentes.add(cRaca, gbc);

       
        
        //Label cores
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridx = 3;
        gbc.gridy = 6;
        pComponentes.add(cor, gbc);
        
        // Combobox cores
          gbc.insets = new Insets(5, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        gbc.ipadx = 80;
        gbc.ipady = 10;
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        pComponentes.add(cCor, gbc);
        
        // PESO DO ANIMAL
        //Label do peso
        gbc.insets = new Insets(35, 15, -27, 0);//Insets de Label
        gbc.gridx = 2;
        gbc.gridy = 8;
        pComponentes.add(peso, gbc);

        //TextField do peso
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        pComponentes.add(fPeso, gbc);

        // DATA DE NASCIMENTO
       //Label do peso
        gbc.insets = new Insets(35, 15, -27, 0);//Insets de Label
        gbc.gridx = 3;
        gbc.gridy = 8;
        pComponentes.add(dtNascimento, gbc);

        //TextField
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        gbc.gridx = 3;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        pComponentes.add(fDtNascimento, gbc);
        return pComponentes;
    }

    private Container botoesCadastro() {
        // Botoes de salvar,Cancelar e limpar
        //Botao salvar
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(35, 0, 40, 50);
        gbc.ipadx = 10;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pbCadastro.add(salvar, gbc);

        //Botao limpar
        gbc.gridx = 1;
        pbCadastro.add(limpar, gbc);

        //Botao cancelar
        gbc.gridx = 2;
        pbCadastro.add(cancelar, gbc);

        return pbCadastro;
    }

    public Container painelCadastro() {
        //Remover o painel de botoao actual
        removerPainelBotao();
        pPrincipal.add(adicionarcomponentes(), BorderLayout.CENTER);
        pbActual = botoesCadastro();
        pPrincipal.add(pbActual, BorderLayout.PAGE_END);
        return pPrincipal;
    }

    private Container botoesResulConsulta() {
        //Botao salvar
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(35, 0, 40, 50);
        gbc.ipadx = 10;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        pbConsulta.add(salvar, gbc);

        //Botao Ver historico
        gbc.gridx = 1;
        pbConsulta.add(bHistorico, gbc);

        //Botao Eliminar
        gbc.gridx = 2;
        pbConsulta.add(bEliminar, gbc);

        //Botao Cancelar
        gbc.gridx = 3;
        pbConsulta.add(cancelar, gbc);

        return pbConsulta;
    }

    public Container painelResulConsulta() {
        //Remover o painel de botoao actual
        removerPainelBotao();
        pPrincipal.add(adicionarcomponentes(), BorderLayout.CENTER);
        pbActual = botoesResulConsulta();
        pPrincipal.add(pbActual, BorderLayout.PAGE_END);
        return pPrincipal;
    }

    private void removerPainelBotao() {
        if (pbActual != null) {
            pPrincipal.remove(pbActual);
        }
    }
    
    private void selecionarRaca(){
    if(rbcao.isSelected()){
        this.cRaca.removeAllItems();
        for(int i=0;i<racas_caes.length;i++){
        cRaca.addItem(racas_caes[i]);
       
        }
        
    }
    if(rbgato.isSelected()){
        this.cRaca.removeAllItems();
        for(int i=0;i<racas_gatos.length;i++){
        cRaca.addItem(racas_gatos[i]);
      
        }
        
    }
     }

    
    
    private void criarJanela() {
        frame = new JFrame("ANIMAL");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(700, 500);
        frame.add(painelCadastro());
        frame.pack();

    }

    public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException, ExceptionDAO {
       new Cadastro_Animal();  
    }
    
  //Metodo para passar os dados recolhidos dos componentes para Controller
 
    private void receberClientes() throws SQLException, ClassNotFoundException, ExceptionDAO{
    clientes=new AnimalController().selecionarCliente();
    for(int i=0; i< clientes.size();i++){
    cClientes.addItem(clientes.elementAt(i).getNome());
    }
    }
    public void selecionarIdCliente(int id){
    idCliente=clientes.elementAt(id).getIdCliente();
    idVeterinaria=clientes.elementAt(id).getIdVeterinaria();
     info.setText("ID do cliente: "+idCliente);
    
   
    }
    public void selecionarAnimal (int idAnimal, String nome, String especie, String sexo,String raca, String cor_pelo, float peso, String dt_nascimento) {
     this.idAnimal = idAnimal;
        fNome.setText(nome);
        //Selecionar a especie
        if(especie=="Canina"){
        rbcao.setSelected(true);
        selecionarRaca();
        SelectcomboBox(raca);
        }else{rbgato.setSelected(true);}
        selecionarRaca();
        SelectcomboBox(raca);
        
        //Selecionar sexo
        if(sexo=="F"){
        rbfeminino.setSelected(true);
       
        }else{rbmascolino.setSelected(true);
        }
       //Selectionsr Cor do pelo
       cCor.setSelectedIndex(SelectcomboBox(cor_pelo, cCor));
       //Preencher o peso
       fPeso.setText(""+peso);
       
       //Preencher data de nascimento
       fDtNascimento.setText(dt_nascimento);
       
       
        
        
        //Passar o painel do resultado da consulta para o menu 
       // new Menu_Principal().ResulConsultaCliente(painelResultConsulta());
     // Menu_Principal.ResulConsultaAnimal(painelResulConsulta());
        
    
    }
    
      private  void SelectcomboBox(String raca) {
        int j = cRaca.getItemCount();
        System.out.println(j);

        for (int i = 0; i < j; i++) {
            if (cRaca.getItemAt(i) != null && cRaca.getItemAt(i).equals(raca)) {
                cRaca.setSelectedIndex(i);
                
                break;
            }
        }
    }

       private  int  SelectcomboBox(String nome,JComboBox combo) {
        int j = combo.getItemCount();
        int indice=-1;
        System.out.println(j);

        for (int i = 0; i < j; i++) {
            if (combo.getItemAt(i) != null && combo.getItemAt(i).equals(nome)) {
                indice=i;
                break;
            }
        }
   return indice; }
    private void Limpar() {
        fNome.setText("");
        this.cClientes.setSelectedIndex(-1);
        fPeso.setText("");
        fDtNascimento.setText("");
        this.cCor.setSelectedIndex(-1);
        this.cRaca.removeAllItems();
        botoes.clearSelection();
        bSexo.clearSelection();
        info.setText("");
        fNome.requestFocus();
       

    }
       private void SalvarDados(){
    String nome= fNome.getText();
    
    //Especie do animal
    String especie="";
    if(rbcao.isSelected()){
    especie=rbcao.getText();}
    
    if(rbgato.isSelected()){
    especie=rbgato.getText();
    }
     //Sexo do animal;
    String sexo="";
   if(rbmascolino.isSelected()){
    sexo=rbmascolino.getText();
   }
    if(rbfeminino.isSelected()){
    sexo=rbfeminino.getText();
    }
    String raca=cRaca.getSelectedItem().toString();
    String cor= cCor.getSelectedItem().toString();
    float peso= vv.StringToFloat(fPeso.getText());    
    String data= fDtNascimento.getText();
    boolean sucesso;
    try{AnimalController animal = new AnimalController();
    if(idCliente>0 && idVeterinaria>0){
    sucesso=animal.cadastrarAnimal(nome, especie, sexo, raca, cor, peso, data, idCliente, idVeterinaria);
    if(sucesso){
    JOptionPane.showMessageDialog(null, "O Animal foi cadastrado com sucesso");
    }
    else{JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar o animal");}
    }
  
    }catch(Exception ex){ JOptionPane.showMessageDialog(null, "Erro ao coletar dados do animal"+ex);}
    
    }
      public void colocarIconMenu() {
        Menu_Principal a = new Menu_Principal("");
        a.iconPrincipal();
        a.mudarCor();
    }
// public void setinfo(Object nomecomponente,Object info){
// if(nomecomponente==fNome){
//     fNome.setText(""+info);
//     System.out.println("Ola jaime");
//     
// }
// 
// }
    public void actionPerformed(ActionEvent e) {
        //Evento para Selecionar o dono do animal
        if(e.getSource()==cClientes){
        indice=cClientes.getSelectedIndex();
        if(indice>=0){
            selecionarIdCliente(indice);
        }
        }
        
        
        if (e.getSource() == limpar) {
            Limpar();
         
        }
        
        //Evento para salvar os dados do animal na BD
        if(e.getSource()==salvar){
        SalvarDados();
        Limpar();
        }
        
        //Evento para Selecionar a raca do animal
        //Selecionar Cao
        if(e.getSource()==rbcao){
            selecionarRaca();
//            System.out.println("Ola mundo");
//            cRaca.addItem("Ola");
//            cRaca.addItem("Oi");
//            cRaca.removeAllItems();
        }
        //Evento para selecionar Gato
        if(e.getSource()==rbgato){
      selecionarRaca();
        }
         if(e.getSource()==cancelar){
       colocarIconMenu();
       }
    }
    
    
}
