package vn.titv.webbansach_backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.titv.webbansach_backend.dao.ChiTietDonHangRepository;

@RestController
public class TestController {

    private ChiTietDonHangRepository repository;

    @Autowired
    public TestController (ChiTietDonHangRepository repository){
        this.repository = repository;
    }

    @GetMapping("/")
    public void test(){
//        ChiTietDonHang ctdh = new ChiTietDonHang();
//        repository.findById(2);
//        repository.saveAndFlush(ctdh);
    }
}
