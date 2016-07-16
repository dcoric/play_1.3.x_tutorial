package models;

import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by Denis on 16.7.2016..
 */
@Entity
public class Comment extends Model {
    public String author;
    public Date postedAt;

    @Lob
    public String content;

    @ManyToOne
    public Post post;

    public Comment(Post post, String author, String content) {
        this.author = author;
        this.content = content;
        this.post = post;
        this.postedAt = new Date();
    }
}
