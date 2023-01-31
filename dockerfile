FROM ubuntu
MAINTAINER uday
RUN apt-get update
RUN apt-get install -y apache2
RUN apt-get install -y git
CMD ["echo","Hello world"]