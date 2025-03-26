package Package;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MenuBarFrame extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu helpMenu;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    ImageIcon loadIcon;
    ImageIcon saveIcon;
    ImageIcon exitIcon;

    MenuBarFrame()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        loadIcon = new ImageIcon("src/folder.png");
        saveIcon = new ImageIcon("src/save.png");
        exitIcon = new ImageIcon("src/exit.png");

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");

        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        loadItem.setIcon(loadIcon);
        saveItem.setIcon(saveIcon);
        exitItem.setIcon(exitIcon);

        // Keyboard shortcut (Jmenu shortcut doesn't work on mac)
        // MacOS should disable mnemonics and use KeyStroke
        fileMenu.setMnemonic(KeyEvent.VK_F); // ALT + F for file
        editMenu.setMnemonic(KeyEvent.VK_E); // ALT + E for edit
        helpMenu.setMnemonic(KeyEvent.VK_H); // ALT + H for help
        loadItem.setMnemonic(KeyEvent.VK_L); // L for load
        saveItem.setMnemonic(KeyEvent.VK_S); // S for save
        exitItem.setMnemonic(KeyEvent.VK_E); // E for exit

        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == loadItem)
        {
            System.out.println("*You loaded an item*");
        }
        else if(e.getSource() == saveItem)
        {
            System.out.println("*You saved an item*");
        }
        else if(e.getSource() == exitItem)
        {
            System.out.println("*You exited*");
            System.exit(0);
        }
    }
}
