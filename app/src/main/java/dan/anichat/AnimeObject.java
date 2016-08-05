package dan.anichat;

/**
 * Created by Dan on 8/4/2016.
 */
public class AnimeObject {

    String name = null;
    Integer imageId = null;

    public AnimeObject(String name, Integer imageId){
        super();
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }
}
