package com.example.beanvalidation.controller;

import com.example.beanvalidation.model.DynamicFilterBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//for static filtering just add @JsonIgnore above the fields of the bean (DynamicFilterBean)
// this is an example for dynamic filtering Note: add @JsonFilter("BeanFilter") on the bean to make it work

@RestController
public class DynamicFilterController {

    @GetMapping("/get")
    public MappingJacksonValue getBean(){
        DynamicFilterBean dfb = new DynamicFilterBean("field1","field2,","field3");

        Set<String> props = new HashSet<>();
        props.add("field1");
        return getFilteredValue(dfb,props);
    }

    @GetMapping("/getAll")
    public MappingJacksonValue getAllBean(){
        List<DynamicFilterBean> dfbList = new ArrayList<>();

        dfbList.add(new DynamicFilterBean("field1","field2,","field3"));
        dfbList.add(new DynamicFilterBean("field1","field2,","field3"));
        dfbList.add(new DynamicFilterBean("field1","field2,","field3"));
        dfbList.add(new DynamicFilterBean("field1","field2,","field3"));

        Set<String> props = new HashSet<>();
        props.add("field1");
        props.add("field3");
        return getFilteredValue(dfbList,props);
    }


    private <T> MappingJacksonValue getFilteredValue(T bean, Set<String> propertiestoGet){
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(propertiestoGet);
        FilterProvider fProvide = new SimpleFilterProvider().addFilter("BeanFilter",filter);
        MappingJacksonValue val = new MappingJacksonValue(bean);
        val.setFilters(fProvide);
        return val;
    }

}
