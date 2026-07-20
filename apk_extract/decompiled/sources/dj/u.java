package dj;

import com.transsion.message.bank.MessageBank;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char[] f4632k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f4636d;
    public final String e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f4637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList f4638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f4639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f4640j;

    public u(String scheme, String username, String password, String host, int i8, ArrayList pathSegments, ArrayList arrayList, String str, String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.f4634b = scheme;
        this.f4635c = username;
        this.f4636d = password;
        this.e = host;
        this.f = i8;
        this.f4637g = pathSegments;
        this.f4638h = arrayList;
        this.f4639i = str;
        this.f4640j = url;
        this.f4633a = Intrinsics.areEqual(scheme, "https");
    }

    public final String a() {
        if (this.f4636d.length() == 0) {
            return "";
        }
        int length = this.f4634b.length() + 3;
        String str = this.f4640j;
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, ':', length, false, 4, (Object) null) + 1;
        int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str, '@', 0, false, 6, (Object) null);
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iIndexOf$default, iIndexOf$default2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String b() {
        int length = this.f4634b.length() + 3;
        String str = this.f4640j;
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', length, false, 4, (Object) null);
        String strSubstring = str.substring(iIndexOf$default, ej.b.f(iIndexOf$default, str.length(), str, "?#"));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final ArrayList c() {
        int length = this.f4634b.length() + 3;
        String str = this.f4640j;
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '/', length, false, 4, (Object) null);
        int iF = ej.b.f(iIndexOf$default, str.length(), str, "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iF) {
            int i8 = iIndexOf$default + 1;
            int iG = ej.b.g(str, '/', i8, iF);
            String strSubstring = str.substring(i8, iG);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iIndexOf$default = iG;
        }
        return arrayList;
    }

    public final String d() {
        if (this.f4638h == null) {
            return null;
        }
        String str = this.f4640j;
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, '?', 0, false, 6, (Object) null) + 1;
        String strSubstring = str.substring(iIndexOf$default, ej.b.g(str, '#', iIndexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String e() {
        if (this.f4635c.length() == 0) {
            return "";
        }
        int length = this.f4634b.length() + 3;
        String str = this.f4640j;
        int iF = ej.b.f(length, str.length(), str, ":@");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(length, iF);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof u) && Intrinsics.areEqual(((u) obj).f4640j, this.f4640j);
    }

    public final t f(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            t tVar = new t();
            tVar.d(this, link);
            return tVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String g() {
        t tVarF = f("/...");
        Intrinsics.checkNotNull(tVarF);
        tVarF.getClass();
        Intrinsics.checkNotNullParameter("", "username");
        tVarF.f4627b = l.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
        Intrinsics.checkNotNullParameter("", MessageBank.KEY_PASSWORD);
        tVarF.f4628c = l.b("", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 251);
        return tVarF.a().f4640j;
    }

    public final URI h() {
        String strSubstring;
        t tVar = new t();
        String str = this.f4634b;
        tVar.f4626a = str;
        String strE = e();
        Intrinsics.checkNotNullParameter(strE, "<set-?>");
        tVar.f4627b = strE;
        String strA = a();
        Intrinsics.checkNotNullParameter(strA, "<set-?>");
        tVar.f4628c = strA;
        tVar.f4629d = this.e;
        int iC = l.c(str);
        int i8 = this.f;
        if (i8 == iC) {
            i8 = -1;
        }
        tVar.e = i8;
        ArrayList arrayList = tVar.f;
        arrayList.clear();
        arrayList.addAll(c());
        tVar.c(d());
        if (this.f4639i == null) {
            strSubstring = null;
        } else {
            String str2 = this.f4640j;
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, '#', 0, false, 6, (Object) null) + 1;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str2.substring(iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        }
        tVar.f4631h = strSubstring;
        String str3 = tVar.f4629d;
        tVar.f4629d = str3 != null ? new Regex("[\"<>^`{|}]").replace(str3, "") : null;
        int size = arrayList.size();
        for (int i9 = 0; i9 < size; i9++) {
            arrayList.set(i9, l.b((String) arrayList.get(i9), 0, 0, "[]", true, true, false, false, 227));
        }
        ArrayList arrayList2 = tVar.f4630g;
        if (arrayList2 != null) {
            int size2 = arrayList2.size();
            for (int i10 = 0; i10 < size2; i10++) {
                String str4 = (String) arrayList2.get(i10);
                arrayList2.set(i10, str4 != null ? l.b(str4, 0, 0, "\\^`{|}", true, true, true, false, 195) : null);
            }
        }
        String str5 = tVar.f4631h;
        tVar.f4631h = str5 != null ? l.b(str5, 0, 0, " \"#<>\\^`{|}", true, true, false, true, 163) : null;
        String string = tVar.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                Intrinsics.checkNotNullExpressionValue(uriCreate, "try {\n        val stripp…e) // Unexpected!\n      }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final int hashCode() {
        return this.f4640j.hashCode();
    }

    public final String toString() {
        return this.f4640j;
    }
}
