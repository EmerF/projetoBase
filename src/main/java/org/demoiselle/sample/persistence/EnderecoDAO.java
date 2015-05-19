package org.demoiselle.sample.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import org.demoiselle.sample.domain.Endereco;

@PersistenceController
public class EnderecoDAO extends JPACrud<Endereco, Long> {

	private static final long serialVersionUID = 1L;
	

}
