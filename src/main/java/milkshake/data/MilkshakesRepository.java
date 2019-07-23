package milkshake.data;
import org.springframework.data.repository.CrudRepository;

import milkshake.Milkshakes;

public interface MilkshakesRepository 
                                  extends CrudRepository<Milkshakes, Long> {

}


