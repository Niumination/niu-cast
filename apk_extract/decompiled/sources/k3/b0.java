package k3;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f6372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f6373d;

    public b0() {
        this.f6370a = 0;
        this.f6373d = new Object[4];
        this.f6371b = 0;
    }

    public void a(Object obj) {
        obj.getClass();
        b(this.f6371b + 1);
        Object[] objArr = (Object[]) this.f6373d;
        int i8 = this.f6371b;
        this.f6371b = i8 + 1;
        objArr[i8] = obj;
    }

    public void b(int i8) {
        Object[] objArr = (Object[]) this.f6373d;
        int length = objArr.length;
        if (length >= i8) {
            if (this.f6372c) {
                this.f6373d = (Object[]) objArr.clone();
                this.f6372c = false;
                return;
            }
            return;
        }
        int i9 = length + (length >> 1) + 1;
        if (i9 < i8) {
            int iHighestOneBit = Integer.highestOneBit(i8 - 1);
            i9 = iHighestOneBit + iHighestOneBit;
        }
        if (i9 < 0) {
            i9 = Integer.MAX_VALUE;
        }
        this.f6373d = Arrays.copyOf(objArr, i9);
        this.f6372c = false;
    }

    public e0 c() {
        this.f6372c = true;
        return e0.zzg((Object[]) this.f6373d, this.f6371b);
    }

    public String toString() {
        switch (this.f6370a) {
            case 1:
                o6.a aVarA = t8.a(this);
                aVarA.d((ze.f) this.f6373d, "callOptions");
                aVarA.c(this.f6371b, "previousAttempts");
                aVarA.f("isTransparentRetry", this.f6372c);
                return aVarA.toString();
            default:
                return super.toString();
        }
    }

    public b0(ze.f fVar, int i8, boolean z2) {
        this.f6370a = 1;
        v8.i(fVar, "callOptions");
        this.f6373d = fVar;
        this.f6371b = i8;
        this.f6372c = z2;
    }
}
