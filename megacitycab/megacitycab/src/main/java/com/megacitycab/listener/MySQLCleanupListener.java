package com.megacitycab.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import java.lang.reflect.Method;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Logger;

@WebListener
public class MySQLCleanupListener implements ServletContextListener {
    private static final Logger LOGGER = Logger.getLogger(MySQLCleanupListener.class.getName());

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        deregisterMySQLDrivers();
        shutdownAbandonedConnectionCleanupThread();
    }

    private void deregisterMySQLDrivers() {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            if (driver.getClass().getName().contains("mysql")) {
                try {
                    DriverManager.deregisterDriver(driver);
                    LOGGER.info("Deregistered MySQL driver: " + driver);
                } catch (SQLException e) {
                    LOGGER.severe("Error deregistering MySQL driver: " + e.getMessage());
                }
            }
        }
    }

    private void shutdownAbandonedConnectionCleanupThread() {
        try {
            // Use reflection to access the private shutdown method
            Class<?> cleanupThreadClass = Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread");
            Method shutdownMethod = cleanupThreadClass.getDeclaredMethod("shutdown", boolean.class);
            shutdownMethod.setAccessible(true); // Bypass private access
            shutdownMethod.invoke(null, true); // shutdown(true)
            LOGGER.info("Forcibly shutdown MySQL abandoned connection cleanup thread");
        } catch (ClassNotFoundException e) {
            LOGGER.warning("AbandonedConnectionCleanupThread class not found: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            LOGGER.warning("Shutdown method not found: " + e.getMessage());
        } catch (Exception e) {
            if (e.getCause() instanceof java.nio.file.NoSuchFileException) {
                LOGGER.warning("File not found during cleanup: " + e.getCause().getMessage());
            } else {
                LOGGER.severe("Failed to shutdown cleanup thread: " + e.getMessage());
            }
        }
    }
}