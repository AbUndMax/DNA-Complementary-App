package DNAComplementApp;

import DNAComplementApp.DNAWindows.DNAMainFrame;
import DNAComplementApp.DNAWindows.ImportSuccessDialog;
import DNAComplementApp.DNAWindows.ResultFrame;

import javax.swing.*;

public class DNAMain {

    public static DNAMainFrame mainFrame;
    public static ImportSuccessDialog importDialog;
    public static ResultFrame resultFrame;

    public static void main(String[] args) {
        newMainFrame();
    }

    public static void newMainFrame() {
        DNAMainFrame mf = new DNAMainFrame();
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
