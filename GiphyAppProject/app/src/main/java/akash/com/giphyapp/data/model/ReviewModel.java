package akash.com.giphyapp.data.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class ReviewModel {
    @Id
    private long id;
    private String gifId;
    private int thumbUp;
    private int thumbDown;

    public ReviewModel() {
    }

    public ReviewModel(long id, String gifId, int thumbUp, int thumbDown) {
        this.id = id;
        this.gifId = gifId;
        this.thumbUp = thumbUp;
        this.thumbDown = thumbDown;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(int thumbUp) {
        this.thumbUp = thumbUp;
    }

    public int getThumbDown() {
        return thumbDown;
    }

    public void setThumbDown(int thumbDown) {
        this.thumbDown = thumbDown;
    }

    public String getGifId() {
        return gifId;
    }

    public void setGifId(String gifId) {
        this.gifId = gifId;
    }
}


