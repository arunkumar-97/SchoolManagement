package com.jesperapps.schoolmanagement.api.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.schoolmanagement.api.model.Year;

public interface YearRepository extends JpaRepository<Year, Integer> {

	Year findByYear(Integer year);

	Year findByYearId(Integer yearId);




}
