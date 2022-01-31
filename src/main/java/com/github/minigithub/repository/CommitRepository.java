package com.github.minigithub.repository;

import java.util.Optional;

import com.github.minigithub.model.Commit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommitRepository extends JpaRepository<Commit, Long> {

    public Optional<Commit> findByHash(String hash);
}
