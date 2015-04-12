package wrappers;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class Property {

    private String address;
    private double square;
    private long cadastralNumber;
    private double price;
    private TypeOfProperty typeOfProperty;

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

    public TypeOfProperty getTypeOfProperty() {
        return typeOfProperty;
    }

    public void setTypeOfProperty(TypeOfProperty typeOfProperty) {
        this.typeOfProperty = typeOfProperty;
    }

    public Property() {
        address = "";
        square = 0;
        cadastralNumber = 0;
        price = 0;
        typeOfProperty = new TypeOfProperty();
    }

    public Property(String address, double square, long cadastralNumber, double price, TypeOfProperty typeOfProperty) {
        this.address = address;
        this.square = square;
        this.cadastralNumber = cadastralNumber;
        this.price = price;
        this.typeOfProperty = typeOfProperty;
    }
}
