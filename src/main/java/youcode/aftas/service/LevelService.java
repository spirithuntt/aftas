package youcode.aftas.service;

import org.springframework.stereotype.Service;

@Service
public interface LevelService {
    void addLevel(Integer level, String description, Integer points);
}
