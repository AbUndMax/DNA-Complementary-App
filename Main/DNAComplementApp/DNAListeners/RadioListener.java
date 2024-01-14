package DNAComplementApp.DNAListeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioListener implements ActionListener {

    // DNA is default (radiobutton dna is also selected by default)
    public static Boolean isSequenceTypeDNA = true;
    public static Boolean isSequenceTypeRNA = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton source = (JRadioButton) e.getSource();

        switch(source.getText()) {
            case "DNA":
                isSequenceTypeDNA = true;
                isSequenceTypeRNA = false;
                break;
            case "RNA":
                isSequenceTypeDNA = false;
                isSequenceTypeRNA = true;
                break;
        }
    }
}
