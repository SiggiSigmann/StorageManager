package panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class SortPanel extends JPanel {

	private GridBagConstraints gbc, gbcRight, gbcLeft;
	private JPanel pLeft, pRight;
	private JLabel lHead;
	private JTree tSource, tDest;
	private JTextField tfSource, tfDest, tfFilter;
	private JSplitPane spSplit;
	private JButton bSort;

	public SortPanel() {
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 0;
		gbc.weightx = 1;
		gbc.gridwidth=2;

		lHead = new JLabel();
		lHead.setText("----- Sort -----");
		lHead.setHorizontalAlignment(SwingConstants.CENTER);
		add(lHead, gbc);

		pLeft = new JPanel();
		pLeft.setLayout(new GridBagLayout());
		gbcLeft = new GridBagConstraints();
		gbcLeft.fill = GridBagConstraints.BOTH;
		gbcLeft.weightx = 1;

		tfSource = new JTextField();
		pLeft.add(tfSource, gbcLeft);

		gbcLeft.gridy = 1;
		gbcLeft.weighty = 1;
		
		DefaultMutableTreeNode style=new DefaultMutableTreeNode("...");  
		
		tSource = new JTree(style);
		pLeft.add(tSource, gbcLeft);

		pRight = new JPanel();
		pRight.setLayout(new GridBagLayout());
		gbcRight = new GridBagConstraints();
		gbcRight.fill = GridBagConstraints.BOTH;
		gbcRight.weightx = 1;
		
		tfDest = new JTextField();
		pRight.add(tfDest, gbcRight);

		gbcRight.gridy = 1;
		gbcRight.weighty = 1;

		tDest = new JTree(style);
		pRight.add(tDest, gbcRight);
		
		spSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		spSplit.setLeftComponent(pLeft);
		spSplit.setRightComponent(pRight);
		spSplit.setDividerLocation(0.5); //no effect Todo: fix
		spSplit.setOneTouchExpandable(true);
		
		gbc.weighty = 1;
		gbc.gridy=1;
		
		add(spSplit, gbc);
		
		gbc.gridwidth=1;
		
		bSort = new JButton();
		bSort.setText("start Sorting");
		gbc.weighty=0;
		gbc.weightx=0;
		gbc.insets= new Insets(5, 0, 5, 0);
		gbc.gridy=2;
		add(bSort,gbc);
		
		tfFilter = new JTextField();
		tfFilter.setText("only use file with ending ...");   
		tfFilter.setForeground(Color.GRAY);
		tfFilter.addFocusListener(new FocusAdapter() {  
			   
		       @Override  
		       public void focusGained(FocusEvent e) {  
		    	   tfFilter.setText("");  
		    	   tfFilter.setForeground(Color.black);  
		       }  
		   
		       @Override  
		       public void focusLost(FocusEvent e) {  
		         if (tfFilter.getText().length()==0) {  
		     		tfFilter.setText("only use file with ending ...");   
		    		tfFilter.setForeground(Color.GRAY);
		         }  
		       }  
		     });  
		   
		gbc.weightx=1;
		gbc.insets= new Insets(5, 5, 5, 0);
		add(tfFilter, gbc);
		
		validate();
		repaint();
	}

}
