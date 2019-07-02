package com.zhrb.test;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @ClassName TestUseSSH
 * @Description TODO
 * @Author Administrator
 * @Date 2019/7/1 15:55
 * @Version
 */
public class TestUseSSH {
    private static  String ip = "your ip";
    private static  int port = 22;
    private static  String user = "user";
    private static  String pswd = "pswd";


    public static void main(String[] args) {
        try {

            Connection conn = new Connection(ip,port);
            conn.connect();
            boolean isAuthenticated = conn.authenticateWithPassword(user,
                    pswd);
            if (isAuthenticated == false)
                throw new IOException("Authentication failed.");
            Session sess = conn.openSession();
            sess.execCommand("sh /test/shell/testForJava");
            InputStream stdout = new StreamGobbler(sess.getStdout());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(stdout));
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
            sess.close();
            conn.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);

            System.exit(2);
        }

    }


}
