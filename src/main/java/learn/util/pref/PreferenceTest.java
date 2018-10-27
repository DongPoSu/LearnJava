package learn.util.pref;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * @author suzheng
 * @version v.1.0
 */
public class PreferenceTest {
    public static void main(String[] args) throws BackingStoreException {
//        Preferences preferences = Preferences.userRoot();
//
//        preferences.addPreferenceChangeListener(evt -> {
//            System.out.println(evt.getKey());
//            System.out.println(evt.getNewValue());
//
//        });
//        preferences = preferences.node("test");
//        preferences = preferences.node("next");
//        preferences.put("a","测试");
//        preferences.put("b","测试");
//        preferences = preferences.node("test");
//        preferences.removeNode();
//        System.out.println(preferences.absolutePath());

//        Preferences preferences = Preferences.systemRoot();
//        preferences = preferences.node("test");

//        preferences.flush();

        System.out.println(System.getProperty("java.vm.name"));
    }
}
