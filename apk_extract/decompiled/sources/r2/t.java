package r2;

import android.accounts.Account;
import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import mg.b0;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final class t extends p3.b implements q2.g, q2.h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final o3.b f9365j = o3.c.f8368a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f9366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h3.e f9367d;
    public final o3.b e;
    public final Set f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c2.k f9368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p3.a f9369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b0 f9370i;

    public t(Context context, h3.e eVar, c2.k kVar) {
        super("com.google.android.gms.signin.internal.ISignInCallbacks", 0);
        this.f9366c = context;
        this.f9367d = eVar;
        this.f9368g = kVar;
        this.f = (Set) kVar.f1407a;
        this.e = f9365j;
    }

    @Override // q2.g
    public final void e(int i8) {
        this.f9369h.disconnect();
    }

    @Override // q2.h
    public final void g(ConnectionResult connectionResult) {
        this.f9370i.b(connectionResult);
    }

    @Override // q2.g
    public final void onConnected() {
        GoogleSignInAccount googleSignInAccountG;
        p3.a aVar = this.f9369h;
        aVar.getClass();
        try {
            aVar.B.getClass();
            Account account = new Account("<<default account>>", "com.google");
            if ("<<default account>>".equals(account.name)) {
                Context context = aVar.f1878c;
                ReentrantLock reentrantLock = o2.a.f8362c;
                u2.l.e(context);
                ReentrantLock reentrantLock2 = o2.a.f8362c;
                reentrantLock2.lock();
                try {
                    if (o2.a.f8363d == null) {
                        o2.a.f8363d = new o2.a(context.getApplicationContext());
                    }
                    o2.a aVar2 = o2.a.f8363d;
                    reentrantLock2.unlock();
                    String strA = aVar2.a("defaultGoogleSignInAccount");
                    if (!TextUtils.isEmpty(strA)) {
                        String strA2 = aVar2.a("googleSignInAccount:" + strA);
                        if (strA2 != null) {
                            try {
                                googleSignInAccountG = GoogleSignInAccount.g(strA2);
                            } catch (JSONException unused) {
                                googleSignInAccountG = null;
                            }
                        }
                    }
                    googleSignInAccountG = null;
                } catch (Throwable th2) {
                    reentrantLock2.unlock();
                    throw th2;
                }
            } else {
                googleSignInAccountG = null;
            }
            Integer num = aVar.D;
            u2.l.e(num);
            zat zatVar = new zat(2, account, num.intValue(), googleSignInAccountG);
            p3.c cVar = (p3.c) aVar.o();
            zai zaiVar = new zai(1, zatVar);
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeInterfaceToken(cVar.f5236d);
            h3.c.c(parcelObtain, zaiVar);
            h3.c.d(parcelObtain, this);
            cVar.e(parcelObtain, 12);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                this.f9367d.post(new i2.e(this, 14, new zak(1, new ConnectionResult(8, null), null), false));
            } catch (RemoteException unused2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }
}
