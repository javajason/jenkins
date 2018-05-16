FROM jenkins/jenkins:2.122-alpine

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

USER root

COPY jenkins/ /usr/share/jenkins/

RUN chown -R jenkins:root /usr/share/jenkins/ref \
&& /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

USER jenkins

