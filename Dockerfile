FROM jenkins/jenkins:2.141-alpine

ENV DOCKER_PACKAGE_VERSION="18.06.1-r0"
ENV KUBECTL_VERSION="1.10.5"

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

USER root

RUN apk update \
&& apk add docker=${DOCKER_PACKAGE_VERSION} \
&& curl -Lo /usr/bin/kubectl https://storage.googleapis.com/kubernetes-release/release/v{$KUBECTL_VERSION}/bin/linux/amd64/kubectl \
&& chmod +x /usr/bin/kubectl

COPY jenkins/ /usr/share/jenkins/

RUN chown -R jenkins:root /usr/share/jenkins/ref \
&& /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
