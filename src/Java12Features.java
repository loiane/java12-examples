public class Java12Features {

    private enum DAY_OF_WEEK { MONDAY, TUESDAY, WEDNESDAY, THRUSDAY, FRIDAY, SATURDAY, SUNDAY};

    public static void main(String[] args) {
        newStringMethods();
        System.out.println(traditionalSwitch(DAY_OF_WEEK.MONDAY));
        System.out.println(newSwitchFeature1(DAY_OF_WEEK.SATURDAY));
        System.out.println(newSwitchFeature2(DAY_OF_WEEK.FRIDAY));
    }

    private static void newStringMethods() {
        String result = "Hello\nWorld!".indent(3);
        System.out.println(result);

        result = "Hello".transform(s -> s + ", World!");
        System.out.println(result); // Hello, World!

        result = "hello"
                .transform(s -> s + ", world!")
                .transform(String::toUpperCase);
        System.out.println(result); // HELLO, WORLD!
    }

    private static String traditionalSwitch(DAY_OF_WEEK dayOfWeek) {
        String result;
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THRUSDAY:
            case FRIDAY:
                result = "Weekday";
                break;
            case SATURDAY:
            case SUNDAY:
                result = "Weekend";
                break;
            default:
                result = "Invalid day!";
        }
        return result;
    }

    private static String newSwitchFeature1(DAY_OF_WEEK dayOfWeek) {
        String result;
        switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THRUSDAY, FRIDAY -> result = "Weekday";
            case SATURDAY, SUNDAY -> result = "Weekend";
            default -> { result = "Invalid day!"; }
        }
        return result;
    }

    private static String newSwitchFeature2(DAY_OF_WEEK dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THRUSDAY, FRIDAY -> "Weekday";
            case SATURDAY, SUNDAY -> "Weekend";
        };
    }
}
