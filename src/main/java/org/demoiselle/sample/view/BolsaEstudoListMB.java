package org.demoiselle.sample.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import org.demoiselle.sample.business.BolsaEstudoBC;
import org.demoiselle.sample.domain.BolsaEstudo;

@ViewController
@NextView("./bolsaEstudo_edit.jsf")
@PreviousView("./bolsaEstudo_list.jsf")
public class BolsaEstudoListMB extends AbstractListPageBean<BolsaEstudo, Integer> {

	private static final long serialVersionUID = 1L;

	@Inject
	private BolsaEstudoBC bolsaEstudoBC;
	
	@Override
	protected List<BolsaEstudo> handleResultList() {
		return this.bolsaEstudoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Integer> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Integer id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				bolsaEstudoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}