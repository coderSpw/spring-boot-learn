package com.spw.dynamic.jpa.repository.secondary;

import com.spw.dynamic.jpa.model.Sync;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryRepository extends JpaRepository<Sync, Integer> {
}
