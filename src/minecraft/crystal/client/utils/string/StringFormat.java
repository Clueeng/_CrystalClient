package crystal.client.utils.string;

public class StringFormat {

    // "armourStatus" to "Armour Status"
    public static String camelCaseToTitleCase(String input) {
        StringBuilder formattedString = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (i > 0 && Character.isUpperCase(currentChar)) {
                formattedString.append(' ');
            }

            formattedString.append(currentChar);
        }

        return formattedString.toString().replaceAll("([a-z])([A-Z])", "$1 $2");
    }


}
