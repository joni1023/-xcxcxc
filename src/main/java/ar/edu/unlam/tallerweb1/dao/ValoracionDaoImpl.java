package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionesGenerales;

@Repository("ValoracionDao")
public class ValoracionDaoImpl implements ValoracionDao {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<ValoracionEdad> valoracionEdadTabla() {
		List<ValoracionEdad> misvalores =  sessionFactory.getCurrentSession().createCriteria(ValoracionEdad.class)
				.add(Restrictions.isNotNull("id"))
				.list();
		return misvalores;
	}

	@Override
	public List<ValoracionAltura> valoracionAlturaTabla() {
		List <ValoracionAltura> misvalores = sessionFactory.getCurrentSession().createCriteria(ValoracionAltura.class)
				.add(Restrictions.isNotNull("id"))
				.list();
		return misvalores;
	}
	
	@Override
	public List<ValoracionPesoAltura> listaValoracionPesoAltura() {
		List<ValoracionPesoAltura> miLista = sessionFactory.getCurrentSession().createCriteria(ValoracionPesoAltura.class)
				.add(Restrictions.isNotNull("id"))
				.list();
		return miLista;
	}

	@Override
	public ValoracionEdad valoracionEdadTablaTipo(Long id) {
		// id 1 es arquero, 2 campo
		ValoracionEdad mivalor = (ValoracionEdad) sessionFactory.getCurrentSession().createCriteria(ValoracionEdad.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		return mivalor;
	}

	@Override
	public ValoracionAltura valoracionAlturaTablaTipo(Long id) {
		// id 1 es arquero, 2 campo
		ValoracionAltura mivalor = (ValoracionAltura) sessionFactory.getCurrentSession().createCriteria(ValoracionAltura.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		return mivalor;
	}

	@Override
	public List<ValoracionPesoAltura> listaValoracionPesoAlturaTipo(String tipo) {
		String arquero="Arquero";
		long id=6l;
		List <ValoracionPesoAltura> misValores = new ArrayList <ValoracionPesoAltura>();
		if (tipo.equals(arquero)) {
			
			misValores= sessionFactory.getCurrentSession().createCriteria(ValoracionPesoAltura.class)
					.add(Restrictions.le("id", id))
					.list();
			
		} else {
			misValores = sessionFactory.getCurrentSession().createCriteria(ValoracionPesoAltura.class)
					.add(Restrictions.gt("id", id))
					.list();
		}
		
		return misValores;
	}

	@Override
	public ValoracionesGenerales valoracionGeneral() {
		
		return (ValoracionesGenerales) sessionFactory.getCurrentSession().createCriteria(ValoracionesGenerales.class)
				.add(Restrictions.isNotNull("id"))
				.uniqueResult();
	}

	@Override
	public void modificarTablaValoracionEdad(ValoracionEdad nuevaValoracionEdad) {
		sessionFactory.getCurrentSession().update(nuevaValoracionEdad);
		
	}

	@Override
	public void modificarTablaValoracionAltura(ValoracionAltura nuevaValoracionAltura) {
		sessionFactory.getCurrentSession().update(nuevaValoracionAltura);		
	}

	@Override
	public void modificarTablaValoracionPesoAltura(ValoracionPesoAltura nuevaValoracionPesoAltura) {
		sessionFactory.getCurrentSession().update(nuevaValoracionPesoAltura);		
	}

	@Override
	public void modificarTablaValoracionGeneral(ValoracionesGenerales nuevaValoracionGeneral) {
		sessionFactory.getCurrentSession().update(nuevaValoracionGeneral);		
	}

	@Override
	public ValoracionPesoAltura valoracionPesoAlturaPorId(Long id) {
		
		return (ValoracionPesoAltura) sessionFactory.getCurrentSession().createCriteria(ValoracionPesoAltura.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}
}