package com.one.ourwiki.repository;

import com.one.ourwiki.domain.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributorRepository extends JpaRepository<Contributor,Long> {
}
