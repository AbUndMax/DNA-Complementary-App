package DNAWindows;

import DNAListeners.ResultComboBoxListener;
import DNAListeners.ResultFrameButtonListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static DNAObjects.DNASequences.getAllSequenceNames;

public class ResultFrame extends JFrame {

    private static ResultFrameButtonListener buttonListener = new ResultFrameButtonListener();

    private static ResultComboBoxListener comboBoxListener = new ResultComboBoxListener();

    private static final JTextArea textArea = new JTextArea();
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

        add(Box.createVerticalStrut(10));

        add(drawTextArea());

        add(Box.createVerticalStrut(0));

        add(drawButtonPane());

        add(Box.createVerticalGlue());

    }

    private static JComboBox drawComboBox() {
        JComboBox comboBox = new JComboBox();
        for (String name : getAllSequenceNames()) {
            comboBox.addItem(name);
        }

        Dimension maxComboBoxDimension = comboBox.getMaximumSize();
        maxComboBoxDimension.height = comboBox.getPreferredSize().height;
        maxComboBoxDimension.width = 500;
        comboBox.setMaximumSize(maxComboBoxDimension);
        comboBox.addActionListener(comboBoxListener);

        return comboBox;
    }

    private static JPanel drawTextArea() {
        JPanel textPanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();

        textArea.setLineWrap(true);

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
