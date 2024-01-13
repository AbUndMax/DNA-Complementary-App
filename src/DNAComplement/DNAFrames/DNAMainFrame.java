package DNAComplement.DNAFrames;

import DNAComplement.DNAListeners.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class DNAMainFrame extends JFrame {

    private ButtonListener buttonListener = new ButtonListener(this);

    private BoxLayout boxL = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);

    private static final JDialog importSuccessDialog = new JDialog();
    private static final JPanel importSuccessButtonPane = new JPanel();
    private static final JPanel resultPane = new JPanel();
    private static final JPanel resultButtonsPane = new JPanel();

    public DNAMainFrame() {
        setTitle("DNA-Complement-Generator");
        setLayout(boxL);
        setSize(500, 300);
        setMinimumSize(new Dimension(300, 100));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(Box.createVerticalGlue());

        // create an import button which allows to import a FASTA-File
        JButton button = new JButton("Import FASTA-File");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setActionCommand("import");
        button.addActionListener(buttonListener);
        button.setPreferredSize(new Dimension(120, 40));
        Font currentFont = button.getFont();
        button.setFont(new Font(currentFont.getName(), currentFont.BOLD, 15));
        add(button);

        add(Box.createVerticalGlue());

        ImportSuccessDialog df = new ImportSuccessDialog(this);
        df.setVisible(true);





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


}