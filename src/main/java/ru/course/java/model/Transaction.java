package ru.course.java.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @ApiModelProperty
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private int id;

    @ApiModelProperty
    @Column(name = "NAME")
    private String name;

    @ApiModelProperty
    @Column(name = "PRICE")
    private Integer price;
}
