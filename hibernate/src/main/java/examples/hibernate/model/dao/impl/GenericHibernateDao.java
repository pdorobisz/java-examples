package examples.hibernate.model.dao.impl;

import examples.hibernate.model.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericHibernateDao<T> implements GenericDao<T> {

    private final Class<T> persistentClass;
    private final SessionFactory sessionFactory;

    public GenericHibernateDao(SessionFactory sessionFactory) {
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T find(long id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(T entity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long save(T entity) {
        return (Long) getCurrentSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
