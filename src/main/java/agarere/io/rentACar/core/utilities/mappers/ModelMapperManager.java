package agarere.io.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service // Her seferinde yeni mapper istemiyorum. IoC'ye eklenmesini istiyorum.
@AllArgsConstructor
public class ModelMapperManager implements  ModelMapperService {

    // Bundan bir tane üretilecek.
    // Constracter ile inject edilecek. -> AllArgsConstructor
    private ModelMapper modelMapper;

    @Override
    public ModelMapper forResponse() {
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
                // LOOSE: Bütün alanları maplemez, olanları mapler.
                // STRICT: Bütün alanların maplenmesi gerekir.
        return modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
                // STANDARD akıllıca eşleştirir.

        return  modelMapper;
    }
}
