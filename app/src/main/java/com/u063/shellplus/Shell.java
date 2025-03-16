package com.u063.shellplus;

import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell {
    private String cmd;
    public Shell(String cmd){
        this.cmd = cmd;
    }
    public String execute(){
        Runtime runtime = Runtime.getRuntime();
        String str = "";
        try {
            Process process = runtime.exec(this.cmd);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String string = "";
            while((string = in.readLine())!=null){
                str += string;
            }
        } catch (IOException ignored){}
        return str;
    }
}
