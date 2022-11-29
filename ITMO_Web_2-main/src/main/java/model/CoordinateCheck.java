package model;

public class CoordinateCheck {
    Float x;
    Float y;
    Float r;

    public CoordinateCheck(String x, String y, String r){
        this.x=Float.valueOf(x);
        this.y=Float.valueOf(y);
        this.r=Float.valueOf(r);
    }

    public Boolean result(){
        return coordinateQuarterFourth()||coordinateQuarterSecond()||coordinateQuarterThird();
    }

    private Boolean coordinateQuarterSecond(){
        return x<=0 && y>=0 && x*x+y*y<=r*r;
    }

    private Boolean coordinateQuarterThird(){
        return x>=0 && y<=0 && 2*y >=x-r;
    }

    private Boolean coordinateQuarterFourth(){
        return x>=0 && y>=0 && x<=r && y<=r;
    }
}
