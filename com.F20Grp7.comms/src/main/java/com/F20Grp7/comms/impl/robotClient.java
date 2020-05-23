package com.F20Grp7.comms.impl;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ancla
 */
public class robotClient {

    private String hostname;
    private int port;
    private Socket connection;
    public PrintWriter out;

    /**
     * Default RobotClient constructor
     */
    public robotClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    /**
     * Method which connects to the robot, using the parameters provided to the
     * constructor.
     */
    public void connect() {
        try {
            connection = new Socket(hostname, port);
            out = new PrintWriter(connection.getOutputStream(), true);
        } catch (IOException ex) {
            Logger.getLogger(robotClient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connecting to robot: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * This method is used to determine if a connection has been established to
     * the robot.
     *
     * @return COnnection state to see if connection is established (true) or
     * not (false).
     */
    public boolean isConnected() {
        return connection.isConnected();
    }

    /**
     * This method writes a message to the robot iff a connection to the robot
     * is established.
     *
     * @param message The message to write to the robot.
     */
    public void write(String message) {
        if (isConnected()) {
            out.print(message);
            out.flush();
        }

    }

    /**
     * Method to close connection to the robot.
     */
    public void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
            } catch (IOException ex) {
                Logger.getLogger(robotClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Returns value of hostname
     *
     * @return
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Sets new value of hostname
     *
     * @param
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * Returns value of port
     *
     * @return
     */
    public int getPort() {
        return port;
    }

    /**
     * Sets new value of port
     *
     * @param
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Returns value of connection
     *
     * @return
     */
    public Socket getConnection() {
        return connection;
    }

    /**
     * Sets new value of connection
     *
     * @param
     */
    public void setConnection(Socket connection) {
        this.connection = connection;
    }

    /**
     * Returns value of out
     *
     * @return
     */
    public PrintWriter getOut() {
        return out;
    }

    /**
     * Sets new value of out
     *
     * @param
     */
    public void setOut(PrintWriter out) {
        this.out = out;
    }

}
