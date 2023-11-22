package gcg.akula.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public final class ResourceLoader {
    static Logger logger = LoggerFactory.getLogger(ResourceLoader.class);

    public static Optional<String> load(String path) {
        try {
            return Optional.of(new String(ResourceLoader.class.getResourceAsStream(path).readAllBytes()));
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return Optional.empty();
        }
    }
}
