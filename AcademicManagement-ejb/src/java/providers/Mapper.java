package providers;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Default
@ApplicationScoped
public class Mapper extends ModelMapper {
    
    @PostConstruct
    private void init() {
        getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }
        
    public <S, D> List<D> map(List<S> source, Class<D> destinationClass) {
        List<D> destination = new LinkedList<>();
        source.forEach(s -> destination.add(map(s, destinationClass)));
        return destination;
    }
}
