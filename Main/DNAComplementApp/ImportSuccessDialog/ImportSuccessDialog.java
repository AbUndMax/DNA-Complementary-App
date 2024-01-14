package DNAComplementApp.ImportSuccessDialog;

import DNAComplementApp.ImportFrame.Listeners.ImportSeqChooserCBoxListener;
import DNAComplementApp.ImportSuccessDialog.Listeners.ComplementButtonListeners;
import DNAComplementApp.Main;

import javax.swing.*;
import java.awt.*;

import static DNAComplementApp.ImportFrame.Listeners.ImportSeqChooserCBoxListener.selectedSequences;
import static DNAComplementApp.ObjectClasses.DNASequences.getAllSequenceNames;

public class ImportSuccessDialog extends JDialog {

    private static final ComplementButtonListeners buttonListener = new ComplementButtonListeners();
    private static final ImportSeqChooserCBoxListener comboBoxListener = new ImportSeqChooserCBoxListener();
    public static JComboBox<String> importSequenceChooserCB = new JComboBox<>();

    private BoxLayout boxYLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);


    public ImportSuccessDialog() {
        super(Main.mainFrame, "Import success", true);
        setSize(new Dimension(450, 250));
        setResizable(false);
        setLocationRelativeTo(Main.mainFrame);
        setLayout(boxYLayout);

        add(Box.createVerticalGlue());
        add(drawSuccessMessage());
        add(Box.createVerticalStrut(30));
        add(drawSequenceChooser());
        add(Box.createVerticalStrut(30));
        add(drawComplementButtons());
        add(Box.createVerticalGlue());

    }

    // simple success message
    private JLabel drawSuccessMessage() {
        JLabel successConfirmation = new JLabel();
        successConfirmation.setText("Import successful!");
        successConfirmation.setFont(new Font(successConfirmation.getFont().getName(), successConfirmation.getFont().BOLD, 15));
        successConfirmation.setAlignmentX(Component.CENTER_ALIGNMENT);

        return successConfirmation;
    }

    // Chooser for which Sequence found in the FASTA file a complement is to be generated
    private JPanel drawSequenceChooser () {
        JPanel sequenceChooserPane = new JPanel();
        BoxLayout scPaneBoxLayout = new BoxLayout(sequenceChooserPane, BoxLayout.Y_AXIS);
        JLabel information = new JLabel();

        // add comboBox Items
        importSequenceChooserCB.addItem("All");
        for (String name : getAllSequenceNames()) {
            importSequenceChooserCB.addItem(name);
        }

        // set default select for the comboBox which is "All"
        selectedSequences = getAllSequenceNames();

        Dimension maxComboBoxDimension = importSequenceChooserCB.getMaximumSize();
        maxComboBoxDimension.height = importSequenceChooserCB.getPreferredSize().height;
        maxComboBoxDimension.width = 360;
        importSequenceChooserCB.setMaximumSize(maxComboBoxDimension);
        importSequenceChooserCB.addActionListener(comboBoxListener);

        information.setText("choose the sequence you want the complementary of:");
        information.setAlignmentX(Component.CENTER_ALIGNMENT);

        sequenceChooserPane.setLayout(scPaneBoxLayout);
        sequenceChooserPane.add(information);
        sequenceChooserPane.add(Box.createVerticalStrut(5));
        sequenceChooserPane.add(importSequenceChooserCB);

        return sequenceChooserPane;
    }

    // Buttons for choosing rather to get the complements or reverse Complements
    private JPanel drawComplementButtons() {
        JPanel buttonPane = new JPanel();
        BoxLayout buttPaneBoxLayout = new BoxLayout(buttonPane, BoxLayout.X_AXIS);
        buttonPane.setLayout(buttPaneBoxLayout);

        JButton complementaryButton = new JButton("complementary");
        JButton reverseComplementaryButton = new JButton("<html><center>reverse<br>complementary</html>");

        complementaryButton.setActionCommand("complementary");
        reverseComplementaryButton.setActionCommand("reverseComp");

        complementaryButton.addActionListener(buttonListener);
        reverseComplementaryButton.addActionListener(buttonListener);

        Dimension buttonSize = new Dimension(130, 50);
        complementaryButton.setPreferredSize(buttonSize);
        complementaryButton.setMinimumSize(buttonSize);
        complementaryButton.setMaximumSize(buttonSize);

        reverseComplementaryButton.setPreferredSize(buttonSize);
        reverseComplementaryButton.setMinimumSize(buttonSize);
        reverseComplementaryButton.setMaximumSize(buttonSize);

        Font currentCompFont = complementaryButton.getFont();
        complementaryButton.setFont(new Font(complementaryButton.getName(), currentCompFont.BOLD, 12));
        Font currentRevFont = complementaryButton.getFont();
        reverseComplementaryButton.setFont(new Font(complementaryButton.getName(), currentRevFont.BOLD, 12));

        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(complementaryButton);
        buttonPane.add(Box.createHorizontalStrut(80));
        buttonPane.add(reverseComplementaryButton);
        buttonPane.add(Box.createHorizontalGlue());

        buttonPane.setMaximumSize(buttonPane.getPreferredSize());

        return buttonPane;
    }


}
