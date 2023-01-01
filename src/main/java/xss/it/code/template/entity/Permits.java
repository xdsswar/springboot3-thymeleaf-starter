package xss.it.code.template.entity;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * @author XDSSWAR
 * Created on 01/01/2023
 */
public enum Permits {
    ADMIN,
    USER;

    public static List<Permits> findAll(){
        return new ArrayList<>(EnumSet.allOf(Permits.class));
    }
}
