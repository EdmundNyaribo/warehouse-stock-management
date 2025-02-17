package com.warehouse.stock.service.Impl;

import com.warehouse.stock.model.Supplier;
import com.warehouse.stock.repository.SupplierRepository;
import com.warehouse.stock.service.SupplierService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public Page<Supplier> getAllSuppliers(Pageable pageable) {
        return supplierRepository.findAll(pageable);
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        return supplierRepository.findById(id).map(existingSupplier -> {
            existingSupplier.setName(supplier.getName());
            existingSupplier.setEmail(supplier.getEmail());
            existingSupplier.setPhoneNumber(supplier.getPhoneNumber());
            existingSupplier.setAddress(supplier.getAddress());
            existingSupplier.setCity(supplier.getCity());
            existingSupplier.setState(supplier.getState());
            existingSupplier.setZipcode(supplier.getZipcode());
            return supplierRepository.save(existingSupplier);
        }).orElseThrow(() -> new RuntimeException("Supplier not found with ID: " + id));
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

}
