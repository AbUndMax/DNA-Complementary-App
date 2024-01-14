package DNAComplementApp.DNAListeners;

import DNAComplementApp.DNAHandlers.ComplementHandler;
import DNAComplementApp.DNAMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportDialogButtonListener implements ActionListener {

    private JDialog importDialog;
    public static Boolean isReverse = false;

    public ImportDialogButtonListener(JDialog importDialog) {
        this.importDialog = importDialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case "complementary":
                isReverse = false;
                ComplementHandler.getComplements();
                break;

            case "reverseComp":
                isReverse = true;
                ComplementHandler.getComplements();
                break;
        }

        DNAMain.newResultFrame();

        importDialog.dispose();
        DNAMain.mainFrame.dispose();
    }
}
