package j9;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<c> f8613c;

    public a(long j10, int i10, List<c> list) {
        this.f8611a = j10;
        this.f8612b = i10;
        this.f8613c = list;
    }

    public int a() {
        return this.f8612b;
    }

    public long b() {
        return this.f8611a;
    }

    public List<c> c() {
        return this.f8613c;
    }

    public void d(int i10) {
        this.f8612b = i10;
    }

    public void e(long j10) {
        this.f8611a = j10;
    }

    public void f(List<c> list) {
        this.f8613c = list;
    }
}
