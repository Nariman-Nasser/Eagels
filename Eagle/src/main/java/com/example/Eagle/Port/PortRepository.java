package com.example.Eagle.Port;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortRepository extends JpaRepository<Port, Long > {
    List<Port> findByportnameIgnoreCaseStartingWith(String prefix);

}
