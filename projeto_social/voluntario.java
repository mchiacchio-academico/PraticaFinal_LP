package projeto_social;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.List;
import java.awt.TextArea;
import java.awt.Button;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class voluntario extends JFrame {

	private JPanel contentPane;
	public JTextField txtTitulo;
	private JTextField txtObjetivo;
	private JTextField txtEndereco;
	private JTextField dataInicio;
	private JTextField txtDtaInicio;
	private JTextField txtStatus;
	private JTextField data;
	private JTextField data_1;
	private JTextField hora;
	private JTextField hora_1;
	private JTextArea descricao;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					voluntario v1 = new voluntario();
					v1.setVisible(true);
					v1.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public voluntario() {
		setTitle("Projetos Sociais");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 544, 437);
		contentPane.add(tabbedPane);
		
		Panel cadastrar = new Panel();
		cadastrar.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastrar Projeto", null, cadastrar, null);
		cadastrar.setLayout(null);
		
		
		Panel agenda = new Panel();
		agenda.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastrar Agenda", null, agenda, null);
		agenda.setLayout(null);
		tabbedPane.setEnabledAt(1, false);
		
		Panel panelCarregar = new Panel();
		tabbedPane.addTab("Carregar Arquivo", null, panelCarregar, null);
		panelCarregar.setLayout(null);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(10, 36, 504, 20);
		cadastrar.add(txtTitulo);
		
		JLabel lbltitulo = new JLabel("T\u00EDtulo");
		lbltitulo.setForeground(Color.BLUE);
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbltitulo.setBounds(253, 11, 56, 14);
		cadastrar.add(lbltitulo);
		
		JLabel lblObjetivo = new JLabel("Objetivo");
		lblObjetivo.setForeground(Color.BLUE);
		lblObjetivo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblObjetivo.setBounds(247, 67, 62, 14);
		cadastrar.add(lblObjetivo);
		
		txtObjetivo = new JTextField();
		txtObjetivo.setColumns(10);
		txtObjetivo.setBounds(10, 92, 504, 20);
		cadastrar.add(txtObjetivo);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setForeground(Color.BLUE);
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEndereco.setBounds(253, 123, 62, 14);
		cadastrar.add(lblEndereco);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(10, 148, 504, 20);
		cadastrar.add(txtEndereco);
		
		JLabel lblDtaInicio = new JLabel("Data de Inicio");
		lblDtaInicio.setForeground(Color.BLUE);
		lblDtaInicio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDtaInicio.setBounds(231, 235, 92, 14);
		cadastrar.add(lblDtaInicio);
		


		dataInicio = new JTextField();
		try{
			javax.swing.text.MaskFormatter date= new javax.swing.text.MaskFormatter("##/##/####");
			txtDtaInicio = new javax.swing.JFormattedTextField(date);
			txtDtaInicio.setHorizontalAlignment(SwingConstants.CENTER);
			}
			catch (Exception e){
			}
		txtDtaInicio.setColumns(10);
		txtDtaInicio.setBounds(231, 260, 92, 20);
		cadastrar.add(txtDtaInicio);
		
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStatus.setBounds(253, 179, 54, 14);
		cadastrar.add(lblStatus);
		
		txtStatus = new JTextField();
		txtStatus.setColumns(10);
		txtStatus.setBounds(10, 204, 504, 20);
		cadastrar.add(txtStatus);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			ArrayList<String> ProjetoSocial = new ArrayList();
			public void actionPerformed(ActionEvent e) {			
				if("".equals(txtTitulo.getText()) || "".equals(txtObjetivo.getText()) || "".equals(txtEndereco.getText()) || 
			            "".equals(txtDtaInicio.getText()) || "".equals(txtStatus.getText())){
			        JOptionPane.showMessageDialog(null,"Não foram preenchidos todos os campos!","Alert",JOptionPane.WARNING_MESSAGE);     
				}else				
				try {
					BufferedWriter escrever = new BufferedWriter(new FileWriter(txtTitulo.getText(),true));
				ProjetoSocial.add("===========================PROJETO SOCIAL================================ "+
									"\n\r===============Nome:"+txtTitulo.getText()+
							   "                                                                                           "+
									" \n\r===============Objetivo: "+txtObjetivo.getText()+
							   "                                                                          "+
									" \n\r===============Endereço: "+txtEndereco.getText()+
							   "                                                                                "+
									" \n\r===============Data de inicio: "+txtDtaInicio.getText()+
							   "                                                                                      "+
									" \n\r===============Status: "+txtStatus.getText()+" "+"\n\r");
	            escrever.append(ProjetoSocial.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", "));
				escrever.close();
				JOptionPane.showMessageDialog(null, "Cadastro realizado!");
				tabbedPane.setEnabledAt(1, true);
				tabbedPane.setSelectedIndex(1);
				tabbedPane.setEnabledAt(0, false);
				
				}				
				catch (IOException e1) {
				e1.printStackTrace();				
				}				
				}			
		}
		);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(231, 311, 102, 30);
		cadastrar.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_5 = new JLabel("Data");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(250, 82, 46, 14);
		agenda.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(237, 194, 70, 14);
		agenda.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Hora");
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(250, 138, 46, 14);
		agenda.add(lblNewLabel_7);
		
		data = new JTextField();
		try{
			javax.swing.text.MaskFormatter data1= new javax.swing.text.MaskFormatter("##/##/####");
			data_1 = new javax.swing.JFormattedTextField(data1);
			data_1.setHorizontalAlignment(SwingConstants.CENTER);
			}
			catch (Exception e){
			}
		data_1.setBounds(237, 107, 70, 20);
		agenda.add(data_1);
		data_1.setColumns(10);
		
		hora = new JTextField();
		try{
			javax.swing.text.MaskFormatter hour= new javax.swing.text.MaskFormatter("##:##");
			hora_1 = new javax.swing.JFormattedTextField(hour);
			hora_1.setHorizontalAlignment(SwingConstants.CENTER);
			}
			catch (Exception e){
			}
		hora_1.setBounds(250, 162, 46, 20);
		agenda.add(hora_1);
		hora_1.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Situa\u00E7\u00E3o");
		lblNewLabel_8.setForeground(Color.BLUE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(250, 24, 57, 14);
		agenda.add(lblNewLabel_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Em execício", "Parado", "Concluído"}));
		
		comboBox.setBounds(169, 49, 214, 22);
		agenda.add(comboBox);
		
		JTextArea descricao = new JTextArea();
		descricao.setBackground(Color.LIGHT_GRAY);
		descricao.setWrapStyleWord(true);
		descricao.setLineWrap(true);
		descricao.setBounds(86, 219, 396, 104);
		agenda.add(descricao);

		
		JButton buttonSalvar = new JButton("Salvar");
		buttonSalvar.addActionListener(new ActionListener() {
			ArrayList<String> Agendas = new ArrayList();
			public void actionPerformed(ActionEvent e) {
				if("".equals(data_1.getText()) || "".equals(hora_1.getText()) || "".equals(descricao.getText())){
					 JOptionPane.showMessageDialog(null,"Preencha todos os campos!","Alert",JOptionPane.WARNING_MESSAGE);
				}else
				try {
					BufferedWriter arquivotxt = new BufferedWriter(new FileWriter(txtTitulo.getText(),true));
				
				Agendas.add("\n\r=========================================================================="+"\n\r==========================AGENDA DO PROJETO============================== "+
																		" \n\r===============Data: "+data_1.getText()+
																		"                                                                                                           "+
																		" \n\r===============Hora: "+hora_1.getText()+
																		"                                                                                                                     "+
																		" \n\r===============Situação: "+comboBox.getSelectedItem()+
																		"                                                                                                       "+
																		" \n\r===============Descrição: "+descricao.getText());
				arquivotxt.append(Agendas.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", "));

				
				JOptionPane.showMessageDialog(null, "Agenda salva!");
				String option = JOptionPane.showInputDialog("Cadastrar outra agenda? \n1-Sim 2-Não");
				if(option.equals("1")){
					comboBox.setSelectedIndex(0);
					data_1.setText("");
					hora_1.setText("");
					descricao.setText("");
					
				}else
				arquivotxt.close();
				comboBox.setSelectedIndex(0);
				data_1.setText("");
				hora_1.setText("");
				descricao.setText("");
				
				}catch (IOException e1) {
					e1.printStackTrace();
					
				
				}
				
			}
			}
		);
		buttonSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonSalvar.setBounds(237, 349, 100, 23);
		agenda.add(buttonSalvar);
		
		JButton btnNewButton_2 = new JButton("Novo Projeto");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(0, true);
				txtTitulo.setText("");
				txtObjetivo.setText("");
				txtEndereco.setText("");
				txtDtaInicio.setText("");
				txtStatus.setText("");
				tabbedPane.setSelectedIndex(0);
				tabbedPane.setEnabledAt(1, false);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_2.setBounds(237, 375, 100, 23);
		agenda.add(btnNewButton_2);
		
		
		
	
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 542, 410);
		panelCarregar.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecionar Arquivo");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(201, 46, 151, 14);
		panel.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(10, 126, 522, 273);
		panel.add(textArea);
		
		JButton btnNewButton_1 = new JButton("Carregar");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fc = new JFileChooser();
                
	              int res = fc.showOpenDialog(null);
	                     
	              if(res == JFileChooser.APPROVE_OPTION){
	                 File arquivo = fc.getSelectedFile();
	                 textArea.setText("");
	                  
	                 try {
	                    BufferedReader in = new BufferedReader(new FileReader(arquivo));
	                    
	                    String str, texto = "";
	                    while((str = in.readLine()) != null){
	                        texto += str;
	                    }
	                    textArea.setText(" \n\r"+texto);
	                    in.close();
	                 } 
	                 catch (IOException ioe){	             
	                 }
	              }
			}
			
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(230, 82, 89, 23);
		panel.add(btnNewButton_1);
		
		
		
		
	}
}