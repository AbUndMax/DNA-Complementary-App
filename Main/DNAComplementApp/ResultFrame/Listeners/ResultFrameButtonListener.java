package DNAComplementApp.ResultFrame.Listeners;

import DNAComplementApp.ResultFrame.Handlers.CopyHandler;
import DNAComplementApp.ResultFrame.Handlers.NewImportHandler;
import DNAComplementApp.ResultFrame.Handlers.SaveHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultFrameButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case "copy":
                CopyHandler.handleCopy();
                break;

            case "save":
                SaveHandler.handleSave();
                break;

            case "new import":
                NewImportHandler.handleNewImport();
                break;
        }
    }
}
