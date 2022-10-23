package View;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro_Cirurgia implements ActionListener {

    private JLabel lab;
    private JButton bSalvar, bLimpar, bCancelar;
    private JTextField fPreco, fData;
    private JComboBox cbNome;
    private String[] nomes = {"Castração", "Remoção de corpos estranhos", "Remoção de pedras na bexiga", "Correção de fraturas"};
    private JFrame frame;
    private JPanel painel;
    private GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Cirurgia() {
        criarJanela();
    }

    public void inicializarComponentes() {
        //Informacoes do nome
        cbNome = new JComboBox(nomes);
        cbNome.setSelectedIndex(-1);

        //TextField do preco da consulta
        fPreco = new JTextField(5);
        fPreco.setColumns(10);

        //TextFild data da cirurgia
        fData = new JTextField(5);
        fData.setColumns(10);

        //Botoes salvar,Sair e cancelar
        bSalvar = new JButton("Salvar");
        bSalvar.setForeground(Color.white);
        bSalvar.setBackground(Color.green);

        bCancelar = new JButton("Cancelar");
        bCancelar.setForeground(Color.white);
        bCancelar.setBackground(Color.red);

        bLimpar = new JButton("Limpar");
        bLimpar.setForeground(Color.white);
        bLimpar.setBackground(Color.blue);
        bLimpar.addActionListener(this);

    }

    public Container componentes() {
        inicializarComponentes();
        JPanel painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // nome
        gbc.insets = new Insets(35, 15, 0, 0);
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 0;
        lab = new JLabel("Nome");
        gbc.gridx = 0;
        painel.add(lab, gbc);

        // ComboBox nome
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(cbNome, gbc);

        // Preco consulta
        gbc.insets = new Insets(35, 15, 20, 0);
        gbc.gridy = 1;
        lab = new JLabel("Preco da Cirurgia");
        gbc.gridx = 0;
        painel.add(lab, gbc);
        //TexteField do preco da consulta
        gbc.insets = new Insets(35, 5, 20, 20);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(fPreco, gbc);

        // label kg
        lab = new JLabel("MZN");
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        painel.add(lab, gbc);

        // Data da Cirurgia
        gbc.insets = new Insets(35, 15, 20, 0);
        gbc.gridy = 2;
        lab = new JLabel("Data da cirurgia");
        gbc.gridx = 0;
        painel.add(lab, gbc);

        //field data cirurgia
        gbc.insets = new Insets(35, 5, 20, 20);
        gbc.gridx = 1;
        gbc.ipadx = 5;
        painel.add(fData, gbc);

        // Butoes salvar,limpar e cancelar
        //Botao salvar
        gbc.insets = new Insets(35, 5, 40, 10);
        gbc.ipady = 5;
        gbc.ipadx = 5;
        gbc.gridy = 3;
        gbc.gridx = 1;
        gbc.weightx = 1;
        painel.add(bSalvar, gbc);

        //Botao cancelar
        gbc.gridx = 3;
        gbc.ipadx = 5;
        painel.add(bCancelar, gbc);

        //Botao limpar
        gbc.gridx = 2;
        gbc.ipadx = 5;
        painel.add(bLimpar, gbc);

        return painel;
    }

    public void criarJanela() {
        frame = new JFrame("CADASTRO DA CIRURGIA");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.add(componentes());
        frame.pack();

    }

    public static void main(String[] args) {
        new Cadastro_Cirurgia();

    }

    public void Limpar() {
        cbNome.setSelectedIndex(-1);
        fPreco.setText("");
        fData.setText("");
        cbNome.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bLimpar) {
            Limpar();
        }
    }

}