package com.nuna.management.service;

import com.nuna.management.entity.Product;
import com.nuna.management.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired; // 의존성 주입 어노테이션
import org.springframework.stereotype.Service; // Service 컴포넌트 어노테이션

import java.util.List;
import java.util.Optional; // 조회 결과가 없을 수도 있으므로 Optional 사용

@Service // 이 클래스를 Service 컴포넌트로 스프링에 등록합니다.
public class ProductService {

    private final ProductRepository productRepository; // 리포지토리 의존성 주입

    @Autowired // 스프링 컨테이너가 ProductRepository 객체를 주입해줍니다.
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 상품 생성 (Create)
    public Product createProduct(Product product) {
        return productRepository.save(product); // 리포지토리의 save 메소드 호출
    }

    // 상품 단건 조회 (Read - by ID)
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id); // 리포지토리의 findById 메소드 호출
    }

    // 상품 전체 조회 (Read - all)
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // 리포지토리의 findAll 메소드 호출
    }

    // 상품 수정 (Update)
    public Product updateProduct(Long id, Product updatedProduct) {
        // 해당 ID의 상품이 존재하는지 확인
        return productRepository.findById(id)
                .map(product -> {
                    // 존재하면 정보 업데이트
                    product.setName(updatedProduct.getName());
                    product.setPrice(updatedProduct.getPrice());
                    return productRepository.save(product); // 변경된 상품 저장 (ID가 있으면 Update, 없으면 Insert)
                })
                .orElse(null); // 존재하지 않으면 null 반환 또는 예외 처리
    }

    // 상품 삭제 (Delete)
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) { // 해당 ID의 상품이 존재하는지 확인
            productRepository.deleteById(id); // 존재하면 삭제
            return true; // 삭제 성공
        }
        return false; // 삭제할 상품 없음
    }
}

