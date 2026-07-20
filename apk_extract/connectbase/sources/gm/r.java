package gm;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes3.dex */
@v("RegEx")
@Documented
@Retention(RetentionPolicy.RUNTIME)
@im.e
public @interface r {

    public static class a implements im.f<r> {
        @Override // im.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public im.g a(r rVar, Object obj) {
            if (!(obj instanceof String)) {
                return im.g.NEVER;
            }
            try {
                Pattern.compile((String) obj);
                return im.g.ALWAYS;
            } catch (PatternSyntaxException unused) {
                return im.g.NEVER;
            }
        }
    }

    im.g when() default im.g.ALWAYS;
}
