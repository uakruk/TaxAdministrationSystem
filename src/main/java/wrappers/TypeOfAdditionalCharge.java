package wrappers;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class TypeOfAdditionalCharge {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TypeOfAdditionalCharge() {
        title = "";
    }

    public TypeOfAdditionalCharge(String title) {
        this.title = title;
    }
}
