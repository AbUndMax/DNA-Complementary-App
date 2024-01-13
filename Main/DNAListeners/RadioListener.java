package DNAListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioListener implements ActionListener {

    // DNA is default (radiobutton dna is also selected by default)
    private static String sequenceType = "DNA";

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton source = (JRadioButton) e.getSource();

        switch(source.getText()) {
            case "DNA":
                sequenceType = "DNA";
                break;
            case "RNA":
                sequenceType = "RNA";
                break;
            // for future extension
            case "Protein":
                sequenceType = "Protein";
        }
    }

    public static Boolean isSequenceTypeDNA() {
        if(sequenceType.equals("DNA")) {
            return true;
        }
        return false;
    }

    public static Boolean isSequenceTypeRNA() {
        if(sequenceType.equals("RNA")) {
            return true;
        }
        return false;
    }

    public static Boolean isSequenceTypeProtein() {
        if(sequenceType.equals("Protein")) {
            return true;
        }
        return false;
    }
}
