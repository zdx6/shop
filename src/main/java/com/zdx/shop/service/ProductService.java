package com.zdx.shop.service;

import com.zdx.shop.common.utils.Page;
import com.zdx.shop.po.Product;

public interface ProductService {
	Product queryById(int id);

	Page<Product> queryProductList(String productName, Integer type,
			Integer shopId, int pageNo, int size);

	int insertProduct(Product product);

	int updateProduct(Product product);

	int updateProductStock(int productId, int num);

	int deleteProduct(int productId);
}
