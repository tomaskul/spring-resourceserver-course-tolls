package io.github.tomaskul.resourceserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TollController {
    private List<TollData> tollData;

    public TollController(){
        tollData = new ArrayList<>();
        tollData.add(new TollData("900", "1VB4GHA", "2023-04-21T13:00:00.123Z"));
        tollData.add(new TollData("901", "1VB4GHA", "2023-04-21T14:00:00.123Z"));
        tollData.add(new TollData("902", "1VB4GHA", "2023-04-21T14:30:00.123Z"));
    }

    @RequestMapping("/api/tolldata")
    public List<TollData> getTollData(){
        return tollData;
    }
}
