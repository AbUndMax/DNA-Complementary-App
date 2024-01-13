package DNAComplement.DNAHandlers;

import DNAComplement.DNAFrames.DNAMainFrame;
import DNAComplement.DNAFrames.ImportSuccessDialog;
import DNAComplement.DNASequences;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ImportHandler {

    // opens JFileChooser, checks File for FASTA format and loads the file into the System.
    public static void handleImport(DNAMainFrame frame) {

        JFileChooser chooser = new JFileChooser();
        Boolean isFileSelected = false;
        File selectedFile = null;

        do {
            try {
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = chooser.showOpenDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                    // check File if Format is correct -> else throw error
                    validateAndLoadFile(selectedFile);
                    isFileSelected = true;

                } else if (result == JFileChooser.CANCEL_OPTION){
                    return;
                }
            } catch (Exception xptn) {
                isFileSelected = false;
                JOptionPane.showMessageDialog(frame, "Error: " + xptn.getMessage());
            }
        } while (!isFileSelected);



        ImportSuccessDialog df = new ImportSuccessDialog(frame);
        df.setVisible(true);
    }

    // Reads the file, checks if format is valid while reading and if so, the sequence gets loaded iinto the system
    // if the file is not valid, a FileFormatError is raised!
    public static void validateAndLoadFile(File selectedFile) throws FileFormatError {
        try {
            // Creating a BufferedReader to read the file
            BufferedReader bufferedIN = new BufferedReader(new FileReader(selectedFile.getAbsolutePath()));
            String line;

            // takes the first line (the Header) & loop through BufferedReader lines as long as the end is not reached
            while ((line = bufferedIN.readLine()) != null) {

                // check if it is a valid FASTA header
                if (line.charAt(0) != '>') {
                        throw new FileFormatError();
                }

                // initialize new sequence object with just its header.
                DNASequences newSequence = new DNASequences(line.substring(1));

                // get the next line (aka the first line of the sequence)
                StringBuilder sequence = new StringBuilder();
                line = bufferedIN.readLine();
                while (!line.isEmpty()) {

                    //check if the line is a valid FASTA sequence
                    if (!line.matches("^[ATCGURYKMSWBDHVN-]*$")) {
                        throw new FileFormatError();
                    }

                    //append the line to the beforehand sequencelines
                    sequence.append(line);

                    // this part is to prevent a nullPointException for .isEmpty if line would be null i.e. the last
                    // line is reached. -> if line is null, break while loop
                    if ((line = bufferedIN.readLine()) == null) {
                        break;
                    }
                    // if the line would be empty, (aka a new Header is expected) jump back to outer while loop
                    // the outer loop grabs the next line, which is a new header and start all over.
                }

                // give the before initialized sequence its actual sequence.
                newSequence.setSequence(sequence.toString());
            }

            try {
                bufferedIN.close();
            } catch (Exception xptn){
                System.out.println(xptn.getMessage());
            }

            // TODO: remove Debug line
            for (String key : DNASequences.allSequences.keySet())
                System.out.println(key);

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
