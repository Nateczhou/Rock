package com.nateczhou.rock.repository;

import com.nateczhou.rock.entity.Takes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakesRepository extends JpaRepository<Takes, String> {
}
