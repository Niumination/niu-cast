package b8;

import android.content.Context;
import android.nfc.NfcManager;

/* JADX INFO: loaded from: classes2.dex */
public class b implements mg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f754c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NfcManager f756b;

    public b() {
        Context contextA = bc.a.a();
        this.f755a = contextA;
        this.f756b = (NfcManager) contextA.getSystemService("nfc");
    }

    @Override // mg.b
    public boolean a() {
        Object objJ = cc.a.j(cc.a.g(this.f756b.getClass(), "getDefaultAdapter", new Class[0]), this.f756b, new Object[0]);
        if (objJ == null) {
            return false;
        }
        Object objJ2 = cc.a.j(cc.a.g(objJ.getClass(), "disable", new Class[0]), objJ, new Object[0]);
        if (objJ2 instanceof Boolean) {
            return ((Boolean) objJ2).booleanValue();
        }
        return false;
    }

    @Override // mg.b
    public boolean b() {
        Object objJ = cc.a.j(cc.a.g(this.f756b.getClass(), "getDefaultAdapter", new Class[0]), this.f756b, new Object[0]);
        if (objJ == null) {
            return false;
        }
        Object objJ2 = cc.a.j(cc.a.g(objJ.getClass(), hi.b.f7122k, new Class[0]), objJ, new Object[0]);
        if (objJ2 instanceof Boolean) {
            return ((Boolean) objJ2).booleanValue();
        }
        return false;
    }
}
