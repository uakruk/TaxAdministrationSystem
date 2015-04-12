package logic;

import javax.persistence.*;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
@Table(name="Property")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long property_id;
    @Column(name = "address")
    private String address;
    @Column(name = "square")
    private double square;
    @Column(name = "cadastralNumber")
    private long cadastralNumber;
    @Column(name = "price")
    private double price;
    @Column(name = "typeOfProperty")
    private String typeOfProperty;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="taxpayer_id")
    private Taxpayer taxpayer;

    public Long getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Long property_id) {
        this.property_id = property_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public long getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(long cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTypeOfProperty() {
        return typeOfProperty;
    }

    public void setTypeOfProperty(String typeOfProperty) {
        this.typeOfProperty = typeOfProperty;
    }

    public Taxpayer getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(Taxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    public Property() {
        address = "";
        square = 0;
        cadastralNumber = 0;
        price = 0;
        typeOfProperty = new String("");
    }

    public Property(String address, double square, long cadastralNumber, double price, String typeOfProperty) {
        this.address = address;
        this.square = square;
        this.cadastralNumber = cadastralNumber;
        this.price = price;
        this.typeOfProperty = typeOfProperty;
    }
}