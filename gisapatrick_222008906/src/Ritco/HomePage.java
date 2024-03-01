package Ritco;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 576);
		setResizable(false);
		contentPane = new JPanel();
		setTitle("WECOME OUR HOME PAGE");
		contentPane.setBackground(Color.darkGray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WECOME OUR HOME PAGE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD , 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-15, 10, 866, 63);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CUSTOMERS FORM");
		btnNewButton.setBackground(new Color(250, 250, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cu=new Customer();
				cu.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 250));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(10, 114, 339, 50);
		contentPane.add(btnNewButton);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log=new Login();
				log.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setForeground(Color.BLUE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogOut.setBounds(730, 489, 185, 50);
		contentPane.add(btnLogOut);
		
		JButton btnDriverForm = new JButton("DRIVER FORM");
		btnDriverForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriveForm form=new DriveForm();
				form.setVisible(true);
				dispose();
			}
		});
		btnDriverForm.setBackground(new Color(255, 255, 0));
		btnDriverForm.setForeground(Color.BLUE);
		btnDriverForm.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnDriverForm.setBounds(10, 232, 339, 50);
		contentPane.add(btnDriverForm);
		
		JButton btnBusForm = new JButton("BUS FORM");
		btnBusForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BusForm form=new BusForm();
				form.setVisible(true);
				dispose();
			}
		});
		btnBusForm.setBackground(new Color(255, 255, 0));
		btnBusForm.setForeground(Color.BLUE);
		btnBusForm.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBusForm.setBounds(10, 333, 339, 50);
		contentPane.add(btnBusForm);
		
		JButton btnTictetForm = new JButton("Tictet FORM");
		btnTictetForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TicketForm form=new TicketForm();
			form.setVisible(true);
			dispose();
			}
		});
		btnTictetForm.setBackground(new Color(255, 255, 0));
		btnTictetForm.setForeground(Color.BLUE);
		btnTictetForm.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnTictetForm.setBounds(10, 433, 339, 50);
		contentPane.add(btnTictetForm);
		
		JLabel lblNewLabel_1 = new JLabel("Ritco ltd is a public -private partnership transport company that was");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(377, 100, 538, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("established to improve public transport services in Rwanda and in the");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(378, 128, 540, 60);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("region in order to bring out of isolation citizens living in rural areas");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(377, 160, 538, 50);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("facilitating their access to development activities at affordable prices.");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(377, 188, 538, 50);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\Desktop\\ritco.jpg"));
		lblNewLabel_2.setBounds(500, 232, 402, 258);
		contentPane.add(lblNewLabel_2);
	}

}
