package com.tvajjala.toggles.service;

import com.tvajjala.toggles.model.FeatureToggle;
import com.tvajjala.toggles.model.ToggleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ToggleService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ToggleService.class);


    static Map<String, FeatureToggle> toggleMap = new HashMap<>();

    static {

        toggleMap.put("TOGGLE_THREAT_METRIX_INTEGRATION", new FeatureToggle(1, "TOGGLE_THREAT_METRIX_INTEGRATION", Boolean.TRUE, "WEB", ToggleType.R));
        toggleMap.put("TOGGLE_PREMIUM_USER", new FeatureToggle(2, "TOGGLE_PREMIUM_USER", Boolean.TRUE, "MOBILE", ToggleType.P));
        toggleMap.put("TOGGLE_PII_MASKING", new FeatureToggle(3, "TOGGLE_PII_MASKING", Boolean.FALSE, "EXTERNAL", ToggleType.P));
        toggleMap.put("TOGGLE_BIO_METRIX_ENABLED", new FeatureToggle(4, "TOGGLE_BIO_METRIX_ENABLED", Boolean.TRUE, "MOBILE", ToggleType.E));
        toggleMap.put("TOGGLE_OTP_VOICE", new FeatureToggle(5, "TOGGLE_OTP_VOICE", Boolean.FALSE, "MOBILE", ToggleType.E));
        toggleMap.put("TOGGLE_DB_VERSION_UPGRADE", new FeatureToggle(6, "TOGGLE_DB_VERSION_UPGRADE", Boolean.FALSE, "ANY", ToggleType.O));

    }


    /**
     * @param nameSpace nameSpace to differentiate toggles IDV /FCM
     * @return list
     */
    public List<FeatureToggle> getToggles(final String nameSpace) {
        LOGGER.info("Reading all toggles");
        return toggleMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());

    }


    public FeatureToggle getToggle(final String nameSpace, final String name) {

        LOGGER.info("get toggles ");
        return toggleMap.get(name);

    }

    public void updateToggle(final String nameSpace, final String name, final FeatureToggle featureToggle) {

        LOGGER.info("updating toggle with name {} ", name);
        toggleMap.put(name, featureToggle);

    }
}
