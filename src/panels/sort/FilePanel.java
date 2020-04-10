package panels.sort;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JFileChooser;


public class FilePanel extends JPanel {

    private GridBagConstraints gbc;
	private JButton bGetPath;
	private JTree tFiles;
	private JTextField tfSource;

	public FilePanel() {

		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;

        tfSource = new JTextField();
		add(tfSource, gbc);

        bGetPath = new JButton();
		bGetPath.setText("...");
		bGetPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				
				int destUrl = chooser.showOpenDialog(null);
		
				if(destUrl == JFileChooser.APPROVE_OPTION){

					tfSource.setText(chooser.getSelectedFile().getPath());
				}
			}
		});
		gbc.weightx = 0;
		add(bGetPath, gbc);

		gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.gridwidth=2;
		
		DefaultMutableTreeNode style=new DefaultMutableTreeNode("...");  
		
		tFiles = new JTree(style);
		add(tFiles, gbc);

		
		
		validate();
		repaint();
	}

}