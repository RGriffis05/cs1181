import javax.swing.*;
import java.awt.*;

public class Controller {
    public static boolean attemptWriteFile(String name, Color c, String password){
        if(!password.equals("rainbow")){
            return false;
        }

        //happy path

        try{
            return Data.writeData(name, c);
        } catch (Data.CouldNotWriteToFIleException cnwtfe){
            
            return false;

        }
    }
}
