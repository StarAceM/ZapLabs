package starace.com.staracetest.models;

/**
 * Created by mstarace on 9/13/17.
 */

public class PlaceHolderModel {

    private String body;

    private String imageUrl;

    public PlaceHolderModel(String body, String imageUrl) {
        this.body = body;
        this.imageUrl = imageUrl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
