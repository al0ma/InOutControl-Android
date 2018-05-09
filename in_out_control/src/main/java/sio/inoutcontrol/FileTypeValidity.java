package sio.inoutcontrol;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marek on 05/05/18.
 */

public class FileTypeValidity {
    private boolean fileType = false;

    private List<String> fileTypeAllowed = new ArrayList<>();
    private List<String> fileTypeDisabled = new ArrayList<>();

    public void addFileTypeAllowed(String format){
        fileTypeAllowed.add(format);
    }

    public void addFileTypeDisabled(String format){
        fileTypeDisabled.add(format);
    }

    public void setParameters(boolean fileType) {

        this.fileType = fileType;
    }

    public boolean checkFile(String path){
        boolean validFile = false;



        if(fileType){
            for(int i = 0; i<fileTypeAllowed.size();i++){
                if (path.contains('.' + fileTypeAllowed.get(i))){
                    validFile = true;
                    break;
                }
            }
        }
        else{
            validFile = true;
            for(int i = 0; i<fileTypeDisabled.size();i++){
                if (path.contains('.' + fileTypeDisabled.get(i))){
                    validFile = false;
                    break;
                }
            }
        }

        if(validFile)
            return true;
        else
            return false;
    }


    private int maxSize;
    public void setMaxSize(int size){
        this.maxSize = size;
    }

    public boolean checkFileSize(File file){
        if(file.length() > maxSize) return false;
        else return true;
    }

    public boolean checkFileSize(byte[] file){
        if(file.length > maxSize) return false;
        else return true;
    }
}
