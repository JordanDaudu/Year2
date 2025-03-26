package HowToOpenANewWindow;

import javax.swing.*;
import java.awt.*;

public class NewWindow
{
    private static NewWindow instance = null;

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Hello!");

    NewWindow()
    {
        label.setBounds(0, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));

        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420); // width, height
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static NewWindow getInstance()
    {
        if(instance == null)
            instance = new NewWindow();
        return instance;
    }
}
