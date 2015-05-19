package org.demoiselle.sample.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.demoiselle.sample.business.FuncionarioBC;
import org.demoiselle.sample.domain.Funcionario;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("./funcionario_edit.jsf")
@PreviousView("./funcionario_list.jsf")
public class FuncionarioListMB extends AbstractListPageBean<Funcionario, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioBC FuncionarioBC;
	
	@Override
	protected List<Funcionario> handleResultList() {
		return this.FuncionarioBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				FuncionarioBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}