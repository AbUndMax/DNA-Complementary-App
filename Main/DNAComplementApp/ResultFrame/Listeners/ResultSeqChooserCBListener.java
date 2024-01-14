package DNAComplementApp.ResultFrame.Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static DNAComplementApp.ObjectClasses.DNASequences.allSequences;
import static DNAComplementApp.ResultFrame.ResultFrame.resultSequenceChooserCB;
import static DNAComplementApp.ResultFrame.ResultFrame.textArea;

public class ResultSeqChooserCBListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = (String) resultSequenceChooserCB.getSelectedItem();

        textArea.setText(allSequences.get(selectedItem).getComplement());
    }
}
