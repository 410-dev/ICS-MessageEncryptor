package ui.components;

import javax.swing.JLabel;

import java.awt.Color;

import ui.ComponentAccessor;
import ui.ViewDimension;

public class StatusLabel extends JLabel {
    public StatusLabel() {
        super("Idle");
        setLayout(null);

        ViewDimension labelDimension = new ViewDimension();
        labelDimension.WIDTH = ComponentAccessor.outputTextAreaDimension.WIDTH;
        labelDimension.HEIGHT = 30;
        labelDimension.X = ComponentAccessor.outputTextAreaDimension.X;
        labelDimension.toTop(
            ComponentAccessor.mainWindowDimension,
            (
                ComponentAccessor.encryptButtonDimension.Y + 
                ComponentAccessor.encryptButtonDimension.HEIGHT +
                10
            )
        );

        ComponentAccessor.statusLabelDimension = labelDimension;

        setBounds(
            ComponentAccessor.statusLabelDimension.X,
            ComponentAccessor.statusLabelDimension.Y,
            ComponentAccessor.statusLabelDimension.WIDTH,
            ComponentAccessor.statusLabelDimension.HEIGHT
        );

        setForeground(Color.WHITE);
        setVisible(true);
    }   
}
