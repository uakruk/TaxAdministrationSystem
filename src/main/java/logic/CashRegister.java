package logic;

import javax.persistence.*;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
@Table(name="CashRegister")
public class CashRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cashRegister_id;

    @Column(name = "ID")
    private long ID;

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="objectOfTaxation_id")
    private ObjectOfTaxation objectOfTaxation;

    public Long getCashRegister_id() {
        return cashRegister_id;
    }

    public void setCashRegister_id(Long cashRegister_id) {
        this.cashRegister_id = cashRegister_id;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public ObjectOfTaxation getObjectOfTaxation() {
        return objectOfTaxation;
    }

    public void setObjectOfTaxation(ObjectOfTaxation objectOfTaxation) {
        this.objectOfTaxation = objectOfTaxation;
    }


    public CashRegister() {
        ID = 0;
    }

    public CashRegister(long ID) {
        this.ID = ID;
    }
}
