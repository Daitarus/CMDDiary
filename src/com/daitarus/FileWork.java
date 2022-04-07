package com.daitarus;

import java.io.*;

public class FileWork {
    private String fileName;
    private File file;
    public FileWork(String fileName) {
        this.fileName=fileName;
        this.file = new File(fileName);
    }
    public boolean exists(){
        return file.exists();
    }
    public boolean createFile(){
        try {
            file.createNewFile();
            return true;
        }catch (IOException ex){
            return false;
        }
    }
    public boolean write(String text){
        try {
            FileWriter writer = new FileWriter(file, false);
            writer.write(text);
            writer.flush();
            return true;
        }catch (IOException ex){
            return false;
        }
    }
    public boolean write(String text, boolean append) {
        try {
            FileWriter writer = new FileWriter(file, append);
            writer.write(text);
            writer.flush();
            writer.close();
            return true;
        }catch (IOException ex){
            return false;
        }
    }
    public String read(){
        try(FileReader reader = new FileReader(file))
        {
            int l = Length();
            char[] buf = new char[l];
            reader.read(buf);
            reader.close();
            return new String(buf);
        }
        catch(IOException ex){

            return null;
        }
    }
    public String readLine(int line){
        try(FileReader reader = new FileReader(file))
        {
            int c0, c=0; int sum=0; String sline = "";
            while((c!=-1)&(sum<=line))
            {
                c0=c;
                c=reader.read();
                if((c0==13)&(c==10)){
                    sum++;
                }
                if((sum == line)&(c!=-1)&(c!=13)&(c!=10)) {
                    sline += (char)c;
                }
            }
            reader.close();
            if (sline.toString().equals("")){
                return null;
            }
            else {
                return sline.toString();
            }
        }
        catch(IOException ex){
            return null;
        }
    }
    public int Line(){
        try(FileReader reader = new FileReader(file))
        {
            int sum = 1; int c0, c=0;
            while(c!=-1)
            {
                c0=c;
                c=reader.read();
                if((c0==13)&(c==10)){
                    sum++;
                }
            }
            reader.close();
            return sum;
        }
        catch(IOException ex){

            return 0;
        }
    }
    public int Length() {
        try(FileReader reader = new FileReader(file))
        {
            int sum=0;
            while(reader.read()!=-1)
            {
                sum++;
            }
            reader.close();
            return sum;
        }
        catch(IOException ex){
            return 0;
        }
    }
    public int Length(int line){
        return 0;
    }
}
