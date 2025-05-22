package com.nuna.management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity // 이 클래스를 데이터베이스 테이블과 매핑되는 엔티티로 선언합니다.
public class Product {

    // Getter 및 Setter 메소드
    @Id // 이 필드를 테이블의 기본 키(Primary Key)로 지정합니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 값을 자동으로 생성합니다 (DB에 따라 전략 다름).
    private Long id; // 상품 ID

    private String name; // 상품 이름
    private double price; // 상품 가격

    // 기본 생성자 (JPA 사용 시 필수)
    public Product() {
    }

    // 모든 필드를 포함하는 생성자 (편의상 추가)
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // toString 메소드 (디버깅 용이)
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

