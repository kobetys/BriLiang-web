package springmvc.annotationcontroller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/file")
public class uploadFileController {
	@RequestMapping("/upload")
	@ResponseBody
	/*上传文件接收参数类CommonsMultipartFile*/
	/*@RequestParam解析上传name的名字*/
	public ModelAndView uploadFile(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest request){
		System.out.println("文件名称："+file.getOriginalFilename());
		String message="上传失败";
		if(!file.isEmpty()){
			FileOutputStream outstream;
			try {
				outstream = new FileOutputStream("E:/uploadFile/"+new Date().getTime()+file.getOriginalFilename());
				InputStream in=file.getInputStream();
				byte[] b = new byte[1024];
				while(in.read(b)!=-1){
					outstream.write(b);
				}
				outstream.flush();
				outstream.close();
				in.close();
				message="上传成功";
			} catch (Exception e) {
				e.printStackTrace();
				message="上传失败";
			} 
		}
		request.setAttribute("message",message);
		return new ModelAndView("/show/uploadFileController");
	}
	@RequestMapping(value="/upload",params="method=showUpload")
	/*上传文件接收参数类CommonsMultipartFile*/
	/*@RequestParam解析上传name的名字*/
	public ModelAndView showUpload() throws Exception{
		ModelAndView model=new ModelAndView();
		model.setViewName("/show/uploadFileController");
		return model;
	}
	@RequestMapping(value="/uploadFileNew")
	/*上传文件接收参数类CommonsMultipartFile*/
	/*@RequestParam解析上传name的名字*/
	public ModelAndView uploadFileNew(HttpServletRequest request) throws Exception{
		String message="上传失败";
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
		if(multipartResolver.isMultipart(request)){
			MultipartHttpServletRequest MultiRequest=(MultipartHttpServletRequest)request;
			Iterator<String> iter=MultiRequest.getFileNames();
			while(iter.hasNext()){
				MultipartFile file=MultiRequest.getFile(iter.next());
				if(file!=null){
					String fileName=new Date().getTime()+file.getOriginalFilename();
					String path="E:/uploadFile/";
					File localFile=new File(path+fileName);
					file.transferTo(localFile);
					message="上传成功";
				}
			}
		}
		ModelAndView model=new ModelAndView();
		model.addObject("message", message);
		model.setViewName("/show/uploadFileController");
		return new ModelAndView("/show/uploadFileController");
	}
}
