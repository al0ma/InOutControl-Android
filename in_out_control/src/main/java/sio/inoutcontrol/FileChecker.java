package sio.inoutcontrol;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by marek on 05/05/18.
 */

public class FileChecker {

    static boolean filled = false;


    static List<byte[]> malwareList = new ArrayList<byte[]>();
    static int length1 = 1200;
    static int length2 = 800;
    static int length3 = 1400;
    static int amount1 = 4;
    static int amount2 = 6;
    static int amount3 = 2;

    private void fillMalware(){


        byte a[][] = new byte[amount1][length1];
        for (int j = 0; j < amount1; j++) {
            for (int i = 0; i < length1; i++) {
                a[j][i] = (byte)(((i+7+(j*3))*11)%256);
            }
            malwareList.add(a[j]);
        }

        byte b[] = {(byte)0x04, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,   (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,
                    (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,   (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,
                    (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,   (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,
                    (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,   (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,
                    (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,   (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,
                    (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,   (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01,
                    (byte)0x01, (byte)0xDC, (byte)0xC9, (byte)0xB0, (byte)0x42, (byte)0xEB, (byte)0x0E, (byte)0x01,   (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x70, (byte)0xAE,
                    (byte)0x24, (byte)0x01, (byte)0x70, (byte)0xAE, (byte)0x42, (byte)0x90, (byte)0x90, (byte)0x90,   (byte)0x90, (byte)0x90, (byte)0x90, (byte)0x90, (byte)0x90, (byte)0x68, (byte)0xDC, (byte)0xC9,
                    (byte)0xB0, (byte)0x42, (byte)0xB8, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x01, (byte)0x31,   (byte)0xC9, (byte)0xB1, (byte)0x18, (byte)0x50, (byte)0xE2, (byte)0xFD, (byte)0x35, (byte)0x01,
                    (byte)0x01, (byte)0x01, (byte)0x05, (byte)0x50, (byte)0x89, (byte)0xE5, (byte)0x51, (byte)0x68,   (byte)0x2E, (byte)0x64, (byte)0x6C, (byte)0x6C, (byte)0x68, (byte)0x65, (byte)0x6C, (byte)0x33,
                    (byte)0x32, (byte)0x68, (byte)0x6B, (byte)0x65, (byte)0x72, (byte)0x6E, (byte)0x51, (byte)0x68,   (byte)0x6F, (byte)0x75, (byte)0x6E, (byte)0x74, (byte)0x68, (byte)0x69, (byte)0x63, (byte)0x6B,
                    (byte)0x43, (byte)0x68, (byte)0x47, (byte)0x65, (byte)0x74, (byte)0x54, (byte)0x66, (byte)0xB9,   (byte)0x6C, (byte)0x6C, (byte)0x51, (byte)0x68, (byte)0x33, (byte)0x32, (byte)0x2E, (byte)0x64,
                    (byte)0x68, (byte)0x77, (byte)0x73, (byte)0x32, (byte)0x5F, (byte)0x66, (byte)0xB9, (byte)0x65,   (byte)0x74, (byte)0x51, (byte)0x68, (byte)0x73, (byte)0x6F, (byte)0x63, (byte)0x6B, (byte)0x66,
                    (byte)0xB9, (byte)0x74, (byte)0x6F, (byte)0x51, (byte)0x68, (byte)0x73, (byte)0x65, (byte)0x6E,   (byte)0x64, (byte)0xBE, (byte)0x18, (byte)0x10, (byte)0xAE, (byte)0x42, (byte)0x8D, (byte)0x45,
                    (byte)0xD4, (byte)0x50, (byte)0xFF, (byte)0x16, (byte)0x50, (byte)0x8D, (byte)0x45, (byte)0xE0,   (byte)0x50, (byte)0x8D, (byte)0x45, (byte)0xF0, (byte)0xF0, (byte)0xFF, (byte)0x16, (byte)0x50,
                    (byte)0xBE, (byte)0x10, (byte)0x10, (byte)0xAE, (byte)0x42, (byte)0x8B, (byte)0x1E, (byte)0x8B,   (byte)0x03, (byte)0x3D, (byte)0x55, (byte)0x8B, (byte)0xEC, (byte)0x51, (byte)0x74, (byte)0x05,
                    (byte)0xBE, (byte)0x1C, (byte)0x10, (byte)0xAE, (byte)0x42, (byte)0xFF, (byte)0x16, (byte)0xFF,   (byte)0xD0, (byte)0x31, (byte)0xC9, (byte)0x51, (byte)0x51, (byte)0x50, (byte)0x81, (byte)0xF1,
                    (byte)0x03, (byte)0x01, (byte)0x04, (byte)0x9B, (byte)0x81, (byte)0xF1, (byte)0x01, (byte)0x01,   (byte)0x01, (byte)0x01, (byte)0x51, (byte)0x8D, (byte)0x45, (byte)0xCC, (byte)0x50, (byte)0x8B,
                    (byte)0x45, (byte)0xC0, (byte)0x50, (byte)0xFF, (byte)0x16, (byte)0x6A, (byte)0x11, (byte)0x6A,   (byte)0x02, (byte)0x6A, (byte)0x02, (byte)0xFF, (byte)0xD0, (byte)0x50, (byte)0x8D, (byte)0x40,
                    (byte)0xC4, (byte)0x50, (byte)0x62, (byte)0x6C, (byte)0x61, (byte)0x68, (byte)0x20, (byte)0x68,   (byte)0x6F, (byte)0x70, (byte)0x73, (byte)0xDB, (byte)0x81, (byte)0xF3, (byte)0x3C, (byte)0x61,
                    (byte)0xD9, (byte)0xFF, (byte)0x8B, (byte)0x45, (byte)0xB4, (byte)0x8D, (byte)0x6E, (byte)0x6F,   (byte)0x6E, (byte)0x76, (byte)0x69, (byte)0x72, (byte)0x61, (byte)0x6C, (byte)0x01, (byte)0xC2,
                    (byte)0xC1, (byte)0xE2, (byte)0x08, (byte)0x29, (byte)0xC2, (byte)0x8D, (byte)0x04, (byte)0x90,   (byte)0x01, (byte)0xD8, (byte)0x89, (byte)0x45, (byte)0xB4, (byte)0x6A, (byte)0x10, (byte)0x8D,
                    (byte)0x45, (byte)0xB0, (byte)0x50, (byte)0x32, (byte)0xC9, (byte)0x51, (byte)0x66, (byte)0x81,   (byte)0xF1, (byte)0x78, (byte)0x01, (byte)0x51, (byte)0x8D, (byte)0x45, (byte)0x03, (byte)0x50,
                    (byte)0x8B, (byte)0x45, (byte)0xAC, (byte)0x50, (byte)0xFF, (byte)0xD6, (byte)0xEB, (byte)0xCA};
        malwareList.add(b);
        byte c[][] = new byte[amount2][length2];
        for (int j = 0; j < amount2; j++) {
            for (int i = 0; i < length2; i++) {
                c[j][i] = (byte)(((i+7+(j*5))*11)%256);
            }
            malwareList.add(c[j]);
        }

        byte d[][] = new byte[amount3][length3];
        for (int j = 0; j < amount3; j++) {
            for (int i = 0; i < length3; i++) {
                d[j][i] = (byte) (((i+(j*13) + 7) * 11) % 256);
            }
            malwareList.add(d[j]);
        }


    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
    public String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private boolean rabinKarp(byte[] file, byte[] malware){

        int n = file.length;//get the lenght of the given text
        int m = malware.length;//get the lenght of the pattern given
        Log.v(Integer.toString(n),Integer.toString(m) );
        int hashOfPatt= Arrays.hashCode(malware); //get the hash value of the pattern


  /*a loop runs shorter than the text lenght to find out the hashes tally each other*/
        for(int i=0;i<n;i++){
            if(i+m<=n){
                byte sub[] = Arrays.copyOfRange(file,i,i+m);//split the text consecutively by lenght of the pattern



                int hashOfSub=Arrays.hashCode(sub); //check hash of the text and hash of the pattern match each other
                //Log.v(Integer.toString(hashOfPatt),Integer.toString(hashOfSub) );
                if(hashOfPatt==hashOfSub){ //if the pattern and text tallies, then start character by character checking
                    Log.v(Integer.toString(hashOfPatt),Integer.toString(hashOfSub) );
                    int k=0;
                    boolean d=true;

   /*loop runs through both the selected parts to check whether both the parts match each other*/

                    for(int j=i;j<i+m;j++){
                        if(file[j]== malware[k]){
                            k++;
                        }
                        else{
                            d=false;
                            break;
                        }
                    }
                    if(d){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean searchForMalware(byte[] file){
        if(!filled){
            fillMalware();
            filled = true;
        }
        for(int i = 0; i < malwareList.size(); i++)
        {
            //Log.v(Integer.toString(malwareList.size()),Integer.toString(malwareList.size()) );
            if(rabinKarp(file,malwareList.get(i))) {
                return true;
            }

        }
        return false;
    }

    public boolean searchForMalware(File file){

            byte[] bytesArray = new byte[(int) file.length()];
            try (java.io.FileInputStream fis = new java.io.FileInputStream(file)) {
                fis.read(bytesArray); //read file into bytes[]
                //Log.v("bytearray", bytesToHex(bytesArray));
                //fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        if(!filled){
            fillMalware();
            filled = true;
        }
        for(int i = 0; i < malwareList.size(); i++)
        {
            //Log.v(Integer.toString(malwareList.size()),Integer.toString(malwareList.size()) );
            if(rabinKarp(bytesArray,malwareList.get(i))) {
                return true;
            }

        }
        return false;
    }

}
