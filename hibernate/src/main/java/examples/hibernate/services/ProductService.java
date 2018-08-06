package examples.hibernate.services;

public interface ProductService {

    public long create(String name);

    public void delete(long id);
}
