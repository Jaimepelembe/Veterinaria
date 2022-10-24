package View;


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
import java.text.ParseException;
import javax.swing.ButtonGroup;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;

public class Cadastro_Vacina implements ActionListener {
    private JLabel lab, especie;
    private JButton bSalvar, bLimpar, bCancelar;
    private JTextField  tfNome, tfQuantidade;
    private JFormattedTextField tfPreco_Aquisicao, tfValidade, tfTemperatura;
    private ButtonGroup botoes;
    private JRadioButton rbcao, rbgato;
    private JComboBox cbMarca, cbNome;
    private int aux1=0, aux2=0;
    private String[] listaMarca = { "Zoetis", "Boehringer ingelheim", "VANGUARD ", "SERUM INSTITUTE OF INDIA PVT" };
    private String[] Vacinas_Caes = { "Polivalente (V10)", "Antirrábica", "Contra a gripe", "contra Giárdia", "Esgana",
            "Parvovirose" };
    private String[] Vacinas_Gatos = { "Panleucopénia felina", "Antirrábica", "RinoTranquete" };
    private JPanel pPrincipal;

    private JFrame janela;
    private JSpinner spQuantidade, spUnidades;
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Vacina() {
        createWindow();
    }

   
    public void inicializarComponentes(){
    //Informacoes da marca
    //Combobox
     cbMarca = new JComboBox<>(listaMarca);
     cbMarca.setSelectedIndex(-1);
     
     //Informacoes da especie
      //Especie
        especie = new JLabel("Especie ");
        botoes = new ButtonGroup();
        rbcao = new JRadioButton("Canino");
        rbcao.setBackground(Color.WHITE);
        rbcao.addActionListener(this);
        
        rbgato = new JRadioButton("Felino");
        rbgato.setBackground(Color.WHITE);
        rbgato.addActionListener(this);
        botoes.add(rbcao);
        botoes.add(rbgato);
     
      // informacoes nome
      //Combobox dos nomes
      cbNome = new JComboBox();
      
      cbNome.setSelectedIndex(-1);
      
      //Spinner Quantidade de vacinas
       spQuantidade = new JSpinner();
       spQuantidade.setValue(0.5);
       spQuantidade.setToolTipText("Indique a quantidade");
       
       //Informacoes do preco de aquisicao
       tfPreco_Aquisicao= new JFormattedTextField();
       formatarCampo(tfPreco_Aquisicao);
       
       //TextField da temperatura
       tfTemperatura = new JFormattedTextField();
       tfTemperatura.setColumns(10);
        formatarCampo(tfTemperatura);
       
       //TextField data
        tfValidade = new JFormattedTextField();
        tfValidade.setColumns(10);
        formatarCampo(tfValidade);
        
        //Spinner unidades
        spUnidades= new JSpinner();
        spUnidades.setToolTipText("Indique quantas unidades que deseja cadastrar");
        
     //Botoes 
     //Salvar
       bSalvar = new JButton("Salvar");
       bSalvar.setForeground(Color.white);
       bSalvar.setBackground(Color.green);
       
      //Eliminar
       bLimpar = new JButton("Limpar");
       bLimpar.setForeground(Color.white);
       bLimpar.setBackground(Color.ORANGE);
       
       //Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar .setForeground(Color.white);
        bCancelar .setBackground(Color.red);
    
    }
    
private  void formatarCampo(JTextField campoTexto){
         try {
             MaskFormatter mascara = new MaskFormatter();
              if(campoTexto==tfValidade){
              mascara.setMask("##/##/####");
             mascara.install( tfValidade);
           }
           if(campoTexto==tfPreco_Aquisicao){
           mascara.setMask("####");
           mascara.install(tfPreco_Aquisicao);}
           
            if(campoTexto==tfTemperatura){
          mascara.setMask("###");
          mascara.install(tfTemperatura);
         }
           
            }
         
        
         
         catch (ParseException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao formatar Campo de texto");
         }
    
    }    
    
    public Container AdicionarComponentes() {
        inicializarComponentes();
        JPanel pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setBackground(Color.white);

        // informacoes Marca
        lab = new JLabel("Marca:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        pPrincipal.add(lab, gbc);

       //ComboBox marca
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        pPrincipal.add(cbMarca, gbc);
        
        
        // SEGUNDA FILA --Especie
        // Label especie
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        pPrincipal.add(especie, gbc);

        // Radios
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        pPrincipal.add(rbcao, gbc);
        
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        pPrincipal.add(rbgato, gbc);

        // informacoes nome
        //Label
        lab = new JLabel("Nome:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        pPrincipal.add(lab, gbc);

        //Combobox nome
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        pPrincipal.add(cbNome, gbc);

        // Informacoes da Quandidade
        lab = new JLabel("Quantidade:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        pPrincipal.add(lab, gbc);

       //Spinner quantidade de vacinas
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 1;
        gbc.ipady=5;
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        pPrincipal.add(spQuantidade, gbc);
        //label ml
        lab = new JLabel("ml");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        pPrincipal.add(lab, gbc);

        // Informacoes do Preco Aquisicao
        lab = new JLabel("Preco Aquisição:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipadx=1;
        gbc.ipady=5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        pPrincipal.add(lab, gbc);
        
        //TextField preco de aquisicao
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        pPrincipal.add(tfPreco_Aquisicao, gbc);

        // Temperatura Conservacao
        lab = new JLabel("Temperatura Conservação:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        pPrincipal.add(lab, gbc);

        //TextField de temperatura 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        pPrincipal.add(tfTemperatura, gbc);

        // informacoes da data de validade Validade
        lab = new JLabel("Data validade:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        pPrincipal.add(lab, gbc);
        
        //TextField da data 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        pPrincipal.add(tfValidade, gbc);
        
        //Informacao das unidades
        lab= new JLabel("Unidades");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        pPrincipal.add(lab,gbc);
        //Spinner unidades
        gbc.gridx=1;
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        pPrincipal.add(spUnidades,gbc);
        
        
    

        // Botoes
        // Salvar
        gbc.insets = new Insets(35, 5, 40, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx=10;
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
       
        pPrincipal.add(bSalvar, gbc);

        // Eliminar
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
          gbc.ipadx=10;
          gbc.ipady=5;
        gbc.weightx=0;
        gbc.insets = new Insets(35, 45, 40, 60);
        pPrincipal.add(bLimpar, gbc);
        
        
        // Cancelar
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.ipadx=10;
        gbc.insets = new Insets(35, 5, 40, 1);
        pPrincipal.add(bCancelar, gbc);

        return pPrincipal;
    }
    
    
    public void createWindow() {
        janela = new JFrame("CADASTRO DA VACINA");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        // Adicicao dos componentes a janela
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        // gbc.gridwidth = 1;
        janela.add(AdicionarComponentes());
        janela.pack();
        janela.setVisible(true);

    }

    public static void main(String[] args) {
        new Cadastro_Vacina();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
     if(e.getSource()==rbcao){
         aux1++;
         if(aux1==1){
         for(int i=0;i<Vacinas_Caes.length;i++){
                 cbNome.addItem(Vacinas_Caes[i]);
                }
     
       }
         
     }
     if(e.getSource()==rbgato){
     aux2++;
       for(int i=0;i<Vacinas_Gatos.length;i++){
        cbNome.addItem(Vacinas_Gatos[i]);
                }
     }
    
    }
}