package com.efx.sup.dao.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.efx.sup.domain.Data;

/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface DataRepository extends PagingAndSortingRepository<Data, Long> {
    Data findDataByBillingData(String data);
    Page findAll(Pageable pageable);
}
