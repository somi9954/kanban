package validators;


public interface PasswordValidator {
    default boolean passwordCheck(String pass, int level) {
        // 레벨1 - 알파벳 소문자 1개 이상, 대문자 1개 이상
        if (level <= 1){
            if (!pass.matches("[a-z]+") || !pass.matches("[A-Z]+")) {
                return false;
            }
        }

        // 레벨2 - 숫자가 1개 이상 포함
        if (level <= 2 && !pass.matches("\\d+")) {
                return  false;
        }

        // 레벨3 -  특수문자가 1개 이상
        if (level > 2 && !pass.matches("[`~!@#^%&*()\\-_=+]+")){
            return false;
        }
        return true;
    }
}
