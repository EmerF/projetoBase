package org.demoiselle.sample.persistence;

import org.demoiselle.sample.domain.Funcionario;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class FuncionarioDAO extends JPACrud<Funcionario, Long> {

	private static final long serialVersionUID = 1L;
	

}
