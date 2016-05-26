package com.office.hibernate.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;
 
import org.hibernate.HibernateException;
import org.hibernate.usertype.EnhancedUserType;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.engine.spi.SessionImplementor;

public class PGEnumUserType implements EnhancedUserType, ParameterizedType  {

private Class<Enum> enumClass;

public PGEnumUserType(){
    super();
}

public void setParameterValues(Properties parameters) {
    String enumClassName = parameters.getProperty("enumClassName");
    try {
        enumClass = (Class<Enum>) Class.forName(enumClassName);
    } catch (ClassNotFoundException e) {
        throw new HibernateException("Enum class not found ", e);
    }

}

public int[] sqlTypes() {
    return new int[] {Types.VARCHAR};
}

public Class returnedClass() {
    return enumClass;
}

public boolean equals(Object x, Object y) throws HibernateException {
    return x==y;
}

public int hashCode(Object x) throws HibernateException {
    return x.hashCode();
}

@Override
public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
            throws SQLException {
    String name = rs.getString(names[0]);
    return rs.wasNull() ? null: Enum.valueOf(enumClass,name);
}

@Override
public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session) 
throws HibernateException, SQLException  {
    if (value == null) {
        st.setNull(index, Types.VARCHAR);
    }
    else {
        st.setObject(index,((Enum) value), Types.OTHER);
    }
}

public Object deepCopy(Object value) throws HibernateException {
    return value;
}

public boolean isMutable() {
    return false;  //To change body of implemented methods use File | Settings | File Templates.
}

public Serializable disassemble(Object value) throws HibernateException {
    return (Enum) value;
}

public Object assemble(Serializable cached, Object owner) throws HibernateException {
    return cached;
}

public Object replace(Object original, Object target, Object owner) throws HibernateException {
    return original;
}

public Object fromXMLString(String xmlValue) {
    return Enum.valueOf(enumClass, xmlValue);
}

public String objectToSQLString(Object value) {
    return '\'' + ( (Enum) value ).name() + '\'';
}

public String toXMLString(Object value) {
    return ( (Enum) value ).name();
}

}