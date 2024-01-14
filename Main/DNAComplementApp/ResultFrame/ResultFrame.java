package DNAComplementApp.ResultFrame;

import DNAComplementApp.ResultFrame.Listeners.ResultSeqChooserCBListener;
import DNAComplementApp.ResultFrame.Listeners.ResultFrameButtonListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static DNAComplementApp.ImportFrame.Listeners.ImportSeqChooserCBoxListener.selectedSequences;
import static DNAComplementApp.ObjectClasses.DNASequences.allSequences;

public class ResultFrame extends JFrame {

    private static final ResultFrameButtonListener buttonListener = new ResultFrameButtonListener();
    private static final ResultSeqChooserCBListener comboBoxListener = new ResultSeqChooserCBListener();

    public static JComboBox resultSequenceChooserCB = new JComboBox();

    public static JTextArea textArea = new JTextArea();
    private BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS );

    public ResultFrame() {
        setTitle("DNA-Complement-Generator");
        setLayout(boxLayout);
        setSize(600, 500);
        setMinimumSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(Box.createVerticalStrut(0));
        add(drawComboBox());
        add(Box.createVerticalStrut(0));
        add(drawTextArea());
        add(Box.createVerticalStrut(0));
        add(drawButtonPane());
        add(Box.createVerticalGlue());

    }

    // Choose which Sequence should be shown
    private static JPanel drawComboBox() {
        JPanel combBoxPane = new JPanel();
        BoxLayout boxLayout = new BoxLayout(combBoxPane, BoxLayout.X_AXIS);
        combBoxPane.setLayout(boxLayout);
        combBoxPane.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));

        resultSequenceChooserCB.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton newImport = new JButton("new Import");
        newImport.setAlignmentX(Component.RIGHT_ALIGNMENT);

        newImport.setActionCommand("new import");
        newImport.addActionListener(buttonListener);

        for (String name : selectedSequences) {
            resultSequenceChooserCB.addItem(name);
        }

        Dimension preferredComboBoxDimension = new Dimension(400, resultSequenceChooserCB.getPreferredSize().height);
        resultSequenceChooserCB.setPreferredSize(preferredComboBoxDimension);
        Dimension minimumComboBoxDimension = new Dimension(100, resultSequenceChooserCB.getPreferredSize().height);
        resultSequenceChooserCB.setMinimumSize(minimumComboBoxDimension);
        resultSequenceChooserCB.addActionListener(comboBoxListener);

        combBoxPane.add(resultSequenceChooserCB);
        combBoxPane.add(newImport);

        return combBoxPane;
    }

    // actual Area which shows the complement
    private static JPanel drawTextArea() {
        JPanel textPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();

        textArea.setLineWrap(true);
        textArea.setEditable(false);

        // load default (which is the first element in the picked sequences)
        textArea.setText(allSequences.get(selectedSequences[0]).getComplement());

        scrollPane.setViewportView(textArea);

        textPanel.setLayout(new BorderLayout());
        textPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
        textPanel.add(scrollPane, BorderLayout.CENTER);

        return textPanel;
    }

    // buttons for easy copy or even saving all Complements to new FASTA file
    private static JPanel drawButtonPane() {
        JPanel buttonPane = new JPanel();
        JButton copyButton = new JButton("copy");
        JButton saveButton = new JButton("save");

        BoxLayout boxLayout = new BoxLayout(buttonPane, BoxLayout.X_AXIS);
        buttonPane.setLayout(boxLayout);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        copyButton.setActionCommand("copy");
        saveButton.setActionCommand("save");

        copyButton.addActionListener(buttonListener);
        saveButton.addActionListener(buttonListener);

        Dimension buttonSize = new Dimension(130, 50);

        copyButton.setPreferredSize(buttonSize);
        copyButton.setMinimumSize(buttonSize);
        copyButton.setMaximumSize(buttonSize);

        saveButton.setPreferredSize(buttonSize);
        saveButton.setMinimumSize(buttonSize);
        saveButton.setMaximumSize(buttonSize);

        Font currentCompFont = copyButton.getFont();
        copyButton.setFont(new Font(copyButton.getName(), currentCompFont.BOLD, 14));
        Font currentRevFont = copyButton.getFont();
        saveButton.setFont(new Font(copyButton.getName(), currentRevFont.BOLD, 14));

        buttonPane.add(copyButton);
        buttonPane.add(Box.createHorizontalGlue());
        buttonPane.add(saveButton);


        return buttonPane;
    }
}
