package codewars;

import com.google.common.collect.Lists;

import java.util.List;

class HumanReadableDuration {

    static String formatDuration(int seconds) {
        List<String> durations = Lists.newArrayList();
        StringBuilder result = new StringBuilder();

        int amountOfYears = seconds / 31536000;
        if (amountOfYears > 0) {
            durations.add(duration(amountOfYears, "year"));
        }

        int amountOfDays = (seconds -= (amountOfYears * 31536000)) / 86400;
        if (amountOfDays > 0) {
            durations.add(duration(amountOfDays, "day"));
        }

        int amountOfHours = (seconds -= (amountOfDays * 86400)) / 3600;
        if (amountOfHours > 0) {
            durations.add(duration(amountOfHours, "hour"));
        }

        int amountOfMinutes = (seconds -= (amountOfHours * 3600)) / 60;
        if (amountOfMinutes > 0) {
            durations.add(duration(amountOfMinutes, "minute"));
        }

        int amountOfSeconds = seconds - (amountOfMinutes * 60);
        if (amountOfSeconds > 0) {
            durations.add(duration(amountOfSeconds, "second"));
        }

        if (durations.isEmpty()) {
            return "now";
        }
        if (durations.size() == 1) {
            return durations.get(0);
        }
        for (int i = 0; i < durations.size() - 2; i++) {
            result.append(durations.get(i)).append(", ");
        }
        return result.append(durations.get(durations.size() - 2))
                .append(" and ")
                .append(durations.get(durations.size() - 1))
                .toString();
    }

    private static String duration(int amount, String unit) {
        boolean isPlural = (amount != 1);
        return String.format("%d %s%s", amount, unit, (isPlural ? "s" : ""));
    }

}
