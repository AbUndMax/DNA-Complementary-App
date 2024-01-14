package DNAComplementApp.DNAListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static DNAComplementApp.DNAListeners.ImportDialogButtonListener.isReverse;
import static DNAComplementApp.DNAObjects.DNASequences.allSequences;
import static DNAComplementApp.DNAWindows.ResultFrame.comboBox;
import static DNAComplementApp.DNAWindows.ResultFrame.textArea;

public class ResultComboBoxListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = (String) comboBox.getSelectedItem();

        if (isReverse) {
            //TextArea aktualisieren mit jeweiliger Seuqunce
            textArea.setText(allSequences.get(selectedItem).getReverseComplement());
        } else {
            textArea.setText(allSequences.get(selectedItem).getComplement());
        }
    }
}
