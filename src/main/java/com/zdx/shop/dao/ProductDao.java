package com.zdx.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zdx.shop.po.Product;

public interface ProductDao {
	Product queryById(int id);

	List<Product> queryProductList(Product product);

	int selectProductListCount(Product product);

	int insertProduct(Product product);

	int updateProduct(Product product);

	int updateProductStock(@Param("productId") int productId,
			@Param("num") int num);

	int reduceStock(@Param("productId") int productId, @Param("num") int num);

	int deleteProduct(int productId);
	
	
}
