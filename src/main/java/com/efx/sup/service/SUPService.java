package com.efx.sup.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.efx.sup.dao.jpa.DataRepository;
import com.efx.sup.domain.Data;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class SUPService {

    private static final Logger log = LoggerFactory.getLogger(SUPService.class);

    @Autowired
    private DataRepository dataRepository;

    public SUPService() {
    }

    public Data createData(Data data) {
        return dataRepository.save(data);
    }

}
