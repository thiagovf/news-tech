package com.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/controlling")
public class AController {

//	@RequestMapping(method = RequestMethod.POST)
//	public void zoon(@RequestParam("aFile") MultipartFile fileAlbum,
//			HttpSession session, HttpServletRequest request,
//			HttpServletResponse response) {
//		System.out.println("zoon!");
//	}

	@RequestMapping(value = "multiPartFileSingle", method = {RequestMethod.GET, RequestMethod.POST})
	public void uploadFile(HttpServletRequest request, HttpServletResponse response){//,
			//@RequestParam(value = "fileUp") MultipartFile file) {

		MultipartFile file = (MultipartFile)request.getAttribute("fileUp");
		String back = "";
		try {
			if (!file.isEmpty()) {

				file.getBytes();
				back = "{successMessage : 'successMessage'}";
			} else {
				back = "{errorMessage : 'errorMessage'}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			back = "{errorMessage : 'errorMessage'}";
		}

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		try {// Changing to ISO, because standard AJAX response is in ISO and
				// our string is in UTF-8
			back = new String(back.getBytes("UTF-8"), "ISO8859_1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// Write Json string in Json format
		AbstractHttpMessageConverter<String> stringHttpMessageConverter = new StringHttpMessageConverter();
		MediaType jsonMimeType = MediaType.APPLICATION_JSON;
		if (stringHttpMessageConverter.canWrite(String.class, jsonMimeType)) {
			try {
				stringHttpMessageConverter.write(back, jsonMimeType,
						new ServletServerHttpResponse(response));
			} catch (IOException m_Ioe) {
				m_Ioe.printStackTrace();
			} catch (HttpMessageNotWritableException p_Nwe) {
				p_Nwe.printStackTrace();
			}
		}
	}

}
