package com.kitap.ekitap.service;

import com.kitap.ekitap.model.Kitap;
import com.kitap.ekitap.repository.KitapRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KitapService {

    private final KitapRepository kitapRepository;

    public KitapService(KitapRepository kitapRepository) {
        this.kitapRepository = kitapRepository;
    }

    public List<Kitap> getAllKitaplar() {
        return kitapRepository.findAll();
    }

    public Optional<Kitap> getKitapById(Long id) {
        return kitapRepository.findById(id);
    }

    public Kitap kitapEkle(Kitap kitap) {
        return kitapRepository.save(kitap);
    }

    public void kitapSil(Long id) {
        kitapRepository.deleteById(id);
    }
}
