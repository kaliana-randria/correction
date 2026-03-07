package com.example.correction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.correction.entity.Resolution;
import com.example.correction.repository.ResolutionRepository;

@Service
public class ResolutionService {
    @Autowired
    private ResolutionRepository resolutionRepository;

    public List<Resolution> findAll() {
        return resolutionRepository.findAll();
    }

    public Resolution findById(int id) {
        return resolutionRepository.findById(id).orElse(null);
    }

    public Resolution save(Resolution resolution) {
        return resolutionRepository.save(resolution);
    }

    public void deleteById(int id) {
        resolutionRepository.deleteById(id);
    }
}
