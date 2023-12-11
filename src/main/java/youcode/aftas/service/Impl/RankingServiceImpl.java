package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import youcode.aftas.service.RankingService;

@Component
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {
    private final RankingService rankingService;
}
