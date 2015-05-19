
package org.demoiselle.sample.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.demoiselle.sample.business.*;
import org.demoiselle.sample.domain.*;
import javax.faces.model.*;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import java.util.*;

// To remove unused imports press: Ctrl+Shift+o

@ViewController
@PreviousView("./bolsaEstudo_list.jsf")
public class BolsaEstudoEditMB extends AbstractEditPageBean<BolsaEstudo, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BolsaEstudoBC bolsaEstudoBC;
	

	
	@Override
	@Transactional
	public String delete() {
		this.bolsaEstudoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.bolsaEstudoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.bolsaEstudoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected BolsaEstudo handleLoad(Integer id) {
		return this.bolsaEstudoBC.load(id);
	}	
}