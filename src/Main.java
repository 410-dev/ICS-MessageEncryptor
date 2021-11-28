import ui.ComponentAccessor;
import ui.components.*;

public class Main {

    private static void prepareUISystem() {
        ComponentAccessor.mainWindow = new MainWindow();
        ComponentAccessor.contentPane = new ContentPane();
        ComponentAccessor.inputTextArea = new IOTextArea(IOTextArea.INPUT_BOX);
        ComponentAccessor.outputTextArea = new IOTextArea(IOTextArea.OUTPUT_BOX);
        ComponentAccessor.scrollableInputTextArea = new IOScrollableTextArea(ComponentAccessor.inputTextArea, IOTextArea.INPUT_BOX);
        ComponentAccessor.scrollableOutputTextArea = new IOScrollableTextArea(ComponentAccessor.outputTextArea, IOTextArea.OUTPUT_BOX);
        ComponentAccessor.keyTextField = new KeyTextField();
        ComponentAccessor.encryptButton = new EncryptButton();
        ComponentAccessor.decryptButton = new DecryptButton();
        ComponentAccessor.importButton = new FileImportButton();
        ComponentAccessor.exportButton = new FileExportButton();
        ComponentAccessor.statusLabel = new StatusLabel();
    }

    private static void buildUI() {
        ComponentAccessor.contentPane.add(ComponentAccessor.inputTextArea);
        ComponentAccessor.contentPane.add(ComponentAccessor.outputTextArea);
        ComponentAccessor.contentPane.add(ComponentAccessor.scrollableInputTextArea);
        ComponentAccessor.contentPane.add(ComponentAccessor.scrollableOutputTextArea);
        ComponentAccessor.contentPane.add(ComponentAccessor.keyTextField);
        ComponentAccessor.contentPane.add(ComponentAccessor.encryptButton);
        ComponentAccessor.contentPane.add(ComponentAccessor.decryptButton);
        ComponentAccessor.contentPane.add(ComponentAccessor.importButton);
        ComponentAccessor.contentPane.add(ComponentAccessor.exportButton);
        ComponentAccessor.contentPane.add(ComponentAccessor.statusLabel);
        ComponentAccessor.mainWindow.add(ComponentAccessor.contentPane);
    }

    public static void main(String[] args) throws Exception {
        prepareUISystem();
        buildUI();
        ComponentAccessor.mainWindow.setVisible(true);
    }
}
