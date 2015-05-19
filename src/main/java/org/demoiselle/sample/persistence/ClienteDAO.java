package org.demoiselle.sample.persistence;

import org.demoiselle.sample.domain.Cliente;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class ClienteDAO extends JPACrud<Cliente, Long> {

	private static final long serialVersionUID = 1L;
	

}
