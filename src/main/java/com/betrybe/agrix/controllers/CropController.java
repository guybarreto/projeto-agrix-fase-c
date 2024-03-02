package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.controllers.dto.FertilizerDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.FertilizerService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;

  /**
   * Instantiates a new Crop controller.
   *
   * @param cropService       the crop service
   * @param fertilizerService the fertilizer service
   */
  @Autowired
  public CropController(CropService cropService, FertilizerService fertilizerService) {
    this.cropService = cropService;
  }

  /**
   * Gets crop by id.
   *
   * @param id the id
   * @return the crop by id
   */
  @GetMapping("/{id}")
  public ResponseEntity<CropDto> getCropById(@PathVariable Long id) {
    Crop crop = cropService.getCropById(id);
    CropDto cropDto = CropDto.cropToCropDto(crop);
    return ResponseEntity.status(HttpStatus.OK).body(cropDto);
  }

  /**
   * Search crops by harvest date response entity.
   *
   * @param start the start
   * @param end   the end
   * @return the response entity
   */
  @GetMapping("/search")
  public ResponseEntity<List<CropDto>> searchCropsByHarvestDate(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end
  ) {
    List<Crop> crops = cropService.getCropsByHarvestDate(start, end);

    List<CropDto> cropDtoList = crops.stream()
        .map(CropDto::cropToCropDto)
        .toList();

    return ResponseEntity.status(HttpStatus.OK).body(cropDtoList);
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  @GetMapping()
  @Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
  public ResponseEntity<List<CropDto>> getAllCrops() {
    List<Crop> crops = cropService.getAllCrops();

    List<CropDto> cropDtoList = crops.stream()
        .map(CropDto::cropToCropDto)
        .toList();

    return ResponseEntity.status(HttpStatus.OK).body(cropDtoList);
  }

  /**
   * Associate fertilizer with crop response entity.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   * @return the response entity
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> associateFertilizerWithCrop(
      @PathVariable Long cropId,
      @PathVariable Long fertilizerId
  ) {
    cropService.associateFertilizerWithCrop(cropId, fertilizerId);
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body("Fertilizante e plantação associados com sucesso!");
  }

  /**
   * Gets fertilizers by crop id.
   *
   * @param cropId the crop id
   * @return the fertilizers by crop id
   */
  @GetMapping("/{cropId}/fertilizers")
  public ResponseEntity<List<FertilizerDto>> getFertilizersByCropId(@PathVariable Long cropId) {
    List<FertilizerDto> fertilizerDtoList = cropService.getFertilizersByCropId(cropId);
    return ResponseEntity.status(HttpStatus.OK).body(fertilizerDtoList);
  }
}
