package View;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;

public class Cadastro_Animal implements  ActionListener{

    private JLabel nome, especie, raca, cor, dtNascimento, peso, kg;
    private JButton salvar, cancelar, limpar;
    private JTextField fNome;
    private JFormattedTextField fPeso, fDtNascimento;
    private JFrame frame;
    private JComboBox cRaca, cCor;
    private ButtonGroup botoes;
    private JRadioButton rbcao, rbgato;
    private String[] racas_caes = {"Pastor Alemao", "Pitbull", "Pastor Belga", "Chiuaua","Husky siberiano","Chow chow","Doberman","outro"};
    private String [] racas_gatos={"Persa","Sphynx","British Shorthair","Maine Coon","Bengal","Ragdoll","Munchkin","outro"};
    private String[] cores = {"Branco", "Cizento", "Azul", "Amarelo"};
    //Teste de GitHub 
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Animal() {
        criarJanela();
    }

    public void inicializarComponentes() {
        //Nome
        nome = new JLabel("Nome ");
        fNome = new JTextField(5);
        fNome.setColumns(10);

        //Especie
        especie = new JLabel("Especie ");
        botoes = new ButtonGroup();
        rbcao = new JRadioButton("Canina");
        rbcao.setBackground(Color.WHITE);
        rbgato = new JRadioButton("Felina");
        rbgato.setBackground(Color.WHITE);
        botoes.add(rbcao);
        botoes.add(rbgato);
        
        //Cor do pelo
        cor = new JLabel("Cor do pelo ");
       cCor = new JComboBox(cores);
       cCor.setSelectedIndex(-1);
       
        //Raca do animal
        //Ela depende da especie
        raca = new JLabel("Raça ");
        cRaca = new JComboBox();//Deve ter raca de caes ou gatos dependendo da especie selecionada
        cRaca.setSelectedIndex(-1);
        //Data de nascimento
        dtNascimento = new JLabel("Data de nascimento ");
        fDtNascimento = new JFormattedTextField();
        fDtNascimento.setColumns(10);
        formatarCampo(fDtNascimento);
        
        //Peso
        peso = new JLabel("Peso ");
        fPeso = new JFormattedTextField();
        fPeso.setColumns(10);
        formatarCampo(fPeso);
        
        //Botoes Salvar,Limpar e cancelar
        //Botao salvar
        salvar = new JButton("Salvar");
        salvar.setForeground(Color.white);
        salvar.setBackground(Color.green);
        
        //Botao cancelar
        cancelar = new JButton("Cancelar");
        cancelar.setForeground(Color.white);
        cancelar.setBackground(Color.red);
        
        //Botao limpar
        limpar = new JButton("Limpar");
        limpar.setForeground(Color.white);
        limpar.setBackground(Color.blue);
        limpar.addActionListener(this);
        
        

    }
    
   private  void formatarCampo(JTextField campoTexto){
         try {
             MaskFormatter mascara = new MaskFormatter();
              if(campoTexto==fDtNascimento){
              mascara.setMask("##/##/####");
             mascara.install( fDtNascimento);
           }
              if(campoTexto==fPeso){
             mascara.setMask("###");
             mascara.install(fPeso);
              }
               
         } catch (ParseException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao formatar Campo de texto");
         }
    
    }
   
    public Container componentes() {
        inicializarComponentes();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes da primeira fila
        //Label Nome
        gbc.insets = new Insets(35, 15, -27, 0);//Insets de Label
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridx = 2;
        gbc.gridy = 0;
        painel.add(nome, gbc);
        
        //Label vazia
        Label vazia = new Label("");
        gbc.insets = new Insets(35, 15, -27, 0);//Insets de Label
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 0;
        painel.add(vazia, gbc);

        // Field nome
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        gbc.ipadx = 150;
        gbc.ipady = 10;
        gbc.gridx = 2;
        gbc.gridy=1;
        gbc.gridwidth = 2;
        painel.add(fNome, gbc);

        // SEGUNDA FILA --Especie
        // Label especie
         gbc.insets = new Insets(35, 15, -27, 0);//Insets de Label
        gbc.gridy = 2;
        gbc.gridx = 2;
        painel.add(especie, gbc);

        // Radios
        gbc.insets = new Insets(35, -10, -27, 0);//Insets e Field,RadioButton, Combobox
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        painel.add(rbcao, gbc);

        gbc.insets = new Insets(35, -4, -27, 0);
        gbc.gridx = 4;
        gbc.gridwidth = 1;
        painel.add(rbgato, gbc);

        // terceira --Raca
         // label raca
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridx = 2;
        gbc.gridy = 3;
        painel.add(raca, gbc);

        // box racas
        gbc.insets = new Insets(5, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        gbc.ipadx=80;
        gbc.ipady=10;
        gbc.gridx = 2;
        gbc.gridy=4;
        gbc.gridwidth = 1;
        painel.add(cRaca, gbc);
        
        //Label cores
        gbc.insets = new Insets(35, 15, -27, 0);//Insets de Label
        gbc.gridx = 2;
        gbc.gridy = 5;
        painel.add(cor, gbc);

        // Combobox cores
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        gbc.ipadx=80;
        gbc.ipady=10;
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        painel.add(cCor, gbc);

          // PESO DO ANIMAL
      
        //Label do peso
        gbc.gridx = 2;
        gbc.insets = new Insets(35, 15, -27, 0);//Insets de Label
        gbc.gridy = 7;
        painel.add(peso, gbc);
        
        //TextField do peso
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        gbc.gridx = 2;
        gbc.gridy=8;
        gbc.gridwidth = 1;
        painel.add(fPeso, gbc);

        // DATA DE NASCIMENTO
        //Label data de nascimento
        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.insets = new Insets(35, 15, -27, 0);//Insets de Label
        painel.add(dtNascimento, gbc);
          
        //TextField
         gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        gbc.gridx = 2;
        gbc.gridy=10;
        gbc.gridwidth = 1;
        painel.add(fDtNascimento, gbc);
        
        // Butoes de salvar,Cancelar e limpar
        //Botao salvar
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(35, 5, 40, 0);
        gbc.ipadx = 10;
        gbc.ipady = 5;
        gbc.gridx = 2;
        gbc.gridy = 11;
        painel.add(salvar, gbc);
        
        //Botao limpar
        gbc.gridx = 3;
        painel.add(limpar, gbc);

       //Botao cancelar
        gbc.gridx = 4;
        painel.add(cancelar, gbc);

        

        return painel;

    }

    public void criarJanela() {
        frame = new JFrame("CADASTRO ANIMAL");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(componentes());
        frame.pack();

    }

    public static void main(String[] args) {
        new Cadastro_Animal();

    }

 public void Limpar(){
     fNome.setText("");
     fPeso.setText("");
     fDtNascimento.setText("");
     cCor.setSelectedIndex(-1);
     cRaca.setSelectedIndex(-1);
     botoes.clearSelection();
     fNome.requestFocus();
     
 }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==limpar){
        Limpar();}
        }
}
