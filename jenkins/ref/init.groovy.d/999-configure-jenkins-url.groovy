import jenkins.model.JenkinsLocationConfiguration

def url = System.env.JENKINS_UI_URL

def urlConfig = JenkinsLocationConfiguration.get()
urlConfig.setUrl(url)

urlConfig.save()

println("Jenkins URL Set to " + url)
