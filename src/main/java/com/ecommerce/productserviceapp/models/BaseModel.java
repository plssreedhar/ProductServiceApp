package com.ecommerce.productserviceapp.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public class BaseModel {
    @Id
    private String id;
    private Date createdAt;
    private Date modifiedAt;
}
