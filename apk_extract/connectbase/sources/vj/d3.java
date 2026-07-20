package vj;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class d3 extends w.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f17083a = Logger.getLogger(d3.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<w> f17084b = new ThreadLocal<>();

    @Override // vj.w.m
    public w a() {
        w wVar = f17084b.get();
        return wVar == null ? w.f17452f : wVar;
    }

    @Override // vj.w.m
    public void b(w wVar, w wVar2) {
        if (a() != wVar) {
            f17083a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (wVar2 != w.f17452f) {
            f17084b.set(wVar2);
        } else {
            f17084b.set(null);
        }
    }

    @Override // vj.w.m
    public w c(w wVar) {
        w wVarA = a();
        f17084b.set(wVar);
        return wVarA;
    }
}
