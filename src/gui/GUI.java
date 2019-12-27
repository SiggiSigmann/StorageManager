package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame{
	
	private JButton bBackup, bSort, bCheck;
	private JPanel pBackup, pSort, pCheck;
	private GridBagConstraints gbc;
	
	public GUI(){
		setTitle("StorageManager");
		setLayout(new GridBagLayout());
		setSize(500, 500);
		setLocationRelativeTo(null);
		setTitle("SchereSteinPapier");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0,10,0,0);
		gbc.ipadx = 10;
		gbc.weightx = 0;
		gbc.weighty = 1;
		
		bBackup = new JButton();
		bBackup.setText("Sync");
		bBackup.setMaximumSize(new Dimension(50,100));
		gbc.gridy = 0;
		add(bBackup,gbc);
		
		bSort = new JButton();
		bSort.setText("Sort");
		gbc.gridy = 1;
		add(bSort,gbc);
		
		bCheck = new JButton();
		bCheck.setText("Check");
		gbc.gridy = 2;
		add(bCheck,gbc);
		
		
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 2;
		gbc.weightx = 1;
		gbc.gridheight = 3;
		gbc.gridy = 0;
		
		pBackup = new panels.BackupPanel();
		pBackup.setVisible(false);
		add(pBackup, gbc);
		
		pSort = new panels.SortPanel();
		add(pSort, gbc);
		
		pCheck = new panels.CeckPanel();
		pCheck.setVisible(false);
		add(pCheck, gbc);
		
		validate();
		repaint();
	}
}
