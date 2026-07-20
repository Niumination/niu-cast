package ca;

import dc.e;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f1387c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public dd.a f1388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l7.a f1389b;

    /* JADX INFO: renamed from: ca.a$a, reason: collision with other inner class name */
    public interface InterfaceC0061a {
        void f(int i10, String str);
    }

    public wf.a a(String str) {
        if (b.b(str)) {
            e.f(f1387c, dd.a.f3695c);
            dd.a aVar = this.f1388a;
            if (aVar != null) {
                return aVar;
            }
            dd.a aVar2 = new dd.a();
            this.f1388a = aVar2;
            return aVar2;
        }
        e.f(f1387c, "TranAospTpManager");
        l7.a aVar3 = this.f1389b;
        if (aVar3 != null) {
            return aVar3;
        }
        l7.a aVar4 = new l7.a();
        this.f1389b = aVar4;
        return aVar4;
    }

    public String b(int i10) throws ac.a {
        if (!fc.a.f()) {
            return null;
        }
        if (i10 >= 0) {
            return a(b.a.f6005y).getValue(i10);
        }
        throw new IllegalArgumentException("type should be greater than 0");
    }

    public boolean c(int i10, String str) throws ac.a {
        if (!fc.a.f()) {
            return false;
        }
        if (i10 < 0 || str == null) {
            throw new IllegalArgumentException("type should be greater than 0 and data should not be null");
        }
        return a(b.a.f6005y).setValue(i10, str);
    }
}
