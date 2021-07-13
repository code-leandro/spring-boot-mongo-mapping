package com.leandrodev.springbootmongomapping.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "school")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class School {

    @Id
    String id;
    String name;

    @DBRef
    Address address;
}
