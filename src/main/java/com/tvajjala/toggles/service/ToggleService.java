package com.tvajjala.toggles.service;

import com.tvajjala.toggles.model.FeatureToggle;
import com.tvajjala.toggles.model.ToggleType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToggleService {


    /**
     * @param nameSpace nameSpace to differentiate toggles IDV /FCM
     * @return list
     */
    public List<FeatureToggle> getToggles(final String nameSpace) {

        final List<FeatureToggle> featureToggleList = new ArrayList<>();

        featureToggleList.add(new FeatureToggle(1, "TOGGLE_THREAT_METRIX_INTEGRATION", Boolean.TRUE, "WEB", ToggleType.R));

        featureToggleList.add(new FeatureToggle(2, "TOGGLE_PREMIUM_USER", Boolean.TRUE, "MOBILE", ToggleType.P));

        featureToggleList.add(new FeatureToggle(3, "TOGGLE_PII_MASKING", Boolean.FALSE, "EXTERNAL", ToggleType.P));

        featureToggleList.add(new FeatureToggle(4, "TOGGLE_BIO_METRIX_ENABLED", Boolean.TRUE, "MOBILE", ToggleType.E));

        featureToggleList.add(new FeatureToggle(5, "TOGGLE_OTP_VOICE", Boolean.FALSE, "MOBILE", ToggleType.E));

        featureToggleList.add(new FeatureToggle(6, "TOGGLE_DB_VERSION_UPGRADE", Boolean.FALSE, "ANY", ToggleType.O));

        return featureToggleList;
    }


}
