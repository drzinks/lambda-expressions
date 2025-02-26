package com.drzinks.recruitment_tasks;

import java.util.ArrayList;
import java.util.List;

public class RecruitTimestamps {

    static final List<CpuUsage> input = List.of( new CpuUsage(5,85),
            new CpuUsage(5,85),
            new CpuUsage(20,93),
            new CpuUsage(25,90),
            new CpuUsage(37,95),
            new CpuUsage(39,85),
            new CpuUsage(50,90),
            new CpuUsage(65,95),
            new CpuUsage(77,83),
            new CpuUsage(95,80),
            new CpuUsage(120,77)
            );
    record CpuUsage(Integer timestamp, Integer value) {}

    public static void main(String[] args) {

    }

    public static List<CpuUsage> getWarningTimestamps(List<CpuUsage> input, int threshold, int period){
        List<CpuUsage> result = new ArrayList<>();
        List<CpuUsage> tempBuffer = new ArrayList<>();

        for (CpuUsage record : input) {
            if (record.value >= threshold) {
                tempBuffer.add(record);
            } else {
                if (!tempBuffer.isEmpty() && (tempBuffer.get(tempBuffer.size() - 1).timestamp - tempBuffer.get(0).timestamp) > period) {
                    result.addAll(tempBuffer);
                }
                tempBuffer.clear();
            }
        }

        // Check last segment
        if (!tempBuffer.isEmpty() && (tempBuffer.get(tempBuffer.size() - 1).timestamp - tempBuffer.get(0).timestamp) > period) {
            result.addAll(tempBuffer);
        }

        return result;
    }

}
