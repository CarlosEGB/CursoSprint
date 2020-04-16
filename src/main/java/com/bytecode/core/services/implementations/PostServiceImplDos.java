package com.bytecode.core.services.implementations;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceDos")
public class PostServiceImplDos implements PostService {

    private final Log log = LogFactory.getLog(getClass());

    @Override
    public List<Post> validation(List<Post> posts) {
        log.info("Estamos ejecutanod desde el segundo postService");
        //System.out.println("Servicio dos de validacion de id");
        for (Post post : posts) {
            if (post.getId() == 0 ){
                throw new NullPointerException("El id no existe");
            }
        }
        return posts;
    }

    @Override
    public void addClass(Class clazz) {
        System.out.println(clazz.getName());
    }
}
