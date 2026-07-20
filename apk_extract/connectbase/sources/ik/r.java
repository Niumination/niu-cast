package ik;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final List<String> f8155a = nm.y.O("***, dd MMM YYYY hh:mm:ss zzz", "****, dd-MMM-YYYY hh:mm:ss zzz", "*** MMM d hh:mm:ss YYYY", "***, dd-MMM-YYYY hh:mm:ss zzz", "***, dd-MMM-YYYY hh-mm-ss zzz", "***, dd MMM YYYY hh:mm:ss zzz", "*** dd-MMM-YYYY hh:mm:ss zzz", "*** dd MMM YYYY hh:mm:ss zzz", "*** dd-MMM-YYYY hh-mm-ss zzz", "***,dd-MMM-YYYY hh:mm:ss zzz", "*** MMM d YYYY hh:mm:ss zzz");

    @os.l
    public static final kl.d a(@os.l String str) {
        kn.l0.p(str, "<this>");
        String string = jq.h0.C5(str).toString();
        try {
            return new n().c(string);
        } catch (w0 unused) {
            return b(string);
        }
    }

    @os.l
    public static final kl.d b(@os.l String str) {
        kn.l0.p(str, "<this>");
        String string = jq.h0.C5(str).toString();
        Iterator<String> it = f8155a.iterator();
        while (it.hasNext()) {
            try {
                return new kl.f(it.next()).b(str);
            } catch (kl.g unused) {
            }
        }
        throw new IllegalStateException(kn.l0.C("Failed to parse date: ", string).toString());
    }

    public static /* synthetic */ void c() {
    }

    public static final String d(int i10, int i11) {
        return jq.h0.R3(String.valueOf(i10), i11, '0');
    }

    @os.l
    public static final String e(@os.l kl.d dVar) {
        kn.l0.p(dVar, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(kn.l0.C(dVar.f9257d.getValue(), ", "));
        sb2.append(kn.l0.C(d(dVar.f9258e, 2), " "));
        sb2.append(kn.l0.C(dVar.f9260g.getValue(), " "));
        sb2.append(d(dVar.f9261i, 4));
        sb2.append(" " + d(dVar.f9256c, 2) + n1.e.f11184d + d(dVar.f9255b, 2) + n1.e.f11184d + d(dVar.f9254a, 2) + ' ');
        sb2.append("GMT");
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
