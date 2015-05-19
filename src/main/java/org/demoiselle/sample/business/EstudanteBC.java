
package org.demoiselle.sample.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import org.demoiselle.sample.domain.*;
import java.util.*;
import javax.faces.model.*;
import org.demoiselle.sample.persistence.EstudanteDAO;

// To remove unused imports press: Ctrl+Shift+o

@BusinessController
public class EstudanteBC extends DelegateCrud<Estudante, Long, EstudanteDAO> {
	private static final long serialVersionUID = 1L;
	
	
	public List<SelectItem> getGenero() {
		List<SelectItem> varGenero = new ArrayList<SelectItem>();
		for (Genero eachGenero : Genero.values()) {
			varGenero.add(new SelectItem(eachGenero));
		}
		return varGenero;
	}
	
}
