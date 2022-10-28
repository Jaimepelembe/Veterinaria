/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author multi
 */

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.MaskFormatter;
public class Resultado_Consulta_Animal {
     private JLabel nome, especie, raca, cor, dtNascimento, peso, kg;
    private JButton bSalvar, bCancelar, bEliminar,bHistorico;
    private JTextField fNome;// fDtNascimento;
    private JFormattedTextField fDtNascimento,fPeso;
    private JFrame frame;
    private JComboBox cRaca, cCor;
    private JPanel pPrincipal;
    private ButtonGroup botoes;
    private JRadioButton rbcao, rbgato;
    private String[] racas_caes = {"Pastor Alemao", "Pitbull", "Pastor Belga", "Chiuaua","Husky siberiano","Chow chow","Doberman","outro"};
    private String [] racas_gatos={"Persa","Sphynx","British Shorthair","Maine Coon","Bengal","Ragdoll","Munchkin","outro"};
     private String[] cores = {"Branco", "Cizento", "Azul", "Amarelo"};
    GridBagConstraints gbc = new GridBagConstraints();

    public Resultado_Consulta_Animal() throws ParseException {
        criarJanela();
    }
   
    
 private void inicializarComponentes() throws ParseException {
        //Nome
        nome = new JLabel("Nome ");
        fNome = new JTextField();
        fNome.setColumns(15);

        //Especie
        especie = new JLabel("Especie ");
        botoes = new ButtonGroup();
        rbcao = new JRadioButton("Canino");
        rbcao.setBackground(Color.WHITE);
        rbgato = new JRadioButton("Felino");
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
        bSalvar = new JButton("Salvar");
        bSalvar.setForeground(Color.white);
        bSalvar.setBackground(Color.green);
        
        //Botao Ver historico
        bHistorico = new JButton("Historico");
        bHistorico.setForeground(Color.white);
        bHistorico.setBackground(Color.blue);
        
        //Botao Eliminar
        bEliminar = new JButton("Eliminar");
        bEliminar.setForeground(Color.white);
        bEliminar.setBackground(Color.orange);
        
        //Botao cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar.setForeground(Color.white);
        bCancelar.setBackground(Color.red);
    }
      
  private Container adicionarComponentes() throws ParseException {
        inicializarComponentes();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes da primeira fila
        // nome
        gbc.insets = new Insets(15, 15, 0, 0);//Insets de Label
        gbc.gridy = 0;
        //Label Nome
        gbc.gridx = 0;
        painel.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(15, 5, 0, 10);//Insets e Field,RadioButton, Combobox
        gbc.ipadx = 15;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy=1;
        gbc.gridwidth = 2;
        painel.add(fNome, gbc);

        // SEGUNDA FILA --Especie
        // Label especie
        gbc.insets = new Insets(15, 15, 0, 0);
        gbc.gridy = 2;
        gbc.gridx = 0;
        painel.add(especie, gbc);

        // Radios
        gbc.insets = new Insets(15, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(rbcao, gbc);

        gbc.insets = new Insets(15, 5, 0, 10);
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        painel.add(rbgato, gbc);

        // terceira --Raca
         // raca
        gbc.insets = new Insets(20, 15, 0, 0);
        gbc.gridy = 3;
        gbc.gridx = 0;
        painel.add(raca, gbc);

        // box racas
        gbc.insets = new Insets(15, 5, 0, 20);
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy=4;
        gbc.gridwidth = 1;
        painel.add(cRaca, gbc);
        
        // cores
        gbc.insets = new Insets(15, 15, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 5;
        //Label
        painel.add(cor, gbc);

        // Combobox cores
        gbc.insets = new Insets(15, 5, 0, 20);
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy=6;
        gbc.gridwidth = 1;
        painel.add(cCor, gbc);

          // PESO DO ANIMAL
         //Label do peso
         gbc.insets = new Insets(15, 15, 20, 0);
         gbc.gridx = 0;
         gbc.gridy = 7;
        painel.add(peso, gbc);
        //TextField
        gbc.insets = new Insets(15, 5, 20, 20);
        gbc.ipady=10;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy=8;
        painel.add(fPeso, gbc);
        // label kg
        kg = new JLabel("KG");
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(kg, gbc);
       

        // DATA DE NASCIMENTO
        gbc.insets = new Insets(15, 15, 0, 0);
        //Label data de nascimento
        gbc.gridx = 0;
        gbc.gridy = 9;
        painel.add(dtNascimento, gbc);
          
        //TextField
        gbc.insets = new Insets(15, 5, 0, 20);
        gbc.ipady=10;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy=10;
        painel.add(fDtNascimento, gbc);

       
        
        // Butoes de salvar,Cancelar e limpar
        //Botao salvar
        gbc.insets = new Insets(35, 10, 10, 10);
        gbc.gridwidth = 1;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 11;
        painel.add(bSalvar, gbc);

      //Botao Eliminar
        gbc.gridx = 1;
        painel.add(bEliminar, gbc);

        //Botao Historico
        gbc.gridx = 2;
        painel.add(bHistorico,gbc);
        
        //Botao Cancelar
        gbc.gridx=3;
        painel.add(bCancelar,gbc);
        return painel;

    }
  
  private  void formatarCampo(JTextField campoTexto){
         try {
             MaskFormatter mascara = new MaskFormatter();
              if(campoTexto==fDtNascimento){
              mascara.setMask(" ## / ## / ####");
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
  public Container painelPrincipal() throws ParseException{
      pPrincipal= new JPanel(new BorderLayout());
  pPrincipal.add(adicionarComponentes(),BorderLayout.CENTER);
  return pPrincipal;}
  
  private void criarJanela() throws ParseException {
        frame = new JFrame("Resultado Consulta Animal");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(painelPrincipal());
        frame.pack();

    }  
    public static void main(String[] args) throws ParseException {
        new Resultado_Consulta_Animal();
    }
}
