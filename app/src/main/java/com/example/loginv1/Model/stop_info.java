package com.example.loginv1.Model;

public class stop_info {
        private  String S_name;
        private  String S_staus;
        private  String S_count;

        public  stop_info()
        {
        }

        public  stop_info(String s_name,String s_staus,String s_count)
        {
            S_name = s_name;
            S_count= s_count;
            S_staus =s_staus;

        }



        public String getS_name() {
            return S_name;
        }

    public String getS_staus() {
        return S_staus;
    }

    public String getS_count() {
        return S_count;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public void setS_staus(String s_staus) {
        S_staus = s_staus;
    }

    public void setS_count(String s_count) {
        S_count = s_count;
    }
}