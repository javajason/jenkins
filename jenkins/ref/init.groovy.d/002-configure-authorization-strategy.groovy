import hudson.security.FullControlOnceLoggedInAuthorizationStrategy
import jenkins.model.Jenkins
 
def instance = Jenkins.getInstance()

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)
 
instance.save()
