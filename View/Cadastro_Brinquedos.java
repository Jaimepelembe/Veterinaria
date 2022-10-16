
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Container;

public class Cadastro_Brinquedos {
    private JLabel lNome, lUnidade, lMaterial, lCor, lPreco_Aquisicao;
    private JButton bSalvar, bLimpar, bCancelar;
    private JFrame janela;
    private JSpinner spUnidades;
    private JPanel pPrincipal;
    private JRadioButton rbPlastico, rbPano;
    private ButtonGroup botoes;
    private JTextField tfPreco_Aquisicao;
    private JComboBox cbNome, cbCor;
    private float Preco_Aquisicao;
    private GridBagConstraints gbc = new GridBagConstraints();

    private String[] listaNome = { "Corda", "Bolinhas", "Frisbee", "Ossinho" };
    private String[] listaCores = { "Preto", "Azul", "Vermelho", "Verde" };

    public Cadastro_Brinquedos() {
        createWindow();
    }

    public Container adicionarComponentes() {
        pPrincipal = new JPanel(new GridBagLayout());
        pPrincipal.setBackground(Color.white);

        // Nome
        lNome = new JLabel("Nome");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 15, 0, 0);// Insets de Label
        pPrincipal.add(lNome, gbc);

        cbNome = new JComboBox(listaNome);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.ipadx = 35;
        gbc.ipady = 5;
        gbc.insets = new Insets(35, 5, 0, 10);// Insets e Field,RadioButton, Combobox
        pPrincipal.add(cbNome, gbc);

        // Cor
        lCor = new JLabel("Cor");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 15, 0, 0);// Insets de Label
        pPrincipal.add(lCor, gbc);

        cbCor = new JComboBox(listaCores);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 0, 10);// Insets e Field,RadioButton, Combobox
        pPrincipal.add(cbCor, gbc);

        // Preco Aquisicao
        lPreco_Aquisicao = new JLabel("Preco Aquisição");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 15, 0, 0);// Insets de Label
        pPrincipal.add(lPreco_Aquisicao, gbc);

        tfPreco_Aquisicao = new JTextField();
        tfPreco_Aquisicao.setToolTipText("Insira o valor pelo qual adiquiriu o produto");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 0, 10);// Insets e Field,RadioButton, Combobox
        pPrincipal.add(tfPreco_Aquisicao, gbc);

        // Unidade
        lUnidade = new JLabel("Unidades");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 15, 0, 0);// Insets de Label
        pPrincipal.add(lUnidade, gbc);

        spUnidades = new JSpinner();
        spUnidades.setValue(1);
        // spQuantidade.setSize(1, 0);
        spUnidades.setToolTipText("Indique a quantidade de unidades");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 0, 10);// Insets e Field,RadioButton, Combobox
        pPrincipal.add(spUnidades, gbc);

        // Radio Buttons
        lMaterial = new JLabel("Tipo de material");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 15, 0, 0);// Insets de Label
        pPrincipal.add(lMaterial, gbc);
        botoes = new ButtonGroup();
        rbPlastico = new JRadioButton("Plastico");
        rbPlastico.setBackground(Color.WHITE);
        rbPano = new JRadioButton("Pano");
        rbPano.setBackground(Color.WHITE);

        botoes.add(rbPlastico);
        botoes.add(rbPano);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 0, 10);// Insets e Field,RadioButton, Combobox
        pPrincipal.add(rbPlastico, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(35, 5, 0, 10);// Insets e Field,RadioButton, Combobox
        pPrincipal.add(rbPano, gbc);

       

        return pPrincipal;
    }

    public void createWindow() {
        janela = new JFrame("CADASTRO DE BRINQUEDO");
        // janela.setLayout(new GridBagLayout());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setBackground(Color.WHITE);
        // Adicicao dos componentes a janela

        janela.add(adicionarComponentes());
        janela.pack();
        janela.setVisible(true);
    }

    public static void main(String[] args) {
        new Cadastro_Brinquedos();
    }

}
