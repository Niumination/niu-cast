package nm;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import lm.a2;
import lm.l2;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\n_Arrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,24423:1\n12524#1,2:24424\n12534#1,2:24426\n1282#1,2:24428\n1290#1,2:24430\n1298#1,2:24432\n1306#1,2:24434\n1314#1,2:24436\n1322#1,2:24438\n1330#1,2:24440\n1338#1,2:24442\n1346#1,2:24444\n2298#1,5:24446\n2311#1,5:24451\n2324#1,5:24456\n2337#1,5:24461\n2350#1,5:24466\n2363#1,5:24471\n2376#1,5:24476\n2389#1,5:24481\n2402#1,5:24486\n4307#1,2:24492\n4317#1,2:24494\n4327#1,2:24496\n4337#1,2:24498\n4347#1,2:24500\n4357#1,2:24502\n4367#1,2:24504\n4377#1,2:24506\n4387#1,2:24508\n3974#1:24510\n13374#1,2:24511\n3975#1,2:24513\n13376#1:24515\n3977#1:24516\n3988#1:24517\n13384#1,2:24518\n3989#1,2:24520\n13386#1:24522\n3991#1:24523\n4002#1:24524\n13394#1,2:24525\n4003#1,2:24527\n13396#1:24529\n4005#1:24530\n4016#1:24531\n13404#1,2:24532\n4017#1,2:24534\n13406#1:24536\n4019#1:24537\n4030#1:24538\n13414#1,2:24539\n4031#1,2:24541\n13416#1:24543\n4033#1:24544\n4044#1:24545\n13424#1,2:24546\n4045#1,2:24548\n13426#1:24550\n4047#1:24551\n4058#1:24552\n13434#1,2:24553\n4059#1,2:24555\n13436#1:24557\n4061#1:24558\n4072#1:24559\n13444#1,2:24560\n4073#1,2:24562\n13446#1:24564\n4075#1:24565\n4086#1:24566\n13454#1,2:24567\n4087#1,2:24569\n13456#1:24571\n4089#1:24572\n13374#1,3:24573\n13384#1,3:24576\n13394#1,3:24579\n13404#1,3:24582\n13414#1,3:24585\n13424#1,3:24588\n13434#1,3:24591\n13444#1,3:24594\n13454#1,3:24597\n4107#1,2:24600\n4217#1,2:24602\n4227#1,2:24604\n4237#1,2:24606\n4247#1,2:24608\n4257#1,2:24610\n4267#1,2:24612\n4277#1,2:24614\n4287#1,2:24616\n4297#1,2:24618\n9088#1,4:24620\n9103#1,4:24624\n9118#1,4:24628\n9133#1,4:24632\n9148#1,4:24636\n9163#1,4:24640\n9178#1,4:24644\n9193#1,4:24648\n9208#1,4:24652\n8801#1,4:24656\n8817#1,4:24660\n8833#1,4:24664\n8849#1,4:24668\n8865#1,4:24672\n8881#1,4:24676\n8897#1,4:24680\n8913#1,4:24684\n8929#1,4:24688\n8945#1,4:24692\n8961#1,4:24696\n8977#1,4:24700\n8993#1,4:24704\n9009#1,4:24708\n9025#1,4:24712\n9041#1,4:24716\n9057#1,4:24720\n9073#1,4:24724\n9376#1,4:24728\n10394#1,5:24732\n10405#1,5:24737\n10416#1,5:24742\n10427#1,5:24747\n10438#1,5:24752\n10449#1,5:24757\n10460#1,5:24762\n10471#1,5:24767\n10482#1,5:24772\n10497#1,5:24777\n10738#1,3:24782\n10741#1,3:24792\n10755#1,3:24795\n10758#1,3:24805\n10772#1,3:24808\n10775#1,3:24818\n10789#1,3:24821\n10792#1,3:24831\n10806#1,3:24834\n10809#1,3:24844\n10823#1,3:24847\n10826#1,3:24857\n10840#1,3:24860\n10843#1,3:24870\n10857#1,3:24873\n10860#1,3:24883\n10874#1,3:24886\n10877#1,3:24896\n10892#1,3:24899\n10895#1,3:24909\n10910#1,3:24912\n10913#1,3:24922\n10928#1,3:24925\n10931#1,3:24935\n10946#1,3:24938\n10949#1,3:24948\n10964#1,3:24951\n10967#1,3:24961\n10982#1,3:24964\n10985#1,3:24974\n11000#1,3:24977\n11003#1,3:24987\n11018#1,3:24990\n11021#1,3:25000\n11036#1,3:25003\n11039#1,3:25013\n11400#1,3:25142\n11410#1,3:25145\n11420#1,3:25148\n11430#1,3:25151\n11440#1,3:25154\n11450#1,3:25157\n11460#1,3:25160\n11470#1,3:25163\n11480#1,3:25166\n11266#1,4:25169\n11279#1,4:25173\n11292#1,4:25177\n11305#1,4:25181\n11318#1,4:25185\n11331#1,4:25189\n11344#1,4:25193\n11357#1,4:25197\n11370#1,4:25201\n11255#1:25205\n13374#1,2:25206\n13376#1:25209\n11256#1:25210\n13374#1,3:25211\n11391#1:25214\n13309#1:25215\n13310#1:25217\n11392#1:25218\n13309#1,2:25219\n13374#1,3:25221\n13384#1,3:25224\n13394#1,3:25227\n13404#1,3:25230\n13414#1,3:25233\n13424#1,3:25236\n13434#1,3:25239\n13444#1,3:25242\n13454#1,3:25245\n20623#1,2:25248\n20625#1,6:25251\n20839#1,2:25257\n20841#1,6:25260\n23035#1,6:25266\n23051#1,6:25272\n23067#1,6:25278\n23083#1,6:25284\n23099#1,6:25290\n23115#1,6:25296\n23131#1,6:25302\n23147#1,6:25308\n23163#1,6:25314\n23269#1,8:25320\n23287#1,8:25328\n23305#1,8:25336\n23323#1,8:25344\n23341#1,8:25352\n23359#1,8:25360\n23377#1,8:25368\n23395#1,8:25376\n23413#1,8:25384\n23511#1,6:25392\n23527#1,6:25398\n23543#1,6:25404\n23559#1,6:25410\n23575#1,6:25416\n23591#1,6:25422\n23607#1,6:25428\n23623#1,6:25434\n1#2:24491\n1#2:25208\n1#2:25216\n1#2:25250\n1#2:25259\n372#3,7:24785\n372#3,7:24798\n372#3,7:24811\n372#3,7:24824\n372#3,7:24837\n372#3,7:24850\n372#3,7:24863\n372#3,7:24876\n372#3,7:24889\n372#3,7:24902\n372#3,7:24915\n372#3,7:24928\n372#3,7:24941\n372#3,7:24954\n372#3,7:24967\n372#3,7:24980\n372#3,7:24993\n372#3,7:25006\n372#3,7:25016\n372#3,7:25023\n372#3,7:25030\n372#3,7:25037\n372#3,7:25044\n372#3,7:25051\n372#3,7:25058\n372#3,7:25065\n372#3,7:25072\n372#3,7:25079\n372#3,7:25086\n372#3,7:25093\n372#3,7:25100\n372#3,7:25107\n372#3,7:25114\n372#3,7:25121\n372#3,7:25128\n372#3,7:25135\n*S KotlinDebug\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n556#1:24424,2\n565#1:24426,2\n832#1:24428,2\n842#1:24430,2\n852#1:24432,2\n862#1:24434,2\n872#1:24436,2\n882#1:24438,2\n892#1:24440,2\n902#1:24442,2\n912#1:24444,2\n922#1:24446,5\n932#1:24451,5\n942#1:24456,5\n952#1:24461,5\n962#1:24466,5\n972#1:24471,5\n982#1:24476,5\n992#1:24481,5\n1002#1:24486,5\n3792#1:24492,2\n3801#1:24494,2\n3810#1:24496,2\n3819#1:24498,2\n3828#1:24500,2\n3837#1:24502,2\n3846#1:24504,2\n3855#1:24506,2\n3864#1:24508,2\n3875#1:24510\n3875#1:24511,2\n3875#1:24513,2\n3875#1:24515\n3875#1:24516\n3886#1:24517\n3886#1:24518,2\n3886#1:24520,2\n3886#1:24522\n3886#1:24523\n3897#1:24524\n3897#1:24525,2\n3897#1:24527,2\n3897#1:24529\n3897#1:24530\n3908#1:24531\n3908#1:24532,2\n3908#1:24534,2\n3908#1:24536\n3908#1:24537\n3919#1:24538\n3919#1:24539,2\n3919#1:24541,2\n3919#1:24543\n3919#1:24544\n3930#1:24545\n3930#1:24546,2\n3930#1:24548,2\n3930#1:24550\n3930#1:24551\n3941#1:24552\n3941#1:24553,2\n3941#1:24555,2\n3941#1:24557\n3941#1:24558\n3952#1:24559\n3952#1:24560,2\n3952#1:24562,2\n3952#1:24564\n3952#1:24565\n3963#1:24566\n3963#1:24567,2\n3963#1:24569,2\n3963#1:24571\n3963#1:24572\n3974#1:24573,3\n3988#1:24576,3\n4002#1:24579,3\n4016#1:24582,3\n4030#1:24585,3\n4044#1:24588,3\n4058#1:24591,3\n4072#1:24594,3\n4086#1:24597,3\n4098#1:24600,2\n4117#1:24602,2\n4126#1:24604,2\n4135#1:24606,2\n4144#1:24608,2\n4153#1:24610,2\n4162#1:24612,2\n4171#1:24614,2\n4180#1:24616,2\n4189#1:24618,2\n8407#1:24620,4\n8422#1:24624,4\n8437#1:24628,4\n8452#1:24632,4\n8467#1:24636,4\n8482#1:24640,4\n8497#1:24644,4\n8512#1:24648,4\n8527#1:24652,4\n8542#1:24656,4\n8557#1:24660,4\n8572#1:24664,4\n8587#1:24668,4\n8602#1:24672,4\n8617#1:24676,4\n8632#1:24680,4\n8647#1:24684,4\n8662#1:24688,4\n8676#1:24692,4\n8690#1:24696,4\n8704#1:24700,4\n8718#1:24704,4\n8732#1:24708,4\n8746#1:24712,4\n8760#1:24716,4\n8774#1:24720,4\n8788#1:24724,4\n9227#1:24728,4\n9972#1:24732,5\n9981#1:24737,5\n9990#1:24742,5\n9999#1:24747,5\n10008#1:24752,5\n10017#1:24757,5\n10026#1:24762,5\n10035#1:24767,5\n10044#1:24772,5\n10057#1:24777,5\n10513#1:24782,3\n10513#1:24792,3\n10525#1:24795,3\n10525#1:24805,3\n10537#1:24808,3\n10537#1:24818,3\n10549#1:24821,3\n10549#1:24831,3\n10561#1:24834,3\n10561#1:24844,3\n10573#1:24847,3\n10573#1:24857,3\n10585#1:24860,3\n10585#1:24870,3\n10597#1:24873,3\n10597#1:24883,3\n10609#1:24886,3\n10609#1:24896,3\n10622#1:24899,3\n10622#1:24909,3\n10635#1:24912,3\n10635#1:24922,3\n10648#1:24925,3\n10648#1:24935,3\n10661#1:24938,3\n10661#1:24948,3\n10674#1:24951,3\n10674#1:24961,3\n10687#1:24964,3\n10687#1:24974,3\n10700#1:24977,3\n10700#1:24987,3\n10713#1:24990,3\n10713#1:25000,3\n10726#1:25003,3\n10726#1:25013,3\n11065#1:25142,3\n11075#1:25145,3\n11085#1:25148,3\n11095#1:25151,3\n11105#1:25154,3\n11115#1:25157,3\n11125#1:25160,3\n11135#1:25163,3\n11145#1:25166,3\n11155#1:25169,4\n11165#1:25173,4\n11175#1:25177,4\n11185#1:25181,4\n11195#1:25185,4\n11205#1:25189,4\n11215#1:25193,4\n11225#1:25197,4\n11235#1:25201,4\n11245#1:25205\n11245#1:25206,2\n11245#1:25209\n11245#1:25210\n11255#1:25211,3\n11383#1:25214\n11383#1:25215\n11383#1:25217\n11383#1:25218\n11391#1:25219,2\n18891#1:25221,3\n18903#1:25224,3\n18915#1:25227,3\n18927#1:25230,3\n18939#1:25233,3\n18951#1:25236,3\n18963#1:25239,3\n18975#1:25242,3\n18987#1:25245,3\n21455#1:25248,2\n21455#1:25251,6\n21617#1:25257,2\n21617#1:25260,6\n22944#1:25266,6\n22954#1:25272,6\n22964#1:25278,6\n22974#1:25284,6\n22984#1:25290,6\n22994#1:25296,6\n23004#1:25302,6\n23014#1:25308,6\n23024#1:25314,6\n23178#1:25320,8\n23188#1:25328,8\n23198#1:25336,8\n23208#1:25344,8\n23218#1:25352,8\n23228#1:25360,8\n23238#1:25368,8\n23248#1:25376,8\n23258#1:25384,8\n23430#1:25392,6\n23440#1:25398,6\n23450#1:25404,6\n23460#1:25410,6\n23470#1:25416,6\n23480#1:25422,6\n23490#1:25428,6\n23500#1:25434,6\n11245#1:25208\n11383#1:25216\n21455#1:25250\n21617#1:25259\n10513#1:24785,7\n10525#1:24798,7\n10537#1:24811,7\n10549#1:24824,7\n10561#1:24837,7\n10573#1:24850,7\n10585#1:24863,7\n10597#1:24876,7\n10609#1:24889,7\n10622#1:24902,7\n10635#1:24915,7\n10648#1:24928,7\n10661#1:24941,7\n10674#1:24954,7\n10687#1:24967,7\n10700#1:24980,7\n10713#1:24993,7\n10726#1:25006,7\n10740#1:25016,7\n10757#1:25023,7\n10774#1:25030,7\n10791#1:25037,7\n10808#1:25044,7\n10825#1:25051,7\n10842#1:25058,7\n10859#1:25065,7\n10876#1:25072,7\n10894#1:25079,7\n10912#1:25086,7\n10930#1:25093,7\n10948#1:25100,7\n10966#1:25107,7\n10984#1:25114,7\n11002#1:25121,7\n11020#1:25128,7\n11038#1:25135,7\n*E\n"})
public class r extends nm.p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kn.r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n23966#2:71\n*E\n"})
    public static final class a<T> implements Iterable<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f11666a;

        public a(Object[] objArr) {
            this.f11666a = objArr;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<T> iterator() {
            return kn.i.a(this.f11666a);
        }
    }

    public static final class a0 extends kn.n0 implements jn.a<Iterator<? extends Boolean>> {
        final /* synthetic */ boolean[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(boolean[] zArr) {
            super(0);
            this.$this_withIndex = zArr;
        }

        @Override // jn.a
        @os.l
        public final Iterator<? extends Boolean> invoke() {
            return kn.j.a(this.$this_withIndex);
        }
    }

    @kn.r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n23974#2:71\n*E\n"})
    public static final class b implements Iterable<Byte>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f11667a;

        public b(byte[] bArr) {
            this.f11667a = bArr;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<Byte> iterator() {
            return kn.j.b(this.f11667a);
        }
    }

    public static final class b0 extends kn.n0 implements jn.a<Iterator<? extends Character>> {
        final /* synthetic */ char[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(char[] cArr) {
            super(0);
            this.$this_withIndex = cArr;
        }

        @Override // jn.a
        @os.l
        public final Iterator<? extends Character> invoke() {
            return kn.j.c(this.$this_withIndex);
        }
    }

    @kn.r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n23982#2:71\n*E\n"})
    public static final class c implements Iterable<Short>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ short[] f11668a;

        public c(short[] sArr) {
            this.f11668a = sArr;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<Short> iterator() {
            return kn.j.h(this.f11668a);
        }
    }

    @kn.r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n23990#2:71\n*E\n"})
    public static final class d implements Iterable<Integer>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f11669a;

        public d(int[] iArr) {
            this.f11669a = iArr;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<Integer> iterator() {
            return kn.j.f(this.f11669a);
        }
    }

    @kn.r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n23998#2:71\n*E\n"})
    public static final class e implements Iterable<Long>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long[] f11670a;

        public e(long[] jArr) {
            this.f11670a = jArr;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<Long> iterator() {
            return kn.j.g(this.f11670a);
        }
    }

    @kn.r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24006#2:71\n*E\n"})
    public static final class f implements Iterable<Float>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float[] f11671a;

        public f(float[] fArr) {
            this.f11671a = fArr;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<Float> iterator() {
            return kn.j.e(this.f11671a);
        }
    }

    @kn.r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24014#2:71\n*E\n"})
    public static final class g implements Iterable<Double>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double[] f11672a;

        public g(double[] dArr) {
            this.f11672a = dArr;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<Double> iterator() {
            return kn.j.d(this.f11672a);
        }
    }

    @kn.r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24022#2:71\n*E\n"})
    public static final class h implements Iterable<Boolean>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f11673a;

        public h(boolean[] zArr) {
            this.f11673a = zArr;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<Boolean> iterator() {
            return kn.j.a(this.f11673a);
        }
    }

    @kn.r1({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,70:1\n24030#2:71\n*E\n"})
    public static final class i implements Iterable<Character>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ char[] f11674a;

        public i(char[] cArr) {
            this.f11674a = cArr;
        }

        @Override // java.lang.Iterable
        @os.l
        public Iterator<Character> iterator() {
            return kn.j.c(this.f11674a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kn.r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24040#2:681\n*E\n"})
    public static final class j<T> implements gq.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f11675a;

        public j(Object[] objArr) {
            this.f11675a = objArr;
        }

        @Override // gq.m
        @os.l
        public Iterator<T> iterator() {
            return kn.i.a(this.f11675a);
        }
    }

    @kn.r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24050#2:681\n*E\n"})
    public static final class k implements gq.m<Byte> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f11676a;

        public k(byte[] bArr) {
            this.f11676a = bArr;
        }

        @Override // gq.m
        @os.l
        public Iterator<Byte> iterator() {
            return kn.j.b(this.f11676a);
        }
    }

    @kn.r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24060#2:681\n*E\n"})
    public static final class l implements gq.m<Short> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ short[] f11677a;

        public l(short[] sArr) {
            this.f11677a = sArr;
        }

        @Override // gq.m
        @os.l
        public Iterator<Short> iterator() {
            return kn.j.h(this.f11677a);
        }
    }

    @kn.r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24070#2:681\n*E\n"})
    public static final class m implements gq.m<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int[] f11678a;

        public m(int[] iArr) {
            this.f11678a = iArr;
        }

        @Override // gq.m
        @os.l
        public Iterator<Integer> iterator() {
            return kn.j.f(this.f11678a);
        }
    }

    @kn.r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24080#2:681\n*E\n"})
    public static final class n implements gq.m<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long[] f11679a;

        public n(long[] jArr) {
            this.f11679a = jArr;
        }

        @Override // gq.m
        @os.l
        public Iterator<Long> iterator() {
            return kn.j.g(this.f11679a);
        }
    }

    @kn.r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24090#2:681\n*E\n"})
    public static final class o implements gq.m<Float> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float[] f11680a;

        public o(float[] fArr) {
            this.f11680a = fArr;
        }

        @Override // gq.m
        @os.l
        public Iterator<Float> iterator() {
            return kn.j.e(this.f11680a);
        }
    }

    @kn.r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24100#2:681\n*E\n"})
    public static final class p implements gq.m<Double> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ double[] f11681a;

        public p(double[] dArr) {
            this.f11681a = dArr;
        }

        @Override // gq.m
        @os.l
        public Iterator<Double> iterator() {
            return kn.j.d(this.f11681a);
        }
    }

    @kn.r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24110#2:681\n*E\n"})
    public static final class q implements gq.m<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean[] f11682a;

        public q(boolean[] zArr) {
            this.f11682a = zArr;
        }

        @Override // gq.m
        @os.l
        public Iterator<Boolean> iterator() {
            return kn.j.a(this.f11682a);
        }
    }

    /* JADX INFO: renamed from: nm.r$r, reason: collision with other inner class name */
    @kn.r1({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,680:1\n24120#2:681\n*E\n"})
    public static final class C0300r implements gq.m<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ char[] f11683a;

        public C0300r(char[] cArr) {
            this.f11683a = cArr;
        }

        @Override // gq.m
        @os.l
        public Iterator<Character> iterator() {
            return kn.j.c(this.f11683a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    @kn.r1({"SMAP\n_Arrays.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt$groupingBy$1\n*L\n1#1,24423:1\n*E\n"})
    public static final class s<K, T> implements o0<T, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ T[] f11684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ jn.l<T, K> f11685b;

        /* JADX WARN: Multi-variable type inference failed */
        public s(T[] tArr, jn.l<? super T, ? extends K> lVar) {
            this.f11684a = tArr;
            this.f11685b = lVar;
        }

        @Override // nm.o0
        public K a(T t10) {
            return this.f11685b.invoke(t10);
        }

        @Override // nm.o0
        @os.l
        public Iterator<T> b() {
            return kn.i.a(this.f11684a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class t<T> extends kn.n0 implements jn.a<Iterator<? extends T>> {
        final /* synthetic */ T[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(T[] tArr) {
            super(0);
            this.$this_withIndex = tArr;
        }

        @Override // jn.a
        @os.l
        public final Iterator<T> invoke() {
            return kn.i.a(this.$this_withIndex);
        }
    }

    public static final class u extends kn.n0 implements jn.a<Iterator<? extends Byte>> {
        final /* synthetic */ byte[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(byte[] bArr) {
            super(0);
            this.$this_withIndex = bArr;
        }

        @Override // jn.a
        @os.l
        public final Iterator<? extends Byte> invoke() {
            return kn.j.b(this.$this_withIndex);
        }
    }

    public static final class v extends kn.n0 implements jn.a<Iterator<? extends Short>> {
        final /* synthetic */ short[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(short[] sArr) {
            super(0);
            this.$this_withIndex = sArr;
        }

        @Override // jn.a
        @os.l
        public final Iterator<? extends Short> invoke() {
            return kn.j.h(this.$this_withIndex);
        }
    }

    public static final class w extends kn.n0 implements jn.a<Iterator<? extends Integer>> {
        final /* synthetic */ int[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(int[] iArr) {
            super(0);
            this.$this_withIndex = iArr;
        }

        @Override // jn.a
        @os.l
        public final Iterator<? extends Integer> invoke() {
            return kn.j.f(this.$this_withIndex);
        }
    }

    public static final class x extends kn.n0 implements jn.a<Iterator<? extends Long>> {
        final /* synthetic */ long[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(long[] jArr) {
            super(0);
            this.$this_withIndex = jArr;
        }

        @Override // jn.a
        @os.l
        public final Iterator<? extends Long> invoke() {
            return kn.j.g(this.$this_withIndex);
        }
    }

    public static final class y extends kn.n0 implements jn.a<Iterator<? extends Float>> {
        final /* synthetic */ float[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(float[] fArr) {
            super(0);
            this.$this_withIndex = fArr;
        }

        @Override // jn.a
        @os.l
        public final Iterator<? extends Float> invoke() {
            return kn.j.e(this.$this_withIndex);
        }
    }

    public static final class z extends kn.n0 implements jn.a<Iterator<? extends Double>> {
        final /* synthetic */ double[] $this_withIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(double[] dArr) {
            super(0);
            this.$this_withIndex = dArr;
        }

        @Override // jn.a
        @os.l
        public final Iterator<? extends Double> invoke() {
            return kn.j.d(this.$this_withIndex);
        }
    }

    @os.l
    public static final Iterable<Long> A5(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return jArr.length == 0 ? k0.INSTANCE : new e(jArr);
    }

    @os.l
    public static final <T, K, M extends Map<? super K, ? super T>> M A6(@os.l T[] tArr, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (T t10 : tArr) {
            m10.put(lVar.invoke(t10), t10);
        }
        return m10;
    }

    @an.f
    public static final short A7(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return sArr[0];
    }

    public static final int A8(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int i10 = 0;
        for (double d10 : dArr) {
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @os.l
    public static final List<Float> A9(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iTe = te(fArr); -1 < iTe; iTe--) {
            if (!lVar.invoke(Float.valueOf(fArr[iTe])).booleanValue()) {
                return yx(fArr, iTe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final List<lm.t0<Short, Short>> AA(@os.l short[] sArr, @os.l short[] sArr2) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(sArr2, "other");
        int iMin = Math.min(sArr.length, sArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(Short.valueOf(sArr[i10]), Short.valueOf(sArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Character>> C Aa(@os.l char[] cArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Character, Boolean> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "predicate");
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            char c11 = cArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Character.valueOf(c11)).booleanValue()) {
                c10.add(Character.valueOf(c11));
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @an.f
    public static final Float Ab(float[] fArr, jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                float f10 = fArr[length];
                if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                    return Float.valueOf(f10);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterable")
    @lm.f1(version = "1.4")
    public static final <R> List<R> Ac(byte[] bArr, jn.p<? super Integer, ? super Byte, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), Byte.valueOf(bArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R Ad(@os.l float[] fArr, R r10, @os.l jn.p<? super Float, ? super R, ? extends R> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (int iTe = te(fArr); iTe >= 0; iTe--) {
            r10 = pVar.invoke(Float.valueOf(fArr[iTe]), r10);
        }
        return r10;
    }

    @an.f
    public static final char Ae(char[] cArr, int i10, jn.l<? super Integer, Character> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > re(cArr)) ? lVar.invoke(Integer.valueOf(i10)).charValue() : cArr[i10];
    }

    @os.l
    public static final <K, V, M extends Map<? super K, List<V>>> M Af(@os.l boolean[] zArr, @os.l M m10, @os.l jn.l<? super Boolean, ? extends K> lVar, @os.l jn.l<? super Boolean, ? extends V> lVar2) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (boolean z10 : zArr) {
            K kInvoke = lVar.invoke(Boolean.valueOf(z10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Boolean.valueOf(z10)));
        }
        return m10;
    }

    @an.f
    public static final boolean Ag(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return !(jArr.length == 0);
    }

    public static <T> T Ah(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[we(tArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C Ai(@os.l T[] tArr, @os.l C c10, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i11 + 1;
            R rInvoke = pVar.invoke(Integer.valueOf(i11), tArr[i10]);
            if (rInvoke != null) {
                c10.add(rInvoke);
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float Aj(int[] iArr, jn.l<? super Integer, Float> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Integer.valueOf(iArr[0])).floatValue();
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Integer.valueOf(iArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Ak(double[] dArr, Comparator<? super R> comparator, jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Double.valueOf(dArr[0]));
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <T, R extends Comparable<? super R>> T Al(@os.l T[] tArr, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        int iWe = we(tArr);
        if (iWe == 0) {
            return t10;
        }
        R rInvoke = lVar.invoke(t10);
        v0 v0VarA = nm.o.a(1, iWe, 1);
        while (v0VarA.hasNext()) {
            T t11 = tArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(t11);
            if (rInvoke.compareTo(rInvoke2) > 0) {
                t10 = t11;
                rInvoke = rInvoke2;
            }
        }
        return t10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double Am(long[] jArr, jn.l<? super Long, Double> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Long.valueOf(jArr[0])).doubleValue();
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Long.valueOf(jArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Byte An(@os.l byte[] bArr, @os.l Comparator<? super Byte> comparator) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte b11 = bArr[it.nextInt()];
            if (comparator.compare(Byte.valueOf(b10), Byte.valueOf(b11)) > 0) {
                b10 = b11;
            }
        }
        return Byte.valueOf(b10);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final short[] Ao(short[] sArr, jn.p<? super Integer, ? super Short, l2> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Short.valueOf(sArr[i10]));
            i10++;
            i11++;
        }
        return sArr;
    }

    public static final long Ap(@os.l long[] jArr, @os.l jn.p<? super Long, ? super Long, Long> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (jArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            jLongValue = pVar.invoke(Long.valueOf(jLongValue), Long.valueOf(jArr[it.nextInt()])).longValue();
        }
        return jLongValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Double Aq(@os.l double[] dArr, @os.l jn.q<? super Integer, ? super Double, ? super Double, Double> qVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iSe = se(dArr);
        if (iSe < 0) {
            return null;
        }
        double dDoubleValue = dArr[iSe];
        for (int i10 = iSe - 1; i10 >= 0; i10--) {
            dDoubleValue = qVar.invoke(Integer.valueOf(i10), Double.valueOf(dArr[i10]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Ar(byte[] bArr, R r10, jn.p<? super R, ? super Byte, ? extends R> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (bArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        for (byte b10 : bArr) {
            r10 = pVar.invoke(r10, Byte.valueOf(b10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> As(short[] sArr, R r10, jn.q<? super Integer, ? super R, ? super Short, ? extends R> qVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (sArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Short.valueOf(sArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Long At(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Long lValueOf = null;
        boolean z10 = false;
        for (long j10 : jArr) {
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                lValueOf = Long.valueOf(j10);
                z10 = true;
            }
        }
        if (z10) {
            return lValueOf;
        }
        return null;
    }

    @lm.f1(version = "1.4")
    public static final void Au(@os.l int[] iArr, int i10, int i11) {
        kn.l0.p(iArr, "<this>");
        nm.p.P3(iArr, i10, i11);
        Zq(iArr, i10, i11);
    }

    @os.l
    public static final List<Double> Av(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kn.l0.o(dArrCopyOf, "copyOf(...)");
        nm.p.K3(dArrCopyOf);
        return kr(dArrCopyOf);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfDouble")
    @lm.f1(version = "1.4")
    public static final double Aw(float[] fArr, jn.l<? super Float, Double> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (float f10 : fArr) {
            dDoubleValue += lVar.invoke(Float.valueOf(f10)).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final List<Long> Ax(@os.l long[] jArr, int i10) {
        kn.l0.p(jArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= jArr.length) {
            return Jy(jArr);
        }
        if (i10 == 1) {
            return nm.x.k(Long.valueOf(jArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (long j10 : jArr) {
            arrayList.add(Long.valueOf(j10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @os.l
    public static final <T> HashSet<T> Ay(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return (HashSet) py(tArr, new HashSet(c1.j(tArr.length)));
    }

    @os.l
    public static final Iterable<s0<Character>> Az(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return new t0(new b0(cArr));
    }

    @os.l
    public static <T> Iterable<T> B5(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return tArr.length == 0 ? k0.INSTANCE : new a(tArr);
    }

    @os.l
    public static final <T, K, V, M extends Map<? super K, ? super V>> M B6(@os.l T[] tArr, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (T t10 : tArr) {
            m10.put(lVar.invoke(t10), lVar2.invoke(t10));
        }
        return m10;
    }

    @an.f
    public static final boolean B7(boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return zArr[0];
    }

    @an.f
    public static final int B8(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return fArr.length;
    }

    @os.l
    public static final List<Integer> B9(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iUe = ue(iArr); -1 < iUe; iUe--) {
            if (!lVar.invoke(Integer.valueOf(iArr[iUe])).booleanValue()) {
                return zx(iArr, iUe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <V> List<V> BA(@os.l short[] sArr, @os.l short[] sArr2, @os.l jn.p<? super Short, ? super Short, ? extends V> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(sArr2, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(sArr.length, sArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Short.valueOf(sArr[i10]), Short.valueOf(sArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Double>> C Ba(@os.l double[] dArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Double, Boolean> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "predicate");
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            double d10 = dArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Double.valueOf(d10)).booleanValue()) {
                c10.add(Double.valueOf(d10));
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @an.f
    public static final Integer Bb(int[] iArr, jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                int i11 = iArr[length];
                if (lVar.invoke(Integer.valueOf(i11)).booleanValue()) {
                    return Integer.valueOf(i11);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterable")
    @lm.f1(version = "1.4")
    public static final <R> List<R> Bc(char[] cArr, jn.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), Character.valueOf(cArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R Bd(@os.l int[] iArr, R r10, @os.l jn.p<? super Integer, ? super R, ? extends R> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (int iUe = ue(iArr); iUe >= 0; iUe--) {
            r10 = pVar.invoke(Integer.valueOf(iArr[iUe]), r10);
        }
        return r10;
    }

    @an.f
    public static final double Be(double[] dArr, int i10, jn.l<? super Integer, Double> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > se(dArr)) ? lVar.invoke(Integer.valueOf(i10)).doubleValue() : dArr[i10];
    }

    @lm.f1(version = "1.1")
    @os.l
    public static final <T, K> o0<T, K> Bf(@os.l T[] tArr, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        return new s(tArr, lVar);
    }

    @an.f
    public static final <T> boolean Bg(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return !(tArr.length == 0);
    }

    public static final <T> T Bh(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                T t10 = tArr[length];
                if (lVar.invoke(t10).booleanValue()) {
                    return t10;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Bi(@os.l byte[] bArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Byte, ? extends R> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), Byte.valueOf(bArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float Bj(long[] jArr, jn.l<? super Long, Float> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Long.valueOf(jArr[0])).floatValue();
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Long.valueOf(jArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Bk(float[] fArr, Comparator<? super R> comparator, jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Float.valueOf(fArr[0]));
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Short Bl(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        int iXe = xe(sArr);
        if (iXe == 0) {
            return Short.valueOf(s10);
        }
        R rInvoke = lVar.invoke(Short.valueOf(s10));
        v0 v0VarA = nm.o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short s11 = sArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Short.valueOf(s11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                s10 = s11;
                rInvoke = rInvoke2;
            }
        }
        return Short.valueOf(s10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> Double Bm(T[] tArr, jn.l<? super T, Double> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(tArr[0]).doubleValue();
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(tArr[it.nextInt()]).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Character Bn(@os.l char[] cArr, @os.l Comparator<? super Character> comparator) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            char c11 = cArr[it.nextInt()];
            if (comparator.compare(Character.valueOf(c10), Character.valueOf(c11)) > 0) {
                c10 = c11;
            }
        }
        return Character.valueOf(c10);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final boolean[] Bo(boolean[] zArr, jn.p<? super Integer, ? super Boolean, l2> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Boolean.valueOf(zArr[i10]));
            i10++;
            i11++;
        }
        return zArr;
    }

    public static final <S, T extends S> S Bp(@os.l T[] tArr, @os.l jn.p<? super S, ? super T, ? extends S> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sInvoke = (S) tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            sInvoke = pVar.invoke(sInvoke, (Object) tArr[it.nextInt()]);
        }
        return sInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Float Bq(@os.l float[] fArr, @os.l jn.q<? super Integer, ? super Float, ? super Float, Float> qVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iTe = te(fArr);
        if (iTe < 0) {
            return null;
        }
        float fFloatValue = fArr[iTe];
        for (int i10 = iTe - 1; i10 >= 0; i10--) {
            fFloatValue = qVar.invoke(Integer.valueOf(i10), Float.valueOf(fArr[i10]), Float.valueOf(fFloatValue)).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Br(char[] cArr, R r10, jn.p<? super R, ? super Character, ? extends R> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (cArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r10);
        for (char c10 : cArr) {
            r10 = pVar.invoke(r10, Character.valueOf(c10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> Bs(boolean[] zArr, R r10, jn.q<? super Integer, ? super R, ? super Boolean, ? extends R> qVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (zArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r10);
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Boolean.valueOf(zArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static <T> T Bt(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final void Bu(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length > 1) {
            nm.p.Q3(jArr);
            ar(jArr);
        }
    }

    @os.l
    public static final List<Float> Bv(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kn.l0.o(fArrCopyOf, "copyOf(...)");
        nm.p.M3(fArrCopyOf);
        return lr(fArrCopyOf);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfDouble")
    @lm.f1(version = "1.4")
    public static final double Bw(int[] iArr, jn.l<? super Integer, Double> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (int i10 : iArr) {
            dDoubleValue += lVar.invoke(Integer.valueOf(i10)).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final <T> List<T> Bx(@os.l T[] tArr, int i10) {
        kn.l0.p(tArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= tArr.length) {
            return Ky(tArr);
        }
        if (i10 == 1) {
            return nm.x.k(tArr[0]);
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (T t10 : tArr) {
            arrayList.add(t10);
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @os.l
    public static final HashSet<Short> By(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return (HashSet) qy(sArr, new HashSet(c1.j(sArr.length)));
    }

    @os.l
    public static final Iterable<s0<Double>> Bz(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return new t0(new z(dArr));
    }

    @os.l
    public static final Iterable<Short> C5(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return sArr.length == 0 ? k0.INSTANCE : new c(sArr);
    }

    @os.l
    public static final <K, M extends Map<? super K, ? super Short>> M C6(@os.l short[] sArr, @os.l M m10, @os.l jn.l<? super Short, ? extends K> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (short s10 : sArr) {
            m10.put(lVar.invoke(Short.valueOf(s10)), Short.valueOf(s10));
        }
        return m10;
    }

    @an.f
    public static final byte C7(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return bArr[1];
    }

    public static final int C8(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int i10 = 0;
        for (float f10 : fArr) {
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @os.l
    public static final List<Long> C9(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iVe = ve(jArr); -1 < iVe; iVe--) {
            if (!lVar.invoke(Long.valueOf(jArr[iVe])).booleanValue()) {
                return Ax(jArr, iVe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <R> List<lm.t0<Boolean, R>> CA(@os.l boolean[] zArr, @os.l Iterable<? extends R> iterable) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(iterable, "other");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(Boolean.valueOf(zArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Float>> C Ca(@os.l float[] fArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Float, Boolean> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "predicate");
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            float f10 = fArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Float.valueOf(f10)).booleanValue()) {
                c10.add(Float.valueOf(f10));
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @an.f
    public static final Long Cb(long[] jArr, jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                long j10 = jArr[length];
                if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                    return Long.valueOf(j10);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterable")
    @lm.f1(version = "1.4")
    public static final <R> List<R> Cc(double[] dArr, jn.p<? super Integer, ? super Double, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), Double.valueOf(dArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R Cd(@os.l long[] jArr, R r10, @os.l jn.p<? super Long, ? super R, ? extends R> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (int iVe = ve(jArr); iVe >= 0; iVe--) {
            r10 = pVar.invoke(Long.valueOf(jArr[iVe]), r10);
        }
        return r10;
    }

    @an.f
    public static final float Ce(float[] fArr, int i10, jn.l<? super Integer, Float> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > te(fArr)) ? lVar.invoke(Integer.valueOf(i10)).floatValue() : fArr[i10];
    }

    public static int Cf(@os.l byte[] bArr, byte b10) {
        kn.l0.p(bArr, "<this>");
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (b10 == bArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @an.f
    public static final boolean Cg(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return !(sArr.length == 0);
    }

    public static short Ch(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[xe(sArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Ci(@os.l char[] cArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Character, ? extends R> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), Character.valueOf(cArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> float Cj(T[] tArr, jn.l<? super T, Float> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(tArr[0]).floatValue();
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(tArr[it.nextInt()]).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Ck(int[] iArr, Comparator<? super R> comparator, jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Integer.valueOf(iArr[0]));
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> byte Cl(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        int iQe = qe(bArr);
        if (iQe == 0) {
            return b10;
        }
        R rInvoke = lVar.invoke(Byte.valueOf(b10));
        v0 v0VarA = nm.o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte b11 = bArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Byte.valueOf(b11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                b10 = b11;
                rInvoke = rInvoke2;
            }
        }
        return b10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double Cm(short[] sArr, jn.l<? super Short, Double> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Short.valueOf(sArr[0])).doubleValue();
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Short.valueOf(sArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Double Cn(@os.l double[] dArr, @os.l Comparator<? super Double> comparator) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            double d11 = dArr[it.nextInt()];
            if (comparator.compare(Double.valueOf(d10), Double.valueOf(d11)) > 0) {
                d10 = d11;
            }
        }
        return Double.valueOf(d10);
    }

    @os.l
    public static final lm.t0<List<Byte>, List<Byte>> Co(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b10 : bArr) {
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                arrayList.add(Byte.valueOf(b10));
            } else {
                arrayList2.add(Byte.valueOf(b10));
            }
        }
        return new lm.t0<>(arrayList, arrayList2);
    }

    public static final short Cp(@os.l short[] sArr, @os.l jn.p<? super Short, ? super Short, Short> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (sArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            sShortValue = pVar.invoke(Short.valueOf(sShortValue), Short.valueOf(sArr[it.nextInt()])).shortValue();
        }
        return sShortValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Integer Cq(@os.l int[] iArr, @os.l jn.q<? super Integer, ? super Integer, ? super Integer, Integer> qVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iUe = ue(iArr);
        if (iUe < 0) {
            return null;
        }
        int iIntValue = iArr[iUe];
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            iIntValue = qVar.invoke(Integer.valueOf(i10), Integer.valueOf(iArr[i10]), Integer.valueOf(iIntValue)).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Cr(double[] dArr, R r10, jn.p<? super R, ? super Double, ? extends R> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (dArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r10);
        for (double d10 : dArr) {
            r10 = pVar.invoke(r10, Double.valueOf(d10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Cs(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        Ds(bArr, rn.f.Default);
    }

    @os.m
    public static final <T> T Ct(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        T t10 = null;
        boolean z10 = false;
        for (T t11 : tArr) {
            if (lVar.invoke(t11).booleanValue()) {
                if (z10) {
                    return null;
                }
                z10 = true;
                t10 = t11;
            }
        }
        if (z10) {
            return t10;
        }
        return null;
    }

    @lm.f1(version = "1.4")
    public static final void Cu(@os.l long[] jArr, int i10, int i11) {
        kn.l0.p(jArr, "<this>");
        nm.p.R3(jArr, i10, i11);
        br(jArr, i10, i11);
    }

    @os.l
    public static final List<Integer> Cv(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kn.l0.o(iArrCopyOf, "copyOf(...)");
        nm.p.O3(iArrCopyOf);
        return mr(iArrCopyOf);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfDouble")
    @lm.f1(version = "1.4")
    public static final double Cw(long[] jArr, jn.l<? super Long, Double> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (long j10 : jArr) {
            dDoubleValue += lVar.invoke(Long.valueOf(j10)).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final List<Short> Cx(@os.l short[] sArr, int i10) {
        kn.l0.p(sArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= sArr.length) {
            return Ly(sArr);
        }
        if (i10 == 1) {
            return nm.x.k(Short.valueOf(sArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (short s10 : sArr) {
            arrayList.add(Short.valueOf(s10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @os.l
    public static final HashSet<Boolean> Cy(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return (HashSet) ry(zArr, new HashSet(c1.j(zArr.length)));
    }

    @os.l
    public static final Iterable<s0<Float>> Cz(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return new t0(new y(fArr));
    }

    @os.l
    public static final Iterable<Boolean> D5(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return zArr.length == 0 ? k0.INSTANCE : new h(zArr);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M D6(@os.l short[] sArr, @os.l M m10, @os.l jn.l<? super Short, ? extends K> lVar, @os.l jn.l<? super Short, ? extends V> lVar2) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (short s10 : sArr) {
            m10.put(lVar.invoke(Short.valueOf(s10)), lVar2.invoke(Short.valueOf(s10)));
        }
        return m10;
    }

    @an.f
    public static final char D7(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return cArr[1];
    }

    @an.f
    public static final int D8(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return iArr.length;
    }

    @os.l
    public static final <T> List<T> D9(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iWe = we(tArr); -1 < iWe; iWe--) {
            if (!lVar.invoke(tArr[iWe]).booleanValue()) {
                return Bx(tArr, iWe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <R, V> List<V> DA(@os.l boolean[] zArr, @os.l Iterable<? extends R> iterable, @os.l jn.p<? super Boolean, ? super R, ? extends V> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(iterable, "other");
        kn.l0.p(pVar, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Boolean.valueOf(zArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Integer>> C Da(@os.l int[] iArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Integer, Boolean> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "predicate");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            int i13 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Integer.valueOf(i12)).booleanValue()) {
                c10.add(Integer.valueOf(i12));
            }
            i10++;
            i11 = i13;
        }
        return c10;
    }

    @an.f
    public static final <T> T Db(T[] tArr, jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                T t10 = tArr[length];
                if (lVar.invoke(t10).booleanValue()) {
                    return t10;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterable")
    @lm.f1(version = "1.4")
    public static final <R> List<R> Dc(float[] fArr, jn.p<? super Integer, ? super Float, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), Float.valueOf(fArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R Dd(@os.l T[] tArr, R r10, @os.l jn.p<? super T, ? super R, ? extends R> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (int iWe = we(tArr); iWe >= 0; iWe--) {
            r10 = pVar.invoke(tArr[iWe], r10);
        }
        return r10;
    }

    @an.f
    public static final int De(int[] iArr, int i10, jn.l<? super Integer, Integer> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > ue(iArr)) ? lVar.invoke(Integer.valueOf(i10)).intValue() : iArr[i10];
    }

    public static final int Df(@os.l char[] cArr, char c10) {
        kn.l0.p(cArr, "<this>");
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (c10 == cArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @an.f
    public static final boolean Dg(boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return !(zArr.length == 0);
    }

    public static final short Dh(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                short s10 = sArr[length];
                if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                    return s10;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Di(@os.l double[] dArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Double, ? extends R> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), Double.valueOf(dArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float Dj(short[] sArr, jn.l<? super Short, Float> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Short.valueOf(sArr[0])).floatValue();
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Short.valueOf(sArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Dk(long[] jArr, Comparator<? super R> comparator, jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Long.valueOf(jArr[0]));
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> char Dl(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        int iRe = re(cArr);
        if (iRe == 0) {
            return c10;
        }
        R rInvoke = lVar.invoke(Character.valueOf(c10));
        v0 v0VarA = nm.o.a(1, iRe, 1);
        while (v0VarA.hasNext()) {
            char c11 = cArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Character.valueOf(c11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                c10 = c11;
                rInvoke = rInvoke2;
            }
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double Dm(boolean[] zArr, jn.l<? super Boolean, Double> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Boolean.valueOf(zArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Float Dn(@os.l float[] fArr, @os.l Comparator<? super Float> comparator) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            float f11 = fArr[it.nextInt()];
            if (comparator.compare(Float.valueOf(f10), Float.valueOf(f11)) > 0) {
                f10 = f11;
            }
        }
        return Float.valueOf(f10);
    }

    @os.l
    public static final lm.t0<List<Character>, List<Character>> Do(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c10 : cArr) {
            if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                arrayList.add(Character.valueOf(c10));
            } else {
                arrayList2.add(Character.valueOf(c10));
            }
        }
        return new lm.t0<>(arrayList, arrayList2);
    }

    public static final boolean Dp(@os.l boolean[] zArr, @os.l jn.p<? super Boolean, ? super Boolean, Boolean> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (zArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[0];
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            zBooleanValue = pVar.invoke(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[it.nextInt()])).booleanValue();
        }
        return zBooleanValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Long Dq(@os.l long[] jArr, @os.l jn.q<? super Integer, ? super Long, ? super Long, Long> qVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iVe = ve(jArr);
        if (iVe < 0) {
            return null;
        }
        long jLongValue = jArr[iVe];
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            jLongValue = qVar.invoke(Integer.valueOf(i10), Long.valueOf(jArr[i10]), Long.valueOf(jLongValue)).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Dr(float[] fArr, R r10, jn.p<? super R, ? super Float, ? extends R> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (fArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r10);
        for (float f10 : fArr) {
            r10 = pVar.invoke(r10, Float.valueOf(f10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Ds(@os.l byte[] bArr, @os.l rn.f fVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(fVar, "random");
        for (int iQe = qe(bArr); iQe > 0; iQe--) {
            int iNextInt = fVar.nextInt(iQe + 1);
            byte b10 = bArr[iQe];
            bArr[iQe] = bArr[iNextInt];
            bArr[iNextInt] = b10;
        }
    }

    @os.m
    public static final Short Dt(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    public static final <T extends Comparable<? super T>> void Du(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        nm.p.h4(tArr, rm.g.x());
    }

    @os.l
    public static final List<Long> Dv(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kn.l0.o(jArrCopyOf, "copyOf(...)");
        nm.p.Q3(jArrCopyOf);
        return nr(jArrCopyOf);
    }

    @in.i(name = "sumOfDouble")
    public static final double Dw(@os.l Double[] dArr) {
        kn.l0.p(dArr, "<this>");
        double dDoubleValue = 0.0d;
        for (Double d10 : dArr) {
            dDoubleValue += d10.doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final List<Boolean> Dx(@os.l boolean[] zArr, int i10) {
        kn.l0.p(zArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= zArr.length) {
            return My(zArr);
        }
        if (i10 == 1) {
            return nm.x.k(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (boolean z10 : zArr) {
            arrayList.add(Boolean.valueOf(z10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @os.l
    public static final int[] Dy(@os.l Integer[] numArr) {
        kn.l0.p(numArr, "<this>");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    @os.l
    public static final Iterable<s0<Integer>> Dz(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return new t0(new w(iArr));
    }

    @os.l
    public static final gq.m<Byte> E5(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return bArr.length == 0 ? gq.g.f6836a : new k(bArr);
    }

    @os.l
    public static final <K, M extends Map<? super K, ? super Boolean>> M E6(@os.l boolean[] zArr, @os.l M m10, @os.l jn.l<? super Boolean, ? extends K> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (boolean z10 : zArr) {
            m10.put(lVar.invoke(Boolean.valueOf(z10)), Boolean.valueOf(z10));
        }
        return m10;
    }

    @an.f
    public static final double E7(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return dArr[1];
    }

    public static final int E8(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int i10 = 0;
        for (int i11 : iArr) {
            if (lVar.invoke(Integer.valueOf(i11)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @os.l
    public static final List<Short> E9(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iXe = xe(sArr); -1 < iXe; iXe--) {
            if (!lVar.invoke(Short.valueOf(sArr[iXe])).booleanValue()) {
                return Cx(sArr, iXe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <R> List<lm.t0<Boolean, R>> EA(@os.l boolean[] zArr, @os.l R[] rArr) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(rArr, "other");
        int iMin = Math.min(zArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            boolean z10 = zArr[i10];
            arrayList.add(new lm.t0(Boolean.valueOf(z10), rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Long>> C Ea(@os.l long[] jArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Long, Boolean> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "predicate");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            long j10 = jArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Long.valueOf(j10)).booleanValue()) {
                c10.add(Long.valueOf(j10));
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @an.f
    public static final Short Eb(short[] sArr, jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                short s10 = sArr[length];
                if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                    return Short.valueOf(s10);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterable")
    @lm.f1(version = "1.4")
    public static final <R> List<R> Ec(int[] iArr, jn.p<? super Integer, ? super Integer, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), Integer.valueOf(iArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R Ed(@os.l short[] sArr, R r10, @os.l jn.p<? super Short, ? super R, ? extends R> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (int iXe = xe(sArr); iXe >= 0; iXe--) {
            r10 = pVar.invoke(Short.valueOf(sArr[iXe]), r10);
        }
        return r10;
    }

    @an.f
    public static final long Ee(long[] jArr, int i10, jn.l<? super Integer, Long> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > ve(jArr)) ? lVar.invoke(Integer.valueOf(i10)).longValue() : jArr[i10];
    }

    @lm.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    @lm.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @lm.a1(expression = "indexOfFirst { it == element }", imports = {}))
    public static final /* synthetic */ int Ef(double[] dArr, double d10) {
        kn.l0.p(dArr, "<this>");
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (d10 == dArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @os.l
    public static final <A extends Appendable> A Eg(@os.l byte[] bArr, @os.l A a10, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Byte, ? extends CharSequence> lVar) throws IOException {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(a10, "buffer");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (byte b10 : bArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                a10.append(lVar.invoke(Byte.valueOf(b10)));
            } else {
                a10.append(String.valueOf((int) b10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final boolean Eh(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[ye(zArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Ei(@os.l float[] fArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Float, ? extends R> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), Float.valueOf(fArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float Ej(boolean[] zArr, jn.l<? super Boolean, Float> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Boolean.valueOf(zArr[0])).floatValue();
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Boolean.valueOf(zArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R> R Ek(T[] tArr, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(tArr[0]);
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(tArr[it.nextInt()]);
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> double El(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d10 = dArr[0];
        int iSe = se(dArr);
        if (iSe == 0) {
            return d10;
        }
        R rInvoke = lVar.invoke(Double.valueOf(d10));
        v0 v0VarA = nm.o.a(1, iSe, 1);
        while (v0VarA.hasNext()) {
            double d11 = dArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Double.valueOf(d11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                d10 = d11;
                rInvoke = rInvoke2;
            }
        }
        return d10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float Em(byte[] bArr, jn.l<? super Byte, Float> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Byte.valueOf(bArr[0])).floatValue();
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Byte.valueOf(bArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Integer En(@os.l int[] iArr, @os.l Comparator<? super Integer> comparator) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int i11 = iArr[it.nextInt()];
            if (comparator.compare(Integer.valueOf(i10), Integer.valueOf(i11)) > 0) {
                i10 = i11;
            }
        }
        return Integer.valueOf(i10);
    }

    @os.l
    public static final lm.t0<List<Double>, List<Double>> Eo(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d10 : dArr) {
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                arrayList.add(Double.valueOf(d10));
            } else {
                arrayList2.add(Double.valueOf(d10));
            }
        }
        return new lm.t0<>(arrayList, arrayList2);
    }

    public static final byte Ep(@os.l byte[] bArr, @os.l jn.q<? super Integer, ? super Byte, ? super Byte, Byte> qVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (bArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            bByteValue = qVar.invoke(Integer.valueOf(iNextInt), Byte.valueOf(bByteValue), Byte.valueOf(bArr[iNextInt])).byteValue();
        }
        return bByteValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <S, T extends S> S Eq(@os.l T[] tArr, @os.l jn.q<? super Integer, ? super T, ? super S, ? extends S> qVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iWe = we(tArr);
        if (iWe < 0) {
            return null;
        }
        S sInvoke = (S) tArr[iWe];
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            sInvoke = qVar.invoke(Integer.valueOf(i10), (Object) tArr[i10], sInvoke);
        }
        return sInvoke;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Er(int[] iArr, R r10, jn.p<? super R, ? super Integer, ? extends R> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (iArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        for (int i10 : iArr) {
            r10 = pVar.invoke(r10, Integer.valueOf(i10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Es(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        Fs(cArr, rn.f.Default);
    }

    @os.m
    public static final Short Et(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Short shValueOf = null;
        boolean z10 = false;
        for (short s10 : sArr) {
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                shValueOf = Short.valueOf(s10);
                z10 = true;
            }
        }
        if (z10) {
            return shValueOf;
        }
        return null;
    }

    @lm.f1(version = "1.4")
    public static final <T extends Comparable<? super T>> void Eu(@os.l T[] tArr, int i10, int i11) {
        kn.l0.p(tArr, "<this>");
        nm.p.i4(tArr, rm.g.x(), i10, i11);
    }

    @os.l
    public static final <T extends Comparable<? super T>> List<T> Ev(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return Mv(tArr, rm.g.x());
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfDouble")
    @lm.f1(version = "1.4")
    public static final <T> double Ew(T[] tArr, jn.l<? super T, Double> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (T t10 : tArr) {
            dDoubleValue += lVar.invoke(t10).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final List<Byte> Ex(@os.l byte[] bArr, int i10) {
        kn.l0.p(bArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = bArr.length;
        if (i10 >= length) {
            return Ey(bArr);
        }
        if (i10 == 1) {
            return nm.x.k(Byte.valueOf(bArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Byte.valueOf(bArr[i11]));
        }
        return arrayList;
    }

    @os.l
    public static List<Byte> Ey(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            return length != 1 ? Oy(bArr) : nm.x.k(Byte.valueOf(bArr[0]));
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final Iterable<s0<Long>> Ez(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return new t0(new x(jArr));
    }

    @os.l
    public static final gq.m<Character> F5(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return cArr.length == 0 ? gq.g.f6836a : new C0300r(cArr);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M F6(@os.l boolean[] zArr, @os.l M m10, @os.l jn.l<? super Boolean, ? extends K> lVar, @os.l jn.l<? super Boolean, ? extends V> lVar2) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (boolean z10 : zArr) {
            m10.put(lVar.invoke(Boolean.valueOf(z10)), lVar2.invoke(Boolean.valueOf(z10)));
        }
        return m10;
    }

    @an.f
    public static final float F7(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return fArr[1];
    }

    @an.f
    public static final int F8(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return jArr.length;
    }

    @os.l
    public static final List<Boolean> F9(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iYe = ye(zArr); -1 < iYe; iYe--) {
            if (!lVar.invoke(Boolean.valueOf(zArr[iYe])).booleanValue()) {
                return Dx(zArr, iYe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <R, V> List<V> FA(@os.l boolean[] zArr, @os.l R[] rArr, @os.l jn.p<? super Boolean, ? super R, ? extends V> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(rArr, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(zArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Boolean.valueOf(zArr[i10]), rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C Fa(@os.l T[] tArr, @os.l C c10, @os.l jn.p<? super Integer, ? super T, Boolean> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "predicate");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            T t10 = tArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), t10).booleanValue()) {
                c10.add(t10);
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    public static byte Fb(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterable")
    @lm.f1(version = "1.4")
    public static final <R> List<R> Fc(long[] jArr, jn.p<? super Integer, ? super Long, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), Long.valueOf(jArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R Fd(@os.l boolean[] zArr, R r10, @os.l jn.p<? super Boolean, ? super R, ? extends R> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (int iYe = ye(zArr); iYe >= 0; iYe--) {
            r10 = pVar.invoke(Boolean.valueOf(zArr[iYe]), r10);
        }
        return r10;
    }

    @an.f
    public static final <T> T Fe(T[] tArr, int i10, jn.l<? super Integer, ? extends T> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > we(tArr)) ? lVar.invoke(Integer.valueOf(i10)) : tArr[i10];
    }

    @lm.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    @lm.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfFirst { it == element }' instead to continue using this behavior, or '.asList().indexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @lm.a1(expression = "indexOfFirst { it == element }", imports = {}))
    public static final /* synthetic */ int Ff(float[] fArr, float f10) {
        kn.l0.p(fArr, "<this>");
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (f10 == fArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @os.l
    public static final <A extends Appendable> A Fg(@os.l char[] cArr, @os.l A a10, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Character, ? extends CharSequence> lVar) throws IOException {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(a10, "buffer");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (char c10 : cArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                a10.append(lVar.invoke(Character.valueOf(c10)));
            } else {
                a10.append(c10);
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final boolean Fh(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                boolean z10 = zArr[length];
                if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                    return z10;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Fi(@os.l int[] iArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Integer, ? extends R> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), Integer.valueOf(iArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Fj(byte[] bArr, jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Byte.valueOf(bArr[0]));
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Fk(short[] sArr, Comparator<? super R> comparator, jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Short.valueOf(sArr[0]));
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> float Fl(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f10 = fArr[0];
        int iTe = te(fArr);
        if (iTe == 0) {
            return f10;
        }
        R rInvoke = lVar.invoke(Float.valueOf(f10));
        v0 v0VarA = nm.o.a(1, iTe, 1);
        while (v0VarA.hasNext()) {
            float f11 = fArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Float.valueOf(f11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                f10 = f11;
                rInvoke = rInvoke2;
            }
        }
        return f10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float Fm(char[] cArr, jn.l<? super Character, Float> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Character.valueOf(cArr[0])).floatValue();
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Character.valueOf(cArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Long Fn(@os.l long[] jArr, @os.l Comparator<? super Long> comparator) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long j11 = jArr[it.nextInt()];
            if (comparator.compare(Long.valueOf(j10), Long.valueOf(j11)) > 0) {
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @os.l
    public static final lm.t0<List<Float>, List<Float>> Fo(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f10 : fArr) {
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                arrayList.add(Float.valueOf(f10));
            } else {
                arrayList2.add(Float.valueOf(f10));
            }
        }
        return new lm.t0<>(arrayList, arrayList2);
    }

    public static final char Fp(@os.l char[] cArr, @os.l jn.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (cArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            cCharValue = qVar.invoke(Integer.valueOf(iNextInt), Character.valueOf(cCharValue), Character.valueOf(cArr[iNextInt])).charValue();
        }
        return cCharValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Short Fq(@os.l short[] sArr, @os.l jn.q<? super Integer, ? super Short, ? super Short, Short> qVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iXe = xe(sArr);
        if (iXe < 0) {
            return null;
        }
        short sShortValue = sArr[iXe];
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sShortValue = qVar.invoke(Integer.valueOf(i10), Short.valueOf(sArr[i10]), Short.valueOf(sShortValue)).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Fr(long[] jArr, R r10, jn.p<? super R, ? super Long, ? extends R> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (jArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        for (long j10 : jArr) {
            r10 = pVar.invoke(r10, Long.valueOf(j10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Fs(@os.l char[] cArr, @os.l rn.f fVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(fVar, "random");
        for (int iRe = re(cArr); iRe > 0; iRe--) {
            int iNextInt = fVar.nextInt(iRe + 1);
            char c10 = cArr[iRe];
            cArr[iRe] = cArr[iNextInt];
            cArr[iNextInt] = c10;
        }
    }

    @os.l
    public static final List<Byte> Ft(@os.l byte[] bArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(iterable, "indices");
        int iB0 = nm.z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf(bArr[it.next().intValue()]));
        }
        return arrayList;
    }

    public static final void Fu(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length > 1) {
            nm.p.W3(sArr);
            er(sArr);
        }
    }

    @os.l
    public static final List<Short> Fv(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kn.l0.o(sArrCopyOf, "copyOf(...)");
        nm.p.W3(sArrCopyOf);
        return pr(sArrCopyOf);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfDouble")
    @lm.f1(version = "1.4")
    public static final double Fw(short[] sArr, jn.l<? super Short, Double> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (short s10 : sArr) {
            dDoubleValue += lVar.invoke(Short.valueOf(s10)).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final List<Character> Fx(@os.l char[] cArr, int i10) {
        kn.l0.p(cArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = cArr.length;
        if (i10 >= length) {
            return Fy(cArr);
        }
        if (i10 == 1) {
            return nm.x.k(Character.valueOf(cArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Character.valueOf(cArr[i11]));
        }
        return arrayList;
    }

    @os.l
    public static List<Character> Fy(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            return length != 1 ? Py(cArr) : nm.x.k(Character.valueOf(cArr[0]));
        }
        return k0.INSTANCE;
    }

    @os.l
    public static <T> Iterable<s0<T>> Fz(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return new t0(new t(tArr));
    }

    @os.l
    public static final gq.m<Double> G5(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return dArr.length == 0 ? gq.g.f6836a : new p(dArr);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M G6(@os.l byte[] bArr, @os.l M m10, @os.l jn.l<? super Byte, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (byte b10 : bArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Byte.valueOf(b10));
            m10.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return m10;
    }

    @an.f
    public static final int G7(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return iArr[1];
    }

    public static final int G8(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int i10 = 0;
        for (long j10 : jArr) {
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @os.l
    public static final List<Byte> G9(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (byte b10 : bArr) {
            if (z10) {
                arrayList.add(Byte.valueOf(b10));
            } else if (!lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                arrayList.add(Byte.valueOf(b10));
                z10 = true;
            }
        }
        return arrayList;
    }

    @os.l
    public static final List<lm.t0<Boolean, Boolean>> GA(@os.l boolean[] zArr, @os.l boolean[] zArr2) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(zArr2, "other");
        int iMin = Math.min(zArr.length, zArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(Boolean.valueOf(zArr[i10]), Boolean.valueOf(zArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Short>> C Ga(@os.l short[] sArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Short, Boolean> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "predicate");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            short s10 = sArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Short.valueOf(s10)).booleanValue()) {
                c10.add(Short.valueOf(s10));
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    public static final byte Gb(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                return b10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterable")
    @lm.f1(version = "1.4")
    public static final <T, R> List<R> Gc(T[] tArr, jn.p<? super Integer, ? super T, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R Gd(@os.l byte[] bArr, R r10, @os.l jn.q<? super Integer, ? super Byte, ? super R, ? extends R> qVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(qVar, "operation");
        for (int iQe = qe(bArr); iQe >= 0; iQe--) {
            r10 = qVar.invoke(Integer.valueOf(iQe), Byte.valueOf(bArr[iQe]), r10);
        }
        return r10;
    }

    @an.f
    public static final short Ge(short[] sArr, int i10, jn.l<? super Integer, Short> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > xe(sArr)) ? lVar.invoke(Integer.valueOf(i10)).shortValue() : sArr[i10];
    }

    public static int Gf(@os.l int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i10 == iArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    @os.l
    public static final <A extends Appendable> A Gg(@os.l double[] dArr, @os.l A a10, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Double, ? extends CharSequence> lVar) throws IOException {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(a10, "buffer");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (double d10 : dArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                a10.append(lVar.invoke(Double.valueOf(d10)));
            } else {
                a10.append(String.valueOf(d10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static int Gh(@os.l byte[] bArr, byte b10) {
        kn.l0.p(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (b10 == bArr[length]) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Gi(@os.l long[] jArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Long, ? extends R> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), Long.valueOf(jArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Gj(char[] cArr, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Character.valueOf(cArr[0]));
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Gk(boolean[] zArr, Comparator<? super R> comparator, jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(zArr[0]));
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> int Gl(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        int iUe = ue(iArr);
        if (iUe == 0) {
            return i10;
        }
        R rInvoke = lVar.invoke(Integer.valueOf(i10));
        v0 v0VarA = nm.o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int i11 = iArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Integer.valueOf(i11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                i10 = i11;
                rInvoke = rInvoke2;
            }
        }
        return i10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float Gm(double[] dArr, jn.l<? super Double, Float> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Double.valueOf(dArr[0])).floatValue();
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Double.valueOf(dArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <T> T Gn(@os.l T[] tArr, @os.l Comparator<? super T> comparator) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            T t11 = tArr[it.nextInt()];
            if (comparator.compare(t10, t11) > 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @os.l
    public static final lm.t0<List<Integer>, List<Integer>> Go(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 : iArr) {
            if (lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                arrayList.add(Integer.valueOf(i10));
            } else {
                arrayList2.add(Integer.valueOf(i10));
            }
        }
        return new lm.t0<>(arrayList, arrayList2);
    }

    public static final double Gp(@os.l double[] dArr, @os.l jn.q<? super Integer, ? super Double, ? super Double, Double> qVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (dArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            dDoubleValue = qVar.invoke(Integer.valueOf(iNextInt), Double.valueOf(dDoubleValue), Double.valueOf(dArr[iNextInt])).doubleValue();
        }
        return dDoubleValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Boolean Gq(@os.l boolean[] zArr, @os.l jn.p<? super Boolean, ? super Boolean, Boolean> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iYe = ye(zArr);
        if (iYe < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[iYe];
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            zBooleanValue = pVar.invoke(Boolean.valueOf(zArr[i10]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @lm.f1(version = "1.4")
    @os.l
    public static final <T, R> List<R> Gr(@os.l T[] tArr, R r10, @os.l jn.p<? super R, ? super T, ? extends R> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (tArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r10);
        for (a1.d dVar : tArr) {
            r10 = pVar.invoke(r10, dVar);
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Gs(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        Hs(dArr, rn.f.Default);
    }

    @os.l
    public static final List<Byte> Gt(@os.l byte[] bArr, @os.l tn.l lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? k0.INSTANCE : nm.p.n(nm.p.f1(bArr, lVar.f15911a, lVar.f15912b + 1));
    }

    @lm.f1(version = "1.4")
    public static final void Gu(@os.l short[] sArr, int i10, int i11) {
        kn.l0.p(sArr, "<this>");
        nm.p.X3(sArr, i10, i11);
        fr(sArr, i10, i11);
    }

    @os.l
    public static final List<Byte> Gv(@os.l byte[] bArr, @os.l Comparator<? super Byte> comparator) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(comparator, "comparator");
        Byte[] bArrN4 = nm.p.N4(bArr);
        nm.p.h4(bArrN4, comparator);
        return nm.p.t(bArrN4);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfDouble")
    @lm.f1(version = "1.4")
    public static final double Gw(boolean[] zArr, jn.l<? super Boolean, Double> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (boolean z10 : zArr) {
            dDoubleValue += lVar.invoke(Boolean.valueOf(z10)).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final List<Double> Gx(@os.l double[] dArr, int i10) {
        kn.l0.p(dArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = dArr.length;
        if (i10 >= length) {
            return Gy(dArr);
        }
        if (i10 == 1) {
            return nm.x.k(Double.valueOf(dArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Double.valueOf(dArr[i11]));
        }
        return arrayList;
    }

    @os.l
    public static List<Double> Gy(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            return length != 1 ? Qy(dArr) : nm.x.k(Double.valueOf(dArr[0]));
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final Iterable<s0<Short>> Gz(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return new t0(new v(sArr));
    }

    @os.l
    public static final gq.m<Float> H5(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return fArr.length == 0 ? gq.g.f6836a : new o(fArr);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M H6(@os.l char[] cArr, @os.l M m10, @os.l jn.l<? super Character, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (char c10 : cArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Character.valueOf(c10));
            m10.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return m10;
    }

    @an.f
    public static final long H7(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return jArr[1];
    }

    @an.f
    public static final <T> int H8(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return tArr.length;
    }

    @os.l
    public static final List<Character> H9(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (char c10 : cArr) {
            if (z10) {
                arrayList.add(Character.valueOf(c10));
            } else if (!lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                arrayList.add(Character.valueOf(c10));
                z10 = true;
            }
        }
        return arrayList;
    }

    @os.l
    public static final <V> List<V> HA(@os.l boolean[] zArr, @os.l boolean[] zArr2, @os.l jn.p<? super Boolean, ? super Boolean, ? extends V> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(zArr2, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(zArr.length, zArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Boolean.valueOf(zArr[i10]), Boolean.valueOf(zArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Boolean>> C Ha(@os.l boolean[] zArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Boolean, Boolean> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "predicate");
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            boolean z10 = zArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Boolean.valueOf(z10)).booleanValue()) {
                c10.add(Boolean.valueOf(z10));
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    public static final char Hb(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterable")
    @lm.f1(version = "1.4")
    public static final <R> List<R> Hc(short[] sArr, jn.p<? super Integer, ? super Short, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), Short.valueOf(sArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R Hd(@os.l char[] cArr, R r10, @os.l jn.q<? super Integer, ? super Character, ? super R, ? extends R> qVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(qVar, "operation");
        for (int iRe = re(cArr); iRe >= 0; iRe--) {
            r10 = qVar.invoke(Integer.valueOf(iRe), Character.valueOf(cArr[iRe]), r10);
        }
        return r10;
    }

    @an.f
    public static final boolean He(boolean[] zArr, int i10, jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > ye(zArr)) ? lVar.invoke(Integer.valueOf(i10)).booleanValue() : zArr[i10];
    }

    public static int Hf(@os.l long[] jArr, long j10) {
        kn.l0.p(jArr, "<this>");
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (j10 == jArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @os.l
    public static final <A extends Appendable> A Hg(@os.l float[] fArr, @os.l A a10, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Float, ? extends CharSequence> lVar) throws IOException {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(a10, "buffer");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (float f10 : fArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                a10.append(lVar.invoke(Float.valueOf(f10)));
            } else {
                a10.append(String.valueOf(f10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final int Hh(@os.l char[] cArr, char c10) {
        kn.l0.p(cArr, "<this>");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (c10 == cArr[length]) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C Hi(@os.l T[] tArr, @os.l C c10, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Hj(double[] dArr, jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Double.valueOf(dArr[0]));
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Byte Hk(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte b11 = bArr[it.nextInt()];
            if (b10 < b11) {
                b10 = b11;
            }
        }
        return Byte.valueOf(b10);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> long Hl(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        int iVe = ve(jArr);
        if (iVe == 0) {
            return j10;
        }
        R rInvoke = lVar.invoke(Long.valueOf(j10));
        v0 v0VarA = nm.o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long j11 = jArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Long.valueOf(j11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                j10 = j11;
                rInvoke = rInvoke2;
            }
        }
        return j10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float Hm(float[] fArr, jn.l<? super Float, Float> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Float.valueOf(fArr[0])).floatValue();
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Float.valueOf(fArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Short Hn(@os.l short[] sArr, @os.l Comparator<? super Short> comparator) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short s11 = sArr[it.nextInt()];
            if (comparator.compare(Short.valueOf(s10), Short.valueOf(s11)) > 0) {
                s10 = s11;
            }
        }
        return Short.valueOf(s10);
    }

    @os.l
    public static final lm.t0<List<Long>, List<Long>> Ho(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j10 : jArr) {
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                arrayList.add(Long.valueOf(j10));
            } else {
                arrayList2.add(Long.valueOf(j10));
            }
        }
        return new lm.t0<>(arrayList, arrayList2);
    }

    public static final float Hp(@os.l float[] fArr, @os.l jn.q<? super Integer, ? super Float, ? super Float, Float> qVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (fArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            fFloatValue = qVar.invoke(Integer.valueOf(iNextInt), Float.valueOf(fFloatValue), Float.valueOf(fArr[iNextInt])).floatValue();
        }
        return fFloatValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Byte Hq(@os.l byte[] bArr, @os.l jn.p<? super Byte, ? super Byte, Byte> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iQe = qe(bArr);
        if (iQe < 0) {
            return null;
        }
        byte bByteValue = bArr[iQe];
        for (int i10 = iQe - 1; i10 >= 0; i10--) {
            bByteValue = pVar.invoke(Byte.valueOf(bArr[i10]), Byte.valueOf(bByteValue)).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Hr(short[] sArr, R r10, jn.p<? super R, ? super Short, ? extends R> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (sArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        for (short s10 : sArr) {
            r10 = pVar.invoke(r10, Short.valueOf(s10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Hs(@os.l double[] dArr, @os.l rn.f fVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(fVar, "random");
        for (int iSe = se(dArr); iSe > 0; iSe--) {
            int iNextInt = fVar.nextInt(iSe + 1);
            double d10 = dArr[iSe];
            dArr[iSe] = dArr[iNextInt];
            dArr[iNextInt] = d10;
        }
    }

    @os.l
    public static final List<Character> Ht(@os.l char[] cArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(iterable, "indices");
        int iB0 = nm.z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf(cArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @os.l
    public static final List<Byte> Hu(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        Byte[] bArrN4 = nm.p.N4(bArr);
        nm.p.U3(bArrN4);
        return nm.p.t(bArrN4);
    }

    @os.l
    public static final List<Character> Hv(@os.l char[] cArr, @os.l Comparator<? super Character> comparator) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(comparator, "comparator");
        Character[] chArrO4 = nm.p.O4(cArr);
        nm.p.h4(chArrO4, comparator);
        return nm.p.t(chArrO4);
    }

    @in.i(name = "sumOfFloat")
    public static final float Hw(@os.l Float[] fArr) {
        kn.l0.p(fArr, "<this>");
        float fFloatValue = 0.0f;
        for (Float f10 : fArr) {
            fFloatValue += f10.floatValue();
        }
        return fFloatValue;
    }

    @os.l
    public static final List<Float> Hx(@os.l float[] fArr, int i10) {
        kn.l0.p(fArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = fArr.length;
        if (i10 >= length) {
            return Hy(fArr);
        }
        if (i10 == 1) {
            return nm.x.k(Float.valueOf(fArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Float.valueOf(fArr[i11]));
        }
        return arrayList;
    }

    @os.l
    public static List<Float> Hy(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            return length != 1 ? Ry(fArr) : nm.x.k(Float.valueOf(fArr[0]));
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final Iterable<s0<Boolean>> Hz(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return new t0(new a0(zArr));
    }

    @os.l
    public static final gq.m<Integer> I5(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return iArr.length == 0 ? gq.g.f6836a : new m(iArr);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M I6(@os.l double[] dArr, @os.l M m10, @os.l jn.l<? super Double, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (double d10 : dArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Double.valueOf(d10));
            m10.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return m10;
    }

    @an.f
    public static final <T> T I7(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return tArr[1];
    }

    public static final <T> int I8(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int i10 = 0;
        for (T t10 : tArr) {
            if (lVar.invoke(t10).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @os.l
    public static final List<Double> I9(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (double d10 : dArr) {
            if (z10) {
                arrayList.add(Double.valueOf(d10));
            } else if (!lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                arrayList.add(Double.valueOf(d10));
                z10 = true;
            }
        }
        return arrayList;
    }

    public static final <R> List<R> Ia(Object[] objArr) {
        kn.l0.p(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            kn.l0.P();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final char Ib(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (char c10 : cArr) {
            if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                return c10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterable")
    @lm.f1(version = "1.4")
    public static final <R> List<R> Ic(boolean[] zArr, jn.p<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(arrayList, pVar.invoke(Integer.valueOf(i11), Boolean.valueOf(zArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final <R> R Id(@os.l double[] dArr, R r10, @os.l jn.q<? super Integer, ? super Double, ? super R, ? extends R> qVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(qVar, "operation");
        for (int iSe = se(dArr); iSe >= 0; iSe--) {
            r10 = qVar.invoke(Integer.valueOf(iSe), Double.valueOf(dArr[iSe]), r10);
        }
        return r10;
    }

    @os.m
    public static final Boolean Ie(@os.l boolean[] zArr, int i10) {
        kn.l0.p(zArr, "<this>");
        if (i10 < 0 || i10 > ye(zArr)) {
            return null;
        }
        return Boolean.valueOf(zArr[i10]);
    }

    public static <T> int If(@os.l T[] tArr, T t10) {
        kn.l0.p(tArr, "<this>");
        int i10 = 0;
        if (t10 == null) {
            int length = tArr.length;
            while (i10 < length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i10 < length2) {
            if (kn.l0.g(t10, tArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @os.l
    public static final <A extends Appendable> A Ig(@os.l int[] iArr, @os.l A a10, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Integer, ? extends CharSequence> lVar) throws IOException {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(a10, "buffer");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (int i12 : iArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                a10.append(lVar.invoke(Integer.valueOf(i12)));
            } else {
                a10.append(String.valueOf(i12));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    @lm.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    @lm.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @lm.a1(expression = "indexOfLast { it == element }", imports = {}))
    public static final /* synthetic */ int Ih(double[] dArr, double d10) {
        kn.l0.p(dArr, "<this>");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (d10 == dArr[length]) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Ii(@os.l short[] sArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Short, ? extends R> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), Short.valueOf(sArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Ij(float[] fArr, jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Float.valueOf(fArr[0]));
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Character Ik(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            char c11 = cArr[it.nextInt()];
            if (kn.l0.t(c10, c11) < 0) {
                c10 = c11;
            }
        }
        return Character.valueOf(c10);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T Il(@os.l T[] tArr, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        int iWe = we(tArr);
        if (iWe == 0) {
            return t10;
        }
        R rInvoke = lVar.invoke(t10);
        v0 v0VarA = nm.o.a(1, iWe, 1);
        while (v0VarA.hasNext()) {
            T t11 = tArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(t11);
            if (rInvoke.compareTo(rInvoke2) > 0) {
                t10 = t11;
                rInvoke = rInvoke2;
            }
        }
        return t10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float Im(int[] iArr, jn.l<? super Integer, Float> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Integer.valueOf(iArr[0])).floatValue();
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Integer.valueOf(iArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final byte In(@os.l byte[] bArr, @os.l Comparator<? super Byte> comparator) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte b11 = bArr[it.nextInt()];
            if (comparator.compare(Byte.valueOf(b10), Byte.valueOf(b11)) > 0) {
                b10 = b11;
            }
        }
        return b10;
    }

    @os.l
    public static final <T> lm.t0<List<T>, List<T>> Io(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t10 : tArr) {
            if (lVar.invoke(t10).booleanValue()) {
                arrayList.add(t10);
            } else {
                arrayList2.add(t10);
            }
        }
        return new lm.t0<>(arrayList, arrayList2);
    }

    public static final int Ip(@os.l int[] iArr, @os.l jn.q<? super Integer, ? super Integer, ? super Integer, Integer> qVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (iArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            iIntValue = qVar.invoke(Integer.valueOf(iNextInt), Integer.valueOf(iIntValue), Integer.valueOf(iArr[iNextInt])).intValue();
        }
        return iIntValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Character Iq(@os.l char[] cArr, @os.l jn.p<? super Character, ? super Character, Character> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iRe = re(cArr);
        if (iRe < 0) {
            return null;
        }
        char cCharValue = cArr[iRe];
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            cCharValue = pVar.invoke(Character.valueOf(cArr[i10]), Character.valueOf(cCharValue)).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Ir(boolean[] zArr, R r10, jn.p<? super R, ? super Boolean, ? extends R> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (zArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r10);
        for (boolean z10 : zArr) {
            r10 = pVar.invoke(r10, Boolean.valueOf(z10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Is(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        Js(fArr, rn.f.Default);
    }

    @os.l
    public static final List<Character> It(@os.l char[] cArr, @os.l tn.l lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? k0.INSTANCE : nm.p.o(nm.p.g1(cArr, lVar.f15911a, lVar.f15912b + 1));
    }

    @os.l
    public static final List<Character> Iu(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        Character[] chArrO4 = nm.p.O4(cArr);
        nm.p.U3(chArrO4);
        return nm.p.t(chArrO4);
    }

    @os.l
    public static final List<Double> Iv(@os.l double[] dArr, @os.l Comparator<? super Double> comparator) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(comparator, "comparator");
        Double[] dArrP4 = nm.p.P4(dArr);
        nm.p.h4(dArrP4, comparator);
        return nm.p.t(dArrP4);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfInt")
    @lm.f1(version = "1.4")
    public static final int Iw(byte[] bArr, jn.l<? super Byte, Integer> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (byte b10 : bArr) {
            iIntValue += lVar.invoke(Byte.valueOf(b10)).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final List<Integer> Ix(@os.l int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = iArr.length;
        if (i10 >= length) {
            return Iy(iArr);
        }
        if (i10 == 1) {
            return nm.x.k(Integer.valueOf(iArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Integer.valueOf(iArr[i11]));
        }
        return arrayList;
    }

    @os.l
    public static List<Integer> Iy(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            return length != 1 ? Sy(iArr) : nm.x.k(Integer.valueOf(iArr[0]));
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <R> List<lm.t0<Byte, R>> Iz(@os.l byte[] bArr, @os.l Iterable<? extends R> iterable) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(iterable, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(Byte.valueOf(bArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final gq.m<Long> J5(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return jArr.length == 0 ? gq.g.f6836a : new n(jArr);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M J6(@os.l float[] fArr, @os.l M m10, @os.l jn.l<? super Float, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (float f10 : fArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Float.valueOf(f10));
            m10.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return m10;
    }

    @an.f
    public static final short J7(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return sArr[1];
    }

    @an.f
    public static final int J8(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return sArr.length;
    }

    @os.l
    public static final List<Float> J9(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (float f10 : fArr) {
            if (z10) {
                arrayList.add(Float.valueOf(f10));
            } else if (!lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                arrayList.add(Float.valueOf(f10));
                z10 = true;
            }
        }
        return arrayList;
    }

    public static final <R, C extends Collection<? super R>> C Ja(Object[] objArr, C c10) {
        kn.l0.p(objArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (Object obj : objArr) {
            kn.l0.P();
            if (obj != null) {
                c10.add(obj);
            }
        }
        return c10;
    }

    public static final double Jb(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @lm.f1(version = "1.4")
    public static final <R, C extends Collection<? super R>> C Jc(byte[] bArr, C c10, jn.p<? super Integer, ? super Byte, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), Byte.valueOf(bArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    public static final <R> R Jd(@os.l float[] fArr, R r10, @os.l jn.q<? super Integer, ? super Float, ? super R, ? extends R> qVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(qVar, "operation");
        for (int iTe = te(fArr); iTe >= 0; iTe--) {
            r10 = qVar.invoke(Integer.valueOf(iTe), Float.valueOf(fArr[iTe]), r10);
        }
        return r10;
    }

    @os.m
    public static final Byte Je(@os.l byte[] bArr, int i10) {
        kn.l0.p(bArr, "<this>");
        if (i10 < 0 || i10 > qe(bArr)) {
            return null;
        }
        return Byte.valueOf(bArr[i10]);
    }

    public static int Jf(@os.l short[] sArr, short s10) {
        kn.l0.p(sArr, "<this>");
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (s10 == sArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @os.l
    public static final <A extends Appendable> A Jg(@os.l long[] jArr, @os.l A a10, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Long, ? extends CharSequence> lVar) throws IOException {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(a10, "buffer");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (long j10 : jArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                a10.append(lVar.invoke(Long.valueOf(j10)));
            } else {
                a10.append(String.valueOf(j10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    @lm.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    @lm.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'indexOfLast { it == element }' instead to continue using this behavior, or '.asList().lastIndexOf(element: T)' to get the same search behavior as in a list.", replaceWith = @lm.a1(expression = "indexOfLast { it == element }", imports = {}))
    public static final /* synthetic */ int Jh(float[] fArr, float f10) {
        kn.l0.p(fArr, "<this>");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (f10 == fArr[length]) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Ji(@os.l boolean[] zArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Boolean, ? extends R> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            c10.add(pVar.invoke(Integer.valueOf(i11), Boolean.valueOf(zArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Jj(int[] iArr, jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Integer.valueOf(iArr[0]));
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <T extends Comparable<? super T>> T Jk(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            T t11 = tArr[it.nextInt()];
            if (t10.compareTo(t11) < 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> short Jl(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        int iXe = xe(sArr);
        if (iXe == 0) {
            return s10;
        }
        R rInvoke = lVar.invoke(Short.valueOf(s10));
        v0 v0VarA = nm.o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short s11 = sArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Short.valueOf(s11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                s10 = s11;
                rInvoke = rInvoke2;
            }
        }
        return s10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float Jm(long[] jArr, jn.l<? super Long, Float> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Long.valueOf(jArr[0])).floatValue();
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Long.valueOf(jArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final char Jn(@os.l char[] cArr, @os.l Comparator<? super Character> comparator) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            char c11 = cArr[it.nextInt()];
            if (comparator.compare(Character.valueOf(c10), Character.valueOf(c11)) > 0) {
                c10 = c11;
            }
        }
        return c10;
    }

    @os.l
    public static final lm.t0<List<Short>, List<Short>> Jo(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s10 : sArr) {
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                arrayList.add(Short.valueOf(s10));
            } else {
                arrayList2.add(Short.valueOf(s10));
            }
        }
        return new lm.t0<>(arrayList, arrayList2);
    }

    public static final long Jp(@os.l long[] jArr, @os.l jn.q<? super Integer, ? super Long, ? super Long, Long> qVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (jArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            jLongValue = qVar.invoke(Integer.valueOf(iNextInt), Long.valueOf(jLongValue), Long.valueOf(jArr[iNextInt])).longValue();
        }
        return jLongValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Double Jq(@os.l double[] dArr, @os.l jn.p<? super Double, ? super Double, Double> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iSe = se(dArr);
        if (iSe < 0) {
            return null;
        }
        double dDoubleValue = dArr[iSe];
        for (int i10 = iSe - 1; i10 >= 0; i10--) {
            dDoubleValue = pVar.invoke(Double.valueOf(dArr[i10]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Jr(byte[] bArr, R r10, jn.q<? super Integer, ? super R, ? super Byte, ? extends R> qVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (bArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Byte.valueOf(bArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Js(@os.l float[] fArr, @os.l rn.f fVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(fVar, "random");
        for (int iTe = te(fArr); iTe > 0; iTe--) {
            int iNextInt = fVar.nextInt(iTe + 1);
            float f10 = fArr[iTe];
            fArr[iTe] = fArr[iNextInt];
            fArr[iNextInt] = f10;
        }
    }

    @os.l
    public static final List<Double> Jt(@os.l double[] dArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(iterable, "indices");
        int iB0 = nm.z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Double.valueOf(dArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @os.l
    public static final List<Double> Ju(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        Double[] dArrP4 = nm.p.P4(dArr);
        nm.p.U3(dArrP4);
        return nm.p.t(dArrP4);
    }

    @os.l
    public static final List<Float> Jv(@os.l float[] fArr, @os.l Comparator<? super Float> comparator) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(comparator, "comparator");
        Float[] fArrQ4 = nm.p.Q4(fArr);
        nm.p.h4(fArrQ4, comparator);
        return nm.p.t(fArrQ4);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfInt")
    @lm.f1(version = "1.4")
    public static final int Jw(char[] cArr, jn.l<? super Character, Integer> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (char c10 : cArr) {
            iIntValue += lVar.invoke(Character.valueOf(c10)).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final List<Long> Jx(@os.l long[] jArr, int i10) {
        kn.l0.p(jArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = jArr.length;
        if (i10 >= length) {
            return Jy(jArr);
        }
        if (i10 == 1) {
            return nm.x.k(Long.valueOf(jArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Long.valueOf(jArr[i11]));
        }
        return arrayList;
    }

    @os.l
    public static List<Long> Jy(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            return length != 1 ? Ty(jArr) : nm.x.k(Long.valueOf(jArr[0]));
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <R, V> List<V> Jz(@os.l byte[] bArr, @os.l Iterable<? extends R> iterable, @os.l jn.p<? super Byte, ? super R, ? extends V> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(iterable, "other");
        kn.l0.p(pVar, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Byte.valueOf(bArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static <T> gq.m<T> K5(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return tArr.length == 0 ? gq.g.f6836a : new j(tArr);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M K6(@os.l int[] iArr, @os.l M m10, @os.l jn.l<? super Integer, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (int i10 : iArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Integer.valueOf(i10));
            m10.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return m10;
    }

    @an.f
    public static final boolean K7(boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return zArr[1];
    }

    public static final int K8(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int i10 = 0;
        for (short s10 : sArr) {
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @os.l
    public static final List<Integer> K9(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (int i10 : iArr) {
            if (z10) {
                arrayList.add(Integer.valueOf(i10));
            } else if (!lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                arrayList.add(Integer.valueOf(i10));
                z10 = true;
            }
        }
        return arrayList;
    }

    @os.l
    public static final List<Byte> Ka(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            if (!lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                arrayList.add(Byte.valueOf(b10));
            }
        }
        return arrayList;
    }

    public static final double Kb(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (double d10 : dArr) {
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                return d10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @lm.f1(version = "1.4")
    public static final <R, C extends Collection<? super R>> C Kc(char[] cArr, C c10, jn.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), Character.valueOf(cArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    public static final <R> R Kd(@os.l int[] iArr, R r10, @os.l jn.q<? super Integer, ? super Integer, ? super R, ? extends R> qVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(qVar, "operation");
        for (int iUe = ue(iArr); iUe >= 0; iUe--) {
            r10 = qVar.invoke(Integer.valueOf(iUe), Integer.valueOf(iArr[iUe]), r10);
        }
        return r10;
    }

    @os.m
    public static final Character Ke(@os.l char[] cArr, int i10) {
        kn.l0.p(cArr, "<this>");
        if (i10 < 0 || i10 > re(cArr)) {
            return null;
        }
        return Character.valueOf(cArr[i10]);
    }

    public static final int Kf(@os.l boolean[] zArr, boolean z10) {
        kn.l0.p(zArr, "<this>");
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (z10 == zArr[i10]) {
                return i10;
            }
        }
        return -1;
    }

    @os.l
    public static final <T, A extends Appendable> A Kg(@os.l T[] tArr, @os.l A a10, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super T, ? extends CharSequence> lVar) throws IOException {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(a10, "buffer");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (T t10 : tArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            jq.w.b(a10, t10, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static int Kh(@os.l int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i11 = length - 1;
                if (i10 == iArr[length]) {
                    return length;
                }
                if (i11 >= 0) {
                    length = i11;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final <T, R> List<R> Ki(@os.l T[] tArr, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            R rInvoke = lVar.invoke(t10);
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Kj(long[] jArr, jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Long.valueOf(jArr[0]));
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Double Kk(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dMax = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            dMax = Math.max(dMax, dArr[it.nextInt()]);
        }
        return Double.valueOf(dMax);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minByOrThrow")
    public static final <R extends Comparable<? super R>> boolean Kl(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z10 = zArr[0];
        int iYe = ye(zArr);
        if (iYe == 0) {
            return z10;
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(z10));
        v0 v0VarA = nm.o.a(1, iYe, 1);
        while (v0VarA.hasNext()) {
            boolean z11 = zArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Boolean.valueOf(z11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                z10 = z11;
                rInvoke = rInvoke2;
            }
        }
        return z10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> Float Km(T[] tArr, jn.l<? super T, Float> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(tArr[0]).floatValue();
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(tArr[it.nextInt()]).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final double Kn(@os.l double[] dArr, @os.l Comparator<? super Double> comparator) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d10 = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            double d11 = dArr[it.nextInt()];
            if (comparator.compare(Double.valueOf(d10), Double.valueOf(d11)) > 0) {
                d10 = d11;
            }
        }
        return d10;
    }

    @os.l
    public static final lm.t0<List<Boolean>, List<Boolean>> Ko(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z10 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z10));
            } else {
                arrayList2.add(Boolean.valueOf(z10));
            }
        }
        return new lm.t0<>(arrayList, arrayList2);
    }

    public static final <S, T extends S> S Kp(@os.l T[] tArr, @os.l jn.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sInvoke = (S) tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            sInvoke = qVar.invoke(Integer.valueOf(iNextInt), sInvoke, (Object) tArr[iNextInt]);
        }
        return sInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Float Kq(@os.l float[] fArr, @os.l jn.p<? super Float, ? super Float, Float> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iTe = te(fArr);
        if (iTe < 0) {
            return null;
        }
        float fFloatValue = fArr[iTe];
        for (int i10 = iTe - 1; i10 >= 0; i10--) {
            fFloatValue = pVar.invoke(Float.valueOf(fArr[i10]), Float.valueOf(fFloatValue)).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Kr(char[] cArr, R r10, jn.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (cArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r10);
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Character.valueOf(cArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Ks(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        Ls(iArr, rn.f.Default);
    }

    @os.l
    public static final List<Double> Kt(@os.l double[] dArr, @os.l tn.l lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? k0.INSTANCE : nm.p.p(nm.p.h1(dArr, lVar.f15911a, lVar.f15912b + 1));
    }

    @os.l
    public static final List<Float> Ku(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        Float[] fArrQ4 = nm.p.Q4(fArr);
        nm.p.U3(fArrQ4);
        return nm.p.t(fArrQ4);
    }

    @os.l
    public static final List<Integer> Kv(@os.l int[] iArr, @os.l Comparator<? super Integer> comparator) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(comparator, "comparator");
        Integer[] numArrR4 = nm.p.R4(iArr);
        nm.p.h4(numArrR4, comparator);
        return nm.p.t(numArrR4);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfInt")
    @lm.f1(version = "1.4")
    public static final int Kw(double[] dArr, jn.l<? super Double, Integer> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (double d10 : dArr) {
            iIntValue += lVar.invoke(Double.valueOf(d10)).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final <T> List<T> Kx(@os.l T[] tArr, int i10) {
        kn.l0.p(tArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = tArr.length;
        if (i10 >= length) {
            return Ky(tArr);
        }
        if (i10 == 1) {
            return nm.x.k(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(tArr[i11]);
        }
        return arrayList;
    }

    @os.l
    public static <T> List<T> Ky(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? Uy(tArr) : nm.x.k(tArr[0]);
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final List<lm.t0<Byte, Byte>> Kz(@os.l byte[] bArr, @os.l byte[] bArr2) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(bArr2, "other");
        int iMin = Math.min(bArr.length, bArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(Byte.valueOf(bArr[i10]), Byte.valueOf(bArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final gq.m<Short> L5(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return sArr.length == 0 ? gq.g.f6836a : new l(sArr);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M L6(@os.l long[] jArr, @os.l M m10, @os.l jn.l<? super Long, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (long j10 : jArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Long.valueOf(j10));
            m10.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return m10;
    }

    @an.f
    public static final byte L7(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return bArr[2];
    }

    @an.f
    public static final int L8(boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return zArr.length;
    }

    @os.l
    public static final List<Long> L9(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (long j10 : jArr) {
            if (z10) {
                arrayList.add(Long.valueOf(j10));
            } else if (!lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                arrayList.add(Long.valueOf(j10));
                z10 = true;
            }
        }
        return arrayList;
    }

    @os.l
    public static final List<Character> La(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c10 : cArr) {
            if (!lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                arrayList.add(Character.valueOf(c10));
            }
        }
        return arrayList;
    }

    public static final float Lb(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @lm.f1(version = "1.4")
    public static final <R, C extends Collection<? super R>> C Lc(double[] dArr, C c10, jn.p<? super Integer, ? super Double, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), Double.valueOf(dArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    public static final <R> R Ld(@os.l long[] jArr, R r10, @os.l jn.q<? super Integer, ? super Long, ? super R, ? extends R> qVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(qVar, "operation");
        for (int iVe = ve(jArr); iVe >= 0; iVe--) {
            r10 = qVar.invoke(Integer.valueOf(iVe), Long.valueOf(jArr[iVe]), r10);
        }
        return r10;
    }

    @os.m
    public static final Double Le(@os.l double[] dArr, int i10) {
        kn.l0.p(dArr, "<this>");
        if (i10 < 0 || i10 > se(dArr)) {
            return null;
        }
        return Double.valueOf(dArr[i10]);
    }

    public static final int Lf(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (lVar.invoke(Byte.valueOf(bArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @os.l
    public static final <A extends Appendable> A Lg(@os.l short[] sArr, @os.l A a10, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Short, ? extends CharSequence> lVar) throws IOException {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(a10, "buffer");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (short s10 : sArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                a10.append(lVar.invoke(Short.valueOf(s10)));
            } else {
                a10.append(String.valueOf((int) s10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static int Lh(@os.l long[] jArr, long j10) {
        kn.l0.p(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (j10 == jArr[length]) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C Li(@os.l T[] tArr, @os.l C c10, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (T t10 : tArr) {
            R rInvoke = lVar.invoke(t10);
            if (rInvoke != null) {
                c10.add(rInvoke);
            }
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R Lj(T[] tArr, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(tArr[0]);
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(tArr[it.nextInt()]);
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Double Lk(@os.l Double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        v0 it = new tn.l(1, we(dArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, dArr[it.nextInt()].doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double Ll(byte[] bArr, jn.l<? super Byte, Double> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Byte.valueOf(bArr[0])).doubleValue();
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Byte.valueOf(bArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float Lm(short[] sArr, jn.l<? super Short, Float> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Short.valueOf(sArr[0])).floatValue();
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Short.valueOf(sArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final float Ln(@os.l float[] fArr, @os.l Comparator<? super Float> comparator) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f10 = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            float f11 = fArr[it.nextInt()];
            if (comparator.compare(Float.valueOf(f10), Float.valueOf(f11)) > 0) {
                f10 = f11;
            }
        }
        return f10;
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final byte Lo(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return Mo(bArr, rn.f.Default);
    }

    public static final short Lp(@os.l short[] sArr, @os.l jn.q<? super Integer, ? super Short, ? super Short, Short> qVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (sArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            sShortValue = qVar.invoke(Integer.valueOf(iNextInt), Short.valueOf(sShortValue), Short.valueOf(sArr[iNextInt])).shortValue();
        }
        return sShortValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Integer Lq(@os.l int[] iArr, @os.l jn.p<? super Integer, ? super Integer, Integer> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iUe = ue(iArr);
        if (iUe < 0) {
            return null;
        }
        int iIntValue = iArr[iUe];
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            iIntValue = pVar.invoke(Integer.valueOf(iArr[i10]), Integer.valueOf(iIntValue)).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Lr(double[] dArr, R r10, jn.q<? super Integer, ? super R, ? super Double, ? extends R> qVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (dArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r10);
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Double.valueOf(dArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Ls(@os.l int[] iArr, @os.l rn.f fVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(fVar, "random");
        for (int iUe = ue(iArr); iUe > 0; iUe--) {
            int iNextInt = fVar.nextInt(iUe + 1);
            int i10 = iArr[iUe];
            iArr[iUe] = iArr[iNextInt];
            iArr[iNextInt] = i10;
        }
    }

    @os.l
    public static final List<Float> Lt(@os.l float[] fArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(iterable, "indices");
        int iB0 = nm.z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(fArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @os.l
    public static final List<Integer> Lu(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        Integer[] numArrR4 = nm.p.R4(iArr);
        nm.p.U3(numArrR4);
        return nm.p.t(numArrR4);
    }

    @os.l
    public static final List<Long> Lv(@os.l long[] jArr, @os.l Comparator<? super Long> comparator) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(comparator, "comparator");
        Long[] lArrS4 = nm.p.S4(jArr);
        nm.p.h4(lArrS4, comparator);
        return nm.p.t(lArrS4);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfInt")
    @lm.f1(version = "1.4")
    public static final int Lw(float[] fArr, jn.l<? super Float, Integer> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (float f10 : fArr) {
            iIntValue += lVar.invoke(Float.valueOf(f10)).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final List<Short> Lx(@os.l short[] sArr, int i10) {
        kn.l0.p(sArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = sArr.length;
        if (i10 >= length) {
            return Ly(sArr);
        }
        if (i10 == 1) {
            return nm.x.k(Short.valueOf(sArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Short.valueOf(sArr[i11]));
        }
        return arrayList;
    }

    @os.l
    public static List<Short> Ly(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        int length = sArr.length;
        if (length != 0) {
            return length != 1 ? Vy(sArr) : nm.x.k(Short.valueOf(sArr[0]));
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <V> List<V> Lz(@os.l byte[] bArr, @os.l byte[] bArr2, @os.l jn.p<? super Byte, ? super Byte, ? extends V> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(bArr2, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(bArr.length, bArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Byte.valueOf(bArr[i10]), Byte.valueOf(bArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final gq.m<Boolean> M5(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return zArr.length == 0 ? gq.g.f6836a : new q(zArr);
    }

    @os.l
    public static final <T, K, V, M extends Map<? super K, ? super V>> M M6(@os.l T[] tArr, @os.l M m10, @os.l jn.l<? super T, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (T t10 : tArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(t10);
            m10.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return m10;
    }

    @an.f
    public static final char M7(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return cArr[2];
    }

    public static final int M8(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int i10 = 0;
        for (boolean z10 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @os.l
    public static final <T> List<T> M9(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (T t10 : tArr) {
            if (z10) {
                arrayList.add(t10);
            } else if (!lVar.invoke(t10).booleanValue()) {
                arrayList.add(t10);
                z10 = true;
            }
        }
        return arrayList;
    }

    @os.l
    public static final List<Double> Ma(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d10 : dArr) {
            if (!lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                arrayList.add(Double.valueOf(d10));
            }
        }
        return arrayList;
    }

    public static final float Mb(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (float f10 : fArr) {
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                return f10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @lm.f1(version = "1.4")
    public static final <R, C extends Collection<? super R>> C Mc(float[] fArr, C c10, jn.p<? super Integer, ? super Float, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), Float.valueOf(fArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R Md(@os.l T[] tArr, R r10, @os.l jn.q<? super Integer, ? super T, ? super R, ? extends R> qVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(qVar, "operation");
        for (int iWe = we(tArr); iWe >= 0; iWe--) {
            r10 = qVar.invoke(Integer.valueOf(iWe), tArr[iWe], r10);
        }
        return r10;
    }

    @os.m
    public static final Float Me(@os.l float[] fArr, int i10) {
        kn.l0.p(fArr, "<this>");
        if (i10 < 0 || i10 > te(fArr)) {
            return null;
        }
        return Float.valueOf(fArr[i10]);
    }

    public static final int Mf(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (lVar.invoke(Character.valueOf(cArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @os.l
    public static final <A extends Appendable> A Mg(@os.l boolean[] zArr, @os.l A a10, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Boolean, ? extends CharSequence> lVar) throws IOException {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(a10, "buffer");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        a10.append(charSequence2);
        int i11 = 0;
        for (boolean z10 : zArr) {
            i11++;
            if (i11 > 1) {
                a10.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            if (lVar != null) {
                a10.append(lVar.invoke(Boolean.valueOf(z10)));
            } else {
                a10.append(String.valueOf(z10));
            }
        }
        if (i10 >= 0 && i11 > i10) {
            a10.append(charSequence4);
        }
        a10.append(charSequence3);
        return a10;
    }

    public static final <T> int Mh(@os.l T[] tArr, T t10) {
        kn.l0.p(tArr, "<this>");
        if (t10 == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i10 = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i10 >= 0) {
                        length = i10;
                    }
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i11 = length2 - 1;
                    if (kn.l0.g(t10, tArr[length2])) {
                        return length2;
                    }
                    if (i11 < 0) {
                        break;
                    }
                    length2 = i11;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Mi(@os.l byte[] bArr, @os.l C c10, @os.l jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (byte b10 : bArr) {
            c10.add(lVar.invoke(Byte.valueOf(b10)));
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Mj(short[] sArr, jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Short.valueOf(sArr[0]));
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Float Mk(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fMax = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            fMax = Math.max(fMax, fArr[it.nextInt()]);
        }
        return Float.valueOf(fMax);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double Ml(char[] cArr, jn.l<? super Character, Double> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Character.valueOf(cArr[0])).doubleValue();
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Character.valueOf(cArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float Mm(boolean[] zArr, jn.l<? super Boolean, Float> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Boolean.valueOf(zArr[0])).floatValue();
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Boolean.valueOf(zArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final int Mn(@os.l int[] iArr, @os.l Comparator<? super Integer> comparator) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int i11 = iArr[it.nextInt()];
            if (comparator.compare(Integer.valueOf(i10), Integer.valueOf(i11)) > 0) {
                i10 = i11;
            }
        }
        return i10;
    }

    @lm.f1(version = "1.3")
    public static final byte Mo(@os.l byte[] bArr, @os.l rn.f fVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(fVar, "random");
        if (bArr.length != 0) {
            return bArr[fVar.nextInt(bArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final boolean Mp(@os.l boolean[] zArr, @os.l jn.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> qVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (zArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[0];
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            zBooleanValue = qVar.invoke(Integer.valueOf(iNextInt), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[iNextInt])).booleanValue();
        }
        return zBooleanValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Long Mq(@os.l long[] jArr, @os.l jn.p<? super Long, ? super Long, Long> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iVe = ve(jArr);
        if (iVe < 0) {
            return null;
        }
        long jLongValue = jArr[iVe];
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            jLongValue = pVar.invoke(Long.valueOf(jArr[i10]), Long.valueOf(jLongValue)).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Mr(float[] fArr, R r10, jn.q<? super Integer, ? super R, ? super Float, ? extends R> qVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (fArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r10);
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Float.valueOf(fArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Ms(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        Ns(jArr, rn.f.Default);
    }

    @os.l
    public static final List<Float> Mt(@os.l float[] fArr, @os.l tn.l lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? k0.INSTANCE : nm.p.q(nm.p.i1(fArr, lVar.f15911a, lVar.f15912b + 1));
    }

    @os.l
    public static final List<Long> Mu(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        Long[] lArrS4 = nm.p.S4(jArr);
        nm.p.U3(lArrS4);
        return nm.p.t(lArrS4);
    }

    @os.l
    public static <T> List<T> Mv(@os.l T[] tArr, @os.l Comparator<? super T> comparator) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        return nm.p.t(fv(tArr, comparator));
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfInt")
    @lm.f1(version = "1.4")
    public static final int Mw(int[] iArr, jn.l<? super Integer, Integer> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (int i10 : iArr) {
            iIntValue += lVar.invoke(Integer.valueOf(i10)).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final List<Boolean> Mx(@os.l boolean[] zArr, int i10) {
        kn.l0.p(zArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        int length = zArr.length;
        if (i10 >= length) {
            return My(zArr);
        }
        if (i10 == 1) {
            return nm.x.k(Boolean.valueOf(zArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = length - i10; i11 < length; i11++) {
            arrayList.add(Boolean.valueOf(zArr[i11]));
        }
        return arrayList;
    }

    @os.l
    public static List<Boolean> My(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        int length = zArr.length;
        if (length != 0) {
            return length != 1 ? Wy(zArr) : nm.x.k(Boolean.valueOf(zArr[0]));
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <R> List<lm.t0<Byte, R>> Mz(@os.l byte[] bArr, @os.l R[] rArr) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(rArr, "other");
        int iMin = Math.min(bArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            byte b10 = bArr[i10];
            arrayList.add(new lm.t0(Byte.valueOf(b10), rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final <K, V> Map<K, V> N5(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "transform");
        int iJ = c1.j(bArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (byte b10 : bArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Byte.valueOf(b10));
            linkedHashMap.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M N6(@os.l short[] sArr, @os.l M m10, @os.l jn.l<? super Short, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (short s10 : sArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Short.valueOf(s10));
            m10.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return m10;
    }

    @an.f
    public static final double N7(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return dArr[2];
    }

    @os.l
    public static final List<Byte> N8(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return h0.V5(Xy(bArr));
    }

    @os.l
    public static final List<Short> N9(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (short s10 : sArr) {
            if (z10) {
                arrayList.add(Short.valueOf(s10));
            } else if (!lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                arrayList.add(Short.valueOf(s10));
                z10 = true;
            }
        }
        return arrayList;
    }

    @os.l
    public static final List<Float> Na(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f10 : fArr) {
            if (!lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                arrayList.add(Float.valueOf(f10));
            }
        }
        return arrayList;
    }

    public static int Nb(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @lm.f1(version = "1.4")
    public static final <R, C extends Collection<? super R>> C Nc(int[] iArr, C c10, jn.p<? super Integer, ? super Integer, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), Integer.valueOf(iArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    public static final <R> R Nd(@os.l short[] sArr, R r10, @os.l jn.q<? super Integer, ? super Short, ? super R, ? extends R> qVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(qVar, "operation");
        for (int iXe = xe(sArr); iXe >= 0; iXe--) {
            r10 = qVar.invoke(Integer.valueOf(iXe), Short.valueOf(sArr[iXe]), r10);
        }
        return r10;
    }

    @os.m
    public static Integer Ne(@os.l int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        if (i10 < 0 || i10 > ue(iArr)) {
            return null;
        }
        return Integer.valueOf(iArr[i10]);
    }

    public static final int Nf(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (lVar.invoke(Double.valueOf(dArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    public static int Nh(@os.l short[] sArr, short s10) {
        kn.l0.p(sArr, "<this>");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (s10 == sArr[length]) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Ni(@os.l char[] cArr, @os.l C c10, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (char c11 : cArr) {
            c10.add(lVar.invoke(Character.valueOf(c11)));
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Nj(boolean[] zArr, jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(zArr[0]));
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Float Nk(@os.l Float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        v0 it = new tn.l(1, we(fArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, fArr[it.nextInt()].floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double Nl(double[] dArr, jn.l<? super Double, Double> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Double.valueOf(dArr[0])).doubleValue();
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Double.valueOf(dArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Nm(byte[] bArr, Comparator<? super R> comparator, jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Byte.valueOf(bArr[0]));
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final long Nn(@os.l long[] jArr, @os.l Comparator<? super Long> comparator) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long j11 = jArr[it.nextInt()];
            if (comparator.compare(Long.valueOf(j10), Long.valueOf(j11)) > 0) {
                j10 = j11;
            }
        }
        return j10;
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final char No(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return Oo(cArr, rn.f.Default);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Boolean Np(@os.l boolean[] zArr, @os.l jn.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> qVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            zBooleanValue = qVar.invoke(Integer.valueOf(iNextInt), Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[iNextInt])).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final <S, T extends S> S Nq(@os.l T[] tArr, @os.l jn.p<? super T, ? super S, ? extends S> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iWe = we(tArr);
        if (iWe < 0) {
            return null;
        }
        S sInvoke = (S) tArr[iWe];
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            sInvoke = pVar.invoke((Object) tArr[i10], sInvoke);
        }
        return sInvoke;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Nr(int[] iArr, R r10, jn.q<? super Integer, ? super R, ? super Integer, ? extends R> qVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (iArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Integer.valueOf(iArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Ns(@os.l long[] jArr, @os.l rn.f fVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(fVar, "random");
        for (int iVe = ve(jArr); iVe > 0; iVe--) {
            int iNextInt = fVar.nextInt(iVe + 1);
            long j10 = jArr[iVe];
            jArr[iVe] = jArr[iNextInt];
            jArr[iNextInt] = j10;
        }
    }

    @os.l
    public static final List<Integer> Nt(@os.l int[] iArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(iterable, "indices");
        int iB0 = nm.z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(iArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @os.l
    public static final <T extends Comparable<? super T>> List<T> Nu(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return nm.p.t(Vu(tArr));
    }

    @os.l
    public static final List<Short> Nv(@os.l short[] sArr, @os.l Comparator<? super Short> comparator) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(comparator, "comparator");
        Short[] shArrT4 = nm.p.T4(sArr);
        nm.p.h4(shArrT4, comparator);
        return nm.p.t(shArrT4);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfInt")
    @lm.f1(version = "1.4")
    public static final int Nw(long[] jArr, jn.l<? super Long, Integer> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (long j10 : jArr) {
            iIntValue += lVar.invoke(Long.valueOf(j10)).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final List<Byte> Nx(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iQe = qe(bArr); -1 < iQe; iQe--) {
            if (!lVar.invoke(Byte.valueOf(bArr[iQe])).booleanValue()) {
                return f9(bArr, iQe + 1);
            }
        }
        return Ey(bArr);
    }

    @os.l
    public static final long[] Ny(@os.l Long[] lArr) {
        kn.l0.p(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = lArr[i10].longValue();
        }
        return jArr;
    }

    @os.l
    public static final <R, V> List<V> Nz(@os.l byte[] bArr, @os.l R[] rArr, @os.l jn.p<? super Byte, ? super R, ? extends V> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(rArr, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(bArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Byte.valueOf(bArr[i10]), rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final <K, V> Map<K, V> O5(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "transform");
        int iJ = c1.j(cArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (char c10 : cArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Character.valueOf(c10));
            linkedHashMap.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M O6(@os.l boolean[] zArr, @os.l M m10, @os.l jn.l<? super Boolean, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (boolean z10 : zArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Boolean.valueOf(z10));
            m10.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return m10;
    }

    @an.f
    public static final float O7(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return fArr[2];
    }

    @os.l
    public static List<Character> O8(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return h0.V5(Yy(cArr));
    }

    @os.l
    public static final List<Boolean> O9(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        for (boolean z11 : zArr) {
            if (z10) {
                arrayList.add(Boolean.valueOf(z11));
            } else if (!lVar.invoke(Boolean.valueOf(z11)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z11));
                z10 = true;
            }
        }
        return arrayList;
    }

    @os.l
    public static final List<Integer> Oa(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (!lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        return arrayList;
    }

    public static final int Ob(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            if (lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                return i10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @lm.f1(version = "1.4")
    public static final <R, C extends Collection<? super R>> C Oc(long[] jArr, C c10, jn.p<? super Integer, ? super Long, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), Long.valueOf(jArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    public static final <R> R Od(@os.l boolean[] zArr, R r10, @os.l jn.q<? super Integer, ? super Boolean, ? super R, ? extends R> qVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(qVar, "operation");
        for (int iYe = ye(zArr); iYe >= 0; iYe--) {
            r10 = qVar.invoke(Integer.valueOf(iYe), Boolean.valueOf(zArr[iYe]), r10);
        }
        return r10;
    }

    @os.m
    public static final Long Oe(@os.l long[] jArr, int i10) {
        kn.l0.p(jArr, "<this>");
        if (i10 < 0 || i10 > ve(jArr)) {
            return null;
        }
        return Long.valueOf(jArr[i10]);
    }

    public static final int Of(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (lVar.invoke(Float.valueOf(fArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    public static final int Oh(@os.l boolean[] zArr, boolean z10) {
        kn.l0.p(zArr, "<this>");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (z10 == zArr[length]) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Oi(@os.l double[] dArr, @os.l C c10, @os.l jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (double d10 : dArr) {
            c10.add(lVar.invoke(Double.valueOf(d10)));
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Oj(byte[] bArr, jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Byte.valueOf(bArr[0]));
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Integer Ok(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int i11 = iArr[it.nextInt()];
            if (i10 < i11) {
                i10 = i11;
            }
        }
        return Integer.valueOf(i10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double Ol(float[] fArr, jn.l<? super Float, Double> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Float.valueOf(fArr[0])).doubleValue();
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Float.valueOf(fArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Om(char[] cArr, Comparator<? super R> comparator, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Character.valueOf(cArr[0]));
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final <T> T On(@os.l T[] tArr, @os.l Comparator<? super T> comparator) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            T t11 = tArr[it.nextInt()];
            if (comparator.compare(t10, t11) > 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @lm.f1(version = "1.3")
    public static final char Oo(@os.l char[] cArr, @os.l rn.f fVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(fVar, "random");
        if (cArr.length != 0) {
            return cArr[fVar.nextInt(cArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Byte Op(@os.l byte[] bArr, @os.l jn.q<? super Integer, ? super Byte, ? super Byte, Byte> qVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            bByteValue = qVar.invoke(Integer.valueOf(iNextInt), Byte.valueOf(bByteValue), Byte.valueOf(bArr[iNextInt])).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Short Oq(@os.l short[] sArr, @os.l jn.p<? super Short, ? super Short, Short> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iXe = xe(sArr);
        if (iXe < 0) {
            return null;
        }
        short sShortValue = sArr[iXe];
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sShortValue = pVar.invoke(Short.valueOf(sArr[i10]), Short.valueOf(sShortValue)).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Or(long[] jArr, R r10, jn.q<? super Integer, ? super R, ? super Long, ? extends R> qVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (jArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Long.valueOf(jArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final <T> void Os(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        Ps(tArr, rn.f.Default);
    }

    @os.l
    public static final List<Integer> Ot(@os.l int[] iArr, @os.l tn.l lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? k0.INSTANCE : nm.p.r(nm.p.j1(iArr, lVar.f15911a, lVar.f15912b + 1));
    }

    @os.l
    public static final List<Short> Ou(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        Short[] shArrT4 = nm.p.T4(sArr);
        nm.p.U3(shArrT4);
        return nm.p.t(shArrT4);
    }

    @os.l
    public static final List<Boolean> Ov(@os.l boolean[] zArr, @os.l Comparator<? super Boolean> comparator) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(comparator, "comparator");
        Boolean[] boolArrM4 = nm.p.M4(zArr);
        nm.p.h4(boolArrM4, comparator);
        return nm.p.t(boolArrM4);
    }

    @in.i(name = "sumOfInt")
    public static final int Ow(@os.l Integer[] numArr) {
        kn.l0.p(numArr, "<this>");
        int iIntValue = 0;
        for (Integer num : numArr) {
            iIntValue += num.intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final List<Character> Ox(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iRe = re(cArr); -1 < iRe; iRe--) {
            if (!lVar.invoke(Character.valueOf(cArr[iRe])).booleanValue()) {
                return g9(cArr, iRe + 1);
            }
        }
        return Fy(cArr);
    }

    @os.l
    public static final List<Byte> Oy(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b10 : bArr) {
            arrayList.add(Byte.valueOf(b10));
        }
        return arrayList;
    }

    @os.l
    public static final <R> List<lm.t0<Character, R>> Oz(@os.l char[] cArr, @os.l Iterable<? extends R> iterable) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(iterable, "other");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(Character.valueOf(cArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final <K, V> Map<K, V> P5(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "transform");
        int iJ = c1.j(dArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (double d10 : dArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Double.valueOf(d10));
            linkedHashMap.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V> Map<Byte, V> P6(byte[] bArr, jn.l<? super Byte, ? extends V> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "valueSelector");
        int iJ = c1.j(bArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (byte b10 : bArr) {
            linkedHashMap.put(Byte.valueOf(b10), lVar.invoke(Byte.valueOf(b10)));
        }
        return linkedHashMap;
    }

    @an.f
    public static final int P7(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return iArr[2];
    }

    @os.l
    public static final List<Double> P8(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return h0.V5(Zy(dArr));
    }

    @an.f
    public static final byte P9(byte[] bArr, int i10, jn.l<? super Integer, Byte> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > qe(bArr)) ? lVar.invoke(Integer.valueOf(i10)).byteValue() : bArr[i10];
    }

    @os.l
    public static final List<Long> Pa(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            if (!lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                arrayList.add(Long.valueOf(j10));
            }
        }
        return arrayList;
    }

    public static long Pb(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @lm.f1(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C Pc(T[] tArr, C c10, jn.p<? super Integer, ? super T, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return c10;
    }

    public static final void Pd(@os.l byte[] bArr, @os.l jn.l<? super Byte, l2> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (byte b10 : bArr) {
            lVar.invoke(Byte.valueOf(b10));
        }
    }

    @os.m
    public static <T> T Pe(@os.l T[] tArr, int i10) {
        kn.l0.p(tArr, "<this>");
        if (i10 < 0 || i10 > we(tArr)) {
            return null;
        }
        return tArr[i10];
    }

    public static final int Pf(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (lVar.invoke(Integer.valueOf(iArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @os.m
    public static final Boolean Ph(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Pi(@os.l float[] fArr, @os.l C c10, @os.l jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (float f10 : fArr) {
            c10.add(lVar.invoke(Float.valueOf(f10)));
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Pj(char[] cArr, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Character.valueOf(cArr[0]));
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Long Pk(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long j11 = jArr[it.nextInt()];
            if (j10 < j11) {
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double Pl(int[] iArr, jn.l<? super Integer, Double> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Integer.valueOf(iArr[0])).doubleValue();
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Integer.valueOf(iArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Pm(double[] dArr, Comparator<? super R> comparator, jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Double.valueOf(dArr[0]));
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final short Pn(@os.l short[] sArr, @os.l Comparator<? super Short> comparator) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short s11 = sArr[it.nextInt()];
            if (comparator.compare(Short.valueOf(s10), Short.valueOf(s11)) > 0) {
                s10 = s11;
            }
        }
        return s10;
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final double Po(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return Qo(dArr, rn.f.Default);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Character Pp(@os.l char[] cArr, @os.l jn.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            cCharValue = qVar.invoke(Integer.valueOf(iNextInt), Character.valueOf(cCharValue), Character.valueOf(cArr[iNextInt])).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    @os.l
    public static <T> T[] Pq(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        for (T t10 : tArr) {
            if (t10 == null) {
                throw new IllegalArgumentException("null element found in " + tArr + n1.e.f11183c);
            }
        }
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @lm.f1(version = "1.4")
    @os.l
    public static final <T, R> List<R> Pr(@os.l T[] tArr, R r10, @os.l jn.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (tArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r10);
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, tArr[i10]);
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final <T> void Ps(@os.l T[] tArr, @os.l rn.f fVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(fVar, "random");
        for (int iWe = we(tArr); iWe > 0; iWe--) {
            int iNextInt = fVar.nextInt(iWe + 1);
            T t10 = tArr[iWe];
            tArr[iWe] = tArr[iNextInt];
            tArr[iNextInt] = t10;
        }
    }

    @os.l
    public static final List<Long> Pt(@os.l long[] jArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(iterable, "indices");
        int iB0 = nm.z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(jArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @os.l
    public static final byte[] Pu(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kn.l0.o(bArrCopyOf, "copyOf(...)");
        nm.p.G3(bArrCopyOf);
        return bArrCopyOf;
    }

    @os.l
    public static final Set<Byte> Pv(@os.l byte[] bArr, @os.l Iterable<Byte> iterable) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Byte> setXy = Xy(bArr);
        d0.I0(setXy, iterable);
        return setXy;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfInt")
    @lm.f1(version = "1.4")
    public static final <T> int Pw(T[] tArr, jn.l<? super T, Integer> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (T t10 : tArr) {
            iIntValue += lVar.invoke(t10).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final List<Double> Px(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iSe = se(dArr); -1 < iSe; iSe--) {
            if (!lVar.invoke(Double.valueOf(dArr[iSe])).booleanValue()) {
                return h9(dArr, iSe + 1);
            }
        }
        return Gy(dArr);
    }

    @os.l
    public static final List<Character> Py(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c10 : cArr) {
            arrayList.add(Character.valueOf(c10));
        }
        return arrayList;
    }

    @os.l
    public static final <R, V> List<V> Pz(@os.l char[] cArr, @os.l Iterable<? extends R> iterable, @os.l jn.p<? super Character, ? super R, ? extends V> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(iterable, "other");
        kn.l0.p(pVar, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Character.valueOf(cArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final <K, V> Map<K, V> Q5(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "transform");
        int iJ = c1.j(fArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (float f10 : fArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Float.valueOf(f10));
            linkedHashMap.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V> Map<Character, V> Q6(char[] cArr, jn.l<? super Character, ? extends V> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "valueSelector");
        int length = cArr.length;
        if (length > 128) {
            length = 128;
        }
        int iJ = c1.j(length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (char c10 : cArr) {
            linkedHashMap.put(Character.valueOf(c10), lVar.invoke(Character.valueOf(c10)));
        }
        return linkedHashMap;
    }

    @an.f
    public static final long Q7(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return jArr[2];
    }

    @os.l
    public static final List<Float> Q8(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return h0.V5(az(fArr));
    }

    @an.f
    public static final char Q9(char[] cArr, int i10, jn.l<? super Integer, Character> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > re(cArr)) ? lVar.invoke(Integer.valueOf(i10)).charValue() : cArr[i10];
    }

    @os.l
    public static final <T> List<T> Qa(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            if (!lVar.invoke(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public static final long Qb(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                return j10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @lm.f1(version = "1.4")
    public static final <R, C extends Collection<? super R>> C Qc(short[] sArr, C c10, jn.p<? super Integer, ? super Short, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), Short.valueOf(sArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    public static final void Qd(@os.l char[] cArr, @os.l jn.l<? super Character, l2> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (char c10 : cArr) {
            lVar.invoke(Character.valueOf(c10));
        }
    }

    @os.m
    public static final Short Qe(@os.l short[] sArr, int i10) {
        kn.l0.p(sArr, "<this>");
        if (i10 < 0 || i10 > xe(sArr)) {
            return null;
        }
        return Short.valueOf(sArr[i10]);
    }

    public static final int Qf(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (lVar.invoke(Long.valueOf(jArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @os.m
    public static final Boolean Qh(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            boolean z10 = zArr[length];
            if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                return Boolean.valueOf(z10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Qi(@os.l int[] iArr, @os.l C c10, @os.l jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (int i10 : iArr) {
            c10.add(lVar.invoke(Integer.valueOf(i10)));
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Qj(double[] dArr, jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Double.valueOf(dArr[0]));
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Short Qk(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short s11 = sArr[it.nextInt()];
            if (s10 < s11) {
                s10 = s11;
            }
        }
        return Short.valueOf(s10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double Ql(long[] jArr, jn.l<? super Long, Double> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Long.valueOf(jArr[0])).doubleValue();
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Long.valueOf(jArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Qm(float[] fArr, Comparator<? super R> comparator, jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Float.valueOf(fArr[0]));
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minWithOrThrow")
    public static final boolean Qn(@os.l boolean[] zArr, @os.l Comparator<? super Boolean> comparator) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z10 = zArr[0];
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            boolean z11 = zArr[it.nextInt()];
            if (comparator.compare(Boolean.valueOf(z10), Boolean.valueOf(z11)) > 0) {
                z10 = z11;
            }
        }
        return z10;
    }

    @lm.f1(version = "1.3")
    public static final double Qo(@os.l double[] dArr, @os.l rn.f fVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(fVar, "random");
        if (dArr.length != 0) {
            return dArr[fVar.nextInt(dArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Double Qp(@os.l double[] dArr, @os.l jn.q<? super Integer, ? super Double, ? super Double, Double> qVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            dDoubleValue = qVar.invoke(Integer.valueOf(iNextInt), Double.valueOf(dDoubleValue), Double.valueOf(dArr[iNextInt])).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    public static void Qq(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        int length = (bArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iQe = qe(bArr);
        v0 v0VarA = nm.o.a(0, length, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            byte b10 = bArr[iNextInt];
            bArr[iNextInt] = bArr[iQe];
            bArr[iQe] = b10;
            iQe--;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Qr(short[] sArr, R r10, jn.q<? super Integer, ? super R, ? super Short, ? extends R> qVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (sArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Short.valueOf(sArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Qs(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        Rs(sArr, rn.f.Default);
    }

    @os.l
    public static final List<Long> Qt(@os.l long[] jArr, @os.l tn.l lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? k0.INSTANCE : nm.p.s(nm.p.k1(jArr, lVar.f15911a, lVar.f15912b + 1));
    }

    @os.l
    public static final char[] Qu(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kn.l0.o(cArrCopyOf, "copyOf(...)");
        nm.p.I3(cArrCopyOf);
        return cArrCopyOf;
    }

    @os.l
    public static final Set<Character> Qv(@os.l char[] cArr, @os.l Iterable<Character> iterable) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Character> setYy = Yy(cArr);
        d0.I0(setYy, iterable);
        return setYy;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfInt")
    @lm.f1(version = "1.4")
    public static final int Qw(short[] sArr, jn.l<? super Short, Integer> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (short s10 : sArr) {
            iIntValue += lVar.invoke(Short.valueOf(s10)).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final List<Float> Qx(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iTe = te(fArr); -1 < iTe; iTe--) {
            if (!lVar.invoke(Float.valueOf(fArr[iTe])).booleanValue()) {
                return i9(fArr, iTe + 1);
            }
        }
        return Hy(fArr);
    }

    @os.l
    public static final List<Double> Qy(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d10 : dArr) {
            arrayList.add(Double.valueOf(d10));
        }
        return arrayList;
    }

    @os.l
    public static final List<lm.t0<Character, Character>> Qz(@os.l char[] cArr, @os.l char[] cArr2) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(cArr2, "other");
        int iMin = Math.min(cArr.length, cArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(Character.valueOf(cArr[i10]), Character.valueOf(cArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final <K, V> Map<K, V> R5(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "transform");
        int iJ = c1.j(iArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (int i10 : iArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Integer.valueOf(i10));
            linkedHashMap.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V> Map<Double, V> R6(double[] dArr, jn.l<? super Double, ? extends V> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "valueSelector");
        int iJ = c1.j(dArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (double d10 : dArr) {
            linkedHashMap.put(Double.valueOf(d10), lVar.invoke(Double.valueOf(d10)));
        }
        return linkedHashMap;
    }

    @an.f
    public static final <T> T R7(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return tArr[2];
    }

    @os.l
    public static final List<Integer> R8(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return h0.V5(bz(iArr));
    }

    @an.f
    public static final double R9(double[] dArr, int i10, jn.l<? super Integer, Double> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > se(dArr)) ? lVar.invoke(Integer.valueOf(i10)).doubleValue() : dArr[i10];
    }

    @os.l
    public static final List<Short> Ra(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            if (!lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                arrayList.add(Short.valueOf(s10));
            }
        }
        return arrayList;
    }

    public static <T> T Rb(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length != 0) {
            return tArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedIterableTo")
    @lm.f1(version = "1.4")
    public static final <R, C extends Collection<? super R>> C Rc(boolean[] zArr, C c10, jn.p<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.r0(c10, pVar.invoke(Integer.valueOf(i11), Boolean.valueOf(zArr[i10])));
            i10++;
            i11++;
        }
        return c10;
    }

    public static final void Rd(@os.l double[] dArr, @os.l jn.l<? super Double, l2> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (double d10 : dArr) {
            lVar.invoke(Double.valueOf(d10));
        }
    }

    @os.l
    public static final <K> Map<K, List<Byte>> Re(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends K> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b10 : bArr) {
            K kInvoke = lVar.invoke(Byte.valueOf(b10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(Byte.valueOf(b10));
        }
        return linkedHashMap;
    }

    public static final <T> int Rf(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (lVar.invoke(tArr[i10]).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @os.m
    public static final Byte Rh(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Ri(@os.l long[] jArr, @os.l C c10, @os.l jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (long j10 : jArr) {
            c10.add(lVar.invoke(Long.valueOf(j10)));
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Rj(float[] fArr, jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Float.valueOf(fArr[0]));
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final byte Rk(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte b11 = bArr[it.nextInt()];
            if (b10 < b11) {
                b10 = b11;
            }
        }
        return b10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> double Rl(T[] tArr, jn.l<? super T, Double> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(tArr[0]).doubleValue();
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(tArr[it.nextInt()]).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Rm(int[] iArr, Comparator<? super R> comparator, jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Integer.valueOf(iArr[0]));
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean Rn(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return bArr.length == 0;
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final float Ro(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return So(fArr, rn.f.Default);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Float Rp(@os.l float[] fArr, @os.l jn.q<? super Integer, ? super Float, ? super Float, Float> qVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            fFloatValue = qVar.invoke(Integer.valueOf(iNextInt), Float.valueOf(fFloatValue), Float.valueOf(fArr[iNextInt])).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.4")
    public static void Rq(@os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, "<this>");
        nm.c.Companion.d(i10, i11, bArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            bArr[i10] = bArr[i13];
            bArr[i13] = b10;
            i13--;
            i10++;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <R> List<R> Rr(boolean[] zArr, R r10, jn.q<? super Integer, ? super R, ? super Boolean, ? extends R> qVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (zArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r10);
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Boolean.valueOf(zArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Rs(@os.l short[] sArr, @os.l rn.f fVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(fVar, "random");
        for (int iXe = xe(sArr); iXe > 0; iXe--) {
            int iNextInt = fVar.nextInt(iXe + 1);
            short s10 = sArr[iXe];
            sArr[iXe] = sArr[iNextInt];
            sArr[iNextInt] = s10;
        }
    }

    @os.l
    public static final <T> List<T> Rt(@os.l T[] tArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(iterable, "indices");
        int iB0 = nm.z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(tArr[it.next().intValue()]);
        }
        return arrayList;
    }

    @os.l
    public static final double[] Ru(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kn.l0.o(dArrCopyOf, "copyOf(...)");
        nm.p.K3(dArrCopyOf);
        return dArrCopyOf;
    }

    @os.l
    public static final Set<Double> Rv(@os.l double[] dArr, @os.l Iterable<Double> iterable) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Double> setZy = Zy(dArr);
        d0.I0(setZy, iterable);
        return setZy;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfInt")
    @lm.f1(version = "1.4")
    public static final int Rw(boolean[] zArr, jn.l<? super Boolean, Integer> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (boolean z10 : zArr) {
            iIntValue += lVar.invoke(Boolean.valueOf(z10)).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final List<Integer> Rx(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iUe = ue(iArr); -1 < iUe; iUe--) {
            if (!lVar.invoke(Integer.valueOf(iArr[iUe])).booleanValue()) {
                return j9(iArr, iUe + 1);
            }
        }
        return Iy(iArr);
    }

    @os.l
    public static final List<Float> Ry(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f10 : fArr) {
            arrayList.add(Float.valueOf(f10));
        }
        return arrayList;
    }

    @os.l
    public static final <V> List<V> Rz(@os.l char[] cArr, @os.l char[] cArr2, @os.l jn.p<? super Character, ? super Character, ? extends V> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(cArr2, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(cArr.length, cArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Character.valueOf(cArr[i10]), Character.valueOf(cArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final <K, V> Map<K, V> S5(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "transform");
        int iJ = c1.j(jArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (long j10 : jArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Long.valueOf(j10));
            linkedHashMap.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V> Map<Float, V> S6(float[] fArr, jn.l<? super Float, ? extends V> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "valueSelector");
        int iJ = c1.j(fArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (float f10 : fArr) {
            linkedHashMap.put(Float.valueOf(f10), lVar.invoke(Float.valueOf(f10)));
        }
        return linkedHashMap;
    }

    @an.f
    public static final short S7(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return sArr[2];
    }

    @os.l
    public static final List<Long> S8(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return h0.V5(cz(jArr));
    }

    @an.f
    public static final float S9(float[] fArr, int i10, jn.l<? super Integer, Float> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > te(fArr)) ? lVar.invoke(Integer.valueOf(i10)).floatValue() : fArr[i10];
    }

    @os.l
    public static final List<Boolean> Sa(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z10 : zArr) {
            if (!lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z10));
            }
        }
        return arrayList;
    }

    public static final <T> T Sb(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (T t10 : tArr) {
            if (lVar.invoke(t10).booleanValue()) {
                return t10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedSequence")
    @lm.f1(version = "1.4")
    public static final <T, R> List<R> Sc(T[] tArr, jn.p<? super Integer, ? super T, ? extends gq.m<? extends R>> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.q0(arrayList, pVar.invoke(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return arrayList;
    }

    public static final void Sd(@os.l float[] fArr, @os.l jn.l<? super Float, l2> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (float f10 : fArr) {
            lVar.invoke(Float.valueOf(f10));
        }
    }

    @os.l
    public static final <K, V> Map<K, List<V>> Se(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends K> lVar, @os.l jn.l<? super Byte, ? extends V> lVar2) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b10 : bArr) {
            K kInvoke = lVar.invoke(Byte.valueOf(b10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Byte.valueOf(b10)));
        }
        return linkedHashMap;
    }

    public static final int Sf(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (lVar.invoke(Short.valueOf(sArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @os.m
    public static final Byte Sh(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            byte b10 = bArr[length];
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                return Byte.valueOf(b10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C Si(@os.l T[] tArr, @os.l C c10, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (T t10 : tArr) {
            c10.add(lVar.invoke(t10));
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Sj(int[] iArr, jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Integer.valueOf(iArr[0]));
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final char Sk(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            char c11 = cArr[it.nextInt()];
            if (kn.l0.t(c10, c11) < 0) {
                c10 = c11;
            }
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double Sl(short[] sArr, jn.l<? super Short, Double> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Short.valueOf(sArr[0])).doubleValue();
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Short.valueOf(sArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Sm(long[] jArr, Comparator<? super R> comparator, jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Long.valueOf(jArr[0]));
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean Sn(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @lm.f1(version = "1.3")
    public static final float So(@os.l float[] fArr, @os.l rn.f fVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(fVar, "random");
        if (fArr.length != 0) {
            return fArr[fVar.nextInt(fArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Integer Sp(@os.l int[] iArr, @os.l jn.q<? super Integer, ? super Integer, ? super Integer, Integer> qVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            iIntValue = qVar.invoke(Integer.valueOf(iNextInt), Integer.valueOf(iIntValue), Integer.valueOf(iArr[iNextInt])).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    public static final void Sq(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        int length = (cArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iRe = re(cArr);
        v0 v0VarA = nm.o.a(0, length, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            char c10 = cArr[iNextInt];
            cArr[iNextInt] = cArr[iRe];
            cArr[iRe] = c10;
            iRe--;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Byte> Sr(byte[] bArr, jn.p<? super Byte, ? super Byte, Byte> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (bArr.length == 0) {
            return k0.INSTANCE;
        }
        byte bByteValue = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(bByteValue));
        int length = bArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            bByteValue = pVar.invoke(Byte.valueOf(bByteValue), Byte.valueOf(bArr[i10])).byteValue();
            arrayList.add(Byte.valueOf(bByteValue));
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Ss(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        Ts(zArr, rn.f.Default);
    }

    @os.l
    public static final <T> List<T> St(@os.l T[] tArr, @os.l tn.l lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? k0.INSTANCE : nm.p.t(nm.p.l1(tArr, lVar.f15911a, lVar.f15912b + 1));
    }

    @os.l
    public static final float[] Su(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kn.l0.o(fArrCopyOf, "copyOf(...)");
        nm.p.M3(fArrCopyOf);
        return fArrCopyOf;
    }

    @os.l
    public static final Set<Float> Sv(@os.l float[] fArr, @os.l Iterable<Float> iterable) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Float> setAz = az(fArr);
        d0.I0(setAz, iterable);
        return setAz;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfLong")
    @lm.f1(version = "1.4")
    public static final long Sw(byte[] bArr, jn.l<? super Byte, Long> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jLongValue = 0;
        for (byte b10 : bArr) {
            jLongValue += lVar.invoke(Byte.valueOf(b10)).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final List<Long> Sx(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iVe = ve(jArr); -1 < iVe; iVe--) {
            if (!lVar.invoke(Long.valueOf(jArr[iVe])).booleanValue()) {
                return k9(jArr, iVe + 1);
            }
        }
        return Jy(jArr);
    }

    @os.l
    public static final List<Integer> Sy(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    @os.l
    public static final <R> List<lm.t0<Character, R>> Sz(@os.l char[] cArr, @os.l R[] rArr) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(rArr, "other");
        int iMin = Math.min(cArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            char c10 = cArr[i10];
            arrayList.add(new lm.t0(Character.valueOf(c10), rArr[i10]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <T, K, V> Map<K, V> T5(@os.l T[] tArr, @os.l jn.l<? super T, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "transform");
        int iJ = c1.j(tArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (a1.d dVar : tArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(dVar);
            linkedHashMap.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V> Map<Integer, V> T6(int[] iArr, jn.l<? super Integer, ? extends V> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "valueSelector");
        int iJ = c1.j(iArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (int i10 : iArr) {
            linkedHashMap.put(Integer.valueOf(i10), lVar.invoke(Integer.valueOf(i10)));
        }
        return linkedHashMap;
    }

    @an.f
    public static final boolean T7(boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return zArr[2];
    }

    @os.l
    public static final <T> List<T> T8(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return h0.V5(dz(tArr));
    }

    @an.f
    public static final int T9(int[] iArr, int i10, jn.l<? super Integer, Integer> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > ue(iArr)) ? lVar.invoke(Integer.valueOf(i10)).intValue() : iArr[i10];
    }

    @os.l
    public static <T> List<T> Ta(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return (List) Ua(tArr, new ArrayList());
    }

    public static short Tb(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length != 0) {
            return sArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @lm.s0
    @an.f
    @in.i(name = "flatMapIndexedSequenceTo")
    @lm.f1(version = "1.4")
    public static final <T, R, C extends Collection<? super R>> C Tc(T[] tArr, C c10, jn.p<? super Integer, ? super T, ? extends gq.m<? extends R>> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "transform");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            d0.q0(c10, pVar.invoke(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return c10;
    }

    public static final void Td(@os.l int[] iArr, @os.l jn.l<? super Integer, l2> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (int i10 : iArr) {
            lVar.invoke(Integer.valueOf(i10));
        }
    }

    @os.l
    public static final <K> Map<K, List<Character>> Te(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends K> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c10 : cArr) {
            K kInvoke = lVar.invoke(Character.valueOf(c10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(Character.valueOf(c10));
        }
        return linkedHashMap;
    }

    public static final int Tf(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (lVar.invoke(Boolean.valueOf(zArr[i10])).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    @os.m
    public static final Character Th(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Ti(@os.l short[] sArr, @os.l C c10, @os.l jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (short s10 : sArr) {
            c10.add(lVar.invoke(Short.valueOf(s10)));
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Tj(long[] jArr, jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Long.valueOf(jArr[0]));
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final double Tk(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dMax = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            dMax = Math.max(dMax, dArr[it.nextInt()]);
        }
        return dMax;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double Tl(boolean[] zArr, jn.l<? super Boolean, Double> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Boolean.valueOf(zArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R> R Tm(T[] tArr, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(tArr[0]);
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(tArr[it.nextInt()]);
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean Tn(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return cArr.length == 0;
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final int To(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return Uo(iArr, rn.f.Default);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Long Tp(@os.l long[] jArr, @os.l jn.q<? super Integer, ? super Long, ? super Long, Long> qVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            jLongValue = qVar.invoke(Integer.valueOf(iNextInt), Long.valueOf(jLongValue), Long.valueOf(jArr[iNextInt])).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    @lm.f1(version = "1.4")
    public static final void Tq(@os.l char[] cArr, int i10, int i11) {
        kn.l0.p(cArr, "<this>");
        nm.c.Companion.d(i10, i11, cArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            char c10 = cArr[i10];
            cArr[i10] = cArr[i13];
            cArr[i13] = c10;
            i13--;
            i10++;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Character> Tr(char[] cArr, jn.p<? super Character, ? super Character, Character> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (cArr.length == 0) {
            return k0.INSTANCE;
        }
        char c10 = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c10));
        int length = cArr.length;
        int i10 = 1;
        while (i10 < length) {
            Character chInvoke = pVar.invoke(Character.valueOf(c10), Character.valueOf(cArr[i10]));
            char cCharValue = chInvoke.charValue();
            arrayList.add(chInvoke);
            i10++;
            c10 = cCharValue;
        }
        return arrayList;
    }

    @lm.f1(version = "1.4")
    public static final void Ts(@os.l boolean[] zArr, @os.l rn.f fVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(fVar, "random");
        for (int iYe = ye(zArr); iYe > 0; iYe--) {
            int iNextInt = fVar.nextInt(iYe + 1);
            boolean z10 = zArr[iYe];
            zArr[iYe] = zArr[iNextInt];
            zArr[iNextInt] = z10;
        }
    }

    @os.l
    public static final List<Short> Tt(@os.l short[] sArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(iterable, "indices");
        int iB0 = nm.z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Short.valueOf(sArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @os.l
    public static final int[] Tu(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kn.l0.o(iArrCopyOf, "copyOf(...)");
        nm.p.O3(iArrCopyOf);
        return iArrCopyOf;
    }

    @os.l
    public static final Set<Integer> Tv(@os.l int[] iArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Integer> setBz = bz(iArr);
        d0.I0(setBz, iterable);
        return setBz;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfLong")
    @lm.f1(version = "1.4")
    public static final long Tw(char[] cArr, jn.l<? super Character, Long> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jLongValue = 0;
        for (char c10 : cArr) {
            jLongValue += lVar.invoke(Character.valueOf(c10)).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final <T> List<T> Tx(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iWe = we(tArr); -1 < iWe; iWe--) {
            if (!lVar.invoke(tArr[iWe]).booleanValue()) {
                return l9(tArr, iWe + 1);
            }
        }
        return Ky(tArr);
    }

    @os.l
    public static final List<Long> Ty(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    @os.l
    public static final <R, V> List<V> Tz(@os.l char[] cArr, @os.l R[] rArr, @os.l jn.p<? super Character, ? super R, ? extends V> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(rArr, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(cArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Character.valueOf(cArr[i10]), rArr[i10]));
        }
        return arrayList;
    }

    public static final boolean U4(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            if (!lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public static final <K, V> Map<K, V> U5(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "transform");
        int iJ = c1.j(sArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (short s10 : sArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Short.valueOf(s10));
            linkedHashMap.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V> Map<Long, V> U6(long[] jArr, jn.l<? super Long, ? extends V> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "valueSelector");
        int iJ = c1.j(jArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (long j10 : jArr) {
            linkedHashMap.put(Long.valueOf(j10), lVar.invoke(Long.valueOf(j10)));
        }
        return linkedHashMap;
    }

    @an.f
    public static final byte U7(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return bArr[3];
    }

    @os.l
    public static final List<Short> U8(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return h0.V5(ez(sArr));
    }

    @an.f
    public static final long U9(long[] jArr, int i10, jn.l<? super Integer, Long> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > ve(jArr)) ? lVar.invoke(Integer.valueOf(i10)).longValue() : jArr[i10];
    }

    @os.l
    public static final <C extends Collection<? super T>, T> C Ua(@os.l T[] tArr, @os.l C c10) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (T t10 : tArr) {
            if (t10 != null) {
                c10.add(t10);
            }
        }
        return c10;
    }

    public static final short Ub(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                return s10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @lm.s0
    @in.i(name = "flatMapSequence")
    @lm.f1(version = "1.4")
    @os.l
    public static final <T, R> List<R> Uc(@os.l T[] tArr, @os.l jn.l<? super T, ? extends gq.m<? extends R>> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            d0.q0(arrayList, lVar.invoke(t10));
        }
        return arrayList;
    }

    public static final void Ud(@os.l long[] jArr, @os.l jn.l<? super Long, l2> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (long j10 : jArr) {
            lVar.invoke(Long.valueOf(j10));
        }
    }

    @os.l
    public static final <K, V> Map<K, List<V>> Ue(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends K> lVar, @os.l jn.l<? super Character, ? extends V> lVar2) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c10 : cArr) {
            K kInvoke = lVar.invoke(Character.valueOf(c10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Character.valueOf(c10)));
        }
        return linkedHashMap;
    }

    public static final int Uf(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (lVar.invoke(Byte.valueOf(bArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.m
    public static final Character Uh(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            char c10 = cArr[length];
            if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                return Character.valueOf(c10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Ui(@os.l boolean[] zArr, @os.l C c10, @os.l jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (boolean z10 : zArr) {
            c10.add(lVar.invoke(Boolean.valueOf(z10)));
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R Uj(T[] tArr, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(tArr[0]);
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(tArr[it.nextInt()]);
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final double Uk(@os.l Double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = dArr[0].doubleValue();
        v0 it = new tn.l(1, we(dArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, dArr[it.nextInt()].doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float Ul(byte[] bArr, jn.l<? super Byte, Float> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Byte.valueOf(bArr[0])).floatValue();
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Byte.valueOf(bArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Um(short[] sArr, Comparator<? super R> comparator, jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Short.valueOf(sArr[0]));
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean Un(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (char c10 : cArr) {
            if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @lm.f1(version = "1.3")
    public static final int Uo(@os.l int[] iArr, @os.l rn.f fVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(fVar, "random");
        if (iArr.length != 0) {
            return iArr[fVar.nextInt(iArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <S, T extends S> S Up(@os.l T[] tArr, @os.l jn.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S sInvoke = (S) tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            sInvoke = qVar.invoke(Integer.valueOf(iNextInt), sInvoke, (Object) tArr[iNextInt]);
        }
        return sInvoke;
    }

    public static final void Uq(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        int length = (dArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iSe = se(dArr);
        v0 v0VarA = nm.o.a(0, length, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            double d10 = dArr[iNextInt];
            dArr[iNextInt] = dArr[iSe];
            dArr[iSe] = d10;
            iSe--;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Double> Ur(double[] dArr, jn.p<? super Double, ? super Double, Double> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (dArr.length == 0) {
            return k0.INSTANCE;
        }
        double dDoubleValue = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(dDoubleValue));
        int length = dArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            dDoubleValue = pVar.invoke(Double.valueOf(dDoubleValue), Double.valueOf(dArr[i10])).doubleValue();
            arrayList.add(Double.valueOf(dDoubleValue));
        }
        return arrayList;
    }

    public static byte Us(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return bArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @os.l
    public static final List<Short> Ut(@os.l short[] sArr, @os.l tn.l lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? k0.INSTANCE : nm.p.u(nm.p.m1(sArr, lVar.f15911a, lVar.f15912b + 1));
    }

    @os.l
    public static final long[] Uu(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kn.l0.o(jArrCopyOf, "copyOf(...)");
        nm.p.Q3(jArrCopyOf);
        return jArrCopyOf;
    }

    @os.l
    public static final Set<Long> Uv(@os.l long[] jArr, @os.l Iterable<Long> iterable) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Long> setCz = cz(jArr);
        d0.I0(setCz, iterable);
        return setCz;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfLong")
    @lm.f1(version = "1.4")
    public static final long Uw(double[] dArr, jn.l<? super Double, Long> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jLongValue = 0;
        for (double d10 : dArr) {
            jLongValue += lVar.invoke(Double.valueOf(d10)).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final List<Short> Ux(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iXe = xe(sArr); -1 < iXe; iXe--) {
            if (!lVar.invoke(Short.valueOf(sArr[iXe])).booleanValue()) {
                return m9(sArr, iXe + 1);
            }
        }
        return Ly(sArr);
    }

    @os.l
    public static final <T> List<T> Uy(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return new ArrayList(nm.y.t(tArr));
    }

    @os.l
    public static final <R> List<lm.t0<Double, R>> Uz(@os.l double[] dArr, @os.l Iterable<? extends R> iterable) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(iterable, "other");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(Double.valueOf(dArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    public static final boolean V4(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (char c10 : cArr) {
            if (!lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public static final <K, V> Map<K, V> V5(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends lm.t0<? extends K, ? extends V>> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "transform");
        int iJ = c1.j(zArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (boolean z10 : zArr) {
            lm.t0<? extends K, ? extends V> t0VarInvoke = lVar.invoke(Boolean.valueOf(z10));
            linkedHashMap.put(t0VarInvoke.getFirst(), t0VarInvoke.getSecond());
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @os.l
    public static final <K, V> Map<K, V> V6(@os.l K[] kArr, @os.l jn.l<? super K, ? extends V> lVar) {
        kn.l0.p(kArr, "<this>");
        kn.l0.p(lVar, "valueSelector");
        int iJ = c1.j(kArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (K k10 : kArr) {
            linkedHashMap.put(k10, lVar.invoke(k10));
        }
        return linkedHashMap;
    }

    @an.f
    public static final char V7(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return cArr[3];
    }

    @os.l
    public static final List<Boolean> V8(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return h0.V5(fz(zArr));
    }

    @an.f
    public static final <T> T V9(T[] tArr, int i10, jn.l<? super Integer, ? extends T> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > we(tArr)) ? lVar.invoke(Integer.valueOf(i10)) : tArr[i10];
    }

    @os.l
    public static final <C extends Collection<? super Byte>> C Va(@os.l byte[] bArr, @os.l C c10, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            if (!lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                c10.add(Byte.valueOf(b10));
            }
        }
        return c10;
    }

    public static final boolean Vb(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        if (zArr.length != 0) {
            return zArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @lm.s0
    @in.i(name = "flatMapSequenceTo")
    @lm.f1(version = "1.4")
    @os.l
    public static final <T, R, C extends Collection<? super R>> C Vc(@os.l T[] tArr, @os.l C c10, @os.l jn.l<? super T, ? extends gq.m<? extends R>> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (T t10 : tArr) {
            d0.q0(c10, lVar.invoke(t10));
        }
        return c10;
    }

    public static final <T> void Vd(@os.l T[] tArr, @os.l jn.l<? super T, l2> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (T t10 : tArr) {
            lVar.invoke(t10);
        }
    }

    @os.l
    public static final <K> Map<K, List<Double>> Ve(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends K> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d10 : dArr) {
            K kInvoke = lVar.invoke(Double.valueOf(d10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(Double.valueOf(d10));
        }
        return linkedHashMap;
    }

    public static final int Vf(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (lVar.invoke(Character.valueOf(cArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.m
    public static final Double Vh(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Boolean Vi(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        int iYe = ye(zArr);
        if (iYe == 0) {
            return Boolean.valueOf(z10);
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(z10));
        v0 v0VarA = nm.o.a(1, iYe, 1);
        while (v0VarA.hasNext()) {
            boolean z11 = zArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Boolean.valueOf(z11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                z10 = z11;
                rInvoke = rInvoke2;
            }
        }
        return Boolean.valueOf(z10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Vj(short[] sArr, jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Short.valueOf(sArr[0]));
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final float Vk(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fMax = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            fMax = Math.max(fMax, fArr[it.nextInt()]);
        }
        return fMax;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float Vl(char[] cArr, jn.l<? super Character, Float> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Character.valueOf(cArr[0])).floatValue();
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Character.valueOf(cArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Vm(boolean[] zArr, Comparator<? super R> comparator, jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(zArr[0]));
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean Vn(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return dArr.length == 0;
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final long Vo(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return Wo(jArr, rn.f.Default);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Short Vp(@os.l short[] sArr, @os.l jn.q<? super Integer, ? super Short, ? super Short, Short> qVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            int iNextInt = it.nextInt();
            sShortValue = qVar.invoke(Integer.valueOf(iNextInt), Short.valueOf(sShortValue), Short.valueOf(sArr[iNextInt])).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    @lm.f1(version = "1.4")
    public static final void Vq(@os.l double[] dArr, int i10, int i11) {
        kn.l0.p(dArr, "<this>");
        nm.c.Companion.d(i10, i11, dArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            double d10 = dArr[i10];
            dArr[i10] = dArr[i13];
            dArr[i13] = d10;
            i13--;
            i10++;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Float> Vr(float[] fArr, jn.p<? super Float, ? super Float, Float> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (fArr.length == 0) {
            return k0.INSTANCE;
        }
        float fFloatValue = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(fFloatValue));
        int length = fArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            fFloatValue = pVar.invoke(Float.valueOf(fFloatValue), Float.valueOf(fArr[i10])).floatValue();
            arrayList.add(Float.valueOf(fFloatValue));
        }
        return arrayList;
    }

    public static final byte Vs(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Byte bValueOf = null;
        boolean z10 = false;
        for (byte b10 : bArr) {
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                bValueOf = Byte.valueOf(b10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kn.l0.n(bValueOf, "null cannot be cast to non-null type kotlin.Byte");
        return bValueOf.byteValue();
    }

    @os.l
    public static final List<Boolean> Vt(@os.l boolean[] zArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(iterable, "indices");
        int iB0 = nm.z.b0(iterable, 10);
        if (iB0 == 0) {
            return k0.INSTANCE;
        }
        ArrayList arrayList = new ArrayList(iB0);
        Iterator<Integer> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(zArr[it.next().intValue()]));
        }
        return arrayList;
    }

    @os.l
    public static final <T extends Comparable<? super T>> T[] Vu(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        kn.l0.o(objArrCopyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        nm.p.U3(tArr2);
        return tArr2;
    }

    @os.l
    public static final <T> Set<T> Vv(@os.l T[] tArr, @os.l Iterable<? extends T> iterable) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<T> setDz = dz(tArr);
        d0.I0(setDz, iterable);
        return setDz;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfLong")
    @lm.f1(version = "1.4")
    public static final long Vw(float[] fArr, jn.l<? super Float, Long> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jLongValue = 0;
        for (float f10 : fArr) {
            jLongValue += lVar.invoke(Float.valueOf(f10)).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final List<Boolean> Vx(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iYe = ye(zArr); -1 < iYe; iYe--) {
            if (!lVar.invoke(Boolean.valueOf(zArr[iYe])).booleanValue()) {
                return n9(zArr, iYe + 1);
            }
        }
        return My(zArr);
    }

    @os.l
    public static final List<Short> Vy(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s10 : sArr) {
            arrayList.add(Short.valueOf(s10));
        }
        return arrayList;
    }

    @os.l
    public static final <R, V> List<V> Vz(@os.l double[] dArr, @os.l Iterable<? extends R> iterable, @os.l jn.p<? super Double, ? super R, ? extends V> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(iterable, "other");
        kn.l0.p(pVar, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Double.valueOf(dArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    public static final boolean W4(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (double d10 : dArr) {
            if (!lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public static final <K> Map<K, Byte> W5(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends K> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        int iJ = c1.j(bArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (byte b10 : bArr) {
            linkedHashMap.put(lVar.invoke(Byte.valueOf(b10)), Byte.valueOf(b10));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V> Map<Short, V> W6(short[] sArr, jn.l<? super Short, ? extends V> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "valueSelector");
        int iJ = c1.j(sArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (short s10 : sArr) {
            linkedHashMap.put(Short.valueOf(s10), lVar.invoke(Short.valueOf(s10)));
        }
        return linkedHashMap;
    }

    @an.f
    public static final double W7(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return dArr[3];
    }

    @os.l
    public static final <K> List<Byte> W8(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends K> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            if (hashSet.add(lVar.invoke(Byte.valueOf(b10)))) {
                arrayList.add(Byte.valueOf(b10));
            }
        }
        return arrayList;
    }

    @an.f
    public static final short W9(short[] sArr, int i10, jn.l<? super Integer, Short> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > xe(sArr)) ? lVar.invoke(Integer.valueOf(i10)).shortValue() : sArr[i10];
    }

    @os.l
    public static final <C extends Collection<? super Character>> C Wa(@os.l char[] cArr, @os.l C c10, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (char c11 : cArr) {
            if (!lVar.invoke(Character.valueOf(c11)).booleanValue()) {
                c10.add(Character.valueOf(c11));
            }
        }
        return c10;
    }

    public static final boolean Wb(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (boolean z10 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                return z10;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Wc(@os.l byte[] bArr, @os.l C c10, @os.l jn.l<? super Byte, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (byte b10 : bArr) {
            d0.r0(c10, lVar.invoke(Byte.valueOf(b10)));
        }
        return c10;
    }

    public static final void Wd(@os.l short[] sArr, @os.l jn.l<? super Short, l2> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (short s10 : sArr) {
            lVar.invoke(Short.valueOf(s10));
        }
    }

    @os.l
    public static final <K, V> Map<K, List<V>> We(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends K> lVar, @os.l jn.l<? super Double, ? extends V> lVar2) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d10 : dArr) {
            K kInvoke = lVar.invoke(Double.valueOf(d10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Double.valueOf(d10)));
        }
        return linkedHashMap;
    }

    public static final int Wf(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (lVar.invoke(Double.valueOf(dArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final String Wg(@os.l byte[] bArr, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Byte, ? extends CharSequence> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        String string = ((StringBuilder) Eg(bArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.m
    public static final Double Wh(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            double d10 = dArr[length];
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                return Double.valueOf(d10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Byte Wi(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        int iQe = qe(bArr);
        if (iQe == 0) {
            return Byte.valueOf(b10);
        }
        R rInvoke = lVar.invoke(Byte.valueOf(b10));
        v0 v0VarA = nm.o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte b11 = bArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Byte.valueOf(b11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                b10 = b11;
                rInvoke = rInvoke2;
            }
        }
        return Byte.valueOf(b10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R Wj(boolean[] zArr, jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(zArr[0]));
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final float Wk(@os.l Float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = fArr[0].floatValue();
        v0 it = new tn.l(1, we(fArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, fArr[it.nextInt()].floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float Wl(double[] dArr, jn.l<? super Double, Float> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Double.valueOf(dArr[0])).floatValue();
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Double.valueOf(dArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Wm(byte[] bArr, Comparator<? super R> comparator, jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Byte.valueOf(bArr[0]));
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean Wn(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (double d10 : dArr) {
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @lm.f1(version = "1.3")
    public static final long Wo(@os.l long[] jArr, @os.l rn.f fVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(fVar, "random");
        if (jArr.length != 0) {
            return jArr[fVar.nextInt(jArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Boolean Wp(@os.l boolean[] zArr, @os.l jn.p<? super Boolean, ? super Boolean, Boolean> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (zArr.length == 0) {
            return null;
        }
        boolean zBooleanValue = zArr[0];
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            zBooleanValue = pVar.invoke(Boolean.valueOf(zBooleanValue), Boolean.valueOf(zArr[it.nextInt()])).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public static final void Wq(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        int length = (fArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iTe = te(fArr);
        v0 v0VarA = nm.o.a(0, length, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            float f10 = fArr[iNextInt];
            fArr[iNextInt] = fArr[iTe];
            fArr[iTe] = f10;
            iTe--;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Integer> Wr(int[] iArr, jn.p<? super Integer, ? super Integer, Integer> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (iArr.length == 0) {
            return k0.INSTANCE;
        }
        int iIntValue = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(iIntValue));
        int length = iArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            iIntValue = pVar.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iArr[i10])).intValue();
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }

    public static char Ws(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @os.l
    public static final List<Boolean> Wt(@os.l boolean[] zArr, @os.l tn.l lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? k0.INSTANCE : nm.p.v(nm.p.n1(zArr, lVar.f15911a, lVar.f15912b + 1));
    }

    @os.l
    public static final short[] Wu(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kn.l0.o(sArrCopyOf, "copyOf(...)");
        nm.p.W3(sArrCopyOf);
        return sArrCopyOf;
    }

    @os.l
    public static final Set<Short> Wv(@os.l short[] sArr, @os.l Iterable<Short> iterable) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Short> setEz = ez(sArr);
        d0.I0(setEz, iterable);
        return setEz;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfLong")
    @lm.f1(version = "1.4")
    public static final long Ww(int[] iArr, jn.l<? super Integer, Long> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jLongValue = 0;
        for (int i10 : iArr) {
            jLongValue += lVar.invoke(Integer.valueOf(i10)).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final List<Byte> Wx(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            if (!lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b10));
        }
        return arrayList;
    }

    @os.l
    public static final List<Boolean> Wy(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z10 : zArr) {
            arrayList.add(Boolean.valueOf(z10));
        }
        return arrayList;
    }

    @os.l
    public static final List<lm.t0<Double, Double>> Wz(@os.l double[] dArr, @os.l double[] dArr2) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(dArr2, "other");
        int iMin = Math.min(dArr.length, dArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(Double.valueOf(dArr[i10]), Double.valueOf(dArr2[i10])));
        }
        return arrayList;
    }

    public static final boolean X4(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (float f10 : fArr) {
            if (!lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public static final <K, V> Map<K, V> X5(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends K> lVar, @os.l jn.l<? super Byte, ? extends V> lVar2) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        int iJ = c1.j(bArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (byte b10 : bArr) {
            linkedHashMap.put(lVar.invoke(Byte.valueOf(b10)), lVar2.invoke(Byte.valueOf(b10)));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V> Map<Boolean, V> X6(boolean[] zArr, jn.l<? super Boolean, ? extends V> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "valueSelector");
        int iJ = c1.j(zArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (boolean z10 : zArr) {
            linkedHashMap.put(Boolean.valueOf(z10), lVar.invoke(Boolean.valueOf(z10)));
        }
        return linkedHashMap;
    }

    @an.f
    public static final float X7(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return fArr[3];
    }

    @os.l
    public static final <K> List<Character> X8(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends K> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c10 : cArr) {
            if (hashSet.add(lVar.invoke(Character.valueOf(c10)))) {
                arrayList.add(Character.valueOf(c10));
            }
        }
        return arrayList;
    }

    @an.f
    public static final boolean X9(boolean[] zArr, int i10, jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > ye(zArr)) ? lVar.invoke(Integer.valueOf(i10)).booleanValue() : zArr[i10];
    }

    @os.l
    public static final <C extends Collection<? super Double>> C Xa(@os.l double[] dArr, @os.l C c10, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (double d10 : dArr) {
            if (!lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                c10.add(Double.valueOf(d10));
            }
        }
        return c10;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001d  */
    /* JADX WARN: Code duplicated, block: B:9:0x001c A[RETURN] */
    @lm.f1(version = "1.5")
    @an.f
    public static final <T, R> R Xb(T[] tArr, jn.l<? super T, ? extends R> lVar) {
        R rInvoke;
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "transform");
        for (T t10 : tArr) {
            rInvoke = lVar.invoke(t10);
            if (rInvoke != null) {
                if (rInvoke != null) {
                    return rInvoke;
                }
                throw new NoSuchElementException("No element of the array was transformed to a non-null value.");
            }
        }
        rInvoke = null;
        if (rInvoke != null) {
            return rInvoke;
        }
        throw new NoSuchElementException("No element of the array was transformed to a non-null value.");
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Xc(@os.l char[] cArr, @os.l C c10, @os.l jn.l<? super Character, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (char c11 : cArr) {
            d0.r0(c10, lVar.invoke(Character.valueOf(c11)));
        }
        return c10;
    }

    public static final void Xd(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, l2> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (boolean z10 : zArr) {
            lVar.invoke(Boolean.valueOf(z10));
        }
    }

    @os.l
    public static final <K> Map<K, List<Float>> Xe(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends K> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f10 : fArr) {
            K kInvoke = lVar.invoke(Float.valueOf(f10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(Float.valueOf(f10));
        }
        return linkedHashMap;
    }

    public static final int Xf(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (lVar.invoke(Float.valueOf(fArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final String Xg(@os.l char[] cArr, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Character, ? extends CharSequence> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        String string = ((StringBuilder) Fg(cArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.m
    public static final Float Xh(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Character Xi(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        int iRe = re(cArr);
        if (iRe == 0) {
            return Character.valueOf(c10);
        }
        R rInvoke = lVar.invoke(Character.valueOf(c10));
        v0 v0VarA = nm.o.a(1, iRe, 1);
        while (v0VarA.hasNext()) {
            char c11 = cArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Character.valueOf(c11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                c10 = c11;
                rInvoke = rInvoke2;
            }
        }
        return Character.valueOf(c10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double Xj(byte[] bArr, jn.l<? super Byte, Double> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Byte.valueOf(bArr[0])).doubleValue();
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Byte.valueOf(bArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final int Xk(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int i11 = iArr[it.nextInt()];
            if (i10 < i11) {
                i10 = i11;
            }
        }
        return i10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float Xl(float[] fArr, jn.l<? super Float, Float> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Float.valueOf(fArr[0])).floatValue();
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Float.valueOf(fArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Xm(char[] cArr, Comparator<? super R> comparator, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Character.valueOf(cArr[0]));
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean Xn(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return fArr.length == 0;
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final <T> T Xo(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return (T) Yo(tArr, rn.f.Default);
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Byte Xp(@os.l byte[] bArr, @os.l jn.p<? super Byte, ? super Byte, Byte> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (bArr.length == 0) {
            return null;
        }
        byte bByteValue = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            bByteValue = pVar.invoke(Byte.valueOf(bByteValue), Byte.valueOf(bArr[it.nextInt()])).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @lm.f1(version = "1.4")
    public static final void Xq(@os.l float[] fArr, int i10, int i11) {
        kn.l0.p(fArr, "<this>");
        nm.c.Companion.d(i10, i11, fArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            float f10 = fArr[i10];
            fArr[i10] = fArr[i13];
            fArr[i13] = f10;
            i13--;
            i10++;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Long> Xr(long[] jArr, jn.p<? super Long, ? super Long, Long> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (jArr.length == 0) {
            return k0.INSTANCE;
        }
        long jLongValue = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(jLongValue));
        int length = jArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            jLongValue = pVar.invoke(Long.valueOf(jLongValue), Long.valueOf(jArr[i10])).longValue();
            arrayList.add(Long.valueOf(jLongValue));
        }
        return arrayList;
    }

    public static final char Xs(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Character chValueOf = null;
        boolean z10 = false;
        for (char c10 : cArr) {
            if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                chValueOf = Character.valueOf(c10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kn.l0.n(chValueOf, "null cannot be cast to non-null type kotlin.Char");
        return chValueOf.charValue();
    }

    @os.l
    public static byte[] Xt(@os.l byte[] bArr, @os.l Collection<Integer> collection) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(collection, "indices");
        byte[] bArr2 = new byte[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            bArr2[i10] = bArr[it.next().intValue()];
            i10++;
        }
        return bArr2;
    }

    @os.l
    public static final byte[] Xu(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kn.l0.o(bArrCopyOf, "copyOf(...)");
        ru(bArrCopyOf);
        return bArrCopyOf;
    }

    @os.l
    public static final Set<Boolean> Xv(@os.l boolean[] zArr, @os.l Iterable<Boolean> iterable) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Boolean> setFz = fz(zArr);
        d0.I0(setFz, iterable);
        return setFz;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfLong")
    @lm.f1(version = "1.4")
    public static final long Xw(long[] jArr, jn.l<? super Long, Long> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jLongValue = 0;
        for (long j10 : jArr) {
            jLongValue += lVar.invoke(Long.valueOf(j10)).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final List<Character> Xx(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c10 : cArr) {
            if (!lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c10));
        }
        return arrayList;
    }

    @os.l
    public static final Set<Byte> Xy(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return (Set) jy(bArr, new LinkedHashSet(c1.j(bArr.length)));
    }

    @os.l
    public static final <V> List<V> Xz(@os.l double[] dArr, @os.l double[] dArr2, @os.l jn.p<? super Double, ? super Double, ? extends V> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(dArr2, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(dArr.length, dArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Double.valueOf(dArr[i10]), Double.valueOf(dArr2[i10])));
        }
        return arrayList;
    }

    public static final boolean Y4(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            if (!lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public static final <K> Map<K, Character> Y5(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends K> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        int iJ = c1.j(cArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (char c10 : cArr) {
            linkedHashMap.put(lVar.invoke(Character.valueOf(c10)), Character.valueOf(c10));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V, M extends Map<? super Byte, ? super V>> M Y6(byte[] bArr, M m10, jn.l<? super Byte, ? extends V> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "valueSelector");
        for (byte b10 : bArr) {
            m10.put(Byte.valueOf(b10), lVar.invoke(Byte.valueOf(b10)));
        }
        return m10;
    }

    @an.f
    public static final int Y7(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return iArr[3];
    }

    @os.l
    public static final <K> List<Double> Y8(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends K> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d10 : dArr) {
            if (hashSet.add(lVar.invoke(Double.valueOf(d10)))) {
                arrayList.add(Double.valueOf(d10));
            }
        }
        return arrayList;
    }

    @an.f
    public static final Boolean Y9(boolean[] zArr, int i10) {
        kn.l0.p(zArr, "<this>");
        return Ie(zArr, i10);
    }

    @os.l
    public static final <C extends Collection<? super Float>> C Ya(@os.l float[] fArr, @os.l C c10, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (float f10 : fArr) {
            if (!lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                c10.add(Float.valueOf(f10));
            }
        }
        return c10;
    }

    @lm.f1(version = "1.5")
    @an.f
    public static final <T, R> R Yb(T[] tArr, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "transform");
        for (T t10 : tArr) {
            R rInvoke = lVar.invoke(t10);
            if (rInvoke != null) {
                return rInvoke;
            }
        }
        return null;
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Yc(@os.l double[] dArr, @os.l C c10, @os.l jn.l<? super Double, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (double d10 : dArr) {
            d0.r0(c10, lVar.invoke(Double.valueOf(d10)));
        }
        return c10;
    }

    public static final void Yd(@os.l byte[] bArr, @os.l jn.p<? super Integer, ? super Byte, l2> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Byte.valueOf(bArr[i10]));
            i10++;
            i11++;
        }
    }

    @os.l
    public static final <K, V> Map<K, List<V>> Ye(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends K> lVar, @os.l jn.l<? super Float, ? extends V> lVar2) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f10 : fArr) {
            K kInvoke = lVar.invoke(Float.valueOf(f10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Float.valueOf(f10)));
        }
        return linkedHashMap;
    }

    public static final int Yf(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (lVar.invoke(Integer.valueOf(iArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final String Yg(@os.l double[] dArr, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Double, ? extends CharSequence> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        String string = ((StringBuilder) Gg(dArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.m
    public static final Float Yh(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            float f10 = fArr[length];
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                return Float.valueOf(f10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Double Yi(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        int iSe = se(dArr);
        if (iSe == 0) {
            return Double.valueOf(d10);
        }
        R rInvoke = lVar.invoke(Double.valueOf(d10));
        v0 v0VarA = nm.o.a(1, iSe, 1);
        while (v0VarA.hasNext()) {
            double d11 = dArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Double.valueOf(d11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                d10 = d11;
                rInvoke = rInvoke2;
            }
        }
        return Double.valueOf(d10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double Yj(char[] cArr, jn.l<? super Character, Double> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Character.valueOf(cArr[0])).doubleValue();
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Character.valueOf(cArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final long Yk(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long j11 = jArr[it.nextInt()];
            if (j10 < j11) {
                j10 = j11;
            }
        }
        return j10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float Yl(int[] iArr, jn.l<? super Integer, Float> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Integer.valueOf(iArr[0])).floatValue();
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Integer.valueOf(iArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Ym(double[] dArr, Comparator<? super R> comparator, jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Double.valueOf(dArr[0]));
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean Yn(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (float f10 : fArr) {
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @lm.f1(version = "1.3")
    public static final <T> T Yo(@os.l T[] tArr, @os.l rn.f fVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(fVar, "random");
        if (tArr.length != 0) {
            return tArr[fVar.nextInt(tArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Character Yp(@os.l char[] cArr, @os.l jn.p<? super Character, ? super Character, Character> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (cArr.length == 0) {
            return null;
        }
        char cCharValue = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            cCharValue = pVar.invoke(Character.valueOf(cCharValue), Character.valueOf(cArr[it.nextInt()])).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    public static void Yq(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        int length = (iArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iUe = ue(iArr);
        v0 v0VarA = nm.o.a(0, length, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            int i10 = iArr[iNextInt];
            iArr[iNextInt] = iArr[iUe];
            iArr[iUe] = i10;
            iUe--;
        }
    }

    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <S, T extends S> List<S> Yr(@os.l T[] tArr, @os.l jn.p<? super S, ? super T, ? extends S> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (tArr.length == 0) {
            return k0.INSTANCE;
        }
        S sInvoke = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(sInvoke);
        int length = tArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            sInvoke = pVar.invoke(sInvoke, (Object) tArr[i10]);
            arrayList.add(sInvoke);
        }
        return arrayList;
    }

    public static final double Ys(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return dArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @os.l
    public static byte[] Yt(@os.l byte[] bArr, @os.l tn.l lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? new byte[0] : nm.p.f1(bArr, lVar.f15911a, lVar.f15912b + 1);
    }

    @os.l
    public static final char[] Yu(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kn.l0.o(cArrCopyOf, "copyOf(...)");
        tu(cArrCopyOf);
        return cArrCopyOf;
    }

    public static final double Yv(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        double d10 = 0.0d;
        for (double d11 : dArr) {
            d10 += d11;
        }
        return d10;
    }

    @in.i(name = "sumOfLong")
    public static final long Yw(@os.l Long[] lArr) {
        kn.l0.p(lArr, "<this>");
        long jLongValue = 0;
        for (Long l10 : lArr) {
            jLongValue += l10.longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final List<Double> Yx(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d10 : dArr) {
            if (!lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d10));
        }
        return arrayList;
    }

    @os.l
    public static final Set<Character> Yy(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        int length = cArr.length;
        if (length > 128) {
            length = 128;
        }
        return (Set) ky(cArr, new LinkedHashSet(c1.j(length)));
    }

    @os.l
    public static final <R> List<lm.t0<Double, R>> Yz(@os.l double[] dArr, @os.l R[] rArr) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(rArr, "other");
        int iMin = Math.min(dArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            double d10 = dArr[i10];
            arrayList.add(new lm.t0(Double.valueOf(d10), rArr[i10]));
        }
        return arrayList;
    }

    public static final boolean Z4(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            if (!lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public static final <K, V> Map<K, V> Z5(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends K> lVar, @os.l jn.l<? super Character, ? extends V> lVar2) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        int iJ = c1.j(cArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (char c10 : cArr) {
            linkedHashMap.put(lVar.invoke(Character.valueOf(c10)), lVar2.invoke(Character.valueOf(c10)));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V, M extends Map<? super Character, ? super V>> M Z6(char[] cArr, M m10, jn.l<? super Character, ? extends V> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "valueSelector");
        for (char c10 : cArr) {
            m10.put(Character.valueOf(c10), lVar.invoke(Character.valueOf(c10)));
        }
        return m10;
    }

    @an.f
    public static final long Z7(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return jArr[3];
    }

    @os.l
    public static final <K> List<Float> Z8(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends K> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f10 : fArr) {
            if (hashSet.add(lVar.invoke(Float.valueOf(f10)))) {
                arrayList.add(Float.valueOf(f10));
            }
        }
        return arrayList;
    }

    @an.f
    public static final Byte Z9(byte[] bArr, int i10) {
        kn.l0.p(bArr, "<this>");
        return Je(bArr, i10);
    }

    @os.l
    public static final <C extends Collection<? super Integer>> C Za(@os.l int[] iArr, @os.l C c10, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            if (!lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                c10.add(Integer.valueOf(i10));
            }
        }
        return c10;
    }

    @os.m
    public static final Boolean Zb(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C Zc(@os.l float[] fArr, @os.l C c10, @os.l jn.l<? super Float, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (float f10 : fArr) {
            d0.r0(c10, lVar.invoke(Float.valueOf(f10)));
        }
        return c10;
    }

    public static final void Zd(@os.l char[] cArr, @os.l jn.p<? super Integer, ? super Character, l2> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Character.valueOf(cArr[i10]));
            i10++;
            i11++;
        }
    }

    @os.l
    public static final <K> Map<K, List<Integer>> Ze(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends K> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 : iArr) {
            K kInvoke = lVar.invoke(Integer.valueOf(i10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(Integer.valueOf(i10));
        }
        return linkedHashMap;
    }

    public static final int Zf(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (lVar.invoke(Long.valueOf(jArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final String Zg(@os.l float[] fArr, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Float, ? extends CharSequence> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        String string = ((StringBuilder) Hg(fArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.m
    public static final Integer Zh(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Float Zi(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        int iTe = te(fArr);
        if (iTe == 0) {
            return Float.valueOf(f10);
        }
        R rInvoke = lVar.invoke(Float.valueOf(f10));
        v0 v0VarA = nm.o.a(1, iTe, 1);
        while (v0VarA.hasNext()) {
            float f11 = fArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Float.valueOf(f11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                f10 = f11;
                rInvoke = rInvoke2;
            }
        }
        return Float.valueOf(f10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double Zj(double[] dArr, jn.l<? super Double, Double> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Double.valueOf(dArr[0])).doubleValue();
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Double.valueOf(dArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    @os.l
    public static final <T extends Comparable<? super T>> T Zk(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            T t11 = tArr[it.nextInt()];
            if (t10.compareTo(t11) < 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float Zl(long[] jArr, jn.l<? super Long, Float> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Long.valueOf(jArr[0])).floatValue();
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Long.valueOf(jArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R Zm(float[] fArr, Comparator<? super R> comparator, jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Float.valueOf(fArr[0]));
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean Zn(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return iArr.length == 0;
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final short Zo(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return ap(sArr, rn.f.Default);
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Double Zp(@os.l double[] dArr, @os.l jn.p<? super Double, ? super Double, Double> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = pVar.invoke(Double.valueOf(dDoubleValue), Double.valueOf(dArr[it.nextInt()])).doubleValue();
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.4")
    public static void Zq(@os.l int[] iArr, int i10, int i11) {
        kn.l0.p(iArr, "<this>");
        nm.c.Companion.d(i10, i11, iArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            int i14 = iArr[i10];
            iArr[i10] = iArr[i13];
            iArr[i13] = i14;
            i13--;
            i10++;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Short> Zr(short[] sArr, jn.p<? super Short, ? super Short, Short> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (sArr.length == 0) {
            return k0.INSTANCE;
        }
        short sShortValue = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(sShortValue));
        int length = sArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            sShortValue = pVar.invoke(Short.valueOf(sShortValue), Short.valueOf(sArr[i10])).shortValue();
            arrayList.add(Short.valueOf(sShortValue));
        }
        return arrayList;
    }

    public static final double Zs(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Double dValueOf = null;
        boolean z10 = false;
        for (double d10 : dArr) {
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                dValueOf = Double.valueOf(d10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kn.l0.n(dValueOf, "null cannot be cast to non-null type kotlin.Double");
        return dValueOf.doubleValue();
    }

    @os.l
    public static final char[] Zt(@os.l char[] cArr, @os.l Collection<Integer> collection) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(collection, "indices");
        char[] cArr2 = new char[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            cArr2[i10] = cArr[it.next().intValue()];
            i10++;
        }
        return cArr2;
    }

    @os.l
    public static final double[] Zu(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kn.l0.o(dArrCopyOf, "copyOf(...)");
        vu(dArrCopyOf);
        return dArrCopyOf;
    }

    public static final float Zv(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        float f10 = 0.0f;
        for (float f11 : fArr) {
            f10 += f11;
        }
        return f10;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfLong")
    @lm.f1(version = "1.4")
    public static final <T> long Zw(T[] tArr, jn.l<? super T, Long> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jLongValue = 0;
        for (T t10 : tArr) {
            jLongValue += lVar.invoke(t10).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final List<Float> Zx(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f10 : fArr) {
            if (!lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f10));
        }
        return arrayList;
    }

    @os.l
    public static final Set<Double> Zy(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return (Set) ly(dArr, new LinkedHashSet(c1.j(dArr.length)));
    }

    @os.l
    public static final <R, V> List<V> Zz(@os.l double[] dArr, @os.l R[] rArr, @os.l jn.p<? super Double, ? super R, ? extends V> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(rArr, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(dArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Double.valueOf(dArr[i10]), rArr[i10]));
        }
        return arrayList;
    }

    public static final <T> boolean a5(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (T t10 : tArr) {
            if (!lVar.invoke(t10).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public static final <K> Map<K, Double> a6(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends K> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        int iJ = c1.j(dArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (double d10 : dArr) {
            linkedHashMap.put(lVar.invoke(Double.valueOf(d10)), Double.valueOf(d10));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V, M extends Map<? super Double, ? super V>> M a7(double[] dArr, M m10, jn.l<? super Double, ? extends V> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "valueSelector");
        for (double d10 : dArr) {
            m10.put(Double.valueOf(d10), lVar.invoke(Double.valueOf(d10)));
        }
        return m10;
    }

    @an.f
    public static final <T> T a8(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return tArr[3];
    }

    @os.l
    public static final <K> List<Integer> a9(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends K> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (hashSet.add(lVar.invoke(Integer.valueOf(i10)))) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        return arrayList;
    }

    @os.l
    public static final <R> List<lm.t0<Float, R>> aA(@os.l float[] fArr, @os.l Iterable<? extends R> iterable) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(iterable, "other");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(Float.valueOf(fArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @an.f
    public static final Character aa(char[] cArr, int i10) {
        kn.l0.p(cArr, "<this>");
        return Ke(cArr, i10);
    }

    @os.l
    public static final <C extends Collection<? super Long>> C ab(@os.l long[] jArr, @os.l C c10, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            if (!lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                c10.add(Long.valueOf(j10));
            }
        }
        return c10;
    }

    @os.m
    public static final Boolean ac(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (boolean z10 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                return Boolean.valueOf(z10);
            }
        }
        return null;
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C ad(@os.l int[] iArr, @os.l C c10, @os.l jn.l<? super Integer, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (int i10 : iArr) {
            d0.r0(c10, lVar.invoke(Integer.valueOf(i10)));
        }
        return c10;
    }

    public static final void ae(@os.l double[] dArr, @os.l jn.p<? super Integer, ? super Double, l2> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Double.valueOf(dArr[i10]));
            i10++;
            i11++;
        }
    }

    @os.l
    public static final <K, V> Map<K, List<V>> af(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends K> lVar, @os.l jn.l<? super Integer, ? extends V> lVar2) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 : iArr) {
            K kInvoke = lVar.invoke(Integer.valueOf(i10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Integer.valueOf(i10)));
        }
        return linkedHashMap;
    }

    public static final <T> int ag(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (lVar.invoke(tArr[length]).booleanValue()) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final String ah(@os.l int[] iArr, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Integer, ? extends CharSequence> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        String string = ((StringBuilder) Ig(iArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.m
    public static final Integer ai(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            int i11 = iArr[length];
            if (lVar.invoke(Integer.valueOf(i11)).booleanValue()) {
                return Integer.valueOf(i11);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Integer aj(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        int iUe = ue(iArr);
        if (iUe == 0) {
            return Integer.valueOf(i10);
        }
        R rInvoke = lVar.invoke(Integer.valueOf(i10));
        v0 v0VarA = nm.o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int i11 = iArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Integer.valueOf(i11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                i10 = i11;
                rInvoke = rInvoke2;
            }
        }
        return Integer.valueOf(i10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double ak(float[] fArr, jn.l<? super Float, Double> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Float.valueOf(fArr[0])).doubleValue();
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Float.valueOf(fArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxOrThrow")
    public static final short al(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short s11 = sArr[it.nextInt()];
            if (s10 < s11) {
                s10 = s11;
            }
        }
        return s10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> float am(T[] tArr, jn.l<? super T, Float> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(tArr[0]).floatValue();
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(tArr[it.nextInt()]).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R an(int[] iArr, Comparator<? super R> comparator, jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Integer.valueOf(iArr[0]));
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean ao(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            if (lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @lm.f1(version = "1.3")
    public static final short ap(@os.l short[] sArr, @os.l rn.f fVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(fVar, "random");
        if (sArr.length != 0) {
            return sArr[fVar.nextInt(sArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Float aq(@os.l float[] fArr, @os.l jn.p<? super Float, ? super Float, Float> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = pVar.invoke(Float.valueOf(fFloatValue), Float.valueOf(fArr[it.nextInt()])).floatValue();
        }
        return Float.valueOf(fFloatValue);
    }

    public static void ar(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        int length = (jArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iVe = ve(jArr);
        v0 v0VarA = nm.o.a(0, length, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            long j10 = jArr[iNextInt];
            jArr[iNextInt] = jArr[iVe];
            jArr[iVe] = j10;
            iVe--;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Boolean> as(boolean[] zArr, jn.p<? super Boolean, ? super Boolean, Boolean> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (zArr.length == 0) {
            return k0.INSTANCE;
        }
        boolean z10 = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z10));
        int length = zArr.length;
        int i10 = 1;
        while (i10 < length) {
            Boolean boolInvoke = pVar.invoke(Boolean.valueOf(z10), Boolean.valueOf(zArr[i10]));
            boolean zBooleanValue = boolInvoke.booleanValue();
            arrayList.add(boolInvoke);
            i10++;
            z10 = zBooleanValue;
        }
        return arrayList;
    }

    public static final float at(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return fArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @os.l
    public static final char[] au(@os.l char[] cArr, @os.l tn.l lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? new char[0] : nm.p.g1(cArr, lVar.f15911a, lVar.f15912b + 1);
    }

    @os.l
    public static final float[] av(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kn.l0.o(fArrCopyOf, "copyOf(...)");
        xu(fArrCopyOf);
        return fArrCopyOf;
    }

    public static final int aw(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        int i10 = 0;
        for (byte b10 : bArr) {
            i10 += b10;
        }
        return i10;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfLong")
    @lm.f1(version = "1.4")
    public static final long ax(short[] sArr, jn.l<? super Short, Long> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jLongValue = 0;
        for (short s10 : sArr) {
            jLongValue += lVar.invoke(Short.valueOf(s10)).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final List<Integer> ay(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (!lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    @os.l
    public static final Set<Float> az(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return (Set) my(fArr, new LinkedHashSet(c1.j(fArr.length)));
    }

    public static final boolean b5(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            if (!lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public static final <K, V> Map<K, V> b6(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends K> lVar, @os.l jn.l<? super Double, ? extends V> lVar2) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        int iJ = c1.j(dArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (double d10 : dArr) {
            linkedHashMap.put(lVar.invoke(Double.valueOf(d10)), lVar2.invoke(Double.valueOf(d10)));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V, M extends Map<? super Float, ? super V>> M b7(float[] fArr, M m10, jn.l<? super Float, ? extends V> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "valueSelector");
        for (float f10 : fArr) {
            m10.put(Float.valueOf(f10), lVar.invoke(Float.valueOf(f10)));
        }
        return m10;
    }

    @an.f
    public static final short b8(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return sArr[3];
    }

    @os.l
    public static final <K> List<Long> b9(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends K> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            if (hashSet.add(lVar.invoke(Long.valueOf(j10)))) {
                arrayList.add(Long.valueOf(j10));
            }
        }
        return arrayList;
    }

    @os.l
    public static final <R, V> List<V> bA(@os.l float[] fArr, @os.l Iterable<? extends R> iterable, @os.l jn.p<? super Float, ? super R, ? extends V> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(iterable, "other");
        kn.l0.p(pVar, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Float.valueOf(fArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @an.f
    public static final Double ba(double[] dArr, int i10) {
        kn.l0.p(dArr, "<this>");
        return Le(dArr, i10);
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C bb(@os.l T[] tArr, @os.l C c10, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (T t10 : tArr) {
            if (!lVar.invoke(t10).booleanValue()) {
                c10.add(t10);
            }
        }
        return c10;
    }

    @os.m
    public static final Byte bc(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C bd(@os.l long[] jArr, @os.l C c10, @os.l jn.l<? super Long, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (long j10 : jArr) {
            d0.r0(c10, lVar.invoke(Long.valueOf(j10)));
        }
        return c10;
    }

    public static final void be(@os.l float[] fArr, @os.l jn.p<? super Integer, ? super Float, l2> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Float.valueOf(fArr[i10]));
            i10++;
            i11++;
        }
    }

    @os.l
    public static final <K> Map<K, List<Long>> bf(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends K> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j10 : jArr) {
            K kInvoke = lVar.invoke(Long.valueOf(j10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(Long.valueOf(j10));
        }
        return linkedHashMap;
    }

    public static final int bg(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (lVar.invoke(Short.valueOf(sArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final String bh(@os.l long[] jArr, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Long, ? extends CharSequence> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        String string = ((StringBuilder) Jg(jArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.m
    public static final Long bi(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Long bj(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        int iVe = ve(jArr);
        if (iVe == 0) {
            return Long.valueOf(j10);
        }
        R rInvoke = lVar.invoke(Long.valueOf(j10));
        v0 v0VarA = nm.o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long j11 = jArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Long.valueOf(j11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                j10 = j11;
                rInvoke = rInvoke2;
            }
        }
        return Long.valueOf(j10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double bk(int[] iArr, jn.l<? super Integer, Double> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Integer.valueOf(iArr[0])).doubleValue();
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Integer.valueOf(iArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Boolean bl(@os.l boolean[] zArr, @os.l Comparator<? super Boolean> comparator) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            boolean z11 = zArr[it.nextInt()];
            if (comparator.compare(Boolean.valueOf(z10), Boolean.valueOf(z11)) < 0) {
                z10 = z11;
            }
        }
        return Boolean.valueOf(z10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float bm(short[] sArr, jn.l<? super Short, Float> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Short.valueOf(sArr[0])).floatValue();
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Short.valueOf(sArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R bn(long[] jArr, Comparator<? super R> comparator, jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Long.valueOf(jArr[0]));
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean bo(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return jArr.length == 0;
    }

    @lm.f1(version = "1.3")
    @an.f
    public static final boolean bp(boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return cp(zArr, rn.f.Default);
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Integer bq(@os.l int[] iArr, @os.l jn.p<? super Integer, ? super Integer, Integer> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (iArr.length == 0) {
            return null;
        }
        int iIntValue = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            iIntValue = pVar.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iArr[it.nextInt()])).intValue();
        }
        return Integer.valueOf(iIntValue);
    }

    @lm.f1(version = "1.4")
    public static void br(@os.l long[] jArr, int i10, int i11) {
        kn.l0.p(jArr, "<this>");
        nm.c.Companion.d(i10, i11, jArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            long j10 = jArr[i10];
            jArr[i10] = jArr[i13];
            jArr[i13] = j10;
            i13--;
            i10++;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Byte> bs(byte[] bArr, jn.q<? super Integer, ? super Byte, ? super Byte, Byte> qVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (bArr.length == 0) {
            return k0.INSTANCE;
        }
        byte bByteValue = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(bByteValue));
        int length = bArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            bByteValue = qVar.invoke(Integer.valueOf(i10), Byte.valueOf(bByteValue), Byte.valueOf(bArr[i10])).byteValue();
            arrayList.add(Byte.valueOf(bByteValue));
        }
        return arrayList;
    }

    public static final float bt(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Float fValueOf = null;
        boolean z10 = false;
        for (float f10 : fArr) {
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                fValueOf = Float.valueOf(f10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kn.l0.n(fValueOf, "null cannot be cast to non-null type kotlin.Float");
        return fValueOf.floatValue();
    }

    @os.l
    public static final double[] bu(@os.l double[] dArr, @os.l Collection<Integer> collection) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(collection, "indices");
        double[] dArr2 = new double[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            dArr2[i10] = dArr[it.next().intValue()];
            i10++;
        }
        return dArr2;
    }

    @os.l
    public static final int[] bv(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kn.l0.o(iArrCopyOf, "copyOf(...)");
        zu(iArrCopyOf);
        return iArrCopyOf;
    }

    public static int bw(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        return i10;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfLong")
    @lm.f1(version = "1.4")
    public static final long bx(boolean[] zArr, jn.l<? super Boolean, Long> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jLongValue = 0;
        for (boolean z10 : zArr) {
            jLongValue += lVar.invoke(Boolean.valueOf(z10)).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final Set<Integer> bz(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return (Set) ny(iArr, new LinkedHashSet(c1.j(iArr.length)));
    }

    public static final boolean c5(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (boolean z10 : zArr) {
            if (!lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @os.l
    public static final <K> Map<K, Float> c6(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends K> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        int iJ = c1.j(fArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (float f10 : fArr) {
            linkedHashMap.put(lVar.invoke(Float.valueOf(f10)), Float.valueOf(f10));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V, M extends Map<? super Integer, ? super V>> M c7(int[] iArr, M m10, jn.l<? super Integer, ? extends V> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "valueSelector");
        for (int i10 : iArr) {
            m10.put(Integer.valueOf(i10), lVar.invoke(Integer.valueOf(i10)));
        }
        return m10;
    }

    @an.f
    public static final boolean c8(boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return zArr[3];
    }

    @os.l
    public static final <T, K> List<T> c9(@os.l T[] tArr, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            if (hashSet.add(lVar.invoke(t10))) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @os.l
    public static final List<lm.t0<Float, Float>> cA(@os.l float[] fArr, @os.l float[] fArr2) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(fArr2, "other");
        int iMin = Math.min(fArr.length, fArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(Float.valueOf(fArr[i10]), Float.valueOf(fArr2[i10])));
        }
        return arrayList;
    }

    @an.f
    public static final Float ca(float[] fArr, int i10) {
        kn.l0.p(fArr, "<this>");
        return Me(fArr, i10);
    }

    @os.l
    public static final <C extends Collection<? super Short>> C cb(@os.l short[] sArr, @os.l C c10, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            if (!lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                c10.add(Short.valueOf(s10));
            }
        }
        return c10;
    }

    @os.m
    public static final Byte cc(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                return Byte.valueOf(b10);
            }
        }
        return null;
    }

    @os.l
    public static final <T, R, C extends Collection<? super R>> C cd(@os.l T[] tArr, @os.l C c10, @os.l jn.l<? super T, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (T t10 : tArr) {
            d0.r0(c10, lVar.invoke(t10));
        }
        return c10;
    }

    public static final void ce(@os.l int[] iArr, @os.l jn.p<? super Integer, ? super Integer, l2> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Integer.valueOf(iArr[i10]));
            i10++;
            i11++;
        }
    }

    @os.l
    public static final <K, V> Map<K, List<V>> cf(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends K> lVar, @os.l jn.l<? super Long, ? extends V> lVar2) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j10 : jArr) {
            K kInvoke = lVar.invoke(Long.valueOf(j10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Long.valueOf(j10)));
        }
        return linkedHashMap;
    }

    public static final int cg(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (lVar.invoke(Boolean.valueOf(zArr[length])).booleanValue()) {
                    return length;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return -1;
    }

    @os.l
    public static final <T> String ch(@os.l T[] tArr, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super T, ? extends CharSequence> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        String string = ((StringBuilder) Kg(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.m
    public static final Long ci(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            long j10 = jArr[length];
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                return Long.valueOf(j10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <T, R extends Comparable<? super R>> T cj(@os.l T[] tArr, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        int iWe = we(tArr);
        if (iWe == 0) {
            return t10;
        }
        R rInvoke = lVar.invoke(t10);
        v0 v0VarA = nm.o.a(1, iWe, 1);
        while (v0VarA.hasNext()) {
            T t11 = tArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(t11);
            if (rInvoke.compareTo(rInvoke2) < 0) {
                t10 = t11;
                rInvoke = rInvoke2;
            }
        }
        return t10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double ck(long[] jArr, jn.l<? super Long, Double> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Long.valueOf(jArr[0])).doubleValue();
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Long.valueOf(jArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Byte cl(@os.l byte[] bArr, @os.l Comparator<? super Byte> comparator) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte b11 = bArr[it.nextInt()];
            if (comparator.compare(Byte.valueOf(b10), Byte.valueOf(b11)) < 0) {
                b10 = b11;
            }
        }
        return Byte.valueOf(b10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float cm(boolean[] zArr, jn.l<? super Boolean, Float> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Boolean.valueOf(zArr[0])).floatValue();
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, lVar.invoke(Boolean.valueOf(zArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R> R cn(T[] tArr, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(tArr[0]);
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(tArr[it.nextInt()]);
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final boolean co(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @lm.f1(version = "1.3")
    public static final boolean cp(@os.l boolean[] zArr, @os.l rn.f fVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(fVar, "random");
        if (zArr.length != 0) {
            return zArr[fVar.nextInt(zArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Long cq(@os.l long[] jArr, @os.l jn.p<? super Long, ? super Long, Long> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (jArr.length == 0) {
            return null;
        }
        long jLongValue = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            jLongValue = pVar.invoke(Long.valueOf(jLongValue), Long.valueOf(jArr[it.nextInt()])).longValue();
        }
        return Long.valueOf(jLongValue);
    }

    public static final <T> void cr(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iWe = we(tArr);
        v0 v0VarA = nm.o.a(0, length, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            T t10 = tArr[iNextInt];
            tArr[iNextInt] = tArr[iWe];
            tArr[iWe] = t10;
            iWe--;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Character> cs(char[] cArr, jn.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (cArr.length == 0) {
            return k0.INSTANCE;
        }
        char c10 = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c10));
        int length = cArr.length;
        int i10 = 1;
        while (i10 < length) {
            Character chInvoke = qVar.invoke(Integer.valueOf(i10), Character.valueOf(c10), Character.valueOf(cArr[i10]));
            char cCharValue = chInvoke.charValue();
            arrayList.add(chInvoke);
            i10++;
            c10 = cCharValue;
        }
        return arrayList;
    }

    public static int ct(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return iArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @os.l
    public static final double[] cu(@os.l double[] dArr, @os.l tn.l lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? new double[0] : nm.p.h1(dArr, lVar.f15911a, lVar.f15912b + 1);
    }

    @os.l
    public static final long[] cv(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kn.l0.o(jArrCopyOf, "copyOf(...)");
        Bu(jArrCopyOf);
        return jArrCopyOf;
    }

    public static final int cw(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        int i10 = 0;
        for (short s10 : sArr) {
            i10 += s10;
        }
        return i10;
    }

    @in.i(name = "sumOfShort")
    public static final int cx(@os.l Short[] shArr) {
        kn.l0.p(shArr, "<this>");
        int iShortValue = 0;
        for (Short sh2 : shArr) {
            iShortValue += sh2.shortValue();
        }
        return iShortValue;
    }

    @os.l
    public static final List<Long> cy(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            if (!lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    @os.l
    public static final Set<Long> cz(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return (Set) oy(jArr, new LinkedHashSet(c1.j(jArr.length)));
    }

    public static boolean d5(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return !(bArr.length == 0);
    }

    @os.l
    public static final <K, V> Map<K, V> d6(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends K> lVar, @os.l jn.l<? super Float, ? extends V> lVar2) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        int iJ = c1.j(fArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (float f10 : fArr) {
            linkedHashMap.put(lVar.invoke(Float.valueOf(f10)), lVar2.invoke(Float.valueOf(f10)));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V, M extends Map<? super Long, ? super V>> M d7(long[] jArr, M m10, jn.l<? super Long, ? extends V> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "valueSelector");
        for (long j10 : jArr) {
            m10.put(Long.valueOf(j10), lVar.invoke(Long.valueOf(j10)));
        }
        return m10;
    }

    @an.f
    public static final byte d8(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return bArr[4];
    }

    @os.l
    public static final <K> List<Short> d9(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends K> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            if (hashSet.add(lVar.invoke(Short.valueOf(s10)))) {
                arrayList.add(Short.valueOf(s10));
            }
        }
        return arrayList;
    }

    @os.l
    public static final <V> List<V> dA(@os.l float[] fArr, @os.l float[] fArr2, @os.l jn.p<? super Float, ? super Float, ? extends V> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(fArr2, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(fArr.length, fArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Float.valueOf(fArr[i10]), Float.valueOf(fArr2[i10])));
        }
        return arrayList;
    }

    @an.f
    public static final Integer da(int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        return Ne(iArr, i10);
    }

    @os.l
    public static final <C extends Collection<? super Boolean>> C db(@os.l boolean[] zArr, @os.l C c10, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (boolean z10 : zArr) {
            if (!lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                c10.add(Boolean.valueOf(z10));
            }
        }
        return c10;
    }

    @os.m
    public static final Character dc(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C dd(@os.l short[] sArr, @os.l C c10, @os.l jn.l<? super Short, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (short s10 : sArr) {
            d0.r0(c10, lVar.invoke(Short.valueOf(s10)));
        }
        return c10;
    }

    public static final void de(@os.l long[] jArr, @os.l jn.p<? super Integer, ? super Long, l2> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Long.valueOf(jArr[i10]));
            i10++;
            i11++;
        }
    }

    @os.l
    public static final <T, K> Map<K, List<T>> df(@os.l T[] tArr, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : tArr) {
            K kInvoke = lVar.invoke(t10);
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(t10);
        }
        return linkedHashMap;
    }

    @os.l
    public static final Set<Byte> dg(@os.l byte[] bArr, @os.l Iterable<Byte> iterable) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Byte> setXy = Xy(bArr);
        d0.S0(setXy, iterable);
        return setXy;
    }

    @os.l
    public static final String dh(@os.l short[] sArr, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Short, ? extends CharSequence> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        String string = ((StringBuilder) Lg(sArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.m
    public static final <T> T di(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Short dj(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        int iXe = xe(sArr);
        if (iXe == 0) {
            return Short.valueOf(s10);
        }
        R rInvoke = lVar.invoke(Short.valueOf(s10));
        v0 v0VarA = nm.o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short s11 = sArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Short.valueOf(s11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                s10 = s11;
                rInvoke = rInvoke2;
            }
        }
        return Short.valueOf(s10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> Double dk(T[] tArr, jn.l<? super T, Double> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(tArr[0]).doubleValue();
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(tArr[it.nextInt()]).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Character dl(@os.l char[] cArr, @os.l Comparator<? super Character> comparator) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            char c11 = cArr[it.nextInt()];
            if (comparator.compare(Character.valueOf(c10), Character.valueOf(c11)) < 0) {
                c10 = c11;
            }
        }
        return Character.valueOf(c10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R dm(byte[] bArr, jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Byte.valueOf(bArr[0]));
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R dn(short[] sArr, Comparator<? super R> comparator, jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Short.valueOf(sArr[0]));
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Boolean dp(boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return ep(zArr, rn.f.Default);
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final <S, T extends S> S dq(@os.l T[] tArr, @os.l jn.p<? super S, ? super T, ? extends S> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (tArr.length == 0) {
            return null;
        }
        S sInvoke = (S) tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            sInvoke = pVar.invoke(sInvoke, (Object) tArr[it.nextInt()]);
        }
        return sInvoke;
    }

    @lm.f1(version = "1.4")
    public static final <T> void dr(@os.l T[] tArr, int i10, int i11) {
        kn.l0.p(tArr, "<this>");
        nm.c.Companion.d(i10, i11, tArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            T t10 = tArr[i10];
            tArr[i10] = tArr[i13];
            tArr[i13] = t10;
            i13--;
            i10++;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Double> ds(double[] dArr, jn.q<? super Integer, ? super Double, ? super Double, Double> qVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (dArr.length == 0) {
            return k0.INSTANCE;
        }
        double dDoubleValue = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(dDoubleValue));
        int length = dArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            dDoubleValue = qVar.invoke(Integer.valueOf(i10), Double.valueOf(dDoubleValue), Double.valueOf(dArr[i10])).doubleValue();
            arrayList.add(Double.valueOf(dDoubleValue));
        }
        return arrayList;
    }

    public static final int dt(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Integer numValueOf = null;
        boolean z10 = false;
        for (int i10 : iArr) {
            if (lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                numValueOf = Integer.valueOf(i10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kn.l0.n(numValueOf, "null cannot be cast to non-null type kotlin.Int");
        return numValueOf.intValue();
    }

    @os.l
    public static final float[] du(@os.l float[] fArr, @os.l Collection<Integer> collection) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(collection, "indices");
        float[] fArr2 = new float[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            fArr2[i10] = fArr[it.next().intValue()];
            i10++;
        }
        return fArr2;
    }

    @os.l
    public static final <T extends Comparable<? super T>> T[] dv(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, tArr.length);
        kn.l0.o(objArrCopyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) objArrCopyOf);
        nm.p.h4(tArr2, rm.g.x());
        return tArr2;
    }

    public static long dw(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        long j10 = 0;
        for (long j11 : jArr) {
            j10 += j11;
        }
        return j10;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final int dx(byte[] bArr, jn.l<? super Byte, lm.w1> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iM = lm.w1.m(0);
        for (byte b10 : bArr) {
            iM += lVar.invoke(Byte.valueOf(b10)).f10227a;
        }
        return iM;
    }

    @os.l
    public static final <T> List<T> dy(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            if (!lVar.invoke(t10).booleanValue()) {
                break;
            }
            arrayList.add(t10);
        }
        return arrayList;
    }

    @os.l
    public static final <T> Set<T> dz(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return (Set) py(tArr, new LinkedHashSet(c1.j(tArr.length)));
    }

    public static final boolean e5(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public static final <K> Map<K, Integer> e6(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends K> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        int iJ = c1.j(iArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (int i10 : iArr) {
            linkedHashMap.put(lVar.invoke(Integer.valueOf(i10)), Integer.valueOf(i10));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M e7(@os.l K[] kArr, @os.l M m10, @os.l jn.l<? super K, ? extends V> lVar) {
        kn.l0.p(kArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "valueSelector");
        for (K k10 : kArr) {
            m10.put(k10, lVar.invoke(k10));
        }
        return m10;
    }

    @an.f
    public static final char e8(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return cArr[4];
    }

    @os.l
    public static final <K> List<Boolean> e9(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends K> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z10 : zArr) {
            if (hashSet.add(lVar.invoke(Boolean.valueOf(z10)))) {
                arrayList.add(Boolean.valueOf(z10));
            }
        }
        return arrayList;
    }

    @os.l
    public static final <R> List<lm.t0<Float, R>> eA(@os.l float[] fArr, @os.l R[] rArr) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(rArr, "other");
        int iMin = Math.min(fArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            float f10 = fArr[i10];
            arrayList.add(new lm.t0(Float.valueOf(f10), rArr[i10]));
        }
        return arrayList;
    }

    @an.f
    public static final Long ea(long[] jArr, int i10) {
        kn.l0.p(jArr, "<this>");
        return Oe(jArr, i10);
    }

    @os.l
    public static final <C extends Collection<? super Byte>> C eb(@os.l byte[] bArr, @os.l C c10, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                c10.add(Byte.valueOf(b10));
            }
        }
        return c10;
    }

    @os.m
    public static final Character ec(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (char c10 : cArr) {
            if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                return Character.valueOf(c10);
            }
        }
        return null;
    }

    @os.l
    public static final <R, C extends Collection<? super R>> C ed(@os.l boolean[] zArr, @os.l C c10, @os.l jn.l<? super Boolean, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "transform");
        for (boolean z10 : zArr) {
            d0.r0(c10, lVar.invoke(Boolean.valueOf(z10)));
        }
        return c10;
    }

    public static final <T> void ee(@os.l T[] tArr, @os.l jn.p<? super Integer, ? super T, l2> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), tArr[i10]);
            i10++;
            i11++;
        }
    }

    @os.l
    public static final <T, K, V> Map<K, List<V>> ef(@os.l T[] tArr, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t10 : tArr) {
            K kInvoke = lVar.invoke(t10);
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(t10));
        }
        return linkedHashMap;
    }

    @os.l
    public static final Set<Character> eg(@os.l char[] cArr, @os.l Iterable<Character> iterable) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Character> setYy = Yy(cArr);
        d0.S0(setYy, iterable);
        return setYy;
    }

    @os.l
    public static final String eh(@os.l boolean[] zArr, @os.l CharSequence charSequence, @os.l CharSequence charSequence2, @os.l CharSequence charSequence3, int i10, @os.l CharSequence charSequence4, @os.m jn.l<? super Boolean, ? extends CharSequence> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(charSequence, "separator");
        kn.l0.p(charSequence2, "prefix");
        kn.l0.p(charSequence3, "postfix");
        kn.l0.p(charSequence4, "truncated");
        String string = ((StringBuilder) Mg(zArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        kn.l0.o(string, "toString(...)");
        return string;
    }

    @os.m
    public static final <T> T ei(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            T t10 = tArr[length];
            if (lVar.invoke(t10).booleanValue()) {
                return t10;
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> byte ej(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        int iQe = qe(bArr);
        if (iQe == 0) {
            return b10;
        }
        R rInvoke = lVar.invoke(Byte.valueOf(b10));
        v0 v0VarA = nm.o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte b11 = bArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Byte.valueOf(b11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                b10 = b11;
                rInvoke = rInvoke2;
            }
        }
        return b10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double ek(short[] sArr, jn.l<? super Short, Double> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Short.valueOf(sArr[0])).doubleValue();
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Short.valueOf(sArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Double el(@os.l double[] dArr, @os.l Comparator<? super Double> comparator) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            double d11 = dArr[it.nextInt()];
            if (comparator.compare(Double.valueOf(d10), Double.valueOf(d11)) < 0) {
                d10 = d11;
            }
        }
        return Double.valueOf(d10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R em(char[] cArr, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Character.valueOf(cArr[0]));
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R en(boolean[] zArr, Comparator<? super R> comparator, jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(zArr[0]));
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    public static final <T> boolean eo(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return tArr.length == 0;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Boolean ep(@os.l boolean[] zArr, @os.l rn.f fVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(fVar, "random");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[fVar.nextInt(zArr.length)]);
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Short eq(@os.l short[] sArr, @os.l jn.p<? super Short, ? super Short, Short> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (sArr.length == 0) {
            return null;
        }
        short sShortValue = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            sShortValue = pVar.invoke(Short.valueOf(sShortValue), Short.valueOf(sArr[it.nextInt()])).shortValue();
        }
        return Short.valueOf(sShortValue);
    }

    public static void er(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        int length = (sArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iXe = xe(sArr);
        v0 v0VarA = nm.o.a(0, length, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            short s10 = sArr[iNextInt];
            sArr[iNextInt] = sArr[iXe];
            sArr[iXe] = s10;
            iXe--;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Float> es(float[] fArr, jn.q<? super Integer, ? super Float, ? super Float, Float> qVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (fArr.length == 0) {
            return k0.INSTANCE;
        }
        float fFloatValue = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(fFloatValue));
        int length = fArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            fFloatValue = qVar.invoke(Integer.valueOf(i10), Float.valueOf(fFloatValue), Float.valueOf(fArr[i10])).floatValue();
            arrayList.add(Float.valueOf(fFloatValue));
        }
        return arrayList;
    }

    public static long et(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return jArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @os.l
    public static final float[] eu(@os.l float[] fArr, @os.l tn.l lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? new float[0] : nm.p.i1(fArr, lVar.f15911a, lVar.f15912b + 1);
    }

    @os.l
    public static final short[] ev(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kn.l0.o(sArrCopyOf, "copyOf(...)");
        Fu(sArrCopyOf);
        return sArrCopyOf;
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int ew(@os.l byte[] bArr, @os.l jn.l<? super Byte, Integer> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (byte b10 : bArr) {
            iIntValue += lVar.invoke(Byte.valueOf(b10)).intValue();
        }
        return iIntValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final int ex(char[] cArr, jn.l<? super Character, lm.w1> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iM = lm.w1.m(0);
        for (char c10 : cArr) {
            iM += lVar.invoke(Character.valueOf(c10)).f10227a;
        }
        return iM;
    }

    @os.l
    public static final List<Short> ey(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            if (!lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s10));
        }
        return arrayList;
    }

    @os.l
    public static final Set<Short> ez(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return (Set) qy(sArr, new LinkedHashSet(c1.j(sArr.length)));
    }

    public static final boolean f5(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return !(cArr.length == 0);
    }

    @os.l
    public static final <K, V> Map<K, V> f6(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends K> lVar, @os.l jn.l<? super Integer, ? extends V> lVar2) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        int iJ = c1.j(iArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (int i10 : iArr) {
            linkedHashMap.put(lVar.invoke(Integer.valueOf(i10)), lVar2.invoke(Integer.valueOf(i10)));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V, M extends Map<? super Short, ? super V>> M f7(short[] sArr, M m10, jn.l<? super Short, ? extends V> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "valueSelector");
        for (short s10 : sArr) {
            m10.put(Short.valueOf(s10), lVar.invoke(Short.valueOf(s10)));
        }
        return m10;
    }

    @an.f
    public static final double f8(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return dArr[4];
    }

    @os.l
    public static final List<Byte> f9(@os.l byte[] bArr, int i10) {
        kn.l0.p(bArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = bArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Ex(bArr, length);
    }

    @os.l
    public static final <R, V> List<V> fA(@os.l float[] fArr, @os.l R[] rArr, @os.l jn.p<? super Float, ? super R, ? extends V> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(rArr, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(fArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Float.valueOf(fArr[i10]), rArr[i10]));
        }
        return arrayList;
    }

    @an.f
    public static final <T> T fa(T[] tArr, int i10) {
        kn.l0.p(tArr, "<this>");
        return (T) Pe(tArr, i10);
    }

    @os.l
    public static final <C extends Collection<? super Character>> C fb(@os.l char[] cArr, @os.l C c10, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (char c11 : cArr) {
            if (lVar.invoke(Character.valueOf(c11)).booleanValue()) {
                c10.add(Character.valueOf(c11));
            }
        }
        return c10;
    }

    @os.m
    public static final Double fc(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    public static final <R> R fd(@os.l byte[] bArr, R r10, @os.l jn.p<? super R, ? super Byte, ? extends R> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (byte b10 : bArr) {
            r10 = pVar.invoke(r10, Byte.valueOf(b10));
        }
        return r10;
    }

    public static final void fe(@os.l short[] sArr, @os.l jn.p<? super Integer, ? super Short, l2> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Short.valueOf(sArr[i10]));
            i10++;
            i11++;
        }
    }

    @os.l
    public static final <K> Map<K, List<Short>> ff(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends K> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s10 : sArr) {
            K kInvoke = lVar.invoke(Short.valueOf(s10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(Short.valueOf(s10));
        }
        return linkedHashMap;
    }

    @os.l
    public static final Set<Double> fg(@os.l double[] dArr, @os.l Iterable<Double> iterable) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Double> setZy = Zy(dArr);
        d0.S0(setZy, iterable);
        return setZy;
    }

    public static /* synthetic */ String fh(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return Wg(bArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @os.m
    public static final Short fi(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> char fj(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        int iRe = re(cArr);
        if (iRe == 0) {
            return c10;
        }
        R rInvoke = lVar.invoke(Character.valueOf(c10));
        v0 v0VarA = nm.o.a(1, iRe, 1);
        while (v0VarA.hasNext()) {
            char c11 = cArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Character.valueOf(c11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                c10 = c11;
                rInvoke = rInvoke2;
            }
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double fk(boolean[] zArr, jn.l<? super Boolean, Double> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Boolean.valueOf(zArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Float fl(@os.l float[] fArr, @os.l Comparator<? super Float> comparator) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            float f11 = fArr[it.nextInt()];
            if (comparator.compare(Float.valueOf(f10), Float.valueOf(f11)) < 0) {
                f10 = f11;
            }
        }
        return Float.valueOf(f10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R fm(double[] dArr, jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Double.valueOf(dArr[0]));
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Byte fn(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte b11 = bArr[it.nextInt()];
            if (b10 > b11) {
                b10 = b11;
            }
        }
        return Byte.valueOf(b10);
    }

    public static final <T> boolean fo(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (T t10 : tArr) {
            if (lVar.invoke(t10).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Byte fp(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return gp(bArr, rn.f.Default);
    }

    public static final byte fq(@os.l byte[] bArr, @os.l jn.p<? super Byte, ? super Byte, Byte> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iQe = qe(bArr);
        if (iQe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[iQe];
        for (int i10 = iQe - 1; i10 >= 0; i10--) {
            bByteValue = pVar.invoke(Byte.valueOf(bArr[i10]), Byte.valueOf(bByteValue)).byteValue();
        }
        return bByteValue;
    }

    @lm.f1(version = "1.4")
    public static void fr(@os.l short[] sArr, int i10, int i11) {
        kn.l0.p(sArr, "<this>");
        nm.c.Companion.d(i10, i11, sArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            short s10 = sArr[i10];
            sArr[i10] = sArr[i13];
            sArr[i13] = s10;
            i13--;
            i10++;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Integer> fs(int[] iArr, jn.q<? super Integer, ? super Integer, ? super Integer, Integer> qVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (iArr.length == 0) {
            return k0.INSTANCE;
        }
        int iIntValue = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(iIntValue));
        int length = iArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            iIntValue = qVar.invoke(Integer.valueOf(i10), Integer.valueOf(iIntValue), Integer.valueOf(iArr[i10])).intValue();
            arrayList.add(Integer.valueOf(iIntValue));
        }
        return arrayList;
    }

    public static final long ft(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Long lValueOf = null;
        boolean z10 = false;
        for (long j10 : jArr) {
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                lValueOf = Long.valueOf(j10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kn.l0.n(lValueOf, "null cannot be cast to non-null type kotlin.Long");
        return lValueOf.longValue();
    }

    @os.l
    public static int[] fu(@os.l int[] iArr, @os.l Collection<Integer> collection) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(collection, "indices");
        int[] iArr2 = new int[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr2[i10] = iArr[it.next().intValue()];
            i10++;
        }
        return iArr2;
    }

    @os.l
    public static final <T> T[] fv(@os.l T[] tArr, @os.l Comparator<? super T> comparator) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kn.l0.o(tArr2, "copyOf(...)");
        nm.p.h4(tArr2, comparator);
        return tArr2;
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int fw(@os.l char[] cArr, @os.l jn.l<? super Character, Integer> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (char c10 : cArr) {
            iIntValue += lVar.invoke(Character.valueOf(c10)).intValue();
        }
        return iIntValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final int fx(double[] dArr, jn.l<? super Double, lm.w1> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iM = lm.w1.m(0);
        for (double d10 : dArr) {
            iM += lVar.invoke(Double.valueOf(d10)).f10227a;
        }
        return iM;
    }

    @os.l
    public static final List<Boolean> fy(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z10 : zArr) {
            if (!lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z10));
        }
        return arrayList;
    }

    @os.l
    public static final Set<Boolean> fz(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return (Set) ry(zArr, new LinkedHashSet(c1.j(zArr.length)));
    }

    public static final boolean g5(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (char c10 : cArr) {
            if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public static final <K> Map<K, Long> g6(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends K> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        int iJ = c1.j(jArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (long j10 : jArr) {
            linkedHashMap.put(lVar.invoke(Long.valueOf(j10)), Long.valueOf(j10));
        }
        return linkedHashMap;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <V, M extends Map<? super Boolean, ? super V>> M g7(boolean[] zArr, M m10, jn.l<? super Boolean, ? extends V> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "valueSelector");
        for (boolean z10 : zArr) {
            m10.put(Boolean.valueOf(z10), lVar.invoke(Boolean.valueOf(z10)));
        }
        return m10;
    }

    @an.f
    public static final float g8(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return fArr[4];
    }

    @os.l
    public static final List<Character> g9(@os.l char[] cArr, int i10) {
        kn.l0.p(cArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = cArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Fx(cArr, length);
    }

    @os.l
    public static final <R> List<lm.t0<Integer, R>> gA(@os.l int[] iArr, @os.l Iterable<? extends R> iterable) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(iterable, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(Integer.valueOf(iArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @an.f
    public static final Short ga(short[] sArr, int i10) {
        kn.l0.p(sArr, "<this>");
        return Qe(sArr, i10);
    }

    @os.l
    public static final <C extends Collection<? super Double>> C gb(@os.l double[] dArr, @os.l C c10, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (double d10 : dArr) {
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                c10.add(Double.valueOf(d10));
            }
        }
        return c10;
    }

    @os.m
    public static final Double gc(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (double d10 : dArr) {
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                return Double.valueOf(d10);
            }
        }
        return null;
    }

    public static final <R> R gd(@os.l char[] cArr, R r10, @os.l jn.p<? super R, ? super Character, ? extends R> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (char c10 : cArr) {
            r10 = pVar.invoke(r10, Character.valueOf(c10));
        }
        return r10;
    }

    public static final void ge(@os.l boolean[] zArr, @os.l jn.p<? super Integer, ? super Boolean, l2> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Boolean.valueOf(zArr[i10]));
            i10++;
            i11++;
        }
    }

    @os.l
    public static final <K, V> Map<K, List<V>> gf(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends K> lVar, @os.l jn.l<? super Short, ? extends V> lVar2) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s10 : sArr) {
            K kInvoke = lVar.invoke(Short.valueOf(s10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Short.valueOf(s10)));
        }
        return linkedHashMap;
    }

    @os.l
    public static final Set<Float> gg(@os.l float[] fArr, @os.l Iterable<Float> iterable) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Float> setAz = az(fArr);
        d0.S0(setAz, iterable);
        return setAz;
    }

    public static /* synthetic */ String gh(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return Xg(cArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @os.m
    public static final Short gi(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            short s10 = sArr[length];
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                return Short.valueOf(s10);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> double gj(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d10 = dArr[0];
        int iSe = se(dArr);
        if (iSe == 0) {
            return d10;
        }
        R rInvoke = lVar.invoke(Double.valueOf(d10));
        v0 v0VarA = nm.o.a(1, iSe, 1);
        while (v0VarA.hasNext()) {
            double d11 = dArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Double.valueOf(d11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                d10 = d11;
                rInvoke = rInvoke2;
            }
        }
        return d10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float gk(byte[] bArr, jn.l<? super Byte, Float> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Byte.valueOf(bArr[0])).floatValue();
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Byte.valueOf(bArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Integer gl(@os.l int[] iArr, @os.l Comparator<? super Integer> comparator) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int i11 = iArr[it.nextInt()];
            if (comparator.compare(Integer.valueOf(i10), Integer.valueOf(i11)) < 0) {
                i10 = i11;
            }
        }
        return Integer.valueOf(i10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R gm(float[] fArr, jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Float.valueOf(fArr[0]));
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Character gn(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            char c11 = cArr[it.nextInt()];
            if (kn.l0.t(c10, c11) > 0) {
                c10 = c11;
            }
        }
        return Character.valueOf(c10);
    }

    public static final boolean go(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return sArr.length == 0;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Byte gp(@os.l byte[] bArr, @os.l rn.f fVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(fVar, "random");
        if (bArr.length == 0) {
            return null;
        }
        return Byte.valueOf(bArr[fVar.nextInt(bArr.length)]);
    }

    public static final char gq(@os.l char[] cArr, @os.l jn.p<? super Character, ? super Character, Character> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iRe = re(cArr);
        if (iRe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[iRe];
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            cCharValue = pVar.invoke(Character.valueOf(cArr[i10]), Character.valueOf(cCharValue)).charValue();
        }
        return cCharValue;
    }

    public static final void gr(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        int length = (zArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int iYe = ye(zArr);
        v0 v0VarA = nm.o.a(0, length, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            boolean z10 = zArr[iNextInt];
            zArr[iNextInt] = zArr[iYe];
            zArr[iYe] = z10;
            iYe--;
        }
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Long> gs(long[] jArr, jn.q<? super Integer, ? super Long, ? super Long, Long> qVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (jArr.length == 0) {
            return k0.INSTANCE;
        }
        long jLongValue = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(jLongValue));
        int length = jArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            jLongValue = qVar.invoke(Integer.valueOf(i10), Long.valueOf(jLongValue), Long.valueOf(jArr[i10])).longValue();
            arrayList.add(Long.valueOf(jLongValue));
        }
        return arrayList;
    }

    public static <T> T gt(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @os.l
    public static int[] gu(@os.l int[] iArr, @os.l tn.l lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? new int[0] : nm.p.j1(iArr, lVar.f15911a, lVar.f15912b + 1);
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Byte> gv(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Gv(bArr, new rm.g.a(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int gw(@os.l double[] dArr, @os.l jn.l<? super Double, Integer> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (double d10 : dArr) {
            iIntValue += lVar.invoke(Double.valueOf(d10)).intValue();
        }
        return iIntValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final int gx(float[] fArr, jn.l<? super Float, lm.w1> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iM = lm.w1.m(0);
        for (float f10 : fArr) {
            iM += lVar.invoke(Float.valueOf(f10)).f10227a;
        }
        return iM;
    }

    @os.l
    public static final boolean[] gy(@os.l Boolean[] boolArr) {
        kn.l0.p(boolArr, "<this>");
        int length = boolArr.length;
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            zArr[i10] = boolArr[i10].booleanValue();
        }
        return zArr;
    }

    @os.l
    public static final Set<Byte> gz(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            return length != 1 ? (Set) jy(bArr, new LinkedHashSet(c1.j(bArr.length))) : n1.f(Byte.valueOf(bArr[0]));
        }
        return m0.INSTANCE;
    }

    public static final boolean h5(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return !(dArr.length == 0);
    }

    @os.l
    public static final <K, V> Map<K, V> h6(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends K> lVar, @os.l jn.l<? super Long, ? extends V> lVar2) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        int iJ = c1.j(jArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (long j10 : jArr) {
            linkedHashMap.put(lVar.invoke(Long.valueOf(j10)), lVar2.invoke(Long.valueOf(j10)));
        }
        return linkedHashMap;
    }

    public static final double h7(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (byte b10 : bArr) {
            d10 += (double) b10;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    @an.f
    public static final int h8(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return iArr[4];
    }

    @os.l
    public static final List<Double> h9(@os.l double[] dArr, int i10) {
        kn.l0.p(dArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = dArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Gx(dArr, length);
    }

    @os.l
    public static final <R, V> List<V> hA(@os.l int[] iArr, @os.l Iterable<? extends R> iterable, @os.l jn.p<? super Integer, ? super R, ? extends V> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(iterable, "other");
        kn.l0.p(pVar, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Integer.valueOf(iArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final List<Byte> ha(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                arrayList.add(Byte.valueOf(b10));
            }
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Float>> C hb(@os.l float[] fArr, @os.l C c10, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (float f10 : fArr) {
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                c10.add(Float.valueOf(f10));
            }
        }
        return c10;
    }

    @os.m
    public static final Float hc(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    public static final <R> R hd(@os.l double[] dArr, R r10, @os.l jn.p<? super R, ? super Double, ? extends R> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (double d10 : dArr) {
            r10 = pVar.invoke(r10, Double.valueOf(d10));
        }
        return r10;
    }

    @os.l
    public static tn.l he(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return new tn.l(0, qe(bArr), 1);
    }

    @os.l
    public static final <K> Map<K, List<Boolean>> hf(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends K> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z10 : zArr) {
            K kInvoke = lVar.invoke(Boolean.valueOf(z10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(Boolean.valueOf(z10));
        }
        return linkedHashMap;
    }

    @os.l
    public static final Set<Integer> hg(@os.l int[] iArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Integer> setBz = bz(iArr);
        d0.S0(setBz, iterable);
        return setBz;
    }

    public static /* synthetic */ String hh(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return Yg(dArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @os.l
    public static final <R> List<R> hi(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b10 : bArr) {
            arrayList.add(lVar.invoke(Byte.valueOf(b10)));
        }
        return arrayList;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> float hj(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f10 = fArr[0];
        int iTe = te(fArr);
        if (iTe == 0) {
            return f10;
        }
        R rInvoke = lVar.invoke(Float.valueOf(f10));
        v0 v0VarA = nm.o.a(1, iTe, 1);
        while (v0VarA.hasNext()) {
            float f11 = fArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Float.valueOf(f11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                f10 = f11;
                rInvoke = rInvoke2;
            }
        }
        return f10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float hk(char[] cArr, jn.l<? super Character, Float> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Character.valueOf(cArr[0])).floatValue();
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Character.valueOf(cArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Long hl(@os.l long[] jArr, @os.l Comparator<? super Long> comparator) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long j11 = jArr[it.nextInt()];
            if (comparator.compare(Long.valueOf(j10), Long.valueOf(j11)) < 0) {
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R hm(int[] iArr, jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Integer.valueOf(iArr[0]));
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <T extends Comparable<? super T>> T hn(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            T t11 = tArr[it.nextInt()];
            if (t10.compareTo(t11) > 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    public static final boolean ho(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Character hp(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return ip(cArr, rn.f.Default);
    }

    public static final double hq(@os.l double[] dArr, @os.l jn.p<? super Double, ? super Double, Double> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iSe = se(dArr);
        if (iSe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[iSe];
        for (int i10 = iSe - 1; i10 >= 0; i10--) {
            dDoubleValue = pVar.invoke(Double.valueOf(dArr[i10]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return dDoubleValue;
    }

    @lm.f1(version = "1.4")
    public static final void hr(@os.l boolean[] zArr, int i10, int i11) {
        kn.l0.p(zArr, "<this>");
        nm.c.Companion.d(i10, i11, zArr.length);
        int i12 = (i10 + i11) / 2;
        if (i10 == i12) {
            return;
        }
        int i13 = i11 - 1;
        while (i10 < i12) {
            boolean z10 = zArr[i10];
            zArr[i10] = zArr[i13];
            zArr[i13] = z10;
            i13--;
            i10++;
        }
    }

    @lm.f1(version = "1.4")
    @os.l
    public static final <S, T extends S> List<S> hs(@os.l T[] tArr, @os.l jn.q<? super Integer, ? super S, ? super T, ? extends S> qVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (tArr.length == 0) {
            return k0.INSTANCE;
        }
        S sInvoke = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(sInvoke);
        int length = tArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            sInvoke = qVar.invoke(Integer.valueOf(i10), sInvoke, (Object) tArr[i10]);
            arrayList.add(sInvoke);
        }
        return arrayList;
    }

    public static final <T> T ht(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        T t10 = null;
        boolean z10 = false;
        for (T t11 : tArr) {
            if (lVar.invoke(t11).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                z10 = true;
                t10 = t11;
            }
        }
        if (z10) {
            return t10;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @os.l
    public static long[] hu(@os.l long[] jArr, @os.l Collection<Integer> collection) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(collection, "indices");
        long[] jArr2 = new long[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            jArr2[i10] = jArr[it.next().intValue()];
            i10++;
        }
        return jArr2;
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Character> hv(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Hv(cArr, new rm.g.a(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int hw(@os.l float[] fArr, @os.l jn.l<? super Float, Integer> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (float f10 : fArr) {
            iIntValue += lVar.invoke(Float.valueOf(f10)).intValue();
        }
        return iIntValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final int hx(int[] iArr, jn.l<? super Integer, lm.w1> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iM = lm.w1.m(0);
        for (int i10 : iArr) {
            iM += lVar.invoke(Integer.valueOf(i10)).f10227a;
        }
        return iM;
    }

    @os.l
    public static final byte[] hy(@os.l Byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr2[i10] = bArr[i10].byteValue();
        }
        return bArr2;
    }

    @os.l
    public static final Set<Character> hz(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            return m0.INSTANCE;
        }
        if (length == 1) {
            return n1.f(Character.valueOf(cArr[0]));
        }
        int length2 = cArr.length;
        if (length2 > 128) {
            length2 = 128;
        }
        return (Set) ky(cArr, new LinkedHashSet(c1.j(length2)));
    }

    public static final boolean i5(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (double d10 : dArr) {
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public static final <T, K> Map<K, T> i6(@os.l T[] tArr, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        int iJ = c1.j(tArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (T t10 : tArr) {
            linkedHashMap.put(lVar.invoke(t10), t10);
        }
        return linkedHashMap;
    }

    public static final double i7(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (double d11 : dArr) {
            d10 += d11;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    @an.f
    public static final long i8(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return jArr[4];
    }

    @os.l
    public static final List<Float> i9(@os.l float[] fArr, int i10) {
        kn.l0.p(fArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = fArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Hx(fArr, length);
    }

    @os.l
    public static final List<lm.t0<Integer, Integer>> iA(@os.l int[] iArr, @os.l int[] iArr2) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(iArr2, "other");
        int iMin = Math.min(iArr.length, iArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(Integer.valueOf(iArr[i10]), Integer.valueOf(iArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final List<Character> ia(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c10 : cArr) {
            if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                arrayList.add(Character.valueOf(c10));
            }
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Integer>> C ib(@os.l int[] iArr, @os.l C c10, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            if (lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                c10.add(Integer.valueOf(i10));
            }
        }
        return c10;
    }

    @os.m
    public static final Float ic(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (float f10 : fArr) {
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                return Float.valueOf(f10);
            }
        }
        return null;
    }

    public static final <R> R id(@os.l float[] fArr, R r10, @os.l jn.p<? super R, ? super Float, ? extends R> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (float f10 : fArr) {
            r10 = pVar.invoke(r10, Float.valueOf(f10));
        }
        return r10;
    }

    @os.l
    public static final tn.l ie(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return new tn.l(0, re(cArr), 1);
    }

    @os.l
    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static final <K, V> Map<K, List<V>> m68if(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends K> lVar, @os.l jn.l<? super Boolean, ? extends V> lVar2) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z10 : zArr) {
            K kInvoke = lVar.invoke(Boolean.valueOf(z10));
            Object objA = linkedHashMap.get(kInvoke);
            if (objA == null) {
                objA = ik.v.a(linkedHashMap, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Boolean.valueOf(z10)));
        }
        return linkedHashMap;
    }

    @os.l
    public static final Set<Long> ig(@os.l long[] jArr, @os.l Iterable<Long> iterable) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Long> setCz = cz(jArr);
        d0.S0(setCz, iterable);
        return setCz;
    }

    public static /* synthetic */ String ih(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return Zg(fArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @os.l
    public static final <R> List<R> ii(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c10 : cArr) {
            arrayList.add(lVar.invoke(Character.valueOf(c10)));
        }
        return arrayList;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> int ij(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        int iUe = ue(iArr);
        if (iUe == 0) {
            return i10;
        }
        R rInvoke = lVar.invoke(Integer.valueOf(i10));
        v0 v0VarA = nm.o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int i11 = iArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Integer.valueOf(i11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                i10 = i11;
                rInvoke = rInvoke2;
            }
        }
        return i10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float ik(double[] dArr, jn.l<? super Double, Float> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Double.valueOf(dArr[0])).floatValue();
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Double.valueOf(dArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <T> T il(@os.l T[] tArr, @os.l Comparator<? super T> comparator) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            T t11 = tArr[it.nextInt()];
            if (comparator.compare(t10, t11) < 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R im(long[] jArr, jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Long.valueOf(jArr[0]));
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Double in(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dMin = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            dMin = Math.min(dMin, dArr[it.nextInt()]);
        }
        return Double.valueOf(dMin);
    }

    public static final boolean io(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return zArr.length == 0;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Character ip(@os.l char[] cArr, @os.l rn.f fVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(fVar, "random");
        if (cArr.length == 0) {
            return null;
        }
        return Character.valueOf(cArr[fVar.nextInt(cArr.length)]);
    }

    public static final float iq(@os.l float[] fArr, @os.l jn.p<? super Float, ? super Float, Float> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iTe = te(fArr);
        if (iTe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[iTe];
        for (int i10 = iTe - 1; i10 >= 0; i10--) {
            fFloatValue = pVar.invoke(Float.valueOf(fArr[i10]), Float.valueOf(fFloatValue)).floatValue();
        }
        return fFloatValue;
    }

    @os.l
    public static final List<Byte> ir(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return k0.INSTANCE;
        }
        List<Byte> listOy = Oy(bArr);
        g0.r1(listOy);
        return listOy;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Short> is(short[] sArr, jn.q<? super Integer, ? super Short, ? super Short, Short> qVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (sArr.length == 0) {
            return k0.INSTANCE;
        }
        short sShortValue = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(sShortValue));
        int length = sArr.length;
        for (int i10 = 1; i10 < length; i10++) {
            sShortValue = qVar.invoke(Integer.valueOf(i10), Short.valueOf(sShortValue), Short.valueOf(sArr[i10])).shortValue();
            arrayList.add(Short.valueOf(sShortValue));
        }
        return arrayList;
    }

    @os.l
    public static long[] iu(@os.l long[] jArr, @os.l tn.l lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? new long[0] : nm.p.k1(jArr, lVar.f15911a, lVar.f15912b + 1);
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Double> iv(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Iv(dArr, new rm.g.a(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int iw(@os.l int[] iArr, @os.l jn.l<? super Integer, Integer> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (int i10 : iArr) {
            iIntValue += lVar.invoke(Integer.valueOf(i10)).intValue();
        }
        return iIntValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final int ix(long[] jArr, jn.l<? super Long, lm.w1> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iM = lm.w1.m(0);
        for (long j10 : jArr) {
            iM += lVar.invoke(Long.valueOf(j10)).f10227a;
        }
        return iM;
    }

    @os.l
    public static final char[] iy(@os.l Character[] chArr) {
        kn.l0.p(chArr, "<this>");
        int length = chArr.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = chArr[i10].charValue();
        }
        return cArr;
    }

    @os.l
    public static final Set<Double> iz(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            return length != 1 ? (Set) ly(dArr, new LinkedHashSet(c1.j(dArr.length))) : n1.f(Double.valueOf(dArr[0]));
        }
        return m0.INSTANCE;
    }

    public static final boolean j5(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return !(fArr.length == 0);
    }

    @os.l
    public static final <T, K, V> Map<K, V> j6(@os.l T[] tArr, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        int iJ = c1.j(tArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (T t10 : tArr) {
            linkedHashMap.put(lVar.invoke(t10), lVar2.invoke(t10));
        }
        return linkedHashMap;
    }

    public static final double j7(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (float f10 : fArr) {
            d10 += (double) f10;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    @an.f
    public static final <T> T j8(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return tArr[4];
    }

    @os.l
    public static final List<Integer> j9(@os.l int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = iArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Ix(iArr, length);
    }

    @os.l
    public static final <V> List<V> jA(@os.l int[] iArr, @os.l int[] iArr2, @os.l jn.p<? super Integer, ? super Integer, ? extends V> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(iArr2, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(iArr.length, iArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Integer.valueOf(iArr[i10]), Integer.valueOf(iArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final List<Double> ja(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d10 : dArr) {
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                arrayList.add(Double.valueOf(d10));
            }
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Long>> C jb(@os.l long[] jArr, @os.l C c10, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                c10.add(Long.valueOf(j10));
            }
        }
        return c10;
    }

    @os.m
    public static final Integer jc(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    public static final <R> R jd(@os.l int[] iArr, R r10, @os.l jn.p<? super R, ? super Integer, ? extends R> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (int i10 : iArr) {
            r10 = pVar.invoke(r10, Integer.valueOf(i10));
        }
        return r10;
    }

    @os.l
    public static final tn.l je(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return new tn.l(0, se(dArr), 1);
    }

    @os.l
    public static final <K, M extends Map<? super K, List<Byte>>> M jf(@os.l byte[] bArr, @os.l M m10, @os.l jn.l<? super Byte, ? extends K> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (byte b10 : bArr) {
            K kInvoke = lVar.invoke(Byte.valueOf(b10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(Byte.valueOf(b10));
        }
        return m10;
    }

    @os.l
    public static final <T> Set<T> jg(@os.l T[] tArr, @os.l Iterable<? extends T> iterable) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<T> setDz = dz(tArr);
        d0.S0(setDz, iterable);
        return setDz;
    }

    public static /* synthetic */ String jh(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return ah(iArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @os.l
    public static final <R> List<R> ji(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d10 : dArr) {
            arrayList.add(lVar.invoke(Double.valueOf(d10)));
        }
        return arrayList;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> long jj(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        int iVe = ve(jArr);
        if (iVe == 0) {
            return j10;
        }
        R rInvoke = lVar.invoke(Long.valueOf(j10));
        v0 v0VarA = nm.o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long j11 = jArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Long.valueOf(j11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                j10 = j11;
                rInvoke = rInvoke2;
            }
        }
        return j10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float jk(float[] fArr, jn.l<? super Float, Float> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Float.valueOf(fArr[0])).floatValue();
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Float.valueOf(fArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Short jl(@os.l short[] sArr, @os.l Comparator<? super Short> comparator) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short s11 = sArr[it.nextInt()];
            if (comparator.compare(Short.valueOf(s10), Short.valueOf(s11)) < 0) {
                s10 = s11;
            }
        }
        return Short.valueOf(s10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R jm(T[] tArr, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(tArr[0]);
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(tArr[it.nextInt()]);
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Double jn(@os.l Double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = dArr[0].doubleValue();
        v0 it = new tn.l(1, we(dArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, dArr[it.nextInt()].doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    public static final boolean jo(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (boolean z10 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Double jp(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return kp(dArr, rn.f.Default);
    }

    public static final int jq(@os.l int[] iArr, @os.l jn.p<? super Integer, ? super Integer, Integer> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iUe = ue(iArr);
        if (iUe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[iUe];
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            iIntValue = pVar.invoke(Integer.valueOf(iArr[i10]), Integer.valueOf(iIntValue)).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final List<Character> jr(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return k0.INSTANCE;
        }
        List<Character> listPy = Py(cArr);
        g0.r1(listPy);
        return listPy;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final List<Boolean> js(boolean[] zArr, jn.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> qVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (zArr.length == 0) {
            return k0.INSTANCE;
        }
        boolean z10 = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z10));
        int length = zArr.length;
        int i10 = 1;
        while (i10 < length) {
            Boolean boolInvoke = qVar.invoke(Integer.valueOf(i10), Boolean.valueOf(z10), Boolean.valueOf(zArr[i10]));
            boolean zBooleanValue = boolInvoke.booleanValue();
            arrayList.add(boolInvoke);
            i10++;
            z10 = zBooleanValue;
        }
        return arrayList;
    }

    public static short jt(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return sArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @os.l
    public static final <T> T[] ju(@os.l T[] tArr, @os.l Collection<Integer> collection) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(collection, "indices");
        T[] tArr2 = (T[]) nm.m.a(tArr, collection.size());
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            tArr2[i10] = tArr[it.next().intValue()];
            i10++;
        }
        return tArr2;
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Float> jv(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Jv(fArr, new rm.g.a(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int jw(@os.l long[] jArr, @os.l jn.l<? super Long, Integer> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (long j10 : jArr) {
            iIntValue += lVar.invoke(Long.valueOf(j10)).intValue();
        }
        return iIntValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final <T> int jx(T[] tArr, jn.l<? super T, lm.w1> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iM = lm.w1.m(0);
        for (T t10 : tArr) {
            iM += lVar.invoke(t10).f10227a;
        }
        return iM;
    }

    @os.l
    public static final <C extends Collection<? super Byte>> C jy(@os.l byte[] bArr, @os.l C c10) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (byte b10 : bArr) {
            c10.add(Byte.valueOf(b10));
        }
        return c10;
    }

    @os.l
    public static final Set<Float> jz(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            return length != 1 ? (Set) my(fArr, new LinkedHashSet(c1.j(fArr.length))) : n1.f(Float.valueOf(fArr[0]));
        }
        return m0.INSTANCE;
    }

    public static final boolean k5(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (float f10 : fArr) {
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public static final <K> Map<K, Short> k6(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends K> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        int iJ = c1.j(sArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (short s10 : sArr) {
            linkedHashMap.put(lVar.invoke(Short.valueOf(s10)), Short.valueOf(s10));
        }
        return linkedHashMap;
    }

    public static final double k7(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (int i11 : iArr) {
            d10 += (double) i11;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    @an.f
    public static final short k8(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return sArr[4];
    }

    @os.l
    public static final List<Long> k9(@os.l long[] jArr, int i10) {
        kn.l0.p(jArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = jArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Jx(jArr, length);
    }

    @os.l
    public static final <R> List<lm.t0<Integer, R>> kA(@os.l int[] iArr, @os.l R[] rArr) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(rArr, "other");
        int iMin = Math.min(iArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            int i11 = iArr[i10];
            arrayList.add(new lm.t0(Integer.valueOf(i11), rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final List<Float> ka(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f10 : fArr) {
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                arrayList.add(Float.valueOf(f10));
            }
        }
        return arrayList;
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C kb(@os.l T[] tArr, @os.l C c10, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (T t10 : tArr) {
            if (lVar.invoke(t10).booleanValue()) {
                c10.add(t10);
            }
        }
        return c10;
    }

    @os.m
    public static final Integer kc(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            if (lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                return Integer.valueOf(i10);
            }
        }
        return null;
    }

    public static final <R> R kd(@os.l long[] jArr, R r10, @os.l jn.p<? super R, ? super Long, ? extends R> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (long j10 : jArr) {
            r10 = pVar.invoke(r10, Long.valueOf(j10));
        }
        return r10;
    }

    @os.l
    public static final tn.l ke(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return new tn.l(0, te(fArr), 1);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, List<V>>> M kf(@os.l byte[] bArr, @os.l M m10, @os.l jn.l<? super Byte, ? extends K> lVar, @os.l jn.l<? super Byte, ? extends V> lVar2) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (byte b10 : bArr) {
            K kInvoke = lVar.invoke(Byte.valueOf(b10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Byte.valueOf(b10)));
        }
        return m10;
    }

    @os.l
    public static final Set<Short> kg(@os.l short[] sArr, @os.l Iterable<Short> iterable) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Short> setEz = ez(sArr);
        d0.S0(setEz, iterable);
        return setEz;
    }

    public static /* synthetic */ String kh(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return bh(jArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @os.l
    public static final <R> List<R> ki(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f10 : fArr) {
            arrayList.add(lVar.invoke(Float.valueOf(f10)));
        }
        return arrayList;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T kj(@os.l T[] tArr, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        int iWe = we(tArr);
        if (iWe == 0) {
            return t10;
        }
        R rInvoke = lVar.invoke(t10);
        v0 v0VarA = nm.o.a(1, iWe, 1);
        while (v0VarA.hasNext()) {
            T t11 = tArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(t11);
            if (rInvoke.compareTo(rInvoke2) < 0) {
                t10 = t11;
                rInvoke = rInvoke2;
            }
        }
        return t10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float kk(int[] iArr, jn.l<? super Integer, Float> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Integer.valueOf(iArr[0])).floatValue();
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Integer.valueOf(iArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final byte kl(@os.l byte[] bArr, @os.l Comparator<? super Byte> comparator) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte b11 = bArr[it.nextInt()];
            if (comparator.compare(Byte.valueOf(b10), Byte.valueOf(b11)) < 0) {
                b10 = b11;
            }
        }
        return b10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R km(short[] sArr, jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Short.valueOf(sArr[0]));
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Float kn(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fMin = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            fMin = Math.min(fMin, fArr[it.nextInt()]);
        }
        return Float.valueOf(fMin);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final byte[] ko(byte[] bArr, jn.l<? super Byte, l2> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (byte b10 : bArr) {
            lVar.invoke(Byte.valueOf(b10));
        }
        return bArr;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Double kp(@os.l double[] dArr, @os.l rn.f fVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(fVar, "random");
        if (dArr.length == 0) {
            return null;
        }
        return Double.valueOf(dArr[fVar.nextInt(dArr.length)]);
    }

    public static final long kq(@os.l long[] jArr, @os.l jn.p<? super Long, ? super Long, Long> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iVe = ve(jArr);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[iVe];
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            jLongValue = pVar.invoke(Long.valueOf(jArr[i10]), Long.valueOf(jLongValue)).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final List<Double> kr(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return k0.INSTANCE;
        }
        List<Double> listQy = Qy(dArr);
        g0.r1(listQy);
        return listQy;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> ks(byte[] bArr, R r10, jn.p<? super R, ? super Byte, ? extends R> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (bArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        for (byte b10 : bArr) {
            r10 = pVar.invoke(r10, Byte.valueOf(b10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    public static final short kt(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Short shValueOf = null;
        boolean z10 = false;
        for (short s10 : sArr) {
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                shValueOf = Short.valueOf(s10);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kn.l0.n(shValueOf, "null cannot be cast to non-null type kotlin.Short");
        return shValueOf.shortValue();
    }

    @os.l
    public static final <T> T[] ku(@os.l T[] tArr, @os.l tn.l lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? (T[]) nm.p.l1(tArr, 0, 0) : (T[]) nm.p.l1(tArr, lVar.f15911a, lVar.f15912b + 1);
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Integer> kv(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Kv(iArr, new rm.g.a(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final <T> int kw(@os.l T[] tArr, @os.l jn.l<? super T, Integer> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (T t10 : tArr) {
            iIntValue += lVar.invoke(t10).intValue();
        }
        return iIntValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final int kx(short[] sArr, jn.l<? super Short, lm.w1> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iM = lm.w1.m(0);
        for (short s10 : sArr) {
            iM += lVar.invoke(Short.valueOf(s10)).f10227a;
        }
        return iM;
    }

    @os.l
    public static final <C extends Collection<? super Character>> C ky(@os.l char[] cArr, @os.l C c10) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (char c11 : cArr) {
            c10.add(Character.valueOf(c11));
        }
        return c10;
    }

    @os.l
    public static final Set<Integer> kz(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            return length != 1 ? (Set) ny(iArr, new LinkedHashSet(c1.j(iArr.length))) : n1.f(Integer.valueOf(iArr[0]));
        }
        return m0.INSTANCE;
    }

    public static boolean l5(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return !(iArr.length == 0);
    }

    @os.l
    public static final <K, V> Map<K, V> l6(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends K> lVar, @os.l jn.l<? super Short, ? extends V> lVar2) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        int iJ = c1.j(sArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (short s10 : sArr) {
            linkedHashMap.put(lVar.invoke(Short.valueOf(s10)), lVar2.invoke(Short.valueOf(s10)));
        }
        return linkedHashMap;
    }

    public static final double l7(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (long j10 : jArr) {
            d10 += j10;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    @an.f
    public static final boolean l8(boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return zArr[4];
    }

    @os.l
    public static <T> List<T> l9(@os.l T[] tArr, int i10) {
        kn.l0.p(tArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = tArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Kx(tArr, length);
    }

    @os.l
    public static final <R, V> List<V> lA(@os.l int[] iArr, @os.l R[] rArr, @os.l jn.p<? super Integer, ? super R, ? extends V> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(rArr, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(iArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Integer.valueOf(iArr[i10]), rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final List<Integer> la(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Short>> C lb(@os.l short[] sArr, @os.l C c10, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                c10.add(Short.valueOf(s10));
            }
        }
        return c10;
    }

    @os.m
    public static final Long lc(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R ld(@os.l T[] tArr, R r10, @os.l jn.p<? super R, ? super T, ? extends R> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (a1.d dVar : tArr) {
            r10 = pVar.invoke(r10, dVar);
        }
        return r10;
    }

    @os.l
    public static tn.l le(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return new tn.l(0, ue(iArr), 1);
    }

    @os.l
    public static final <K, M extends Map<? super K, List<Character>>> M lf(@os.l char[] cArr, @os.l M m10, @os.l jn.l<? super Character, ? extends K> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (char c10 : cArr) {
            K kInvoke = lVar.invoke(Character.valueOf(c10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(Character.valueOf(c10));
        }
        return m10;
    }

    @os.l
    public static final Set<Boolean> lg(@os.l boolean[] zArr, @os.l Iterable<Boolean> iterable) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Boolean> setFz = fz(zArr);
        d0.S0(setFz, iterable);
        return setFz;
    }

    public static /* synthetic */ String lh(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return ch(objArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @os.l
    public static final <R> List<R> li(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(lVar.invoke(Integer.valueOf(i10)));
        }
        return arrayList;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> short lj(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        int iXe = xe(sArr);
        if (iXe == 0) {
            return s10;
        }
        R rInvoke = lVar.invoke(Short.valueOf(s10));
        v0 v0VarA = nm.o.a(1, iXe, 1);
        while (v0VarA.hasNext()) {
            short s11 = sArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Short.valueOf(s11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                s10 = s11;
                rInvoke = rInvoke2;
            }
        }
        return s10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float lk(long[] jArr, jn.l<? super Long, Float> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Long.valueOf(jArr[0])).floatValue();
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Long.valueOf(jArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final char ll(@os.l char[] cArr, @os.l Comparator<? super Character> comparator) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            char c11 = cArr[it.nextInt()];
            if (comparator.compare(Character.valueOf(c10), Character.valueOf(c11)) < 0) {
                c10 = c11;
            }
        }
        return c10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R lm(boolean[] zArr, jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(zArr[0]));
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Float ln(@os.l Float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        float fFloatValue = fArr[0].floatValue();
        v0 it = new tn.l(1, we(fArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, fArr[it.nextInt()].floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final char[] lo(char[] cArr, jn.l<? super Character, l2> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (char c10 : cArr) {
            lVar.invoke(Character.valueOf(c10));
        }
        return cArr;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Float lp(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return mp(fArr, rn.f.Default);
    }

    public static final <S, T extends S> S lq(@os.l T[] tArr, @os.l jn.p<? super T, ? super S, ? extends S> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iWe = we(tArr);
        if (iWe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sInvoke = (S) tArr[iWe];
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            sInvoke = pVar.invoke((Object) tArr[i10], sInvoke);
        }
        return sInvoke;
    }

    @os.l
    public static final List<Float> lr(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return k0.INSTANCE;
        }
        List<Float> listRy = Ry(fArr);
        g0.r1(listRy);
        return listRy;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> ls(char[] cArr, R r10, jn.p<? super R, ? super Character, ? extends R> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (cArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r10);
        for (char c10 : cArr) {
            r10 = pVar.invoke(r10, Character.valueOf(c10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    public static final boolean lt(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return zArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @os.l
    public static short[] lu(@os.l short[] sArr, @os.l Collection<Integer> collection) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(collection, "indices");
        short[] sArr2 = new short[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            sArr2[i10] = sArr[it.next().intValue()];
            i10++;
        }
        return sArr2;
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Long> lv(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Lv(jArr, new rm.g.a(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int lw(@os.l short[] sArr, @os.l jn.l<? super Short, Integer> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (short s10 : sArr) {
            iIntValue += lVar.invoke(Short.valueOf(s10)).intValue();
        }
        return iIntValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfUInt")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final int lx(boolean[] zArr, jn.l<? super Boolean, lm.w1> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iM = lm.w1.m(0);
        for (boolean z10 : zArr) {
            iM += lVar.invoke(Boolean.valueOf(z10)).f10227a;
        }
        return iM;
    }

    @os.l
    public static final <C extends Collection<? super Double>> C ly(@os.l double[] dArr, @os.l C c10) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (double d10 : dArr) {
            c10.add(Double.valueOf(d10));
        }
        return c10;
    }

    @os.l
    public static final Set<Long> lz(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            return length != 1 ? (Set) oy(jArr, new LinkedHashSet(c1.j(jArr.length))) : n1.f(Long.valueOf(jArr[0]));
        }
        return m0.INSTANCE;
    }

    public static final boolean m5(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            if (lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public static final <K> Map<K, Boolean> m6(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends K> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        int iJ = c1.j(zArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (boolean z10 : zArr) {
            linkedHashMap.put(lVar.invoke(Boolean.valueOf(z10)), Boolean.valueOf(z10));
        }
        return linkedHashMap;
    }

    public static final double m7(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        double d10 = 0.0d;
        int i10 = 0;
        for (short s10 : sArr) {
            d10 += (double) s10;
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return d10 / ((double) i10);
    }

    public static boolean m8(@os.l byte[] bArr, byte b10) {
        kn.l0.p(bArr, "<this>");
        return Cf(bArr, b10) >= 0;
    }

    @os.l
    public static final List<Short> m9(@os.l short[] sArr, int i10) {
        kn.l0.p(sArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = sArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Lx(sArr, length);
    }

    @os.l
    public static final <R> List<lm.t0<Long, R>> mA(@os.l long[] jArr, @os.l Iterable<? extends R> iterable) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(iterable, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(Long.valueOf(jArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final List<Long> ma(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                arrayList.add(Long.valueOf(j10));
            }
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Boolean>> C mb(@os.l boolean[] zArr, @os.l C c10, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "predicate");
        for (boolean z10 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                c10.add(Boolean.valueOf(z10));
            }
        }
        return c10;
    }

    @os.m
    public static final Long mc(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                return Long.valueOf(j10);
            }
        }
        return null;
    }

    public static final <R> R md(@os.l short[] sArr, R r10, @os.l jn.p<? super R, ? super Short, ? extends R> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (short s10 : sArr) {
            r10 = pVar.invoke(r10, Short.valueOf(s10));
        }
        return r10;
    }

    @os.l
    public static tn.l me(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return new tn.l(0, ve(jArr), 1);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, List<V>>> M mf(@os.l char[] cArr, @os.l M m10, @os.l jn.l<? super Character, ? extends K> lVar, @os.l jn.l<? super Character, ? extends V> lVar2) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (char c10 : cArr) {
            K kInvoke = lVar.invoke(Character.valueOf(c10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Character.valueOf(c10)));
        }
        return m10;
    }

    @an.f
    public static final boolean mg(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return bArr.length == 0;
    }

    public static /* synthetic */ String mh(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return dh(sArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @os.l
    public static final <R> List<R> mi(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j10 : jArr) {
            arrayList.add(lVar.invoke(Long.valueOf(j10)));
        }
        return arrayList;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxByOrThrow")
    public static final <R extends Comparable<? super R>> boolean mj(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z10 = zArr[0];
        int iYe = ye(zArr);
        if (iYe == 0) {
            return z10;
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(z10));
        v0 v0VarA = nm.o.a(1, iYe, 1);
        while (v0VarA.hasNext()) {
            boolean z11 = zArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Boolean.valueOf(z11));
            if (rInvoke.compareTo(rInvoke2) < 0) {
                z10 = z11;
                rInvoke = rInvoke2;
            }
        }
        return z10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> Float mk(T[] tArr, jn.l<? super T, Float> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(tArr[0]).floatValue();
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(tArr[it.nextInt()]).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final double ml(@os.l double[] dArr, @os.l Comparator<? super Double> comparator) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double d10 = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            double d11 = dArr[it.nextInt()];
            if (comparator.compare(Double.valueOf(d10), Double.valueOf(d11)) < 0) {
                d10 = d11;
            }
        }
        return d10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R mm(byte[] bArr, jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Byte.valueOf(bArr[0]));
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Integer mn(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int i11 = iArr[it.nextInt()];
            if (i10 > i11) {
                i10 = i11;
            }
        }
        return Integer.valueOf(i10);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final double[] mo(double[] dArr, jn.l<? super Double, l2> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (double d10 : dArr) {
            lVar.invoke(Double.valueOf(d10));
        }
        return dArr;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Float mp(@os.l float[] fArr, @os.l rn.f fVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(fVar, "random");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fVar.nextInt(fArr.length)]);
    }

    public static final short mq(@os.l short[] sArr, @os.l jn.p<? super Short, ? super Short, Short> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iXe = xe(sArr);
        if (iXe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[iXe];
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sShortValue = pVar.invoke(Short.valueOf(sArr[i10]), Short.valueOf(sShortValue)).shortValue();
        }
        return sShortValue;
    }

    @os.l
    public static final List<Integer> mr(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return k0.INSTANCE;
        }
        List<Integer> listSy = Sy(iArr);
        g0.r1(listSy);
        return listSy;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> ms(double[] dArr, R r10, jn.p<? super R, ? super Double, ? extends R> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (dArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r10);
        for (double d10 : dArr) {
            r10 = pVar.invoke(r10, Double.valueOf(d10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    public static final boolean mt(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Boolean boolValueOf = null;
        boolean z10 = false;
        for (boolean z11 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z11)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                boolValueOf = Boolean.valueOf(z11);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        kn.l0.n(boolValueOf, "null cannot be cast to non-null type kotlin.Boolean");
        return boolValueOf.booleanValue();
    }

    @os.l
    public static short[] mu(@os.l short[] sArr, @os.l tn.l lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? new short[0] : nm.p.m1(sArr, lVar.f15911a, lVar.f15912b + 1);
    }

    @os.l
    public static final <T, R extends Comparable<? super R>> List<T> mv(@os.l T[] tArr, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Mv(tArr, new rm.g.a(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final int mw(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Integer> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        int iIntValue = 0;
        for (boolean z10 : zArr) {
            iIntValue += lVar.invoke(Boolean.valueOf(z10)).intValue();
        }
        return iIntValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final long mx(byte[] bArr, jn.l<? super Byte, a2> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (byte b10 : bArr) {
            jM += lVar.invoke(Byte.valueOf(b10)).f10177a;
        }
        return jM;
    }

    @os.l
    public static final <C extends Collection<? super Float>> C my(@os.l float[] fArr, @os.l C c10) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (float f10 : fArr) {
            c10.add(Float.valueOf(f10));
        }
        return c10;
    }

    @os.l
    public static <T> Set<T> mz(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            return length != 1 ? (Set) py(tArr, new LinkedHashSet(c1.j(tArr.length))) : n1.f(tArr[0]);
        }
        return m0.INSTANCE;
    }

    public static boolean n5(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return !(jArr.length == 0);
    }

    @os.l
    public static final <K, V> Map<K, V> n6(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends K> lVar, @os.l jn.l<? super Boolean, ? extends V> lVar2) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        int iJ = c1.j(zArr.length);
        if (iJ < 16) {
            iJ = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
        for (boolean z10 : zArr) {
            linkedHashMap.put(lVar.invoke(Boolean.valueOf(z10)), lVar2.invoke(Boolean.valueOf(z10)));
        }
        return linkedHashMap;
    }

    @in.i(name = "averageOfByte")
    public static final double n7(@os.l Byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        double dByteValue = 0.0d;
        int i10 = 0;
        for (Byte b10 : bArr) {
            dByteValue += (double) b10.byteValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dByteValue / ((double) i10);
    }

    public static boolean n8(@os.l char[] cArr, char c10) {
        kn.l0.p(cArr, "<this>");
        return Df(cArr, c10) >= 0;
    }

    @os.l
    public static final List<Boolean> n9(@os.l boolean[] zArr, int i10) {
        kn.l0.p(zArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = zArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Mx(zArr, length);
    }

    @os.l
    public static final <R, V> List<V> nA(@os.l long[] jArr, @os.l Iterable<? extends R> iterable, @os.l jn.p<? super Long, ? super R, ? extends V> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(iterable, "other");
        kn.l0.p(pVar, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Long.valueOf(jArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final <T> List<T> na(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            if (lVar.invoke(t10).booleanValue()) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    @an.f
    public static final Boolean nb(boolean[] zArr, jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (boolean z10 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                return Boolean.valueOf(z10);
            }
        }
        return null;
    }

    @os.m
    public static <T> T nc(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final <R> R nd(@os.l boolean[] zArr, R r10, @os.l jn.p<? super R, ? super Boolean, ? extends R> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (boolean z10 : zArr) {
            r10 = pVar.invoke(r10, Boolean.valueOf(z10));
        }
        return r10;
    }

    @os.l
    public static final <T> tn.l ne(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return new tn.l(0, we(tArr), 1);
    }

    @os.l
    public static final <K, M extends Map<? super K, List<Double>>> M nf(@os.l double[] dArr, @os.l M m10, @os.l jn.l<? super Double, ? extends K> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (double d10 : dArr) {
            K kInvoke = lVar.invoke(Double.valueOf(d10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(Double.valueOf(d10));
        }
        return m10;
    }

    @an.f
    public static final boolean ng(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return cArr.length == 0;
    }

    public static /* synthetic */ String nh(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, jn.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return eh(zArr, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    @os.l
    public static <T, R> List<R> ni(@os.l T[] tArr, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t10 : tArr) {
            arrayList.add(lVar.invoke(t10));
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double nj(byte[] bArr, jn.l<? super Byte, Double> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Byte.valueOf(bArr[0])).doubleValue();
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Byte.valueOf(bArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float nk(short[] sArr, jn.l<? super Short, Float> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Short.valueOf(sArr[0])).floatValue();
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Short.valueOf(sArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final float nl(@os.l float[] fArr, @os.l Comparator<? super Float> comparator) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float f10 = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            float f11 = fArr[it.nextInt()];
            if (comparator.compare(Float.valueOf(f10), Float.valueOf(f11)) < 0) {
                f10 = f11;
            }
        }
        return f10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R nm(char[] cArr, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Character.valueOf(cArr[0]));
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Long nn(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long j11 = jArr[it.nextInt()];
            if (j10 > j11) {
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final float[] no(float[] fArr, jn.l<? super Float, l2> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (float f10 : fArr) {
            lVar.invoke(Float.valueOf(f10));
        }
        return fArr;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Integer np(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return op(iArr, rn.f.Default);
    }

    public static final boolean nq(@os.l boolean[] zArr, @os.l jn.p<? super Boolean, ? super Boolean, Boolean> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "operation");
        int iYe = ye(zArr);
        if (iYe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[iYe];
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            zBooleanValue = pVar.invoke(Boolean.valueOf(zArr[i10]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return zBooleanValue;
    }

    @os.l
    public static final List<Long> nr(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return k0.INSTANCE;
        }
        List<Long> listTy = Ty(jArr);
        g0.r1(listTy);
        return listTy;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> ns(float[] fArr, R r10, jn.p<? super R, ? super Float, ? extends R> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (fArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r10);
        for (float f10 : fArr) {
            r10 = pVar.invoke(r10, Float.valueOf(f10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Boolean nt(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    @os.l
    public static final boolean[] nu(@os.l boolean[] zArr, @os.l Collection<Integer> collection) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(collection, "indices");
        boolean[] zArr2 = new boolean[collection.size()];
        Iterator<Integer> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            zArr2[i10] = zArr[it.next().intValue()];
            i10++;
        }
        return zArr2;
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Short> nv(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Nv(sArr, new rm.g.a(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double nw(@os.l byte[] bArr, @os.l jn.l<? super Byte, Double> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (byte b10 : bArr) {
            dDoubleValue += lVar.invoke(Byte.valueOf(b10)).doubleValue();
        }
        return dDoubleValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final long nx(char[] cArr, jn.l<? super Character, a2> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (char c10 : cArr) {
            jM += lVar.invoke(Character.valueOf(c10)).f10177a;
        }
        return jM;
    }

    @os.l
    public static final <C extends Collection<? super Integer>> C ny(@os.l int[] iArr, @os.l C c10) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (int i10 : iArr) {
            c10.add(Integer.valueOf(i10));
        }
        return c10;
    }

    @os.l
    public static final Set<Short> nz(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        int length = sArr.length;
        if (length != 0) {
            return length != 1 ? (Set) qy(sArr, new LinkedHashSet(c1.j(sArr.length))) : n1.f(Short.valueOf(sArr[0]));
        }
        return m0.INSTANCE;
    }

    public static final boolean o5(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public static final <K, M extends Map<? super K, ? super Byte>> M o6(@os.l byte[] bArr, @os.l M m10, @os.l jn.l<? super Byte, ? extends K> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (byte b10 : bArr) {
            m10.put(lVar.invoke(Byte.valueOf(b10)), Byte.valueOf(b10));
        }
        return m10;
    }

    @in.i(name = "averageOfDouble")
    public static final double o7(@os.l Double[] dArr) {
        kn.l0.p(dArr, "<this>");
        double dDoubleValue = 0.0d;
        int i10 = 0;
        for (Double d10 : dArr) {
            dDoubleValue += d10.doubleValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dDoubleValue / ((double) i10);
    }

    @lm.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    @lm.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @lm.a1(expression = "any { it == element }", imports = {}))
    public static final /* synthetic */ boolean o8(double[] dArr, double d10) {
        kn.l0.p(dArr, "<this>");
        for (double d11 : dArr) {
            if (d11 == d10) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public static final List<Byte> o9(@os.l byte[] bArr, int i10) {
        kn.l0.p(bArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = bArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return vx(bArr, length);
    }

    @os.l
    public static final List<lm.t0<Long, Long>> oA(@os.l long[] jArr, @os.l long[] jArr2) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(jArr2, "other");
        int iMin = Math.min(jArr.length, jArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(Long.valueOf(jArr[i10]), Long.valueOf(jArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final List<Short> oa(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                arrayList.add(Short.valueOf(s10));
            }
        }
        return arrayList;
    }

    @an.f
    public static final Byte ob(byte[] bArr, jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (byte b10 : bArr) {
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                return Byte.valueOf(b10);
            }
        }
        return null;
    }

    @os.m
    public static final <T> T oc(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (T t10 : tArr) {
            if (lVar.invoke(t10).booleanValue()) {
                return t10;
            }
        }
        return null;
    }

    public static final <R> R od(@os.l byte[] bArr, R r10, @os.l jn.q<? super Integer, ? super R, ? super Byte, ? extends R> qVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(qVar, "operation");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, Byte.valueOf(bArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    @os.l
    public static tn.l oe(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return new tn.l(0, xe(sArr), 1);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, List<V>>> M of(@os.l double[] dArr, @os.l M m10, @os.l jn.l<? super Double, ? extends K> lVar, @os.l jn.l<? super Double, ? extends V> lVar2) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (double d10 : dArr) {
            K kInvoke = lVar.invoke(Double.valueOf(d10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Double.valueOf(d10)));
        }
        return m10;
    }

    @an.f
    public static final boolean og(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return dArr.length == 0;
    }

    public static byte oh(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length != 0) {
            return bArr[qe(bArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.l
    public static final <R> List<R> oi(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s10 : sArr) {
            arrayList.add(lVar.invoke(Short.valueOf(s10)));
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double oj(char[] cArr, jn.l<? super Character, Double> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Character.valueOf(cArr[0])).doubleValue();
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Character.valueOf(cArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Float ok(boolean[] zArr, jn.l<? super Boolean, Float> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        float fFloatValue = lVar.invoke(Boolean.valueOf(zArr[0])).floatValue();
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Boolean.valueOf(zArr[it.nextInt()])).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final int ol(@os.l int[] iArr, @os.l Comparator<? super Integer> comparator) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int i11 = iArr[it.nextInt()];
            if (comparator.compare(Integer.valueOf(i10), Integer.valueOf(i11)) < 0) {
                i10 = i11;
            }
        }
        return i10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R om(double[] dArr, jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Double.valueOf(dArr[0]));
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Short on(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short s11 = sArr[it.nextInt()];
            if (s10 > s11) {
                s10 = s11;
            }
        }
        return Short.valueOf(s10);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final int[] oo(int[] iArr, jn.l<? super Integer, l2> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (int i10 : iArr) {
            lVar.invoke(Integer.valueOf(i10));
        }
        return iArr;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Integer op(@os.l int[] iArr, @os.l rn.f fVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(fVar, "random");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[fVar.nextInt(iArr.length)]);
    }

    public static final byte oq(@os.l byte[] bArr, @os.l jn.q<? super Integer, ? super Byte, ? super Byte, Byte> qVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iQe = qe(bArr);
        if (iQe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[iQe];
        for (int i10 = iQe - 1; i10 >= 0; i10--) {
            bByteValue = qVar.invoke(Integer.valueOf(i10), Byte.valueOf(bArr[i10]), Byte.valueOf(bByteValue)).byteValue();
        }
        return bByteValue;
    }

    @os.l
    public static final <T> List<T> or(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return k0.INSTANCE;
        }
        List<T> listUy = Uy(tArr);
        g0.r1(listUy);
        return listUy;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> os(int[] iArr, R r10, jn.p<? super R, ? super Integer, ? extends R> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (iArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        for (int i10 : iArr) {
            r10 = pVar.invoke(r10, Integer.valueOf(i10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Boolean ot(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Boolean boolValueOf = null;
        boolean z10 = false;
        for (boolean z11 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z11)).booleanValue()) {
                if (z10) {
                    return null;
                }
                boolValueOf = Boolean.valueOf(z11);
                z10 = true;
            }
        }
        if (z10) {
            return boolValueOf;
        }
        return null;
    }

    @os.l
    public static final boolean[] ou(@os.l boolean[] zArr, @os.l tn.l lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "indices");
        return lVar.isEmpty() ? new boolean[0] : nm.p.n1(zArr, lVar.f15911a, lVar.f15912b + 1);
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Boolean> ov(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Ov(zArr, new rm.g.a(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double ow(@os.l char[] cArr, @os.l jn.l<? super Character, Double> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (char c10 : cArr) {
            dDoubleValue += lVar.invoke(Character.valueOf(c10)).doubleValue();
        }
        return dDoubleValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final long ox(double[] dArr, jn.l<? super Double, a2> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (double d10 : dArr) {
            jM += lVar.invoke(Double.valueOf(d10)).f10177a;
        }
        return jM;
    }

    @os.l
    public static final <C extends Collection<? super Long>> C oy(@os.l long[] jArr, @os.l C c10) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (long j10 : jArr) {
            c10.add(Long.valueOf(j10));
        }
        return c10;
    }

    @os.l
    public static final Set<Boolean> oz(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        int length = zArr.length;
        if (length != 0) {
            return length != 1 ? (Set) ry(zArr, new LinkedHashSet(c1.j(zArr.length))) : n1.f(Boolean.valueOf(zArr[0]));
        }
        return m0.INSTANCE;
    }

    public static final <T> boolean p5(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return !(tArr.length == 0);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M p6(@os.l byte[] bArr, @os.l M m10, @os.l jn.l<? super Byte, ? extends K> lVar, @os.l jn.l<? super Byte, ? extends V> lVar2) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (byte b10 : bArr) {
            m10.put(lVar.invoke(Byte.valueOf(b10)), lVar2.invoke(Byte.valueOf(b10)));
        }
        return m10;
    }

    @in.i(name = "averageOfFloat")
    public static final double p7(@os.l Float[] fArr) {
        kn.l0.p(fArr, "<this>");
        double dFloatValue = 0.0d;
        int i10 = 0;
        for (Float f10 : fArr) {
            dFloatValue += (double) f10.floatValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dFloatValue / ((double) i10);
    }

    @lm.l(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    @lm.k(message = "The function has unclear behavior when searching for NaN or zero values and will be removed soon. Use 'any { it == element }' instead to continue using this behavior, or '.asList().contains(element: T)' to get the same search behavior as in a list.", replaceWith = @lm.a1(expression = "any { it == element }", imports = {}))
    public static final /* synthetic */ boolean p8(float[] fArr, float f10) {
        kn.l0.p(fArr, "<this>");
        for (float f11 : fArr) {
            if (f11 == f10) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public static final List<Character> p9(@os.l char[] cArr, int i10) {
        kn.l0.p(cArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = cArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return wx(cArr, length);
    }

    @os.l
    public static final <V> List<V> pA(@os.l long[] jArr, @os.l long[] jArr2, @os.l jn.p<? super Long, ? super Long, ? extends V> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(jArr2, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(jArr.length, jArr2.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Long.valueOf(jArr[i10]), Long.valueOf(jArr2[i10])));
        }
        return arrayList;
    }

    @os.l
    public static final List<Boolean> pa(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z10 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z10));
            }
        }
        return arrayList;
    }

    @an.f
    public static final Character pb(char[] cArr, jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (char c10 : cArr) {
            if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                return Character.valueOf(c10);
            }
        }
        return null;
    }

    @os.m
    public static final Short pc(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    public static final <R> R pd(@os.l char[] cArr, R r10, @os.l jn.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(qVar, "operation");
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, Character.valueOf(cArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    @os.l
    public static final tn.l pe(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return new tn.l(0, ye(zArr), 1);
    }

    @os.l
    public static final <K, M extends Map<? super K, List<Float>>> M pf(@os.l float[] fArr, @os.l M m10, @os.l jn.l<? super Float, ? extends K> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (float f10 : fArr) {
            K kInvoke = lVar.invoke(Float.valueOf(f10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(Float.valueOf(f10));
        }
        return m10;
    }

    @an.f
    public static final boolean pg(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return fArr.length == 0;
    }

    public static final byte ph(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                byte b10 = bArr[length];
                if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                    return b10;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @os.l
    public static final <R> List<R> pi(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z10 : zArr) {
            arrayList.add(lVar.invoke(Boolean.valueOf(z10)));
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double pj(double[] dArr, jn.l<? super Double, Double> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Double.valueOf(dArr[0])).doubleValue();
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Double.valueOf(dArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R pk(byte[] bArr, Comparator<? super R> comparator, jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Byte.valueOf(bArr[0]));
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final long pl(@os.l long[] jArr, @os.l Comparator<? super Long> comparator) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long j11 = jArr[it.nextInt()];
            if (comparator.compare(Long.valueOf(j10), Long.valueOf(j11)) < 0) {
                j10 = j11;
            }
        }
        return j10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R pm(float[] fArr, jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Float.valueOf(fArr[0]));
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final byte pn(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        byte b10 = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            byte b11 = bArr[it.nextInt()];
            if (b10 > b11) {
                b10 = b11;
            }
        }
        return b10;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final long[] po(long[] jArr, jn.l<? super Long, l2> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (long j10 : jArr) {
            lVar.invoke(Long.valueOf(j10));
        }
        return jArr;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Long pp(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return qp(jArr, rn.f.Default);
    }

    public static final char pq(@os.l char[] cArr, @os.l jn.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iRe = re(cArr);
        if (iRe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[iRe];
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            cCharValue = qVar.invoke(Integer.valueOf(i10), Character.valueOf(cArr[i10]), Character.valueOf(cCharValue)).charValue();
        }
        return cCharValue;
    }

    @os.l
    public static final List<Short> pr(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return k0.INSTANCE;
        }
        List<Short> listVy = Vy(sArr);
        g0.r1(listVy);
        return listVy;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> ps(long[] jArr, R r10, jn.p<? super R, ? super Long, ? extends R> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (jArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        for (long j10 : jArr) {
            r10 = pVar.invoke(r10, Long.valueOf(j10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Byte pt(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    public static final <T, R extends Comparable<? super R>> void pu(@os.l T[] tArr, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length > 1) {
            nm.p.h4(tArr, new rm.g.a(lVar));
        }
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Byte> pv(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Gv(bArr, new rm.g.c(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double pw(@os.l double[] dArr, @os.l jn.l<? super Double, Double> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (double d10 : dArr) {
            dDoubleValue += lVar.invoke(Double.valueOf(d10)).doubleValue();
        }
        return dDoubleValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final long px(float[] fArr, jn.l<? super Float, a2> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (float f10 : fArr) {
            jM += lVar.invoke(Float.valueOf(f10)).f10177a;
        }
        return jM;
    }

    @os.l
    public static final <T, C extends Collection<? super T>> C py(@os.l T[] tArr, @os.l C c10) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (T t10 : tArr) {
            c10.add(t10);
        }
        return c10;
    }

    @os.l
    public static final short[] pz(@os.l Short[] shArr) {
        kn.l0.p(shArr, "<this>");
        int length = shArr.length;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            sArr[i10] = shArr[i10].shortValue();
        }
        return sArr;
    }

    public static final <T> boolean q5(@os.l T[] tArr, @os.l jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (T t10 : tArr) {
            if (lVar.invoke(t10).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public static final <K, M extends Map<? super K, ? super Character>> M q6(@os.l char[] cArr, @os.l M m10, @os.l jn.l<? super Character, ? extends K> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (char c10 : cArr) {
            m10.put(lVar.invoke(Character.valueOf(c10)), Character.valueOf(c10));
        }
        return m10;
    }

    @in.i(name = "averageOfInt")
    public static final double q7(@os.l Integer[] numArr) {
        kn.l0.p(numArr, "<this>");
        double dIntValue = 0.0d;
        int i10 = 0;
        for (Integer num : numArr) {
            dIntValue += (double) num.intValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dIntValue / ((double) i10);
    }

    public static boolean q8(@os.l int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        return Gf(iArr, i10) >= 0;
    }

    @os.l
    public static final List<Double> q9(@os.l double[] dArr, int i10) {
        kn.l0.p(dArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = dArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return xx(dArr, length);
    }

    @os.l
    public static final <R> List<lm.t0<Long, R>> qA(@os.l long[] jArr, @os.l R[] rArr) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(rArr, "other");
        int iMin = Math.min(jArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            long j10 = jArr[i10];
            arrayList.add(new lm.t0(Long.valueOf(j10), rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final List<Byte> qa(@os.l byte[] bArr, @os.l jn.p<? super Integer, ? super Byte, Boolean> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Byte.valueOf(b10)).booleanValue()) {
                arrayList.add(Byte.valueOf(b10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @an.f
    public static final Double qb(double[] dArr, jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (double d10 : dArr) {
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                return Double.valueOf(d10);
            }
        }
        return null;
    }

    @os.m
    public static final Short qc(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                return Short.valueOf(s10);
            }
        }
        return null;
    }

    public static final <R> R qd(@os.l double[] dArr, R r10, @os.l jn.q<? super Integer, ? super R, ? super Double, ? extends R> qVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(qVar, "operation");
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, Double.valueOf(dArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static int qe(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return bArr.length - 1;
    }

    @os.l
    public static final <K, V, M extends Map<? super K, List<V>>> M qf(@os.l float[] fArr, @os.l M m10, @os.l jn.l<? super Float, ? extends K> lVar, @os.l jn.l<? super Float, ? extends V> lVar2) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (float f10 : fArr) {
            K kInvoke = lVar.invoke(Float.valueOf(f10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Float.valueOf(f10)));
        }
        return m10;
    }

    @an.f
    public static final boolean qg(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return iArr.length == 0;
    }

    public static final char qh(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length != 0) {
            return cArr[re(cArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.l
    public static final <R> List<R> qi(@os.l byte[] bArr, @os.l jn.p<? super Integer, ? super Byte, ? extends R> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), Byte.valueOf(bArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double qj(float[] fArr, jn.l<? super Float, Double> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Float.valueOf(fArr[0])).doubleValue();
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Float.valueOf(fArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R qk(char[] cArr, Comparator<? super R> comparator, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Character.valueOf(cArr[0]));
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final <T> T ql(@os.l T[] tArr, @os.l Comparator<? super T> comparator) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            T t11 = tArr[it.nextInt()];
            if (comparator.compare(t10, t11) < 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R qm(int[] iArr, jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Integer.valueOf(iArr[0]));
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final char qn(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        char c10 = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            char c11 = cArr[it.nextInt()];
            if (kn.l0.t(c10, c11) > 0) {
                c10 = c11;
            }
        }
        return c10;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <T> T[] qo(T[] tArr, jn.l<? super T, l2> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (T t10 : tArr) {
            lVar.invoke(t10);
        }
        return tArr;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Long qp(@os.l long[] jArr, @os.l rn.f fVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(fVar, "random");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[fVar.nextInt(jArr.length)]);
    }

    public static final double qq(@os.l double[] dArr, @os.l jn.q<? super Integer, ? super Double, ? super Double, Double> qVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iSe = se(dArr);
        if (iSe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[iSe];
        for (int i10 = iSe - 1; i10 >= 0; i10--) {
            dDoubleValue = qVar.invoke(Integer.valueOf(i10), Double.valueOf(dArr[i10]), Double.valueOf(dDoubleValue)).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final List<Boolean> qr(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return k0.INSTANCE;
        }
        List<Boolean> listWy = Wy(zArr);
        g0.r1(listWy);
        return listWy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <T, R> List<R> qs(@os.l T[] tArr, R r10, @os.l jn.p<? super R, ? super T, ? extends R> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (tArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r10);
        for (a1.d dVar : tArr) {
            r10 = pVar.invoke(r10, dVar);
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Byte qt(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Byte bValueOf = null;
        boolean z10 = false;
        for (byte b10 : bArr) {
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                bValueOf = Byte.valueOf(b10);
                z10 = true;
            }
        }
        if (z10) {
            return bValueOf;
        }
        return null;
    }

    public static final <T, R extends Comparable<? super R>> void qu(@os.l T[] tArr, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length > 1) {
            nm.p.h4(tArr, new rm.g.c(lVar));
        }
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Character> qv(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Hv(cArr, new rm.g.c(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double qw(@os.l float[] fArr, @os.l jn.l<? super Float, Double> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (float f10 : fArr) {
            dDoubleValue += lVar.invoke(Float.valueOf(f10)).doubleValue();
        }
        return dDoubleValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final long qx(int[] iArr, jn.l<? super Integer, a2> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (int i10 : iArr) {
            jM += lVar.invoke(Integer.valueOf(i10)).f10177a;
        }
        return jM;
    }

    @os.l
    public static final <C extends Collection<? super Short>> C qy(@os.l short[] sArr, @os.l C c10) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (short s10 : sArr) {
            c10.add(Short.valueOf(s10));
        }
        return c10;
    }

    @os.l
    public static final Set<Byte> qz(@os.l byte[] bArr, @os.l Iterable<Byte> iterable) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Byte> setXy = Xy(bArr);
        d0.r0(setXy, iterable);
        return setXy;
    }

    public static boolean r5(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return !(sArr.length == 0);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M r6(@os.l char[] cArr, @os.l M m10, @os.l jn.l<? super Character, ? extends K> lVar, @os.l jn.l<? super Character, ? extends V> lVar2) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (char c10 : cArr) {
            m10.put(lVar.invoke(Character.valueOf(c10)), lVar2.invoke(Character.valueOf(c10)));
        }
        return m10;
    }

    @in.i(name = "averageOfLong")
    public static final double r7(@os.l Long[] lArr) {
        kn.l0.p(lArr, "<this>");
        double dLongValue = 0.0d;
        int i10 = 0;
        for (Long l10 : lArr) {
            dLongValue += l10.longValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dLongValue / ((double) i10);
    }

    public static boolean r8(@os.l long[] jArr, long j10) {
        kn.l0.p(jArr, "<this>");
        return Hf(jArr, j10) >= 0;
    }

    @os.l
    public static final List<Float> r9(@os.l float[] fArr, int i10) {
        kn.l0.p(fArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = fArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return yx(fArr, length);
    }

    @os.l
    public static final <R, V> List<V> rA(@os.l long[] jArr, @os.l R[] rArr, @os.l jn.p<? super Long, ? super R, ? extends V> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(rArr, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(jArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Long.valueOf(jArr[i10]), rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final List<Character> ra(@os.l char[] cArr, @os.l jn.p<? super Integer, ? super Character, Boolean> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            char c10 = cArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Character.valueOf(c10)).booleanValue()) {
                arrayList.add(Character.valueOf(c10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @an.f
    public static final Float rb(float[] fArr, jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (float f10 : fArr) {
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                return Float.valueOf(f10);
            }
        }
        return null;
    }

    @os.l
    public static final <R> List<R> rc(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b10 : bArr) {
            d0.r0(arrayList, lVar.invoke(Byte.valueOf(b10)));
        }
        return arrayList;
    }

    public static final <R> R rd(@os.l float[] fArr, R r10, @os.l jn.q<? super Integer, ? super R, ? super Float, ? extends R> qVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(qVar, "operation");
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, Float.valueOf(fArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static final int re(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return cArr.length - 1;
    }

    @os.l
    public static final <K, M extends Map<? super K, List<Integer>>> M rf(@os.l int[] iArr, @os.l M m10, @os.l jn.l<? super Integer, ? extends K> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (int i10 : iArr) {
            K kInvoke = lVar.invoke(Integer.valueOf(i10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(Integer.valueOf(i10));
        }
        return m10;
    }

    @an.f
    public static final boolean rg(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return jArr.length == 0;
    }

    public static final char rh(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                char c10 = cArr[length];
                if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                    return c10;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @os.l
    public static final <R> List<R> ri(@os.l char[] cArr, @os.l jn.p<? super Integer, ? super Character, ? extends R> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), Character.valueOf(cArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double rj(int[] iArr, jn.l<? super Integer, Double> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Integer.valueOf(iArr[0])).doubleValue();
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Integer.valueOf(iArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R rk(double[] dArr, Comparator<? super R> comparator, jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Double.valueOf(dArr[0]));
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Double.valueOf(dArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final short rl(@os.l short[] sArr, @os.l Comparator<? super Short> comparator) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short s11 = sArr[it.nextInt()];
            if (comparator.compare(Short.valueOf(s10), Short.valueOf(s11)) < 0) {
                s10 = s11;
            }
        }
        return s10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R rm(long[] jArr, jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Long.valueOf(jArr[0]));
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final double rn(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dMin = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            dMin = Math.min(dMin, dArr[it.nextInt()]);
        }
        return dMin;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final short[] ro(short[] sArr, jn.l<? super Short, l2> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (short s10 : sArr) {
            lVar.invoke(Short.valueOf(s10));
        }
        return sArr;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <T> T rp(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return (T) sp(tArr, rn.f.Default);
    }

    public static final float rq(@os.l float[] fArr, @os.l jn.q<? super Integer, ? super Float, ? super Float, Float> qVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iTe = te(fArr);
        if (iTe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[iTe];
        for (int i10 = iTe - 1; i10 >= 0; i10--) {
            fFloatValue = qVar.invoke(Integer.valueOf(i10), Float.valueOf(fArr[i10]), Float.valueOf(fFloatValue)).floatValue();
        }
        return fFloatValue;
    }

    @os.l
    public static byte[] rr(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int iQe = qe(bArr);
        v0 v0VarA = nm.o.a(0, iQe, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            bArr2[iQe - iNextInt] = bArr[iNextInt];
        }
        return bArr2;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> rs(short[] sArr, R r10, jn.p<? super R, ? super Short, ? extends R> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (sArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r10);
        for (short s10 : sArr) {
            r10 = pVar.invoke(r10, Short.valueOf(s10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Character rt(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    public static final void ru(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        if (bArr.length > 1) {
            nm.p.G3(bArr);
            Qq(bArr);
        }
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Double> rv(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Iv(dArr, new rm.g.c(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double rw(@os.l int[] iArr, @os.l jn.l<? super Integer, Double> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (int i10 : iArr) {
            dDoubleValue += lVar.invoke(Integer.valueOf(i10)).doubleValue();
        }
        return dDoubleValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final long rx(long[] jArr, jn.l<? super Long, a2> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (long j10 : jArr) {
            jM += lVar.invoke(Long.valueOf(j10)).f10177a;
        }
        return jM;
    }

    @os.l
    public static final <C extends Collection<? super Boolean>> C ry(@os.l boolean[] zArr, @os.l C c10) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        for (boolean z10 : zArr) {
            c10.add(Boolean.valueOf(z10));
        }
        return c10;
    }

    @os.l
    public static final Set<Character> rz(@os.l char[] cArr, @os.l Iterable<Character> iterable) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Character> setYy = Yy(cArr);
        d0.r0(setYy, iterable);
        return setYy;
    }

    public static final boolean s5(@os.l short[] sArr, @os.l jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public static final <K, M extends Map<? super K, ? super Double>> M s6(@os.l double[] dArr, @os.l M m10, @os.l jn.l<? super Double, ? extends K> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (double d10 : dArr) {
            m10.put(lVar.invoke(Double.valueOf(d10)), Double.valueOf(d10));
        }
        return m10;
    }

    @in.i(name = "averageOfShort")
    public static final double s7(@os.l Short[] shArr) {
        kn.l0.p(shArr, "<this>");
        double dShortValue = 0.0d;
        int i10 = 0;
        for (Short sh2 : shArr) {
            dShortValue += (double) sh2.shortValue();
            i10++;
        }
        if (i10 == 0) {
            return Double.NaN;
        }
        return dShortValue / ((double) i10);
    }

    public static <T> boolean s8(@os.l T[] tArr, T t10) {
        kn.l0.p(tArr, "<this>");
        return If(tArr, t10) >= 0;
    }

    @os.l
    public static final List<Integer> s9(@os.l int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = iArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return zx(iArr, length);
    }

    @os.l
    public static final <T, R> List<lm.t0<T, R>> sA(@os.l T[] tArr, @os.l Iterable<? extends R> iterable) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(iterable, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(tArr[i10], r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final List<Double> sa(@os.l double[] dArr, @os.l jn.p<? super Integer, ? super Double, Boolean> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            double d10 = dArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Double.valueOf(d10)).booleanValue()) {
                arrayList.add(Double.valueOf(d10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @an.f
    public static final Integer sb(int[] iArr, jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int i10 : iArr) {
            if (lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                return Integer.valueOf(i10);
            }
        }
        return null;
    }

    @os.l
    public static final <R> List<R> sc(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c10 : cArr) {
            d0.r0(arrayList, lVar.invoke(Character.valueOf(c10)));
        }
        return arrayList;
    }

    public static final <R> R sd(@os.l int[] iArr, R r10, @os.l jn.q<? super Integer, ? super R, ? super Integer, ? extends R> qVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(qVar, "operation");
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, Integer.valueOf(iArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static final int se(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return dArr.length - 1;
    }

    @os.l
    public static final <K, V, M extends Map<? super K, List<V>>> M sf(@os.l int[] iArr, @os.l M m10, @os.l jn.l<? super Integer, ? extends K> lVar, @os.l jn.l<? super Integer, ? extends V> lVar2) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (int i10 : iArr) {
            K kInvoke = lVar.invoke(Integer.valueOf(i10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Integer.valueOf(i10)));
        }
        return m10;
    }

    @an.f
    public static final <T> boolean sg(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return tArr.length == 0;
    }

    public static final double sh(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length != 0) {
            return dArr[se(dArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.l
    public static final <R> List<R> si(@os.l double[] dArr, @os.l jn.p<? super Integer, ? super Double, ? extends R> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), Double.valueOf(dArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double sj(long[] jArr, jn.l<? super Long, Double> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Long.valueOf(jArr[0])).doubleValue();
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Long.valueOf(jArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R sk(float[] fArr, Comparator<? super R> comparator, jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Float.valueOf(fArr[0]));
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Float.valueOf(fArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "maxWithOrThrow")
    public static final boolean sl(@os.l boolean[] zArr, @os.l Comparator<? super Boolean> comparator) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z10 = zArr[0];
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            boolean z11 = zArr[it.nextInt()];
            if (comparator.compare(Boolean.valueOf(z10), Boolean.valueOf(z11)) < 0) {
                z10 = z11;
            }
        }
        return z10;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R extends Comparable<? super R>> R sm(T[] tArr, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(tArr[0]);
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(tArr[it.nextInt()]);
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final double sn(@os.l Double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = dArr[0].doubleValue();
        v0 it = new tn.l(1, we(dArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, dArr[it.nextInt()].doubleValue());
        }
        return dDoubleValue;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final boolean[] so(boolean[] zArr, jn.l<? super Boolean, l2> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, k4.f.f8937e);
        for (boolean z10 : zArr) {
            lVar.invoke(Boolean.valueOf(z10));
        }
        return zArr;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final <T> T sp(@os.l T[] tArr, @os.l rn.f fVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(fVar, "random");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[fVar.nextInt(tArr.length)];
    }

    public static final int sq(@os.l int[] iArr, @os.l jn.q<? super Integer, ? super Integer, ? super Integer, Integer> qVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iUe = ue(iArr);
        if (iUe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[iUe];
        for (int i10 = iUe - 1; i10 >= 0; i10--) {
            iIntValue = qVar.invoke(Integer.valueOf(i10), Integer.valueOf(iArr[i10]), Integer.valueOf(iIntValue)).intValue();
        }
        return iIntValue;
    }

    @os.l
    public static final char[] sr(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length == 0) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int iRe = re(cArr);
        v0 v0VarA = nm.o.a(0, iRe, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            cArr2[iRe - iNextInt] = cArr[iNextInt];
        }
        return cArr2;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> ss(boolean[] zArr, R r10, jn.p<? super R, ? super Boolean, ? extends R> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (zArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r10);
        for (boolean z10 : zArr) {
            r10 = pVar.invoke(r10, Boolean.valueOf(z10));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Character st(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Character chValueOf = null;
        boolean z10 = false;
        for (char c10 : cArr) {
            if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                chValueOf = Character.valueOf(c10);
                z10 = true;
            }
        }
        if (z10) {
            return chValueOf;
        }
        return null;
    }

    @lm.f1(version = "1.4")
    public static final void su(@os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, "<this>");
        nm.p.H3(bArr, i10, i11);
        Rq(bArr, i10, i11);
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Float> sv(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Jv(fArr, new rm.g.c(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double sw(@os.l long[] jArr, @os.l jn.l<? super Long, Double> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (long j10 : jArr) {
            dDoubleValue += lVar.invoke(Long.valueOf(j10)).doubleValue();
        }
        return dDoubleValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final <T> long sx(T[] tArr, jn.l<? super T, a2> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (T t10 : tArr) {
            jM += lVar.invoke(t10).f10177a;
        }
        return jM;
    }

    @os.l
    public static final double[] sy(@os.l Double[] dArr) {
        kn.l0.p(dArr, "<this>");
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr2[i10] = dArr[i10].doubleValue();
        }
        return dArr2;
    }

    @os.l
    public static final Set<Double> sz(@os.l double[] dArr, @os.l Iterable<Double> iterable) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Double> setZy = Zy(dArr);
        d0.r0(setZy, iterable);
        return setZy;
    }

    public static final boolean t5(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return !(zArr.length == 0);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M t6(@os.l double[] dArr, @os.l M m10, @os.l jn.l<? super Double, ? extends K> lVar, @os.l jn.l<? super Double, ? extends V> lVar2) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (double d10 : dArr) {
            m10.put(lVar.invoke(Double.valueOf(d10)), lVar2.invoke(Double.valueOf(d10)));
        }
        return m10;
    }

    @an.f
    public static final byte t7(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return bArr[0];
    }

    public static boolean t8(@os.l short[] sArr, short s10) {
        kn.l0.p(sArr, "<this>");
        return Jf(sArr, s10) >= 0;
    }

    @os.l
    public static final List<Long> t9(@os.l long[] jArr, int i10) {
        kn.l0.p(jArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = jArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Ax(jArr, length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final <T, R, V> List<V> tA(@os.l T[] tArr, @os.l Iterable<? extends R> iterable, @os.l jn.p<? super T, ? super R, ? extends V> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(iterable, "other");
        kn.l0.p(pVar, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(tArr[i10], r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final List<Float> ta(@os.l float[] fArr, @os.l jn.p<? super Integer, ? super Float, Boolean> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            float f10 = fArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Float.valueOf(f10)).booleanValue()) {
                arrayList.add(Float.valueOf(f10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @an.f
    public static final Long tb(long[] jArr, jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (long j10 : jArr) {
            if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                return Long.valueOf(j10);
            }
        }
        return null;
    }

    @os.l
    public static final <R> List<R> tc(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d10 : dArr) {
            d0.r0(arrayList, lVar.invoke(Double.valueOf(d10)));
        }
        return arrayList;
    }

    public static final <R> R td(@os.l long[] jArr, R r10, @os.l jn.q<? super Integer, ? super R, ? super Long, ? extends R> qVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(qVar, "operation");
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, Long.valueOf(jArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static final int te(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return fArr.length - 1;
    }

    @os.l
    public static final <K, M extends Map<? super K, List<Long>>> M tf(@os.l long[] jArr, @os.l M m10, @os.l jn.l<? super Long, ? extends K> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (long j10 : jArr) {
            K kInvoke = lVar.invoke(Long.valueOf(j10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(Long.valueOf(j10));
        }
        return m10;
    }

    @an.f
    public static final boolean tg(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return sArr.length == 0;
    }

    public static final double th(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                double d10 = dArr[length];
                if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                    return d10;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @os.l
    public static final <R> List<R> ti(@os.l float[] fArr, @os.l jn.p<? super Integer, ? super Float, ? extends R> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), Float.valueOf(fArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T> double tj(T[] tArr, jn.l<? super T, Double> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(tArr[0]).doubleValue();
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(tArr[it.nextInt()]).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R tk(int[] iArr, Comparator<? super R> comparator, jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Integer.valueOf(iArr[0]));
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Integer.valueOf(iArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Boolean tl(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        int iYe = ye(zArr);
        if (iYe == 0) {
            return Boolean.valueOf(z10);
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(z10));
        v0 v0VarA = nm.o.a(1, iYe, 1);
        while (v0VarA.hasNext()) {
            boolean z11 = zArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Boolean.valueOf(z11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                z10 = z11;
                rInvoke = rInvoke2;
            }
        }
        return Boolean.valueOf(z10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R tm(short[] sArr, jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Short.valueOf(sArr[0]));
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final float tn(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fMin = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            fMin = Math.min(fMin, fArr[it.nextInt()]);
        }
        return fMin;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final byte[] to(byte[] bArr, jn.p<? super Integer, ? super Byte, l2> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Byte.valueOf(bArr[i10]));
            i10++;
            i11++;
        }
        return bArr;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final Short tp(short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return up(sArr, rn.f.Default);
    }

    public static final long tq(@os.l long[] jArr, @os.l jn.q<? super Integer, ? super Long, ? super Long, Long> qVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iVe = ve(jArr);
        if (iVe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long jLongValue = jArr[iVe];
        for (int i10 = iVe - 1; i10 >= 0; i10--) {
            jLongValue = qVar.invoke(Integer.valueOf(i10), Long.valueOf(jArr[i10]), Long.valueOf(jLongValue)).longValue();
        }
        return jLongValue;
    }

    @os.l
    public static final double[] tr(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 0) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int iSe = se(dArr);
        v0 v0VarA = nm.o.a(0, iSe, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            dArr2[iSe - iNextInt] = dArr[iNextInt];
        }
        return dArr2;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> ts(byte[] bArr, R r10, jn.q<? super Integer, ? super R, ? super Byte, ? extends R> qVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (bArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r10);
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Byte.valueOf(bArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Double tt(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    public static final void tu(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        if (cArr.length > 1) {
            nm.p.I3(cArr);
            Sq(cArr);
        }
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Integer> tv(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Kv(iArr, new rm.g.c(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final <T> double tw(@os.l T[] tArr, @os.l jn.l<? super T, Double> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (T t10 : tArr) {
            dDoubleValue += lVar.invoke(t10).doubleValue();
        }
        return dDoubleValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final long tx(short[] sArr, jn.l<? super Short, a2> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (short s10 : sArr) {
            jM += lVar.invoke(Short.valueOf(s10)).f10177a;
        }
        return jM;
    }

    @os.l
    public static final float[] ty(@os.l Float[] fArr) {
        kn.l0.p(fArr, "<this>");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i10 = 0; i10 < length; i10++) {
            fArr2[i10] = fArr[i10].floatValue();
        }
        return fArr2;
    }

    @os.l
    public static final Set<Float> tz(@os.l float[] fArr, @os.l Iterable<Float> iterable) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Float> setAz = az(fArr);
        d0.r0(setAz, iterable);
        return setAz;
    }

    public static final boolean u5(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (boolean z10 : zArr) {
            if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @os.l
    public static final <K, M extends Map<? super K, ? super Float>> M u6(@os.l float[] fArr, @os.l M m10, @os.l jn.l<? super Float, ? extends K> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (float f10 : fArr) {
            m10.put(lVar.invoke(Float.valueOf(f10)), Float.valueOf(f10));
        }
        return m10;
    }

    @an.f
    public static final char u7(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return cArr[0];
    }

    public static final boolean u8(@os.l boolean[] zArr, boolean z10) {
        kn.l0.p(zArr, "<this>");
        return Kf(zArr, z10) >= 0;
    }

    @os.l
    public static final <T> List<T> u9(@os.l T[] tArr, int i10) {
        kn.l0.p(tArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = tArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Bx(tArr, length);
    }

    @os.l
    public static <T, R> List<lm.t0<T, R>> uA(@os.l T[] tArr, @os.l R[] rArr) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(rArr, "other");
        int iMin = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(new lm.t0(tArr[i10], rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final List<Integer> ua(@os.l int[] iArr, @os.l jn.p<? super Integer, ? super Integer, Boolean> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = iArr[i10];
            int i13 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Integer.valueOf(i12)).booleanValue()) {
                arrayList.add(Integer.valueOf(i12));
            }
            i10++;
            i11 = i13;
        }
        return arrayList;
    }

    @an.f
    public static final <T> T ub(T[] tArr, jn.l<? super T, Boolean> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (T t10 : tArr) {
            if (lVar.invoke(t10).booleanValue()) {
                return t10;
            }
        }
        return null;
    }

    @os.l
    public static final <R> List<R> uc(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f10 : fArr) {
            d0.r0(arrayList, lVar.invoke(Float.valueOf(f10)));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R ud(@os.l T[] tArr, R r10, @os.l jn.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(qVar, "operation");
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, tArr[i10]);
            i10++;
            i11++;
        }
        return r10;
    }

    public static int ue(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return iArr.length - 1;
    }

    @os.l
    public static final <K, V, M extends Map<? super K, List<V>>> M uf(@os.l long[] jArr, @os.l M m10, @os.l jn.l<? super Long, ? extends K> lVar, @os.l jn.l<? super Long, ? extends V> lVar2) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (long j10 : jArr) {
            K kInvoke = lVar.invoke(Long.valueOf(j10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Long.valueOf(j10)));
        }
        return m10;
    }

    @an.f
    public static final boolean ug(boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return zArr.length == 0;
    }

    public static final float uh(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length != 0) {
            return fArr[te(fArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.l
    public static final <R> List<R> ui(@os.l int[] iArr, @os.l jn.p<? super Integer, ? super Integer, ? extends R> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), Integer.valueOf(iArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double uj(short[] sArr, jn.l<? super Short, Double> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Short.valueOf(sArr[0])).doubleValue();
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Short.valueOf(sArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R uk(long[] jArr, Comparator<? super R> comparator, jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Long.valueOf(jArr[0]));
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Long.valueOf(jArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Byte ul(@os.l byte[] bArr, @os.l jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        int iQe = qe(bArr);
        if (iQe == 0) {
            return Byte.valueOf(b10);
        }
        R rInvoke = lVar.invoke(Byte.valueOf(b10));
        v0 v0VarA = nm.o.a(1, iQe, 1);
        while (v0VarA.hasNext()) {
            byte b11 = bArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Byte.valueOf(b11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                b10 = b11;
                rInvoke = rInvoke2;
            }
        }
        return Byte.valueOf(b10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R extends Comparable<? super R>> R um(boolean[] zArr, jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(zArr[0]));
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final float un(@os.l Float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = fArr[0].floatValue();
        v0 it = new tn.l(1, we(fArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.min(fFloatValue, fArr[it.nextInt()].floatValue());
        }
        return fFloatValue;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final char[] uo(char[] cArr, jn.p<? super Integer, ? super Character, l2> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = cArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Character.valueOf(cArr[i10]));
            i10++;
            i11++;
        }
        return cArr;
    }

    @os.m
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    public static final Short up(@os.l short[] sArr, @os.l rn.f fVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(fVar, "random");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[fVar.nextInt(sArr.length)]);
    }

    public static final <S, T extends S> S uq(@os.l T[] tArr, @os.l jn.q<? super Integer, ? super T, ? super S, ? extends S> qVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iWe = we(tArr);
        if (iWe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S sInvoke = (S) tArr[iWe];
        for (int i10 = iWe - 1; i10 >= 0; i10--) {
            sInvoke = qVar.invoke(Integer.valueOf(i10), (Object) tArr[i10], sInvoke);
        }
        return sInvoke;
    }

    @os.l
    public static final float[] ur(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 0) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int iTe = te(fArr);
        v0 v0VarA = nm.o.a(0, iTe, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            fArr2[iTe - iNextInt] = fArr[iNextInt];
        }
        return fArr2;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> us(char[] cArr, R r10, jn.q<? super Integer, ? super R, ? super Character, ? extends R> qVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (cArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r10);
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Character.valueOf(cArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Double ut(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Double dValueOf = null;
        boolean z10 = false;
        for (double d10 : dArr) {
            if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                dValueOf = Double.valueOf(d10);
                z10 = true;
            }
        }
        if (z10) {
            return dValueOf;
        }
        return null;
    }

    @lm.f1(version = "1.4")
    public static final void uu(@os.l char[] cArr, int i10, int i11) {
        kn.l0.p(cArr, "<this>");
        nm.p.J3(cArr, i10, i11);
        Tq(cArr, i10, i11);
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Long> uv(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Lv(jArr, new rm.g.c(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double uw(@os.l short[] sArr, @os.l jn.l<? super Short, Double> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (short s10 : sArr) {
            dDoubleValue += lVar.invoke(Short.valueOf(s10)).doubleValue();
        }
        return dDoubleValue;
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfULong")
    @p2(markerClass = {lm.t.class})
    @lm.f1(version = "1.5")
    public static final long ux(boolean[] zArr, jn.l<? super Boolean, a2> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        long jM = a2.m(0L);
        for (boolean z10 : zArr) {
            jM += lVar.invoke(Boolean.valueOf(z10)).f10177a;
        }
        return jM;
    }

    @os.l
    public static final HashSet<Byte> uy(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return (HashSet) jy(bArr, new HashSet(c1.j(bArr.length)));
    }

    @os.l
    public static final Set<Integer> uz(@os.l int[] iArr, @os.l Iterable<Integer> iterable) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Integer> setBz = bz(iArr);
        d0.r0(setBz, iterable);
        return setBz;
    }

    @os.l
    public static final Iterable<Byte> v5(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return bArr.length == 0 ? k0.INSTANCE : new b(bArr);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M v6(@os.l float[] fArr, @os.l M m10, @os.l jn.l<? super Float, ? extends K> lVar, @os.l jn.l<? super Float, ? extends V> lVar2) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (float f10 : fArr) {
            m10.put(lVar.invoke(Float.valueOf(f10)), lVar2.invoke(Float.valueOf(f10)));
        }
        return m10;
    }

    @an.f
    public static final double v7(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return dArr[0];
    }

    @an.f
    public static final int v8(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return bArr.length;
    }

    @os.l
    public static final List<Short> v9(@os.l short[] sArr, int i10) {
        kn.l0.p(sArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = sArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Cx(sArr, length);
    }

    @os.l
    public static final <T, R, V> List<V> vA(@os.l T[] tArr, @os.l R[] rArr, @os.l jn.p<? super T, ? super R, ? extends V> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(rArr, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(tArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(tArr[i10], rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final List<Long> va(@os.l long[] jArr, @os.l jn.p<? super Integer, ? super Long, Boolean> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            long j10 = jArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Long.valueOf(j10)).booleanValue()) {
                arrayList.add(Long.valueOf(j10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @an.f
    public static final Short vb(short[] sArr, jn.l<? super Short, Boolean> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (short s10 : sArr) {
            if (lVar.invoke(Short.valueOf(s10)).booleanValue()) {
                return Short.valueOf(s10);
            }
        }
        return null;
    }

    @os.l
    public static final <R> List<R> vc(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            d0.r0(arrayList, lVar.invoke(Integer.valueOf(i10)));
        }
        return arrayList;
    }

    public static final <R> R vd(@os.l short[] sArr, R r10, @os.l jn.q<? super Integer, ? super R, ? super Short, ? extends R> qVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(qVar, "operation");
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, Short.valueOf(sArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static int ve(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return jArr.length - 1;
    }

    @os.l
    public static final <T, K, M extends Map<? super K, List<T>>> M vf(@os.l T[] tArr, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (T t10 : tArr) {
            K kInvoke = lVar.invoke(t10);
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(t10);
        }
        return m10;
    }

    @an.f
    public static final boolean vg(byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return !(bArr.length == 0);
    }

    public static final float vh(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                float f10 = fArr[length];
                if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                    return f10;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @os.l
    public static final <R> List<R> vi(@os.l long[] jArr, @os.l jn.p<? super Integer, ? super Long, ? extends R> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), Long.valueOf(jArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final double vj(boolean[] zArr, jn.l<? super Boolean, Double> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = lVar.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, lVar.invoke(Boolean.valueOf(zArr[it.nextInt()])).doubleValue());
        }
        return dDoubleValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <T, R> R vk(T[] tArr, Comparator<? super R> comparator, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(tArr[0]);
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(tArr[it.nextInt()]);
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Character vl(@os.l char[] cArr, @os.l jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        int iRe = re(cArr);
        if (iRe == 0) {
            return Character.valueOf(c10);
        }
        R rInvoke = lVar.invoke(Character.valueOf(c10));
        v0 v0VarA = nm.o.a(1, iRe, 1);
        while (v0VarA.hasNext()) {
            char c11 = cArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Character.valueOf(c11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                c10 = c11;
                rInvoke = rInvoke2;
            }
        }
        return Character.valueOf(c10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double vm(byte[] bArr, jn.l<? super Byte, Double> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Byte.valueOf(bArr[0])).doubleValue();
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Byte.valueOf(bArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final int vn(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i10 = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            int i11 = iArr[it.nextInt()];
            if (i10 > i11) {
                i10 = i11;
            }
        }
        return i10;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final double[] vo(double[] dArr, jn.p<? super Integer, ? super Double, l2> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = dArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Double.valueOf(dArr[i10]));
            i10++;
            i11++;
        }
        return dArr;
    }

    public static final byte vp(@os.l byte[] bArr, @os.l jn.p<? super Byte, ? super Byte, Byte> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (bArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        byte bByteValue = bArr[0];
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            bByteValue = pVar.invoke(Byte.valueOf(bByteValue), Byte.valueOf(bArr[it.nextInt()])).byteValue();
        }
        return bByteValue;
    }

    public static final short vq(@os.l short[] sArr, @os.l jn.q<? super Integer, ? super Short, ? super Short, Short> qVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iXe = xe(sArr);
        if (iXe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short sShortValue = sArr[iXe];
        for (int i10 = iXe - 1; i10 >= 0; i10--) {
            sShortValue = qVar.invoke(Integer.valueOf(i10), Short.valueOf(sArr[i10]), Short.valueOf(sShortValue)).shortValue();
        }
        return sShortValue;
    }

    @os.l
    public static int[] vr(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length == 0) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int iUe = ue(iArr);
        v0 v0VarA = nm.o.a(0, iUe, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            iArr2[iUe - iNextInt] = iArr[iNextInt];
        }
        return iArr2;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> vs(double[] dArr, R r10, jn.q<? super Integer, ? super R, ? super Double, ? extends R> qVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (dArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r10);
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Double.valueOf(dArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Float vt(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    public static final void vu(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        if (dArr.length > 1) {
            nm.p.K3(dArr);
            Uq(dArr);
        }
    }

    @os.l
    public static final <T, R extends Comparable<? super R>> List<T> vv(@os.l T[] tArr, @os.l jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Mv(tArr, new rm.g.c(lVar));
    }

    @lm.l(warningSince = "1.5")
    @lm.k(message = "Use sumOf instead.", replaceWith = @lm.a1(expression = "this.sumOf(selector)", imports = {}))
    public static final double vw(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, Double> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (boolean z10 : zArr) {
            dDoubleValue += lVar.invoke(Boolean.valueOf(z10)).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final List<Byte> vx(@os.l byte[] bArr, int i10) {
        kn.l0.p(bArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= bArr.length) {
            return Ey(bArr);
        }
        if (i10 == 1) {
            return nm.x.k(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (byte b10 : bArr) {
            arrayList.add(Byte.valueOf(b10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @os.l
    public static final HashSet<Character> vy(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        int length = cArr.length;
        if (length > 128) {
            length = 128;
        }
        return (HashSet) ky(cArr, new HashSet(c1.j(length)));
    }

    @os.l
    public static final Set<Long> vz(@os.l long[] jArr, @os.l Iterable<Long> iterable) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Long> setCz = cz(jArr);
        d0.r0(setCz, iterable);
        return setCz;
    }

    @os.l
    public static final Iterable<Character> w5(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return cArr.length == 0 ? k0.INSTANCE : new i(cArr);
    }

    @os.l
    public static final <K, M extends Map<? super K, ? super Integer>> M w6(@os.l int[] iArr, @os.l M m10, @os.l jn.l<? super Integer, ? extends K> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (int i10 : iArr) {
            m10.put(lVar.invoke(Integer.valueOf(i10)), Integer.valueOf(i10));
        }
        return m10;
    }

    @an.f
    public static final float w7(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return fArr[0];
    }

    public static final int w8(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int i10 = 0;
        for (byte b10 : bArr) {
            if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @os.l
    public static final List<Boolean> w9(@os.l boolean[] zArr, int i10) {
        kn.l0.p(zArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        int length = zArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        return Dx(zArr, length);
    }

    @os.l
    public static final <R> List<lm.t0<Short, R>> wA(@os.l short[] sArr, @os.l Iterable<? extends R> iterable) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(iterable, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(new lm.t0(Short.valueOf(sArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final <T> List<T> wa(@os.l T[] tArr, @os.l jn.p<? super Integer, ? super T, Boolean> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            T t10 = tArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), t10).booleanValue()) {
                arrayList.add(t10);
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @an.f
    public static final Boolean wb(boolean[] zArr, jn.l<? super Boolean, Boolean> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                boolean z10 = zArr[length];
                if (lVar.invoke(Boolean.valueOf(z10)).booleanValue()) {
                    return Boolean.valueOf(z10);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @os.l
    public static final <R> List<R> wc(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j10 : jArr) {
            d0.r0(arrayList, lVar.invoke(Long.valueOf(j10)));
        }
        return arrayList;
    }

    public static final <R> R wd(@os.l boolean[] zArr, R r10, @os.l jn.q<? super Integer, ? super R, ? super Boolean, ? extends R> qVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(qVar, "operation");
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            r10 = qVar.invoke(Integer.valueOf(i11), r10, Boolean.valueOf(zArr[i10]));
            i10++;
            i11++;
        }
        return r10;
    }

    public static <T> int we(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return tArr.length - 1;
    }

    @os.l
    public static final <T, K, V, M extends Map<? super K, List<V>>> M wf(@os.l T[] tArr, @os.l M m10, @os.l jn.l<? super T, ? extends K> lVar, @os.l jn.l<? super T, ? extends V> lVar2) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (T t10 : tArr) {
            K kInvoke = lVar.invoke(t10);
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(t10));
        }
        return m10;
    }

    @an.f
    public static final boolean wg(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return !(cArr.length == 0);
    }

    public static int wh(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length != 0) {
            return iArr[ue(iArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.l
    public static final <T, R> List<R> wi(@os.l T[] tArr, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), tArr[i10]));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float wj(byte[] bArr, jn.l<? super Byte, Float> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Byte.valueOf(bArr[0])).floatValue();
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Byte.valueOf(bArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R wk(short[] sArr, Comparator<? super R> comparator, jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Short.valueOf(sArr[0]));
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Short.valueOf(sArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Double wl(@os.l double[] dArr, @os.l jn.l<? super Double, ? extends R> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        int iSe = se(dArr);
        if (iSe == 0) {
            return Double.valueOf(d10);
        }
        R rInvoke = lVar.invoke(Double.valueOf(d10));
        v0 v0VarA = nm.o.a(1, iSe, 1);
        while (v0VarA.hasNext()) {
            double d11 = dArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Double.valueOf(d11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                d10 = d11;
                rInvoke = rInvoke2;
            }
        }
        return Double.valueOf(d10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double wm(char[] cArr, jn.l<? super Character, Double> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Character.valueOf(cArr[0])).doubleValue();
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Character.valueOf(cArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final long wn(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j10 = jArr[0];
        v0 it = new tn.l(1, ve(jArr), 1).iterator();
        while (it.hasNext()) {
            long j11 = jArr[it.nextInt()];
            if (j10 > j11) {
                j10 = j11;
            }
        }
        return j10;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final float[] wo(float[] fArr, jn.p<? super Integer, ? super Float, l2> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = fArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Float.valueOf(fArr[i10]));
            i10++;
            i11++;
        }
        return fArr;
    }

    public static final char wp(@os.l char[] cArr, @os.l jn.p<? super Character, ? super Character, Character> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (cArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        char cCharValue = cArr[0];
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            cCharValue = pVar.invoke(Character.valueOf(cCharValue), Character.valueOf(cArr[it.nextInt()])).charValue();
        }
        return cCharValue;
    }

    public static final boolean wq(@os.l boolean[] zArr, @os.l jn.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> qVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iYe = ye(zArr);
        if (iYe < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean zBooleanValue = zArr[iYe];
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            zBooleanValue = qVar.invoke(Integer.valueOf(i10), Boolean.valueOf(zArr[i10]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return zBooleanValue;
    }

    @os.l
    public static long[] wr(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length == 0) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int iVe = ve(jArr);
        v0 v0VarA = nm.o.a(0, iVe, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            jArr2[iVe - iNextInt] = jArr[iNextInt];
        }
        return jArr2;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> ws(float[] fArr, R r10, jn.q<? super Integer, ? super R, ? super Float, ? extends R> qVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (fArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r10);
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Float.valueOf(fArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Float wt(@os.l float[] fArr, @os.l jn.l<? super Float, Boolean> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Float fValueOf = null;
        boolean z10 = false;
        for (float f10 : fArr) {
            if (lVar.invoke(Float.valueOf(f10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                fValueOf = Float.valueOf(f10);
                z10 = true;
            }
        }
        if (z10) {
            return fValueOf;
        }
        return null;
    }

    @lm.f1(version = "1.4")
    public static final void wu(@os.l double[] dArr, int i10, int i11) {
        kn.l0.p(dArr, "<this>");
        nm.p.L3(dArr, i10, i11);
        Vq(dArr, i10, i11);
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Short> wv(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends R> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Nv(sArr, new rm.g.c(lVar));
    }

    @in.i(name = "sumOfByte")
    public static final int ww(@os.l Byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        int iByteValue = 0;
        for (Byte b10 : bArr) {
            iByteValue += b10.byteValue();
        }
        return iByteValue;
    }

    @os.l
    public static final List<Character> wx(@os.l char[] cArr, int i10) {
        kn.l0.p(cArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= cArr.length) {
            return Fy(cArr);
        }
        if (i10 == 1) {
            return nm.x.k(Character.valueOf(cArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (char c10 : cArr) {
            arrayList.add(Character.valueOf(c10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @os.l
    public static final HashSet<Double> wy(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return (HashSet) ly(dArr, new HashSet(c1.j(dArr.length)));
    }

    @os.l
    public static final <T> Set<T> wz(@os.l T[] tArr, @os.l Iterable<? extends T> iterable) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<T> setDz = dz(tArr);
        d0.r0(setDz, iterable);
        return setDz;
    }

    @os.l
    public static final Iterable<Double> x5(@os.l double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return dArr.length == 0 ? k0.INSTANCE : new g(dArr);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M x6(@os.l int[] iArr, @os.l M m10, @os.l jn.l<? super Integer, ? extends K> lVar, @os.l jn.l<? super Integer, ? extends V> lVar2) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (int i10 : iArr) {
            m10.put(lVar.invoke(Integer.valueOf(i10)), lVar2.invoke(Integer.valueOf(i10)));
        }
        return m10;
    }

    @an.f
    public static final int x7(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return iArr[0];
    }

    @an.f
    public static final int x8(char[] cArr) {
        kn.l0.p(cArr, "<this>");
        return cArr.length;
    }

    @os.l
    public static final List<Byte> x9(@os.l byte[] bArr, @os.l jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iQe = qe(bArr); -1 < iQe; iQe--) {
            if (!lVar.invoke(Byte.valueOf(bArr[iQe])).booleanValue()) {
                return vx(bArr, iQe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <R, V> List<V> xA(@os.l short[] sArr, @os.l Iterable<? extends R> iterable, @os.l jn.p<? super Short, ? super R, ? extends V> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(iterable, "other");
        kn.l0.p(pVar, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(nm.z.b0(iterable, 10), length));
        int i10 = 0;
        for (R r10 : iterable) {
            if (i10 >= length) {
                break;
            }
            arrayList.add(pVar.invoke(Short.valueOf(sArr[i10]), r10));
            i10++;
        }
        return arrayList;
    }

    @os.l
    public static final List<Short> xa(@os.l short[] sArr, @os.l jn.p<? super Integer, ? super Short, Boolean> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            short s10 = sArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Short.valueOf(s10)).booleanValue()) {
                arrayList.add(Short.valueOf(s10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @an.f
    public static final Byte xb(byte[] bArr, jn.l<? super Byte, Boolean> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                byte b10 = bArr[length];
                if (lVar.invoke(Byte.valueOf(b10)).booleanValue()) {
                    return Byte.valueOf(b10);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @os.l
    public static final <T, R> List<R> xc(@os.l T[] tArr, @os.l jn.l<? super T, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t10 : tArr) {
            d0.r0(arrayList, lVar.invoke(t10));
        }
        return arrayList;
    }

    public static final <R> R xd(@os.l byte[] bArr, R r10, @os.l jn.p<? super Byte, ? super R, ? extends R> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (int iQe = qe(bArr); iQe >= 0; iQe--) {
            r10 = pVar.invoke(Byte.valueOf(bArr[iQe]), r10);
        }
        return r10;
    }

    public static int xe(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        return sArr.length - 1;
    }

    @os.l
    public static final <K, M extends Map<? super K, List<Short>>> M xf(@os.l short[] sArr, @os.l M m10, @os.l jn.l<? super Short, ? extends K> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (short s10 : sArr) {
            K kInvoke = lVar.invoke(Short.valueOf(s10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(Short.valueOf(s10));
        }
        return m10;
    }

    @an.f
    public static final boolean xg(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return !(dArr.length == 0);
    }

    public static final int xh(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                int i11 = iArr[length];
                if (lVar.invoke(Integer.valueOf(i11)).booleanValue()) {
                    return i11;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @os.l
    public static final <R> List<R> xi(@os.l short[] sArr, @os.l jn.p<? super Integer, ? super Short, ? extends R> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int length = sArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), Short.valueOf(sArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float xj(char[] cArr, jn.l<? super Character, Float> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Character.valueOf(cArr[0])).floatValue();
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Character.valueOf(cArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R xk(boolean[] zArr, Comparator<? super R> comparator, jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R rInvoke = lVar.invoke(Boolean.valueOf(zArr[0]));
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Boolean.valueOf(zArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Float xl(@os.l float[] fArr, @os.l jn.l<? super Float, ? extends R> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        int iTe = te(fArr);
        if (iTe == 0) {
            return Float.valueOf(f10);
        }
        R rInvoke = lVar.invoke(Float.valueOf(f10));
        v0 v0VarA = nm.o.a(1, iTe, 1);
        while (v0VarA.hasNext()) {
            float f11 = fArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Float.valueOf(f11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                f10 = f11;
                rInvoke = rInvoke2;
            }
        }
        return Float.valueOf(f10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double xm(double[] dArr, jn.l<? super Double, Double> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Double.valueOf(dArr[0])).doubleValue();
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Double.valueOf(dArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    @os.l
    public static final <T extends Comparable<? super T>> T xn(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t10 = tArr[0];
        v0 it = new tn.l(1, we(tArr), 1).iterator();
        while (it.hasNext()) {
            T t11 = tArr[it.nextInt()];
            if (t10.compareTo(t11) > 0) {
                t10 = t11;
            }
        }
        return t10;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final int[] xo(int[] iArr, jn.p<? super Integer, ? super Integer, l2> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Integer.valueOf(iArr[i10]));
            i10++;
            i11++;
        }
        return iArr;
    }

    public static final double xp(@os.l double[] dArr, @os.l jn.p<? super Double, ? super Double, Double> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (dArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        double dDoubleValue = dArr[0];
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = pVar.invoke(Double.valueOf(dDoubleValue), Double.valueOf(dArr[it.nextInt()])).doubleValue();
        }
        return dDoubleValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Boolean xq(@os.l boolean[] zArr, @os.l jn.q<? super Integer, ? super Boolean, ? super Boolean, Boolean> qVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iYe = ye(zArr);
        if (iYe < 0) {
            return null;
        }
        boolean zBooleanValue = zArr[iYe];
        for (int i10 = iYe - 1; i10 >= 0; i10--) {
            zBooleanValue = qVar.invoke(Integer.valueOf(i10), Boolean.valueOf(zArr[i10]), Boolean.valueOf(zBooleanValue)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    @os.l
    public static final <T> T[] xr(@os.l T[] tArr) {
        kn.l0.p(tArr, "<this>");
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) nm.m.a(tArr, tArr.length);
        int iWe = we(tArr);
        v0 v0VarA = nm.o.a(0, iWe, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            tArr2[iWe - iNextInt] = tArr[iNextInt];
        }
        return tArr2;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> xs(int[] iArr, R r10, jn.q<? super Integer, ? super R, ? super Integer, ? extends R> qVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (iArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r10);
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Integer.valueOf(iArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Integer xt(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    public static final void xu(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        if (fArr.length > 1) {
            nm.p.M3(fArr);
            Wq(fArr);
        }
    }

    @os.l
    public static final <R extends Comparable<? super R>> List<Boolean> xv(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends R> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "selector");
        return Ov(zArr, new rm.g.c(lVar));
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfDouble")
    @lm.f1(version = "1.4")
    public static final double xw(byte[] bArr, jn.l<? super Byte, Double> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (byte b10 : bArr) {
            dDoubleValue += lVar.invoke(Byte.valueOf(b10)).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final List<Double> xx(@os.l double[] dArr, int i10) {
        kn.l0.p(dArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= dArr.length) {
            return Gy(dArr);
        }
        if (i10 == 1) {
            return nm.x.k(Double.valueOf(dArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (double d10 : dArr) {
            arrayList.add(Double.valueOf(d10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @os.l
    public static final HashSet<Float> xy(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return (HashSet) my(fArr, new HashSet(c1.j(fArr.length)));
    }

    @os.l
    public static final Set<Short> xz(@os.l short[] sArr, @os.l Iterable<Short> iterable) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Short> setEz = ez(sArr);
        d0.r0(setEz, iterable);
        return setEz;
    }

    @os.l
    public static final Iterable<Float> y5(@os.l float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return fArr.length == 0 ? k0.INSTANCE : new f(fArr);
    }

    @os.l
    public static final <K, M extends Map<? super K, ? super Long>> M y6(@os.l long[] jArr, @os.l M m10, @os.l jn.l<? super Long, ? extends K> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (long j10 : jArr) {
            m10.put(lVar.invoke(Long.valueOf(j10)), Long.valueOf(j10));
        }
        return m10;
    }

    @an.f
    public static final long y7(long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return jArr[0];
    }

    public static final int y8(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int i10 = 0;
        for (char c10 : cArr) {
            if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @os.l
    public static final List<Character> y9(@os.l char[] cArr, @os.l jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iRe = re(cArr); -1 < iRe; iRe--) {
            if (!lVar.invoke(Character.valueOf(cArr[iRe])).booleanValue()) {
                return wx(cArr, iRe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <R> List<lm.t0<Short, R>> yA(@os.l short[] sArr, @os.l R[] rArr) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(rArr, "other");
        int iMin = Math.min(sArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            short s10 = sArr[i10];
            arrayList.add(new lm.t0(Short.valueOf(s10), rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final List<Boolean> ya(@os.l boolean[] zArr, @os.l jn.p<? super Integer, ? super Boolean, Boolean> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            boolean z10 = zArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Boolean.valueOf(z10)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z10));
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @an.f
    public static final Character yb(char[] cArr, jn.l<? super Character, Boolean> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                char c10 = cArr[length];
                if (lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                    return Character.valueOf(c10);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @os.l
    public static final <R> List<R> yc(@os.l short[] sArr, @os.l jn.l<? super Short, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArr) {
            d0.r0(arrayList, lVar.invoke(Short.valueOf(s10)));
        }
        return arrayList;
    }

    public static final <R> R yd(@os.l char[] cArr, R r10, @os.l jn.p<? super Character, ? super R, ? extends R> pVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (int iRe = re(cArr); iRe >= 0; iRe--) {
            r10 = pVar.invoke(Character.valueOf(cArr[iRe]), r10);
        }
        return r10;
    }

    public static final int ye(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        return zArr.length - 1;
    }

    @os.l
    public static final <K, V, M extends Map<? super K, List<V>>> M yf(@os.l short[] sArr, @os.l M m10, @os.l jn.l<? super Short, ? extends K> lVar, @os.l jn.l<? super Short, ? extends V> lVar2) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (short s10 : sArr) {
            K kInvoke = lVar.invoke(Short.valueOf(s10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(lVar2.invoke(Short.valueOf(s10)));
        }
        return m10;
    }

    @an.f
    public static final boolean yg(float[] fArr) {
        kn.l0.p(fArr, "<this>");
        return !(fArr.length == 0);
    }

    public static long yh(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length != 0) {
            return jArr[ve(jArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    @os.l
    public static final <R> List<R> yi(@os.l boolean[] zArr, @os.l jn.p<? super Integer, ? super Boolean, ? extends R> pVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int length = zArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            arrayList.add(pVar.invoke(Integer.valueOf(i11), Boolean.valueOf(zArr[i10])));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float yj(double[] dArr, jn.l<? super Double, Float> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Double.valueOf(dArr[0])).floatValue();
        v0 it = new tn.l(1, se(dArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Double.valueOf(dArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R yk(byte[] bArr, Comparator<? super R> comparator, jn.l<? super Byte, ? extends R> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (bArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Byte.valueOf(bArr[0]));
        v0 it = new tn.l(1, qe(bArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Byte.valueOf(bArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Integer yl(@os.l int[] iArr, @os.l jn.l<? super Integer, ? extends R> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        int iUe = ue(iArr);
        if (iUe == 0) {
            return Integer.valueOf(i10);
        }
        R rInvoke = lVar.invoke(Integer.valueOf(i10));
        v0 v0VarA = nm.o.a(1, iUe, 1);
        while (v0VarA.hasNext()) {
            int i11 = iArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Integer.valueOf(i11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                i10 = i11;
                rInvoke = rInvoke2;
            }
        }
        return Integer.valueOf(i10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double ym(float[] fArr, jn.l<? super Float, Double> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Float.valueOf(fArr[0])).doubleValue();
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Float.valueOf(fArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @lm.f1(version = "1.7")
    @in.i(name = "minOrThrow")
    public static final short yn(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s10 = sArr[0];
        v0 it = new tn.l(1, xe(sArr), 1).iterator();
        while (it.hasNext()) {
            short s11 = sArr[it.nextInt()];
            if (s10 > s11) {
                s10 = s11;
            }
        }
        return s10;
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final long[] yo(long[] jArr, jn.p<? super Integer, ? super Long, l2> pVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = jArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), Long.valueOf(jArr[i10]));
            i10++;
            i11++;
        }
        return jArr;
    }

    public static final float yp(@os.l float[] fArr, @os.l jn.p<? super Float, ? super Float, Float> pVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (fArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        float fFloatValue = fArr[0];
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = pVar.invoke(Float.valueOf(fFloatValue), Float.valueOf(fArr[it.nextInt()])).floatValue();
        }
        return fFloatValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Byte yq(@os.l byte[] bArr, @os.l jn.q<? super Integer, ? super Byte, ? super Byte, Byte> qVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iQe = qe(bArr);
        if (iQe < 0) {
            return null;
        }
        byte bByteValue = bArr[iQe];
        for (int i10 = iQe - 1; i10 >= 0; i10--) {
            bByteValue = qVar.invoke(Integer.valueOf(i10), Byte.valueOf(bArr[i10]), Byte.valueOf(bByteValue)).byteValue();
        }
        return Byte.valueOf(bByteValue);
    }

    @os.l
    public static short[] yr(@os.l short[] sArr) {
        kn.l0.p(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int iXe = xe(sArr);
        v0 v0VarA = nm.o.a(0, iXe, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            sArr2[iXe - iNextInt] = sArr[iNextInt];
        }
        return sArr2;
    }

    @lm.f1(version = "1.4")
    @an.f
    @p2(markerClass = {lm.r.class})
    public static final <R> List<R> ys(long[] jArr, R r10, jn.q<? super Integer, ? super R, ? super Long, ? extends R> qVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (jArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r10);
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, Long.valueOf(jArr[i10]));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Integer yt(@os.l int[] iArr, @os.l jn.l<? super Integer, Boolean> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "predicate");
        Integer numValueOf = null;
        boolean z10 = false;
        for (int i10 : iArr) {
            if (lVar.invoke(Integer.valueOf(i10)).booleanValue()) {
                if (z10) {
                    return null;
                }
                numValueOf = Integer.valueOf(i10);
                z10 = true;
            }
        }
        if (z10) {
            return numValueOf;
        }
        return null;
    }

    @lm.f1(version = "1.4")
    public static final void yu(@os.l float[] fArr, int i10, int i11) {
        kn.l0.p(fArr, "<this>");
        nm.p.N3(fArr, i10, i11);
        Xq(fArr, i10, i11);
    }

    @os.l
    public static final List<Byte> yv(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kn.l0.o(bArrCopyOf, "copyOf(...)");
        nm.p.G3(bArrCopyOf);
        return ir(bArrCopyOf);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfDouble")
    @lm.f1(version = "1.4")
    public static final double yw(char[] cArr, jn.l<? super Character, Double> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (char c10 : cArr) {
            dDoubleValue += lVar.invoke(Character.valueOf(c10)).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final List<Float> yx(@os.l float[] fArr, int i10) {
        kn.l0.p(fArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= fArr.length) {
            return Hy(fArr);
        }
        if (i10 == 1) {
            return nm.x.k(Float.valueOf(fArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (float f10 : fArr) {
            arrayList.add(Float.valueOf(f10));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @os.l
    public static final HashSet<Integer> yy(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return (HashSet) ny(iArr, new HashSet(c1.j(iArr.length)));
    }

    @os.l
    public static final Set<Boolean> yz(@os.l boolean[] zArr, @os.l Iterable<Boolean> iterable) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(iterable, "other");
        Set<Boolean> setFz = fz(zArr);
        d0.r0(setFz, iterable);
        return setFz;
    }

    @os.l
    public static final Iterable<Integer> z5(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return iArr.length == 0 ? k0.INSTANCE : new d(iArr);
    }

    @os.l
    public static final <K, V, M extends Map<? super K, ? super V>> M z6(@os.l long[] jArr, @os.l M m10, @os.l jn.l<? super Long, ? extends K> lVar, @os.l jn.l<? super Long, ? extends V> lVar2) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        kn.l0.p(lVar2, "valueTransform");
        for (long j10 : jArr) {
            m10.put(lVar.invoke(Long.valueOf(j10)), lVar2.invoke(Long.valueOf(j10)));
        }
        return m10;
    }

    @an.f
    public static final <T> T z7(T[] tArr) {
        kn.l0.p(tArr, "<this>");
        return tArr[0];
    }

    @an.f
    public static final int z8(double[] dArr) {
        kn.l0.p(dArr, "<this>");
        return dArr.length;
    }

    @os.l
    public static final List<Double> z9(@os.l double[] dArr, @os.l jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        for (int iSe = se(dArr); -1 < iSe; iSe--) {
            if (!lVar.invoke(Double.valueOf(dArr[iSe])).booleanValue()) {
                return xx(dArr, iSe + 1);
            }
        }
        return k0.INSTANCE;
    }

    @os.l
    public static final <R, V> List<V> zA(@os.l short[] sArr, @os.l R[] rArr, @os.l jn.p<? super Short, ? super R, ? extends V> pVar) {
        kn.l0.p(sArr, "<this>");
        kn.l0.p(rArr, "other");
        kn.l0.p(pVar, "transform");
        int iMin = Math.min(sArr.length, rArr.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(pVar.invoke(Short.valueOf(sArr[i10]), rArr[i10]));
        }
        return arrayList;
    }

    @os.l
    public static final <C extends Collection<? super Byte>> C za(@os.l byte[] bArr, @os.l C c10, @os.l jn.p<? super Integer, ? super Byte, Boolean> pVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(c10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(pVar, "predicate");
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArr[i10];
            int i12 = i11 + 1;
            if (pVar.invoke(Integer.valueOf(i11), Byte.valueOf(b10)).booleanValue()) {
                c10.add(Byte.valueOf(b10));
            }
            i10++;
            i11 = i12;
        }
        return c10;
    }

    @an.f
    public static final Double zb(double[] dArr, jn.l<? super Double, Boolean> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                double d10 = dArr[length];
                if (lVar.invoke(Double.valueOf(d10)).booleanValue()) {
                    return Double.valueOf(d10);
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        return null;
    }

    @os.l
    public static final <R> List<R> zc(@os.l boolean[] zArr, @os.l jn.l<? super Boolean, ? extends Iterable<? extends R>> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean z10 : zArr) {
            d0.r0(arrayList, lVar.invoke(Boolean.valueOf(z10)));
        }
        return arrayList;
    }

    public static final <R> R zd(@os.l double[] dArr, R r10, @os.l jn.p<? super Double, ? super R, ? extends R> pVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(pVar, "operation");
        for (int iSe = se(dArr); iSe >= 0; iSe--) {
            r10 = pVar.invoke(Double.valueOf(dArr[iSe]), r10);
        }
        return r10;
    }

    @an.f
    public static final byte ze(byte[] bArr, int i10, jn.l<? super Integer, Byte> lVar) {
        kn.l0.p(bArr, "<this>");
        kn.l0.p(lVar, "defaultValue");
        return (i10 < 0 || i10 > qe(bArr)) ? lVar.invoke(Integer.valueOf(i10)).byteValue() : bArr[i10];
    }

    @os.l
    public static final <K, M extends Map<? super K, List<Boolean>>> M zf(@os.l boolean[] zArr, @os.l M m10, @os.l jn.l<? super Boolean, ? extends K> lVar) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(m10, RtspHeaders.Values.DESTINATION);
        kn.l0.p(lVar, "keySelector");
        for (boolean z10 : zArr) {
            K kInvoke = lVar.invoke(Boolean.valueOf(z10));
            Object objA = m10.get(kInvoke);
            if (objA == null) {
                objA = nm.q.a(m10, kInvoke);
            }
            ((List) objA).add(Boolean.valueOf(z10));
        }
        return m10;
    }

    @an.f
    public static final boolean zg(int[] iArr) {
        kn.l0.p(iArr, "<this>");
        return !(iArr.length == 0);
    }

    public static final long zh(@os.l long[] jArr, @os.l jn.l<? super Long, Boolean> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                long j10 = jArr[length];
                if (lVar.invoke(Long.valueOf(j10)).booleanValue()) {
                    return j10;
                }
                if (i10 >= 0) {
                    length = i10;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @os.l
    public static final <T, R> List<R> zi(@os.l T[] tArr, @os.l jn.p<? super Integer, ? super T, ? extends R> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i11 + 1;
            R rInvoke = pVar.invoke(Integer.valueOf(i11), tArr[i10]);
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final float zj(float[] fArr, jn.l<? super Float, Float> lVar) {
        kn.l0.p(fArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = lVar.invoke(Float.valueOf(fArr[0])).floatValue();
        v0 it = new tn.l(1, te(fArr), 1).iterator();
        while (it.hasNext()) {
            fFloatValue = Math.max(fFloatValue, lVar.invoke(Float.valueOf(fArr[it.nextInt()])).floatValue());
        }
        return fFloatValue;
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final <R> R zk(char[] cArr, Comparator<? super R> comparator, jn.l<? super Character, ? extends R> lVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(comparator, "comparator");
        kn.l0.p(lVar, "selector");
        if (cArr.length == 0) {
            return null;
        }
        R rInvoke = lVar.invoke(Character.valueOf(cArr[0]));
        v0 it = new tn.l(1, re(cArr), 1).iterator();
        while (it.hasNext()) {
            R rInvoke2 = lVar.invoke(Character.valueOf(cArr[it.nextInt()]));
            if (comparator.compare(rInvoke, rInvoke2) < 0) {
                rInvoke = rInvoke2;
            }
        }
        return rInvoke;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final <R extends Comparable<? super R>> Long zl(@os.l long[] jArr, @os.l jn.l<? super Long, ? extends R> lVar) {
        kn.l0.p(jArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        int iVe = ve(jArr);
        if (iVe == 0) {
            return Long.valueOf(j10);
        }
        R rInvoke = lVar.invoke(Long.valueOf(j10));
        v0 v0VarA = nm.o.a(1, iVe, 1);
        while (v0VarA.hasNext()) {
            long j11 = jArr[v0VarA.nextInt()];
            R rInvoke2 = lVar.invoke(Long.valueOf(j11));
            if (rInvoke.compareTo(rInvoke2) > 0) {
                j10 = j11;
                rInvoke = rInvoke2;
            }
        }
        return Long.valueOf(j10);
    }

    @lm.s0
    @lm.f1(version = "1.4")
    @an.f
    public static final Double zm(int[] iArr, jn.l<? super Integer, Double> lVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(lVar, "selector");
        if (iArr.length == 0) {
            return null;
        }
        double dDoubleValue = lVar.invoke(Integer.valueOf(iArr[0])).doubleValue();
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, lVar.invoke(Integer.valueOf(iArr[it.nextInt()])).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Boolean zn(@os.l boolean[] zArr, @os.l Comparator<? super Boolean> comparator) {
        kn.l0.p(zArr, "<this>");
        kn.l0.p(comparator, "comparator");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        v0 it = new tn.l(1, ye(zArr), 1).iterator();
        while (it.hasNext()) {
            boolean z11 = zArr[it.nextInt()];
            if (comparator.compare(Boolean.valueOf(z10), Boolean.valueOf(z11)) > 0) {
                z10 = z11;
            }
        }
        return Boolean.valueOf(z10);
    }

    @lm.f1(version = "1.4")
    @an.f
    public static final <T> T[] zo(T[] tArr, jn.p<? super Integer, ? super T, l2> pVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(pVar, k4.f.f8937e);
        int length = tArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            pVar.invoke(Integer.valueOf(i11), tArr[i10]);
            i10++;
            i11++;
        }
        return tArr;
    }

    public static final int zp(@os.l int[] iArr, @os.l jn.p<? super Integer, ? super Integer, Integer> pVar) {
        kn.l0.p(iArr, "<this>");
        kn.l0.p(pVar, "operation");
        if (iArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        int iIntValue = iArr[0];
        v0 it = new tn.l(1, ue(iArr), 1).iterator();
        while (it.hasNext()) {
            iIntValue = pVar.invoke(Integer.valueOf(iIntValue), Integer.valueOf(iArr[it.nextInt()])).intValue();
        }
        return iIntValue;
    }

    @os.m
    @lm.f1(version = "1.4")
    public static final Character zq(@os.l char[] cArr, @os.l jn.q<? super Integer, ? super Character, ? super Character, Character> qVar) {
        kn.l0.p(cArr, "<this>");
        kn.l0.p(qVar, "operation");
        int iRe = re(cArr);
        if (iRe < 0) {
            return null;
        }
        char cCharValue = cArr[iRe];
        for (int i10 = iRe - 1; i10 >= 0; i10--) {
            cCharValue = qVar.invoke(Integer.valueOf(i10), Character.valueOf(cArr[i10]), Character.valueOf(cCharValue)).charValue();
        }
        return Character.valueOf(cCharValue);
    }

    @os.l
    public static final boolean[] zr(@os.l boolean[] zArr) {
        kn.l0.p(zArr, "<this>");
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int iYe = ye(zArr);
        v0 v0VarA = nm.o.a(0, iYe, 1);
        while (v0VarA.hasNext()) {
            int iNextInt = v0VarA.nextInt();
            zArr2[iYe - iNextInt] = zArr[iNextInt];
        }
        return zArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @lm.f1(version = "1.4")
    @p2(markerClass = {lm.r.class})
    @os.l
    public static final <T, R> List<R> zs(@os.l T[] tArr, R r10, @os.l jn.q<? super Integer, ? super R, ? super T, ? extends R> qVar) {
        kn.l0.p(tArr, "<this>");
        kn.l0.p(qVar, "operation");
        if (tArr.length == 0) {
            return nm.x.k(r10);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r10);
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            r10 = qVar.invoke(Integer.valueOf(i10), r10, tArr[i10]);
            arrayList.add(r10);
        }
        return arrayList;
    }

    @os.m
    public static final Long zt(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    public static final void zu(@os.l int[] iArr) {
        kn.l0.p(iArr, "<this>");
        if (iArr.length > 1) {
            nm.p.O3(iArr);
            Yq(iArr);
        }
    }

    @os.l
    public static final List<Character> zv(@os.l char[] cArr) {
        kn.l0.p(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kn.l0.o(cArrCopyOf, "copyOf(...)");
        nm.p.I3(cArrCopyOf);
        return jr(cArrCopyOf);
    }

    @lm.s0
    @an.f
    @in.i(name = "sumOfDouble")
    @lm.f1(version = "1.4")
    public static final double zw(double[] dArr, jn.l<? super Double, Double> lVar) {
        kn.l0.p(dArr, "<this>");
        kn.l0.p(lVar, "selector");
        double dDoubleValue = 0.0d;
        for (double d10 : dArr) {
            dDoubleValue += lVar.invoke(Double.valueOf(d10)).doubleValue();
        }
        return dDoubleValue;
    }

    @os.l
    public static final List<Integer> zx(@os.l int[] iArr, int i10) {
        kn.l0.p(iArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(k.b.a("Requested element count ", i10, " is less than zero.").toString());
        }
        if (i10 == 0) {
            return k0.INSTANCE;
        }
        if (i10 >= iArr.length) {
            return Iy(iArr);
        }
        if (i10 == 1) {
            return nm.x.k(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(i10);
        int i11 = 0;
        for (int i12 : iArr) {
            arrayList.add(Integer.valueOf(i12));
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return arrayList;
    }

    @os.l
    public static final HashSet<Long> zy(@os.l long[] jArr) {
        kn.l0.p(jArr, "<this>");
        return (HashSet) oy(jArr, new HashSet(c1.j(jArr.length)));
    }

    @os.l
    public static final Iterable<s0<Byte>> zz(@os.l byte[] bArr) {
        kn.l0.p(bArr, "<this>");
        return new t0(new u(bArr));
    }
}
