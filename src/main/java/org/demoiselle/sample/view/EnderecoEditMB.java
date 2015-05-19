
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
@PreviousView("./endereco_list.jsf")
public class EnderecoEditMB extends AbstractEditPageBean<Endereco, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoBC enderecoBC;
	


	private DualListModel<Estudante> estudanteList;
	
	@Inject
	private EstudanteBC estudanteBC;

	public void setEstudanteList(DualListModel<Estudante> estudanteList) {
		this.estudanteList = estudanteList;
	}
		
	public void addEstudanteList(List<Estudante> estudanteList) {
		this.getBean().getEstudantes().addAll(estudanteList);
	}

	public void deleteEstudanteList(List<Estudante> estudanteList) {
		this.getBean().getEstudantes().removeAll(estudanteList);
	}
	
	
	public DualListModel<Estudante> getEstudanteList() {
		if (this.estudanteList == null) {
			List<Estudante> source = estudanteBC.findAll();
			List<Estudante> target = this.getBean().getEstudantes();

			if (source == null) {
				source = new ArrayList<Estudante>();
			}
			if (target == null) {
				target = new ArrayList<Estudante>();
			}else{
				source.removeAll(target);
			}
			this.estudanteList = new DualListModel<Estudante>(source, target);

		}
		return this.estudanteList;
	}
	
	@SuppressWarnings("unchecked")
	public void onTransfer(TransferEvent event) {
		if (event.isAdd()){
			this.addEstudanteList((List<Estudante>) event.getItems());
		}
		if (event.isRemove()) {
			this.deleteEstudanteList((List<Estudante>) event.getItems());
		 }
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.enderecoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.enderecoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.enderecoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Endereco handleLoad(Long id) {
		return this.enderecoBC.load(id);
	}	
}