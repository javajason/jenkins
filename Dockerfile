FROM jenkins/jenkins:2.131-alpine

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

USER root

RUN apk update \
&& apk add docker \
&& curl -Lo /usr/bin/kubectl https://storage.googleapis.com/kubernetes-release/release/v1.10.5/bin/linux/amd64/kubectl \
&& chmod +x /usr/bin/kubectl

COPY jenkins/ /usr/share/jenkins/

RUN chown -R jenkins:root /usr/share/jenkins/ref \
&& /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
