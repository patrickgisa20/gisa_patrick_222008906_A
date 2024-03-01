package Ritco;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
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

public class DriveForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField natxf;
	private JTextField motxf;
	private JTextField ematxf;
	private JTextField litxf;
	private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriveForm frame = new DriveForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public DriveForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 922, 555);
		contentPane = new JPanel();
		setTitle("DRIVER FORM IN RITCO MANAGEMENT SYSTEM");
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DRIVER FORM IN RITCO MANAGEMENT SYSTEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 888, 35);
		contentPane.add(lblNewLabel);
		
		JLabel nalb = new JLabel("Names");
		nalb.setForeground(new Color(255, 255, 255));
		nalb.setFont(new Font("Tahoma", Font.ITALIC, 20));
		nalb.setBounds(37, 65, 213, 45);
		contentPane.add(nalb);
		
		natxf = new JTextField();
		natxf.setBounds(10, 123, 351, 45);
		contentPane.add(natxf);
		natxf.setColumns(10);
		
		JLabel molb = new JLabel("Mobile");
		molb.setForeground(Color.WHITE);
		molb.setFont(new Font("Tahoma", Font.ITALIC, 20));
		molb.setBounds(33, 170, 217, 45);
		contentPane.add(molb);
		
		motxf = new JTextField();
		motxf.setColumns(10);
		motxf.setBounds(20, 228, 341, 45);
		contentPane.add(motxf);
		
		JLabel emalb = new JLabel("Email");
		emalb.setForeground(Color.WHITE);
		emalb.setFont(new Font("Tahoma", Font.ITALIC, 20));
		emalb.setBounds(36, 271, 214, 45);
		contentPane.add(emalb);
		
		ematxf = new JTextField();
		ematxf.setColumns(10);
		ematxf.setBounds(23, 329, 338, 45);
		contentPane.add(ematxf);
		
		JLabel lilb = new JLabel("Licence");
		lilb.setForeground(Color.WHITE);
		lilb.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lilb.setBounds(33, 378, 217, 45);
		contentPane.add(lilb);
		
		litxf = new JTextField();
		litxf.setColumns(10);
		litxf.setBounds(20, 436, 341, 45);
		contentPane.add(litxf);
		
		JButton insertbtn = new JButton("INSERT");
	        insertbtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String Names = natxf.getText();
	                String Mobile = motxf.getText();
	                String Email = ematxf.getText();
	                String Licence = litxf.getText();

	                try {
	                    Class.forName("com.mysql.cj.jdbc.Driver");

	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "222008906", "222008906");
	                    String sql = "INSERT INTO driver(Names, Mobile, Email, Licence) VALUES (?, ?, ?, ?)";
	                    PreparedStatement statement = con.prepareStatement(sql);
	                    statement.setString(1, Names);
	                    statement.setString(2, Mobile);
	                    statement.setString(3, Email);
	                    statement.setString(4, Licence);

	                    int rowsInserted = statement.executeUpdate();
	                    if (rowsInserted > 0) {
	                        JOptionPane.showMessageDialog(insertbtn, "New driver information inserted successfully!");
	                    }
	                    
	                    statement.close();
	                    con.close();
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
		insertbtn.setBackground(new Color(255, 255, 0));
		insertbtn.setForeground(new Color(0, 0, 255));
		insertbtn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		insertbtn.setBounds(379, 120, 139, 45);
		contentPane.add(insertbtn);
		
		JButton btnRead = new JButton("READ");

		btnRead.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "222008906", "222008906");
		            String sql = "SELECT * FROM driver";
		            PreparedStatement statement = con.prepareStatement(sql);
		            ResultSet resultSet = statement.executeQuery();

		            
		            DefaultTableModel model = new DefaultTableModel();
		            model.addColumn("Driver ID");
		            model.addColumn("Names");
		            model.addColumn("Mobile");
		            model.addColumn("Email");
		            model.addColumn("Licence");

		            while (resultSet.next()) {
		                int driverId = resultSet.getInt("driver_id");
		                String name = resultSet.getString("Names");
		                String mobile = resultSet.getString("Mobile");
		                String email = resultSet.getString("Email");
		                String licence = resultSet.getString("Licence");
		                model.addRow(new Object[]{driverId, name, mobile, email, licence});
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


		btnRead.setForeground(Color.BLUE);
		btnRead.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnRead.setBackground(Color.YELLOW);
		btnRead.setBounds(379, 170, 139, 45);
		contentPane.add(btnRead);
		
		JButton btnu = new JButton("UPDATE");
		btnu.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "root", "");

		            String sql = "UPDATE driver SET Mobile=?, Email=?, licence=? WHERE Names=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setString(1, motxf.getText());
		                stm.setString(2, ematxf.getText());
		                stm.setString(3, litxf.getText());
		                stm.setString(4, natxf.getText());

		                int rowsAffected = stm.executeUpdate(); 

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(btnu, "Record updated successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(btnu, "No record found with the given name.");
		                }
		            }
		        } catch (Exception e2) {
		            e2.printStackTrace();
		            JOptionPane.showMessageDialog(btnu, "An error is found.");
		        }
		    }
		});
		btnu.setForeground(Color.BLUE);
		btnu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnu.setBackground(Color.YELLOW);
		btnu.setBounds(379, 228, 139, 45);
		contentPane.add(btnu);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "root", "");

		            String sql = "DELETE FROM driver WHERE Names=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setString(1, natxf.getText());

		                int rowsAffected = stm.executeUpdate(); 

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(btnDelete, "Record deleted successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(btnDelete, "No record found with the given name.");
		                }
		            }
		        } catch (Exception e2) {
		            e2.printStackTrace();
		            JOptionPane.showMessageDialog(btnDelete, "An error occurred. Please check the console for details.");
		        }
		    }
		});
		btnDelete.setForeground(Color.BLUE);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDelete.setBackground(Color.red);
		btnDelete.setBounds(379, 283, 139, 45);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(528, 62, 370, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(128, 128, 128));
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
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnBack.setBackground(Color.YELLOW);
		btnBack.setBounds(795, 473, 112, 45);
		contentPane.add(btnBack);
	}

}
