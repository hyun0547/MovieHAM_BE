package util.com;

public class CommonUtil {

    public static <T> T checkNullEmpty(T parameter, T defaultValue){

        if(parameter == null){
            return defaultValue;
        }
        else if("".equals(parameter)){
            return defaultValue;
        }

        return parameter;
    }

}
