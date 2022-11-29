package view;

import java.io.Serializable;

public class TableValue implements Serializable {

    private String x;
    private String y;
    private String r;
    private String time;
    private String long_time;
    private String result;
    private String table="";

    public TableValue(){

    }
    public void addValue(String str){
        table=table+str;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLong_time() {
        return long_time;
    }

    public void setLong_time(String long_time) {
        this.long_time = long_time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "<tr>" +
                "<td>" + x + "</td>" +
                "<td>" + y + "</td>" +
                "<td>" + r + "</td>" +
                "<td>" + time + "</td>" +
                "<td>" + long_time + "</td>" +
                "<td>" + result + "</td>" +
                "</tr>";
    }

    public String getTabel() {
        return table;
    }
}
