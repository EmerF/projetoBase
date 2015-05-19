
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
@PreviousView("./funcionario_list.jsf")
public class FuncionarioEditMB extends AbstractEditPageBean<Funcionario, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioBC FuncionarioBC;
	

	/*@Inject
	private TurmaBC turmaBC;
	
	public List<Turma> getTurmaList(){
		return turmaBC.findAll();
	}
			
	@Inject
	private BolsaEstudoBC bolsaEstudoBC;
	
	public List<BolsaEstudo> getBolsaEstudoList(){
		return bolsaEstudoBC.findAll();
	}*/
			

	private DualListModel<Endereco> enderecoList;
	
	@Inject
	private EnderecoBC enderecoBC;

	public void setEnderecoList(DualListModel<Endereco> enderecoList) {
		this.enderecoList = enderecoList;
	}
		
	public void addEnderecoList(List<Endereco> enderecoList) {
		this.getBean().getEnderecos().addAll(enderecoList);
	}

	public void deleteEnderecoList(List<Endereco> enderecoList) {
		this.getBean().getEnderecos().removeAll(enderecoList);
	}
	
	
	public DualListModel<Endereco> getEnderecoList() {
		if (this.enderecoList == null) {
			List<Endereco> source = enderecoBC.findAll();
			List<Endereco> target = this.getBean().getEnderecos();

			if (source == null) {
				source = new ArrayList<Endereco>();
			}
			if (target == null) {
				target = new ArrayList<Endereco>();
			}else{
				source.removeAll(target);
			}
			this.enderecoList = new DualListModel<Endereco>(source, target);

		}
		return this.enderecoList;
	}
	
	@SuppressWarnings("unchecked")
	public void onTransfer(TransferEvent event) {
		if (event.isAdd()){
			this.addEnderecoList((List<Endereco>) event.getItems());
		}
		if (event.isRemove()) {
			this.deleteEnderecoList((List<Endereco>) event.getItems());
		 }
	} 
	public List<SelectItem> getGenero() {
		return FuncionarioBC.getGenero();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.FuncionarioBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.FuncionarioBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.FuncionarioBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Funcionario handleLoad(Long id) {
		return this.FuncionarioBC.load(id);
	}	
}