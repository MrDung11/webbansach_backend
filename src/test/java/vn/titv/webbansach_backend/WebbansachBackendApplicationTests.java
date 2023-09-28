package vn.titv.webbansach_backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import vn.titv.webbansach_backend.entity.TheLoai;

@SpringBootTest
class WebbansachBackendApplicationTests {

	@Test
	void contextLoads() {
		TheLoai theLoai = new TheLoai();
		theLoai.setMaTheLoai(1);
		theLoai.setTenTheLoai("Giáo Khoa");

//		ChiTietDonHang ctdh = new ChiTietDonHang();
//		CHiTietDonHangRepository repository = new CHiTietDonHangRepository() {
//		};
	}

}
