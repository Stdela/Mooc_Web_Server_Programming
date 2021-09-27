package Classes;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course extends AbstractPersistable<Long> {
    private String name;
    @ManyToMany
    @JoinTable(
    name = "Enrollment",
    joinColumns = @JoinColumn( name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
            
    
    )
    private List<Student> students = new ArrayList<>();
    
}
