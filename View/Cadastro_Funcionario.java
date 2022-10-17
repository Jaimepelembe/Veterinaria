/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria.View;
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

public class Cadastro_Funcionario {
    private JLabel nome, tel, morada, preco;
    private JButton salvar, cancelar, limpar;
    private JTextField fNome, fTel,fPreco;
    private JFrame frame;
    private JComboBox cDistrito,cBairro;
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Funcionario(){
    criarJanela();
    }

    public Container componentes() {

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
        nome = new JLabel("Nome ");
        gbc.gridx = 0;
        painel.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(35, 5, 0, 10);
        fNome = new JTextField(5);
        fNome.setColumns(10);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        painel.add(fNome, gbc);

        // SEGUNDA FILA
        // Label Telelfone
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.gridy = 1;
        tel = new JLabel("Telefone ");
        gbc.gridx = 0;
        painel.add(tel, gbc);

        // Field telefone
        gbc.insets = new Insets(35, 5, 0, 10);
        fTel = new JTextField();
        fTel.setColumns(10);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        painel.add(fTel, gbc);

        // terceira
        // Label distrito
        gbc.insets = new Insets(35, 15, 40, 0);
        gbc.gridy = 2;
        morada = new JLabel("Morada");
        gbc.gridx = 0;
        painel.add(morada, gbc);

        // Box distrito
        gbc.insets = new Insets(35, 5, 40, 20);
        gbc.ipady = 5;
        String[] distritos = { "Matola", "Marracuene", "Manhiça", "Magude", "Moamba", "Boane", "Namaacha", "Matutuine" };
        cDistrito = new JComboBox(distritos);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cDistrito, gbc);
        
         
        
          // Salario do funcionario
          gbc.insets = new Insets(35, 15, 20, 0);
          gbc.gridy = 3;
          preco = new JLabel("Salario do Funcionario ");
          gbc.gridx = 0;
          painel.add(preco, gbc);
  
          gbc.insets = new Insets(35, 5, 20, 20);
          fPreco = new JTextField(5);
          fPreco.setColumns(10);
          gbc.gridx = 1;
          gbc.gridwidth = 1;
          painel.add(fPreco, gbc);
          // label mzn
          preco = new JLabel("MZN");
          gbc.gridx = 2;
          gbc.gridwidth = 1;
          painel.add(preco, gbc);

        // Butoes de baixo
        gbc.insets = new Insets(35, 5, 40, 10);
        // gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 4;
        salvar = new JButton("Salvar");
        gbc.gridx = 1;
        salvar.setForeground(Color.white);
        salvar.setBackground(Color.green);
        painel.add(salvar, gbc);

        cancelar = new JButton("Cancelar");
        gbc.gridx = 3;
        cancelar.setForeground(Color.white);
        cancelar.setBackground(Color.red);
        painel.add(cancelar, gbc);

        limpar = new JButton("Limpar");
        limpar.setForeground(Color.white);
        limpar.setBackground(Color.blue);
        gbc.gridx = 2;
        painel.add(limpar, gbc);
        
        
        
        
        //EVENTOS
        /* ActionListener a = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //if(cMoeda.equals("Euro")){
                String s = (String) cDistrito.getSelectedItem();
               if(s == "Matola"){String[] matola = {"cadda","fjkafak"};}
               else if(s == "Machava"){  cBairro.addItem(null);;}
               else if(s == "Machava"){  cBairro.addItem(null);;}
               else if(s == "Machava"){  cBairro.addItem(null);;}
               else if(s == "Machava"){  cBairro.addItem(null);;}
               else if(s == "Machava"){  cBairro.addItem(null);;}
               else if(s == "Machava"){  cBairro.addItem(null);;}
        }};
        cDistrito.addActionListener(a);*/

        return painel;

    }

    public void criarJanela() {
        frame = new JFrame("CADASTRO DE FUNCIONARIO");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(componentes());
        frame.pack();

    }

    public static void main(String[] args) {
     new Cadastro_Funcionario();
        
        
    }

}
