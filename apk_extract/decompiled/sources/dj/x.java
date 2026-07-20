package dj;

import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f4641d = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern e = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f4644c;

    public x(String str, String str2, String[] strArr) {
        this.f4642a = str;
        this.f4643b = str2;
        this.f4644c = strArr;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof x) && Intrinsics.areEqual(((x) obj).f4642a, this.f4642a);
    }

    public final int hashCode() {
        return this.f4642a.hashCode();
    }

    public final String toString() {
        return this.f4642a;
    }
}
