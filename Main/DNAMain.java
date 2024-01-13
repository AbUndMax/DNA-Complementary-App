import DNAWindows.DNAMainFrame;
import DNAWindows.ResultFrame;

public class DNAMain {

    public static void main(String[] args) {
        DNAMainFrame mf = new DNAMainFrame();
        mf.setVisible(false);

        ResultFrame rf = new ResultFrame();
        rf.setVisible(true);

    }
}
