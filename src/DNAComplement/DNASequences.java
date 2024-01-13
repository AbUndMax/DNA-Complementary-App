package DNAComplement;

import java.util.HashMap;

public class DNASequences {

    private String header;

    private String sequence;

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
}
