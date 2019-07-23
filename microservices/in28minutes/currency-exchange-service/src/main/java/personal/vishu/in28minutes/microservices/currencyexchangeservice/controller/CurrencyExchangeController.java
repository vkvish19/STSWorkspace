package personal.vishu.in28minutes.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import personal.vishu.in28minutes.microservices.currencyexchangeservice.bean.ExchangeValue;
import personal.vishu.in28minutes.microservices.currencyexchangeservice.repository.ExchangeValueRepository;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController
{
    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable(value = "from") String from, @PathVariable(value = "to") String to)
    {
//        ExchangeValue exchangeValue = new ExchangeValue(1001L, from, to, BigDecimal.valueOf(65));
        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
        int portValue = Integer.parseInt(environment.getProperty("local.server.port"));
        exchangeValue.setPort(portValue);
        return exchangeValue;
    }
}
