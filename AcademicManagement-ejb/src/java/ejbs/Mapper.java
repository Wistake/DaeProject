/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

/**
 *
 * @author sergi
 */
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
