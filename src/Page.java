import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Page {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        int intent = 3;
        String user_name = "";
        String password = "";
        dictionary.put("admin", "admin");
        JOptionPane.showMessageDialog(
                null, "The system is empty. Please, register a new user", "Password validation",
                JOptionPane.QUESTION_MESSAGE
        );
        String new_user = JOptionPane.showInputDialog(
                null, "Create your username", "Password validation",
                JOptionPane.QUESTION_MESSAGE
        );
        String new_password;
        boolean is_valid = false;
        String patron = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
        do {
            new_password = JOptionPane.showInputDialog(
                    null, "Create your password " +
                            "(it must include uppercase letters, lowercase letters, numbers and a special character):",
                    "Password validation", JOptionPane.QUESTION_MESSAGE
            );
            if (new_password.matches(patron)) {
                is_valid = true;
                dictionary.put(new_user, new_password);
                JOptionPane.showMessageDialog(
                        null, "User successfully registered in the database!",
                        "Password validation", JOptionPane.QUESTION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null, "The password is very weak. Please try again.",
                        "Password validation", JOptionPane.QUESTION_MESSAGE
                );
            }
        } while (!is_valid);

        boolean access_granted = false;
        while (intent > 0) {
            user_name = JOptionPane.showInputDialog(
                    null, "LOGIN: Enter the user", "Password validation",
                    JOptionPane.QUESTION_MESSAGE
            );
            password = JOptionPane.showInputDialog(
                    null, "LOGIN: Enter the password", "Password",
                    JOptionPane.QUESTION_MESSAGE
            );
            if (dictionary.containsKey(user_name) && dictionary.get(user_name).equals(password)) {
                JOptionPane.showMessageDialog(
                        null, "Welcome to the system", "Password validation",
                        JOptionPane.QUESTION_MESSAGE
                );
                access_granted = true;
                break;
            } else {
                intent--;
                if (intent > 0) {
                    JOptionPane.showMessageDialog(
                            null, "Incorrect credentials. You have " + intent + " attempts remaining",
                            "Password validation", JOptionPane.QUESTION_MESSAGE
                    );
                }
            }
        }
        if (!access_granted) {
            JOptionPane.showMessageDialog(
                    null, "You have exceeded the attempt limit. User blocked.", "Password validation",
                    JOptionPane.QUESTION_MESSAGE
            );
        }
    }
}
