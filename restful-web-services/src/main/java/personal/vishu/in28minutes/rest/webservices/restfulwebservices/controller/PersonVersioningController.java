package personal.vishu.in28minutes.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import personal.vishu.in28minutes.rest.webservices.restfulwebservices.bean.Name;
import personal.vishu.in28minutes.rest.webservices.restfulwebservices.bean.PersonV1;
import personal.vishu.in28minutes.rest.webservices.restfulwebservices.bean.PersonV2;

@RestController
public class PersonVersioningController
{
    //below two methods are examples of URI versioning
	@GetMapping("v1/person")
	public PersonV1 getPersonV1()
	{
		return new PersonV1("Vishu Kulkarni");
	}

	@GetMapping("v2/person")
	public PersonV2 getPersonV2()
	{
		return new PersonV2(new Name("Vishu", "Kulkarni"));
	}

    //below two methods are examples of request parameter versioning
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1()
	{
		return new PersonV1("Vishu Kulkarni");
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2()
	{
		return new PersonV2(new Name("Vishu", "Kulkarni"));
	}

    //below two methods are examples of (custom) header versioning
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1()
    {
        return new PersonV1("Vishu Kulkarni");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2()
    {
        return new PersonV2(new Name("Vishu", "Kulkarni"));
    }

    //below two are examples of MIME type versioning. Also called Media type or content negotiation
    // or accept header versioning
    @GetMapping(value = "/person/produces", produces = "application/vkk.company.app-v1+json")
    public PersonV1 producesV1()
    {
        return new PersonV1("Vishu Kulkarni");
    }

    @GetMapping(value = "/person/produces", produces = "application/vkk.company.app-v2+json")
    public PersonV2 producesV2()
    {
        return new PersonV2(new Name("Vishu", "Kulkarni"));
    }
}
