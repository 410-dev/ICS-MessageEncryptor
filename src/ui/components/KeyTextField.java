package ui.components;

import java.awt.Color;

import javax.swing.JTextField;

import ui.ComponentAccessor;
import ui.ViewDimension;

public class KeyTextField extends JTextField {
    public KeyTextField() {
        super();
        setLayout(null);

        ViewDimension textFieldDimension = new ViewDimension();
        textFieldDimension.WIDTH = ComponentAccessor.inputTextAreaDimension.WIDTH;
        textFieldDimension.HEIGHT = 30;
        textFieldDimension.alignCenter(ComponentAccessor.mainWindowDimension);
        textFieldDimension.toTop(
            ComponentAccessor.mainWindowDimension,
            (
                ComponentAccessor.outputTextAreaDimension.Y + 
                ComponentAccessor.outputTextAreaDimension.HEIGHT +
                10
            )
        );

        ComponentAccessor.keyTextFieldDimension = textFieldDimension;

        setBounds(
            ComponentAccessor.keyTextFieldDimension.X,
            ComponentAccessor.keyTextFieldDimension.Y,
            ComponentAccessor.keyTextFieldDimension.WIDTH,
            ComponentAccessor.keyTextFieldDimension.HEIGHT
        );

        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setToolTipText("Private Key");
        setVisible(true);
    }
}
