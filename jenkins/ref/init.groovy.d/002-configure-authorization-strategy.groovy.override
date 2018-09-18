import groovy.transform.SourceURI
import hudson.security.FullControlOnceLoggedInAuthorizationStrategy
import jenkins.model.Jenkins

@SourceURI URI sourceUri
def initializationFile = new File(sourceUri.getPath() + ".run")
def isInitialized = initializationFile.exists()

def forceInitialization = System.getenv("JENKINS_FORCE_INITIALIZATION")

if (forceInitialization || !isInitialized){
 
    def instance = Jenkins.getInstance()

    def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
    strategy.setAllowAnonymousRead(false)
    instance.setAuthorizationStrategy(strategy)
 
    instance.save()
}

initializationFile.createNewFile()
