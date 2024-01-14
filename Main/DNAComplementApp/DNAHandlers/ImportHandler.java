package DNAComplementApp.DNAHandlers;

import DNAComplementApp.DNAMain;
import DNAComplementApp.DNAObjects.DNASequences;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;

public class ImportHandler {

    // opens JFileChooser, checks File for FASTA format and loads the file into the System.
    public static void handleImport() {

        JFileChooser chooser = new JFileChooser();
        Boolean isFileSelected = false;
        File selectedFile;

        do {
            try {
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = chooser.showOpenDialog(DNAMain.mainFrame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();

                    // check File if Format is correct & Load it into the system-> else throw error
                    validateAndLoadFile(selectedFile);
                    isFileSelected = true;

                } else if (result == JFileChooser.CANCEL_OPTION){
                    return;
                }
            } catch (Exception xptn) {
                isFileSelected = false;
                JOptionPane.showMessageDialog(DNAMain.mainFrame, "Error: " + xptn.getMessage());
            }
        } while (!isFileSelected);


        // If import is successful, open the success Dialog
        DNAMain.newImportDialog();
    }

    // Reads the file, checks if format is valid while reading and if so, the sequence gets loaded iinto the system
    // if the file is not valid, a FileFormatError is raised!
    public static void validateAndLoadFile(File selectedFile) throws FileFormatError {
        try {
            // Creating a BufferedReader to read the file
            BufferedReader bufferedIN = new BufferedReader(new FileReader(selectedFile.getAbsolutePath()));
            String line = bufferedIN.readLine();
            DNASequences newSequence = null;

            // takes the first line (the Header) & loop through BufferedReader lines as long as the end is not reached
            while (line != null) {

                StringBuilder sequence = new StringBuilder();

                System.out.println(line.charAt(0));

                if (line.charAt(0) == '>') {
                    // if Header is found, set new Sequence Instance and place Header as Sequence name
                    System.out.println("Header found");
                    newSequence = new DNASequences(line.substring(1));
                    line = bufferedIN.readLine();
                }
                else if (line.charAt(0) == ';' | line.isEmpty()) {
                    line = bufferedIN.readLine();
                }
                else if (line.matches("^[ATCGURYKMSWBDHVN-]*$")){
                    // append the Sequence to one full String
                    System.out.println("line Matches Nukleotide");
                    do {
                            System.out.println("new line" + line);
                            sequence.append(line);
                    } while ((line = bufferedIN.readLine()) != null && line.toUpperCase().matches("^[ATCGURYKMSWBDHVN-]*$"));
                    // set finished String as Sequence attribute
                    newSequence.setSequence(sequence.toString());
                    System.out.println("Sequence appended");
                }
                else {
                    throw new FileFormatError();
                }
            }

            try {
                bufferedIN.close();
            } catch (Exception xptn){
                System.out.println(xptn.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new FileFormatError();
        }
    }

    private static class FileFormatError extends Exception {
        public FileFormatError() {
            super("File format not correct!");
        }
    }
}