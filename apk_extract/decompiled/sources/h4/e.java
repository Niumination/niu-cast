package h4;

/* JADX INFO: loaded from: classes.dex */
public final class e extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5245b = Integer.numberOfLeadingZeros(31);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f5246c = new e("CharMatcher.whitespace()");

    @Override // k3.s8
    public final boolean a(char c9) {
        return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c9) >>> f5245b) == c9;
    }
}
