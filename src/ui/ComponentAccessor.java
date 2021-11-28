package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ComponentAccessor {
    public static JFrame mainWindow;
    public static JPanel contentPane;
    public static JButton importButton;
    public static JButton exportButton;
    public static JButton encryptButton;
    public static JButton decryptButton;
    public static JTextArea inputTextArea;
    public static JTextArea outputTextArea;
    public static JScrollPane scrollableInputTextArea;
    public static JScrollPane scrollableOutputTextArea;
    public static JTextField keyTextField;
    public static JLabel statusLabel;

    public static ViewDimension mainWindowDimension;
    public static ViewDimension encryptButtonDimension;
    public static ViewDimension decryptButtonDimension;
    public static ViewDimension importButtonDimension;
    public static ViewDimension exportButtonDimension;
    public static ViewDimension inputTextAreaDimension;
    public static ViewDimension outputTextAreaDimension;
    public static ViewDimension keyTextFieldDimension;
    public static ViewDimension statusLabelDimension;

    public static final String versionStr = "Message Encryptor InDev";
}
