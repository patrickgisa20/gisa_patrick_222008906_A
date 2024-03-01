package Ritco;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usertxf;
	private JTextField passtxf;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 457);
		contentPane = new JPanel();
		setTitle("LOG IN FORM IN RITCO MANAGEMENT SYSTEM ");
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOG IN FORM IS HERE");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(92, 10, 456, 43);
		contentPane.add(lblNewLabel);
		
		JLabel userlb = new JLabel("USERNAME");
		userlb.setForeground(new Color(255, 255, 255));
		userlb.setFont(new Font("Tahoma", Font.BOLD, 29));
		userlb.setBounds(50, 98, 392, 43);
		contentPane.add(userlb);
		
		usertxf = new JTextField();
		usertxf.setBounds(30, 143, 489, 49);
		contentPane.add(usertxf);
		usertxf.setColumns(10);
		
		JLabel passlb = new JLabel("PASSWORD");
		passlb.setForeground(new Color(255, 255, 255));
		passlb.setFont(new Font("Tahoma", Font.BOLD, 28));
		passlb.setBounds(50, 199, 392, 43);
		contentPane.add(passlb);
		
		passtxf = new JTextField();
		passtxf.setColumns(10);
		passtxf.setBounds(32, 244, 489, 49);
		contentPane.add(passtxf);
		
		JButton loginbtn = new JButton("LOG IN");
		 loginbtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String username = usertxf.getText();
	                String password = passtxf.getText();

	                try {
	                    Class.forName("com.mysql.cj.jdbc.Driver");

	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "222008906", "222008906");
	                    String sql = "SELECT Username,password FROM signup WHERE Username = ? AND password= ?";
	                    PreparedStatement statement = con.prepareStatement(sql);
	                    statement.setString(1, username);
	                    statement.setString(2, password);

	                    ResultSet result = statement.executeQuery();
	                    if (result.next()) {

	                        HomePage home = new HomePage();
	                        home.setVisible(true);
	                        dispose(); 
	                    } else {

	                        System.out.println("Invalid username or password!");
	                    }

	            
	                    result.close();
	                    statement.close();
	                    con.close();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	                
	                
	            }
	        });
						
		
		loginbtn.setBackground(new Color(255, 255, 128));
		loginbtn.setForeground(new Color(0, 128, 192));
		loginbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		loginbtn.setBounds(40, 341, 138, 49);
		contentPane.add(loginbtn);
		
		JButton signinbtn = new JButton("SIGN IN");
		signinbtn.setBackground(new Color(255, 255, 128));
		signinbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp si=new SignUp();
				si.frame.setVisible(true);
				dispose();
			}
		});
		signinbtn.setForeground(new Color(0, 128, 192));
		signinbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		signinbtn.setBounds(200, 341, 150, 49);
		contentPane.add(signinbtn);
		
		  JButton cancelbtn = new JButton("CANCEL");
	        cancelbtn.setBackground(new Color(255, 255, 128));
	        cancelbtn.setForeground(new Color(0, 128, 192));
	        cancelbtn.setFont(new Font("Tahoma", Font.BOLD, 22));
	        cancelbtn.setBounds(380, 341, 139, 49);
	        cancelbtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose(); 
	            }
	        });
	        contentPane.add(cancelbtn);
	}

}
