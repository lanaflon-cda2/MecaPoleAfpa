package fr.afpa.formation.mecanique;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import fr.afpa.formation.mecanique.entity.Stagiaire;
import fr.afpa.formation.mecanique.repository.StagiaireRepository;
import fr.afpa.formation.mecanique.service.StagiaireService;

@RunWith(MockitoJUnitRunner.class)
public class TestStagiaireServiceMock {

	@Mock
	private StagiaireRepository stagiaireRepositoryMock;

	@InjectMocks
	private StagiaireService stagiaireService;

	List<fr.afpa.formation.mecanique.entity.Stagiaire> stagiaires = new ArrayList<>();
	int itemsSize;

	@Before
	public void setUp() {

		Stagiaire stagiaire1 = new Stagiaire(null, "jv.gmail.com", "VALJEAN", "Jean", "04 67 14 23 45", "12435687",
				"mot de passe", new Date(), new Date(), "2 345 678 3", R);

		Stagiaire stagiaire2 = new Stagiaire(null, "jd.gmail.com", "DUPOND", "Jacques", "05 72 84 13 21", "68735124",
				"mot de passe", new Date(), new Date(), "1 234 526 2");

		stagiaires.add(stagiaire1);
		stagiaires.add(stagiaire2);

		itemsSize = 2;

	}

	@Test
	public void findAll() throws Exception {
		when(stagiaireRepositoryMock.findAll()).thenReturn(stagiaires);

		assertEquals(itemsSize, stagiaireService.findAll().size());

	}

}
