package com.zdx.shop.service;

import java.util.List;

import com.zdx.shop.po.Address;

public interface AddressService {
	Address queryById(int addressId);

	List<Address> queryAddressListByUserId(Integer userId);

	int insertAddress(Address address);

	int updateAddress(Address address);

	int deleteAddress(int id);
}
