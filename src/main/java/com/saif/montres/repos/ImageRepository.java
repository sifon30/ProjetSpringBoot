package com.saif.montres.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saif.montres.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

}
