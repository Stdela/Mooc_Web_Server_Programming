
package Spring_part3.Exams_and_questions;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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

public class Question extends AbstractPersistable<Long> {
private String title;
private String content;
@ManyToMany
private List<Exam> exams =  new ArrayList<>();


}
