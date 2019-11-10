package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements MouseListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 * 
	 * When add task is clicked: ask the user for a task and save it to an array
	 * list
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: prompt the user for which task to
	 * remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Prompt the user for the location of the
	 * file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */
	static JFrame f = new JFrame();
	static JPanel p = new JPanel();
	static JButton[] b = new JButton[5];
	public ArrayList <String> list = new ArrayList <String>();
	public boolean view = false;
	
	public static void main(String[] args) {
		ToDoList l = new ToDoList();
		l.setup();
		
	}
	void setup() {
		String[] title = { "Add Task", "View Tasks", "Remove Task", "Save List", "Load List" };
		f.add(p);
		for (int i = 0; i < title.length; i++) {
			b[i] = new JButton();
			b[i].setName(title[i]);
			b[i].setText(title[i]);
			b[i].setVisible(true);
			b[i].addMouseListener(this);
			p.add(b[i]);
		}
		f.setVisible(true);
		f.addMouseListener(this);
		f.pack();
		
		try {
			BufferedReader b = new BufferedReader(new FileReader("src/_03_To_Do_List/list.txt"));
			String s = b.readLine();
			while(s != null) {
				list.add(s);
				s = b.readLine();
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void addTask() {
		String task = JOptionPane.showInputDialog("Insert a task");
		list.add(task);
	}
	void viewTasks() {
		updateList();
	}
	void removeTask() {
		String s = JOptionPane.showInputDialog("Which task do you want to remove?");
		
		for (int i = 0; i < list.size(); i++) {
			if(s.toLowerCase().equals(list.get(i).toLowerCase())){
				list.remove(i);
			}
		}
	}
	void saveList() {
		try {
			FileWriter f = new FileWriter("src/_03_To_Do_List/list.txt");
			for(String s: list) {
				f.write(s +"\n");
			}
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	void loadList() {
		
	}
	void updateList() {
		for (String s  : list) {
			System.out.println(s);
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int n = 0;
		for (int i = 0; i < b.length; i++) {
			if(b[i].equals(e.getSource())) {
				n = i;
			}
		}
		switch (n) {
		case 0:
			addTask();
			break;
		case 1:
			viewTasks();
			break;
		case 2:
			removeTask();
			break;
		case 3:
			saveList();
			break;
		case 4:
			loadList();
			break;
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
}
