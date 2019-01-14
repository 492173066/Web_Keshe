package com.cassie.zigbee_work.impl;

import com.cassie.zigbee_dao.dao.ErrorSensorDao;
import com.cassie.zigbee_dao.entity.ErrorSensor;
import com.cassie.zigbee_work.work.ErrorSensorWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("errorSensorImpl")
public class ErrorSensorImpl implements ErrorSensorWork {

    @Autowired
    private ErrorSensorDao errorSensorDao;

    @Override
    public void add(ErrorSensor errorSensor) {
        errorSensorDao.insert(errorSensor);
    }

    @Override
    public void remove(Integer id) {
        errorSensorDao.delete(id);
    }

    @Override
    public List<ErrorSensor> getAll() {
        return errorSensorDao.selectAll();
    }
}
