package ch.fhnw.depa.u01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class ColorPicker extends JFrame {

	private JPanel contentPane;
	private JTextField txtRed;
	private JTextField txtGreen;
	private JTextField txtBlue;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new GridLayout(0, 3, 5, 5));
		
		JScrollBar scrRed = new JScrollBar();
		scrRed.setBackground(Color.RED);
		scrRed.setMaximum(255);
		scrRed.setOrientation(JScrollBar.HORIZONTAL);
		topPanel.add(scrRed);
		
		txtRed = new JTextField();
		topPanel.add(txtRed);
		txtRed.setColumns(10);
		
		JLabel lblRed = new JLabel("00");
		topPanel.add(lblRed);
		
		JScrollBar scrGreen = new JScrollBar();
		scrGreen.setBackground(Color.GREEN);
		scrGreen.setOrientation(JScrollBar.HORIZONTAL);
		scrGreen.setMaximum(255);
		topPanel.add(scrGreen);
		
		txtGreen = new JTextField();
		txtGreen.setColumns(10);
		topPanel.add(txtGreen);
		
		JLabel lblGreen = new JLabel("00");
		topPanel.add(lblGreen);
		
		JScrollBar scrBlue = new JScrollBar();
		scrBlue.setBackground(Color.BLUE);
		scrBlue.setOrientation(JScrollBar.HORIZONTAL);
		scrBlue.setMaximum(255);
		topPanel.add(scrBlue);
		
		txtBlue = new JTextField();
		txtBlue.setColumns(10);
		topPanel.add(txtBlue);
		
		JLabel lblBlue = new JLabel("00");
		topPanel.add(lblBlue);
		
		JPanel botPanel = new JPanel();
		contentPane.add(botPanel, BorderLayout.CENTER);
		botPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel botRightPanel = new JPanel();
		botPanel.add(botRightPanel, BorderLayout.EAST);
		botRightPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnRed = new JButton("red");
		btnRed.setActionCommand("red");
		botRightPanel.add(btnRed);
		
		JButton btnBrighter = new JButton("Brighter");
		btnBrighter.setActionCommand("brighter");
		botRightPanel.add(btnBrighter);
		
		JButton btnGreen = new JButton("green");
		btnGreen.setActionCommand("green");
		botRightPanel.add(btnGreen);
		
		JButton btnDarker = new JButton("Darker");
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
		
		JPanel pnlColor = new JPanel();
		botPanel.add(pnlColor, BorderLayout.CENTER);
	}

}
