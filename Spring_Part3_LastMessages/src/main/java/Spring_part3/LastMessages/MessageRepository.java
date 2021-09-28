/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_part3.LastMessages;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author delam
 */
public interface MessageRepository extends JpaRepository<Messages,Long> {
//    List<Messages> findByNow(LocalDateTime time);
    
    
}
