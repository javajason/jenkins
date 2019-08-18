ARG base_image=jenkins/jenkins:2.180-alpine

FROM ${base_image}

ENV DOCKER_PACKAGE_VERSION="18.09.1-r10"
ENV KUBECTL_VERSION="1.11.5"

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

USER root

RUN apk update \
    && apk add docker=${DOCKER_PACKAGE_VERSION} gettext \
    && curl -Lo /usr/bin/kubectl https://storage.googleapis.com/kubernetes-release/release/v{$KUBECTL_VERSION}/bin/linux/amd64/kubectl \
    && chmod +x /usr/bin/kubectl

COPY jenkins/ /usr/share/jenkins/

RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt
