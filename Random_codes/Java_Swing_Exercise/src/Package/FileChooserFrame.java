package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooserFrame extends JFrame implements ActionListener {

    JButton button;

    FileChooserFrame()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("Select file");
        button.addActionListener(this);

        this.add(button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button)
        {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File("."));
            // Set default path, here current file is chosen (with ".")

            int response = fileChooser.showOpenDialog(null); // Select file to open
            int response2 = fileChooser.showSaveDialog(null); // Select file to save
            // response = 0 when selected and 1 when canceling
            if(response == JFileChooser.APPROVE_OPTION) // response = 0
            {
                File file = new File(String.valueOf(fileChooser.getSelectedFile().getAbsoluteFile()));
                System.out.println(file);
            }
        }
    }
}
