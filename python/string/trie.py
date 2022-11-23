from collections import deque

class TrieNode(object):
    def __init__(self):
        self.children = {}
        self.is_end = False

class TrieTree(object):
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for c in word:
            if c not in node.children:
                node.children[c] = TrieNode()
            node = node.children[c]
        node.is_end = True

    def search(self, word):
        node = self.root
        for c in word:
            if c not in node.children:
                return False
            node = node.children[c]
        return node.is_end
    
    def startsWith(self, prefix):
        node = self.root
        for c in prefix:
            if c not in node.children:
                return False
            node = node.children[c]
        return True
    
    def isPartOf(self, word):
        q = deque()
        q.append(self.root)
        for c in word:
            if len(q)>0:
                size = len(q)
                for _ in range(size):
                    node = q.popleft()
                    if c in node.children:
                        if node.children[c].is_end:
                            return True
                        q.append(node.children[c])
            if c in self.root.children:
                q.append(self.root.children[c])
        return False


if __name__ == '__main__':
    tree = TrieTree()
    tree.insert("hello")
    tree.insert("world")
    tree.insert("hi")
    tree.insert("how")
    tree.insert("are")
    tree.insert("you")

    # Output: True
    print(tree.search("hello"))
    # Output: False
    print(tree.search("hell"))
    # Output: True
    print(tree.isPartOf("helloworld"))