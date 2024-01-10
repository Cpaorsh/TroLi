package com.newspage.iexcel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;//add
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//import com.newspage.iexcel.FileUploadService;

@Controller
public class FileUploadController {

	@Autowired
	FileUploadService uploadService;

	@RequestMapping(value = "/importAcc", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("upload");
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ModelAndView singleFileUpload(@RequestParam("file") MultipartFile file,
			Model model) {

		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload");
			return new ModelAndView("upload");
		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get("D:\\" + file.getOriginalFilename());
			Files.write(path, bytes);

			uploadService.uploadFileData("D:\\"+path.getFileName());

			model.addAttribute("message", "Tải lên thành công danh sách sinh viên từ file '" + file.getOriginalFilename() + "'");
			
		} catch (IOException e) {
			model.addAttribute("message", "Failure occured during upload '" + file.getOriginalFilename() + "'");			
			e.printStackTrace();
		}

		return new ModelAndView("upload");
	}
}
