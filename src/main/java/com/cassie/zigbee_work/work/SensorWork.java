package com.cassie.zigbee_work.work;

import com.cassie.zigbee_dao.entity.Sensor;

import java.util.List;

public interface SensorWork {

    void add(Sensor sensor);
    void remove(Integer id);
    List<Sensor> getAll();
}
