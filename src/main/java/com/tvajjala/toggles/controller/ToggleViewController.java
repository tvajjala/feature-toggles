package com.tvajjala.toggles.controller;

import com.tvajjala.toggles.service.ToggleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This is not rest controller. this is used to render HTML page to view toggle states.
 */
@Controller
@RequestMapping("/ui/toggle-ui")
public class ToggleViewController {


    @Autowired
    ToggleService toggleService;


    private static final Logger LOGGER = LoggerFactory.getLogger(ToggleViewController.class);

    /**
     * @param nameSpace IDV or FCM
     * @return view
     */
    @GetMapping
    public ModelAndView getToggles(@RequestParam(required = false, name = "ns", defaultValue = "IDV") final String nameSpace) {


        final Map<String, Object> model = new HashMap<>();
        model.put("namespace", nameSpace);
        model.put("featureToggles", toggleService.getToggles(nameSpace));

        final Collection<? extends GrantedAuthority> grantedAuthorityList = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        final boolean editAuthority = grantedAuthorityList.contains(new SimpleGrantedAuthority("ADMIN"));
        LOGGER.info("Authorities {} ", editAuthority);

        /** user who has AUTHORITY== ADMIN can only able edit toggle states */
        model.put("disableEditing", !editAuthority);

        LOGGER.info("Editing disabled for this user {} ", model.get("disableEditing"));

        return new ModelAndView("index", model);

    }

}
