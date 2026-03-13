mvn clean compile
mvn spring-boot:run


# mvn clean
# mvn clean package


# mvn clean compile exec:java -Dexec.mainClass="com.example.correction.CorrectionApplication" -DskipTests


# ================= Lancement

SPRING_PROFILES_ACTIVE=sprint1 ./mvnw spring-boot:run
ou
SPRING_PROFILES_ACTIVE=sprint2 ./mvnw spring-boot:run
