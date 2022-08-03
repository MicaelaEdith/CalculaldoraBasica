import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.invoke.SwitchPoint;

import javax.swing.JButton;

public class Calculadora extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	double numero1,numero2,resultado;
	String stringNumero1="", stringNumero2="",historialNum="",stringResultado="";
	boolean banderaOperacion=false, resultadoCalc=false,AcOk=false,calculado=false;
	char operacion=' ';
	
	public Calculadora() {
		setForeground(SystemColor.control);
		setBackground(SystemColor.text);
		setTitle("Calculadora");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 443);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("DesktopIcon.border"));
		contentPane.setForeground(new Color(255, 255, 224));
		contentPane.setBackground(new Color(248, 248, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		seteoPanel();		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 113, 50, 50);
		panel_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)
				panel_1.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				presionarNumero(1);
			}
		});
		panel_1.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("1");
		label_1.setForeground(new Color(128, 128, 128));
		label_1.setBackground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Cookie", Font.BOLD, 34));
		label_1.setBounds(0, 0, 50, 50);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(78, 113, 50, 50);
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_2.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_2.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				presionarNumero(2);
			}
		});
		panel_2.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("2");
		label_2.setForeground(new Color(128, 128, 128));
		label_2.setBackground(new Color(255, 255, 240));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Cookie", Font.BOLD, 34));
		label_2.setBounds(0, 0, 50, 50);
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(138, 113, 50, 50);
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_3.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				presionarNumero(3);
			}
		});
		panel_3.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_3 = new JLabel("3");
		label_3.setForeground(new Color(128, 128, 128));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Cookie", Font.BOLD, 34));
		label_3.setBounds(0, 0, 50, 50);
		panel_3.add(label_3);
		
		JPanel panel_mas = new JPanel();
		panel_mas.setBounds(198, 113, 50, 50);
		panel_mas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_mas.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_mas.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				presionarOperacion('+');
			}
		});
		panel_mas.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_mas);
		panel_mas.setLayout(null);
		
		JLabel label_12 = new JLabel("+");
		label_12.setForeground(new Color(128, 128, 128));
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Cookie", Font.BOLD, 34));
		label_12.setBounds(0, 0, 50, 50);
		panel_mas.add(label_12);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(20, 173, 50, 50);
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_4.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				presionarNumero(4);
			}
		});
		panel_4.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_4 = new JLabel("4");
		label_4.setForeground(new Color(128, 128, 128));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Cookie", Font.BOLD, 34));
		label_4.setBounds(0, 0, 50, 50);
		panel_4.add(label_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(78, 173, 50, 50);
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_5.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				presionarNumero(5);
			}
		});
		panel_5.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_5 = new JLabel("5");
		label_5.setForeground(new Color(128, 128, 128));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Cookie", Font.BOLD, 34));
		label_5.setBounds(0, 0, 50, 50);
		panel_5.add(label_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(138, 173, 50, 50);
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_6.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				presionarNumero(6);
			}
		});
		panel_6.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_6 = new JLabel("6");
		label_6.setForeground(new Color(128, 128, 128));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Cookie", Font.BOLD, 34));
		label_6.setBounds(0, 0, 50, 50);
		panel_6.add(label_6);
		
		JPanel panel_menos = new JPanel();
		panel_menos.setBounds(198, 173, 50, 50);
		panel_menos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_menos.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_menos.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				presionarOperacion('-');
			}
		});
		panel_menos.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_menos);
		panel_menos.setLayout(null);
		
		JLabel label_13 = new JLabel("-");
		label_13.setForeground(new Color(128, 128, 128));
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setFont(new Font("Cookie", Font.BOLD, 34));
		label_13.setBounds(0, 0, 50, 50);
		panel_menos.add(label_13);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(20, 234, 50, 50);
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_7.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_7.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				presionarNumero(7);
			}
		});
		panel_7.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel label_7 = new JLabel("7");
		label_7.setForeground(new Color(128, 128, 128));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Cookie", Font.BOLD, 34));
		label_7.setBounds(0, 0, 50, 50);
		panel_7.add(label_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(78, 234, 50, 50);
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_8.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_8.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				presionarNumero(8);
			}
		});
		panel_8.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel label_8 = new JLabel("8");
		label_8.setForeground(new Color(128, 128, 128));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Cookie", Font.BOLD, 34));
		label_8.setBounds(0, 0, 50, 50);
		panel_8.add(label_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(138, 234, 50, 50);
		panel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_9.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_9.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				presionarNumero(9);
			}
		});
		panel_9.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel label_9 = new JLabel("9");
		label_9.setForeground(new Color(128, 128, 128));
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Cookie", Font.BOLD, 34));
		label_9.setBounds(0, 0, 50, 50);
		panel_9.add(label_9);
		
		JPanel panel_div = new JPanel();
		panel_div.setBounds(198, 234, 50, 50);
		panel_div.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_div.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_div.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				presionarOperacion('/');
			}
		});
		panel_div.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_div);
		panel_div.setLayout(null);
		
		JLabel label_14 = new JLabel("/");
		label_14.setForeground(new Color(128, 128, 128));
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setFont(new Font("Cookie", Font.BOLD, 34));
		label_14.setBounds(0, 0, 50, 50);
		panel_div.add(label_14);
		
		JPanel panel_coma = new JPanel();
		panel_coma.setBounds(20, 295, 50, 50);
		panel_coma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_coma.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_coma.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				presionarComa();
			}
		});
		panel_coma.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_coma);
		panel_coma.setLayout(null);
		
		JLabel lblComa = new JLabel(",");
		lblComa.setVerticalAlignment(SwingConstants.TOP);
		lblComa.setForeground(new Color(128, 128, 128));
		lblComa.setHorizontalAlignment(SwingConstants.CENTER);
		lblComa.setFont(new Font("Cookie", Font.BOLD, 30));
		lblComa.setBounds(0, 0, 50, 50);
		panel_coma.add(lblComa);
		
		JPanel panel_0 = new JPanel();
		panel_0.setBounds(78, 295, 50, 50);
		panel_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_0.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_0.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				presionarNumero(0);
			}
		});
		panel_0.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_0);
		panel_0.setLayout(null);
		
		JLabel label_10 = new JLabel("0");
		label_10.setForeground(new Color(128, 128, 128));
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Cookie", Font.BOLD, 34));
		label_10.setBounds(0, 0, 50, 50);
		panel_0.add(label_10);
		
		JPanel panel_igual = new JPanel();
		panel_igual.setBounds(138, 295, 50, 50);
		panel_igual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_igual.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_igual.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				calcular(operacion);
				calculado=true;
			}
		});
		panel_igual.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_igual);
		panel_igual.setLayout(null);
		
		JLabel label_11 = new JLabel("=");
		label_11.setForeground(new Color(128, 128, 128));
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Cookie", Font.BOLD, 34));
		label_11.setBounds(0, 0, 50, 50);
		panel_igual.add(label_11);
		
		JPanel panel_por = new JPanel();
		panel_por.setBounds(198, 295, 50, 50);
		panel_por.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(!calculado)panel_por.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_por.setBackground(new Color(255, 255, 240));				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				presionarOperacion('*');
			}
		});
		panel_por.setBackground(new Color(255, 255, 240));
		contentPane.add(panel_por);
		panel_por.setLayout(null);
		
		JLabel label_15 = new JLabel("*");
		label_15.setForeground(new Color(128, 128, 128));
		label_15.setVerticalAlignment(SwingConstants.BOTTOM);
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setFont(new Font("Cookie", Font.BOLD, 34));
		label_15.setBounds(0, 0, 50, 50);
		panel_por.add(label_15);
		
		JPanel panel_C = new JPanel();
		panel_C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(!calculado)panel_C.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_C.setBackground(new Color(255, 255, 240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
					if(!banderaOperacion)stringNumero1="";
					else stringNumero2="";
					seteoPanel();
						
				}
			});
		panel_C.setLayout(null);
		panel_C.setBackground(new Color(255, 255, 240));
		panel_C.setBounds(20, 352, 108, 36);
		contentPane.add(panel_C);
		
		JLabel lblC = new JLabel("C");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setForeground(Color.GRAY);
		lblC.setFont(new Font("Candara Light", Font.BOLD, 22));
		lblC.setBounds(0, 0, 107, 36);
		panel_C.add(lblC);
		
		JPanel panel_AC = new JPanel();
		panel_AC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_AC.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_AC.setBackground(new Color(255, 255, 240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				stringNumero1="";
				stringNumero2="";
				stringResultado="";
				resultado=0;
				banderaOperacion=false;
				resultadoCalc=false;
				AcOk=true;
				calculado=false;
				operacion=' ';
				seteoPanel();
			}
		});
		
		panel_AC.setLayout(null);
		panel_AC.setBackground(new Color(255, 255, 240));
		panel_AC.setBounds(140, 352, 108, 36);
		contentPane.add(panel_AC);
		
		JLabel lblAc = new JLabel("AC");
		lblAc.setHorizontalAlignment(SwingConstants.CENTER);
		lblAc.setForeground(Color.GRAY);
		lblAc.setFont(new Font("Candara Light", Font.BOLD, 22));
		lblAc.setBounds(0, 0, 107, 36);
		panel_AC.add(lblAc);
		
	}

	public void presionarNumero(int numero){			
	
		if(!banderaOperacion)
		stringNumero1=stringNumero1+numero;
		else stringNumero2=stringNumero2+numero;
		seteoPanel();
	}

	public void presionarComa(){
		if(!banderaOperacion)stringNumero1=stringNumero1+'.';
		else stringNumero2=stringNumero2+'.';
		seteoPanel();
		
	}

	public void presionarOperacion(char ope){
		
		if(!banderaOperacion){
			operacion=ope;
			banderaOperacion=true;}
			seteoPanel();
	}
	
	public void calcular(char opeCalc){
		numero1=Double.parseDouble(stringNumero1);
		numero2=Double.parseDouble(stringNumero2);
		switch (opeCalc) {
		case '+': resultado=numero1+numero2;
			break;
		case '-': resultado=numero1-numero2;
		    break;
		case '/': resultado=numero1/numero2;
		    break;
		default:  resultado=numero1*numero2;
			break;
		}
		if(!resultadoCalc)stringResultado=stringResultado+resultado;
		historialNum=stringNumero1+" "+operacion+" "+stringNumero2+" = "+resultado;
		resultadoCalc=true;
		seteoPanel();		
	}

	public void seteoPanel(){
		JPanel panel = new JPanel();
		panel.setBounds(20, 21, 228, 67);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel labelHistorial = new JLabel("");
		labelHistorial.setFont(new Font("Cookie", Font.PLAIN, 22));
		labelHistorial.setBounds(0, 0, 96, 21);
		panel.add(labelHistorial);
		
		JLabel LBLentradaNumeros = new JLabel("");
		LBLentradaNumeros.setHorizontalAlignment(SwingConstants.RIGHT);
		LBLentradaNumeros.setForeground(new Color(128, 128, 128));
		LBLentradaNumeros.setFont(new Font("Cookie", Font.BOLD, 40));
		LBLentradaNumeros.setBounds(10, 22, 216, 45);
		panel.add(LBLentradaNumeros); 
		if(AcOk){AcOk=false;LBLentradaNumeros.setText(" ");}
		else{if(!resultadoCalc){
			    if (!banderaOperacion)LBLentradaNumeros.setText(stringNumero1);
			    else LBLentradaNumeros.setText(stringNumero1 + operacion + stringNumero2);}
		     else LBLentradaNumeros.setText(stringResultado);
		}

	    labelHistorial.setText(historialNum);
	}
}
