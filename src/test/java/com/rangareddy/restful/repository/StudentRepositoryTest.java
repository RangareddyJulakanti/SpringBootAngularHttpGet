package com.rangareddy.restful.repository;

import com.rangareddy.restful.model.EAddress;
import com.rangareddy.restful.model.EStudent;
import com.rangareddy.restful.model.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by RANGAREJ on 5/5/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    public void testStudentData() {
        EStudent eStudent1 = new EStudent();
        eStudent1.setSname("Ranga");
        EStudent eStudent2 = new EStudent();
        eStudent2.setSname("Hari");
       /* EStudent eStudent3 = new EStudent();
        eStudent3.setSname("Krishna");*/
        EAddress eAddress1 = new EAddress();
        eAddress1.setAddress("BANGALORE");
        EAddress eAddress2 = new EAddress();
        eAddress2.setAddress("HYDERABAD");
        eStudent1.setAddressList(Arrays.asList(new EAddress[]{eAddress1}));
        eStudent2.setAddressList(Arrays.asList(new EAddress[]{eAddress2}));
        studentRepository.save(eStudent1);
        studentRepository.save(eStudent2);
       /* studentRepository.save(eStudent3);*/

        List<EStudent> studentList = studentRepository.findAll();

        Assert.assertEquals(2, studentList.size());
       List<EStudent> students= studentRepository.findStudentByAddressFiller("HYDERABAD");
        Assert.assertEquals(1, students.size());
        Assert.assertEquals("Hari", students.get(0).getSname());

    }
}
