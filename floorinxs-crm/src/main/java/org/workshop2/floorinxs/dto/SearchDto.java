package org.workshop2.floorinxs.dto;

import java.util.List;
import java.util.Map;

public interface SearchDto {
    public Map<String, List<String>> createSearchParamMap();
    public Map<String, String> createAliasesMap();
}
