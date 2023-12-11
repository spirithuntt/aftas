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
    @Override
    public void addLevel(Integer shootingLevel, String Description, Integer points) {
        if (levelRepository.existsByShootingLevel(shootingLevel) && levelRepository.existsByPoints(points)) {
            throw new RuntimeException("Level already exists");
        } else if (levelRepository.existsByShootingLevel(shootingLevel) && levelRepository.existsByPointsGreaterThanEqual(points)) {
            throw new RuntimeException("Points should be higher than the previous level");
        } else if (levelRepository.existsByShootingLevel(shootingLevel) && levelRepository.existsByPointsLessThanEqual(points)) {
            throw new RuntimeException("Points should be lower than the previous level");
        } else {
            Level level = new Level();
            level.setShootingLevel(shootingLevel);
            level.setDescription(Description);
            level.setPoints(points);
            levelRepository.save(level);
        }
    }

}
