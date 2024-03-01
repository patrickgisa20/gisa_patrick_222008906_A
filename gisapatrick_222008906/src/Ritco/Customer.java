package Ritco;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Customer extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField natxf;
	private JTextField ematxf;
	private JTextField motxf;
	private JTextField iniadtxf;
	private JTextField fatxf;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Customer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 975, 602);
		contentPane = new JPanel();
		setTitle("CUSTOMER FORM IN RITCO MANAGEMENT SYSTEM");
		contentPane.setBackground(new Color(100, 100, 100));
		contentPane.setForeground(new Color(155, 155, 155));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER FORM IN RITCO MANAGEMENT SYSTEM ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 10, 883, 40);
		contentPane.add(lblNewLabel);
		
		JLabel nalb = new JLabel("Names");
		nalb.setForeground(new Color(255, 255, 255));
		nalb.setFont(new Font("Tahoma", Font.ITALIC, 23));
		nalb.setBounds(2, 71, 296, 40);
		contentPane.add(nalb);
		
		natxf = new JTextField();
		natxf.setBounds(0, 113, 413, 40);
		contentPane.add(natxf);
		natxf.setColumns(10);
		
		JLabel emalb = new JLabel("Email");
		emalb.setForeground(new Color(255, 255, 255));
		emalb.setFont(new Font("Tahoma", Font.ITALIC, 23));
		emalb.setBounds(0, 158, 296, 40);
		contentPane.add(emalb);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(0, 200, 413, 44);
		contentPane.add(ematxf);
		
		JLabel molb = new JLabel("Mobile");
		molb.setForeground(new Color(255, 255, 255));
		molb.setFont(new Font("Tahoma", Font.ITALIC, 23));
		molb.setBounds(0, 245, 296, 40);
		contentPane.add(molb);
		
		motxf = new JTextField();
		motxf.setColumns(10);
		motxf.setBounds(0, 287, 413, 41);
		contentPane.add(motxf);
		
		JLabel inialb = new JLabel("InitialAddress");
		inialb.setForeground(new Color(255, 255, 255));
		inialb.setFont(new Font("Tahoma", Font.ITALIC, 23));
		inialb.setBounds(0, 333, 296, 40);
		contentPane.add(inialb);
		
		iniadtxf = new JTextField();
		iniadtxf.setColumns(10);
		iniadtxf.setBounds(0, 375, 415, 41);
		contentPane.add(iniadtxf);
		
		JLabel falb = new JLabel("FinalAddress");
		falb.setForeground(new Color(255, 255, 255));
		falb.setFont(new Font("Tahoma", Font.ITALIC, 23));
		falb.setBounds(0, 423, 296, 40);
		contentPane.add(falb);
		
		fatxf = new JTextField();
		fatxf.setColumns(10);
		fatxf.setBounds(0, 460, 415, 42);
		contentPane.add(fatxf);
		
		JButton insertbtn = new JButton("INSERT");
	        insertbtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String Names = natxf.getText();
	                String Email = ematxf.getText();
	                String Mobile = motxf.getText();
	                String InitialAddress = iniadtxf.getText();
	                String FinalAddress = fatxf.getText();

	                try {
	                    Class.forName("com.mysql.cj.jdbc.Driver");

	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "222008906", "222008906");
	                    String sql = "INSERT INTO customer(Names, Email, Mobile, address, addressto) VALUES (?, ?, ?, ?, ?)";
	                    PreparedStatement statement = con.prepareStatement(sql);
	                    statement.setString(1, Names);
	                    statement.setString(2, Email);
	                    statement.setString(3, Mobile);
	                    statement.setString(4, InitialAddress);
	                    statement.setString(5, FinalAddress);

	                    int rowsInserted = statement.executeUpdate();
	                    if (rowsInserted > 0) {
	                    	JOptionPane.showMessageDialog(insertbtn, "A new customer was inserted successfully!");
	                    }
	                    
	                    statement.close();
	                    con.close();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
		
		insertbtn.setBackground(new Color(200, 255, 128));
		insertbtn.setForeground(new Color(0, 0, 255));
		insertbtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		insertbtn.setBounds(500, 113, 133, 40);
		contentPane.add(insertbtn);
		
		JButton readbtn = new JButton("READ");
		readbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "222008906", "222008906");
		            String sql = "SELECT * FROM customer";
		            PreparedStatement statement = con.prepareStatement(sql);
		            ResultSet resultSet = statement.executeQuery();

		            DefaultTableModel model = new DefaultTableModel();
		            model.addColumn("customerid"); 
		            model.addColumn("Names");
		            model.addColumn("Email");
		            model.addColumn("mobile");
		            model.addColumn("address");
		            model.addColumn("addressto");
		            
		            while (resultSet.next()) {
		                int customerid = resultSet.getInt("customerid"); 
		                String Names = resultSet.getString("Names");
		                String Email = resultSet.getString("Email");
		                String mobile = resultSet.getString("mobile");
		                String address = resultSet.getString("address");
		                String addressto = resultSet.getString("addressto");
		                model.addRow(new Object[]{customerid, Names,Email, mobile, address, addressto});
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

		readbtn.setForeground(Color.BLUE);
		readbtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		readbtn.setBackground(new Color(255, 255, 128));
		readbtn.setBounds(650, 112, 133, 40);
		contentPane.add(readbtn);
		
		JButton updatebtn = new JButton("UPDATE");
		updatebtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "root", "");

		            String sql = "UPDATE customer SET Email=?, Mobile=?, address=?, addressto=? WHERE Names=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setString(1, ematxf.getText());
		                stm.setString(2, motxf.getText());
		                stm.setString(3, iniadtxf.getText());
		                stm.setString(4, fatxf.getText());
		                stm.setString(5, natxf.getText());

		                int rowsAffected = stm.executeUpdate(); 

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(updatebtn, "Record updated successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(updatebtn, "No record found with the given name.");
		                }
		            }
		        } catch (Exception e2) {
		            e2.printStackTrace();
		            JOptionPane.showMessageDialog(updatebtn, "An error is found check your eclipse.");
		        }
		    }
		});
		updatebtn.setForeground(Color.BLUE);
		updatebtn.setFont(new Font("Tahoma", Font.ITALIC, 25));
		updatebtn.setBackground(new Color(255, 255, 128));
		updatebtn.setBounds(500, 165, 136, 40);
		contentPane.add(updatebtn);
		
		JButton exitbtn = new JButton("delete");
		exitbtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "root", "");

		            String sql = "DELETE FROM customer WHERE customerid=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setString(1, natxf.getText());

		                int rowsDeleted = stm.executeUpdate(); 

		                if (rowsDeleted > 0) {
		                    JOptionPane.showMessageDialog(exitbtn, "Record deleted successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(exitbtn, "No record found with the given customer id.");
		                }
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(exitbtn, "An error occurred while deleting the record because it has aforiegin key to ticket table.");
		        }
		    }
		});

		exitbtn.setForeground(Color.red);
		exitbtn.setFont(new Font("Tahoma", Font.ITALIC, 25));
		exitbtn.setBackground(new Color(255, 255, 128));
		exitbtn.setBounds(650, 165, 133, 40);
		contentPane.add(exitbtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(500, 216, 379, 290);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 0, 255));
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage page=new HomePage();
				page.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.BLUE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.setBackground(new Color(255, 255, 128));
		btnBack.setBounds(629, 500, 133, 40);
		contentPane.add(btnBack);
	}
}
