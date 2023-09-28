package vn.titv.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "hinh_anh")
public class HinhAnh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_hinh_anh", length = 256)
    private int maHinhAnh;

    @Column(name = "ten_hinh_anh", length = 256)
    private String tenHinhAnh;

    @Column(name = "la_icon")   // trong SQL la: tiny int
    private boolean laIcon;

    @Column(name = "duong_dan")
    private String duongDan;

    @Column(name = "du_lieu_anh")
    @Lob
    private String duLieuAnh;

    @ManyToOne(cascade = {CascadeType.DETACH,
                            CascadeType.PERSIST,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,}
    )
    @JoinColumn(name = "ma_sach", nullable = false)
    private Sach sach;
}
