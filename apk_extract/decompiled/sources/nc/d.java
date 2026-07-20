package nc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Reader f8160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public char f8161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f8162d;

    public d(String str) {
        Reader stringReader = new StringReader(str);
        this.f8160b = stringReader.markSupported() ? stringReader : new BufferedReader(stringReader);
        this.f8162d = false;
        this.f8159a = 0;
    }

    public final String a(int i8) {
        if (i8 == 0) {
            return "";
        }
        char[] cArr = new char[i8];
        int i9 = 0;
        if (this.f8162d) {
            this.f8162d = false;
            cArr[0] = this.f8161c;
            i9 = 1;
        }
        while (i9 < i8) {
            try {
                int i10 = this.f8160b.read(cArr, i9, i8 - i9);
                if (i10 == -1) {
                    break;
                }
                i9 += i10;
            } catch (IOException e) {
                throw new c(e);
            }
        }
        this.f8159a += i9;
        if (i9 < i8) {
            throw b("Substring bounds error");
        }
        this.f8161c = cArr[i8 - 1];
        return new String(cArr);
    }

    public final c b(String str) {
        StringBuilder sbS = o.d.s(str);
        sbS.append(toString());
        return new c(sbS.toString());
    }

    public final void c() {
        int i8;
        if (this.f8162d || (i8 = this.f8159a) <= 0) {
            throw new c("Stepping back two steps is not supported");
        }
        this.f8159a = i8 - 1;
        this.f8162d = true;
    }

    public final char d() {
        if (this.f8162d) {
            this.f8162d = false;
            char c9 = this.f8161c;
            if (c9 != 0) {
                this.f8159a++;
            }
            return c9;
        }
        try {
            int i8 = this.f8160b.read();
            if (i8 <= 0) {
                this.f8161c = (char) 0;
                return (char) 0;
            }
            this.f8159a++;
            char c10 = (char) i8;
            this.f8161c = c10;
            return c10;
        } catch (IOException e) {
            throw new c(e);
        }
    }

    public final char e() {
        char cD;
        do {
            cD = d();
            if (cD == 0) {
                break;
            }
        } while (cD <= ' ');
        return cD;
    }

    public final Serializable f() {
        char c9;
        char cE;
        char cE2 = e();
        if (cE2 != '\"') {
            if (cE2 != '[') {
                if (cE2 == '{') {
                    c();
                    HashMap map = new HashMap();
                    if (e() != '{') {
                        throw b("A JSONObject text must begin with '{'");
                    }
                    while (true) {
                        char cE3 = e();
                        if (cE3 == 0) {
                            throw b("A JSONObject text must end with '}'");
                        }
                        if (cE3 != '}') {
                            c();
                            String string = f().toString();
                            char cE4 = e();
                            if (cE4 == '=') {
                                if (d() != '>') {
                                    c();
                                }
                            } else if (cE4 != ':') {
                                throw b("Expected a ':' after a key");
                            }
                            Serializable serializableF = f();
                            if (string != null) {
                                if (map.containsKey(string)) {
                                    throw new c(h0.a.j("Duplicate key \"", string, "\""));
                                }
                                map.put(string, serializableF);
                            }
                            char cE5 = e();
                            if (cE5 == ',' || cE5 == ';') {
                                if (e() != '}') {
                                    c();
                                }
                            } else if (cE5 != '}') {
                                throw b("Expected a ',' or '}'");
                            }
                        }
                        return map;
                    }
                }
                if (cE2 != '\'') {
                    if (cE2 != '(') {
                        StringBuilder sb2 = new StringBuilder();
                        while (cE2 >= ' ' && ",:]}/\\\"[{;=#".indexOf(cE2) < 0) {
                            sb2.append(cE2);
                            cE2 = d();
                        }
                        c();
                        String strTrim = sb2.toString().trim();
                        if (strTrim.equals("")) {
                            throw b("Missing value");
                        }
                        if (!strTrim.equals("")) {
                            if (strTrim.equalsIgnoreCase("true")) {
                                return Boolean.TRUE;
                            }
                            if (strTrim.equalsIgnoreCase("false")) {
                                return Boolean.FALSE;
                            }
                            if (strTrim.equalsIgnoreCase("null")) {
                                return null;
                            }
                            for (int i8 = 0; i8 < strTrim.length(); i8++) {
                                char cCharAt = strTrim.charAt(i8);
                                if (Character.isDigit(cCharAt) || cCharAt == '-' || cCharAt == '.' || cCharAt == '+' || cCharAt == 'e' || cCharAt == 'E') {
                                }
                            }
                            return new e(strTrim);
                        }
                        return strTrim;
                    }
                }
            }
            c();
            ArrayList arrayList = new ArrayList();
            char cE6 = e();
            if (cE6 == '[') {
                c9 = ']';
            } else {
                if (cE6 != '(') {
                    throw b("A JSONArray text must start with '['");
                }
                c9 = ')';
            }
            if (e() != ']') {
                c();
                while (true) {
                    if (e() == ',') {
                        c();
                        arrayList.add(null);
                    } else {
                        c();
                        arrayList.add(f());
                    }
                    cE = e();
                    if (cE == ')') {
                        break;
                    }
                    if (cE != ',' && cE != ';') {
                        if (cE == ']') {
                            break;
                        }
                        throw b("Expected a ',' or ']'");
                    }
                    if (e() != ']') {
                        c();
                    }
                }
                if (c9 != cE) {
                    throw b("Expected a '" + c9 + "'");
                }
            }
            return arrayList;
        }
        StringBuilder sb3 = new StringBuilder();
        while (true) {
            char cD = d();
            if (cD == 0 || cD == '\n' || cD == '\r') {
                throw b("Unterminated string");
            }
            if (cD == '\\') {
                char cD2 = d();
                if (cD2 == 'b') {
                    sb3.append('\b');
                } else if (cD2 == 'f') {
                    sb3.append('\f');
                } else if (cD2 == 'n') {
                    sb3.append('\n');
                } else if (cD2 == 'r') {
                    sb3.append('\r');
                } else if (cD2 == 'x') {
                    sb3.append((char) Integer.parseInt(a(2), 16));
                } else if (cD2 == 't') {
                    sb3.append('\t');
                } else if (cD2 != 'u') {
                    sb3.append(cD2);
                } else {
                    sb3.append((char) Integer.parseInt(a(4), 16));
                }
            } else {
                if (cD == cE2) {
                    return sb3.toString();
                }
                sb3.append(cD);
            }
        }
    }

    public final String toString() {
        return " at character " + this.f8159a;
    }
}
