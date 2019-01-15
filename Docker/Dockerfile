
#Original docker image
FROM payara/server-full
#Copy application war
COPY --chown=payara TCTest1-0.1.war $DEPLOY_DIR
#Copy jpg's
COPY --chown=payara a1.jpg /opt/payara41/glassfish/domains/domain1/
COPY --chown=payara a2.jpg /opt/payara41/glassfish/domains/domain1/
COPY --chown=payara a3.jpg /opt/payara41/glassfish/domains/domain1/
COPY --chown=payara a4.jpg /opt/payara41/glassfish/domains/domain1/
COPY --chown=payara a5.jpg /opt/payara41/glassfish/domains/domain1/
