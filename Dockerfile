FROM amitsahoo/amazonlinuxopenjdk17:2.0
LABEL org.opencontainers.image.authors="amitsahoolearnings@gmail.com"

ARG JAR_NAME
ENV JAR_FILE ${JAR_NAME}
USER ec2-user
COPY --chown=ec2-user:app ./${JAR_FILE} /home/ec2-user/
COPY --chown=ec2-user:app ./entrypoint.sh /home/ec2-user/
RUN chmod u+x /home/ec2-user/entrypoint.sh
WORKDIR /home/ec2-user
CMD ["/home/ec2-user/entrypoint.sh"]