

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JMenuItem;

public class Valetinho {

	private JFrame frmValetinho;
	private Estacionamento estacionamento;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Valetinho window = new Valetinho();
					window.frmValetinho.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Valetinho() {
		initialize();
		frmValetinho.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() {
		frmValetinho = new JFrame("MENU");
		frmValetinho.setTitle("Valetinho");
		frmValetinho.setBounds(400, 100, 499, 625);
		frmValetinho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmValetinho.getContentPane().setLayout(null);
		
		try {
			estacionamento = new Estacionamento(10);
			estacionamento.lerDados();
			JOptionPane.showMessageDialog(null, "Estacionamento Criado!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			String msg = e.getMessage();
			JOptionPane.showMessageDialog(null, msg, "Error ao criar Estacionamento", JOptionPane.ERROR_MESSAGE);
		}
		
		URL url = this.getClass().getResource("/imagens/icone.png"); 
		Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url); 
		frmValetinho.setIconImage(iconeTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("Entrada:");
		lblNewLabel_1.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		lblNewLabel_1.setBounds(62, 48, 75, 13);
		frmValetinho.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(83, 71, 96, 19);
		frmValetinho.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(189, 71, 96, 19);
		frmValetinho.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Entrar");
		btnNewButton_1.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_1.getText().isEmpty() || textField_2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo Vazio!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String placa = textField_1.getText();
				int vaga = Integer.parseInt(textField_2.getText());
				try {
					estacionamento.entrar(placa, vaga);
					estacionamento.gravarDados();
					JOptionPane.showMessageDialog(null, "Veículo " + placa + " entrou na vaga " + vaga, "Entrar", JOptionPane.INFORMATION_MESSAGE);
					textField_1.setText("");
					textField_2.setText("");
				} catch (Exception i) {
					JOptionPane.showMessageDialog(null, i.getMessage(), "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_1.setBounds(295, 70, 120, 21);
		frmValetinho.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Saida:");
		lblNewLabel_2.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		lblNewLabel_2.setBounds(62, 129, 64, 13);
		frmValetinho.getContentPane().add(lblNewLabel_2);
		
		textField_4 = new JTextField();
		textField_4.setBounds(83, 152, 96, 19);
		frmValetinho.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Sair");
		btnNewButton_2.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo Vazio!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int vaga = Integer.parseInt(textField_4.getText());
				try {
					estacionamento.sair(vaga);
					estacionamento.gravarDados();
					JOptionPane.showMessageDialog(null, "Veículo saiu da vaga " + vaga, "Sair", JOptionPane.INFORMATION_MESSAGE);
					textField_4.setText("");
				} catch (Exception i) {
					JOptionPane.showMessageDialog(null, i.getMessage(), "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(189, 152, 120, 21);
		frmValetinho.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Consulta de Placa:");
		lblNewLabel_3.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		lblNewLabel_3.setBounds(62, 203, 158, 13);
		frmValetinho.getContentPane().add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(83, 226, 96, 19);
		frmValetinho.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Consultar");
		btnNewButton_3.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo Vazio!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String placa = textField_5.getText();
				int vaga = estacionamento.consultarPlaca(placa);
				try {
					if (vaga == -1) {
						JOptionPane.showMessageDialog(null, "Veículo inexistente ", "Consultar Placa", JOptionPane.ERROR_MESSAGE);
						textField_5.setText("");
						textField_5.requestFocus();
					} else {
						JOptionPane.showMessageDialog(null, "Veículo está na vaga " + vaga, "Consultar Placa", JOptionPane.INFORMATION_MESSAGE);
						textField_5.setText("");
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(189, 226, 120, 21);
		frmValetinho.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("Transferência de Placa:");
		lblNewLabel_4.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		lblNewLabel_4.setBounds(63, 281, 189, 13);
		frmValetinho.getContentPane().add(lblNewLabel_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(83, 304, 96, 19);
		frmValetinho.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(189, 304, 96, 19);
		frmValetinho.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Transferir");
		btnNewButton_4.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_6.getText().isEmpty() || textField_7.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo Vazio!", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int vaga1 = Integer.parseInt(textField_6.getText());
				int vaga2 = Integer.parseInt(textField_7.getText());
				try {
					estacionamento.transferir(vaga1, vaga2);
					estacionamento.gravarDados();
					JOptionPane.showMessageDialog(null, "Veículo da vaga " + vaga1 +  " transeferido para vaga " + vaga2, "Transferir", JOptionPane.INFORMATION_MESSAGE);
					textField_6.setText("");
					textField_7.setText("");
				} catch(Exception i) {
					JOptionPane.showMessageDialog(null, i.getMessage(), "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_4.setBounds(295, 303, 120, 21);
		frmValetinho.getContentPane().add(btnNewButton_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 423, 129, 88);
		frmValetinho.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(253, 423, 129, 88);
		frmValetinho.getContentPane().add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setEditable(false);
		
		JLabel lblNewLabel_5 = new JLabel("Listagem Geral:");
		lblNewLabel_5.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		lblNewLabel_5.setBounds(62, 369, 135, 13);
		frmValetinho.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_5 = new JButton("Listar");
		btnNewButton_5.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				for (int i = 0; i < estacionamento.listarGeral().length; i++) {
					textArea.append(" " + (i+1) + "  → " + estacionamento.listarGeral()[i] + "\n");
				}
			}
		});
		btnNewButton_5.setBounds(83, 392, 131, 21);
		frmValetinho.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_6 = new JLabel("Listagem de Vagas Livres:");
		lblNewLabel_6.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		lblNewLabel_6.setBounds(247, 369, 198, 13);
		frmValetinho.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_6 = new JButton("Listar");
		btnNewButton_6.setFont(new Font("JetBrains Mono ExtraBold", Font.BOLD, 11));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("");
				for(Integer s : estacionamento.listarLivres()) {
					textArea_1.append(" " + s + "\n");
				}
			}
		});
		btnNewButton_6.setBounds(253, 392, 131, 21);
		frmValetinho.getContentPane().add(btnNewButton_6);
		
		JLabel lblNewLabel_8 = new JLabel("placa");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_8.setForeground(Color.GRAY);
		lblNewLabel_8.setBounds(113, 89, 45, 13);
		frmValetinho.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("vaga");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_9.setForeground(Color.GRAY);
		lblNewLabel_9.setBounds(224, 89, 45, 13);
		frmValetinho.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("vaga");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_10.setForeground(Color.GRAY);
		lblNewLabel_10.setBounds(113, 169, 45, 13);
		frmValetinho.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("placa");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_11.setForeground(Color.GRAY);
		lblNewLabel_11.setBounds(113, 244, 45, 13);
		frmValetinho.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("vaga origem");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_12.setForeground(Color.GRAY);
		lblNewLabel_12.setBounds(104, 320, 75, 13);
		frmValetinho.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("vaga destino");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_13.setForeground(Color.GRAY);
		lblNewLabel_13.setBounds(210, 320, 75, 13);
		frmValetinho.getContentPane().add(lblNewLabel_13);
		
		JMenuBar menuBar = new JMenuBar();
		frmValetinho.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sair");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmValetinho.dispose();
			}
		});
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Desenvolvedores");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alic");
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("João Marcos");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Genildo");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		
	}
}
