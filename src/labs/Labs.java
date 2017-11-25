package labs;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Labs {

	private JFrame frame;
	private ShipPanel panel;
	private JFormattedTextField formattedTextField;
	private JList list;
	
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
		frame.setBounds(100, 100, 1069, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new ShipPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(21, 24, 845, 447);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("\u0417\u0430\u043A\u0430\u0437\u0430\u0442\u044C \u043A\u043E\u0440\u0430\u0431\u043B\u044C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdditionalForm additionalForm = new AdditionalForm(new ShipCallBack() {
					@Override
					public void takeShip(ITransport ship) {
						panel.setShip(ship);
						panel.repaint();
					}
				});
				
			}
		});
		btnNewButton_1.setBounds(895, 203, 140, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		SmallShipPanel panel_1 = new SmallShipPanel();
		panel_1.setBorder(new TitledBorder(null, "\u041A\u043E\u0440\u0430\u0431\u043B\u044C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(895, 251, 140, 221);
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
		String[] str = new String[5];
		for(int i = 1;i<6;i++) {
			str[i-1] = "������� " + i;
		}
		list = new JList(str);
		list.enable(false);
		list.setSelectedIndex(0);
		list.setBounds(895, 24, 140, 115);
		frame.getContentPane().add(list);
		
		JButton btnNewButton_3 = new JButton("<<");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = list.getSelectedIndex();
				if(select>0) {
					list.setSelectedIndex(select - 1);
					panel.lvlDown();
					panel.repaint();
				}
			}
		});
		btnNewButton_3.setBounds(895, 155, 49, 37);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton button = new JButton(">>");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = list.getSelectedIndex();
				if(select<5) {
					list.setSelectedIndex(select + 1);
					panel.lvlUp();
					panel.repaint();
				}
				
			}
		});
		button.setBounds(985, 155, 49, 37);
		frame.getContentPane().add(button);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("����");
		JMenuItem save = new JMenuItem("���������");
		JMenuItem load = new JMenuItem("���������");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();  
				if (fc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {  
				    try {  
				        panel.saveParking(fc.getSelectedFile().getPath()); 
				    }  
				    catch (Exception e) {
				    	System.out.println("��� ������� � �����");
				    }  
				} 
			}
		});
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();  
				if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {  
					panel.loadParking(fc.getSelectedFile().getPath());
				}
			}
		});
		file.add(save);
		file.add(load);
		menuBar.add(file);
		frame.setJMenuBar(menuBar);
	}
}
