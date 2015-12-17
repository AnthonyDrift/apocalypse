package ort.geekstagram_student.posts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/post")
	public String index(){
		return "hello";
	}
}
