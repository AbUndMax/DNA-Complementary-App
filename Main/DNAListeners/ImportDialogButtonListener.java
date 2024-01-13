package DNAListeners;

import DNAHandlers.ComplementHandler;
import DNAHandlers.ImportHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ImportDialogButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case "complementary":
                ComplementHandler.getComplements(false);
                break;

            case "reveresComp":
                ComplementHandler.getComplements(true);
                break;
        }
    }
}
