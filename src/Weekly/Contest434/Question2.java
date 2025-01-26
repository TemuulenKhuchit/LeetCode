package Weekly.Contest434;

import java.util.*;

public class Question2 {

    public static void main(String[] args) {
        List<List<String>> events = new ArrayList<>();
        events.add(new ArrayList<>(List.of("MESSAGE", "10", "id1 id0")));
        events.add(new ArrayList<>(List.of("OFFLINE", "11", "0")));
        events.add(new ArrayList<>(List.of("MESSAGE", "71", "HERE")));
        System.out.println(Arrays.toString(countMentions(2, events)));
    }

    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];
        Map<Integer, Integer> offlineTimers = new HashMap<>();
        events.sort((a, b) -> {
            String a_eventType = a.get(0);
            String b_eventType = b.get(0);
            int a_timestamp = Integer.parseInt(a.get(1));
            int b_timestamp = Integer.parseInt(b.get(1));
            if (a_timestamp != b_timestamp)
                return a_timestamp - b_timestamp;
            if (a_eventType.equals(b_eventType))
                return 0;
            return a_eventType.equals("OFFLINE") ? -1 : 1;
        });
        for (List<String> event : events) {
            String eventType = event.get(0);
            int currTime = Integer.parseInt(event.get(1));

            if (eventType.equals("OFFLINE")) {
                int offUser = Integer.parseInt(event.get(2));
                offlineUntil[offUser] = currTime + 59;
            }
            else {
                String mentionType = event.get(2);
                if (mentionType.equals("ALL"))
                    for (int i = 0; i < numberOfUsers; i++)
                        mentions[i]++;
                else if (mentionType.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (currTime > offlineUntil[i]) {
                            mentions[i]++;
                        }
                    }
                }
                else {
                    String[] parts = mentionType.split(" ");
                    int[] mentioned = new int[parts.length];
                    for (int i = 0; i < parts.length; i++) {
                        mentioned[i] = Integer.parseInt(parts[i].replace("id", ""));
                        mentions[mentioned[i]]++;
                    }
                }
            }
        }
        return mentions;
    }
}
