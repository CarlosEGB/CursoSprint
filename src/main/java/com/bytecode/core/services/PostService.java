package com.bytecode.core.services;

import com.bytecode.core.model.Post;

import java.util.List;

public interface PostService {
    public List<Post> validation(List<Post> posts);
    public void addClass(Class clazz);
}
