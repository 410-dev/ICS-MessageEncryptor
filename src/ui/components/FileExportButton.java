package ui.components;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.FileWriter;
import java.io.IOException;

import ui.ComponentAccessor;
import ui.ViewDimension;

public class FileExportButton extends JButton {
    
    public FileExportButton(){
        super("Export");
        setLayout(null);

        ViewDimension buttonDimension = new ViewDimension();
        buttonDimension.WIDTH = (ComponentAccessor.inputTextAreaDimension.WIDTH / 4);
        buttonDimension.HEIGHT = 30;
        buttonDimension.X = (
            ComponentAccessor.importButtonDimension.X + 
            ComponentAccessor.importButtonDimension.WIDTH
        );
        buttonDimension.toTop(
            ComponentAccessor.mainWindowDimension,
            (
                ComponentAccessor.keyTextFieldDimension.Y + 
                ComponentAccessor.keyTextFieldDimension.HEIGHT +
                10
            )
        );

        ComponentAccessor.exportButtonDimension = buttonDimension;

        setBounds(
            ComponentAccessor.exportButtonDimension.X,
            ComponentAccessor.exportButtonDimension.Y,
            ComponentAccessor.exportButtonDimension.WIDTH,
            ComponentAccessor.exportButtonDimension.HEIGHT
        );

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(null);
                String savePath = fileChooser.getSelectedFile().getAbsolutePath();
                try{
                    FileWriter fw = new FileWriter(savePath + ".cryptographyproject");
                    fw.write(ComponentAccessor.outputTextArea.getText());
                    fw.close();
                }catch(IOException e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to save file: " + e1.getMessage());
                }
            }
        });

        setVisible(true);
    }
}
