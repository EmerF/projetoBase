
package org.demoiselle.sample.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.demoiselle.sample.domain.Cliente;
import org.demoiselle.sample.domain.Genero;
import org.demoiselle.sample.persistence.ClienteDAO;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

// To remove unused imports press: Ctrl+Shift+o

@BusinessController
public class ClienteBC extends DelegateCrud<Cliente, Long, ClienteDAO> {
	private static final long serialVersionUID = 1L;
	
	
	public List<SelectItem> getGenero() {
		List<SelectItem> varGenero = new ArrayList<SelectItem>();
		for (Genero eachGenero : Genero.values()) {
			varGenero.add(new SelectItem(eachGenero));
		}
		return varGenero;
	}
	
}
