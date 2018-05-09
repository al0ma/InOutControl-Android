package sio.inoutcontrol;

import java.io.File;

/**
 * Created by marek on 05/05/18.
 */

public class FileInput {

    private boolean analyseAllowed = false;
    private boolean fileType = false;

    private boolean validity = true;
    private boolean validFileType = true;
    private boolean malware = false;

    private FileTypeValidity filev = null;

    public boolean getValidity(){
        return validity;
    }

    public boolean getValidFileType(){
        return validFileType;
    }

    public boolean checkMalwarePresent(){
        return malware;
    }

    public void analyseAllowed(boolean analyseAllowed){
        this.analyseAllowed = analyseAllowed;
    }

    public void setFileTypeParameters(boolean fileType){
        this.fileType = fileType;
    }

    public void addFileTypeAllowed(String filetype){
        filev.addFileTypeAllowed(filetype);
    }

    public void addFileTypeDisabled(String filetype){
        filev.addFileTypeDisabled(filetype);
    }

    FileChecker filec = new FileChecker();
    public File fileLoad(String path){
        try {
            File file = new File(path);
            if(analyseAllowed){
                if(filec.searchForMalware(file)){
                    validity = false;
                    malware = true;
                }
            }
            if(fileType){
                FileTypeValidity filev = new FileTypeValidity();
                if(filev.checkFile(path)){
                    validity = true;
                    validFileType = true;
                }
                else{
                    validity = false;
                    validFileType = false;
                }
            }


            return file;
        }
        catch(Exception e) {
            e.printStackTrace();
            validity = false;
            return null;
        }

    }



    public byte[] fileLoadToBytes(String path) {

        File file = new File(path);
        byte[] bytesArray = new byte[(int) file.length()];
        try (java.io.FileInputStream fis = new java.io.FileInputStream(path)) {
            fis.read(bytesArray); //read file into bytes[]
            //Log.v("bytearray", bytesToHex(bytesArray));
            //fis.close();
            if(analyseAllowed){
                if(filec.searchForMalware(file)){
                    validity = false;
                    malware = true;
                }
            }
            if(fileType){
                FileTypeValidity filev = new FileTypeValidity();
                if(filev.checkFile(path)){
                    validity = true;
                    validFileType = true;
                }
                else{
                    validity = false;
                    validFileType = false;
                }
            }
            return bytesArray;
        } catch (Exception e) {
            e.printStackTrace();
            validity = false;
            return null;
        }

    }

}
