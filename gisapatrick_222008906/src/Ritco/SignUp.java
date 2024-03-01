package Ritco;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class SignUp {

	 JFrame frame;
	private JTextField fntxf;
	private JTextField lntxf;
	private JTextField ematxf;
	private JTextField usertxf;
	private JTextField passtxf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("SIGN UP FORM  IN RITCO MANAGEMENT SYSTEM");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 944, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP FORM FOR ALL MEMBERS");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(94, 0, 791, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel fnlb = new JLabel("FirstName");
		fnlb.setForeground(new Color(255, 255, 255));
		fnlb.setFont(new Font("Tahoma", Font.ITALIC, 20));
		fnlb.setHorizontalAlignment(SwingConstants.CENTER);
		fnlb.setBounds(137, 53, 373, 55);
		frame.getContentPane().add(fnlb);
		
		fntxf = new JTextField();
		fntxf.setBounds(109, 106, 487, 47);
		frame.getContentPane().add(fntxf);
		fntxf.setColumns(10);
		
		JLabel lnlb = new JLabel("LastName");
		lnlb.setForeground(new Color(255, 255, 255));
		lnlb.setHorizontalAlignment(SwingConstants.CENTER);
		lnlb.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lnlb.setBounds(147, 154, 373, 55);
		frame.getContentPane().add(lnlb);
		
		lntxf = new JTextField();
		lntxf.setColumns(10);
		lntxf.setBounds(107, 207, 487, 47);
		frame.getContentPane().add(lntxf);
		
		JLabel emalb = new JLabel("Email");
		emalb.setForeground(new Color(255, 255, 255));
		emalb.setHorizontalAlignment(SwingConstants.CENTER);
		emalb.setFont(new Font("Tahoma", Font.ITALIC, 20));
		emalb.setBounds(108, 259, 373, 55);
		frame.getContentPane().add(emalb);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(103, 309, 487, 47);
		frame.getContentPane().add(ematxf);
		
		JLabel userlb = new JLabel("UserName");
		userlb.setForeground(new Color(255, 255, 255));
		userlb.setHorizontalAlignment(SwingConstants.CENTER);
		userlb.setFont(new Font("Tahoma", Font.ITALIC, 20));
		userlb.setBounds(156, 361, 373, 55);
		frame.getContentPane().add(userlb);
		
		usertxf = new JTextField();
		usertxf.setColumns(10);
		usertxf.setBounds(104, 409, 487, 47);
		frame.getContentPane().add(usertxf);
		
		JLabel passlb = new JLabel("PassWord");
		passlb.setForeground(new Color(255, 255, 255));
		passlb.setHorizontalAlignment(SwingConstants.CENTER);
		passlb.setFont(new Font("Tahoma", Font.ITALIC, 20));
		passlb.setBounds(155, 459, 373, 55);
		frame.getContentPane().add(passlb);
		
		passtxf = new JTextField();
		passtxf.setColumns(10);
		passtxf.setBounds(103, 512, 487, 47);
		frame.getContentPane().add(passtxf);
		
		JButton signinbtn = new JButton("SIGN IN");
		 signinbtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String firstName = fntxf.getText();
	                String lastName = lntxf.getText();
	                String email = ematxf.getText();
	                String username = usertxf.getText();
	                String password = passtxf.getText();

	                try {
	                	Class.forName("com.mysql.cj.jdbc.Driver");

						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");
	                    String sql = "INSERT INTO signup (firstname, lastname, email, username, password) VALUES (?, ?, ?, ?, ?)";
	                    PreparedStatement statement = con.prepareStatement(sql);
	                    statement.setString(1, firstName);
	                    statement.setString(2, lastName);
	                    statement.setString(3, email);
	                    statement.setString(4, username);
	                    statement.setString(5, password);

	                  
	                    int rowsInserted = statement.executeUpdate();
	                    if (rowsInserted > 0) {
	                    	  JOptionPane.showMessageDialog(signinbtn, "A new user was inserted successfully!");
	                
	                    }

	                 
	                    statement.close();
	                    con.close();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
					
		signinbtn.setBackground(new Color(255, 255, 128));
		signinbtn.setForeground(new Color(0, 128, 255));
		signinbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		signinbtn.setBounds(711, 107, 112, 47);
		frame.getContentPane().add(signinbtn);
		
		
		 JButton cancelbtn = new JButton("CANCEL");
	        cancelbtn.setForeground(new Color(0, 128, 255));
	        cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 18));
	        cancelbtn.setBackground(new Color(255, 255, 128));
	        cancelbtn.setBounds(711, 164, 112, 47);
	        cancelbtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                frame.dispose(); 
	            }
	        });
	        frame.getContentPane().add(cancelbtn);
		
		JButton Gobtn = new JButton("GO");
		Gobtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log=new Login();
				log.setVisible(true);
				frame.dispose();
			}
		});
		Gobtn.setForeground(new Color(0, 128, 255));
		Gobtn.setFont(new Font("Tahoma", Font.BOLD, 30));
		Gobtn.setBackground(new Color(255, 255, 128));
		Gobtn.setBounds(819, 519, 112, 47);
		frame.getContentPane().add(Gobtn);
	}
}
