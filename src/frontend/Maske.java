package frontend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Maske extends JFrame implements ActionListener{

	JButton jButton1;
	JPanel  jPanel1;
	JTextField jText1;
	static Maske frame;
	ActionListener listener;
	
	public Maske() {
		// TODO Auto-generated constructor stub
	
	}
	
	public void initFrame(Maske frame) {
 

	

        

        
        //TextField
        jText1 = new JTextField();
        jText1.setSize(100,100);
        jText1.setText("DAS ,uss doch niungehge");
        getContentPane().add(jText1);
        
        
	    //ButtonParameter
		jButton1 = new javax.swing.JButton();
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(jText1.getText());
			}
		});
		
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());
        jButton1.setText("jButton1");
        getContentPane().add(jButton1);
 
    	//FensterParameter   
		this.setTitle("Word Cloud");
	    this.setSize(1000, 620);
	    this.setResizable(false);
	    this.setLocation(50, 50);
	    this.setVisible(true);
        pack();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     frame=new Maske();
	 	 frame.initFrame(frame);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
