package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import backend.ValidateInputBetrag;

public class LoginFrontend extends JFrame implements ActionListener {
	JButton jButton1;
	JPanel jPanel1;
	JTextField jText1;
	JTextField jText2;
	JTextField jText3;
	static Maske frame;
	ActionListener listener;
	public String name;
	public String password;
	public String betrag;
	ValidateInputBetrag blockchain;

	public LoginFrontend(LoginFrontend login) {

		// TextField
		jText1 = new JTextField();
		jText1.setSize(100, 100);
		jText1.setText("multichainrpc");
		getContentPane().add(jText1);

		// TextField
		jText2 = new JTextField();
		jText2.setSize(100, 100);
		jText2.setText("Csh4eMi3s9r4yVQ1CY2RtrF8uduhiojJBi1ASNUGKwpM");
		getContentPane().add(jText2);

		// TextField
		jText3 = new JTextField();
		jText3.setSize(100, 100);
		jText3.setText("500");
		getContentPane().add(jText3);

		// ButtonParameter
		jButton1 = new javax.swing.JButton();
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				name = jText1.getText();
				password = jText2.getText();
				betrag = jText3.getText();
				System.out.println(name);
				System.out.println(password);
				System.out.println(betrag);
				blockchain = new ValidateInputBetrag();
				blockchain.callBlockchain(name, password, convertStringToHex(Integer.parseInt(betrag)));

			}
		});

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.FlowLayout());
		jButton1.setText("jButton1");
		getContentPane().add(jButton1);

		// FensterParameter
		this.setTitle("Anmelden");
		this.setSize(1000, 620);
		this.setResizable(false);
		this.setLocation(50, 50);
		this.setVisible(true);
		pack();
	}

	private static String convertStringToHex(Integer s) {
    	String hexAppend;
    	hexAppend = Integer.toHexString(s);
    	
    	if (hexAppend.length()%2!=0)
    	{
    		StringBuilder sb= new StringBuilder();
    		sb.append("0");
    		sb.append(hexAppend);
    		return sb.toString();
    		}
    	else {
    	return hexAppend;}

    }

	public String getName() {
		return name;

	}

	public String getPw() {
		return password;

	}

	public static void main(String[] args) {
		LoginFrontend login = null;
		login = new LoginFrontend(login);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
