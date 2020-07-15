package cst438hw2.domain;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	@Query(value = "SELECT * FROM City where Name = :name", nativeQuery = true)
	List<City> findByName(@Param("name") String name);
}
