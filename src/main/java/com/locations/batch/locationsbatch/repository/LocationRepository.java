package com.locations.batch.locationsbatch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.locations.batch.locationsbatch.model.Location;

public interface LocationRepository extends JpaRepository<Location, String> {

	Page<Location> findByCityIsNullOrDistrictIsNullOrStreetIsNull(Pageable pageable);

}
