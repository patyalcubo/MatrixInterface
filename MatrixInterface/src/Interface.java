import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface extends JPanel {
	private JTextField textField_1;
	private JTextField textField;
	int blockX = 50;
	int blockY = 50;
	
	public void generateMatrix(JTextField[][] matrix, int rows, int columns, int offX, int offY){
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				matrix[i][j] = new JTextField();
				add(matrix[i][j]);
				matrix[i][j].setBounds(offX + (i * blockX), offY + (j * blockY), blockX - 10, blockY - 10);
				// textFieldArray[i].setBounds(x, y, width, height);
			}
		}
	}
	
	public Interface() {

		int offX = 10;
		int offY = 10;
		
		int rows = 5;
		int columns = 10;
		

		JTextField[][] M1 = new JTextField[columns][rows];
		setLayout(null);

		generateMatrix(M1, rows, columns, offX, offY);
		
		offX = (columns+2)*blockX;
		offY = 10;

		rows = 3;
		columns = 2;

		JTextField[][] M2 = new JTextField[columns][rows];
		generateMatrix(M2, rows, columns, offX, offY);
		
		offX = offX + ((columns+2)*blockX);
		offY = 10;

		rows = 3;
		columns = 1;

		JTextField[][] Res = new JTextField[columns][rows];
		generateMatrix(Res, rows, columns, offX, offY);

	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().add(new Interface());
		f.setSize(1000, 800);
		f.setVisible(true);

		/*
		 * JTextField[] fields = new JTextField[22]; for (int i = 0; i < 22;
		 * i++) { fields[i] = new JTextField(); fields[i].setVisible(true);
		 * fields[i].setBounds(10*i, 10*i, 10, 4); //you can add any listener
		 * for JTextField here f.getContentPane().add(fields[i]); }
		 */
	}

}