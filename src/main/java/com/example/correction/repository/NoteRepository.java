package com.example.correction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.correction.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{
    List<Note> findByCandidatIdAndMatiereId(int candidatId, int matiereId);
}
