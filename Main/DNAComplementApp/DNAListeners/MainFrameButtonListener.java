package DNAComplementApp.DNAListeners;

import DNAComplementApp.DNAMain;
import DNAComplementApp.DNAWindows.DNAMainFrame;
import DNAComplementApp.DNAHandlers.ImportHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case "import":
                ImportHandler.handleImport();
                break;
        }
    }
}
