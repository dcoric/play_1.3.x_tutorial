package models;

import org.hibernate.annotations.Type;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Denis on 16.7.2016..
 */
@Entity
public class Post extends Model {
    public String title;
    public Date postedAt;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    public String content;

    @ManyToOne
    public User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<Comment> comments;

    public Post addComment(String author, String content) {
        Comment newComment = new Comment(this, author, content).save();
        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        this.comments.add(newComment);
        this.save();
        return this;
    }

    public Post(User author, String title, String content) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.postedAt = new Date();
    }
}
