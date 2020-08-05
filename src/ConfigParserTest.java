import static org.junit.jupiter.api.Assertions.*;

class ConfigParserTest {

    ConfigParser config1 = new ConfigParser("src/config/config.txt");
    ConfigParser config2 = new ConfigParser("src/config/config-staging.txt");
    ConfigParser config3 = new ConfigParser("src/config/config-dev.txt");

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("fintek", config1.get("application.name"));
        assertEquals("fintek-staging", config2.get("application.name"));
        assertEquals("fintek-development", config3.get("application.name"));
    }

    @org.junit.jupiter.api.Test
    void getDbname() {
        assertEquals("sq04_db", config1.get("dbname"));
        assertEquals("sq04_db", config2.get("dbname"));
        assertEquals("sq04_db-development", config3.get("dbname"));
    }

    @org.junit.jupiter.api.Test
    void getMode() {
        assertEquals("production", config1.get("mode"));
        assertEquals("staging", config2.get("mode"));
        assertEquals("development", config3.get("mode"));
    }

    @org.junit.jupiter.api.Test
    void getPipeline() {
        assertEquals("fast", config1.get("pipeline"));
        assertEquals("fast-staging", config2.get("pipeline"));
        assertEquals("fast-development", config3.get("pipeline"));
    }

    @org.junit.jupiter.api.Test
    void getPort() {
        assertEquals("8080", config1.get("application.port"));
        assertEquals("8081", config2.get("application.port"));
        assertEquals("8082", config3.get("application.port"));
    }

    @org.junit.jupiter.api.Test
    void getHost() {
        assertEquals("127.0.0.1", config1.get("host"));
        assertEquals("127.0.0.1", config2.get("host"));
        assertEquals("127.0.0.1", config3.get("host"));
    }

    @org.junit.jupiter.api.Test
    void getTheme() {
        assertEquals("green", config1.get("theme"));
        assertEquals("blue", config2.get("theme"));
        assertEquals("yellow", config3.get("theme"));
    }

    @org.junit.jupiter.api.Test
    void getContextUrl() {
        assertEquals("/api/v1", config1.get("application.context-url"));
        assertEquals("/api/v1", config2.get("application.context-url"));
        assertEquals("/api/v1", config3.get("application.context-url"));
    }
}