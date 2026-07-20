package bp;

import fp.g;
import fp.i;
import fp.j;
import fp.k;
import fp.q;
import fp.s;
import fp.w;
import fp.z;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i.g<yo.a.d, c> f1003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i.g<yo.a.i, c> f1004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i.g<yo.a.i, Integer> f1005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i.g<yo.a.n, d> f1006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i.g<yo.a.n, Integer> f1007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i.g<yo.a.q, List<yo.a.b>> f1008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i.g<yo.a.q, Boolean> f1009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i.g<yo.a.s, List<yo.a.b>> f1010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i.g<yo.a.c, Integer> f1011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i.g<yo.a.c, List<yo.a.n>> f1012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final i.g<yo.a.c, Integer> f1013k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final i.g<yo.a.c, Integer> f1014l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final i.g<yo.a.l, Integer> f1015m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final i.g<yo.a.l, List<yo.a.n>> f1016n;

    public static final class b extends i implements bp.b {
        public static s<b> PARSER = new C0037a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f1017a;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: bp.a$b$a, reason: collision with other inner class name */
        public static class C0037a extends fp.b<b> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, g gVar) throws k {
                return new b(eVar, gVar);
            }
        }

        /* JADX INFO: renamed from: bp.a$b$b, reason: collision with other inner class name */
        public static final class C0038b extends i.b<b, C0038b> implements bp.b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1018b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f1019c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f1020d;

            public static C0038b j() {
                return new C0038b();
            }

            public static C0038b n() {
                return new C0038b();
            }

            private void p() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public i getDefaultInstanceForType() {
                return b.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public q getDefaultInstanceForType() {
                return b.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public b build() {
                b bVarL = l();
                if (bVarL.isInitialized()) {
                    return bVarL;
                }
                throw new w(bVarL);
            }

            public b l() {
                b bVar = new b(this);
                int i10 = this.f1018b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                bVar.name_ = this.f1019c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                bVar.desc_ = this.f1020d;
                bVar.bitField0_ = i11;
                return bVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public C0038b l() {
                return new C0038b().h(l());
            }

            public b o() {
                return b.getDefaultInstance();
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public C0038b h(b bVar) {
                if (bVar == b.getDefaultInstance()) {
                    return this;
                }
                if (bVar.hasName()) {
                    t(bVar.getName());
                }
                if (bVar.hasDesc()) {
                    s(bVar.getDesc());
                }
                this.f6241a = this.f6241a.b(bVar.unknownFields);
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public C0038b c(fp.e eVar, g gVar) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b bVarC = b.PARSER.c(eVar, gVar);
                        if (bVarC != null) {
                            h(bVarC);
                        }
                        return this;
                    } catch (k e10) {
                        b bVar2 = (b) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            bVar = bVar2;
                            if (bVar != null) {
                                h(bVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bVar != null) {
                        h(bVar);
                    }
                    throw th;
                }
            }

            public C0038b s(int i10) {
                this.f1018b |= 2;
                this.f1020d = i10;
                return this;
            }

            public C0038b t(int i10) {
                this.f1018b |= 1;
                this.f1019c = i10;
                return this;
            }
        }

        static {
            b bVar = new b(true);
            f1017a = bVar;
            bVar.b();
        }

        private void b() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static b getDefaultInstance() {
            return f1017a;
        }

        public static C0038b newBuilder(b bVar) {
            return newBuilder().h(bVar);
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // fp.i, fp.q
        public s<b> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iO += fp.f.o(2, this.desc_);
            }
            int size = this.unknownFields.size() + iO;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // fp.r
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(2, this.desc_);
            }
            fVar.i0(this.unknownFields);
        }

        public static C0038b newBuilder() {
            return new C0038b();
        }

        @Override // fp.r
        public b getDefaultInstanceForType() {
            return f1017a;
        }

        @Override // fp.q
        public C0038b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public C0038b toBuilder() {
            return newBuilder(this);
        }

        public b(i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public b(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public b(fp.e eVar, g gVar) throws k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            b();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.A();
                            } else if (iK != 16) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = eVar.A();
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        try {
                            fVarJ.I();
                        } catch (IOException unused) {
                        } finally {
                            this.unknownFields = bVarQ.k();
                        }
                        makeExtensionsImmutable();
                        throw th2;
                    }
                } catch (k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            try {
                fVarJ.I();
            } catch (IOException unused2) {
            } finally {
                this.unknownFields = bVarQ.k();
            }
            makeExtensionsImmutable();
        }
    }

    public static final class c extends i implements bp.c {
        public static s<c> PARSER = new C0039a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f1021a;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: bp.a$c$a, reason: collision with other inner class name */
        public static class C0039a extends fp.b<c> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public c c(fp.e eVar, g gVar) throws k {
                return new c(eVar, gVar);
            }
        }

        public static final class b extends i.b<c, b> implements bp.c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1022b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f1023c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f1024d;

            public static b j() {
                return new b();
            }

            public static b n() {
                return new b();
            }

            private void p() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public i getDefaultInstanceForType() {
                return c.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public q getDefaultInstanceForType() {
                return c.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public c build() {
                c cVarL = l();
                if (cVarL.isInitialized()) {
                    return cVarL;
                }
                throw new w(cVarL);
            }

            public c l() {
                c cVar = new c(this);
                int i10 = this.f1022b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                cVar.name_ = this.f1023c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                cVar.desc_ = this.f1024d;
                cVar.bitField0_ = i11;
                return cVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(l());
            }

            public c o() {
                return c.getDefaultInstance();
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public b h(c cVar) {
                if (cVar == c.getDefaultInstance()) {
                    return this;
                }
                if (cVar.hasName()) {
                    t(cVar.getName());
                }
                if (cVar.hasDesc()) {
                    s(cVar.getDesc());
                }
                this.f6241a = this.f6241a.b(cVar.unknownFields);
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, g gVar) throws Throwable {
                c cVar = null;
                try {
                    try {
                        c cVarC = c.PARSER.c(eVar, gVar);
                        if (cVarC != null) {
                            h(cVarC);
                        }
                        return this;
                    } catch (k e10) {
                        c cVar2 = (c) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            cVar = cVar2;
                            if (cVar != null) {
                                h(cVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (cVar != null) {
                        h(cVar);
                    }
                    throw th;
                }
            }

            public b s(int i10) {
                this.f1022b |= 2;
                this.f1024d = i10;
                return this;
            }

            public b t(int i10) {
                this.f1022b |= 1;
                this.f1023c = i10;
                return this;
            }
        }

        static {
            c cVar = new c(true);
            f1021a = cVar;
            cVar.b();
        }

        private void b() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static c getDefaultInstance() {
            return f1021a;
        }

        public static b newBuilder(c cVar) {
            return newBuilder().h(cVar);
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // fp.i, fp.q
        public s<c> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iO += fp.f.o(2, this.desc_);
            }
            int size = this.unknownFields.size() + iO;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // fp.r
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(2, this.desc_);
            }
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public c getDefaultInstanceForType() {
            return f1021a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public c(i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public c(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public c(fp.e eVar, g gVar) throws k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            b();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.A();
                            } else if (iK != 16) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = eVar.A();
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        try {
                            fVarJ.I();
                        } catch (IOException unused) {
                        } finally {
                            this.unknownFields = bVarQ.k();
                        }
                        makeExtensionsImmutable();
                        throw th2;
                    }
                } catch (k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            try {
                fVarJ.I();
            } catch (IOException unused2) {
            } finally {
                this.unknownFields = bVarQ.k();
            }
            makeExtensionsImmutable();
        }
    }

    public static final class d extends i implements bp.d {
        public static s<d> PARSER = new C0040a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f1025a;
        private int bitField0_;
        private c delegateMethod_;
        private b field_;
        private c getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private c setter_;
        private c syntheticMethod_;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: bp.a$d$a, reason: collision with other inner class name */
        public static class C0040a extends fp.b<d> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public d c(fp.e eVar, g gVar) throws k {
                return new d(eVar, gVar);
            }
        }

        public static final class b extends i.b<d, b> implements bp.d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1026b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public b f1027c = b.getDefaultInstance();

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public c f1028d = c.getDefaultInstance();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public c f1029e = c.getDefaultInstance();

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public c f1030f = c.getDefaultInstance();

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public c f1031g = c.getDefaultInstance();

            public static b j() {
                return new b();
            }

            public static b n() {
                return new b();
            }

            private void p() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public i getDefaultInstanceForType() {
                return d.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public q getDefaultInstanceForType() {
                return d.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public d build() {
                d dVarL = l();
                if (dVarL.isInitialized()) {
                    return dVarL;
                }
                throw new w(dVarL);
            }

            public d l() {
                d dVar = new d(this);
                int i10 = this.f1026b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                dVar.field_ = this.f1027c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                dVar.syntheticMethod_ = this.f1028d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                dVar.getter_ = this.f1029e;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                dVar.setter_ = this.f1030f;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                dVar.delegateMethod_ = this.f1031g;
                dVar.bitField0_ = i11;
                return dVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(l());
            }

            public d o() {
                return d.getDefaultInstance();
            }

            public b q(c cVar) {
                if ((this.f1026b & 16) != 16 || this.f1031g == c.getDefaultInstance()) {
                    this.f1031g = cVar;
                } else {
                    this.f1031g = c.newBuilder(this.f1031g).h(cVar).l();
                }
                this.f1026b |= 16;
                return this;
            }

            public b r(b bVar) {
                if ((this.f1026b & 1) != 1 || this.f1027c == b.getDefaultInstance()) {
                    this.f1027c = bVar;
                } else {
                    this.f1027c = b.newBuilder(this.f1027c).h(bVar).l();
                }
                this.f1026b |= 1;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b h(d dVar) {
                if (dVar == d.getDefaultInstance()) {
                    return this;
                }
                if (dVar.hasField()) {
                    r(dVar.getField());
                }
                if (dVar.hasSyntheticMethod()) {
                    w(dVar.getSyntheticMethod());
                }
                if (dVar.hasGetter()) {
                    u(dVar.getGetter());
                }
                if (dVar.hasSetter()) {
                    v(dVar.getSetter());
                }
                if (dVar.hasDelegateMethod()) {
                    q(dVar.getDelegateMethod());
                }
                this.f6241a = this.f6241a.b(dVar.unknownFields);
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, g gVar) throws Throwable {
                d dVar = null;
                try {
                    try {
                        d dVarC = d.PARSER.c(eVar, gVar);
                        if (dVarC != null) {
                            h(dVarC);
                        }
                        return this;
                    } catch (k e10) {
                        d dVar2 = (d) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            dVar = dVar2;
                            if (dVar != null) {
                                h(dVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (dVar != null) {
                        h(dVar);
                    }
                    throw th;
                }
            }

            public b u(c cVar) {
                if ((this.f1026b & 4) != 4 || this.f1029e == c.getDefaultInstance()) {
                    this.f1029e = cVar;
                } else {
                    this.f1029e = c.newBuilder(this.f1029e).h(cVar).l();
                }
                this.f1026b |= 4;
                return this;
            }

            public b v(c cVar) {
                if ((this.f1026b & 8) != 8 || this.f1030f == c.getDefaultInstance()) {
                    this.f1030f = cVar;
                } else {
                    this.f1030f = c.newBuilder(this.f1030f).h(cVar).l();
                }
                this.f1026b |= 8;
                return this;
            }

            public b w(c cVar) {
                if ((this.f1026b & 2) != 2 || this.f1028d == c.getDefaultInstance()) {
                    this.f1028d = cVar;
                } else {
                    this.f1028d = c.newBuilder(this.f1028d).h(cVar).l();
                }
                this.f1026b |= 2;
                return this;
            }
        }

        static {
            d dVar = new d(true);
            f1025a = dVar;
            dVar.b();
        }

        private void b() {
            this.field_ = b.getDefaultInstance();
            this.syntheticMethod_ = c.getDefaultInstance();
            this.getter_ = c.getDefaultInstance();
            this.setter_ = c.getDefaultInstance();
            this.delegateMethod_ = c.getDefaultInstance();
        }

        public static d getDefaultInstance() {
            return f1025a;
        }

        public static b newBuilder(d dVar) {
            return newBuilder().h(dVar);
        }

        public c getDelegateMethod() {
            return this.delegateMethod_;
        }

        public b getField() {
            return this.field_;
        }

        public c getGetter() {
            return this.getter_;
        }

        @Override // fp.i, fp.q
        public s<d> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iS = (this.bitField0_ & 1) == 1 ? fp.f.s(1, this.field_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iS += fp.f.s(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iS += fp.f.s(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iS += fp.f.s(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iS += fp.f.s(5, this.delegateMethod_);
            }
            int size = this.unknownFields.size() + iS;
            this.memoizedSerializedSize = size;
            return size;
        }

        public c getSetter() {
            return this.setter_;
        }

        public c getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        public boolean hasDelegateMethod() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasField() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetter() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasSetter() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasSyntheticMethod() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // fp.r
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                fVar.d0(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.d0(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.d0(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                fVar.d0(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                fVar.d0(5, this.delegateMethod_);
            }
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public d getDefaultInstanceForType() {
            return f1025a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public d(i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public d(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public d(fp.e eVar, g gVar) throws k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            b();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 10) {
                                b.C0038b builder = (this.bitField0_ & 1) == 1 ? this.field_.toBuilder() : null;
                                b bVar = (b) eVar.u(b.PARSER, gVar);
                                this.field_ = bVar;
                                if (builder != null) {
                                    builder.h(bVar);
                                    this.field_ = builder.l();
                                }
                                this.bitField0_ |= 1;
                            } else if (iK == 18) {
                                c.b builder2 = (this.bitField0_ & 2) == 2 ? this.syntheticMethod_.toBuilder() : null;
                                c cVar = (c) eVar.u(c.PARSER, gVar);
                                this.syntheticMethod_ = cVar;
                                if (builder2 != null) {
                                    builder2.h(cVar);
                                    this.syntheticMethod_ = builder2.l();
                                }
                                this.bitField0_ |= 2;
                            } else if (iK == 26) {
                                c.b builder3 = (this.bitField0_ & 4) == 4 ? this.getter_.toBuilder() : null;
                                c cVar2 = (c) eVar.u(c.PARSER, gVar);
                                this.getter_ = cVar2;
                                if (builder3 != null) {
                                    builder3.h(cVar2);
                                    this.getter_ = builder3.l();
                                }
                                this.bitField0_ |= 4;
                            } else if (iK == 34) {
                                c.b builder4 = (this.bitField0_ & 8) == 8 ? this.setter_.toBuilder() : null;
                                c cVar3 = (c) eVar.u(c.PARSER, gVar);
                                this.setter_ = cVar3;
                                if (builder4 != null) {
                                    builder4.h(cVar3);
                                    this.setter_ = builder4.l();
                                }
                                this.bitField0_ |= 8;
                            } else if (iK != 42) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                c.b builder5 = (this.bitField0_ & 16) == 16 ? this.delegateMethod_.toBuilder() : null;
                                c cVar4 = (c) eVar.u(c.PARSER, gVar);
                                this.delegateMethod_ = cVar4;
                                if (builder5 != null) {
                                    builder5.h(cVar4);
                                    this.delegateMethod_ = builder5.l();
                                }
                                this.bitField0_ |= 16;
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        try {
                            fVarJ.I();
                        } catch (IOException unused) {
                        } finally {
                            this.unknownFields = bVarQ.k();
                        }
                        makeExtensionsImmutable();
                        throw th2;
                    }
                } catch (k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            try {
                fVarJ.I();
            } catch (IOException unused2) {
            } finally {
                this.unknownFields = bVarQ.k();
            }
            makeExtensionsImmutable();
        }
    }

    public static final class e extends i implements f {
        public static s<e> PARSER = new C0041a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f1032a;
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<c> record_;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: bp.a$e$a, reason: collision with other inner class name */
        public static class C0041a extends fp.b<e> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public e c(fp.e eVar, g gVar) throws k {
                return new e(eVar, gVar);
            }
        }

        public static final class b extends i.b<e, b> implements f {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1033b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public List<c> f1034c = Collections.emptyList();

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public List<Integer> f1035d = Collections.emptyList();

            public static b j() {
                return new b();
            }

            public static b n() {
                return new b();
            }

            private void r() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public i getDefaultInstanceForType() {
                return e.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public q getDefaultInstanceForType() {
                return e.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public e build() {
                e eVarL = l();
                if (eVarL.isInitialized()) {
                    return eVarL;
                }
                throw new w(eVarL);
            }

            public e l() {
                e eVar = new e(this);
                if ((this.f1033b & 1) == 1) {
                    this.f1034c = Collections.unmodifiableList(this.f1034c);
                    this.f1033b &= -2;
                }
                eVar.record_ = this.f1034c;
                if ((this.f1033b & 2) == 2) {
                    this.f1035d = Collections.unmodifiableList(this.f1035d);
                    this.f1033b &= -3;
                }
                eVar.localName_ = this.f1035d;
                return eVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(l());
            }

            public final void o() {
                if ((this.f1033b & 2) != 2) {
                    this.f1035d = new ArrayList(this.f1035d);
                    this.f1033b |= 2;
                }
            }

            public final void p() {
                if ((this.f1033b & 1) != 1) {
                    this.f1034c = new ArrayList(this.f1034c);
                    this.f1033b |= 1;
                }
            }

            public e q() {
                return e.getDefaultInstance();
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b h(e eVar) {
                if (eVar == e.getDefaultInstance()) {
                    return this;
                }
                if (!eVar.record_.isEmpty()) {
                    if (this.f1034c.isEmpty()) {
                        this.f1034c = eVar.record_;
                        this.f1033b &= -2;
                    } else {
                        p();
                        this.f1034c.addAll(eVar.record_);
                    }
                }
                if (!eVar.localName_.isEmpty()) {
                    if (this.f1035d.isEmpty()) {
                        this.f1035d = eVar.localName_;
                        this.f1033b &= -3;
                    } else {
                        o();
                        this.f1035d.addAll(eVar.localName_);
                    }
                }
                this.f6241a = this.f6241a.b(eVar.unknownFields);
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, g gVar) throws Throwable {
                e eVar2 = null;
                try {
                    try {
                        e eVarC = e.PARSER.c(eVar, gVar);
                        if (eVarC != null) {
                            h(eVarC);
                        }
                        return this;
                    } catch (k e10) {
                        e eVar3 = (e) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            eVar2 = eVar3;
                            if (eVar2 != null) {
                                h(eVar2);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (eVar2 != null) {
                        h(eVar2);
                    }
                    throw th;
                }
            }
        }

        public static final class c extends i implements bp.e {
            public static s<c> PARSER = new C0042a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f1036a;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private EnumC0043c operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final fp.d unknownFields;

            /* JADX INFO: renamed from: bp.a$e$c$a, reason: collision with other inner class name */
            public static class C0042a extends fp.b<c> {
                @Override // fp.s
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public c c(fp.e eVar, g gVar) throws k {
                    return new c(eVar, gVar);
                }
            }

            public static final class b extends i.b<c, b> implements bp.e {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public int f1037b;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public int f1039d;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public int f1038c = 1;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public Object f1040e = "";

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public EnumC0043c f1041f = EnumC0043c.NONE;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public List<Integer> f1042g = Collections.emptyList();

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public List<Integer> f1043i = Collections.emptyList();

                public static b j() {
                    return new b();
                }

                public static b n() {
                    return new b();
                }

                private void r() {
                }

                @Override // fp.i.b
                /* JADX INFO: renamed from: f */
                public i getDefaultInstanceForType() {
                    return c.getDefaultInstance();
                }

                @Override // fp.i.b, fp.r
                public q getDefaultInstanceForType() {
                    return c.getDefaultInstance();
                }

                @Override // fp.r
                public final boolean isInitialized() {
                    return true;
                }

                @Override // fp.q.a
                /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
                public c build() {
                    c cVarL = l();
                    if (cVarL.isInitialized()) {
                        return cVarL;
                    }
                    throw new w(cVarL);
                }

                public c l() {
                    c cVar = new c(this);
                    int i10 = this.f1037b;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    cVar.range_ = this.f1038c;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    cVar.predefinedIndex_ = this.f1039d;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    cVar.string_ = this.f1040e;
                    if ((i10 & 8) == 8) {
                        i11 |= 8;
                    }
                    cVar.operation_ = this.f1041f;
                    if ((this.f1037b & 16) == 16) {
                        this.f1042g = Collections.unmodifiableList(this.f1042g);
                        this.f1037b &= -17;
                    }
                    cVar.substringIndex_ = this.f1042g;
                    if ((this.f1037b & 32) == 32) {
                        this.f1043i = Collections.unmodifiableList(this.f1043i);
                        this.f1037b &= -33;
                    }
                    cVar.replaceChar_ = this.f1043i;
                    cVar.bitField0_ = i11;
                    return cVar;
                }

                @Override // fp.i.b
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public b l() {
                    return new b().h(l());
                }

                public final void o() {
                    if ((this.f1037b & 32) != 32) {
                        this.f1043i = new ArrayList(this.f1043i);
                        this.f1037b |= 32;
                    }
                }

                public final void p() {
                    if ((this.f1037b & 16) != 16) {
                        this.f1042g = new ArrayList(this.f1042g);
                        this.f1037b |= 16;
                    }
                }

                public c q() {
                    return c.getDefaultInstance();
                }

                @Override // fp.i.b
                /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
                public b h(c cVar) {
                    if (cVar == c.getDefaultInstance()) {
                        return this;
                    }
                    if (cVar.hasRange()) {
                        w(cVar.getRange());
                    }
                    if (cVar.hasPredefinedIndex()) {
                        v(cVar.getPredefinedIndex());
                    }
                    if (cVar.hasString()) {
                        this.f1037b |= 4;
                        this.f1040e = cVar.string_;
                    }
                    if (cVar.hasOperation()) {
                        u(cVar.getOperation());
                    }
                    if (!cVar.substringIndex_.isEmpty()) {
                        if (this.f1042g.isEmpty()) {
                            this.f1042g = cVar.substringIndex_;
                            this.f1037b &= -17;
                        } else {
                            p();
                            this.f1042g.addAll(cVar.substringIndex_);
                        }
                    }
                    if (!cVar.replaceChar_.isEmpty()) {
                        if (this.f1043i.isEmpty()) {
                            this.f1043i = cVar.replaceChar_;
                            this.f1037b &= -33;
                        } else {
                            o();
                            this.f1043i.addAll(cVar.replaceChar_);
                        }
                    }
                    this.f6241a = this.f6241a.b(cVar.unknownFields);
                    return this;
                }

                /* JADX WARN: Code duplicated, block: B:15:0x001d  */
                @Override // fp.a.AbstractC0147a, fp.q.a
                /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
                public b c(fp.e eVar, g gVar) throws Throwable {
                    c cVar = null;
                    try {
                        try {
                            c cVarC = c.PARSER.c(eVar, gVar);
                            if (cVarC != null) {
                                h(cVarC);
                            }
                            return this;
                        } catch (k e10) {
                            c cVar2 = (c) e10.getUnfinishedMessage();
                            try {
                                throw e10;
                            } catch (Throwable th2) {
                                th = th2;
                                cVar = cVar2;
                                if (cVar != null) {
                                    h(cVar);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (cVar != null) {
                            h(cVar);
                        }
                        throw th;
                    }
                }

                public b u(EnumC0043c enumC0043c) {
                    enumC0043c.getClass();
                    this.f1037b |= 8;
                    this.f1041f = enumC0043c;
                    return this;
                }

                public b v(int i10) {
                    this.f1037b |= 2;
                    this.f1039d = i10;
                    return this;
                }

                public b w(int i10) {
                    this.f1037b |= 1;
                    this.f1038c = i10;
                    return this;
                }
            }

            /* JADX INFO: renamed from: bp.a$e$c$c, reason: collision with other inner class name */
            public enum EnumC0043c implements j.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);


                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static j.b<EnumC0043c> f1044a = new C0044a();
                private final int value;

                /* JADX INFO: renamed from: bp.a$e$c$c$a, reason: collision with other inner class name */
                public static class C0044a implements j.b<EnumC0043c> {
                    public EnumC0043c a(int i10) {
                        return EnumC0043c.valueOf(i10);
                    }

                    @Override // fp.j.b
                    public j.a findValueByNumber(int i10) {
                        return EnumC0043c.valueOf(i10);
                    }
                }

                EnumC0043c(int i10, int i11) {
                    this.value = i11;
                }

                @Override // fp.j.a
                public final int getNumber() {
                    return this.value;
                }

                public static EnumC0043c valueOf(int i10) {
                    if (i10 == 0) {
                        return NONE;
                    }
                    if (i10 == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i10 != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }
            }

            static {
                c cVar = new c(true);
                f1036a = cVar;
                cVar.b();
            }

            private void b() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = EnumC0043c.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
            }

            public static c getDefaultInstance() {
                return f1036a;
            }

            public static b newBuilder(c cVar) {
                return newBuilder().h(cVar);
            }

            public EnumC0043c getOperation() {
                return this.operation_;
            }

            @Override // fp.i, fp.q
            public s<c> getParserForType() {
                return PARSER;
            }

            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            public int getRange() {
                return this.range_;
            }

            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            @Override // fp.q
            public int getSerializedSize() {
                int i10 = this.memoizedSerializedSize;
                if (i10 != -1) {
                    return i10;
                }
                int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.range_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iO += fp.f.o(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    iO += fp.f.h(3, this.operation_.getNumber());
                }
                int iP = 0;
                for (int i11 = 0; i11 < this.substringIndex_.size(); i11++) {
                    iP += fp.f.p(this.substringIndex_.get(i11).intValue());
                }
                int iP2 = iO + iP;
                if (!getSubstringIndexList().isEmpty()) {
                    iP2 = iP2 + 1 + fp.f.p(iP);
                }
                this.substringIndexMemoizedSerializedSize = iP;
                int iP3 = 0;
                for (int i12 = 0; i12 < this.replaceChar_.size(); i12++) {
                    iP3 += fp.f.p(this.replaceChar_.get(i12).intValue());
                }
                int iD = iP2 + iP3;
                if (!getReplaceCharList().isEmpty()) {
                    iD = iD + 1 + fp.f.p(iP3);
                }
                this.replaceCharMemoizedSerializedSize = iP3;
                if ((this.bitField0_ & 4) == 4) {
                    iD += fp.f.d(6, getStringBytes());
                }
                int size = this.unknownFields.size() + iD;
                this.memoizedSerializedSize = size;
                return size;
            }

            public String getString() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                fp.d dVar = (fp.d) obj;
                String strW = dVar.w();
                if (dVar.m()) {
                    this.string_ = strW;
                }
                return strW;
            }

            public fp.d getStringBytes() {
                Object obj = this.string_;
                if (!(obj instanceof String)) {
                    return (fp.d) obj;
                }
                fp.d dVarG = fp.d.g((String) obj);
                this.string_ = dVarG;
                return dVarG;
            }

            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            public boolean hasOperation() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasPredefinedIndex() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasRange() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasString() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // fp.r
            public final boolean isInitialized() {
                byte b10 = this.memoizedIsInitialized;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // fp.q
            public void writeTo(fp.f fVar) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    fVar.a0(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    fVar.a0(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    fVar.S(3, this.operation_.getNumber());
                }
                if (getSubstringIndexList().size() > 0) {
                    fVar.o0(34);
                    fVar.o0(this.substringIndexMemoizedSerializedSize);
                }
                for (int i10 = 0; i10 < this.substringIndex_.size(); i10++) {
                    fVar.b0(this.substringIndex_.get(i10).intValue());
                }
                if (getReplaceCharList().size() > 0) {
                    fVar.o0(42);
                    fVar.o0(this.replaceCharMemoizedSerializedSize);
                }
                for (int i11 = 0; i11 < this.replaceChar_.size(); i11++) {
                    fVar.b0(this.replaceChar_.get(i11).intValue());
                }
                if ((this.bitField0_ & 4) == 4) {
                    fVar.O(6, getStringBytes());
                }
                fVar.i0(this.unknownFields);
            }

            public static b newBuilder() {
                return new b();
            }

            @Override // fp.r
            public c getDefaultInstanceForType() {
                return f1036a;
            }

            @Override // fp.q
            public b newBuilderForType() {
                return newBuilder();
            }

            @Override // fp.q
            public b toBuilder() {
                return newBuilder(this);
            }

            public c(i.b bVar) {
                super(bVar);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.f6241a;
            }

            public c(boolean z10) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = fp.d.f6202a;
            }

            public c(fp.e eVar, g gVar) throws k {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                b();
                fp.d.b bVarQ = fp.d.q();
                fp.f fVarJ = fp.f.J(bVarQ, 1);
                boolean z10 = false;
                int i10 = 0;
                while (!z10) {
                    try {
                        try {
                            int iK = eVar.K();
                            if (iK != 0) {
                                if (iK == 8) {
                                    this.bitField0_ |= 1;
                                    this.range_ = eVar.A();
                                } else if (iK == 16) {
                                    this.bitField0_ |= 2;
                                    this.predefinedIndex_ = eVar.A();
                                } else if (iK == 24) {
                                    int iA = eVar.A();
                                    EnumC0043c enumC0043cValueOf = EnumC0043c.valueOf(iA);
                                    if (enumC0043cValueOf == null) {
                                        fVarJ.o0(iK);
                                        fVarJ.o0(iA);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.operation_ = enumC0043cValueOf;
                                    }
                                } else if (iK == 32) {
                                    if ((i10 & 16) != 16) {
                                        this.substringIndex_ = new ArrayList();
                                        i10 |= 16;
                                    }
                                    this.substringIndex_.add(Integer.valueOf(eVar.A()));
                                } else if (iK == 34) {
                                    int iJ = eVar.j(eVar.A());
                                    if ((i10 & 16) != 16 && eVar.e() > 0) {
                                        this.substringIndex_ = new ArrayList();
                                        i10 |= 16;
                                    }
                                    while (eVar.e() > 0) {
                                        this.substringIndex_.add(Integer.valueOf(eVar.A()));
                                    }
                                    eVar.i(iJ);
                                } else if (iK == 40) {
                                    if ((i10 & 32) != 32) {
                                        this.replaceChar_ = new ArrayList();
                                        i10 |= 32;
                                    }
                                    this.replaceChar_.add(Integer.valueOf(eVar.A()));
                                } else if (iK == 42) {
                                    int iJ2 = eVar.j(eVar.A());
                                    if ((i10 & 32) != 32 && eVar.e() > 0) {
                                        this.replaceChar_ = new ArrayList();
                                        i10 |= 32;
                                    }
                                    while (eVar.e() > 0) {
                                        this.replaceChar_.add(Integer.valueOf(eVar.A()));
                                    }
                                    eVar.i(iJ2);
                                } else if (iK != 50) {
                                    if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    }
                                } else {
                                    fp.d dVarL = eVar.l();
                                    this.bitField0_ |= 4;
                                    this.string_ = dVarL;
                                }
                            }
                            z10 = true;
                        } catch (Throwable th2) {
                            if ((i10 & 16) == 16) {
                                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                            }
                            if ((i10 & 32) == 32) {
                                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                            }
                            try {
                                fVarJ.I();
                            } catch (IOException unused) {
                            } finally {
                                this.unknownFields = bVarQ.k();
                            }
                            makeExtensionsImmutable();
                            throw th2;
                        }
                    } catch (k e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new k(e11.getMessage()).setUnfinishedMessage(this);
                    }
                }
                if ((i10 & 16) == 16) {
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                }
                if ((i10 & 32) == 32) {
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                }
                try {
                    fVarJ.I();
                } catch (IOException unused2) {
                } finally {
                    this.unknownFields = bVarQ.k();
                }
                makeExtensionsImmutable();
            }
        }

        static {
            e eVar = new e(true);
            f1032a = eVar;
            eVar.b();
        }

        private void b() {
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
        }

        public static e getDefaultInstance() {
            return f1032a;
        }

        public static b newBuilder(e eVar) {
            return newBuilder().h(eVar);
        }

        public static e parseDelimitedFrom(InputStream inputStream, g gVar) throws IOException {
            return PARSER.d(inputStream, gVar);
        }

        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        @Override // fp.i, fp.q
        public s<e> getParserForType() {
            return PARSER;
        }

        public List<c> getRecordList() {
            return this.record_;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iS = 0;
            for (int i11 = 0; i11 < this.record_.size(); i11++) {
                iS += fp.f.s(1, this.record_.get(i11));
            }
            int iP = 0;
            for (int i12 = 0; i12 < this.localName_.size(); i12++) {
                iP += fp.f.p(this.localName_.get(i12).intValue());
            }
            int iP2 = iS + iP;
            if (!getLocalNameList().isEmpty()) {
                iP2 = iP2 + 1 + fp.f.p(iP);
            }
            this.localNameMemoizedSerializedSize = iP;
            int size = this.unknownFields.size() + iP2;
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // fp.r
        public final boolean isInitialized() {
            byte b10 = this.memoizedIsInitialized;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            for (int i10 = 0; i10 < this.record_.size(); i10++) {
                fVar.d0(1, this.record_.get(i10));
            }
            if (getLocalNameList().size() > 0) {
                fVar.o0(42);
                fVar.o0(this.localNameMemoizedSerializedSize);
            }
            for (int i11 = 0; i11 < this.localName_.size(); i11++) {
                fVar.b0(this.localName_.get(i11).intValue());
            }
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public e getDefaultInstanceForType() {
            return f1032a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public e(i.b bVar) {
            super(bVar);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public e(boolean z10) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public e(fp.e eVar, g gVar) throws k {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            b();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            int i10 = 0;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 10) {
                                if ((i10 & 1) != 1) {
                                    this.record_ = new ArrayList();
                                    i10 |= 1;
                                }
                                this.record_.add((c) eVar.u(c.PARSER, gVar));
                            } else if (iK == 40) {
                                if ((i10 & 2) != 2) {
                                    this.localName_ = new ArrayList();
                                    i10 |= 2;
                                }
                                this.localName_.add(Integer.valueOf(eVar.A()));
                            } else if (iK != 42) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                int iJ = eVar.j(eVar.A());
                                if ((i10 & 2) != 2 && eVar.e() > 0) {
                                    this.localName_ = new ArrayList();
                                    i10 |= 2;
                                }
                                while (eVar.e() > 0) {
                                    this.localName_.add(Integer.valueOf(eVar.A()));
                                }
                                eVar.i(iJ);
                            }
                        }
                        z10 = true;
                    } catch (k e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new k(e11.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th2) {
                    if ((i10 & 1) == 1) {
                        this.record_ = Collections.unmodifiableList(this.record_);
                    }
                    if ((i10 & 2) == 2) {
                        this.localName_ = Collections.unmodifiableList(this.localName_);
                    }
                    try {
                        fVarJ.I();
                    } catch (IOException unused) {
                    } finally {
                        this.unknownFields = bVarQ.k();
                    }
                    makeExtensionsImmutable();
                    throw th2;
                }
            }
            if ((i10 & 1) == 1) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if ((i10 & 2) == 2) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
            }
            try {
                fVarJ.I();
            } catch (IOException unused2) {
            } finally {
                this.unknownFields = bVarQ.k();
            }
            makeExtensionsImmutable();
        }
    }

    static {
        yo.a.d defaultInstance = yo.a.d.getDefaultInstance();
        c defaultInstance2 = c.getDefaultInstance();
        c defaultInstance3 = c.getDefaultInstance();
        z.b bVar = z.b.MESSAGE;
        f1003a = i.newSingularGeneratedExtension(defaultInstance, defaultInstance2, defaultInstance3, null, 100, bVar, c.class);
        f1004b = i.newSingularGeneratedExtension(yo.a.i.getDefaultInstance(), c.getDefaultInstance(), c.getDefaultInstance(), null, 100, bVar, c.class);
        yo.a.i defaultInstance4 = yo.a.i.getDefaultInstance();
        z.b bVar2 = z.b.INT32;
        f1005c = i.newSingularGeneratedExtension(defaultInstance4, 0, null, null, 101, bVar2, Integer.class);
        f1006d = i.newSingularGeneratedExtension(yo.a.n.getDefaultInstance(), d.getDefaultInstance(), d.getDefaultInstance(), null, 100, bVar, d.class);
        f1007e = i.newSingularGeneratedExtension(yo.a.n.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        f1008f = i.newRepeatedGeneratedExtension(yo.a.q.getDefaultInstance(), yo.a.b.getDefaultInstance(), null, 100, bVar, false, yo.a.b.class);
        f1009g = i.newSingularGeneratedExtension(yo.a.q.getDefaultInstance(), Boolean.FALSE, null, null, 101, z.b.BOOL, Boolean.class);
        f1010h = i.newRepeatedGeneratedExtension(yo.a.s.getDefaultInstance(), yo.a.b.getDefaultInstance(), null, 100, bVar, false, yo.a.b.class);
        f1011i = i.newSingularGeneratedExtension(yo.a.c.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        f1012j = i.newRepeatedGeneratedExtension(yo.a.c.getDefaultInstance(), yo.a.n.getDefaultInstance(), null, 102, bVar, false, yo.a.n.class);
        f1013k = i.newSingularGeneratedExtension(yo.a.c.getDefaultInstance(), 0, null, null, 103, bVar2, Integer.class);
        f1014l = i.newSingularGeneratedExtension(yo.a.c.getDefaultInstance(), 0, null, null, 104, bVar2, Integer.class);
        f1015m = i.newSingularGeneratedExtension(yo.a.l.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        f1016n = i.newRepeatedGeneratedExtension(yo.a.l.getDefaultInstance(), yo.a.n.getDefaultInstance(), null, 102, bVar, false, yo.a.n.class);
    }

    public static void a(g gVar) {
        gVar.a(f1003a);
        gVar.a(f1004b);
        gVar.a(f1005c);
        gVar.a(f1006d);
        gVar.a(f1007e);
        gVar.a(f1008f);
        gVar.a(f1009g);
        gVar.a(f1010h);
        gVar.a(f1011i);
        gVar.a(f1012j);
        gVar.a(f1013k);
        gVar.a(f1014l);
        gVar.a(f1015m);
        gVar.a(f1016n);
    }
}
