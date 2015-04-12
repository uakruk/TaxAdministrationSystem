package schema;

import javax.persistence.*;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 12.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
@Entity
@Table(name = "TransactionSubject", schema = "", catalog = "Podatkova")
@IdClass(TransactionSubjectEntityPK.class)
public class TransactionSubjectEntity {
    private int transactionSubjectId;
    private String name;
    private String adress;
    private int taxpayerTaxpayerId;

    @Id
    @Column(name = "TransactionSubject_id", nullable = false, insertable = true, updatable = true)
    public int getTransactionSubjectId() {
        return transactionSubjectId;
    }

    public void setTransactionSubjectId(int transactionSubjectId) {
        this.transactionSubjectId = transactionSubjectId;
    }

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Adress", nullable = false, insertable = true, updatable = true, length = 70)
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Id
    @Column(name = "Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    public int getTaxpayerTaxpayerId() {
        return taxpayerTaxpayerId;
    }

    public void setTaxpayerTaxpayerId(int taxpayerTaxpayerId) {
        this.taxpayerTaxpayerId = taxpayerTaxpayerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionSubjectEntity that = (TransactionSubjectEntity) o;

        if (taxpayerTaxpayerId != that.taxpayerTaxpayerId) return false;
        if (transactionSubjectId != that.transactionSubjectId) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionSubjectId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + taxpayerTaxpayerId;
        return result;
    }
}
