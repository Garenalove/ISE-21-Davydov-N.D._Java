package labs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Labs {

	private JFrame frame;
	private final JButton btnNewButton = new JButton("\u0412\u0437\u044F\u0442\u044C \u043C\u044F\u0441\u043E");
	private JCheckBox craneOnOff;
	private JCheckBox plateOnOff;
	private JCheckBox grinderOnOff;
	private Crane crane;
	private Cutlet cutlet;
	private Egg egg;
	private ForceMeat forceMeat;
	private Knife knife;
	private Meat meat;
	private MeatGrinder meatGrinder;
	private Oil oil;
	private Pan pan;
	private Plate plate;
	private Spice spice;
	
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
		plate =  new Plate();
		knife = new Knife();
		crane = new Crane();
		meatGrinder = new MeatGrinder();
		oil =  new Oil();
		frame = new JFrame();
		frame.setBounds(100, 100, 860, 293);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u0418\u043D\u0433\u0440\u0435\u0434\u0438\u0435\u043D\u0442\u044B", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 128, 119);
		frame.getContentPane().add(panel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(meat == null) {
					meat = new Meat();
					JOptionPane.showMessageDialog(frame,
						    "Мясо взято",
						    "Сообщение",
						    JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы уже взяли мясо",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u0412\u0437\u044F\u0442\u044C \u044F\u0439\u0446\u0430");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(egg == null) {
					egg = new Egg();
					JOptionPane.showMessageDialog(frame,
						    "Яйца взяты",
						    "Сообщение",
						    JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы уже взяли яйца",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(button);
		
		JButton button_1 = new JButton("\u0412\u0437\u044F\u0442\u044C \u0441\u043F\u0435\u0446\u0438\u0438");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(spice == null) {
					spice = new Spice();
					JOptionPane.showMessageDialog(frame,
						    "Специи взяты",
						    "Сообщение",
						    JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы уже взяли специи",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u041A\u0440\u0430\u043D", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(148, 11, 159, 119);
		frame.getContentPane().add(panel_1);
		
		craneOnOff = new JCheckBox("\u0412\u043A\u043B\\\u0412\u044B\u043A\u043B");
		panel_1.add(craneOnOff);
		
		JButton button_2 = new JButton("\u041F\u043E\u043C\u044B\u0442\u044C \u043C\u044F\u0441\u043E");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(meat!=null) {
					if(craneOnOff.isSelected()) {
						crane.cleanMeat(meat);
						JOptionPane.showMessageDialog(frame,
							    "Мясо помыто",
							    "Сообщение",
							    JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame,
							    "Включите кран",
							    "Сообщение",
							    JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы не взяли мясо",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("\u041F\u043E\u043C\u044B\u0442\u044C \u044F\u0439\u0446\u0430");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(egg!=null) {
					if(craneOnOff.isSelected()) {
						crane.cleanEgg(egg);
						JOptionPane.showMessageDialog(frame,
							    "Яйца помыты",
							    "Сообщение",
							    JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame,
							    "Включите кран",
							    "Сообщение",
							    JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы не взяли яйца",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel_1.add(button_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u041D\u0430\u0440\u0435\u0437\u043A\u0430", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(322, 11, 159, 89);
		frame.getContentPane().add(panel_2);
		
		JButton button_4 = new JButton("\u041D\u0430\u0440\u0435\u0437\u0430\u0442\u044C \u043C\u044F\u0441\u043E");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(meat != null) {
					if(meat.isClean()) {
						knife.cutMeat(meat);
						JOptionPane.showMessageDialog(frame,
							    "Мясо нарезано",
							    "Сообщение",
							    JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame,
							    "Помойте мясо",
							    "Сообщение",
							    JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы не взяли мясо",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("\u0420\u0430\u0437\u0431\u044E\u0438\u0442\u044C \u044F\u0439\u0446\u0430");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(egg != null) {
					if(egg.isClean()) {
						knife.brokeEgg(egg);
						JOptionPane.showMessageDialog(frame,
							    "Яйца разбиты",
							    "Сообщение",
							    JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame,
							    "Помойте яйца",
							    "Сообщение",
							    JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы не взяли яйца",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel_2.add(button_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u041C\u044F\u0441\u043E\u0440\u0443\u0431\u043A\u0430", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(491, 11, 329, 119);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton button_6 = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043C\u044F\u0441\u043E");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(grinderOnOff.isSelected()) {
					if(meat != null) {
						if(meat.isCut()) {
							meatGrinder.setMeat(meat);
							JOptionPane.showMessageDialog(frame,
								    "Мясо добавленно",
								    "Сообщение",
								    JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(frame,
								    "Нарежте мясо",
								    "Сообщение",
								    JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(frame,
							    "Вы не взяли мясо",
							    "Сообщение",
							    JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы не включили мясорубку",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_6.setBounds(19, 21, 129, 23);
		panel_3.add(button_6);
		
		grinderOnOff = new JCheckBox("\u0412\u043A\u043B\\\u0412\u044B\u043A\u043B");
		grinderOnOff.setBounds(188, 21, 94, 23);
		panel_3.add(grinderOnOff);
		
		JButton button_8 = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u044F\u0439\u0446\u0430");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(grinderOnOff.isSelected()) {
					if(egg != null) {
						if(egg.isBroken()) {
							meatGrinder.setEgg(egg);
							JOptionPane.showMessageDialog(frame,
								    "Яйца добавленны",
								    "Сообщение",
								    JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(frame,
								    "Разбейте яйца",
								    "Сообщение",
								    JOptionPane.WARNING_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(frame,
							    "Вы не взяли яйца",
							    "Сообщение",
							    JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы не включили мясорубку",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_8.setBounds(19, 55, 129, 23);
		panel_3.add(button_8);
		
		JButton button_9 = new JButton("\u041F\u0440\u0438\u0433\u043E\u0442\u043E\u0432\u0438\u0442\u044C \u0444\u0430\u0440\u0448");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				meatGrinder.setState(grinderOnOff.isSelected());
				forceMeat = meatGrinder.getForceMeat();
				if(forceMeat != null) {
					JOptionPane.showMessageDialog(frame,
						    "Фарш получен",
						    "Сообщение",
						    JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Недостаточно ингредиентов или мясорубка выключена",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_9.setBounds(172, 51, 147, 57);
		panel_3.add(button_9);
		
		JButton button_7 = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0441\u043F\u0435\u0446\u0438\u0438");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(grinderOnOff.isSelected()) {
					if(spice != null) {
						meatGrinder.setSpice(spice);
						JOptionPane.showMessageDialog(frame,
							    "Специи добавленны",
							    "Сообщение",
							    JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame,
							    "Вы не взяли специи",
							    "Сообщение",
							    JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы не включили мясорубку",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_7.setBounds(19, 85, 129, 23);
		panel_3.add(button_7);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0421\u043A\u043E\u0432\u043E\u0440\u043E\u0434\u0430", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(10, 134, 345, 108);
		frame.getContentPane().add(panel_4);
		
		JButton button_10 = new JButton("\u0412\u0437\u044F\u0442\u044C \u0441\u043A\u043E\u0432\u043E\u0440\u043E\u0434\u0443");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pan == null) {
					pan =  new Pan();
					JOptionPane.showMessageDialog(frame,
						    "Сковорода взята",
						    "Сообщение",
						    JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы уже взяли сковороду",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_10.setBounds(19, 21, 137, 23);
		panel_4.add(button_10);
		
		JButton button_11 = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u043C\u0430\u0441\u043B\u043E");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pan!=null) {
					pan.setOil(oil);
					JOptionPane.showMessageDialog(frame,
						    "Масло добавлено",
						    "Сообщение",
						    JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы не взяли сковороду",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_11.setBounds(19, 75, 137, 23);
		panel_4.add(button_11);
		
		JButton button_12 = new JButton("\u041F\u0440\u0438\u0433\u043E\u0442\u043E\u0432\u0438\u0442\u044C \u043A\u043E\u0442\u043B\u0435\u0442\u044B");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pan!=null) {
					cutlet = pan.getCutlet();
					if(cutlet!=null) {
						JOptionPane.showMessageDialog(frame,
							    "Котлеты готовы",
							    "Сообщение",
							    JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame,
							    "Котлеты ещё не готовы",
							    "Сообщение",
							    JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы не взяли сковороду",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_12.setBounds(166, 22, 169, 76);
		panel_4.add(button_12);
		
		JButton button_14 = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0444\u0430\u0440\u0448");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pan!=null) {
					if(forceMeat != null) {
						pan.setForceMeat(forceMeat);
						JOptionPane.showMessageDialog(frame,
							    "Мясо добавлено",
							    "Сообщение",
							    JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame,
							    "У вас нет фарша",
							    "Сообщение",
							    JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы не взяли сковороду",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_14.setBounds(19, 49, 137, 23);
		panel_4.add(button_14);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u041F\u043B\u0438\u0442\u0430", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(379, 134, 345, 119);
		frame.getContentPane().add(panel_5);
		
		JButton button_13 = new JButton("\u041F\u043E\u0441\u0442\u0430\u0432\u0438\u0442\u044C \u0441\u043A\u043E\u0432\u043E\u0440\u043E\u0434\u0443");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pan!= null) {
					plate.setPan(pan);
					JOptionPane.showMessageDialog(frame,
						    "Сковорода на плите",
						    "Сообщение",
						    JOptionPane.INFORMATION_MESSAGE);
					
				} else {
					JOptionPane.showMessageDialog(frame,
						    "Вы не взяли сковороду",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_13.setBounds(10, 51, 143, 57);
		panel_5.add(button_13);
		
		plateOnOff = new JCheckBox("\u0412\u043A\u043B\\\u0412\u044B\u043A\u043B");
		plateOnOff.setBounds(130, 21, 104, 23);
		panel_5.add(plateOnOff);
		
		JButton button_15 = new JButton("\u041D\u0430\u0433\u0440\u0435\u0442\u044C \u0441\u043A\u043E\u0432\u043E\u0440\u043E\u0434\u0443");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(plate.getPan() != null) {
					if(plateOnOff.isSelected()) {
						for(int i =0;i<10;i++) {
							plate.cookIng();
						}
						JOptionPane.showMessageDialog(frame,
							    "Сковорода нагрета на 10 градусов",
							    "Сообщение",
							    JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(frame,
							    "Плита выключена",
							    "Сообщение",
							    JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(frame,
						    "На плите нет сковороды",
						    "Сообщение",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button_15.setBounds(172, 51, 163, 57);
		panel_5.add(button_15);
	}
}
