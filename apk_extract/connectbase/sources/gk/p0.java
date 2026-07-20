package gk;

import ik.i1;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.List;
import lm.l2;
import nq.k1;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final byte[] f6687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f6688b;

    @xm.f(c = "io.ktor.features.MultipleRangeWriterKt$writeMultipleRangesImpl$1", f = "MultipleRangeWriter.kt", i = {0, 0, 1, 2, 3}, l = {40, 41, 42, 45, 46}, m = "invokeSuspend", n = {"$this$writer", "current", "$this$writer", "$this$writer", "$this$writer"}, s = {"L$0", "L$2", "L$0", "L$0", "L$0"})
    public static final class a extends xm.o implements jn.p<pl.m0, um.d<? super l2>, Object> {
        final /* synthetic */ String $boundary;
        final /* synthetic */ jn.l<tn.o, pl.k> $channelProducer;
        final /* synthetic */ String $contentType;
        final /* synthetic */ Long $fullLength;
        final /* synthetic */ List<tn.o> $ranges;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(List<tn.o> list, jn.l<? super tn.o, ? extends pl.k> lVar, String str, String str2, Long l10, um.d<? super a> dVar) {
            super(2, dVar);
            this.$ranges = list;
            this.$channelProducer = lVar;
            this.$boundary = str;
            this.$contentType = str2;
            this.$fullLength = l10;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            a aVar = new a(this.$ranges, this.$channelProducer, this.$boundary, this.$contentType, this.$fullLength, dVar);
            aVar.L$0 = obj;
            return aVar;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x006e  */
        /* JADX WARN: Code duplicated, block: B:22:0x009a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x009b  */
        /* JADX WARN: Code duplicated, block: B:26:0x00b6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:30:0x00cd A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00cb -> B:14:0x0039). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 270
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: gk.p0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.m0 m0Var, @os.m um.d<? super l2> dVar) {
            return ((a) create(m0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    static {
        byte[] bytes = "\r\n".getBytes(jq.f.f8805g);
        kn.l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        f6687a = bytes;
        ik.j0 j0Var = ik.j0.f8048a;
        j0Var.getClass();
        int length = ik.j0.f8086t.length() + 14;
        j0Var.getClass();
        f6688b = ik.j0.f8084s.length() + length;
    }

    public static final int c(tn.o oVar, String str, String str2, Long l10) {
        String strA = ik.h.a(oVar, l10, i1.Bytes);
        return strA.length() + str2.length() + str.length() + f6688b;
    }

    public static final long d(@os.l List<tn.o> list, @os.m Long l10, @os.l String str, @os.l String str2) {
        kn.l0.p(list, "ranges");
        kn.l0.p(str, HttpHeaders.Values.BOUNDARY);
        kn.l0.p(str2, "contentType");
        long jC = 0;
        for (tn.o oVar : list) {
            jC += ((((long) c(oVar, str, str2, l10)) + oVar.f15922b) - oVar.f15921a) + 3;
        }
        return jC + ((long) str.length()) + ((long) 6);
    }

    public static final Object e(pl.n nVar, tn.o oVar, String str, String str2, Long l10, um.d<? super l2> dVar) {
        String strA = ik.h.a(oVar, l10, i1.Bytes);
        StringBuilder sb2 = new StringBuilder(strA.length() + str2.length() + str.length() + f6688b);
        sb2.append("--");
        sb2.append(str);
        sb2.append("\r\n");
        ik.j0 j0Var = ik.j0.f8048a;
        j0Var.getClass();
        sb2.append(ik.j0.f8086t);
        sb2.append(": ");
        sb2.append(str2);
        sb2.append("\r\n");
        j0Var.getClass();
        sb2.append(ik.j0.f8084s);
        sb2.append(": ");
        sb2.append(strA);
        sb2.append("\r\n\r\n");
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        byte[] bytes = string.getBytes(jq.f.f8805g);
        kn.l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        Object objF = pl.o.f(nVar, bytes, dVar);
        return objF == wm.a.COROUTINE_SUSPENDED ? objF : l2.f10208a;
    }

    @lm.k(message = "This is going to be removed. Use PartialContent feature instead.")
    @os.l
    public static final pl.k f(@os.l nq.s0 s0Var, @os.l jn.l<? super tn.o, ? extends pl.k> lVar, @os.l List<tn.o> list, @os.m Long l10, @os.l String str, @os.l String str2) {
        kn.l0.p(s0Var, "<this>");
        kn.l0.p(lVar, "channelProducer");
        kn.l0.p(list, "ranges");
        kn.l0.p(str, HttpHeaders.Values.BOUNDARY);
        kn.l0.p(str2, "contentType");
        return g(s0Var, lVar, list, l10, str, str2);
    }

    @os.l
    public static final pl.k g(@os.l nq.s0 s0Var, @os.l jn.l<? super tn.o, ? extends pl.k> lVar, @os.l List<tn.o> list, @os.m Long l10, @os.l String str, @os.l String str2) {
        kn.l0.p(s0Var, "<this>");
        kn.l0.p(lVar, "channelProducer");
        kn.l0.p(list, "ranges");
        kn.l0.p(str, HttpHeaders.Values.BOUNDARY);
        kn.l0.p(str2, "contentType");
        return pl.v.k(s0Var, k1.g(), true, new a(list, lVar, str, str2, l10, null)).a();
    }
}
