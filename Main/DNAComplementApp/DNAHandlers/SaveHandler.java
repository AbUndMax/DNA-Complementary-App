package DNAComplementApp.DNAHandlers;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static DNAComplementApp.DNAListeners.ImportComboBoxListener.selectedItems;
import static DNAComplementApp.DNAListeners.ImportDialogButtonListener.isReverse;
import static DNAComplementApp.DNAObjects.DNASequences.allSequences;

public class SaveHandler {

    public static void handleSave() {

        String fileName;
        if (isReverse) {
            fileName = "reverse-complement";
        } else {
            fileName  = "complement";
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        fileChooser.setSelectedFile(new File(fileName+".fasta"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // Von hier aus können Sie nun FileOutputStream, PrintWriter oder einen anderen Writer verwenden,
            // um an dem durch 'fileToSave' angegebenen Ort eine Datei zu schreiben.
            try(PrintWriter out = new PrintWriter(fileToSave)){
                for (String sequenceName : selectedItems) {

                    String complement;
                    if (isReverse) {
                        complement = allSequences.get(sequenceName).getReverseComplement();
                    } else {
                        complement = allSequences.get(sequenceName).getComplement();
                    }
                    //print header
                    out.println(">" + sequenceName + "-" + fileName);

                    // print Sequence
                    // max 80 Nucleotides per Row
                    int complementLength = complement.length();
                    int complementRest = complementLength % 80;
                    int complementEnd = complementLength - complementRest;
                    int i = 0;
                    do {
                        if (i < complementEnd) {
                            out.println(complement.substring(i, i += 80));
                        } else {
                            out.println(complement.substring(i, complementLength));
                        }
                    } while (i < complementEnd);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}