package vn.titv.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "chi_tiet_don_hang")
public class ChiTietDonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chi_tiet_don_hang")
    private long chiTietDonHang;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "gia_ban")
    private double giaBan;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST}
    )
    @JoinColumn(name = "ma_sach", nullable = false)
    private Sach sach;

    @ManyToOne(fetch = FetchType.LAZY,
                cascade = {CascadeType.DETACH,
                            CascadeType.PERSIST,
                            CascadeType.MERGE,
                            CascadeType.REFRESH}
    )
    @JoinColumn(name = "ma_don_hang")
    private DonHang donHang;
}
