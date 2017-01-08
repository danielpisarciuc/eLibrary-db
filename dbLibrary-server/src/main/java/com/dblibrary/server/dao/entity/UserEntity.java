package com.dblibrary.server.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "UserEntity")
@Table(name = "DBA_USERS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USER_ID", unique = true, nullable = false)
    private Long userId;

    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "USER_EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private Long phoneNumber;

    @Column(name = "REGISTRATION", unique = true, nullable = false)
    private String registration;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_TYPE", nullable = false)
    private String type;

    @Column(name = "MODIFY_AT", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate modifyAt;

}
