package DNAComplementApp.ImportFrame.Listeners;

import DNAComplementApp.ImportFrame.Handlers.ImportHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportButtonListener implements ActionListener {

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
