package org.demoiselle.sample.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import org.demoiselle.sample.domain.Turma;

@PersistenceController
public class TurmaDAO extends JPACrud<Turma, Long> {

	private static final long serialVersionUID = 1L;
	

}
