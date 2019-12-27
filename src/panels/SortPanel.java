package panels;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SortPanel extends JPanel{

	private JButton bSort;
	private GridBagConstraints gbc;
	
	public SortPanel() {
		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0,10,0,0);
		gbc.ipadx = 10;
		gbc.weightx = 0;
		gbc.weighty = 1;
		
		bSort = new JButton();
		bSort.setText("huhu");
		add(bSort, gbc);
		
	}
	
}
