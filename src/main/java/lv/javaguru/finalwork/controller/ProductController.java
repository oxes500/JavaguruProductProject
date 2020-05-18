package lv.javaguru.finalwork.controller;

import lv.javaguru.finalwork.exceptions.EmptyListException;
import lv.javaguru.finalwork.exceptions.InvalidDataException;
import lv.javaguru.finalwork.exceptions.NotFoundException;
import lv.javaguru.finalwork.businesslogic.services.*;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

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
    List<Product> getAllProducts() {
        try {
            return getListOfAllProducts.getListOfAllProducts();
        } catch (EmptyListException e) {
            throw new EmptyListException();
        }
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product) {
        try {
            addProductService.addProduct(product);
            return product;
        } catch (Exception e) {
         throw new InvalidDataException();
        }
    }

    @PostMapping("/exists")
    public Product addProductInExistingList(@RequestBody Product product) {
        try {
            addProductToPreviousListService.addProduct(product);
            return product;
        } catch (Exception e) {
         throw new InvalidDataException();
        }
    }

    @GetMapping("/product/{id}")
    public Product findById(@PathVariable Long id) {
        try {
            return findProductByIdService.findProductById(id);
        } catch (NotFoundException e) {
            throw new NotFoundException();
        }
    }

    @GetMapping("/product/{name}")
    public Product findByName(@PathVariable String name) {
        try {
            return findProductByNameService.findProductByName(name);
        } catch (NotFoundException e) {
            throw new NotFoundException();
        }
    }

    @GetMapping("/category/{category}")
    List<Product> getByCategory(@PathVariable String category) {
        try {
            return getProductsByCategoryService.getListByCategory(Category.valueOf(category));
        } catch (IllegalArgumentException e) {
            throw new NotFoundException();
        }
    }

    @DeleteMapping("/product/{id}")
    public String delete(@PathVariable Long id) {
        try {
            removeProductByIdService.removeProductById(id);
            return "Product with id " + id + " has been deleted!";
        } catch (EmptyResultDataAccessException e) {
         throw new NotFoundException();
        }
    }

    @PutMapping("/product/{id}")
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