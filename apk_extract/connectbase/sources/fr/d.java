package fr;

import hs.a0;
import hs.p;
import hs.x;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@x(qualifier = fr.a.class)
@Repeatable(a.class)
public @interface d {

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @p
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
        d[] value();
    }

    @a0("value")
    String[] methods();

    String[] value();
}
