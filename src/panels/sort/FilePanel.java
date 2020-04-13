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
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.tree.TreePath;
import javax.swing.tree.ExpandVetoException;
import javax.swing.JScrollPane;


public class FilePanel extends JPanel {

    private GridBagConstraints gbc;
	private JButton bGetPath;
	private JTree tFiles;
	private JTextField tfSource;

	public FilePanel() {

		setLayout(new GridBagLayout());

		gbc = new GridBagConstraints();

		//textfield to enter link
		tfSource = new JTextField();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		add(tfSource, gbc);

		//button to display a filechooser
        bGetPath = new JButton();
		bGetPath.setText("...");
		bGetPath.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("choos Directory");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int destUrl = chooser.showOpenDialog(null);
		
				if(destUrl == JFileChooser.APPROVE_OPTION){

					tfSource.setText(chooser.getSelectedFile().getPath());

					createTree(chooser.getSelectedFile().getPath());
				}
			}
		});
		gbc.weightx = 0;
		add(bGetPath, gbc);
		
		tFiles = new JTree();
		tFiles.addTreeWillExpandListener(new TreeWillExpandListener() {

			//collaps node
			public void treeWillCollapse(TreeExpansionEvent treeExpansionEvent) throws ExpandVetoException {
				
				//get node
				TreePath path = treeExpansionEvent.getPath();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
				String name = node.getUserObject().toString();
				node.removeAllChildren();
				node.add( new DefaultMutableTreeNode(name));

				System.out.println("collaps: " + name);
				DefaultTreeModel model = (DefaultTreeModel) tFiles.getModel();
				DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
				model.reload();
				tFiles.repaint();
			}
	  
			public void treeWillExpand(TreeExpansionEvent treeExpansionEvent) throws ExpandVetoException {
	  
				//get node
				TreePath path = treeExpansionEvent.getPath();
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
				
				//create filepath
				String s="";
				for(Object t: path.getPath()){
					DefaultMutableTreeNode ob = (DefaultMutableTreeNode)t;
					s = s.concat(ob.getUserObject()+"\\");
				}

				addContentToTree(node,s);

				String name = node.getUserObject().toString();
				System.out.println("expand: " + name);

				DefaultTreeModel model = (DefaultTreeModel) tFiles.getModel();
				DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
				model.reload();
				tFiles.repaint();
			}
		});
		createTree(System.getProperty("user.dir"));

		JScrollPane scrollPane = new JScrollPane(tFiles);
		scrollPane.setViewportView(tFiles);
		gbc.gridy = 1;
		gbc.weightx = 1;
        gbc.weighty = 1;
		gbc.gridwidth=2;
		add(scrollPane, gbc);


		validate();
		repaint();
	}

	private void createTree(String url){
		DefaultTreeModel model = (DefaultTreeModel) tFiles.getModel();
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
		root.removeAllChildren();
		root.setUserObject(url);

		if(url.isBlank()){
			root.setUserObject("error");
			model.reload(root);
			return;
		}

		addContentToTree(root, url);
		
		model.reload(root);
		
		validate();
		repaint();
	}

	private void addContentToTree(DefaultMutableTreeNode root, String url){
		File rootpath = new File(url);
		for(File f: rootpath.listFiles()){
			if(f.isFile()){
				root.add( new DefaultMutableTreeNode( f.getName()));
				
			}else{
				DefaultMutableTreeNode folder = new DefaultMutableTreeNode(f.getName());
				folder.add( new DefaultMutableTreeNode( f.getName()));
				root.add(folder);
			}
		}
	}

}