package validators;

public interface MobileValidator {
    default boolean mobileCheck(String num) {
        /**
         * 1. 010, 011, 016, 000~0000, 0000
         * 2. 010-0000-0000, 010.0000.0000, 010_0000_0000, 01000000000 : 숫자가 아닌 문자는 제거, 숫자만 남기기
         *
         */
        num = num.replaceAll("\\D", "");
        String pattern = "^01[016]\\d{3,4}\\d{4}$";

        return num.matches(pattern);
    }
}
