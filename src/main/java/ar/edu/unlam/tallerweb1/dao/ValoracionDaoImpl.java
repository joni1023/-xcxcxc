package ar.edu.unlam.tallerweb1.dao;

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
	public ValoracionEdad valoracionEdadTabla() {
		ValoracionEdad mivalor = (ValoracionEdad) sessionFactory.getCurrentSession().createCriteria(ValoracionEdad.class)
				.add(Restrictions.isNotNull("id"))
				.uniqueResult();
		return mivalor;
	}

	@Override
	public ValoracionAltura valoracionAlturaTabla() {
		ValoracionAltura mivalor = (ValoracionAltura) sessionFactory.getCurrentSession().createCriteria(ValoracionAltura.class)
				.add(Restrictions.isNotNull("id"))
				.uniqueResult();
		return mivalor;
	}
	
	@Override
	public List<ValoracionPesoAlturaA> listaValoracionPesoAlturA() {
		List<ValoracionPesoAlturaA> miLista=sessionFactory.getCurrentSession().createCriteria(ValoracionPesoAlturaA.class)
				.add(Restrictions.isNotNull("id"))
				.list();
		return miLista;
	}
	

	@Override
	public ValoracionPesoAlturaA valoracionesoAlturaArqTabla(Long id) {
		ValoracionPesoAlturaA mivalor = (ValoracionPesoAlturaA) sessionFactory.getCurrentSession().createCriteria(ValoracionPesoAlturaA.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		return mivalor;
	}

	

}
