package ui.components;

import javax.swing.JTextArea;

import java.awt.Color;

import ui.ComponentAccessor;
import ui.ViewDimension;

public class IOTextArea extends JTextArea {

    public static boolean OUTPUT_BOX = false;
    public static boolean INPUT_BOX = true;

    public IOTextArea(boolean boxType) {
        super();
        setLayout(null);

        ViewDimension fieldDimension = new ViewDimension(
            (int) Math.round(ComponentAccessor.mainWindowDimension.WIDTH*0.9), 
            (int) Math.round(ComponentAccessor.mainWindowDimension.HEIGHT*0.34)
        );

        fieldDimension.alignCenter(ComponentAccessor.mainWindowDimension);

        if (boxType == OUTPUT_BOX) {
            fieldDimension.toTop(
                ComponentAccessor.mainWindowDimension, 
                (
                    ComponentAccessor.inputTextAreaDimension.HEIGHT + 
                    ComponentAccessor.inputTextAreaDimension.Y + 
                    10
                )
            );
            
            ComponentAccessor.outputTextAreaDimension = fieldDimension;

            setEditable(false);
            setToolTipText("Output Field");
        }else{
            fieldDimension.toTop(
                ComponentAccessor.mainWindowDimension, 
                (
                    ContentPane.labelDimension.HEIGHT + 
                    ContentPane.labelDimension.Y + 
                    15
                )
            );

            ComponentAccessor.inputTextAreaDimension = fieldDimension;

            setEditable(true);
            setToolTipText("Input Field");
        }

        setBounds(
            fieldDimension.X,
            fieldDimension.Y,
            fieldDimension.WIDTH,
            fieldDimension.HEIGHT
        );

        setLineWrap(true);
        setWrapStyleWord(true);
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setVisible(true);
    }
}