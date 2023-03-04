package agarere.io.rentACar.business.rules;

import agarere.io.rentACar.core.utilities.exceptions.BusinessException;
import agarere.io.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists (String name) {
        if (brandRepository.existsBrandByName(name)) {
            throw new BusinessException("Brand already exists !");
        }
    }
}
