package DNAHandlers;

import DNAObjects.DNASequences;

import static DNAListeners.ComboBoxListener.selectedItems;
import static DNAListeners.RadioListener.isSequenceTypeDNA;
import static DNAListeners.RadioListener.isSequenceTypeRNA;
import static DNAObjects.DNASequences.allSequences;

public class ComplementHandler {

    // Achtung
    private static final char[][] complementaryDNAArray = {{'A', 'T'}, {'C', 'G'}, {'R', 'Y'}, {'K', 'M'}, {'W', 'W'}, {'S', 'S'}, {'B', 'V'}, {'D', 'H'}, {'N', 'N'}, {'-', '-'}};
    private static final char[][] complementaryRNAArray = {{'A', 'U'}, {'C', 'G'}, {'R', 'Y'}, {'K', 'M'}, {'W', 'W'}, {'S', 'S'}, {'B', 'V'}, {'D', 'H'}, {'N', 'N'}, {'-', '-'}};

    public static void getComplements(Boolean isReverse) {

        int i = 0;
        for (String sequenceName : selectedItems) {
            DNASequences currentSequence = allSequences.get(sequenceName);

            String complement = generateComplementary(currentSequence.getSequence(), isReverse);

            if (isReverse) {
                currentSequence.setReverseComplement(complement);
            } else {
                currentSequence.setComplement(complement);
            }
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
        else if (isSequenceTypeRNA) {
            nucleotideComplementArray = complementaryRNAArray;
        }

        // outer for loops though each nucleotide in input sequence
        for (int i = 0; i <= sequence.length() - 1; i++) {
            char currentNucleotide = sequence.charAt(i);

            // inner for loops through the complementary Array and if it has a hit, it appends the complement nucleotide
            // to the complement String.
            for (char[] nucleotidePair : nucleotideComplementArray) {
                if (currentNucleotide == nucleotidePair[0]) {
                    complement.append(nucleotidePair[1]);
                }
                else if (currentNucleotide == nucleotidePair[1]) {
                    complement.append(nucleotidePair[0]);
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