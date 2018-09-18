import groovy.transform.SourceURI
import jenkins.model.Jenkins
import jenkins.security.s2m.AdminWhitelistRule

@SourceURI URI sourceUri
def initializationFile = new File(sourceUri.getPath() + ".run")
def isInitialized = initializationFile.exists()

def forceInitialization = System.getenv("JENKINS_FORCE_INITIALIZATION")

if (forceInitialization || !isInitialized){
    def instance = Jenkins.getInstance()

    instance.injector.getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false); 

    instance.save()
}

initializationFile.createNewFile()
