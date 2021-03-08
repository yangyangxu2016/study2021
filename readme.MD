docker pull mysql:5.7
docker run -i -d --name=mysql5.7 -p3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql:5.7