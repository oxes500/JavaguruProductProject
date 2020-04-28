package lv.javaguru.finalwork.Controller;

import lv.javaguru.finalwork.Exceptions.EmptyListException;
import lv.javaguru.finalwork.Exceptions.InvalidDataException;
import lv.javaguru.finalwork.Exceptions.NotFoundException;
import lv.javaguru.finalwork.businesslogic.services.*;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("products")
public class ProductController {

    private final AddProductService addProductService;
    private final AddProductToPreviousListService addProductToPreviousListService;
    private final FindProductByIdService findProductByIdService;
    private final FindProductByNameService findProductByNameService;
    private final GetListOfAllProducts getListOfAllProducts;
    private final GetProductsByCategoryService getProductsByCategoryService;
    private final RemoveProductByIdService removeProductByIdService;
    private final UpdateProductService updateProductService;

    public ProductController(AddProductService addProductService, AddProductToPreviousListService addProductToPreviousListService, FindProductByIdService findProductByIdService, FindProductByNameService findProductByNameService, GetListOfAllProducts getListOfAllProducts, GetProductsByCategoryService getProductsByCategoryService, RemoveProductByIdService removeProductByIdService, UpdateProductService updateProductService) {
        this.addProductService = addProductService;
        this.addProductToPreviousListService = addProductToPreviousListService;
        this.findProductByIdService = findProductByIdService;
        this.findProductByNameService = findProductByNameService;
        this.getListOfAllProducts = getListOfAllProducts;
        this.getProductsByCategoryService = getProductsByCategoryService;
        this.removeProductByIdService = removeProductByIdService;
        this.updateProductService = updateProductService;
    }

    @GetMapping
    List<Product> all() {
        try {
            return getListOfAllProducts.getListOfAllProducts();
        } catch (EmptyListException e) {
            throw new EmptyListException();
        }
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        try {
            addProductService.addProduct(product);
            return product;
        } catch (Exception e) {
         throw new InvalidDataException();
        }
    }

    @PostMapping("/exists")
    public Product createInExisting(@RequestBody Product product) {
        try {
            addProductToPreviousListService.addProduct(product);
            return product;
        } catch (Exception e) {
         throw new InvalidDataException();
        }
    }

    @GetMapping("/find_id_{id}")
    public Product findById(@PathVariable Long id) {
        if (findProductByIdService.findProductById(id)!=null) {
            return findProductByIdService.findProductById(id);
        } else {
           throw new NotFoundException();
        }
    }

    @GetMapping("/find_name_{name}")
    public Product findById(@PathVariable String name) {
        try {
            return findProductByNameService.findProductByName(name);
        } catch (NotFoundException e) {
            throw new NotFoundException();
        }
    }

    @GetMapping("/category_{category}")
    List<Product> getByCategory(@PathVariable String category) {
        try {
            return getProductsByCategoryService.getListByCategory(Category.valueOf(category));
        } catch (IllegalArgumentException e) {
            throw new NotFoundException();
        }
    }

    @DeleteMapping("/delete_{id}")
    public String delete(@PathVariable Long id) {
        try {
            removeProductByIdService.removeProductById(id);
            return "Product with id " + id + " has been deleted!";
        } catch (EmptyResultDataAccessException e) {
         throw new NotFoundException();
        }
    }

    @PutMapping("/update_{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product)  {
        try {
            product.setId(id);
            updateProductService.updateProduct(product);
            return product;
        } catch (NoSuchElementException e) {
            throw new NotFoundException();
        }
    }
}