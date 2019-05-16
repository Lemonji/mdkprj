package com.mdkproject.mdk2019.services;

import com.mdkproject.mdk2019.entity.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> findAll();

    List<String> findbyqu(String quname);
}
