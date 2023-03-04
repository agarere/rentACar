package agarere.io.rentACar.dataAccess.abstracts;

import agarere.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository // Artık bunu yazmana gerek yok.
// JpaRepositoryden extend yaptığı için bunun Repository olduğunu anlıyor.
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsBrandByName(String name);
}
