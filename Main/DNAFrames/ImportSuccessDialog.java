package DNAFrames;

import DNAObjects.DNASequences;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

public class ImportSuccessDialog extends JDialog {

    private BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
    private static final JLabel successConfirmation = new JLabel();
    private static final JPanel RadioPane = new JPanel();
    private static final JRadioButton dna = new JRadioButton();
    private static final JRadioButton rna = new JRadioButton();
    private static final JPanel comboPane = new JPanel();
    private static final JPanel ButtonPane = new JPanel();
    private static JButton complementary = new JButton();
    private static JButton reverseComplementary = new JButton();

    private Set<String> sequenceNames = DNASequences.allSequences.keySet();



    public ImportSuccessDialog(Frame owner) {
        super(owner, "Import succes", true);
        setSize(new Dimension(300, 200));
        setLocationRelativeTo(null);
        setLayout(boxLayout);



        // generate the Array for the ComboBox
        String[] comboBoxList = new String[sequenceNames.size() + 2];
        comboBoxList[0] = "Select sequence";
        comboBoxList[comboBoxList.length - 1] = "All";

        int i = 1;
        for (String name : sequenceNames) {
            comboBoxList[i++] = name;
        }

        JComboBox<String> comboBox = new JComboBox<>(comboBoxList);
        add(comboBox);


    }
}
