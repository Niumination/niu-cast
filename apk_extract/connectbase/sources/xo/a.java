package xo;

import cp.e;
import in.n;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kn.l0;
import kn.w;
import nm.c1;
import nm.k0;
import nm.p;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final EnumC0527a f20438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final e f20439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public final String[] f20440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public final String[] f20441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m
    public final String[] f20442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @m
    public final String f20443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f20444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @m
    public final String f20445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @m
    public final byte[] f20446i;

    /* JADX INFO: renamed from: xo.a$a, reason: collision with other inner class name */
    public enum EnumC0527a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);


        @l
        public static final C0528a Companion = new C0528a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public static final Map<Integer, EnumC0527a> f20447a;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f20449id;

        /* JADX INFO: renamed from: xo.a$a$a, reason: collision with other inner class name */
        public static final class C0528a {
            public C0528a() {
            }

            @n
            @l
            public final EnumC0527a a(int i10) {
                EnumC0527a enumC0527a = (EnumC0527a) EnumC0527a.f20447a.get(Integer.valueOf(i10));
                return enumC0527a == null ? EnumC0527a.UNKNOWN : enumC0527a;
            }

            public C0528a(w wVar) {
            }
        }

        static {
            int i10 = 0;
            EnumC0527a[] enumC0527aArrValues = values();
            int iJ = c1.j(enumC0527aArrValues.length);
            LinkedHashMap linkedHashMap = new LinkedHashMap(iJ < 16 ? 16 : iJ);
            int length = enumC0527aArrValues.length;
            while (i10 < length) {
                EnumC0527a enumC0527a = enumC0527aArrValues[i10];
                i10++;
                linkedHashMap.put(Integer.valueOf(enumC0527a.getId()), enumC0527a);
            }
            f20447a = linkedHashMap;
        }

        EnumC0527a(int i10) {
            this.f20449id = i10;
        }

        @n
        @l
        public static final EnumC0527a getById(int i10) {
            return Companion.a(i10);
        }

        public final int getId() {
            return this.f20449id;
        }
    }

    public a(@l EnumC0527a enumC0527a, @l e eVar, @m String[] strArr, @m String[] strArr2, @m String[] strArr3, @m String str, int i10, @m String str2, @m byte[] bArr) {
        l0.p(enumC0527a, "kind");
        l0.p(eVar, "metadataVersion");
        this.f20438a = enumC0527a;
        this.f20439b = eVar;
        this.f20440c = strArr;
        this.f20441d = strArr2;
        this.f20442e = strArr3;
        this.f20443f = str;
        this.f20444g = i10;
        this.f20445h = str2;
        this.f20446i = bArr;
    }

    @m
    public final String[] a() {
        return this.f20440c;
    }

    @m
    public final String[] b() {
        return this.f20441d;
    }

    @l
    public final EnumC0527a c() {
        return this.f20438a;
    }

    @l
    public final e d() {
        return this.f20439b;
    }

    @m
    public final String e() {
        String str = this.f20443f;
        if (this.f20438a == EnumC0527a.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    @l
    public final List<String> f() {
        String[] strArr = this.f20440c;
        if (this.f20438a != EnumC0527a.MULTIFILE_CLASS) {
            strArr = null;
        }
        List<String> listT = strArr != null ? p.t(strArr) : null;
        return listT == null ? k0.INSTANCE : listT;
    }

    @m
    public final String[] g() {
        return this.f20442e;
    }

    public final boolean h(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public final boolean i() {
        return h(this.f20444g, 2);
    }

    public final boolean j() {
        return h(this.f20444g, 64) && !h(this.f20444g, 32);
    }

    public final boolean k() {
        return h(this.f20444g, 16) && !h(this.f20444g, 32);
    }

    @l
    public String toString() {
        return this.f20438a + " version=" + this.f20439b;
    }
}
