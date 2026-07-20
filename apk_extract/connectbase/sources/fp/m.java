package fp;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f6264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f6265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f6266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile q f6267d;

    public void a(q qVar) {
        if (this.f6267d != null) {
            return;
        }
        synchronized (this) {
            if (this.f6267d != null) {
                return;
            }
            try {
                if (this.f6264a != null) {
                    this.f6267d = qVar.getParserForType().a(this.f6264a, this.f6265b);
                } else {
                    this.f6267d = qVar;
                }
            } catch (IOException unused) {
            }
        }
    }

    public int b() {
        return this.f6266c ? this.f6267d.getSerializedSize() : this.f6264a.size();
    }

    public q c(q qVar) {
        a(qVar);
        return this.f6267d;
    }

    public q d(q qVar) {
        q qVar2 = this.f6267d;
        this.f6267d = qVar;
        this.f6264a = null;
        this.f6266c = true;
        return qVar2;
    }
}
