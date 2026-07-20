package rl;

import java.nio.charset.MalformedInputException;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes2.dex */
public class c extends MalformedInputException {

    @l
    private final String _message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@l String str) {
        super(0);
        l0.p(str, "message");
        this._message = str;
    }

    @Override // java.nio.charset.MalformedInputException, java.lang.Throwable
    @m
    public String getMessage() {
        return this._message;
    }
}
