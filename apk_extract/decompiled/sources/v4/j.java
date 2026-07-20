package v4;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public abstract class j implements k {
    private static final /* synthetic */ j[] $VALUES;
    public static final j IDENTITY;
    public static final j LOWER_CASE_WITH_DASHES;
    public static final j LOWER_CASE_WITH_DOTS;
    public static final j LOWER_CASE_WITH_UNDERSCORES;
    public static final j UPPER_CAMEL_CASE;
    public static final j UPPER_CAMEL_CASE_WITH_SPACES;
    public static final j UPPER_CASE_WITH_UNDERSCORES;

    static {
        c cVar = new c("IDENTITY", 0);
        IDENTITY = cVar;
        final String str = "UPPER_CAMEL_CASE";
        final int i8 = 1;
        j jVar = new j(str, i8) { // from class: v4.d
            {
                c cVar2 = null;
            }

            @Override // v4.j, v4.k
            public /* bridge */ /* synthetic */ List alternateNames(Field field) {
                return super.alternateNames(field);
            }

            @Override // v4.j, v4.k
            public String translateName(Field field) {
                return j.upperCaseFirstLetter(field.getName());
            }
        };
        UPPER_CAMEL_CASE = jVar;
        final String str2 = "UPPER_CAMEL_CASE_WITH_SPACES";
        final int i9 = 2;
        j jVar2 = new j(str2, i9) { // from class: v4.e
            {
                c cVar2 = null;
            }

            @Override // v4.j, v4.k
            public /* bridge */ /* synthetic */ List alternateNames(Field field) {
                return super.alternateNames(field);
            }

            @Override // v4.j, v4.k
            public String translateName(Field field) {
                return j.upperCaseFirstLetter(j.separateCamelCase(field.getName(), ' '));
            }
        };
        UPPER_CAMEL_CASE_WITH_SPACES = jVar2;
        final String str3 = "UPPER_CASE_WITH_UNDERSCORES";
        final int i10 = 3;
        j jVar3 = new j(str3, i10) { // from class: v4.f
            {
                c cVar2 = null;
            }

            @Override // v4.j, v4.k
            public /* bridge */ /* synthetic */ List alternateNames(Field field) {
                return super.alternateNames(field);
            }

            @Override // v4.j, v4.k
            public String translateName(Field field) {
                return j.separateCamelCase(field.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        };
        UPPER_CASE_WITH_UNDERSCORES = jVar3;
        final String str4 = "LOWER_CASE_WITH_UNDERSCORES";
        final int i11 = 4;
        j jVar4 = new j(str4, i11) { // from class: v4.g
            {
                c cVar2 = null;
            }

            @Override // v4.j, v4.k
            public /* bridge */ /* synthetic */ List alternateNames(Field field) {
                return super.alternateNames(field);
            }

            @Override // v4.j, v4.k
            public String translateName(Field field) {
                return j.separateCamelCase(field.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_UNDERSCORES = jVar4;
        final String str5 = "LOWER_CASE_WITH_DASHES";
        final int i12 = 5;
        j jVar5 = new j(str5, i12) { // from class: v4.h
            {
                c cVar2 = null;
            }

            @Override // v4.j, v4.k
            public /* bridge */ /* synthetic */ List alternateNames(Field field) {
                return super.alternateNames(field);
            }

            @Override // v4.j, v4.k
            public String translateName(Field field) {
                return j.separateCamelCase(field.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DASHES = jVar5;
        final String str6 = "LOWER_CASE_WITH_DOTS";
        final int i13 = 6;
        j jVar6 = new j(str6, i13) { // from class: v4.i
            {
                c cVar2 = null;
            }

            @Override // v4.j, v4.k
            public /* bridge */ /* synthetic */ List alternateNames(Field field) {
                return super.alternateNames(field);
            }

            @Override // v4.j, v4.k
            public String translateName(Field field) {
                return j.separateCamelCase(field.getName(), '.').toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DOTS = jVar6;
        $VALUES = new j[]{cVar, jVar, jVar2, jVar3, jVar4, jVar5, jVar6};
    }

    private j(String str, int i8) {
        super(str, i8);
    }

    public static String separateCamelCase(String str, char c9) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (Character.isUpperCase(cCharAt) && sb2.length() != 0) {
                sb2.append(c9);
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public static String upperCaseFirstLetter(String str) {
        int length = str.length();
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (Character.isLetter(cCharAt)) {
                if (Character.isUpperCase(cCharAt)) {
                    return str;
                }
                char upperCase = Character.toUpperCase(cCharAt);
                if (i8 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i8) + upperCase + str.substring(i8 + 1);
            }
        }
        return str;
    }

    public static j valueOf(String str) {
        return (j) Enum.valueOf(j.class, str);
    }

    public static j[] values() {
        return (j[]) $VALUES.clone();
    }

    public /* bridge */ /* synthetic */ List alternateNames(Field field) {
        return super.alternateNames(field);
    }

    public abstract /* synthetic */ String translateName(Field field);

    public /* synthetic */ j(String str, int i8, c cVar) {
        this(str, i8);
    }
}
