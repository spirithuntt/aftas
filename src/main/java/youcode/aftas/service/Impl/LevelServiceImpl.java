package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import youcode.aftas.domain.Level;
import youcode.aftas.repository.LevelRepository;
import youcode.aftas.service.LevelService;

@Component
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;

    public void addLevel(Integer shootingLevel, String Description, Integer points) {
        if (levelRepository.existsByPointsGreaterThanEqual(points)) {
            System.out.println("Level already exists");
        } else {
            Level level = new Level();
            level.setShootingLevel(shootingLevel);
            level.setDescription(Description);
            level.setPoints(points);
            levelRepository.save(level);
        }
    }

}
