package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

@Repository("EquipoDao")
public class EquipoDaoImpl implements EquipoDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
    public List<Equipo> listarEquipos() {
		List <Equipo> miLista = sessionFactory.getCurrentSession().createCriteria(Equipo.class)
                .add(Restrictions.isNotNull("nombre"))
                .list();

		return miLista;
    }
	
	@Override
	public Equipo buscarEquipo(Long id) {
		Equipo miEquipoBuscado = (Equipo) sessionFactory.getCurrentSession().createCriteria(Equipo.class)
				   .add(Restrictions.eq("id", id))
				   .uniqueResult();

		return miEquipoBuscado;
	}
	
	@Override
	public void agregarEquipo(Equipo equipo) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(equipo);
	}
	
	@Override
	public void editarEquipo(Equipo equipo) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(equipo);
	}
	
	@Override
	public void eliminarEquipo(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Equipo equipo = (Equipo) session.get(Equipo.class, new Long(id));
		
		if(null != equipo) {
			session.delete(equipo);
		}
	}

	@Override
	public Equipo buscarEquipoNombre(String nombre) {
		Equipo miEquipoBuscado = (Equipo) sessionFactory.getCurrentSession().createCriteria(Equipo.class)
				   .add(Restrictions.eq("nombre", nombre))
				   .uniqueResult();

		return miEquipoBuscado;
	}
	
	@Override

    public List<Equipo> listarEquiposPorTorneo(Long id){
		List<Equipo> listaDeEquipos = sessionFactory.getCurrentSession().createCriteria(Equipo.class)
									.createAlias("torneo", "torneoJoin")
									.add(Restrictions.eq("torneoJoin.id", id))
									.list();
		
		return listaDeEquipos;
	}
	
	@Override
	public void editarEquipoTorneo(Equipo equipo) {
			
	}
}