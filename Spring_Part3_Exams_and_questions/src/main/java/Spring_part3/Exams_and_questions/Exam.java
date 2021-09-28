
package Spring_part3.Exams_and_questions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
public class Exam extends AbstractPersistable<Long> {
private String subject;
private LocalDate date;
@ManyToMany
private List <Question> questions = new ArrayList<>();

}
