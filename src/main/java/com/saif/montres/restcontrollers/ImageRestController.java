package com.saif.montres.restcontrollers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.saif.montres.entities.Image;
import com.saif.montres.entities.Montre;
import com.saif.montres.service.ImageService;
import com.saif.montres.service.MontreService;
import org.springframework.http.MediaType;


@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	 @Autowired
	 ImageService imageService ;
	 
	 @Autowired
	 MontreService montreService;
	 
	 
	 @RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile 
			 file,@PathVariable("id") Long id) throws IOException {
		 Montre m = montreService.getMontre(id);
		 m.setImagePath(id+".jpg");

		 Files.write(Paths.get(System.getProperty("user.home")+"/images/"+m.getImagePath())
				 , file.getBytes());
		 montreService.saveMontre(m);

	 }
	 @RequestMapping(value = "/loadfromFS/{id}" , 
			 method = RequestMethod.GET,
			 produces = MediaType.IMAGE_JPEG_VALUE)
	 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		 Montre m = montreService.getMontre(id);
		 return	 Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+m.getImagePath()));
	 }

	 
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		 	return imageService.uplaodImage(file);
	 }
	 
	 @PostMapping(value = "/uplaodImageMon/{idMon}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
			 @PathVariable("idMon") Long idMon) 
					 throws IOException {
		 return imageService.uplaodImageMon(file,idMon);
	 }
	 
	 @RequestMapping(value = "/getImagesProd/{idMon}" , method = RequestMethod.GET)
	 public List<Image> getImagesMon(@PathVariable("idMon") Long idMon) 
			 throws IOException {
		 return imageService.getImagesParMon(idMon);
	 }
	 
	 
	 
	 
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 
	 
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException 
	{
	 return imageService.getImage(id);
	 }
	 
	 
	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	 
	 
	
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	}