import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Combinations {
    public static void main(String[] args) {
        try {
            int amountToChoose = Integer.parseInt(args[0]);
            List<String> set = new ArrayList<String>(Arrays.asList(args));
            set.remove(0);

            List<List<String>> combinations = getCombinations(set, amountToChoose);
            System.out.println(combinations.size());
            for (int i = 0 ; i < combinations.size() ; i++) {
                String singleCombinationString = combinations.get(i).stream().collect(Collectors.joining(","));
                System.out.println(singleCombinationString);
            }
        } catch (NumberFormatException e) {
            System.err.println("The first arg should be the quantity to choose from the set");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Provide a quantity to choose and at least one element for the set");
            e.printStackTrace();
        } catch (InsufficientElementsException e) {
            System.err.println("The quantity to choose should be between 1 and the size of the set");
            e.printStackTrace();
        }
    }

    public static List<List<String>> getCombinations(List<String> set, int amountToChoose) throws InsufficientElementsException {
        if (set.size() < amountToChoose || amountToChoose < 1) {
            throw new InsufficientElementsException();
        } else if (amountToChoose == 1) {
            return set.stream().map(element -> List.of(element)).toList();
        } else {
            List<List<String>> allCombinations = 
                new ArrayList<List<String>>(
                    getCombinations(
                        set.subList(1, set.size()), 
                        amountToChoose - 1)
                    .stream()
                    .map(list -> {
                            List<String> mutableList = new ArrayList<String>(list);
                            mutableList.add(0, set.get(0));
                            return mutableList;
                        })
                    .toList());
            if (set.size() > amountToChoose) {
                allCombinations.addAll(
                    getCombinations(
                        set.subList(1, set.size()), 
                        amountToChoose));
            }
            return allCombinations;
        }
    }
}

class InsufficientElementsException extends Exception {}