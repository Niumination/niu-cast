package fn;

import com.transsion.connectx.mirror.source.pad.FloatingWindow;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.r1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@f
public final class n implements gq.m<Path> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Path f6151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final p[] f6152b;

    @r1({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,177:1\n45#2,15:178\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n*L\n98#1:178,15\n*E\n"})
    @xm.f(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {184, 190}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "queue", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    public static final class a extends xm.k implements jn.p<gq.o<? super Path>, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        public a(um.d<? super a> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = n.this.new a(dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l gq.o<? super Path> oVar, @os.m um.d<? super l2> dVar) {
            return ((a) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0077  */
        /* JADX WARN: Code duplicated, block: B:17:0x009f  */
        /* JADX WARN: Code duplicated, block: B:19:0x00a5  */
        /* JADX WARN: Code duplicated, block: B:21:0x00b9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:22:0x00ba  */
        /* JADX WARN: Code duplicated, block: B:24:0x00c8 A[PHI: r1 r5 r6 r7 r8 r13
          0x00c8: PHI (r1v3 fn.d) = (r1v5 fn.d), (r1v6 fn.d) binds: [B:23:0x00c1, B:18:0x00a3] A[DONT_GENERATE, DONT_INLINE]
          0x00c8: PHI (r5v2 nm.k) = (r5v4 nm.k), (r5v5 nm.k) binds: [B:23:0x00c1, B:18:0x00a3] A[DONT_GENERATE, DONT_INLINE]
          0x00c8: PHI (r6v4 gq.o) = (r6v6 gq.o), (r6v7 gq.o) binds: [B:23:0x00c1, B:18:0x00a3] A[DONT_GENERATE, DONT_INLINE]
          0x00c8: PHI (r7v3 fn.n) = (r7v11 fn.n), (r7v12 fn.n) binds: [B:23:0x00c1, B:18:0x00a3] A[DONT_GENERATE, DONT_INLINE]
          0x00c8: PHI (r8v1 java.nio.file.Path) = (r8v3 java.nio.file.Path), (r8v4 java.nio.file.Path) binds: [B:23:0x00c1, B:18:0x00a3] A[DONT_GENERATE, DONT_INLINE]
          0x00c8: PHI (r13v3 fn.l) = (r13v6 fn.l), (r13v9 fn.l) binds: [B:23:0x00c1, B:18:0x00a3] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:26:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:27:0x00ea  */
        /* JADX WARN: Code duplicated, block: B:29:0x00f4  */
        /* JADX WARN: Code duplicated, block: B:37:0x0106 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:38:0x0099 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:39:0x011a A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:41:0x0071 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:42:0x0071 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00de -> B:11:0x0071). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00e0 -> B:11:0x0071). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:17:0x009f
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 286
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: fn.n.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @r1({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,177:1\n45#2,15:178\n45#2,15:193\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n*L\n67#1:178,15\n78#1:193,15\n*E\n"})
    @xm.f(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {184, 190, 199, 205}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
    public static final class b extends xm.k implements jn.p<gq.o<? super Path>, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        public b(um.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            b bVar = n.this.new b(dVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l gq.o<? super Path> oVar, @os.m um.d<? super l2> dVar) {
            return ((b) create(oVar, dVar)).invokeSuspend(l2.f10208a);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x0133  */
        /* JADX WARN: Code duplicated, block: B:44:0x016c  */
        /* JADX WARN: Code duplicated, block: B:46:0x0172  */
        /* JADX WARN: Code duplicated, block: B:48:0x0186 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:49:0x0187  */
        /* JADX WARN: Code duplicated, block: B:51:0x0195 A[PHI: r1 r4 r7 r8 r9 r15
          0x0195: PHI (r1v9 fn.d) = (r1v7 fn.d), (r1v11 fn.d) binds: [B:45:0x0170, B:50:0x018e] A[DONT_GENERATE, DONT_INLINE]
          0x0195: PHI (r4v18 nm.k) = (r4v16 nm.k), (r4v20 nm.k) binds: [B:45:0x0170, B:50:0x018e] A[DONT_GENERATE, DONT_INLINE]
          0x0195: PHI (r7v9 gq.o) = (r7v7 gq.o), (r7v11 gq.o) binds: [B:45:0x0170, B:50:0x018e] A[DONT_GENERATE, DONT_INLINE]
          0x0195: PHI (r8v15 fn.n) = (r8v13 fn.n), (r8v25 fn.n) binds: [B:45:0x0170, B:50:0x018e] A[DONT_GENERATE, DONT_INLINE]
          0x0195: PHI (r9v12 java.nio.file.Path) = (r9v10 java.nio.file.Path), (r9v14 java.nio.file.Path) binds: [B:45:0x0170, B:50:0x018e] A[DONT_GENERATE, DONT_INLINE]
          0x0195: PHI (r15v20 fn.l) = (r15v12 fn.l), (r15v21 fn.l) binds: [B:45:0x0170, B:50:0x018e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:53:0x01ad  */
        /* JADX WARN: Code duplicated, block: B:54:0x01bc  */
        /* JADX WARN: Code duplicated, block: B:67:0x0166 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:69:0x0144 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01ab -> B:36:0x012d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01ad -> B:36:0x012d). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r15) {
            /*
                Method dump skipped, instruction units count: 501
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: fn.n.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public n(@os.l Path path, @os.l p[] pVarArr) {
        l0.p(path, FloatingWindow.f2048b0);
        l0.p(pVarArr, "options");
        this.f6151a = path;
        this.f6152b = pVarArr;
    }

    public final Iterator<Path> g() {
        return gq.q.a(new a(null));
    }

    public final Iterator<Path> h() {
        return gq.q.a(new b(null));
    }

    public final boolean i() {
        return nm.r.s8(this.f6152b, p.FOLLOW_LINKS);
    }

    @Override // gq.m
    @os.l
    public Iterator<Path> iterator() {
        return l() ? g() : h();
    }

    public final boolean j() {
        return nm.r.s8(this.f6152b, p.INCLUDE_DIRECTORIES);
    }

    public final LinkOption[] k() {
        return j.f6137a.a(i());
    }

    public final boolean l() {
        return nm.r.s8(this.f6152b, p.BREADTH_FIRST);
    }

    public final Object m(gq.o<? super Path> oVar, l lVar, d dVar, jn.l<? super List<l>, l2> lVar2, um.d<? super l2> dVar2) throws FileSystemLoopException {
        Path path = lVar.f6144a;
        LinkOption[] linkOptionArrK = k();
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptionArrK, linkOptionArrK.length);
        if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            if (o.c(lVar)) {
                throw new FileSystemLoopException(path.toString());
            }
            if (j()) {
                oVar.a(path, dVar2);
            }
            LinkOption[] linkOptionArrK2 = k();
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArrK2, linkOptionArrK2.length);
            if (Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                lVar2.invoke(dVar.c(lVar));
            }
        } else if (Files.exists(path, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            oVar.a(path, dVar2);
            return l2.f10208a;
        }
        return l2.f10208a;
    }
}
