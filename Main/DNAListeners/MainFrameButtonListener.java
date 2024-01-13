package DNAListeners;

import DNAWindows.DNAMainFrame;
import DNAHandlers.ImportHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameButtonListener implements ActionListener {

    private DNAMainFrame frame;

    public MainFrameButtonListener(DNAMainFrame frame) {
        this.frame  = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case "import":
                ImportHandler.handleImport(frame);
                break;
        }
    }
}
