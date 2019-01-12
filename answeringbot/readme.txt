Code Build
- mvn clean install

Code build + execute 
- mvn clean install exec:java -Dexec.mainClass="com.example.autobot.App"

Provide file name as argument - 
- mvn clean install exec:java -Dexec.mainClass="com.example.autobot.App" -Dfile_name={file_name}


Inline java docs are added for more context