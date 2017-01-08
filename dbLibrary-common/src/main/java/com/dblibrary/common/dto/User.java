package com.dblibrary.common.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String type;

    @NonNull
    private Long phoneNumber;
}