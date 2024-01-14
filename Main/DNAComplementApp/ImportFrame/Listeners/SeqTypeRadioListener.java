package DNAComplementApp.ImportFrame.Listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeqTypeRadioListener implements ActionListener {

    // DNA is default (radiobutton dna is also selected by default)
    public static Boolean isSequenceTypeDNA = true;

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton source = (JRadioButton) e.getSource();

        switch(source.getText()) {
            case "DNA":
                isSequenceTypeDNA = true;
                break;
            case "RNA":
                isSequenceTypeDNA = false;
                break;
        }
    }
}
