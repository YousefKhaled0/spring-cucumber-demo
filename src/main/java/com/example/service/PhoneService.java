package com.example.service;

import com.example.model.Phone;
import com.example.repository.PhoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class PhoneService {
    @Autowired
    private final PhoneRepository phoneRepository;

    public Phone addPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    public Phone getPhone(UUID id) {
        return phoneRepository.findById(id.toString()).orElseThrow();
    }

    public void delete(UUID id) {
        phoneRepository.delete(getPhone(id));
    }

    public List<Phone> all() {
        return phoneRepository.findAll();
    }
}
