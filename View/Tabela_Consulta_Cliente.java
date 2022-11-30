/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AnimalController;
import Controller.ClienteController;
import Controller.Validacao;
import Model.DAO.ExceptionDAO;
import Model.VO.Cliente;
import com.itextpdf.text.DocumentException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Tabela_Consulta_Cliente extends MouseAdapter implements ActionListener {

    private JLabel nome, tel, morada;
    private JTextField fNome;
    private JFrame frame;
    private JComboBox cDistrito;
    private JTable tabela;
    private JButton bPesquisar, bRelatorio;
    private JPanel pPrincipal, pTabela, painel;
    private Vector<Cliente> clientes;
    private GridBagConstraints gbc = new GridBagConstraints();
    private String[] distritos = {"Matola", "Marracuene", "Manhiça", "Magude", "Moamba", "Boane", "Namaacha",
        "Matutuine"};
    Color corSalvar = new Color(0.05f, 0.72f, 0.08f, 1.0f);
    Color corLimpar = new Color(0.05f, 0.31f, 0.72f, 1.0f);
    Validacao vv = new Validacao();

    public Tabela_Consulta_Cliente() {
        inicializarComponentes();
        //criarJanela();
    }

    private void inicializarComponentes() {
        painel = new JPanel();
        painel.setBackground(Color.white);
        painel.setLayout(new GridBagLayout());
        //Label Nome
        nome = new JLabel("   Nome");
        nome.setForeground(Color.gray);
        //TextField Nome
        fNome = new JTextField(5);
        fNome.setColumns(17);

        //Label Morada
        morada = new JLabel(" Morada");
        morada.setForeground(Color.gray);

        //Combobox Morada
        cDistrito = new JComboBox(distritos);
        cDistrito.setSelectedIndex(-1);
        cDistrito.addActionListener(this);

        //Botoes
        //Pesquisar
        bPesquisar = new JButton("PESQUISAR");
        bPesquisar.setForeground(Color.WHITE);
        bPesquisar.setBackground(corLimpar);
        bPesquisar.addActionListener(this);
        bPesquisar.setFocusPainted(false);

        //Botao de relatorio
        bRelatorio = new JButton("Relatorio");
        bRelatorio.setForeground(Color.WHITE);
        bRelatorio.setBackground(Color.DARK_GRAY);
        bRelatorio.setFocusPainted(false);
        bRelatorio.addActionListener(this);

    }

    private Container adicionarComponentes() {
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label morada
        gbc.insets = new Insets(35, 25, 0, 0);
        gbc.gridy = 0;
        gbc.gridx = 0;
        painel.add(morada, gbc);

        // ComboBox Morada
        gbc.insets = new Insets(35, 5, 0, 10);
        gbc.ipady = 5;
        gbc.ipadx = 10;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        painel.add(cDistrito, gbc);

        // nome
        gbc.insets = new Insets(35, 25, 30, 0);
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.gridy = 1;
        gbc.gridx = 0;
        painel.add(nome, gbc);

        // Field nome
        gbc.insets = new Insets(35, 5, 20, 10);
        gbc.gridx = 1;
        gbc.gridwidth = 1;
        painel.add(fNome, gbc);

        // BOTAO PESQUISAR
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 20, 10);
        painel.add(bPesquisar, gbc);

        //Botao de relatorio
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(35, 15, 20, 0);
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        painel.add(bRelatorio, gbc);
        return painel;

    }

    public Container painelPrincipal() {
        pPrincipal = new JPanel(new BorderLayout());
        pPrincipal.setBackground(Color.white);
        pPrincipal.setForeground(Color.white);
        pPrincipal.add(adicionarComponentes(), BorderLayout.CENTER);
        pPrincipal.add(painelTabela(), BorderLayout.PAGE_END);

        return pPrincipal;
    }

    private Container painelTabela() {
        Object[][] data = {};
        String[] colunas = {"ID", "NOME", "TELEFONE", "MORADA"
        };
        pTabela = new JPanel(new BorderLayout());
        pTabela.setBackground(Color.white);
        pTabela.setForeground(Color.white);
        // INICIALIZANDO a tabela
        tabela = new JTable(data, colunas);
        tabela.setBounds(30, 40, 200, 300);
        // tabela.setForeground(Color.white);
        //tabela.setBackground(Color.white);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
                data,
                colunas
        ) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        tabela.addMouseListener(this);

        // Adicionar a tabela ap SCROLL PANE
        JScrollPane sp = new JScrollPane(tabela);
        sp.setForeground(Color.white);
        sp.setBackground(Color.white);
        pTabela.add(sp, BorderLayout.CENTER);
        return pTabela;
    }

    private void selecionarCliente() {//Levar todos atributos e passar para tela de cadastro
        Integer linha = tabela.getSelectedRow();
        int id = (Integer) tabela.getModel().getValueAt(linha, 0);
        String nome = (String) tabela.getModel().getValueAt(linha, 1);
        String telefone = (String) tabela.getModel().getValueAt(linha, 2);
        String morada = (String) tabela.getModel().getValueAt(linha, 3);
        Cadastro_Cliente cliente = new Cadastro_Cliente();
        cliente.selecionarCliente(id, nome, telefone, morada);

    }

    private void pesquisarClienteMorada() {
        String morada = "";
        if (cDistrito.getSelectedItem() != null) {
            morada = cDistrito.getSelectedItem().toString();
        }
        try {
            if (morada != null && morada.length() > 0) {
                DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
                modelo.setRowCount(0);
                ClienteController cliente = new ClienteController();
                clientes = cliente.pesquisarClienteMorada(morada);
                clientes.forEach((Cliente cli) -> {
                    modelo.addRow(new Object[]{cli.getIdCliente(), cli.getNome(), cli.getTelefone(), cli.getMorada()});
                });
                tabela.setModel(modelo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o actor" + ex);
        }
    }

    private void pesquisarClienteNome() {
        String nome = "";
        nome = fNome.getText();

        try {
            if (nome != null && nome.length() > 0) {
                DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
                modelo.setRowCount(0);
                ClienteController cliente = new ClienteController();
                clientes = cliente.pesquisarClienteNome(nome);
                clientes.forEach((Cliente cli) -> {
                    modelo.addRow(new Object[]{cli.getIdCliente(), cli.getNome(), cli.getTelefone(), cli.getMorada(), cli.getNrAnimsais()});
                });
                tabela.setModel(modelo);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o actor" + ex);
        }
    }

    private void gerarRelatorio() throws DocumentException, IOException, FileNotFoundException, ClassNotFoundException, ExceptionDAO {
        new ClienteController().gerarRelatorio(clientes);

    }

    private void criarJanela() {
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(880, 750);
        frame.add(painelPrincipal());
        //frame.add(tabela());
        //frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Tabela_Consulta_Cliente();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Evento para selecionar o distritos dos clientes
        if (e.getSource() == cDistrito) {
            pesquisarClienteMorada();
            fNome.setText("");
        }

        //Evento para selecionar o cliente pelo nome
        if (e.getSource() == bPesquisar) {
            pesquisarClienteNome();
            cDistrito.setSelectedIndex(-1);
        }
        if (e.getSource() == bRelatorio) {
            try {
                gerarRelatorio();
            } catch (DocumentException ex) {
                Logger.getLogger(Tabela_Consulta_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Tabela_Consulta_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Tabela_Consulta_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ExceptionDAO ex) {
                Logger.getLogger(Tabela_Consulta_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void mouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            selecionarCliente();
        }
    }

}
