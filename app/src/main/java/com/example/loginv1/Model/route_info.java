package com.example.loginv1.Model;

public class route_info {

    private  String R_name;
    private  String AM_PM;
    private  String S_time;
    private  String E_time;
    private  int Image;

    public  route_info()
    {
    }

    public  route_info(String r_name,String am_pm,String s_time,String e_time, int image )
    {
        R_name = r_name;
        AM_PM=am_pm;
        S_time=s_time;
        E_time=e_time;
        Image=image;

    }

    public int getImage() {
        return Image;
    }

    public String getR_name() {
        return R_name;
    }

    public String getAM_PM() {
        return AM_PM;
    }

    public String getS_time() {
        return S_time;
    }

    public String getE_time() {
        return E_time;
    }

    public void setR_name(String r_name) {
        R_name = r_name;
    }

    public void setAM_PM(String AM_PM) {
        this.AM_PM = AM_PM;
    }

    public void setS_time(String s_time) {
        S_time = s_time;
    }

    public void setE_time(String e_time) {
        E_time = e_time;
    }

    public void setImage(int image) {
        Image = image;
    }
}
