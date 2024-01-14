package DNAComplementApp.DNAWindows;

import DNAComplementApp.DNAListeners.ImportComboBoxListener;
import DNAComplementApp.DNAListeners.ImportDialogButtonListener;
import DNAComplementApp.DNAMain;

import javax.swing.*;
import java.awt.*;

import static DNAComplementApp.DNAListeners.ImportComboBoxListener.selectedItems;
import static DNAComplementApp.DNAObjects.DNASequences.getAllSequenceNames;

public class ImportSuccessDialog extends JDialog {

    private ImportDialogButtonListener buttonListener = new ImportDialogButtonListener(this);
    private ImportComboBoxListener comboBoxListener = new ImportComboBoxListener();
    public static JComboBox<String> comboBox = new JComboBox<>();

    private BoxLayout boxYLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
    private static final JLabel successConfirmation = new JLabel();
    private static final JLabel information = new JLabel();


    public ImportSuccessDialog() {
        super(DNAMain.mainFrame, "Import success", true);
        setSize(new Dimension(450, 250));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(boxYLayout);

        add(Box.createVerticalGlue());

        successConfirmation.setText("Import successful!");
        successConfirmation.setFont(new Font(successConfirmation.getFont().getName(), successConfirmation.getFont().BOLD, 15));
        successConfirmation.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(successConfirmation);

        add(Box.createVerticalStrut(30));

        add(drawSequenceChooser());

        add(Box.createVerticalStrut(30));

        add(drawComplementButtons());

        add(Box.createVerticalGlue());

    }

    private JPanel drawSequenceChooser () {
        JPanel sequenceChooserPane = new JPanel();
        BoxLayout scPaneBoxLayout = new BoxLayout(sequenceChooserPane, BoxLayout.Y_AXIS);

        // add comboBox Items
        comboBox.addItem("All");
        for (String name : getAllSequenceNames()) {
            comboBox.addItem(name);
        }

        // set default select for the comboBox which is "All"
        selectedItems = getAllSequenceNames();

        Dimension maxComboBoxDimension = comboBox.getMaximumSize();
        maxComboBoxDimension.height = comboBox.getPreferredSize().height;
        maxComboBoxDimension.width = 360;
        comboBox.setMaximumSize(maxComboBoxDimension);
        comboBox.addActionListener(comboBoxListener);

        information.setText("choose the sequence you want the complementary of:");
        information.setAlignmentX(Component.CENTER_ALIGNMENT);


        sequenceChooserPane.setLayout(scPaneBoxLayout);
        sequenceChooserPane.add(information);
        sequenceChooserPane.add(Box.createVerticalStrut(5));
        sequenceChooserPane.add(comboBox);

        return sequenceChooserPane;
    }

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

        complementaryButton.setPreferredSize(new Dimension(130, 50));
        Font currentCompFont = complementaryButton.getFont();
        complementaryButton.setFont(new Font(complementaryButton.getName(), currentCompFont.BOLD, 12));
        reverseComplementaryButton.setPreferredSize(new Dimension(130, 50));
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
