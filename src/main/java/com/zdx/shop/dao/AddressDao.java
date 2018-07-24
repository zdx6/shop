package com.zdx.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zdx.shop.po.Address;

public interface AddressDao {
	Address queryById(int addressId);

	List<Address> queryAddressListByUserId(@Param("userId") int userId);

	int selectAddressListCount(int userId);

	int insertAddress(Address address);

	int updateAddress(Address address);

	int deleteAddress(int id);
}
