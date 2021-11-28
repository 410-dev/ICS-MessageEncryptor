package ui.components;

import javax.swing.JFrame;

import ui.ComponentAccessor;
import ui.ViewDimension;

public class MainWindow extends JFrame{
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 700;

    public MainWindow() {
        super("Message Encryptor");
        setSize(
            MainWindow.WINDOW_WIDTH, 
            MainWindow.WINDOW_HEIGHT
        );
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ComponentAccessor.mainWindowDimension = new ViewDimension(
            MainWindow.WINDOW_WIDTH,
            MainWindow.WINDOW_HEIGHT
        );
    }
}
