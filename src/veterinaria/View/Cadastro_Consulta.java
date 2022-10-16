package veterinaria.View;

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

public class Cadastro_Consulta {
    private JLabel lab;
    private JButton bSalvar, bLimpar, bCancelar;
    private JTextField fPreco, fDtrealizacao;
    private JComboBox cbNome;
    private String[] nomes = {"Hemograma", "Exame de rins" ,"Exame de fígado", "Raio-x" }; 
    private JFrame frame;
    private JPanel painel;
    private GridBagConstraints gbc = new GridBagConstraints();
    public Cadastro_Consulta(){
        criarJanela();
    }
      
    public Container componentes(){
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // nome
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 0;
        lab = new JLabel("Nome ");
        gbc.gridx = 0;
        painel.add(lab, gbc);

        // ComboBox nome
        gbc.insets = new Insets(35, 5, 0, 10);
        cbNome = new JComboBox(nomes);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        painel.add(cbNome, gbc);

          // Preco consulta
          gbc.insets = new Insets(35, 15, 20, 0);
          gbc.gridy = 1;
          lab = new JLabel("Preco da consulta ");
          gbc.gridx = 0;
          painel.add(lab, gbc);
  
          gbc.insets = new Insets(35, 5, 20, 20);
          fPreco = new JTextField(5);
          fPreco.setColumns(10);
          gbc.gridx = 1;
          gbc.gridwidth = 1;
          painel.add(fPreco, gbc);
          // label kg
          lab = new JLabel("MZN");
          gbc.gridx = 2;
          gbc.gridwidth = 1;
          painel.add(lab, gbc);

             // Data Real
             gbc.insets = new Insets(35, 15, 20, 0);
             gbc.gridy = 2;
             lab = new JLabel("Data da consulta ");
             gbc.gridx = 0;
             painel.add(lab, gbc);
            //field
             gbc.insets = new Insets(35, 5, 20, 20);
             fPreco = new JTextField(5);
             fPreco.setColumns(10);
             gbc.gridx = 1;
             gbc.gridwidth = 1;
             painel.add(fPreco, gbc);
      // Butoes de baixo
      gbc.insets = new Insets(35, 5, 40, 10);
      // gbc.ipadx = 35;
      gbc.ipady = 5;
      gbc.gridy = 4;
      bSalvar = new JButton("Salvar");
      gbc.gridx = 1;
      bSalvar.setForeground(Color.white);
      bSalvar.setBackground(Color.green);
      painel.add(bSalvar, gbc);

      bCancelar = new JButton("Cancelar");
      gbc.gridx = 3;
      bCancelar.setForeground(Color.white);
      bCancelar.setBackground(Color.red);
      painel.add(bCancelar, gbc);

      bLimpar = new JButton("Limpar");
      bLimpar.setForeground(Color.white);
      bLimpar.setBackground(Color.blue);
      gbc.gridx = 2;
      painel.add(bLimpar, gbc);

   
return painel;
    }
    
    public void criarJanela() {
        frame = new JFrame("CADASTRO DE CLIENTE");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(componentes());
        frame.pack();

    }

    public static void main(String[] args) {
     new Cadastro_Consulta();
        
        
    }


}
