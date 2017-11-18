package manager;

import java.io.Serializable;
import java.util.List;

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

	private static final long serialVersionUID = 1L;

	@Inject
	private Consumidor consumidor;

	@Inject
	private ConsumidorDao dao; // sem new apenas injeção de dependência

	private List<Consumidor> consumidores;

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

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	public ConsumidorDao getDao() {
		return dao;
	}

	public void setDao(ConsumidorDao dao) {
		this.dao = dao;
	}

	public List<Consumidor> getConsumidores() {
		return consumidores == null ? (consumidores = (List<Consumidor>) this.dao.FindAll()) : consumidores;
	}

	public void setConsumidores(List<Consumidor> consumidores) {
		this.consumidores = consumidores;
	}

}
