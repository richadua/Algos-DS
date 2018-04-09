import java.util.*;
import java.io.*;

class Solution2 {
    public static void main(String[] cpdomains) throws IOException {
        Hashtable<String, Integer> subdomainTable = new Hashtable<String, Integer>();
        Hashtable<String, Integer> finalTable = new Hashtable<String, Integer>();
        Map<String, Integer> counts = new HashMap<String, Integer>();
        try {
            File f = new File("textFile.txt");
            Scanner sc = new Scanner(f);
            List<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }

            String[] arr = lines.toArray(new String[0]);
            
            for (String domain: arr) {
                String[] cpinfo = domain.split("\\s+");               
                String[] frags = cpinfo[1].split("\\.");                             
                int count = Integer.valueOf(cpinfo[0]);
                String cur = "";
                for (int i = frags.length - 1; i >= 0; i--) {
                    cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                    counts.put(cur, counts.getOrDefault(cur, 0) + count);
                }
        }

        List<String> ans = new ArrayList<String>();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        System.out.println(ans);
    } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Exception " + e + " occured");
        }
    }
}

