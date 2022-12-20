package edu.student.business;

import edu.student.dao.*;
import edu.student.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Service
public class StudentOrderService {
    private final static Logger LOGGER = LoggerFactory.getLogger(StudentOrderService.class);

    @Autowired
    private StudentOrderRepository dao;
    @Autowired
    private StreetRepository street;
    @Autowired
    private StudentOrderStatusRepository daoStatus;
    @Autowired
    private PassportOfficeRepository passOfficeRepository;
    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private RegisterOfficeRepository regOfficeRepository;
    @Autowired
    private CountryAreaRepository areaRepository;
    @Autowired
    private StudentOrderChildRepository childRepository;

    @Transactional
    public void testSave() {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderDate(LocalDateTime.now());
        so.setStatus(daoStatus.getOne(1L));
        so.setCertificateNumber("12345");
        so.setMarriageDate(LocalDate.now());
        so.setRegisterOffice(regOfficeRepository.getOne(1L));
        so.setHusband(buildPerson(false));
        so.setWife(buildPerson(true));

        dao.save(so);

        StudentOrderChild soc = buildChild(so);
        childRepository.save(soc);
    }

    @Transactional
    public void testGet() {
        List<StudentOrder> sos = dao.findAll();
        LOGGER.info(sos.get(0).getWife().getGivename());
        LOGGER.info(sos.get(0).getHusband().getGivename());
    }

    private Adult buildPerson(boolean wife) {
        Adult p = new Adult();
        p.setDateOfBirth(LocalDate.now());
        Address a = new Address();
        a.setPostCode("1");
        a.setBuilding("23");
        a.setExtension("2");
        a.setApartment("173");
        a.setStreet(street.getOne(1L));
        if(wife) {
            p.setSurName("Петрова");
            p.setGivename("Ангелина");
            p.setPatronymic("Павловна");
            p.setAddress(a);
            p.setPassportSeria("1234");
            p.setPassportNumber("56789");
            p.setPassportOffice(passOfficeRepository.getOne(1L));
            p.setStudentNumber("12345");
            p.setUniversity(universityRepository.getOne(1L));
            p.setIssueDate(LocalDate.of(1975, Month.DECEMBER, 22));
        } else {
            p.setSurName("Петров");
            p.setGivename("Иван");
            p.setPatronymic("Васильевич");
            p.setAddress(a);
            p.setPassportSeria("9876");
            p.setPassportNumber("54321");
            p.setPassportOffice(passOfficeRepository.getOne(1L));
            p.setStudentNumber("23456");
            p.setUniversity(universityRepository.getOne(1L));
            p.setIssueDate(LocalDate.of(1975, Month.DECEMBER, 22));
        }
        return p;
    }

    private StudentOrderChild buildChild(StudentOrder so) {
        StudentOrderChild orderChild = new StudentOrderChild();
        orderChild.setOrder(so);

        Child c = new Child();
        c.setSurName("Петрова");
        c.setGivename("Ангелина");
        c.setPatronymic("Павловна");
        c.setDateOfBirth(LocalDate.now());
        c.setCertificateDate(LocalDate.now());
        c.setRegisterOffice(regOfficeRepository.getOne(1L));
        c.setCertificateNumber("CERT");

        Address a = new Address();
        a.setPostCode("1");
        a.setBuilding("23");
        a.setExtension("2");
        a.setApartment("173");
        a.setStreet(street.getOne(1L));
        c.setAddress(a);

        orderChild.setChild(c);

        return orderChild;
    }
}
