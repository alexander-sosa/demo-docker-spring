package bo.ucb.edu.bo.demodockerspring.bl;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DummyService {
    public int calculateRandomNumber(){
        return (new Random()).nextInt();
    }
}
