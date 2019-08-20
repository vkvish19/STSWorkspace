package personal.vishu.in28minutes.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import personal.vishu.in28minutes.microservices.limitsservice.bean.LimitConfigurationBean;
import personal.vishu.in28minutes.microservices.limitsservice.configuration.LimitsConfiguration;

@RestController
public class LimitsCofigurationController
{
    @Autowired
    LimitsConfiguration configuration;

    @GetMapping("/limits")
    public LimitConfigurationBean retrieveLimitsFromConfiguration()
    {
        return new LimitConfigurationBean(configuration.getMaximum(), configuration.getMinimum());
    }

    @GetMapping("fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitConfigurationBean retrieveConfiguration()
    {
        throw new RuntimeException("Not Available");
    }
    
    public LimitConfigurationBean fallbackRetrieveConfiguration()
    {
        return new LimitConfigurationBean(999, 9);
    }
}
