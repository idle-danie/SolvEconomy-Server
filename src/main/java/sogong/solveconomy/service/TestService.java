package sogong.solveconomy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    public String test() {
        return "this is data from service";
    }
}
