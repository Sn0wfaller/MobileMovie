package com.infinity.movies.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    @Value("classpath:data.sql")
    private Resource dataScript;

    @Override
    public void run(String... args) throws Exception {
        if (!isDatabaseInitialized()) {
            ResourceDatabasePopulator populator = new ResourceDatabasePopulator(dataScript);
            DatabasePopulatorUtils.execute(populator, Objects.requireNonNull(jdbcTemplate.getDataSource()));
        }
    }

    private boolean isDatabaseInitialized() {
        int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM authority", Integer.class);
        return count > 0;
    }
}