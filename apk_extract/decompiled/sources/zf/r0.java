package zf;

import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11540d;
    public final boolean e;
    public final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f11541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f11542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n0 f11543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n0 f11544j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f11545k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f11546l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f11547m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f11548n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f11549o;
    public final Lazy p;

    public r0(n0 n0Var, String host, int i8, ArrayList pathSegments, d0 parameters, String fragment, String str, String str2, boolean z2, String urlString) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        this.f11537a = host;
        this.f11538b = i8;
        this.f11539c = str;
        this.f11540d = str2;
        this.e = z2;
        this.f = urlString;
        if (i8 < 0 || i8 >= 65536) {
            throw new IllegalArgumentException(a1.a.o(i8, "Port must be between 0 and 65535, or 0 if not set. Provided: ").toString());
        }
        this.f11541g = pathSegments;
        this.f11542h = LazyKt.lazy(new ag.a(pathSegments, 23));
        this.f11543i = n0Var;
        this.f11544j = n0Var == null ? n0.f11524c : n0Var;
        this.f11545k = LazyKt.lazy(new cj.d(5, pathSegments, this));
        final int i9 = 0;
        this.f11546l = LazyKt.lazy(new Function0(this) { // from class: zf.q0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r0 f11535b;

            {
                this.f11535b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                r0 r0Var = this.f11535b;
                switch (i9) {
                    case 0:
                        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '?', 0, false, 6, (Object) null) + 1;
                        if (iIndexOf$default == 0) {
                            return "";
                        }
                        String str3 = r0Var.f;
                        int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str3, '#', iIndexOf$default, false, 4, (Object) null);
                        if (iIndexOf$default2 == -1) {
                            String strSubstring = str3.substring(iIndexOf$default);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            return strSubstring;
                        }
                        String strSubstring2 = str3.substring(iIndexOf$default, iIndexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        return strSubstring2;
                    case 1:
                        int iIndexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '/', r0Var.f11544j.f11526a.length() + 3, false, 4, (Object) null);
                        if (iIndexOf$default3 == -1) {
                            return "";
                        }
                        String str4 = r0Var.f;
                        int iIndexOf$default4 = StringsKt__StringsKt.indexOf$default((CharSequence) str4, '#', iIndexOf$default3, false, 4, (Object) null);
                        if (iIndexOf$default4 == -1) {
                            String strSubstring3 = str4.substring(iIndexOf$default3);
                            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                            return strSubstring3;
                        }
                        String strSubstring4 = str4.substring(iIndexOf$default3, iIndexOf$default4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                        return strSubstring4;
                    case 2:
                        String str5 = r0Var.f11539c;
                        if (str5 == null) {
                            return null;
                        }
                        if (str5.length() == 0) {
                            return "";
                        }
                        int length = r0Var.f11544j.f11526a.length() + 3;
                        String str6 = r0Var.f;
                        String strSubstring5 = str6.substring(length, StringsKt__StringsKt.indexOfAny$default((CharSequence) str6, new char[]{':', '@'}, length, false, 4, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                        return strSubstring5;
                    case 3:
                        String str7 = r0Var.f11540d;
                        if (str7 == null) {
                            return null;
                        }
                        if (str7.length() == 0) {
                            return "";
                        }
                        int length2 = r0Var.f11544j.f11526a.length() + 3;
                        String str8 = r0Var.f;
                        String strSubstring6 = str8.substring(StringsKt__StringsKt.indexOf$default((CharSequence) str8, ':', length2, false, 4, (Object) null) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) str8, '@', 0, false, 6, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
                        return strSubstring6;
                    default:
                        int iIndexOf$default5 = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '#', 0, false, 6, (Object) null) + 1;
                        if (iIndexOf$default5 == 0) {
                            return "";
                        }
                        String strSubstring7 = r0Var.f.substring(iIndexOf$default5);
                        Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
                        return strSubstring7;
                }
            }
        });
        final int i10 = 1;
        this.f11547m = LazyKt.lazy(new Function0(this) { // from class: zf.q0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r0 f11535b;

            {
                this.f11535b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                r0 r0Var = this.f11535b;
                switch (i10) {
                    case 0:
                        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '?', 0, false, 6, (Object) null) + 1;
                        if (iIndexOf$default == 0) {
                            return "";
                        }
                        String str3 = r0Var.f;
                        int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str3, '#', iIndexOf$default, false, 4, (Object) null);
                        if (iIndexOf$default2 == -1) {
                            String strSubstring = str3.substring(iIndexOf$default);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            return strSubstring;
                        }
                        String strSubstring2 = str3.substring(iIndexOf$default, iIndexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        return strSubstring2;
                    case 1:
                        int iIndexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '/', r0Var.f11544j.f11526a.length() + 3, false, 4, (Object) null);
                        if (iIndexOf$default3 == -1) {
                            return "";
                        }
                        String str4 = r0Var.f;
                        int iIndexOf$default4 = StringsKt__StringsKt.indexOf$default((CharSequence) str4, '#', iIndexOf$default3, false, 4, (Object) null);
                        if (iIndexOf$default4 == -1) {
                            String strSubstring3 = str4.substring(iIndexOf$default3);
                            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                            return strSubstring3;
                        }
                        String strSubstring4 = str4.substring(iIndexOf$default3, iIndexOf$default4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                        return strSubstring4;
                    case 2:
                        String str5 = r0Var.f11539c;
                        if (str5 == null) {
                            return null;
                        }
                        if (str5.length() == 0) {
                            return "";
                        }
                        int length = r0Var.f11544j.f11526a.length() + 3;
                        String str6 = r0Var.f;
                        String strSubstring5 = str6.substring(length, StringsKt__StringsKt.indexOfAny$default((CharSequence) str6, new char[]{':', '@'}, length, false, 4, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                        return strSubstring5;
                    case 3:
                        String str7 = r0Var.f11540d;
                        if (str7 == null) {
                            return null;
                        }
                        if (str7.length() == 0) {
                            return "";
                        }
                        int length2 = r0Var.f11544j.f11526a.length() + 3;
                        String str8 = r0Var.f;
                        String strSubstring6 = str8.substring(StringsKt__StringsKt.indexOf$default((CharSequence) str8, ':', length2, false, 4, (Object) null) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) str8, '@', 0, false, 6, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
                        return strSubstring6;
                    default:
                        int iIndexOf$default5 = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '#', 0, false, 6, (Object) null) + 1;
                        if (iIndexOf$default5 == 0) {
                            return "";
                        }
                        String strSubstring7 = r0Var.f.substring(iIndexOf$default5);
                        Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
                        return strSubstring7;
                }
            }
        });
        final int i11 = 2;
        this.f11548n = LazyKt.lazy(new Function0(this) { // from class: zf.q0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r0 f11535b;

            {
                this.f11535b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                r0 r0Var = this.f11535b;
                switch (i11) {
                    case 0:
                        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '?', 0, false, 6, (Object) null) + 1;
                        if (iIndexOf$default == 0) {
                            return "";
                        }
                        String str3 = r0Var.f;
                        int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str3, '#', iIndexOf$default, false, 4, (Object) null);
                        if (iIndexOf$default2 == -1) {
                            String strSubstring = str3.substring(iIndexOf$default);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            return strSubstring;
                        }
                        String strSubstring2 = str3.substring(iIndexOf$default, iIndexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        return strSubstring2;
                    case 1:
                        int iIndexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '/', r0Var.f11544j.f11526a.length() + 3, false, 4, (Object) null);
                        if (iIndexOf$default3 == -1) {
                            return "";
                        }
                        String str4 = r0Var.f;
                        int iIndexOf$default4 = StringsKt__StringsKt.indexOf$default((CharSequence) str4, '#', iIndexOf$default3, false, 4, (Object) null);
                        if (iIndexOf$default4 == -1) {
                            String strSubstring3 = str4.substring(iIndexOf$default3);
                            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                            return strSubstring3;
                        }
                        String strSubstring4 = str4.substring(iIndexOf$default3, iIndexOf$default4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                        return strSubstring4;
                    case 2:
                        String str5 = r0Var.f11539c;
                        if (str5 == null) {
                            return null;
                        }
                        if (str5.length() == 0) {
                            return "";
                        }
                        int length = r0Var.f11544j.f11526a.length() + 3;
                        String str6 = r0Var.f;
                        String strSubstring5 = str6.substring(length, StringsKt__StringsKt.indexOfAny$default((CharSequence) str6, new char[]{':', '@'}, length, false, 4, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                        return strSubstring5;
                    case 3:
                        String str7 = r0Var.f11540d;
                        if (str7 == null) {
                            return null;
                        }
                        if (str7.length() == 0) {
                            return "";
                        }
                        int length2 = r0Var.f11544j.f11526a.length() + 3;
                        String str8 = r0Var.f;
                        String strSubstring6 = str8.substring(StringsKt__StringsKt.indexOf$default((CharSequence) str8, ':', length2, false, 4, (Object) null) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) str8, '@', 0, false, 6, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
                        return strSubstring6;
                    default:
                        int iIndexOf$default5 = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '#', 0, false, 6, (Object) null) + 1;
                        if (iIndexOf$default5 == 0) {
                            return "";
                        }
                        String strSubstring7 = r0Var.f.substring(iIndexOf$default5);
                        Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
                        return strSubstring7;
                }
            }
        });
        final int i12 = 3;
        this.f11549o = LazyKt.lazy(new Function0(this) { // from class: zf.q0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r0 f11535b;

            {
                this.f11535b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                r0 r0Var = this.f11535b;
                switch (i12) {
                    case 0:
                        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '?', 0, false, 6, (Object) null) + 1;
                        if (iIndexOf$default == 0) {
                            return "";
                        }
                        String str3 = r0Var.f;
                        int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str3, '#', iIndexOf$default, false, 4, (Object) null);
                        if (iIndexOf$default2 == -1) {
                            String strSubstring = str3.substring(iIndexOf$default);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            return strSubstring;
                        }
                        String strSubstring2 = str3.substring(iIndexOf$default, iIndexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        return strSubstring2;
                    case 1:
                        int iIndexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '/', r0Var.f11544j.f11526a.length() + 3, false, 4, (Object) null);
                        if (iIndexOf$default3 == -1) {
                            return "";
                        }
                        String str4 = r0Var.f;
                        int iIndexOf$default4 = StringsKt__StringsKt.indexOf$default((CharSequence) str4, '#', iIndexOf$default3, false, 4, (Object) null);
                        if (iIndexOf$default4 == -1) {
                            String strSubstring3 = str4.substring(iIndexOf$default3);
                            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                            return strSubstring3;
                        }
                        String strSubstring4 = str4.substring(iIndexOf$default3, iIndexOf$default4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                        return strSubstring4;
                    case 2:
                        String str5 = r0Var.f11539c;
                        if (str5 == null) {
                            return null;
                        }
                        if (str5.length() == 0) {
                            return "";
                        }
                        int length = r0Var.f11544j.f11526a.length() + 3;
                        String str6 = r0Var.f;
                        String strSubstring5 = str6.substring(length, StringsKt__StringsKt.indexOfAny$default((CharSequence) str6, new char[]{':', '@'}, length, false, 4, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                        return strSubstring5;
                    case 3:
                        String str7 = r0Var.f11540d;
                        if (str7 == null) {
                            return null;
                        }
                        if (str7.length() == 0) {
                            return "";
                        }
                        int length2 = r0Var.f11544j.f11526a.length() + 3;
                        String str8 = r0Var.f;
                        String strSubstring6 = str8.substring(StringsKt__StringsKt.indexOf$default((CharSequence) str8, ':', length2, false, 4, (Object) null) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) str8, '@', 0, false, 6, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
                        return strSubstring6;
                    default:
                        int iIndexOf$default5 = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '#', 0, false, 6, (Object) null) + 1;
                        if (iIndexOf$default5 == 0) {
                            return "";
                        }
                        String strSubstring7 = r0Var.f.substring(iIndexOf$default5);
                        Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
                        return strSubstring7;
                }
            }
        });
        final int i13 = 4;
        this.p = LazyKt.lazy(new Function0(this) { // from class: zf.q0

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ r0 f11535b;

            {
                this.f11535b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                r0 r0Var = this.f11535b;
                switch (i13) {
                    case 0:
                        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '?', 0, false, 6, (Object) null) + 1;
                        if (iIndexOf$default == 0) {
                            return "";
                        }
                        String str3 = r0Var.f;
                        int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str3, '#', iIndexOf$default, false, 4, (Object) null);
                        if (iIndexOf$default2 == -1) {
                            String strSubstring = str3.substring(iIndexOf$default);
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            return strSubstring;
                        }
                        String strSubstring2 = str3.substring(iIndexOf$default, iIndexOf$default2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        return strSubstring2;
                    case 1:
                        int iIndexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '/', r0Var.f11544j.f11526a.length() + 3, false, 4, (Object) null);
                        if (iIndexOf$default3 == -1) {
                            return "";
                        }
                        String str4 = r0Var.f;
                        int iIndexOf$default4 = StringsKt__StringsKt.indexOf$default((CharSequence) str4, '#', iIndexOf$default3, false, 4, (Object) null);
                        if (iIndexOf$default4 == -1) {
                            String strSubstring3 = str4.substring(iIndexOf$default3);
                            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                            return strSubstring3;
                        }
                        String strSubstring4 = str4.substring(iIndexOf$default3, iIndexOf$default4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                        return strSubstring4;
                    case 2:
                        String str5 = r0Var.f11539c;
                        if (str5 == null) {
                            return null;
                        }
                        if (str5.length() == 0) {
                            return "";
                        }
                        int length = r0Var.f11544j.f11526a.length() + 3;
                        String str6 = r0Var.f;
                        String strSubstring5 = str6.substring(length, StringsKt__StringsKt.indexOfAny$default((CharSequence) str6, new char[]{':', '@'}, length, false, 4, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                        return strSubstring5;
                    case 3:
                        String str7 = r0Var.f11540d;
                        if (str7 == null) {
                            return null;
                        }
                        if (str7.length() == 0) {
                            return "";
                        }
                        int length2 = r0Var.f11544j.f11526a.length() + 3;
                        String str8 = r0Var.f;
                        String strSubstring6 = str8.substring(StringsKt__StringsKt.indexOf$default((CharSequence) str8, ':', length2, false, 4, (Object) null) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) str8, '@', 0, false, 6, (Object) null));
                        Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
                        return strSubstring6;
                    default:
                        int iIndexOf$default5 = StringsKt__StringsKt.indexOf$default((CharSequence) r0Var.f, '#', 0, false, 6, (Object) null) + 1;
                        if (iIndexOf$default5 == 0) {
                            return "";
                        }
                        String strSubstring7 = r0Var.f.substring(iIndexOf$default5);
                        Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
                        return strSubstring7;
                }
            }
        });
    }

    public final int a() {
        int i8 = this.f11538b;
        Integer numValueOf = Integer.valueOf(i8);
        if (i8 == 0) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : this.f11544j.f11527b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r0.class != obj.getClass()) {
            return false;
        }
        return Intrinsics.areEqual(this.f, ((r0) obj).f);
    }

    public final int hashCode() {
        return this.f.hashCode();
    }

    public final String toString() {
        return this.f;
    }
}
