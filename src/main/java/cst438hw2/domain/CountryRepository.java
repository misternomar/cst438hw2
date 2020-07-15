package cst438hw2.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
	@Query(value = "SELECT * FROM Country where Code = :code", nativeQuery = true)
	Country findByCode(@Param("code") String code);
}