package DNAListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static DNAObjects.DNASequences.allSequences;
import static DNAWindows.ImportSuccessDialog.comboBox;

public class ResultComboBoxListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = (String) comboBox.getSelectedItem();

        //TextArea aktualisieren mit jeweiliger Seuqunce

    }
}
