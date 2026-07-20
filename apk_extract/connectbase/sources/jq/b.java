package jq;

import java.util.LinkedHashMap;
import java.util.Map;
import kn.r1;
import nm.c1;

/* JADX INFO: loaded from: classes3.dex */
public enum b {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);

    private final int value;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ym.a f8798c = ym.c.c(a());

    @os.l
    public static final C0230b Companion = new C0230b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final lm.d0<Map<Integer, b>> f8796a = lm.f0.b(a.INSTANCE);

    @r1({"SMAP\nCharDirectionality.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CharDirectionality.kt\nkotlin/text/CharDirectionality$Companion$directionalityMap$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,124:1\n1194#2,2:125\n1222#2,4:127\n*S KotlinDebug\n*F\n+ 1 CharDirectionality.kt\nkotlin/text/CharDirectionality$Companion$directionalityMap$2\n*L\n118#1:125,2\n118#1:127,4\n*E\n"})
    public static final class a extends kn.n0 implements jn.a<Map<Integer, ? extends b>> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Map<Integer, ? extends b> invoke() {
            ym.a<b> entries = b.getEntries();
            int iJ = c1.j(nm.z.b0(entries, 10));
            if (iJ < 16) {
                iJ = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
            for (b bVar : entries) {
                linkedHashMap.put(Integer.valueOf(bVar.getValue()), bVar);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: renamed from: jq.b$b, reason: collision with other inner class name */
    public static final class C0230b {
        public C0230b() {
        }

        public final Map<Integer, b> a() {
            return (Map) b.f8796a.getValue();
        }

        @os.l
        public final b b(int i10) {
            b bVar = a().get(Integer.valueOf(i10));
            if (bVar != null) {
                return bVar;
            }
            throw new IllegalArgumentException(k.b.a("Directionality #", i10, " is not defined."));
        }

        public C0230b(kn.w wVar) {
        }
    }

    b(int i10) {
        this.value = i10;
    }

    @os.l
    public static ym.a<b> getEntries() {
        return f8798c;
    }

    public final int getValue() {
        return this.value;
    }
}
