
package Spring_Part4.GifRepository;
import javax.persistence.Entity;
import javax.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author delam
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gif extends AbstractPersistable<Long> {

    
    private int visits;
    @Lob
    private byte[] content;
}
