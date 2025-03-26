package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerFrame extends JFrame implements KeyListener {

    JLabel label;
    ImageIcon icon;

    KeyListenerFrame()
    {
        icon = new ImageIcon("src/rocket.png");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.addKeyListener(this);

        label = new JLabel();
        label.setBounds(0, 0, 128, 128);
        label.setIcon(icon);
        //label.setBackground(Color.red);
        //label.setOpaque(true);

        this.getContentPane().setBackground(Color.black);
        this.add(label);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        // keyTyped = Invoked when a key is typed. Uses KeyChar, char output
        switch(e.getKeyChar())
        {
            case 'a' -> label.setLocation(label.getX() - 10, label.getY());
            case 'w' -> label.setLocation(label.getX(), label.getY() - 10);
            case 's' -> label.setLocation(label.getX(), label.getY() + 10);
            case 'd' -> label.setLocation(label.getX() + 10, label.getY());
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        // keyPressed = Invoked when a physical key is pressed down. Uses keyCode, int output
        switch(e.getKeyCode())
        {
            case 37 -> label.setLocation(label.getX() - 10, label.getY());
            case 38 -> label.setLocation(label.getX(), label.getY() - 10);
            case 40 -> label.setLocation(label.getX(), label.getY() + 10);
            case 39 -> label.setLocation(label.getX() + 10, label.getY());
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // keyReleased = Called whenever a button is released
        System.out.println("You released key character: " + e.getKeyChar());
        System.out.println("You released key code: " + e.getKeyCode());
    }
}
