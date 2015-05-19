

package org.demoiselle.sample.business;

import static org.junit.Assert.*;
import java.util.*;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import org.demoiselle.sample.domain.BolsaEstudo;
import org.demoiselle.sample.business.BolsaEstudoBC;

@RunWith(DemoiselleRunner.class)
public class BolsaEstudoBCTest {

    @Inject
	private BolsaEstudoBC bolsaEstudoBC;
	
	@Before
	public void before() {
		for (BolsaEstudo bolsaEstudo : bolsaEstudoBC.findAll()) {
			bolsaEstudoBC.delete(bolsaEstudo.getNumero());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		BolsaEstudo bolsaEstudo = new BolsaEstudo(Long.valueOf(1),new Date(),new Date());
		bolsaEstudoBC.insert(bolsaEstudo);
		List<BolsaEstudo> listOfBolsaEstudo = bolsaEstudoBC.findAll();
		assertNotNull(listOfBolsaEstudo);
		assertEquals(1, listOfBolsaEstudo.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		BolsaEstudo bolsaEstudo = new BolsaEstudo(Long.valueOf(1),new Date(),new Date());
		bolsaEstudoBC.insert(bolsaEstudo);
		
		List<BolsaEstudo> listOfBolsaEstudo = bolsaEstudoBC.findAll();
		assertNotNull(listOfBolsaEstudo);
		assertEquals(1, listOfBolsaEstudo.size());
		
		bolsaEstudoBC.delete(bolsaEstudo.getNumero());
		listOfBolsaEstudo = bolsaEstudoBC.findAll();
		assertEquals(0, listOfBolsaEstudo.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		BolsaEstudo bolsaEstudo = new BolsaEstudo(Long.valueOf(1),new Date(),new Date());
		bolsaEstudoBC.insert(bolsaEstudo);
		
		List<BolsaEstudo> listOfBolsaEstudo = bolsaEstudoBC.findAll();
		BolsaEstudo bolsaEstudo2 = (BolsaEstudo)listOfBolsaEstudo.get(0);
		assertNotNull(listOfBolsaEstudo);

		// alterar para tratar uma propriedade existente na Entidade BolsaEstudo
		// bolsaEstudo2.setUmaPropriedade("novo valor");
		bolsaEstudoBC.update(bolsaEstudo2);
		
		listOfBolsaEstudo = bolsaEstudoBC.findAll();
		BolsaEstudo bolsaEstudo3 = (BolsaEstudo)listOfBolsaEstudo.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade BolsaEstudo
		// assertEquals("novo valor", bolsaEstudo3.getUmaPropriedade());
	}

}