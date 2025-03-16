import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Main <chemin_du_fichier>");
            return;
        }

        String fileName = args[0];
        try {
            List<Mower> mowers = new ArrayList<>();
            List<String> instructionsList = new ArrayList<>();
            Field field = readInputFile(fileName, mowers, instructionsList);

            executeInstructions(mowers, instructionsList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Field readInputFile(String fileName, List<Mower> mowers, List<String> instructionsList) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            Field field = parseFieldDimensions(line);

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                Mower mower = parseMower(line, field);
                mowers.add(mower);

                String instructions = br.readLine();
                instructionsList.add(instructions);
            }

            return field;
        }
    }

    private static Field parseFieldDimensions(String line) {
        String[] fieldDimensions = line.split(" ");
        int maxX = Integer.parseInt(fieldDimensions[0]);
        int maxY = Integer.parseInt(fieldDimensions[1]);
        return new Field(maxX, maxY);
    }

    private static Mower parseMower(String line, Field field) {
        String[] positionParts = line.split(" ");
        int x = Integer.parseInt(positionParts[0]);
        int y = Integer.parseInt(positionParts[1]);
        Direction direction = Direction.valueOf(positionParts[2]);
        return new Mower(x, y, direction, field);
    }

    private static void executeInstructions(List<Mower> mowers, List<String> instructionsList) {
        for (int i = 0; i < mowers.size(); i++) {
            Mower mower = mowers.get(i);
            String instructions = instructionsList.get(i);
            for (char command : instructions.toCharArray()) {
                mower.execute(command);
            }
            System.out.println(mower);
        }
    }
}