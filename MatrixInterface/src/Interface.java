import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

import javax.swing.*;

import operations.Addition;
import operations.Multiplication;



public class Interface extends JFrame {
	int blockX = 50;
	int blockY = 50;
	
	private JTextField[][] textMatrix  = new JTextField[1][1];
	private JButton btnClear;
	private JButton btnGenerate;
	private JButton btnCalculate;
	private JLabel lblSigno;
	private JLabel lblIgual;
	
	static Random random = new Random();
	
	public int m1Row;
	public int m1Col;
	public int m2Row;
	public int m2Col;
	public int resRow;
	public int resCol;
	
	
	public long[][] m1;
	public long[][] m2;
	public long[][] res;
	String sign;
	
	public JTextField[][] jTextM1;
	public JTextField[][] jTextM2;
	public JTextField[][] jTextRes;
	
	int offX = 50;
	int offY = 200;
	private JTextField Acol;
	private JTextField Arow;
	private JLabel lblMatrixB;
	private JTextField Bcol;
	private JTextField Brow;
	private JLabel lblRes;
	private JTextField Rcol;
	private JTextField Rrow;
	private JComboBox<String> Operation;
	
	public Interface() {
		
		Container c = getContentPane();
		getContentPane().setLayout(null);

		
		btnClear = new JButton("Clear");
		btnClear.setBounds(10, 10, 100, 40);
		c.add(btnClear);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeMatrix(false);
				btnCalculate.setEnabled(false);
			}
		});
		
		btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(110, 10, 100, 40);
		c.add(btnGenerate);
		
		
		lblSigno = new JLabel("Signo");
		lblIgual = new JLabel("=");
		getContentPane().add(lblSigno);
		getContentPane().add(lblIgual);
		lblSigno.setVisible(false);
		lblIgual.setVisible(false);
		
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkMatrix();
				removeMatrix(false);
				
				offX = 100;
				offY = 150;
				
				
				//Set Matrix values
				m1 = new long[m1Row][m1Col];
				m2 = new long[m2Row][m2Col];
				
				jTextM1 = new JTextField[m1Row][m1Col];
				jTextM2 = new JTextField[m2Row][m2Col];
				
				//Initialization to random values
				
				if (sign == "*"){
					for (int ii = 0; ii < m1.length; ii++) {
				        for (int jj = 0; jj < m1[0].length; jj++) {
				        	Random random = new Random();
				        	m1[ii][jj] = random.nextInt(100);
				        	}
				        }
					
					for (int ii = 0; ii < m2.length; ii++) {
				        for (int jj = 0; jj < m2[0].length; jj++) {
				        	Random random = new Random();
				        	m2[ii][jj] = random.nextInt(100);
				        }
				    }
					
				}
				else{
					for (int ii = 0; ii < m1.length; ii++) {
				        for (int jj = 0; jj < m1[0].length; jj++) {
				        	Random random = new Random();
				        	m1[ii][jj] = random.nextInt(100);
				        	m2[ii][jj] = random.nextInt(100);
				            //System.out.println(ii + " " + jj);
				        }
				    }
				}
				
				//END of Initialization to random values 
				
				generateMatrix(jTextM1, offX, offY, m1);
				
				offX = (m1[0].length+2)*blockX + offX;
				
				generateMatrix(jTextM2, offX, offY, m2);
				
				lblSigno.setBounds(offX - blockX, offY, 46, 14);
				
				offX = offX + ((m2[0].length+2)*blockX);
				
				lblSigno.setText(sign);
				lblSigno.setVisible(true);
				
				
				if (m1.length > m2.length){
					setSize(offX,offY + ((m1.length+2)*blockY));
				} else {
					setSize(offX,offY + ((m2.length+2)*blockY));
				}
				
				btnCalculate.setEnabled(true);
				
				c.repaint();
			}
		});
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(210, 10, 100, 40);
		c.add(btnCalculate);
		btnCalculate.setEnabled(false);
		
		Acol = new JTextField();
		Acol.setText("1");
		Acol.setBounds(70, 75, 50, 20);
		getContentPane().add(Acol);
		Acol.setColumns(10);
		
		Arow = new JTextField();
		Arow.setText("1");
		Arow.setBounds(10, 75, 50, 20);
		getContentPane().add(Arow);
		Arow.setColumns(10);
		
		JLabel lblMatrixA = new JLabel("Matrix A");
		lblMatrixA.setBounds(14, 50, 46, 14);
		getContentPane().add(lblMatrixA);
		
		lblMatrixB = new JLabel("Matrix B");
		lblMatrixB.setBounds(143, 50, 46, 14);
		getContentPane().add(lblMatrixB);
		
		Bcol = new JTextField();
		Bcol.setText("1");
		Bcol.setColumns(10);
		Bcol.setBounds(203, 75, 50, 20);
		getContentPane().add(Bcol);
		
		Brow = new JTextField();
		Brow.setText("1");
		Brow.setColumns(10);
		Brow.setBounds(143, 75, 50, 20);
		getContentPane().add(Brow);
		
		lblRes = new JLabel("Resultado");
		lblRes.setBounds(313, 50, 46, 14);
		getContentPane().add(lblRes);
		
		Rcol = new JTextField();
		Rcol.setText("1");
		Rcol.setEditable(false);
		Rcol.setColumns(10);
		Rcol.setBounds(372, 75, 50, 20);
		getContentPane().add(Rcol);
		
		Rrow = new JTextField();
		Rrow.setText("1");
		Rrow.setEditable(false);
		Rrow.setColumns(10);
		Rrow.setBounds(313, 75, 50, 20);
		getContentPane().add(Rrow);
		
		
		Arow.setEditable(false);
		Acol.setEditable(false);
		Brow.setEditable(false);
		Bcol.setEditable(false);
		
		Operation = new JComboBox<String>();
		Operation.setEditable(true);
		Operation.setBounds(320, 20, 52, 20);
		getContentPane().add(Operation);
		Operation.addItem("+");
		Operation.addItem("-");
		Operation.addItem("*");
		Operation.setSelectedItem("+");
		
		actionListener actChecker = new actionListener();
		focusListener focChecker = new focusListener();
		
		Operation.addActionListener(actChecker);
		Arow.addActionListener(actChecker);
		Acol.addActionListener(actChecker);
		Brow.addActionListener(actChecker);
		Bcol.addActionListener(actChecker);
		Rrow.addActionListener(actChecker);
		Rcol.addActionListener(actChecker);
		
		Arow.addFocusListener(focChecker);
		Acol.addFocusListener(focChecker);
		Brow.addFocusListener(focChecker);
		Bcol.addFocusListener(focChecker);
		Rrow.addFocusListener(focChecker);
		Rcol.addFocusListener(focChecker);
		
		
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("PAAAAAAAAAAAATY");
				System.out.println(jTextM1);
				if(jTextM1 != null){
					removeMatrix(true);
					
					//Updates m1 and m2 values 
					updateMatrix(jTextM1, m1);
					updateMatrix(jTextM2, m2);
					
					//Calculates res matrix
					
					res = new long[resRow][resCol];
					jTextRes = new JTextField[resRow][resCol];
					
					if (sign == "*"){
						res = Multiplication.Multiplicate(m1, m2);
					} else if (sign == "+"){
						res = Addition.Add(m1, m2, false);
					} else{
						res = Addition.Add(m1, m2, true);
					}
					
					//Draws res matrix
					
					
					generateMatrix(jTextRes, offX, offY, res);
					
					updateMatrix(jTextRes, res);
					
					lblIgual.setBounds(offX - blockX, offY, 46, 14);
					lblIgual.setVisible(true);
					
					//offX = offX + ((m2[0].length+2)*blockX);
					
					setSize(offX + ((m2[0].length+2)*blockX), getHeight());
					
					c.repaint();
					
					
					}
			}
		});
		
		
		setSize(700,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
	class focusListener implements FocusListener{
		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			checkMatrix();
		}
	   }
	
	private class actionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			checkMatrix();
		}
	}
	
	public void removeMatrix(boolean onlyRes){
		if (jTextM1 != null & !onlyRes){
			if (jTextM1[0][0] != null){
				deleteMatrix(jTextM1);
				deleteMatrix(jTextM2);
				jTextM1 = null;
				jTextM2 = null;
				lblSigno.setVisible(false);
			}
		}
		if (jTextRes != null){
			if (jTextRes[0][0] != null){
				//System.out.println(jTextRes[0][0]);
				deleteMatrix(jTextRes);
				jTextRes = null;
				lblIgual.setVisible(false);				
			}
		}
		
		
		repaint();
	}
	
	public void checkMatrix(){
		sign = (String) Operation.getSelectedItem();
		if (sign == "*"){
			Brow.setText(Acol.getText()); 
			Rrow.setText(Arow.getText()); 
			Rcol.setText(Bcol.getText());
			
			Arow.setEditable(true);
			Acol.setEditable(true);
			Brow.setEditable(false);
			Bcol.setEditable(true);
		} else {
			Brow.setText(Arow.getText()); 
			Bcol.setText(Acol.getText());
			Rrow.setText(Arow.getText()); 
			Rcol.setText(Acol.getText());
			
			Arow.setEditable(true);
			Acol.setEditable(true);
			Brow.setEditable(false);
			Bcol.setEditable(false);
		}
		m1Row = Integer.parseInt(Arow.getText());
		m1Col = Integer.parseInt(Acol.getText());
		m2Row = Integer.parseInt(Brow.getText());
		m2Col = Integer.parseInt(Bcol.getText());
		resRow = Integer.parseInt(Rrow.getText());
		resCol = Integer.parseInt(Rcol.getText());
		
		btnCalculate.setEnabled(false);
	}
	
	
	public void generateMatrix(JTextField[][] jTextMatrix, int offX, int offY, long[][] Matrix){
		int rows = Matrix.length;
		int columns = Matrix[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				//Creates the JTextField
				jTextMatrix[i][j] = new JTextField();
				//Sets JTextField text to Matrix values
				jTextMatrix[i][j].setText(String.valueOf(Matrix[i][j]));
				getContentPane().add(jTextMatrix[i][j]);
				jTextMatrix[i][j].setBounds(offX + (j * blockX), offY + (i * blockY), blockX - 10, blockY - 10);
				// textFieldArray[i].setBounds(x, y, width, height);
			}
		}
	}
	
	public void deleteMatrix(JTextField[][] jTextMatrix){
		int rows = jTextMatrix.length;
		int columns = jTextMatrix[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				//Deletes the JTextField
				remove(jTextMatrix[i][j]);
			}
		}
		
	}
	
	public void updateMatrix(JTextField[][] jTextMatrix, long[][] Matrix){
		int rows = jTextMatrix.length;
		int columns = jTextMatrix[0].length;
		//System.out.println("Printing matrix " + jTextMatrix.toString());
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				//Deletes the JTextField
				Matrix[i][j] = Long.parseLong(jTextMatrix[i][j].getText());
				//System.out.print(Matrix[i][j]);
				//System.out.print(",");
			}
			//System.out.println();
		}
	}

	public static void main(String args[]) {
		Interface interFace = new Interface();
	}
}