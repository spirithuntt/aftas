package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import youcode.aftas.domain.Level;
import youcode.aftas.repository.LevelRepository;
import youcode.aftas.service.LevelService;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;
 @Override
 public Level addLevel(Level level) {
     Level levels = levelRepository.findAll().stream().max((l1, l2) -> l1.getPoints() > l2.getPoints() ? 1 : -1).orElse(null);
     if(levels != null) {
         if(level.getPoints() <= levels.getPoints()) {
             throw new RuntimeException("Points should be higher than the previous level");
         }
     }
     return levelRepository.save(level);
 }

    @Override
    public Level getLevelById(Long id) {
        return levelRepository.findById(id).orElseThrow(() -> new RuntimeException("Level not found"));
    }

    @Override
    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    @Override
    public void deleteLevel(Long id) {
        levelRepository.deleteById(id);
    }

}
