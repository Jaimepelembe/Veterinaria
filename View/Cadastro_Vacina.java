package View;


import java.awt.BorderLayout;
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
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;

public class Cadastro_Vacina implements  ActionListener {
    private JLabel nome, marca, quant,preco, dtVal,especie ;
    Color corSalvar = new Color(0.05f, 0.72f, 0.08f, 1.0f);
    Color corLimpar = new Color(0.05f, 0.31f, 0.72f, 1.0f);
    private JButton bSalvar, bCancelar, bLimpar;
    private JTextField fNome, fPreco;
    private JTextField  fDtVal;
    private JFrame frame;
    private JComboBox cMarca,cNome;
    private JRadioButton rbgato,rbcao;
    private ButtonGroup botoes;
    private JSpinner spQuant;
     private String[] listaMarca = { "Zoetis", "Boehringer ingelheim", "VANGUARD ", "SERUM INSTITUTE OF INDIA PVT" };
     private String[] VacinasCaes={"Polivalente (V10) ","Antirrábica","Gripe","Giárdia","Esgana","Parvovirose "};
     private String[] VacinasGatos={"Panleucopénia","Antirrábica ","RinoTranquete","Leucemia","Peritonite infeciosa ","Clamídia"};
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Vacina() {
    inicializarComponentes();
    criarJanela();
    }
    

    
    public void inicializarComponentes(){
        
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
        
        
        
    //Informacoes do nome
    //Label
    nome = new JLabel("Nome ");
    nome.setForeground(Color.gray);
    
   //Combobox Nome
    cNome = new JComboBox();
      cNome.setSelectedIndex(-1);
//      
//       for(int i=0;i<VacinasCaes.length;i++){
//        cNome.addItem(VacinasCaes[i]);
//        
//        }
      
    
    //informacoes da marca
    //Label
    marca = new JLabel("Marca");
      cMarca = new JComboBox(listaMarca);
      cMarca.setSelectedIndex(-1);
     //BOX
     marca.setForeground(Color.gray);
     
     //Informacoes QUANTIDADE
     //Label
     quant = new JLabel("Quantidade");
     quant.setForeground(Color.gray);
     
     //SPINNER QUANTIDADE
     spQuant = new JSpinner();
     
      //Informacoes do preco
    //Label
    preco = new JLabel("Preco (MZN) ");
    preco.setForeground(Color.gray);
    
   //TextField
    fPreco = new JTextField(5);
    fPreco.setColumns(20);
     
   //INFORMACOES SOBRE DATA 
     //Label
    dtVal = new JLabel("Data de Validade ");
    dtVal.setForeground(Color.gray);
    
   //TextField
    fDtVal = new JTextField();
    fDtVal.setColumns(20);
        
        
     //Botoes 
     //Salvar
       bSalvar = new JButton("Salvar");
       bSalvar.setForeground(Color.white);
       bSalvar.setBackground(corSalvar);
       bSalvar.setBorderPainted(false);
       bSalvar.addActionListener(this);
       bSalvar.setFocusPainted(false);
       
      //limpar
       bLimpar = new JButton("Limpar");
       bLimpar.setForeground(Color.white);
       bLimpar.setBackground(corLimpar);
       bLimpar.setBorderPainted(false);
       bLimpar.addActionListener(this);
       bLimpar.setFocusPainted(false);
       
       //Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar .setForeground(Color.white);
        bCancelar .setBackground(Color.red);
        bCancelar.setBorderPainted(false);
        bCancelar.setFocusPainted(false);
        bCancelar.addActionListener(this);
  
    }
    
//       private  void formatarCampo(JTextField campoTexto){
//         try {
//             MaskFormatter mascara = new MaskFormatter();
//              if(campoTexto==fDtVal){
//              mascara.setMask("##/##/####");
//             mascara.install( fDtVal);
//           }
//               
//         } catch (ParseException ex) {
//             JOptionPane.showMessageDialog(null, "Erro ao formatar Campo de texto");
//         }
//    
//    }
       
    public Container adicionarComponentes() {
       
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
         
        JLabel vazio = new JLabel("");
         gbc.insets = new Insets(35, 15, 77, 0);
         painel.add(vazio, gbc);
         
         // SEGUNDA FILA --Especie
        // Label especie
        gbc.insets = new Insets(35, 15, -7, 0);//Insets de Label
        gbc.gridy = 0;
        gbc.gridx = 1;
        painel.add(especie, gbc);

        // Radios
        gbc.insets = new Insets(95, 0, 0, 0);//Insets e Field,RadioButton, Combobox
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(rbcao, gbc);

        gbc.insets = new Insets(95, -4, -7, 0);
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        painel.add(rbgato, gbc);
         
         
        // Informacoes d o nome
        // nome
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 3;
        gbc.gridx = 1;
        painel.add(nome, gbc);
       
        // Field nome
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.ipady = 6;
        gbc.gridwidth = 1;
        painel.add(cNome, gbc);

        // SEGUNDA FILA
        // Label MARCA
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 1;
        gbc.gridx = 1;
        gbc.ipady = 12;
        painel.add(marca, gbc);

        // BOX MARCA
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.ipady = 6;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        painel.add(cMarca, gbc);

        // terceira
        // Label quant
        gbc.insets = new Insets(35, 15, -27, 0);
        gbc.gridy = 5;
        gbc.gridx = 1;
        painel.add(quant, gbc);

        // SPINNER QUANT
        gbc.insets = new Insets(35, 5, 90, 10);
        gbc.ipady = 15;
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(spQuant, gbc);
        
        // Informacoes dE preco
        // precp
        gbc.insets = new Insets(35, 45, -27, 0);
        gbc.gridy = 1;
        gbc.gridx = 2;
        gbc.ipady = 12;
        painel.add(preco, gbc);
        // Field nome
        gbc.insets = new Insets(35, 35, 0, 10);
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        painel.add(fPreco, gbc);

        // SEGUNDA FILA
        // Label data
        gbc.insets = new Insets(35, 45, -27, 0);
        gbc.gridy = 3;
        gbc.gridx = 2;
        painel.add(dtVal, gbc);

        // field data
        gbc.insets = new Insets(35, 35, 0, 10);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        painel.add(fDtVal, gbc);
        
        return painel;

    }
public Container adicionarBotoes() {
      
        inicializarComponentes();
        JPanel pBotoes = new JPanel();
        pBotoes.setBackground(Color.white);
       pBotoes.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(1, -5, 50, 15);
        // add buttons to the panel
         gbc.ipady = 4;
        gbc.gridy=0;
        gbc.gridx = 0;
        pBotoes.add(bSalvar,gbc);
        gbc.gridx = 1;
        pBotoes.add(bLimpar,gbc);
        gbc.gridx = 2;
        pBotoes.add(bCancelar,gbc);
    return pBotoes;
}

public Container adicionarImagens() {
      
        inicializarComponentes();
        JPanel pImagens = new JPanel();
        ImageIcon imageIcon;
        
        JLabel label = new JLabel();
      label.setIcon(new ImageIcon("C:/Users/Valter Boa/Documents/NetBeansProject/veterinaria/src/Imagens/vacina.png"));
        pImagens.add(label);
        pImagens.setBackground(Color.white);
        
   
    

    return pImagens;
}
 public Container painelPrincipal() {
JPanel  pComponentes = new JPanel();
pComponentes.setBackground(Color.white);
pComponentes.add(adicionarImagens(), BorderLayout.NORTH);
        pComponentes.add(adicionarComponentes(), BorderLayout.CENTER);
         pComponentes.add(adicionarBotoes(), BorderLayout.SOUTH);
 
 return pComponentes;}
      //Volta a colocar a imagem central no Painel do menu Principal
    public void colocarIconMenu() {
        Menu_Principal a = new Menu_Principal("");
        a.iconPrincipal();
        a.mudarCor();
    }
    //limpar
    public void Limpar() {
        this.fNome.setText("");
        this.fDtVal.setText("");
        this.fPreco.setText("");
        this.cMarca.setSelectedIndex(-1);
        this.spQuant.setValue(0);
    }
    //Metodo para colocar o nome das vacinas de determinada especie no combobox
    public void selecionarNomeVacina(){
        if(rbcao.isSelected()){
        this.cNome.removeAllItems();
        for(int i=0;i<VacinasCaes.length;i++){
        this.cNome.addItem(VacinasCaes[i]);
       
        }
        
    }
    if(rbgato.isSelected()){
        this.cNome.removeAllItems();
        for(int i=0;i<VacinasGatos.length;i++){
        this.cNome.addItem(VacinasGatos[i]);
        }
        
    }
    
    
    
    
    }
    
//    
//     public void CadastrarVacina() {
//         //marca da vacina
//        String marca = cMarca.getSelectedItem().toString();
//        
//        //nome da vacina
//        String nome = fNome.getText();
//        
//        //data
//        String data = fDtVal.getText();
//        //data
//        Float preco = Float.parseFloat(fPreco.getText());
//        //data
//        Float quantidade = Float.parseFloat(quant.getText());
//
//        boolean sucesso;
//        try {
//            VacinaController vacina = new VacinaController();
//            sucesso = vacina.cadastrarVacina(marca,nome,data,quantidade,preco);
//            if (sucesso) {
//                JOptionPane.showMessageDialog(null, "A vacina foi cadastrado com sucesso");
//            } else {
//                JOptionPane.showMessageDialog(null, "Houve um erro ao cadastrar a vacina");
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao coletar dados da vacina" + ex);
//        }
//
//    }

    public void criarJanela() {
        frame = new JFrame("CADASTRO DE VACINA");
        frame.setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(730, 690);
       frame.add(painelPrincipal());
        ImageIcon img = new ImageIcon("C:/Users/Valter Boa/Documents/NetBeansProject/veterinaria/src/Imagens/iconVacina.png");
        //frame.setIconImage(img.getImage());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
     new Cadastro_Vacina(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bLimpar) {
            Limpar();
        }
         if(e.getSource()==bCancelar){
       colocarIconMenu();
       }
         
           //Evento para salvar os dados da vacina na BD
        if (e.getSource() == bSalvar) {
//            CadastrarVacina();
            Limpar();
        }
        
        //Evento para selecionar a especie do animal
        if(e.getSource()==rbcao){
            System.out.println("Ola mundo");
            selecionarNomeVacina();
        }
        
        if(e.getSource()==rbgato){
            selecionarNomeVacina();
        }
        
         System.out.println("Ola mundo 2");
        
        
}
    }
 

