package ui.components;

import javax.swing.JPanel;

import ui.ComponentAccessor;
import ui.ViewDimension;

import javax.swing.JLabel;

import java.awt.Color;

public class ContentPane extends JPanel {

    public static ViewDimension labelDimension = new ViewDimension(10, 0, 1000, 30);
    public static ViewDimension contentPaneDimension = new ViewDimension(0, 0, ComponentAccessor.mainWindowDimension.WIDTH, ComponentAccessor.mainWindowDimension.HEIGHT);

    public ContentPane() {
        super();
        setLayout(null);
        setBackground(Color.BLACK);
        setBounds(
            ComponentAccessor.mainWindowDimension.X,
            ComponentAccessor.mainWindowDimension.Y,
            ComponentAccessor.mainWindowDimension.WIDTH,
            ComponentAccessor.mainWindowDimension.HEIGHT
        );

        JLabel label = new JLabel();
        label.setText(ComponentAccessor.versionStr);
        label.setForeground(Color.WHITE);

        ViewDimension labelDimension = new ViewDimension();
        labelDimension.WIDTH = ContentPane.labelDimension.WIDTH;
        labelDimension.HEIGHT = ContentPane.labelDimension.HEIGHT;
        labelDimension.alignCenter(ComponentAccessor.mainWindowDimension);
        labelDimension.toTop(
            ComponentAccessor.mainWindowDimension, 
            ContentPane.labelDimension.X
        );
        labelDimension.toLeft(
            ComponentAccessor.mainWindowDimension, 
            ContentPane.labelDimension.Y
        );

        label.setBounds(
            labelDimension.X, 
            labelDimension.Y, 
            labelDimension.WIDTH, 
            labelDimension.HEIGHT
        );
        add(label);

        setVisible(true);
    }
}
