package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Equipo;

@Repository("EquipoDao")
public class EquipoDaoImpl implements EquipoDao {
	
	@Inject
    private SessionFactory sessionFactory;


	@Override
	public Equipo buscarEquipo(Long id) {
		Equipo miEquipoBuscado = (Equipo) sessionFactory.getCurrentSession().createCriteria(Equipo.class)
				   .add(Restrictions.eq("id", id))
				   .uniqueResult();

			return miEquipoBuscado;
	}
	
	@Override
	public List<Equipo> listaDeEquipos(){
		List<Equipo> listaEncontrada = sessionFactory.getCurrentSession().createCriteria(Equipo.class)
						.add(Restrictions.isNotNull("nombre"))
						.list();
		return listaEncontrada;
	}

}
