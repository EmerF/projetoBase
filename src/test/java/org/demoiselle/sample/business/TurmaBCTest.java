

package org.demoiselle.sample.business;

import static org.junit.Assert.*;
import java.util.*;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import org.demoiselle.sample.domain.Turma;
import org.demoiselle.sample.business.TurmaBC;

@RunWith(DemoiselleRunner.class)
public class TurmaBCTest {

    @Inject
	private TurmaBC turmaBC;
	
	@Before
	public void before() {
		for (Turma turma : turmaBC.findAll()) {
			turmaBC.delete(turma.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		Turma turma = new Turma("nomeTurma",null);
		turmaBC.insert(turma);
		List<Turma> listOfTurma = turmaBC.findAll();
		assertNotNull(listOfTurma);
		assertEquals(1, listOfTurma.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		Turma turma = new Turma("nomeTurma",null);
		turmaBC.insert(turma);
		
		List<Turma> listOfTurma = turmaBC.findAll();
		assertNotNull(listOfTurma);
		assertEquals(1, listOfTurma.size());
		
		turmaBC.delete(turma.getId());
		listOfTurma = turmaBC.findAll();
		assertEquals(0, listOfTurma.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		Turma turma = new Turma("nomeTurma",null);
		turmaBC.insert(turma);
		
		List<Turma> listOfTurma = turmaBC.findAll();
		Turma turma2 = (Turma)listOfTurma.get(0);
		assertNotNull(listOfTurma);

		// alterar para tratar uma propriedade existente na Entidade Turma
		// turma2.setUmaPropriedade("novo valor");
		turmaBC.update(turma2);
		
		listOfTurma = turmaBC.findAll();
		Turma turma3 = (Turma)listOfTurma.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Turma
		// assertEquals("novo valor", turma3.getUmaPropriedade());
	}

}