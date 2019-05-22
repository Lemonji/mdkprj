package com.mdkproject.mdk2019.services;

import com.mdkproject.mdk2019.entity.HearthCard;
import com.mdkproject.mdk2019.services.model.HealthCardModel;

import java.util.List;

public interface HearthCardService {

    //查询健康证(身份证号)
    HealthCardModel getHealthCard(String idCard);

    int daycardnum();

    List<HearthCard> weektjnum();

    String getlastnum();
}
