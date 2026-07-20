package fo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.w;
import lm.t0;
import nm.d1;
import nm.h0;
import nm.r;
import nm.x;
import nm.y;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'PROPERTY' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final n CONSTRUCTOR;
    public static final n FIELD;
    public static final n FUNCTION;

    @os.l
    public static final Map<e, n> H;
    public static final n LOCAL_VARIABLE;
    public static final n PROPERTY;
    public static final n PROPERTY_GETTER;
    public static final n PROPERTY_SETTER;
    public static final n VALUE_PARAMETER;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final Set<n> f6181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final Set<n> f6182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final List<n> f6183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final List<n> f6184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final List<n> f6185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final List<n> f6186g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final List<n> f6187i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public static final List<n> f6188n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public static final List<n> f6189p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public static final List<n> f6190v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public static final List<n> f6191w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public static final List<n> f6192x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public static final List<n> f6193y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public static final List<n> f6194z;

    @os.l
    private final String description;
    private final boolean isDefault;
    public static final n CLASS = new n("CLASS", 0, "class", 0 == true ? 1 : 0, 2, null);
    public static final n ANNOTATION_CLASS = new n("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);
    public static final n TYPE_PARAMETER = new n("TYPE_PARAMETER", 2, "type parameter", false);
    public static final n TYPE = new n("TYPE", 11, "type usage", false);
    public static final n EXPRESSION = new n("EXPRESSION", 12, "expression", false);
    public static final n FILE = new n("FILE", 13, "file", false);
    public static final n TYPEALIAS = new n("TYPEALIAS", 14, "typealias", false);
    public static final n TYPE_PROJECTION = new n("TYPE_PROJECTION", 15, "type projection", false);
    public static final n STAR_PROJECTION = new n("STAR_PROJECTION", 16, "star projection", false);
    public static final n PROPERTY_PARAMETER = new n("PROPERTY_PARAMETER", 17, "property constructor parameter", false);
    public static final n CLASS_ONLY = new n("CLASS_ONLY", 18, "class", false);
    public static final n OBJECT = new n("OBJECT", 19, "object", false);
    public static final n COMPANION_OBJECT = new n("COMPANION_OBJECT", 20, "companion object", false);
    public static final n INTERFACE = new n("INTERFACE", 21, "interface", false);
    public static final n ENUM_CLASS = new n("ENUM_CLASS", 22, "enum class", false);
    public static final n ENUM_ENTRY = new n("ENUM_ENTRY", 23, "enum entry", false);
    public static final n LOCAL_CLASS = new n("LOCAL_CLASS", 24, "local class", false);
    public static final n LOCAL_FUNCTION = new n("LOCAL_FUNCTION", 25, "local function", false);
    public static final n MEMBER_FUNCTION = new n("MEMBER_FUNCTION", 26, "member function", false);
    public static final n TOP_LEVEL_FUNCTION = new n("TOP_LEVEL_FUNCTION", 27, "top level function", false);
    public static final n MEMBER_PROPERTY = new n("MEMBER_PROPERTY", 28, "member property", false);
    public static final n MEMBER_PROPERTY_WITH_BACKING_FIELD = new n("MEMBER_PROPERTY_WITH_BACKING_FIELD", 29, "member property with backing field", false);
    public static final n MEMBER_PROPERTY_WITH_DELEGATE = new n("MEMBER_PROPERTY_WITH_DELEGATE", 30, "member property with delegate", false);
    public static final n MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new n("MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 31, "member property without backing field or delegate", false);
    public static final n TOP_LEVEL_PROPERTY = new n("TOP_LEVEL_PROPERTY", 32, "top level property", false);
    public static final n TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD = new n("TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD", 33, "top level property with backing field", false);
    public static final n TOP_LEVEL_PROPERTY_WITH_DELEGATE = new n("TOP_LEVEL_PROPERTY_WITH_DELEGATE", 34, "top level property with delegate", false);
    public static final n TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE = new n("TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE", 35, "top level property without backing field or delegate", false);
    public static final n INITIALIZER = new n("INITIALIZER", 36, "initializer", false);
    public static final n DESTRUCTURING_DECLARATION = new n("DESTRUCTURING_DECLARATION", 37, "destructuring declaration", false);
    public static final n LAMBDA_EXPRESSION = new n("LAMBDA_EXPRESSION", 38, "lambda expression", false);
    public static final n ANONYMOUS_FUNCTION = new n("ANONYMOUS_FUNCTION", 39, "anonymous function", false);
    public static final n OBJECT_LITERAL = new n("OBJECT_LITERAL", 40, "object literal", false);
    public static final /* synthetic */ n[] I = a();

    @os.l
    public static final a Companion = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final HashMap<String, n> f6180a = new HashMap<>();

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i10 = 0;
        int i11 = 2;
        w wVar = null;
        boolean z10 = false;
        PROPERTY = new n("PROPERTY", 3, "property", z10, i11, wVar);
        int i12 = 2;
        w wVar2 = null;
        boolean z11 = false;
        FIELD = new n("FIELD", 4, "field", z11, i12, wVar2);
        LOCAL_VARIABLE = new n("LOCAL_VARIABLE", 5, "local variable", z10, i11, wVar);
        VALUE_PARAMETER = new n("VALUE_PARAMETER", 6, "value parameter", z11, i12, wVar2);
        CONSTRUCTOR = new n("CONSTRUCTOR", 7, "constructor", z10, i11, wVar);
        FUNCTION = new n("FUNCTION", 8, "function", z11, i12, wVar2);
        PROPERTY_GETTER = new n("PROPERTY_GETTER", 9, "getter", z10, i11, wVar);
        PROPERTY_SETTER = new n("PROPERTY_SETTER", 10, "setter", z11, i12, wVar2);
        n[] nVarArrValues = values();
        int length = nVarArrValues.length;
        int i13 = 0;
        while (i13 < length) {
            n nVar = nVarArrValues[i13];
            i13++;
            f6180a.put(nVar.name(), nVar);
        }
        n[] nVarArrValues2 = values();
        ArrayList arrayList = new ArrayList();
        int length2 = nVarArrValues2.length;
        while (i10 < length2) {
            n nVar2 = nVarArrValues2[i10];
            i10++;
            if (nVar2.isDefault()) {
                arrayList.add(nVar2);
            }
        }
        f6181b = h0.a6(arrayList);
        f6182c = r.mz(values());
        n nVar3 = ANNOTATION_CLASS;
        n nVar4 = CLASS;
        f6183d = y.O(nVar3, nVar4);
        f6184e = y.O(LOCAL_CLASS, nVar4);
        f6185f = y.O(CLASS_ONLY, nVar4);
        n nVar5 = COMPANION_OBJECT;
        n nVar6 = OBJECT;
        f6186g = y.O(nVar5, nVar6, nVar4);
        f6187i = y.O(nVar6, nVar4);
        f6188n = y.O(INTERFACE, nVar4);
        f6189p = y.O(ENUM_CLASS, nVar4);
        n nVar7 = ENUM_ENTRY;
        n nVar8 = PROPERTY;
        n nVar9 = FIELD;
        f6190v = y.O(nVar7, nVar8, nVar9);
        n nVar10 = PROPERTY_SETTER;
        f6191w = x.k(nVar10);
        n nVar11 = PROPERTY_GETTER;
        f6192x = x.k(nVar11);
        f6193y = x.k(FUNCTION);
        n nVar12 = FILE;
        f6194z = x.k(nVar12);
        e eVar = e.CONSTRUCTOR_PARAMETER;
        n nVar13 = VALUE_PARAMETER;
        H = d1.W(new t0(eVar, nVar13), new t0(e.FIELD, nVar9), new t0(e.PROPERTY, nVar8), new t0(e.FILE, nVar12), new t0(e.PROPERTY_GETTER, nVar11), new t0(e.PROPERTY_SETTER, nVar10), new t0(e.RECEIVER, nVar13), new t0(e.SETTER_PARAMETER, nVar13), new t0(e.PROPERTY_DELEGATE_FIELD, nVar9));
    }

    public n(String str, int i10, String str2, boolean z10) {
        super(str, i10);
        this.description = str2;
        this.isDefault = z10;
    }

    public static final /* synthetic */ n[] a() {
        return new n[]{CLASS, ANNOTATION_CLASS, TYPE_PARAMETER, PROPERTY, FIELD, LOCAL_VARIABLE, VALUE_PARAMETER, CONSTRUCTOR, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER, TYPE, EXPRESSION, FILE, TYPEALIAS, TYPE_PROJECTION, STAR_PROJECTION, PROPERTY_PARAMETER, CLASS_ONLY, OBJECT, COMPANION_OBJECT, INTERFACE, ENUM_CLASS, ENUM_ENTRY, LOCAL_CLASS, LOCAL_FUNCTION, MEMBER_FUNCTION, TOP_LEVEL_FUNCTION, MEMBER_PROPERTY, MEMBER_PROPERTY_WITH_BACKING_FIELD, MEMBER_PROPERTY_WITH_DELEGATE, MEMBER_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, TOP_LEVEL_PROPERTY, TOP_LEVEL_PROPERTY_WITH_BACKING_FIELD, TOP_LEVEL_PROPERTY_WITH_DELEGATE, TOP_LEVEL_PROPERTY_WITHOUT_FIELD_OR_DELEGATE, INITIALIZER, DESTRUCTURING_DECLARATION, LAMBDA_EXPRESSION, ANONYMOUS_FUNCTION, OBJECT_LITERAL};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) I.clone();
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public /* synthetic */ n(String str, int i10, String str2, boolean z10, int i11, w wVar) {
        this(str, i10, str2, (i11 & 2) != 0 ? true : z10);
    }
}
