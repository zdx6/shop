package com.zdx.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdx.shop.dao.AddressDao;
import com.zdx.shop.po.Address;
import com.zdx.shop.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressDao;

	@Override
	public Address queryById(int addressId) {
		return addressDao.queryById(addressId);
	}

	@Override
	public List<Address> queryAddressListByUserId(Integer userId) {
		return addressDao.queryAddressListByUserId(userId);
	}

	@Override
	public int insertAddress(Address address) {
		return addressDao.insertAddress(address);
	}

	@Override
	public int updateAddress(Address address) {
		return addressDao.updateAddress(address);
	}

	@Override
	public int deleteAddress(int id) {
		return addressDao.deleteAddress(id);
	}

}
