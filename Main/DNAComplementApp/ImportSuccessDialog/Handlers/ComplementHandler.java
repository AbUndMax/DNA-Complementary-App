package DNAComplementApp.ImportSuccessDialog.Handlers;

import DNAComplementApp.ObjectClasses.DNASequences;

import static DNAComplementApp.ImportFrame.Listeners.ImportSeqChooserCBoxListener.selectedSequences;
import static DNAComplementApp.ImportSuccessDialog.Listeners.ComplementButtonListeners.isReverse;
import static DNAComplementApp.ImportFrame.Listeners.SeqTypeRadioListener.isSequenceTypeDNA;
import static DNAComplementApp.ObjectClasses.DNASequences.allSequences;

public class ComplementHandler {

    // All allowed letters for nucleotides with its complementary in FASTA
    private static final char[][] complementaryDNAArray = {{'A', 'T'}, {'T', 'A'}, {'C', 'G'}, {'G', 'C'},
            {'R', 'Y'}, {'Y', 'R'}, {'K', 'M'}, {'M', 'K'}, {'W', 'W'}, {'S', 'S'}, {'B', 'V'}, {'V', 'B'},
            {'D', 'H'}, {'H', 'D'}, {'N', 'N'}, {'-', '-'}};

    // Yeah, do u find the difference? ¯\_(ツ)_/¯
    private static final char[][] complementaryRNAArray = {{'A', 'U'}, {'U', 'A'}, {'C', 'G'}, {'G', 'C'},
            {'R', 'Y'}, {'Y', 'R'}, {'K', 'M'}, {'M', 'K'}, {'W', 'W'}, {'S', 'S'}, {'B', 'V'}, {'V', 'B'},
            {'D', 'H'}, {'H', 'D'}, {'N', 'N'}, {'-', '-'}};

    // sets all complements to its corresponding DNASequence Object as its Complement Attribute
    public static void getComplements() {

        // for all selected sequences the complementary is generated
        for (String sequenceName : selectedSequences) {
            // get the corresponding Sequence in the DNASequences Objects
            DNASequences currentSequence = allSequences.get(sequenceName);

            // call the generateComplementary function on the current Object Sequence
            String complement = generateComplementary(currentSequence.getSequence(), isReverse);

            // set attribute accordingly
            currentSequence.setComplement(complement);
        }
    }

    // this is the actual function which generates the Complements!
    public static String generateComplementary(String sequence, Boolean isReverse) {
        StringBuilder complement = new StringBuilder();

        char[][] nucleotideComplementArray = new char[complementaryDNAArray.length][2];

        // decide rather to use RNA or DNA complements based on RadioButtons
        if (isSequenceTypeDNA) {
            nucleotideComplementArray = complementaryDNAArray;
        }
        else {
            nucleotideComplementArray = complementaryRNAArray;
        }

        // outer for loop, loops through each nucleotide in input sequence
        for (int i = 0; i <= sequence.length() - 1; i++) {
            char currentNucleotide = sequence.charAt(i);

            // inner for loop, loops through the complementary Array and if it has a hit, it appends the complement nucleotide
            // to the complement String.
            for (char[] nucleotidePair : nucleotideComplementArray) {
                if (currentNucleotide == nucleotidePair[0]) {
                    complement.append(nucleotidePair[1]);
                }
            }
        }

        if (isReverse) {
            return complement.reverse().toString();
        } else {
            return complement.toString();
        }
    }
}