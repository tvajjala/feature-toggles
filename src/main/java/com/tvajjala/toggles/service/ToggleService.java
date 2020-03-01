package com.tvajjala.toggles.service;

import com.tvajjala.toggles.model.FeatureToggle;
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
        featureToggleList.add(new FeatureToggle(1, "TOGGLE_BALANCE_TRANSFER", Boolean.TRUE, "WEB"));
        featureToggleList.add(new FeatureToggle(2, "TOGGLE_OTP_SMS", Boolean.TRUE, "MOBILE"));
        featureToggleList.add(new FeatureToggle(3, "TOGGLE_LOGIN", Boolean.FALSE, "WEB"));
        featureToggleList.add(new FeatureToggle(4, "TOGGLE_OTP_VOICE", Boolean.TRUE, "MOBILE"));
        featureToggleList.add(new FeatureToggle(5, "TOGGLE_OTP_EMAIL", Boolean.FALSE, "WEB"));
        featureToggleList.add(new FeatureToggle(6, "TOGGLE_PII_MASKING", Boolean.FALSE, "WEB"));
        return featureToggleList;
    }


}
