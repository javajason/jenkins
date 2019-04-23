# Jenkins

## Windows

```
echo "ucp-dc-passwd!" | docker secret create jenkins-admin-password -
echo "admin" | docker secret create jenkins-admin-user -

docker secret create jenkins.cert C:\<certs directory>\fullchain.pem
docker secret create jenkins.key C:\<certs directory>\privkey1.pem
```

```
$env:STACK_NAME = "jenkins"
$env:REGISTRY_FQDN = "<REGISTRY FQDN>"
$env:REGISTRY_NAMESPACE = "<REGISTRY NAMESPACE>"
$env:REGISTRY_REPOSITORY = "<REGISTRY RESPOSITORY"
$env:REGISTRY_TAG = "<IMAGE TAG>"
$env:JENKINS_ADMIN_PASSWORD_SECRET = "jenkins-admin-password"
$env:JENKINS_ADMIN_USER_SECRET = "jenkins-admin-user"
$env:JENKINS_FQDN = "<FQDN>"
$env:JENKINS_SSL_CERT_SECRET = "jenkins.cert"
$env:JENKINS_SSL_KEY_SECRET = "jenkins.key"
$env:UCP_COLLECTION = "/Shared/Jenkins"

docker stack deploy -c docker-compose.yml $env:STACK_NAME
```

## Linux

```
echo "ucp-dc-passwd!" | docker secret create jenkins-admin-password -
echo "admin" | docker secret create jenkins-admin-user -

docker secret create jenkins.cert /<certs directory>/fullchain.pem
docker secret create jenkins.key /<certs directory>/privkey1.pem
```

```
export STACK_NAME="jenkins"
export REGISTRY_FQDN="<REGISTRY FQDN>"
export REGISTRY_NAMESPACE="<REGISTRY NAMESPACE>"
export REGISTRY_REPOSITORY="<REGISTRY RESPOSITORY"
export REGISTRY_TAG="<IMAGE TAG>"
export JENKINS_ADMIN_PASSWORD_SECRET="jenkins-admin-password"
export JENKINS_ADMIN_USER_SECRET="jenkins-admin-user"
export JENKINS_FQDN="<FQDN>"
export JENKINS_SSL_CERT_SECRET="jenkins.cert"
export JENKINS_SSL_KEY_SECRET="jenkins.key"
export UCP_COLLECTION="/Shared/Jenkins"

docker stack deploy -c docker-compose.yml ${STACK_NAME}
```