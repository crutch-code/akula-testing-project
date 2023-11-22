package gcg.akula.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public final class ResourceLoader {
    static Logger logger = LoggerFactory.getLogger(ResourceLoader.class);

    public static Optional<String> load(String path) {
        try {
            return Optional.of(Files.readString(Paths.get(ResourceLoader.class.getResource(path).toURI())));
        } catch(Exception ex) {
            logger.error(ex.getMessage(), ex);
            return Optional.empty();
        }
    }
}
