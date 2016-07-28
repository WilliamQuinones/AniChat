package dan.anichat;

/**
 * Created by Dan on 7/28/2016.
 */
public class Message {

    private String text, name, photoUrl;

    public Message(){

    }

    public Message(String text, String name, String photoUrl){
        this.text = text;
        this.name = name;
        this.photoUrl = photoUrl;
    }

    public String getText(){ return text;}

    public void setText (String text){ this.text = text;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
