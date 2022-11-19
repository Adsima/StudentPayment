package edu.student.business;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"classpath:springContext.xml"})
public class StudentOrderServiceTest {

    @Autowired
    private StudentOrderService service;

    @Test
    public void testService() {
        service.testSave();
        service.testGet();
    }
}