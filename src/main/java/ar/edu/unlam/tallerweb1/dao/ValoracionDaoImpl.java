package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ValoracionAltura;
import ar.edu.unlam.tallerweb1.modelo.ValoracionEdad;
import ar.edu.unlam.tallerweb1.modelo.ValoracionPesoAlturaA;

@Repository("ValoracionDao")
public class ValoracionDaoImpl implements ValoracionDao {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<ValoracionEdad> valoracionEdadTabla() {
		List<ValoracionEdad> mivalores =  sessionFactory.getCurrentSession().createCriteria(ValoracionEdad.class)
				.add(Restrictions.isNotNull("id"))
				.list();
		return mivalores;
	}

	@Override
	public List<ValoracionAltura> valoracionAlturaTabla() {
		List <ValoracionAltura> mivalores = sessionFactory.getCurrentSession().createCriteria(ValoracionAltura.class)
				.add(Restrictions.isNotNull("id"))
				.list();
		return mivalores;
	}
	
	@Override
	public List<ValoracionPesoAlturaA> listaValoracionPesoAlturA() {
		List<ValoracionPesoAlturaA> miLista=sessionFactory.getCurrentSession().createCriteria(ValoracionPesoAlturaA.class)
				.add(Restrictions.isNotNull("id"))
				.list();
		return miLista;
	}

	@Override
	public ValoracionEdad valoracionEdadTablaTipo(Long id) {
//		id 1 es arquero , 2 campo
			ValoracionEdad mivalor = (ValoracionEdad) sessionFactory.getCurrentSession().createCriteria(ValoracionEdad.class)
					.add(Restrictions.eq("id", id))
					.uniqueResult();
			return mivalor;
	}

	@Override
	public ValoracionAltura valoracionAlturaTablaTipo(Long id) {
//		id 1 es arquero , 2 campo
		ValoracionAltura mivalor = (ValoracionAltura) sessionFactory.getCurrentSession().createCriteria(ValoracionAltura.class)
					.add(Restrictions.eq("id", id))
					.uniqueResult();
			return mivalor;
	}

	@Override
	public List<ValoracionPesoAlturaA> listaValoracionPesoAlturATipo(String tipo) {
		String arquero="Arquero";
		long id=6l;
		List <ValoracionPesoAlturaA> misValores = new ArrayList <ValoracionPesoAlturaA>();
		if (tipo.equals(arquero)) {
			
			misValores= sessionFactory.getCurrentSession().createCriteria(ValoracionPesoAlturaA.class)
					.add(Restrictions.le("id", id))
					.list();
			
		}else {
			misValores = sessionFactory.getCurrentSession().createCriteria(ValoracionPesoAlturaA.class)
					.add(Restrictions.gt("id", id))
					.list();
		}
		return misValores;
	}

	

}
