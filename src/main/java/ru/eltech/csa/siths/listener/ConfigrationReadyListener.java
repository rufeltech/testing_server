package ru.eltech.csa.siths.listener;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import ru.eltech.csa.siths.entity.node.Account;
import ru.eltech.csa.siths.entity.node.Role;
import ru.eltech.csa.siths.entity.node.IssueType;
import ru.eltech.csa.siths.service.behaviour.AccountService;
import ru.eltech.csa.siths.service.behaviour.RoleService;
import ru.eltech.csa.siths.service.behaviour.IssueTypeService;

@Component
public class ConfigrationReadyListener implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private IssueTypeService issueTypeService;

    private static final String adminAccountName = "admin";
    private static final String adminAccountEmail = "admin@admin";
    private static final String adminAccountPassword = "admin";

    private static final Set<String> rolesNames = initRolesNamesSet();

    private static final Map<String, Integer> issueTypes = initIssueTypesMap();

    private static final Map<String, Integer> issuePriorities = initIssuePrioritiesMap();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Account adminAccount = new Account( adminAccountName, adminAccountEmail, adminAccountPassword );
        for (String roleName : rolesNames) {
            if ( !this.roleService.isRoleExists( roleName ) ) {
                Role role = roleService.createRole( new Role( roleName ) );
                adminAccount.addRole(role);
            }
        }

        if ( !this.accountService.isNameInUse( adminAccountName ) ) {
            adminAccount = accountService.createAccount(adminAccount);
        }

        for ( Map.Entry<String, Integer> iType : issueTypes.entrySet() )
        {
            if ( !this.issueTypeService.isIssueTypeExists( iType.getKey() ) ) {
                this.issueTypeService.createIssueType( 
                    new IssueType( iType.getKey(), iType.getValue().intValue() ) );
            }
        }

        for (IssueType it : issueTypeService.getIssueTypesList()) {
            System.out.println(it.getName());
        }
    }

    private static Set<String> initRolesNamesSet() {
        Set<String> prepRolesNames = new HashSet<String>();

        prepRolesNames.add("ROLE_ADMIN"); 
        prepRolesNames.add("ROLE_COMEPANY_MANAGER"); 
        prepRolesNames.add("ROLE_PROJECT_MANAGER");
        prepRolesNames.add("ROLE_TEAM_LEADER");
        prepRolesNames.add("ROLE_PROGRAMMER");
        prepRolesNames.add("ROLE_TESTER");
        prepRolesNames.add("ROLE_USER");

        return prepRolesNames;  
    }

    private static Map<String, Integer> initIssueTypesMap() {
        Map<String, Integer> prepIssueTypes = new HashMap<String, Integer>();

        prepIssueTypes.put("Bug", 1);
        prepIssueTypes.put("Improvement", 2);
        prepIssueTypes.put("Feature", 3);
        prepIssueTypes.put("Task", 4);

        return prepIssueTypes;
    }

    private static Map<String, Integer> initIssuePrioritiesMap() {
        Map<String, Integer> prepIssuePriorities = new HashMap<String, Integer>();

        prepIssuePriorities.put("Blocker", 1);
        prepIssuePriorities.put("Critical", 2);
        prepIssuePriorities.put("Major", 3);
        prepIssuePriorities.put("Minor", 4);
        prepIssuePriorities.put("Trivial", 5);

        return prepIssuePriorities;
    }

}