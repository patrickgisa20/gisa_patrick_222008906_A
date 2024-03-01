package Ritco;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
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

public class BusForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField natxf;
	private JTextField pntxf;
	private JTextField textField_2;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusForm frame = new BusForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public BusForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 595);
		contentPane = new JPanel();
		setTitle("BUS FORM IN RITCO MANAGEMENT SYSTEM ");
		contentPane.setBackground(new Color(120, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUS FORM IN RITCO MANAGEMENT SYSTEM ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 37));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(27, 10, 851, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(27, 81, 516, 58);
		contentPane.add(lblNewLabel_1);
		
		natxf = new JTextField();
		natxf.setBounds(12, 139, 500, 48);
		contentPane.add(natxf);
		natxf.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PlateNumber");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(27, 194, 516, 58);
		contentPane.add(lblNewLabel_1_1);
		
		pntxf = new JTextField();
		pntxf.setColumns(10);
		pntxf.setBounds(12, 252, 500, 48);
		contentPane.add(pntxf);
		
		JLabel sntxf = new JLabel("SeatNumber");
		sntxf.setHorizontalAlignment(SwingConstants.LEFT);
		sntxf.setForeground(Color.WHITE);
		sntxf.setFont(new Font("Tahoma", Font.ITALIC, 20));
		sntxf.setBounds(27, 310, 516, 58);
		contentPane.add(sntxf);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 368, 500, 48);
		contentPane.add(textField_2);
		
		JButton addbtn = new JButton("ADD");
		
		addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Names= natxf.getText();
                String Platenumber = pntxf.getText();
                String Seatnumber = textField_2.getText();


                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");

					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m","222008906","222008906");
                    String sql = "INSERT INTO bus(Names,PlateNumber , Seatnumber) VALUES (?, ?, ?)";
                    PreparedStatement statement = con.prepareStatement(sql);
                    statement.setString(1, Names);
                    statement.setString(2, Platenumber);
                    statement.setString(3, Seatnumber);

                  
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                    	JOptionPane.showMessageDialog(addbtn, "A new bus was inserted successfully!");
                    }
                    
                 
                    statement.close();
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
		
		
		
		addbtn.setBackground(new Color(255, 255, 0));
		addbtn.setFont(new Font("Tahoma", Font.BOLD, 23));
		addbtn.setForeground(new Color(0, 0, 160));
		addbtn.setBounds(0, 420, 143, 48);
		contentPane.add(addbtn);
		
		JButton btnRead = new JButton("VIEW");
		btnRead.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "222008906", "222008906");
		            String sql = "SELECT * FROM bus";
		            PreparedStatement statement = con.prepareStatement(sql);
		            ResultSet resultSet = statement.executeQuery();

		            
		            DefaultTableModel model = new DefaultTableModel();
		            model.addColumn("Bus ID"); 
		            model.addColumn("Name");
		            model.addColumn("Plate Number");
		            model.addColumn("Seat Number");

		            while (resultSet.next()) {
		                int busId = resultSet.getInt("bus_id"); 
		                String name = resultSet.getString("Names");
		                String plateNumber = resultSet.getString("PlateNumber");
		                String seatNumber = resultSet.getString("Seatnumber");
		                model.addRow(new Object[]{busId, name, plateNumber, seatNumber});
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


		btnRead.setBackground(new Color(255, 255, 0));
		btnRead.setForeground(new Color(0, 0, 160));
		btnRead.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnRead.setBounds(120, 420, 143, 48);
		contentPane.add(btnRead);
		
        JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "root", "");

		            con.setAutoCommit(true); 

		            String sql = "UPDATE bus SET PlateNumber=?, SeatNumber=? WHERE Names=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setString(1, pntxf.getText());
		                stm.setString(2, textField_2.getText());
		                stm.setString(3, natxf.getText());

		                int rowsAffected = stm.executeUpdate(); 

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(btnUpdate, "Record updated successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(btnUpdate, "No record found with the given name.");
		                }
		            }
		        } catch (Exception e2) {
		            e2.printStackTrace();
		            JOptionPane.showMessageDialog(btnUpdate, "THERE IS SOME ERROR.");
		        }
		    }
		});

		btnUpdate.setBackground(new Color(255, 255, 0));
		btnUpdate.setForeground(new Color(0, 0, 160));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnUpdate.setBounds(240,420, 143, 48);
		contentPane.add(btnUpdate);
		
		JButton btndelete = new JButton("DELETE");
		btndelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisa_patrick_r_s_m", "root", "");

		            String sql = "DELETE FROM bus WHERE Names=?";
		            try (PreparedStatement stm = con.prepareStatement(sql)) {
		                stm.setString(1, natxf.getText());

		                int rowsAffected = stm.executeUpdate(); // Execute the delete

		                if (rowsAffected > 0) {
		                    JOptionPane.showMessageDialog(btndelete, "Record deleted successfully!");
		                } else {
		                    JOptionPane.showMessageDialog(btndelete, "No record found with the given name.");
		                }
		            }
		        } catch (Exception e2) {
		            e2.printStackTrace();
		            JOptionPane.showMessageDialog(btndelete, "An error IS FOUND CHECK YOUR CODES.");
		        }
		    }
		});
		btndelete.setBackground(Color.red);
		btndelete.setForeground(new Color(0, 0, 160));
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 23));
		btndelete.setBounds(380, 420, 143, 48);
		contentPane.add(btndelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(528, 62, 370, 402);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(0, 128, 255));
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage page=new HomePage();
				page.setVisible(true);
				dispose();
			}
		});
		btnBack.setBackground(new Color(255, 255, 0));
		btnBack.setForeground(new Color(0, 0, 160));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(830, 470, 70, 30);
		contentPane.add(btnBack);
	}

}
