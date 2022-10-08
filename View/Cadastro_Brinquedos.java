
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
    private JLabel lNome, lUnidade, lMaterial, lCor;
    private JButton bSalvar, bLimpar, bCancelar;
    private JFrame janela;
    private JSpinner spUnidades;
    private JPanel pPrincipal;
    private JRadioButton rbPlastico, rbPano;
    private ButtonGroup botoes;
    private JComboBox cbNome, cbCor;
    private String[] listaNome = { "Corda", "Bolinhas", "Frisbee", "Ossinho" };
    private String[] listaCores = { "Preto", "Azul", "Vermelho", "Verde" };
    private GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Brinquedos() {
        createWindow();
    }

    public Container adicionarComponentes() {
        pPrincipal = new JPanel(new GridBagLayout());

        // Nome
        lNome = new JLabel("Nome:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lNome, gbc);

        cbNome = new JComboBox(listaNome);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(cbNome, gbc);

        // Cor
        lCor = new JLabel("Cor:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lCor, gbc);

        cbCor = new JComboBox(listaCores);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(cbCor, gbc);

        // Unidade
        lUnidade = new JLabel("Unidades:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lUnidade, gbc);

        spUnidades = new JSpinner();
        spUnidades.setValue(1);
        // spQuantidade.setSize(1, 0);
        spUnidades.setToolTipText("Indique a quantidade de unidades");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(spUnidades, gbc);

        // Radio Buttons
        lMaterial = new JLabel("Tipo de material:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lMaterial, gbc);
        botoes = new ButtonGroup();
        rbPlastico = new JRadioButton("Plastico");
        rbPano = new JRadioButton("Pano");

        botoes.add(rbPlastico);
        botoes.add(rbPano);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(rbPlastico, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(rbPano, gbc);

        // Botoes

        // Salvar
        bSalvar = new JButton("Salvar");
        bSalvar.setForeground(Color.BLUE);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 5, 0);
        pPrincipal.add(bSalvar, gbc);

        // limpar
        bLimpar = new JButton("Limpar");
        bLimpar.setForeground(Color.ORANGE);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(bLimpar, gbc);
        // Cancelar
        bCancelar = new JButton("Cancelar");
        bCancelar.setForeground(Color.RED);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(bCancelar, gbc);

        return pPrincipal;
    }

    public void createWindow() {
        janela = new JFrame();
        janela.setLayout(new GridBagLayout());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        // Adicicao dos componentes a janela
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        // gbc.gridwidth = 1;
        janela.add(adicionarComponentes(), gbc);
        janela.pack();
        janela.setVisible(true);

    }

    public static void main(String[] args) {
        new Cadastro_Brinquedos();
    }

}
