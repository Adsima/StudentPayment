package edu.student.business;

import edu.student.dao.StudentOrderRepository;
import edu.student.domain.Person;
import edu.student.domain.StudentOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentOrderService {
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentOrderService.class);

    @Autowired
    private StudentOrderRepository dao;

    @Transactional
    public void testSave() {
        StudentOrder so = new StudentOrder();
        so.setHusband(buildPerson(false));
        so.setWife(buildPerson(true));

        dao.save(so);
    }

    @Transactional
    public void testGet() {
        List<StudentOrder> sos = dao.findAll();
        LOGGER.info(sos.get(0).getWife().getGivename());
        LOGGER.info(sos.get(0).getHusband().getGivename());
    }

    private Person buildPerson(boolean wife) {
        Person p = new Person();
        p.setDateOfBirth(LocalDate.now());
        if(wife) {
            p.setSurName("Петрова");
            p.setGivename("Ангелина");
            p.setPatronymic("Павловна");
        } else {
            p.setGivename("Петров");
            p.setGivename("Иван");
            p.setPatronymic("Васильевич");
        }
        return p;
    }
}
