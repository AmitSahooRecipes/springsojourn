FROM amitsahoo/amazonlinuxopenjdk17:2.0
LABEL org.opencontainers.image.authors="amitsahoolearnings@gmail.com"

ARG JAR_FILE=${jarName}
USER ec2-user
COPY --chown=ec2-user:app ./${JAR_FILE} /home/ec2-user/
WORKDIR /home/ec2-user

CMD ["java","-jar","/home/ec2-user/${JAR_FILE}"]