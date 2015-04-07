package wrappers;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class Decree {

    private String text;
    private String signaturedByWho;
    private long regiastrationNumber;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSignaturedByWho() {
        return signaturedByWho;
    }

    public void setSignaturedByWho(String signaturedByWho) {
        this.signaturedByWho = signaturedByWho;
    }

    public long getRegiastrationNumber() {
        return regiastrationNumber;
    }

    public void setRegiastrationNumber(long regiastrationNumber) {
        this.regiastrationNumber = regiastrationNumber;
    }

    public Decree() {
        text = "";
        signaturedByWho = "";
        regiastrationNumber = 0;
    }

    public Decree(String text, String signaturedByWho, long regiastrationNumber) {
        this.text = text;
        this.signaturedByWho = signaturedByWho;
        this.regiastrationNumber = regiastrationNumber;
    }
}
