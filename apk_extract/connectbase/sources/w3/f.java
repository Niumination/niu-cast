package w3;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class f extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s3.h f17916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n3.a f17917d;

    public f(@NonNull Handler handler, s3.h hVar, n3.a aVar) {
        super(handler);
        this.f17916c = hVar;
        this.f17917d = aVar;
    }

    @Override // w3.c
    public void a() throws Throwable {
        l<String> lVarD = d.d(s3.g.F(), "", this.f17916c.A());
        if (lVarD.f17928a == -1 && s3.e.j(this.f17916c.b()) && s3.g.f14990w && !this.f17912a.hasMessages(298)) {
            Message messageObtainMessage = this.f17912a.obtainMessage(298);
            messageObtainMessage.arg1 = 1;
            this.f17912a.sendMessageDelayed(messageObtainMessage, 300000L);
            return;
        }
        int i10 = lVarD.f17928a;
        if (i10 == 0) {
            String str = lVarD.f17929b;
            y3.b.g("<-- globalConfig:%s", str);
            n3.b.l().h(str);
            this.f17916c.k(this.f17916c.i() + System.currentTimeMillis());
            this.f17912a.postAtFrontOfQueue(new Runnable() { // from class: w3.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17915a.e();
                }
            });
        } else if (i10 != 1) {
            s3.h hVar = this.f17916c;
            hVar.p(hVar.o() + 1);
        } else {
            y3.b.g("<-- globalConfig:%s", "NOT_MODIFIED");
            this.f17916c.k(this.f17916c.i() + System.currentTimeMillis());
        }
        n3.b.l().x();
    }

    @Override // w3.c
    public String c() {
        return "Retrieve-Global-Config";
    }

    public final /* synthetic */ void e() {
        n3.a aVar = this.f17917d;
        if (aVar != null) {
            aVar.a(0, false);
        }
    }
}
