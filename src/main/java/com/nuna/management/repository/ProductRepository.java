package com.nuna.management.repository;

import com.nuna.management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository; // Spring Data JPA 인터페이스

// JpaRepository를 상속받으면 기본적인 CRUD 메소드가 자동으로 제공됩니다.
// <엔티티 타입, 기본 키 타입>
public interface ProductRepository extends JpaRepository<Product, Long> {
    // 추가적인 데이터 조회 메소드가 필요하면 여기에 정의할 수 있습니다.
    // 예: List<Product> findByName(String name);
}