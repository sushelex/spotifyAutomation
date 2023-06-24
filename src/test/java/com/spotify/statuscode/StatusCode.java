package com.spotify.statuscode;

public enum StatusCode {
    CODE_200(200, ""),
    CODE_201(201,""),
    CODE_400(400, ""),
    CODE_404(404, ""),
    CODE_500(500, "");

    public final int i;
    public final String message;
    StatusCode(int i, String s) {
        this.i = i;
        this.message = s;
    }
}
