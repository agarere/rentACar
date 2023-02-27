package agarere.io.rentACar.dataAccess.abstracts;

import agarere.io.rentACar.entities.concretes.Brand;

import java.util.List;

public interface BrandRepository {
    List<Brand> getAll();
}
