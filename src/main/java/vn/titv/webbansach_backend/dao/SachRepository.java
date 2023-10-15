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

    // Cấu hình các endPoint để tìm kiếm
    // Containing: Để chỉ cần gõ vài ký tự đúng vẫn nhận (chứa key-word)
    // Có phân biệt chữ hoa và chữ thường

    // 3 loại tìm kiếm

    // Tìm kiếm theo tên sách
    Page<Sach> findByTenSachContaining(@RequestParam("tenSach") String tenSach, Pageable pageable);

    // EndPoint: mã thể loại
    Page<Sach> findByDanhSachTheLoai_MaTheLoai(@RequestParam("maTheLoai") int maTheLoai, Pageable pageable);

    // EndPoint: mã thể loại và tên sách
    Page<Sach> findByDanhSachTheLoai_MaTheLoaiAndTenSachContaining(@RequestParam("maTheLoai") int maTheLoai, @RequestParam("tenSach") String tenSach, Pageable pageable);
}
