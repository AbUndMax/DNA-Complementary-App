package DNAListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultFrameButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch(command) {
            case "copy":

                break;

            case "save":

                break;
        }
    }
}
