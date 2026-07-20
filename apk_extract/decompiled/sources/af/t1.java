package af;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f594b;

    public t1(int i8) {
        this.f593a = i8;
        switch (i8) {
            case 1:
                this.f594b = new ArrayList(20);
                break;
            case 2:
                this.f594b = new ArrayList();
                break;
            default:
                this.f594b = new ArrayList();
                break;
        }
    }

    public void a(Object obj, String str) {
        this.f594b.add(str + "=" + obj);
    }

    public String toString() {
        switch (this.f593a) {
            case 0:
                return this.f594b.toString();
            default:
                return super.toString();
        }
    }
}
