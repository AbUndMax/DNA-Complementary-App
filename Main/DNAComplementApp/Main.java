package DNAComplementApp;

import DNAComplementApp.ImportFrame.ImportFrame;
import DNAComplementApp.ImportSuccessDialog.ImportSuccessDialog;
import DNAComplementApp.ResultFrame.ResultFrame;

// The Main Class is used to get access on the specific Frame instances without mixing them up in the other classes!

public class Main {

    public static ImportFrame mainFrame;
    public static ImportSuccessDialog importDialog;
    public static ResultFrame resultFrame;

    public static void main(String[] args) {
        newMainFrame();
    }

    public static void newMainFrame() {
        ImportFrame mf = new ImportFrame();
        mainFrame = mf;
        mf.setVisible(true);
    }

    public static void newImportDialog() {
        ImportSuccessDialog id = new ImportSuccessDialog();
        importDialog = id;
        id.setVisible(true);
    }

    public static void newResultFrame() {
        ResultFrame rf = new ResultFrame();
        resultFrame = rf;
        rf.setVisible(true);
    }
}
