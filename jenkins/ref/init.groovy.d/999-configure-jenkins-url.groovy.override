import groovy.transform.SourceURI
import jenkins.model.JenkinsLocationConfiguration

@SourceURI URI sourceUri
def initializationFile = new File(sourceUri.getPath() + ".run")
def isInitialized = initializationFile.exists()

def forceInitialization = System.getenv("JENKINS_FORCE_INITIALIZATION")

if (forceInitialization || !isInitialized){
    def url = System.env.JENKINS_UI_URL

    def urlConfig = JenkinsLocationConfiguration.get()
    urlConfig.setUrl(url)

    urlConfig.save()

    println("Jenkins URL Set to " + url)
}

initializationFile.createNewFile()
