package by.mitroshin.homedev.log;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by HP M6 on 20.05.2015.
 */
public class LogRunner {
    public final static Logger LOG = Logger.getLogger(LogRunner.class);

    static{
         new DOMConfigurator().doConfigure("config/log4j.xml", LogManager.getLoggerRepository());
    }
}
