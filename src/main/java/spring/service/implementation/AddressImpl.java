package spring.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.AddressDao;
import spring.model.Address;
import spring.service.AddressService;

import java.sql.SQLException;
import java.util.List;

public class AddressImpl implements AddressService {
    @Autowired
    AddressDao addressDao;

    public AddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public void insertAddress(Address addressDetails) {
        addressDao.insertAddress(addressDetails);

    }

    @Override
    public List<Address> getAllAddress() {
        return addressDao.getAllAddress();
    }

    @Override
    public void updateAddress(Address addressDetails) {
        addressDao.updateAddress(addressDetails);

    }

    @Override
    public void deleteAddress(int addressId) throws SQLException {
        addressDao.deleteAddress(addressId);

    }

    @Override
    public Address getAddressById(int addressId) throws SQLException {
        return addressDao.getAddressById(addressId);
    }

    @Override
    public List<Address> getByUserId(int userId) {
        return addressDao.getByUserId(userId);
    }
}
