package ui.components;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.ComponentAccessor;
import ui.ViewDimension;

import encryptor.Encryptor;

public class EncryptButton extends JButton {
    public EncryptButton() {
        super("Encrypt");
        setLayout(null);

        ViewDimension buttonDimension = new ViewDimension();
        buttonDimension.WIDTH = (ComponentAccessor.inputTextAreaDimension.WIDTH / 4);
        buttonDimension.HEIGHT = 30;
        buttonDimension.X = ComponentAccessor.inputTextAreaDimension.X;
        buttonDimension.toTop(
            ComponentAccessor.mainWindowDimension,
            (
                ComponentAccessor.keyTextFieldDimension.Y + 
                ComponentAccessor.keyTextFieldDimension.HEIGHT +
                10
            )
        );

        ComponentAccessor.encryptButtonDimension = buttonDimension;

        setBounds(
            ComponentAccessor.encryptButtonDimension.X,
            ComponentAccessor.encryptButtonDimension.Y,
            ComponentAccessor.encryptButtonDimension.WIDTH,
            ComponentAccessor.encryptButtonDimension.HEIGHT
        );

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ComponentAccessor.statusLabel.setText("Encrypting...");
                ComponentAccessor.statusLabel.setForeground(Color.GREEN);

                Thread t = new Thread(new Runnable() {
                    public void run() {
                        try{
                            ComponentAccessor.outputTextArea.setText(
                                Encryptor.encrypt(
                                    ComponentAccessor.inputTextArea.getText(),
                                    ComponentAccessor.keyTextField.getText()
                                )
                            );
                            ComponentAccessor.statusLabel.setText("Encrypted");
                            ComponentAccessor.statusLabel.setForeground(Color.WHITE);
                        } catch (Exception e) {
                            e.printStackTrace();
                            ComponentAccessor.statusLabel.setText("Error");
                            ComponentAccessor.statusLabel.setForeground(Color.RED);
                        }
                    }
                });

                t.start();
            }
        });

        setVisible(true);
    }
}
