package com.dblibrary.server.dao.entity;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "UserEntity")
@Table(name = "DBA_USERS")
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
    private String userEmail;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private Long phoneNumber;

    @Column(name = "REGISTRATION", unique = true, nullable = false)
    private String registration;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_TYPE", nullable = false)
    private String userType;

    @Column(name = "MODIFY_AT", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate modifyAt;

    public Integer getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    public LocalDate getModifyAt() {
        return modifyAt;
    }

    public void setModifyAt(LocalDate modifyAt) {
        this.modifyAt = modifyAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof UserEntity)) return false;

        UserEntity that = (UserEntity) o;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getUserId(), that.getUserId())
                .append(getUserName(), that.getUserName())
                .append(getUserEmail(), that.getUserEmail())
                .append(getPhoneNumber(), that.getPhoneNumber())
                .append(getRegistration(), that.getRegistration())
                .append(getPassword(), that.getPassword())
                .append(getUserType(), that.getUserType())
                .append(getModifyAt(), that.getModifyAt())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getUserId())
                .append(getUserName())
                .append(getUserEmail())
                .append(getPhoneNumber())
                .append(getRegistration())
                .append(getPassword())
                .append(getUserType())
                .append(getModifyAt())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("userId", userId)
                .append("userName", userName)
                .append("userEmail", userEmail)
                .append("phoneNumber", phoneNumber)
                .append("registration", registration)
                .append("password", password)
                .append("userType", userType)
                .append("modifyAt", modifyAt)
                .toString();
    }
}
