package test1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.awt.Choice;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class One {

	private JFrame frame;
	private JLayeredPane layeredPane;
	private JPanel search_panel;
	private JPanel lookup_panel;
	private JPanel result_panel;
	private JComboBox comboBoxFrom;
	private JComboBox comboBoxTo;
	private JLabel lblFlightData;
	private JPanel panel_1;
	private JDateChooser dateChooser;
	private JTable table;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					One window = new One();
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
	public One() {
		initialize();
	}
	
	
	public void switch_panel(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 6, 788, 41);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Search Bus");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch_panel(search_panel);
				dateChooser.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 6, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Booking");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch_panel(lookup_panel);
				textField.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(137, 6, 200, 29);
		panel.add(btnNewButton_1);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(6, 59, 788, 357);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel welcome_panel = new JPanel();
		welcome_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		welcome_panel.setBackground(Color.PINK);
		welcome_panel.setBounds(0, 0, 788, 357);
		layeredPane.add(welcome_panel);
		welcome_panel.setLayout(null);
		
		JLabel lblWelcomeScreen = new JLabel("Welcome to Bus Ticket Booking System");
		lblWelcomeScreen.setBackground(Color.green);
		lblWelcomeScreen.setFont(new Font("DialogInput", Font.BOLD, 28));
		lblWelcomeScreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeScreen.setBounds(0, 0, 788, 297);
		welcome_panel.add(lblWelcomeScreen);
		
		JLabel lblWelcomeScreenInstruction = new JLabel("Select any option from above to get started");
		lblWelcomeScreenInstruction.setFont(new Font("Lao MN", Font.ITALIC, 20));
		lblWelcomeScreenInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeScreenInstruction.setBounds(0, 66, 788, 291);
		welcome_panel.add(lblWelcomeScreenInstruction);
		
		lookup_panel = new JPanel();
		lookup_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lookup_panel.setBackground(Color.CYAN);
		lookup_panel.setBounds(0, 0, 788, 357);
		layeredPane.add(lookup_panel);
		lookup_panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(83, 58, 197, 27);
		lookup_panel.add(textField);
		textField.setVisible(false);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Booking ID");
		lblNewLabel_1.setBounds(83, 33, 93, 14);
		lookup_panel.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("Submit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(191, 133, 89, 23);
		lookup_panel.add(btnNewButton_3);
		
		panel_1 = new JPanel();
		panel_1.setBounds(401, 11, 365, 324);
		lookup_panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("From: Mumbai");
		lblNewLabel_2.setBounds(25, 37, 160, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("To: Rajasthan");
		lblNewLabel_2_1.setBounds(25, 62, 160, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Date: 25 May, 2022");
		lblNewLabel_2_1_1.setBounds(25, 87, 160, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Status: Your ticket is Booked");
		lblNewLabel_2_1_1_1.setBounds(25, 112, 160, 14);
		panel_1.add(lblNewLabel_2_1_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I am authorized to view the booking.");
		chckbxNewCheckBox.setBounds(83, 92, 264, 23);
		lookup_panel.add(chckbxNewCheckBox);
		
		search_panel = new JPanel();
		search_panel.setBounds(0, 0, 788, 357);
		layeredPane.add(search_panel);
		search_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		search_panel.setBackground(Color.YELLOW);
		search_panel.setLayout(null);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(31, 31, 61, 16);
		search_panel.add(lblFrom);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(31, 74, 61, 16);
		search_panel.add(lblTo);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String from = comboBoxFrom.getSelectedItem().toString();
				String to = comboBoxTo.getSelectedItem().toString();
				
				lblFlightData.setText(from + " to " + to);
				result_panel.setVisible(true);
			}
		});
		btnSearch.setBounds(119, 177, 117, 29);
		search_panel.add(btnSearch);
		
		comboBoxFrom = new JComboBox();
		comboBoxFrom.setBounds(90, 27, 193, 27);
		search_panel.add(comboBoxFrom);
		comboBoxFrom.setModel(new DefaultComboBoxModel(new String[] {"Rajkot", "Mumbai", "Delhi"}));
		
		comboBoxTo = new JComboBox();
		comboBoxTo.setModel(new DefaultComboBoxModel(new String[] {"Bhuj", "Rajasthan", "Bengaluru"}));
		comboBoxTo.setBounds(90, 70, 193, 27);
		search_panel.add(comboBoxTo);
		
		result_panel = new JPanel();
		result_panel.setBounds(404, 6, 378, 345);
		search_panel.add(result_panel);
		result_panel.setLayout(null);
		result_panel.setVisible(false);
		
		lblFlightData = new JLabel("Location");
		lblFlightData.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightData.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblFlightData.setBounds(6, 6, 366, 34);
		result_panel.add(lblFlightData);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"01", "Available"},
				{"02", "Available"},
				{"03", "Available"},
				{"04", "Available"},
				{"05", "Available"},
				{"06", "Available"},
				{"07", "Available"},
				{"08", "Available"},
				{"09", "Available"},
				{"10", "Available"},
			},
			new String[] {
				"Seat Number", "Availability"
			}
		));
		table.setBounds(6, 72, 362, 160);
		result_panel.add(table);
		
		JLabel lblNewLabel_5 = new JLabel("Availability");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(189, 51, 179, 14);
		result_panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Seat No");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(6, 51, 179, 14);
		result_panel.add(lblNewLabel_6);
		
		JButton btnNewButton_2 = new JButton("Book");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText("Booked!");
			}
		});
		btnNewButton_2.setBounds(279, 311, 89, 23);
		result_panel.add(btnNewButton_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(6, 287, 114, 42);
		result_panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Date:");
		lblNewLabel_3.setBounds(30, 117, 45, 16);
		search_panel.add(lblNewLabel_3);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(90, 117, 193, 26);
		search_panel.add(dateChooser);
		dateChooser.setVisible(false);
	}
	
}
