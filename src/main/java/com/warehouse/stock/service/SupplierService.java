package com.warehouse.stock.service;

import com.warehouse.stock.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);

    Optional<Supplier> getSupplierById(Long id);

    Page<Supplier> getAllSuppliers(Pageable pageable, String name, Long createdDate, Long endDate);

    Supplier updateSupplier(Long id, Supplier supplier);

    void deleteSupplier(Long id);
}
