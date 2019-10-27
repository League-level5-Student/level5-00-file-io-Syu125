package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/message.txt");
			String message = JOptionPane.showInputDialog("Write a message");
			char[] c = message.toCharArray();
			for (int i = 0; i < c.length / 2 + 1; i++) {
				char temp = c[i];
				c[i] = c[c.length - 1 - i];
				c[c.length - 1 - i] = temp;
			}
			fw.write(c);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}