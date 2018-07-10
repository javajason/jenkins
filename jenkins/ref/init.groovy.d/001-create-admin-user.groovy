import hudson.security.HudsonPrivateSecurityRealm
import jenkins.model.Jenkins

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
