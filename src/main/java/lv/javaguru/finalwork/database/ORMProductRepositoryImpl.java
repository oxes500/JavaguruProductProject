package lv.javaguru.finalwork.database;

import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


//@Component


public class ORMProductRepositoryImpl implements ProductRepository {


    //@Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void addProduct(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Transactional
    @Override
    public List<Product> getProducts() {
        return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
    }

    @Transactional
    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable((Product) sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("id", id)).uniqueResult());
    }

    @Transactional
    @Override
    public boolean deleteById(Long id) {
        try {
            sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("id", id)).uniqueResult());
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    @Transactional
    @Override
    public List<Product> getProductByCategory(Category category) {
        return sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("category", category)).list();
    }

    @Transactional
    @Override
    public Optional<Product> findProductByName(String productName) {
        return Optional.ofNullable((Product) sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("name", productName)).uniqueResult());
    }

    @Transactional
    @Override
    public void updateProduct(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }
}
