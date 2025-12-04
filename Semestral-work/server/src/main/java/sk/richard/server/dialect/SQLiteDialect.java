package sk.richard.server.dialect;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
    }

    // Nepoužívať @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new SQLiteIdentityColumnSupport();
    }

    public boolean supportsLimit() {
        return true;
    }

    public String getLimitString(String query, boolean hasOffset) {
        return query + (hasOffset ? " LIMIT ? OFFSET ?" : " LIMIT ?");
    }

    public static class SQLiteIdentityColumnSupport extends IdentityColumnSupportImpl {

        public boolean supportsIdentityColumns() {
            return true;
        }

        public String getIdentitySelectString(String table, String column, int type) {
            return "select last_insert_rowid()";
        }

        public String getIdentityColumnString(int type) {
            return "integer";
        }
    }
}
