package org.openmrs.sync.core.repository.light;

import org.openmrs.sync.core.entity.light.ConceptNameLight;
import org.openmrs.sync.core.repository.OpenMrsRepository;
import org.springframework.cache.annotation.Cacheable;

public interface ConceptNameLightRepository extends OpenMrsRepository<ConceptNameLight> {

    @Override
    @Cacheable(cacheNames = "conceptName", unless="#result == null")
    ConceptNameLight findByUuid(String uuid);
}
