package com.example.web;

import com.example.model.Phone;
import com.example.service.PhoneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/phones")
@AllArgsConstructor
public class PhoneController {

    @Autowired
    private final PhoneService phoneService;

    @PostMapping
    public Phone addPhone(@RequestBody Phone phone) {
        return phoneService.addPhone(phone);
    }

    @GetMapping
    public List<Phone> getAll() {
        return phoneService.all();
    }

    @GetMapping("/{id}")
    public Phone getPhone(@PathVariable UUID id) {
        return phoneService.getPhone(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePhone(@PathVariable UUID id) {
        phoneService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
