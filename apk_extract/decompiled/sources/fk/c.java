package fk;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Serializable {
    private static final long serialVersionUID = 3;
    final Throwable e;

    public c(Throwable th2) {
        this.e = th2;
    }

    public String toString() {
        return "Notification=>Error:" + this.e;
    }
}
