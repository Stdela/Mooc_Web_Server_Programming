
package Spring_Part2.Todo_Application;

import javax.persistence.Entity;
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
public class Task extends AbstractPersistable<Long> {

    private String task;
    private int visits;

   
        
}
