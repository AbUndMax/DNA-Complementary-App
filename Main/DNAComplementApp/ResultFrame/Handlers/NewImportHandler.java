package DNAComplementApp.ResultFrame.Handlers;

import DNAComplementApp.Main;
import DNAComplementApp.ObjectClasses.DNASequences;

import static DNAComplementApp.ImportFrame.Listeners.ImportSeqChooserCBoxListener.selectedSequences;
import static DNAComplementApp.ObjectClasses.DNASequences.allSequences;
import static DNAComplementApp.ObjectClasses.DNASequences.getAllSequenceNames;
import static DNAComplementApp.ResultFrame.ResultFrame.resultSequenceChooserCB;
import static DNAComplementApp.ImportSuccessDialog.ImportSuccessDialog.importSequenceChooserCB;

public class NewImportHandler {

    // this method disposes all opened frames, cleanes the arrays, objects and combobox items to ready the system
    // for a new import. (finally draw a new MainFrame)
    public static void handleNewImport() {

        Main.resultFrame.dispose();

        // clear the comboBoxes (ActionListeners has to be removed, since the .removeAllItems() triggers
        // ActionEvent which may lead to nullPointExceptions.
        resultSequenceChooserCB.removeActionListener(resultSequenceChooserCB.getActionListeners()[0]);
        importSequenceChooserCB.removeActionListener(importSequenceChooserCB.getActionListeners()[0]);
        resultSequenceChooserCB.removeAllItems();
        importSequenceChooserCB.removeAllItems();

        // clear Objects
        for (String ObjectName : getAllSequenceNames()) {
            allSequences.get(ObjectName).cleanObject();
        }
        DNASequences.allSequences.clear();

        // clear other Lists or Arrays
        selectedSequences = new String[0];

        Main.newMainFrame();
    }
}
