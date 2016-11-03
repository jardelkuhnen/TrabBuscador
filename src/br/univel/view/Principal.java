package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

import br.univel.cntroller.ArquivoController;
import br.univel.dao.PessoaController;
import br.univel.enuns.TipoBanco;
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
	private JTextArea txtArquivos;
	private JTextArea txtGoogle;
	private JLabel lblPath;
	private JTextField txtPath;

	private TabelaModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal principal = new Principal();
					principal.setVisible(true);
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

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
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

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		pnMysql.add(scrollPane_1, gbc_scrollPane_1);

		tblMySql = new JTable();
		scrollPane_1.setViewportView(tblMySql);

		pnArq = new JPanel();
		tabbedPane.addTab("Arquivos", null, pnArq, null);
		GridBagLayout gbl_pnArq = new GridBagLayout();
		gbl_pnArq.columnWidths = new int[] { 36, 419, 0, 0 };
		gbl_pnArq.rowHeights = new int[] { 30, 369, 0 };
		gbl_pnArq.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
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
		gbc_txtPath.gridwidth = 2;
		gbc_txtPath.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPath.insets = new Insets(0, 0, 5, 5);
		gbc_txtPath.gridx = 1;
		gbc_txtPath.gridy = 0;
		pnArq.add(txtPath, gbc_txtPath);
		txtPath.setColumns(10);

		txtArquivos = new JTextArea();
		GridBagConstraints gbc_txtArquivos = new GridBagConstraints();
		gbc_txtArquivos.gridwidth = 3;
		gbc_txtArquivos.fill = GridBagConstraints.BOTH;
		gbc_txtArquivos.gridx = 0;
		gbc_txtArquivos.gridy = 1;
		pnArq.add(txtArquivos, gbc_txtArquivos);

		pnGoogle = new JPanel();
		tabbedPane.addTab("Google", null, pnGoogle, null);
		GridBagLayout gbl_pnGoogle = new GridBagLayout();
		gbl_pnGoogle.columnWidths = new int[] { 0, 0 };
		gbl_pnGoogle.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnGoogle.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_pnGoogle.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		pnGoogle.setLayout(gbl_pnGoogle);

		txtGoogle = new JTextArea();
		GridBagConstraints gbc_txtGoogle = new GridBagConstraints();
		gbc_txtGoogle.gridheight = 2;
		gbc_txtGoogle.fill = GridBagConstraints.BOTH;
		gbc_txtGoogle.gridx = 0;
		gbc_txtGoogle.gridy = 0;
		pnGoogle.add(txtGoogle, gbc_txtGoogle);

		txtCriterio = new JTextField();
		panel.add(txtCriterio, BorderLayout.NORTH);
		txtCriterio.setToolTipText("Informe o critério de busca...");
		txtCriterio.setText("Informe o critério de busca...");
		txtCriterio.setColumns(10);
		txtCriterio.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

//					buscarDadosPostgres(txtCriterio.getText().trim());
//					buscarDadosMySql(txtCriterio.getText().trim());
					buscarDadosArq(txtCriterio.getText().trim());

				}

			}

		});

	}

	protected void buscarDadosArq(String criterio) {

		File file = new File(txtPath.getText());
		File qtdFile[] = file.listFiles();

		ExecutorService executor = Executors.newFixedThreadPool(qtdFile.length);

		final Future<List<String>> future = executor
				.submit(new ArquivoController(txtCriterio.getText().trim(),
						txtPath.getText()));

		try {
			List<String> arquivos = future.get();

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < arquivos.size(); i++) {
				sb.append(arquivos.get(i));
			}

			txtArquivos.setText(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void buscarDadosMySql(String criterio) {

		final ExecutorService executor = Executors.newSingleThreadExecutor();

		// Continuar implementação para o banco MySql.

	}

	public void buscarDadosPostgres(String criterio) {

		final ExecutorService executor = Executors.newSingleThreadExecutor();

		final Future<List<Pessoa>> future = executor
				.submit(new PessoaController(criterio, TipoBanco.POSTGRES));
		List<Pessoa> dadosPostgres;

		try {
			dadosPostgres = future.get();

			model = new TabelaModel(dadosPostgres);

			if (dadosPostgres.size() == 0) {
				JOptionPane.showMessageDialog(Principal.this,
						"Nenhuma informação encontrada no banco Postgres",
						"Atenção", JOptionPane.WARNING_MESSAGE);
			} else {
				tblPostgres.setModel(model);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
