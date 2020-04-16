package com.bytecode.core.services.implementations;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceDecorado")
@Scope("singleton") //carga el memoria estatica y utilizada simultaneamente
public class PostServiceDecoradoImpl implements PostService {
    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    private PostServiceImpl postServiceImpl;

    @Autowired
    private PostServiceImplDos postServiceImplDos;

    @Override
    public List<Post> validation(List<Post> posts) {
        log.debug(posts);
         posts = postServiceImpl.validation(posts);
         posts = postServiceImplDos.validation(posts);
        for (Post post : posts) {
            if (post.getDescripcion() == null){
                throw new NullPointerException("-----------La descripcion esta nula ----------");
            }
            if (post.getFecha()== null){
                throw new NullPointerException("----------- La fecha esta nula ----------");
            }
        }
        //System.out.println("--- esta la clase decorada -------");
        return posts;
    }

    @Override
    public void addClass(Class clazz) {
        System.out.println(clazz.getName());
    }
}
