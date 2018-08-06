package examples.hibernate.model.dao;

import java.util.List;

public interface GenericDao<T> {

    /**
     * If entity isn't found returns null
     *
     * @param id entity id
     * @return entity or null if not found
     */
    public T find(long id);

    public List<T> findAll();

    public void delete(T entity);

    public long save(T entity);

    public void saveOrUpdate(T entity);
}
