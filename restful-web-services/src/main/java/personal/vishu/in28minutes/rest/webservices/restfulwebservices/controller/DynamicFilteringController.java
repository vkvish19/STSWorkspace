package personal.vishu.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import personal.vishu.in28minutes.rest.webservices.restfulwebservices.bean.DynamicFilteringBean;

@RestController
public class DynamicFilteringController
{

	//this will show only field1, field2
	@GetMapping(path = "/dynamic-filtering-bean")
	public MappingJacksonValue getDynamicFilteringBean()
	{
		DynamicFilteringBean bean = new DynamicFilteringBean("field1", "field2", "field3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	//this will show only field2, field3
	@GetMapping(path = "/dynamic-filtering-list")
	public MappingJacksonValue getListOfDynamicFilteringBean()
	{
		List<DynamicFilteringBean> list =  Arrays.asList(
				new DynamicFilteringBean("field1", "field2", "field3"),
				new DynamicFilteringBean("field11", "field22", "field33")
				);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;		
	}
}
