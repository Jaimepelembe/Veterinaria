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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;




public class Tabela_Consulta_Cliente {

    private JLabel nome, tel, morada;
    private JTextField fNome, fTel;
    private JFrame frame;
    private JComboBox cDistrito;
    private JTable tabela;
    private JButton bPesquisar;
    GridBagConstraints gbc = new GridBagConstraints();
       String[][] data = {
            { "Carlos lino", "84564031", "MATOLA" },
            { "Ana joaana", "846975478", "BOANE" } };
 
        // NOMES DAS COLUNAS
        String[] columnNames = { "NOME", "TELEFONE", "MORADA" };

    public Tabela_Consulta_Cliente(){
    //criarJanela();
    }
    
    

    public Container componentes() {

        JPanel painel = new JPanel() ;
      painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Componentes da primeira fila
        // nome
        gbc.insets = new Insets(35, 25, 0, 0);
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 1;
        nome = new JLabel("   Nome");
        nome.setForeground(Color.gray);
        gbc.gridx = 0;
        painel.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(35, 5, 0, 10);
        fNome = new JTextField(5);
        fNome.setColumns(17);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        painel.add(fNome, gbc);
        

        // SEGUNDA FILA
        // Label Telelfone
        gbc.insets = new Insets(35, 95, 0, 0);  
        gbc.gridy = 1;
        tel = new JLabel("Telefone ");
        tel.setForeground(Color.gray);
        gbc.gridx = 2;
        painel.add(tel, gbc);
            gbc.ipady = 6;
        // Field telefone
         gbc.insets = new Insets(35, 70, 0, 20);
        fTel = new JTextField();
        fTel.setColumns(9);
        gbc.gridx = 3;
        gbc.gridwidth = 1;
        painel.add(fTel, gbc);

        // terceira
        // Label distrito
        gbc.insets = new Insets(35, 25, 0, 0);
        gbc.gridy = 0;
        morada = new JLabel(" Morada");
        morada.setForeground(Color.gray);
        gbc.gridx = 0;
        painel.add(morada, gbc);

        // Box distrito
       gbc.insets = new Insets(35, 5, 0, 10);
        gbc.ipady = 5;
        String[] distritos = { "Matola", "Marracuene", "Manhiça", "Magude", "Moamba", "Boane", "Namaacha",
                "Matutuine" };
        cDistrito = new JComboBox(distritos);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        painel.add(cDistrito, gbc);
        
        
          // BOTAO PESQUISAR
        bPesquisar = new JButton("PESQUISAR");
        bPesquisar.setForeground(Color.WHITE);
        bPesquisar.setBackground(Color.blue);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(20, 15, -35, 0);
        painel.add(bPesquisar, gbc);
       
        
         //tabela
        gbc.insets = new Insets(50, 5, -32, 50);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.gridwidth = 4;
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
        frame = new JFrame("CONSULTAR CLIENTE");
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(880, 750);
        frame.add(componentes());
      //frame.add(tabela());
        //frame.pack();
 frame.setVisible(true);
    }

    public static void main(String[] args) {
     new Tabela_Consulta_Cliente();
     
        
        
    }

}
