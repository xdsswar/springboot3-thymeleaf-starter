package xss.it.code.template.services.internals;

/**
 * @author XDSSWAR
 * Created on 12/27/2022
 */
public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
