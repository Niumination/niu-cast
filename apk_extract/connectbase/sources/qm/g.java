package qm;

import ik.v;
import in.i;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import jn.p;
import jn.q;
import kn.l0;
import kn.n0;
import kn.r1;
import lm.a1;
import lm.a2;
import lm.b2;
import lm.f1;
import lm.g2;
import lm.h2;
import lm.k;
import lm.l2;
import lm.p2;
import lm.s0;
import lm.s1;
import lm.t;
import lm.t1;
import lm.w1;
import lm.x1;
import nm.c1;
import nm.d0;
import nm.g0;
import nm.h0;
import nm.k0;
import nm.o;
import nm.r;
import nm.t0;
import nm.u1;
import nm.v0;
import nm.x;
import nm.z;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\n_UArrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _UArrays.kt\nkotlin/collections/unsigned/UArraysKt___UArraysKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,10733:1\n3775#1:10734\n3783#1:10735\n3791#1:10736\n3799#1:10737\n3775#1:10738\n3783#1:10739\n3791#1:10740\n3799#1:10741\n3775#1:10742\n3783#1:10743\n3791#1:10744\n3799#1:10745\n3775#1:10795\n3783#1:10796\n3791#1:10797\n3799#1:10798\n3775#1:10799\n3783#1:10800\n3791#1:10801\n3799#1:10802\n3775#1:10803\n3783#1:10804\n3791#1:10805\n3799#1:10806\n3775#1:10863\n3783#1:10864\n3791#1:10865\n3799#1:10866\n3775#1:10867\n3783#1:10868\n3791#1:10869\n3799#1:10870\n3775#1:10871\n3783#1:10872\n3791#1:10873\n3799#1:10874\n3775#1:10875\n3783#1:10876\n3791#1:10877\n3799#1:10878\n3775#1:10879\n3783#1:10880\n3791#1:10881\n3799#1:10882\n3775#1:10883\n3783#1:10884\n3791#1:10885\n3799#1:10886\n3775#1:10887\n3783#1:10888\n3791#1:10889\n3799#1:10890\n3775#1:10891\n3783#1:10892\n3791#1:10893\n3799#1:10894\n3775#1:10895\n3783#1:10896\n3791#1:10897\n3799#1:10898\n3775#1:10899\n3783#1:10900\n3791#1:10901\n3799#1:10902\n3775#1:10903\n3783#1:10904\n3791#1:10905\n3799#1:10906\n3775#1:10907\n3783#1:10908\n3791#1:10909\n3799#1:10910\n3775#1:10911\n3783#1:10912\n3791#1:10913\n3799#1:10914\n3775#1:10915\n3783#1:10916\n3791#1:10917\n3799#1:10918\n3775#1:10919\n3783#1:10920\n3791#1:10921\n3799#1:10922\n3775#1:10923\n3783#1:10924\n3791#1:10925\n3799#1:10926\n3775#1:10927\n3783#1:10928\n3791#1:10929\n3799#1:10930\n3775#1:10931\n3783#1:10932\n3791#1:10933\n3799#1:10934\n3775#1:10935\n3783#1:10936\n3791#1:10937\n3799#1:10938\n3775#1:10939\n3783#1:10940\n3791#1:10941\n3799#1:10942\n3775#1:10943\n3783#1:10944\n3791#1:10945\n3799#1:10946\n3775#1:10947\n3783#1:10948\n3791#1:10949\n3799#1:10950\n3775#1:10951\n3783#1:10952\n3791#1:10953\n3799#1:10954\n3775#1:10955\n3783#1:10956\n3791#1:10957\n3799#1:10958\n3775#1:10959\n3783#1:10960\n3791#1:10961\n3799#1:10962\n3775#1:10963\n3783#1:10964\n3791#1:10965\n3799#1:10966\n3775#1:10967\n3783#1:10968\n3791#1:10969\n3799#1:10970\n3775#1:10971\n3783#1:10972\n3791#1:10973\n3799#1:10974\n3775#1:10975\n3783#1:10976\n3791#1:10977\n3799#1:10978\n3775#1:10979\n3783#1:10980\n3791#1:10981\n3799#1:10982\n3775#1:10983\n3783#1:10984\n3791#1:10985\n3799#1:10986\n3775#1:10987\n3783#1:10988\n3791#1:10989\n3799#1:10990\n3775#1:10991\n3783#1:10992\n3791#1:10993\n3799#1:10994\n3775#1:10995\n3783#1:10996\n3791#1:10997\n3799#1:10998\n3775#1:10999\n3783#1:11000\n3791#1:11001\n3799#1:11002\n3775#1:11003\n3783#1:11004\n3791#1:11005\n3799#1:11006\n3775#1:11007\n3783#1:11008\n3791#1:11009\n3799#1:11010\n3775#1:11011\n3783#1:11012\n3791#1:11013\n3799#1:11014\n1663#2,6:10746\n1675#2,6:10752\n1639#2,6:10758\n1651#2,6:10764\n1771#2,6:10770\n1783#2,6:10776\n1747#2,6:10782\n1759#2,6:10788\n1#3:10794\n372#4,7:10807\n372#4,7:10814\n372#4,7:10821\n372#4,7:10828\n372#4,7:10835\n372#4,7:10842\n372#4,7:10849\n372#4,7:10856\n*S KotlinDebug\n*F\n+ 1 _UArrays.kt\nkotlin/collections/unsigned/UArraysKt___UArraysKt\n*L\n326#1:10734\n338#1:10735\n350#1:10736\n362#1:10737\n692#1:10738\n702#1:10739\n712#1:10740\n722#1:10741\n733#1:10742\n744#1:10743\n755#1:10744\n766#1:10745\n1718#1:10795\n1735#1:10796\n1752#1:10797\n1769#1:10798\n2546#1:10799\n2563#1:10800\n2580#1:10801\n2597#1:10802\n2913#1:10803\n2929#1:10804\n2945#1:10805\n2961#1:10806\n5573#1:10863\n5593#1:10864\n5613#1:10865\n5633#1:10866\n5654#1:10867\n5676#1:10868\n5698#1:10869\n5720#1:10870\n5833#1:10871\n5852#1:10872\n5871#1:10873\n5890#1:10874\n5912#1:10875\n5941#1:10876\n5970#1:10877\n5999#1:10878\n6024#1:10879\n6049#1:10880\n6074#1:10881\n6099#1:10882\n6129#1:10883\n6152#1:10884\n6175#1:10885\n6198#1:10886\n6221#1:10887\n6244#1:10888\n6267#1:10889\n6290#1:10890\n6311#1:10891\n6334#1:10892\n6357#1:10893\n6380#1:10894\n6403#1:10895\n6424#1:10896\n6445#1:10897\n6466#1:10898\n6487#1:10899\n6508#1:10900\n6529#1:10901\n6550#1:10902\n6569#1:10903\n6590#1:10904\n6611#1:10905\n6632#1:10906\n6655#1:10907\n6678#1:10908\n6701#1:10909\n6724#1:10910\n6745#1:10911\n6766#1:10912\n6787#1:10913\n6808#1:10914\n6825#1:10915\n6840#1:10916\n6855#1:10917\n6870#1:10918\n6889#1:10919\n6908#1:10920\n6927#1:10921\n6946#1:10922\n6961#1:10923\n6976#1:10924\n6991#1:10925\n7006#1:10926\n7025#1:10927\n7044#1:10928\n7063#1:10929\n7082#1:10930\n7104#1:10931\n7133#1:10932\n7162#1:10933\n7191#1:10934\n7216#1:10935\n7241#1:10936\n7266#1:10937\n7291#1:10938\n7321#1:10939\n7344#1:10940\n7367#1:10941\n7390#1:10942\n7413#1:10943\n7436#1:10944\n7459#1:10945\n7482#1:10946\n7503#1:10947\n7526#1:10948\n7549#1:10949\n7572#1:10950\n7595#1:10951\n7616#1:10952\n7637#1:10953\n7658#1:10954\n7679#1:10955\n7700#1:10956\n7721#1:10957\n7742#1:10958\n7761#1:10959\n7782#1:10960\n7803#1:10961\n7824#1:10962\n7847#1:10963\n7870#1:10964\n7893#1:10965\n7916#1:10966\n7937#1:10967\n7958#1:10968\n7979#1:10969\n8000#1:10970\n8017#1:10971\n8032#1:10972\n8047#1:10973\n8062#1:10974\n8081#1:10975\n8100#1:10976\n8119#1:10977\n8138#1:10978\n8153#1:10979\n8168#1:10980\n8183#1:10981\n8198#1:10982\n8416#1:10983\n8441#1:10984\n8466#1:10985\n8491#1:10986\n8516#1:10987\n8541#1:10988\n8566#1:10989\n8591#1:10990\n8615#1:10991\n8639#1:10992\n8663#1:10993\n8687#1:10994\n8712#1:10995\n8737#1:10996\n8762#1:10997\n8787#1:10998\n8809#1:10999\n8834#1:11000\n8859#1:11001\n8884#1:11002\n8909#1:11003\n8935#1:11004\n8961#1:11005\n8987#1:11006\n9012#1:11007\n9037#1:11008\n9062#1:11009\n9087#1:11010\n9113#1:11011\n9138#1:11012\n9163#1:11013\n9188#1:11014\n816#1:10746,6\n826#1:10752,6\n836#1:10758,6\n846#1:10764,6\n856#1:10770,6\n866#1:10776,6\n876#1:10782,6\n886#1:10788,6\n4791#1:10807,7\n4811#1:10814,7\n4831#1:10821,7\n4851#1:10828,7\n4872#1:10835,7\n4893#1:10842,7\n4914#1:10849,7\n4935#1:10856,7\n*E\n"})
public class g extends f {

    public static final class a extends n0 implements jn.a<Iterator<? extends w1>> {
        final /* synthetic */ int[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int[] iArr) {
            super(0);
            this.$this_withIndex = iArr;
        }

        @Override // jn.a
        @l
        public final Iterator<? extends w1> invoke() {
            return new x1.a(this.$this_withIndex);
        }
    }

    public static final class b extends n0 implements jn.a<Iterator<? extends a2>> {
        final /* synthetic */ long[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long[] jArr) {
            super(0);
            this.$this_withIndex = jArr;
        }

        @Override // jn.a
        @l
        public final Iterator<? extends a2> invoke() {
            return new b2.a(this.$this_withIndex);
        }
    }

    public static final class c extends n0 implements jn.a<Iterator<? extends s1>> {
        final /* synthetic */ byte[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(byte[] bArr) {
            super(0);
            this.$this_withIndex = bArr;
        }

        @Override // jn.a
        @l
        public final Iterator<? extends s1> invoke() {
            return new t1.a(this.$this_withIndex);
        }
    }

    public static final class d extends n0 implements jn.a<Iterator<? extends g2>> {
        final /* synthetic */ short[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(short[] sArr) {
            super(0);
            this.$this_withIndex = sArr;
        }

        @Override // jn.a
        @l
        public final Iterator<? extends g2> invoke() {
            return new h2.a(this.$this_withIndex);
        }
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long A0(long[] jArr) {
        l0.p(jArr, "$this$component1");
        return a2.m(jArr[0]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int A1(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$count");
        l0.p(lVar, "predicate");
        int i10 = 0;
        for (int i11 : iArr) {
            if (((Boolean) e.a(w1.m(i11), lVar)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super w1>> C A2(int[] iArr, C c10, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$filterNotTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            if (!((Boolean) e.a(iM, lVar)).booleanValue()) {
                c10.add(new w1(iM));
            }
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R A3(long[] jArr, R r10, q<? super Integer, ? super R, ? super a2, ? extends R> qVar) {
        l0.p(jArr, "$this$foldIndexed");
        l0.p(qVar, "operation");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, new a2(a2.m(jArr[i10])));
            i10++;
            i11++;
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, V, M extends Map<? super K, List<V>>> M A4(int[] iArr, M m10, jn.l<? super w1, ? extends K> lVar, jn.l<? super w1, ? extends V> lVar2) {
        l0.p(iArr, "$this$groupByTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            Object objA = e.a(iM, lVar);
            Object objA2 = m10.get(objA);
            if (objA2 == null) {
                objA2 = nm.q.a(m10, objA);
            }
            ((List) objA2).add(lVar2.invoke(new w1(iM)));
        }
        return m10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C A5(int[] iArr, C c10, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$mapTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        for (int i10 : iArr) {
            c10.add(lVar.invoke(new w1(w1.m(i10))));
        }
        return c10;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final g2 A6(@l short[] sArr, @l Comparator<? super g2> comparator) {
        l0.p(sArr, "$this$maxWithOrNull");
        l0.p(comparator, "comparator");
        if (h2.t(sArr)) {
            return null;
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short sM2 = g2.m(sArr[it.nextInt()]);
            if (comparator.compare(new g2(sM), new g2(sM2)) < 0) {
                sM = sM2;
            }
        }
        return new g2(sM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "minOrThrow-U")
    public static final long A7(@l long[] jArr) {
        l0.p(jArr, "$this$min");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long jM2 = a2.m(jArr[it.nextInt()]);
            if (Long.compareUnsigned(jM, jM2) > 0) {
                jM = jM2;
            }
        }
        return jM;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final g2 A8(short[] sArr) {
        l0.p(sArr, "$this$randomOrNull");
        return B8(sArr, rn.f.Default);
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R> List<R> A9(int[] iArr, R r10, p<? super R, ? super w1, ? extends R> pVar) {
        l0.p(iArr, "$this$runningFold");
        l0.p(pVar, "operation");
        if (x1.t(iArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        for (int i10 : iArr) {
            r10 = pVar.invoke(r10, new w1(w1.m(i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<s1> Aa(@l byte[] bArr, @l tn.l lVar) {
        l0.p(bArr, "$this$slice");
        l0.p(lVar, "indices");
        if (lVar.isEmpty()) {
            return k0.INSTANCE;
        }
        byte[] bArrF1 = nm.p.f1(bArr, lVar.f15911a, lVar.f15912b + 1);
        l0.p(bArrF1, "storage");
        return f.b(bArrF1);
    }

    @an.f
    @f1(version = "1.3")
    @lm.l(warningSince = "1.5")
    @t
    @k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int Ab(int[] iArr, jn.l<? super w1, w1> lVar) {
        l0.p(iArr, "$this$sumBy");
        l0.p(lVar, "selector");
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += ((w1) e.a(w1.m(i11), lVar)).f10227a;
        }
        return i10;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final a2[] Ac(@l long[] jArr) {
        l0.p(jArr, "$this$toTypedArray");
        int length = jArr.length;
        a2[] a2VarArr = new a2[length];
        for (int i10 = 0; i10 < length; i10++) {
            a2VarArr[i10] = new a2(a2.m(jArr[i10]));
        }
        return a2VarArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short B0(short[] sArr) {
        l0.p(sArr, "$this$component1");
        return g2.m(sArr[0]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int B1(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$count");
        l0.p(lVar, "predicate");
        int i10 = 0;
        for (short s10 : sArr) {
            if (((Boolean) qm.b.a(g2.m(s10), lVar)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super s1>> C B2(byte[] bArr, C c10, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$filterNotTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            if (!((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                c10.add(new s1(bM));
            }
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R B3(int[] iArr, R r10, q<? super Integer, ? super R, ? super w1, ? extends R> qVar) {
        l0.p(iArr, "$this$foldIndexed");
        l0.p(qVar, "operation");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, new w1(w1.m(iArr[i10])));
            i10++;
            i11++;
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, V, M extends Map<? super K, List<V>>> M B4(long[] jArr, M m10, jn.l<? super a2, ? extends K> lVar, jn.l<? super a2, ? extends V> lVar2) {
        l0.p(jArr, "$this$groupByTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            Object objA = qm.c.a(jM, lVar);
            Object objA2 = m10.get(objA);
            if (objA2 == null) {
                objA2 = nm.q.a(m10, objA);
            }
            ((List) objA2).add(lVar2.invoke(new a2(jM)));
        }
        return m10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C B5(byte[] bArr, C c10, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$mapTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        for (byte b10 : bArr) {
            c10.add(lVar.invoke(new s1(s1.m(b10))));
        }
        return c10;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final a2 B6(@l long[] jArr, @l Comparator<? super a2> comparator) {
        l0.p(jArr, "$this$maxWithOrNull");
        l0.p(comparator, "comparator");
        if (b2.t(jArr)) {
            return null;
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long jM2 = a2.m(jArr[it.nextInt()]);
            if (comparator.compare(new a2(jM), new a2(jM2)) < 0) {
                jM = jM2;
            }
        }
        return new a2(jM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "minOrThrow-U")
    public static final short B7(@l short[] sArr) {
        l0.p(sArr, "$this$min");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short sM2 = g2.m(sArr[it.nextInt()]);
            if (l0.t(sM & g2.f10190d, 65535 & sM2) > 0) {
                sM = sM2;
            }
        }
        return sM;
    }

    @p2(markerClass = {lm.r.class})
    @m
    @f1(version = "1.4")
    @t
    public static final g2 B8(@l short[] sArr, @l rn.f fVar) {
        l0.p(sArr, "$this$randomOrNull");
        l0.p(fVar, "random");
        if (h2.t(sArr)) {
            return null;
        }
        return new g2(g2.m(sArr[fVar.nextInt(sArr.length)]));
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R> List<R> B9(short[] sArr, R r10, p<? super R, ? super g2, ? extends R> pVar) {
        l0.p(sArr, "$this$runningFold");
        l0.p(pVar, "operation");
        if (h2.t(sArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        for (short s10 : sArr) {
            r10 = pVar.invoke(r10, new g2(g2.m(s10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<w1> Ba(@l int[] iArr, @l tn.l lVar) {
        l0.p(iArr, "$this$slice");
        l0.p(lVar, "indices");
        if (lVar.isEmpty()) {
            return k0.INSTANCE;
        }
        int[] iArrJ1 = nm.p.j1(iArr, lVar.f15911a, lVar.f15912b + 1);
        l0.p(iArrJ1, "storage");
        return f.a(iArrJ1);
    }

    @an.f
    @f1(version = "1.3")
    @lm.l(warningSince = "1.5")
    @t
    @k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int Bb(short[] sArr, jn.l<? super g2, w1> lVar) {
        l0.p(sArr, "$this$sumBy");
        l0.p(lVar, "selector");
        int i10 = 0;
        for (short s10 : sArr) {
            i10 += ((w1) qm.b.a(g2.m(s10), lVar)).f10227a;
        }
        return i10;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final g2[] Bc(@l short[] sArr) {
        l0.p(sArr, "$this$toTypedArray");
        int length = sArr.length;
        g2[] g2VarArr = new g2[length];
        for (int i10 = 0; i10 < length; i10++) {
            g2VarArr[i10] = new g2(g2.m(sArr[i10]));
        }
        return g2VarArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int C0(int[] iArr) {
        l0.p(iArr, "$this$component2");
        return w1.m(iArr[1]);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<s1> C1(@l byte[] bArr, int i10) {
        l0.p(bArr, "$this$drop");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = bArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return ic(bArr, length);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super a2>> C C2(long[] jArr, C c10, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$filterTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            if (((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                c10.add(new a2(jM));
            }
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R C3(long[] jArr, R r10, p<? super a2, ? super R, ? extends R> pVar) {
        l0.p(jArr, "$this$foldRight");
        l0.p(pVar, "operation");
        for (int iVe = r.ve(jArr); iVe >= 0; iVe--) {
            r10 = pVar.invoke(new a2(a2.m(jArr[iVe])), r10);
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, M extends Map<? super K, List<a2>>> M C4(long[] jArr, M m10, jn.l<? super a2, ? extends K> lVar) {
        l0.p(jArr, "$this$groupByTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            Object objA = qm.c.a(jM, lVar);
            Object objA2 = m10.get(objA);
            if (objA2 == null) {
                objA2 = nm.q.a(m10, objA);
            }
            ((List) objA2).add(new a2(jM));
        }
        return m10;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R extends Comparable<? super R>> s1 C5(byte[] bArr, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$maxByOrNull");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        byte bM = s1.m(bArr[0]);
        int iQe = r.qe(bArr);
        if (iQe == 0) {
            return new s1(bM);
        }
        Comparable comparable = (Comparable) qm.d.a(bM, lVar);
        v0 v0VarA = o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte bM2 = s1.m(bArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.d.a(bM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                bM = bM2;
                comparable = comparable2;
            }
        }
        return new s1(bM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "maxWithOrThrow-U")
    public static final byte C6(@l byte[] bArr, @l Comparator<? super s1> comparator) {
        l0.p(bArr, "$this$maxWith");
        l0.p(comparator, "comparator");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte bM2 = s1.m(bArr[it.nextInt()]);
            if (comparator.compare(new s1(bM), new s1(bM2)) < 0) {
                bM = bM2;
            }
        }
        return bM;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final s1 C7(@l byte[] bArr, @l Comparator<? super s1> comparator) {
        l0.p(bArr, "$this$minWithOrNull");
        l0.p(comparator, "comparator");
        if (t1.t(bArr)) {
            return null;
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte bM2 = s1.m(bArr[it.nextInt()]);
            if (comparator.compare(new s1(bM), new s1(bM2)) > 0) {
                bM = bM2;
            }
        }
        return new s1(bM);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte C8(byte[] bArr, p<? super s1, ? super s1, s1> pVar) {
        l0.p(bArr, "$this$reduce");
        l0.p(pVar, "operation");
        if (t1.t(bArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            bM = pVar.invoke(new s1(bM), new s1(s1.m(bArr[it.nextInt()]))).f10218a;
        }
        return bM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R> List<R> C9(byte[] bArr, R r10, q<? super Integer, ? super R, ? super s1, ? extends R> qVar) {
        l0.p(bArr, "$this$runningFoldIndexed");
        l0.p(qVar, "operation");
        if (t1.t(bArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, new s1(s1.m(bArr[i10])));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final int[] Ca(@l int[] iArr, @l Collection<Integer> collection) {
        l0.p(iArr, "$this$sliceArray");
        l0.p(collection, "indices");
        int[] iArrFu = r.fu(iArr, collection);
        l0.p(iArrFu, "storage");
        return iArrFu;
    }

    @an.f
    @f1(version = "1.3")
    @lm.l(warningSince = "1.5")
    @t
    @k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double Cb(byte[] bArr, jn.l<? super s1, Double> lVar) {
        l0.p(bArr, "$this$sumByDouble");
        l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (byte b10 : bArr) {
            dDoubleValue += ((Number) qm.d.a(s1.m(b10), lVar)).doubleValue();
        }
        return dDoubleValue;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] Cc(byte[] bArr) {
        l0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        l0.o(bArrCopyOf, "copyOf(...)");
        l0.p(bArrCopyOf, "storage");
        return bArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte D0(byte[] bArr) {
        l0.p(bArr, "$this$component2");
        return s1.m(bArr[1]);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<g2> D1(@l short[] sArr, int i10) {
        l0.p(sArr, "$this$drop");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = sArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return jc(sArr, length);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super g2>> C D2(short[] sArr, C c10, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$filterTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            if (((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                c10.add(new g2(sM));
            }
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R D3(byte[] bArr, R r10, p<? super s1, ? super R, ? extends R> pVar) {
        l0.p(bArr, "$this$foldRight");
        l0.p(pVar, "operation");
        for (int iQe = r.qe(bArr); iQe >= 0; iQe--) {
            r10 = pVar.invoke(new s1(s1.m(bArr[iQe])), r10);
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, M extends Map<? super K, List<g2>>> M D4(short[] sArr, M m10, jn.l<? super g2, ? extends K> lVar) {
        l0.p(sArr, "$this$groupByTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            Object objA = qm.b.a(sM, lVar);
            Object objA2 = m10.get(objA);
            if (objA2 == null) {
                objA2 = nm.q.a(m10, objA);
            }
            ((List) objA2).add(new g2(sM));
        }
        return m10;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R extends Comparable<? super R>> a2 D5(long[] jArr, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$maxByOrNull");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        long jM = a2.m(jArr[0]);
        int iVe = r.ve(jArr);
        if (iVe == 0) {
            return new a2(jM);
        }
        Comparable comparable = (Comparable) qm.c.a(jM, lVar);
        v0 v0VarA = o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long jM2 = a2.m(jArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.c.a(jM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                jM = jM2;
                comparable = comparable2;
            }
        }
        return new a2(jM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "maxWithOrThrow-U")
    public static final int D6(@l int[] iArr, @l Comparator<? super w1> comparator) {
        l0.p(iArr, "$this$maxWith");
        l0.p(comparator, "comparator");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iM2 = w1.m(iArr[it.nextInt()]);
            if (comparator.compare(new w1(iM), new w1(iM2)) < 0) {
                iM = iM2;
            }
        }
        return iM;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final w1 D7(@l int[] iArr, @l Comparator<? super w1> comparator) {
        l0.p(iArr, "$this$minWithOrNull");
        l0.p(comparator, "comparator");
        if (x1.t(iArr)) {
            return null;
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iM2 = w1.m(iArr[it.nextInt()]);
            if (comparator.compare(new w1(iM), new w1(iM2)) > 0) {
                iM = iM2;
            }
        }
        return new w1(iM);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int D8(int[] iArr, p<? super w1, ? super w1, w1> pVar) {
        l0.p(iArr, "$this$reduce");
        l0.p(pVar, "operation");
        if (x1.t(iArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            iM = pVar.invoke(new w1(iM), new w1(w1.m(iArr[it.nextInt()]))).f10227a;
        }
        return iM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R> List<R> D9(short[] sArr, R r10, q<? super Integer, ? super R, ? super g2, ? extends R> qVar) {
        l0.p(sArr, "$this$runningFoldIndexed");
        l0.p(qVar, "operation");
        if (h2.t(sArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, new g2(g2.m(sArr[i10])));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final short[] Da(@l short[] sArr, @l tn.l lVar) {
        l0.p(sArr, "$this$sliceArray");
        l0.p(lVar, "indices");
        short[] sArrMu = r.mu(sArr, lVar);
        l0.p(sArrMu, "storage");
        return sArrMu;
    }

    @an.f
    @f1(version = "1.3")
    @lm.l(warningSince = "1.5")
    @t
    @k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double Db(long[] jArr, jn.l<? super a2, Double> lVar) {
        l0.p(jArr, "$this$sumByDouble");
        l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (long j10 : jArr) {
            dDoubleValue += ((Number) qm.c.a(a2.m(j10), lVar)).doubleValue();
        }
        return dDoubleValue;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final byte[] Dc(@l s1[] s1VarArr) {
        l0.p(s1VarArr, "<this>");
        int length = s1VarArr.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = s1VarArr[i10].f10218a;
        }
        l0.p(bArr, "storage");
        return bArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long E0(long[] jArr) {
        l0.p(jArr, "$this$component2");
        return a2.m(jArr[1]);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<w1> E1(@l int[] iArr, int i10) {
        l0.p(iArr, "$this$drop");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = iArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return kc(iArr, length);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super w1>> C E2(int[] iArr, C c10, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$filterTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            if (((Boolean) e.a(iM, lVar)).booleanValue()) {
                c10.add(new w1(iM));
            }
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R E3(int[] iArr, R r10, p<? super w1, ? super R, ? extends R> pVar) {
        l0.p(iArr, "$this$foldRight");
        l0.p(pVar, "operation");
        for (int iUe = r.ue(iArr); iUe >= 0; iUe--) {
            r10 = pVar.invoke(new w1(w1.m(iArr[iUe])), r10);
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, V, M extends Map<? super K, List<V>>> M E4(short[] sArr, M m10, jn.l<? super g2, ? extends K> lVar, jn.l<? super g2, ? extends V> lVar2) {
        l0.p(sArr, "$this$groupByTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            Object objA = qm.b.a(sM, lVar);
            Object objA2 = m10.get(objA);
            if (objA2 == null) {
                objA2 = nm.q.a(m10, objA);
            }
            ((List) objA2).add(lVar2.invoke(new g2(sM)));
        }
        return m10;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R extends Comparable<? super R>> w1 E5(int[] iArr, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$maxByOrNull");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        int iM = w1.m(iArr[0]);
        int iUe = r.ue(iArr);
        if (iUe == 0) {
            return new w1(iM);
        }
        Comparable comparable = (Comparable) e.a(iM, lVar);
        v0 v0VarA = o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int iM2 = w1.m(iArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) e.a(iM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                iM = iM2;
                comparable = comparable2;
            }
        }
        return new w1(iM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "maxWithOrThrow-U")
    public static final long E6(@l long[] jArr, @l Comparator<? super a2> comparator) {
        l0.p(jArr, "$this$maxWith");
        l0.p(comparator, "comparator");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long jM2 = a2.m(jArr[it.nextInt()]);
            if (comparator.compare(new a2(jM), new a2(jM2)) < 0) {
                jM = jM2;
            }
        }
        return jM;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final g2 E7(@l short[] sArr, @l Comparator<? super g2> comparator) {
        l0.p(sArr, "$this$minWithOrNull");
        l0.p(comparator, "comparator");
        if (h2.t(sArr)) {
            return null;
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short sM2 = g2.m(sArr[it.nextInt()]);
            if (comparator.compare(new g2(sM), new g2(sM2)) > 0) {
                sM = sM2;
            }
        }
        return new g2(sM);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long E8(long[] jArr, p<? super a2, ? super a2, a2> pVar) {
        l0.p(jArr, "$this$reduce");
        l0.p(pVar, "operation");
        if (b2.t(jArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            jM = pVar.invoke(new a2(jM), new a2(a2.m(jArr[it.nextInt()]))).f10177a;
        }
        return jM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R> List<R> E9(long[] jArr, R r10, q<? super Integer, ? super R, ? super a2, ? extends R> qVar) {
        l0.p(jArr, "$this$runningFoldIndexed");
        l0.p(qVar, "operation");
        if (b2.t(jArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, new a2(a2.m(jArr[i10])));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final long[] Ea(@l long[] jArr, @l tn.l lVar) {
        l0.p(jArr, "$this$sliceArray");
        l0.p(lVar, "indices");
        long[] jArrIu = r.iu(jArr, lVar);
        l0.p(jArrIu, "storage");
        return jArrIu;
    }

    @an.f
    @f1(version = "1.3")
    @lm.l(warningSince = "1.5")
    @t
    @k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double Eb(int[] iArr, jn.l<? super w1, Double> lVar) {
        l0.p(iArr, "$this$sumByDouble");
        l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (int i10 : iArr) {
            dDoubleValue += ((Number) e.a(w1.m(i10), lVar)).doubleValue();
        }
        return dDoubleValue;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] Ec(int[] iArr) {
        l0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        l0.o(iArrCopyOf, "copyOf(...)");
        l0.p(iArrCopyOf, "storage");
        return iArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short F0(short[] sArr) {
        l0.p(sArr, "$this$component2");
        return g2.m(sArr[1]);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<a2> F1(@l long[] jArr, int i10) {
        l0.p(jArr, "$this$drop");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = jArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return lc(jArr, length);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super s1>> C F2(byte[] bArr, C c10, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$filterTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            if (((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                c10.add(new s1(bM));
            }
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R F3(short[] sArr, R r10, p<? super g2, ? super R, ? extends R> pVar) {
        l0.p(sArr, "$this$foldRight");
        l0.p(pVar, "operation");
        for (int iXe = r.xe(sArr); iXe >= 0; iXe--) {
            r10 = pVar.invoke(new g2(g2.m(sArr[iXe])), r10);
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, V, M extends Map<? super K, List<V>>> M F4(byte[] bArr, M m10, jn.l<? super s1, ? extends K> lVar, jn.l<? super s1, ? extends V> lVar2) {
        l0.p(bArr, "$this$groupByTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            Object objA = qm.d.a(bM, lVar);
            Object objA2 = m10.get(objA);
            if (objA2 == null) {
                objA2 = nm.q.a(m10, objA);
            }
            ((List) objA2).add(lVar2.invoke(new s1(bM)));
        }
        return m10;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R extends Comparable<? super R>> g2 F5(short[] sArr, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$maxByOrNull");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        short sM = g2.m(sArr[0]);
        int iXe = r.xe(sArr);
        if (iXe == 0) {
            return new g2(sM);
        }
        Comparable comparable = (Comparable) qm.b.a(sM, lVar);
        v0 v0VarA = o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short sM2 = g2.m(sArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.b.a(sM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                sM = sM2;
                comparable = comparable2;
            }
        }
        return new g2(sM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "maxWithOrThrow-U")
    public static final short F6(@l short[] sArr, @l Comparator<? super g2> comparator) {
        l0.p(sArr, "$this$maxWith");
        l0.p(comparator, "comparator");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short sM2 = g2.m(sArr[it.nextInt()]);
            if (comparator.compare(new g2(sM), new g2(sM2)) < 0) {
                sM = sM2;
            }
        }
        return sM;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final a2 F7(@l long[] jArr, @l Comparator<? super a2> comparator) {
        l0.p(jArr, "$this$minWithOrNull");
        l0.p(comparator, "comparator");
        if (b2.t(jArr)) {
            return null;
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long jM2 = a2.m(jArr[it.nextInt()]);
            if (comparator.compare(new a2(jM), new a2(jM2)) > 0) {
                jM = jM2;
            }
        }
        return new a2(jM);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short F8(short[] sArr, p<? super g2, ? super g2, g2> pVar) {
        l0.p(sArr, "$this$reduce");
        l0.p(pVar, "operation");
        if (h2.t(sArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            sM = pVar.invoke(new g2(sM), new g2(g2.m(sArr[it.nextInt()]))).f10193a;
        }
        return sM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R> List<R> F9(int[] iArr, R r10, q<? super Integer, ? super R, ? super w1, ? extends R> qVar) {
        l0.p(iArr, "$this$runningFoldIndexed");
        l0.p(qVar, "operation");
        if (x1.t(iArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, new w1(w1.m(iArr[i10])));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final byte[] Fa(@l byte[] bArr, @l tn.l lVar) {
        l0.p(bArr, "$this$sliceArray");
        l0.p(lVar, "indices");
        byte[] bArrYt = r.Yt(bArr, lVar);
        l0.p(bArrYt, "storage");
        return bArrYt;
    }

    @an.f
    @f1(version = "1.3")
    @lm.l(warningSince = "1.5")
    @t
    @k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double Fb(short[] sArr, jn.l<? super g2, Double> lVar) {
        l0.p(sArr, "$this$sumByDouble");
        l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (short s10 : sArr) {
            dDoubleValue += ((Number) qm.b.a(g2.m(s10), lVar)).doubleValue();
        }
        return dDoubleValue;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final int[] Fc(@l w1[] w1VarArr) {
        l0.p(w1VarArr, "<this>");
        int length = w1VarArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = w1VarArr[i10].f10227a;
        }
        l0.p(iArr, "storage");
        return iArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int G0(int[] iArr) {
        l0.p(iArr, "$this$component3");
        return w1.m(iArr[2]);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<s1> G1(@l byte[] bArr, int i10) {
        l0.p(bArr, "$this$dropLast");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = bArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return ec(bArr, length);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final s1 G2(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$find");
        l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            if (((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                return new s1(bM);
            }
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R G3(byte[] bArr, R r10, q<? super Integer, ? super s1, ? super R, ? extends R> qVar) {
        l0.p(bArr, "$this$foldRightIndexed");
        l0.p(qVar, "operation");
        for (int iQe = r.qe(bArr); iQe >= 0; iQe--) {
            r10 = qVar.invoke(Integer.valueOf(iQe), new s1(s1.m(bArr[iQe])), r10);
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int G4(long[] jArr, long j10) {
        l0.p(jArr, "$this$indexOf");
        return r.Hf(jArr, j10);
    }

    @an.f
    @i(name = "maxByOrThrow-U")
    @f1(version = "1.7")
    @t
    public static final <R extends Comparable<? super R>> byte G5(byte[] bArr, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$maxBy");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        byte bM = s1.m(bArr[0]);
        int iQe = r.qe(bArr);
        if (iQe == 0) {
            return bM;
        }
        Comparable comparable = (Comparable) qm.d.a(bM, lVar);
        v0 v0VarA = o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte bM2 = s1.m(bArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.d.a(bM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                bM = bM2;
                comparable = comparable2;
            }
        }
        return bM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R extends Comparable<? super R>> s1 G6(byte[] bArr, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$minByOrNull");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        byte bM = s1.m(bArr[0]);
        int iQe = r.qe(bArr);
        if (iQe == 0) {
            return new s1(bM);
        }
        Comparable comparable = (Comparable) qm.d.a(bM, lVar);
        v0 v0VarA = o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte bM2 = s1.m(bArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.d.a(bM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                bM = bM2;
                comparable = comparable2;
            }
        }
        return new s1(bM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "minWithOrThrow-U")
    public static final byte G7(@l byte[] bArr, @l Comparator<? super s1> comparator) {
        l0.p(bArr, "$this$minWith");
        l0.p(comparator, "comparator");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte bM2 = s1.m(bArr[it.nextInt()]);
            if (comparator.compare(new s1(bM), new s1(bM2)) > 0) {
                bM = bM2;
            }
        }
        return bM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int G8(int[] iArr, q<? super Integer, ? super w1, ? super w1, w1> qVar) {
        l0.p(iArr, "$this$reduceIndexed");
        l0.p(qVar, "operation");
        if (x1.t(iArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            iM = qVar.invoke(Integer.valueOf(iNextInt), new w1(iM), new w1(w1.m(iArr[iNextInt]))).f10227a;
        }
        return iM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final List<s1> G9(byte[] bArr, p<? super s1, ? super s1, s1> pVar) {
        l0.p(bArr, "$this$runningReduce");
        l0.p(pVar, "operation");
        if (t1.t(bArr)) {
            return k0.INSTANCE;
        }
        byte bM = s1.m(bArr[0]);
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(new s1(bM));
        int length = bArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            bM = pVar.invoke(new s1(bM), new s1(s1.m(bArr[i10]))).f10218a;
            arrayList.add(new s1(bM));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final long[] Ga(@l long[] jArr, @l Collection<Integer> collection) {
        l0.p(jArr, "$this$sliceArray");
        l0.p(collection, "indices");
        long[] jArrHu = r.hu(jArr, collection);
        l0.p(jArrHu, "storage");
        return jArrHu;
    }

    @s0
    @an.f
    @i(name = "sumOfDouble")
    @f1(version = "1.4")
    @t
    public static final double Gb(byte[] bArr, jn.l<? super s1, Double> lVar) {
        l0.p(bArr, "$this$sumOf");
        l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (byte b10 : bArr) {
            dDoubleValue += ((Number) qm.d.a(s1.m(b10), lVar)).doubleValue();
        }
        return dDoubleValue;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] Gc(long[] jArr) {
        l0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        l0.o(jArrCopyOf, "copyOf(...)");
        l0.p(jArrCopyOf, "storage");
        return jArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte H0(byte[] bArr) {
        l0.p(bArr, "$this$component3");
        return s1.m(bArr[2]);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<g2> H1(@l short[] sArr, int i10) {
        l0.p(sArr, "$this$dropLast");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = sArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return fc(sArr, length);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final a2 H2(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$find");
        l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            if (((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                return new a2(jM);
            }
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R H3(short[] sArr, R r10, q<? super Integer, ? super g2, ? super R, ? extends R> qVar) {
        l0.p(sArr, "$this$foldRightIndexed");
        l0.p(qVar, "operation");
        for (int iXe = r.xe(sArr); iXe >= 0; iXe--) {
            r10 = qVar.invoke(Integer.valueOf(iXe), new g2(g2.m(sArr[iXe])), r10);
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int H4(short[] sArr, short s10) {
        l0.p(sArr, "$this$indexOf");
        return r.Jf(sArr, s10);
    }

    @an.f
    @i(name = "maxByOrThrow-U")
    @f1(version = "1.7")
    @t
    public static final <R extends Comparable<? super R>> int H5(int[] iArr, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$maxBy");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        int iM = w1.m(iArr[0]);
        int iUe = r.ue(iArr);
        if (iUe == 0) {
            return iM;
        }
        Comparable comparable = (Comparable) e.a(iM, lVar);
        v0 v0VarA = o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int iM2 = w1.m(iArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) e.a(iM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                iM = iM2;
                comparable = comparable2;
            }
        }
        return iM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R extends Comparable<? super R>> a2 H6(long[] jArr, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$minByOrNull");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        long jM = a2.m(jArr[0]);
        int iVe = r.ve(jArr);
        if (iVe == 0) {
            return new a2(jM);
        }
        Comparable comparable = (Comparable) qm.c.a(jM, lVar);
        v0 v0VarA = o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long jM2 = a2.m(jArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.c.a(jM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                jM = jM2;
                comparable = comparable2;
            }
        }
        return new a2(jM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "minWithOrThrow-U")
    public static final int H7(@l int[] iArr, @l Comparator<? super w1> comparator) {
        l0.p(iArr, "$this$minWith");
        l0.p(comparator, "comparator");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iM2 = w1.m(iArr[it.nextInt()]);
            if (comparator.compare(new w1(iM), new w1(iM2)) > 0) {
                iM = iM2;
            }
        }
        return iM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte H8(byte[] bArr, q<? super Integer, ? super s1, ? super s1, s1> qVar) {
        l0.p(bArr, "$this$reduceIndexed");
        l0.p(qVar, "operation");
        if (t1.t(bArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            bM = qVar.invoke(Integer.valueOf(iNextInt), new s1(bM), new s1(s1.m(bArr[iNextInt]))).f10218a;
        }
        return bM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final List<w1> H9(int[] iArr, p<? super w1, ? super w1, w1> pVar) {
        l0.p(iArr, "$this$runningReduce");
        l0.p(pVar, "operation");
        if (x1.t(iArr)) {
            return k0.INSTANCE;
        }
        int iM = w1.m(iArr[0]);
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(new w1(iM));
        int length = iArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            iM = pVar.invoke(new w1(iM), new w1(w1.m(iArr[i10]))).f10227a;
            arrayList.add(new w1(iM));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final short[] Ha(@l short[] sArr, @l Collection<Integer> collection) {
        l0.p(sArr, "$this$sliceArray");
        l0.p(collection, "indices");
        short[] sArrLu = r.lu(sArr, collection);
        l0.p(sArrLu, "storage");
        return sArrLu;
    }

    @s0
    @an.f
    @i(name = "sumOfDouble")
    @f1(version = "1.4")
    @t
    public static final double Hb(int[] iArr, jn.l<? super w1, Double> lVar) {
        l0.p(iArr, "$this$sumOf");
        l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (int i10 : iArr) {
            dDoubleValue += ((Number) e.a(w1.m(i10), lVar)).doubleValue();
        }
        return dDoubleValue;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final long[] Hc(@l a2[] a2VarArr) {
        l0.p(a2VarArr, "<this>");
        int length = a2VarArr.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = a2VarArr[i10].f10177a;
        }
        l0.p(jArr, "storage");
        return jArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long I0(long[] jArr) {
        l0.p(jArr, "$this$component3");
        return a2.m(jArr[2]);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<w1> I1(@l int[] iArr, int i10) {
        l0.p(iArr, "$this$dropLast");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = iArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return gc(iArr, length);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final w1 I2(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$find");
        l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            if (((Boolean) e.a(iM, lVar)).booleanValue()) {
                return new w1(iM);
            }
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R I3(long[] jArr, R r10, q<? super Integer, ? super a2, ? super R, ? extends R> qVar) {
        l0.p(jArr, "$this$foldRightIndexed");
        l0.p(qVar, "operation");
        for (int iVe = r.ve(jArr); iVe >= 0; iVe--) {
            r10 = qVar.invoke(Integer.valueOf(iVe), new a2(a2.m(jArr[iVe])), r10);
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int I4(byte[] bArr, byte b10) {
        l0.p(bArr, "$this$indexOf");
        return r.Cf(bArr, b10);
    }

    @an.f
    @i(name = "maxByOrThrow-U")
    @f1(version = "1.7")
    @t
    public static final <R extends Comparable<? super R>> long I5(long[] jArr, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$maxBy");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        long jM = a2.m(jArr[0]);
        int iVe = r.ve(jArr);
        if (iVe == 0) {
            return jM;
        }
        Comparable comparable = (Comparable) qm.c.a(jM, lVar);
        v0 v0VarA = o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long jM2 = a2.m(jArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.c.a(jM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                jM = jM2;
                comparable = comparable2;
            }
        }
        return jM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R extends Comparable<? super R>> w1 I6(int[] iArr, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$minByOrNull");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        int iM = w1.m(iArr[0]);
        int iUe = r.ue(iArr);
        if (iUe == 0) {
            return new w1(iM);
        }
        Comparable comparable = (Comparable) e.a(iM, lVar);
        v0 v0VarA = o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int iM2 = w1.m(iArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) e.a(iM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                iM = iM2;
                comparable = comparable2;
            }
        }
        return new w1(iM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "minWithOrThrow-U")
    public static final long I7(@l long[] jArr, @l Comparator<? super a2> comparator) {
        l0.p(jArr, "$this$minWith");
        l0.p(comparator, "comparator");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long jM2 = a2.m(jArr[it.nextInt()]);
            if (comparator.compare(new a2(jM), new a2(jM2)) > 0) {
                jM = jM2;
            }
        }
        return jM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short I8(short[] sArr, q<? super Integer, ? super g2, ? super g2, g2> qVar) {
        l0.p(sArr, "$this$reduceIndexed");
        l0.p(qVar, "operation");
        if (h2.t(sArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            sM = qVar.invoke(Integer.valueOf(iNextInt), new g2(sM), new g2(g2.m(sArr[iNextInt]))).f10193a;
        }
        return sM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final List<a2> I9(long[] jArr, p<? super a2, ? super a2, a2> pVar) {
        l0.p(jArr, "$this$runningReduce");
        l0.p(pVar, "operation");
        if (b2.t(jArr)) {
            return k0.INSTANCE;
        }
        long jM = a2.m(jArr[0]);
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(new a2(jM));
        int length = jArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            jM = pVar.invoke(new a2(jM), new a2(a2.m(jArr[i10]))).f10177a;
            arrayList.add(new a2(jM));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final int[] Ia(@l int[] iArr, @l tn.l lVar) {
        l0.p(iArr, "$this$sliceArray");
        l0.p(lVar, "indices");
        int[] iArrGu = r.gu(iArr, lVar);
        l0.p(iArrGu, "storage");
        return iArrGu;
    }

    @s0
    @an.f
    @i(name = "sumOfDouble")
    @f1(version = "1.4")
    @t
    public static final double Ib(long[] jArr, jn.l<? super a2, Double> lVar) {
        l0.p(jArr, "$this$sumOf");
        l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (long j10 : jArr) {
            dDoubleValue += ((Number) qm.c.a(a2.m(j10), lVar)).doubleValue();
        }
        return dDoubleValue;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final short[] Ic(@l g2[] g2VarArr) {
        l0.p(g2VarArr, "<this>");
        int length = g2VarArr.length;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            sArr[i10] = g2VarArr[i10].f10193a;
        }
        l0.p(sArr, "storage");
        return sArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short J0(short[] sArr) {
        l0.p(sArr, "$this$component3");
        return g2.m(sArr[2]);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<a2> J1(@l long[] jArr, int i10) {
        l0.p(jArr, "$this$dropLast");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = jArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return hc(jArr, length);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final g2 J2(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$find");
        l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            if (((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                return new g2(sM);
            }
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R J3(int[] iArr, R r10, q<? super Integer, ? super w1, ? super R, ? extends R> qVar) {
        l0.p(iArr, "$this$foldRightIndexed");
        l0.p(qVar, "operation");
        for (int iUe = r.ue(iArr); iUe >= 0; iUe--) {
            r10 = qVar.invoke(Integer.valueOf(iUe), new w1(w1.m(iArr[iUe])), r10);
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int J4(int[] iArr, int i10) {
        l0.p(iArr, "$this$indexOf");
        return r.Gf(iArr, i10);
    }

    @an.f
    @i(name = "maxByOrThrow-U")
    @f1(version = "1.7")
    @t
    public static final <R extends Comparable<? super R>> short J5(short[] sArr, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$maxBy");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        short sM = g2.m(sArr[0]);
        int iXe = r.xe(sArr);
        if (iXe == 0) {
            return sM;
        }
        Comparable comparable = (Comparable) qm.b.a(sM, lVar);
        v0 v0VarA = o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short sM2 = g2.m(sArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.b.a(sM2, lVar);
            if (comparable.compareTo(comparable2) < 0) {
                sM = sM2;
                comparable = comparable2;
            }
        }
        return sM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R extends Comparable<? super R>> g2 J6(short[] sArr, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$minByOrNull");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        short sM = g2.m(sArr[0]);
        int iXe = r.xe(sArr);
        if (iXe == 0) {
            return new g2(sM);
        }
        Comparable comparable = (Comparable) qm.b.a(sM, lVar);
        v0 v0VarA = o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short sM2 = g2.m(sArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.b.a(sM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                sM = sM2;
                comparable = comparable2;
            }
        }
        return new g2(sM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "minWithOrThrow-U")
    public static final short J7(@l short[] sArr, @l Comparator<? super g2> comparator) {
        l0.p(sArr, "$this$minWith");
        l0.p(comparator, "comparator");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short sM2 = g2.m(sArr[it.nextInt()]);
            if (comparator.compare(new g2(sM), new g2(sM2)) > 0) {
                sM = sM2;
            }
        }
        return sM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long J8(long[] jArr, q<? super Integer, ? super a2, ? super a2, a2> qVar) {
        l0.p(jArr, "$this$reduceIndexed");
        l0.p(qVar, "operation");
        if (b2.t(jArr)) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            jM = qVar.invoke(Integer.valueOf(iNextInt), new a2(jM), new a2(a2.m(jArr[iNextInt]))).f10177a;
        }
        return jM;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final List<g2> J9(short[] sArr, p<? super g2, ? super g2, g2> pVar) {
        l0.p(sArr, "$this$runningReduce");
        l0.p(pVar, "operation");
        if (h2.t(sArr)) {
            return k0.INSTANCE;
        }
        short sM = g2.m(sArr[0]);
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(new g2(sM));
        int length = sArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            sM = pVar.invoke(new g2(sM), new g2(g2.m(sArr[i10]))).f10193a;
            arrayList.add(new g2(sM));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final byte[] Ja(@l byte[] bArr, @l Collection<Integer> collection) {
        l0.p(bArr, "$this$sliceArray");
        l0.p(collection, "indices");
        byte[] bArrXt = r.Xt(bArr, collection);
        l0.p(bArrXt, "storage");
        return bArrXt;
    }

    @s0
    @an.f
    @i(name = "sumOfDouble")
    @f1(version = "1.4")
    @t
    public static final double Jb(short[] sArr, jn.l<? super g2, Double> lVar) {
        l0.p(sArr, "$this$sumOf");
        l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (short s10 : sArr) {
            dDoubleValue += ((Number) qm.b.a(g2.m(s10), lVar)).doubleValue();
        }
        return dDoubleValue;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] Jc(short[] sArr) {
        l0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        l0.o(sArrCopyOf, "copyOf(...)");
        l0.p(sArrCopyOf, "storage");
        return sArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int K0(int[] iArr) {
        l0.p(iArr, "$this$component4");
        return w1.m(iArr[3]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<s1> K1(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$dropLastWhile");
        l0.p(lVar, "predicate");
        for (int iQe = r.qe(bArr); -1 < iQe; iQe--) {
            if (!((Boolean) qm.d.a(s1.m(bArr[iQe]), lVar)).booleanValue()) {
                return ec(bArr, iQe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final s1 K2(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$findLast");
        l0.p(lVar, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                byte bM = s1.m(bArr[length]);
                if (((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                    return new s1(bM);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void K3(byte[] bArr, jn.l<? super s1, l2> lVar) {
        l0.p(bArr, "$this$forEach");
        l0.p(lVar, k4.f.f8937e);
        for (byte b10 : bArr) {
            lVar.invoke(new s1(s1.m(b10)));
        }
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int K4(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$indexOfFirst");
        l0.p(lVar, "predicate");
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (((Boolean) qm.d.a(s1.m(bArr[i10]), lVar)).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final double K5(byte[] bArr, jn.l<? super s1, Double> lVar) {
        l0.p(bArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) qm.d.a(s1.m(bArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) qm.d.a(s1.m(bArr[it.nextInt()]), lVar)).doubleValue());
        }
        return dDoubleValue;
    }

    @an.f
    @i(name = "minByOrThrow-U")
    @f1(version = "1.7")
    @t
    public static final <R extends Comparable<? super R>> byte K6(byte[] bArr, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$minBy");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        byte bM = s1.m(bArr[0]);
        int iQe = r.qe(bArr);
        if (iQe == 0) {
            return bM;
        }
        Comparable comparable = (Comparable) qm.d.a(bM, lVar);
        v0 v0VarA = o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte bM2 = s1.m(bArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.d.a(bM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                bM = bM2;
                comparable = comparable2;
            }
        }
        return bM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean K7(int[] iArr) {
        l0.p(iArr, "$this$none");
        return x1.t(iArr);
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final w1 K8(int[] iArr, q<? super Integer, ? super w1, ? super w1, w1> qVar) {
        l0.p(iArr, "$this$reduceIndexedOrNull");
        l0.p(qVar, "operation");
        if (x1.t(iArr)) {
            return null;
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            iM = qVar.invoke(Integer.valueOf(iNextInt), new w1(iM), new w1(w1.m(iArr[iNextInt]))).f10227a;
        }
        return new w1(iM);
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final List<w1> K9(int[] iArr, q<? super Integer, ? super w1, ? super w1, w1> qVar) {
        l0.p(iArr, "$this$runningReduceIndexed");
        l0.p(qVar, "operation");
        if (x1.t(iArr)) {
            return k0.INSTANCE;
        }
        int iM = w1.m(iArr[0]);
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(new w1(iM));
        int length = iArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            iM = qVar.invoke(Integer.valueOf(i10), new w1(iM), new w1(w1.m(iArr[i10]))).f10227a;
            arrayList.add(new w1(iM));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    public static final void Ka(@l int[] iArr) {
        l0.p(iArr, "$this$sort");
        if (iArr.length > 1) {
            u1.l(iArr, 0, iArr.length);
        }
    }

    @s0
    @an.f
    @i(name = "sumOfInt")
    @f1(version = "1.4")
    @t
    public static final int Kb(byte[] bArr, jn.l<? super s1, Integer> lVar) {
        l0.p(bArr, "$this$sumOf");
        l0.p(lVar, "selector");
        int iIntValue = 0;
        for (byte b10 : bArr) {
            iIntValue += ((Number) qm.d.a(s1.m(b10), lVar)).intValue();
        }
        return iIntValue;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final Iterable<nm.s0<w1>> Kc(@l int[] iArr) {
        l0.p(iArr, "$this$withIndex");
        return new t0(new a(iArr));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte L0(byte[] bArr) {
        l0.p(bArr, "$this$component4");
        return s1.m(bArr[3]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<a2> L1(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$dropLastWhile");
        l0.p(lVar, "predicate");
        for (int iVe = r.ve(jArr); -1 < iVe; iVe--) {
            if (!((Boolean) qm.c.a(a2.m(jArr[iVe]), lVar)).booleanValue()) {
                return hc(jArr, iVe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final a2 L2(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$findLast");
        l0.p(lVar, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                long jM = a2.m(jArr[length]);
                if (((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                    return new a2(jM);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void L3(long[] jArr, jn.l<? super a2, l2> lVar) {
        l0.p(jArr, "$this$forEach");
        l0.p(lVar, k4.f.f8937e);
        for (long j10 : jArr) {
            lVar.invoke(new a2(a2.m(j10)));
        }
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int L4(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$indexOfFirst");
        l0.p(lVar, "predicate");
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (((Boolean) qm.c.a(a2.m(jArr[i10]), lVar)).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final float L5(byte[] bArr, jn.l<? super s1, Float> lVar) {
        l0.p(bArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) qm.d.a(s1.m(bArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) qm.d.a(s1.m(bArr[it.nextInt()]), lVar)).floatValue());
        }
        return fFloatValue;
    }

    @an.f
    @i(name = "minByOrThrow-U")
    @f1(version = "1.7")
    @t
    public static final <R extends Comparable<? super R>> int L6(int[] iArr, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$minBy");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        int iM = w1.m(iArr[0]);
        int iUe = r.ue(iArr);
        if (iUe == 0) {
            return iM;
        }
        Comparable comparable = (Comparable) e.a(iM, lVar);
        v0 v0VarA = o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int iM2 = w1.m(iArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) e.a(iM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                iM = iM2;
                comparable = comparable2;
            }
        }
        return iM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean L7(byte[] bArr) {
        l0.p(bArr, "$this$none");
        return t1.t(bArr);
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final s1 L8(byte[] bArr, q<? super Integer, ? super s1, ? super s1, s1> qVar) {
        l0.p(bArr, "$this$reduceIndexedOrNull");
        l0.p(qVar, "operation");
        if (t1.t(bArr)) {
            return null;
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            bM = qVar.invoke(Integer.valueOf(iNextInt), new s1(bM), new s1(s1.m(bArr[iNextInt]))).f10218a;
        }
        return new s1(bM);
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final List<s1> L9(byte[] bArr, q<? super Integer, ? super s1, ? super s1, s1> qVar) {
        l0.p(bArr, "$this$runningReduceIndexed");
        l0.p(qVar, "operation");
        if (t1.t(bArr)) {
            return k0.INSTANCE;
        }
        byte bM = s1.m(bArr[0]);
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(new s1(bM));
        int length = bArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            bM = qVar.invoke(Integer.valueOf(i10), new s1(bM), new s1(s1.m(bArr[i10]))).f10218a;
            arrayList.add(new s1(bM));
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    public static final void La(@l long[] jArr, int i10, int i11) {
        l0.p(jArr, "$this$sort");
        nm.c.Companion.d(i10, i11, jArr.length);
        u1.i(jArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfInt")
    @f1(version = "1.4")
    @t
    public static final int Lb(int[] iArr, jn.l<? super w1, Integer> lVar) {
        l0.p(iArr, "$this$sumOf");
        l0.p(lVar, "selector");
        int iIntValue = 0;
        for (int i10 : iArr) {
            iIntValue += ((Number) e.a(w1.m(i10), lVar)).intValue();
        }
        return iIntValue;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final Iterable<nm.s0<s1>> Lc(@l byte[] bArr) {
        l0.p(bArr, "$this$withIndex");
        return new t0(new c(bArr));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long M0(long[] jArr) {
        l0.p(jArr, "$this$component4");
        return a2.m(jArr[3]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<w1> M1(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$dropLastWhile");
        l0.p(lVar, "predicate");
        for (int iUe = r.ue(iArr); -1 < iUe; iUe--) {
            if (!((Boolean) e.a(w1.m(iArr[iUe]), lVar)).booleanValue()) {
                return gc(iArr, iUe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final w1 M2(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$findLast");
        l0.p(lVar, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                int iM = w1.m(iArr[length]);
                if (((Boolean) e.a(iM, lVar)).booleanValue()) {
                    return new w1(iM);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void M3(int[] iArr, jn.l<? super w1, l2> lVar) {
        l0.p(iArr, "$this$forEach");
        l0.p(lVar, k4.f.f8937e);
        for (int i10 : iArr) {
            lVar.invoke(new w1(w1.m(i10)));
        }
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int M4(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$indexOfFirst");
        l0.p(lVar, "predicate");
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (((Boolean) e.a(w1.m(iArr[i10]), lVar)).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R M5(byte[] bArr, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.d.a(s1.m(bArr[0]), lVar);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.d.a(s1.m(bArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) < 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @an.f
    @i(name = "minByOrThrow-U")
    @f1(version = "1.7")
    @t
    public static final <R extends Comparable<? super R>> long M6(long[] jArr, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$minBy");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        long jM = a2.m(jArr[0]);
        int iVe = r.ve(jArr);
        if (iVe == 0) {
            return jM;
        }
        Comparable comparable = (Comparable) qm.c.a(jM, lVar);
        v0 v0VarA = o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long jM2 = a2.m(jArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.c.a(jM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                jM = jM2;
                comparable = comparable2;
            }
        }
        return jM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean M7(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$none");
        l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            if (((Boolean) qm.d.a(s1.m(b10), lVar)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final g2 M8(short[] sArr, q<? super Integer, ? super g2, ? super g2, g2> qVar) {
        l0.p(sArr, "$this$reduceIndexedOrNull");
        l0.p(qVar, "operation");
        if (h2.t(sArr)) {
            return null;
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            sM = qVar.invoke(Integer.valueOf(iNextInt), new g2(sM), new g2(g2.m(sArr[iNextInt]))).f10193a;
        }
        return new g2(sM);
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final List<g2> M9(short[] sArr, q<? super Integer, ? super g2, ? super g2, g2> qVar) {
        l0.p(sArr, "$this$runningReduceIndexed");
        l0.p(qVar, "operation");
        if (h2.t(sArr)) {
            return k0.INSTANCE;
        }
        short sM = g2.m(sArr[0]);
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(new g2(sM));
        int length = sArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            sM = qVar.invoke(Integer.valueOf(i10), new g2(sM), new g2(g2.m(sArr[i10]))).f10193a;
            arrayList.add(new g2(sM));
        }
        return arrayList;
    }

    public static void Ma(long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = jArr.length;
        }
        La(jArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfInt")
    @f1(version = "1.4")
    @t
    public static final int Mb(long[] jArr, jn.l<? super a2, Integer> lVar) {
        l0.p(jArr, "$this$sumOf");
        l0.p(lVar, "selector");
        int iIntValue = 0;
        for (long j10 : jArr) {
            iIntValue += ((Number) qm.c.a(a2.m(j10), lVar)).intValue();
        }
        return iIntValue;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final Iterable<nm.s0<a2>> Mc(@l long[] jArr) {
        l0.p(jArr, "$this$withIndex");
        return new t0(new b(jArr));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short N0(short[] sArr) {
        l0.p(sArr, "$this$component4");
        return g2.m(sArr[3]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<g2> N1(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$dropLastWhile");
        l0.p(lVar, "predicate");
        for (int iXe = r.xe(sArr); -1 < iXe; iXe--) {
            if (!((Boolean) qm.b.a(g2.m(sArr[iXe]), lVar)).booleanValue()) {
                return fc(sArr, iXe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final g2 N2(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$findLast");
        l0.p(lVar, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                short sM = g2.m(sArr[length]);
                if (((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                    return new g2(sM);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void N3(short[] sArr, jn.l<? super g2, l2> lVar) {
        l0.p(sArr, "$this$forEach");
        l0.p(lVar, k4.f.f8937e);
        for (short s10 : sArr) {
            lVar.invoke(new g2(g2.m(s10)));
        }
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int N4(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$indexOfFirst");
        l0.p(lVar, "predicate");
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (((Boolean) qm.b.a(g2.m(sArr[i10]), lVar)).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final double N5(long[] jArr, jn.l<? super a2, Double> lVar) {
        l0.p(jArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) qm.c.a(a2.m(jArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) qm.c.a(a2.m(jArr[it.nextInt()]), lVar)).doubleValue());
        }
        return dDoubleValue;
    }

    @an.f
    @i(name = "minByOrThrow-U")
    @f1(version = "1.7")
    @t
    public static final <R extends Comparable<? super R>> short N6(short[] sArr, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$minBy");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        short sM = g2.m(sArr[0]);
        int iXe = r.xe(sArr);
        if (iXe == 0) {
            return sM;
        }
        Comparable comparable = (Comparable) qm.b.a(sM, lVar);
        v0 v0VarA = o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short sM2 = g2.m(sArr[v0VarA.nextInt()]);
            Comparable comparable2 = (Comparable) qm.b.a(sM2, lVar);
            if (comparable.compareTo(comparable2) > 0) {
                sM = sM2;
                comparable = comparable2;
            }
        }
        return sM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean N7(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$none");
        l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            if (((Boolean) qm.c.a(a2.m(j10), lVar)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final a2 N8(long[] jArr, q<? super Integer, ? super a2, ? super a2, a2> qVar) {
        l0.p(jArr, "$this$reduceIndexedOrNull");
        l0.p(qVar, "operation");
        if (b2.t(jArr)) {
            return null;
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            jM = qVar.invoke(Integer.valueOf(iNextInt), new a2(jM), new a2(a2.m(jArr[iNextInt]))).f10177a;
        }
        return new a2(jM);
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final List<a2> N9(long[] jArr, q<? super Integer, ? super a2, ? super a2, a2> qVar) {
        l0.p(jArr, "$this$runningReduceIndexed");
        l0.p(qVar, "operation");
        if (b2.t(jArr)) {
            return k0.INSTANCE;
        }
        long jM = a2.m(jArr[0]);
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(new a2(jM));
        int length = jArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            jM = qVar.invoke(Integer.valueOf(i10), new a2(jM), new a2(a2.m(jArr[i10]))).f10177a;
            arrayList.add(new a2(jM));
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    public static final void Na(@l byte[] bArr, int i10, int i11) {
        l0.p(bArr, "$this$sort");
        nm.c.Companion.d(i10, i11, bArr.length);
        u1.j(bArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfInt")
    @f1(version = "1.4")
    @t
    public static final int Nb(short[] sArr, jn.l<? super g2, Integer> lVar) {
        l0.p(sArr, "$this$sumOf");
        l0.p(lVar, "selector");
        int iIntValue = 0;
        for (short s10 : sArr) {
            iIntValue += ((Number) qm.b.a(g2.m(s10), lVar)).intValue();
        }
        return iIntValue;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final Iterable<nm.s0<g2>> Nc(@l short[] sArr) {
        l0.p(sArr, "$this$withIndex");
        return new t0(new d(sArr));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int O0(int[] iArr) {
        l0.p(iArr, "$this$component5");
        return w1.m(iArr[4]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<s1> O1(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$dropWhile");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            if (z10) {
                arrayList.add(new s1(bM));
            } else if (!((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                arrayList.add(new s1(bM));
                z10 = true;
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int O2(int[] iArr) {
        l0.p(iArr, "$this$first");
        return w1.m(r.Nb(iArr));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void O3(byte[] bArr, p<? super Integer, ? super s1, l2> pVar) {
        l0.p(bArr, "$this$forEachIndexed");
        l0.p(pVar, k4.f.f8937e);
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), new s1(s1.m(bArr[i10])));
            i10++;
            i11++;
        }
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int O4(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$indexOfLast");
        l0.p(lVar, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i10 = length - 1;
            if (((Boolean) qm.d.a(s1.m(bArr[length]), lVar)).booleanValue()) {
                return length;
            }
            if (i10 < 0) {
                return -1;
            }
            length = i10;
        }
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final float O5(long[] jArr, jn.l<? super a2, Float> lVar) {
        l0.p(jArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) qm.c.a(a2.m(jArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) qm.c.a(a2.m(jArr[it.nextInt()]), lVar)).floatValue());
        }
        return fFloatValue;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final double O6(byte[] bArr, jn.l<? super s1, Double> lVar) {
        l0.p(bArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) qm.d.a(s1.m(bArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) qm.d.a(s1.m(bArr[it.nextInt()]), lVar)).doubleValue());
        }
        return dDoubleValue;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean O7(long[] jArr) {
        l0.p(jArr, "$this$none");
        return b2.t(jArr);
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final s1 O8(byte[] bArr, p<? super s1, ? super s1, s1> pVar) {
        l0.p(bArr, "$this$reduceOrNull");
        l0.p(pVar, "operation");
        if (t1.t(bArr)) {
            return null;
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            bM = pVar.invoke(new s1(bM), new s1(s1.m(bArr[it.nextInt()]))).f10218a;
        }
        return new s1(bM);
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final <R> List<R> O9(long[] jArr, R r10, p<? super R, ? super a2, ? extends R> pVar) {
        l0.p(jArr, "$this$scan");
        l0.p(pVar, "operation");
        if (b2.t(jArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        for (long j10 : jArr) {
            r10 = pVar.invoke(r10, new a2(a2.m(j10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    public static void Oa(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        Na(bArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfLong")
    @f1(version = "1.4")
    @t
    public static final long Ob(byte[] bArr, jn.l<? super s1, Long> lVar) {
        l0.p(bArr, "$this$sumOf");
        l0.p(lVar, "selector");
        long jLongValue = 0;
        for (byte b10 : bArr) {
            jLongValue += ((Number) qm.d.a(s1.m(b10), lVar)).longValue();
        }
        return jLongValue;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, V> List<V> Oc(int[] iArr, Iterable<? extends R> iterable, p<? super w1, ? super R, ? extends V> pVar) {
        l0.p(iArr, "$this$zip");
        l0.p(iterable, "other");
        l0.p(pVar, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(new w1(w1.m(iArr[i10])), r10));
            i10++;
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte P0(byte[] bArr) {
        l0.p(bArr, "$this$component5");
        return s1.m(bArr[4]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<a2> P1(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$dropWhile");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            if (z10) {
                arrayList.add(new a2(jM));
            } else if (!((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                arrayList.add(new a2(jM));
                z10 = true;
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte P2(byte[] bArr) {
        l0.p(bArr, "$this$first");
        return s1.m(r.Fb(bArr));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void P3(int[] iArr, p<? super Integer, ? super w1, l2> pVar) {
        l0.p(iArr, "$this$forEachIndexed");
        l0.p(pVar, k4.f.f8937e);
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), new w1(w1.m(iArr[i10])));
            i10++;
            i11++;
        }
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int P4(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$indexOfLast");
        l0.p(lVar, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i10 = length - 1;
            if (((Boolean) qm.c.a(a2.m(jArr[length]), lVar)).booleanValue()) {
                return length;
            }
            if (i10 < 0) {
                return -1;
            }
            length = i10;
        }
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R P5(long[] jArr, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.c.a(a2.m(jArr[0]), lVar);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.c.a(a2.m(jArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) < 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final float P6(byte[] bArr, jn.l<? super s1, Float> lVar) {
        l0.p(bArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) qm.d.a(s1.m(bArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) qm.d.a(s1.m(bArr[it.nextInt()]), lVar)).floatValue());
        }
        return fFloatValue;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean P7(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$none");
        l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            if (((Boolean) e.a(w1.m(i10), lVar)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final w1 P8(int[] iArr, p<? super w1, ? super w1, w1> pVar) {
        l0.p(iArr, "$this$reduceOrNull");
        l0.p(pVar, "operation");
        if (x1.t(iArr)) {
            return null;
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            iM = pVar.invoke(new w1(iM), new w1(w1.m(iArr[it.nextInt()]))).f10227a;
        }
        return new w1(iM);
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final <R> List<R> P9(byte[] bArr, R r10, p<? super R, ? super s1, ? extends R> pVar) {
        l0.p(bArr, "$this$scan");
        l0.p(pVar, "operation");
        if (t1.t(bArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        for (byte b10 : bArr) {
            r10 = pVar.invoke(r10, new s1(s1.m(b10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    public static final void Pa(@l short[] sArr, int i10, int i11) {
        l0.p(sArr, "$this$sort");
        nm.c.Companion.d(i10, i11, sArr.length);
        u1.k(sArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfLong")
    @f1(version = "1.4")
    @t
    public static final long Pb(int[] iArr, jn.l<? super w1, Long> lVar) {
        l0.p(iArr, "$this$sumOf");
        l0.p(lVar, "selector");
        long jLongValue = 0;
        for (int i10 : iArr) {
            jLongValue += ((Number) e.a(w1.m(i10), lVar)).longValue();
        }
        return jLongValue;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, V> List<V> Pc(long[] jArr, R[] rArr, p<? super a2, ? super R, ? extends V> pVar) {
        l0.p(jArr, "$this$zip");
        l0.p(rArr, "other");
        l0.p(pVar, "transform");
        int iMin = Math.min(jArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(new a2(a2.m(jArr[i10])), rArr[i10]));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long Q0(long[] jArr) {
        l0.p(jArr, "$this$component5");
        return a2.m(jArr[4]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<w1> Q1(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$dropWhile");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            if (z10) {
                arrayList.add(new w1(iM));
            } else if (!((Boolean) e.a(iM, lVar)).booleanValue()) {
                arrayList.add(new w1(iM));
                z10 = true;
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte Q2(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$first");
        l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            if (((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                return bM;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void Q3(long[] jArr, p<? super Integer, ? super a2, l2> pVar) {
        l0.p(jArr, "$this$forEachIndexed");
        l0.p(pVar, k4.f.f8937e);
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), new a2(a2.m(jArr[i10])));
            i10++;
            i11++;
        }
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int Q4(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$indexOfLast");
        l0.p(lVar, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i10 = length - 1;
            if (((Boolean) e.a(w1.m(iArr[length]), lVar)).booleanValue()) {
                return length;
            }
            if (i10 < 0) {
                return -1;
            }
            length = i10;
        }
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final double Q5(int[] iArr, jn.l<? super w1, Double> lVar) {
        l0.p(iArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) e.a(w1.m(iArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) e.a(w1.m(iArr[it.nextInt()]), lVar)).doubleValue());
        }
        return dDoubleValue;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R Q6(byte[] bArr, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.d.a(s1.m(bArr[0]), lVar);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.d.a(s1.m(bArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) > 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean Q7(short[] sArr) {
        l0.p(sArr, "$this$none");
        return h2.t(sArr);
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final a2 Q8(long[] jArr, p<? super a2, ? super a2, a2> pVar) {
        l0.p(jArr, "$this$reduceOrNull");
        l0.p(pVar, "operation");
        if (b2.t(jArr)) {
            return null;
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            jM = pVar.invoke(new a2(jM), new a2(a2.m(jArr[it.nextInt()]))).f10177a;
        }
        return new a2(jM);
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final <R> List<R> Q9(int[] iArr, R r10, p<? super R, ? super w1, ? extends R> pVar) {
        l0.p(iArr, "$this$scan");
        l0.p(pVar, "operation");
        if (x1.t(iArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        for (int i10 : iArr) {
            r10 = pVar.invoke(r10, new w1(w1.m(i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    public static void Qa(short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = sArr.length;
        }
        Pa(sArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfLong")
    @f1(version = "1.4")
    @t
    public static final long Qb(long[] jArr, jn.l<? super a2, Long> lVar) {
        l0.p(jArr, "$this$sumOf");
        l0.p(lVar, "selector");
        long jLongValue = 0;
        for (long j10 : jArr) {
            jLongValue += ((Number) qm.c.a(a2.m(j10), lVar)).longValue();
        }
        return jLongValue;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final <R> List<lm.t0<w1, R>> Qc(@l int[] iArr, @l R[] rArr) {
        l0.p(iArr, "$this$zip");
        l0.p(rArr, "other");
        int iMin = Math.min(iArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            int iM = w1.m(iArr[i10]);
            arrayList.add(new lm.t0(new w1(iM), rArr[i10]));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short R0(short[] sArr) {
        l0.p(sArr, "$this$component5");
        return g2.m(sArr[4]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<g2> R1(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$dropWhile");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            if (z10) {
                arrayList.add(new g2(sM));
            } else if (!((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                arrayList.add(new g2(sM));
                z10 = true;
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long R2(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$first");
        l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            if (((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                return jM;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void R3(short[] sArr, p<? super Integer, ? super g2, l2> pVar) {
        l0.p(sArr, "$this$forEachIndexed");
        l0.p(pVar, k4.f.f8937e);
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), new g2(g2.m(sArr[i10])));
            i10++;
            i11++;
        }
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int R4(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$indexOfLast");
        l0.p(lVar, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return -1;
        }
        while (true) {
            int i10 = length - 1;
            if (((Boolean) qm.b.a(g2.m(sArr[length]), lVar)).booleanValue()) {
                return length;
            }
            if (i10 < 0) {
                return -1;
            }
            length = i10;
        }
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final float R5(int[] iArr, jn.l<? super w1, Float> lVar) {
        l0.p(iArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) e.a(w1.m(iArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) e.a(w1.m(iArr[it.nextInt()]), lVar)).floatValue());
        }
        return fFloatValue;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final double R6(long[] jArr, jn.l<? super a2, Double> lVar) {
        l0.p(jArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) qm.c.a(a2.m(jArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) qm.c.a(a2.m(jArr[it.nextInt()]), lVar)).doubleValue());
        }
        return dDoubleValue;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean R7(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$none");
        l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            if (((Boolean) qm.b.a(g2.m(s10), lVar)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final g2 R8(short[] sArr, p<? super g2, ? super g2, g2> pVar) {
        l0.p(sArr, "$this$reduceOrNull");
        l0.p(pVar, "operation");
        if (h2.t(sArr)) {
            return null;
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            sM = pVar.invoke(new g2(sM), new g2(g2.m(sArr[it.nextInt()]))).f10193a;
        }
        return new g2(sM);
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final <R> List<R> R9(short[] sArr, R r10, p<? super R, ? super g2, ? extends R> pVar) {
        l0.p(sArr, "$this$scan");
        l0.p(pVar, "operation");
        if (h2.t(sArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        for (short s10 : sArr) {
            r10 = pVar.invoke(r10, new g2(g2.m(s10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    public static final void Ra(@l byte[] bArr) {
        l0.p(bArr, "$this$sort");
        if (bArr.length > 1) {
            u1.j(bArr, 0, bArr.length);
        }
    }

    @s0
    @an.f
    @i(name = "sumOfLong")
    @f1(version = "1.4")
    @t
    public static final long Rb(short[] sArr, jn.l<? super g2, Long> lVar) {
        l0.p(sArr, "$this$sumOf");
        l0.p(lVar, "selector");
        long jLongValue = 0;
        for (short s10 : sArr) {
            jLongValue += ((Number) qm.b.a(g2.m(s10), lVar)).longValue();
        }
        return jLongValue;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final <R> List<lm.t0<a2, R>> Rc(@l long[] jArr, @l Iterable<? extends R> iterable) {
        l0.p(jArr, "$this$zip");
        l0.p(iterable, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(new a2(a2.m(jArr[i10])), r10));
            i10++;
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    public static boolean S0(@m short[] sArr, @m short[] sArr2) {
        if (sArr == null) {
            sArr = null;
        }
        if (sArr2 == null) {
            sArr2 = null;
        }
        return Arrays.equals(sArr, sArr2);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short S1(short[] sArr, int i10, jn.l<? super Integer, g2> lVar) {
        l0.p(sArr, "$this$elementAtOrElse");
        l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > r.xe(sArr)) ? lVar.invoke(Integer.valueOf(i10)).f10193a : g2.m(sArr[i10]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long S2(long[] jArr) {
        l0.p(jArr, "$this$first");
        return a2.m(r.Pb(jArr));
    }

    @l
    public static final tn.l S3(@l int[] iArr) {
        l0.p(iArr, "$this$indices");
        return r.le(iArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int S4(int[] iArr) {
        l0.p(iArr, "$this$last");
        return w1.m(r.wh(iArr));
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R S5(int[] iArr, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) e.a(w1.m(iArr[0]), lVar);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) e.a(w1.m(iArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) < 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final float S6(long[] jArr, jn.l<? super a2, Float> lVar) {
        l0.p(jArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) qm.c.a(a2.m(jArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) qm.c.a(a2.m(jArr[it.nextInt()]), lVar)).floatValue());
        }
        return fFloatValue;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final byte[] S7(byte[] bArr, jn.l<? super s1, l2> lVar) {
        l0.p(bArr, "$this$onEach");
        l0.p(lVar, k4.f.f8937e);
        for (byte b10 : bArr) {
            lVar.invoke(new s1(s1.m(b10)));
        }
        return bArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte S8(byte[] bArr, p<? super s1, ? super s1, s1> pVar) {
        l0.p(bArr, "$this$reduceRight");
        l0.p(pVar, "operation");
        int iQe = r.qe(bArr);
        if (iQe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM = s1.m(bArr[iQe]);
        for (int i10 = iQe - 1; i10 >= 0; i10--) {
            bM = pVar.invoke(new s1(s1.m(bArr[i10])), new s1(bM)).f10218a;
        }
        return bM;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final <R> List<R> S9(byte[] bArr, R r10, q<? super Integer, ? super R, ? super s1, ? extends R> qVar) {
        l0.p(bArr, "$this$scanIndexed");
        l0.p(qVar, "operation");
        if (t1.t(bArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, new s1(s1.m(bArr[i10])));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    public static final void Sa(@l long[] jArr) {
        l0.p(jArr, "$this$sort");
        if (jArr.length > 1) {
            u1.i(jArr, 0, jArr.length);
        }
    }

    @f1(version = "1.5")
    @i(name = "sumOfUByte")
    @p2(markerClass = {t.class})
    public static final int Sb(@l s1[] s1VarArr) {
        l0.p(s1VarArr, "<this>");
        int iM = 0;
        for (s1 s1Var : s1VarArr) {
            iM += w1.m(s1Var.f10218a & 255);
        }
        return iM;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final <R> List<lm.t0<w1, R>> Sc(@l int[] iArr, @l Iterable<? extends R> iterable) {
        l0.p(iArr, "$this$zip");
        l0.p(iterable, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(new w1(w1.m(iArr[i10])), r10));
            i10++;
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    public static boolean T0(@m int[] iArr, @m int[] iArr2) {
        if (iArr == null) {
            iArr = null;
        }
        if (iArr2 == null) {
            iArr2 = null;
        }
        return Arrays.equals(iArr, iArr2);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int T1(int[] iArr, int i10, jn.l<? super Integer, w1> lVar) {
        l0.p(iArr, "$this$elementAtOrElse");
        l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > r.ue(iArr)) ? lVar.invoke(Integer.valueOf(i10)).f10227a : w1.m(iArr[i10]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int T2(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$first");
        l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            if (((Boolean) e.a(iM, lVar)).booleanValue()) {
                return iM;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @f1(version = "1.3")
    @t
    public static /* synthetic */ void T3(int[] iArr) {
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte T4(byte[] bArr) {
        l0.p(bArr, "$this$last");
        return s1.m(r.oh(bArr));
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final double T5(short[] sArr, jn.l<? super g2, Double> lVar) {
        l0.p(sArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) qm.b.a(g2.m(sArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) qm.b.a(g2.m(sArr[it.nextInt()]), lVar)).doubleValue());
        }
        return dDoubleValue;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R T6(long[] jArr, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.c.a(a2.m(jArr[0]), lVar);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.c.a(a2.m(jArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) > 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final long[] T7(long[] jArr, jn.l<? super a2, l2> lVar) {
        l0.p(jArr, "$this$onEach");
        l0.p(lVar, k4.f.f8937e);
        for (long j10 : jArr) {
            lVar.invoke(new a2(a2.m(j10)));
        }
        return jArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int T8(int[] iArr, p<? super w1, ? super w1, w1> pVar) {
        l0.p(iArr, "$this$reduceRight");
        l0.p(pVar, "operation");
        int iUe = r.ue(iArr);
        if (iUe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM = w1.m(iArr[iUe]);
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            iM = pVar.invoke(new w1(w1.m(iArr[i10])), new w1(iM)).f10227a;
        }
        return iM;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final <R> List<R> T9(short[] sArr, R r10, q<? super Integer, ? super R, ? super g2, ? extends R> qVar) {
        l0.p(sArr, "$this$scanIndexed");
        l0.p(qVar, "operation");
        if (h2.t(sArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, new g2(g2.m(sArr[i10])));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    public static final void Ta(@l int[] iArr, int i10, int i11) {
        l0.p(iArr, "$this$sort");
        nm.c.Companion.d(i10, i11, iArr.length);
        u1.l(iArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfUInt")
    @p2(markerClass = {t.class})
    @f1(version = "1.5")
    @t
    public static final int Tb(byte[] bArr, jn.l<? super s1, w1> lVar) {
        l0.p(bArr, "$this$sumOf");
        l0.p(lVar, "selector");
        int iM = w1.m(0);
        for (byte b10 : bArr) {
            iM += ((w1) qm.d.a(s1.m(b10), lVar)).f10227a;
        }
        return iM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <V> List<V> Tc(byte[] bArr, byte[] bArr2, p<? super s1, ? super s1, ? extends V> pVar) {
        l0.p(bArr, "$this$zip");
        l0.p(bArr2, "other");
        l0.p(pVar, "transform");
        int iMin = Math.min(bArr.length, bArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(new s1(s1.m(bArr[i10])), new s1(s1.m(bArr2[i10]))));
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    public static boolean U0(@m byte[] bArr, @m byte[] bArr2) {
        if (bArr == null) {
            bArr = null;
        }
        if (bArr2 == null) {
            bArr2 = null;
        }
        return Arrays.equals(bArr, bArr2);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long U1(long[] jArr, int i10, jn.l<? super Integer, a2> lVar) {
        l0.p(jArr, "$this$elementAtOrElse");
        l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > r.ve(jArr)) ? lVar.invoke(Integer.valueOf(i10)).f10177a : a2.m(jArr[i10]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short U2(short[] sArr) {
        l0.p(sArr, "$this$first");
        return g2.m(r.Tb(sArr));
    }

    @l
    public static final tn.l U3(@l byte[] bArr) {
        l0.p(bArr, "$this$indices");
        return r.he(bArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte U4(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$last");
        l0.p(lVar, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                byte bM = s1.m(bArr[length]);
                if (((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                    return bM;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final float U5(short[] sArr, jn.l<? super g2, Float> lVar) {
        l0.p(sArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) qm.b.a(g2.m(sArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) qm.b.a(g2.m(sArr[it.nextInt()]), lVar)).floatValue());
        }
        return fFloatValue;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final double U6(int[] iArr, jn.l<? super w1, Double> lVar) {
        l0.p(iArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) e.a(w1.m(iArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) e.a(w1.m(iArr[it.nextInt()]), lVar)).doubleValue());
        }
        return dDoubleValue;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final int[] U7(int[] iArr, jn.l<? super w1, l2> lVar) {
        l0.p(iArr, "$this$onEach");
        l0.p(lVar, k4.f.f8937e);
        for (int i10 : iArr) {
            lVar.invoke(new w1(w1.m(i10)));
        }
        return iArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long U8(long[] jArr, p<? super a2, ? super a2, a2> pVar) {
        l0.p(jArr, "$this$reduceRight");
        l0.p(pVar, "operation");
        int iVe = r.ve(jArr);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM = a2.m(jArr[iVe]);
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            jM = pVar.invoke(new a2(a2.m(jArr[i10])), new a2(jM)).f10177a;
        }
        return jM;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final <R> List<R> U9(long[] jArr, R r10, q<? super Integer, ? super R, ? super a2, ? extends R> qVar) {
        l0.p(jArr, "$this$scanIndexed");
        l0.p(qVar, "operation");
        if (b2.t(jArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, new a2(a2.m(jArr[i10])));
            arrayList.add(r10);
        }
        return arrayList;
    }

    public static void Ua(int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = iArr.length;
        }
        Ta(iArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfUInt")
    @p2(markerClass = {t.class})
    @f1(version = "1.5")
    @t
    public static final int Ub(int[] iArr, jn.l<? super w1, w1> lVar) {
        l0.p(iArr, "$this$sumOf");
        l0.p(lVar, "selector");
        int iM = w1.m(0);
        for (int i10 : iArr) {
            iM += ((w1) e.a(w1.m(i10), lVar)).f10227a;
        }
        return iM;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final <R> List<lm.t0<g2, R>> Uc(@l short[] sArr, @l Iterable<? extends R> iterable) {
        l0.p(sArr, "$this$zip");
        l0.p(iterable, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(new g2(g2.m(sArr[i10])), r10));
            i10++;
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    public static boolean V0(@m long[] jArr, @m long[] jArr2) {
        if (jArr == null) {
            jArr = null;
        }
        if (jArr2 == null) {
            jArr2 = null;
        }
        return Arrays.equals(jArr, jArr2);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte V1(byte[] bArr, int i10, jn.l<? super Integer, s1> lVar) {
        l0.p(bArr, "$this$elementAtOrElse");
        l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > r.qe(bArr)) ? lVar.invoke(Integer.valueOf(i10)).f10218a : s1.m(bArr[i10]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short V2(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$first");
        l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            if (((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                return sM;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @f1(version = "1.3")
    @t
    public static /* synthetic */ void V3(byte[] bArr) {
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long V4(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$last");
        l0.p(lVar, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                long jM = a2.m(jArr[length]);
                if (((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                    return jM;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R V5(short[] sArr, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$maxOf");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.b.a(g2.m(sArr[0]), lVar);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.b.a(g2.m(sArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) < 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final float V6(int[] iArr, jn.l<? super w1, Float> lVar) {
        l0.p(iArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) e.a(w1.m(iArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) e.a(w1.m(iArr[it.nextInt()]), lVar)).floatValue());
        }
        return fFloatValue;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final short[] V7(short[] sArr, jn.l<? super g2, l2> lVar) {
        l0.p(sArr, "$this$onEach");
        l0.p(lVar, k4.f.f8937e);
        for (short s10 : sArr) {
            lVar.invoke(new g2(g2.m(s10)));
        }
        return sArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short V8(short[] sArr, p<? super g2, ? super g2, g2> pVar) {
        l0.p(sArr, "$this$reduceRight");
        l0.p(pVar, "operation");
        int iXe = r.xe(sArr);
        if (iXe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM = g2.m(sArr[iXe]);
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sM = pVar.invoke(new g2(g2.m(sArr[i10])), new g2(sM)).f10193a;
        }
        return sM;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final <R> List<R> V9(int[] iArr, R r10, q<? super Integer, ? super R, ? super w1, ? extends R> qVar) {
        l0.p(iArr, "$this$scanIndexed");
        l0.p(qVar, "operation");
        if (x1.t(iArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, new w1(w1.m(iArr[i10])));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    public static final void Va(@l short[] sArr) {
        l0.p(sArr, "$this$sort");
        if (sArr.length > 1) {
            u1.k(sArr, 0, sArr.length);
        }
    }

    @s0
    @an.f
    @i(name = "sumOfUInt")
    @p2(markerClass = {t.class})
    @f1(version = "1.5")
    @t
    public static final int Vb(long[] jArr, jn.l<? super a2, w1> lVar) {
        l0.p(jArr, "$this$sumOf");
        l0.p(lVar, "selector");
        int iM = w1.m(0);
        for (long j10 : jArr) {
            iM += ((w1) qm.c.a(a2.m(j10), lVar)).f10227a;
        }
        return iM;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final <R> List<lm.t0<s1, R>> Vc(@l byte[] bArr, @l Iterable<? extends R> iterable) {
        l0.p(bArr, "$this$zip");
        l0.p(iterable, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(new s1(s1.m(bArr[i10])), r10));
            i10++;
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean W(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$all");
        l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            if (!((Boolean) qm.d.a(s1.m(b10), lVar)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @f1(version = "1.4")
    @t
    public static final int W0(@m byte[] bArr) {
        if (bArr == null) {
            bArr = null;
        }
        return Arrays.hashCode(bArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final s1 W1(byte[] bArr, int i10) {
        l0.p(bArr, "$this$elementAtOrNull");
        return m4(bArr, i10);
    }

    @m
    @f1(version = "1.3")
    @t
    public static final w1 W2(@l int[] iArr) {
        l0.p(iArr, "$this$firstOrNull");
        if (x1.t(iArr)) {
            return null;
        }
        return new w1(w1.m(iArr[0]));
    }

    @l
    public static final tn.l W3(@l long[] jArr) {
        l0.p(jArr, "$this$indices");
        return r.me(jArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long W4(long[] jArr) {
        l0.p(jArr, "$this$last");
        return a2.m(r.yh(jArr));
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R W5(byte[] bArr, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        R r10 = (R) qm.d.a(s1.m(bArr[0]), lVar);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.d.a(s1.m(bArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) < 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R W6(int[] iArr, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) e.a(w1.m(iArr[0]), lVar);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) e.a(w1.m(iArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) > 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final byte[] W7(byte[] bArr, p<? super Integer, ? super s1, l2> pVar) {
        l0.p(bArr, "$this$onEachIndexed");
        l0.p(pVar, k4.f.f8937e);
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), new s1(s1.m(bArr[i10])));
            i10++;
            i11++;
        }
        return bArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int W8(int[] iArr, q<? super Integer, ? super w1, ? super w1, w1> qVar) {
        l0.p(iArr, "$this$reduceRightIndexed");
        l0.p(qVar, "operation");
        int iUe = r.ue(iArr);
        if (iUe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iM = w1.m(iArr[iUe]);
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            iM = qVar.invoke(Integer.valueOf(i10), new w1(w1.m(iArr[i10])), new w1(iM)).f10227a;
        }
        return iM;
    }

    @f1(version = "1.4")
    @t
    public static final void W9(@l int[] iArr) {
        l0.p(iArr, "$this$shuffle");
        X9(iArr, rn.f.Default);
    }

    @f1(version = "1.3")
    @t
    public static final void Wa(@l int[] iArr) {
        l0.p(iArr, "$this$sortDescending");
        if (iArr.length > 1) {
            Ka(iArr);
            r.Yq(iArr);
        }
    }

    @f1(version = "1.5")
    @i(name = "sumOfUInt")
    @p2(markerClass = {t.class})
    public static final int Wb(@l w1[] w1VarArr) {
        l0.p(w1VarArr, "<this>");
        int i10 = 0;
        for (w1 w1Var : w1VarArr) {
            i10 += w1Var.f10227a;
        }
        return i10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <V> List<V> Wc(int[] iArr, int[] iArr2, p<? super w1, ? super w1, ? extends V> pVar) {
        l0.p(iArr, "$this$zip");
        l0.p(iArr2, "other");
        l0.p(pVar, "transform");
        int iMin = Math.min(iArr.length, iArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(new w1(w1.m(iArr[i10])), new w1(w1.m(iArr2[i10]))));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean X(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$all");
        l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            if (!((Boolean) qm.c.a(a2.m(j10), lVar)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @f1(version = "1.4")
    @t
    public static final int X0(@m int[] iArr) {
        if (iArr == null) {
            iArr = null;
        }
        return Arrays.hashCode(iArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final g2 X1(short[] sArr, int i10) {
        l0.p(sArr, "$this$elementAtOrNull");
        return n4(sArr, i10);
    }

    @m
    @f1(version = "1.3")
    @t
    public static final s1 X2(@l byte[] bArr) {
        l0.p(bArr, "$this$firstOrNull");
        if (t1.t(bArr)) {
            return null;
        }
        return new s1(s1.m(bArr[0]));
    }

    @f1(version = "1.3")
    @t
    public static /* synthetic */ void X3(long[] jArr) {
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int X4(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$last");
        l0.p(lVar, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                int iM = w1.m(iArr[length]);
                if (((Boolean) e.a(iM, lVar)).booleanValue()) {
                    return iM;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Double X5(byte[] bArr, jn.l<? super s1, Double> lVar) {
        l0.p(bArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        double dDoubleValue = ((Number) qm.d.a(s1.m(bArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) qm.d.a(s1.m(bArr[it.nextInt()]), lVar)).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final double X6(short[] sArr, jn.l<? super g2, Double> lVar) {
        l0.p(sArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = ((Number) qm.b.a(g2.m(sArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) qm.b.a(g2.m(sArr[it.nextInt()]), lVar)).doubleValue());
        }
        return dDoubleValue;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final int[] X7(int[] iArr, p<? super Integer, ? super w1, l2> pVar) {
        l0.p(iArr, "$this$onEachIndexed");
        l0.p(pVar, k4.f.f8937e);
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), new w1(w1.m(iArr[i10])));
            i10++;
            i11++;
        }
        return iArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte X8(byte[] bArr, q<? super Integer, ? super s1, ? super s1, s1> qVar) {
        l0.p(bArr, "$this$reduceRightIndexed");
        l0.p(qVar, "operation");
        int iQe = r.qe(bArr);
        if (iQe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bM = s1.m(bArr[iQe]);
        for (int i10 = iQe - 1; i10 >= 0; i10--) {
            bM = qVar.invoke(Integer.valueOf(i10), new s1(s1.m(bArr[i10])), new s1(bM)).f10218a;
        }
        return bM;
    }

    @f1(version = "1.4")
    @t
    public static final void X9(@l int[] iArr, @l rn.f fVar) {
        l0.p(iArr, "$this$shuffle");
        l0.p(fVar, "random");
        for (int iUe = r.ue(iArr); iUe > 0; iUe--) {
            int iNextInt = fVar.nextInt(iUe + 1);
            int iM = w1.m(iArr[iUe]);
            iArr[iUe] = w1.m(iArr[iNextInt]);
            iArr[iNextInt] = iM;
        }
    }

    @f1(version = "1.4")
    @t
    public static final void Xa(@l long[] jArr, int i10, int i11) {
        l0.p(jArr, "$this$sortDescending");
        La(jArr, i10, i11);
        r.br(jArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfUInt")
    @p2(markerClass = {t.class})
    @f1(version = "1.5")
    @t
    public static final int Xb(short[] sArr, jn.l<? super g2, w1> lVar) {
        l0.p(sArr, "$this$sumOf");
        l0.p(lVar, "selector");
        int iM = w1.m(0);
        for (short s10 : sArr) {
            iM += ((w1) qm.b.a(g2.m(s10), lVar)).f10227a;
        }
        return iM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, V> List<V> Xc(byte[] bArr, R[] rArr, p<? super s1, ? super R, ? extends V> pVar) {
        l0.p(bArr, "$this$zip");
        l0.p(rArr, "other");
        l0.p(pVar, "transform");
        int iMin = Math.min(bArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(new s1(s1.m(bArr[i10])), rArr[i10]));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean Y(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$all");
        l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            if (!((Boolean) e.a(w1.m(i10), lVar)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @f1(version = "1.4")
    @t
    public static final int Y0(@m short[] sArr) {
        if (sArr == null) {
            sArr = null;
        }
        return Arrays.hashCode(sArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final w1 Y1(int[] iArr, int i10) {
        l0.p(iArr, "$this$elementAtOrNull");
        return o4(iArr, i10);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final s1 Y2(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$firstOrNull");
        l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            if (((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                return new s1(bM);
            }
        }
        return null;
    }

    @l
    public static final tn.l Y3(@l short[] sArr) {
        l0.p(sArr, "$this$indices");
        return r.oe(sArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short Y4(short[] sArr) {
        l0.p(sArr, "$this$last");
        return g2.m(r.Ch(sArr));
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Float Y5(byte[] bArr, jn.l<? super s1, Float> lVar) {
        l0.p(bArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        float fFloatValue = ((Number) qm.d.a(s1.m(bArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) qm.d.a(s1.m(bArr[it.nextInt()]), lVar)).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final float Y6(short[] sArr, jn.l<? super g2, Float> lVar) {
        l0.p(sArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        float fFloatValue = ((Number) qm.b.a(g2.m(sArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) qm.b.a(g2.m(sArr[it.nextInt()]), lVar)).floatValue());
        }
        return fFloatValue;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final long[] Y7(long[] jArr, p<? super Integer, ? super a2, l2> pVar) {
        l0.p(jArr, "$this$onEachIndexed");
        l0.p(pVar, k4.f.f8937e);
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), new a2(a2.m(jArr[i10])));
            i10++;
            i11++;
        }
        return jArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short Y8(short[] sArr, q<? super Integer, ? super g2, ? super g2, g2> qVar) {
        l0.p(sArr, "$this$reduceRightIndexed");
        l0.p(qVar, "operation");
        int iXe = r.xe(sArr);
        if (iXe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sM = g2.m(sArr[iXe]);
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sM = qVar.invoke(Integer.valueOf(i10), new g2(g2.m(sArr[i10])), new g2(sM)).f10193a;
        }
        return sM;
    }

    @f1(version = "1.4")
    @t
    public static final void Y9(@l byte[] bArr) {
        l0.p(bArr, "$this$shuffle");
        ba(bArr, rn.f.Default);
    }

    @f1(version = "1.4")
    @t
    public static final void Ya(@l byte[] bArr, int i10, int i11) {
        l0.p(bArr, "$this$sortDescending");
        Na(bArr, i10, i11);
        r.Rq(bArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfULong")
    @p2(markerClass = {t.class})
    @f1(version = "1.5")
    @t
    public static final long Yb(byte[] bArr, jn.l<? super s1, a2> lVar) {
        l0.p(bArr, "$this$sumOf");
        l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (byte b10 : bArr) {
            jM += ((a2) qm.d.a(s1.m(b10), lVar)).f10177a;
        }
        return jM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <V> List<V> Yc(long[] jArr, long[] jArr2, p<? super a2, ? super a2, ? extends V> pVar) {
        l0.p(jArr, "$this$zip");
        l0.p(jArr2, "other");
        l0.p(pVar, "transform");
        int iMin = Math.min(jArr.length, jArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(new a2(a2.m(jArr[i10])), new a2(a2.m(jArr2[i10]))));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean Z(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$all");
        l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            if (!((Boolean) qm.b.a(g2.m(s10), lVar)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @f1(version = "1.4")
    @t
    public static final int Z0(@m long[] jArr) {
        if (jArr == null) {
            jArr = null;
        }
        return Arrays.hashCode(jArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final a2 Z1(long[] jArr, int i10) {
        l0.p(jArr, "$this$elementAtOrNull");
        return p4(jArr, i10);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final a2 Z2(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$firstOrNull");
        l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            if (((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                return new a2(jM);
            }
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    public static /* synthetic */ void Z3(short[] sArr) {
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short Z4(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$last");
        l0.p(lVar, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                short sM = g2.m(sArr[length]);
                if (((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                    return sM;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R Z5(long[] jArr, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        R r10 = (R) qm.c.a(a2.m(jArr[0]), lVar);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.c.a(a2.m(jArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) < 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R Z6(short[] sArr, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$minOf");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.b.a(g2.m(sArr[0]), lVar);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.b.a(g2.m(sArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) > 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final short[] Z7(short[] sArr, p<? super Integer, ? super g2, l2> pVar) {
        l0.p(sArr, "$this$onEachIndexed");
        l0.p(pVar, k4.f.f8937e);
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), new g2(g2.m(sArr[i10])));
            i10++;
            i11++;
        }
        return sArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long Z8(long[] jArr, q<? super Integer, ? super a2, ? super a2, a2> qVar) {
        l0.p(jArr, "$this$reduceRightIndexed");
        l0.p(qVar, "operation");
        int iVe = r.ve(jArr);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jM = a2.m(jArr[iVe]);
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            jM = qVar.invoke(Integer.valueOf(i10), new a2(a2.m(jArr[i10])), new a2(jM)).f10177a;
        }
        return jM;
    }

    @f1(version = "1.4")
    @t
    public static final void Z9(@l long[] jArr, @l rn.f fVar) {
        l0.p(jArr, "$this$shuffle");
        l0.p(fVar, "random");
        for (int iVe = r.ve(jArr); iVe > 0; iVe--) {
            int iNextInt = fVar.nextInt(iVe + 1);
            long jM = a2.m(jArr[iVe]);
            jArr[iVe] = a2.m(jArr[iNextInt]);
            jArr[iNextInt] = jM;
        }
    }

    @f1(version = "1.4")
    @t
    public static final void Za(@l short[] sArr, int i10, int i11) {
        l0.p(sArr, "$this$sortDescending");
        Pa(sArr, i10, i11);
        r.fr(sArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfULong")
    @p2(markerClass = {t.class})
    @f1(version = "1.5")
    @t
    public static final long Zb(int[] iArr, jn.l<? super w1, a2> lVar) {
        l0.p(iArr, "$this$sumOf");
        l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (int i10 : iArr) {
            jM += ((a2) e.a(w1.m(i10), lVar)).f10177a;
        }
        return jM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, V> List<V> Zc(long[] jArr, Iterable<? extends R> iterable, p<? super a2, ? super R, ? extends V> pVar) {
        l0.p(jArr, "$this$zip");
        l0.p(iterable, "other");
        l0.p(pVar, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(new a2(a2.m(jArr[i10])), r10));
            i10++;
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean a0(int[] iArr) {
        l0.p(iArr, "$this$any");
        return r.l5(iArr);
    }

    @f1(version = "1.4")
    @t
    @l
    public static String a1(@m byte[] bArr) {
        String strM3;
        return (bArr == null || (strM3 = h0.m3(new t1(bArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? d6.a.E : strM3;
    }

    @f1(version = "1.3")
    @t
    public static final void a2(@l int[] iArr, int i10, int i11, int i12) {
        l0.p(iArr, "$this$fill");
        nm.p.K1(iArr, i10, i11, i12);
    }

    @m
    @f1(version = "1.3")
    @t
    public static final a2 a3(@l long[] jArr) {
        l0.p(jArr, "$this$firstOrNull");
        if (b2.t(jArr)) {
            return null;
        }
        return new a2(a2.m(jArr[0]));
    }

    public static final int a4(@l int[] iArr) {
        l0.p(iArr, "$this$lastIndex");
        return r.ue(iArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int a5(long[] jArr, long j10) {
        l0.p(jArr, "$this$lastIndexOf");
        return r.Lh(jArr, j10);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Double a6(long[] jArr, jn.l<? super a2, Double> lVar) {
        l0.p(jArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        double dDoubleValue = ((Number) qm.c.a(a2.m(jArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) qm.c.a(a2.m(jArr[it.nextInt()]), lVar)).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R a7(byte[] bArr, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        R r10 = (R) qm.d.a(s1.m(bArr[0]), lVar);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.d.a(s1.m(bArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) > 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] a8(long[] jArr, long j10) {
        l0.p(jArr, "$this$plus");
        long[] jArrT3 = nm.p.t3(jArr, j10);
        l0.p(jArrT3, "storage");
        return jArrT3;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final w1 a9(int[] iArr, q<? super Integer, ? super w1, ? super w1, w1> qVar) {
        l0.p(iArr, "$this$reduceRightIndexedOrNull");
        l0.p(qVar, "operation");
        int iUe = r.ue(iArr);
        if (iUe < 0) {
            return null;
        }
        int iM = w1.m(iArr[iUe]);
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            iM = qVar.invoke(Integer.valueOf(i10), new w1(w1.m(iArr[i10])), new w1(iM)).f10227a;
        }
        return new w1(iM);
    }

    @f1(version = "1.4")
    @t
    public static final void aa(@l long[] jArr) {
        l0.p(jArr, "$this$shuffle");
        Z9(jArr, rn.f.Default);
    }

    @f1(version = "1.3")
    @t
    public static final void ab(@l byte[] bArr) {
        l0.p(bArr, "$this$sortDescending");
        if (bArr.length > 1) {
            Ra(bArr);
            r.Qq(bArr);
        }
    }

    @s0
    @an.f
    @i(name = "sumOfULong")
    @p2(markerClass = {t.class})
    @f1(version = "1.5")
    @t
    public static final long ac(long[] jArr, jn.l<? super a2, a2> lVar) {
        l0.p(jArr, "$this$sumOf");
        l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (long j10 : jArr) {
            jM += ((a2) qm.c.a(a2.m(j10), lVar)).f10177a;
        }
        return jM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, V> List<V> ad(byte[] bArr, Iterable<? extends R> iterable, p<? super s1, ? super R, ? extends V> pVar) {
        l0.p(bArr, "$this$zip");
        l0.p(iterable, "other");
        l0.p(pVar, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(new s1(s1.m(bArr[i10])), r10));
            i10++;
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean b0(byte[] bArr) {
        l0.p(bArr, "$this$any");
        return r.d5(bArr);
    }

    @f1(version = "1.4")
    @t
    @l
    public static String b1(@m int[] iArr) {
        String strM3;
        return (iArr == null || (strM3 = h0.m3(new x1(iArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? d6.a.E : strM3;
    }

    public static void b2(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = iArr.length;
        }
        a2(iArr, i10, i11, i12);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final w1 b3(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$firstOrNull");
        l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            if (((Boolean) e.a(iM, lVar)).booleanValue()) {
                return new w1(iM);
            }
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    public static /* synthetic */ void b4(int[] iArr) {
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int b5(short[] sArr, short s10) {
        l0.p(sArr, "$this$lastIndexOf");
        return r.Nh(sArr, s10);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Float b6(long[] jArr, jn.l<? super a2, Float> lVar) {
        l0.p(jArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        float fFloatValue = ((Number) qm.c.a(a2.m(jArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) qm.c.a(a2.m(jArr[it.nextInt()]), lVar)).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Double b7(byte[] bArr, jn.l<? super s1, Double> lVar) {
        l0.p(bArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        double dDoubleValue = ((Number) qm.d.a(s1.m(bArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) qm.d.a(s1.m(bArr[it.nextInt()]), lVar)).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final int[] b8(@l int[] iArr, @l Collection<w1> collection) {
        l0.p(iArr, "$this$plus");
        l0.p(collection, "elements");
        int length = iArr.length;
        int[] iArrCopyOf = Arrays.copyOf(iArr, collection.size() + iArr.length);
        l0.o(iArrCopyOf, "copyOf(...)");
        Iterator<w1> it = collection.iterator();
        while (it.hasNext()) {
            iArrCopyOf[length] = it.next().f10227a;
            length++;
        }
        l0.p(iArrCopyOf, "storage");
        return iArrCopyOf;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final s1 b9(byte[] bArr, q<? super Integer, ? super s1, ? super s1, s1> qVar) {
        l0.p(bArr, "$this$reduceRightIndexedOrNull");
        l0.p(qVar, "operation");
        int iQe = r.qe(bArr);
        if (iQe < 0) {
            return null;
        }
        byte bM = s1.m(bArr[iQe]);
        for (int i10 = iQe - 1; i10 >= 0; i10--) {
            bM = qVar.invoke(Integer.valueOf(i10), new s1(s1.m(bArr[i10])), new s1(bM)).f10218a;
        }
        return new s1(bM);
    }

    @f1(version = "1.4")
    @t
    public static final void ba(@l byte[] bArr, @l rn.f fVar) {
        l0.p(bArr, "$this$shuffle");
        l0.p(fVar, "random");
        for (int iQe = r.qe(bArr); iQe > 0; iQe--) {
            int iNextInt = fVar.nextInt(iQe + 1);
            byte bM = s1.m(bArr[iQe]);
            bArr[iQe] = s1.m(bArr[iNextInt]);
            bArr[iNextInt] = bM;
        }
    }

    @f1(version = "1.3")
    @t
    public static final void bb(@l long[] jArr) {
        l0.p(jArr, "$this$sortDescending");
        if (jArr.length > 1) {
            Sa(jArr);
            r.ar(jArr);
        }
    }

    @f1(version = "1.5")
    @i(name = "sumOfULong")
    @p2(markerClass = {t.class})
    public static final long bc(@l a2[] a2VarArr) {
        l0.p(a2VarArr, "<this>");
        long j10 = 0;
        for (a2 a2Var : a2VarArr) {
            j10 += a2Var.f10177a;
        }
        return j10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, V> List<V> bd(int[] iArr, R[] rArr, p<? super w1, ? super R, ? extends V> pVar) {
        l0.p(iArr, "$this$zip");
        l0.p(rArr, "other");
        l0.p(pVar, "transform");
        int iMin = Math.min(iArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(new w1(w1.m(iArr[i10])), rArr[i10]));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean c0(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$any");
        l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            if (((Boolean) qm.d.a(s1.m(b10), lVar)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @f1(version = "1.4")
    @t
    @l
    public static String c1(@m short[] sArr) {
        String strM3;
        return (sArr == null || (strM3 = h0.m3(new h2(sArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? d6.a.E : strM3;
    }

    @f1(version = "1.3")
    @t
    public static final void c2(@l short[] sArr, short s10, int i10, int i11) {
        l0.p(sArr, "$this$fill");
        nm.p.N1(sArr, s10, i10, i11);
    }

    @m
    @f1(version = "1.3")
    @t
    public static final g2 c3(@l short[] sArr) {
        l0.p(sArr, "$this$firstOrNull");
        if (h2.t(sArr)) {
            return null;
        }
        return new g2(g2.m(sArr[0]));
    }

    public static final int c4(@l byte[] bArr) {
        l0.p(bArr, "$this$lastIndex");
        return r.qe(bArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int c5(byte[] bArr, byte b10) {
        l0.p(bArr, "$this$lastIndexOf");
        return r.Gh(bArr, b10);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R c6(int[] iArr, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        R r10 = (R) e.a(w1.m(iArr[0]), lVar);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) e.a(w1.m(iArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) < 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Float c7(byte[] bArr, jn.l<? super s1, Float> lVar) {
        l0.p(bArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        float fFloatValue = ((Number) qm.d.a(s1.m(bArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) qm.d.a(s1.m(bArr[it.nextInt()]), lVar)).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] c8(short[] sArr, short s10) {
        l0.p(sArr, "$this$plus");
        short[] sArrA3 = nm.p.A3(sArr, s10);
        l0.p(sArrA3, "storage");
        return sArrA3;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final g2 c9(short[] sArr, q<? super Integer, ? super g2, ? super g2, g2> qVar) {
        l0.p(sArr, "$this$reduceRightIndexedOrNull");
        l0.p(qVar, "operation");
        int iXe = r.xe(sArr);
        if (iXe < 0) {
            return null;
        }
        short sM = g2.m(sArr[iXe]);
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sM = qVar.invoke(Integer.valueOf(i10), new g2(g2.m(sArr[i10])), new g2(sM)).f10193a;
        }
        return new g2(sM);
    }

    @f1(version = "1.4")
    @t
    public static final void ca(@l short[] sArr) {
        l0.p(sArr, "$this$shuffle");
        da(sArr, rn.f.Default);
    }

    @f1(version = "1.4")
    @t
    public static final void cb(@l int[] iArr, int i10, int i11) {
        l0.p(iArr, "$this$sortDescending");
        Ta(iArr, i10, i11);
        r.Zq(iArr, i10, i11);
    }

    @s0
    @an.f
    @i(name = "sumOfULong")
    @p2(markerClass = {t.class})
    @f1(version = "1.5")
    @t
    public static final long cc(short[] sArr, jn.l<? super g2, a2> lVar) {
        l0.p(sArr, "$this$sumOf");
        l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (short s10 : sArr) {
            jM += ((a2) qm.b.a(g2.m(s10), lVar)).f10177a;
        }
        return jM;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<lm.t0<w1, w1>> cd(@l int[] iArr, @l int[] iArr2) {
        l0.p(iArr, "$this$zip");
        l0.p(iArr2, "other");
        int iMin = Math.min(iArr.length, iArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(new w1(w1.m(iArr[i10])), new w1(w1.m(iArr2[i10]))));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean d0(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$any");
        l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            if (((Boolean) qm.c.a(a2.m(j10), lVar)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @f1(version = "1.4")
    @t
    @l
    public static String d1(@m long[] jArr) {
        String strM3;
        return (jArr == null || (strM3 = h0.m3(new b2(jArr), ", ", "[", "]", 0, null, null, 56, null)) == null) ? d6.a.E : strM3;
    }

    public static void d2(short[] sArr, short s10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length;
        }
        c2(sArr, s10, i10, i11);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final g2 d3(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$firstOrNull");
        l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            if (((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                return new g2(sM);
            }
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    public static /* synthetic */ void d4(byte[] bArr) {
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int d5(int[] iArr, int i10) {
        l0.p(iArr, "$this$lastIndexOf");
        return r.Kh(iArr, i10);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Double d6(int[] iArr, jn.l<? super w1, Double> lVar) {
        l0.p(iArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        double dDoubleValue = ((Number) e.a(w1.m(iArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) e.a(w1.m(iArr[it.nextInt()]), lVar)).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R d7(long[] jArr, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        R r10 = (R) qm.c.a(a2.m(jArr[0]), lVar);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.c.a(a2.m(jArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) > 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] d8(int[] iArr, int[] iArr2) {
        l0.p(iArr, "$this$plus");
        l0.p(iArr2, "elements");
        int[] iArrS3 = nm.p.s3(iArr, iArr2);
        l0.p(iArrS3, "storage");
        return iArrS3;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final a2 d9(long[] jArr, q<? super Integer, ? super a2, ? super a2, a2> qVar) {
        l0.p(jArr, "$this$reduceRightIndexedOrNull");
        l0.p(qVar, "operation");
        int iVe = r.ve(jArr);
        if (iVe < 0) {
            return null;
        }
        long jM = a2.m(jArr[iVe]);
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            jM = qVar.invoke(Integer.valueOf(i10), new a2(a2.m(jArr[i10])), new a2(jM)).f10177a;
        }
        return new a2(jM);
    }

    @f1(version = "1.4")
    @t
    public static final void da(@l short[] sArr, @l rn.f fVar) {
        l0.p(sArr, "$this$shuffle");
        l0.p(fVar, "random");
        for (int iXe = r.xe(sArr); iXe > 0; iXe--) {
            int iNextInt = fVar.nextInt(iXe + 1);
            short sM = g2.m(sArr[iXe]);
            sArr[iXe] = g2.m(sArr[iNextInt]);
            sArr[iNextInt] = sM;
        }
    }

    @f1(version = "1.3")
    @t
    public static final void db(@l short[] sArr) {
        l0.p(sArr, "$this$sortDescending");
        if (sArr.length > 1) {
            Va(sArr);
            r.er(sArr);
        }
    }

    @f1(version = "1.5")
    @i(name = "sumOfUShort")
    @p2(markerClass = {t.class})
    public static final int dc(@l g2[] g2VarArr) {
        l0.p(g2VarArr, "<this>");
        int iM = 0;
        for (g2 g2Var : g2VarArr) {
            iM += w1.m(g2Var.f10193a & g2.f10190d);
        }
        return iM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, V> List<V> dd(short[] sArr, R[] rArr, p<? super g2, ? super R, ? extends V> pVar) {
        l0.p(sArr, "$this$zip");
        l0.p(rArr, "other");
        l0.p(pVar, "transform");
        int iMin = Math.min(sArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(new g2(g2.m(sArr[i10])), rArr[i10]));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean e0(long[] jArr) {
        l0.p(jArr, "$this$any");
        return r.n5(jArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] e1(long[] jArr, long[] jArr2, int i10, int i11, int i12) {
        l0.p(jArr, "$this$copyInto");
        l0.p(jArr2, RtspHeaders.Values.DESTINATION);
        nm.p.A0(jArr, jArr2, i10, i11, i12);
        return jArr2;
    }

    @f1(version = "1.3")
    @t
    public static final void e2(@l long[] jArr, long j10, int i10, int i11) {
        l0.p(jArr, "$this$fill");
        nm.p.L1(jArr, j10, i10, i11);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> e3(byte[] bArr, jn.l<? super s1, ? extends Iterable<? extends R>> lVar) {
        l0.p(bArr, "$this$flatMap");
        l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            d0.r0(arrayList, (Iterable) qm.d.a(s1.m(b10), lVar));
        }
        return arrayList;
    }

    public static final int e4(@l long[] jArr) {
        l0.p(jArr, "$this$lastIndex");
        return r.ve(jArr);
    }

    @m
    @f1(version = "1.3")
    @t
    public static final w1 e5(@l int[] iArr) {
        l0.p(iArr, "$this$lastOrNull");
        if (x1.t(iArr)) {
            return null;
        }
        return new w1(w1.m(iArr[iArr.length - 1]));
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Float e6(int[] iArr, jn.l<? super w1, Float> lVar) {
        l0.p(iArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        float fFloatValue = ((Number) e.a(w1.m(iArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) e.a(w1.m(iArr[it.nextInt()]), lVar)).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Double e7(long[] jArr, jn.l<? super a2, Double> lVar) {
        l0.p(jArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        double dDoubleValue = ((Number) qm.c.a(a2.m(jArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) qm.c.a(a2.m(jArr[it.nextInt()]), lVar)).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] e8(byte[] bArr, byte b10) {
        l0.p(bArr, "$this$plus");
        byte[] bArrE3 = nm.p.e3(bArr, b10);
        l0.p(bArrE3, "storage");
        return bArrE3;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final s1 e9(byte[] bArr, p<? super s1, ? super s1, s1> pVar) {
        l0.p(bArr, "$this$reduceRightOrNull");
        l0.p(pVar, "operation");
        int iQe = r.qe(bArr);
        if (iQe < 0) {
            return null;
        }
        byte bM = s1.m(bArr[iQe]);
        for (int i10 = iQe - 1; i10 >= 0; i10--) {
            bM = pVar.invoke(new s1(s1.m(bArr[i10])), new s1(bM)).f10218a;
        }
        return new s1(bM);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int ea(int[] iArr) {
        l0.p(iArr, "$this$single");
        return w1.m(r.ct(iArr));
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<w1> eb(@l int[] iArr) {
        l0.p(iArr, "$this$sorted");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        l0.o(iArrCopyOf, "copyOf(...)");
        l0.p(iArrCopyOf, "storage");
        Ka(iArrCopyOf);
        return f.a(iArrCopyOf);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<s1> ec(@l byte[] bArr, int i10) {
        l0.p(bArr, "$this$take");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= bArr.length) {
            return h0.V5(new t1(bArr));
        }
        if (i10 == 1) {
            return x.k(new s1(s1.m(bArr[0])));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (byte b10 : bArr) {
            arrayList.add(new s1(s1.m(b10)));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final <R> List<lm.t0<a2, R>> ed(@l long[] jArr, @l R[] rArr) {
        l0.p(jArr, "$this$zip");
        l0.p(rArr, "other");
        int iMin = Math.min(jArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            long jM = a2.m(jArr[i10]);
            arrayList.add(new lm.t0(new a2(jM), rArr[i10]));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean f0(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$any");
        l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            if (((Boolean) e.a(w1.m(i10), lVar)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static long[] f1(long[] jArr, long[] jArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = jArr.length;
        }
        l0.p(jArr, "$this$copyInto");
        l0.p(jArr2, RtspHeaders.Values.DESTINATION);
        nm.p.A0(jArr, jArr2, i10, i11, i12);
        return jArr2;
    }

    public static void f2(long[] jArr, long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length;
        }
        e2(jArr, j10, i10, i11);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> f3(long[] jArr, jn.l<? super a2, ? extends Iterable<? extends R>> lVar) {
        l0.p(jArr, "$this$flatMap");
        l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            d0.r0(arrayList, (Iterable) qm.c.a(a2.m(j10), lVar));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    public static /* synthetic */ void f4(long[] jArr) {
    }

    @m
    @f1(version = "1.3")
    @t
    public static final s1 f5(@l byte[] bArr) {
        l0.p(bArr, "$this$lastOrNull");
        if (t1.t(bArr)) {
            return null;
        }
        return new s1(s1.m(bArr[bArr.length - 1]));
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R f6(short[] sArr, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        R r10 = (R) qm.b.a(g2.m(sArr[0]), lVar);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.b.a(g2.m(sArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) < 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Float f7(long[] jArr, jn.l<? super a2, Float> lVar) {
        l0.p(jArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        float fFloatValue = ((Number) qm.c.a(a2.m(jArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) qm.c.a(a2.m(jArr[it.nextInt()]), lVar)).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] f8(byte[] bArr, byte[] bArr2) {
        l0.p(bArr, "$this$plus");
        l0.p(bArr2, "elements");
        byte[] bArrG3 = nm.p.g3(bArr, bArr2);
        l0.p(bArrG3, "storage");
        return bArrG3;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final w1 f9(int[] iArr, p<? super w1, ? super w1, w1> pVar) {
        l0.p(iArr, "$this$reduceRightOrNull");
        l0.p(pVar, "operation");
        int iUe = r.ue(iArr);
        if (iUe < 0) {
            return null;
        }
        int iM = w1.m(iArr[iUe]);
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            iM = pVar.invoke(new w1(w1.m(iArr[i10])), new w1(iM)).f10227a;
        }
        return new w1(iM);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte fa(byte[] bArr) {
        l0.p(bArr, "$this$single");
        return s1.m(r.Us(bArr));
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<s1> fb(@l byte[] bArr) {
        l0.p(bArr, "$this$sorted");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        l0.o(bArrCopyOf, "copyOf(...)");
        l0.p(bArrCopyOf, "storage");
        Ra(bArrCopyOf);
        return f.b(bArrCopyOf);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<g2> fc(@l short[] sArr, int i10) {
        l0.p(sArr, "$this$take");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= sArr.length) {
            return h0.V5(new h2(sArr));
        }
        if (i10 == 1) {
            return x.k(new g2(g2.m(sArr[0])));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (short s10 : sArr) {
            arrayList.add(new g2(g2.m(s10)));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <V> List<V> fd(short[] sArr, short[] sArr2, p<? super g2, ? super g2, ? extends V> pVar) {
        l0.p(sArr, "$this$zip");
        l0.p(sArr2, "other");
        l0.p(pVar, "transform");
        int iMin = Math.min(sArr.length, sArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(new g2(g2.m(sArr[i10])), new g2(g2.m(sArr2[i10]))));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean g0(short[] sArr) {
        l0.p(sArr, "$this$any");
        return r.r5(sArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] g1(short[] sArr, short[] sArr2, int i10, int i11, int i12) {
        l0.p(sArr, "$this$copyInto");
        l0.p(sArr2, RtspHeaders.Values.DESTINATION);
        nm.p.C0(sArr, sArr2, i10, i11, i12);
        return sArr2;
    }

    @f1(version = "1.3")
    @t
    public static final void g2(@l byte[] bArr, byte b10, int i10, int i11) {
        l0.p(bArr, "$this$fill");
        nm.p.G1(bArr, b10, i10, i11);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> g3(int[] iArr, jn.l<? super w1, ? extends Iterable<? extends R>> lVar) {
        l0.p(iArr, "$this$flatMap");
        l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            d0.r0(arrayList, (Iterable) e.a(w1.m(i10), lVar));
        }
        return arrayList;
    }

    public static final int g4(@l short[] sArr) {
        l0.p(sArr, "$this$lastIndex");
        return r.xe(sArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final s1 g5(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$lastOrNull");
        l0.p(lVar, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            byte bM = s1.m(bArr[length]);
            if (((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                return new s1(bM);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Double g6(short[] sArr, jn.l<? super g2, Double> lVar) {
        l0.p(sArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        double dDoubleValue = ((Number) qm.b.a(g2.m(sArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, ((Number) qm.b.a(g2.m(sArr[it.nextInt()]), lVar)).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R g7(int[] iArr, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        R r10 = (R) e.a(w1.m(iArr[0]), lVar);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) e.a(w1.m(iArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) > 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final long[] g8(@l long[] jArr, @l Collection<a2> collection) {
        l0.p(jArr, "$this$plus");
        l0.p(collection, "elements");
        int length = jArr.length;
        long[] jArrCopyOf = Arrays.copyOf(jArr, collection.size() + jArr.length);
        l0.o(jArrCopyOf, "copyOf(...)");
        Iterator<a2> it = collection.iterator();
        while (it.hasNext()) {
            jArrCopyOf[length] = it.next().f10177a;
            length++;
        }
        l0.p(jArrCopyOf, "storage");
        return jArrCopyOf;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final a2 g9(long[] jArr, p<? super a2, ? super a2, a2> pVar) {
        l0.p(jArr, "$this$reduceRightOrNull");
        l0.p(pVar, "operation");
        int iVe = r.ve(jArr);
        if (iVe < 0) {
            return null;
        }
        long jM = a2.m(jArr[iVe]);
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            jM = pVar.invoke(new a2(a2.m(jArr[i10])), new a2(jM)).f10177a;
        }
        return new a2(jM);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte ga(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$single");
        l0.p(lVar, "predicate");
        s1 s1Var = null;
        boolean z10 = false;
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            if (((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                s1Var = new s1(bM);
                z10 = true;
            }
        }
        if (z10) {
            return s1Var.f10218a;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<a2> gb(@l long[] jArr) {
        l0.p(jArr, "$this$sorted");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        l0.o(jArrCopyOf, "copyOf(...)");
        l0.p(jArrCopyOf, "storage");
        Sa(jArrCopyOf);
        return f.c(jArrCopyOf);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<w1> gc(@l int[] iArr, int i10) {
        l0.p(iArr, "$this$take");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= iArr.length) {
            return h0.V5(new x1(iArr));
        }
        if (i10 == 1) {
            return x.k(new w1(w1.m(iArr[0])));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (int i12 : iArr) {
            arrayList.add(new w1(w1.m(i12)));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, V> List<V> gd(short[] sArr, Iterable<? extends R> iterable, p<? super g2, ? super R, ? extends V> pVar) {
        l0.p(sArr, "$this$zip");
        l0.p(iterable, "other");
        l0.p(pVar, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(new g2(g2.m(sArr[i10])), r10));
            i10++;
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final boolean h0(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$any");
        l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            if (((Boolean) qm.b.a(g2.m(s10), lVar)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static short[] h1(short[] sArr, short[] sArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = sArr.length;
        }
        l0.p(sArr, "$this$copyInto");
        l0.p(sArr2, RtspHeaders.Values.DESTINATION);
        nm.p.C0(sArr, sArr2, i10, i11, i12);
        return sArr2;
    }

    public static void h2(byte[] bArr, byte b10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        g2(bArr, b10, i10, i11);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> h3(short[] sArr, jn.l<? super g2, ? extends Iterable<? extends R>> lVar) {
        l0.p(sArr, "$this$flatMap");
        l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            d0.r0(arrayList, (Iterable) qm.b.a(g2.m(s10), lVar));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    public static /* synthetic */ void h4(short[] sArr) {
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final a2 h5(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$lastOrNull");
        l0.p(lVar, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            long jM = a2.m(jArr[length]);
            if (((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                return new a2(jM);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Float h6(short[] sArr, jn.l<? super g2, Float> lVar) {
        l0.p(sArr, "$this$maxOfOrNull");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        float fFloatValue = ((Number) qm.b.a(g2.m(sArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, ((Number) qm.b.a(g2.m(sArr[it.nextInt()]), lVar)).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Double h7(int[] iArr, jn.l<? super w1, Double> lVar) {
        l0.p(iArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        double dDoubleValue = ((Number) e.a(w1.m(iArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) e.a(w1.m(iArr[it.nextInt()]), lVar)).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] h8(short[] sArr, short[] sArr2) {
        l0.p(sArr, "$this$plus");
        l0.p(sArr2, "elements");
        short[] sArrB3 = nm.p.B3(sArr, sArr2);
        l0.p(sArrB3, "storage");
        return sArrB3;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final g2 h9(short[] sArr, p<? super g2, ? super g2, g2> pVar) {
        l0.p(sArr, "$this$reduceRightOrNull");
        l0.p(pVar, "operation");
        int iXe = r.xe(sArr);
        if (iXe < 0) {
            return null;
        }
        short sM = g2.m(sArr[iXe]);
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sM = pVar.invoke(new g2(g2.m(sArr[i10])), new g2(sM)).f10193a;
        }
        return new g2(sM);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long ha(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$single");
        l0.p(lVar, "predicate");
        a2 a2Var = null;
        boolean z10 = false;
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            if (((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                a2Var = new a2(jM);
                z10 = true;
            }
        }
        if (z10) {
            return a2Var.f10177a;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<g2> hb(@l short[] sArr) {
        l0.p(sArr, "$this$sorted");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        l0.o(sArrCopyOf, "copyOf(...)");
        l0.p(sArrCopyOf, "storage");
        Va(sArrCopyOf);
        return f.d(sArrCopyOf);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<a2> hc(@l long[] jArr, int i10) {
        l0.p(jArr, "$this$take");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= jArr.length) {
            return h0.V5(new b2(jArr));
        }
        if (i10 == 1) {
            return x.k(new a2(a2.m(jArr[0])));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (long j10 : jArr) {
            arrayList.add(new a2(a2.m(j10)));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<lm.t0<s1, s1>> hd(@l byte[] bArr, @l byte[] bArr2) {
        l0.p(bArr, "$this$zip");
        l0.p(bArr2, "other");
        int iMin = Math.min(bArr.length, bArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(new s1(s1.m(bArr[i10])), new s1(s1.m(bArr2[i10]))));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] i0(byte[] bArr) {
        l0.p(bArr, "$this$asByteArray");
        return bArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] i1(byte[] bArr, byte[] bArr2, int i10, int i11, int i12) {
        l0.p(bArr, "$this$copyInto");
        l0.p(bArr2, RtspHeaders.Values.DESTINATION);
        nm.p.v0(bArr, bArr2, i10, i11, i12);
        return bArr2;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<s1> i2(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$filter");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            if (((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                arrayList.add(new s1(bM));
            }
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> List<R> i3(byte[] bArr, p<? super Integer, ? super s1, ? extends Iterable<? extends R>> pVar) {
        l0.p(bArr, "$this$flatMapIndexed");
        l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), new s1(s1.m(bArr[i10]))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short i4(short[] sArr, int i10, jn.l<? super Integer, g2> lVar) {
        l0.p(sArr, "$this$getOrElse");
        l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > r.xe(sArr)) ? lVar.invoke(Integer.valueOf(i10)).f10193a : g2.m(sArr[i10]);
    }

    @m
    @f1(version = "1.3")
    @t
    public static final a2 i5(@l long[] jArr) {
        l0.p(jArr, "$this$lastOrNull");
        if (b2.t(jArr)) {
            return null;
        }
        return new a2(a2.m(jArr[jArr.length - 1]));
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R i6(long[] jArr, Comparator<? super R> comparator, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$maxOfWith");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.c.a(a2.m(jArr[0]), lVar);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.c.a(a2.m(jArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) < 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Float i7(int[] iArr, jn.l<? super w1, Float> lVar) {
        l0.p(iArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        float fFloatValue = ((Number) e.a(w1.m(iArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) e.a(w1.m(iArr[it.nextInt()]), lVar)).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final short[] i8(@l short[] sArr, @l Collection<g2> collection) {
        l0.p(sArr, "$this$plus");
        l0.p(collection, "elements");
        int length = sArr.length;
        short[] sArrCopyOf = Arrays.copyOf(sArr, collection.size() + sArr.length);
        l0.o(sArrCopyOf, "copyOf(...)");
        Iterator<g2> it = collection.iterator();
        while (it.hasNext()) {
            sArrCopyOf[length] = it.next().f10193a;
            length++;
        }
        l0.p(sArrCopyOf, "storage");
        return sArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void i9(int[] iArr) {
        l0.p(iArr, "$this$reverse");
        r.Yq(iArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long ia(long[] jArr) {
        l0.p(jArr, "$this$single");
        return a2.m(r.et(jArr));
    }

    @f1(version = "1.3")
    @t
    @l
    public static final int[] ib(@l int[] iArr) {
        l0.p(iArr, "$this$sortedArray");
        if (x1.t(iArr)) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        l0.o(iArrCopyOf, "copyOf(...)");
        l0.p(iArrCopyOf, "storage");
        Ka(iArrCopyOf);
        return iArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<s1> ic(@l byte[] bArr, int i10) {
        l0.p(bArr, "$this$takeLast");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = bArr.length;
        if (i10 >= length) {
            return h0.V5(new t1(bArr));
        }
        if (i10 == 1) {
            return x.k(new s1(s1.m(bArr[length - 1])));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(new s1(s1.m(bArr[i11])));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<lm.t0<g2, g2>> id(@l short[] sArr, @l short[] sArr2) {
        l0.p(sArr, "$this$zip");
        l0.p(sArr2, "other");
        int iMin = Math.min(sArr.length, sArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(new g2(g2.m(sArr[i10])), new g2(g2.m(sArr2[i10]))));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] j0(int[] iArr) {
        l0.p(iArr, "$this$asIntArray");
        return iArr;
    }

    public static byte[] j1(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        l0.p(bArr, "$this$copyInto");
        l0.p(bArr2, RtspHeaders.Values.DESTINATION);
        nm.p.v0(bArr, bArr2, i10, i11, i12);
        return bArr2;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<a2> j2(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$filter");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            if (((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                arrayList.add(new a2(jM));
            }
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> List<R> j3(int[] iArr, p<? super Integer, ? super w1, ? extends Iterable<? extends R>> pVar) {
        l0.p(iArr, "$this$flatMapIndexed");
        l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), new w1(w1.m(iArr[i10]))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int j4(int[] iArr, int i10, jn.l<? super Integer, w1> lVar) {
        l0.p(iArr, "$this$getOrElse");
        l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > r.ue(iArr)) ? lVar.invoke(Integer.valueOf(i10)).f10227a : w1.m(iArr[i10]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final w1 j5(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$lastOrNull");
        l0.p(lVar, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            int iM = w1.m(iArr[length]);
            if (((Boolean) e.a(iM, lVar)).booleanValue()) {
                return new w1(iM);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R j6(byte[] bArr, Comparator<? super R> comparator, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$maxOfWith");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.d.a(s1.m(bArr[0]), lVar);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.d.a(s1.m(bArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) < 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R extends Comparable<? super R>> R j7(short[] sArr, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        R r10 = (R) qm.b.a(g2.m(sArr[0]), lVar);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            Comparable comparable = (Comparable) qm.b.a(g2.m(sArr[it.nextInt()]), lVar);
            if (r10.compareTo(comparable) > 0) {
                r10 = (R) comparable;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] j8(int[] iArr, int i10) {
        l0.p(iArr, "$this$plus");
        int[] iArrQ3 = nm.p.q3(iArr, i10);
        l0.p(iArrQ3, "storage");
        return iArrQ3;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final void j9(long[] jArr, int i10, int i11) {
        l0.p(jArr, "$this$reverse");
        r.br(jArr, i10, i11);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int ja(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$single");
        l0.p(lVar, "predicate");
        w1 w1Var = null;
        boolean z10 = false;
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            if (((Boolean) e.a(iM, lVar)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                w1Var = new w1(iM);
                z10 = true;
            }
        }
        if (z10) {
            return w1Var.f10227a;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @f1(version = "1.3")
    @t
    @l
    public static final byte[] jb(@l byte[] bArr) {
        l0.p(bArr, "$this$sortedArray");
        if (t1.t(bArr)) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        l0.o(bArrCopyOf, "copyOf(...)");
        l0.p(bArrCopyOf, "storage");
        Ra(bArrCopyOf);
        return bArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<g2> jc(@l short[] sArr, int i10) {
        l0.p(sArr, "$this$takeLast");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = sArr.length;
        if (i10 >= length) {
            return h0.V5(new h2(sArr));
        }
        if (i10 == 1) {
            return x.k(new g2(g2.m(sArr[length - 1])));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(new g2(g2.m(sArr[i11])));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final <R> List<lm.t0<s1, R>> jd(@l byte[] bArr, @l R[] rArr) {
        l0.p(bArr, "$this$zip");
        l0.p(rArr, "other");
        int iMin = Math.min(bArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            byte bM = s1.m(bArr[i10]);
            arrayList.add(new lm.t0(new s1(bM), rArr[i10]));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] k0(long[] jArr) {
        l0.p(jArr, "$this$asLongArray");
        return jArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] k1(int[] iArr, int[] iArr2, int i10, int i11, int i12) {
        l0.p(iArr, "$this$copyInto");
        l0.p(iArr2, RtspHeaders.Values.DESTINATION);
        nm.p.z0(iArr, iArr2, i10, i11, i12);
        return iArr2;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<w1> k2(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$filter");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            if (((Boolean) e.a(iM, lVar)).booleanValue()) {
                arrayList.add(new w1(iM));
            }
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> List<R> k3(long[] jArr, p<? super Integer, ? super a2, ? extends Iterable<? extends R>> pVar) {
        l0.p(jArr, "$this$flatMapIndexed");
        l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), new a2(a2.m(jArr[i10]))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long k4(long[] jArr, int i10, jn.l<? super Integer, a2> lVar) {
        l0.p(jArr, "$this$getOrElse");
        l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > r.ve(jArr)) ? lVar.invoke(Integer.valueOf(i10)).f10177a : a2.m(jArr[i10]);
    }

    @m
    @f1(version = "1.3")
    @t
    public static final g2 k5(@l short[] sArr) {
        l0.p(sArr, "$this$lastOrNull");
        if (h2.t(sArr)) {
            return null;
        }
        return new g2(g2.m(sArr[sArr.length - 1]));
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R k6(short[] sArr, Comparator<? super R> comparator, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$maxOfWith");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.b.a(g2.m(sArr[0]), lVar);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.b.a(g2.m(sArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) < 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Double k7(short[] sArr, jn.l<? super g2, Double> lVar) {
        l0.p(sArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        double dDoubleValue = ((Number) qm.b.a(g2.m(sArr[0]), lVar)).doubleValue();
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, ((Number) qm.b.a(g2.m(sArr[it.nextInt()]), lVar)).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] k8(long[] jArr, long[] jArr2) {
        l0.p(jArr, "$this$plus");
        l0.p(jArr2, "elements");
        long[] jArrV3 = nm.p.v3(jArr, jArr2);
        l0.p(jArrV3, "storage");
        return jArrV3;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final void k9(byte[] bArr, int i10, int i11) {
        l0.p(bArr, "$this$reverse");
        r.Rq(bArr, i10, i11);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short ka(short[] sArr) {
        l0.p(sArr, "$this$single");
        return g2.m(r.jt(sArr));
    }

    @f1(version = "1.3")
    @t
    @l
    public static final long[] kb(@l long[] jArr) {
        l0.p(jArr, "$this$sortedArray");
        if (b2.t(jArr)) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        l0.o(jArrCopyOf, "copyOf(...)");
        l0.p(jArrCopyOf, "storage");
        Sa(jArrCopyOf);
        return jArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<w1> kc(@l int[] iArr, int i10) {
        l0.p(iArr, "$this$takeLast");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = iArr.length;
        if (i10 >= length) {
            return h0.V5(new x1(iArr));
        }
        if (i10 == 1) {
            return x.k(new w1(w1.m(iArr[length - 1])));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(new w1(w1.m(iArr[i11])));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final <R> List<lm.t0<g2, R>> kd(@l short[] sArr, @l R[] rArr) {
        l0.p(sArr, "$this$zip");
        l0.p(rArr, "other");
        int iMin = Math.min(sArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            short sM = g2.m(sArr[i10]);
            arrayList.add(new lm.t0(new g2(sM), rArr[i10]));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] l0(short[] sArr) {
        l0.p(sArr, "$this$asShortArray");
        return sArr;
    }

    public static int[] l1(int[] iArr, int[] iArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = iArr.length;
        }
        l0.p(iArr, "$this$copyInto");
        l0.p(iArr2, RtspHeaders.Values.DESTINATION);
        nm.p.z0(iArr, iArr2, i10, i11, i12);
        return iArr2;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<g2> l2(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$filter");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            if (((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                arrayList.add(new g2(sM));
            }
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> List<R> l3(short[] sArr, p<? super Integer, ? super g2, ? extends Iterable<? extends R>> pVar) {
        l0.p(sArr, "$this$flatMapIndexed");
        l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), new g2(g2.m(sArr[i10]))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte l4(byte[] bArr, int i10, jn.l<? super Integer, s1> lVar) {
        l0.p(bArr, "$this$getOrElse");
        l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > r.qe(bArr)) ? lVar.invoke(Integer.valueOf(i10)).f10218a : s1.m(bArr[i10]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final g2 l5(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$lastOrNull");
        l0.p(lVar, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            short sM = g2.m(sArr[length]);
            if (((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                return new g2(sM);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R l6(int[] iArr, Comparator<? super R> comparator, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$maxOfWith");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) e.a(w1.m(iArr[0]), lVar);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) e.a(w1.m(iArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) < 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final Float l7(short[] sArr, jn.l<? super g2, Float> lVar) {
        l0.p(sArr, "$this$minOfOrNull");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        float fFloatValue = ((Number) qm.b.a(g2.m(sArr[0]), lVar)).floatValue();
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, ((Number) qm.b.a(g2.m(sArr[it.nextInt()]), lVar)).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final byte[] l8(@l byte[] bArr, @l Collection<s1> collection) {
        l0.p(bArr, "$this$plus");
        l0.p(collection, "elements");
        int length = bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, collection.size() + bArr.length);
        l0.o(bArrCopyOf, "copyOf(...)");
        Iterator<s1> it = collection.iterator();
        while (it.hasNext()) {
            bArrCopyOf[length] = it.next().f10218a;
            length++;
        }
        l0.p(bArrCopyOf, "storage");
        return bArrCopyOf;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final void l9(short[] sArr, int i10, int i11) {
        l0.p(sArr, "$this$reverse");
        r.fr(sArr, i10, i11);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short la(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$single");
        l0.p(lVar, "predicate");
        g2 g2Var = null;
        boolean z10 = false;
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            if (((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                g2Var = new g2(sM);
                z10 = true;
            }
        }
        if (z10) {
            return g2Var.f10193a;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @f1(version = "1.3")
    @t
    @l
    public static final short[] lb(@l short[] sArr) {
        l0.p(sArr, "$this$sortedArray");
        if (h2.t(sArr)) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        l0.o(sArrCopyOf, "copyOf(...)");
        l0.p(sArrCopyOf, "storage");
        Va(sArrCopyOf);
        return sArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<a2> lc(@l long[] jArr, int i10) {
        l0.p(jArr, "$this$takeLast");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = jArr.length;
        if (i10 >= length) {
            return h0.V5(new b2(jArr));
        }
        if (i10 == 1) {
            return x.k(new a2(a2.m(jArr[length - 1])));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(new a2(a2.m(jArr[i11])));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<lm.t0<a2, a2>> ld(@l long[] jArr, @l long[] jArr2) {
        l0.p(jArr, "$this$zip");
        l0.p(jArr2, "other");
        int iMin = Math.min(jArr.length, jArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(new a2(a2.m(jArr[i10])), new a2(a2.m(jArr2[i10]))));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] m0(byte[] bArr) {
        l0.p(bArr, "<this>");
        l0.p(bArr, "storage");
        return bArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] m1(int[] iArr) {
        l0.p(iArr, "$this$copyOf");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        l0.o(iArrCopyOf, "copyOf(...)");
        l0.p(iArrCopyOf, "storage");
        return iArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<s1> m2(byte[] bArr, p<? super Integer, ? super s1, Boolean> pVar) {
        l0.p(bArr, "$this$filterIndexed");
        l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte bM = s1.m(bArr[i10]);
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), new s1(bM)).booleanValue()) {
                arrayList.add(new s1(bM));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R, C extends Collection<? super R>> C m3(int[] iArr, C c10, p<? super Integer, ? super w1, ? extends Iterable<? extends R>> pVar) {
        l0.p(iArr, "$this$flatMapIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), new w1(w1.m(iArr[i10]))));
            i10++;
            i11++;
        }
        return c10;
    }

    @m
    @f1(version = "1.3")
    @t
    public static final s1 m4(@l byte[] bArr, int i10) {
        l0.p(bArr, "$this$getOrNull");
        if (i10 < 0 || i10 > r.qe(bArr)) {
            return null;
        }
        return new s1(s1.m(bArr[i10]));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> m5(byte[] bArr, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$map");
        l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b10 : bArr) {
            arrayList.add(lVar.invoke(new s1(s1.m(b10))));
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R m6(long[] jArr, Comparator<? super R> comparator, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$maxOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        R r10 = (R) qm.c.a(a2.m(jArr[0]), lVar);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.c.a(a2.m(jArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) < 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R m7(long[] jArr, Comparator<? super R> comparator, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$minOfWith");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.c.a(a2.m(jArr[0]), lVar);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.c.a(a2.m(jArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) > 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int m8(int[] iArr) {
        l0.p(iArr, "$this$random");
        return n8(iArr, rn.f.Default);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void m9(byte[] bArr) {
        l0.p(bArr, "$this$reverse");
        r.Qq(bArr);
    }

    @m
    @f1(version = "1.3")
    @t
    public static final w1 ma(@l int[] iArr) {
        l0.p(iArr, "$this$singleOrNull");
        if (iArr.length == 1) {
            return new w1(w1.m(iArr[0]));
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final int[] mb(@l int[] iArr) {
        l0.p(iArr, "$this$sortedArrayDescending");
        if (x1.t(iArr)) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        l0.o(iArrCopyOf, "copyOf(...)");
        l0.p(iArrCopyOf, "storage");
        Wa(iArrCopyOf);
        return iArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<s1> mc(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$takeLastWhile");
        l0.p(lVar, "predicate");
        for (int iQe = r.qe(bArr); -1 < iQe; iQe--) {
            if (!((Boolean) qm.d.a(s1.m(bArr[iQe]), lVar)).booleanValue()) {
                return C1(bArr, iQe + 1);
            }
        }
        return h0.V5(new t1(bArr));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] n0(int[] iArr) {
        l0.p(iArr, "<this>");
        l0.p(iArr, "storage");
        return iArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] n1(byte[] bArr) {
        l0.p(bArr, "$this$copyOf");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        l0.o(bArrCopyOf, "copyOf(...)");
        l0.p(bArrCopyOf, "storage");
        return bArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<w1> n2(int[] iArr, p<? super Integer, ? super w1, Boolean> pVar) {
        l0.p(iArr, "$this$filterIndexed");
        l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int iM = w1.m(iArr[i10]);
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), new w1(iM)).booleanValue()) {
                arrayList.add(new w1(iM));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R, C extends Collection<? super R>> C n3(short[] sArr, C c10, p<? super Integer, ? super g2, ? extends Iterable<? extends R>> pVar) {
        l0.p(sArr, "$this$flatMapIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), new g2(g2.m(sArr[i10]))));
            i10++;
            i11++;
        }
        return c10;
    }

    @m
    @f1(version = "1.3")
    @t
    public static final g2 n4(@l short[] sArr, int i10) {
        l0.p(sArr, "$this$getOrNull");
        if (i10 < 0 || i10 > r.xe(sArr)) {
            return null;
        }
        return new g2(g2.m(sArr[i10]));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> n5(long[] jArr, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$map");
        l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            arrayList.add(lVar.invoke(new a2(a2.m(j10))));
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R n6(byte[] bArr, Comparator<? super R> comparator, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$maxOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        R r10 = (R) qm.d.a(s1.m(bArr[0]), lVar);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.d.a(s1.m(bArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) < 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R n7(byte[] bArr, Comparator<? super R> comparator, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$minOfWith");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.d.a(s1.m(bArr[0]), lVar);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.d.a(s1.m(bArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) > 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    public static final int n8(@l int[] iArr, @l rn.f fVar) {
        l0.p(iArr, "$this$random");
        l0.p(fVar, "random");
        if (x1.t(iArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return w1.m(iArr[fVar.nextInt(iArr.length)]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void n9(long[] jArr) {
        l0.p(jArr, "$this$reverse");
        r.ar(jArr);
    }

    @m
    @f1(version = "1.3")
    @t
    public static final s1 na(@l byte[] bArr) {
        l0.p(bArr, "$this$singleOrNull");
        if (bArr.length == 1) {
            return new s1(s1.m(bArr[0]));
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final byte[] nb(@l byte[] bArr) {
        l0.p(bArr, "$this$sortedArrayDescending");
        if (t1.t(bArr)) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        l0.o(bArrCopyOf, "copyOf(...)");
        l0.p(bArrCopyOf, "storage");
        ab(bArrCopyOf);
        return bArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<a2> nc(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$takeLastWhile");
        l0.p(lVar, "predicate");
        for (int iVe = r.ve(jArr); -1 < iVe; iVe--) {
            if (!((Boolean) qm.c.a(a2.m(jArr[iVe]), lVar)).booleanValue()) {
                return F1(jArr, iVe + 1);
            }
        }
        return h0.V5(new b2(jArr));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] o0(long[] jArr) {
        l0.p(jArr, "<this>");
        l0.p(jArr, "storage");
        return jArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] o1(byte[] bArr, int i10) {
        l0.p(bArr, "$this$copyOf");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i10);
        l0.o(bArrCopyOf, "copyOf(...)");
        l0.p(bArrCopyOf, "storage");
        return bArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<a2> o2(long[] jArr, p<? super Integer, ? super a2, Boolean> pVar) {
        l0.p(jArr, "$this$filterIndexed");
        l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            long jM = a2.m(jArr[i10]);
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), new a2(jM)).booleanValue()) {
                arrayList.add(new a2(jM));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R, C extends Collection<? super R>> C o3(byte[] bArr, C c10, p<? super Integer, ? super s1, ? extends Iterable<? extends R>> pVar) {
        l0.p(bArr, "$this$flatMapIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), new s1(s1.m(bArr[i10]))));
            i10++;
            i11++;
        }
        return c10;
    }

    @m
    @f1(version = "1.3")
    @t
    public static final w1 o4(@l int[] iArr, int i10) {
        l0.p(iArr, "$this$getOrNull");
        if (i10 < 0 || i10 > r.ue(iArr)) {
            return null;
        }
        return new w1(w1.m(iArr[i10]));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> o5(int[] iArr, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$map");
        l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(lVar.invoke(new w1(w1.m(i10))));
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R o6(short[] sArr, Comparator<? super R> comparator, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$maxOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        R r10 = (R) qm.b.a(g2.m(sArr[0]), lVar);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.b.a(g2.m(sArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) < 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R o7(short[] sArr, Comparator<? super R> comparator, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$minOfWith");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) qm.b.a(g2.m(sArr[0]), lVar);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.b.a(g2.m(sArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) > 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte o8(byte[] bArr) {
        l0.p(bArr, "$this$random");
        return r8(bArr, rn.f.Default);
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final void o9(int[] iArr, int i10, int i11) {
        l0.p(iArr, "$this$reverse");
        r.Zq(iArr, i10, i11);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final s1 oa(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$singleOrNull");
        l0.p(lVar, "predicate");
        s1 s1Var = null;
        boolean z10 = false;
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            if (((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                if (z10) {
                    return null;
                }
                s1Var = new s1(bM);
                z10 = true;
            }
        }
        if (z10) {
            return s1Var;
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final long[] ob(@l long[] jArr) {
        l0.p(jArr, "$this$sortedArrayDescending");
        if (b2.t(jArr)) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        l0.o(jArrCopyOf, "copyOf(...)");
        l0.p(jArrCopyOf, "storage");
        bb(jArrCopyOf);
        return jArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<w1> oc(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$takeLastWhile");
        l0.p(lVar, "predicate");
        for (int iUe = r.ue(iArr); -1 < iUe; iUe--) {
            if (!((Boolean) e.a(w1.m(iArr[iUe]), lVar)).booleanValue()) {
                return E1(iArr, iUe + 1);
            }
        }
        return h0.V5(new x1(iArr));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] p0(short[] sArr) {
        l0.p(sArr, "<this>");
        l0.p(sArr, "storage");
        return sArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] p1(long[] jArr) {
        l0.p(jArr, "$this$copyOf");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        l0.o(jArrCopyOf, "copyOf(...)");
        l0.p(jArrCopyOf, "storage");
        return jArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<g2> p2(short[] sArr, p<? super Integer, ? super g2, Boolean> pVar) {
        l0.p(sArr, "$this$filterIndexed");
        l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            short sM = g2.m(sArr[i10]);
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), new g2(sM)).booleanValue()) {
                arrayList.add(new g2(sM));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R, C extends Collection<? super R>> C p3(long[] jArr, C c10, p<? super Integer, ? super a2, ? extends Iterable<? extends R>> pVar) {
        l0.p(jArr, "$this$flatMapIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), new a2(a2.m(jArr[i10]))));
            i10++;
            i11++;
        }
        return c10;
    }

    @m
    @f1(version = "1.3")
    @t
    public static final a2 p4(@l long[] jArr, int i10) {
        l0.p(jArr, "$this$getOrNull");
        if (i10 < 0 || i10 > r.ve(jArr)) {
            return null;
        }
        return new a2(a2.m(jArr[i10]));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> p5(short[] sArr, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$map");
        l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s10 : sArr) {
            arrayList.add(lVar.invoke(new g2(g2.m(s10))));
        }
        return arrayList;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R p6(int[] iArr, Comparator<? super R> comparator, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$maxOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        R r10 = (R) e.a(w1.m(iArr[0]), lVar);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) e.a(w1.m(iArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) < 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R p7(int[] iArr, Comparator<? super R> comparator, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$minOfWith");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        R r10 = (R) e.a(w1.m(iArr[0]), lVar);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) e.a(w1.m(iArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) > 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    public static final long p8(@l long[] jArr, @l rn.f fVar) {
        l0.p(jArr, "$this$random");
        l0.p(fVar, "random");
        if (b2.t(jArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return a2.m(jArr[fVar.nextInt(jArr.length)]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final void p9(short[] sArr) {
        l0.p(sArr, "$this$reverse");
        r.er(sArr);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final a2 pa(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$singleOrNull");
        l0.p(lVar, "predicate");
        a2 a2Var = null;
        boolean z10 = false;
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            if (((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                if (z10) {
                    return null;
                }
                a2Var = new a2(jM);
                z10 = true;
            }
        }
        if (z10) {
            return a2Var;
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final short[] pb(@l short[] sArr) {
        l0.p(sArr, "$this$sortedArrayDescending");
        if (h2.t(sArr)) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        l0.o(sArrCopyOf, "copyOf(...)");
        l0.p(sArrCopyOf, "storage");
        db(sArrCopyOf);
        return sArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<g2> pc(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$takeLastWhile");
        l0.p(lVar, "predicate");
        for (int iXe = r.xe(sArr); -1 < iXe; iXe--) {
            if (!((Boolean) qm.b.a(g2.m(sArr[iXe]), lVar)).booleanValue()) {
                return D1(sArr, iXe + 1);
            }
        }
        return h0.V5(new h2(sArr));
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <V> Map<s1, V> q0(byte[] bArr, jn.l<? super s1, ? extends V> lVar) {
        l0.p(bArr, "$this$associateWith");
        l0.p(lVar, "valueSelector");
        int iJ = c1.j(bArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            linkedHashMap.put(new s1(bM), lVar.invoke(new s1(bM)));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] q1(short[] sArr, int i10) {
        l0.p(sArr, "$this$copyOf");
        short[] sArrCopyOf = Arrays.copyOf(sArr, i10);
        l0.o(sArrCopyOf, "copyOf(...)");
        l0.p(sArrCopyOf, "storage");
        return sArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super w1>> C q2(int[] iArr, C c10, p<? super Integer, ? super w1, Boolean> pVar) {
        l0.p(iArr, "$this$filterIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "predicate");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int iM = w1.m(iArr[i10]);
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), new w1(iM)).booleanValue()) {
                c10.add(new w1(iM));
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C q3(long[] jArr, C c10, jn.l<? super a2, ? extends Iterable<? extends R>> lVar) {
        l0.p(jArr, "$this$flatMapTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        for (long j10 : jArr) {
            d0.r0(c10, (Iterable) qm.c.a(a2.m(j10), lVar));
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, V> Map<K, List<V>> q4(long[] jArr, jn.l<? super a2, ? extends K> lVar, jn.l<? super a2, ? extends V> lVar2) {
        l0.p(jArr, "$this$groupBy");
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            Object objA = qm.c.a(jM, lVar);
            Object objA2 = linkedHashMap.get(objA);
            if (objA2 == null) {
                objA2 = v.a(linkedHashMap, objA);
            }
            ((List) objA2).add(lVar2.invoke(new a2(jM)));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> q5(byte[] bArr, p<? super Integer, ? super s1, ? extends R> pVar) {
        l0.p(bArr, "$this$mapIndexed");
        l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), new s1(s1.m(bArr[i10]))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final w1 q6(@l int[] iArr) {
        l0.p(iArr, "$this$maxOrNull");
        if (x1.t(iArr)) {
            return null;
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iM2 = w1.m(iArr[it.nextInt()]);
            if (Integer.compareUnsigned(iM, iM2) < 0) {
                iM = iM2;
            }
        }
        return new w1(iM);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R q7(long[] jArr, Comparator<? super R> comparator, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$minOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (b2.t(jArr)) {
            return null;
        }
        R r10 = (R) qm.c.a(a2.m(jArr[0]), lVar);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.c.a(a2.m(jArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) > 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long q8(long[] jArr) {
        l0.p(jArr, "$this$random");
        return p8(jArr, rn.f.Default);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<w1> q9(@l int[] iArr) {
        l0.p(iArr, "$this$reversed");
        if (x1.t(iArr)) {
            return k0.INSTANCE;
        }
        List<w1> listY5 = h0.Y5(new x1(iArr));
        g0.r1(listY5);
        return listY5;
    }

    @m
    @f1(version = "1.3")
    @t
    public static final a2 qa(@l long[] jArr) {
        l0.p(jArr, "$this$singleOrNull");
        if (jArr.length == 1) {
            return new a2(a2.m(jArr[0]));
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<w1> qb(@l int[] iArr) {
        l0.p(iArr, "$this$sortedDescending");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        l0.o(iArrCopyOf, "copyOf(...)");
        l0.p(iArrCopyOf, "storage");
        Ka(iArrCopyOf);
        return q9(iArrCopyOf);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<s1> qc(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$takeWhile");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            if (!((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                break;
            }
            arrayList.add(new s1(bM));
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <V> Map<a2, V> r0(long[] jArr, jn.l<? super a2, ? extends V> lVar) {
        l0.p(jArr, "$this$associateWith");
        l0.p(lVar, "valueSelector");
        int iJ = c1.j(jArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            linkedHashMap.put(new a2(jM), lVar.invoke(new a2(jM)));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] r1(int[] iArr, int i10) {
        l0.p(iArr, "$this$copyOf");
        int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
        l0.o(iArrCopyOf, "copyOf(...)");
        l0.p(iArrCopyOf, "storage");
        return iArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super g2>> C r2(short[] sArr, C c10, p<? super Integer, ? super g2, Boolean> pVar) {
        l0.p(sArr, "$this$filterIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "predicate");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            short sM = g2.m(sArr[i10]);
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), new g2(sM)).booleanValue()) {
                c10.add(new g2(sM));
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C r3(short[] sArr, C c10, jn.l<? super g2, ? extends Iterable<? extends R>> lVar) {
        l0.p(sArr, "$this$flatMapTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        for (short s10 : sArr) {
            d0.r0(c10, (Iterable) qm.b.a(g2.m(s10), lVar));
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, V> Map<K, List<V>> r4(short[] sArr, jn.l<? super g2, ? extends K> lVar, jn.l<? super g2, ? extends V> lVar2) {
        l0.p(sArr, "$this$groupBy");
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            Object objA = qm.b.a(sM, lVar);
            Object objA2 = linkedHashMap.get(objA);
            if (objA2 == null) {
                objA2 = v.a(linkedHashMap, objA);
            }
            ((List) objA2).add(lVar2.invoke(new g2(sM)));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> r5(int[] iArr, p<? super Integer, ? super w1, ? extends R> pVar) {
        l0.p(iArr, "$this$mapIndexed");
        l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), new w1(w1.m(iArr[i10]))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final s1 r6(@l byte[] bArr) {
        l0.p(bArr, "$this$maxOrNull");
        if (t1.t(bArr)) {
            return null;
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte bM2 = s1.m(bArr[it.nextInt()]);
            if (l0.t(bM & 255, bM2 & 255) < 0) {
                bM = bM2;
            }
        }
        return new s1(bM);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R r7(byte[] bArr, Comparator<? super R> comparator, jn.l<? super s1, ? extends R> lVar) {
        l0.p(bArr, "$this$minOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (t1.t(bArr)) {
            return null;
        }
        R r10 = (R) qm.d.a(s1.m(bArr[0]), lVar);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.d.a(s1.m(bArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) > 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    public static final byte r8(@l byte[] bArr, @l rn.f fVar) {
        l0.p(bArr, "$this$random");
        l0.p(fVar, "random");
        if (t1.t(bArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return s1.m(bArr[fVar.nextInt(bArr.length)]);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<s1> r9(@l byte[] bArr) {
        l0.p(bArr, "$this$reversed");
        if (t1.t(bArr)) {
            return k0.INSTANCE;
        }
        List<s1> listY5 = h0.Y5(new t1(bArr));
        g0.r1(listY5);
        return listY5;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final w1 ra(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$singleOrNull");
        l0.p(lVar, "predicate");
        w1 w1Var = null;
        boolean z10 = false;
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            if (((Boolean) e.a(iM, lVar)).booleanValue()) {
                if (z10) {
                    return null;
                }
                w1Var = new w1(iM);
                z10 = true;
            }
        }
        if (z10) {
            return w1Var;
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<s1> rb(@l byte[] bArr) {
        l0.p(bArr, "$this$sortedDescending");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        l0.o(bArrCopyOf, "copyOf(...)");
        l0.p(bArrCopyOf, "storage");
        Ra(bArrCopyOf);
        return r9(bArrCopyOf);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<a2> rc(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$takeWhile");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            if (!((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                break;
            }
            arrayList.add(new a2(jM));
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <V> Map<w1, V> s0(int[] iArr, jn.l<? super w1, ? extends V> lVar) {
        l0.p(iArr, "$this$associateWith");
        l0.p(lVar, "valueSelector");
        int iJ = c1.j(iArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            linkedHashMap.put(new w1(iM), lVar.invoke(new w1(iM)));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] s1(long[] jArr, int i10) {
        l0.p(jArr, "$this$copyOf");
        long[] jArrCopyOf = Arrays.copyOf(jArr, i10);
        l0.o(jArrCopyOf, "copyOf(...)");
        l0.p(jArrCopyOf, "storage");
        return jArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super s1>> C s2(byte[] bArr, C c10, p<? super Integer, ? super s1, Boolean> pVar) {
        l0.p(bArr, "$this$filterIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "predicate");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte bM = s1.m(bArr[i10]);
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), new s1(bM)).booleanValue()) {
                c10.add(new s1(bM));
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C s3(int[] iArr, C c10, jn.l<? super w1, ? extends Iterable<? extends R>> lVar) {
        l0.p(iArr, "$this$flatMapTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        for (int i10 : iArr) {
            d0.r0(c10, (Iterable) e.a(w1.m(i10), lVar));
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K> Map<K, List<s1>> s4(byte[] bArr, jn.l<? super s1, ? extends K> lVar) {
        l0.p(bArr, "$this$groupBy");
        l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            Object objA = qm.d.a(bM, lVar);
            Object objA2 = linkedHashMap.get(objA);
            if (objA2 == null) {
                objA2 = v.a(linkedHashMap, objA);
            }
            ((List) objA2).add(new s1(bM));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> s5(long[] jArr, p<? super Integer, ? super a2, ? extends R> pVar) {
        l0.p(jArr, "$this$mapIndexed");
        l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), new a2(a2.m(jArr[i10]))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final a2 s6(@l long[] jArr) {
        l0.p(jArr, "$this$maxOrNull");
        if (b2.t(jArr)) {
            return null;
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long jM2 = a2.m(jArr[it.nextInt()]);
            if (Long.compareUnsigned(jM, jM2) < 0) {
                jM = jM2;
            }
        }
        return new a2(jM);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R s7(short[] sArr, Comparator<? super R> comparator, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$minOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (h2.t(sArr)) {
            return null;
        }
        R r10 = (R) qm.b.a(g2.m(sArr[0]), lVar);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) qm.b.a(g2.m(sArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) > 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short s8(short[] sArr) {
        l0.p(sArr, "$this$random");
        return t8(sArr, rn.f.Default);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<a2> s9(@l long[] jArr) {
        l0.p(jArr, "$this$reversed");
        if (b2.t(jArr)) {
            return k0.INSTANCE;
        }
        List<a2> listY5 = h0.Y5(new b2(jArr));
        g0.r1(listY5);
        return listY5;
    }

    @m
    @f1(version = "1.3")
    @t
    public static final g2 sa(@l short[] sArr) {
        l0.p(sArr, "$this$singleOrNull");
        if (sArr.length == 1) {
            return new g2(g2.m(sArr[0]));
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<a2> sb(@l long[] jArr) {
        l0.p(jArr, "$this$sortedDescending");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        l0.o(jArrCopyOf, "copyOf(...)");
        l0.p(jArrCopyOf, "storage");
        Sa(jArrCopyOf);
        return s9(jArrCopyOf);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<w1> sc(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$takeWhile");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            if (!((Boolean) e.a(iM, lVar)).booleanValue()) {
                break;
            }
            arrayList.add(new w1(iM));
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <V> Map<g2, V> t0(short[] sArr, jn.l<? super g2, ? extends V> lVar) {
        l0.p(sArr, "$this$associateWith");
        l0.p(lVar, "valueSelector");
        int iJ = c1.j(sArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            linkedHashMap.put(new g2(sM), lVar.invoke(new g2(sM)));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] t1(short[] sArr) {
        l0.p(sArr, "$this$copyOf");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        l0.o(sArrCopyOf, "copyOf(...)");
        l0.p(sArrCopyOf, "storage");
        return sArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super a2>> C t2(long[] jArr, C c10, p<? super Integer, ? super a2, Boolean> pVar) {
        l0.p(jArr, "$this$filterIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "predicate");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            long jM = a2.m(jArr[i10]);
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), new a2(jM)).booleanValue()) {
                c10.add(new a2(jM));
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C t3(byte[] bArr, C c10, jn.l<? super s1, ? extends Iterable<? extends R>> lVar) {
        l0.p(bArr, "$this$flatMapTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        for (byte b10 : bArr) {
            d0.r0(c10, (Iterable) qm.d.a(s1.m(b10), lVar));
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, V> Map<K, List<V>> t4(int[] iArr, jn.l<? super w1, ? extends K> lVar, jn.l<? super w1, ? extends V> lVar2) {
        l0.p(iArr, "$this$groupBy");
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            Object objA = e.a(iM, lVar);
            Object objA2 = linkedHashMap.get(objA);
            if (objA2 == null) {
                objA2 = v.a(linkedHashMap, objA);
            }
            ((List) objA2).add(lVar2.invoke(new w1(iM)));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> List<R> t5(short[] sArr, p<? super Integer, ? super g2, ? extends R> pVar) {
        l0.p(sArr, "$this$mapIndexed");
        l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), new g2(g2.m(sArr[i10]))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final g2 t6(@l short[] sArr) {
        l0.p(sArr, "$this$maxOrNull");
        if (h2.t(sArr)) {
            return null;
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short sM2 = g2.m(sArr[it.nextInt()]);
            if (l0.t(sM & g2.f10190d, 65535 & sM2) < 0) {
                sM = sM2;
            }
        }
        return new g2(sM);
    }

    @s0
    @an.f
    @f1(version = "1.4")
    @t
    public static final <R> R t7(int[] iArr, Comparator<? super R> comparator, jn.l<? super w1, ? extends R> lVar) {
        l0.p(iArr, "$this$minOfWithOrNull");
        l0.p(comparator, "comparator");
        l0.p(lVar, "selector");
        if (x1.t(iArr)) {
            return null;
        }
        R r10 = (R) e.a(w1.m(iArr[0]), lVar);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            Object obj = (Object) e.a(w1.m(iArr[it.nextInt()]), lVar);
            if (comparator.compare(r10, obj) > 0) {
                r10 = (R) obj;
            }
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    public static final short t8(@l short[] sArr, @l rn.f fVar) {
        l0.p(sArr, "$this$random");
        l0.p(fVar, "random");
        if (h2.t(sArr)) {
            throw new NoSuchElementException("Array is empty.");
        }
        return g2.m(sArr[fVar.nextInt(sArr.length)]);
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<g2> t9(@l short[] sArr) {
        l0.p(sArr, "$this$reversed");
        if (h2.t(sArr)) {
            return k0.INSTANCE;
        }
        List<g2> listY5 = h0.Y5(new h2(sArr));
        g0.r1(listY5);
        return listY5;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final g2 ta(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$singleOrNull");
        l0.p(lVar, "predicate");
        g2 g2Var = null;
        boolean z10 = false;
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            if (((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                if (z10) {
                    return null;
                }
                g2Var = new g2(sM);
                z10 = true;
            }
        }
        if (z10) {
            return g2Var;
        }
        return null;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<g2> tb(@l short[] sArr) {
        l0.p(sArr, "$this$sortedDescending");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        l0.o(sArrCopyOf, "copyOf(...)");
        l0.p(sArrCopyOf, "storage");
        Va(sArrCopyOf);
        return t9(sArrCopyOf);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<g2> tc(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$takeWhile");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            if (!((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                break;
            }
            arrayList.add(new g2(sM));
        }
        return arrayList;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <V, M extends Map<? super w1, ? super V>> M u0(int[] iArr, M m10, jn.l<? super w1, ? extends V> lVar) {
        l0.p(iArr, "$this$associateWithTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "valueSelector");
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            m10.put(new w1(iM), lVar.invoke(new w1(iM)));
        }
        return m10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] u1(long[] jArr, int i10, int i11) {
        long[] jArrCopyOfRange;
        l0.p(jArr, "$this$copyOfRange");
        if (an.m.a(1, 3, 0)) {
            jArrCopyOfRange = nm.p.k1(jArr, i10, i11);
        } else {
            if (i11 > jArr.length) {
                StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
                sbA.append(jArr.length);
                throw new IndexOutOfBoundsException(sbA.toString());
            }
            jArrCopyOfRange = Arrays.copyOfRange(jArr, i10, i11);
            l0.m(jArrCopyOfRange);
        }
        l0.p(jArrCopyOfRange, "storage");
        return jArrCopyOfRange;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<s1> u2(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$filterNot");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            if (!((Boolean) qm.d.a(bM, lVar)).booleanValue()) {
                arrayList.add(new s1(bM));
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R u3(long[] jArr, R r10, p<? super R, ? super a2, ? extends R> pVar) {
        l0.p(jArr, "$this$fold");
        l0.p(pVar, "operation");
        for (long j10 : jArr) {
            r10 = pVar.invoke(r10, new a2(a2.m(j10)));
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K> Map<K, List<a2>> u4(long[] jArr, jn.l<? super a2, ? extends K> lVar) {
        l0.p(jArr, "$this$groupBy");
        l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            Object objA = qm.c.a(jM, lVar);
            Object objA2 = linkedHashMap.get(objA);
            if (objA2 == null) {
                objA2 = v.a(linkedHashMap, objA);
            }
            ((List) objA2).add(new a2(jM));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C u5(int[] iArr, C c10, p<? super Integer, ? super w1, ? extends R> pVar) {
        l0.p(iArr, "$this$mapIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), new w1(w1.m(iArr[i10]))));
            i10++;
            i11++;
        }
        return c10;
    }

    @f1(version = "1.7")
    @t
    @i(name = "maxOrThrow-U")
    public static final byte u6(@l byte[] bArr) {
        l0.p(bArr, "$this$max");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte bM2 = s1.m(bArr[it.nextInt()]);
            if (l0.t(bM & 255, bM2 & 255) < 0) {
                bM = bM2;
            }
        }
        return bM;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final w1 u7(@l int[] iArr) {
        l0.p(iArr, "$this$minOrNull");
        if (x1.t(iArr)) {
            return null;
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iM2 = w1.m(iArr[it.nextInt()]);
            if (Integer.compareUnsigned(iM, iM2) > 0) {
                iM = iM2;
            }
        }
        return new w1(iM);
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final w1 u8(int[] iArr) {
        l0.p(iArr, "$this$randomOrNull");
        return v8(iArr, rn.f.Default);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] u9(int[] iArr) {
        l0.p(iArr, "$this$reversedArray");
        int[] iArrVr = r.vr(iArr);
        l0.p(iArrVr, "storage");
        return iArrVr;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<a2> ua(@l long[] jArr, @l Iterable<Integer> iterable) {
        l0.p(jArr, "$this$slice");
        l0.p(iterable, "indices");
        int iB0 = z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(new a2(a2.m(jArr[it.next().intValue()])));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int ub(int[] iArr) {
        l0.p(iArr, "$this$sum");
        return w1.m(r.bw(iArr));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] uc(byte[] bArr) {
        l0.p(bArr, "$this$toByteArray");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        l0.o(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <V, M extends Map<? super s1, ? super V>> M v0(byte[] bArr, M m10, jn.l<? super s1, ? extends V> lVar) {
        l0.p(bArr, "$this$associateWithTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "valueSelector");
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            m10.put(new s1(bM), lVar.invoke(new s1(bM)));
        }
        return m10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] v1(byte[] bArr, int i10, int i11) {
        byte[] bArrCopyOfRange;
        l0.p(bArr, "$this$copyOfRange");
        if (an.m.a(1, 3, 0)) {
            bArrCopyOfRange = nm.p.f1(bArr, i10, i11);
        } else {
            if (i11 > bArr.length) {
                StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
                sbA.append(bArr.length);
                throw new IndexOutOfBoundsException(sbA.toString());
            }
            bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
            l0.m(bArrCopyOfRange);
        }
        l0.p(bArrCopyOfRange, "storage");
        return bArrCopyOfRange;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<a2> v2(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$filterNot");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            if (!((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                arrayList.add(new a2(jM));
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R v3(byte[] bArr, R r10, p<? super R, ? super s1, ? extends R> pVar) {
        l0.p(bArr, "$this$fold");
        l0.p(pVar, "operation");
        for (byte b10 : bArr) {
            r10 = pVar.invoke(r10, new s1(s1.m(b10)));
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, V> Map<K, List<V>> v4(byte[] bArr, jn.l<? super s1, ? extends K> lVar, jn.l<? super s1, ? extends V> lVar2) {
        l0.p(bArr, "$this$groupBy");
        l0.p(lVar, "keySelector");
        l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            Object objA = qm.d.a(bM, lVar);
            Object objA2 = linkedHashMap.get(objA);
            if (objA2 == null) {
                objA2 = v.a(linkedHashMap, objA);
            }
            ((List) objA2).add(lVar2.invoke(new s1(bM)));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C v5(short[] sArr, C c10, p<? super Integer, ? super g2, ? extends R> pVar) {
        l0.p(sArr, "$this$mapIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), new g2(g2.m(sArr[i10]))));
            i10++;
            i11++;
        }
        return c10;
    }

    @f1(version = "1.7")
    @t
    @i(name = "maxOrThrow-U")
    public static final int v6(@l int[] iArr) {
        l0.p(iArr, "$this$max");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iM2 = w1.m(iArr[it.nextInt()]);
            if (Integer.compareUnsigned(iM, iM2) < 0) {
                iM = iM2;
            }
        }
        return iM;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final s1 v7(@l byte[] bArr) {
        l0.p(bArr, "$this$minOrNull");
        if (t1.t(bArr)) {
            return null;
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte bM2 = s1.m(bArr[it.nextInt()]);
            if (l0.t(bM & 255, bM2 & 255) > 0) {
                bM = bM2;
            }
        }
        return new s1(bM);
    }

    @p2(markerClass = {lm.r.class})
    @m
    @f1(version = "1.4")
    @t
    public static final w1 v8(@l int[] iArr, @l rn.f fVar) {
        l0.p(iArr, "$this$randomOrNull");
        l0.p(fVar, "random");
        if (x1.t(iArr)) {
            return null;
        }
        return new w1(w1.m(iArr[fVar.nextInt(iArr.length)]));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte[] v9(byte[] bArr) {
        l0.p(bArr, "$this$reversedArray");
        byte[] bArrRr = r.rr(bArr);
        l0.p(bArrRr, "storage");
        return bArrRr;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<w1> va(@l int[] iArr, @l Iterable<Integer> iterable) {
        l0.p(iArr, "$this$slice");
        l0.p(iterable, "indices");
        int iB0 = z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(new w1(w1.m(iArr[it.next().intValue()])));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int vb(byte[] bArr) {
        l0.p(bArr, "$this$sum");
        int iM = w1.m(0);
        for (byte b10 : bArr) {
            iM += s1.m(b10) & 255;
        }
        return iM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] vc(int[] iArr) {
        l0.p(iArr, "$this$toIntArray");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        l0.o(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <V, M extends Map<? super a2, ? super V>> M w0(long[] jArr, M m10, jn.l<? super a2, ? extends V> lVar) {
        l0.p(jArr, "$this$associateWithTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "valueSelector");
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            m10.put(new a2(jM), lVar.invoke(new a2(jM)));
        }
        return m10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] w1(short[] sArr, int i10, int i11) {
        short[] sArrCopyOfRange;
        l0.p(sArr, "$this$copyOfRange");
        if (an.m.a(1, 3, 0)) {
            sArrCopyOfRange = nm.p.m1(sArr, i10, i11);
        } else {
            if (i11 > sArr.length) {
                StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
                sbA.append(sArr.length);
                throw new IndexOutOfBoundsException(sbA.toString());
            }
            sArrCopyOfRange = Arrays.copyOfRange(sArr, i10, i11);
            l0.m(sArrCopyOfRange);
        }
        l0.p(sArrCopyOfRange, "storage");
        return sArrCopyOfRange;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<w1> w2(int[] iArr, jn.l<? super w1, Boolean> lVar) {
        l0.p(iArr, "$this$filterNot");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            if (!((Boolean) e.a(iM, lVar)).booleanValue()) {
                arrayList.add(new w1(iM));
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R w3(int[] iArr, R r10, p<? super R, ? super w1, ? extends R> pVar) {
        l0.p(iArr, "$this$fold");
        l0.p(pVar, "operation");
        for (int i10 : iArr) {
            r10 = pVar.invoke(r10, new w1(w1.m(i10)));
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K> Map<K, List<w1>> w4(int[] iArr, jn.l<? super w1, ? extends K> lVar) {
        l0.p(iArr, "$this$groupBy");
        l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            Object objA = e.a(iM, lVar);
            Object objA2 = linkedHashMap.get(objA);
            if (objA2 == null) {
                objA2 = v.a(linkedHashMap, objA);
            }
            ((List) objA2).add(new w1(iM));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C w5(byte[] bArr, C c10, p<? super Integer, ? super s1, ? extends R> pVar) {
        l0.p(bArr, "$this$mapIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), new s1(s1.m(bArr[i10]))));
            i10++;
            i11++;
        }
        return c10;
    }

    @f1(version = "1.7")
    @t
    @i(name = "maxOrThrow-U")
    public static final long w6(@l long[] jArr) {
        l0.p(jArr, "$this$max");
        if (b2.t(jArr)) {
            throw new NoSuchElementException();
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long jM2 = a2.m(jArr[it.nextInt()]);
            if (Long.compareUnsigned(jM, jM2) < 0) {
                jM = jM2;
            }
        }
        return jM;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final a2 w7(@l long[] jArr) {
        l0.p(jArr, "$this$minOrNull");
        if (b2.t(jArr)) {
            return null;
        }
        long jM = a2.m(jArr[0]);
        v0 it = new tn.l(1, r.ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long jM2 = a2.m(jArr[it.nextInt()]);
            if (Long.compareUnsigned(jM, jM2) > 0) {
                jM = jM2;
            }
        }
        return new a2(jM);
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final s1 w8(byte[] bArr) {
        l0.p(bArr, "$this$randomOrNull");
        return z8(bArr, rn.f.Default);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] w9(long[] jArr) {
        l0.p(jArr, "$this$reversedArray");
        long[] jArrWr = r.wr(jArr);
        l0.p(jArrWr, "storage");
        return jArrWr;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<g2> wa(@l short[] sArr, @l Iterable<Integer> iterable) {
        l0.p(sArr, "$this$slice");
        l0.p(iterable, "indices");
        int iB0 = z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(new g2(g2.m(sArr[it.next().intValue()])));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long wb(long[] jArr) {
        l0.p(jArr, "$this$sum");
        return a2.m(r.dw(jArr));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final long[] wc(long[] jArr) {
        l0.p(jArr, "$this$toLongArray");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        l0.o(jArrCopyOf, "copyOf(...)");
        return jArrCopyOf;
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <V, M extends Map<? super g2, ? super V>> M x0(short[] sArr, M m10, jn.l<? super g2, ? extends V> lVar) {
        l0.p(sArr, "$this$associateWithTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "valueSelector");
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            m10.put(new g2(sM), lVar.invoke(new g2(sM)));
        }
        return m10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int[] x1(int[] iArr, int i10, int i11) {
        int[] iArrCopyOfRange;
        l0.p(iArr, "$this$copyOfRange");
        if (an.m.a(1, 3, 0)) {
            iArrCopyOfRange = nm.p.j1(iArr, i10, i11);
        } else {
            if (i11 > iArr.length) {
                StringBuilder sbA = h.b.a("toIndex: ", i11, ", size: ");
                sbA.append(iArr.length);
                throw new IndexOutOfBoundsException(sbA.toString());
            }
            iArrCopyOfRange = Arrays.copyOfRange(iArr, i10, i11);
            l0.m(iArrCopyOfRange);
        }
        l0.p(iArrCopyOfRange, "storage");
        return iArrCopyOfRange;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final List<g2> x2(short[] sArr, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$filterNot");
        l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            if (!((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                arrayList.add(new g2(sM));
            }
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R x3(short[] sArr, R r10, p<? super R, ? super g2, ? extends R> pVar) {
        l0.p(sArr, "$this$fold");
        l0.p(pVar, "operation");
        for (short s10 : sArr) {
            r10 = pVar.invoke(r10, new g2(g2.m(s10)));
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K> Map<K, List<g2>> x4(short[] sArr, jn.l<? super g2, ? extends K> lVar) {
        l0.p(sArr, "$this$groupBy");
        l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            Object objA = qm.b.a(sM, lVar);
            Object objA2 = linkedHashMap.get(objA);
            if (objA2 == null) {
                objA2 = v.a(linkedHashMap, objA);
            }
            ((List) objA2).add(new g2(sM));
        }
        return linkedHashMap;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C x5(long[] jArr, C c10, p<? super Integer, ? super a2, ? extends R> pVar) {
        l0.p(jArr, "$this$mapIndexedTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(pVar, "transform");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), new a2(a2.m(jArr[i10]))));
            i10++;
            i11++;
        }
        return c10;
    }

    @f1(version = "1.7")
    @t
    @i(name = "maxOrThrow-U")
    public static final short x6(@l short[] sArr) {
        l0.p(sArr, "$this$max");
        if (h2.t(sArr)) {
            throw new NoSuchElementException();
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short sM2 = g2.m(sArr[it.nextInt()]);
            if (l0.t(sM & g2.f10190d, 65535 & sM2) < 0) {
                sM = sM2;
            }
        }
        return sM;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final g2 x7(@l short[] sArr) {
        l0.p(sArr, "$this$minOrNull");
        if (h2.t(sArr)) {
            return null;
        }
        short sM = g2.m(sArr[0]);
        v0 it = new tn.l(1, r.xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short sM2 = g2.m(sArr[it.nextInt()]);
            if (l0.t(sM & g2.f10190d, 65535 & sM2) > 0) {
                sM = sM2;
            }
        }
        return new g2(sM);
    }

    @p2(markerClass = {lm.r.class})
    @m
    @f1(version = "1.4")
    @t
    public static final a2 x8(@l long[] jArr, @l rn.f fVar) {
        l0.p(jArr, "$this$randomOrNull");
        l0.p(fVar, "random");
        if (b2.t(jArr)) {
            return null;
        }
        return new a2(a2.m(jArr[fVar.nextInt(jArr.length)]));
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] x9(short[] sArr) {
        l0.p(sArr, "$this$reversedArray");
        short[] sArrYr = r.yr(sArr);
        l0.p(sArrYr, "storage");
        return sArrYr;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<s1> xa(@l byte[] bArr, @l Iterable<Integer> iterable) {
        l0.p(bArr, "$this$slice");
        l0.p(iterable, "indices");
        int iB0 = z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(new s1(s1.m(bArr[it.next().intValue()])));
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int xb(short[] sArr) {
        l0.p(sArr, "$this$sum");
        int iM = w1.m(0);
        for (short s10 : sArr) {
            iM += g2.m(s10) & g2.f10190d;
        }
        return iM;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final short[] xc(short[] sArr) {
        l0.p(sArr, "$this$toShortArray");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        l0.o(sArrCopyOf, "copyOf(...)");
        return sArrCopyOf;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int y0(int[] iArr) {
        l0.p(iArr, "$this$component1");
        return w1.m(iArr[0]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int y1(byte[] bArr, jn.l<? super s1, Boolean> lVar) {
        l0.p(bArr, "$this$count");
        l0.p(lVar, "predicate");
        int i10 = 0;
        for (byte b10 : bArr) {
            if (((Boolean) qm.d.a(s1.m(b10), lVar)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super a2>> C y2(long[] jArr, C c10, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$filterNotTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            long jM = a2.m(j10);
            if (!((Boolean) qm.c.a(jM, lVar)).booleanValue()) {
                c10.add(new a2(jM));
            }
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R y3(byte[] bArr, R r10, q<? super Integer, ? super R, ? super s1, ? extends R> qVar) {
        l0.p(bArr, "$this$foldIndexed");
        l0.p(qVar, "operation");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, new s1(s1.m(bArr[i10])));
            i10++;
            i11++;
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, M extends Map<? super K, List<w1>>> M y4(int[] iArr, M m10, jn.l<? super w1, ? extends K> lVar) {
        l0.p(iArr, "$this$groupByTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        for (int i10 : iArr) {
            int iM = w1.m(i10);
            Object objA = e.a(iM, lVar);
            Object objA2 = m10.get(objA);
            if (objA2 == null) {
                objA2 = nm.q.a(m10, objA);
            }
            ((List) objA2).add(new w1(iM));
        }
        return m10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C y5(long[] jArr, C c10, jn.l<? super a2, ? extends R> lVar) {
        l0.p(jArr, "$this$mapTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        for (long j10 : jArr) {
            c10.add(lVar.invoke(new a2(a2.m(j10))));
        }
        return c10;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final s1 y6(@l byte[] bArr, @l Comparator<? super s1> comparator) {
        l0.p(bArr, "$this$maxWithOrNull");
        l0.p(comparator, "comparator");
        if (t1.t(bArr)) {
            return null;
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte bM2 = s1.m(bArr[it.nextInt()]);
            if (comparator.compare(new s1(bM), new s1(bM2)) < 0) {
                bM = bM2;
            }
        }
        return new s1(bM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "minOrThrow-U")
    public static final byte y7(@l byte[] bArr) {
        l0.p(bArr, "$this$min");
        if (t1.t(bArr)) {
            throw new NoSuchElementException();
        }
        byte bM = s1.m(bArr[0]);
        v0 it = new tn.l(1, r.qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte bM2 = s1.m(bArr[it.nextInt()]);
            if (l0.t(bM & 255, bM2 & 255) > 0) {
                bM = bM2;
            }
        }
        return bM;
    }

    @an.f
    @p2(markerClass = {lm.r.class})
    @f1(version = "1.4")
    @t
    public static final a2 y8(long[] jArr) {
        l0.p(jArr, "$this$randomOrNull");
        return x8(jArr, rn.f.Default);
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R> List<R> y9(long[] jArr, R r10, p<? super R, ? super a2, ? extends R> pVar) {
        l0.p(jArr, "$this$runningFold");
        l0.p(pVar, "operation");
        if (b2.t(jArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        for (long j10 : jArr) {
            r10 = pVar.invoke(r10, new a2(a2.m(j10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<g2> ya(@l short[] sArr, @l tn.l lVar) {
        l0.p(sArr, "$this$slice");
        l0.p(lVar, "indices");
        if (lVar.isEmpty()) {
            return k0.INSTANCE;
        }
        short[] sArrM1 = nm.p.m1(sArr, lVar.f15911a, lVar.f15912b + 1);
        l0.p(sArrM1, "storage");
        return f.d(sArrM1);
    }

    @an.f
    @f1(version = "1.3")
    @lm.l(warningSince = "1.5")
    @t
    @k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int yb(byte[] bArr, jn.l<? super s1, w1> lVar) {
        l0.p(bArr, "$this$sumBy");
        l0.p(lVar, "selector");
        int i10 = 0;
        for (byte b10 : bArr) {
            i10 += ((w1) qm.d.a(s1.m(b10), lVar)).f10227a;
        }
        return i10;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final w1[] yc(@l int[] iArr) {
        l0.p(iArr, "$this$toTypedArray");
        int length = iArr.length;
        w1[] w1VarArr = new w1[length];
        for (int i10 = 0; i10 < length; i10++) {
            w1VarArr[i10] = new w1(w1.m(iArr[i10]));
        }
        return w1VarArr;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final byte z0(byte[] bArr) {
        l0.p(bArr, "$this$component1");
        return s1.m(bArr[0]);
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final int z1(long[] jArr, jn.l<? super a2, Boolean> lVar) {
        l0.p(jArr, "$this$count");
        l0.p(lVar, "predicate");
        int i10 = 0;
        for (long j10 : jArr) {
            if (((Boolean) qm.c.a(a2.m(j10), lVar)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <C extends Collection<? super g2>> C z2(short[] sArr, C c10, jn.l<? super g2, Boolean> lVar) {
        l0.p(sArr, "$this$filterNotTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            short sM = g2.m(s10);
            if (!((Boolean) qm.b.a(sM, lVar)).booleanValue()) {
                c10.add(new g2(sM));
            }
        }
        return c10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R> R z3(short[] sArr, R r10, q<? super Integer, ? super R, ? super g2, ? extends R> qVar) {
        l0.p(sArr, "$this$foldIndexed");
        l0.p(qVar, "operation");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, new g2(g2.m(sArr[i10])));
            i10++;
            i11++;
        }
        return r10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <K, M extends Map<? super K, List<s1>>> M z4(byte[] bArr, M m10, jn.l<? super s1, ? extends K> lVar) {
        l0.p(bArr, "$this$groupByTo");
        l0.p(m10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "keySelector");
        for (byte b10 : bArr) {
            byte bM = s1.m(b10);
            Object objA = qm.d.a(bM, lVar);
            Object objA2 = m10.get(objA);
            if (objA2 == null) {
                objA2 = nm.q.a(m10, objA);
            }
            ((List) objA2).add(new s1(bM));
        }
        return m10;
    }

    @f1(version = "1.3")
    @t
    @an.f
    public static final <R, C extends Collection<? super R>> C z5(short[] sArr, C c10, jn.l<? super g2, ? extends R> lVar) {
        l0.p(sArr, "$this$mapTo");
        l0.p(c10, RtspHeaders.Values.DESTINATION);
        l0.p(lVar, "transform");
        for (short s10 : sArr) {
            c10.add(lVar.invoke(new g2(g2.m(s10))));
        }
        return c10;
    }

    @m
    @f1(version = "1.4")
    @t
    public static final w1 z6(@l int[] iArr, @l Comparator<? super w1> comparator) {
        l0.p(iArr, "$this$maxWithOrNull");
        l0.p(comparator, "comparator");
        if (x1.t(iArr)) {
            return null;
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iM2 = w1.m(iArr[it.nextInt()]);
            if (comparator.compare(new w1(iM), new w1(iM2)) < 0) {
                iM = iM2;
            }
        }
        return new w1(iM);
    }

    @f1(version = "1.7")
    @t
    @i(name = "minOrThrow-U")
    public static final int z7(@l int[] iArr) {
        l0.p(iArr, "$this$min");
        if (x1.t(iArr)) {
            throw new NoSuchElementException();
        }
        int iM = w1.m(iArr[0]);
        v0 it = new tn.l(1, r.ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iM2 = w1.m(iArr[it.nextInt()]);
            if (Integer.compareUnsigned(iM, iM2) > 0) {
                iM = iM2;
            }
        }
        return iM;
    }

    @p2(markerClass = {lm.r.class})
    @m
    @f1(version = "1.4")
    @t
    public static final s1 z8(@l byte[] bArr, @l rn.f fVar) {
        l0.p(bArr, "$this$randomOrNull");
        l0.p(fVar, "random");
        if (t1.t(bArr)) {
            return null;
        }
        return new s1(s1.m(bArr[fVar.nextInt(bArr.length)]));
    }

    @f1(version = "1.4")
    @t
    @an.f
    public static final <R> List<R> z9(byte[] bArr, R r10, p<? super R, ? super s1, ? extends R> pVar) {
        l0.p(bArr, "$this$runningFold");
        l0.p(pVar, "operation");
        if (t1.t(bArr)) {
            return x.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        for (byte b10 : bArr) {
            r10 = pVar.invoke(r10, new s1(s1.m(b10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final List<a2> za(@l long[] jArr, @l tn.l lVar) {
        l0.p(jArr, "$this$slice");
        l0.p(lVar, "indices");
        if (lVar.isEmpty()) {
            return k0.INSTANCE;
        }
        long[] jArrK1 = nm.p.k1(jArr, lVar.f15911a, lVar.f15912b + 1);
        l0.p(jArrK1, "storage");
        return f.c(jArrK1);
    }

    @an.f
    @f1(version = "1.3")
    @lm.l(warningSince = "1.5")
    @t
    @k(message = "Use sumOf instead.", replaceWith = @a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int zb(long[] jArr, jn.l<? super a2, w1> lVar) {
        l0.p(jArr, "$this$sumBy");
        l0.p(lVar, "selector");
        int i10 = 0;
        for (long j10 : jArr) {
            i10 += ((w1) qm.c.a(a2.m(j10), lVar)).f10227a;
        }
        return i10;
    }

    @f1(version = "1.3")
    @t
    @l
    public static final s1[] zc(@l byte[] bArr) {
        l0.p(bArr, "$this$toTypedArray");
        int length = bArr.length;
        s1[] s1VarArr = new s1[length];
        for (int i10 = 0; i10 < length; i10++) {
            s1VarArr[i10] = new s1(s1.m(bArr[i10]));
        }
        return s1VarArr;
    }
}
