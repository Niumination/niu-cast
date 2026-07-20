package zc;

import android.content.Context;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.hardware.face.ITranAuthenticationCallback;
import com.transsion.hubsdk.hardware.face.ITranFaceManager;
import com.transsion.hubsdk.hardware.face.TranFaceManager;
import dc.e;
import zb.f;

/* JADX INFO: loaded from: classes2.dex */
public class d implements sf.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f21916d = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranFaceManager f21917a = ITranFaceManager.Stub.asInterface(TranServiceManager.getServiceIBinder("face_manager"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f21918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TranFaceManager f21919c;

    public class a implements ITranAuthenticationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y9.b.a f21920a;

        public a(y9.b.a aVar) {
            this.f21920a = aVar;
        }

        public void a(int i10) {
            y9.b.a aVar = this.f21920a;
            if (aVar != null) {
                aVar.b(i10);
            }
        }

        public void b(int i10, CharSequence charSequence) {
            y9.b.a aVar = this.f21920a;
            if (aVar != null) {
                aVar.a(i10, charSequence);
            }
        }

        public void c() {
            y9.b.a aVar = this.f21920a;
            if (aVar != null) {
                aVar.d();
            }
        }

        public void d(int i10, CharSequence charSequence) {
            y9.b.a aVar = this.f21920a;
            if (aVar != null) {
                aVar.c(i10, charSequence);
            }
        }

        public void e(String str) {
            y9.b.a aVar = this.f21920a;
            if (aVar != null) {
                aVar.e(str);
            }
        }
    }

    @Override // sf.b
    public boolean a() {
        boolean zBooleanValue = ((Boolean) new f().c(new f.b() { // from class: zc.b
            @Override // zb.f.b
            public final Object run() {
                return this.f21909a.g();
            }
        }, "face_manager")).booleanValue();
        e.f(f21916d, "hasEnrolledTemplates");
        return zBooleanValue;
    }

    @Override // sf.b
    public void b(final CancellationSignal cancellationSignal, y9.b.a aVar, final Handler handler, final int i10, final boolean z10) {
        final a aVar2 = new a(aVar);
        new f().c(new f.b() { // from class: zc.c
            @Override // zb.f.b
            public final Object run() {
                return this.f21910a.f(cancellationSignal, aVar2, handler, i10, z10);
            }
        }, "face_manager");
        e.f(f21916d, "authenticate");
    }

    public final TranFaceManager e() {
        this.f21918b = bc.a.a();
        if (this.f21919c == null) {
            this.f21919c = new TranFaceManager(this.f21918b);
        }
        return this.f21919c;
    }

    public final /* synthetic */ Object f(CancellationSignal cancellationSignal, ITranAuthenticationCallback iTranAuthenticationCallback, Handler handler, int i10, boolean z10) throws RemoteException {
        e().authenticate(cancellationSignal, iTranAuthenticationCallback, handler, i10, z10);
        return null;
    }

    public final /* synthetic */ Object g() throws RemoteException {
        return Boolean.valueOf(e().hasEnrolledTemplates());
    }

    @VisibleForTesting
    public void h(ITranFaceManager iTranFaceManager) {
        this.f21917a = iTranFaceManager;
    }
}
