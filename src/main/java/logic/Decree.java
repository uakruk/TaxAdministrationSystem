package logic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
@Table(name="decree")
public class Decree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long decree_id;
    @Column(name = "text")
    private String text;
    @Column(name = "signatureByWho")
    private String signaturedByWho;
    @Column(name = "registrationNumber")
    private long regiastrationNumber;

    @OneToMany(mappedBy = "decree")
    private Collection<Referral> referrals = new ArrayList<Referral>();

    public Long getDecree_id() {
        return decree_id;
    }

    public void setDecree_id(Long decree_id) {
        this.decree_id = decree_id;
    }

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

    public Collection<Referral> getReferrals() {
        return referrals;
    }

    public void setReferrals(Collection<Referral> referrals) {
        this.referrals = referrals;
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