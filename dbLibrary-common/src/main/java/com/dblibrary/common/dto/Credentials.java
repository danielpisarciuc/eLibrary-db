package com.dblibrary.common.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Credentials {

    private String registration;
    private String password;


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

    public boolean hasValidRegistration() {
        return registration == null || registration.isEmpty();
    }

    public boolean hasValidPassword() {
        return password == null || password.isEmpty();
    }

    public boolean hasValidCredentials() {
        return hasValidRegistration() && hasValidPassword();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Credentials)) return false;

        Credentials that = (Credentials) o;

        return new EqualsBuilder()
                .append(getRegistration(), that.getRegistration())
                .append(getPassword(), that.getPassword())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getRegistration())
                .append(getPassword())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("registration", registration)
                .append("password", password)
                .toString();
    }
}
