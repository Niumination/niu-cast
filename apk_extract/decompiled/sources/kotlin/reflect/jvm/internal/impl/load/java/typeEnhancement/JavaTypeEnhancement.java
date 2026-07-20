package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\ntypeEnhancement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,262:1\n1#2:263\n3436#3,7:264\n1734#3,3:271\n3436#3,7:274\n*S KotlinDebug\n*F\n+ 1 typeEnhancement.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/JavaTypeEnhancement\n*L\n117#1:264,7\n143#1:271,3\n155#1:274,7\n*E\n"})
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    public static final class Result {
        private final int subtreeSize;
        private final KotlinType type;

        public Result(KotlinType kotlinType, int i8) {
            this.type = kotlinType;
            this.subtreeSize = i8;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final KotlinType getType() {
            return this.type;
        }
    }

    public static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        private final SimpleType type;

        public SimpleResult(SimpleType simpleType, int i8, boolean z2) {
            this.type = simpleType;
            this.subtreeSize = i8;
            this.forWarnings = z2;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final SimpleType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(JavaResolverSettings javaResolverSettings) {
        Intrinsics.checkNotNullParameter(javaResolverSettings, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v14 */
    private final SimpleResult enhanceInflexible(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i8, TypeComponentPosition typeComponentPosition, boolean z2, boolean z3) {
        ClassifierDescriptor classifierDescriptorMo1437getDeclarationDescriptor;
        TypeConstructor constructor;
        boolean z5;
        Result result;
        TypeProjection typeProjectionMakeStarProjection;
        Function1<? super Integer, JavaTypeQualifiers> function2 = function1;
        boolean zShouldEnhance = TypeComponentPositionKt.shouldEnhance(typeComponentPosition);
        ?? r7 = 0;
        boolean z10 = (z3 && z2) ? false : true;
        KotlinType kotlinType = null;
        if ((zShouldEnhance || !simpleType.getArguments().isEmpty()) && (classifierDescriptorMo1437getDeclarationDescriptor = simpleType.getConstructor().mo1437getDeclarationDescriptor()) != null) {
            JavaTypeQualifiers javaTypeQualifiersInvoke = function2.invoke(Integer.valueOf(i8));
            ClassifierDescriptor classifierDescriptorEnhanceMutability = TypeEnhancementKt.enhanceMutability(classifierDescriptorMo1437getDeclarationDescriptor, javaTypeQualifiersInvoke, typeComponentPosition);
            Boolean enhancedNullability = TypeEnhancementKt.getEnhancedNullability(javaTypeQualifiersInvoke, typeComponentPosition);
            if (classifierDescriptorEnhanceMutability == null || (constructor = classifierDescriptorEnhanceMutability.getTypeConstructor()) == null) {
                constructor = simpleType.getConstructor();
            }
            TypeConstructor typeConstructor = constructor;
            int subtreeSize = i8 + 1;
            List<TypeProjection> arguments = simpleType.getArguments();
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "getParameters(...)");
            List<TypeParameterDescriptor> list = parameters;
            Iterator<T> it = arguments.iterator();
            Iterator<T> it2 = list.iterator();
            ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.i(arguments), CollectionsKt.i(list)));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) it2.next();
                TypeProjection typeProjection = (TypeProjection) next;
                if (z10) {
                    z5 = z10;
                    if (!typeProjection.isStarProjection()) {
                        result = enhancePossiblyFlexible(typeProjection.getType().unwrap(), function2, subtreeSize, z3);
                    } else if (function2.invoke(Integer.valueOf(subtreeSize)).getNullability() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                        UnwrappedType unwrappedTypeUnwrap = typeProjection.getType().unwrap();
                        result = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(unwrappedTypeUnwrap).makeNullableAsSpecified((boolean) r7), FlexibleTypesKt.upperIfFlexible(unwrappedTypeUnwrap).makeNullableAsSpecified(true)), 1);
                    } else {
                        result = new Result(null, 1);
                    }
                } else {
                    z5 = z10;
                    result = new Result(kotlinType, r7);
                }
                subtreeSize += result.getSubtreeSize();
                if (result.getType() != null) {
                    KotlinType type = result.getType();
                    Variance projectionKind = typeProjection.getProjectionKind();
                    Intrinsics.checkNotNullExpressionValue(projectionKind, "getProjectionKind(...)");
                    typeProjectionMakeStarProjection = TypeUtilsKt.createProjection(type, projectionKind, typeParameterDescriptor);
                } else if (classifierDescriptorEnhanceMutability == null || typeProjection.isStarProjection()) {
                    typeProjectionMakeStarProjection = classifierDescriptorEnhanceMutability != null ? TypeUtils.makeStarProjection(typeParameterDescriptor) : null;
                } else {
                    KotlinType type2 = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type2, "getType(...)");
                    Variance projectionKind2 = typeProjection.getProjectionKind();
                    Intrinsics.checkNotNullExpressionValue(projectionKind2, "getProjectionKind(...)");
                    typeProjectionMakeStarProjection = TypeUtilsKt.createProjection(type2, projectionKind2, typeParameterDescriptor);
                }
                arrayList.add(typeProjectionMakeStarProjection);
                function2 = function1;
                z10 = z5;
                r7 = 0;
                kotlinType = null;
            }
            int i9 = subtreeSize - i8;
            if (classifierDescriptorEnhanceMutability == null && enhancedNullability == null) {
                if (!arrayList.isEmpty()) {
                    Iterator it3 = arrayList.iterator();
                    do {
                        if (it3.hasNext()) {
                        }
                    } while (((TypeProjection) it3.next()) == null);
                }
                return new SimpleResult(null, i9, false);
            }
            Annotations annotations = simpleType.getAnnotations();
            EnhancedTypeAnnotations enhancedTypeAnnotations = TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS;
            if (classifierDescriptorEnhanceMutability == null) {
                enhancedTypeAnnotations = null;
            }
            TypeAttributes defaultAttributes = TypeAttributesKt.toDefaultAttributes(TypeEnhancementKt.compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull((Object[]) new Annotations[]{annotations, enhancedTypeAnnotations, enhancedNullability != null ? TypeEnhancementKt.getENHANCED_NULLABILITY_ANNOTATIONS() : null})));
            List<TypeProjection> arguments2 = simpleType.getArguments();
            Iterator it4 = arrayList.iterator();
            Iterator<T> it5 = arguments2.iterator();
            ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt.i(arrayList), CollectionsKt.i(arguments2)));
            while (it4.hasNext() && it5.hasNext()) {
                Object next2 = it4.next();
                TypeProjection typeProjection2 = (TypeProjection) it5.next();
                TypeProjection typeProjection3 = (TypeProjection) next2;
                if (typeProjection3 != null) {
                    typeProjection2 = typeProjection3;
                }
                arrayList2.add(typeProjection2);
            }
            SimpleType simpleTypeSimpleType$default = KotlinTypeFactory.simpleType$default(defaultAttributes, typeConstructor, arrayList2, enhancedNullability != null ? enhancedNullability.booleanValue() : simpleType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
            if (javaTypeQualifiersInvoke.getDefinitelyNotNull()) {
                simpleTypeSimpleType$default = notNullTypeParameter(simpleTypeSimpleType$default);
            }
            return new SimpleResult(simpleTypeSimpleType$default, i9, enhancedNullability != null && javaTypeQualifiersInvoke.isNullabilityQualifierForWarning());
        }
        return new SimpleResult(null, 1, false);
    }

    public static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i8, TypeComponentPosition typeComponentPosition, boolean z2, boolean z3, int i9, Object obj) {
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i8, typeComponentPosition, (i9 & 8) != 0 ? false : z2, (i9 & 16) != 0 ? false : z3);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0098  */
    private final Result enhancePossiblyFlexible(UnwrappedType unwrappedType, Function1<? super Integer, JavaTypeQualifiers> function1, int i8, boolean z2) {
        KotlinType type;
        KotlinType kotlinTypeWrapEnhancement = null;
        if (KotlinTypeKt.isError(unwrappedType)) {
            return new Result(null, 1);
        }
        if (!(unwrappedType instanceof FlexibleType)) {
            if (!(unwrappedType instanceof SimpleType)) {
                throw new NoWhenBranchMatchedException();
            }
            SimpleResult simpleResultEnhanceInflexible$default = enhanceInflexible$default(this, (SimpleType) unwrappedType, function1, i8, TypeComponentPosition.INFLEXIBLE, false, z2, 8, null);
            return new Result(simpleResultEnhanceInflexible$default.getForWarnings() ? TypeWithEnhancementKt.wrapEnhancement(unwrappedType, simpleResultEnhanceInflexible$default.getType()) : simpleResultEnhanceInflexible$default.getType(), simpleResultEnhanceInflexible$default.getSubtreeSize());
        }
        boolean z3 = unwrappedType instanceof RawType;
        FlexibleType flexibleType = (FlexibleType) unwrappedType;
        SimpleResult simpleResultEnhanceInflexible = enhanceInflexible(flexibleType.getLowerBound(), function1, i8, TypeComponentPosition.FLEXIBLE_LOWER, z3, z2);
        SimpleResult simpleResultEnhanceInflexible2 = enhanceInflexible(flexibleType.getUpperBound(), function1, i8, TypeComponentPosition.FLEXIBLE_UPPER, z3, z2);
        simpleResultEnhanceInflexible.getSubtreeSize();
        simpleResultEnhanceInflexible2.getSubtreeSize();
        if (simpleResultEnhanceInflexible.getType() != null || simpleResultEnhanceInflexible2.getType() != null) {
            if (simpleResultEnhanceInflexible.getForWarnings() || simpleResultEnhanceInflexible2.getForWarnings()) {
                SimpleType type2 = simpleResultEnhanceInflexible2.getType();
                if (type2 == null) {
                    type = simpleResultEnhanceInflexible.getType();
                    Intrinsics.checkNotNull(type);
                } else {
                    SimpleType type3 = simpleResultEnhanceInflexible.getType();
                    if (type3 == null) {
                        type3 = type2;
                    }
                    type = KotlinTypeFactory.flexibleType(type3, type2);
                    if (type == null) {
                        type = simpleResultEnhanceInflexible.getType();
                        Intrinsics.checkNotNull(type);
                    }
                }
                kotlinTypeWrapEnhancement = TypeWithEnhancementKt.wrapEnhancement(unwrappedType, type);
            } else if (z3) {
                SimpleType type4 = simpleResultEnhanceInflexible.getType();
                if (type4 == null) {
                    type4 = flexibleType.getLowerBound();
                }
                SimpleType type5 = simpleResultEnhanceInflexible2.getType();
                if (type5 == null) {
                    type5 = flexibleType.getUpperBound();
                }
                kotlinTypeWrapEnhancement = new RawTypeImpl(type4, type5);
            } else {
                SimpleType type6 = simpleResultEnhanceInflexible.getType();
                if (type6 == null) {
                    type6 = flexibleType.getLowerBound();
                }
                SimpleType type7 = simpleResultEnhanceInflexible2.getType();
                if (type7 == null) {
                    type7 = flexibleType.getUpperBound();
                }
                kotlinTypeWrapEnhancement = KotlinTypeFactory.flexibleType(type6, type7);
            }
        }
        return new Result(kotlinTypeWrapEnhancement, simpleResultEnhanceInflexible.getSubtreeSize());
    }

    private final SimpleType notNullTypeParameter(SimpleType simpleType) {
        return this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter() ? SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true) : new NotNullTypeParameterImpl(simpleType);
    }

    public final KotlinType enhance(KotlinType kotlinType, Function1<? super Integer, JavaTypeQualifiers> qualifiers, boolean z2) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(qualifiers, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), qualifiers, 0, z2).getType();
    }
}
