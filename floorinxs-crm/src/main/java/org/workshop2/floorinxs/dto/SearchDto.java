package org.workshop2.floorinxs.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface SearchDto extends Serializable {
    public Map<String, List<String>> createSearchParamMap();
    public Map<String, String> createAliasesMap();
}
