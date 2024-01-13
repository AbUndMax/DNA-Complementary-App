package DNAListeners;

import DNAFrames.DNAMainFrame;
import DNAHandlers.ImportHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private DNAMainFrame frame;

    public ButtonListener(DNAMainFrame frame) {
        this.frame  = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case "import":
                ImportHandler.handleImport(frame);
                break;

            case "reverseC":

                break;

            case "complement":

                break;

            case "copy":

                break;

            case "save":

                break;
        }
    }
}
