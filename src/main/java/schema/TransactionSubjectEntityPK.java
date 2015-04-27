package schema;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 12.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public class TransactionSubjectEntityPK implements Serializable {
    private int transactionSubjectId;
    private int taxpayerTaxpayerId;

    @Column(name = "TransactionSubject_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTransactionSubjectId() {
        return transactionSubjectId;
    }

    public void setTransactionSubjectId(int transactionSubjectId) {
        this.transactionSubjectId = transactionSubjectId;
    }

    @Column(name = "Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    @Id
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

        TransactionSubjectEntityPK that = (TransactionSubjectEntityPK) o;

        if (taxpayerTaxpayerId != that.taxpayerTaxpayerId) return false;
        if (transactionSubjectId != that.transactionSubjectId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = transactionSubjectId;
        result = 31 * result + taxpayerTaxpayerId;
        return result;
    }
}
