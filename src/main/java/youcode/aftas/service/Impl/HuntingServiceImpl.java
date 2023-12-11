package youcode.aftas.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import youcode.aftas.service.HuntingService;

@Component
@RequiredArgsConstructor
public class HuntingServiceImpl implements HuntingService {
    private final HuntingService huntingService;
}
