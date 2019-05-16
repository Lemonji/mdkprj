package com.mdkproject.mdk2019.services.impl;

import com.mdkproject.mdk2019.dao.HospitalMapper;
import com.mdkproject.mdk2019.entity.Hospital;
import com.mdkproject.mdk2019.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalMapper hospitalMapper;

    @Override
    public List<Hospital> findAll() {
        return hospitalMapper.findAll();
    }

    @Override
    public List<String> findbyqu(String quname) {
        return hospitalMapper.findbyqu(quname);
    }
}
