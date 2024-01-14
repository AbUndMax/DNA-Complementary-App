package DNAComplementApp.ObjectClasses;

import java.util.HashMap;

// in this class all Sequences are saved as an Object

public class DNASequences {

    private String header;
    private String sequence;
    // we only use the complement attribute also for the reverse Complement since the App
    // is designed in a way, where only the reverse complement or the complement is used
    private String complement;

    public static HashMap<String, DNASequences> allSequences = new HashMap<>();

    public DNASequences(String header) {
        this.header = header;

        allSequences.put(header, this);
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public static String[] getAllSequenceNames() {
        return allSequences.keySet().toArray(new String[0]);
    }

    // cleaner method to erase all generated objects by setting everything to null (ready for garbage collector)
    public void cleanObject() {
        header = null;
        sequence = null;
        complement = null;
    }
}
