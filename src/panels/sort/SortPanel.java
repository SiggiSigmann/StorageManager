package panels.sort;

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
import javax.swing.SwingConstants;


public class SortPanel extends JPanel {

	private GridBagConstraints gbc;
	private JPanel pFpLeft, pFpRight;
	private JLabel lHead;
	private JTextField tfFilter;
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

		pFpLeft = new FilePanel();
		pFpRight = new FilePanel();

		
		spSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		spSplit.setLeftComponent(pFpLeft);
		spSplit.setRightComponent(pFpRight);
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
