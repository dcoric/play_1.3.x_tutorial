package controllers;

import models.Post;
import play.Play;
import play.mvc.Before;
import play.mvc.Controller;

import java.util.List;

public class Application extends Controller {

    @Before
    static void addDefaults() {
        renderArgs.put("blogTitle", Play.configuration.getProperty("blog.title"));
        renderArgs.put("blogBaseline", Play.configuration.getProperty("blog.baseline"));
    }

    public static void index() {
        System.out.println("Index");
        Post frontPost = Post.find("order by postedAt desc").first();
        System.out.println("Popunjeno: " + (frontPost != null ? "front" : "null"));
        List<Post> olderPosts = Post.find("order by postedAt desc").from(1).fetch(10);
        System.out.println("Starih postova: " + olderPosts.size());

        render(frontPost, olderPosts);
    }

}