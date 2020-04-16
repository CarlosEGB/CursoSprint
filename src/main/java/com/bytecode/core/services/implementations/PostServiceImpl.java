package com.bytecode.core.services.implementations;

import com.bytecode.core.model.Post;
import com.bytecode.core.services.PostService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceUno")
public class PostServiceImpl implements PostService {

    private final Log log = LogFactory.getLog(getClass());

    @Override
    public List<Post> validation(List<Post> posts) {
        log.info("Estamos ejecutanod desde el primer postService");
        //System.out.println("Servicio uno de validacion de titulo nulo");
        for (Post post : posts) {
            if (post.getTitulo() == null){
                throw new NullPointerException("El titulo es vacio");
            }
        }
        return posts;
    }

    @Override
    public void addClass(Class clazz) {
        System.out.println(clazz.getName());
    }
}
