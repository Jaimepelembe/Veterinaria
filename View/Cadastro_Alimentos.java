
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

public class Cadastro_Alimentos {
    private JLabel lNome, lQuantidade, lValidade, lkg, lUnidade;
    private JButton bSalvar, bLimpar, bCancelar;
    private JTextField tfNome, tfValidade;
    private JFrame janela;
    private JSpinner spQuantidade, spUnidades;
    GridBagConstraints gbc = new GridBagConstraints();

    public Cadastro_Alimentos() {
        createWindow();
    }

    public Container adicionarComponentes() {
        JPanel pPrincipal = new JPanel(new GridBagLayout());

        // informacoes nome
        lNome = new JLabel("Nome:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lNome, gbc);

        tfNome = new JTextField();
        tfNome.setColumns(10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(tfNome, gbc);

        // Informacoes Quandidade
        lQuantidade = new JLabel("Quantidade:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lQuantidade, gbc);

        spQuantidade = new JSpinner();
        spQuantidade.setValue(1);

        // spQuantidade.setSize(1, 0);
        spQuantidade.setToolTipText("Indique a quantidade");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        // gbc.weightx = 0.5;
        gbc.ipadx = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(spQuantidade, gbc);
        // KG
        lkg = new JLabel("KG");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 5, 0);
        pPrincipal.add(lkg, gbc);

        // Validade
        lValidade = new JLabel("Validade:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lValidade, gbc);

        tfValidade = new JTextField();
        tfValidade.setColumns(10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(tfValidade, gbc);

        // Unidade
        lUnidade = new JLabel("Unidades:");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        pPrincipal.add(lUnidade, gbc);

        spUnidades = new JSpinner();
        spUnidades.setValue(1);
        // spQuantidade.setSize(1, 0);
        spUnidades.setToolTipText("Indique a quantidade de unidades");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 15, 5, 0);
        pPrincipal.add(spUnidades, gbc);

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
        new Cadastro_Alimentos();
    }

}
