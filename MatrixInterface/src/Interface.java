import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	static int a = random.nextInt(10) + 1;
	static int b = random.nextInt(10) + 1;
	static int c = random.nextInt(10) + 1;
	
	
	static long[][] m1 = new long[a][b];
	static long[][] m2 = new long[b][c];
	static long[][] res = new long[a][c];
	String sign = "*";
	
	
	/*
	static long[][] m1 = new long[a][b];
	static long[][] m2 = new long[a][b];
	static long[][] res = new long[a][b];
	String sign = "-";
	*/
		
	static JTextField[][] jTextM1 = new JTextField[m1.length][m1[0].length];
	static JTextField[][] jTextM2 = new JTextField[m2.length][m2[0].length];
	static JTextField[][] jTextRes = new JTextField[res.length][res[0].length];
	
	int offX = 50;
	int offY = 200;
	
	public Interface() {
		
		//Not needed, initialization to check addition 
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
		            res[ii][jj] = m1[ii][jj] + m2[ii][jj];
		            System.out.println(ii + " " + jj);
		        }
		    }
		}
		//END initialization 
		
		Container c = getContentPane();
		getContentPane().setLayout(null);

		
		btnClear = new JButton("Clear");
		btnClear.setBounds(10, 10, 100, 100);
		c.add(btnClear);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteMatrix(jTextM1);
				deleteMatrix(jTextM2);
				deleteMatrix(jTextRes);
				
				lblSigno.setVisible(false);
				lblIgual.setVisible(false);
				
				c.repaint();
			}
		});
		
		btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(100, 10, 100, 100);
		c.add(btnGenerate);
		
		
		lblSigno = new JLabel("Signo");
		lblIgual = new JLabel("=");
		getContentPane().add(lblSigno);
		getContentPane().add(lblIgual);
		lblSigno.setVisible(false);
		lblIgual.setVisible(false);
		
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				offX = 100;
				offY = 150;
				
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
				
				c.repaint();
			}
		});
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(200, 10, 100, 100);
		c.add(btnCalculate);
		
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Updates m1 and m2 values 
				updateMatrix(jTextM1, m1);
				updateMatrix(jTextM2, m2);
				
				//Calculates res matrix
				if (sign == "*"){
					res = Multiplication.Multiplicate(m1, m2);
				} else if (sign == "+"){
					res = Addition.Add(m1, m2, false);
				} else{
					res = Addition.Add(m1, m2, true);
				}
				
				//Draws res matrix
				generateMatrix(jTextRes, offX, offY, res);
				
				//updateMatrix(jTextRes, res);
				
				lblIgual.setBounds(offX - blockX, offY, 46, 14);
				lblIgual.setVisible(true);
				
				offX = offX + ((m2[0].length+2)*blockX);
				
				setSize(offX, getHeight());
				
				c.repaint();
			}
		});
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
		System.out.println("Printing matrix " + jTextMatrix.toString());
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				//Deletes the JTextField
				Matrix[i][j] = Long.parseLong(jTextMatrix[i][j].getText());
				System.out.print(Matrix[i][j]);
				System.out.print(",");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Interface interFace = new Interface();
	}
}