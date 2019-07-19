package org.openmrs.sync.core.repository.light;

import org.openmrs.sync.core.entity.light.ProviderAttributeTypeLight;
import org.openmrs.sync.core.repository.OpenMrsRepository;
import org.springframework.cache.annotation.Cacheable;

public interface ProviderAttributeTypeLightRepository extends OpenMrsRepository<ProviderAttributeTypeLight> {

    @Override
    @Cacheable(cacheNames = "providerAttributeType", unless="#result == null")
    ProviderAttributeTypeLight findByUuid(String uuid);
}
