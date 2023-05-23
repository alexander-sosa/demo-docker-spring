package bo.ucb.edu.bo.demodockerspring.api;

import bo.ucb.edu.bo.demodockerspring.bl.DummyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloApi {

    private final static Logger logger = LoggerFactory.getLogger(HelloApi.class);
    private DummyService dummyService;

    @Autowired
    public HelloApi(DummyService dummyService){
        this.dummyService = dummyService;
    }

    @GetMapping("/hello")
    public Map<String, String> greeting(@RequestParam String name, HttpServletRequest request){
        logger.info("Ingresando a greeting");
        HashMap<String, String> result = new HashMap<>();
        result.put("greeting", "Hello " + name);
        logger.info("Invocando a Dummy Service");
        result.put("random int", dummyService.calculateRandomNumber() + "");
        logger.info("Fin de Dummy Service");
        result.put("host-ip", request.getLocalAddr());
        result.put("host-name", request.getLocalName());
        logger.info("Retornando respuesta");
        return result;
    }
}
