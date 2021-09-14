package Spring_part2.ItemDatabase;



import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author delam
 */
public interface ItemRepository extends JpaRepository<Item,Long> {
    
}
