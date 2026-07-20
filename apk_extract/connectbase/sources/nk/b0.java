package nk;

import ik.r0;

/* JADX INFO: loaded from: classes2.dex */
public enum b0 {
    OK(r0.f8165g),
    NOT_MODIFIED(r0.f8177s),
    PRECONDITION_FAILED(r0.J);


    @os.l
    private final r0 statusCode;

    static {
        r0.a aVar = r0.f8158c;
        aVar.getClass();
        aVar.getClass();
        aVar.getClass();
    }

    b0(r0 r0Var) {
        this.statusCode = r0Var;
    }

    @os.l
    public final r0 getStatusCode() {
        return this.statusCode;
    }
}
