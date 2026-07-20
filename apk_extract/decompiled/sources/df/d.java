package df;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4441d;
    public int e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public char[] f4442g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f4438a = name;
        this.f4439b = name.length();
    }

    public final int a(int i8) {
        int i9;
        int i10;
        int i11 = i8 + 1;
        int i12 = this.f4439b;
        String str = this.f4438a;
        if (i11 >= i12) {
            throw new IllegalStateException("Malformed DN: " + str);
        }
        char[] cArr = this.f4442g;
        char c9 = cArr[i8];
        if (c9 >= '0' && c9 <= '9') {
            i9 = c9 - '0';
        } else if (c9 >= 'a' && c9 <= 'f') {
            i9 = c9 - 'W';
        } else {
            if (c9 < 'A' || c9 > 'F') {
                throw new IllegalStateException("Malformed DN: " + str);
            }
            i9 = c9 - '7';
        }
        char c10 = cArr[i11];
        if (c10 >= '0' && c10 <= '9') {
            i10 = c10 - '0';
        } else if (c10 >= 'a' && c10 <= 'f') {
            i10 = c10 - 'W';
        } else {
            if (c10 < 'A' || c10 > 'F') {
                throw new IllegalStateException("Malformed DN: " + str);
            }
            i10 = c10 - '7';
        }
        return (i9 << 4) + i10;
    }

    public final char b() {
        int i8;
        int i9 = this.f4440c + 1;
        this.f4440c = i9;
        int i10 = this.f4439b;
        if (i9 == i10) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f4438a);
        }
        char c9 = this.f4442g[i9];
        if (c9 != ' ' && c9 != '%' && c9 != '\\' && c9 != '_' && c9 != '\"' && c9 != '#') {
            switch (c9) {
                default:
                    switch (c9) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            int iA = a(i9);
                            this.f4440c++;
                            if (iA >= 128) {
                                if (iA >= 192 && iA <= 247) {
                                    if (iA <= 223) {
                                        iA &= 31;
                                        i8 = 1;
                                    } else if (iA <= 239) {
                                        iA &= 15;
                                        i8 = 2;
                                    } else {
                                        iA &= 7;
                                        i8 = 3;
                                    }
                                    for (int i11 = 0; i11 < i8; i11++) {
                                        int i12 = this.f4440c;
                                        int i13 = i12 + 1;
                                        this.f4440c = i13;
                                        if (i13 != i10 && this.f4442g[i13] == '\\') {
                                            int i14 = i12 + 2;
                                            this.f4440c = i14;
                                            int iA2 = a(i14);
                                            this.f4440c++;
                                            if ((iA2 & 192) == 128) {
                                                iA = (iA << 6) + (iA2 & 63);
                                            }
                                        }
                                    }
                                }
                                return '?';
                            }
                            return (char) iA;
                    }
                case '*':
                case '+':
                case ',':
                    return c9;
            }
        }
        return c9;
    }

    public final String c() {
        int i8;
        int i9;
        int i10;
        char c9;
        int i11;
        char c10;
        char c11;
        while (true) {
            i8 = this.f4440c;
            i9 = this.f4439b;
            if (i8 >= i9 || this.f4442g[i8] != ' ') {
                break;
            }
            this.f4440c = i8 + 1;
        }
        if (i8 == i9) {
            return null;
        }
        this.f4441d = i8;
        this.f4440c = i8 + 1;
        while (true) {
            i10 = this.f4440c;
            if (i10 >= i9 || (c11 = this.f4442g[i10]) == '=' || c11 == ' ') {
                break;
            }
            this.f4440c = i10 + 1;
        }
        String str = this.f4438a;
        if (i10 >= i9) {
            throw new IllegalStateException("Unexpected end of DN: " + str);
        }
        this.e = i10;
        if (this.f4442g[i10] == ' ') {
            while (true) {
                i11 = this.f4440c;
                if (i11 >= i9 || (c10 = this.f4442g[i11]) == '=' || c10 != ' ') {
                    break;
                }
                this.f4440c = i11 + 1;
            }
            if (this.f4442g[i11] != '=' || i11 == i9) {
                throw new IllegalStateException("Unexpected end of DN: " + str);
            }
        }
        this.f4440c++;
        while (true) {
            int i12 = this.f4440c;
            if (i12 >= i9 || this.f4442g[i12] != ' ') {
                break;
            }
            this.f4440c = i12 + 1;
        }
        int i13 = this.e;
        int i14 = this.f4441d;
        if (i13 - i14 > 4) {
            char[] cArr = this.f4442g;
            if (cArr[i14 + 3] == '.' && (((c9 = cArr[i14]) == 'O' || c9 == 'o') && ((cArr[i14 + 1] == 'I' || cArr[i14 + 1] == 'i') && (cArr[i14 + 2] == 'D' || cArr[i14 + 2] == 'd')))) {
                this.f4441d = i14 + 4;
            }
        }
        char[] cArr2 = this.f4442g;
        int i15 = this.f4441d;
        return new String(cArr2, i15, i13 - i15);
    }
}
