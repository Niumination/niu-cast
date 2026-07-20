package x4;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public char[] f10831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10832b;

    @Override // java.lang.CharSequence
    public final char charAt(int i8) {
        return this.f10831a[i8];
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f10831a.length;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i8, int i9) {
        return new String(this.f10831a, i8, i9 - i8);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        if (this.f10832b == null) {
            this.f10832b = new String(this.f10831a);
        }
        return this.f10832b;
    }
}
