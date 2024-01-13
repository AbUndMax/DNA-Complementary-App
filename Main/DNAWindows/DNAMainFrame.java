package DNAWindows;

import DNAListeners.MainFrameButtonListener;
import DNAListeners.RadioListener;

import javax.swing.*;
import java.awt.*;

public class DNAMainFrame extends JFrame {

    private MainFrameButtonListener buttonListener = new MainFrameButtonListener(this);
    private RadioListener radioListener = new RadioListener();

    private BoxLayout boxLayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);

    public static final JRadioButton dna = new JRadioButton("DNA");
    public static final JRadioButton rna = new JRadioButton("RNA");


    public DNAMainFrame() {
        setTitle("DNA-Complement-Generator");
        setLayout(boxLayout);
        setSize(500, 300);
        setMinimumSize(new Dimension(300, 150));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        add(Box.createVerticalGlue());

        add(drawImportButton());

        add(Box.createVerticalStrut(10));

        add(drawRadioButton());

        add(Box.createVerticalGlue());

    }

    private JButton createButton(String name){
        JButton button = new JButton();
        Font currentFont = button.getFont();
        Font newFont = new Font(currentFont.getName(), currentFont.BOLD, 20);
        button.setText(name);
        button.setActionCommand(name);
        button.addActionListener(buttonListener);
        button.setFont(newFont);

        return button;
    }

    private JButton drawImportButton() {
        // create an import button which allows to import a FASTA-File
        JButton button = new JButton("Import FASTA-File");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand("import");
        button.addActionListener(buttonListener);
        button.setPreferredSize(new Dimension(120, 40));
        Font currentFont = button.getFont();
        button.setFont(new Font(currentFont.getName(), currentFont.BOLD, 15));

        return button;
    }

    private JPanel drawRadioButton(){
        JPanel RadioPane = new JPanel();
        BoxLayout RadioBoxLayout = new BoxLayout(RadioPane, BoxLayout.X_AXIS);

        dna.setActionCommand("DNA");
        rna.setActionCommand("RNA");

        dna.addActionListener(radioListener);
        rna.addActionListener(radioListener);

        ButtonGroup group = new ButtonGroup();
        group.add(dna);
        group.add(rna);

        RadioPane.setLayout(RadioBoxLayout);
        RadioPane.add(Box.createHorizontalGlue());
        RadioPane.add(dna);
        RadioPane.add(Box.createHorizontalStrut(40));
        RadioPane.add(rna);
        RadioPane.add(Box.createHorizontalGlue());

        dna.setSelected(true);

        RadioPane.setMaximumSize(RadioPane.getMinimumSize());

        return RadioPane;
    }
}