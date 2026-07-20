package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import mm.a;
import mm.b;
import mm.e;
import mm.f;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.FIELD, ElementType.METHOD})
@f(allowedTargets = {b.FIELD, b.FUNCTION, b.PROPERTY_GETTER, b.PROPERTY_SETTER})
@e(a.BINARY)
@Retention(RetentionPolicy.CLASS)
public @interface GuardedBy {
    String value();
}
