package DNAComplementApp.DNAObjects;

import java.util.HashMap;

public class DNASequences {

    private String header;
    private String sequence;
    private String complement;
    private String reverseComplement;

    public static HashMap<String, DNASequences> allSequences = new HashMap<>();

    public DNASequences(String header) {
        this.header = header;

        allSequences.put(header, this);
    }

    public DNASequences(String header, String sequence) {
        this.header = header;
        this.sequence = sequence;

        allSequences.put(header, this);
    }


    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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

    public String getReverseComplement() {
        return reverseComplement;
    }

    public void setReverseComplement(String reverseComplement) {
        this.reverseComplement = reverseComplement;
    }

    public static String[] getAllSequenceNames() {
        return allSequences.keySet().toArray(new String[0]);
    }

    public void cleanObject() {
        header = null;
        sequence = null;
        complement = null;
        reverseComplement = null;
    }
}
