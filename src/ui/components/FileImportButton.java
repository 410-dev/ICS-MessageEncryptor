package ui.components;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.IOException;

import ui.ComponentAccessor;
import ui.ViewDimension;

public class FileImportButton extends JButton {
    
    public FileImportButton(){
        super("Import");
        setLayout(null);

        ViewDimension buttonDimension = new ViewDimension();
        buttonDimension.WIDTH = (ComponentAccessor.inputTextAreaDimension.WIDTH / 4);
        buttonDimension.HEIGHT = 30;
        buttonDimension.X = (
            ComponentAccessor.decryptButtonDimension.X + 
            ComponentAccessor.decryptButtonDimension.WIDTH
        );
        buttonDimension.toTop(
            ComponentAccessor.mainWindowDimension,
            (
                ComponentAccessor.keyTextFieldDimension.Y + 
                ComponentAccessor.keyTextFieldDimension.HEIGHT +
                10
            )
        );

        ComponentAccessor.importButtonDimension = buttonDimension;

        setBounds(
            ComponentAccessor.importButtonDimension.X,
            ComponentAccessor.importButtonDimension.Y,
            ComponentAccessor.importButtonDimension.WIDTH,
            ComponentAccessor.importButtonDimension.HEIGHT
        );

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Cryptograph Files", "cryptographyproject");
                fileChooser.setFileFilter(filter);
                fileChooser.showOpenDialog(null);
                String openpath = fileChooser.getSelectedFile().getAbsolutePath();
                try{
                    FileReader fr = new FileReader(openpath);
                    StringBuilder sb = new StringBuilder();
                    int c;
                    while((c = fr.read()) != -1){
                        sb.append((char)c);
                    }
                    ComponentAccessor.inputTextArea.setText(sb.toString());
                    fr.close();
                }catch(IOException e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to load file: " + e1.getMessage());
                }
            }
        });

        setVisible(true);
    }
}
