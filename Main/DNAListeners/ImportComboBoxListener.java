package DNAListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static DNAObjects.DNASequences.allSequences;
import static DNAWindows.ImportSuccessDialog.comboBox;

public class ImportComboBoxListener implements ActionListener {

    public static String[] selectedItems = allSequences.keySet().toArray(new String[0]);

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedItem = (String) comboBox.getSelectedItem();

        switch(selectedItem) {
            case "All":
                selectedItems = allSequences.keySet().toArray(new String[0]);
                break;

            default:
                selectedItems = new String[1];
                selectedItems[0] = selectedItem;
                break;

        }
    }
}
