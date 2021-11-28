package ui.components;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ui.ComponentAccessor;

public class IOScrollableTextArea extends JScrollPane{
    public IOScrollableTextArea(JTextArea field, boolean boxType) {
        super(field);
        setLayout(null);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        if (boxType == IOTextArea.INPUT_BOX) {
            setBounds(
                ComponentAccessor.inputTextAreaDimension.X,
                ComponentAccessor.inputTextAreaDimension.Y,
                ComponentAccessor.inputTextAreaDimension.WIDTH,
                ComponentAccessor.inputTextAreaDimension.HEIGHT
            );
        }else{
            setBounds(
                ComponentAccessor.outputTextAreaDimension.X,
                ComponentAccessor.outputTextAreaDimension.Y,
                ComponentAccessor.outputTextAreaDimension.WIDTH,
                ComponentAccessor.outputTextAreaDimension.HEIGHT
            );
        }
        setVisible(true);
    }
}
