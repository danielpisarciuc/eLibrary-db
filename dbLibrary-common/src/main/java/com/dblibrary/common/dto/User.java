package com.dblibrary.common.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

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