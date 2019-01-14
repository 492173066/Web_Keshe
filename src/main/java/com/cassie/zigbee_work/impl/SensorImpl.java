package com.cassie.zigbee_work.impl;

import com.cassie.zigbee_dao.dao.SensorDao;
import com.cassie.zigbee_dao.entity.Sensor;
import com.cassie.zigbee_work.work.SensorWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sensorImpl")
public class SensorImpl implements SensorWork {

    @Autowired
    private SensorDao sensorDao;

    @Override
    public void add(Sensor sensor) {
        sensorDao.insert(sensor);
    }

    @Override
    public void remove(Integer id) {
        sensorDao.delete(id);
    }

    @Override
    public List<Sensor> getAll() {
        return sensorDao.selectAll();
    }
}
