package com.api.repository;

import com.api.model.GestorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface GestorRepository extends JpaRepository<GestorModel, Long> {
    
}
