package _02_File_Encrypt_Decrypt;

import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		try {

			FileReader fr = new FileReader("src/_02_File_Encrypt_Decrypt/message.txt");
			int c = 0;
			String s = "";
			while (c != -1) {
				s = s.concat(String.valueOf((char) c));
				c = fr.read();
			}
			char[] given = s.toCharArray();
			String message = "";
			if(given.length%2 == 0) {
				for (int i = 0; i < given.length / 2; i++) {
				char temp = given[i];
				given[i] = given[given.length - i - 1];
				given[given.length - i - 1] = temp;
			}
			}else {
				for (int i = 0; i < given.length / 2 +1; i++) {
					char temp = given[i];
					given[i] = given[given.length - i - 1];
					given[given.length - i - 1] = temp;
				}
			}
			
			for (char ch : given) {
				message = message.concat(String.valueOf(ch));
			}
			JOptionPane.showMessageDialog(null, message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
