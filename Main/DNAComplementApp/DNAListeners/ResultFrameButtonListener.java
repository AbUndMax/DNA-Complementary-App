package DNAComplementApp.DNAListeners;

import DNAComplementApp.DNAHandlers.SavedHandler;
import DNAComplementApp.DNAMain;
import DNAComplementApp.DNAWindows.DNAMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static DNAComplementApp.DNAObjects.DNASequences.allSequences;
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
                SavedHandler.handleSave();
                break;

            case "new import":

                DNAMain.resultFrame.dispose();

                DNAMain.newMainFrame();

                break;
        }
    }
}
