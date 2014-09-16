package ch.fhnw.depa.u01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ColorPicker extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2156450603943081648L;
	private JPanel contentPane;
	private JTextField txtRed;
	private JTextField txtGreen;
	private JTextField txtBlue;
	private JPanel pnlColor;
	private JScrollBar scrRed;
	private JScrollBar scrGreen;
	private JScrollBar scrBlue;
	private JLabel lblRed;
	private JLabel lblGreen;
	private JLabel lblBlue;
	private JButton btnBrighter;
	private JButton btnDarker;

	@Override
	public void update(Observable o, Object x) {
		if(o instanceof ColorPickerData) {
			ColorPickerData data = (ColorPickerData)o;
			Color c = new Color(data.getRed(), data.getGreen(), data.getBlue());
			pnlColor.setBackground(c);
			scrRed.setValue(data.getRed());
			scrGreen.setValue(data.getGreen());
			scrBlue.setValue(data.getBlue());
			txtRed.setText(Short.toString(data.getRed()));
			txtGreen.setText(Short.toString(data.getGreen()));
			txtBlue.setText(Short.toString(data.getBlue()));
			lblRed.setText(Integer.toString((int)data.getRed(), 16).toUpperCase());
			lblGreen.setText(Integer.toString((int)data.getGreen(), 16).toUpperCase());
			lblBlue.setText(Integer.toString((int)data.getBlue(), 16).toUpperCase());
			btnDarker.setEnabled(data.getRed() + data.getGreen() + data.getBlue() > 0);
			btnBrighter.setEnabled(data.getRed() < 255 || data.getGreen() < 255 || data.getBlue() < 255);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColorPicker frame = new ColorPicker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ColorPicker() {
		ColorPickerData data = new ColorPickerData();
		data.addObserver(this);
		ColorPickerActionListener listener = new ColorPickerActionListener(data);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new GridLayout(0, 3, 5, 5));
		
		scrRed = new JScrollBar();
		scrRed.setBackground(Color.RED);
		scrRed.setMaximum(265);
		scrRed.setOrientation(JScrollBar.HORIZONTAL);
		scrRed.getModel().addChangeListener(listener.createScrollListener(ColorPickerActionListener.ScrollListener.RED));
		topPanel.add(scrRed);
		
		txtRed = new JTextField();
		txtRed.setEditable(false);
		topPanel.add(txtRed);
		txtRed.setColumns(10);
		
		lblRed = new JLabel("00");
		topPanel.add(lblRed);
		
		scrGreen = new JScrollBar();
		scrGreen.setBackground(Color.GREEN);
		scrGreen.setOrientation(JScrollBar.HORIZONTAL);
		scrGreen.setMaximum(265);
		scrGreen.getModel().addChangeListener(listener.createScrollListener(ColorPickerActionListener.ScrollListener.GREEN));
		topPanel.add(scrGreen);
		
		txtGreen = new JTextField();
		txtGreen.setEditable(false);
		txtGreen.setColumns(10);
		topPanel.add(txtGreen);
		
		lblGreen = new JLabel("00");
		topPanel.add(lblGreen);
		
		scrBlue = new JScrollBar();
		scrBlue.setBackground(Color.BLUE);
		scrBlue.setOrientation(JScrollBar.HORIZONTAL);
		scrBlue.setMaximum(265);
		scrBlue.getModel().addChangeListener(listener.createScrollListener(ColorPickerActionListener.ScrollListener.BLUE));
		topPanel.add(scrBlue);
		
		txtBlue = new JTextField();
		txtBlue.setEditable(false);
		txtBlue.setColumns(10);
		topPanel.add(txtBlue);
		
		lblBlue = new JLabel("00");
		topPanel.add(lblBlue);
		
		JPanel botPanel = new JPanel();
		contentPane.add(botPanel, BorderLayout.CENTER);
		botPanel.setLayout(new BorderLayout(5, 5));
		
		JPanel botRightPanel = new JPanel();
		botPanel.add(botRightPanel, BorderLayout.EAST);
		botRightPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnRed = new JButton("red");
		btnRed.setActionCommand("red");
		botRightPanel.add(btnRed);
		
		btnBrighter = new JButton("Brighter");
		btnBrighter.setActionCommand("brighter");
		botRightPanel.add(btnBrighter);
		
		JButton btnGreen = new JButton("green");
		btnGreen.setActionCommand("green");
		botRightPanel.add(btnGreen);
		
		btnDarker = new JButton("Darker");
		btnDarker.setEnabled(false);
		btnDarker.setActionCommand("darker");
		botRightPanel.add(btnDarker);
		
		JButton btnBlue = new JButton("blue");
		btnBlue.setActionCommand("blue");
		botRightPanel.add(btnBlue);
		
		JLabel label = new JLabel("");
		botRightPanel.add(label);
		
		JButton btnYellow = new JButton("Yellow");
		btnYellow.setActionCommand("yellow");
		botRightPanel.add(btnYellow);
		
		JLabel label_1 = new JLabel("");
		botRightPanel.add(label_1);
		
		JButton btnOrange = new JButton("Orange");
		btnOrange.setActionCommand("orange");
		botRightPanel.add(btnOrange);
		
		JLabel label_2 = new JLabel("");
		botRightPanel.add(label_2);
		
		JButton btnBlack = new JButton("Black");
		btnBlack.setActionCommand("black");
		botRightPanel.add(btnBlack);
		
		JLabel label_3 = new JLabel("");
		botRightPanel.add(label_3);
		
		JButton btnGrey = new JButton("Grey");
		btnGrey.setActionCommand("grey");
		botRightPanel.add(btnGrey);
		
		JLabel label_4 = new JLabel("");
		botRightPanel.add(label_4);

		for(Component c : botRightPanel.getComponents()){
			if(c instanceof JButton){ ((JButton)c).addActionListener(listener); }
		}
		
		pnlColor = new JPanel();
		pnlColor.setBackground(Color.BLACK);
		botPanel.add(pnlColor, BorderLayout.CENTER);
	}

}
