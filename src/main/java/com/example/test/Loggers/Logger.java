package com.example.test.Loggers;

import com.example.test.DatabaseEntities.DatabaseDepartment;
import com.example.test.DatabaseEntities.DatabaseEmployee;

import java.util.Calendar;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Logger {
//    public void logInEmployee(DatabaseEmployee databaseEmployee, Calendar Date, boolean isHired) {
//        Optional<DatabaseDepartment> department = departmentRepository.findById(databaseEmployee.getDepartmentId());
//        String logString = "";
//        logString.concat(Date.getTime() + ". Сотрудник " + databaseEmployee.getUid());
//        if (isHired) {
//            logString.concat(" нанят " + databaseEmployee.getHiredTime() +
//                    ". Отдел: " + department.get().getName());
//        } else {
//            long timeDiff = databaseEmployee.getFiredTime().getTime() - databaseEmployee.getHiredTime().getTime();
//            long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
//            logString.concat(" уволен " + databaseEmployee.getFiredTime() +
//                    ". Отдел: " + department.get().getName()
//                    + " Проработал: " + daysDiff);
//        }
//    }
}
