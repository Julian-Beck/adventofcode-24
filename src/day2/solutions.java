package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class solutions {
    private ArrayList<String> readInput() {
        ArrayList<String> ret = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./src/day2/input.txt"))) {
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

    private int[] convertToReport(String rawInput){
        String[] temp = rawInput.split(" ");
        int[] report = new int[temp.length];
        for (int c = 0; c < temp.length; c++) {
            report[c] = (Integer.parseInt(temp[c]));
        }
        return report;
    }

    private boolean checkForSafe(int[] report) {
        int last = report[0];
        boolean ascending = report[0] < report[1];
        for (int i = 1; i < report.length; i++){
            int curr = report[i];
            int dist = Math.abs(last - curr);
            if (dist != 1 && dist != 2 && dist != 3) { return false; }
            if (ascending && last > curr) { return false; }
            if (!ascending && last < curr) { return false; }
            last = curr;
        }
        return true;
    }

    public int solution1() {
        ArrayList<String> input = readInput();
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            int[] report = convertToReport(input.get(i));
            if (checkForSafe(report)) { sum++; }
        }
        return sum;
    }

    private boolean checkForSafe2(int[] report) {
        int last = report[0];
        boolean ascending = report[0] < report[1];
        boolean tolerate = false;
        for (int i = 1; i < report.length; i++){
            boolean res = true;
            int curr = report[i];
            int dist = Math.abs(last - curr);
            if (dist != 1 && dist != 2 && dist != 3) { res = false; }
            if (ascending && last > curr) { res = false; }
            if (!ascending && last < curr) { res = false; }
            if (!res && !tolerate) {
                res = true;
                tolerate = true;
            } else {
                last = curr;
            }
            if (!res) {
                int[] newReport = new int[report.length-1];
                for (int c = 0; c < newReport.length; c++) {
                    newReport[c] = report[c+1];
                }
                if (checkForSafe(newReport)) {
                    return !res;
                } else {
                    return res;
                }
            }
        }
        return true;
    }

    private boolean checkForSafe3(int[] report) {
        for (int indexToSkip = 0; indexToSkip < report.length; indexToSkip++) {
            int[] newReport = new int[report.length-1];
            boolean skipped = false;
            for (int indexForCopy = 0; indexForCopy < newReport.length; indexForCopy++){
                if (indexForCopy == indexToSkip) { skipped = true; }
                if (!skipped) { newReport[indexForCopy] = report[indexForCopy]; }
                else { newReport[indexForCopy] = report[indexForCopy+1];}
            }
            if (checkForSafe(newReport)) { return true; }
        }
        return false;
    }

    public int solution2() {
        ArrayList<String> input = readInput();
        int sum = 0;
        for (int i = 0; i < input.size(); i++) {
            int[] report = convertToReport(input.get(i));
            if (checkForSafe3(report)) { sum++; }
        }
        return sum;
    }
}
