package examples.hibernate.services.impl;

import examples.hibernate.model.domain.Product;
import examples.hibernate.services.ProductService;
import examples.hibernate.model.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional(readOnly = false)
    public long create(String name) {
        Product product = new Product();
        product.setName(name);
        return productDao.save(product);
    }

    @Override
    public void delete(long id) {
    }
}
