package com.saif.montres.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.saif.montres.entities.Image;

public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;
	Image getImageDetails(Long id) throws IOException;
	ResponseEntity<byte[]> getImage(Long id) throws IOException;
	void deleteImage(Long id) ;

	
	Image uplaodImageMon(MultipartFile file,Long idMon) throws IOException;
	List<Image> getImagesParMon(Long idMon);

}
