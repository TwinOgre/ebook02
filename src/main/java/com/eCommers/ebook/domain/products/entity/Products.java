package com.eCommers.ebook.domain.products.entity;

import com.eCommers.ebook.domain.users.entity.Users;
import com.eCommers.ebook.global.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Products extends BaseEntity {
    @Column(unique = true)
    private String productName;

    @Column
    private String productIntroduce;

    @Column
    private Integer price;

    @Column
    private float discount;

    @Column
    private float averageRating;

    @Column
    private boolean isReported;

    @ManyToOne
    private Users seller;
}
