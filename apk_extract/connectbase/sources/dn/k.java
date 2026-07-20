package dn;

import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kn.l0;
import kn.r1;
import lm.i0;
import lm.l2;
import nm.s1;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements gq.m<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final File f3760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final l f3761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final jn.l<File, Boolean> f3762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final jn.l<File, l2> f3763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public final jn.p<File, IOException, l2> f3764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3765f;

    @r1({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$DirectoryState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
    public static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@os.l File file) {
            super(file);
            l0.p(file, "rootDir");
        }
    }

    public final class b extends nm.b<File> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final ArrayDeque<c> f3766c;

        public final class a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f3768b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @os.m
            public File[] f3769c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f3770d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f3771e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ b f3772f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@os.l b bVar, File file) {
                super(file);
                l0.p(file, "rootDir");
                this.f3772f = bVar;
            }

            @Override // dn.k.c
            @os.m
            public File b() {
                if (!this.f3771e && this.f3769c == null) {
                    jn.l<File, Boolean> lVar = k.this.f3762c;
                    if (lVar != null && !lVar.invoke(this.f3780a).booleanValue()) {
                        return null;
                    }
                    File[] fileArrListFiles = this.f3780a.listFiles();
                    this.f3769c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        jn.p<File, IOException, l2> pVar = k.this.f3764e;
                        if (pVar != null) {
                            pVar.invoke(this.f3780a, new dn.a(this.f3780a, null, "Cannot list files in a directory", 2, null));
                        }
                        this.f3771e = true;
                    }
                }
                File[] fileArr = this.f3769c;
                if (fileArr != null) {
                    int i10 = this.f3770d;
                    l0.m(fileArr);
                    if (i10 < fileArr.length) {
                        File[] fileArr2 = this.f3769c;
                        l0.m(fileArr2);
                        int i11 = this.f3770d;
                        this.f3770d = i11 + 1;
                        return fileArr2[i11];
                    }
                }
                if (!this.f3768b) {
                    this.f3768b = true;
                    return this.f3780a;
                }
                jn.l<File, l2> lVar2 = k.this.f3763d;
                if (lVar2 != null) {
                    lVar2.invoke(this.f3780a);
                }
                return null;
            }
        }

        /* JADX INFO: renamed from: dn.k$b$b, reason: collision with other inner class name */
        @r1({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
        public final class C0087b extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f3773b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ b f3774c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0087b(@os.l b bVar, File file) {
                super(file);
                l0.p(file, "rootFile");
                this.f3774c = bVar;
            }

            @Override // dn.k.c
            @os.m
            public File b() {
                if (this.f3773b) {
                    return null;
                }
                this.f3773b = true;
                return this.f3780a;
            }
        }

        public final class c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f3775b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @os.m
            public File[] f3776c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f3777d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ b f3778e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@os.l b bVar, File file) {
                super(file);
                l0.p(file, "rootDir");
                this.f3778e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // dn.k.c
            @os.m
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public java.io.File b() {
                /*
                    r10 = this;
                    boolean r0 = r10.f3775b
                    r1 = 0
                    if (r0 != 0) goto L22
                    dn.k$b r0 = r10.f3778e
                    dn.k r0 = dn.k.this
                    jn.l<java.io.File, java.lang.Boolean> r0 = r0.f3762c
                    if (r0 == 0) goto L1c
                    java.io.File r2 = r10.f3780a
                    java.lang.Object r0 = r0.invoke(r2)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L1c
                    return r1
                L1c:
                    r0 = 1
                    r10.f3775b = r0
                    java.io.File r10 = r10.f3780a
                    return r10
                L22:
                    java.io.File[] r0 = r10.f3776c
                    if (r0 == 0) goto L3d
                    int r2 = r10.f3777d
                    kn.l0.m(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L2f
                    goto L3d
                L2f:
                    dn.k$b r0 = r10.f3778e
                    dn.k r0 = dn.k.this
                    jn.l<java.io.File, lm.l2> r0 = r0.f3763d
                    if (r0 == 0) goto L3c
                    java.io.File r10 = r10.f3780a
                    r0.invoke(r10)
                L3c:
                    return r1
                L3d:
                    java.io.File[] r0 = r10.f3776c
                    if (r0 != 0) goto L7d
                    java.io.File r0 = r10.f3780a
                    java.io.File[] r0 = r0.listFiles()
                    r10.f3776c = r0
                    if (r0 != 0) goto L65
                    dn.k$b r0 = r10.f3778e
                    dn.k r0 = dn.k.this
                    jn.p<java.io.File, java.io.IOException, lm.l2> r0 = r0.f3764e
                    if (r0 == 0) goto L65
                    java.io.File r2 = r10.f3780a
                    dn.a r9 = new dn.a
                    java.io.File r4 = r10.f3780a
                    r7 = 2
                    r8 = 0
                    r5 = 0
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3 = r9
                    r3.<init>(r4, r5, r6, r7, r8)
                    r0.invoke(r2, r9)
                L65:
                    java.io.File[] r0 = r10.f3776c
                    if (r0 == 0) goto L6f
                    kn.l0.m(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L7d
                L6f:
                    dn.k$b r0 = r10.f3778e
                    dn.k r0 = dn.k.this
                    jn.l<java.io.File, lm.l2> r0 = r0.f3763d
                    if (r0 == 0) goto L7c
                    java.io.File r10 = r10.f3780a
                    r0.invoke(r10)
                L7c:
                    return r1
                L7d:
                    java.io.File[] r0 = r10.f3776c
                    kn.l0.m(r0)
                    int r1 = r10.f3777d
                    int r2 = r1 + 1
                    r10.f3777d = r2
                    r10 = r0[r1]
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: dn.k.b.c.b():java.io.File");
            }
        }

        public /* synthetic */ class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f3779a;

            static {
                int[] iArr = new int[l.values().length];
                try {
                    iArr[l.TOP_DOWN.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[l.BOTTOM_UP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f3779a = iArr;
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f3766c = arrayDeque;
            if (k.this.f3760a.isDirectory()) {
                arrayDeque.push(g(k.this.f3760a));
            } else if (k.this.f3760a.isFile()) {
                arrayDeque.push(new C0087b(this, k.this.f3760a));
            } else {
                this.f11609a = s1.Done;
            }
        }

        @Override // nm.b
        public void a() {
            File fileH = h();
            if (fileH != null) {
                e(fileH);
            } else {
                this.f11609a = s1.Done;
            }
        }

        public final a g(File file) {
            int i10 = d.f3779a[k.this.f3761b.ordinal()];
            if (i10 == 1) {
                return new c(this, file);
            }
            if (i10 == 2) {
                return new a(this, file);
            }
            throw new i0();
        }

        public final File h() {
            while (true) {
                c cVarPeek = this.f3766c.peek();
                if (cVarPeek == null) {
                    return null;
                }
                File fileB = cVarPeek.b();
                if (fileB == null) {
                    this.f3766c.pop();
                } else {
                    if (l0.g(fileB, cVarPeek.f3780a) || !fileB.isDirectory() || this.f3766c.size() >= k.this.f3765f) {
                        return fileB;
                    }
                    this.f3766c.push(g(fileB));
                }
            }
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final File f3780a;

        public c(@os.l File file) {
            l0.p(file, "root");
            this.f3780a = file;
        }

        @os.l
        public final File a() {
            return this.f3780a;
        }

        @os.m
        public abstract File b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(File file, l lVar, jn.l<? super File, Boolean> lVar2, jn.l<? super File, l2> lVar3, jn.p<? super File, ? super IOException, l2> pVar, int i10) {
        this.f3760a = file;
        this.f3761b = lVar;
        this.f3762c = lVar2;
        this.f3763d = lVar3;
        this.f3764e = pVar;
        this.f3765f = i10;
    }

    @os.l
    public final k i(int i10) {
        if (i10 > 0) {
            return new k(this.f3760a, this.f3761b, this.f3762c, this.f3763d, this.f3764e, i10);
        }
        throw new IllegalArgumentException("depth must be positive, but was " + i10 + n1.e.f11183c);
    }

    @Override // gq.m
    @os.l
    public Iterator<File> iterator() {
        return new b();
    }

    @os.l
    public final k j(@os.l jn.l<? super File, Boolean> lVar) {
        l0.p(lVar, "function");
        return new k(this.f3760a, this.f3761b, lVar, this.f3763d, this.f3764e, this.f3765f);
    }

    @os.l
    public final k k(@os.l jn.p<? super File, ? super IOException, l2> pVar) {
        l0.p(pVar, "function");
        return new k(this.f3760a, this.f3761b, this.f3762c, this.f3763d, pVar, this.f3765f);
    }

    @os.l
    public final k l(@os.l jn.l<? super File, l2> lVar) {
        l0.p(lVar, "function");
        return new k(this.f3760a, this.f3761b, this.f3762c, lVar, this.f3764e, this.f3765f);
    }

    public /* synthetic */ k(File file, l lVar, jn.l lVar2, jn.l lVar3, jn.p pVar, int i10, int i11, kn.w wVar) {
        this(file, (i11 & 2) != 0 ? l.TOP_DOWN : lVar, lVar2, lVar3, pVar, (i11 & 32) != 0 ? Integer.MAX_VALUE : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(@os.l File file, @os.l l lVar) {
        this(file, lVar, null, null, null, 0, 32, null);
        l0.p(file, FloatingWindow.f2048b0);
        l0.p(lVar, "direction");
    }

    public /* synthetic */ k(File file, l lVar, int i10, kn.w wVar) {
        this(file, (i10 & 2) != 0 ? l.TOP_DOWN : lVar);
    }
}
