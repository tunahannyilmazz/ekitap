package com.kitap.ekitap.controller;

import com.kitap.ekitap.model.Kitap;
import com.kitap.ekitap.service.KitapService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kitaplar")
public class KitapController {

    private final KitapService kitapService;

    public KitapController(KitapService kitapService) {
        this.kitapService = kitapService;
    }

    @GetMapping
    public List<Kitap> kitaplariListele() {
        return kitapService.getAllKitaplar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitap> kitapGetir(@PathVariable Long id) {
        return kitapService.getKitapById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Kitap kitapEkle(@RequestBody Kitap kitap) {
        return kitapService.kitapEkle(kitap);
    }

    @DeleteMapping("/{id}")
    public void kitapSil(@PathVariable Long id) {
        kitapService.kitapSil(id);
    }
}
