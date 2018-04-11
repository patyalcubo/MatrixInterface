import java.awt.*;
import java.awt.event.*;
import javax.sql.rowset.CachedRowSet;
import javax.swing.*;

public class SelectOp {

	String[] items = {"Addition", "Subtraction", "Multiplication"}; //string array
	JComboBox c = new JComboBox(items);
	JButton b = new JButton("Generate");
	JLabel l = new JLabel("Display selection here");
	JTextField mi = new JTextField(5); // Matriz A i
	JTextField mj = new JTextField(5); // Matriz A j
	JTextField mk = new JTextField(5); // Matriz B k
	JTextField ml = new JTextField(5); // Matriz B l
	
	public SelectOp(){ // constructor
		frame(); // method frame to display combobox
	}
	
	public void frame() {
		JFrame f = new JFrame();
		f.setTitle("Matrix Operations");
		f.setVisible(true);
		f.setSize(400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mk.setEditable(false); // Disabled at the begginning
		ml.setEditable(false); // Disabled at the begginning
		
		JPanel p = new JPanel();
		p.add(c);
		p.add(b);
		p.add(mi);
		p.add(mj);
		p.add(l);
		p.add(mk);
		p.add(ml);
		f.add(p);
		
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s = c.getSelectedItem().toString();
				switch (s){
				case "Addition": 
					l.setText("+"); 
					mk.setText(mi.getText()); 
					ml.setText(mj.getText()); 
					break;
				case "Subtraction": 
					l.setText("-"); 
					mk.setText(mi.getText()); 
					ml.setText(mj.getText()); 					
					break;
				case "Multiplication": 
					l.setText("x"); 
					mk.setText(mj.getText()); 
					ml.setEditable(true); // Make enable again this JTextField
					break;
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
		new SelectOp();
	}

}
