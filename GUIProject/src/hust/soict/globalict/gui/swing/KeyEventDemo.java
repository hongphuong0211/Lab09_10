package hust.soict.globalict.gui.swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.event.*;

// An AWT GUI program inherits from the top-level container java.awt.Frame
public class KeyEventDemo extends JFrame {

   private JTextField tfInput;  // Single-line TextField to receive tfInput key
   private JTextArea taDisplay; // Multi-line TextArea to taDisplay result

   // Constructor to setup the GUI components and event handlers
   public KeyEventDemo() {
	  Container cp = getContentPane();
	  cp.setLayout(new GridLayout(3, 0, 5, 5));  // The content-pane sets its layout

      cp.add(new JLabel("Enter Text: "));
      tfInput = new JTextField();
      cp.add(tfInput);
      taDisplay = new JTextArea(5, 40); // 5 rows, 40 columns
      cp.add(taDisplay);

      tfInput.addKeyListener(new KeyListener(){
    	  @Override
    	  public void keyTyped(KeyEvent e) {
    		  // TODO Auto-generated method stub
    		  taDisplay.append("You have typed " + e.getKeyChar() + "\n");
    	  }

    	  @Override public void keyPressed(KeyEvent e) {}
    	  @Override public void keyReleased(KeyEvent e) {}
       });
      setTitle("KeyEvent Demo"); // "super" Frame sets title
      setSize(400, 200);         // "super" Frame sets initial size
      setVisible(true);          // "super" Frame shows
   }

   // The entry main() method
   public static void main(String[] args) {
      new KeyEventDemo();  // Let the constructor do the job
   }
}
