import static org.junit.jupiter.api.Assertions.*;

class ConfigParserTest {

    ConfigParser config1 = new ConfigParser("src/config/config.txt");
    ConfigParser config2 = new ConfigParser("src/config/config-staging.txt");
    ConfigParser config3 = new ConfigParser("src/config/config-dev.txt");

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("fintek", config1.getName());
        assertEquals("fintek-staging", config2.getName());
        assertEquals("fintek-development", config3.getName());
    }

    @org.junit.jupiter.api.Test
    void getDbname() {
        assertEquals("sq04_db", config1.getDbname());
        assertEquals("sq04_db", config2.getDbname());
        assertEquals("sq04_db-development", config3.getDbname());
    }

    @org.junit.jupiter.api.Test
    void getMode() {
        assertEquals("production", config1.getMode());
        assertEquals("staging", config2.getMode());
        assertEquals("development", config3.getMode());
    }

    @org.junit.jupiter.api.Test
    void getPipeline() {
        assertEquals("fast", config1.getPipeline());
        assertEquals("fast-staging", config2.getPipeline());
        assertEquals("fast-development", config3.getPipeline());
    }

    @org.junit.jupiter.api.Test
    void getPort() {
        assertEquals("8080", config1.getPort());
        assertEquals("8081", config2.getPort());
        assertEquals("8082", config3.getPort());
    }

    @org.junit.jupiter.api.Test
    void getHost() {
        assertEquals("127.0.0.1", config1.getHost());
        assertEquals("127.0.0.1", config2.getHost());
        assertEquals("127.0.0.1", config3.getHost());
    }

    @org.junit.jupiter.api.Test
    void getTheme() {
        assertEquals("green", config1.getTheme());
        assertEquals("blue", config2.getTheme());
        assertEquals("yellow", config3.getTheme());
    }

    @org.junit.jupiter.api.Test
    void getContextUrl() {
        assertEquals("/api/v1", config1.getContextUrl());
        assertEquals("/api/v1", config2.getContextUrl());
        assertEquals("/api/v1", config3.getContextUrl());
    }
}