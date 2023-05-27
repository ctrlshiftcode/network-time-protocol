package io.github.ctrlshiftcode.ntp.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("/ntp/utcTime")
    public Optional<Time> getUTCTimeObject(){
        return Optional.ofNullable(timeService.getNTPTime());
    }
}
