package manager;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import entity.Consumidor;
import persistence.ConsumidorDao;

@ManagedBean(name = "mb")
@RequestScoped
public class ManagerBean implements Serializable {

	@Inject
	private Consumidor consumidor;

	@Inject
	private ConsumidorDao dao; // sem new apenas injeção de dependência

	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();
		try {
			dao.create(consumidor);
			consumidor = new Consumidor();
			fc.addMessage(null, new FacesMessage("Dados Gravados..."));
		} catch (Exception ex) {
			fc.addMessage(null, new FacesMessage("error: " + ex.getMessage()));

		}
	}

}
