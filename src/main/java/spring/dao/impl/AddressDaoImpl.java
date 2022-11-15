package spring.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.AddressDao;
import spring.dao.repository.AddressRepository;
import spring.model.Address;

import java.sql.SQLException;
import java.util.List;

public class AddressDaoImpl implements AddressDao {
    @Autowired
    AddressRepository addressRepository;

    public AddressRepository getAddressRepository() {
        return addressRepository;
    }

    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void insertAddress(Address addressDetails) {
        addressRepository.save(addressDetails);

    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public void updateAddress(Address addressDetails) {
        addressRepository.save(addressDetails);
    }

    @Override
    public void deleteAddress(int addressId) throws SQLException {
        addressRepository.deleteById(addressId);

    }

    @Override
    public Address getAddressById(int addressId) throws SQLException {
        return addressRepository.findById(addressId).get();
    }

    @Override
    public List<Address> getByUserId(int userId) {
        return addressRepository.getByUserId(userId);
    }
}
