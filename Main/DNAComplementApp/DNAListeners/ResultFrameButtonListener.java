package DNAComplementApp.DNAListeners;

import DNAComplementApp.DNAHandlers.SaveHandler;
import DNAComplementApp.DNAMain;
import DNAComplementApp.DNAObjects.DNASequences;
import DNAComplementApp.DNAWindows.ImportSuccessDialog;
import DNAComplementApp.DNAWindows.ResultFrame;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static DNAComplementApp.DNAListeners.ImportComboBoxListener.selectedItems;
import static DNAComplementApp.DNAObjects.DNASequences.allSequences;
import static DNAComplementApp.DNAObjects.DNASequences.getAllSequenceNames;

import static DNAComplementApp.DNAWindows.ResultFrame.textArea;

public class ResultFrameButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case "copy":
                StringSelection stringSelection = new StringSelection(textArea.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                break;

            case "save":
                SaveHandler.handleSave();
                break;

            case "new import":

                DNAMain.resultFrame.dispose();

                // clear the comboBoxes (ActionListeners has to be removed, since the .removeAllItems() triggers
                // ActionEvent which may lead to nullPointExceptions.
                ResultFrame.comboBox.removeActionListener(ResultFrame.comboBox.getActionListeners()[0]);
                ImportSuccessDialog.comboBox.removeActionListener(ImportSuccessDialog.comboBox.getActionListeners()[0]);
                ResultFrame.comboBox.removeAllItems();
                ImportSuccessDialog.comboBox.removeAllItems();

                // clear Objects
                for (String ObjectName : getAllSequenceNames()) {
                    allSequences.get(ObjectName).cleanObject();
                }
                DNASequences.allSequences.clear();

                // clear other Lists or Arrays
                selectedItems = new String[0];

                DNAMain.newMainFrame();

                break;
        }
    }
}
