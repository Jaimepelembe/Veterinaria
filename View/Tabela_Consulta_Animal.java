/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class Tabela_Consulta_Animal {

    private JLabel nome, tel, especie, raca, cor;
    private JTextField fNome, fTel;
    private JFrame frame;
    private JComboBox cCores, cRacas;
    private JTable tabela;
    private JButton bPesquisar;
    private ButtonGroup botoes;
    private JRadioButton rbcao, rbgato;
    GridBagConstraints gbc = new GridBagConstraints();
       String[][] data = {
            { "Rex", "Canino", "PitBull", "Preto"},
            { "Kitty", "Felino", "Gatao", "Branco"} };
 
        // NOMES DAS COLUNAS
        String[] columnNames = { "NOME", "ESPECIE", "RAÇA", "COR"};

    public Tabela_Consulta_Animal(){
    criarJanela();
    }
    
    public void inicializar(){
        
        
        
        
    //Especie
        especie = new JLabel("Especie ");
        botoes = new ButtonGroup();
        rbcao = new JRadioButton("Cão");
        rbcao.setBackground(Color.WHITE);
        rbgato = new JRadioButton("Gato");
        rbgato.setBackground(Color.WHITE);
        botoes.add(rbcao);
        botoes.add(rbgato);
    }

    public Container componentes() {
        inicializar();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes da primeira fila
       
        // ESPECIES
        // Label ESPECIES
        /*gbc.insets = new Insets(35, 15, -17, 0);
        gbc.gridy = 0;
        especie = new JLabel("Especie");
        especie.setForeground(Color.gray);
        gbc.gridx = 1;
        painel.add(especie, gbc);*/
        //butoes
        gbc.gridy = 0;
        gbc.insets = new Insets(-300, 15, -17, 0);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
       // painel.add(rbcao, gbc);
        gbc.insets = new Insets(-300, 15, -17, 0);
        gbc.gridx = 2;
        gbc.gridwidth = 1;
       // painel.add(rbgato, gbc);
        
       //RACA DO ANIMAL
        gbc.insets = new Insets(28, 15, -10, 0);
        gbc.gridy = 2;
        raca = new JLabel("Raça");
        raca.setForeground(Color.gray);
        gbc.gridx = 1;
        painel.add(raca, gbc); 

        // Box racas
        gbc.gridy = 3;
       gbc.insets = new Insets(30, 5, 0, 10);
        gbc.ipady = 5;
        gbc.ipadx =100;
         String[] racas = {"Pastor Alemao", "Pitbull", "Pastor Belga", "Chiuaua"};
        cRacas = new JComboBox(racas);
        
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cRacas, gbc);
       
        //COR DO ANIMAL
        gbc.insets = new Insets(12, 15, -10, 0);
        gbc.gridy = 2;
        cor = new JLabel("Cor");
        cor.setForeground(Color.gray);
        gbc.gridx = 2;
        painel.add(cor, gbc); 

        // Box cores
        gbc.gridy = 3;
       gbc.insets = new Insets(30, 5, 0, 10);
        gbc.ipady = 5;
        gbc.ipadx =100;
        String[] cores = {"Branco", "Cizento", "Azul", "Amarelo"};
        cCores = new JComboBox(cores);
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        painel.add(cCores, gbc);
        
         // nome
         gbc.gridwidth = 0;
        gbc.insets = new Insets(25, 15, -35, 0);
        gbc.ipadx = 20;
        gbc.ipady = 5;
        gbc.gridy = 5;
        nome = new JLabel("Nome ");
        nome.setForeground(Color.gray);
        gbc.gridx = 1;
        painel.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(5, 55, 20, 50);
        fNome = new JTextField(5);
        fNome.setColumns(25);
        gbc.ipady =10;
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(fNome, gbc);
        
          // BOTAO PESQUISAR
        bPesquisar = new JButton("PESQUISAR");
        bPesquisar.setForeground(Color.WHITE);
        bPesquisar.setBackground(Color.blue);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 5, 20, 50);
        gbc.ipadx = -2;
        painel.add(bPesquisar, gbc);

        
         //tabela
        gbc.insets = new Insets(5, 5, -35, 0);
        gbc.gridy = 7;
        gbc.gridx = 1;
        gbc.gridwidth = 5;
        // INICIALIZANDO
        tabela = new JTable(data, columnNames);
        tabela.setBounds(30, 40, 200, 300);
        painel.add(tabela, gbc);
        
        

        // SCROLL PANE
        JScrollPane sp = new JScrollPane(tabela);
        painel.add(sp, gbc);

        return painel;

    }

    public void criarJanela() {
        frame = new JFrame("CONSULTAR ANIMAL");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 650);
        frame.add(componentes());
      //frame.add(tabela());
       // frame.pack();
frame.setVisible(true);
    }

    public static void main(String[] args) {
     new Tabela_Consulta_Animal();
     
        
        
    }

}
