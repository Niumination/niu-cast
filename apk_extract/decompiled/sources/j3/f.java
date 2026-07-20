package j3;

import com.google.android.gms.common.Feature;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f6067a = new Object[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6068b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f6069c;

    public final void a(String str, Feature feature) {
        int i8 = this.f6068b + 1;
        Object[] objArr = this.f6067a;
        int length = objArr.length;
        int i9 = i8 + i8;
        if (i9 > length) {
            if (i9 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i10 = length + (length >> 1) + 1;
            if (i10 < i9) {
                int iHighestOneBit = Integer.highestOneBit(i9 - 1);
                i10 = iHighestOneBit + iHighestOneBit;
            }
            if (i10 < 0) {
                i10 = Integer.MAX_VALUE;
            }
            this.f6067a = Arrays.copyOf(objArr, i10);
        }
        Object[] objArr2 = this.f6067a;
        int i11 = this.f6068b;
        int i12 = i11 + i11;
        objArr2[i12] = str;
        objArr2[i12 + 1] = feature;
        this.f6068b = i11 + 1;
    }
}
