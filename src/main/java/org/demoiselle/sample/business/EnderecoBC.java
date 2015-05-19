
package org.demoiselle.sample.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import org.demoiselle.sample.domain.*;
import java.util.*;
import javax.faces.model.*;
import org.demoiselle.sample.persistence.EnderecoDAO;

// To remove unused imports press: Ctrl+Shift+o

@BusinessController
public class EnderecoBC extends DelegateCrud<Endereco, Long, EnderecoDAO> {
	private static final long serialVersionUID = 1L;
	
	
}
