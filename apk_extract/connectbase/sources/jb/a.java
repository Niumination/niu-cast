package jb;

import com.transsion.hubsdk.api.telephony.TranAlphaTag;
import com.transsion.hubsdk.api.telephony.TranUsimGroup;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8631c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public je.a f8632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t8.a f8633b;

    public boolean a(int i10, int i11, int i12) throws ac.a {
        return d(fc.b.a.f6001u).n(i10, i11, i12);
    }

    public int b(int i10) throws ac.a {
        return d(fc.b.a.f6001u).q(i10);
    }

    public int c(int i10) throws ac.a {
        return d(fc.b.a.f6001u).k(i10);
    }

    public dh.a d(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f8631c, "TranThubMtkIccPhoneBookManager");
            je.a aVar = this.f8632a;
            if (aVar != null) {
                return aVar;
            }
            je.a aVar2 = new je.a();
            this.f8632a = aVar2;
            return aVar2;
        }
        dc.e.f(f8631c, "TranAospMtkIccPhoneBookManager");
        t8.a aVar3 = this.f8633b;
        if (aVar3 != null) {
            return aVar3;
        }
        t8.a aVar4 = new t8.a();
        this.f8633b = aVar4;
        return aVar4;
    }

    public int e(int i10) throws ac.a {
        return d(fc.b.a.f6001u).i(i10);
    }

    public String f(int i10, int i11) throws ac.a {
        return d(fc.b.a.f6001u).r(i10, i11);
    }

    public List<TranAlphaTag> g(int i10) throws ac.a {
        return d(fc.b.a.f6001u).g(i10);
    }

    public int h(int i10) throws ac.a {
        return d(fc.b.a.f6001u).o(i10);
    }

    public int i(int i10) throws ac.a {
        return d(fc.b.a.f6001u).t(i10);
    }

    public List<TranUsimGroup> j(int i10) throws ac.a {
        return d(fc.b.a.f6001u).s(i10);
    }

    public int k(int i10) throws ac.a {
        return d(fc.b.a.f6001u).d(i10);
    }

    public int l(int i10) throws ac.a {
        return d(fc.b.a.f6001u).l(i10);
    }

    public boolean m(int i10) throws ac.a {
        return d(fc.b.a.f6001u).a(i10);
    }

    public int n(int i10, String str) throws ac.a {
        if (str != null) {
            return d(fc.b.a.f6001u).m(i10, str);
        }
        throw new IllegalArgumentException("aasName is null");
    }

    public int o(int i10, String str) throws ac.a {
        if (str != null) {
            return d(fc.b.a.f6001u).b(i10, str);
        }
        throw new IllegalArgumentException("grpName is null");
    }

    public boolean p(int i10) throws ac.a {
        return d(fc.b.a.f6001u).h(i10);
    }

    public boolean q(int i10, int i11, int[] iArr, int[] iArr2) throws ac.a {
        if (iArr == null || iArr2 == null) {
            throw new IllegalArgumentException("fromGrpIdList or toGrpIdList is null");
        }
        return d(fc.b.a.f6001u).f(i10, i11, iArr, iArr2);
    }

    public boolean r(int i10, int i11, int i12) throws ac.a {
        return d(fc.b.a.f6001u).p(i10, i11, i12);
    }

    public boolean s(int i10, int i11, int i12) throws ac.a {
        return d(fc.b.a.f6001u).j(i10, i11, i12);
    }

    public boolean t(int i10, int i11) throws ac.a {
        return d(fc.b.a.f6001u).c(i10, i11);
    }

    public boolean u(int i10, int i11, int i12, String str) throws ac.a {
        if (str != null) {
            return d(fc.b.a.f6001u).u(i10, i11, i12, str);
        }
        throw new IllegalArgumentException("aasName is null");
    }

    public int v(int i10, int i11, String str) throws ac.a {
        if (str != null) {
            return d(fc.b.a.f6001u).e(i10, i11, str);
        }
        throw new IllegalArgumentException("grpName is null");
    }
}
