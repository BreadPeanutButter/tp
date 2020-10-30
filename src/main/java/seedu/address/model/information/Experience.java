package seedu.address.model.information;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's experience in years.
 * Guarantees: immutable; is valid as declared in {@link #isValidExperience(String)}
 */
public class Experience {

    public static final String MESSAGE_CONSTRAINTS = "Experience in years has to be an unsigned (non-negative) number "
            + "that is less than or equals to 100.";

    public final double experienceInYears;

    /**
     * Constructs an {@code Experience}.
     *
     * @param experience A string representing a valid number of years of experience.
     */
    public Experience(String experience) {
        requireNonNull(experience);
        checkArgument(isValidExperience(experience), MESSAGE_CONSTRAINTS);
        experienceInYears = Double.parseDouble(experience);
    }

    /**
     * Returns if a given String represents valid number of years of experience.
     */
    public static boolean isValidExperience(String test) {
        requireNonNull(test);
        double experience;
        test = test.strip();
        try {
            experience = Double.parseDouble(test);
        } catch (NumberFormatException exception) {
            return false;
        }
        return experience >= 0 && experience <= 100;
    }

    @Override
    public String toString() {
        return experienceInYears + "";
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Experience // instanceof handles nulls
                && experienceInYears == ((Experience) other).experienceInYears); // state check
    }

    @Override
    public int hashCode() {
        return Double.valueOf(experienceInYears).hashCode();
    }

}

