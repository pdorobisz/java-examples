package examples.hibernate.model.dao.impl;

import examples.hibernate.model.dao.ProductDao;
import examples.hibernate.model.domain.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductHibernateDao extends GenericHibernateDao<Product> implements ProductDao {

    @Autowired
    public ProductHibernateDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
