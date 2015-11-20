import java.util.Arrays;

/**
 * Created by oleg on 11/18/15.
 */
public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD:afanasiev-oleg/theme-1.04/text-formatting-3.21/src/Main.java
        int width = 60;
=======
        int width = 90;
>>>>>>> edd338aed7b5192e9c1231a6d4fdf44e8162e248:afanasiev-oleg/module-1.04/text-formatting-3.21/src/Main.java
        String text =
                "The cheetah (Acinonyx jubatus) is a big cat in the subfamily Felinae that inhabits most of Africa and parts of Iran. " +
                        " It is the only extant member of the genus Acinonyx. The cheetah can run as fast as 109.4 to 120.7 km/h (68.0 to 75.0 mph), " +
                        "faster than any other land animal.[3][4][5][6][7][8] " +
                        "It covers distances up to 500 m (1,640 ft) in short bursts, and can " +
                        " accelerate from 0 to 96 km/h (0 to 60 mph) in three seconds.[9]\n" +
                        "\n" +
                        "The cheetah's closest extant relatives are the puma and jaguarundi of the Americas. " +
                        "Cheetahs are notable for adaptations in the paws as they are one of the few felids with only " +
                        "semi-retractable claws.[10]\n" +
                        "\n" +
                        "Their main hunting strategy is to trip swift prey such as various antelope species and hares with " +
                        "its dewclaw. Almost every facet of the cheetah's anatomy has evolved to maximise its success in the " +
                        "chase, the result of an evolutionary arms race with its prey. Due to this specialisation, however, " +
                        "the cheetah is poorly equipped to defend itself against other large predators, with speed being its main means of defence.";
        printFormattingText(text, width);
    }

    private static void printFormattingText(String text, int width) {
        String[] sectiones = text.split("\n");

        for (int i = 0; i < sectiones.length; i++) {
            printSection(sectiones[i], width);
        }
    }

    private static void printSection(String section, int width) {
        StringBuilder lineStr = new StringBuilder();
        String[] words = section.split(" ");
        int lineLength = 0;

        for (int i = 0; i < words.length; i++) {
            if (lineLength + words[i].length() <= width) {
                lineStr.append(words[i] + " ");
                lineLength += words[i].length() + 1;
            }
            else {
                System.out.println(justify(lineStr.toString(), width));
                lineStr.setLength(0);
                lineStr.append(words[i] + " ");
                lineLength = words[i].length() + 1;
            }
        } // for

        System.out.println(lineStr);
    }

    private static StringBuilder justifyOld(StringBuilder line, int width) {
        int needAddSpaces = width - line.toString().trim().length();

        if (needAddSpaces == 0)
            return line;

        String[] words = line.toString().trim().split(" ");
        if (words.length < 2)
            return line;

        line.setLength(0);

        for (int i = 0; i < words.length; i++) {
            line.append(words[i] + " ");

            if (needAddSpaces > 0) {
                line.append(" ");
                needAddSpaces--;
            }
        }

        return justifyOld(line, width);
    }

    private static String justify(String line, int width) {
        int nInseredSpaces = width - line.trim().length();

        if (nInseredSpaces == 0)
            return line;

        String[] words = line.toString().trim().split(" ");
        if (words.length < 2)
            return line;

        StringBuilder lineSB = new StringBuilder(line);
        int nGroupSpaces = nInseredSpaces / (words.length - 1);
        int nRemainSpaces = nInseredSpaces % (words.length - 1);
        char[] groupSpaces = new char[nGroupSpaces];

        Arrays.fill(groupSpaces, ' ');
        lineSB.setLength(0);

        for (int i = 0; i < words.length; i++) {
            lineSB.append(words[i] + " ");

            lineSB.append(groupSpaces);

            if (nRemainSpaces > 0) {
                lineSB.append(" ");
                nRemainSpaces--;
            }
        }

        return lineSB.toString();
    }

    private static StringBuilder justifyOptim(StringBuilder line, int width) {
        int needAddSpaces = width - line.toString().trim().length();

        if (needAddSpaces == 0)
            return line;

        String[] words = line.toString().trim().split(" ");
        if (words.length < 2)
            return line;

        line.setLength(0);

        for (int i = 0; i < words.length; i++) {
            line.append(words[i] + " ");

            if (needAddSpaces > 0) {
                line.append(" ");
                needAddSpaces--;
            }
        }

        return line;
    }
}
