package com.saif.montres.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.saif.montres.entities.Image;
import com.saif.montres.entities.Montre;
import com.saif.montres.repos.ImageRepository;
import com.saif.montres.repos.MontreRepository;
@Service
public class ImageServiceImpl implements ImageService {
	 @Autowired
	 ImageRepository imageRepository;


	 @Autowired
	 MontreService montreService;
	 
	 @Autowired
	MontreRepository montreRepository;
	 
		@Override
		public Image uplaodImage(MultipartFile file) throws IOException {
			/*
			 * Ce code commenté est équivalent au code utilisant le design pattern Builder
			 * Image image = new Image(null, file.getOriginalFilename(),
			 * file.getContentType(), file.getBytes(), null);
			 *   return imageRepository.save(image);
			 */
			return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
					.image(file.getBytes()).build());
		}

		@Override
		public Image getImageDetails(Long id) throws IOException {
			final Optional<Image> dbImage = imageRepository.findById(id);
			return Image.builder().idImage(dbImage.get().getIdImage()).name(dbImage.get().getName())
					.type(dbImage.get().getType()).image(dbImage.get().getImage()).build();
		}

		@Override
		public ResponseEntity<byte[]> getImage(Long id) throws IOException {
			final Optional<Image> dbImage = imageRepository.findById(id);
			return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
					.body(dbImage.get().getImage());
		}

		@Override
		public void deleteImage(Long id) {
			imageRepository.deleteById(id);
		}

		@Override
		public Image uplaodImageMon(MultipartFile file,Long idMon) 
		throws IOException {
				Montre m = new Montre();
				m.setIdMontre(idMon);
		return imageRepository.save(Image.builder()
		 .name(file.getOriginalFilename())
		 .type(file.getContentType())
		 .image(file.getBytes())
		 .montre(m).build() );
		}

		@Override
		public List<Image> getImagesParMon(Long idMon) {
			Montre m = montreRepository.findById(idMon).get();
				return m.getImages();
		}

		
		
		
		
		
	}