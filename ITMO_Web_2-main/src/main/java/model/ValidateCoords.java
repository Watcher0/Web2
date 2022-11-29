package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateCoords {

    String x;
    String y;
    String r;

    public ValidateCoords(String x, String y, String r){
        this.x=x;
        this.y=y;
        this.r=r;
    }

    public Boolean checkCorrectValue(){
        try {
            return validateX(x)&&validateY(y)&&validateR(r);
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    private Boolean validateX(String x){
        String regex = "^-?[0-9]+([.,]?[0-9]+)?$";
        return x.matches(regex)&&Float.parseFloat(x)>=-5&&Float.parseFloat(x)<=3;
    }

    private Boolean validateY(String y){
        String regex = "^-?[0-9]+([.,]?[0-9]+)?$";
        return y.matches(regex)&&Float.parseFloat(y)>=-3&&Float.parseFloat(y)<=3;
    }

    private Boolean validateR(String r){
        for(float i=1; i<=3;i+=+0.5){
            if(Float.parseFloat(r)==i){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ValidateCoords{" +
                "x='" + validateX(x) + '\'' +
                ", y='" + validateY(y) + '\'' +
                ", r='" + validateR(r) + '\'' +
                '}';
    }
}
