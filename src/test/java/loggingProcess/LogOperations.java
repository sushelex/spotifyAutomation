package loggingProcess;
import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.nio.file.Files;


public class LogOperations
{
 static Logger logger = Logger.getLogger(LogOperations.class);

 public LogOperations()
 {
     Appender console = new ConsoleAppender();
     Logger root = Logger.getRootLogger();
     root.addAppender(console);
     String log4jConfigFile = System.getProperty("user.dir")+ File.separator+"log4j.properties";
     PropertyConfigurator.configure(log4jConfigFile);
 }

 public void logInfoFile(String msg)
 {
     logger.info(msg);
 }

    public void logErrorFile(String msg)
    {
        logger.error(msg);
    }
}
