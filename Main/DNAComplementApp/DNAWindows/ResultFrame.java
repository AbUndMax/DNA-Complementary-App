package DNAComplementApp.DNAWindows;

import DNAComplementApp.DNAListeners.ResultComboBoxListener;
import DNAComplementApp.DNAListeners.ResultFrameButtonListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;

import static DNAComplementApp.DNAListeners.ImportComboBoxListener.selectedItems;
import static DNAComplementApp.DNAListeners.ImportDialogButtonListener.isReverse;
import static DNAComplementApp.DNAObjects.DNASequences.allSequences;
import static DNAComplementApp.DNAObjects.DNASequences.getAllSequenceNames;

public class ResultFrame extends JFrame {

    private static ResultFrameButtonListener buttonListener = new ResultFrameButtonListener();

    private static ResultComboBoxListener comboBoxListener = new ResultComboBoxListener();

    public static JComboBox comboBox = new JComboBox();

    public static final JTextArea textArea = new JTextArea();
    private static final JScrollPane scrollPane = new JScrollPane();
    private BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS );
    public ResultFrame() {
        setTitle("DNA-Complement-Generator");
        setLayout(boxLayout);
        setSize(600, 500);
        setMinimumSize(new Dimension(400, 400));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(Box.createVerticalStrut(15));

        add(drawComboBox());

        add(Box.createVerticalStrut(0));

        add(drawTextArea());

        add(Box.createVerticalStrut(0));

        add(drawButtonPane());

        add(Box.createVerticalGlue());

    }

    private static JPanel drawComboBox() {
        JPanel combBoxPane = new JPanel();
        BoxLayout boxLayout = new BoxLayout(combBoxPane, BoxLayout.X_AXIS);
        combBoxPane.setLayout(boxLayout);
        combBoxPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton newImport = new JButton("new Import");
        newImport.setAlignmentX(Component.RIGHT_ALIGNMENT);

        newImport.setActionCommand("new import");
        newImport.addActionListener(buttonListener);

        for (String name : selectedItems) {
            comboBox.addItem(name);
        }

        Dimension preferredComboBoxDimension = new Dimension(400, comboBox.getPreferredSize().height);
        comboBox.setPreferredSize(preferredComboBoxDimension);
        Dimension minimumComboBoxDimension = new Dimension(100, comboBox.getPreferredSize().height);
        comboBox.setMinimumSize(minimumComboBoxDimension);
        comboBox.addActionListener(comboBoxListener);

        combBoxPane.add(comboBox);
        combBoxPane.add(newImport);

        return combBoxPane;
    }

    private static JPanel drawTextArea() {
        JPanel textPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();

        textArea.setLineWrap(true);
        textArea.setEditable(false);
        //load default

        if (isReverse) {
            textArea.setText(allSequences.get(selectedItems[0]).getReverseComplement());
        } else {
            textArea.setText(allSequences.get(selectedItems[0]).getComplement());
        }

        scrollPane.setViewportView(textArea);

        textPanel.setLayout(new BorderLayout());
        textPanel.setBorder(new EmptyBorder(0, 10, 0, 10));
        textPanel.add(scrollPane, BorderLayout.CENTER);

        return textPanel;
    }

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
