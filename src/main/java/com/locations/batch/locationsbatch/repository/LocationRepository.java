package com.locations.batch.locationsbatch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.locations.batch.locationsbatch.model.Location;

public interface LocationRepository extends JpaRepository<Location, String> {

	@Query(value = "select * from \"location\" l where trim(l.city) = '' or l.city is null or lower(l.city) like lower('%null%') or trim(l.district) = '' or l.district is null or lower(l.district) like lower('%null%') or trim(l.street) = '' or l.street is null or lower(l.street) like lower('%null%')", nativeQuery = true)
	List<Location> findUncompletedLocation();

}
