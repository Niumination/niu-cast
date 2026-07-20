package vd;

import android.os.RemoteException;
import com.transsion.hubsdk.os.ITranSystemProperties;
import com.transsion.hubsdk.os.TranSystemProperties;

/* JADX INFO: loaded from: classes2.dex */
public class c0 implements pg.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranSystemProperties f16915a;

    @Override // pg.l
    public boolean a(String str, boolean z10) throws RemoteException {
        return TranSystemProperties.getBoolean(str, z10);
    }

    @Override // pg.l
    public long b(String str, long j10) throws RemoteException {
        return TranSystemProperties.getLong(str, j10);
    }

    @Override // pg.l
    public void c(String str, String str2) throws RemoteException {
        TranSystemProperties.set(str, str2);
    }

    @Override // pg.l
    public int d(String str, int i10) throws RemoteException {
        return TranSystemProperties.getInt(str, i10);
    }

    @Override // pg.l
    public String e(String str, String str2) throws RemoteException {
        return TranSystemProperties.get(str, str2);
    }
}
