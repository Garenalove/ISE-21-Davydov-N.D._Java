package labs;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;

public class Labs {

	private JFrame frame;
	private ShipPanel panel;
	private JFormattedTextField formattedTextField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Labs window = new Labs();
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
	public Labs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1081, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new ShipPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(21, 24, 845, 402);
		frame.getContentPane().add(panel);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(479, 441, 46, 14);
		frame.getContentPane().add(lblColor);
		
		JLabel lblColor_1 = new JLabel("Color:");
		lblColor_1.setBounds(572, 441, 46, 14);
		frame.getContentPane().add(lblColor_1);
		
		JButton bodyColorSwitcher = new JButton("");
		bodyColorSwitcher.setBackground(Color.BLUE);
		bodyColorSwitcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color tmp = JColorChooser.showDialog(frame, "Выберите цвет", null);
				bodyColorSwitcher.setBackground(tmp);
			}
		});
		bodyColorSwitcher.setBounds(516, 437, 46, 23);
		frame.getContentPane().add(bodyColorSwitcher);
		
		JButton dopColorSwitcher = new JButton("");
		dopColorSwitcher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color tmp = JColorChooser.showDialog(frame, "Выберите цвет", null);
				dopColorSwitcher.setBackground(tmp);
			}
		});
		dopColorSwitcher.setBackground(Color.BLUE);
		dopColorSwitcher.setBounds(608, 437, 46, 23);
		frame.getContentPane().add(dopColorSwitcher);
		
		JButton btnNewButton = new JButton("MotorShip");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ITransport s = new MotorShip(50,5,100,bodyColorSwitcher.getBackground());
				panel.setShip(s);
				panel.repaint();
			}
		});
		btnNewButton.setBounds(21, 437, 214, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UltaMegaBuffSuperMotorShip");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setShip(new UltaMegaBuffSuperMotorShip(50,5,100,bodyColorSwitcher.getBackground(),
						true,true,dopColorSwitcher.getBackground()));
				panel.repaint();
			}
		});
		btnNewButton_1.setBounds(245, 437, 214, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		SmallShipPanel panel_1 = new SmallShipPanel();
		panel_1.setBorder(new TitledBorder(null, "\u041A\u043E\u0440\u0430\u0431\u043B\u044C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(902, 190, 140, 221);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 93, 120, 117);
		panel_1.add(panel_2);
		
		JButton btnNewButton_2 = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setShip(panel.getShip(Integer.parseInt(formattedTextField.getText())-1));
				panel_1.repaint();
				panel.repaint();
			}
		});
		btnNewButton_2.setBounds(10, 60, 120, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel label = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		label.setBounds(10, 35, 46, 14);
		panel_1.add(label);
		
		formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(84, 29, 46, 20);
		panel_1.add(formattedTextField);
	}
}
