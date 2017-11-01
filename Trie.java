package trie;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class implements a Trie. 
 * 
 * @author Sesh Venugopal
 *
 */
public class Trie {
	private static TrieNode root; 
    ArrayList<String> words;
	
	// prevent instantiation
    
	private Trie() {
        root = new TrieNode(null, null, null);
        words = new ArrayList<String>();
	}
	
    public void insertWord(String word) {
        words.add(word);

        TrieNode node = new TrieNode(new Indexes(words.size() - 1, (short) 0, (short) (word.length()-1)), null, null);
        if (root.firstChild == null) {
            root.firstChild = node;
        }

        String prefix = findlargestPrefix(root, word);
        TrieNode last = findNode(root.firstChild, word, prefix);

        if (last == null)
        	return;

        if (!prefix.isEmpty()) {
            short len = (short) prefix.length();
            TrieNode child = new TrieNode(new Indexes(last.substr.wordIndex, len, last.substr.endIndex), last.firstChild, node);
            TrieNode parent = findNode(root.firstChild, word, findSmallestPrefix(root, word));

            node.substr.startIndex = last.substr.endIndex = len;
            last.substr.startIndex = parent != last ? parent.substr.endIndex : 0;

            if (child.substr.startIndex == child.substr.endIndex) {
                node.sibling = last.firstChild;
                last.firstChild = node;
            } else
                last.firstChild = child;
        }

        last.sibling = node;
    }
    
    
    private TrieNode findNode(TrieNode root, String word, String prefix) {
        if (root == null)
            return null;
        TrieNode recurse = findNode(root.sibling, word, prefix);
        if (recurse != null)
            return recurse;
        if (prefix.isEmpty())
            return root;
        recurse = findNode(root.firstChild, word, prefix);
        if (recurse != null)
            return recurse;
        String rootPrefix = findPrefix(findTrieWord(root), word);

        if (rootPrefix.equals(prefix))
            return root;
        if (!rootPrefix.isEmpty() && prefix.startsWith(rootPrefix)) {
            String sub = prefix.substring(rootPrefix.length());
            return findNode(root.firstChild, sub, sub);
        }
        return null;
    }
    
    private String findPrefix(TrieNode root, String word, final boolean largest) {
        ArrayList<String> prefixes = new ArrayList<String>(words.size());
        if (root == null)
            return "";
        for (TrieNode ptr = root.firstChild; ptr != null; ptr = ptr.sibling) {
            String recurse = findPrefix(ptr, word, largest);
            if (recurse.isEmpty())
                continue;
            prefixes.add(recurse);
        }
      if (!prefixes.isEmpty()){
         return prefixes.stream().sorted(( a,  b) -> (largest ? b.length() - a.length() : a.length() - b.length())).findFirst().get();
      }
      return findPrefix(findLiteralWord(root), word);
    }

    private String findPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int index = 0; index < len; index++) {
            if (a.charAt(index) != b.charAt(index))
                return a.substring(0, index);
        }
        return a.substring(0, len);
    }

    private String findlargestPrefix(TrieNode root, String word) {
        return findPrefix(root, word, true);
    }

    private String findSmallestPrefix(TrieNode root, String word) {
        return findPrefix(root, word, false);
    }

    private String findWord(TrieNode root, boolean sub) {
        if (root.substr == null)
            return "3ROOTWORD";
        String word = words.get(root.substr.wordIndex);
        return sub ? word.substring(root.substr.startIndex, root.substr.endIndex) : word;
    }

    private String findTrieWord(TrieNode root) {
        return findWord(root, true);
    }

    private String findLiteralWord(TrieNode root) {
        return findWord(root, false);
    }

    private boolean isPrefixNode(TrieNode root) {
        return root.firstChild != null;
    }



	
	/**
	 * Builds a trie by inserting all words in the input array, one at a time,
	 * in sequence FROM FIRST TO LAST. (The sequence is IMPORTANT!)
	 * The words in the input array are all lower case.
	 * 
	 * @param allWords Input array of words (lowercase) to be inserted.
	 * @return Root of trie with all words inserted from the input array
	 */
	public static TrieNode buildTrie(String[] allWords) {
		/** COMPLETE THIS METHOD **/
		Trie t =new Trie();
		for(int i=0;i<allWords.length-1;i++)
			t.insertWord(allWords[i]);
		return root;
		
		// FOLLOWING LINE IS A PLACEHOLDER TO ENSURE COMPILATION
		// MODIFY IT AS NEEDED FOR YOUR IMPLEMENTATION
	}
	
	/**
	 * Given a trie, returns the "completion list" for a prefix, i.e. all the leaf nodes in the 
	 * trie whose words start with this prefix. 
	 * For instance, if the trie had the words "bear", "bull", "stock", and "bell",
	 * the completion list for prefix "b" would be the leaf nodes that hold "bear", "bull", and "bell"; 
	 * for prefix "be", the completion would be the leaf nodes that hold "bear" and "bell", 
	 * and for prefix "bell", completion would be the leaf node that holds "bell". 
	 * (The last example shows that an input prefix can be an entire word.) 
	 * The order of returned leaf nodes DOES NOT MATTER. So, for prefix "be",
	 * the returned list of leaf nodes can be either hold [bear,bell] or [bell,bear].
	 *
	 * @param root Root of Trie that stores all words to search on for completion lists
	 * @param allWords Array of words that have been inserted into the trie
	 * @param prefix Prefix to be completed with words in trie
	 * @return List of all leaf nodes in trie that hold words that start with the prefix, 
	 * 			order of leaf nodes does not matter.
	 *         If there is no word in the tree that has this prefix, null is returned.
	 */
	public static ArrayList<TrieNode> completionList(TrieNode root,
										String[] allWords, String prefix) {
		/** COMPLETE THIS METHOD **/
		
		// FOLLOWING LINE IS A PLACEHOLDER TO ENSURE COMPILATION
		// MODIFY IT AS NEEDED FOR YOUR IMPLEMENTATION
		for(int i=0;i<allWords.length;i++){
			
		}
		return null;
	}
	 public ArrayList<String> completionList(String prefix) {
	        TrieNode node = null;
	        for (int index = 1; index <= prefix.length(); index++) {
	            node = findNode(root, prefix, prefix.substring(0, index));
	            if (node != null)
	                return completionList(node, prefix);
	        }
	        return null;
	    }

	    private ArrayList<String> completionList(TrieNode root, String prefix) {
	        ArrayList<String> common = new ArrayList<String>();
	        if (root == null)
	            return null;

	        ArrayList<String> recursive = completionList(root.sibling, prefix);
	        if (recursive != null)
	            common.addAll(recursive);

	        recursive = completionList(root.firstChild, prefix);
	        if (recursive != null)
	            common.addAll(recursive);

	        if (isPrefixNode(root))
	            return common;

	        String rootWord = findLiteralWord(root);
	        if (rootWord.startsWith(prefix))
	            common.add(rootWord);

	        if (common.isEmpty())
	            return null;
	        return common;
	    }
	
	public static void print(TrieNode root, String[] allWords) {
		System.out.println("\nTRIE\n");
		print(root, 1, allWords);
	}
	
	private static void print(TrieNode root, int indent, String[] words) {
		if (root == null) {
			return;
		}
		for (int i=0; i < indent-1; i++) {
			System.out.print("    ");
		}
		
		if (root.substr != null) {
			String pre = words[root.substr.wordIndex]
							.substring(0, root.substr.endIndex+1);
			System.out.println("      " + pre);
		}
		
		for (int i=0; i < indent-1; i++) {
			System.out.print("    ");
		}
		System.out.print(" ---");
		if (root.substr == null) {
			System.out.println("root");
		} else {
			System.out.println(root.substr);
		}
		
		for (TrieNode ptr=root.firstChild; ptr != null; ptr=ptr.sibling) {
			for (int i=0; i < indent-1; i++) {
				System.out.print("    ");
			}
			System.out.println("     |");
			print(ptr, indent+1, words);
		}
	}
 }
************************************************************
package trie;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class implements a Trie. 
 * 
 * @author Sesh Venugopal
 *
 */
public class Trie {
	private static TrieNode root; 
    static ArrayList<String> words;
	
	// prevent instantiation
    
	private Trie() {
        root = new TrieNode(null, null, null);
        words = new ArrayList<String>();
	}
	
    public void insertWord(String word) {
        words.add(word);

        TrieNode node = new TrieNode(new Indexes(words.size() - 1, (short) 0, (short) (word.length()-1)), null, null);
        if (root.firstChild == null) {
            root.firstChild = node;
        }
        
        
        String prefix = findlargestPrefix(root, word);
        TrieNode last = findNode(root.firstChild, word, prefix);

        if (last == null)
        	return;
        
        if (!prefix.isEmpty()) {
            short len = (short) (prefix.length());
            TrieNode child = new TrieNode(new Indexes(last.substr.wordIndex, (short)(len-1), (short)(last.substr.endIndex)), last.firstChild, node);
            TrieNode parent = findNode(root.firstChild, word, findSmallestPrefix(root, word));

            node.substr.startIndex = last.substr.endIndex = (short) (len);
            
            last.substr.startIndex = parent != last ? (short)(parent.substr.endIndex) : 0;

            if (child.substr.startIndex == child.substr.endIndex) {
                node.sibling = last.firstChild;
                last.firstChild = node;
            } else
                last.firstChild = child;
            return;
        }

       last.sibling = node;
    }
    
    
    private static TrieNode findNode(TrieNode root, String word, String prefix) {
        if (root == null)
            return null;
        TrieNode recurse = findNode(root.sibling, word, prefix);
        if (recurse != null)
            return recurse;
        if (prefix.isEmpty())
            return root;
        recurse = findNode(root.firstChild, word, prefix);
        if (recurse != null)
            return recurse;
        String rootPrefix = findPrefix(findTrieWord(root), word);

        if (rootPrefix.equals(prefix))
            return root;
        if (!rootPrefix.isEmpty() && prefix.startsWith(rootPrefix)) {
            String sub = prefix.substring(rootPrefix.length());
            return findNode(root.firstChild, sub, sub);
        }
        return null;
    }
    
    private String findPrefix(TrieNode root, String word, final boolean largest) {
        ArrayList<String> prefixes = new ArrayList<String>(words.size());
        if (root == null)
            return "";
        for (TrieNode ptr = root.firstChild; ptr != null; ptr = ptr.sibling) {
            String recurse = findPrefix(ptr, word, largest);
            if (recurse.isEmpty())
                continue;
            prefixes.add(recurse);
        }
      if (!prefixes.isEmpty()){
         return prefixes.stream().sorted(( a,  b) -> (largest ? b.length() - a.length() : a.length() - b.length())).findFirst().get();
      }
      return findPrefix(findLiteralWord(root), word);
    }

    private static String findPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int index = 0; index < len; index++) {
            if (a.charAt(index) != b.charAt(index))
                return a.substring(0, index);
        }
        return a.substring(0, len);
    }

    private String findlargestPrefix(TrieNode root, String word) {
        return findPrefix(root, word, true);
    }

    private String findSmallestPrefix(TrieNode root, String word) {
        return findPrefix(root, word, false);
    }

    private static String findWord(TrieNode root, boolean sub) {
        if (root.substr == null)
            return "3ROOTWORD";
        String word = words.get(root.substr.wordIndex);
        return sub ? word.substring(root.substr.startIndex, root.substr.endIndex) : word;
    }

    private static String findTrieWord(TrieNode root) {
        return findWord(root, true);
    }

    private String findLiteralWord(TrieNode root) {
        return findWord(root, false);
    }

    private boolean isPrefixNode(TrieNode root) {
        return root.firstChild != null;
    }



	
	/**
	 * Builds a trie by inserting all words in the input array, one at a time,
	 * in sequence FROM FIRST TO LAST. (The sequence is IMPORTANT!)
	 * The words in the input array are all lower case.
	 * 
	 * @param allWords Input array of words (lowercase) to be inserted.
	 * @return Root of trie with all words inserted from the input array
	 */
	public static TrieNode buildTrie(String[] allWords) {
		/** COMPLETE THIS METHOD **/
		Trie t =new Trie();
		for(int i=0;i<allWords.length;i++)
			t.insertWord(allWords[i]);
		return root;
		
		// FOLLOWING LINE IS A PLACEHOLDER TO ENSURE COMPILATION
		// MODIFY IT AS NEEDED FOR YOUR IMPLEMENTATION
	}
	
	/**
	 * Given a trie, returns the "completion list" for a prefix, i.e. all the leaf nodes in the 
	 * trie whose words start with this prefix. 
	 * For instance, if the trie had the words "bear", "bull", "stock", and "bell",
	 * the completion list for prefix "b" would be the leaf nodes that hold "bear", "bull", and "bell"; 
	 * for prefix "be", the completion would be the leaf nodes that hold "bear" and "bell", 
	 * and for prefix "bell", completion would be the leaf node that holds "bell". 
	 * (The last example shows that an input prefix can be an entire word.) 
	 * The order of returned leaf nodes DOES NOT MATTER. So, for prefix "be",
	 * the returned list of leaf nodes can be either hold [bear,bell] or [bell,bear].
	 *
	 * @param root Root of Trie that stores all words to search on for completion lists
	 * @param allWords Array of words that have been inserted into the trie
	 * @param prefix Prefix to be completed with words in trie
	 * @return List of all leaf nodes in trie that hold words that start with the prefix, 
	 * 			order of leaf nodes does not matter.
	 *         If there is no word in the tree that has this prefix, null is returned.
	 */
	public static ArrayList<TrieNode> completionList(TrieNode root,
										String[] allWords, String prefix) {
		ArrayList<TrieNode> leafNodes=new ArrayList<TrieNode>();
		/** COMPLETE THIS METHOD **/
		
		// FOLLOWING LINE IS A PLACEHOLDER TO ENSURE COMPILATION
		// MODIFY IT AS NEEDED FOR YOUR IMPLEMENTATION
		for(int i=0;i<allWords.length;i++){
			leafNodes.add(findNode(root, allWords[i], prefix));
			
		}
		return leafNodes;
	}
	 public ArrayList<String> completionList(String prefix) {
	        TrieNode node = null;
	        for (int index = 1; index <= prefix.length(); index++) {
	            node = findNode(root, prefix, prefix.substring(0, index));
	            if (node != null)
	                return completionList(node, prefix);
	        }
	        return null;
	    }

	    private ArrayList<String> completionList(TrieNode root, String prefix) {
	        ArrayList<String> common = new ArrayList<String>();
	        if (root == null)
	            return null;

	        ArrayList<String> recursive = completionList(root.sibling, prefix);
	        if (recursive != null)
	            common.addAll(recursive);

	        recursive = completionList(root.firstChild, prefix);
	        if (recursive != null)
	            common.addAll(recursive);

	        if (isPrefixNode(root))
	            return common;

	        String rootWord = findLiteralWord(root);
	        if (rootWord.startsWith(prefix))
	            common.add(rootWord);

	        if (common.isEmpty())
	            return null;
	        return common;
	    }
	
	public static void print(TrieNode root, String[] allWords) {
		System.out.println("\nTRIE\n");
		print(root, 1, allWords);
	}
	
	private static void print(TrieNode root, int indent, String[] words) {
		if (root == null) {
			return;
		}
		for (int i=0; i < indent-1; i++) {
			System.out.print("    ");
		}
		
		if (root.substr != null) {
			String pre = words[root.substr.wordIndex]
							.substring(0, root.substr.endIndex+1);
			System.out.println("      " + pre);
		}
		
		for (int i=0; i < indent-1; i++) {
			System.out.print("    ");
		}
		System.out.print(" ---");
		if (root.substr == null) {
			System.out.println("root");
		} else {
			System.out.println(root.substr);
		}
		
		for (TrieNode ptr=root.firstChild; ptr != null; ptr=ptr.sibling) {
			for (int i=0; i < indent-1; i++) {
				System.out.print("    ");
			}
			System.out.println("     |");
			print(ptr, indent+1, words);
		}
	}
 }
