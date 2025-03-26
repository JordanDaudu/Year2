package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener
{
    JButton button;
    JLabel label;

    MyFrame()
    {
        ImageIcon icon = new ImageIcon("src/like.png");
        ImageIcon icon2 = new ImageIcon("src/surprise.png");

        label = new JLabel();
        label.setIcon(icon2);
        label.setBounds(120,360,256,256);
        label.setVisible(false);

        button = new JButton();
        button.setBounds(100, 100, 250, 250); // x,y,width,height
        button.addActionListener(this);
        // Note: There is a more advanced way not implementing actionListener
        //       and actionPerformed function
        // button.addActionListener(e -> System.out.println("poo"));
        button.setText("I'm a button!"); // put text on button
        button.setFocusable(false); // removes the border around the text
        button.setIcon(icon); // Sets an icon image for the button
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Courier New", Font.BOLD, 18));
        button.setIconTextGap(15); // Sets the gap between the text and the icon in pixels
        button.setForeground(Color.cyan); // Sets the text color
        button.setBackground(Color.red); // Sets the background color of the button
        button.setBorder(BorderFactory.createEtchedBorder()); // Adds an etched border around the button
        button.setEnabled(true); // Enable/Disable button (true by default)


        this.setTitle("JFrame title goes here"); // sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
        this.setResizable(false); // prevent frame from being resized
        this.setLayout(null); // setting layout to null
        this.setSize(720, 720); // sets the x-dimension and y-dimension of frame
        this.setVisible(true);
        this.add(button);
        this.add(label);

        ImageIcon image = new ImageIcon("src/Thors.png"); // create an ImageIcon
        this.setIconImage(image.getImage()); // change icon of frame (for windows)
        this.getContentPane().setBackground(Color.lightGray); // change color of background
        this.getContentPane().setBackground(new Color(255, 255, 255)); // custom color
        //                                                                (hexadecimal possible as well)
        // This try catch block is for changing the icon on Mac
        try
        {
            Taskbar taskbar = Taskbar.getTaskbar();
            taskbar.setIconImage(image.getImage()); // Works on macOS and some Linux distros
        }
        catch (UnsupportedOperationException | SecurityException e)
        {
            System.out.println("Could not set Dock icon: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == button)
        {
            System.out.println("Like!"); // print when pressing
        }
        label.setVisible(true); // makes label visible (in this case surprise.png)
    }
}
