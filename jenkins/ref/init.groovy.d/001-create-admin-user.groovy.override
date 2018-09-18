import groovy.transform.SourceURI
import hudson.security.HudsonPrivateSecurityRealm
import jenkins.model.Jenkins

@SourceURI URI sourceUri
def initializationFile = new File(sourceUri.getPath() + ".run")
def isInitialized = initializationFile.exists()

def forceInitialization = System.getenv("JENKINS_FORCE_INITIALIZATION")

if (forceInitialization || !isInitialized){
    def instance = Jenkins.getInstance()

    def username = new File("/run/secrets/jenkins-admin-user").text.trim()
    def password = new File("/run/secrets/jenkins-admin-password").text.trim()

    if (System.env.JENKINS_LOG_ADMIN_CREDS) {
        println("Jenkins admin user: " + username)
        println("Jenkins admin password: " + password)
    }
 
    def hudsonRealm = new HudsonPrivateSecurityRealm(false)
    hudsonRealm.createAccount(username, password)
    instance.setSecurityRealm(hudsonRealm)

    instance.save()
}

initializationFile.createNewFile()
