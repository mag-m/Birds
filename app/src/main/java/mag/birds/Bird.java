package mag.birds;

import java.io.Serializable;
import java.util.Calendar;

public class Bird implements Serializable {
    private Calendar Created;
    private int Id;
    private String NameDanish;
    private String NameEnglish;
    private String PhotoUrl;
    private String UserId;


    public Bird(){

    }

    public Bird(Calendar created, int id, String nameDanish, String nameEnglish, String photoUrl, String userId){
        Created = created;
        Id = id;
        NameDanish = nameDanish;
        NameEnglish = nameEnglish;
        PhotoUrl = photoUrl;
        UserId = userId;
    }

    public Calendar getCreated() {
        return Created;
    }

    public void setCreated(Calendar created) {
        Created = created;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNameDanish() {
        return NameDanish;
    }

    public void setNameDanish(String nameDanish) {
        NameDanish = nameDanish;
    }

    public String getNameEnglish() {
        return NameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        NameEnglish = nameEnglish;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    @Override
    public String toString() {
        return NameEnglish;
    }
}
