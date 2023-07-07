## Overview

Cadastro dos colaboradores em uma hierarquia, considerando suas senhas com base nas métricas de força disponíveis no site: http://www.passwordmeter.com/



## Execution

Tools:
<li> Java 11 </li>
<li> SpringBoot 2.7.13 </li>
<li> Docker </li>
<br>
<strong>Back-end: </strong>
Import the project into an IDE of your choice, the IDE used in the development was the Netbeans IDE, 
so just build the application to download the dependencies that are managed by Maven,
but first, Docker must be installed and the container images encoded in the <strong>docker-compose.yml</strong> file initialized, 
with the <code>docker-compose up -d</code> command, and when the application is running, just access the link http://localhost:8080/swagger-ui/index.html to analyze the application's endpoints.
