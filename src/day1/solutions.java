package day1;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class solutions {
    private ArrayList<String> readInput() {
        ArrayList<String> ret = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/day1/input.txt.txt"))) {
            String line = br.readLine();
            while (line != null) {
                ret.add(line);
                line = br.readLine();
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<String>();
    }

    private int lowest(ArrayList<Integer> list){
        int lowest = list.getFirst();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < lowest) {
                lowest = list.get(i);
            }
        }
        return lowest;
    }

    public int solution1() {
        ArrayList<String> input = readInput();
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        for (String line : input) {
            String[] split = line.split("   ");
            first.add(Integer.parseInt(split[0]));
            second.add(Integer.parseInt(split[1]));
        }

        int limit = first.size();
        int sum = 0;
        for (int i = 0; i < limit; i++) {
            int firstLow = lowest(first);
            int secondLow = lowest(second);

            sum+= Math.abs(firstLow - secondLow);

            first.remove(first.indexOf(firstLow));
            second.remove(second.indexOf(secondLow));
        }
        return sum;
    }

    private int count_occ(int num, ArrayList<Integer> list){
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == num) {
                count++;
            }
        }
        return count;
    }

    public int solution2() {
        ArrayList<String> input = readInput();
        ArrayList<Integer> first = new ArrayList<Integer>();
        ArrayList<Integer> second = new ArrayList<Integer>();
        for (String line : input) {
            String[] split = line.split("   ");
            first.add(Integer.parseInt(split[0]));
            second.add(Integer.parseInt(split[1]));
        }

        int limit = first.size();
        int sum = 0;
        for (int i = 0; i < first.size(); i++) {
            int num = first.get(i);
            int count = count_occ(num, second);
            sum+= count * num;
        }
        return sum;
    }
}
