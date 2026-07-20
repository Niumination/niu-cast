package kotlin.reflect.jvm.internal.impl.load.kotlin;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.PointerIconCompat;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeMappingMode {

    @JvmField
    public static final TypeMappingMode CLASS_DECLARATION;
    public static final Companion Companion = new Companion(null);

    @JvmField
    public static final TypeMappingMode DEFAULT;

    @JvmField
    public static final TypeMappingMode DEFAULT_UAST;

    @JvmField
    public static final TypeMappingMode GENERIC_ARGUMENT;

    @JvmField
    public static final TypeMappingMode GENERIC_ARGUMENT_UAST;

    @JvmField
    public static final TypeMappingMode RETURN_TYPE_BOXED;

    @JvmField
    public static final TypeMappingMode SUPER_TYPE;

    @JvmField
    public static final TypeMappingMode SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS;

    @JvmField
    public static final TypeMappingMode VALUE_FOR_ANNOTATION;
    private final TypeMappingMode genericArgumentMode;
    private final TypeMappingMode genericContravariantArgumentMode;
    private final TypeMappingMode genericInvariantArgumentMode;
    private final boolean isForAnnotationParameter;
    private final boolean kotlinCollectionsToJavaCollections;
    private final boolean mapTypeAliases;
    private final boolean needInlineClassWrapping;
    private final boolean needPrimitiveBoxing;
    private final boolean skipDeclarationSiteWildcards;
    private final boolean skipDeclarationSiteWildcardsIfPossible;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            try {
                iArr[Variance.IN_VARIANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Variance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z2 = false;
        boolean z3 = false;
        boolean z5 = false;
        boolean z10 = false;
        TypeMappingMode typeMappingMode = null;
        boolean z11 = false;
        TypeMappingMode typeMappingMode2 = null;
        TypeMappingMode typeMappingMode3 = null;
        boolean z12 = false;
        TypeMappingMode typeMappingMode4 = new TypeMappingMode(z2, false, z3, z5, z10, typeMappingMode, z11, typeMappingMode2, typeMappingMode3, z12, 1023, defaultConstructorMarker);
        GENERIC_ARGUMENT = typeMappingMode4;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        TypeMappingMode typeMappingMode5 = null;
        TypeMappingMode typeMappingMode6 = null;
        boolean z19 = true;
        TypeMappingMode typeMappingMode7 = new TypeMappingMode(z13, z14, z15, z16, z17, null, z18, typeMappingMode5, typeMappingMode6, z19, FrameMetricsAggregator.EVERY_DURATION, defaultConstructorMarker2);
        GENERIC_ARGUMENT_UAST = typeMappingMode7;
        RETURN_TYPE_BOXED = new TypeMappingMode(z2, true, z3, z5, z10, typeMappingMode, z11, typeMappingMode2, typeMappingMode3, z12, PointerIconCompat.TYPE_GRABBING, defaultConstructorMarker);
        int i8 = 988;
        DEFAULT = new TypeMappingMode(z2, false, z3, z5, z10, typeMappingMode4, z11, typeMappingMode2, typeMappingMode3, z12, i8, defaultConstructorMarker);
        DEFAULT_UAST = new TypeMappingMode(z13, z14, z15, z16, z17, typeMappingMode7, z18, typeMappingMode5, typeMappingMode6, z19, 476, defaultConstructorMarker2);
        CLASS_DECLARATION = new TypeMappingMode(z2, true, z3, z5, z10, typeMappingMode4, z11, typeMappingMode2, typeMappingMode3, z12, i8, defaultConstructorMarker);
        boolean z20 = false;
        boolean z21 = true;
        SUPER_TYPE = new TypeMappingMode(z2, z20, z3, z21, z10, typeMappingMode4, z11, typeMappingMode2, typeMappingMode3, z12, 983, defaultConstructorMarker);
        SUPER_TYPE_KOTLIN_COLLECTIONS_AS_IS = new TypeMappingMode(z2, z20, z3, z21, z10, typeMappingMode4, z11, typeMappingMode2, typeMappingMode3, z12, 919, defaultConstructorMarker);
        VALUE_FOR_ANNOTATION = new TypeMappingMode(z2, z20, true, false, z10, typeMappingMode4, z11, typeMappingMode2, typeMappingMode3, z12, 984, defaultConstructorMarker);
    }

    public TypeMappingMode() {
        this(false, false, false, false, false, null, false, null, null, false, 1023, null);
    }

    public final boolean getKotlinCollectionsToJavaCollections() {
        return this.kotlinCollectionsToJavaCollections;
    }

    public final boolean getMapTypeAliases() {
        return this.mapTypeAliases;
    }

    public final boolean getNeedInlineClassWrapping() {
        return this.needInlineClassWrapping;
    }

    public final boolean getNeedPrimitiveBoxing() {
        return this.needPrimitiveBoxing;
    }

    public final boolean isForAnnotationParameter() {
        return this.isForAnnotationParameter;
    }

    public final TypeMappingMode toGenericArgumentMode(Variance effectiveVariance, boolean z2) {
        TypeMappingMode typeMappingMode;
        Intrinsics.checkNotNullParameter(effectiveVariance, "effectiveVariance");
        if (z2 && this.isForAnnotationParameter) {
            return this;
        }
        int i8 = WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()];
        if (i8 == 1) {
            typeMappingMode = this.genericContravariantArgumentMode;
            if (typeMappingMode == null) {
                return this;
            }
        } else if (i8 != 2) {
            typeMappingMode = this.genericArgumentMode;
            if (typeMappingMode == null) {
                return this;
            }
        } else {
            typeMappingMode = this.genericInvariantArgumentMode;
            if (typeMappingMode == null) {
                return this;
            }
        }
        return typeMappingMode;
    }

    public final TypeMappingMode wrapInlineClassesMode() {
        return new TypeMappingMode(this.needPrimitiveBoxing, true, this.isForAnnotationParameter, this.skipDeclarationSiteWildcards, this.skipDeclarationSiteWildcardsIfPossible, this.genericArgumentMode, this.kotlinCollectionsToJavaCollections, this.genericContravariantArgumentMode, this.genericInvariantArgumentMode, false, 512, null);
    }

    public TypeMappingMode(boolean z2, boolean z3, boolean z5, boolean z10, boolean z11, TypeMappingMode typeMappingMode, boolean z12, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z13) {
        this.needPrimitiveBoxing = z2;
        this.needInlineClassWrapping = z3;
        this.isForAnnotationParameter = z5;
        this.skipDeclarationSiteWildcards = z10;
        this.skipDeclarationSiteWildcardsIfPossible = z11;
        this.genericArgumentMode = typeMappingMode;
        this.kotlinCollectionsToJavaCollections = z12;
        this.genericContravariantArgumentMode = typeMappingMode2;
        this.genericInvariantArgumentMode = typeMappingMode3;
        this.mapTypeAliases = z13;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ TypeMappingMode(boolean z2, boolean z3, boolean z5, boolean z10, boolean z11, TypeMappingMode typeMappingMode, boolean z12, TypeMappingMode typeMappingMode2, TypeMappingMode typeMappingMode3, boolean z13, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        z2 = (i8 & 1) != 0 ? true : z2;
        z3 = (i8 & 2) != 0 ? true : z3;
        z5 = (i8 & 4) != 0 ? false : z5;
        z10 = (i8 & 8) != 0 ? false : z10;
        z11 = (i8 & 16) != 0 ? false : z11;
        typeMappingMode = (i8 & 32) != 0 ? null : typeMappingMode;
        this(z2, z3, z5, z10, z11, typeMappingMode, (i8 & 64) != 0 ? true : z12, (i8 & 128) != 0 ? typeMappingMode : typeMappingMode2, (i8 & 256) != 0 ? typeMappingMode : typeMappingMode3, (i8 & 512) != 0 ? false : z13);
    }
}
