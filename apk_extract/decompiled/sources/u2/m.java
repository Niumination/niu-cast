package u2;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.transsion.atomiccore.support.host.AtomicIntentType;

/* JADX INFO: loaded from: classes.dex */
public final class m extends h3.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f10350b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(com.google.android.gms.common.internal.a aVar, Looper looper) {
        super(looper, 1);
        this.f10350b = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0199  */
    @Override // h3.e, android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        if (this.f10350b.f1893x.get() != message.arg1) {
            int i8 = message.what;
            if (i8 == 2 || i8 == 1 || i8 == 7) {
                j jVar = (j) message.obj;
                jVar.getClass();
                jVar.c();
                return;
            }
            return;
        }
        int i9 = message.what;
        if (i9 != 1 && i9 != 7) {
            if (i9 == 4) {
                this.f10350b.getClass();
            } else if (i9 == 5) {
            }
            if (!this.f10350b.a()) {
                j jVar2 = (j) message.obj;
                jVar2.getClass();
                jVar2.c();
                return;
            }
        } else if (!this.f10350b.a()) {
            j jVar3 = (j) message.obj;
            jVar3.getClass();
            jVar3.c();
            return;
        }
        int i10 = message.what;
        if (i10 == 4) {
            com.google.android.gms.common.internal.a aVar = this.f10350b;
            aVar.u = new ConnectionResult(message.arg2);
            if (!aVar.f1891v && !TextUtils.isEmpty(aVar.p()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(aVar.p());
                    com.google.android.gms.common.internal.a aVar2 = this.f10350b;
                    if (!aVar2.f1891v) {
                        aVar2.t(null, 3);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            com.google.android.gms.common.internal.a aVar3 = this.f10350b;
            ConnectionResult connectionResult = aVar3.u;
            if (connectionResult == null) {
                connectionResult = new ConnectionResult(8);
            }
            aVar3.f1883k.a(connectionResult);
            this.f10350b.getClass();
            System.currentTimeMillis();
            return;
        }
        if (i10 == 5) {
            com.google.android.gms.common.internal.a aVar4 = this.f10350b;
            ConnectionResult connectionResult2 = aVar4.u;
            if (connectionResult2 == null) {
                connectionResult2 = new ConnectionResult(8);
            }
            aVar4.f1883k.a(connectionResult2);
            this.f10350b.getClass();
            System.currentTimeMillis();
            return;
        }
        if (i10 == 3) {
            Object obj = message.obj;
            this.f10350b.f1883k.a(new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
            this.f10350b.getClass();
            System.currentTimeMillis();
            return;
        }
        if (i10 == 6) {
            this.f10350b.t(null, 5);
            e eVar = this.f10350b.p;
            if (eVar != null) {
                ((q2.g) eVar.f10334a).e(message.arg2);
            }
            this.f10350b.getClass();
            System.currentTimeMillis();
            com.google.android.gms.common.internal.a.s(this.f10350b, 5, 1, null);
            return;
        }
        if (i10 == 2 && !this.f10350b.g()) {
            j jVar4 = (j) message.obj;
            jVar4.getClass();
            jVar4.c();
            return;
        }
        int i11 = message.what;
        if (i11 != 2 && i11 != 1 && i11 != 7) {
            Log.wtf("GmsClient", "Don't know how to handle message: " + i11, new Exception());
            return;
        }
        j jVar5 = (j) message.obj;
        synchronized (jVar5) {
            try {
                bool = jVar5.f10342a;
                if (jVar5.f10343b) {
                    Log.w("GmsClient", "Callback proxy " + jVar5.toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (bool != null) {
            com.google.android.gms.common.internal.a aVar5 = jVar5.f;
            int i12 = jVar5.f10345d;
            if (i12 != 0) {
                aVar5.t(null, 1);
                Bundle bundle = jVar5.e;
                jVar5.a(new ConnectionResult(i12, bundle != null ? (PendingIntent) bundle.getParcelable(AtomicIntentType.PENDING_INTENT) : null));
            } else if (!jVar5.b()) {
                aVar5.t(null, 1);
                jVar5.a(new ConnectionResult(8, null));
            }
        }
        synchronized (jVar5) {
            jVar5.f10343b = true;
        }
        jVar5.c();
    }
}
