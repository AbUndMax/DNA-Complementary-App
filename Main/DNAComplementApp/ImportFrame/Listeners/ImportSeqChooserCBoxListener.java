package DNAComplementApp.ImportFrame.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static DNAComplementApp.ObjectClasses.DNASequences.getAllSequenceNames;
import static DNAComplementApp.ImportSuccessDialog.ImportSuccessDialog.importSequenceChooserCB;

public class ImportSeqChooserCBoxListener implements ActionListener {

    public static String[] selectedSequences;

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = (String) importSequenceChooserCB.getSelectedItem();

        switch(selectedItem) {
            case "All":
                selectedSequences = getAllSequenceNames();
                break;

            default:
                selectedSequences = new String[1];
                selectedSequences[0] = selectedItem;
                break;

        }
    }
}
