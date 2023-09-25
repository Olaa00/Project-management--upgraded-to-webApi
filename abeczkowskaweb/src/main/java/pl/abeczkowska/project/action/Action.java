package pl.abeczkowska.project.action;
import pl.ttpsc.javaupdate.project.model.Role;

import java.util.List;

public interface Action {
    void execute();
    List<Role> getAllowedRoles();
    boolean hasAnyRole(List<Role> roles);

}
