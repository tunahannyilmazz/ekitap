package com.kitap.ekitap.repository;

import com.kitap.ekitap.model.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KitapRepository extends JpaRepository<Kitap, Long> {
    // özel sorgular yazılabilir (örneğin yazar adına göre kitap bulma gibi)
}
