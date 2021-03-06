package lv.javaguru.finalwork.database;

import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
public class JDBCProductRepository implements ProductRepository {

    @Value( "${jdbc.url}" )
    protected String jdbcUrl;

    @Value( "${driverClass}" )
    protected String driverClass;

    @Value( "${database.user.name}" )
    protected String userName;

    @Value( "${database.user.password}" )
    protected String password;

    protected Connection getConnection() {
        try {
            return DriverManager.getConnection(jdbcUrl, userName, password);
        } catch (SQLException e) {
            System.out.println("Exception while getting connection to DB");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    protected void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception while closing connection to DB");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addProduct(Product product) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into PRODUCTS(id, name, price, category, discount, description) values(default, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice().toString());
            preparedStatement.setString(3, product.getCategory().toString());
            preparedStatement.setString(4, product.getDiscount().toString());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                product.setId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while trying to add product to DB");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from PRODUCTS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setCategory(Category.valueOf(resultSet.getString("category")));
                product.setDiscount(resultSet.getBigDecimal("discount"));
                product.setDescription(resultSet.getString("description"));
                products.add(product);
            }
        } catch (Throwable e) {
            System.out.println("Exception while trying to get list of products from DB");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Connection connection = null;
        try {
          connection = getConnection();

          String sql = "select * from PRODUCTS where id = ?";
          PreparedStatement preparedStatement = connection.prepareStatement(sql);
          preparedStatement.setLong(1, id);
          ResultSet resultSet = preparedStatement.executeQuery();
          Product product = null;
          if (resultSet.next()) {
              product = new Product();
              product.setId(resultSet.getLong("id"));
              product.setName(resultSet.getString("name"));
              product.setPrice(resultSet.getBigDecimal("price"));
              product.setCategory(Category.valueOf(resultSet.getString("category")));
              product.setDiscount(resultSet.getBigDecimal("discount"));
              product.setDescription(resultSet.getString("description"));
          }
          return Optional.ofNullable(product);
        } catch (Throwable e) {
            System.out.println("Exception while trying to find product in by ID DB");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }


    @Override
    public boolean deleteById(Long id) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "delete from PRODUCTS where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();;
            return true;
        } catch (Throwable e) {
            System.out.println("Exception while trying to delete product by ID in DB");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Product> getProductByCategory(Category category) {
        List<Product> products = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from PRODUCTS where category = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setCategory(Category.valueOf(resultSet.getString("category")));
                product.setDiscount(resultSet.getBigDecimal("discount"));
                product.setDescription(resultSet.getString("description"));
                products.add(product);
            }
        } catch (Throwable e) {
            System.out.println("Exception while trying to get products list by category from DB");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
        return products;
    }

    @Override
    public Optional<Product> findProductByName(String productName) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from PRODUCTS where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productName);
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product = null;
            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getBigDecimal("price"));
                product.setCategory(Category.valueOf(resultSet.getString("category")));
                product.setDiscount(resultSet.getBigDecimal("discount"));
                product.setDescription(resultSet.getString("description"));
            }
            return Optional.ofNullable(product);
        } catch (Throwable e) {
            System.out.println("Exception while trying to get product by name from DB");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateProduct(Product product) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "update PRODUCTS set name = ?, price = ?, category = ?, discount = ?, description = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice().toString());
            preparedStatement.setString(3, product.getCategory().toString());
            preparedStatement.setString(4, product.getDiscount().toString());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setLong(6, product.getId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while trying to update product");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnection(connection);
        }
    }
}