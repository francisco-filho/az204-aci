FROM registry.access.redhat.com/ubi8/openjdk-17:1.18

ENV LANGUAGE='en_US:en'

# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --chown=185 target/az204-aci.jar /deployments/app/

USER 185
ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/app/az204-aci.jar"

CMD ["java", "-jar", "/deployments/app/az204-aci.jar", "com.capimgrosso.azure.App"]
#ENTRYPOINT [ "/opt/jboss/container/java/run/run-java.sh" ]

