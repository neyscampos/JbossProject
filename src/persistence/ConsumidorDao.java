package persistence;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Consumidor;

@Stateless
@Dependent
public class ConsumidorDao {

	@PersistenceContext(unitName = "JbossProject")
	EntityManager em;

	public void create(Consumidor c) {
		em.persist(c);
	}

	public void update(Consumidor c) {
		em.merge(c);
	}

	public void delete(Integer id) {
		em.remove(em.getReference(Consumidor.class, id));
	}

	public Collection<Consumidor> FindAll() {
		return em.createNamedQuery("mostra").getResultList();
	}

	public Consumidor findByCode(Integer id) {
		return em.getReference(Consumidor.class, id);
	}
}
