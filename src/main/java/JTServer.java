package com.alex.jungletiger;

import com.alex.jungletiger.admin.JTAdminServer;
import org.slf4j.*;
import org.json.*;
import java.io.*;

public final class JTServer {
    private Logger logger = LoggerFactory.getLogger(JTServer.class);
    static JSONObject json;

    public static void main(String[] args) throws Exception {
    	if (args.length != 2) {
    		System.out.println("[Usage] jungletiger <proxy|admin> <config_file>");
    		System.exit(-1);
    	}
    	
        loadJsonConfig(args[1]);

        if (args[0].equals("admin")) {
        	JTAdminServer jtadmin = new JTAdminServer(json.getJSONObject("admin"));
        	jtadmin.run();
        } else {
        	System.out.println("wrong server type, must be admin|proxy.");
        	System.exit(-1);
        }
    }

    private static void loadJsonConfig(String filename) throws Exception {
        json = new JSONObject(new JSONTokener(new FileReader(new File(filename))));  
    }
}