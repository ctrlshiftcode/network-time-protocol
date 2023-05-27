package io.github.ctrlshiftcode.ntp.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TimeRepositoryImpl implements TimeRepository {

    @Autowired
    private TimeService timeService;

    public Time getUTCTime() {
        return timeService.getNTPTime();
    }


}
