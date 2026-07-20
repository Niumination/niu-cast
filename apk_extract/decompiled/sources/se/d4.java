package se;

import kotlin.Pair;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pair f9716b;

    public /* synthetic */ d4(Pair pair, int i8) {
        this.f9715a = i8;
        this.f9716b = pair;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9715a) {
            case 0:
                ((b4) this.f9716b.getSecond()).g();
                break;
            case 1:
                ((b4) this.f9716b.getSecond()).e();
                break;
            case 2:
                ((b4) this.f9716b.getSecond()).d();
                break;
            default:
                ((b4) this.f9716b.getSecond()).i();
                break;
        }
    }
}
