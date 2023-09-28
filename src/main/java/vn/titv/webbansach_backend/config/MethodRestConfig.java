package vn.titv.webbansach_backend.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import vn.titv.webbansach_backend.entity.NguoiDung;
import vn.titv.webbansach_backend.entity.TheLoai;

@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {
    private String url ="http://localhost:8080";

    @Autowired
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] chanCacPhuongThuc = {
                HttpMethod.POST,
                HttpMethod.PUT,
                HttpMethod.PATCH,
                HttpMethod.DELETE,
        };

        // expose ids
        // cho phep id trong khi tra ve json
        // Tat ca
//        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));

        // Loai class nao duoc chi dinh
        // config.exposeIdsFor(TheLoai.class)

        // disable cai nao di: tat ca hoc tung cai; cho phep nguoi dung nao truy cap
//        disableHttpMethods(TheLoai.class, config, chanCacPhuongThuc);
//
//        HttpMethod[] phuongThucDelete = {
//                HttpMethod.DELETE
//        };
//        disableHttpMethods(NguoiDung.class, config, phuongThucDelete);
    }

    // Quy dinh pham vi
    private void disableHttpMethods(Class c,
                                 RepositoryRestConfiguration config,
                                 HttpMethod[] methods){
        config.getExposureConfiguration()
                .forDomainType(c)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(methods)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(methods)));
    }
}
