package model;


import sun.java2d.pipe.SpanShapeRenderer;
import view.TableValue;

import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CoordinateSave {
    private String x;
    private String y;
    private String r;
    public String time;
    private long long_time;
    private Boolean result;


    public CoordinateSave(String x, String y, String r, long start, Boolean result){
        this.x=x;
        this.y=y;
        this.r=r;
        this.result=result;
        long_time=start;
    }


    public TableValue getTableValue(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        TableValue tableValue = new TableValue();
        time=format.format(date);
        if(result){
            tableValue.setResult("Hit");
        }
        else{
            tableValue.setResult("Miss");
        }
        tableValue.setX(x);
        tableValue.setY(y);
        tableValue.setR(r);
        tableValue.setTime(time);
        tableValue.setLong_time(String.valueOf((date.getTime()-long_time)*0.001));
        return tableValue;
    }

    @Override
    public String toString() {
        return "<tr>" +
                "<th>" + x + "</th>" +
                "<th>" + y + "</th>" +
                "<th>" + r + "</th>" +
                "<th>" + time + "</th>" +
                "<th>" + long_time + "</th>" +
                "<th>" + result +"</th>" +
                "</tr>";
    }
}
