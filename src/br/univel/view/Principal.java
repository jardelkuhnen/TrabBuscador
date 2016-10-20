package br.univel.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;
import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtCriterio;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;

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
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Postgres", null, panel_1, null);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("MySql", null, panel_2, null);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Arquivos", null, panel_3, null);
		
		panel_4 = new JPanel();
		tabbedPane.addTab("Google", null, panel_4, null);
		panel_4.setLayout(null);
		
				txtCriterio = new JTextField();
				panel.add(txtCriterio, BorderLayout.NORTH);
				txtCriterio.setToolTipText("Informe o criit\u00E9rio de busca...");
				txtCriterio.setText("Informe o criit\u00E9rio de busca...");
				txtCriterio.setColumns(10);


	}
}
