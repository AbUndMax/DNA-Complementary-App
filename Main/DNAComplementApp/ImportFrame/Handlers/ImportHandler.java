package DNAComplementApp.ImportFrame.Handlers;

import DNAComplementApp.Main;
import DNAComplementApp.ObjectClasses.DNASequences;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ImportHandler {

    // opens JFileChooser, checks File for FASTA format and loads the file into the System.
    public static void handleImport() {

        JFileChooser chooser = new JFileChooser();
        Boolean isFileSelected = false;
        File selectedFile;

        do {
            try {
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = chooser.showOpenDialog(Main.mainFrame);

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
                JOptionPane.showMessageDialog(Main.mainFrame, "Error: " + xptn.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } while (!isFileSelected);


        // If import is successful, open the success Dialog
        Main.newImportDialog();
    }

    // Reads the file, checks if format is valid while reading and if so, the sequence gets loaded iinto the system
    // if the file is not valid, a FileFormatError is raised!
    public static void validateAndLoadFile(File selectedFile) throws FileFormatError {
        try (BufferedReader bufferedIN = new BufferedReader(new FileReader(selectedFile.getAbsolutePath()))) {
            // Creating a BufferedReader to read the file
            String line = bufferedIN.readLine();
            DNASequences newSequence = null;

            // takes the first line (the Header) & loop through BufferedReader lines as long as the end is not reached
            while (line != null) {

                /*
                Basic flow:
                function gets a line, it then checks:
                * Header
                    here it takes the header and uses it as the name for the sequence
                    it also instantiates a new DNASequence Object and hands it the sequence name
                * comment or empty line
                    these lines are just skipped
                * valid nucleotide sequence (valid in regard of FASTA allowed nucleotides)
                    here a new loop is created.
                    this loop, loops over each sequence line until it found a line that doesn't match any sequence anymore.
                    It then hands the finished sequence to the before created DNASequence Object and jumps back to
                    the outer loop which then checks for a new header.
                if none of these is found, a file error is raised.
                 */

                StringBuilder sequence = new StringBuilder();

                if (line.charAt(0) == '>') {
                    // if Header is found, set new Sequence Instance and place Header as Sequence name
                    newSequence = new DNASequences(line.substring(1));
                    line = bufferedIN.readLine();
                }
                else if (line.charAt(0) == ';' | line.isEmpty()) {
                    // jump comments and empty lines
                    line = bufferedIN.readLine();
                }
                else if (line.matches("^[ATCGURYKMSWBDHVN-]*$")){
                    // append the Sequence to one full String
                    do {
                            sequence.append(line);
                    } while ((line = bufferedIN.readLine()) != null && line.toUpperCase().matches("^[ATCGURYKMSWBDHVN-]*$"));
                    // set finished String as Sequence attribute
                    newSequence.setSequence(sequence.toString());
                }
                else {
                    throw new FileFormatError();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new FileFormatError();
        }
    }

    // self Made Error
    private static class FileFormatError extends Exception {
        public FileFormatError() {
            super("File format not correct!");
        }
    }
}