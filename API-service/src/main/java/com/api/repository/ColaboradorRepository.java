package com.api.repository;

import com.api.model.ColaboradorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miguel Castro
 */
@Repository
public interface ColaboradorRepository extends JpaRepository<ColaboradorModel, Long> {
    
}
