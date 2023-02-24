package lat.fercejor.fercejorapp.controller.Dashboard;

import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@PreAuthorize("!hasAuthority('Cliente')")
@Controller
@RequestMapping("/dashboard")
public class DashboardMenuController {

    @GetMapping("")
    public String dashboard(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("user", userDetails.getUsername());
        Set<String> roles = AuthorityUtils.authorityListToSet(userDetails.getAuthorities());
        model.addAttribute("roles", roles);
        return "dashboard/inicio";
    }
    
}
