
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
@PreviousView("./turma_list.jsf")
public class TurmaEditMB extends AbstractEditPageBean<Turma, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private TurmaBC turmaBC;
	

	private DataModel<Estudante> estudanteList;
	
	public void addEstudante() {
		this.getBean().getEstudantes().add(new Estudante());
	}
	public void deleteEstudante() {
	   this.getBean().getEstudantes().remove(getEstudanteList().getRowData());
	}
	public DataModel<Estudante> getEstudanteList() {
	   if (estudanteList == null) {
		   estudanteList = new ListDataModel<Estudante>(this.getBean().getEstudantes());
	   }
	   return estudanteList;
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.turmaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.turmaBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.turmaBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Turma handleLoad(Long id) {
		return this.turmaBC.load(id);
	}	
}