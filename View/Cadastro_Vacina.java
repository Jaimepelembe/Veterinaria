package View;


import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class Cadastro_Vacina {
    private JLabel lab;
    private JButton bSalvar, bLimpar, bCancelar;
    private JTextField  tfNome, tfQuantidade, tfPreco_Aquisicao, tfValidade, tfTemperatura;
    private JComboBox cbMarca, cbNome;
    private String[] listaMarca = { "Zoetis", "Boehringer ingelheim", "VANGUARD ", "SERUM INSTITUTE OF INDIA PVT" };
    private String[] Vacinas_Caes = { "Polivalente (V10)", "Antirrábica", "Contra a gripe", "contra Giárdia", "Esgana",
            "Parvovirose" };
    private String[] Vacinas_Gatos = { "Panleucopénia felina", "Antirrábica", "RinoTranquete" };
    private JPanel pPrincipal;

    private JFrame janela;
    private JSpinner spQuantidade, spUnidades;
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Vacina() {
        createWindow();
    }

    public Container AdicionarComponentes() {
        JPanel pPrincipal = new JPanel(new GridBagLayout());

        // informacoes Marca
        lab = new JLabel("Marca:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);

        cbMarca = new JComboBox<>(listaMarca);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 15, 5, 0);
       // pPrincipal.add(tfMarca, gbc);

        // informacoes nome
        lab = new JLabel("Nome:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);

        cbNome = new JComboBox<>();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 15, 5, 0);
//        pPrincipal.add(tfNome, gbc);

        // Informacoes Quandidade
        lab = new JLabel("Quantidade:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);

        spQuantidade = new JSpinner();
        spQuantidade.setValue(1);

        // spQuantidade.setSize(1, 0);
        spQuantidade.setToolTipText("Indique a quantidade");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        // gbc.weightx = 0.5;
        gbc.ipadx = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(spQuantidade, gbc);
        // KG
        lab = new JLabel("ml");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 5, 0);
        pPrincipal.add(lab, gbc);

        // Preco Aquisicao
        lab = new JLabel("Preco Aquisição:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);

        tfPreco_Aquisicao = new JTextField();
        tfPreco_Aquisicao.setToolTipText("Insira o valor pelo qual adiquiriu o produto");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 0, 0);
        pPrincipal.add(tfPreco_Aquisicao, gbc);

        // Temperatura Conservacao
        lab = new JLabel("Temperatura Conservação:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);

        tfTemperatura = new JTextField();
        tfTemperatura.setColumns(10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(tfTemperatura, gbc);

        // Validade
        lab = new JLabel("Data validade:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);

        tfValidade = new JTextField();
        tfValidade.setColumns(10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(tfValidade, gbc);

        // Unidade
        lab = new JLabel("Unidades:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lab, gbc);

        spUnidades = new JSpinner();
        spUnidades.setValue(1);
        // spQuantidade.setSize(1, 0);
        spUnidades.setToolTipText("Indique a quantidade de unidades");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(spUnidades, gbc);

        // Botoes

        // Salvar
        bSalvar = new JButton("Salvar");
        bSalvar.setForeground(Color.BLUE);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 5, 0);
        pPrincipal.add(bSalvar, gbc);

        // limpar
        bLimpar = new JButton("Limpar");
        bLimpar.setForeground(Color.ORANGE);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(bLimpar, gbc);
        // Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar.setForeground(Color.RED);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(bCancelar, gbc);

        return pPrincipal;
    }

    public void createWindow() {
        janela = new JFrame("CADASTRO DA VACINA");
        janela.setLayout(new GridBagLayout());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        // Adicicao dos componentes a janela
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        // gbc.gridwidth = 1;
        janela.add(AdicionarComponentes(), gbc);
        janela.pack();
        janela.setVisible(true);

    }

    public static void main(String[] args) {
        new Cadastro_Vacina();
    }
}