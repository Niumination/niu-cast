package androidx.sqlite.db;

import h0.a;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class SupportSQLiteQueryBuilder {
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private Object[] mBindArgs;
    private String mSelection;
    private final String mTable;
    private boolean mDistinct = false;
    private String[] mColumns = null;
    private String mGroupBy = null;
    private String mHaving = null;
    private String mOrderBy = null;
    private String mLimit = null;

    private SupportSQLiteQueryBuilder(String str) {
        this.mTable = str;
    }

    private static void appendClause(StringBuilder sb2, String str, String str2) {
        if (isEmpty(str2)) {
            return;
        }
        sb2.append(str);
        sb2.append(str2);
    }

    private static void appendColumns(StringBuilder sb2, String[] strArr) {
        int length = strArr.length;
        for (int i8 = 0; i8 < length; i8++) {
            String str = strArr[i8];
            if (i8 > 0) {
                sb2.append(", ");
            }
            sb2.append(str);
        }
        sb2.append(' ');
    }

    public static SupportSQLiteQueryBuilder builder(String str) {
        return new SupportSQLiteQueryBuilder(str);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public SupportSQLiteQueryBuilder columns(String[] strArr) {
        this.mColumns = strArr;
        return this;
    }

    public SupportSQLiteQuery create() {
        if (isEmpty(this.mGroupBy) && !isEmpty(this.mHaving)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        StringBuilder sb2 = new StringBuilder(120);
        sb2.append("SELECT ");
        if (this.mDistinct) {
            sb2.append("DISTINCT ");
        }
        String[] strArr = this.mColumns;
        if (strArr == null || strArr.length == 0) {
            sb2.append(" * ");
        } else {
            appendColumns(sb2, strArr);
        }
        sb2.append(" FROM ");
        sb2.append(this.mTable);
        appendClause(sb2, " WHERE ", this.mSelection);
        appendClause(sb2, " GROUP BY ", this.mGroupBy);
        appendClause(sb2, " HAVING ", this.mHaving);
        appendClause(sb2, " ORDER BY ", this.mOrderBy);
        appendClause(sb2, " LIMIT ", this.mLimit);
        return new SimpleSQLiteQuery(sb2.toString(), this.mBindArgs);
    }

    public SupportSQLiteQueryBuilder distinct() {
        this.mDistinct = true;
        return this;
    }

    public SupportSQLiteQueryBuilder groupBy(String str) {
        this.mGroupBy = str;
        return this;
    }

    public SupportSQLiteQueryBuilder having(String str) {
        this.mHaving = str;
        return this;
    }

    public SupportSQLiteQueryBuilder limit(String str) {
        if (!isEmpty(str) && !sLimitPattern.matcher(str).matches()) {
            throw new IllegalArgumentException(a.i("invalid LIMIT clauses:", str));
        }
        this.mLimit = str;
        return this;
    }

    public SupportSQLiteQueryBuilder orderBy(String str) {
        this.mOrderBy = str;
        return this;
    }

    public SupportSQLiteQueryBuilder selection(String str, Object[] objArr) {
        this.mSelection = str;
        this.mBindArgs = objArr;
        return this;
    }
}
