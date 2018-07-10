import jenkins.model.Jenkins
import jenkins.security.s2m.AdminWhitelistRule
 
def instance = Jenkins.getInstance()

instance.injector.getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false); 

instance.save()
