package Spring_Part4.GifRepository;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author delam
 */
public interface GifRepository extends JpaRepository<Gif,Long> {

}

