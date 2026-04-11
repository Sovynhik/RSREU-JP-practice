package ru.rsreu.savushkin.pr3.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.transaction.annotation.Transactional;
import ru.rsreu.savushkin.pr3.entity.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class CountryRepositoryTest {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    @Sql(scripts = "/test-data.sql", config = @SqlConfig(encoding = "UTF-8"))
    public void testLoadData() {
        assertEquals(3, countryRepository.findAll().size());
        Country germany = countryRepository.findAll().stream()
                .filter(c -> c.getName().equals("Germany"))
                .findFirst()
                .orElse(null);
        assertNotNull(germany);
    }

    @Test
    @SqlGroup({
            @Sql(scripts = "/test-schema.sql", config = @SqlConfig()),
            @Sql("/test-data.sql")
    })
    public void testLoadDataWithGroup() {
        assertEquals(3, countryRepository.findAll().size());
    }

    @Test
    @Sql(scripts = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void testWithExplicitPhase() {
        assertEquals(3, countryRepository.findAll().size());
    }
}