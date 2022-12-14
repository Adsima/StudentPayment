package edu.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jc_order_status")
public class StudentOrderStatus {
    @Id
    @Column(name = "status_id")
    private Long statusId;
    @Column(name = "status_name")
    private String statusName;
}
