package com.bytecode.core.controllers;

import com.bytecode.core.components.PostComponent;
import com.bytecode.core.configuration.Paginas;
import com.bytecode.core.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class ControllerBasic {

	@Autowired
	private PostComponent _postComponent;

    @GetMapping(path = {"/posty", "/"})
    public String saludar(Model model) {
        model.addAttribute("posts", this._postComponent.getPosts());
        return "index";
    }

	//video 12
	//sacar un modelo en especifico o un grupo de dependiendo de un id
	@GetMapping(path = {"/post","/post/p/{post}"}) //para que en la ruta url no se ?id.... sino post/1
	public ModelAndView getPostIndividual(@PathVariable(required = true, name = "post") int id ) { //recibe el parametro id del primer post o el solicitado

		//indicamos que pagina va ir dirigida el post
		ModelAndView modelAndView = new ModelAndView(Paginas.POST);

		//esto filtra por id todos los datos de los post, solo dejando los id del post indicado
		List<Post> postFiltrado = this._postComponent.getPosts().stream()
				.filter((p) -> {
					return p.getId() == id;
				}).collect(Collectors.toList());

		//aqui le enviamos el modelandview el post en la posicion cero
		modelAndView.addObject("post", postFiltrado.get(0));
		return modelAndView;
	}


	//video 13
	//Esta llamando al form.html y me envia unos datos del model POST()
	@GetMapping("/postNew")
	public  ModelAndView getForm(){
    	return new ModelAndView("form").addObject("post", new Post());
	}

	//video 13
	//Este metodo es llamado por el acti del form  y obtiene los datos guardado en el model y lo agrega al post
	@PostMapping("/addNewPost")
	public String addNewPost(Post post, Model model){
    	List<Post> posts = this._postComponent.getPosts();
    	posts.add(post);
    	model.addAttribute("posts",posts);
    	return Paginas.HOME;
	}



//    //video 11
//    //sacar un modelo en especifico o un grupo de dependiendo de un id
//    @GetMapping(path = {"/post"})
//    public ModelAndView getPostIndividual(@RequestParam(defaultValue = "1", name = "id", required = false) int id) { //recibe el parametro id del primer post
//
//    	//indicamos que pagina va ir dirigida el post
//        ModelAndView modelAndView = new ModelAndView(Paginas.POST);
//
//        //esto filtra por id todos los datos de los post, solo dejando los id del post indicado
//        List<Post> postFiltrado = this.getPosts().stream()
//                .filter((p) -> {
//                    return p.getId() == id;
//                }).collect(Collectors.toList());
//
//        //aqui le enviamos el modelandview el post en la posicion cero
//        modelAndView.addObject("post", postFiltrado.get(0));
//        return modelAndView;
//    }


    //video 10
    //adicionar un modelo a la vista
//	@GetMapping(path="/public")
//	public ModelAndView post(){
//		ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
//		modelAndView.addObject("posts",this.getPosts());
//		return modelAndView;
//	}


}
