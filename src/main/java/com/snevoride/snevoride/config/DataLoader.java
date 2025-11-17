package com.snevoride.snevoride.config;

import com.snevoride.snevoride.entity.Driver;
import com.snevoride.snevoride.repository.DriverRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final DriverRepository driverRepository;

    public DataLoader(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        driverRepository.saveAll(List.of(
                new Driver("John Doe", "1234567890", true, 0.0, 0.0, "KA01AB1234", "Sedan"),
                new Driver("Alice", "9876543210", true, 0.0, 0.0, "KA01XY1234", "Sedan")
        ));
    }
}
