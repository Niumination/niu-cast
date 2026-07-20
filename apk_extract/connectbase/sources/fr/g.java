package fr;

import hs.a0;
import hs.y;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@y(qualifier = fr.a.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface g {

    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
        g[] value();
    }

    @a0("value")
    String[] methods();

    String[] value();
}
