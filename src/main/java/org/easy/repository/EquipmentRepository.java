package org.easy.repository;

import org.easy.domain.Dispositive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Dispositive, Long>{

}
