package org.fasttrackit.massage.persistance;

import org.fasttrackit.massage.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
