package org.workshop2.floorinxs.dto;

import org.springframework.util.MultiValueMap;

public interface SearchDto {
    public MultiValueMap<String, String> createSearchParamMap();
}
