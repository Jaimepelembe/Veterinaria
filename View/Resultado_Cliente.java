/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author multi
 */

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
import javax.swing.JComboBox;

public class Resultado_Cliente {
    private JLabel nome, tel, morada;
    private JButton bSalvar, bCancelar, bEliminar,bAnimal;
    private JTextField fNome, fTel;
    private JFrame frame;
    private JComboBox cDistrito;
    GridBagConstraints gbc = new GridBagConstraints();
Color corSalvar = new Color(0.05f, 0.72f, 0.08f, 1.0f);
    Color corLimpar = new Color(0.05f, 0.31f, 0.72f, 1.0f);
    public Resultado_Cliente() {
        criarJanela();
    }
    
    public void inicializarComponentes(){
    //Informacoes do nome
    //Label
    nome = new JLabel("Nome ");
    
   //TextField
    fNome = new JTextField(5);
    fNome.setColumns(10);
    
    //informacoes do telefone
    //Label
     tel = new JLabel("Telefone ");
     //TextField
     fTel = new JTextField();
     fTel.setColumns(10);
     
     //Informacoes da morada
     //Label
     morada = new JLabel("Morada");
     //ComboBox
      String[] distritos = { "Matola", "Marracuene", "Manhiça", "Magude", "Moamba", "Boane", "Namaacha",
                "Matutuine" };
        cDistrito = new JComboBox(distritos);
        cDistrito.setSelectedIndex(-1);
        
     //Botoes 
     //Salvar
       bSalvar = new JButton("Salvar");
       bSalvar.setForeground(Color.white);
       bSalvar.setBackground(corSalvar);
       
       //Adicionar Animal
       bAnimal= new JButton("Adicionar Animal");
       bAnimal.setForeground(Color.white);
       bAnimal.setBackground(corLimpar);
       
      //Eliminar
       bEliminar = new JButton("Eliminar");
       bEliminar.setForeground(Color.white);
       bEliminar.setBackground(Color.ORANGE);
       
       //Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar .setForeground(Color.white);
        bCancelar .setBackground(Color.red);
  
    }

    public Container adicionarComponentes() {
        inicializarComponentes();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes da primeira fila
        // nome
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 0;
        
        //Label nome
        gbc.gridx = 0;
        painel.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        painel.add(fNome, gbc);

        // SEGUNDA FILA
        // Label Telelfone
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 1;
        gbc.gridx = 0;
        painel.add(tel, gbc);

        // Field telefone
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(fTel, gbc);

        // terceira
        // Label morada
        gbc.insets = new Insets(35, 15, 40, 0);
        gbc.gridy = 2;
        
        gbc.gridx = 0;
        painel.add(morada, gbc);

        // ComboBox morada
        gbc.insets = new Insets(35, 5, 40, 20);
        gbc.ipady = 5;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cDistrito, gbc);

        // Botoes de baixo
       
        //Botao Salvar
        gbc.insets = new Insets(35, 5, 40, 10);
        gbc.ipady = 5;
        gbc.ipadx = 35;
        gbc.gridy = 3;
        gbc.gridx = 0;
        painel.add(bSalvar, gbc);

        //Adicionar animal
        gbc.gridx = 1;
        painel.add(bAnimal, gbc);
        
        //Eliminar
        gbc.gridx=2;
        painel.add(bEliminar,gbc);
        
       //Cancelar
        gbc.gridx = 3;
       painel.add( bCancelar , gbc);

        return painel;

    }

    public void criarJanela() {
        frame = new JFrame("RESULTADO DA PESQUISA DO CLIENTE");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(adicionarComponentes());
        frame.pack();
       

    }
    
    public static void main(String[] args) {
        new Resultado_Cliente ();
    }
}

