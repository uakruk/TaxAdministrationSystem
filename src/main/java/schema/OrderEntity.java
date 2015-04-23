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
@Table(name = "Order", schema = "", catalog = "Podatkova")
public class OrderEntity {
    private int orderId;
    private int registrationId;
    private String text;
    private String writerName;

    @Id
    @Column(name = "Order_id", nullable = false, insertable = true, updatable = true)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "Registration_id", nullable = false, insertable = true, updatable = true)
    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    @Basic
    @Column(name = "Text", nullable = false, insertable = true, updatable = true, length = 300)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "WriterName", nullable = false, insertable = true, updatable = true, length = 50)
    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (orderId != that.orderId) return false;
        if (registrationId != that.registrationId) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (writerName != null ? !writerName.equals(that.writerName) : that.writerName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + registrationId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (writerName != null ? writerName.hashCode() : 0);
        return result;
    }
}
