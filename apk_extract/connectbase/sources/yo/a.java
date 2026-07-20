package yo;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.transsion.widgetslib.widget.OSMaskImageView;
import com.transsion.widgetslib.widget.tablayout.TabLayout;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    public static final class b extends fp.i implements yo.d {
        public static fp.s<b> PARSER = new C0558a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f21502a;
        private List<C0559b> argument_;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: yo.a$b$a, reason: collision with other inner class name */
        public static class C0558a extends fp.b<b> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws fp.k {
                return new b(eVar, gVar);
            }
        }

        /* JADX INFO: renamed from: yo.a$b$b, reason: collision with other inner class name */
        public static final class C0559b extends fp.i implements yo.c {
            public static fp.s<C0559b> PARSER = new C0560a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0559b f21503a;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int nameId_;
            private final fp.d unknownFields;
            private c value_;

            /* JADX INFO: renamed from: yo.a$b$b$a, reason: collision with other inner class name */
            public static class C0560a extends fp.b<C0559b> {
                @Override // fp.s
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public C0559b c(fp.e eVar, fp.g gVar) throws fp.k {
                    return new C0559b(eVar, gVar);
                }
            }

            /* JADX INFO: renamed from: yo.a$b$b$b, reason: collision with other inner class name */
            public static final class C0561b extends fp.i.b<C0559b, C0561b> implements yo.c {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public int f21504b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public int f21505c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public c f21506d = c.getDefaultInstance();

                public static C0561b j() {
                    return new C0561b();
                }

                public static C0561b n() {
                    return new C0561b();
                }

                private void s() {
                }

                @Override // fp.i.b
                /* JADX INFO: renamed from: f */
                public fp.i getDefaultInstanceForType() {
                    return C0559b.getDefaultInstance();
                }

                @Override // fp.i.b, fp.r
                public fp.q getDefaultInstanceForType() {
                    return C0559b.getDefaultInstance();
                }

                @Override // fp.r
                public final boolean isInitialized() {
                    return q() && r() && this.f21506d.isInitialized();
                }

                @Override // fp.q.a
                /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
                public C0559b build() {
                    C0559b c0559bL = l();
                    if (c0559bL.isInitialized()) {
                        return c0559bL;
                    }
                    throw new fp.w(c0559bL);
                }

                public C0559b l() {
                    C0559b c0559b = new C0559b(this);
                    int i10 = this.f21504b;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    c0559b.nameId_ = this.f21505c;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    c0559b.value_ = this.f21506d;
                    c0559b.bitField0_ = i11;
                    return c0559b;
                }

                @Override // fp.i.b
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                public C0561b l() {
                    return new C0561b().h(l());
                }

                public C0559b o() {
                    return C0559b.getDefaultInstance();
                }

                public c p() {
                    return this.f21506d;
                }

                public boolean q() {
                    return (this.f21504b & 1) == 1;
                }

                public boolean r() {
                    return (this.f21504b & 2) == 2;
                }

                /* JADX WARN: Code duplicated, block: B:15:0x001d  */
                @Override // fp.a.AbstractC0147a, fp.q.a
                /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                public C0561b c(fp.e eVar, fp.g gVar) throws Throwable {
                    C0559b c0559b = null;
                    try {
                        try {
                            C0559b c0559bC = C0559b.PARSER.c(eVar, gVar);
                            if (c0559bC != null) {
                                h(c0559bC);
                            }
                            return this;
                        } catch (fp.k e10) {
                            C0559b c0559b2 = (C0559b) e10.getUnfinishedMessage();
                            try {
                                throw e10;
                            } catch (Throwable th2) {
                                th = th2;
                                c0559b = c0559b2;
                                if (c0559b != null) {
                                    h(c0559b);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (c0559b != null) {
                            h(c0559b);
                        }
                        throw th;
                    }
                }

                @Override // fp.i.b
                /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
                public C0561b h(C0559b c0559b) {
                    if (c0559b == C0559b.getDefaultInstance()) {
                        return this;
                    }
                    if (c0559b.hasNameId()) {
                        w(c0559b.getNameId());
                    }
                    if (c0559b.hasValue()) {
                        v(c0559b.getValue());
                    }
                    this.f6241a = this.f6241a.b(c0559b.unknownFields);
                    return this;
                }

                public C0561b v(c cVar) {
                    if ((this.f21504b & 2) != 2 || this.f21506d == c.getDefaultInstance()) {
                        this.f21506d = cVar;
                    } else {
                        this.f21506d = c.newBuilder(this.f21506d).h(cVar).l();
                    }
                    this.f21504b |= 2;
                    return this;
                }

                public C0561b w(int i10) {
                    this.f21504b |= 1;
                    this.f21505c = i10;
                    return this;
                }
            }

            /* JADX INFO: renamed from: yo.a$b$b$c */
            public static final class c extends fp.i implements yo.b {
                public static fp.s<c> PARSER = new C0562a();

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final c f21507a;
                private b annotation_;
                private int arrayDimensionCount_;
                private List<c> arrayElement_;
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                private int stringValue_;
                private EnumC0564c type_;
                private final fp.d unknownFields;

                /* JADX INFO: renamed from: yo.a$b$b$c$a, reason: collision with other inner class name */
                public static class C0562a extends fp.b<c> {
                    @Override // fp.s
                    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                    public c c(fp.e eVar, fp.g gVar) throws fp.k {
                        return new c(eVar, gVar);
                    }
                }

                /* JADX INFO: renamed from: yo.a$b$b$c$b, reason: collision with other inner class name */
                public static final class C0563b extends fp.i.b<c, C0563b> implements yo.b {

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public int f21508b;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    public long f21510d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    public float f21511e;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    public double f21512f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    public int f21513g;

                    /* JADX INFO: renamed from: i, reason: collision with root package name */
                    public int f21514i;

                    /* JADX INFO: renamed from: n, reason: collision with root package name */
                    public int f21515n;

                    /* JADX INFO: renamed from: w, reason: collision with root package name */
                    public int f21518w;

                    /* JADX INFO: renamed from: x, reason: collision with root package name */
                    public int f21519x;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    public EnumC0564c f21509c = EnumC0564c.BYTE;

                    /* JADX INFO: renamed from: p, reason: collision with root package name */
                    public b f21516p = b.getDefaultInstance();

                    /* JADX INFO: renamed from: v, reason: collision with root package name */
                    public List<c> f21517v = Collections.emptyList();

                    public static C0563b j() {
                        return new C0563b();
                    }

                    public static C0563b n() {
                        return new C0563b();
                    }

                    public C0563b A(double d10) {
                        this.f21508b |= 8;
                        this.f21512f = d10;
                        return this;
                    }

                    public C0563b B(int i10) {
                        this.f21508b |= 64;
                        this.f21515n = i10;
                        return this;
                    }

                    public C0563b C(int i10) {
                        this.f21508b |= 1024;
                        this.f21519x = i10;
                        return this;
                    }

                    public C0563b D(float f10) {
                        this.f21508b |= 4;
                        this.f21511e = f10;
                        return this;
                    }

                    public C0563b E(long j10) {
                        this.f21508b |= 2;
                        this.f21510d = j10;
                        return this;
                    }

                    public C0563b F(int i10) {
                        this.f21508b |= 16;
                        this.f21513g = i10;
                        return this;
                    }

                    public C0563b G(EnumC0564c enumC0564c) {
                        enumC0564c.getClass();
                        this.f21508b |= 1;
                        this.f21509c = enumC0564c;
                        return this;
                    }

                    @Override // fp.i.b
                    /* JADX INFO: renamed from: f */
                    public fp.i getDefaultInstanceForType() {
                        return c.getDefaultInstance();
                    }

                    @Override // fp.i.b, fp.r
                    public fp.q getDefaultInstanceForType() {
                        return c.getDefaultInstance();
                    }

                    @Override // fp.r
                    public final boolean isInitialized() {
                        if (t() && !this.f21516p.isInitialized()) {
                            return false;
                        }
                        for (int i10 = 0; i10 < this.f21517v.size(); i10++) {
                            if (!q(i10).isInitialized()) {
                                return false;
                            }
                        }
                        return true;
                    }

                    @Override // fp.q.a
                    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
                    public c build() {
                        c cVarL = l();
                        if (cVarL.isInitialized()) {
                            return cVarL;
                        }
                        throw new fp.w(cVarL);
                    }

                    public c l() {
                        c cVar = new c(this);
                        int i10 = this.f21508b;
                        int i11 = (i10 & 1) != 1 ? 0 : 1;
                        cVar.type_ = this.f21509c;
                        if ((i10 & 2) == 2) {
                            i11 |= 2;
                        }
                        cVar.intValue_ = this.f21510d;
                        if ((i10 & 4) == 4) {
                            i11 |= 4;
                        }
                        cVar.floatValue_ = this.f21511e;
                        if ((i10 & 8) == 8) {
                            i11 |= 8;
                        }
                        cVar.doubleValue_ = this.f21512f;
                        if ((i10 & 16) == 16) {
                            i11 |= 16;
                        }
                        cVar.stringValue_ = this.f21513g;
                        if ((i10 & 32) == 32) {
                            i11 |= 32;
                        }
                        cVar.classId_ = this.f21514i;
                        if ((i10 & 64) == 64) {
                            i11 |= 64;
                        }
                        cVar.enumValueId_ = this.f21515n;
                        if ((i10 & 128) == 128) {
                            i11 |= 128;
                        }
                        cVar.annotation_ = this.f21516p;
                        if ((this.f21508b & 256) == 256) {
                            this.f21517v = Collections.unmodifiableList(this.f21517v);
                            this.f21508b &= -257;
                        }
                        cVar.arrayElement_ = this.f21517v;
                        if ((i10 & 512) == 512) {
                            i11 |= 256;
                        }
                        cVar.arrayDimensionCount_ = this.f21518w;
                        if ((i10 & 1024) == 1024) {
                            i11 |= 512;
                        }
                        cVar.flags_ = this.f21519x;
                        cVar.bitField0_ = i11;
                        return cVar;
                    }

                    @Override // fp.i.b
                    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
                    public C0563b l() {
                        return new C0563b().h(l());
                    }

                    public final void o() {
                        if ((this.f21508b & 256) != 256) {
                            this.f21517v = new ArrayList(this.f21517v);
                            this.f21508b |= 256;
                        }
                    }

                    public b p() {
                        return this.f21516p;
                    }

                    public c q(int i10) {
                        return this.f21517v.get(i10);
                    }

                    public int r() {
                        return this.f21517v.size();
                    }

                    public c s() {
                        return c.getDefaultInstance();
                    }

                    public boolean t() {
                        return (this.f21508b & 128) == 128;
                    }

                    public final void u() {
                    }

                    public C0563b v(b bVar) {
                        if ((this.f21508b & 128) != 128 || this.f21516p == b.getDefaultInstance()) {
                            this.f21516p = bVar;
                        } else {
                            this.f21516p = b.newBuilder(this.f21516p).h(bVar).l();
                        }
                        this.f21508b |= 128;
                        return this;
                    }

                    /* JADX WARN: Code duplicated, block: B:15:0x001d  */
                    @Override // fp.a.AbstractC0147a, fp.q.a
                    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
                    public C0563b c(fp.e eVar, fp.g gVar) throws Throwable {
                        c cVar = null;
                        try {
                            try {
                                c cVarC = c.PARSER.c(eVar, gVar);
                                if (cVarC != null) {
                                    h(cVarC);
                                }
                                return this;
                            } catch (fp.k e10) {
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

                    @Override // fp.i.b
                    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
                    public C0563b h(c cVar) {
                        if (cVar == c.getDefaultInstance()) {
                            return this;
                        }
                        if (cVar.hasType()) {
                            G(cVar.getType());
                        }
                        if (cVar.hasIntValue()) {
                            E(cVar.getIntValue());
                        }
                        if (cVar.hasFloatValue()) {
                            D(cVar.getFloatValue());
                        }
                        if (cVar.hasDoubleValue()) {
                            A(cVar.getDoubleValue());
                        }
                        if (cVar.hasStringValue()) {
                            F(cVar.getStringValue());
                        }
                        if (cVar.hasClassId()) {
                            z(cVar.getClassId());
                        }
                        if (cVar.hasEnumValueId()) {
                            B(cVar.getEnumValueId());
                        }
                        if (cVar.hasAnnotation()) {
                            v(cVar.getAnnotation());
                        }
                        if (!cVar.arrayElement_.isEmpty()) {
                            if (this.f21517v.isEmpty()) {
                                this.f21517v = cVar.arrayElement_;
                                this.f21508b &= -257;
                            } else {
                                o();
                                this.f21517v.addAll(cVar.arrayElement_);
                            }
                        }
                        if (cVar.hasArrayDimensionCount()) {
                            y(cVar.getArrayDimensionCount());
                        }
                        if (cVar.hasFlags()) {
                            C(cVar.getFlags());
                        }
                        this.f6241a = this.f6241a.b(cVar.unknownFields);
                        return this;
                    }

                    public C0563b y(int i10) {
                        this.f21508b |= 512;
                        this.f21518w = i10;
                        return this;
                    }

                    public C0563b z(int i10) {
                        this.f21508b |= 32;
                        this.f21514i = i10;
                        return this;
                    }
                }

                /* JADX INFO: renamed from: yo.a$b$b$c$c, reason: collision with other inner class name */
                public enum EnumC0564c implements fp.j.a {
                    BYTE(0, 0),
                    CHAR(1, 1),
                    SHORT(2, 2),
                    INT(3, 3),
                    LONG(4, 4),
                    FLOAT(5, 5),
                    DOUBLE(6, 6),
                    BOOLEAN(7, 7),
                    STRING(8, 8),
                    CLASS(9, 9),
                    ENUM(10, 10),
                    ANNOTATION(11, 11),
                    ARRAY(12, 12);


                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static fp.j.b<EnumC0564c> f21520a = new C0565a();
                    private final int value;

                    /* JADX INFO: renamed from: yo.a$b$b$c$c$a, reason: collision with other inner class name */
                    public static class C0565a implements fp.j.b<EnumC0564c> {
                        public EnumC0564c a(int i10) {
                            return EnumC0564c.valueOf(i10);
                        }

                        @Override // fp.j.b
                        public fp.j.a findValueByNumber(int i10) {
                            return EnumC0564c.valueOf(i10);
                        }
                    }

                    EnumC0564c(int i10, int i11) {
                        this.value = i11;
                    }

                    @Override // fp.j.a
                    public final int getNumber() {
                        return this.value;
                    }

                    public static EnumC0564c valueOf(int i10) {
                        switch (i10) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }
                }

                static {
                    c cVar = new c(true);
                    f21507a = cVar;
                    cVar.b();
                }

                public static c getDefaultInstance() {
                    return f21507a;
                }

                public static C0563b newBuilder(c cVar) {
                    return newBuilder().h(cVar);
                }

                public final void b() {
                    this.type_ = EnumC0564c.BYTE;
                    this.intValue_ = 0L;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = 0.0d;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = b.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
                }

                public b getAnnotation() {
                    return this.annotation_;
                }

                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                public c getArrayElement(int i10) {
                    return this.arrayElement_.get(i10);
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                public List<c> getArrayElementList() {
                    return this.arrayElement_;
                }

                public int getClassId() {
                    return this.classId_;
                }

                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                public int getFlags() {
                    return this.flags_;
                }

                public float getFloatValue() {
                    return this.floatValue_;
                }

                public long getIntValue() {
                    return this.intValue_;
                }

                @Override // fp.i, fp.q
                public fp.s<c> getParserForType() {
                    return PARSER;
                }

                @Override // fp.q
                public int getSerializedSize() {
                    int i10 = this.memoizedSerializedSize;
                    if (i10 != -1) {
                        return i10;
                    }
                    int iH = (this.bitField0_ & 1) == 1 ? fp.f.h(1, this.type_.getNumber()) : 0;
                    if ((this.bitField0_ & 2) == 2) {
                        iH += fp.f.A(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        iH += fp.f.l(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        iH += fp.f.f(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        iH += fp.f.o(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        iH += fp.f.o(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        iH += fp.f.o(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        iH += fp.f.s(8, this.annotation_);
                    }
                    for (int i11 = 0; i11 < this.arrayElement_.size(); i11++) {
                        iH += fp.f.s(9, this.arrayElement_.get(i11));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        iH += fp.f.o(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        iH += fp.f.o(11, this.arrayDimensionCount_);
                    }
                    int size = this.unknownFields.size() + iH;
                    this.memoizedSerializedSize = size;
                    return size;
                }

                public int getStringValue() {
                    return this.stringValue_;
                }

                public EnumC0564c getType() {
                    return this.type_;
                }

                public boolean hasAnnotation() {
                    return (this.bitField0_ & 128) == 128;
                }

                public boolean hasArrayDimensionCount() {
                    return (this.bitField0_ & 256) == 256;
                }

                public boolean hasClassId() {
                    return (this.bitField0_ & 32) == 32;
                }

                public boolean hasDoubleValue() {
                    return (this.bitField0_ & 8) == 8;
                }

                public boolean hasEnumValueId() {
                    return (this.bitField0_ & 64) == 64;
                }

                public boolean hasFlags() {
                    return (this.bitField0_ & 512) == 512;
                }

                public boolean hasFloatValue() {
                    return (this.bitField0_ & 4) == 4;
                }

                public boolean hasIntValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                public boolean hasStringValue() {
                    return (this.bitField0_ & 16) == 16;
                }

                public boolean hasType() {
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
                    if (hasAnnotation() && !getAnnotation().isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                    for (int i10 = 0; i10 < getArrayElementCount(); i10++) {
                        if (!getArrayElement(i10).isInitialized()) {
                            this.memoizedIsInitialized = (byte) 0;
                            return false;
                        }
                    }
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }

                @Override // fp.q
                public void writeTo(fp.f fVar) throws IOException {
                    getSerializedSize();
                    if ((this.bitField0_ & 1) == 1) {
                        fVar.S(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        fVar.t0(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        fVar.W(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        fVar.Q(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        fVar.a0(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        fVar.a0(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        fVar.a0(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        fVar.d0(8, this.annotation_);
                    }
                    for (int i10 = 0; i10 < this.arrayElement_.size(); i10++) {
                        fVar.d0(9, this.arrayElement_.get(i10));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        fVar.a0(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        fVar.a0(11, this.arrayDimensionCount_);
                    }
                    fVar.i0(this.unknownFields);
                }

                public static C0563b newBuilder() {
                    return new C0563b();
                }

                @Override // fp.r
                public c getDefaultInstanceForType() {
                    return f21507a;
                }

                @Override // fp.q
                public C0563b newBuilderForType() {
                    return newBuilder();
                }

                @Override // fp.q
                public C0563b toBuilder() {
                    return newBuilder(this);
                }

                public c(fp.i.b bVar) {
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

                public c(fp.e eVar, fp.g gVar) throws fp.k {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    b();
                    fp.d.b bVarQ = fp.d.q();
                    fp.f fVarJ = fp.f.J(bVarQ, 1);
                    boolean z10 = false;
                    char c10 = 0;
                    while (!z10) {
                        try {
                            try {
                                try {
                                    int iK = eVar.K();
                                    switch (iK) {
                                        case 0:
                                            break;
                                        case 8:
                                            int iA = eVar.A();
                                            EnumC0564c enumC0564cValueOf = EnumC0564c.valueOf(iA);
                                            if (enumC0564cValueOf == null) {
                                                fVarJ.o0(iK);
                                                fVarJ.o0(iA);
                                            } else {
                                                this.bitField0_ |= 1;
                                                this.type_ = enumC0564cValueOf;
                                                continue;
                                            }
                                            break;
                                        case 16:
                                            this.bitField0_ |= 2;
                                            this.intValue_ = eVar.H();
                                            continue;
                                        case 29:
                                            this.bitField0_ |= 4;
                                            this.floatValue_ = eVar.q();
                                            continue;
                                        case 33:
                                            this.bitField0_ |= 8;
                                            this.doubleValue_ = eVar.m();
                                            continue;
                                        case 40:
                                            this.bitField0_ |= 16;
                                            this.stringValue_ = eVar.A();
                                            continue;
                                        case 48:
                                            this.bitField0_ |= 32;
                                            this.classId_ = eVar.A();
                                            continue;
                                        case 56:
                                            this.bitField0_ |= 64;
                                            this.enumValueId_ = eVar.A();
                                            continue;
                                        case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                            c builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                            b bVar = (b) eVar.u(b.PARSER, gVar);
                                            this.annotation_ = bVar;
                                            if (builder != null) {
                                                builder.h(bVar);
                                                this.annotation_ = builder.l();
                                            }
                                            this.bitField0_ |= 128;
                                            continue;
                                        case 74:
                                            if ((c10 & 256) != 256) {
                                                this.arrayElement_ = new ArrayList();
                                                c10 = 256;
                                            }
                                            this.arrayElement_.add((c) eVar.u(PARSER, gVar));
                                            continue;
                                        case 80:
                                            this.bitField0_ |= 512;
                                            this.flags_ = eVar.A();
                                            continue;
                                        case 88:
                                            this.bitField0_ |= 256;
                                            this.arrayDimensionCount_ = eVar.A();
                                            continue;
                                        default:
                                            if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                                break;
                                            }
                                            break;
                                    }
                                    z10 = true;
                                } catch (fp.k e10) {
                                    throw e10.setUnfinishedMessage(this);
                                }
                            } catch (IOException e11) {
                                throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                            }
                        } catch (Throwable th2) {
                            if ((c10 & 256) == 256) {
                                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                    if ((c10 & 256) == 256) {
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                C0559b c0559b = new C0559b(true);
                f21503a = c0559b;
                c0559b.b();
            }

            private void b() {
                this.nameId_ = 0;
                this.value_ = c.getDefaultInstance();
            }

            public static C0559b getDefaultInstance() {
                return f21503a;
            }

            public static C0561b newBuilder(C0559b c0559b) {
                return newBuilder().h(c0559b);
            }

            public int getNameId() {
                return this.nameId_;
            }

            @Override // fp.i, fp.q
            public fp.s<C0559b> getParserForType() {
                return PARSER;
            }

            @Override // fp.q
            public int getSerializedSize() {
                int i10 = this.memoizedSerializedSize;
                if (i10 != -1) {
                    return i10;
                }
                int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.nameId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iO += fp.f.s(2, this.value_);
                }
                int size = this.unknownFields.size() + iO;
                this.memoizedSerializedSize = size;
                return size;
            }

            public c getValue() {
                return this.value_;
            }

            public boolean hasNameId() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasValue() {
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
                if (!hasNameId()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                if (!hasValue()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                if (getValue().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }

            @Override // fp.q
            public void writeTo(fp.f fVar) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    fVar.a0(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    fVar.d0(2, this.value_);
                }
                fVar.i0(this.unknownFields);
            }

            public static C0561b newBuilder() {
                return new C0561b();
            }

            @Override // fp.r
            public C0559b getDefaultInstanceForType() {
                return f21503a;
            }

            @Override // fp.q
            public C0561b newBuilderForType() {
                return newBuilder();
            }

            @Override // fp.q
            public C0561b toBuilder() {
                return newBuilder(this);
            }

            public C0559b(fp.i.b bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.f6241a;
            }

            public C0559b(boolean z10) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = fp.d.f6202a;
            }

            public C0559b(fp.e eVar, fp.g gVar) throws fp.k {
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
                                    this.nameId_ = eVar.A();
                                } else if (iK != 18) {
                                    if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    }
                                } else {
                                    c.C0563b builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                    c cVar = (c) eVar.u(c.PARSER, gVar);
                                    this.value_ = cVar;
                                    if (builder != null) {
                                        builder.h(cVar);
                                        this.value_ = builder.l();
                                    }
                                    this.bitField0_ |= 2;
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
                    } catch (fp.k e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
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

        public static final class c extends fp.i.b<b, c> implements yo.d {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f21522b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f21523c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public List<C0559b> f21524d = Collections.emptyList();

            public static c j() {
                return new c();
            }

            public static c n() {
                return new c();
            }

            private void t() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return b.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return b.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                if (!s()) {
                    return false;
                }
                for (int i10 = 0; i10 < this.f21524d.size(); i10++) {
                    if (!p(i10).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public b build() {
                b bVarL = l();
                if (bVarL.isInitialized()) {
                    return bVarL;
                }
                throw new fp.w(bVarL);
            }

            public b l() {
                b bVar = new b(this);
                int i10 = (this.f21522b & 1) != 1 ? 0 : 1;
                bVar.id_ = this.f21523c;
                if ((this.f21522b & 2) == 2) {
                    this.f21524d = Collections.unmodifiableList(this.f21524d);
                    this.f21522b &= -3;
                }
                bVar.argument_ = this.f21524d;
                bVar.bitField0_ = i10;
                return bVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public c l() {
                return new c().h(l());
            }

            public final void o() {
                if ((this.f21522b & 2) != 2) {
                    this.f21524d = new ArrayList(this.f21524d);
                    this.f21522b |= 2;
                }
            }

            public C0559b p(int i10) {
                return this.f21524d.get(i10);
            }

            public int q() {
                return this.f21524d.size();
            }

            public b r() {
                return b.getDefaultInstance();
            }

            public boolean s() {
                return (this.f21522b & 1) == 1;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public c c(fp.e eVar, fp.g gVar) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b bVarC = b.PARSER.c(eVar, gVar);
                        if (bVarC != null) {
                            h(bVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
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

            @Override // fp.i.b
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public c h(b bVar) {
                if (bVar == b.getDefaultInstance()) {
                    return this;
                }
                if (bVar.hasId()) {
                    w(bVar.getId());
                }
                if (!bVar.argument_.isEmpty()) {
                    if (this.f21524d.isEmpty()) {
                        this.f21524d = bVar.argument_;
                        this.f21522b &= -3;
                    } else {
                        o();
                        this.f21524d.addAll(bVar.argument_);
                    }
                }
                this.f6241a = this.f6241a.b(bVar.unknownFields);
                return this;
            }

            public c w(int i10) {
                this.f21522b |= 1;
                this.f21523c = i10;
                return this;
            }
        }

        static {
            b bVar = new b(true);
            f21502a = bVar;
            bVar.b();
        }

        private void b() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
        }

        public static b getDefaultInstance() {
            return f21502a;
        }

        public static c newBuilder(b bVar) {
            return newBuilder().h(bVar);
        }

        public C0559b getArgument(int i10) {
            return this.argument_.get(i10);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<C0559b> getArgumentList() {
            return this.argument_;
        }

        public int getId() {
            return this.id_;
        }

        @Override // fp.i, fp.q
        public fp.s<b> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.id_) : 0;
            for (int i11 = 0; i11 < this.argument_.size(); i11++) {
                iO += fp.f.s(2, this.argument_.get(i11));
            }
            int size = this.unknownFields.size() + iO;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasId() {
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
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i10 = 0; i10 < getArgumentCount(); i10++) {
                if (!getArgument(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.id_);
            }
            for (int i10 = 0; i10 < this.argument_.size(); i10++) {
                fVar.d0(2, this.argument_.get(i10));
            }
            fVar.i0(this.unknownFields);
        }

        public static c newBuilder() {
            return new c();
        }

        @Override // fp.r
        public b getDefaultInstanceForType() {
            return f21502a;
        }

        @Override // fp.q
        public c newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public c toBuilder() {
            return newBuilder(this);
        }

        public b(fp.i.b bVar) {
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

        public b(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            b();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            char c10 = 0;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.bitField0_ |= 1;
                                this.id_ = eVar.A();
                            } else if (iK != 18) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                if ((c10 & 2) != 2) {
                                    this.argument_ = new ArrayList();
                                    c10 = 2;
                                }
                                this.argument_.add((C0559b) eVar.u(C0559b.PARSER, gVar));
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if ((c10 & 2) == 2) {
                            this.argument_ = Collections.unmodifiableList(this.argument_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if ((c10 & 2) == 2) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
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

    public static final class c extends fp.i.d<c> implements yo.e {
        public static fp.s<c> PARSER = new C0566a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f21525a;
        private int bitField0_;
        private int companionObjectName_;
        private List<d> constructor_;
        private List<g> enumEntry_;
        private int flags_;
        private int fqName_;
        private List<i> function_;
        private int inlineClassUnderlyingPropertyName_;
        private int inlineClassUnderlyingTypeId_;
        private q inlineClassUnderlyingType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nestedClassNameMemoizedSerializedSize;
        private List<Integer> nestedClassName_;
        private List<n> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        private List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        private List<Integer> supertypeId_;
        private List<q> supertype_;
        private List<r> typeAlias_;
        private List<s> typeParameter_;
        private t typeTable_;
        private final fp.d unknownFields;
        private w versionRequirementTable_;
        private List<Integer> versionRequirement_;

        /* JADX INFO: renamed from: yo.a$c$a, reason: collision with other inner class name */
        public static class C0566a extends fp.b<c> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public c c(fp.e eVar, fp.g gVar) throws fp.k {
                return new c(eVar, gVar);
            }
        }

        public static final class b extends fp.i.c<c, b> implements yo.e {
            public int J;
            public int L;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21526d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f21528f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f21529g;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f21527e = 6;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public List<s> f21530i = Collections.emptyList();

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public List<q> f21531n = Collections.emptyList();

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public List<Integer> f21532p = Collections.emptyList();

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public List<Integer> f21533v = Collections.emptyList();

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public List<d> f21534w = Collections.emptyList();

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public List<i> f21535x = Collections.emptyList();

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            public List<n> f21536y = Collections.emptyList();

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            public List<r> f21537z = Collections.emptyList();
            public List<g> H = Collections.emptyList();
            public List<Integer> I = Collections.emptyList();
            public q K = q.getDefaultInstance();
            public t M = t.getDefaultInstance();
            public List<Integer> N = Collections.emptyList();
            public w O = w.getDefaultInstance();

            private void Z() {
            }

            public static b p() {
                return new b();
            }

            public static b t() {
                return new b();
            }

            public final void A() {
                if ((this.f21526d & 32) != 32) {
                    this.f21532p = new ArrayList(this.f21532p);
                    this.f21526d |= 32;
                }
            }

            public final void B() {
                if ((this.f21526d & 16) != 16) {
                    this.f21531n = new ArrayList(this.f21531n);
                    this.f21526d |= 16;
                }
            }

            public final void C() {
                if ((this.f21526d & 1024) != 1024) {
                    this.f21537z = new ArrayList(this.f21537z);
                    this.f21526d |= 1024;
                }
            }

            public final void D() {
                if ((this.f21526d & 8) != 8) {
                    this.f21530i = new ArrayList(this.f21530i);
                    this.f21526d |= 8;
                }
            }

            public final void E() {
                if ((this.f21526d & 131072) != 131072) {
                    this.N = new ArrayList(this.N);
                    this.f21526d |= 131072;
                }
            }

            public d F(int i10) {
                return this.f21534w.get(i10);
            }

            public int G() {
                return this.f21534w.size();
            }

            public c H() {
                return c.getDefaultInstance();
            }

            public g I(int i10) {
                return this.H.get(i10);
            }

            public int J() {
                return this.H.size();
            }

            public i K(int i10) {
                return this.f21535x.get(i10);
            }

            public int L() {
                return this.f21535x.size();
            }

            public q M() {
                return this.K;
            }

            public n N(int i10) {
                return this.f21536y.get(i10);
            }

            public int O() {
                return this.f21536y.size();
            }

            public q P(int i10) {
                return this.f21531n.get(i10);
            }

            public int Q() {
                return this.f21531n.size();
            }

            public r R(int i10) {
                return this.f21537z.get(i10);
            }

            public int S() {
                return this.f21537z.size();
            }

            public s T(int i10) {
                return this.f21530i.get(i10);
            }

            public int U() {
                return this.f21530i.size();
            }

            public t V() {
                return this.M;
            }

            public boolean W() {
                return (this.f21526d & 2) == 2;
            }

            public boolean X() {
                return (this.f21526d & 16384) == 16384;
            }

            public boolean Y() {
                return (this.f21526d & 65536) == 65536;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                c cVar = null;
                try {
                    try {
                        c cVarC = c.PARSER.c(eVar, gVar);
                        if (cVarC != null) {
                            h(cVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
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

            @Override // fp.i.b
            /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
            public b h(c cVar) {
                if (cVar == c.getDefaultInstance()) {
                    return this;
                }
                if (cVar.hasFlags()) {
                    g0(cVar.getFlags());
                }
                if (cVar.hasFqName()) {
                    h0(cVar.getFqName());
                }
                if (cVar.hasCompanionObjectName()) {
                    f0(cVar.getCompanionObjectName());
                }
                if (!cVar.typeParameter_.isEmpty()) {
                    if (this.f21530i.isEmpty()) {
                        this.f21530i = cVar.typeParameter_;
                        this.f21526d &= -9;
                    } else {
                        D();
                        this.f21530i.addAll(cVar.typeParameter_);
                    }
                }
                if (!cVar.supertype_.isEmpty()) {
                    if (this.f21531n.isEmpty()) {
                        this.f21531n = cVar.supertype_;
                        this.f21526d &= -17;
                    } else {
                        B();
                        this.f21531n.addAll(cVar.supertype_);
                    }
                }
                if (!cVar.supertypeId_.isEmpty()) {
                    if (this.f21532p.isEmpty()) {
                        this.f21532p = cVar.supertypeId_;
                        this.f21526d &= -33;
                    } else {
                        A();
                        this.f21532p.addAll(cVar.supertypeId_);
                    }
                }
                if (!cVar.nestedClassName_.isEmpty()) {
                    if (this.f21533v.isEmpty()) {
                        this.f21533v = cVar.nestedClassName_;
                        this.f21526d &= -65;
                    } else {
                        x();
                        this.f21533v.addAll(cVar.nestedClassName_);
                    }
                }
                if (!cVar.constructor_.isEmpty()) {
                    if (this.f21534w.isEmpty()) {
                        this.f21534w = cVar.constructor_;
                        this.f21526d &= -129;
                    } else {
                        u();
                        this.f21534w.addAll(cVar.constructor_);
                    }
                }
                if (!cVar.function_.isEmpty()) {
                    if (this.f21535x.isEmpty()) {
                        this.f21535x = cVar.function_;
                        this.f21526d &= -257;
                    } else {
                        w();
                        this.f21535x.addAll(cVar.function_);
                    }
                }
                if (!cVar.property_.isEmpty()) {
                    if (this.f21536y.isEmpty()) {
                        this.f21536y = cVar.property_;
                        this.f21526d &= -513;
                    } else {
                        y();
                        this.f21536y.addAll(cVar.property_);
                    }
                }
                if (!cVar.typeAlias_.isEmpty()) {
                    if (this.f21537z.isEmpty()) {
                        this.f21537z = cVar.typeAlias_;
                        this.f21526d &= -1025;
                    } else {
                        C();
                        this.f21537z.addAll(cVar.typeAlias_);
                    }
                }
                if (!cVar.enumEntry_.isEmpty()) {
                    if (this.H.isEmpty()) {
                        this.H = cVar.enumEntry_;
                        this.f21526d &= -2049;
                    } else {
                        v();
                        this.H.addAll(cVar.enumEntry_);
                    }
                }
                if (!cVar.sealedSubclassFqName_.isEmpty()) {
                    if (this.I.isEmpty()) {
                        this.I = cVar.sealedSubclassFqName_;
                        this.f21526d &= -4097;
                    } else {
                        z();
                        this.I.addAll(cVar.sealedSubclassFqName_);
                    }
                }
                if (cVar.hasInlineClassUnderlyingPropertyName()) {
                    i0(cVar.getInlineClassUnderlyingPropertyName());
                }
                if (cVar.hasInlineClassUnderlyingType()) {
                    c0(cVar.getInlineClassUnderlyingType());
                }
                if (cVar.hasInlineClassUnderlyingTypeId()) {
                    j0(cVar.getInlineClassUnderlyingTypeId());
                }
                if (cVar.hasTypeTable()) {
                    d0(cVar.getTypeTable());
                }
                if (!cVar.versionRequirement_.isEmpty()) {
                    if (this.N.isEmpty()) {
                        this.N = cVar.versionRequirement_;
                        this.f21526d &= -131073;
                    } else {
                        E();
                        this.N.addAll(cVar.versionRequirement_);
                    }
                }
                if (cVar.hasVersionRequirementTable()) {
                    e0(cVar.getVersionRequirementTable());
                }
                o(cVar);
                this.f6241a = this.f6241a.b(cVar.unknownFields);
                return this;
            }

            public b c0(q qVar) {
                if ((this.f21526d & 16384) != 16384 || this.K == q.getDefaultInstance()) {
                    this.K = qVar;
                } else {
                    this.K = q.newBuilder(this.K).h(qVar).r();
                }
                this.f21526d |= 16384;
                return this;
            }

            public b d0(t tVar) {
                if ((this.f21526d & 65536) != 65536 || this.M == t.getDefaultInstance()) {
                    this.M = tVar;
                } else {
                    this.M = t.newBuilder(this.M).h(tVar).l();
                }
                this.f21526d |= 65536;
                return this;
            }

            public b e0(w wVar) {
                if ((this.f21526d & 262144) != 262144 || this.O == w.getDefaultInstance()) {
                    this.O = wVar;
                } else {
                    this.O = w.newBuilder(this.O).h(wVar).l();
                }
                this.f21526d |= 262144;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return c.getDefaultInstance();
            }

            public b f0(int i10) {
                this.f21526d |= 4;
                this.f21529g = i10;
                return this;
            }

            public b g0(int i10) {
                this.f21526d |= 1;
                this.f21527e = i10;
                return this;
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return c.getDefaultInstance();
            }

            public b h0(int i10) {
                this.f21526d |= 2;
                this.f21528f = i10;
                return this;
            }

            public b i0(int i10) {
                this.f21526d |= 8192;
                this.J = i10;
                return this;
            }

            @Override // fp.r
            public final boolean isInitialized() {
                if (!W()) {
                    return false;
                }
                for (int i10 = 0; i10 < this.f21530i.size(); i10++) {
                    if (!T(i10).isInitialized()) {
                        return false;
                    }
                }
                for (int i11 = 0; i11 < this.f21531n.size(); i11++) {
                    if (!P(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < this.f21534w.size(); i12++) {
                    if (!F(i12).isInitialized()) {
                        return false;
                    }
                }
                for (int i13 = 0; i13 < this.f21535x.size(); i13++) {
                    if (!K(i13).isInitialized()) {
                        return false;
                    }
                }
                for (int i14 = 0; i14 < this.f21536y.size(); i14++) {
                    if (!N(i14).isInitialized()) {
                        return false;
                    }
                }
                for (int i15 = 0; i15 < this.f21537z.size(); i15++) {
                    if (!R(i15).isInitialized()) {
                        return false;
                    }
                }
                for (int i16 = 0; i16 < this.H.size(); i16++) {
                    if (!I(i16).isInitialized()) {
                        return false;
                    }
                }
                if (!X() || this.K.isInitialized()) {
                    return (!Y() || this.M.isInitialized()) && this.f6242b.n();
                }
                return false;
            }

            public b j0(int i10) {
                this.f21526d |= 32768;
                this.L = i10;
                return this;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public c build() {
                c cVarR = r();
                if (cVarR.isInitialized()) {
                    return cVarR;
                }
                throw new fp.w(cVarR);
            }

            public c r() {
                c cVar = new c(this);
                int i10 = this.f21526d;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                cVar.flags_ = this.f21527e;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                cVar.fqName_ = this.f21528f;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                cVar.companionObjectName_ = this.f21529g;
                if ((this.f21526d & 8) == 8) {
                    this.f21530i = Collections.unmodifiableList(this.f21530i);
                    this.f21526d &= -9;
                }
                cVar.typeParameter_ = this.f21530i;
                if ((this.f21526d & 16) == 16) {
                    this.f21531n = Collections.unmodifiableList(this.f21531n);
                    this.f21526d &= -17;
                }
                cVar.supertype_ = this.f21531n;
                if ((this.f21526d & 32) == 32) {
                    this.f21532p = Collections.unmodifiableList(this.f21532p);
                    this.f21526d &= -33;
                }
                cVar.supertypeId_ = this.f21532p;
                if ((this.f21526d & 64) == 64) {
                    this.f21533v = Collections.unmodifiableList(this.f21533v);
                    this.f21526d &= -65;
                }
                cVar.nestedClassName_ = this.f21533v;
                if ((this.f21526d & 128) == 128) {
                    this.f21534w = Collections.unmodifiableList(this.f21534w);
                    this.f21526d &= -129;
                }
                cVar.constructor_ = this.f21534w;
                if ((this.f21526d & 256) == 256) {
                    this.f21535x = Collections.unmodifiableList(this.f21535x);
                    this.f21526d &= -257;
                }
                cVar.function_ = this.f21535x;
                if ((this.f21526d & 512) == 512) {
                    this.f21536y = Collections.unmodifiableList(this.f21536y);
                    this.f21526d &= -513;
                }
                cVar.property_ = this.f21536y;
                if ((this.f21526d & 1024) == 1024) {
                    this.f21537z = Collections.unmodifiableList(this.f21537z);
                    this.f21526d &= -1025;
                }
                cVar.typeAlias_ = this.f21537z;
                if ((this.f21526d & 2048) == 2048) {
                    this.H = Collections.unmodifiableList(this.H);
                    this.f21526d &= -2049;
                }
                cVar.enumEntry_ = this.H;
                if ((this.f21526d & 4096) == 4096) {
                    this.I = Collections.unmodifiableList(this.I);
                    this.f21526d &= -4097;
                }
                cVar.sealedSubclassFqName_ = this.I;
                if ((i10 & 8192) == 8192) {
                    i11 |= 8;
                }
                cVar.inlineClassUnderlyingPropertyName_ = this.J;
                if ((i10 & 16384) == 16384) {
                    i11 |= 16;
                }
                cVar.inlineClassUnderlyingType_ = this.K;
                if ((i10 & 32768) == 32768) {
                    i11 |= 32;
                }
                cVar.inlineClassUnderlyingTypeId_ = this.L;
                if ((i10 & 65536) == 65536) {
                    i11 |= 64;
                }
                cVar.typeTable_ = this.M;
                if ((this.f21526d & 131072) == 131072) {
                    this.N = Collections.unmodifiableList(this.N);
                    this.f21526d &= -131073;
                }
                cVar.versionRequirement_ = this.N;
                if ((i10 & 262144) == 262144) {
                    i11 |= 128;
                }
                cVar.versionRequirementTable_ = this.O;
                cVar.bitField0_ = i11;
                return cVar;
            }

            @Override // fp.i.c
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(r());
            }

            public final void u() {
                if ((this.f21526d & 128) != 128) {
                    this.f21534w = new ArrayList(this.f21534w);
                    this.f21526d |= 128;
                }
            }

            public final void v() {
                if ((this.f21526d & 2048) != 2048) {
                    this.H = new ArrayList(this.H);
                    this.f21526d |= 2048;
                }
            }

            public final void w() {
                if ((this.f21526d & 256) != 256) {
                    this.f21535x = new ArrayList(this.f21535x);
                    this.f21526d |= 256;
                }
            }

            public final void x() {
                if ((this.f21526d & 64) != 64) {
                    this.f21533v = new ArrayList(this.f21533v);
                    this.f21526d |= 64;
                }
            }

            public final void y() {
                if ((this.f21526d & 512) != 512) {
                    this.f21536y = new ArrayList(this.f21536y);
                    this.f21526d |= 512;
                }
            }

            public final void z() {
                if ((this.f21526d & 4096) != 4096) {
                    this.I = new ArrayList(this.I);
                    this.f21526d |= 4096;
                }
            }
        }

        /* JADX INFO: renamed from: yo.a$c$c, reason: collision with other inner class name */
        public enum EnumC0567c implements fp.j.a {
            CLASS(0, 0),
            INTERFACE(1, 1),
            ENUM_CLASS(2, 2),
            ENUM_ENTRY(3, 3),
            ANNOTATION_CLASS(4, 4),
            OBJECT(5, 5),
            COMPANION_OBJECT(6, 6);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static fp.j.b<EnumC0567c> f21538a = new C0568a();
            private final int value;

            /* JADX INFO: renamed from: yo.a$c$c$a, reason: collision with other inner class name */
            public static class C0568a implements fp.j.b<EnumC0567c> {
                public EnumC0567c a(int i10) {
                    return EnumC0567c.valueOf(i10);
                }

                @Override // fp.j.b
                public fp.j.a findValueByNumber(int i10) {
                    return EnumC0567c.valueOf(i10);
                }
            }

            EnumC0567c(int i10, int i11) {
                this.value = i11;
            }

            @Override // fp.j.a
            public final int getNumber() {
                return this.value;
            }

            public static EnumC0567c valueOf(int i10) {
                switch (i10) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }
        }

        static {
            c cVar = new c(true);
            f21525a = cVar;
            cVar.d();
        }

        private void d() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = q.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.typeTable_ = t.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = w.getDefaultInstance();
        }

        public static c getDefaultInstance() {
            return f21525a;
        }

        public static b newBuilder(c cVar) {
            return newBuilder().h(cVar);
        }

        public static c parseFrom(InputStream inputStream, fp.g gVar) throws IOException {
            return PARSER.b(inputStream, gVar);
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public d getConstructor(int i10) {
            return this.constructor_.get(i10);
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public List<d> getConstructorList() {
            return this.constructor_;
        }

        public g getEnumEntry(int i10) {
            return this.enumEntry_.get(i10);
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public List<g> getEnumEntryList() {
            return this.enumEntry_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFqName() {
            return this.fqName_;
        }

        public i getFunction(int i10) {
            return this.function_.get(i10);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<i> getFunctionList() {
            return this.function_;
        }

        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        public q getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        @Override // fp.i, fp.q
        public fp.s<c> getParserForType() {
            return PARSER;
        }

        public n getProperty(int i10) {
            return this.property_.get(i10);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<n> getPropertyList() {
            return this.property_;
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.flags_) : 0;
            int iP = 0;
            for (int i11 = 0; i11 < this.supertypeId_.size(); i11++) {
                iP += fp.f.p(this.supertypeId_.get(i11).intValue());
            }
            int iS = iO + iP;
            if (!getSupertypeIdList().isEmpty()) {
                iS = iS + 1 + fp.f.p(iP);
            }
            this.supertypeIdMemoizedSerializedSize = iP;
            if ((this.bitField0_ & 2) == 2) {
                iS += fp.f.o(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iS += fp.f.o(4, this.companionObjectName_);
            }
            for (int i12 = 0; i12 < this.typeParameter_.size(); i12++) {
                iS += fp.f.s(5, this.typeParameter_.get(i12));
            }
            for (int i13 = 0; i13 < this.supertype_.size(); i13++) {
                iS += fp.f.s(6, this.supertype_.get(i13));
            }
            int iP2 = 0;
            for (int i14 = 0; i14 < this.nestedClassName_.size(); i14++) {
                iP2 += fp.f.p(this.nestedClassName_.get(i14).intValue());
            }
            int iS2 = iS + iP2;
            if (!getNestedClassNameList().isEmpty()) {
                iS2 = iS2 + 1 + fp.f.p(iP2);
            }
            this.nestedClassNameMemoizedSerializedSize = iP2;
            for (int i15 = 0; i15 < this.constructor_.size(); i15++) {
                iS2 += fp.f.s(8, this.constructor_.get(i15));
            }
            for (int i16 = 0; i16 < this.function_.size(); i16++) {
                iS2 += fp.f.s(9, this.function_.get(i16));
            }
            for (int i17 = 0; i17 < this.property_.size(); i17++) {
                iS2 += fp.f.s(10, this.property_.get(i17));
            }
            for (int i18 = 0; i18 < this.typeAlias_.size(); i18++) {
                iS2 += fp.f.s(11, this.typeAlias_.get(i18));
            }
            for (int i19 = 0; i19 < this.enumEntry_.size(); i19++) {
                iS2 += fp.f.s(13, this.enumEntry_.get(i19));
            }
            int iP3 = 0;
            for (int i20 = 0; i20 < this.sealedSubclassFqName_.size(); i20++) {
                iP3 += fp.f.p(this.sealedSubclassFqName_.get(i20).intValue());
            }
            int iS3 = iS2 + iP3;
            if (!getSealedSubclassFqNameList().isEmpty()) {
                iS3 = iS3 + 2 + fp.f.p(iP3);
            }
            this.sealedSubclassFqNameMemoizedSerializedSize = iP3;
            if ((this.bitField0_ & 8) == 8) {
                iS3 += fp.f.o(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iS3 += fp.f.s(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                iS3 += fp.f.o(19, this.inlineClassUnderlyingTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                iS3 += fp.f.s(30, this.typeTable_);
            }
            int iP4 = 0;
            for (int i21 = 0; i21 < this.versionRequirement_.size(); i21++) {
                iP4 += fp.f.p(this.versionRequirement_.get(i21).intValue());
            }
            int size = (getVersionRequirementList().size() * 2) + iS3 + iP4;
            if ((this.bitField0_ & 128) == 128) {
                size += fp.f.s(32, this.versionRequirementTable_);
            }
            int size2 = this.unknownFields.size() + extensionsSerializedSize() + size;
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public q getSupertype(int i10) {
            return this.supertype_.get(i10);
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        public List<q> getSupertypeList() {
            return this.supertype_;
        }

        public r getTypeAlias(int i10) {
            return this.typeAlias_.get(i10);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<r> getTypeAliasList() {
            return this.typeAlias_;
        }

        public s getTypeParameter(int i10) {
            return this.typeParameter_.get(i10);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<s> getTypeParameterList() {
            return this.typeParameter_;
        }

        public t getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public w getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasCompanionObjectName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasFqName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasInlineClassUnderlyingPropertyName() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasInlineClassUnderlyingType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasInlineClassUnderlyingTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 128) == 128;
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
            if (!hasFqName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i10 = 0; i10 < getTypeParameterCount(); i10++) {
                if (!getTypeParameter(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i11 = 0; i11 < getSupertypeCount(); i11++) {
                if (!getSupertype(i11).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i12 = 0; i12 < getConstructorCount(); i12++) {
                if (!getConstructor(i12).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i13 = 0; i13 < getFunctionCount(); i13++) {
                if (!getFunction(i13).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i14 = 0; i14 < getPropertyCount(); i14++) {
                if (!getProperty(i14).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i15 = 0; i15 < getTypeAliasCount(); i15++) {
                if (!getTypeAlias(i15).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i16 = 0; i16 < getEnumEntryCount(); i16++) {
                if (!getEnumEntry(i16).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasInlineClassUnderlyingType() && !getInlineClassUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            fp.i.d<MessageType>.a aVarNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.flags_);
            }
            if (getSupertypeIdList().size() > 0) {
                fVar.o0(18);
                fVar.o0(this.supertypeIdMemoizedSerializedSize);
            }
            for (int i10 = 0; i10 < this.supertypeId_.size(); i10++) {
                fVar.b0(this.supertypeId_.get(i10).intValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.a0(4, this.companionObjectName_);
            }
            for (int i11 = 0; i11 < this.typeParameter_.size(); i11++) {
                fVar.d0(5, this.typeParameter_.get(i11));
            }
            for (int i12 = 0; i12 < this.supertype_.size(); i12++) {
                fVar.d0(6, this.supertype_.get(i12));
            }
            if (getNestedClassNameList().size() > 0) {
                fVar.o0(58);
                fVar.o0(this.nestedClassNameMemoizedSerializedSize);
            }
            for (int i13 = 0; i13 < this.nestedClassName_.size(); i13++) {
                fVar.b0(this.nestedClassName_.get(i13).intValue());
            }
            for (int i14 = 0; i14 < this.constructor_.size(); i14++) {
                fVar.d0(8, this.constructor_.get(i14));
            }
            for (int i15 = 0; i15 < this.function_.size(); i15++) {
                fVar.d0(9, this.function_.get(i15));
            }
            for (int i16 = 0; i16 < this.property_.size(); i16++) {
                fVar.d0(10, this.property_.get(i16));
            }
            for (int i17 = 0; i17 < this.typeAlias_.size(); i17++) {
                fVar.d0(11, this.typeAlias_.get(i17));
            }
            for (int i18 = 0; i18 < this.enumEntry_.size(); i18++) {
                fVar.d0(13, this.enumEntry_.get(i18));
            }
            if (getSealedSubclassFqNameList().size() > 0) {
                fVar.o0(OSMaskImageView.f2731x);
                fVar.o0(this.sealedSubclassFqNameMemoizedSerializedSize);
            }
            for (int i19 = 0; i19 < this.sealedSubclassFqName_.size(); i19++) {
                fVar.b0(this.sealedSubclassFqName_.get(i19).intValue());
            }
            if ((this.bitField0_ & 8) == 8) {
                fVar.a0(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                fVar.d0(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                fVar.a0(19, this.inlineClassUnderlyingTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                fVar.d0(30, this.typeTable_);
            }
            for (int i20 = 0; i20 < this.versionRequirement_.size(); i20++) {
                fVar.a0(31, this.versionRequirement_.get(i20).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                fVar.d0(32, this.versionRequirementTable_);
            }
            aVarNewExtensionWriter.a(19000, fVar);
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public c getDefaultInstanceForType() {
            return f21525a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public c(fp.i.c<c, ?> cVar) {
            super(cVar);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f6241a;
        }

        public c(boolean z10) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(fp.e eVar, fp.g gVar) throws fp.k {
            boolean z10;
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            d();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z11 = false;
            int i10 = 0;
            while (!z11) {
                try {
                    try {
                        int iK = eVar.K();
                        switch (iK) {
                            case 0:
                                z10 = true;
                                z11 = true;
                                continue;
                            case 8:
                                z10 = true;
                                this.bitField0_ |= 1;
                                this.flags_ = eVar.s();
                                continue;
                            case 16:
                                if ((i10 & 32) != 32) {
                                    this.supertypeId_ = new ArrayList();
                                    i10 |= 32;
                                }
                                this.supertypeId_.add(Integer.valueOf(eVar.s()));
                                break;
                            case 18:
                                int iJ = eVar.j(eVar.A());
                                if ((i10 & 32) != 32 && eVar.e() > 0) {
                                    this.supertypeId_ = new ArrayList();
                                    i10 |= 32;
                                }
                                while (eVar.e() > 0) {
                                    this.supertypeId_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(iJ);
                                break;
                            case 24:
                                this.bitField0_ |= 2;
                                this.fqName_ = eVar.s();
                                break;
                            case 32:
                                this.bitField0_ |= 4;
                                this.companionObjectName_ = eVar.s();
                                break;
                            case 42:
                                if ((i10 & 8) != 8) {
                                    this.typeParameter_ = new ArrayList();
                                    i10 |= 8;
                                }
                                this.typeParameter_.add((s) eVar.u(s.PARSER, gVar));
                                break;
                            case 50:
                                if ((i10 & 16) != 16) {
                                    this.supertype_ = new ArrayList();
                                    i10 |= 16;
                                }
                                this.supertype_.add((q) eVar.u(q.PARSER, gVar));
                                break;
                            case 56:
                                if ((i10 & 64) != 64) {
                                    this.nestedClassName_ = new ArrayList();
                                    i10 |= 64;
                                }
                                this.nestedClassName_.add(Integer.valueOf(eVar.s()));
                                break;
                            case 58:
                                int iJ2 = eVar.j(eVar.A());
                                if ((i10 & 64) != 64 && eVar.e() > 0) {
                                    this.nestedClassName_ = new ArrayList();
                                    i10 |= 64;
                                }
                                while (eVar.e() > 0) {
                                    this.nestedClassName_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(iJ2);
                                break;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                if ((i10 & 128) != 128) {
                                    this.constructor_ = new ArrayList();
                                    i10 |= 128;
                                }
                                this.constructor_.add((d) eVar.u(d.PARSER, gVar));
                                break;
                            case 74:
                                if ((i10 & 256) != 256) {
                                    this.function_ = new ArrayList();
                                    i10 |= 256;
                                }
                                this.function_.add((i) eVar.u(i.PARSER, gVar));
                                break;
                            case 82:
                                if ((i10 & 512) != 512) {
                                    this.property_ = new ArrayList();
                                    i10 |= 512;
                                }
                                this.property_.add((n) eVar.u(n.PARSER, gVar));
                                break;
                            case 90:
                                if ((i10 & 1024) != 1024) {
                                    this.typeAlias_ = new ArrayList();
                                    i10 |= 1024;
                                }
                                this.typeAlias_.add((r) eVar.u(r.PARSER, gVar));
                                break;
                            case 106:
                                if ((i10 & 2048) != 2048) {
                                    this.enumEntry_ = new ArrayList();
                                    i10 |= 2048;
                                }
                                this.enumEntry_.add((g) eVar.u(g.PARSER, gVar));
                                break;
                            case 128:
                                if ((i10 & 4096) != 4096) {
                                    this.sealedSubclassFqName_ = new ArrayList();
                                    i10 |= 4096;
                                }
                                this.sealedSubclassFqName_.add(Integer.valueOf(eVar.s()));
                                break;
                            case OSMaskImageView.f2731x /* 130 */:
                                int iJ3 = eVar.j(eVar.A());
                                if ((i10 & 4096) != 4096 && eVar.e() > 0) {
                                    this.sealedSubclassFqName_ = new ArrayList();
                                    i10 |= 4096;
                                }
                                while (eVar.e() > 0) {
                                    this.sealedSubclassFqName_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(iJ3);
                                break;
                            case 136:
                                this.bitField0_ |= 8;
                                this.inlineClassUnderlyingPropertyName_ = eVar.s();
                                break;
                            case 146:
                                q.c builder = (this.bitField0_ & 16) == 16 ? this.inlineClassUnderlyingType_.toBuilder() : null;
                                q qVar = (q) eVar.u(q.PARSER, gVar);
                                this.inlineClassUnderlyingType_ = qVar;
                                if (builder != 0) {
                                    builder.h(qVar);
                                    this.inlineClassUnderlyingType_ = builder.r();
                                }
                                this.bitField0_ |= 16;
                                break;
                            case 152:
                                this.bitField0_ |= 32;
                                this.inlineClassUnderlyingTypeId_ = eVar.s();
                                break;
                            case 242:
                                t.b builder2 = (this.bitField0_ & 64) == 64 ? this.typeTable_.toBuilder() : null;
                                t tVar = (t) eVar.u(t.PARSER, gVar);
                                this.typeTable_ = tVar;
                                if (builder2 != 0) {
                                    builder2.h(tVar);
                                    this.typeTable_ = builder2.l();
                                }
                                this.bitField0_ |= 64;
                                break;
                            case 248:
                                if ((i10 & 131072) != 131072) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 |= 131072;
                                }
                                this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                break;
                            case 250:
                                int iJ4 = eVar.j(eVar.A());
                                if ((i10 & 131072) != 131072 && eVar.e() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 |= 131072;
                                }
                                while (eVar.e() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(iJ4);
                                break;
                            case 258:
                                w.b builder3 = (this.bitField0_ & 128) == 128 ? this.versionRequirementTable_.toBuilder() : null;
                                w wVar = (w) eVar.u(w.PARSER, gVar);
                                this.versionRequirementTable_ = wVar;
                                if (builder3 != 0) {
                                    builder3.h(wVar);
                                    this.versionRequirementTable_ = builder3.l();
                                }
                                this.bitField0_ |= 128;
                                break;
                            default:
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    z11 = true;
                                }
                                break;
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if ((i10 & 32) == 32) {
                            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                        }
                        if ((i10 & 8) == 8) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((i10 & 16) == 16) {
                            this.supertype_ = Collections.unmodifiableList(this.supertype_);
                        }
                        if ((i10 & 64) == 64) {
                            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                        }
                        if ((i10 & 128) == 128) {
                            this.constructor_ = Collections.unmodifiableList(this.constructor_);
                        }
                        if ((i10 & 256) == 256) {
                            this.function_ = Collections.unmodifiableList(this.function_);
                        }
                        if ((i10 & 512) == 512) {
                            this.property_ = Collections.unmodifiableList(this.property_);
                        }
                        if ((i10 & 1024) == 1024) {
                            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                        }
                        if ((i10 & 2048) == 2048) {
                            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                        }
                        if ((i10 & 4096) == 4096) {
                            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                        }
                        if ((i10 & 131072) == 131072) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if ((i10 & 32) == 32) {
                this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
            }
            if ((i10 & 8) == 8) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if ((i10 & 16) == 16) {
                this.supertype_ = Collections.unmodifiableList(this.supertype_);
            }
            if ((i10 & 64) == 64) {
                this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
            }
            if ((i10 & 128) == 128) {
                this.constructor_ = Collections.unmodifiableList(this.constructor_);
            }
            if ((i10 & 256) == 256) {
                this.function_ = Collections.unmodifiableList(this.function_);
            }
            if ((i10 & 512) == 512) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            if ((i10 & 1024) == 1024) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
            }
            if ((i10 & 2048) == 2048) {
                this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
            }
            if ((i10 & 4096) == 4096) {
                this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
            }
            if ((i10 & 131072) == 131072) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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

    public static final class d extends fp.i.d<d> implements yo.f {
        public static fp.s<d> PARSER = new C0569a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f21540a;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final fp.d unknownFields;
        private List<u> valueParameter_;
        private List<Integer> versionRequirement_;

        /* JADX INFO: renamed from: yo.a$d$a, reason: collision with other inner class name */
        public static class C0569a extends fp.b<d> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public d c(fp.e eVar, fp.g gVar) throws fp.k {
                return new d(eVar, gVar);
            }
        }

        public static final class b extends fp.i.c<d, b> implements yo.f {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21541d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f21542e = 6;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public List<u> f21543f = Collections.emptyList();

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public List<Integer> f21544g = Collections.emptyList();

            public static b p() {
                return new b();
            }

            public static b t() {
                return new b();
            }

            private void v() {
                if ((this.f21541d & 4) != 4) {
                    this.f21544g = new ArrayList(this.f21544g);
                    this.f21541d |= 4;
                }
            }

            private void z() {
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                d dVar = null;
                try {
                    try {
                        d dVarC = d.PARSER.c(eVar, gVar);
                        if (dVarC != null) {
                            h(dVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
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

            @Override // fp.i.b
            /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
            public b h(d dVar) {
                if (dVar == d.getDefaultInstance()) {
                    return this;
                }
                if (dVar.hasFlags()) {
                    C(dVar.getFlags());
                }
                if (!dVar.valueParameter_.isEmpty()) {
                    if (this.f21543f.isEmpty()) {
                        this.f21543f = dVar.valueParameter_;
                        this.f21541d &= -3;
                    } else {
                        u();
                        this.f21543f.addAll(dVar.valueParameter_);
                    }
                }
                if (!dVar.versionRequirement_.isEmpty()) {
                    if (this.f21544g.isEmpty()) {
                        this.f21544g = dVar.versionRequirement_;
                        this.f21541d &= -5;
                    } else {
                        v();
                        this.f21544g.addAll(dVar.versionRequirement_);
                    }
                }
                o(dVar);
                this.f6241a = this.f6241a.b(dVar.unknownFields);
                return this;
            }

            public b C(int i10) {
                this.f21541d |= 1;
                this.f21542e = i10;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return d.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return d.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < this.f21543f.size(); i10++) {
                    if (!x(i10).isInitialized()) {
                        return false;
                    }
                }
                return this.f6242b.n();
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public d build() {
                d dVarR = r();
                if (dVarR.isInitialized()) {
                    return dVarR;
                }
                throw new fp.w(dVarR);
            }

            public d r() {
                d dVar = new d(this);
                int i10 = (this.f21541d & 1) != 1 ? 0 : 1;
                dVar.flags_ = this.f21542e;
                if ((this.f21541d & 2) == 2) {
                    this.f21543f = Collections.unmodifiableList(this.f21543f);
                    this.f21541d &= -3;
                }
                dVar.valueParameter_ = this.f21543f;
                if ((this.f21541d & 4) == 4) {
                    this.f21544g = Collections.unmodifiableList(this.f21544g);
                    this.f21541d &= -5;
                }
                dVar.versionRequirement_ = this.f21544g;
                dVar.bitField0_ = i10;
                return dVar;
            }

            @Override // fp.i.c
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(r());
            }

            public final void u() {
                if ((this.f21541d & 2) != 2) {
                    this.f21543f = new ArrayList(this.f21543f);
                    this.f21541d |= 2;
                }
            }

            public d w() {
                return d.getDefaultInstance();
            }

            public u x(int i10) {
                return this.f21543f.get(i10);
            }

            public int y() {
                return this.f21543f.size();
            }
        }

        static {
            d dVar = new d(true);
            f21540a = dVar;
            dVar.d();
        }

        private void d() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static d getDefaultInstance() {
            return f21540a;
        }

        public static b newBuilder(d dVar) {
            return newBuilder().h(dVar);
        }

        public int getFlags() {
            return this.flags_;
        }

        @Override // fp.i, fp.q
        public fp.s<d> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.flags_) : 0;
            for (int i11 = 0; i11 < this.valueParameter_.size(); i11++) {
                iO += fp.f.s(2, this.valueParameter_.get(i11));
            }
            int iP = 0;
            for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
                iP += fp.f.p(this.versionRequirement_.get(i12).intValue());
            }
            int size = this.unknownFields.size() + extensionsSerializedSize() + (getVersionRequirementList().size() * 2) + iO + iP;
            this.memoizedSerializedSize = size;
            return size;
        }

        public u getValueParameter(int i10) {
            return this.valueParameter_.get(i10);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<u> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
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
            for (int i10 = 0; i10 < getValueParameterCount(); i10++) {
                if (!getValueParameter(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            fp.i.d<MessageType>.a aVarNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.flags_);
            }
            for (int i10 = 0; i10 < this.valueParameter_.size(); i10++) {
                fVar.d0(2, this.valueParameter_.get(i10));
            }
            for (int i11 = 0; i11 < this.versionRequirement_.size(); i11++) {
                fVar.a0(31, this.versionRequirement_.get(i11).intValue());
            }
            aVarNewExtensionWriter.a(19000, fVar);
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public d getDefaultInstanceForType() {
            return f21540a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public d(fp.i.c<d, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f6241a;
        }

        public d(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public d(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            d();
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
                                this.flags_ = eVar.A();
                            } else if (iK == 18) {
                                if ((i10 & 2) != 2) {
                                    this.valueParameter_ = new ArrayList();
                                    i10 |= 2;
                                }
                                this.valueParameter_.add((u) eVar.u(u.PARSER, gVar));
                            } else if (iK == 248) {
                                if ((i10 & 4) != 4) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 |= 4;
                                }
                                this.versionRequirement_.add(Integer.valueOf(eVar.A()));
                            } else if (iK != 250) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                int iJ = eVar.j(eVar.A());
                                if ((i10 & 4) != 4 && eVar.e() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 |= 4;
                                }
                                while (eVar.e() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(eVar.A()));
                                }
                                eVar.i(iJ);
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if ((i10 & 2) == 2) {
                            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                        }
                        if ((i10 & 4) == 4) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if ((i10 & 2) == 2) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
            }
            if ((i10 & 4) == 4) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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

    public static final class e extends fp.i implements yo.g {
        public static fp.s<e> PARSER = new C0570a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f21545a;
        private List<f> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: yo.a$e$a, reason: collision with other inner class name */
        public static class C0570a extends fp.b<e> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public e c(fp.e eVar, fp.g gVar) throws fp.k {
                return new e(eVar, gVar);
            }
        }

        public static final class b extends fp.i.b<e, b> implements yo.g {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f21546b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public List<f> f21547c = Collections.emptyList();

            public static b j() {
                return new b();
            }

            public static b n() {
                return new b();
            }

            private void s() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return e.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return e.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < this.f21547c.size(); i10++) {
                    if (!q(i10).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public e build() {
                e eVarL = l();
                if (eVarL.isInitialized()) {
                    return eVarL;
                }
                throw new fp.w(eVarL);
            }

            public e l() {
                e eVar = new e(this);
                if ((this.f21546b & 1) == 1) {
                    this.f21547c = Collections.unmodifiableList(this.f21547c);
                    this.f21546b &= -2;
                }
                eVar.effect_ = this.f21547c;
                return eVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(l());
            }

            public final void o() {
                if ((this.f21546b & 1) != 1) {
                    this.f21547c = new ArrayList(this.f21547c);
                    this.f21546b |= 1;
                }
            }

            public e p() {
                return e.getDefaultInstance();
            }

            public f q(int i10) {
                return this.f21547c.get(i10);
            }

            public int r() {
                return this.f21547c.size();
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                e eVar2 = null;
                try {
                    try {
                        e eVarC = e.PARSER.c(eVar, gVar);
                        if (eVarC != null) {
                            h(eVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
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

            @Override // fp.i.b
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public b h(e eVar) {
                if (eVar == e.getDefaultInstance()) {
                    return this;
                }
                if (!eVar.effect_.isEmpty()) {
                    if (this.f21547c.isEmpty()) {
                        this.f21547c = eVar.effect_;
                        this.f21546b &= -2;
                    } else {
                        o();
                        this.f21547c.addAll(eVar.effect_);
                    }
                }
                this.f6241a = this.f6241a.b(eVar.unknownFields);
                return this;
            }
        }

        static {
            e eVar = new e(true);
            f21545a = eVar;
            eVar.b();
        }

        private void b() {
            this.effect_ = Collections.emptyList();
        }

        public static e getDefaultInstance() {
            return f21545a;
        }

        public static b newBuilder(e eVar) {
            return newBuilder().h(eVar);
        }

        public f getEffect(int i10) {
            return this.effect_.get(i10);
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        @Override // fp.i, fp.q
        public fp.s<e> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iS = 0;
            for (int i11 = 0; i11 < this.effect_.size(); i11++) {
                iS += fp.f.s(1, this.effect_.get(i11));
            }
            int size = this.unknownFields.size() + iS;
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
            for (int i10 = 0; i10 < getEffectCount(); i10++) {
                if (!getEffect(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            for (int i10 = 0; i10 < this.effect_.size(); i10++) {
                fVar.d0(1, this.effect_.get(i10));
            }
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public e getDefaultInstanceForType() {
            return f21545a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public e(fp.i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public e(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public e(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            b();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK != 10) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                if (!z11) {
                                    this.effect_ = new ArrayList();
                                    z11 = true;
                                }
                                this.effect_.add((f) eVar.u(f.PARSER, gVar));
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if (z11) {
                            this.effect_ = Collections.unmodifiableList(this.effect_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if (z11) {
                this.effect_ = Collections.unmodifiableList(this.effect_);
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

    public static final class f extends fp.i implements yo.h {
        public static fp.s<f> PARSER = new C0571a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f21548a;
        private int bitField0_;
        private h conclusionOfConditionalEffect_;
        private List<h> effectConstructorArgument_;
        private c effectType_;
        private d kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: yo.a$f$a, reason: collision with other inner class name */
        public static class C0571a extends fp.b<f> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public f c(fp.e eVar, fp.g gVar) throws fp.k {
                return new f(eVar, gVar);
            }
        }

        public static final class b extends fp.i.b<f, b> implements yo.h {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f21549b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public c f21550c = c.RETURNS_CONSTANT;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public List<h> f21551d = Collections.emptyList();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public h f21552e = h.getDefaultInstance();

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public d f21553f = d.AT_MOST_ONCE;

            public static b j() {
                return new b();
            }

            public static b n() {
                return new b();
            }

            private void u() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return f.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return f.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < this.f21551d.size(); i10++) {
                    if (!r(i10).isInitialized()) {
                        return false;
                    }
                }
                return !t() || this.f21552e.isInitialized();
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public f build() {
                f fVarL = l();
                if (fVarL.isInitialized()) {
                    return fVarL;
                }
                throw new fp.w(fVarL);
            }

            public f l() {
                f fVar = new f(this);
                int i10 = this.f21549b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                fVar.effectType_ = this.f21550c;
                if ((this.f21549b & 2) == 2) {
                    this.f21551d = Collections.unmodifiableList(this.f21551d);
                    this.f21549b &= -3;
                }
                fVar.effectConstructorArgument_ = this.f21551d;
                if ((i10 & 4) == 4) {
                    i11 |= 2;
                }
                fVar.conclusionOfConditionalEffect_ = this.f21552e;
                if ((i10 & 8) == 8) {
                    i11 |= 4;
                }
                fVar.kind_ = this.f21553f;
                fVar.bitField0_ = i11;
                return fVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(l());
            }

            public final void o() {
                if ((this.f21549b & 2) != 2) {
                    this.f21551d = new ArrayList(this.f21551d);
                    this.f21549b |= 2;
                }
            }

            public h p() {
                return this.f21552e;
            }

            public f q() {
                return f.getDefaultInstance();
            }

            public h r(int i10) {
                return this.f21551d.get(i10);
            }

            public int s() {
                return this.f21551d.size();
            }

            public boolean t() {
                return (this.f21549b & 4) == 4;
            }

            public b v(h hVar) {
                if ((this.f21549b & 4) != 4 || this.f21552e == h.getDefaultInstance()) {
                    this.f21552e = hVar;
                } else {
                    this.f21552e = h.newBuilder(this.f21552e).h(hVar).l();
                }
                this.f21549b |= 4;
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                f fVar = null;
                try {
                    try {
                        f fVarC = f.PARSER.c(eVar, gVar);
                        if (fVarC != null) {
                            h(fVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        f fVar2 = (f) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            fVar = fVar2;
                            if (fVar != null) {
                                h(fVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (fVar != null) {
                        h(fVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
            public b h(f fVar) {
                if (fVar == f.getDefaultInstance()) {
                    return this;
                }
                if (fVar.hasEffectType()) {
                    y(fVar.getEffectType());
                }
                if (!fVar.effectConstructorArgument_.isEmpty()) {
                    if (this.f21551d.isEmpty()) {
                        this.f21551d = fVar.effectConstructorArgument_;
                        this.f21549b &= -3;
                    } else {
                        o();
                        this.f21551d.addAll(fVar.effectConstructorArgument_);
                    }
                }
                if (fVar.hasConclusionOfConditionalEffect()) {
                    v(fVar.getConclusionOfConditionalEffect());
                }
                if (fVar.hasKind()) {
                    z(fVar.getKind());
                }
                this.f6241a = this.f6241a.b(fVar.unknownFields);
                return this;
            }

            public b y(c cVar) {
                cVar.getClass();
                this.f21549b |= 1;
                this.f21550c = cVar;
                return this;
            }

            public b z(d dVar) {
                dVar.getClass();
                this.f21549b |= 8;
                this.f21553f = dVar;
                return this;
            }
        }

        public enum c implements fp.j.a {
            RETURNS_CONSTANT(0, 0),
            CALLS(1, 1),
            RETURNS_NOT_NULL(2, 2);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static fp.j.b<c> f21554a = new C0572a();
            private final int value;

            /* JADX INFO: renamed from: yo.a$f$c$a, reason: collision with other inner class name */
            public static class C0572a implements fp.j.b<c> {
                public c a(int i10) {
                    return c.valueOf(i10);
                }

                @Override // fp.j.b
                public fp.j.a findValueByNumber(int i10) {
                    return c.valueOf(i10);
                }
            }

            c(int i10, int i11) {
                this.value = i11;
            }

            @Override // fp.j.a
            public final int getNumber() {
                return this.value;
            }

            public static c valueOf(int i10) {
                if (i10 == 0) {
                    return RETURNS_CONSTANT;
                }
                if (i10 == 1) {
                    return CALLS;
                }
                if (i10 != 2) {
                    return null;
                }
                return RETURNS_NOT_NULL;
            }
        }

        public enum d implements fp.j.a {
            AT_MOST_ONCE(0, 0),
            EXACTLY_ONCE(1, 1),
            AT_LEAST_ONCE(2, 2);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static fp.j.b<d> f21556a = new C0573a();
            private final int value;

            /* JADX INFO: renamed from: yo.a$f$d$a, reason: collision with other inner class name */
            public static class C0573a implements fp.j.b<d> {
                public d a(int i10) {
                    return d.valueOf(i10);
                }

                @Override // fp.j.b
                public fp.j.a findValueByNumber(int i10) {
                    return d.valueOf(i10);
                }
            }

            d(int i10, int i11) {
                this.value = i11;
            }

            @Override // fp.j.a
            public final int getNumber() {
                return this.value;
            }

            public static d valueOf(int i10) {
                if (i10 == 0) {
                    return AT_MOST_ONCE;
                }
                if (i10 == 1) {
                    return EXACTLY_ONCE;
                }
                if (i10 != 2) {
                    return null;
                }
                return AT_LEAST_ONCE;
            }
        }

        static {
            f fVar = new f(true);
            f21548a = fVar;
            fVar.b();
        }

        private void b() {
            this.effectType_ = c.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = h.getDefaultInstance();
            this.kind_ = d.AT_MOST_ONCE;
        }

        public static f getDefaultInstance() {
            return f21548a;
        }

        public static b newBuilder(f fVar) {
            return newBuilder().h(fVar);
        }

        public h getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        public h getEffectConstructorArgument(int i10) {
            return this.effectConstructorArgument_.get(i10);
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        public c getEffectType() {
            return this.effectType_;
        }

        public d getKind() {
            return this.kind_;
        }

        @Override // fp.i, fp.q
        public fp.s<f> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iH = (this.bitField0_ & 1) == 1 ? fp.f.h(1, this.effectType_.getNumber()) : 0;
            for (int i11 = 0; i11 < this.effectConstructorArgument_.size(); i11++) {
                iH += fp.f.s(2, this.effectConstructorArgument_.get(i11));
            }
            if ((this.bitField0_ & 2) == 2) {
                iH += fp.f.s(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iH += fp.f.h(4, this.kind_.getNumber());
            }
            int size = this.unknownFields.size() + iH;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasConclusionOfConditionalEffect() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasEffectType() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasKind() {
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
            for (int i10 = 0; i10 < getEffectConstructorArgumentCount(); i10++) {
                if (!getEffectConstructorArgument(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                fVar.S(1, this.effectType_.getNumber());
            }
            for (int i10 = 0; i10 < this.effectConstructorArgument_.size(); i10++) {
                fVar.d0(2, this.effectConstructorArgument_.get(i10));
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.d0(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.S(4, this.kind_.getNumber());
            }
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public f getDefaultInstanceForType() {
            return f21548a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public f(fp.i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public f(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public f(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            b();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            char c10 = 0;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                int iA = eVar.A();
                                c cVarValueOf = c.valueOf(iA);
                                if (cVarValueOf == null) {
                                    fVarJ.o0(iK);
                                    fVarJ.o0(iA);
                                } else {
                                    this.bitField0_ |= 1;
                                    this.effectType_ = cVarValueOf;
                                }
                            } else if (iK == 18) {
                                if ((c10 & 2) != 2) {
                                    this.effectConstructorArgument_ = new ArrayList();
                                    c10 = 2;
                                }
                                this.effectConstructorArgument_.add((h) eVar.u(h.PARSER, gVar));
                            } else if (iK == 26) {
                                h.b builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                                h hVar = (h) eVar.u(h.PARSER, gVar);
                                this.conclusionOfConditionalEffect_ = hVar;
                                if (builder != null) {
                                    builder.h(hVar);
                                    this.conclusionOfConditionalEffect_ = builder.l();
                                }
                                this.bitField0_ |= 2;
                            } else if (iK != 32) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                int iA2 = eVar.A();
                                d dVarValueOf = d.valueOf(iA2);
                                if (dVarValueOf == null) {
                                    fVarJ.o0(iK);
                                    fVarJ.o0(iA2);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.kind_ = dVarValueOf;
                                }
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if ((c10 & 2) == 2) {
                            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if ((c10 & 2) == 2) {
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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

    public static final class g extends fp.i.d<g> implements yo.i {
        public static fp.s<g> PARSER = new C0574a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f21558a;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: yo.a$g$a, reason: collision with other inner class name */
        public static class C0574a extends fp.b<g> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public g c(fp.e eVar, fp.g gVar) throws fp.k {
                return new g(eVar, gVar);
            }
        }

        public static final class b extends fp.i.c<g, b> implements yo.i {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21559d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f21560e;

            public static b p() {
                return new b();
            }

            public static b t() {
                return new b();
            }

            private void v() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return g.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return g.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                return this.f6242b.n();
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public g build() {
                g gVarR = r();
                if (gVarR.isInitialized()) {
                    return gVarR;
                }
                throw new fp.w(gVarR);
            }

            public g r() {
                g gVar = new g(this);
                int i10 = (this.f21559d & 1) != 1 ? 0 : 1;
                gVar.name_ = this.f21560e;
                gVar.bitField0_ = i10;
                return gVar;
            }

            @Override // fp.i.c
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(r());
            }

            public g u() {
                return g.getDefaultInstance();
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                g gVar2 = null;
                try {
                    try {
                        g gVarC = g.PARSER.c(eVar, gVar);
                        if (gVarC != null) {
                            h(gVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        g gVar3 = (g) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            gVar2 = gVar3;
                            if (gVar2 != null) {
                                h(gVar2);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (gVar2 != null) {
                        h(gVar2);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
            public b h(g gVar) {
                if (gVar == g.getDefaultInstance()) {
                    return this;
                }
                if (gVar.hasName()) {
                    y(gVar.getName());
                }
                o(gVar);
                this.f6241a = this.f6241a.b(gVar.unknownFields);
                return this;
            }

            public b y(int i10) {
                this.f21559d |= 1;
                this.f21560e = i10;
                return this;
            }
        }

        static {
            g gVar = new g(true);
            f21558a = gVar;
            gVar.name_ = 0;
        }

        private void d() {
            this.name_ = 0;
        }

        public static g getDefaultInstance() {
            return f21558a;
        }

        public static b newBuilder(g gVar) {
            return newBuilder().h(gVar);
        }

        public int getName() {
            return this.name_;
        }

        @Override // fp.i, fp.q
        public fp.s<g> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int size = this.unknownFields.size() + extensionsSerializedSize() + ((this.bitField0_ & 1) == 1 ? fp.f.o(1, this.name_) : 0);
            this.memoizedSerializedSize = size;
            return size;
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
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            fp.i.d<MessageType>.a aVarNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.name_);
            }
            aVarNewExtensionWriter.a(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, fVar);
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public g getDefaultInstanceForType() {
            return f21558a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public g(fp.i.c<g, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f6241a;
        }

        public g(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public g(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            boolean z10 = false;
            this.name_ = 0;
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK != 8) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.A();
                            }
                        }
                        z10 = true;
                    } catch (fp.k e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                    }
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

    public static final class h extends fp.i implements yo.j {
        public static fp.s<h> PARSER = new C0575a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f21561a;
        private List<h> andArgument_;
        private int bitField0_;
        private c constantValue_;
        private int flags_;
        private int isInstanceTypeId_;
        private q isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<h> orArgument_;
        private final fp.d unknownFields;
        private int valueParameterReference_;

        /* JADX INFO: renamed from: yo.a$h$a, reason: collision with other inner class name */
        public static class C0575a extends fp.b<h> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public h c(fp.e eVar, fp.g gVar) throws fp.k {
                return new h(eVar, gVar);
            }
        }

        public static final class b extends fp.i.b<h, b> implements yo.j {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f21562b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f21563c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21564d;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f21567g;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public c f21565e = c.TRUE;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public q f21566f = q.getDefaultInstance();

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public List<h> f21568i = Collections.emptyList();

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public List<h> f21569n = Collections.emptyList();

            public static b j() {
                return new b();
            }

            public static b n() {
                return new b();
            }

            private void x() {
            }

            public b A(q qVar) {
                if ((this.f21562b & 8) != 8 || this.f21566f == q.getDefaultInstance()) {
                    this.f21566f = qVar;
                } else {
                    this.f21566f = q.newBuilder(this.f21566f).h(qVar).r();
                }
                this.f21562b |= 8;
                return this;
            }

            public b B(c cVar) {
                cVar.getClass();
                this.f21562b |= 4;
                this.f21565e = cVar;
                return this;
            }

            public b C(int i10) {
                this.f21562b |= 1;
                this.f21563c = i10;
                return this;
            }

            public b D(int i10) {
                this.f21562b |= 16;
                this.f21567g = i10;
                return this;
            }

            public b E(int i10) {
                this.f21562b |= 2;
                this.f21564d = i10;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return h.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return h.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                if (w() && !this.f21566f.isInitialized()) {
                    return false;
                }
                for (int i10 = 0; i10 < this.f21568i.size(); i10++) {
                    if (!q(i10).isInitialized()) {
                        return false;
                    }
                }
                for (int i11 = 0; i11 < this.f21569n.size(); i11++) {
                    if (!u(i11).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public h build() {
                h hVarL = l();
                if (hVarL.isInitialized()) {
                    return hVarL;
                }
                throw new fp.w(hVarL);
            }

            public h l() {
                h hVar = new h(this);
                int i10 = this.f21562b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                hVar.flags_ = this.f21563c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                hVar.valueParameterReference_ = this.f21564d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                hVar.constantValue_ = this.f21565e;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                hVar.isInstanceType_ = this.f21566f;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                hVar.isInstanceTypeId_ = this.f21567g;
                if ((this.f21562b & 32) == 32) {
                    this.f21568i = Collections.unmodifiableList(this.f21568i);
                    this.f21562b &= -33;
                }
                hVar.andArgument_ = this.f21568i;
                if ((this.f21562b & 64) == 64) {
                    this.f21569n = Collections.unmodifiableList(this.f21569n);
                    this.f21562b &= -65;
                }
                hVar.orArgument_ = this.f21569n;
                hVar.bitField0_ = i11;
                return hVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(l());
            }

            public final void o() {
                if ((this.f21562b & 32) != 32) {
                    this.f21568i = new ArrayList(this.f21568i);
                    this.f21562b |= 32;
                }
            }

            public final void p() {
                if ((this.f21562b & 64) != 64) {
                    this.f21569n = new ArrayList(this.f21569n);
                    this.f21562b |= 64;
                }
            }

            public h q(int i10) {
                return this.f21568i.get(i10);
            }

            public int r() {
                return this.f21568i.size();
            }

            public h s() {
                return h.getDefaultInstance();
            }

            public q t() {
                return this.f21566f;
            }

            public h u(int i10) {
                return this.f21569n.get(i10);
            }

            public int v() {
                return this.f21569n.size();
            }

            public boolean w() {
                return (this.f21562b & 8) == 8;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                h hVar = null;
                try {
                    try {
                        h hVarC = h.PARSER.c(eVar, gVar);
                        if (hVarC != null) {
                            h(hVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        h hVar2 = (h) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            hVar = hVar2;
                            if (hVar != null) {
                                h(hVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (hVar != null) {
                        h(hVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public b h(h hVar) {
                if (hVar == h.getDefaultInstance()) {
                    return this;
                }
                if (hVar.hasFlags()) {
                    C(hVar.getFlags());
                }
                if (hVar.hasValueParameterReference()) {
                    E(hVar.getValueParameterReference());
                }
                if (hVar.hasConstantValue()) {
                    B(hVar.getConstantValue());
                }
                if (hVar.hasIsInstanceType()) {
                    A(hVar.getIsInstanceType());
                }
                if (hVar.hasIsInstanceTypeId()) {
                    D(hVar.getIsInstanceTypeId());
                }
                if (!hVar.andArgument_.isEmpty()) {
                    if (this.f21568i.isEmpty()) {
                        this.f21568i = hVar.andArgument_;
                        this.f21562b &= -33;
                    } else {
                        o();
                        this.f21568i.addAll(hVar.andArgument_);
                    }
                }
                if (!hVar.orArgument_.isEmpty()) {
                    if (this.f21569n.isEmpty()) {
                        this.f21569n = hVar.orArgument_;
                        this.f21562b &= -65;
                    } else {
                        p();
                        this.f21569n.addAll(hVar.orArgument_);
                    }
                }
                this.f6241a = this.f6241a.b(hVar.unknownFields);
                return this;
            }
        }

        public enum c implements fp.j.a {
            TRUE(0, 0),
            FALSE(1, 1),
            NULL(2, 2);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static fp.j.b<c> f21570a = new C0576a();
            private final int value;

            /* JADX INFO: renamed from: yo.a$h$c$a, reason: collision with other inner class name */
            public static class C0576a implements fp.j.b<c> {
                public c a(int i10) {
                    return c.valueOf(i10);
                }

                @Override // fp.j.b
                public fp.j.a findValueByNumber(int i10) {
                    return c.valueOf(i10);
                }
            }

            c(int i10, int i11) {
                this.value = i11;
            }

            @Override // fp.j.a
            public final int getNumber() {
                return this.value;
            }

            public static c valueOf(int i10) {
                if (i10 == 0) {
                    return TRUE;
                }
                if (i10 == 1) {
                    return FALSE;
                }
                if (i10 != 2) {
                    return null;
                }
                return NULL;
            }
        }

        static {
            h hVar = new h(true);
            f21561a = hVar;
            hVar.b();
        }

        private void b() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = c.TRUE;
            this.isInstanceType_ = q.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
        }

        public static h getDefaultInstance() {
            return f21561a;
        }

        public static b newBuilder(h hVar) {
            return newBuilder().h(hVar);
        }

        public h getAndArgument(int i10) {
            return this.andArgument_.get(i10);
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public c getConstantValue() {
            return this.constantValue_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public q getIsInstanceType() {
            return this.isInstanceType_;
        }

        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        public h getOrArgument(int i10) {
            return this.orArgument_.get(i10);
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        @Override // fp.i, fp.q
        public fp.s<h> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iO += fp.f.o(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iO += fp.f.h(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                iO += fp.f.s(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iO += fp.f.o(5, this.isInstanceTypeId_);
            }
            for (int i11 = 0; i11 < this.andArgument_.size(); i11++) {
                iO += fp.f.s(6, this.andArgument_.get(i11));
            }
            for (int i12 = 0; i12 < this.orArgument_.size(); i12++) {
                iO += fp.f.s(7, this.orArgument_.get(i12));
            }
            int size = this.unknownFields.size() + iO;
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        public boolean hasConstantValue() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasIsInstanceType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasIsInstanceTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasValueParameterReference() {
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
            if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i10 = 0; i10 < getAndArgumentCount(); i10++) {
                if (!getAndArgument(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i11 = 0; i11 < getOrArgumentCount(); i11++) {
                if (!getOrArgument(i11).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.S(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                fVar.d0(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                fVar.a0(5, this.isInstanceTypeId_);
            }
            for (int i10 = 0; i10 < this.andArgument_.size(); i10++) {
                fVar.d0(6, this.andArgument_.get(i10));
            }
            for (int i11 = 0; i11 < this.orArgument_.size(); i11++) {
                fVar.d0(7, this.orArgument_.get(i11));
            }
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public h getDefaultInstanceForType() {
            return f21561a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public h(fp.i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public h(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public h(fp.e eVar, fp.g gVar) throws fp.k {
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
                                this.flags_ = eVar.A();
                            } else if (iK == 16) {
                                this.bitField0_ |= 2;
                                this.valueParameterReference_ = eVar.A();
                            } else if (iK == 24) {
                                int iA = eVar.A();
                                c cVarValueOf = c.valueOf(iA);
                                if (cVarValueOf == null) {
                                    fVarJ.o0(iK);
                                    fVarJ.o0(iA);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.constantValue_ = cVarValueOf;
                                }
                            } else if (iK == 34) {
                                q.c builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                                q qVar = (q) eVar.u(q.PARSER, gVar);
                                this.isInstanceType_ = qVar;
                                if (builder != null) {
                                    builder.h(qVar);
                                    this.isInstanceType_ = builder.r();
                                }
                                this.bitField0_ |= 8;
                            } else if (iK == 40) {
                                this.bitField0_ |= 16;
                                this.isInstanceTypeId_ = eVar.A();
                            } else if (iK == 50) {
                                if ((i10 & 32) != 32) {
                                    this.andArgument_ = new ArrayList();
                                    i10 |= 32;
                                }
                                this.andArgument_.add((h) eVar.u(PARSER, gVar));
                            } else if (iK != 58) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                if ((i10 & 64) != 64) {
                                    this.orArgument_ = new ArrayList();
                                    i10 |= 64;
                                }
                                this.orArgument_.add((h) eVar.u(PARSER, gVar));
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if ((i10 & 32) == 32) {
                            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                        }
                        if ((i10 & 64) == 64) {
                            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if ((i10 & 32) == 32) {
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
            }
            if ((i10 & 64) == 64) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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

    public static final class i extends fp.i.d<i> implements yo.k {
        public static fp.s<i> PARSER = new C0577a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f21572a;
        private int bitField0_;
        private e contract_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private q receiverType_;
        private int returnTypeId_;
        private q returnType_;
        private List<s> typeParameter_;
        private t typeTable_;
        private final fp.d unknownFields;
        private List<u> valueParameter_;
        private List<Integer> versionRequirement_;

        /* JADX INFO: renamed from: yo.a$i$a, reason: collision with other inner class name */
        public static class C0577a extends fp.b<i> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public i c(fp.e eVar, fp.g gVar) throws fp.k {
                return new i(eVar, gVar);
            }
        }

        public static final class b extends fp.i.c<i, b> implements yo.k {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21573d;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f21576g;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public int f21578n;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public int f21581w;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f21574e = 6;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f21575f = 6;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public q f21577i = q.getDefaultInstance();

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public List<s> f21579p = Collections.emptyList();

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public q f21580v = q.getDefaultInstance();

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public List<u> f21582x = Collections.emptyList();

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            public t f21583y = t.getDefaultInstance();

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            public List<Integer> f21584z = Collections.emptyList();
            public e H = e.getDefaultInstance();

            private void L() {
            }

            public static b p() {
                return new b();
            }

            public static b t() {
                return new b();
            }

            private void u() {
                if ((this.f21573d & 32) != 32) {
                    this.f21579p = new ArrayList(this.f21579p);
                    this.f21573d |= 32;
                }
            }

            private void v() {
                if ((this.f21573d & 256) != 256) {
                    this.f21582x = new ArrayList(this.f21582x);
                    this.f21573d |= 256;
                }
            }

            private void w() {
                if ((this.f21573d & 1024) != 1024) {
                    this.f21584z = new ArrayList(this.f21584z);
                    this.f21573d |= 1024;
                }
            }

            public q A() {
                return this.f21577i;
            }

            public s B(int i10) {
                return this.f21579p.get(i10);
            }

            public int C() {
                return this.f21579p.size();
            }

            public t D() {
                return this.f21583y;
            }

            public u E(int i10) {
                return this.f21582x.get(i10);
            }

            public int F() {
                return this.f21582x.size();
            }

            public boolean G() {
                return (this.f21573d & 2048) == 2048;
            }

            public boolean H() {
                return (this.f21573d & 4) == 4;
            }

            public boolean I() {
                return (this.f21573d & 64) == 64;
            }

            public boolean J() {
                return (this.f21573d & 8) == 8;
            }

            public boolean K() {
                return (this.f21573d & 512) == 512;
            }

            public b M(e eVar) {
                if ((this.f21573d & 2048) != 2048 || this.H == e.getDefaultInstance()) {
                    this.H = eVar;
                } else {
                    this.H = e.newBuilder(this.H).h(eVar).l();
                }
                this.f21573d |= 2048;
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                i iVar = null;
                try {
                    try {
                        i iVarC = i.PARSER.c(eVar, gVar);
                        if (iVarC != null) {
                            h(iVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        i iVar2 = (i) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            iVar = iVar2;
                            if (iVar != null) {
                                h(iVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (iVar != null) {
                        h(iVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
            public b h(i iVar) {
                if (iVar == i.getDefaultInstance()) {
                    return this;
                }
                if (iVar.hasFlags()) {
                    S(iVar.getFlags());
                }
                if (iVar.hasOldFlags()) {
                    U(iVar.getOldFlags());
                }
                if (iVar.hasName()) {
                    T(iVar.getName());
                }
                if (iVar.hasReturnType()) {
                    Q(iVar.getReturnType());
                }
                if (iVar.hasReturnTypeId()) {
                    W(iVar.getReturnTypeId());
                }
                if (!iVar.typeParameter_.isEmpty()) {
                    if (this.f21579p.isEmpty()) {
                        this.f21579p = iVar.typeParameter_;
                        this.f21573d &= -33;
                    } else {
                        u();
                        this.f21579p.addAll(iVar.typeParameter_);
                    }
                }
                if (iVar.hasReceiverType()) {
                    P(iVar.getReceiverType());
                }
                if (iVar.hasReceiverTypeId()) {
                    V(iVar.getReceiverTypeId());
                }
                if (!iVar.valueParameter_.isEmpty()) {
                    if (this.f21582x.isEmpty()) {
                        this.f21582x = iVar.valueParameter_;
                        this.f21573d &= -257;
                    } else {
                        v();
                        this.f21582x.addAll(iVar.valueParameter_);
                    }
                }
                if (iVar.hasTypeTable()) {
                    R(iVar.getTypeTable());
                }
                if (!iVar.versionRequirement_.isEmpty()) {
                    if (this.f21584z.isEmpty()) {
                        this.f21584z = iVar.versionRequirement_;
                        this.f21573d &= -1025;
                    } else {
                        w();
                        this.f21584z.addAll(iVar.versionRequirement_);
                    }
                }
                if (iVar.hasContract()) {
                    M(iVar.getContract());
                }
                o(iVar);
                this.f6241a = this.f6241a.b(iVar.unknownFields);
                return this;
            }

            public b P(q qVar) {
                if ((this.f21573d & 64) != 64 || this.f21580v == q.getDefaultInstance()) {
                    this.f21580v = qVar;
                } else {
                    this.f21580v = q.newBuilder(this.f21580v).h(qVar).r();
                }
                this.f21573d |= 64;
                return this;
            }

            public b Q(q qVar) {
                if ((this.f21573d & 8) != 8 || this.f21577i == q.getDefaultInstance()) {
                    this.f21577i = qVar;
                } else {
                    this.f21577i = q.newBuilder(this.f21577i).h(qVar).r();
                }
                this.f21573d |= 8;
                return this;
            }

            public b R(t tVar) {
                if ((this.f21573d & 512) != 512 || this.f21583y == t.getDefaultInstance()) {
                    this.f21583y = tVar;
                } else {
                    this.f21583y = t.newBuilder(this.f21583y).h(tVar).l();
                }
                this.f21573d |= 512;
                return this;
            }

            public b S(int i10) {
                this.f21573d |= 1;
                this.f21574e = i10;
                return this;
            }

            public b T(int i10) {
                this.f21573d |= 4;
                this.f21576g = i10;
                return this;
            }

            public b U(int i10) {
                this.f21573d |= 2;
                this.f21575f = i10;
                return this;
            }

            public b V(int i10) {
                this.f21573d |= 128;
                this.f21581w = i10;
                return this;
            }

            public b W(int i10) {
                this.f21573d |= 16;
                this.f21578n = i10;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return i.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return i.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                if (!H()) {
                    return false;
                }
                if (J() && !this.f21577i.isInitialized()) {
                    return false;
                }
                for (int i10 = 0; i10 < this.f21579p.size(); i10++) {
                    if (!B(i10).isInitialized()) {
                        return false;
                    }
                }
                if (I() && !this.f21580v.isInitialized()) {
                    return false;
                }
                for (int i11 = 0; i11 < this.f21582x.size(); i11++) {
                    if (!E(i11).isInitialized()) {
                        return false;
                    }
                }
                if (!K() || this.f21583y.isInitialized()) {
                    return (!G() || this.H.isInitialized()) && this.f6242b.n();
                }
                return false;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public i build() {
                i iVarR = r();
                if (iVarR.isInitialized()) {
                    return iVarR;
                }
                throw new fp.w(iVarR);
            }

            public i r() {
                i iVar = new i(this);
                int i10 = this.f21573d;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                iVar.flags_ = this.f21574e;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                iVar.oldFlags_ = this.f21575f;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                iVar.name_ = this.f21576g;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                iVar.returnType_ = this.f21577i;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                iVar.returnTypeId_ = this.f21578n;
                if ((this.f21573d & 32) == 32) {
                    this.f21579p = Collections.unmodifiableList(this.f21579p);
                    this.f21573d &= -33;
                }
                iVar.typeParameter_ = this.f21579p;
                if ((i10 & 64) == 64) {
                    i11 |= 32;
                }
                iVar.receiverType_ = this.f21580v;
                if ((i10 & 128) == 128) {
                    i11 |= 64;
                }
                iVar.receiverTypeId_ = this.f21581w;
                if ((this.f21573d & 256) == 256) {
                    this.f21582x = Collections.unmodifiableList(this.f21582x);
                    this.f21573d &= -257;
                }
                iVar.valueParameter_ = this.f21582x;
                if ((i10 & 512) == 512) {
                    i11 |= 128;
                }
                iVar.typeTable_ = this.f21583y;
                if ((this.f21573d & 1024) == 1024) {
                    this.f21584z = Collections.unmodifiableList(this.f21584z);
                    this.f21573d &= -1025;
                }
                iVar.versionRequirement_ = this.f21584z;
                if ((i10 & 2048) == 2048) {
                    i11 |= 256;
                }
                iVar.contract_ = this.H;
                iVar.bitField0_ = i11;
                return iVar;
            }

            @Override // fp.i.c
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(r());
            }

            public e x() {
                return this.H;
            }

            public i y() {
                return i.getDefaultInstance();
            }

            public q z() {
                return this.f21580v;
            }
        }

        static {
            i iVar = new i(true);
            f21572a = iVar;
            iVar.d();
        }

        private void d() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = q.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = q.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = t.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = e.getDefaultInstance();
        }

        public static i getDefaultInstance() {
            return f21572a;
        }

        public static b newBuilder(i iVar) {
            return newBuilder().h(iVar);
        }

        public static i parseFrom(InputStream inputStream, fp.g gVar) throws IOException {
            return PARSER.b(inputStream, gVar);
        }

        public e getContract() {
            return this.contract_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // fp.i, fp.q
        public fp.s<i> getParserForType() {
            return PARSER;
        }

        public q getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public q getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 2) == 2 ? fp.f.o(1, this.oldFlags_) : 0;
            if ((this.bitField0_ & 4) == 4) {
                iO += fp.f.o(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iO += fp.f.s(3, this.returnType_);
            }
            for (int i11 = 0; i11 < this.typeParameter_.size(); i11++) {
                iO += fp.f.s(4, this.typeParameter_.get(i11));
            }
            if ((this.bitField0_ & 32) == 32) {
                iO += fp.f.s(5, this.receiverType_);
            }
            for (int i12 = 0; i12 < this.valueParameter_.size(); i12++) {
                iO += fp.f.s(6, this.valueParameter_.get(i12));
            }
            if ((this.bitField0_ & 16) == 16) {
                iO += fp.f.o(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                iO += fp.f.o(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                iO += fp.f.o(9, this.flags_);
            }
            if ((this.bitField0_ & 128) == 128) {
                iO += fp.f.s(30, this.typeTable_);
            }
            int iP = 0;
            for (int i13 = 0; i13 < this.versionRequirement_.size(); i13++) {
                iP += fp.f.p(this.versionRequirement_.get(i13).intValue());
            }
            int size = (getVersionRequirementList().size() * 2) + iO + iP;
            if ((this.bitField0_ & 256) == 256) {
                size += fp.f.s(32, this.contract_);
            }
            int size2 = this.unknownFields.size() + extensionsSerializedSize() + size;
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public s getTypeParameter(int i10) {
            return this.typeParameter_.get(i10);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<s> getTypeParameterList() {
            return this.typeParameter_;
        }

        public t getTypeTable() {
            return this.typeTable_;
        }

        public u getValueParameter(int i10) {
            return this.valueParameter_.get(i10);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<u> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasContract() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 128) == 128;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i10 = 0; i10 < getTypeParameterCount(); i10++) {
                if (!getTypeParameter(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasReceiverType() && !getReceiverType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i11 = 0; i11 < getValueParameterCount(); i11++) {
                if (!getValueParameter(i11).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasContract() && !getContract().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            fp.i.d<MessageType>.a aVarNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.a0(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                fVar.d0(3, this.returnType_);
            }
            for (int i10 = 0; i10 < this.typeParameter_.size(); i10++) {
                fVar.d0(4, this.typeParameter_.get(i10));
            }
            if ((this.bitField0_ & 32) == 32) {
                fVar.d0(5, this.receiverType_);
            }
            for (int i11 = 0; i11 < this.valueParameter_.size(); i11++) {
                fVar.d0(6, this.valueParameter_.get(i11));
            }
            if ((this.bitField0_ & 16) == 16) {
                fVar.a0(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                fVar.a0(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(9, this.flags_);
            }
            if ((this.bitField0_ & 128) == 128) {
                fVar.d0(30, this.typeTable_);
            }
            for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
                fVar.a0(31, this.versionRequirement_.get(i12).intValue());
            }
            if ((this.bitField0_ & 256) == 256) {
                fVar.d0(32, this.contract_);
            }
            aVarNewExtensionWriter.a(19000, fVar);
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public i getDefaultInstanceForType() {
            return f21572a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public i(fp.i.c<i, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f6241a;
        }

        public i(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public i(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            d();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            int i10 = 0;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        switch (iK) {
                            case 0:
                                break;
                            case 8:
                                this.bitField0_ |= 2;
                                this.oldFlags_ = eVar.A();
                                continue;
                            case 16:
                                this.bitField0_ |= 4;
                                this.name_ = eVar.A();
                                continue;
                            case 26:
                                q.c builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                q qVar = (q) eVar.u(q.PARSER, gVar);
                                this.returnType_ = qVar;
                                if (builder != null) {
                                    builder.h(qVar);
                                    this.returnType_ = builder.r();
                                }
                                this.bitField0_ |= 8;
                                continue;
                            case 34:
                                int i11 = (i10 == true ? 1 : 0) & 32;
                                i10 = i10;
                                if (i11 != 32) {
                                    this.typeParameter_ = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 32;
                                }
                                this.typeParameter_.add((s) eVar.u(s.PARSER, gVar));
                                continue;
                            case 42:
                                q.c builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                q qVar2 = (q) eVar.u(q.PARSER, gVar);
                                this.receiverType_ = qVar2;
                                if (builder2 != null) {
                                    builder2.h(qVar2);
                                    this.receiverType_ = builder2.r();
                                }
                                this.bitField0_ |= 32;
                                continue;
                            case 50:
                                int i12 = (i10 == true ? 1 : 0) & 256;
                                i10 = i10;
                                if (i12 != 256) {
                                    this.valueParameter_ = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 256;
                                }
                                this.valueParameter_.add((u) eVar.u(u.PARSER, gVar));
                                continue;
                            case 56:
                                this.bitField0_ |= 16;
                                this.returnTypeId_ = eVar.A();
                                continue;
                            case 64:
                                this.bitField0_ |= 64;
                                this.receiverTypeId_ = eVar.A();
                                continue;
                            case TabLayout.f3131k0 /* 72 */:
                                this.bitField0_ |= 1;
                                this.flags_ = eVar.A();
                                continue;
                            case 242:
                                t.b builder3 = (this.bitField0_ & 128) == 128 ? this.typeTable_.toBuilder() : null;
                                t tVar = (t) eVar.u(t.PARSER, gVar);
                                this.typeTable_ = tVar;
                                if (builder3 != null) {
                                    builder3.h(tVar);
                                    this.typeTable_ = builder3.l();
                                }
                                this.bitField0_ |= 128;
                                continue;
                            case 248:
                                int i13 = (i10 == true ? 1 : 0) & 1024;
                                i10 = i10;
                                if (i13 != 1024) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 1024;
                                }
                                this.versionRequirement_.add(Integer.valueOf(eVar.A()));
                                continue;
                            case 250:
                                int iJ = eVar.j(eVar.A());
                                int i14 = (i10 == true ? 1 : 0) & 1024;
                                i10 = i10;
                                if (i14 != 1024 && eVar.e() > 0) {
                                    i10 = i10;
                                    this.versionRequirement_ = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 1024;
                                }
                                i10 = i10;
                                while (eVar.e() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(eVar.A()));
                                }
                                eVar.i(iJ);
                                continue;
                            case 258:
                                e.b builder4 = (this.bitField0_ & 256) == 256 ? this.contract_.toBuilder() : null;
                                e eVar2 = (e) eVar.u(e.PARSER, gVar);
                                this.contract_ = eVar2;
                                if (builder4 != null) {
                                    builder4.h(eVar2);
                                    this.contract_ = builder4.l();
                                }
                                this.bitField0_ |= 256;
                                continue;
                            default:
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    break;
                                }
                                break;
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if (((i10 == true ? 1 : 0) & 32) == 32) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if (((i10 == true ? 1 : 0) & 256) == 256) {
                            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                        }
                        if (((i10 == true ? 1 : 0) & 1024) == 1024) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if (((i10 == true ? 1 : 0) & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if (((i10 == true ? 1 : 0) & 256) == 256) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
            }
            if (((i10 == true ? 1 : 0) & 1024) == 1024) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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

    public enum j implements fp.j.a {
        DECLARATION(0, 0),
        FAKE_OVERRIDE(1, 1),
        DELEGATION(2, 2),
        SYNTHESIZED(3, 3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static fp.j.b<j> f21585a = new C0578a();
        private final int value;

        /* JADX INFO: renamed from: yo.a$j$a, reason: collision with other inner class name */
        public static class C0578a implements fp.j.b<j> {
            public j a(int i10) {
                return j.valueOf(i10);
            }

            @Override // fp.j.b
            public fp.j.a findValueByNumber(int i10) {
                return j.valueOf(i10);
            }
        }

        j(int i10, int i11) {
            this.value = i11;
        }

        @Override // fp.j.a
        public final int getNumber() {
            return this.value;
        }

        public static j valueOf(int i10) {
            if (i10 == 0) {
                return DECLARATION;
            }
            if (i10 == 1) {
                return FAKE_OVERRIDE;
            }
            if (i10 == 2) {
                return DELEGATION;
            }
            if (i10 != 3) {
                return null;
            }
            return SYNTHESIZED;
        }
    }

    public enum k implements fp.j.a {
        FINAL(0, 0),
        OPEN(1, 1),
        ABSTRACT(2, 2),
        SEALED(3, 3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static fp.j.b<k> f21587a = new C0579a();
        private final int value;

        /* JADX INFO: renamed from: yo.a$k$a, reason: collision with other inner class name */
        public static class C0579a implements fp.j.b<k> {
            public k a(int i10) {
                return k.valueOf(i10);
            }

            @Override // fp.j.b
            public fp.j.a findValueByNumber(int i10) {
                return k.valueOf(i10);
            }
        }

        k(int i10, int i11) {
            this.value = i11;
        }

        @Override // fp.j.a
        public final int getNumber() {
            return this.value;
        }

        public static k valueOf(int i10) {
            if (i10 == 0) {
                return FINAL;
            }
            if (i10 == 1) {
                return OPEN;
            }
            if (i10 == 2) {
                return ABSTRACT;
            }
            if (i10 != 3) {
                return null;
            }
            return SEALED;
        }
    }

    public static final class l extends fp.i.d<l> implements yo.m {
        public static fp.s<l> PARSER = new C0580a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f21589a;
        private int bitField0_;
        private List<i> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<n> property_;
        private List<r> typeAlias_;
        private t typeTable_;
        private final fp.d unknownFields;
        private w versionRequirementTable_;

        /* JADX INFO: renamed from: yo.a$l$a, reason: collision with other inner class name */
        public static class C0580a extends fp.b<l> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public l c(fp.e eVar, fp.g gVar) throws fp.k {
                return new l(eVar, gVar);
            }
        }

        public static final class b extends fp.i.c<l, b> implements yo.m {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21590d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public List<i> f21591e = Collections.emptyList();

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public List<n> f21592f = Collections.emptyList();

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public List<r> f21593g = Collections.emptyList();

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public t f21594i = t.getDefaultInstance();

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public w f21595n = w.getDefaultInstance();

            private void G() {
            }

            public static b p() {
                return new b();
            }

            public static b t() {
                return new b();
            }

            private void u() {
                if ((this.f21590d & 1) != 1) {
                    this.f21591e = new ArrayList(this.f21591e);
                    this.f21590d |= 1;
                }
            }

            private void v() {
                if ((this.f21590d & 2) != 2) {
                    this.f21592f = new ArrayList(this.f21592f);
                    this.f21590d |= 2;
                }
            }

            private void w() {
                if ((this.f21590d & 4) != 4) {
                    this.f21593g = new ArrayList(this.f21593g);
                    this.f21590d |= 4;
                }
            }

            public n A(int i10) {
                return this.f21592f.get(i10);
            }

            public int B() {
                return this.f21592f.size();
            }

            public r C(int i10) {
                return this.f21593g.get(i10);
            }

            public int D() {
                return this.f21593g.size();
            }

            public t E() {
                return this.f21594i;
            }

            public boolean F() {
                return (this.f21590d & 8) == 8;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                l lVar = null;
                try {
                    try {
                        l lVarC = l.PARSER.c(eVar, gVar);
                        if (lVarC != null) {
                            h(lVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        l lVar2 = (l) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            lVar = lVar2;
                            if (lVar != null) {
                                h(lVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (lVar != null) {
                        h(lVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
            public b h(l lVar) {
                if (lVar == l.getDefaultInstance()) {
                    return this;
                }
                if (!lVar.function_.isEmpty()) {
                    if (this.f21591e.isEmpty()) {
                        this.f21591e = lVar.function_;
                        this.f21590d &= -2;
                    } else {
                        u();
                        this.f21591e.addAll(lVar.function_);
                    }
                }
                if (!lVar.property_.isEmpty()) {
                    if (this.f21592f.isEmpty()) {
                        this.f21592f = lVar.property_;
                        this.f21590d &= -3;
                    } else {
                        v();
                        this.f21592f.addAll(lVar.property_);
                    }
                }
                if (!lVar.typeAlias_.isEmpty()) {
                    if (this.f21593g.isEmpty()) {
                        this.f21593g = lVar.typeAlias_;
                        this.f21590d &= -5;
                    } else {
                        w();
                        this.f21593g.addAll(lVar.typeAlias_);
                    }
                }
                if (lVar.hasTypeTable()) {
                    J(lVar.getTypeTable());
                }
                if (lVar.hasVersionRequirementTable()) {
                    K(lVar.getVersionRequirementTable());
                }
                o(lVar);
                this.f6241a = this.f6241a.b(lVar.unknownFields);
                return this;
            }

            public b J(t tVar) {
                if ((this.f21590d & 8) != 8 || this.f21594i == t.getDefaultInstance()) {
                    this.f21594i = tVar;
                } else {
                    this.f21594i = t.newBuilder(this.f21594i).h(tVar).l();
                }
                this.f21590d |= 8;
                return this;
            }

            public b K(w wVar) {
                if ((this.f21590d & 16) != 16 || this.f21595n == w.getDefaultInstance()) {
                    this.f21595n = wVar;
                } else {
                    this.f21595n = w.newBuilder(this.f21595n).h(wVar).l();
                }
                this.f21590d |= 16;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return l.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return l.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < this.f21591e.size(); i10++) {
                    if (!y(i10).isInitialized()) {
                        return false;
                    }
                }
                for (int i11 = 0; i11 < this.f21592f.size(); i11++) {
                    if (!A(i11).isInitialized()) {
                        return false;
                    }
                }
                for (int i12 = 0; i12 < this.f21593g.size(); i12++) {
                    if (!C(i12).isInitialized()) {
                        return false;
                    }
                }
                return (!F() || this.f21594i.isInitialized()) && this.f6242b.n();
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public l build() {
                l lVarR = r();
                if (lVarR.isInitialized()) {
                    return lVarR;
                }
                throw new fp.w(lVarR);
            }

            public l r() {
                l lVar = new l(this);
                int i10 = this.f21590d;
                if ((i10 & 1) == 1) {
                    this.f21591e = Collections.unmodifiableList(this.f21591e);
                    this.f21590d &= -2;
                }
                lVar.function_ = this.f21591e;
                if ((this.f21590d & 2) == 2) {
                    this.f21592f = Collections.unmodifiableList(this.f21592f);
                    this.f21590d &= -3;
                }
                lVar.property_ = this.f21592f;
                if ((this.f21590d & 4) == 4) {
                    this.f21593g = Collections.unmodifiableList(this.f21593g);
                    this.f21590d &= -5;
                }
                lVar.typeAlias_ = this.f21593g;
                int i11 = (i10 & 8) != 8 ? 0 : 1;
                lVar.typeTable_ = this.f21594i;
                if ((i10 & 16) == 16) {
                    i11 |= 2;
                }
                lVar.versionRequirementTable_ = this.f21595n;
                lVar.bitField0_ = i11;
                return lVar;
            }

            @Override // fp.i.c
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(r());
            }

            public l x() {
                return l.getDefaultInstance();
            }

            public i y(int i10) {
                return this.f21591e.get(i10);
            }

            public int z() {
                return this.f21591e.size();
            }
        }

        static {
            l lVar = new l(true);
            f21589a = lVar;
            lVar.d();
        }

        private void d() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = t.getDefaultInstance();
            this.versionRequirementTable_ = w.getDefaultInstance();
        }

        public static l getDefaultInstance() {
            return f21589a;
        }

        public static b newBuilder(l lVar) {
            return newBuilder().h(lVar);
        }

        public static l parseFrom(InputStream inputStream, fp.g gVar) throws IOException {
            return PARSER.b(inputStream, gVar);
        }

        public i getFunction(int i10) {
            return this.function_.get(i10);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<i> getFunctionList() {
            return this.function_;
        }

        @Override // fp.i, fp.q
        public fp.s<l> getParserForType() {
            return PARSER;
        }

        public n getProperty(int i10) {
            return this.property_.get(i10);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<n> getPropertyList() {
            return this.property_;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iS = 0;
            for (int i11 = 0; i11 < this.function_.size(); i11++) {
                iS += fp.f.s(3, this.function_.get(i11));
            }
            for (int i12 = 0; i12 < this.property_.size(); i12++) {
                iS += fp.f.s(4, this.property_.get(i12));
            }
            for (int i13 = 0; i13 < this.typeAlias_.size(); i13++) {
                iS += fp.f.s(5, this.typeAlias_.get(i13));
            }
            if ((this.bitField0_ & 1) == 1) {
                iS += fp.f.s(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                iS += fp.f.s(32, this.versionRequirementTable_);
            }
            int size = this.unknownFields.size() + extensionsSerializedSize() + iS;
            this.memoizedSerializedSize = size;
            return size;
        }

        public r getTypeAlias(int i10) {
            return this.typeAlias_.get(i10);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<r> getTypeAliasList() {
            return this.typeAlias_;
        }

        public t getTypeTable() {
            return this.typeTable_;
        }

        public w getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasVersionRequirementTable() {
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
            for (int i10 = 0; i10 < getFunctionCount(); i10++) {
                if (!getFunction(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i11 = 0; i11 < getPropertyCount(); i11++) {
                if (!getProperty(i11).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i12 = 0; i12 < getTypeAliasCount(); i12++) {
                if (!getTypeAlias(i12).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            fp.i.d<MessageType>.a aVarNewExtensionWriter = newExtensionWriter();
            for (int i10 = 0; i10 < this.function_.size(); i10++) {
                fVar.d0(3, this.function_.get(i10));
            }
            for (int i11 = 0; i11 < this.property_.size(); i11++) {
                fVar.d0(4, this.property_.get(i11));
            }
            for (int i12 = 0; i12 < this.typeAlias_.size(); i12++) {
                fVar.d0(5, this.typeAlias_.get(i12));
            }
            if ((this.bitField0_ & 1) == 1) {
                fVar.d0(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.d0(32, this.versionRequirementTable_);
            }
            aVarNewExtensionWriter.a(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, fVar);
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public l getDefaultInstanceForType() {
            return f21589a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public l(fp.i.c<l, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f6241a;
        }

        public l(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public l(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            d();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            int i10 = 0;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 26) {
                                int i11 = (i10 == true ? 1 : 0) & 1;
                                i10 = i10;
                                if (i11 != 1) {
                                    this.function_ = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 1;
                                }
                                this.function_.add((i) eVar.u(i.PARSER, gVar));
                            } else if (iK == 34) {
                                int i12 = (i10 == true ? 1 : 0) & 2;
                                i10 = i10;
                                if (i12 != 2) {
                                    this.property_ = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 2;
                                }
                                this.property_.add((n) eVar.u(n.PARSER, gVar));
                            } else if (iK != 42) {
                                if (iK == 242) {
                                    t.b builder = (this.bitField0_ & 1) == 1 ? this.typeTable_.toBuilder() : null;
                                    t tVar = (t) eVar.u(t.PARSER, gVar);
                                    this.typeTable_ = tVar;
                                    if (builder != null) {
                                        builder.h(tVar);
                                        this.typeTable_ = builder.l();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (iK != 258) {
                                    if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    }
                                } else {
                                    w.b builder2 = (this.bitField0_ & 2) == 2 ? this.versionRequirementTable_.toBuilder() : null;
                                    w wVar = (w) eVar.u(w.PARSER, gVar);
                                    this.versionRequirementTable_ = wVar;
                                    if (builder2 != null) {
                                        builder2.h(wVar);
                                        this.versionRequirementTable_ = builder2.l();
                                    }
                                    this.bitField0_ |= 2;
                                }
                            } else {
                                int i13 = (i10 == true ? 1 : 0) & 4;
                                i10 = i10;
                                if (i13 != 4) {
                                    this.typeAlias_ = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 4;
                                }
                                this.typeAlias_.add((r) eVar.u(r.PARSER, gVar));
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if (((i10 == true ? 1 : 0) & 1) == 1) {
                            this.function_ = Collections.unmodifiableList(this.function_);
                        }
                        if (((i10 == true ? 1 : 0) & 2) == 2) {
                            this.property_ = Collections.unmodifiableList(this.property_);
                        }
                        if (((i10 == true ? 1 : 0) & 4) == 4) {
                            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if (((i10 == true ? 1 : 0) & 1) == 1) {
                this.function_ = Collections.unmodifiableList(this.function_);
            }
            if (((i10 == true ? 1 : 0) & 2) == 2) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            if (((i10 == true ? 1 : 0) & 4) == 4) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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

    public static final class m extends fp.i.d<m> implements yo.l {
        public static fp.s<m> PARSER = new C0581a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f21596a;
        private int bitField0_;
        private List<c> class__;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private l package_;
        private o qualifiedNames_;
        private p strings_;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: yo.a$m$a, reason: collision with other inner class name */
        public static class C0581a extends fp.b<m> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public m c(fp.e eVar, fp.g gVar) throws fp.k {
                return new m(eVar, gVar);
            }
        }

        public static final class b extends fp.i.c<m, b> implements yo.l {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21597d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public p f21598e = p.getDefaultInstance();

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public o f21599f = o.getDefaultInstance();

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public l f21600g = l.getDefaultInstance();

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public List<c> f21601i = Collections.emptyList();

            private void C() {
            }

            public static b p() {
                return new b();
            }

            public static b t() {
                return new b();
            }

            public boolean A() {
                return (this.f21597d & 4) == 4;
            }

            public boolean B() {
                return (this.f21597d & 2) == 2;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                m mVar = null;
                try {
                    try {
                        m mVarC = m.PARSER.c(eVar, gVar);
                        if (mVarC != null) {
                            h(mVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        m mVar2 = (m) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            mVar = mVar2;
                            if (mVar != null) {
                                h(mVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (mVar != null) {
                        h(mVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
            public b h(m mVar) {
                if (mVar == m.getDefaultInstance()) {
                    return this;
                }
                if (mVar.hasStrings()) {
                    H(mVar.getStrings());
                }
                if (mVar.hasQualifiedNames()) {
                    G(mVar.getQualifiedNames());
                }
                if (mVar.hasPackage()) {
                    F(mVar.getPackage());
                }
                if (!mVar.class__.isEmpty()) {
                    if (this.f21601i.isEmpty()) {
                        this.f21601i = mVar.class__;
                        this.f21597d &= -9;
                    } else {
                        u();
                        this.f21601i.addAll(mVar.class__);
                    }
                }
                o(mVar);
                this.f6241a = this.f6241a.b(mVar.unknownFields);
                return this;
            }

            public b F(l lVar) {
                if ((this.f21597d & 4) != 4 || this.f21600g == l.getDefaultInstance()) {
                    this.f21600g = lVar;
                } else {
                    this.f21600g = l.newBuilder(this.f21600g).h(lVar).r();
                }
                this.f21597d |= 4;
                return this;
            }

            public b G(o oVar) {
                if ((this.f21597d & 2) != 2 || this.f21599f == o.getDefaultInstance()) {
                    this.f21599f = oVar;
                } else {
                    this.f21599f = o.newBuilder(this.f21599f).h(oVar).l();
                }
                this.f21597d |= 2;
                return this;
            }

            public b H(p pVar) {
                if ((this.f21597d & 1) != 1 || this.f21598e == p.getDefaultInstance()) {
                    this.f21598e = pVar;
                } else {
                    this.f21598e = p.newBuilder(this.f21598e).h(pVar).l();
                }
                this.f21597d |= 1;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return m.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return m.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                if (B() && !this.f21599f.isInitialized()) {
                    return false;
                }
                if (A() && !this.f21600g.isInitialized()) {
                    return false;
                }
                for (int i10 = 0; i10 < this.f21601i.size(); i10++) {
                    if (!v(i10).isInitialized()) {
                        return false;
                    }
                }
                return this.f6242b.n();
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public m build() {
                m mVarR = r();
                if (mVarR.isInitialized()) {
                    return mVarR;
                }
                throw new fp.w(mVarR);
            }

            public m r() {
                m mVar = new m(this);
                int i10 = this.f21597d;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                mVar.strings_ = this.f21598e;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                mVar.qualifiedNames_ = this.f21599f;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                mVar.package_ = this.f21600g;
                if ((this.f21597d & 8) == 8) {
                    this.f21601i = Collections.unmodifiableList(this.f21601i);
                    this.f21597d &= -9;
                }
                mVar.class__ = this.f21601i;
                mVar.bitField0_ = i11;
                return mVar;
            }

            @Override // fp.i.c
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(r());
            }

            public final void u() {
                if ((this.f21597d & 8) != 8) {
                    this.f21601i = new ArrayList(this.f21601i);
                    this.f21597d |= 8;
                }
            }

            public c v(int i10) {
                return this.f21601i.get(i10);
            }

            public int w() {
                return this.f21601i.size();
            }

            public m x() {
                return m.getDefaultInstance();
            }

            public l y() {
                return this.f21600g;
            }

            public o z() {
                return this.f21599f;
            }
        }

        static {
            m mVar = new m(true);
            f21596a = mVar;
            mVar.d();
        }

        private void d() {
            this.strings_ = p.getDefaultInstance();
            this.qualifiedNames_ = o.getDefaultInstance();
            this.package_ = l.getDefaultInstance();
            this.class__ = Collections.emptyList();
        }

        public static m getDefaultInstance() {
            return f21596a;
        }

        public static b newBuilder(m mVar) {
            return newBuilder().h(mVar);
        }

        public static m parseFrom(InputStream inputStream, fp.g gVar) throws IOException {
            return PARSER.b(inputStream, gVar);
        }

        public c getClass_(int i10) {
            return this.class__.get(i10);
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public List<c> getClass_List() {
            return this.class__;
        }

        public l getPackage() {
            return this.package_;
        }

        @Override // fp.i, fp.q
        public fp.s<m> getParserForType() {
            return PARSER;
        }

        public o getQualifiedNames() {
            return this.qualifiedNames_;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iS = (this.bitField0_ & 1) == 1 ? fp.f.s(1, this.strings_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iS += fp.f.s(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iS += fp.f.s(3, this.package_);
            }
            for (int i11 = 0; i11 < this.class__.size(); i11++) {
                iS += fp.f.s(4, this.class__.get(i11));
            }
            int size = this.unknownFields.size() + extensionsSerializedSize() + iS;
            this.memoizedSerializedSize = size;
            return size;
        }

        public p getStrings() {
            return this.strings_;
        }

        public boolean hasPackage() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasQualifiedNames() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasStrings() {
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
            if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasPackage() && !getPackage().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i10 = 0; i10 < getClass_Count(); i10++) {
                if (!getClass_(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            fp.i.d<MessageType>.a aVarNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                fVar.d0(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.d0(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.d0(3, this.package_);
            }
            for (int i10 = 0; i10 < this.class__.size(); i10++) {
                fVar.d0(4, this.class__.get(i10));
            }
            aVarNewExtensionWriter.a(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, fVar);
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public m getDefaultInstanceForType() {
            return f21596a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public m(fp.i.c<m, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f6241a;
        }

        public m(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public m(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            d();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            char c10 = 0;
            while (!z10) {
                try {
                    try {
                        try {
                            int iK = eVar.K();
                            if (iK != 0) {
                                if (iK == 10) {
                                    p.b builder = (this.bitField0_ & 1) == 1 ? this.strings_.toBuilder() : null;
                                    p pVar = (p) eVar.u(p.PARSER, gVar);
                                    this.strings_ = pVar;
                                    if (builder != null) {
                                        builder.h(pVar);
                                        this.strings_ = builder.l();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (iK == 18) {
                                    o.b builder2 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.toBuilder() : null;
                                    o oVar = (o) eVar.u(o.PARSER, gVar);
                                    this.qualifiedNames_ = oVar;
                                    if (builder2 != null) {
                                        builder2.h(oVar);
                                        this.qualifiedNames_ = builder2.l();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (iK == 26) {
                                    l.b builder3 = (this.bitField0_ & 4) == 4 ? this.package_.toBuilder() : null;
                                    l lVar = (l) eVar.u(l.PARSER, gVar);
                                    this.package_ = lVar;
                                    if (builder3 != null) {
                                        builder3.h(lVar);
                                        this.package_ = builder3.r();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (iK != 34) {
                                    if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    }
                                } else {
                                    int i10 = (c10 == true ? 1 : 0) & '\b';
                                    c10 = c10;
                                    if (i10 != 8) {
                                        this.class__ = new ArrayList();
                                        c10 = '\b';
                                    }
                                    this.class__.add((c) eVar.u(c.PARSER, gVar));
                                }
                            }
                            z10 = true;
                        } catch (fp.k e10) {
                            throw e10.setUnfinishedMessage(this);
                        }
                    } catch (IOException e11) {
                        throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th2) {
                    if (((c10 == true ? 1 : 0) & '\b') == 8) {
                        this.class__ = Collections.unmodifiableList(this.class__);
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
            if (((c10 == true ? 1 : 0) & '\b') == 8) {
                this.class__ = Collections.unmodifiableList(this.class__);
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

    public static final class n extends fp.i.d<n> implements yo.n {
        public static fp.s<n> PARSER = new C0582a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f21602a;
        private int bitField0_;
        private int flags_;
        private int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private q receiverType_;
        private int returnTypeId_;
        private q returnType_;
        private int setterFlags_;
        private u setterValueParameter_;
        private List<s> typeParameter_;
        private final fp.d unknownFields;
        private List<Integer> versionRequirement_;

        /* JADX INFO: renamed from: yo.a$n$a, reason: collision with other inner class name */
        public static class C0582a extends fp.b<n> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public n c(fp.e eVar, fp.g gVar) throws fp.k {
                return new n(eVar, gVar);
            }
        }

        public static final class b extends fp.i.c<n, b> implements yo.n {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21603d;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f21606g;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public int f21608n;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public int f21611w;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            public int f21613y;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            public int f21614z;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f21604e = 518;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f21605f = 2054;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public q f21607i = q.getDefaultInstance();

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public List<s> f21609p = Collections.emptyList();

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public q f21610v = q.getDefaultInstance();

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public u f21612x = u.getDefaultInstance();
            public List<Integer> H = Collections.emptyList();

            private void G() {
            }

            public static b p() {
                return new b();
            }

            public static b t() {
                return new b();
            }

            private void u() {
                if ((this.f21603d & 32) != 32) {
                    this.f21609p = new ArrayList(this.f21609p);
                    this.f21603d |= 32;
                }
            }

            private void v() {
                if ((this.f21603d & 2048) != 2048) {
                    this.H = new ArrayList(this.H);
                    this.f21603d |= 2048;
                }
            }

            public s A(int i10) {
                return this.f21609p.get(i10);
            }

            public int B() {
                return this.f21609p.size();
            }

            public boolean C() {
                return (this.f21603d & 4) == 4;
            }

            public boolean D() {
                return (this.f21603d & 64) == 64;
            }

            public boolean E() {
                return (this.f21603d & 8) == 8;
            }

            public boolean F() {
                return (this.f21603d & 256) == 256;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                n nVar = null;
                try {
                    try {
                        n nVarC = n.PARSER.c(eVar, gVar);
                        if (nVarC != null) {
                            h(nVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        n nVar2 = (n) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            nVar = nVar2;
                            if (nVar != null) {
                                h(nVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (nVar != null) {
                        h(nVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
            public b h(n nVar) {
                if (nVar == n.getDefaultInstance()) {
                    return this;
                }
                if (nVar.hasFlags()) {
                    M(nVar.getFlags());
                }
                if (nVar.hasOldFlags()) {
                    P(nVar.getOldFlags());
                }
                if (nVar.hasName()) {
                    O(nVar.getName());
                }
                if (nVar.hasReturnType()) {
                    K(nVar.getReturnType());
                }
                if (nVar.hasReturnTypeId()) {
                    R(nVar.getReturnTypeId());
                }
                if (!nVar.typeParameter_.isEmpty()) {
                    if (this.f21609p.isEmpty()) {
                        this.f21609p = nVar.typeParameter_;
                        this.f21603d &= -33;
                    } else {
                        u();
                        this.f21609p.addAll(nVar.typeParameter_);
                    }
                }
                if (nVar.hasReceiverType()) {
                    J(nVar.getReceiverType());
                }
                if (nVar.hasReceiverTypeId()) {
                    Q(nVar.getReceiverTypeId());
                }
                if (nVar.hasSetterValueParameter()) {
                    L(nVar.getSetterValueParameter());
                }
                if (nVar.hasGetterFlags()) {
                    N(nVar.getGetterFlags());
                }
                if (nVar.hasSetterFlags()) {
                    S(nVar.getSetterFlags());
                }
                if (!nVar.versionRequirement_.isEmpty()) {
                    if (this.H.isEmpty()) {
                        this.H = nVar.versionRequirement_;
                        this.f21603d &= -2049;
                    } else {
                        v();
                        this.H.addAll(nVar.versionRequirement_);
                    }
                }
                o(nVar);
                this.f6241a = this.f6241a.b(nVar.unknownFields);
                return this;
            }

            public b J(q qVar) {
                if ((this.f21603d & 64) != 64 || this.f21610v == q.getDefaultInstance()) {
                    this.f21610v = qVar;
                } else {
                    this.f21610v = q.newBuilder(this.f21610v).h(qVar).r();
                }
                this.f21603d |= 64;
                return this;
            }

            public b K(q qVar) {
                if ((this.f21603d & 8) != 8 || this.f21607i == q.getDefaultInstance()) {
                    this.f21607i = qVar;
                } else {
                    this.f21607i = q.newBuilder(this.f21607i).h(qVar).r();
                }
                this.f21603d |= 8;
                return this;
            }

            public b L(u uVar) {
                if ((this.f21603d & 256) != 256 || this.f21612x == u.getDefaultInstance()) {
                    this.f21612x = uVar;
                } else {
                    this.f21612x = u.newBuilder(this.f21612x).h(uVar).r();
                }
                this.f21603d |= 256;
                return this;
            }

            public b M(int i10) {
                this.f21603d |= 1;
                this.f21604e = i10;
                return this;
            }

            public b N(int i10) {
                this.f21603d |= 512;
                this.f21613y = i10;
                return this;
            }

            public b O(int i10) {
                this.f21603d |= 4;
                this.f21606g = i10;
                return this;
            }

            public b P(int i10) {
                this.f21603d |= 2;
                this.f21605f = i10;
                return this;
            }

            public b Q(int i10) {
                this.f21603d |= 128;
                this.f21611w = i10;
                return this;
            }

            public b R(int i10) {
                this.f21603d |= 16;
                this.f21608n = i10;
                return this;
            }

            public b S(int i10) {
                this.f21603d |= 1024;
                this.f21614z = i10;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return n.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return n.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                if (!C()) {
                    return false;
                }
                if (E() && !this.f21607i.isInitialized()) {
                    return false;
                }
                for (int i10 = 0; i10 < this.f21609p.size(); i10++) {
                    if (!A(i10).isInitialized()) {
                        return false;
                    }
                }
                if (!D() || this.f21610v.isInitialized()) {
                    return (!F() || this.f21612x.isInitialized()) && this.f6242b.n();
                }
                return false;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public n build() {
                n nVarR = r();
                if (nVarR.isInitialized()) {
                    return nVarR;
                }
                throw new fp.w(nVarR);
            }

            public n r() {
                n nVar = new n(this);
                int i10 = this.f21603d;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                nVar.flags_ = this.f21604e;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                nVar.oldFlags_ = this.f21605f;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                nVar.name_ = this.f21606g;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                nVar.returnType_ = this.f21607i;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                nVar.returnTypeId_ = this.f21608n;
                if ((this.f21603d & 32) == 32) {
                    this.f21609p = Collections.unmodifiableList(this.f21609p);
                    this.f21603d &= -33;
                }
                nVar.typeParameter_ = this.f21609p;
                if ((i10 & 64) == 64) {
                    i11 |= 32;
                }
                nVar.receiverType_ = this.f21610v;
                if ((i10 & 128) == 128) {
                    i11 |= 64;
                }
                nVar.receiverTypeId_ = this.f21611w;
                if ((i10 & 256) == 256) {
                    i11 |= 128;
                }
                nVar.setterValueParameter_ = this.f21612x;
                if ((i10 & 512) == 512) {
                    i11 |= 256;
                }
                nVar.getterFlags_ = this.f21613y;
                if ((i10 & 1024) == 1024) {
                    i11 |= 512;
                }
                nVar.setterFlags_ = this.f21614z;
                if ((this.f21603d & 2048) == 2048) {
                    this.H = Collections.unmodifiableList(this.H);
                    this.f21603d &= -2049;
                }
                nVar.versionRequirement_ = this.H;
                nVar.bitField0_ = i11;
                return nVar;
            }

            @Override // fp.i.c
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(r());
            }

            public n w() {
                return n.getDefaultInstance();
            }

            public q x() {
                return this.f21610v;
            }

            public q y() {
                return this.f21607i;
            }

            public u z() {
                return this.f21612x;
            }
        }

        static {
            n nVar = new n(true);
            f21602a = nVar;
            nVar.d();
        }

        private void d() {
            this.flags_ = 518;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = q.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = q.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.setterValueParameter_ = u.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
        }

        public static n getDefaultInstance() {
            return f21602a;
        }

        public static b newBuilder(n nVar) {
            return newBuilder().h(nVar);
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getGetterFlags() {
            return this.getterFlags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // fp.i, fp.q
        public fp.s<n> getParserForType() {
            return PARSER;
        }

        public q getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public q getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 2) == 2 ? fp.f.o(1, this.oldFlags_) : 0;
            if ((this.bitField0_ & 4) == 4) {
                iO += fp.f.o(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iO += fp.f.s(3, this.returnType_);
            }
            for (int i11 = 0; i11 < this.typeParameter_.size(); i11++) {
                iO += fp.f.s(4, this.typeParameter_.get(i11));
            }
            if ((this.bitField0_ & 32) == 32) {
                iO += fp.f.s(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                iO += fp.f.s(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                iO += fp.f.o(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                iO += fp.f.o(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iO += fp.f.o(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                iO += fp.f.o(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                iO += fp.f.o(11, this.flags_);
            }
            int iP = 0;
            for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
                iP += fp.f.p(this.versionRequirement_.get(i12).intValue());
            }
            int size = this.unknownFields.size() + extensionsSerializedSize() + (getVersionRequirementList().size() * 2) + iO + iP;
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public u getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public s getTypeParameter(int i10) {
            return this.typeParameter_.get(i10);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<s> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetterFlags() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasSetterFlags() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasSetterValueParameter() {
            return (this.bitField0_ & 128) == 128;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i10 = 0; i10 < getTypeParameterCount(); i10++) {
                if (!getTypeParameter(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasReceiverType() && !getReceiverType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            fp.i.d<MessageType>.a aVarNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.a0(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                fVar.d0(3, this.returnType_);
            }
            for (int i10 = 0; i10 < this.typeParameter_.size(); i10++) {
                fVar.d0(4, this.typeParameter_.get(i10));
            }
            if ((this.bitField0_ & 32) == 32) {
                fVar.d0(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                fVar.d0(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                fVar.a0(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                fVar.a0(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                fVar.a0(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                fVar.a0(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(11, this.flags_);
            }
            for (int i11 = 0; i11 < this.versionRequirement_.size(); i11++) {
                fVar.a0(31, this.versionRequirement_.get(i11).intValue());
            }
            aVarNewExtensionWriter.a(19000, fVar);
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public n getDefaultInstanceForType() {
            return f21602a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public n(fp.i.c<n, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f6241a;
        }

        public n(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public n(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            d();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            int i10 = 0;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        switch (iK) {
                            case 0:
                                break;
                            case 8:
                                this.bitField0_ |= 2;
                                this.oldFlags_ = eVar.A();
                                continue;
                            case 16:
                                this.bitField0_ |= 4;
                                this.name_ = eVar.A();
                                continue;
                            case 26:
                                q.c builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                q qVar = (q) eVar.u(q.PARSER, gVar);
                                this.returnType_ = qVar;
                                if (builder != null) {
                                    builder.h(qVar);
                                    this.returnType_ = builder.r();
                                }
                                this.bitField0_ |= 8;
                                continue;
                            case 34:
                                int i11 = (i10 == true ? 1 : 0) & 32;
                                i10 = i10;
                                if (i11 != 32) {
                                    this.typeParameter_ = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 32;
                                }
                                this.typeParameter_.add((s) eVar.u(s.PARSER, gVar));
                                continue;
                            case 42:
                                q.c builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                q qVar2 = (q) eVar.u(q.PARSER, gVar);
                                this.receiverType_ = qVar2;
                                if (builder2 != null) {
                                    builder2.h(qVar2);
                                    this.receiverType_ = builder2.r();
                                }
                                this.bitField0_ |= 32;
                                continue;
                            case 50:
                                u.b builder3 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : null;
                                u uVar = (u) eVar.u(u.PARSER, gVar);
                                this.setterValueParameter_ = uVar;
                                if (builder3 != null) {
                                    builder3.h(uVar);
                                    this.setterValueParameter_ = builder3.r();
                                }
                                this.bitField0_ |= 128;
                                continue;
                            case 56:
                                this.bitField0_ |= 256;
                                this.getterFlags_ = eVar.A();
                                continue;
                            case 64:
                                this.bitField0_ |= 512;
                                this.setterFlags_ = eVar.A();
                                continue;
                            case TabLayout.f3131k0 /* 72 */:
                                this.bitField0_ |= 16;
                                this.returnTypeId_ = eVar.A();
                                continue;
                            case 80:
                                this.bitField0_ |= 64;
                                this.receiverTypeId_ = eVar.A();
                                continue;
                            case 88:
                                this.bitField0_ |= 1;
                                this.flags_ = eVar.A();
                                continue;
                            case 248:
                                int i12 = (i10 == true ? 1 : 0) & 2048;
                                i10 = i10;
                                if (i12 != 2048) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 2048;
                                }
                                this.versionRequirement_.add(Integer.valueOf(eVar.A()));
                                continue;
                            case 250:
                                int iJ = eVar.j(eVar.A());
                                int i13 = (i10 == true ? 1 : 0) & 2048;
                                i10 = i10;
                                if (i13 != 2048 && eVar.e() > 0) {
                                    i10 = i10;
                                    this.versionRequirement_ = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 2048;
                                }
                                i10 = i10;
                                while (eVar.e() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(eVar.A()));
                                }
                                eVar.i(iJ);
                                continue;
                            default:
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    break;
                                }
                                break;
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if (((i10 == true ? 1 : 0) & 32) == 32) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if (((i10 == true ? 1 : 0) & 2048) == 2048) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if (((i10 == true ? 1 : 0) & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if (((i10 == true ? 1 : 0) & 2048) == 2048) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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

    public static final class o extends fp.i implements yo.p {
        public static fp.s<o> PARSER = new C0583a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f21615a;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<c> qualifiedName_;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: yo.a$o$a, reason: collision with other inner class name */
        public static class C0583a extends fp.b<o> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public o c(fp.e eVar, fp.g gVar) throws fp.k {
                return new o(eVar, gVar);
            }
        }

        public static final class b extends fp.i.b<o, b> implements yo.p {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f21616b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public List<c> f21617c = Collections.emptyList();

            public static b j() {
                return new b();
            }

            public static b n() {
                return new b();
            }

            private void s() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return o.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return o.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < this.f21617c.size(); i10++) {
                    if (!q(i10).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public o build() {
                o oVarL = l();
                if (oVarL.isInitialized()) {
                    return oVarL;
                }
                throw new fp.w(oVarL);
            }

            public o l() {
                o oVar = new o(this);
                if ((this.f21616b & 1) == 1) {
                    this.f21617c = Collections.unmodifiableList(this.f21617c);
                    this.f21616b &= -2;
                }
                oVar.qualifiedName_ = this.f21617c;
                return oVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(l());
            }

            public final void o() {
                if ((this.f21616b & 1) != 1) {
                    this.f21617c = new ArrayList(this.f21617c);
                    this.f21616b |= 1;
                }
            }

            public o p() {
                return o.getDefaultInstance();
            }

            public c q(int i10) {
                return this.f21617c.get(i10);
            }

            public int r() {
                return this.f21617c.size();
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                o oVar = null;
                try {
                    try {
                        o oVarC = o.PARSER.c(eVar, gVar);
                        if (oVarC != null) {
                            h(oVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        o oVar2 = (o) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            oVar = oVar2;
                            if (oVar != null) {
                                h(oVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (oVar != null) {
                        h(oVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public b h(o oVar) {
                if (oVar == o.getDefaultInstance()) {
                    return this;
                }
                if (!oVar.qualifiedName_.isEmpty()) {
                    if (this.f21617c.isEmpty()) {
                        this.f21617c = oVar.qualifiedName_;
                        this.f21616b &= -2;
                    } else {
                        o();
                        this.f21617c.addAll(oVar.qualifiedName_);
                    }
                }
                this.f6241a = this.f6241a.b(oVar.unknownFields);
                return this;
            }
        }

        public static final class c extends fp.i implements yo.o {
            public static fp.s<c> PARSER = new C0584a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f21618a;
            private int bitField0_;
            private EnumC0585c kind_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int parentQualifiedName_;
            private int shortName_;
            private final fp.d unknownFields;

            /* JADX INFO: renamed from: yo.a$o$c$a, reason: collision with other inner class name */
            public static class C0584a extends fp.b<c> {
                @Override // fp.s
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public c c(fp.e eVar, fp.g gVar) throws fp.k {
                    return new c(eVar, gVar);
                }
            }

            public static final class b extends fp.i.b<c, b> implements yo.o {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public int f21619b;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public int f21621d;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public int f21620c = -1;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public EnumC0585c f21622e = EnumC0585c.PACKAGE;

                public static b j() {
                    return new b();
                }

                public static b n() {
                    return new b();
                }

                private void q() {
                }

                @Override // fp.i.b
                /* JADX INFO: renamed from: f */
                public fp.i getDefaultInstanceForType() {
                    return c.getDefaultInstance();
                }

                @Override // fp.i.b, fp.r
                public fp.q getDefaultInstanceForType() {
                    return c.getDefaultInstance();
                }

                @Override // fp.r
                public final boolean isInitialized() {
                    return p();
                }

                @Override // fp.q.a
                /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
                public c build() {
                    c cVarL = l();
                    if (cVarL.isInitialized()) {
                        return cVarL;
                    }
                    throw new fp.w(cVarL);
                }

                public c l() {
                    c cVar = new c(this);
                    int i10 = this.f21619b;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    cVar.parentQualifiedName_ = this.f21620c;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    cVar.shortName_ = this.f21621d;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    cVar.kind_ = this.f21622e;
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

                public boolean p() {
                    return (this.f21619b & 2) == 2;
                }

                /* JADX WARN: Code duplicated, block: B:15:0x001d  */
                @Override // fp.a.AbstractC0147a, fp.q.a
                /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
                public b c(fp.e eVar, fp.g gVar) throws Throwable {
                    c cVar = null;
                    try {
                        try {
                            c cVarC = c.PARSER.c(eVar, gVar);
                            if (cVarC != null) {
                                h(cVarC);
                            }
                            return this;
                        } catch (fp.k e10) {
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

                @Override // fp.i.b
                /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
                public b h(c cVar) {
                    if (cVar == c.getDefaultInstance()) {
                        return this;
                    }
                    if (cVar.hasParentQualifiedName()) {
                        u(cVar.getParentQualifiedName());
                    }
                    if (cVar.hasShortName()) {
                        v(cVar.getShortName());
                    }
                    if (cVar.hasKind()) {
                        t(cVar.getKind());
                    }
                    this.f6241a = this.f6241a.b(cVar.unknownFields);
                    return this;
                }

                public b t(EnumC0585c enumC0585c) {
                    enumC0585c.getClass();
                    this.f21619b |= 4;
                    this.f21622e = enumC0585c;
                    return this;
                }

                public b u(int i10) {
                    this.f21619b |= 1;
                    this.f21620c = i10;
                    return this;
                }

                public b v(int i10) {
                    this.f21619b |= 2;
                    this.f21621d = i10;
                    return this;
                }
            }

            /* JADX INFO: renamed from: yo.a$o$c$c, reason: collision with other inner class name */
            public enum EnumC0585c implements fp.j.a {
                CLASS(0, 0),
                PACKAGE(1, 1),
                LOCAL(2, 2);


                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static fp.j.b<EnumC0585c> f21623a = new C0586a();
                private final int value;

                /* JADX INFO: renamed from: yo.a$o$c$c$a, reason: collision with other inner class name */
                public static class C0586a implements fp.j.b<EnumC0585c> {
                    public EnumC0585c a(int i10) {
                        return EnumC0585c.valueOf(i10);
                    }

                    @Override // fp.j.b
                    public fp.j.a findValueByNumber(int i10) {
                        return EnumC0585c.valueOf(i10);
                    }
                }

                EnumC0585c(int i10, int i11) {
                    this.value = i11;
                }

                @Override // fp.j.a
                public final int getNumber() {
                    return this.value;
                }

                public static EnumC0585c valueOf(int i10) {
                    if (i10 == 0) {
                        return CLASS;
                    }
                    if (i10 == 1) {
                        return PACKAGE;
                    }
                    if (i10 != 2) {
                        return null;
                    }
                    return LOCAL;
                }
            }

            static {
                c cVar = new c(true);
                f21618a = cVar;
                cVar.b();
            }

            private void b() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = EnumC0585c.PACKAGE;
            }

            public static c getDefaultInstance() {
                return f21618a;
            }

            public static b newBuilder(c cVar) {
                return newBuilder().h(cVar);
            }

            public EnumC0585c getKind() {
                return this.kind_;
            }

            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            @Override // fp.i, fp.q
            public fp.s<c> getParserForType() {
                return PARSER;
            }

            @Override // fp.q
            public int getSerializedSize() {
                int i10 = this.memoizedSerializedSize;
                if (i10 != -1) {
                    return i10;
                }
                int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.parentQualifiedName_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iO += fp.f.o(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    iO += fp.f.h(3, this.kind_.getNumber());
                }
                int size = this.unknownFields.size() + iO;
                this.memoizedSerializedSize = size;
                return size;
            }

            public int getShortName() {
                return this.shortName_;
            }

            public boolean hasKind() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasParentQualifiedName() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasShortName() {
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
                if (hasShortName()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }

            @Override // fp.q
            public void writeTo(fp.f fVar) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    fVar.a0(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    fVar.a0(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    fVar.S(3, this.kind_.getNumber());
                }
                fVar.i0(this.unknownFields);
            }

            public static b newBuilder() {
                return new b();
            }

            @Override // fp.r
            public c getDefaultInstanceForType() {
                return f21618a;
            }

            @Override // fp.q
            public b newBuilderForType() {
                return newBuilder();
            }

            @Override // fp.q
            public b toBuilder() {
                return newBuilder(this);
            }

            public c(fp.i.b bVar) {
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

            public c(fp.e eVar, fp.g gVar) throws fp.k {
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
                                    this.parentQualifiedName_ = eVar.A();
                                } else if (iK == 16) {
                                    this.bitField0_ |= 2;
                                    this.shortName_ = eVar.A();
                                } else if (iK != 24) {
                                    if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    }
                                } else {
                                    int iA = eVar.A();
                                    EnumC0585c enumC0585cValueOf = EnumC0585c.valueOf(iA);
                                    if (enumC0585cValueOf == null) {
                                        fVarJ.o0(iK);
                                        fVarJ.o0(iA);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.kind_ = enumC0585cValueOf;
                                    }
                                }
                            }
                            z10 = true;
                        } catch (fp.k e10) {
                            throw e10.setUnfinishedMessage(this);
                        } catch (IOException e11) {
                            throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                        }
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
            o oVar = new o(true);
            f21615a = oVar;
            oVar.b();
        }

        private void b() {
            this.qualifiedName_ = Collections.emptyList();
        }

        public static o getDefaultInstance() {
            return f21615a;
        }

        public static b newBuilder(o oVar) {
            return newBuilder().h(oVar);
        }

        @Override // fp.i, fp.q
        public fp.s<o> getParserForType() {
            return PARSER;
        }

        public c getQualifiedName(int i10) {
            return this.qualifiedName_.get(i10);
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iS = 0;
            for (int i11 = 0; i11 < this.qualifiedName_.size(); i11++) {
                iS += fp.f.s(1, this.qualifiedName_.get(i11));
            }
            int size = this.unknownFields.size() + iS;
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
            for (int i10 = 0; i10 < getQualifiedNameCount(); i10++) {
                if (!getQualifiedName(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            for (int i10 = 0; i10 < this.qualifiedName_.size(); i10++) {
                fVar.d0(1, this.qualifiedName_.get(i10));
            }
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public o getDefaultInstanceForType() {
            return f21615a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public o(fp.i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public o(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public o(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            b();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK != 10) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                if (!z11) {
                                    this.qualifiedName_ = new ArrayList();
                                    z11 = true;
                                }
                                this.qualifiedName_.add((c) eVar.u(c.PARSER, gVar));
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if (z11) {
                            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if (z11) {
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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

    public static final class p extends fp.i implements yo.q {
        public static fp.s<p> PARSER = new C0587a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f21625a;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private fp.o string_;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: yo.a$p$a, reason: collision with other inner class name */
        public static class C0587a extends fp.b<p> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public p c(fp.e eVar, fp.g gVar) throws fp.k {
                return new p(eVar, gVar);
            }
        }

        public static final class b extends fp.i.b<p, b> implements yo.q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f21626b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public fp.o f21627c = fp.n.f6268b;

            public static b j() {
                return new b();
            }

            public static b n() {
                return new b();
            }

            private void q() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return p.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return p.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public p build() {
                p pVarL = l();
                if (pVarL.isInitialized()) {
                    return pVarL;
                }
                throw new fp.w(pVarL);
            }

            public p l() {
                p pVar = new p(this);
                if ((this.f21626b & 1) == 1) {
                    this.f21627c = this.f21627c.getUnmodifiableView();
                    this.f21626b &= -2;
                }
                pVar.string_ = this.f21627c;
                return pVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(l());
            }

            public final void o() {
                if ((this.f21626b & 1) != 1) {
                    this.f21627c = new fp.n(this.f21627c);
                    this.f21626b |= 1;
                }
            }

            public p p() {
                return p.getDefaultInstance();
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                p pVar = null;
                try {
                    try {
                        p pVarC = p.PARSER.c(eVar, gVar);
                        if (pVarC != null) {
                            h(pVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        p pVar2 = (p) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            pVar = pVar2;
                            if (pVar != null) {
                                h(pVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (pVar != null) {
                        h(pVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b h(p pVar) {
                if (pVar == p.getDefaultInstance()) {
                    return this;
                }
                if (!pVar.string_.isEmpty()) {
                    if (this.f21627c.isEmpty()) {
                        this.f21627c = pVar.string_;
                        this.f21626b &= -2;
                    } else {
                        o();
                        this.f21627c.addAll(pVar.string_);
                    }
                }
                this.f6241a = this.f6241a.b(pVar.unknownFields);
                return this;
            }
        }

        static {
            p pVar = new p(true);
            f21625a = pVar;
            pVar.string_ = fp.n.f6268b;
        }

        private void b() {
            this.string_ = fp.n.f6268b;
        }

        public static p getDefaultInstance() {
            return f21625a;
        }

        public static b newBuilder(p pVar) {
            return newBuilder().h(pVar);
        }

        @Override // fp.i, fp.q
        public fp.s<p> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iE = 0;
            for (int i11 = 0; i11 < this.string_.size(); i11++) {
                iE += fp.f.e(this.string_.getByteString(i11));
            }
            int size = this.unknownFields.size() + getStringList().size() + iE;
            this.memoizedSerializedSize = size;
            return size;
        }

        public String getString(int i10) {
            return this.string_.get(i10);
        }

        public fp.t getStringList() {
            return this.string_;
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
            for (int i10 = 0; i10 < this.string_.size(); i10++) {
                fVar.O(1, this.string_.getByteString(i10));
            }
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public p getDefaultInstanceForType() {
            return f21625a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public p(fp.i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public p(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public p(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.string_ = fp.n.f6268b;
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK != 10) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                fp.d dVarL = eVar.l();
                                if (!z11) {
                                    this.string_ = new fp.n();
                                    z11 = true;
                                }
                                this.string_.h(dVarL);
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if (z11) {
                            this.string_ = this.string_.getUnmodifiableView();
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if (z11) {
                this.string_ = this.string_.getUnmodifiableView();
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

    public static final class q extends fp.i.d<q> implements yo.t {
        public static fp.s<q> PARSER = new C0588a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f21628a;
        private int abbreviatedTypeId_;
        private q abbreviatedType_;
        private List<b> argument_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private q flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean nullable_;
        private int outerTypeId_;
        private q outerType_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: yo.a$q$a, reason: collision with other inner class name */
        public static class C0588a extends fp.b<q> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public q c(fp.e eVar, fp.g gVar) throws fp.k {
                return new q(eVar, gVar);
            }
        }

        public static final class b extends fp.i implements yo.r {
            public static fp.s<b> PARSER = new C0589a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f21629a;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private c projection_;
            private int typeId_;
            private q type_;
            private final fp.d unknownFields;

            /* JADX INFO: renamed from: yo.a$q$b$a, reason: collision with other inner class name */
            public static class C0589a extends fp.b<b> {
                @Override // fp.s
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public b c(fp.e eVar, fp.g gVar) throws fp.k {
                    return new b(eVar, gVar);
                }
            }

            /* JADX INFO: renamed from: yo.a$q$b$b, reason: collision with other inner class name */
            public static final class C0590b extends fp.i.b<b, C0590b> implements yo.r {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public int f21630b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public c f21631c = c.INV;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public q f21632d = q.getDefaultInstance();

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public int f21633e;

                public static C0590b j() {
                    return new C0590b();
                }

                public static C0590b n() {
                    return new C0590b();
                }

                private void r() {
                }

                @Override // fp.i.b
                /* JADX INFO: renamed from: f */
                public fp.i getDefaultInstanceForType() {
                    return b.getDefaultInstance();
                }

                @Override // fp.i.b, fp.r
                public fp.q getDefaultInstanceForType() {
                    return b.getDefaultInstance();
                }

                @Override // fp.r
                public final boolean isInitialized() {
                    return !q() || this.f21632d.isInitialized();
                }

                @Override // fp.q.a
                /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
                public b build() {
                    b bVarL = l();
                    if (bVarL.isInitialized()) {
                        return bVarL;
                    }
                    throw new fp.w(bVarL);
                }

                public b l() {
                    b bVar = new b(this);
                    int i10 = this.f21630b;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    bVar.projection_ = this.f21631c;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    bVar.type_ = this.f21632d;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    bVar.typeId_ = this.f21633e;
                    bVar.bitField0_ = i11;
                    return bVar;
                }

                @Override // fp.i.b
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public C0590b l() {
                    return new C0590b().h(l());
                }

                public b o() {
                    return b.getDefaultInstance();
                }

                public q p() {
                    return this.f21632d;
                }

                public boolean q() {
                    return (this.f21630b & 2) == 2;
                }

                /* JADX WARN: Code duplicated, block: B:15:0x001d  */
                @Override // fp.a.AbstractC0147a, fp.q.a
                /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
                public C0590b c(fp.e eVar, fp.g gVar) throws Throwable {
                    b bVar = null;
                    try {
                        try {
                            b bVarC = b.PARSER.c(eVar, gVar);
                            if (bVarC != null) {
                                h(bVarC);
                            }
                            return this;
                        } catch (fp.k e10) {
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

                @Override // fp.i.b
                /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
                public C0590b h(b bVar) {
                    if (bVar == b.getDefaultInstance()) {
                        return this;
                    }
                    if (bVar.hasProjection()) {
                        v(bVar.getProjection());
                    }
                    if (bVar.hasType()) {
                        u(bVar.getType());
                    }
                    if (bVar.hasTypeId()) {
                        w(bVar.getTypeId());
                    }
                    this.f6241a = this.f6241a.b(bVar.unknownFields);
                    return this;
                }

                public C0590b u(q qVar) {
                    if ((this.f21630b & 2) != 2 || this.f21632d == q.getDefaultInstance()) {
                        this.f21632d = qVar;
                    } else {
                        this.f21632d = q.newBuilder(this.f21632d).h(qVar).r();
                    }
                    this.f21630b |= 2;
                    return this;
                }

                public C0590b v(c cVar) {
                    cVar.getClass();
                    this.f21630b |= 1;
                    this.f21631c = cVar;
                    return this;
                }

                public C0590b w(int i10) {
                    this.f21630b |= 4;
                    this.f21633e = i10;
                    return this;
                }
            }

            public enum c implements fp.j.a {
                IN(0, 0),
                OUT(1, 1),
                INV(2, 2),
                STAR(3, 3);


                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static fp.j.b<c> f21634a = new C0591a();
                private final int value;

                /* JADX INFO: renamed from: yo.a$q$b$c$a, reason: collision with other inner class name */
                public static class C0591a implements fp.j.b<c> {
                    public c a(int i10) {
                        return c.valueOf(i10);
                    }

                    @Override // fp.j.b
                    public fp.j.a findValueByNumber(int i10) {
                        return c.valueOf(i10);
                    }
                }

                c(int i10, int i11) {
                    this.value = i11;
                }

                @Override // fp.j.a
                public final int getNumber() {
                    return this.value;
                }

                public static c valueOf(int i10) {
                    if (i10 == 0) {
                        return IN;
                    }
                    if (i10 == 1) {
                        return OUT;
                    }
                    if (i10 == 2) {
                        return INV;
                    }
                    if (i10 != 3) {
                        return null;
                    }
                    return STAR;
                }
            }

            static {
                b bVar = new b(true);
                f21629a = bVar;
                bVar.b();
            }

            private void b() {
                this.projection_ = c.INV;
                this.type_ = q.getDefaultInstance();
                this.typeId_ = 0;
            }

            public static b getDefaultInstance() {
                return f21629a;
            }

            public static C0590b newBuilder(b bVar) {
                return newBuilder().h(bVar);
            }

            @Override // fp.i, fp.q
            public fp.s<b> getParserForType() {
                return PARSER;
            }

            public c getProjection() {
                return this.projection_;
            }

            @Override // fp.q
            public int getSerializedSize() {
                int i10 = this.memoizedSerializedSize;
                if (i10 != -1) {
                    return i10;
                }
                int iH = (this.bitField0_ & 1) == 1 ? fp.f.h(1, this.projection_.getNumber()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    iH += fp.f.s(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    iH += fp.f.o(3, this.typeId_);
                }
                int size = this.unknownFields.size() + iH;
                this.memoizedSerializedSize = size;
                return size;
            }

            public q getType() {
                return this.type_;
            }

            public int getTypeId() {
                return this.typeId_;
            }

            public boolean hasProjection() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasType() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasTypeId() {
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
                if (!hasType() || getType().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }

            @Override // fp.q
            public void writeTo(fp.f fVar) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    fVar.S(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    fVar.d0(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    fVar.a0(3, this.typeId_);
                }
                fVar.i0(this.unknownFields);
            }

            public static C0590b newBuilder() {
                return new C0590b();
            }

            @Override // fp.r
            public b getDefaultInstanceForType() {
                return f21629a;
            }

            @Override // fp.q
            public C0590b newBuilderForType() {
                return newBuilder();
            }

            @Override // fp.q
            public C0590b toBuilder() {
                return newBuilder(this);
            }

            public b(fp.i.b bVar) {
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

            public b(fp.e eVar, fp.g gVar) throws fp.k {
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
                                    int iA = eVar.A();
                                    c cVarValueOf = c.valueOf(iA);
                                    if (cVarValueOf == null) {
                                        fVarJ.o0(iK);
                                        fVarJ.o0(iA);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.projection_ = cVarValueOf;
                                    }
                                } else if (iK == 18) {
                                    c builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                    q qVar = (q) eVar.u(q.PARSER, gVar);
                                    this.type_ = qVar;
                                    if (builder != null) {
                                        builder.h(qVar);
                                        this.type_ = builder.r();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (iK != 24) {
                                    if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    }
                                } else {
                                    this.bitField0_ |= 4;
                                    this.typeId_ = eVar.A();
                                }
                            }
                            z10 = true;
                        } catch (fp.k e10) {
                            throw e10.setUnfinishedMessage(this);
                        } catch (IOException e11) {
                            throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                        }
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

        public static final class c extends fp.i.c<q, c> implements yo.t {
            public int I;
            public int J;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21636d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f21638f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f21639g;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public int f21641n;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public int f21642p;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public int f21643v;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public int f21644w;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public int f21645x;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            public int f21647z;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public List<b> f21637e = Collections.emptyList();

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public q f21640i = q.getDefaultInstance();

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            public q f21646y = q.getDefaultInstance();
            public q H = q.getDefaultInstance();

            private void E() {
            }

            public static c p() {
                return new c();
            }

            public static c t() {
                return new c();
            }

            private void u() {
                if ((this.f21636d & 1) != 1) {
                    this.f21637e = new ArrayList(this.f21637e);
                    this.f21636d |= 1;
                }
            }

            public q A() {
                return this.f21646y;
            }

            public boolean B() {
                return (this.f21636d & 2048) == 2048;
            }

            public boolean C() {
                return (this.f21636d & 8) == 8;
            }

            public boolean D() {
                return (this.f21636d & 512) == 512;
            }

            public c F(q qVar) {
                if ((this.f21636d & 2048) != 2048 || this.H == q.getDefaultInstance()) {
                    this.H = qVar;
                } else {
                    this.H = q.newBuilder(this.H).h(qVar).r();
                }
                this.f21636d |= 2048;
                return this;
            }

            public c G(q qVar) {
                if ((this.f21636d & 8) != 8 || this.f21640i == q.getDefaultInstance()) {
                    this.f21640i = qVar;
                } else {
                    this.f21640i = q.newBuilder(this.f21640i).h(qVar).r();
                }
                this.f21636d |= 8;
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
            public c c(fp.e eVar, fp.g gVar) throws Throwable {
                q qVar = null;
                try {
                    try {
                        q qVarC = q.PARSER.c(eVar, gVar);
                        if (qVarC != null) {
                            h(qVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        q qVar2 = (q) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            qVar = qVar2;
                            if (qVar != null) {
                                h(qVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (qVar != null) {
                        h(qVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
            public c h(q qVar) {
                if (qVar == q.getDefaultInstance()) {
                    return this;
                }
                if (!qVar.argument_.isEmpty()) {
                    if (this.f21637e.isEmpty()) {
                        this.f21637e = qVar.argument_;
                        this.f21636d &= -2;
                    } else {
                        u();
                        this.f21637e.addAll(qVar.argument_);
                    }
                }
                if (qVar.hasNullable()) {
                    P(qVar.getNullable());
                }
                if (qVar.hasFlexibleTypeCapabilitiesId()) {
                    N(qVar.getFlexibleTypeCapabilitiesId());
                }
                if (qVar.hasFlexibleUpperBound()) {
                    G(qVar.getFlexibleUpperBound());
                }
                if (qVar.hasFlexibleUpperBoundId()) {
                    O(qVar.getFlexibleUpperBoundId());
                }
                if (qVar.hasClassName()) {
                    L(qVar.getClassName());
                }
                if (qVar.hasTypeParameter()) {
                    S(qVar.getTypeParameter());
                }
                if (qVar.hasTypeParameterName()) {
                    T(qVar.getTypeParameterName());
                }
                if (qVar.hasTypeAliasName()) {
                    R(qVar.getTypeAliasName());
                }
                if (qVar.hasOuterType()) {
                    J(qVar.getOuterType());
                }
                if (qVar.hasOuterTypeId()) {
                    Q(qVar.getOuterTypeId());
                }
                if (qVar.hasAbbreviatedType()) {
                    F(qVar.getAbbreviatedType());
                }
                if (qVar.hasAbbreviatedTypeId()) {
                    K(qVar.getAbbreviatedTypeId());
                }
                if (qVar.hasFlags()) {
                    M(qVar.getFlags());
                }
                o(qVar);
                this.f6241a = this.f6241a.b(qVar.unknownFields);
                return this;
            }

            public c J(q qVar) {
                if ((this.f21636d & 512) != 512 || this.f21646y == q.getDefaultInstance()) {
                    this.f21646y = qVar;
                } else {
                    this.f21646y = q.newBuilder(this.f21646y).h(qVar).r();
                }
                this.f21636d |= 512;
                return this;
            }

            public c K(int i10) {
                this.f21636d |= 4096;
                this.I = i10;
                return this;
            }

            public c L(int i10) {
                this.f21636d |= 32;
                this.f21642p = i10;
                return this;
            }

            public c M(int i10) {
                this.f21636d |= 8192;
                this.J = i10;
                return this;
            }

            public c N(int i10) {
                this.f21636d |= 4;
                this.f21639g = i10;
                return this;
            }

            public c O(int i10) {
                this.f21636d |= 16;
                this.f21641n = i10;
                return this;
            }

            public c P(boolean z10) {
                this.f21636d |= 2;
                this.f21638f = z10;
                return this;
            }

            public c Q(int i10) {
                this.f21636d |= 1024;
                this.f21647z = i10;
                return this;
            }

            public c R(int i10) {
                this.f21636d |= 256;
                this.f21645x = i10;
                return this;
            }

            public c S(int i10) {
                this.f21636d |= 64;
                this.f21643v = i10;
                return this;
            }

            public c T(int i10) {
                this.f21636d |= 128;
                this.f21644w = i10;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return q.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return q.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < this.f21637e.size(); i10++) {
                    if (!w(i10).isInitialized()) {
                        return false;
                    }
                }
                if (C() && !this.f21640i.isInitialized()) {
                    return false;
                }
                if (!D() || this.f21646y.isInitialized()) {
                    return (!B() || this.H.isInitialized()) && this.f6242b.n();
                }
                return false;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public q build() {
                q qVarR = r();
                if (qVarR.isInitialized()) {
                    return qVarR;
                }
                throw new fp.w(qVarR);
            }

            public q r() {
                q qVar = new q(this);
                int i10 = this.f21636d;
                if ((i10 & 1) == 1) {
                    this.f21637e = Collections.unmodifiableList(this.f21637e);
                    this.f21636d &= -2;
                }
                qVar.argument_ = this.f21637e;
                int i11 = (i10 & 2) != 2 ? 0 : 1;
                qVar.nullable_ = this.f21638f;
                if ((i10 & 4) == 4) {
                    i11 |= 2;
                }
                qVar.flexibleTypeCapabilitiesId_ = this.f21639g;
                if ((i10 & 8) == 8) {
                    i11 |= 4;
                }
                qVar.flexibleUpperBound_ = this.f21640i;
                if ((i10 & 16) == 16) {
                    i11 |= 8;
                }
                qVar.flexibleUpperBoundId_ = this.f21641n;
                if ((i10 & 32) == 32) {
                    i11 |= 16;
                }
                qVar.className_ = this.f21642p;
                if ((i10 & 64) == 64) {
                    i11 |= 32;
                }
                qVar.typeParameter_ = this.f21643v;
                if ((i10 & 128) == 128) {
                    i11 |= 64;
                }
                qVar.typeParameterName_ = this.f21644w;
                if ((i10 & 256) == 256) {
                    i11 |= 128;
                }
                qVar.typeAliasName_ = this.f21645x;
                if ((i10 & 512) == 512) {
                    i11 |= 256;
                }
                qVar.outerType_ = this.f21646y;
                if ((i10 & 1024) == 1024) {
                    i11 |= 512;
                }
                qVar.outerTypeId_ = this.f21647z;
                if ((i10 & 2048) == 2048) {
                    i11 |= 1024;
                }
                qVar.abbreviatedType_ = this.H;
                if ((i10 & 4096) == 4096) {
                    i11 |= 2048;
                }
                qVar.abbreviatedTypeId_ = this.I;
                if ((i10 & 8192) == 8192) {
                    i11 |= 4096;
                }
                qVar.flags_ = this.J;
                qVar.bitField0_ = i11;
                return qVar;
            }

            @Override // fp.i.c
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public c l() {
                return new c().h(r());
            }

            public q v() {
                return this.H;
            }

            public b w(int i10) {
                return this.f21637e.get(i10);
            }

            public int x() {
                return this.f21637e.size();
            }

            public q y() {
                return q.getDefaultInstance();
            }

            public q z() {
                return this.f21640i;
            }
        }

        static {
            q qVar = new q(true);
            f21628a = qVar;
            qVar.d();
        }

        private void d() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
        }

        public static q getDefaultInstance() {
            return f21628a;
        }

        public static c newBuilder(q qVar) {
            return newBuilder().h(qVar);
        }

        public q getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        public b getArgument(int i10) {
            return this.argument_.get(i10);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<b> getArgumentList() {
            return this.argument_;
        }

        public int getClassName() {
            return this.className_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public q getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        public boolean getNullable() {
            return this.nullable_;
        }

        public q getOuterType() {
            return this.outerType_;
        }

        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        @Override // fp.i, fp.q
        public fp.s<q> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 4096) == 4096 ? fp.f.o(1, this.flags_) : 0;
            for (int i11 = 0; i11 < this.argument_.size(); i11++) {
                iO += fp.f.s(2, this.argument_.get(i11));
            }
            if ((this.bitField0_ & 1) == 1) {
                iO += fp.f.a(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                iO += fp.f.o(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iO += fp.f.s(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iO += fp.f.o(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                iO += fp.f.o(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iO += fp.f.o(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                iO += fp.f.o(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                iO += fp.f.s(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                iO += fp.f.o(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                iO += fp.f.o(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                iO += fp.f.s(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                iO += fp.f.o(14, this.abbreviatedTypeId_);
            }
            int size = this.unknownFields.size() + extensionsSerializedSize() + iO;
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        public int getTypeParameter() {
            return this.typeParameter_;
        }

        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        public boolean hasAbbreviatedType() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public boolean hasAbbreviatedTypeId() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean hasClassName() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public boolean hasFlexibleTypeCapabilitiesId() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasFlexibleUpperBound() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlexibleUpperBoundId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasOuterType() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasOuterTypeId() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasTypeAliasName() {
            return (this.bitField0_ & 128) == 128;
        }

        public boolean hasTypeParameter() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasTypeParameterName() {
            return (this.bitField0_ & 64) == 64;
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
            for (int i10 = 0; i10 < getArgumentCount(); i10++) {
                if (!getArgument(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasOuterType() && !getOuterType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            fp.i.d<MessageType>.a aVarNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 4096) == 4096) {
                fVar.a0(1, this.flags_);
            }
            for (int i10 = 0; i10 < this.argument_.size(); i10++) {
                fVar.d0(2, this.argument_.get(i10));
            }
            if ((this.bitField0_ & 1) == 1) {
                fVar.L(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.d0(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                fVar.a0(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                fVar.a0(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                fVar.a0(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                fVar.a0(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                fVar.d0(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                fVar.a0(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                fVar.a0(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                fVar.d0(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                fVar.a0(14, this.abbreviatedTypeId_);
            }
            aVarNewExtensionWriter.a(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, fVar);
            fVar.i0(this.unknownFields);
        }

        public static c newBuilder() {
            return new c();
        }

        @Override // fp.r
        public q getDefaultInstanceForType() {
            return f21628a;
        }

        @Override // fp.q
        public c newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public c toBuilder() {
            return newBuilder(this);
        }

        public q(fp.i.c<q, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f6241a;
        }

        public q(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public q(fp.e eVar, fp.g gVar) throws fp.k {
            c builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            d();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        switch (iK) {
                            case 0:
                                break;
                            case 8:
                                this.bitField0_ |= 4096;
                                this.flags_ = eVar.A();
                                continue;
                            case 18:
                                if (!z11) {
                                    this.argument_ = new ArrayList();
                                    z11 = true;
                                }
                                this.argument_.add((b) eVar.u(b.PARSER, gVar));
                                continue;
                            case 24:
                                this.bitField0_ |= 1;
                                this.nullable_ = eVar.k();
                                continue;
                            case 32:
                                this.bitField0_ |= 2;
                                this.flexibleTypeCapabilitiesId_ = eVar.A();
                                continue;
                            case 42:
                                builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : null;
                                q qVar = (q) eVar.u(PARSER, gVar);
                                this.flexibleUpperBound_ = qVar;
                                if (builder != null) {
                                    builder.h(qVar);
                                    this.flexibleUpperBound_ = builder.r();
                                }
                                this.bitField0_ |= 4;
                                continue;
                            case 48:
                                this.bitField0_ |= 16;
                                this.className_ = eVar.A();
                                continue;
                            case 56:
                                this.bitField0_ |= 32;
                                this.typeParameter_ = eVar.A();
                                continue;
                            case 64:
                                this.bitField0_ |= 8;
                                this.flexibleUpperBoundId_ = eVar.A();
                                continue;
                            case TabLayout.f3131k0 /* 72 */:
                                this.bitField0_ |= 64;
                                this.typeParameterName_ = eVar.A();
                                continue;
                            case 82:
                                builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : null;
                                q qVar2 = (q) eVar.u(PARSER, gVar);
                                this.outerType_ = qVar2;
                                if (builder != null) {
                                    builder.h(qVar2);
                                    this.outerType_ = builder.r();
                                }
                                this.bitField0_ |= 256;
                                continue;
                            case 88:
                                this.bitField0_ |= 512;
                                this.outerTypeId_ = eVar.A();
                                continue;
                            case 96:
                                this.bitField0_ |= 128;
                                this.typeAliasName_ = eVar.A();
                                continue;
                            case 106:
                                builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : null;
                                q qVar3 = (q) eVar.u(PARSER, gVar);
                                this.abbreviatedType_ = qVar3;
                                if (builder != null) {
                                    builder.h(qVar3);
                                    this.abbreviatedType_ = builder.r();
                                }
                                this.bitField0_ |= 1024;
                                continue;
                            case y5.a.f20716e0 /* 112 */:
                                this.bitField0_ |= 2048;
                                this.abbreviatedTypeId_ = eVar.A();
                                continue;
                            default:
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    break;
                                }
                                break;
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if (z11) {
                            this.argument_ = Collections.unmodifiableList(this.argument_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if (z11) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
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

    public static final class r extends fp.i.d<r> implements yo.s {
        public static fp.s<r> PARSER = new C0592a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final r f21648a;
        private List<b> annotation_;
        private int bitField0_;
        private int expandedTypeId_;
        private q expandedType_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List<s> typeParameter_;
        private int underlyingTypeId_;
        private q underlyingType_;
        private final fp.d unknownFields;
        private List<Integer> versionRequirement_;

        /* JADX INFO: renamed from: yo.a$r$a, reason: collision with other inner class name */
        public static class C0592a extends fp.b<r> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public r c(fp.e eVar, fp.g gVar) throws fp.k {
                return new r(eVar, gVar);
            }
        }

        public static final class b extends fp.i.c<r, b> implements yo.s {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21649d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f21651f;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public int f21654n;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public int f21656v;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f21650e = 6;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public List<s> f21652g = Collections.emptyList();

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public q f21653i = q.getDefaultInstance();

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public q f21655p = q.getDefaultInstance();

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public List<b> f21657w = Collections.emptyList();

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public List<Integer> f21658x = Collections.emptyList();

            private void H() {
            }

            public static b p() {
                return new b();
            }

            public static b t() {
                return new b();
            }

            private void v() {
                if ((this.f21649d & 4) != 4) {
                    this.f21652g = new ArrayList(this.f21652g);
                    this.f21649d |= 4;
                }
            }

            private void w() {
                if ((this.f21649d & 256) != 256) {
                    this.f21658x = new ArrayList(this.f21658x);
                    this.f21649d |= 256;
                }
            }

            public q A() {
                return this.f21655p;
            }

            public s B(int i10) {
                return this.f21652g.get(i10);
            }

            public int C() {
                return this.f21652g.size();
            }

            public q D() {
                return this.f21653i;
            }

            public boolean E() {
                return (this.f21649d & 32) == 32;
            }

            public boolean F() {
                return (this.f21649d & 2) == 2;
            }

            public boolean G() {
                return (this.f21649d & 8) == 8;
            }

            public b I(q qVar) {
                if ((this.f21649d & 32) != 32 || this.f21655p == q.getDefaultInstance()) {
                    this.f21655p = qVar;
                } else {
                    this.f21655p = q.newBuilder(this.f21655p).h(qVar).r();
                }
                this.f21649d |= 32;
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                r rVar = null;
                try {
                    try {
                        r rVarC = r.PARSER.c(eVar, gVar);
                        if (rVarC != null) {
                            h(rVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        r rVar2 = (r) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            rVar = rVar2;
                            if (rVar != null) {
                                h(rVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (rVar != null) {
                        h(rVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
            public b h(r rVar) {
                if (rVar == r.getDefaultInstance()) {
                    return this;
                }
                if (rVar.hasFlags()) {
                    N(rVar.getFlags());
                }
                if (rVar.hasName()) {
                    O(rVar.getName());
                }
                if (!rVar.typeParameter_.isEmpty()) {
                    if (this.f21652g.isEmpty()) {
                        this.f21652g = rVar.typeParameter_;
                        this.f21649d &= -5;
                    } else {
                        v();
                        this.f21652g.addAll(rVar.typeParameter_);
                    }
                }
                if (rVar.hasUnderlyingType()) {
                    L(rVar.getUnderlyingType());
                }
                if (rVar.hasUnderlyingTypeId()) {
                    P(rVar.getUnderlyingTypeId());
                }
                if (rVar.hasExpandedType()) {
                    I(rVar.getExpandedType());
                }
                if (rVar.hasExpandedTypeId()) {
                    M(rVar.getExpandedTypeId());
                }
                if (!rVar.annotation_.isEmpty()) {
                    if (this.f21657w.isEmpty()) {
                        this.f21657w = rVar.annotation_;
                        this.f21649d &= -129;
                    } else {
                        u();
                        this.f21657w.addAll(rVar.annotation_);
                    }
                }
                if (!rVar.versionRequirement_.isEmpty()) {
                    if (this.f21658x.isEmpty()) {
                        this.f21658x = rVar.versionRequirement_;
                        this.f21649d &= -257;
                    } else {
                        w();
                        this.f21658x.addAll(rVar.versionRequirement_);
                    }
                }
                o(rVar);
                this.f6241a = this.f6241a.b(rVar.unknownFields);
                return this;
            }

            public b L(q qVar) {
                if ((this.f21649d & 8) != 8 || this.f21653i == q.getDefaultInstance()) {
                    this.f21653i = qVar;
                } else {
                    this.f21653i = q.newBuilder(this.f21653i).h(qVar).r();
                }
                this.f21649d |= 8;
                return this;
            }

            public b M(int i10) {
                this.f21649d |= 64;
                this.f21656v = i10;
                return this;
            }

            public b N(int i10) {
                this.f21649d |= 1;
                this.f21650e = i10;
                return this;
            }

            public b O(int i10) {
                this.f21649d |= 2;
                this.f21651f = i10;
                return this;
            }

            public b P(int i10) {
                this.f21649d |= 16;
                this.f21654n = i10;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return r.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return r.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                if (!F()) {
                    return false;
                }
                for (int i10 = 0; i10 < this.f21652g.size(); i10++) {
                    if (!B(i10).isInitialized()) {
                        return false;
                    }
                }
                if (G() && !this.f21653i.isInitialized()) {
                    return false;
                }
                if (E() && !this.f21655p.isInitialized()) {
                    return false;
                }
                for (int i11 = 0; i11 < this.f21657w.size(); i11++) {
                    if (!x(i11).isInitialized()) {
                        return false;
                    }
                }
                return this.f6242b.n();
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public r build() {
                r rVarR = r();
                if (rVarR.isInitialized()) {
                    return rVarR;
                }
                throw new fp.w(rVarR);
            }

            public r r() {
                r rVar = new r(this);
                int i10 = this.f21649d;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                rVar.flags_ = this.f21650e;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                rVar.name_ = this.f21651f;
                if ((this.f21649d & 4) == 4) {
                    this.f21652g = Collections.unmodifiableList(this.f21652g);
                    this.f21649d &= -5;
                }
                rVar.typeParameter_ = this.f21652g;
                if ((i10 & 8) == 8) {
                    i11 |= 4;
                }
                rVar.underlyingType_ = this.f21653i;
                if ((i10 & 16) == 16) {
                    i11 |= 8;
                }
                rVar.underlyingTypeId_ = this.f21654n;
                if ((i10 & 32) == 32) {
                    i11 |= 16;
                }
                rVar.expandedType_ = this.f21655p;
                if ((i10 & 64) == 64) {
                    i11 |= 32;
                }
                rVar.expandedTypeId_ = this.f21656v;
                if ((this.f21649d & 128) == 128) {
                    this.f21657w = Collections.unmodifiableList(this.f21657w);
                    this.f21649d &= -129;
                }
                rVar.annotation_ = this.f21657w;
                if ((this.f21649d & 256) == 256) {
                    this.f21658x = Collections.unmodifiableList(this.f21658x);
                    this.f21649d &= -257;
                }
                rVar.versionRequirement_ = this.f21658x;
                rVar.bitField0_ = i11;
                return rVar;
            }

            @Override // fp.i.c
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(r());
            }

            public final void u() {
                if ((this.f21649d & 128) != 128) {
                    this.f21657w = new ArrayList(this.f21657w);
                    this.f21649d |= 128;
                }
            }

            public b x(int i10) {
                return this.f21657w.get(i10);
            }

            public int y() {
                return this.f21657w.size();
            }

            public r z() {
                return r.getDefaultInstance();
            }
        }

        static {
            r rVar = new r(true);
            f21648a = rVar;
            rVar.d();
        }

        private void d() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = q.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = q.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static r getDefaultInstance() {
            return f21648a;
        }

        public static b newBuilder(r rVar) {
            return newBuilder().h(rVar);
        }

        public static r parseDelimitedFrom(InputStream inputStream, fp.g gVar) throws IOException {
            return PARSER.d(inputStream, gVar);
        }

        public b getAnnotation(int i10) {
            return this.annotation_.get(i10);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<b> getAnnotationList() {
            return this.annotation_;
        }

        public q getExpandedType() {
            return this.expandedType_;
        }

        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // fp.i, fp.q
        public fp.s<r> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iO += fp.f.o(2, this.name_);
            }
            for (int i11 = 0; i11 < this.typeParameter_.size(); i11++) {
                iO += fp.f.s(3, this.typeParameter_.get(i11));
            }
            if ((this.bitField0_ & 4) == 4) {
                iO += fp.f.s(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iO += fp.f.o(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iO += fp.f.s(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                iO += fp.f.o(7, this.expandedTypeId_);
            }
            for (int i12 = 0; i12 < this.annotation_.size(); i12++) {
                iO += fp.f.s(8, this.annotation_.get(i12));
            }
            int iP = 0;
            for (int i13 = 0; i13 < this.versionRequirement_.size(); i13++) {
                iP += fp.f.p(this.versionRequirement_.get(i13).intValue());
            }
            int size = this.unknownFields.size() + extensionsSerializedSize() + (getVersionRequirementList().size() * 2) + iO + iP;
            this.memoizedSerializedSize = size;
            return size;
        }

        public s getTypeParameter(int i10) {
            return this.typeParameter_.get(i10);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<s> getTypeParameterList() {
            return this.typeParameter_;
        }

        public q getUnderlyingType() {
            return this.underlyingType_;
        }

        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasExpandedType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasExpandedTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasUnderlyingType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasUnderlyingTypeId() {
            return (this.bitField0_ & 8) == 8;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i10 = 0; i10 < getTypeParameterCount(); i10++) {
                if (!getTypeParameter(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasExpandedType() && !getExpandedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i11 = 0; i11 < getAnnotationCount(); i11++) {
                if (!getAnnotation(i11).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            fp.i.d<MessageType>.a aVarNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(2, this.name_);
            }
            for (int i10 = 0; i10 < this.typeParameter_.size(); i10++) {
                fVar.d0(3, this.typeParameter_.get(i10));
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.d0(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                fVar.a0(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                fVar.d0(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                fVar.a0(7, this.expandedTypeId_);
            }
            for (int i11 = 0; i11 < this.annotation_.size(); i11++) {
                fVar.d0(8, this.annotation_.get(i11));
            }
            for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
                fVar.a0(31, this.versionRequirement_.get(i12).intValue());
            }
            aVarNewExtensionWriter.a(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, fVar);
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public r getDefaultInstanceForType() {
            return f21648a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public r(fp.i.c<r, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f6241a;
        }

        public r(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public r(fp.e eVar, fp.g gVar) throws fp.k {
            q.c builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            d();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            int i10 = 0;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        switch (iK) {
                            case 0:
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.flags_ = eVar.A();
                                continue;
                            case 16:
                                this.bitField0_ |= 2;
                                this.name_ = eVar.A();
                                continue;
                            case 26:
                                if ((i10 & 4) != 4) {
                                    this.typeParameter_ = new ArrayList();
                                    i10 |= 4;
                                }
                                this.typeParameter_.add((s) eVar.u(s.PARSER, gVar));
                                continue;
                            case 34:
                                builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                                q qVar = (q) eVar.u(q.PARSER, gVar);
                                this.underlyingType_ = qVar;
                                if (builder != null) {
                                    builder.h(qVar);
                                    this.underlyingType_ = builder.r();
                                }
                                this.bitField0_ |= 4;
                                continue;
                            case 40:
                                this.bitField0_ |= 8;
                                this.underlyingTypeId_ = eVar.A();
                                continue;
                            case 50:
                                builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                                q qVar2 = (q) eVar.u(q.PARSER, gVar);
                                this.expandedType_ = qVar2;
                                if (builder != null) {
                                    builder.h(qVar2);
                                    this.expandedType_ = builder.r();
                                }
                                this.bitField0_ |= 16;
                                continue;
                            case 56:
                                this.bitField0_ |= 32;
                                this.expandedTypeId_ = eVar.A();
                                continue;
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                                if ((i10 & 128) != 128) {
                                    this.annotation_ = new ArrayList();
                                    i10 |= 128;
                                }
                                this.annotation_.add((b) eVar.u(b.PARSER, gVar));
                                continue;
                            case 248:
                                if ((i10 & 256) != 256) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 |= 256;
                                }
                                this.versionRequirement_.add(Integer.valueOf(eVar.A()));
                                continue;
                            case 250:
                                int iJ = eVar.j(eVar.A());
                                if ((i10 & 256) != 256 && eVar.e() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    i10 |= 256;
                                }
                                while (eVar.e() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(eVar.A()));
                                }
                                eVar.i(iJ);
                                continue;
                            default:
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    break;
                                }
                                break;
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if ((i10 & 4) == 4) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((i10 & 128) == 128) {
                            this.annotation_ = Collections.unmodifiableList(this.annotation_);
                        }
                        if ((i10 & 256) == 256) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if ((i10 & 4) == 4) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if ((i10 & 128) == 128) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
            }
            if ((i10 & 256) == 256) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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

    public static final class s extends fp.i.d<s> implements yo.u {
        public static fp.s<s> PARSER = new C0593a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f21659a;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private boolean reified_;
        private final fp.d unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        private List<Integer> upperBoundId_;
        private List<q> upperBound_;
        private c variance_;

        /* JADX INFO: renamed from: yo.a$s$a, reason: collision with other inner class name */
        public static class C0593a extends fp.b<s> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public s c(fp.e eVar, fp.g gVar) throws fp.k {
                return new s(eVar, gVar);
            }
        }

        public static final class b extends fp.i.c<s, b> implements yo.u {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21660d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f21661e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f21662f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public boolean f21663g;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public c f21664i = c.INV;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public List<q> f21665n = Collections.emptyList();

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public List<Integer> f21666p = Collections.emptyList();

            private void B() {
            }

            public static b p() {
                return new b();
            }

            public static b t() {
                return new b();
            }

            public boolean A() {
                return (this.f21660d & 2) == 2;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                s sVar = null;
                try {
                    try {
                        s sVarC = s.PARSER.c(eVar, gVar);
                        if (sVarC != null) {
                            h(sVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        s sVar2 = (s) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            sVar = sVar2;
                            if (sVar != null) {
                                h(sVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (sVar != null) {
                        h(sVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
            public b h(s sVar) {
                if (sVar == s.getDefaultInstance()) {
                    return this;
                }
                if (sVar.hasId()) {
                    E(sVar.getId());
                }
                if (sVar.hasName()) {
                    F(sVar.getName());
                }
                if (sVar.hasReified()) {
                    G(sVar.getReified());
                }
                if (sVar.hasVariance()) {
                    H(sVar.getVariance());
                }
                if (!sVar.upperBound_.isEmpty()) {
                    if (this.f21665n.isEmpty()) {
                        this.f21665n = sVar.upperBound_;
                        this.f21660d &= -17;
                    } else {
                        v();
                        this.f21665n.addAll(sVar.upperBound_);
                    }
                }
                if (!sVar.upperBoundId_.isEmpty()) {
                    if (this.f21666p.isEmpty()) {
                        this.f21666p = sVar.upperBoundId_;
                        this.f21660d &= -33;
                    } else {
                        u();
                        this.f21666p.addAll(sVar.upperBoundId_);
                    }
                }
                o(sVar);
                this.f6241a = this.f6241a.b(sVar.unknownFields);
                return this;
            }

            public b E(int i10) {
                this.f21660d |= 1;
                this.f21661e = i10;
                return this;
            }

            public b F(int i10) {
                this.f21660d |= 2;
                this.f21662f = i10;
                return this;
            }

            public b G(boolean z10) {
                this.f21660d |= 4;
                this.f21663g = z10;
                return this;
            }

            public b H(c cVar) {
                cVar.getClass();
                this.f21660d |= 8;
                this.f21664i = cVar;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return s.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return s.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                if (!z() || !A()) {
                    return false;
                }
                for (int i10 = 0; i10 < this.f21665n.size(); i10++) {
                    if (!x(i10).isInitialized()) {
                        return false;
                    }
                }
                return this.f6242b.n();
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public s build() {
                s sVarR = r();
                if (sVarR.isInitialized()) {
                    return sVarR;
                }
                throw new fp.w(sVarR);
            }

            public s r() {
                s sVar = new s(this);
                int i10 = this.f21660d;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                sVar.id_ = this.f21661e;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                sVar.name_ = this.f21662f;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                sVar.reified_ = this.f21663g;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                sVar.variance_ = this.f21664i;
                if ((this.f21660d & 16) == 16) {
                    this.f21665n = Collections.unmodifiableList(this.f21665n);
                    this.f21660d &= -17;
                }
                sVar.upperBound_ = this.f21665n;
                if ((this.f21660d & 32) == 32) {
                    this.f21666p = Collections.unmodifiableList(this.f21666p);
                    this.f21660d &= -33;
                }
                sVar.upperBoundId_ = this.f21666p;
                sVar.bitField0_ = i11;
                return sVar;
            }

            @Override // fp.i.c
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(r());
            }

            public final void u() {
                if ((this.f21660d & 32) != 32) {
                    this.f21666p = new ArrayList(this.f21666p);
                    this.f21660d |= 32;
                }
            }

            public final void v() {
                if ((this.f21660d & 16) != 16) {
                    this.f21665n = new ArrayList(this.f21665n);
                    this.f21660d |= 16;
                }
            }

            public s w() {
                return s.getDefaultInstance();
            }

            public q x(int i10) {
                return this.f21665n.get(i10);
            }

            public int y() {
                return this.f21665n.size();
            }

            public boolean z() {
                return (this.f21660d & 1) == 1;
            }
        }

        public enum c implements fp.j.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static fp.j.b<c> f21667a = new C0594a();
            private final int value;

            /* JADX INFO: renamed from: yo.a$s$c$a, reason: collision with other inner class name */
            public static class C0594a implements fp.j.b<c> {
                public c a(int i10) {
                    return c.valueOf(i10);
                }

                @Override // fp.j.b
                public fp.j.a findValueByNumber(int i10) {
                    return c.valueOf(i10);
                }
            }

            c(int i10, int i11) {
                this.value = i11;
            }

            @Override // fp.j.a
            public final int getNumber() {
                return this.value;
            }

            public static c valueOf(int i10) {
                if (i10 == 0) {
                    return IN;
                }
                if (i10 == 1) {
                    return OUT;
                }
                if (i10 != 2) {
                    return null;
                }
                return INV;
            }
        }

        static {
            s sVar = new s(true);
            f21659a = sVar;
            sVar.d();
        }

        private void d() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = c.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
        }

        public static s getDefaultInstance() {
            return f21659a;
        }

        public static b newBuilder(s sVar) {
            return newBuilder().h(sVar);
        }

        public int getId() {
            return this.id_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // fp.i, fp.q
        public fp.s<s> getParserForType() {
            return PARSER;
        }

        public boolean getReified() {
            return this.reified_;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.id_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iO += fp.f.o(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iO += fp.f.a(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iO += fp.f.h(4, this.variance_.getNumber());
            }
            for (int i11 = 0; i11 < this.upperBound_.size(); i11++) {
                iO += fp.f.s(5, this.upperBound_.get(i11));
            }
            int iP = 0;
            for (int i12 = 0; i12 < this.upperBoundId_.size(); i12++) {
                iP += fp.f.p(this.upperBoundId_.get(i12).intValue());
            }
            int iP2 = iO + iP;
            if (!getUpperBoundIdList().isEmpty()) {
                iP2 = iP2 + 1 + fp.f.p(iP);
            }
            this.upperBoundIdMemoizedSerializedSize = iP;
            int size = this.unknownFields.size() + extensionsSerializedSize() + iP2;
            this.memoizedSerializedSize = size;
            return size;
        }

        public q getUpperBound(int i10) {
            return this.upperBound_.get(i10);
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        public List<q> getUpperBoundList() {
            return this.upperBound_;
        }

        public c getVariance() {
            return this.variance_;
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReified() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasVariance() {
            return (this.bitField0_ & 8) == 8;
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
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i10 = 0; i10 < getUpperBoundCount(); i10++) {
                if (!getUpperBound(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            fp.i.d<MessageType>.a aVarNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.L(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                fVar.S(4, this.variance_.getNumber());
            }
            for (int i10 = 0; i10 < this.upperBound_.size(); i10++) {
                fVar.d0(5, this.upperBound_.get(i10));
            }
            if (getUpperBoundIdList().size() > 0) {
                fVar.o0(50);
                fVar.o0(this.upperBoundIdMemoizedSerializedSize);
            }
            for (int i11 = 0; i11 < this.upperBoundId_.size(); i11++) {
                fVar.b0(this.upperBoundId_.get(i11).intValue());
            }
            aVarNewExtensionWriter.a(1000, fVar);
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public s getDefaultInstanceForType() {
            return f21659a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public s(fp.i.c<s, ?> cVar) {
            super(cVar);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f6241a;
        }

        public s(boolean z10) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public s(fp.e eVar, fp.g gVar) throws fp.k {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            d();
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
                                this.id_ = eVar.A();
                            } else if (iK == 16) {
                                this.bitField0_ |= 2;
                                this.name_ = eVar.A();
                            } else if (iK == 24) {
                                this.bitField0_ |= 4;
                                this.reified_ = eVar.k();
                            } else if (iK == 32) {
                                int iA = eVar.A();
                                c cVarValueOf = c.valueOf(iA);
                                if (cVarValueOf == null) {
                                    fVarJ.o0(iK);
                                    fVarJ.o0(iA);
                                } else {
                                    this.bitField0_ |= 8;
                                    this.variance_ = cVarValueOf;
                                }
                            } else if (iK == 42) {
                                if ((i10 & 16) != 16) {
                                    this.upperBound_ = new ArrayList();
                                    i10 |= 16;
                                }
                                this.upperBound_.add((q) eVar.u(q.PARSER, gVar));
                            } else if (iK == 48) {
                                if ((i10 & 32) != 32) {
                                    this.upperBoundId_ = new ArrayList();
                                    i10 |= 32;
                                }
                                this.upperBoundId_.add(Integer.valueOf(eVar.A()));
                            } else if (iK != 50) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                int iJ = eVar.j(eVar.A());
                                if ((i10 & 32) != 32 && eVar.e() > 0) {
                                    this.upperBoundId_ = new ArrayList();
                                    i10 |= 32;
                                }
                                while (eVar.e() > 0) {
                                    this.upperBoundId_.add(Integer.valueOf(eVar.A()));
                                }
                                eVar.i(iJ);
                            }
                        }
                        z10 = true;
                    } catch (fp.k e10) {
                        throw e10.setUnfinishedMessage(this);
                    } catch (IOException e11) {
                        throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th2) {
                    if ((i10 & 16) == 16) {
                        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    }
                    if ((i10 & 32) == 32) {
                        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
            if ((i10 & 16) == 16) {
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
            }
            if ((i10 & 32) == 32) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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

    public static final class t extends fp.i implements yo.v {
        public static fp.s<t> PARSER = new C0595a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f21669a;
        private int bitField0_;
        private int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<q> type_;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: yo.a$t$a, reason: collision with other inner class name */
        public static class C0595a extends fp.b<t> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public t c(fp.e eVar, fp.g gVar) throws fp.k {
                return new t(eVar, gVar);
            }
        }

        public static final class b extends fp.i.b<t, b> implements yo.v {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f21670b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public List<q> f21671c = Collections.emptyList();

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21672d = -1;

            public static b j() {
                return new b();
            }

            public static b n() {
                return new b();
            }

            private void s() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return t.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return t.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                for (int i10 = 0; i10 < this.f21671c.size(); i10++) {
                    if (!q(i10).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public t build() {
                t tVarL = l();
                if (tVarL.isInitialized()) {
                    return tVarL;
                }
                throw new fp.w(tVarL);
            }

            public t l() {
                t tVar = new t(this);
                int i10 = this.f21670b;
                if ((i10 & 1) == 1) {
                    this.f21671c = Collections.unmodifiableList(this.f21671c);
                    this.f21670b &= -2;
                }
                tVar.type_ = this.f21671c;
                int i11 = (i10 & 2) != 2 ? 0 : 1;
                tVar.firstNullable_ = this.f21672d;
                tVar.bitField0_ = i11;
                return tVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(l());
            }

            public final void o() {
                if ((this.f21670b & 1) != 1) {
                    this.f21671c = new ArrayList(this.f21671c);
                    this.f21670b |= 1;
                }
            }

            public t p() {
                return t.getDefaultInstance();
            }

            public q q(int i10) {
                return this.f21671c.get(i10);
            }

            public int r() {
                return this.f21671c.size();
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                t tVar = null;
                try {
                    try {
                        t tVarC = t.PARSER.c(eVar, gVar);
                        if (tVarC != null) {
                            h(tVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        t tVar2 = (t) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            tVar = tVar2;
                            if (tVar != null) {
                                h(tVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (tVar != null) {
                        h(tVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public b h(t tVar) {
                if (tVar == t.getDefaultInstance()) {
                    return this;
                }
                if (!tVar.type_.isEmpty()) {
                    if (this.f21671c.isEmpty()) {
                        this.f21671c = tVar.type_;
                        this.f21670b &= -2;
                    } else {
                        o();
                        this.f21671c.addAll(tVar.type_);
                    }
                }
                if (tVar.hasFirstNullable()) {
                    v(tVar.getFirstNullable());
                }
                this.f6241a = this.f6241a.b(tVar.unknownFields);
                return this;
            }

            public b v(int i10) {
                this.f21670b |= 2;
                this.f21672d = i10;
                return this;
            }
        }

        static {
            t tVar = new t(true);
            f21669a = tVar;
            tVar.b();
        }

        private void b() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
        }

        public static t getDefaultInstance() {
            return f21669a;
        }

        public static b newBuilder(t tVar) {
            return newBuilder().h(tVar);
        }

        public int getFirstNullable() {
            return this.firstNullable_;
        }

        @Override // fp.i, fp.q
        public fp.s<t> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = 0;
            for (int i11 = 0; i11 < this.type_.size(); i11++) {
                iO += fp.f.s(1, this.type_.get(i11));
            }
            if ((this.bitField0_ & 1) == 1) {
                iO += fp.f.o(2, this.firstNullable_);
            }
            int size = this.unknownFields.size() + iO;
            this.memoizedSerializedSize = size;
            return size;
        }

        public q getType(int i10) {
            return this.type_.get(i10);
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        public List<q> getTypeList() {
            return this.type_;
        }

        public boolean hasFirstNullable() {
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
            for (int i10 = 0; i10 < getTypeCount(); i10++) {
                if (!getType(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            for (int i10 = 0; i10 < this.type_.size(); i10++) {
                fVar.d0(1, this.type_.get(i10));
            }
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(2, this.firstNullable_);
            }
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public t getDefaultInstanceForType() {
            return f21669a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public t(fp.i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public t(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public t(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            b();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 10) {
                                if (!z11) {
                                    this.type_ = new ArrayList();
                                    z11 = true;
                                }
                                this.type_.add((q) eVar.u(q.PARSER, gVar));
                            } else if (iK != 16) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.firstNullable_ = eVar.A();
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if (z11) {
                            this.type_ = Collections.unmodifiableList(this.type_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if (z11) {
                this.type_ = Collections.unmodifiableList(this.type_);
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

    public static final class u extends fp.i.d<u> implements yo.w {
        public static fp.s<u> PARSER = new C0596a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final u f21673a;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int typeId_;
        private q type_;
        private final fp.d unknownFields;
        private int varargElementTypeId_;
        private q varargElementType_;

        /* JADX INFO: renamed from: yo.a$u$a, reason: collision with other inner class name */
        public static class C0596a extends fp.b<u> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public u c(fp.e eVar, fp.g gVar) throws fp.k {
                return new u(eVar, gVar);
            }
        }

        public static final class b extends fp.i.c<u, b> implements yo.w {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21674d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f21675e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f21676f;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f21678i;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public int f21680p;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public q f21677g = q.getDefaultInstance();

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public q f21679n = q.getDefaultInstance();

            private void A() {
            }

            public static b p() {
                return new b();
            }

            public static b t() {
                return new b();
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                u uVar = null;
                try {
                    try {
                        u uVarC = u.PARSER.c(eVar, gVar);
                        if (uVarC != null) {
                            h(uVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        u uVar2 = (u) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            uVar = uVar2;
                            if (uVar != null) {
                                h(uVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (uVar != null) {
                        h(uVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
            public b h(u uVar) {
                if (uVar == u.getDefaultInstance()) {
                    return this;
                }
                if (uVar.hasFlags()) {
                    F(uVar.getFlags());
                }
                if (uVar.hasName()) {
                    G(uVar.getName());
                }
                if (uVar.hasType()) {
                    D(uVar.getType());
                }
                if (uVar.hasTypeId()) {
                    H(uVar.getTypeId());
                }
                if (uVar.hasVarargElementType()) {
                    E(uVar.getVarargElementType());
                }
                if (uVar.hasVarargElementTypeId()) {
                    I(uVar.getVarargElementTypeId());
                }
                o(uVar);
                this.f6241a = this.f6241a.b(uVar.unknownFields);
                return this;
            }

            public b D(q qVar) {
                if ((this.f21674d & 4) != 4 || this.f21677g == q.getDefaultInstance()) {
                    this.f21677g = qVar;
                } else {
                    this.f21677g = q.newBuilder(this.f21677g).h(qVar).r();
                }
                this.f21674d |= 4;
                return this;
            }

            public b E(q qVar) {
                if ((this.f21674d & 16) != 16 || this.f21679n == q.getDefaultInstance()) {
                    this.f21679n = qVar;
                } else {
                    this.f21679n = q.newBuilder(this.f21679n).h(qVar).r();
                }
                this.f21674d |= 16;
                return this;
            }

            public b F(int i10) {
                this.f21674d |= 1;
                this.f21675e = i10;
                return this;
            }

            public b G(int i10) {
                this.f21674d |= 2;
                this.f21676f = i10;
                return this;
            }

            public b H(int i10) {
                this.f21674d |= 8;
                this.f21678i = i10;
                return this;
            }

            public b I(int i10) {
                this.f21674d |= 32;
                this.f21680p = i10;
                return this;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return u.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return u.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                if (!x()) {
                    return false;
                }
                if (!y() || this.f21677g.isInitialized()) {
                    return (!z() || this.f21679n.isInitialized()) && this.f6242b.n();
                }
                return false;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public u build() {
                u uVarR = r();
                if (uVarR.isInitialized()) {
                    return uVarR;
                }
                throw new fp.w(uVarR);
            }

            public u r() {
                u uVar = new u(this);
                int i10 = this.f21674d;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                uVar.flags_ = this.f21675e;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                uVar.name_ = this.f21676f;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                uVar.type_ = this.f21677g;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                uVar.typeId_ = this.f21678i;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                uVar.varargElementType_ = this.f21679n;
                if ((i10 & 32) == 32) {
                    i11 |= 32;
                }
                uVar.varargElementTypeId_ = this.f21680p;
                uVar.bitField0_ = i11;
                return uVar;
            }

            @Override // fp.i.c
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(r());
            }

            public u u() {
                return u.getDefaultInstance();
            }

            public q v() {
                return this.f21677g;
            }

            public q w() {
                return this.f21679n;
            }

            public boolean x() {
                return (this.f21674d & 2) == 2;
            }

            public boolean y() {
                return (this.f21674d & 4) == 4;
            }

            public boolean z() {
                return (this.f21674d & 16) == 16;
            }
        }

        static {
            u uVar = new u(true);
            f21673a = uVar;
            uVar.d();
        }

        private void d() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = q.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = q.getDefaultInstance();
            this.varargElementTypeId_ = 0;
        }

        public static u getDefaultInstance() {
            return f21673a;
        }

        public static b newBuilder(u uVar) {
            return newBuilder().h(uVar);
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // fp.i, fp.q
        public fp.s<u> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iO += fp.f.o(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iO += fp.f.s(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iO += fp.f.s(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iO += fp.f.o(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                iO += fp.f.o(6, this.varargElementTypeId_);
            }
            int size = this.unknownFields.size() + extensionsSerializedSize() + iO;
            this.memoizedSerializedSize = size;
            return size;
        }

        public q getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public q getVarargElementType() {
            return this.varargElementType_;
        }

        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasVarargElementType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasVarargElementTypeId() {
            return (this.bitField0_ & 32) == 32;
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
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasType() && !getType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // fp.q
        public void writeTo(fp.f fVar) throws IOException {
            getSerializedSize();
            fp.i.d<MessageType>.a aVarNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                fVar.a0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.d0(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                fVar.d0(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                fVar.a0(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                fVar.a0(6, this.varargElementTypeId_);
            }
            aVarNewExtensionWriter.a(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, fVar);
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public u getDefaultInstanceForType() {
            return f21673a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public u(fp.i.c<u, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f6241a;
        }

        public u(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public u(fp.e eVar, fp.g gVar) throws fp.k {
            q.c builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            d();
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
                                this.flags_ = eVar.A();
                            } else if (iK != 16) {
                                if (iK == 26) {
                                    builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : null;
                                    q qVar = (q) eVar.u(q.PARSER, gVar);
                                    this.type_ = qVar;
                                    if (builder != null) {
                                        builder.h(qVar);
                                        this.type_ = builder.r();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (iK == 34) {
                                    builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : null;
                                    q qVar2 = (q) eVar.u(q.PARSER, gVar);
                                    this.varargElementType_ = qVar2;
                                    if (builder != null) {
                                        builder.h(qVar2);
                                        this.varargElementType_ = builder.r();
                                    }
                                    this.bitField0_ |= 16;
                                } else if (iK == 40) {
                                    this.bitField0_ |= 8;
                                    this.typeId_ = eVar.A();
                                } else if (iK != 48) {
                                    if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                    }
                                } else {
                                    this.bitField0_ |= 32;
                                    this.varargElementTypeId_ = eVar.A();
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.name_ = eVar.A();
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
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

    public static final class v extends fp.i implements yo.x {
        public static fp.s<v> PARSER = new C0597a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f21681a;
        private int bitField0_;
        private int errorCode_;
        private c level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int message_;
        private final fp.d unknownFields;
        private int versionFull_;
        private d versionKind_;
        private int version_;

        /* JADX INFO: renamed from: yo.a$v$a, reason: collision with other inner class name */
        public static class C0597a extends fp.b<v> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public v c(fp.e eVar, fp.g gVar) throws fp.k {
                return new v(eVar, gVar);
            }
        }

        public static final class b extends fp.i.b<v, b> implements yo.x {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f21682b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f21683c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f21684d;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f21686f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f21687g;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public c f21685e = c.ERROR;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public d f21688i = d.LANGUAGE_VERSION;

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
            public fp.i getDefaultInstanceForType() {
                return v.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return v.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public v build() {
                v vVarL = l();
                if (vVarL.isInitialized()) {
                    return vVarL;
                }
                throw new fp.w(vVarL);
            }

            public v l() {
                v vVar = new v(this);
                int i10 = this.f21682b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                vVar.version_ = this.f21683c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                vVar.versionFull_ = this.f21684d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                vVar.level_ = this.f21685e;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                vVar.errorCode_ = this.f21686f;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                vVar.message_ = this.f21687g;
                if ((i10 & 32) == 32) {
                    i11 |= 32;
                }
                vVar.versionKind_ = this.f21688i;
                vVar.bitField0_ = i11;
                return vVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(l());
            }

            public v o() {
                return v.getDefaultInstance();
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                v vVar = null;
                try {
                    try {
                        v vVarC = v.PARSER.c(eVar, gVar);
                        if (vVarC != null) {
                            h(vVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        v vVar2 = (v) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            vVar = vVar2;
                            if (vVar != null) {
                                h(vVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (vVar != null) {
                        h(vVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public b h(v vVar) {
                if (vVar == v.getDefaultInstance()) {
                    return this;
                }
                if (vVar.hasVersion()) {
                    v(vVar.getVersion());
                }
                if (vVar.hasVersionFull()) {
                    w(vVar.getVersionFull());
                }
                if (vVar.hasLevel()) {
                    t(vVar.getLevel());
                }
                if (vVar.hasErrorCode()) {
                    s(vVar.getErrorCode());
                }
                if (vVar.hasMessage()) {
                    u(vVar.getMessage());
                }
                if (vVar.hasVersionKind()) {
                    x(vVar.getVersionKind());
                }
                this.f6241a = this.f6241a.b(vVar.unknownFields);
                return this;
            }

            public b s(int i10) {
                this.f21682b |= 8;
                this.f21686f = i10;
                return this;
            }

            public b t(c cVar) {
                cVar.getClass();
                this.f21682b |= 4;
                this.f21685e = cVar;
                return this;
            }

            public b u(int i10) {
                this.f21682b |= 16;
                this.f21687g = i10;
                return this;
            }

            public b v(int i10) {
                this.f21682b |= 1;
                this.f21683c = i10;
                return this;
            }

            public b w(int i10) {
                this.f21682b |= 2;
                this.f21684d = i10;
                return this;
            }

            public b x(d dVar) {
                dVar.getClass();
                this.f21682b |= 32;
                this.f21688i = dVar;
                return this;
            }
        }

        public enum c implements fp.j.a {
            WARNING(0, 0),
            ERROR(1, 1),
            HIDDEN(2, 2);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static fp.j.b<c> f21689a = new C0598a();
            private final int value;

            /* JADX INFO: renamed from: yo.a$v$c$a, reason: collision with other inner class name */
            public static class C0598a implements fp.j.b<c> {
                public c a(int i10) {
                    return c.valueOf(i10);
                }

                @Override // fp.j.b
                public fp.j.a findValueByNumber(int i10) {
                    return c.valueOf(i10);
                }
            }

            c(int i10, int i11) {
                this.value = i11;
            }

            @Override // fp.j.a
            public final int getNumber() {
                return this.value;
            }

            public static c valueOf(int i10) {
                if (i10 == 0) {
                    return WARNING;
                }
                if (i10 == 1) {
                    return ERROR;
                }
                if (i10 != 2) {
                    return null;
                }
                return HIDDEN;
            }
        }

        public enum d implements fp.j.a {
            LANGUAGE_VERSION(0, 0),
            COMPILER_VERSION(1, 1),
            API_VERSION(2, 2);


            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static fp.j.b<d> f21691a = new C0599a();
            private final int value;

            /* JADX INFO: renamed from: yo.a$v$d$a, reason: collision with other inner class name */
            public static class C0599a implements fp.j.b<d> {
                public d a(int i10) {
                    return d.valueOf(i10);
                }

                @Override // fp.j.b
                public fp.j.a findValueByNumber(int i10) {
                    return d.valueOf(i10);
                }
            }

            d(int i10, int i11) {
                this.value = i11;
            }

            @Override // fp.j.a
            public final int getNumber() {
                return this.value;
            }

            public static d valueOf(int i10) {
                if (i10 == 0) {
                    return LANGUAGE_VERSION;
                }
                if (i10 == 1) {
                    return COMPILER_VERSION;
                }
                if (i10 != 2) {
                    return null;
                }
                return API_VERSION;
            }
        }

        static {
            v vVar = new v(true);
            f21681a = vVar;
            vVar.b();
        }

        private void b() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = c.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = d.LANGUAGE_VERSION;
        }

        public static v getDefaultInstance() {
            return f21681a;
        }

        public static b newBuilder(v vVar) {
            return newBuilder().h(vVar);
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public c getLevel() {
            return this.level_;
        }

        public int getMessage() {
            return this.message_;
        }

        @Override // fp.i, fp.q
        public fp.s<v> getParserForType() {
            return PARSER;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.bitField0_ & 1) == 1 ? fp.f.o(1, this.version_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iO += fp.f.o(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iO += fp.f.h(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                iO += fp.f.o(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                iO += fp.f.o(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                iO += fp.f.h(6, this.versionKind_.getNumber());
            }
            int size = this.unknownFields.size() + iO;
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getVersion() {
            return this.version_;
        }

        public int getVersionFull() {
            return this.versionFull_;
        }

        public d getVersionKind() {
            return this.versionKind_;
        }

        public boolean hasErrorCode() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasLevel() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasMessage() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasVersionFull() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasVersionKind() {
            return (this.bitField0_ & 32) == 32;
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
                fVar.a0(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                fVar.a0(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                fVar.S(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                fVar.a0(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                fVar.a0(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                fVar.S(6, this.versionKind_.getNumber());
            }
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public v getDefaultInstanceForType() {
            return f21681a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public v(fp.i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public v(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public v(fp.e eVar, fp.g gVar) throws fp.k {
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
                                this.version_ = eVar.A();
                            } else if (iK == 16) {
                                this.bitField0_ |= 2;
                                this.versionFull_ = eVar.A();
                            } else if (iK == 24) {
                                int iA = eVar.A();
                                c cVarValueOf = c.valueOf(iA);
                                if (cVarValueOf == null) {
                                    fVarJ.o0(iK);
                                    fVarJ.o0(iA);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.level_ = cVarValueOf;
                                }
                            } else if (iK == 32) {
                                this.bitField0_ |= 8;
                                this.errorCode_ = eVar.A();
                            } else if (iK == 40) {
                                this.bitField0_ |= 16;
                                this.message_ = eVar.A();
                            } else if (iK != 48) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                int iA2 = eVar.A();
                                d dVarValueOf = d.valueOf(iA2);
                                if (dVarValueOf == null) {
                                    fVarJ.o0(iK);
                                    fVarJ.o0(iA2);
                                } else {
                                    this.bitField0_ |= 32;
                                    this.versionKind_ = dVarValueOf;
                                }
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
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

    public static final class w extends fp.i implements y {
        public static fp.s<w> PARSER = new C0600a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final w f21693a;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<v> requirement_;
        private final fp.d unknownFields;

        /* JADX INFO: renamed from: yo.a$w$a, reason: collision with other inner class name */
        public static class C0600a extends fp.b<w> {
            @Override // fp.s
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public w c(fp.e eVar, fp.g gVar) throws fp.k {
                return new w(eVar, gVar);
            }
        }

        public static final class b extends fp.i.b<w, b> implements y {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f21694b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public List<v> f21695c = Collections.emptyList();

            public static b j() {
                return new b();
            }

            public static b n() {
                return new b();
            }

            private void q() {
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: f */
            public fp.i getDefaultInstanceForType() {
                return w.getDefaultInstance();
            }

            @Override // fp.i.b, fp.r
            public fp.q getDefaultInstanceForType() {
                return w.getDefaultInstance();
            }

            @Override // fp.r
            public final boolean isInitialized() {
                return true;
            }

            @Override // fp.q.a
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public w build() {
                w wVarL = l();
                if (wVarL.isInitialized()) {
                    return wVarL;
                }
                throw new fp.w(wVarL);
            }

            public w l() {
                w wVar = new w(this);
                if ((this.f21694b & 1) == 1) {
                    this.f21695c = Collections.unmodifiableList(this.f21695c);
                    this.f21694b &= -2;
                }
                wVar.requirement_ = this.f21695c;
                return wVar;
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b l() {
                return new b().h(l());
            }

            public final void o() {
                if ((this.f21694b & 1) != 1) {
                    this.f21695c = new ArrayList(this.f21695c);
                    this.f21694b |= 1;
                }
            }

            public w p() {
                return w.getDefaultInstance();
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // fp.a.AbstractC0147a, fp.q.a
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public b c(fp.e eVar, fp.g gVar) throws Throwable {
                w wVar = null;
                try {
                    try {
                        w wVarC = w.PARSER.c(eVar, gVar);
                        if (wVarC != null) {
                            h(wVarC);
                        }
                        return this;
                    } catch (fp.k e10) {
                        w wVar2 = (w) e10.getUnfinishedMessage();
                        try {
                            throw e10;
                        } catch (Throwable th2) {
                            th = th2;
                            wVar = wVar2;
                            if (wVar != null) {
                                h(wVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (wVar != null) {
                        h(wVar);
                    }
                    throw th;
                }
            }

            @Override // fp.i.b
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public b h(w wVar) {
                if (wVar == w.getDefaultInstance()) {
                    return this;
                }
                if (!wVar.requirement_.isEmpty()) {
                    if (this.f21695c.isEmpty()) {
                        this.f21695c = wVar.requirement_;
                        this.f21694b &= -2;
                    } else {
                        o();
                        this.f21695c.addAll(wVar.requirement_);
                    }
                }
                this.f6241a = this.f6241a.b(wVar.unknownFields);
                return this;
            }
        }

        static {
            w wVar = new w(true);
            f21693a = wVar;
            wVar.b();
        }

        private void b() {
            this.requirement_ = Collections.emptyList();
        }

        public static w getDefaultInstance() {
            return f21693a;
        }

        public static b newBuilder(w wVar) {
            return newBuilder().h(wVar);
        }

        @Override // fp.i, fp.q
        public fp.s<w> getParserForType() {
            return PARSER;
        }

        public int getRequirementCount() {
            return this.requirement_.size();
        }

        public List<v> getRequirementList() {
            return this.requirement_;
        }

        @Override // fp.q
        public int getSerializedSize() {
            int i10 = this.memoizedSerializedSize;
            if (i10 != -1) {
                return i10;
            }
            int iS = 0;
            for (int i11 = 0; i11 < this.requirement_.size(); i11++) {
                iS += fp.f.s(1, this.requirement_.get(i11));
            }
            int size = this.unknownFields.size() + iS;
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
            for (int i10 = 0; i10 < this.requirement_.size(); i10++) {
                fVar.d0(1, this.requirement_.get(i10));
            }
            fVar.i0(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // fp.r
        public w getDefaultInstanceForType() {
            return f21693a;
        }

        @Override // fp.q
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // fp.q
        public b toBuilder() {
            return newBuilder(this);
        }

        public w(fp.i.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f6241a;
        }

        public w(boolean z10) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = fp.d.f6202a;
        }

        public w(fp.e eVar, fp.g gVar) throws fp.k {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            b();
            fp.d.b bVarQ = fp.d.q();
            fp.f fVarJ = fp.f.J(bVarQ, 1);
            boolean z10 = false;
            boolean z11 = false;
            while (!z10) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK != 10) {
                                if (!parseUnknownField(eVar, fVarJ, gVar, iK)) {
                                }
                            } else {
                                if (!z11) {
                                    this.requirement_ = new ArrayList();
                                    z11 = true;
                                }
                                this.requirement_.add((v) eVar.u(v.PARSER, gVar));
                            }
                        }
                        z10 = true;
                    } catch (Throwable th2) {
                        if (z11) {
                            this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
                } catch (fp.k e10) {
                    throw e10.setUnfinishedMessage(this);
                } catch (IOException e11) {
                    throw new fp.k(e11.getMessage()).setUnfinishedMessage(this);
                }
            }
            if (z11) {
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
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

    public enum x implements fp.j.a {
        INTERNAL(0, 0),
        PRIVATE(1, 1),
        PROTECTED(2, 2),
        PUBLIC(3, 3),
        PRIVATE_TO_THIS(4, 4),
        LOCAL(5, 5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static fp.j.b<x> f21696a = new C0601a();
        private final int value;

        /* JADX INFO: renamed from: yo.a$x$a, reason: collision with other inner class name */
        public static class C0601a implements fp.j.b<x> {
            public x a(int i10) {
                return x.valueOf(i10);
            }

            @Override // fp.j.b
            public fp.j.a findValueByNumber(int i10) {
                return x.valueOf(i10);
            }
        }

        x(int i10, int i11) {
            this.value = i11;
        }

        @Override // fp.j.a
        public final int getNumber() {
            return this.value;
        }

        public static x valueOf(int i10) {
            if (i10 == 0) {
                return INTERNAL;
            }
            if (i10 == 1) {
                return PRIVATE;
            }
            if (i10 == 2) {
                return PROTECTED;
            }
            if (i10 == 3) {
                return PUBLIC;
            }
            if (i10 == 4) {
                return PRIVATE_TO_THIS;
            }
            if (i10 != 5) {
                return null;
            }
            return LOCAL;
        }
    }
}
