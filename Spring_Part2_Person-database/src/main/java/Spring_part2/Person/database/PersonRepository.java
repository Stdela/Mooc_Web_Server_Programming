/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spring_part2.Person.database;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author delam
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
    
}
