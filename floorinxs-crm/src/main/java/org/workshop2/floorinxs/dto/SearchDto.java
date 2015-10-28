package org.workshop2.floorinxs.dto;

import java.util.Map;
import org.springframework.util.MultiValueMap;

public interface SearchDto {
    public MultiValueMap<String, String> createSearchParamMap();
    public Map<String, String> createAliasesMap();
}
