package y4;

import androidx.annotation.NonNull;
import w4.c0;

/* JADX INFO: loaded from: classes2.dex */
public class d implements f4.c, f4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f20706a = c0.b.f17991a;

    @Override // f4.c
    public void onCancel(long j10, boolean z10) {
        this.f20706a.c0(j10, z10);
    }

    @Override // f4.c
    public void onFail(long j10, int i10) {
        this.f20706a.d0(j10, i10);
    }

    @Override // f4.c
    public void onFinish(long j10) {
        this.f20706a.e0(j10);
    }

    @Override // f4.c
    public void onProgress(long j10, double d10, int i10, int i11) {
        this.f20706a.f0(j10, d10, i10, i11);
    }

    @Override // f4.b
    public void onRequest(@NonNull String str, @NonNull String str2) {
        this.f20706a.b0(str, str2);
    }

    @Override // f4.c
    public void onStart(long j10, int i10) {
        this.f20706a.g0(j10, i10);
    }
}
