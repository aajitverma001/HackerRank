
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cb-ajit
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _buildingBlocks_size = Integer.parseInt(in.nextLine());
        int[] _buildingBlocks = new int[_buildingBlocks_size];
        int _buildingBlocks_item;
        for (int _buildingBlocks_i = 0; _buildingBlocks_i < _buildingBlocks_size; _buildingBlocks_i++) {
            _buildingBlocks_item = Integer.parseInt(in.nextLine());
            _buildingBlocks[_buildingBlocks_i] = _buildingBlocks_item;
        }

        res = calcWaterStored(_buildingBlocks);
        System.out.println(res);

    }

    static int calcWaterStored(int[] buildingBlocks) {
        int ans = 0, startIdx = 0, startBuildLen = 0;
        startBuildLen = buildingBlocks[0];
        for (int i = 1; i < buildingBlocks.length; i++) {
            if (buildingBlocks[i] >= startBuildLen) {
                startBuildLen = buildingBlocks[i];
                startIdx = i;
                continue;
            }
            int indx = lookAnotherTallBuilding(buildingBlocks, startIdx, startBuildLen);
            if (indx == -1) {
                continue;
            }
            ans += getDiff(buildingBlocks, startIdx, indx);
            startIdx = indx;
            startBuildLen = buildingBlocks[startIdx];
            i = startIdx + 1;
        }
        return ans;
    }

    static int getDiff(int[] buildingBlocks, int startIdx, int endIdx) {
        int offset = buildingBlocks[startIdx];
        int diff = 0;
        if (buildingBlocks[endIdx] < offset) {
            offset = buildingBlocks[endIdx];
        }
        for (int i = startIdx; i <= endIdx; i++) {
            if (offset - buildingBlocks[i] > 0) {
                diff = offset - buildingBlocks[i];
            }
        }
        return diff;
    }

    private static int lookAnotherTallBuilding(int[] buildingBlocks, int startIdx, int startBuildLen) {
        if (startBuildLen == 0) {
            return -1;
        }
        for (int i = startIdx + 1; i < buildingBlocks.length; i++) {
            if (buildingBlocks[i] >= startBuildLen) {
                return i;
            }
        }
        return lookAnotherTallBuilding(buildingBlocks, startIdx, --startBuildLen);
    }

}
