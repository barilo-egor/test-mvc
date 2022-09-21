package org.example.service;

import org.example.enums.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class JspMappingService {
    public void mapObject(Object object, ModelMapper modelMapper, ModelMap modelMap) {
        modelMapper.getObjectMapper().apply(object, modelMap);
    }
}
