package io.github.ctrlshiftcode.ntp.time;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class TimeService {

    @Value("${ntp.server.url}")
    private String ntpServerURL;

    @Value("${ntp.server.timeout}")
    private int serverTimeout;

    public String getNTPTime(){

        String valueReturn = "";

        try {
            NTPUDPClient client = new NTPUDPClient();
            client.setDefaultTimeout(serverTimeout);

            InetAddress host = InetAddress.getByName(ntpServerURL);
            client.open();

            log.info("InetAddress host connect: {}", client.isOpen());

            TimeInfo timeInfo = client.getTime(host);

            long ntpTimeInMillis = timeInfo.getReturnTime();
            long unixTimeInMillis = (ntpTimeInMillis - 2208988800000L);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS'Z'").withZone(ZoneOffset.UTC);

            valueReturn = formatter.format(Instant.ofEpochMilli(unixTimeInMillis));
            log.info("Return UTC Time {}", valueReturn);

        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return valueReturn;
    }

}
