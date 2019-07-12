package personal.vishu.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import personal.vishu.in28minutes.rest.webservices.restfulwebservices.bean.StaticFilteringBean;

@RestController
public class StaticFilteringController
{

	@GetMapping(path = "/static-filtering-bean")
	public StaticFilteringBean getStaticFilteringBean()
	{
		return new StaticFilteringBean("field1", "field2", "field3");
	}
	
	@GetMapping(path = "/static-filtering-list")
	public List<StaticFilteringBean> getListOfStaticFilteringBean()
	{
		return Arrays.asList(
				new StaticFilteringBean("field1", "field2", "field3"),
				new StaticFilteringBean("field11", "field21", "field31")
				);
	}
	
}
