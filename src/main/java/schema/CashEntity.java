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
@Table(name = "Cash", schema = "", catalog = "Podatkova")
@IdClass(CashEntityPK.class)
public class CashEntity {
    private int cashId;
    private int mainId;
    private int transactionSubjectTransactionSubjectId;
    private int transactionSubjectTaxpayerTaxpayerId;

    @Id
    @Column(name = "Cash_id", nullable = false, insertable = true, updatable = true)
    public int getCashId() {
        return cashId;
    }

    public void setCashId(int cashId) {
        this.cashId = cashId;
    }

    @Basic
    @Column(name = "Main_id", nullable = false, insertable = true, updatable = true)
    public int getMainId() {
        return mainId;
    }

    public void setMainId(int mainId) {
        this.mainId = mainId;
    }

    @Id
    @Column(name = "Transaction Subject_TransactionSubject_id", nullable = false, insertable = true, updatable = true)
    public int getTransactionSubjectTransactionSubjectId() {
        return transactionSubjectTransactionSubjectId;
    }

    public void setTransactionSubjectTransactionSubjectId(int transactionSubjectTransactionSubjectId) {
        this.transactionSubjectTransactionSubjectId = transactionSubjectTransactionSubjectId;
    }

    @Id
    @Column(name = "Transaction Subject_Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
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

        CashEntity that = (CashEntity) o;

        if (cashId != that.cashId) return false;
        if (mainId != that.mainId) return false;
        if (transactionSubjectTaxpayerTaxpayerId != that.transactionSubjectTaxpayerTaxpayerId) return false;
        if (transactionSubjectTransactionSubjectId != that.transactionSubjectTransactionSubjectId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cashId;
        result = 31 * result + mainId;
        result = 31 * result + transactionSubjectTransactionSubjectId;
        result = 31 * result + transactionSubjectTaxpayerTaxpayerId;
        return result;
    }
}
