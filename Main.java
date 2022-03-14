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

public class Test2 {

	private JFrame frame;
	private JLayeredPane layeredPane;
	private JPanel search_panel;
	private JPanel lookup_panel;
	private JPanel result_panel;
	private JComboBox comboBoxFrom;
	private JComboBox comboBoxTo;
	private JLabel lblFlightData;
	private JPanel add_flight_panel;
	private JPanel add_flight_panel_result;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JDateChooser dateChooser_1;
	private JComboBox comboBoxFrom_1;
	private JComboBox comboBoxTo_1;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_2_1_1_1;
	private JLabel lblNewLabel_2_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test2 window = new Test2();
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
	public Test2() {
		initialize();
		Connect();
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
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch_panel(search_panel);
			}
		});
		btnNewButton.setBounds(135, 6, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lookup Booking");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch_panel(lookup_panel);
			}
		});
		btnNewButton_1.setBounds(264, 6, 146, 29);
		panel.add(btnNewButton_1);
		
		JButton btnAddFlight = new JButton("Add Flight");
		btnAddFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch_panel(add_flight_panel);
			}
		});
		btnAddFlight.setBounds(6, 6, 117, 29);
		panel.add(btnAddFlight);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(6, 59, 788, 357);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		search_panel = new JPanel();
		search_panel.setBounds(0, 0, 788, 357);
		layeredPane.add(search_panel);
		search_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		search_panel.setBackground(Color.WHITE);
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
				lblNewLabel_4.setText("Date: 12 March, 2022");
				result_panel.setVisible(true);
			}
		});
		btnSearch.setBounds(119, 177, 117, 29);
		search_panel.add(btnSearch);
		
		comboBoxFrom = new JComboBox();
		comboBoxFrom.setBounds(90, 27, 193, 27);
		search_panel.add(comboBoxFrom);
		comboBoxFrom.setModel(new DefaultComboBoxModel(new String[] {"Mumbai", "Delhi", "Kolkata"}));
		
		comboBoxTo = new JComboBox();
		comboBoxTo.setModel(new DefaultComboBoxModel(new String[] {"Ahmedabad", "Rajkot", "Hydrabad"}));
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
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(9, 48, 363, 16);
		result_panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Date:");
		lblNewLabel_3.setBounds(30, 117, 45, 16);
		search_panel.add(lblNewLabel_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(90, 117, 193, 26);
		search_panel.add(dateChooser);
		
		add_flight_panel = new JPanel();
		add_flight_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add_flight_panel.setBackground(Color.WHITE);
		add_flight_panel.setBounds(0, 0, 788, 357);
		layeredPane.add(add_flight_panel);
		add_flight_panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Flight");
		lblNewLabel.setBounds(6, 16, 399, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add_flight_panel.add(lblNewLabel);
		
		JLabel lblFrom_1 = new JLabel("From:");
		lblFrom_1.setBounds(36, 86, 61, 16);
		add_flight_panel.add(lblFrom_1);
		
		JLabel lblTo_1 = new JLabel("To:");
		lblTo_1.setBounds(36, 129, 61, 16);
		add_flight_panel.add(lblTo_1);
		
		JButton btnSearch_1 = new JButton("Add");
		btnSearch_1.setBounds(124, 227, 117, 29);
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				Add to DB
				String from = comboBoxFrom_1.getSelectedItem().toString();
				String to = comboBoxTo_1.getSelectedItem().toString();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(dateChooser_1.getDate());
				
				for(int i=0; i<10; i++) {
					int seat = i+1;
					String status = "available";
					
					try {
						pst = conn.prepareStatement("INSERT INTO flights (flight_from, flight_to, date, seat_no, status) VALUES (?, ?, ?, ?, ?)");
						pst.setString(1, from);
						pst.setString(2, to);
						pst.setString(3, date);
						pst.setInt(4, seat);
						pst.setString(5, status);
						pst.executeUpdate();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				add_flight_panel_result.setVisible(true);
//				lblNewLabel_2
				lblNewLabel_2_1.setText("From: " + from);
				lblNewLabel_2_1_1.setText("To: " + to );
				lblNewLabel_2_1_1_1.setText("Date: " + date);
				lblNewLabel_2_2.setText("Seats: 50");
			}
		});
		add_flight_panel.add(btnSearch_1);
		
		comboBoxFrom_1 = new JComboBox();
		comboBoxFrom_1.setBounds(95, 82, 193, 27);
		comboBoxFrom_1.setModel(new DefaultComboBoxModel(new String[] {"Mumbai", "Delhi", "Kolkata"}));
		add_flight_panel.add(comboBoxFrom_1);
		
		comboBoxTo_1 = new JComboBox();
		comboBoxTo_1.setBounds(95, 125, 193, 27);
		comboBoxTo_1.setModel(new DefaultComboBoxModel(new String[] {"Ahmedabad", "Rajkot", "Hydrabad"}));
		add_flight_panel.add(comboBoxTo_1);
		
		JLabel lblNewLabel_1 = new JLabel("Date:");
		lblNewLabel_1.setBounds(36, 173, 44, 16);
		add_flight_panel.add(lblNewLabel_1);
		
		add_flight_panel_result = new JPanel();
		add_flight_panel_result.setBounds(405, 6, 377, 345);
		add_flight_panel_result.setBackground(Color.LIGHT_GRAY);
		add_flight_panel.add(add_flight_panel_result);
		add_flight_panel_result.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Successfully Added!");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel_2.setBackground(Color.GREEN);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(6, 6, 365, 31);
		add_flight_panel_result.add(lblNewLabel_2);
		
		lblNewLabel_2_1 = new JLabel("From");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setBounds(6, 49, 365, 31);
		add_flight_panel_result.add(lblNewLabel_2_1);
		
		lblNewLabel_2_1_1 = new JLabel("From");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setBounds(6, 92, 365, 31);
		add_flight_panel_result.add(lblNewLabel_2_1_1);
		
		lblNewLabel_2_1_1_1 = new JLabel("From");
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_1.setBounds(6, 135, 365, 31);
		add_flight_panel_result.add(lblNewLabel_2_1_1_1);
		
		lblNewLabel_2_2 = new JLabel("From");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setBounds(6, 178, 365, 31);
		add_flight_panel_result.add(lblNewLabel_2_2);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(95, 164, 193, 26);
		add_flight_panel.add(dateChooser_1);
		add_flight_panel_result.setVisible(false);
		
		JPanel welcome_panel = new JPanel();
		welcome_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		welcome_panel.setBackground(Color.WHITE);
		welcome_panel.setBounds(0, 0, 788, 357);
		layeredPane.add(welcome_panel);
		welcome_panel.setLayout(null);
		
		JLabel lblWelcomeScreen = new JLabel("Welcome to Air Ticket Managemy System");
		lblWelcomeScreen.setFont(new Font("Kokonor", Font.BOLD | Font.ITALIC, 28));
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
		lookup_panel.setBackground(Color.WHITE);
		lookup_panel.setBounds(0, 0, 788, 357);
		layeredPane.add(lookup_panel);
		lookup_panel.setLayout(null);
	}
	
	public void switch_panel(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	Connection conn;
	PreparedStatement pst;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/air_ticket", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
