package com.tvajjala.toggles.model;

import java.io.Serializable;
import java.time.Instant;

public class FeatureToggle implements Serializable {

    private Integer id;

    private String toggleName;

    private Instant lastModifiedOn = Instant.now();

    private Boolean enabled;

    private String channel;


    public FeatureToggle() {

    }

    public FeatureToggle(final Integer id, final String toggleName, final Boolean enabled, final String channel) {
        this.id = id;
        this.toggleName = toggleName;
        this.enabled = enabled;
        this.channel = channel;
    }


    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getToggleName() {
        return toggleName;
    }

    public void setToggleName(final String toggleName) {
        this.toggleName = toggleName;
    }

    public Instant getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(final Instant lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(final Boolean enabled) {
        this.enabled = enabled;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(final String channel) {
        this.channel = channel;
    }
}
