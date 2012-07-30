package br.com.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/uploadfileindex")
public class UploadFileIndexController {

	@RequestMapping(method = RequestMethod.POST)
    public void create(@RequestParam("fileAlbum") MultipartFile fileAlbum,
                    HttpServletRequest request, HttpServletResponse response,
                    HttpSession session) {
		System.out.println("Yahoo");
		
	}
	
}
