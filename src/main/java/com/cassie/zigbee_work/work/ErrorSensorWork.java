package com.cassie.zigbee_work.work;

import com.cassie.zigbee_dao.entity.ErrorSensor;

import java.util.List;

public interface ErrorSensorWork {

    void add(ErrorSensor errorSensor);
    void remove(Integer id);
    List<ErrorSensor> getAll();
}
