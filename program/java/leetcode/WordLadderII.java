import java.util.*;

public class WordLadderII{
    public static List<List<String>> findLaddersAlt(String start, String end, Set<String> dict){
        dict.add(end);
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        HashMap<String, List<List<String>>> hm = new HashMap<String, List<List<String>>>();
        List<String> entry = new ArrayList<String>();
        entry.add(start);
        List<List<String>> value = new ArrayList<List<String>>();
        value.add(entry);
        hm.put(start, value);

        while(!q.isEmpty()){
            String cur = q.poll();
            if(cur.equals(end)) {
                Set<String> set = hm.keySet();
                for(String x : set) {
                    System.out.print(x + ", ");
                    List<List<String>> element = hm.get(x);
                    for(List<String> y : element) {
                        System.out.print("[");
                        for(String z : y) {
                            System.out.print(z +  " ");
                        }
                        System.out.print("] ");
                    }
                    System.out.println();
                }
                return hm.get(end);
            }
            char[] charStr = cur.toCharArray();
            for(int i = 0;i < charStr.length;i++){
                char origin = charStr[i];
                for(char j = 'a';j <= 'z';j++){
                    charStr[i] = j;
                    String newStr = new String(charStr);
                    if(dict.contains(newStr)){
                        if(!hm.containsKey(newStr)){
                            List<List<String>> newValue = new ArrayList<List<String>>(); 
                            List<List<String>> preValue = hm.get(cur);
                            for(List<String> x : preValue){
                                List<String> newEntry = new ArrayList<String>(x);
                                newEntry.add(newStr);
                                newValue.add(newEntry);
                            }
                            q.offer(newStr);
                            hm.put(newStr, newValue);
                        }
                        else{
                            List<List<String>> newValue = hm.get(newStr);
                            List<List<String>> preValue = hm.get(cur);
                            if(preValue.get(0).size() + 1 == hm.get(newStr).get(0).size()){
                                for(List<String> x : preValue){
                                    List<String> newEntry = new ArrayList<String>(x);
                                    newEntry.add(newStr);
                                    newValue.add(newEntry);
                                }
                                hm.put(newStr, newValue);
                            }
                        }
                    }
                }
                charStr[i] = origin;
            }
        }
        return new ArrayList<List<String>>();
    }
    public static List<List<String>> findLadders(String start, String end, Set<String> dict){ List<List<String>> output = new ArrayList<List<String>>();
        List<String> entry = new ArrayList<String>();
        entry.add(start);
        helper(start, end, dict, entry, output); return output;
    }
    public static void helper(
            String start, 
            String end,
            Set<String> dict,
            List<String> entry,
            List<List<String>> output
            ){
        for(int i = 0;i < start.length();i++){
            for(char k = 'a';k < 'z';k++){
                char[] currents = start.toCharArray();
                currents[i] = k;
                String tmp = new String(currents);
                if(tmp.equals(end)){
                    if(output.size() != 0 && entry.size() + 1 < output.get(0).size())
                        output.clear();
                    entry.add(end);
                    output.add(new ArrayList<String>(entry));
                    entry.remove(end);
                    return;
                }
                if(dict.contains(tmp)){
                    if(output.size() != 0 && entry.size() + 1 >= output.get(0).size())
                        return;
                    entry.add(tmp);
                    dict.remove(tmp);
                    helper(tmp, end, dict, entry, output);
                    entry.remove(tmp);
                    dict.add(tmp);
                }
            }
        }
    }
    public static void main(String[] args){
        String[] words = {"hot","dot","dog","lot","log","cog"};
		//String[] words = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
        Set<String> dict = new HashSet<String>();
        for(String x: words)
            dict.add(x);
        //List<List<String>> output = findLadders("cet", "ism", dict); 
        List<List<String>> output = findLaddersAlt("hit", "cig", dict); 
        System.out.println("---");
        for(List<String> x: output){
            for(String y: x)
                System.out.print(y + " ");
            System.out.println();
        }
    }
}
