package css.cis3334.participation10;

/**
 * Created by akadijevic on 3/31/2017.
 */

public class Comment {
    private long id;
    private String comment;
    //retrieves the id of the comment
    public long getId() {
        return id;
    }
    //sets the new id to of each entry
    public void setId(long id) {
        this.id = id;
    }
    //retrieves the comment
    public String getComment() {
        return comment;
    }
    // setts the new comment to the value declared "comment"
    public void setComment(String comment) {
        this.comment = comment;
    }

    // Will be used by the ArrayAdapter in the ListView
    // turns user's input into a string
    @Override
    public String toString() {
        return comment;
    }
}
