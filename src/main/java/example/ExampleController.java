package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ExampleController {

    @Autowired
    private ServerConfiguration configuration;

    @Autowired
    private JniBridge jniBridge;

    @RequestMapping("/")
    public String index() {
        long[] values = {1,2,3,4,5,6,7,8,9,10};
        long[] results = jniBridge.calculateSquares(values);
        StringBuffer buffer = new StringBuffer();
        boolean isFirst = true;
        for (long result : results) {
            if (isFirst) {
                isFirst = false;
            }
            else {
                buffer.append(",");
            }
            buffer.append(result);
        }
        return "Results: " + buffer.toString();
    }
    
}
