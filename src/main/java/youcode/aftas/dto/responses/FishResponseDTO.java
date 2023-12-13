package youcode.aftas.dto.responses;

import youcode.aftas.domain.Fish;
public record FishResponseDTO(
        String name,
        Double averageWeight,
        Integer level
) {
    public static FishResponseDTO fromFish(Fish fish){
        return new FishResponseDTO(
                fish.getName(),
                fish.getAverageWeight(),
                fish.getLevel() != null ? fish.getLevel().getShootingLevel() : null
        );
    }
}