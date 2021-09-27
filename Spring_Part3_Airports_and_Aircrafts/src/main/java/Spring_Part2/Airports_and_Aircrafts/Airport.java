package Spring_Part2.Airports_and_Aircrafts;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.Setter;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author delam
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport extends AbstractPersistable<Long> {

    private String identifier;
    private String name;
    @OneToMany(mappedBy = "airport")
    private List<Aircraft> aircrafts = new ArrayList<>();
}
