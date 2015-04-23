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
public class CashEntityPK implements Serializable {
    private int cashId;
    private int transactionSubjectTransactionSubjectId;
    private int transactionSubjectTaxpayerTaxpayerId;

    @Column(name = "Cash_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getCashId() {
        return cashId;
    }

    public void setCashId(int cashId) {
        this.cashId = cashId;
    }

    @Column(name = "Transaction Subject_TransactionSubject_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTransactionSubjectTransactionSubjectId() {
        return transactionSubjectTransactionSubjectId;
    }

    public void setTransactionSubjectTransactionSubjectId(int transactionSubjectTransactionSubjectId) {
        this.transactionSubjectTransactionSubjectId = transactionSubjectTransactionSubjectId;
    }

    @Column(name = "Transaction Subject_Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTransactionSubjectTaxpayerTaxpayerId() {
        return transactionSubjectTaxpayerTaxpayerId;
    }

    public void setTransactionSubjectTaxpayerTaxpayerId(int transactionSubjectTaxpayerTaxpayerId) {
        this.transactionSubjectTaxpayerTaxpayerId = transactionSubjectTaxpayerTaxpayerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CashEntityPK that = (CashEntityPK) o;

        if (cashId != that.cashId) return false;
        if (transactionSubjectTaxpayerTaxpayerId != that.transactionSubjectTaxpayerTaxpayerId) return false;
        if (transactionSubjectTransactionSubjectId != that.transactionSubjectTransactionSubjectId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cashId;
        result = 31 * result + transactionSubjectTransactionSubjectId;
        result = 31 * result + transactionSubjectTaxpayerTaxpayerId;
        return result;
    }
}
