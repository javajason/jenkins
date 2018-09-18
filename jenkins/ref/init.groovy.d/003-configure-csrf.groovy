import groovy.transform.SourceURI
import hudson.security.csrf.DefaultCrumbIssuer
import jenkins.model.Jenkins

@SourceURI URI sourceUri
def initializationFile = new File(sourceUri.getPath() + ".run")
def isInitialized = initializationFile.exists()

def forceInitialization = System.getenv("JENKINS_FORCE_INITIALIZATION")

if (forceInitialization || !isInitialized){
    def instance = Jenkins.getInstance()

    instance.setCrumbIssuer(new DefaultCrumbIssuer(true))
 
    instance.save()
}

initializationFile.createNewFile()
