package org.demoiselle.sample.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import org.demoiselle.sample.domain.BolsaEstudo;

@PersistenceController
public class BolsaEstudoDAO extends JPACrud<BolsaEstudo, Integer> {

	private static final long serialVersionUID = 1L;
	

}
