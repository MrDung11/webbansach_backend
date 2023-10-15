package vn.titv.webbansach_backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import vn.titv.webbansach_backend.entity.Sach;

@RepositoryRestResource(path = "sach")
public interface SachRepository extends JpaRepository<Sach, Integer> {

    // Cấu hình các endPoint để ìm kiếm
    // Containing: Để chỉ cần gõ vài ký tự đúng vẫn nhận (chứa key-word)
    // Có phân biệt chữ hoa và chữ thường
    Page<Sach> findByTenSachContaining(@RequestParam("tenSach") String tenSach, Pageable pageable);
}
