package youcode.aftas.service;

import org.springframework.stereotype.Service;
import youcode.aftas.domain.Level;

import java.util.List;

@Service
public interface LevelService {

    Level getLevelById(Long id);

    List<Level> getAllLevels();

    void deleteLevel(Long id);

    Level addLevel(Level level);

}
