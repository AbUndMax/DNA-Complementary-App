package DNAComplementApp.ResultFrame.Handlers;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static DNAComplementApp.ImportSuccessDialog.Listeners.ImportSeqChooserCBoxListener.selectedSequences;
import static DNAComplementApp.ImportSuccessDialog.Listeners.ComplementButtonListeners.isReverse;
import static DNAComplementApp.ObjectClasses.DNASequences.allSequences;

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

            try(PrintWriter out = new PrintWriter(fileToSave)){
                for (String sequenceName : selectedSequences) {

                    String complement = allSequences.get(sequenceName).getComplement();;

                    //print header
                    out.println(">" + sequenceName + "-" + fileName);

                    // print Sequence
                    // max 80 Nucleotides per Row
                    // every loop a substring of 80 letters is generated,
                    // if the rest is less than 80 letters a substring from current Index till last index is written
                    int complementLength = complement.length();
                    int complementRest = complementLength % 80;
                    int complementEndWithoutRest = complementLength - complementRest;
                    int i = 0;
                    do {
                        if (i < complementEndWithoutRest) {
                            out.println(complement.substring(i, i += 80));
                        } else {
                            out.println(complement.substring(i, complementLength));
                        }
                    } while (i < complementEndWithoutRest);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}