import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Interface extends JFrame {
	int blockX = 50;
	int blockY = 50;
	
	private JTextField[][] textMatrix  = new JTextField[1][1];
	private JButton btnClear;
	private JButton btnGenerate;
	private JButton btnCalculate;
	private JButton btnUpdate;
	private JLabel lblSigno;
	private JLabel lblIgual;
	
	
	static long[][] m1 = new long[12][8];
	static long[][] m2 = new long[13][4];
	static long[][] res = new long[3][5];
	
	static JTextField[][] jTextM1 = new JTextField[m1.length][m1[0].length];
	static JTextField[][] jTextM2 = new JTextField[m2.length][m2[0].length];
	static JTextField[][] jTextRes = new JTextField[res.length][res[0].length];
	
	int offX = 100;
	int offY = 100;
	String sign = "*";
	
	public Interface() {
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
		btnGenerate.setBounds(10, 100, 100, 100);
		c.add(btnGenerate);
		
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				offX = 100;
				offY = 100;
				
				generateMatrix(jTextM1, offX, offY, m1);
				
				offX = (m1[0].length+2)*blockX + offX;
				generateMatrix(jTextM2, offX, offY, m2);
				
				lblSigno.setBounds(offX - blockX, offY, 46, 14);
				
				offX = offX + ((m2[0].length+2)*blockX);
				
				lblSigno.setText(sign);
				lblSigno.setVisible(true);
				
				c.repaint();
			}
		});
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(10, 200, 100, 100);
		c.add(btnCalculate);
		
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				generateMatrix(jTextRes, offX, offY, res);
				
				lblIgual.setBounds(offX - blockX, offY, 46, 14);
				lblIgual.setVisible(true);
				
				c.repaint();
			}
		});
		
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(10, 300, 100, 100);
		c.add(btnUpdate);
		
		
		lblSigno = new JLabel("Signo");
		lblIgual = new JLabel("=");
		getContentPane().add(lblSigno);
		getContentPane().add(lblIgual);
		lblSigno.setVisible(false);
		lblIgual.setVisible(false);
		
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateMatrix(jTextM1, m1);
				updateMatrix(jTextM2, m2);
				//Aqui 
				updateMatrix(jTextRes, res);
			}
		});
		
		setSize(500,500);
		setVisible(true);

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