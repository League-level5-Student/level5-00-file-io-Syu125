package _05_Pixel_Art_Save_State;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;

public class GridPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int windowWidth;
	private int windowHeight;
	private int pixelWidth;
	private int pixelHeight;
	private int rows;
	private int cols;

	public int[][][] pNum;

	// 1. Create a 2D array of pixels. Do not initialize it yet.
	Pixel[][] p;

	private Color color;

	public GridPanel(int w, int h, int r, int c) {
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;

		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;

		setPreferredSize(new Dimension(windowWidth, windowHeight));

		// 2. Initialize the pixel array using the rows and cols variables.
		p = new Pixel[rows][cols];
		pNum = new int[rows][cols][3];
		// 3. Iterate through the array and initialize each element to a new pixel.
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				p[i][j] = new Pixel(i * pixelWidth, j * pixelHeight);
			}
		}

	}

	public void setColor(Color c) {
		color = c;
	}

	public void clickPixel(int mouseX, int mouseY) {
		// 5. Use the mouseX and mouseY variables to change the color
		// of the pixel that was clicked. *HINT* Use the pixel's dimensions.
		p[mouseX / pixelWidth][mouseY / pixelHeight].color = color;
		System.out.println(mouseX / pixelWidth + "," + mouseY / pixelHeight);
		System.out.println(color);
		pNum[mouseX / pixelWidth][mouseY / pixelHeight][0] = color.getRed();
		pNum[mouseX / pixelWidth][mouseY / pixelHeight][1] = color.getGreen();
		pNum[mouseX / pixelWidth][mouseY / pixelHeight][2] = color.getBlue();
	}

	@Override
	public void paintComponent(Graphics g) {
		// 4. Iterate through the array.
		// For every pixel in the list, fill in a rectangle using the pixel's color.
		// Then, use drawRect to add a grid pattern to your display.
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				g.setColor(p[i][j].color);
				g.fillRect(p[i][j].x, p[i][j].y, pixelWidth, pixelHeight);
				g.setColor(Color.black);
				g.drawRect(p[i][j].x, p[i][j].y, pixelWidth, pixelHeight);
			}
		}

	}

	public void save() {
		try {
			FileWriter fw = new FileWriter("src/_05_Pixel_Art_Save_State/art.txt");
			for (int i = 0; i < pNum.length; i++) {
				for (int j = 0; j < pNum[i].length; j++) {
					for (int h = 0; h < pNum[i][j].length; h++) {
					//	fw.write(pNum[i][j][h]);
						System.out.println(pNum[i][j][h]+"\n");
					}
				}
			}
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
