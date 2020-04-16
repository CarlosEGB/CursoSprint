package com.bytecode.core.components;

import com.bytecode.core.model.Post;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("com.bytecode.core.components.PostComponent")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PostComponent {

    public List<Post> getPosts() {
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post(1, "Desarrollador de software", "La función del desarrollador de software recae en un programador", "http://localhost/img/post.jpg", new Date()));
        post.add(new Post(2, "Desarrollador de Computadoras", "La función del desarrollador de software recae en un programador", "http://localhost/img/post.jpg", new Date()));
        post.add(new Post(3, "Desarrollador de Maquinas", "La función del desarrollador de software recae en un programador", "http://localhost/img/post.jpg", new Date()));
        post.add(new Post(4, "Desarrollador de Red", "La función del desarrollador de software recae en un programador", "http://localhost/img/post.jpg", new Date()));
        return post;
    }


}
