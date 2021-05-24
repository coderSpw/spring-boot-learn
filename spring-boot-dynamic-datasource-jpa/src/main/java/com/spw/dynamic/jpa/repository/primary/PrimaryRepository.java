package com.spw.dynamic.jpa.repository.primary;

import com.spw.dynamic.jpa.model.Sync;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryRepository extends JpaRepository<Sync, Integer> {
}
