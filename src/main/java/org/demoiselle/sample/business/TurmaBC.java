
package org.demoiselle.sample.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import org.demoiselle.sample.domain.*;
import java.util.*;
import javax.faces.model.*;
import org.demoiselle.sample.persistence.TurmaDAO;

// To remove unused imports press: Ctrl+Shift+o

@BusinessController
public class TurmaBC extends DelegateCrud<Turma, Long, TurmaDAO> {
	private static final long serialVersionUID = 1L;
	
	
}
