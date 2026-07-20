package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import lm.k;
import mm.a;
import mm.b;
import mm.e;
import mm.f;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@f(allowedTargets = {b.FUNCTION, b.PROPERTY_GETTER, b.PROPERTY_SETTER})
@e(a.SOURCE)
@Retention(RetentionPolicy.SOURCE)
@k(message = "Replaced by the {@code androidx.resourceinpsection} package.")
public @interface InspectableProperty {

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @f(allowedTargets = {b.ANNOTATION_CLASS, b.CLASS})
    @e(a.SOURCE)
    @Retention(RetentionPolicy.SOURCE)
    public @interface EnumEntry {
        String name();

        int value();
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @f(allowedTargets = {b.ANNOTATION_CLASS, b.CLASS})
    @e(a.SOURCE)
    @Retention(RetentionPolicy.SOURCE)
    public @interface FlagEntry {
        int mask() default 0;

        String name();

        int target();
    }

    public enum ValueType {
        NONE,
        INFERRED,
        INT_ENUM,
        INT_FLAG,
        COLOR,
        GRAVITY,
        RESOURCE_ID
    }

    int attributeId() default 0;

    EnumEntry[] enumMapping() default {};

    FlagEntry[] flagMapping() default {};

    boolean hasAttributeId() default true;

    String name() default "";

    ValueType valueType() default ValueType.INFERRED;
}
