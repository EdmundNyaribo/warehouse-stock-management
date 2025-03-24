package com.warehouse.stock.config;

import com.warehouse.stock.model.Supplier;
import org.springframework.data.jpa.domain.Specification;

public class SupplierSearchConfig {

    public static Specification<Supplier> hasNameLike(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    public static Specification<Supplier> createdBetween(Long createdDate, Long endDate) {
        return (root, query, criteriaBuilder) -> {
            if (createdDate == null && endDate == null) {
                return criteriaBuilder.conjunction();
            } else if (createdDate == null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("createdDate"), endDate);
            } else if (endDate == null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("createdDate"), createdDate);
            } else {
                return criteriaBuilder.between(root.get("createdDate"), createdDate, endDate);
            }
        };
    }
}
