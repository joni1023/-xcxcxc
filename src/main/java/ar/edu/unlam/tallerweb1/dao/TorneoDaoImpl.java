package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Torneo;

@Repository("TorneoDao")
public class TorneoDaoImpl implements TorneoDao{
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public void agregarEquipo(Equipo equipo) {
		sessionFactory.getCurrentSession().save(equipo);
	}
	@Override
	public List<Torneo>listarTorneos(){
		List<Torneo>listaDeTorneos = sessionFactory.getCurrentSession().createCriteria(Torneo.class)
									.add(Restrictions.isNotNull("nombre"))
									.list();
		return listaDeTorneos;
	}
	
	@Override
	public void agregarTorneo(Torneo torneo) {
		sessionFactory.getCurrentSession().save(torneo);
	}
	
	@Override
	public Torneo listarTorneoId(Long id) {
		Torneo torneo = (Torneo) sessionFactory.getCurrentSession().createCriteria(Torneo.class)
						.add(Restrictions.eq("id", id))
						.uniqueResult();
		return torneo;
	}
}
