package DNAComplementApp.DNAListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static DNAComplementApp.DNAObjects.DNASequences.getAllSequenceNames;
import static DNAComplementApp.DNAWindows.ImportSuccessDialog.comboBox;

public class ImportComboBoxListener implements ActionListener {

    public static String[] selectedItems;

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = (String) comboBox.getSelectedItem();

        switch(selectedItem) {
            case "All":
                selectedItems = getAllSequenceNames();
                break;

            default:
                selectedItems = new String[1];
                selectedItems[0] = selectedItem;
                break;

        }
    }
}
