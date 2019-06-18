//this model added 6/18/19 during lecture as part of the demonstration of form:option, form:select, etc
package com.codingdojo.ProductsAndCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.ProductsAndCategories.models.CategoryProduct;

@Repository

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

}
