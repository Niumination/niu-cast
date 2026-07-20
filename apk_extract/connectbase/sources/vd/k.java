package vd;

import android.content.Context;
import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.os.ITranNvramService;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k implements pg.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16948c = "k";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f16950b = bc.a.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranNvramService f16949a = ITranNvramService.Stub.asInterface(TranServiceManager.getServiceIBinder("nvram"));

    @Override // pg.g
    public byte a(final String str, final int i10, final List list) {
        byte bByteValue = ((Byte) new zb.f(this.f16950b).c(new zb.f.b() { // from class: vd.j
            @Override // zb.f.b
            public final Object run() {
                return this.f16941a.l(str, i10, list);
            }
        }, "nvram")).byteValue();
        dc.e.f(f16948c, "writeFileByNamevec mByteData:" + ((int) bByteValue));
        return bByteValue;
    }

    @Override // pg.g
    public boolean b() {
        boolean zBooleanValue = ((Boolean) new zb.f(this.f16950b).c(new zb.f.b() { // from class: vd.g
            @Override // zb.f.b
            public final Object run() {
                return this.f16926a.i();
            }
        }, "nvram")).booleanValue();
        ic.n0.a("backupToBinRegion_All result:", zBooleanValue, f16948c);
        return zBooleanValue;
    }

    @Override // pg.g
    public String c(final String str, final int i10) {
        String str2 = (String) new zb.f(this.f16950b).c(new zb.f.b() { // from class: vd.h
            @Override // zb.f.b
            public final Object run() {
                return this.f16931a.k(str, i10);
            }
        }, "nvram");
        dc.e.f(f16948c, "readFileByName result:" + str2);
        return str2;
    }

    @Override // pg.g
    public boolean d(final String str) {
        boolean zBooleanValue = ((Boolean) new zb.f(this.f16950b).c(new zb.f.b() { // from class: vd.i
            @Override // zb.f.b
            public final Object run() {
                return this.f16937a.j(str);
            }
        }, "nvram")).booleanValue();
        ic.n0.a("deleteFileByName result:", zBooleanValue, f16948c);
        return zBooleanValue;
    }

    public final /* synthetic */ Object i() throws RemoteException {
        ITranNvramService iTranNvramService = this.f16949a;
        if (iTranNvramService != null) {
            return Boolean.valueOf(iTranNvramService.BackupToBinRegion_All());
        }
        return 0;
    }

    public final /* synthetic */ Object j(String str) throws RemoteException {
        ITranNvramService iTranNvramService = this.f16949a;
        if (iTranNvramService != null) {
            return Boolean.valueOf(iTranNvramService.DeleteFile(str));
        }
        return 0;
    }

    public final /* synthetic */ Object k(String str, int i10) throws RemoteException {
        ITranNvramService iTranNvramService = this.f16949a;
        if (iTranNvramService != null) {
            return iTranNvramService.readFileByName(str, i10);
        }
        return 0;
    }

    public final /* synthetic */ Object l(String str, int i10, List list) throws RemoteException {
        ITranNvramService iTranNvramService = this.f16949a;
        if (iTranNvramService != null) {
            return Byte.valueOf(iTranNvramService.writeFileByNamevec(str, i10, list));
        }
        return 0;
    }
}
