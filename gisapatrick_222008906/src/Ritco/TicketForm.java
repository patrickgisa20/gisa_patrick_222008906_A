package Ritco;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class TicketForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField bustxf;
	private JTextField custxf;
	private JTextField dritxf;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketForm frame = new TicketForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TicketForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 972, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		setTitle("TICKET FORM IS HERE IN RITCO SYSTEM");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TICKET FORM IS HERE IN RITCO SYSTEM");
		lblNewLabel.setForeground(new Color(0, 0, 150));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 10, 850, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BusID");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 65, 424, 37);
		contentPane.add(lblNewLabel_1);
		
		bustxf = new JTextField();
		bustxf.setBounds(12, 104, 500, 37);
		contentPane.add(bustxf);
		bustxf.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("CustomerID");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(0, 137, 400, 45);
		contentPane.add(lblNewLabel_1_1);
		
		custxf = new JTextField();
		custxf.setColumns(10);
		custxf.setBounds(10, 181, 500, 37);
		contentPane.add(custxf);
		
		JLabel lblNewLabel_1_2 = new JLabel("DriverID");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1_2.setBounds(0, 220, 424, 46);
		contentPane.add(lblNewLabel_1_2);
		
		dritxf = new JTextField();
		dritxf.setColumns(10);
		dritxf.setBounds(10, 268, 500, 37);
		contentPane.add(dritxf);
		
		JLabel startxf = new JLabel("Start");
		startxf.setForeground(new Color(255, 255, 255));
		startxf.setFont(new Font("Tahoma", Font.ITALIC, 20));
		startxf.setBounds(0, 303, 424, 45);
		contentPane.add(startxf);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 347, 500, 37);
		contentPane.add(textField_3);
		
		JLabel stoptxf = new JLabel("Stop");
		stoptxf.setForeground(new Color(255, 255, 255));
		stoptxf.setFont(new Font("Tahoma", Font.ITALIC, 20));
		stoptxf.setBounds(0, 387, 424, 45);
		contentPane.add(stoptxf);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 431, 500, 37);
		contentPane.add(textField_4);
		
		JLabel tdtxf = new JLabel("TicketDate");
		tdtxf.setForeground(new Color(255, 255, 255));
		tdtxf.setFont(new Font("Tahoma", Font.ITALIC, 20));
		tdtxf.setBounds(0, 472, 424, 45);
		contentPane.add(tdtxf);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 516, 500, 37);
		contentPane.add(textField_5);
		
		JButton addbtn = new JButton("ADD");
		
	        addbtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String busID = bustxf.getText();
	                String customerID = custxf.getText();
	                String driverID = dritxf.getText();
	                String start = textField_3.getText();
	                String stop = textField_4.getText();
	                String ticketDate = textField_5.getText();

	                try {
	                    Class.forName("com.mysql.cj.jdbc.Driver");

	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "222008906", "222008906");
	                    String sql = "INSERT INTO ticket(Bus_id, customerid, driver_id, Start, Stop, Date) VALUES (?, ?, ?, ?, ?, ?)";
	                    PreparedStatement statement = con.prepareStatement(sql);
	                    statement.setString(1, busID);
	                    statement.setString(2, customerID);
	                    statement.setString(3, driverID);
	                    statement.setString(4, start);
	                    statement.setString(5, stop);
	                    statement.setString(6, ticketDate);

	                    int rowsInserted = statement.executeUpdate();
	                    if (rowsInserted > 0) {
	                    	JOptionPane.showMessageDialog(addbtn, "A new customer was inserted successfully!");
	                    }

	                    statement.close();
	                    con.close();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
		addbtn.setBackground(Color.PINK);
		addbtn.setForeground(new Color(0, 0, 255));
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		addbtn.setBounds(520, 430, 120, 53);
		contentPane.add(addbtn);
		
		JButton readbtn = new JButton("READ");
		readbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "222008906", "222008906");
		            String sql = "SELECT * FROM ticket";
		            PreparedStatement statement = con.prepareStatement(sql);
		            ResultSet resultSet = statement.executeQuery();

		            
		            DefaultTableModel model = new DefaultTableModel();
		            model.addColumn("Bus ID"); 
		            model.addColumn("Customer ID");
		            model.addColumn("Driver ID");
		            model.addColumn("Start");
		            model.addColumn("Stop");
		            model.addColumn("Ticket Date");

		            while (resultSet.next()) {
		                int busId = resultSet.getInt("Bus_id"); 
		                String customerId = resultSet.getString("customerid");
		                String driverId = resultSet.getString("driver_id");
		                String start = resultSet.getString("Start");
		                String stop = resultSet.getString("Stop");
		                String ticketDate = resultSet.getString("Date");
		                model.addRow(new Object[]{busId, customerId, driverId, start, stop, ticketDate});
		            }

		            table.setModel(model);

		            resultSet.close();
		            statement.close();
		            con.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		readbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    }
		});
		readbtn.setForeground(Color.BLUE);
		readbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		readbtn.setBackground(Color.PINK);
		readbtn.setBounds(640, 430, 100, 50);
		contentPane.add(readbtn);

		JButton updatebtn = new JButton("UPDATE");
		updatebtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		           
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            
		            
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "root", "");
		            
		            
		            String sql = "UPDATE ticket SET Start=?, Stop=?, Date=? WHERE Bus_id=?";
		            
		           
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                
		                
		                stm.setString(1, textField_3.getText()); 
		                stm.setString(2, textField_4.getText()); 
		                stm.setString(3, textField_5.getText());
		                stm.setString(4, bustxf.getText());       
		                
		                
		                int rowsUpdated = stm.executeUpdate();

		 
		                if (rowsUpdated > 0) {
		                    JOptionPane.showMessageDialog(updatebtn, "Record updated successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(updatebtn, "No record found with the given Bus ID.");
		                }
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(updatebtn, "An error occurred while updating the record.");
		        }
		    }
		});

		updatebtn.setForeground(Color.BLUE);
		updatebtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		updatebtn.setBackground(Color.PINK);
		updatebtn.setBounds(740, 430, 120, 53);
		contentPane.add(updatebtn);

		
		JButton deletebtn= new JButton("DELETE");
		deletebtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "root", "");

		            String sql = "DELETE FROM ticket WHERE ticket_id=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                int ticket_id = Integer.parseInt(bustxf.getText());
		                stm.setInt(1, ticket_id);

		                int rowsAffected = stm.executeUpdate(); 

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(deletebtn, "Record deleted successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(deletebtn, "No record found with the given id.");
		                }
		            }
		        } catch (Exception e2) {
		            e2.printStackTrace();
		            JOptionPane.showMessageDialog(deletebtn, "An error occurred while executing your command.");
		        }
		    }
		});

		deletebtn.setForeground(Color.BLUE);
		deletebtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		deletebtn.setBackground(Color.PINK);
		deletebtn.setBounds(860, 430, 120, 53);
		contentPane.add(deletebtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(528, 62, 400, 350);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 100, 150));
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home=new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(Color.PINK);
		btnBack.setBounds(540, 510, 120, 53);
		contentPane.add(btnBack);
	}

}
