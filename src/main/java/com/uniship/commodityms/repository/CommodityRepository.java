package com.uniship.commodityms.repository;

import com.uniship.commodityms.domain.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CommodityRepository extends JpaRepository<Commodity, Integer> {

    List<Commodity> findByCustomerId(Integer customerId);
    void deleteByIdIn(List<Integer> ids);
}
