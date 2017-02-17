import java.util.*;

public class MostRepeatedWords {
    public static void main(String[] args) {
        MostRepeatedWords mrw = new MostRepeatedWords();
        String str = "a b b c c e e e e e d d d d g g g g g g g f f f f f f";
        String[] top = mrw.topKWords(str, 3);
        for(int i = 0;i < top.length;i++) {
            System.out.println(top[i]);
        }
    }
    public String[] topKWords(final String stream, final int k) {
    final class WordFreq implements Comparable<WordFreq> {
        String word;
        int freq;

        public WordFreq(final String w, final int c) {
            word = w;
            freq = c;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int compareTo(final WordFreq other) {
            return this.freq == other.freq ? 0 : this.freq > other.freq ? 1 : -1;
        }
    }
    final Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
    final MinHeap<WordFreq> topKHeap = new MinHeap<WordFreq>(k);

    final String[] words = stream.toLowerCase().trim().split(" ");
    for (final String word : words) {
        int freq = 1;
        if (frequencyMap.containsKey(word)) {
            freq = frequencyMap.get(word) + 1;
        }

        // update the frequency map
        frequencyMap.put(word, freq);
    }

    // Build the topK heap
    for (final java.util.Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
        if (topKHeap.size() < k) {
            topKHeap.insert(new WordFreq(entry.getKey(), entry.getValue()));
        } else if (entry.getValue() > topKHeap.top().freq) {
            topKHeap.extract();
            topKHeap.insert(new WordFreq(entry.getKey(), entry.getValue()));
        }
    }

    // extract the top K
    final String[] topK = new String[k];
    int i = 0;
    while (topKHeap.size() > 0) {
        topK[i++] = topKHeap.extract().word;
    }

    return topK;
}
}
