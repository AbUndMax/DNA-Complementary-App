package DNAComplementApp.ResultFrame.Handlers;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

import static DNAComplementApp.ResultFrame.ResultFrame.textArea;

public class CopyHandler {

    // simply copies the currently shown complement in the textarea to the clipboard of the user.
    public static void handleCopy() {
        StringSelection stringSelection = new StringSelection(textArea.getText());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }
}
