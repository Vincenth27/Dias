package pe.edu.idat.vincenth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class WeekdayTranslatorEndpoint {

    @PayloadRoot(namespace = "http://localhost:8080/wsec1e1/", localPart = "TranslateWeekdayRequest")
    @ResponsePayload
    public TranslatedWeekdayResponse translateWeekday(@RequestPayload TranslateWeekdayRequest request) {
        String weekday = request.getWeekday();

        Map<String, String> translationMap = new HashMap<>();
        translationMap.put("lunes", "Monday");
        translationMap.put("martes", "Tuesday");

        if (translationMap.containsKey(weekday.toLowerCase())) {
            String translatedWeekday = translationMap.get(weekday.toLowerCase());

            TranslatedWeekdayResponse response = new TranslatedWeekdayResponse();
            response.setTranslatedWeekday(translatedWeekday);
            return response;
        } else {
        throw new IllegalArgumentException("Día de la semana no válido: " + weekday);
        }
    }


}

