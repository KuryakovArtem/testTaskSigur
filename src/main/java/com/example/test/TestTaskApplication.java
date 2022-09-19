package com.example.test;

import com.example.test.Services.DepartmentGenerator;
import com.example.test.Services.EmployeesMgr;
import com.example.test.Services.GuestsMgr;
//import com.example.test.Services.MainService;
import com.example.test.Services.PassEmulator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootApplication
public class TestTaskApplication {//implements CommandLineRunner

    public static void main(String[] args) throws ParseException, NoSuchAlgorithmException, InterruptedException {
//		SpringApplication.run(TestTaskApplication.class, args);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar hiringPeriod = Calendar.getInstance();
        String startDate = "01-01-2022";
        hiringPeriod.setTime(simpleDateFormat.parse(startDate));
        Calendar endOfHiringPeriod = Calendar.getInstance();
        String endDate = "01-01-2023";
        endOfHiringPeriod.setTime(simpleDateFormat.parse(endDate));
        ApplicationContext context = SpringApplication.run(TestTaskApplication.class, args);
        DepartmentGenerator generator = (DepartmentGenerator) context.getBean("departmentGenerator");
        generator.generateDepartment();
        EmployeesMgr mgr = (EmployeesMgr) context.getBean("employeesMgr");
        GuestsMgr guestsMgr = (GuestsMgr) context.getBean("guestsMgr");
        PassEmulator emulator = (PassEmulator) context.getBean("passEmulator");
        int hireNumber = 1;
        while (hiringPeriod.before(endOfHiringPeriod)) {
            mgr.generateEmployee(hiringPeriod, hireNumber);
            guestsMgr.createGuestsVisit();
            for (int i = 0; i < 10; i++) {
                emulator.emulate(hiringPeriod);
            }
            hireNumber++;
            hiringPeriod.add(Calendar.DATE, 1);
        }
    }


//	@Override
//	public void run(String... args)  {
//		ApplicationContext context = SpringApplication.run(TestTaskApplication.class, args);
//		MainService service = (MainService) context.getBean("mainService");
//		ApplicationContext context = SpringApplication.run(TestTaskApplication.class, args);
//		DepartmentGenerator generator = (DepartmentGenerator) context.getBean("departmentGenerator");
//		generator.generateDepartment();
//		EmployeesMgr mgr = (EmployeesMgr) context.getBean("employeesMgr");
//		mgr.generateEmployee();
//	}

}
