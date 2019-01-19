Code Build
- mvn clean install

Code build + execute 
- mvn clean install exec:java -Dexec.mainClass="com.example.autobot.App"

Provide file name as argument - 
- mvn clean install exec:java -Dexec.mainClass="com.example.autobot.App" -Dfile_name={file_name}


Inline java docs are added for more context

// todo & Future enhancements 
1. Add more testcases.
2. Add more debug execution logs.
3. Expose this service as an REST api. 
3. Make this an async process. 
4. Store the logs in centralized location. 