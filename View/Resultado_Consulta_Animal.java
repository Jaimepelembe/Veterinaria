/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author multi
 */

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
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
public class Resultado_Consulta_Animal {
     private JLabel nome, especie, raca, cor, dtNascimento, peso, kg;
    private JButton bSalvar, bCancelar, bEliminar,bHistorico;
    private JTextField fNome, fPeso, fDtNascimento;
    private JFrame frame;
    private JComboBox cRaca, cCor;
    private ButtonGroup botoes;
    private JRadioButton rbcao, rbgato;
    private String[] racas_caes = {"Pastor Alemao", "Pitbull", "Pastor Belga", "Chiuaua","Husky siberiano","Chow chow","Doberman","outro"};
    private String [] racas_gatos={"Persa","Sphynx","British Shorthair","Maine Coon","Bengal","Ragdoll","Munchkin","outro"};
     private String[] cores = {"Branco", "Cizento", "Azul", "Amarelo"};
    GridBagConstraints gbc = new GridBagConstraints();

    public Resultado_Consulta_Animal() {
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
        fDtNascimento = new JTextField(5);
        fDtNascimento.setColumns(10);
        
        //Peso
        peso = new JLabel("Peso ");
        fPeso = new JTextField(5);
        fPeso.setColumns(10);
        
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
      
      
    public Container adicionarComponentes() {
        inicializarComponentes();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes da primeira fila
        // nome
        gbc.insets = new Insets(35, 15, 0, 0);//Insets de Label
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 0;
        //Label Nome
        gbc.gridx = 0;
        painel.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(35, 5, 0, 10);//Insets e Field,RadioButton, Combobox

        gbc.gridx = 1;
        gbc.gridwidth = 3;
        painel.add(fNome, gbc);

        // SEGUNDA FILA --Especie
        // Label especie
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 1;
        gbc.gridx = 0;
        painel.add(especie, gbc);

        // Radios
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(rbcao, gbc);

        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        painel.add(rbgato, gbc);

        // terceira --Raca
         // raca
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 2;
        gbc.gridx = 0;
        painel.add(raca, gbc);

        // box racas
        gbc.insets = new Insets(35, 5, 0, 20);
        gbc.ipady = 5;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cRaca, gbc);
        
        // cores
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 3;
        //Label
        gbc.gridx = 0;
        painel.add(cor, gbc);

        // Combobox cores
        gbc.insets = new Insets(35, 5, 0, 20);
        gbc.ipady = 5;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cCor, gbc);

          // PESO DO ANIMAL
        gbc.insets = new Insets(35, 15, 20, 0);
        gbc.gridy = 4;
        //Label do peso
        gbc.gridx = 0;
        painel.add(peso, gbc);

        gbc.insets = new Insets(35, 5, 20, 20);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(fPeso, gbc);
        // label kg
        kg = new JLabel("KG");
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        painel.add(kg, gbc);
       

        // DATA DE NASCIMENTO
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 5;

        //Label data de nascimento
        gbc.gridx = 0;
        painel.add(dtNascimento, gbc);
          //TextField
        gbc.insets = new Insets(35, 5, 0, 20);
        
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(fDtNascimento, gbc);

       
        
        // Butoes de salvar,Cancelar e limpar
        //Botao salvar
        gbc.insets = new Insets(35, 10, 10, 10);
        gbc.gridwidth = 1;
        gbc.ipady = 5;
        gbc.gridx = 0;
        gbc.gridy = 6;
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
    
   public void criarJanela() {
        frame = new JFrame("Resultado Consulta Animal");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(adicionarComponentes());
        frame.pack();

    }  
    public static void main(String[] args) {
        new Resultado_Consulta_Animal();
    }
}
