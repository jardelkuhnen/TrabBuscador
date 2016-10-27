package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.univel.dao.postgres.PessoaController;
import br.univel.model.Pessoa;
import br.univel.model.TabelaModel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtCriterio;
	private JTabbedPane tabbedPane;
	private JPanel pnPostgres;
	private JPanel pnMysql;
	private JPanel pnArq;
	private JPanel pnGoogle;
	private JTable tblPostgres;
	private JTable tblMySql;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JLabel lblPath;
	private JTextField txtPath;

	private JTable tableNow;
	private JButton btnBuscar;
	private JButton btnBuscar_1;
	private JButton btnBuscar_2;
	private JButton btnBuscar_3;
	private List<Pessoa> listaPessoas;
	private TabelaModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 496);
		setLocationRelativeTo(null);
		setTitle("Buscador de arquivos");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		Panel panel = new Panel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel.add(tabbedPane, BorderLayout.CENTER);

		pnPostgres = new JPanel();
		tabbedPane.addTab("Postgres", null, pnPostgres, null);
		GridBagLayout gbl_pnPostgres = new GridBagLayout();
		gbl_pnPostgres.columnWidths = new int[] { 0, 0 };
		gbl_pnPostgres.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnPostgres.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnPostgres.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		pnPostgres.setLayout(gbl_pnPostgres);

		btnBuscar_3 = new JButton("Buscar");
		btnBuscar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String busca = txtCriterio.getText().trim();

				preencherTela(busca);

			}
		});
		GridBagConstraints gbc_btnBuscar_3 = new GridBagConstraints();
		gbc_btnBuscar_3.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar_3.gridx = 0;
		gbc_btnBuscar_3.gridy = 0;
		pnPostgres.add(btnBuscar_3, gbc_btnBuscar_3);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		pnPostgres.add(scrollPane, gbc_scrollPane);

		tblPostgres = new JTable();
		scrollPane.setViewportView(tblPostgres);

		pnMysql = new JPanel();
		tabbedPane.addTab("MySql", null, pnMysql, null);
		GridBagLayout gbl_pnMysql = new GridBagLayout();
		gbl_pnMysql.columnWidths = new int[] { 0, 0 };
		gbl_pnMysql.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnMysql.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnMysql.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		pnMysql.setLayout(gbl_pnMysql);

		btnBuscar_2 = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar_2 = new GridBagConstraints();
		gbc_btnBuscar_2.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar_2.gridx = 0;
		gbc_btnBuscar_2.gridy = 0;
		pnMysql.add(btnBuscar_2, gbc_btnBuscar_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		pnMysql.add(scrollPane_1, gbc_scrollPane_1);

		tblMySql = new JTable();
		scrollPane_1.setViewportView(tblMySql);

		pnArq = new JPanel();
		tabbedPane.addTab("Arquivos", null, pnArq, null);
		GridBagLayout gbl_pnArq = new GridBagLayout();
		gbl_pnArq.columnWidths = new int[] { 36, 419, 0, 0 };
		gbl_pnArq.rowHeights = new int[] { 30, 369, 0 };
		gbl_pnArq.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_pnArq.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		pnArq.setLayout(gbl_pnArq);

		lblPath = new JLabel("Path:");
		GridBagConstraints gbc_lblPath = new GridBagConstraints();
		gbc_lblPath.anchor = GridBagConstraints.EAST;
		gbc_lblPath.insets = new Insets(0, 0, 5, 5);
		gbc_lblPath.gridx = 0;
		gbc_lblPath.gridy = 0;
		pnArq.add(lblPath, gbc_lblPath);

		txtPath = new JTextField();
		txtPath.setText("D:\\");
		GridBagConstraints gbc_txtPath = new GridBagConstraints();
		gbc_txtPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPath.insets = new Insets(0, 0, 5, 5);
		gbc_txtPath.gridx = 1;
		gbc_txtPath.gridy = 0;
		pnArq.add(txtPath, gbc_txtPath);
		txtPath.setColumns(10);

		btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.gridx = 2;
		gbc_btnBuscar.gridy = 0;
		pnArq.add(btnBuscar, gbc_btnBuscar);

		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 3;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		pnArq.add(textArea, gbc_textArea);

		pnGoogle = new JPanel();
		tabbedPane.addTab("Google", null, pnGoogle, null);
		GridBagLayout gbl_pnGoogle = new GridBagLayout();
		gbl_pnGoogle.columnWidths = new int[] { 0, 0 };
		gbl_pnGoogle.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnGoogle.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnGoogle.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		pnGoogle.setLayout(gbl_pnGoogle);

		btnBuscar_1 = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar_1 = new GridBagConstraints();
		gbc_btnBuscar_1.anchor = GridBagConstraints.EAST;
		gbc_btnBuscar_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar_1.gridx = 0;
		gbc_btnBuscar_1.gridy = 0;
		pnGoogle.add(btnBuscar_1, gbc_btnBuscar_1);

		textArea_1 = new JTextArea();
		GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
		gbc_textArea_1.fill = GridBagConstraints.BOTH;
		gbc_textArea_1.gridx = 0;
		gbc_textArea_1.gridy = 1;
		pnGoogle.add(textArea_1, gbc_textArea_1);

		txtCriterio = new JTextField();
		panel.add(txtCriterio, BorderLayout.NORTH);
		txtCriterio.setToolTipText("Informe o critério de busca...");
		txtCriterio.setText("Informe o critério de busca...");
		txtCriterio.setColumns(10);

	}

	private void preencherTela(String criterio) {

		listaPessoas = new PessoaController().buscarDados(criterio);
		model = new TabelaModel(listaPessoas);

		if (listaPessoas.size() == 0) {
			JOptionPane.showMessageDialog(Principal.this, "Nenhuma informação encontrada!", "Atenção",
					JOptionPane.WARNING_MESSAGE);
		} else {
			tblMySql.setModel(model);
			tblPostgres.setModel(model);

		}

	}
}
