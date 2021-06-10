package calcuJamir;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDisplay;


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

	double primero;
	double segundo;
	double result;
	int i;
	String op;
	String rpta;
	boolean borra = false;
	private JTextField txtVista;
	
	public Principal() {
		setUndecorated(true);
		
		//*****************<<PANEL Y BOTONES DE OPERACIONES>>*****************
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 587);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(244, 164, 96));
		panel.setBackground(Color.decode("#2e3951"));
		panel.setBounds(0, 199, 363, 390);
		contentPane.add(panel);
		
		JButton btn_borrar = new JButton("AC");
		btn_borrar.setBorder(null);
		btn_borrar.setBounds(21, 22, 74, 62);
		btn_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtDisplay.setText(null);
				txtVista.setText(null);
			}
		});
		panel.setLayout(null);
		btn_borrar.setFocusable(false);
		btn_borrar.setForeground(Color.WHITE);
		btn_borrar.setFont(new Font("Montserrat", Font.BOLD, 23));
		btn_borrar.setBackground(new Color(47, 79, 79));
		panel.add(btn_borrar);
		
		JButton btn_cuadrado = new JButton("x\u00B2");
		btn_cuadrado.setBorder(null);
		btn_cuadrado.setBounds(92, 22, 74, 62);
		btn_cuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				primero = Double.parseDouble(txtDisplay.getText());
				result = primero*primero;
				rpta = String.format("%.2f",result);
				txtDisplay.setText(rpta);
				txtVista.setText(txtVista.getText() + btn_cuadrado.getText());
				i++;
				if (i>1) {
					txtVista.setText(null);
					i=0;
						  }
				borra = true;
			}
		});
		btn_cuadrado.setForeground(Color.WHITE);
		btn_cuadrado.setFont(new Font("Montserrat", Font.BOLD, 23));
		btn_cuadrado.setFocusable(false);
		btn_cuadrado.setBackground(new Color(47, 79, 79));
		panel.add(btn_cuadrado);
		
		JButton btn_raiz = new JButton("\u221Ax");
		btn_raiz.setBorder(null);
		btn_raiz.setBounds(163, 22, 74, 62);
		btn_raiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				primero = Double.parseDouble(txtDisplay.getText());
				result = Math.sqrt(primero);
				rpta = String.format("%.2f",result);
				txtDisplay.setText(rpta);
				i++;
				txtVista.setText(txtVista.getText() + btn_raiz.getText());
				if (i>1) {
					txtVista.setText(null);
					i=0;
						  }
				borra = true;
			}
		});
		btn_raiz.setForeground(Color.WHITE);
		btn_raiz.setFont(new Font("Montserrat", Font.BOLD, 23));
		btn_raiz.setFocusable(false);
		btn_raiz.setBackground(new Color(47, 79, 79));
		panel.add(btn_raiz);
		
		JButton btn_igual = new JButton("=");
		btn_igual.setBorder(null);
		btn_igual.setBounds(265, 22, 74, 62);
		btn_igual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rpta;
				segundo = Double.parseDouble(txtDisplay.getText());
				
				if (op == "+")
				{
					result = primero + segundo;
					rpta = String.format("%.2f",result);
					txtDisplay.setText(rpta);
					borra = true;
				}
				else if (op == "-")
				{
					result = primero - segundo;
					rpta = String.format("%.2f",result);
					txtDisplay.setText(rpta);
					borra = true;
				}
				else if (op == "*")
				{
					result = primero * segundo;
					rpta = String.format("%.2f",result);
					txtDisplay.setText(rpta);
					borra = true;
				}
				else if (op == "/")
				{
					if (segundo==0){
						txtDisplay.setText("Indefinido");	
						borra = true;
					}else {
						result = primero / segundo;
						rpta = String.format("%.2f",result);
						txtDisplay.setText(rpta);
						borra = true;
					}}

			}
		});
		btn_igual.setForeground(Color.WHITE);
		btn_igual.setFont(new Font("Montserrat", Font.BOLD, 23));
		btn_igual.setFocusable(false);
		btn_igual.setBackground(new Color(160, 82, 45));
		panel.add(btn_igual);
		
		JButton btn_division = new JButton("\u00F7");
		btn_division.setBorder(null);
		btn_division.setBounds(265, 94, 74, 62);
		btn_division.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				primero = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				op = "/";
				i++;
				txtVista.setText(txtVista.getText() + btn_division.getText());
				if (i>=2) {
					txtVista.setText(null);
					i=0;
						  }
				borra = false;
			}
		});
		btn_division.setForeground(Color.WHITE);
		btn_division.setFont(new Font("Montserrat", Font.BOLD, 23));
		btn_division.setFocusable(false);
		btn_division.setBackground(new Color(154, 205, 50));
		panel.add(btn_division);
		
		JButton btn_producto = new JButton("X");
		btn_producto.setBorder(null);
		btn_producto.setBounds(265, 166, 74, 62);
		btn_producto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				primero = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				op = "*";
				i++;
				txtVista.setText(txtVista.getText() + btn_producto.getText());
				if (i>=2) {
					txtVista.setText(null);
					i=0;
						  }
				borra = false;
			}
		});
		btn_producto.setForeground(Color.WHITE);
		btn_producto.setFont(new Font("Montserrat", Font.BOLD, 23));
		btn_producto.setFocusable(false);
		btn_producto.setBackground(new Color(154, 205, 50));
		panel.add(btn_producto);
		
		JButton btn_resta = new JButton("-");
		btn_resta.setBorder(null);
		btn_resta.setBounds(265, 238, 74, 62);
		btn_resta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				primero = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				op = "-";
				i++;
				txtVista.setText(txtVista.getText() + btn_resta.getText());
				if (i>=2) {
					txtVista.setText(null);
					i=0;
						  }
				borra = false;

			}
		});
		btn_resta.setForeground(Color.WHITE);
		btn_resta.setFont(new Font("Montserrat", Font.BOLD, 23));
		btn_resta.setFocusable(false);
		btn_resta.setBackground(new Color(154, 205, 50));
		panel.add(btn_resta);
		
		JButton btn_suma = new JButton("+");
		btn_suma.setBorder(null);
		btn_suma.setBounds(265, 310, 74, 62);
		btn_suma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				primero = Double.parseDouble(txtDisplay.getText());
				txtDisplay.setText("");
				op = "+";
				
				txtVista.setText(txtVista.getText() + btn_suma.getText());
				i++;
				if (i>=2) {
					txtVista.setText(null);
					i=0;
					}
				borra = false;
			}
		});
		btn_suma.setForeground(Color.WHITE);
		btn_suma.setFont(new Font("Montserrat", Font.BOLD, 23));
		btn_suma.setFocusable(false);
		btn_suma.setBackground(new Color(154, 205, 50));
		panel.add(btn_suma);
		
		// *****************<<NUMEROS Y PUNTO>>****************+*
		
		JButton btn_7 = new JButton("7");
		btn_7.setBounds(32, 111, 48, 47);
		btn_7.setBorder(null);
		btn_7.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_7.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_7.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_7.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (borra == true) {
					txtDisplay.setText(null);
					txtVista.setText(null);
					borra = false;
					i=0;
				}
				String EnterNumber = txtDisplay.getText() + btn_7.getText();
				
				txtDisplay.setText(EnterNumber );
				txtVista.setText(txtVista.getText() + btn_7.getText());
				
			}
		});
		btn_7.setForeground(Color.WHITE);
		btn_7.setFont(new Font("Montserrat", Font.BOLD, 22));
		btn_7.setFocusable(false);
		btn_7.setBackground(Color.decode("#2e3951"));
		panel.add(btn_7);
		
		JButton btn_8 = new JButton("8");
		btn_8.setBounds(103, 109, 48, 47);
		btn_8.setBorder(null);
		btn_8.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_8.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_8.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_8.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (borra == true) {
					txtDisplay.setText(null);
					txtVista.setText(null);
					borra = false;
					i=0;
				}
				String EnterNumber = txtDisplay.getText() + btn_8.getText();
				txtDisplay.setText(EnterNumber );
				txtVista.setText(txtVista.getText() + btn_8.getText());
				
			}
		});
		btn_8.setForeground(Color.WHITE);
		btn_8.setFont(new Font("Montserrat", Font.BOLD, 22));
		btn_8.setFocusable(false);
		btn_8.setBackground(Color.decode("#2e3951"));
		panel.add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.setBounds(174, 109, 48, 47);
		btn_9.setBorder(null);
		btn_9.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_9.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_9.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_9.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (borra == true) {
					txtDisplay.setText(null);
					txtVista.setText(null);
					borra = false;
					i=0;
				}
				String EnterNumber = txtDisplay.getText() + btn_9.getText();
				txtDisplay.setText(EnterNumber );
				txtVista.setText(txtVista.getText() + btn_9.getText());
				
			}
		});
		btn_9.setForeground(Color.WHITE);
		btn_9.setFont(new Font("Montserrat", Font.BOLD, 22));
		btn_9.setFocusable(false);
		btn_9.setBackground(Color.decode("#2e3951"));
		panel.add(btn_9);
		
		JButton btn_4 = new JButton("4");
		btn_4.setBounds(32, 173, 48, 47);
		btn_4.setBorder(null);
		btn_4.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_4.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_4.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_4.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (borra == true) {
					txtDisplay.setText(null);
					txtVista.setText(null);
					borra = false;
					i=0;
				}
				String EnterNumber = txtDisplay.getText() + btn_4.getText();
				txtDisplay.setText(EnterNumber );
				txtVista.setText(txtVista.getText() + btn_4.getText());
				
			}
		});
		btn_4.setForeground(Color.WHITE);
		btn_4.setFont(new Font("Montserrat", Font.BOLD, 22));
		btn_4.setFocusable(false);
		btn_4.setBackground(Color.decode("#2e3951"));
		panel.add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.setBounds(103, 173, 48, 47);
		btn_5.setBorder(null);
		btn_5.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_5.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_5.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_5.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (borra == true) {
					txtDisplay.setText(null);
					txtVista.setText(null);
					borra = false;
					i=0;
				}
				String EnterNumber = txtDisplay.getText() + btn_5.getText();
				txtDisplay.setText(EnterNumber );
				txtVista.setText(txtVista.getText() + btn_5.getText());
				
			}
		});
		btn_5.setForeground(Color.WHITE);
		btn_5.setFont(new Font("Montserrat", Font.BOLD, 22));
		btn_5.setFocusable(false);
		btn_5.setBackground(Color.decode("#2e3951"));
		panel.add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.setBounds(174, 173, 48, 47);
		btn_6.setBorder(null);
		btn_6.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_6.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_6.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_6.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (borra == true) {
					txtDisplay.setText(null);
					txtVista.setText(null);
					borra = false;
					i=0;
				}
				String EnterNumber = txtDisplay.getText() + btn_6.getText();
				txtDisplay.setText(EnterNumber );
				txtVista.setText(txtVista.getText() + btn_6.getText());
				
			}
		});
		btn_6.setForeground(Color.WHITE);
		btn_6.setFont(new Font("Montserrat", Font.BOLD, 22));
		btn_6.setFocusable(false);
		btn_6.setBackground(Color.decode("#2e3951"));
		panel.add(btn_6);
		
		JButton btn_1 = new JButton("1");
		btn_1.setBounds(31, 244, 49, 49);

		btn_1.setBorder(null);
		btn_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_1.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_1.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_1.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (borra == true) {
					txtDisplay.setText(null);
					txtVista.setText(null);
					borra = false;
					borra = false;
					i=0;
				}
				String EnterNumber = txtDisplay.getText() + btn_1.getText();
				txtDisplay.setText(EnterNumber );
				txtVista.setText(txtVista.getText() + btn_1.getText());
				
			}
		});
		btn_1.setForeground(Color.WHITE);
		btn_1.setFont(new Font("Montserrat", Font.BOLD, 22));
		btn_1.setFocusable(false);
		btn_1.setBackground(Color.decode("#2e3951"));
		panel.add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.setBounds(102, 244, 49, 49);
		btn_2.setBorder(null);
		btn_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_2.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_2.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_2.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (borra == true) {
					txtDisplay.setText(null);
					txtVista.setText(null);
					borra = false;
					i=0;
				}
				String EnterNumber = txtDisplay.getText() + btn_2.getText();
				txtDisplay.setText(EnterNumber );
				txtVista.setText(txtVista.getText() + btn_2.getText());
				
			}
		});
		btn_2.setForeground(Color.WHITE);
		btn_2.setFont(new Font("Montserrat", Font.BOLD, 22));
		btn_2.setFocusable(false);
		btn_2.setBackground(Color.decode("#2e3951"));
		panel.add(btn_2);
		
		JButton btn_3 = new JButton("3");
		btn_3.setBounds(173, 244, 49, 49);
		btn_3.setBorder(null);
		btn_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_3.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_3.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_3.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (borra == true) {
					txtDisplay.setText(null);
					txtVista.setText(null);
					borra = false;
					i=0;
				}
				String EnterNumber = txtDisplay.getText() + btn_3.getText();
				txtDisplay.setText(EnterNumber );
				txtVista.setText(txtVista.getText() + btn_3.getText());
				
			}
		});
		btn_3.setForeground(Color.WHITE);
		btn_3.setFont(new Font("Montserrat", Font.BOLD, 22));
		btn_3.setFocusable(false);
		btn_3.setBackground(Color.decode("#2e3951"));
		panel.add(btn_3);
		
		JButton btn_0 = new JButton("0");
		btn_0.setBounds(103, 317, 48, 47);
		btn_0.setBorder(null);
		btn_0.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_0.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_0.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_0.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (borra == true) {
					txtDisplay.setText(null);
					txtVista.setText(null);
					borra = false;
					i=0;
				}
				String EnterNumber = txtDisplay.getText() + btn_0.getText();
				txtDisplay.setText(EnterNumber );
				txtVista.setText(txtVista.getText() + btn_0.getText());
				
			}
		});
		btn_0.setForeground(Color.WHITE);
		btn_0.setFont(new Font("Montserrat", Font.BOLD, 22));
		btn_0.setFocusable(false);
		btn_0.setBackground(Color.decode("#2e3951"));
		panel.add(btn_0);
		
		JButton btn_punto = new JButton(".");
		btn_punto.setBounds(174, 317, 48, 47);
		btn_punto.setBorder(null);
		btn_punto.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_punto.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_punto.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn2_dark.png"));
		btn_punto.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
		btn_punto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (borra == true) {
					txtDisplay.setText(null);
					txtVista.setText(null);
					borra = false;
					i=0;
				}
				String EnterNumber = txtDisplay.getText() + btn_punto.getText();
				txtDisplay.setText(EnterNumber );
				txtVista.setText(txtVista.getText() + btn_punto.getText());
				
			}
		});
		btn_punto.setForeground(Color.WHITE);
		btn_punto.setFont(new Font("Montserrat", Font.BOLD, 22));
		btn_punto.setFocusable(false);
		btn_punto.setBackground(Color.decode("#2e3951"));
		panel.add(btn_punto);
		
		JPanel panel_sup = new JPanel();
		panel_sup.setBounds(0, 0, 363, 199);
		panel_sup.setBackground(Color.decode("#212b41"));
		contentPane.add(panel_sup);
		panel_sup.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Simple");
		lblNewLabel.setBounds(10, 42, 117, 44);
		panel_sup.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Montserrat Medium", Font.PLAIN, 24));
		
		
		JButton btn_pro = new JButton("");
		btn_pro.setBounds(297, 10, 56, 36);
		panel_sup.add(btn_pro);
		btn_pro.setFocusPainted(false);
		btn_pro.setFocusable(false);
		btn_pro.setBorder(null);
		btn_pro.setBackground(Color.decode("#2e3951"));
		btn_pro.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\darkmode_3.png"));
		
		JLabel lblNewLabel_1 = new JLabel(" \u2022");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(0, -3, 35, 35);
		panel_sup.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u2022");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		lblNewLabel_1_1.setForeground(Color.ORANGE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel_1_1.setBounds(35, 5, 24, 18);
		panel_sup.add(lblNewLabel_1_1);
		
		txtVista = new JTextField();

		txtVista.setForeground(new Color(153, 204, 102));
		txtVista.setBorder(null);
		txtVista.setBackground(Color.decode("#212b41"));
		txtVista.setEditable(false);
		txtVista.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtVista.setHorizontalAlignment(SwingConstants.RIGHT);
		txtVista.setFont(new Font("Consolas", Font.ITALIC, 18));
		txtVista.setBounds(10, 134, 333, 37);
		contentPane.add(txtVista);
		txtVista.setColumns(10);
		
		txtDisplay = new JTextField();
		txtDisplay.setForeground(new Color(153, 204, 102));
		txtDisplay.setBorder(null);
		txtDisplay.setBackground(Color.decode("#212b41"));
		txtDisplay.setSelectedTextColor(Color.WHITE);
		txtDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDisplay.setFont(new Font("Montserrat SemiBold", Font.PLAIN, 32));
		txtDisplay.setBounds(10, 76, 333, 60);
		contentPane.add(txtDisplay);
		txtDisplay.setColumns(10);
		btn_pro.addActionListener(new ActionListener() {
			boolean modoPro = false;
			public void actionPerformed(ActionEvent e) {
				if (!modoPro) {
					cambiarColorBtn1(btn_producto);
		            cambiarColorBtn1(btn_suma);
		            cambiarColorBtn1(btn_resta);
		            cambiarColorBtn1(btn_cuadrado);
		            cambiarColorBtn1(btn_division);
		            cambiarColorBtn1(btn_borrar);
		            cambiarColorBtn1(btn_raiz);
		            lblNewLabel.setText("Pro");
		            
		            btn_pro.setIcon(new ImageIcon("E:\\\\Eclipse IDE\\\\Workspace\\\\calculadoraJamir\\\\src\\\\images\\\\darkmode_2.png"));
		            btn_igual.setIcon(new ImageIcon("E:\\\\Eclipse IDE\\\\Workspace\\\\calculadoraJamir\\\\src\\\\images\\\\btn3_dark.png"));
		            btn_igual.setPressedIcon(new ImageIcon("E:\\\\Eclipse IDE\\\\Workspace\\\\calculadoraJamir\\\\src\\\\images\\\\btn3_dark.png"));
		            btn_igual.setRolloverIcon(new ImageIcon("E:\\\\Eclipse IDE\\\\Workspace\\\\calculadoraJamir\\\\src\\\\images\\\\btn3_pressed_dark.png"));
		            btn_igual.setHorizontalTextPosition(SwingConstants.CENTER);
		            btn_igual.setBackground(Color.decode("#2e3951"));
		            btn_igual.setForeground(Color.decode("#b914c3"));
		            btn_igual.setForeground(Color.decode("#2e3951"));
		            modoPro = true;
				} else {
		            Principal frame = new Principal();
		            dispose();
		            frame.setVisible(true);
		        }	
			}

		});

	}
	
	
	public void cambiarColorBtn1(JButton btn) {
        btn.setIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_dark.png"));
        btn.setPressedIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_dark.png"));
        btn.setRolloverIcon(new ImageIcon("E:\\Eclipse IDE\\Workspace\\calculadoraJamir\\src\\images\\btn1_pressed_dark.png"));
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        btn.setBackground(Color.decode("#2e3951"));
        btn.setForeground(Color.decode("#b914c3"));
    }
}