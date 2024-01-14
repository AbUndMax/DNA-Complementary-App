package DNAComplementApp.ImportSuccessDialog.Listeners;

import DNAComplementApp.ImportSuccessDialog.Handlers.ComplementHandler;
import DNAComplementApp.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComplementButtonListeners implements ActionListener {

    public static Boolean isReverse = false;

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

        Main.newResultFrame();

        Main.importDialog.dispose();
        Main.mainFrame.dispose();
    }
}
