package com.saif.montres;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.saif.montres.entities.Genre;
import com.saif.montres.entities.Montre;
import com.saif.montres.repos.MontreRepository;

@SpringBootTest
class MontresApplicationTests {

	@Autowired
	private MontreRepository montreRepository;
	@Test
	public void testCreateMontre() {
	Montre mon = new Montre("omega",2000.500,new Date());
	montreRepository.save(mon);
	}
	
	
	@Test
	public void testFindMontre()
	{
	Montre m = montreRepository.findById(1L).get(); 
	System.out.println(m);
	}
	
	
	@Test
	public void testUpdateMontre()
	{
	Montre m = montreRepository.findById(1L).get(); 
	m.setPrixMontre(2000.0);
	montreRepository.save(m);
	}
	
	@Test
	public void testDeleteMontre()
	{
	montreRepository.deleteById(1L);;
	}
	
	@Test
	public void testListerTousMontres()
	{
	List<Montre> mons = montreRepository.findAll();
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	}
	
	@Test
	public void testFindMontreByNom()
	{
	List<Montre> mons = montreRepository.findByNomMontre("rolex");
	for (Montre m : mons)
	{
	System.out.println(m);
	}	}
	
	@Test
	public void testFindMontreByNomContains()
	{
	List<Montre> mons = montreRepository.findByNomMontreContains("o");
	for (Montre m : mons)
	{
	System.out.println(m);
	}	}
	
	
	@Test
	public void testfindByNomPrix()
	{
	List<Montre> mons = montreRepository.findByNomPrix("rolex", 3000.500);
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	}
	
	
	@Test
	public void testfindByGenre()
	{
	Genre gen = new Genre();
	gen.setIdGen(2L);
	List<Montre> mons = montreRepository.findByGenre(gen);
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	}
	
	
	@Test
	public void findByGenreIdGen()
	{
	List<Montre> mons = montreRepository.findByGenreIdGen(1L);
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	 }
	
	
	@Test
	public void findByOrderByNomMontreAsc()
	{
	List<Montre> mons = 
			montreRepository.findByOrderByNomMontreAsc();
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	}
	
	@Test
	public void testTrierMontresNomsPrix()
	{
	List<Montre> mons = montreRepository.trierMontresNomsPrix();
	for (Montre m : mons)
	{
	System.out.println(m);
	}
	}

}
