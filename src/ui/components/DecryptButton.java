package ui.components;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.ComponentAccessor;
import ui.ViewDimension;

import encryptor.Decryptor;

public class DecryptButton extends JButton {
    public DecryptButton() {
        super("Decrypt");
        setLayout(null);

        ViewDimension buttonDimension = new ViewDimension();
        buttonDimension.WIDTH = (ComponentAccessor.inputTextAreaDimension.WIDTH / 4);
        buttonDimension.HEIGHT = 30;
        buttonDimension.X = (
            ComponentAccessor.encryptButtonDimension.X + 
            ComponentAccessor.encryptButtonDimension.WIDTH
        );
        buttonDimension.toTop(
            ComponentAccessor.mainWindowDimension,
            (
                ComponentAccessor.keyTextFieldDimension.Y + 
                ComponentAccessor.keyTextFieldDimension.HEIGHT +
                10
            )
        );

        ComponentAccessor.decryptButtonDimension = buttonDimension;

        setBounds(
            ComponentAccessor.decryptButtonDimension.X,
            ComponentAccessor.decryptButtonDimension.Y,
            ComponentAccessor.decryptButtonDimension.WIDTH,
            ComponentAccessor.decryptButtonDimension.HEIGHT
        );

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ComponentAccessor.statusLabel.setText("Decrypting...");
                ComponentAccessor.statusLabel.setForeground(Color.GREEN);

                Thread t = new Thread(new Runnable() {
                    public void run() {
                        try{
                            ComponentAccessor.outputTextArea.setText(
                                Decryptor.decrypt(
                                    ComponentAccessor.inputTextArea.getText(),
                                    ComponentAccessor.keyTextField.getText()
                                )
                            );
                            ComponentAccessor.statusLabel.setText("Decrypted");
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
